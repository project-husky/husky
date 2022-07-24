/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.ch.cda.digesters;

import org.apache.commons.lang3.ObjectUtils;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.common.hl7cdar2.*;
import org.husky.common.utils.OptionalUtils;
import org.husky.emed.ch.cda.services.EmedEntryDigestService;
import org.husky.emed.ch.cda.utils.CdaR2Utils;
import org.husky.emed.ch.cda.utils.IiUtils;
import org.husky.emed.ch.cda.utils.IvlTsUtils;
import org.husky.emed.ch.cda.utils.TemplateIds;
import org.husky.emed.ch.cda.utils.readers.AuthorReader;
import org.husky.emed.ch.cda.utils.readers.SubAdmEntryReader;
import org.husky.emed.ch.errors.InvalidEmedContentException;
import org.husky.emed.ch.models.common.AuthorDigest;
import org.husky.emed.ch.models.common.EmedReference;
import org.husky.emed.ch.models.common.RenewalInterval;
import org.husky.emed.ch.models.entry.EmedEntryDigest;
import org.husky.emed.ch.models.entry.EmedPreEntryDigest;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.TemporalAmount;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

/**
 * Creator of CDA-CH-EMED PRE item entry digests.
 *
 * @author Quentin Ligier
 */
@Component
public class CcePreEntryDigester {

    /**
     * The registry of {@link EmedEntryDigest}.
     */
    protected final EmedEntryDigestService emedEntryService;

    /**
     * Constructor.
     *
     * @param emedEntryService The registry of {@link EmedEntryDigest}.
     */
    public CcePreEntryDigester(final EmedEntryDigestService emedEntryService) {
        this.emedEntryService = Objects.requireNonNull(emedEntryService);
    }

    /**
     * Creates a new {@link EmedPreEntryDigest} from a PRE SubstanceAdministration element.
     *
     * @param substanceAdministration           The PRE SubstanceAdministration element.
     * @param documentId                        The PRE document ID (PRE or PADV).
     * @param prescriptionTime                  The prescription time.
     * @param prescriptionDocumentValidityStart The prescription validity start time (inclusive).
     * @param prescriptionDocumentValidityStop  The prescription validity stop time (inclusive) or {@code null}.
     * @param parentDocumentAuthor              The parent document author (not the original document author).
     * @param parentSectionAuthor               The parent section author (not the original section author).
     * @return a digest of the element.
     */
    public EmedPreEntryDigest createDigest(final POCDMT000040SubstanceAdministration substanceAdministration,
                                           final UUID documentId,
                                           final Instant prescriptionTime,
                                           final Instant prescriptionDocumentValidityStart,
                                           @Nullable final Instant prescriptionDocumentValidityStop,
                                           final AuthorDigest parentDocumentAuthor,
                                           final AuthorDigest parentSectionAuthor) throws InvalidEmedContentException {
        if (!TemplateIds.hasAllIds(TemplateIds.PRE_ENTRY, substanceAdministration.getTemplateId())) {
            throw new InvalidEmedContentException("The given substance administration is not a PRE item entry");
        }
        final var preEntry = new SubAdmEntryReader(substanceAdministration);

        final EmedEntryDigest targetedMtp = this.getTargetedEntryDigest(substanceAdministration).orElse(null);

        final int sequence;
        final UUID medicationTreatmentId;
        if (targetedMtp != null) {
            sequence = (int) this.emedEntryService.getSequence(targetedMtp.getMedicationTreatmentId(),
                    prescriptionTime);
            medicationTreatmentId = targetedMtp.getMedicationTreatmentId();
        } else {
            sequence = 0;
            medicationTreatmentId = IiUtils.getUuid(preEntry.getEntryId());
        }

        final AuthorDigest documentAuthor;
        final AuthorDigest sectionAuthor;
        if (substanceAdministration.getAuthor().size() == 2) {
            sectionAuthor = new AuthorReader(substanceAdministration.getAuthor().get(0)).toDigest();
            documentAuthor = new AuthorReader(substanceAdministration.getAuthor().get(1)).toDigest();
        } else if (substanceAdministration.getAuthor().size() == 1) {
            sectionAuthor = new AuthorReader(substanceAdministration.getAuthor().get(0)).toDigest();
            documentAuthor = sectionAuthor;
        } else {
            documentAuthor = parentDocumentAuthor;
            sectionAuthor = parentSectionAuthor;
        }

        final Instant itemValidityStart = ObjectUtils.firstNonNull(
                preEntry.getEffectiveStartTime().orElse(null),
                prescriptionTime
        );

        return new EmedPreEntryDigest(
                prescriptionTime,
                documentId,
                documentAuthor,
                sectionAuthor,
                IiUtils.getUuid(preEntry.getEntryId()),
                medicationTreatmentId,
                sequence,
                preEntry.getAnnotationComment().orElse(null),
                preEntry.getDosageInstructions(),
                preEntry.getManufacturedMaterialReader().toMedicationProduct(),
                preEntry.getRepeatNumber().orElse(null),
                preEntry.getRouteOfAdministration().orElse(null),
                prescriptionDocumentValidityStart,
                prescriptionDocumentValidityStop,
                itemValidityStart,
                preEntry.getEffectiveStopTime().orElse(null),
                this.getRenewalInterval(substanceAdministration).orElse(null),
                this.getTargetedMtpReference(substanceAdministration).orElse(null),
                this.isProvisional(substanceAdministration),
                preEntry.isSubstitutionPermitted(),
                preEntry.getTreatmentReason().orElse(null),
                preEntry.getPatientMedicationInstructions().orElse(null),
                preEntry.getFulfillmentInstructions().orElse(null),
                preEntry.isInReserve(),
                preEntry.getQuantityToDispense().orElse(null)
        );
    }

    /**
     * Returns the targeted MTP item entry digest if the reference and the item exist.
     *
     * @param substanceAdministration The PRE item SubstanceAdministration.
     * @return an {@link Optional} that may contain the referenced MTP item entry digest.
     */
    private Optional<EmedEntryDigest> getTargetedEntryDigest(final POCDMT000040SubstanceAdministration substanceAdministration) throws InvalidEmedContentException {
        return this.getTargetedMtpReference(substanceAdministration)
                .map(EmedReference::getDocumentId)
                .flatMap(this.emedEntryService::getByDocument);
    }

    /**
     * Returns the reference to the targeted MTP document.
     *
     * @param substanceAdministration The PRE item SubstanceAdministration.
     * @return an {@link Optional} that may contain the reference to the targeted MTP document.
     */
    Optional<EmedReference> getTargetedMtpReference(final POCDMT000040SubstanceAdministration substanceAdministration) throws InvalidEmedContentException {
        return substanceAdministration.getEntryRelationship().stream()
                .filter(entryRelationship -> entryRelationship.getTypeCode() == XActRelationshipEntryRelationship.REFR)
                .findAny()
                .map(POCDMT000040EntryRelationship::getSubstanceAdministration)
                .map(CdaR2Utils::toEmedReference);
    }

    /**
     * Returns whether the PRE entry is provisional or not. It's provisional if it contains a single validation step, as
     * per IHE Pharm PRE 6.3.4.16.
     *
     * @param substanceAdministration The PRE item SubstanceAdministration.
     */
    boolean isProvisional(final POCDMT000040SubstanceAdministration substanceAdministration) {
        return substanceAdministration.getEntryRelationship().stream()
                .filter(entryRelationship -> entryRelationship.getTypeCode() == XActRelationshipEntryRelationship.REFR)
                .map(POCDMT000040EntryRelationship::getSubstanceAdministration)
                .filter(Objects::nonNull)
                .filter(sa -> sa.getMoodCode() == XDocumentSubstanceMood.PRP)
                .filter(sa -> sa.getClassCode().contains("SBADM"))
                .anyMatch(sa -> TemplateIds.isInList(TemplateIds.VALIDATION_STEP, sa.getTemplateId()));
    }

    /**
     * Returns the renewal period.
     *
     * @param substanceAdministration The PRE item SubstanceAdministration.
     * @return an {@link Optional} that may contain the renewal period.
     */
    Optional<RenewalInterval> getRenewalInterval(final POCDMT000040SubstanceAdministration substanceAdministration) {
        final var effectiveTime = substanceAdministration.getEntryRelationship().stream()
                .filter(entryRelationship -> entryRelationship.getTypeCode() == XActRelationshipEntryRelationship.COMP)
                .map(POCDMT000040EntryRelationship::getSupply)
                .filter(Objects::nonNull)
                .filter(supply -> TemplateIds.isInList(TemplateIds.RENEWAL_PERIOD, supply.getTemplateId()))
                .findAny()
                .map(POCDMT000040Supply::getEffectiveTime)
                .map(OptionalUtils::getListFirstElement)
                .filter(IVLTS.class::isInstance)
                .map(IVLTS.class::cast)
                .orElse(null);
        if (effectiveTime == null) {
            return Optional.empty();
        }
        final Instant low = IvlTsUtils.getInclusiveLowInstant(effectiveTime);
        final Instant high = IvlTsUtils.getInclusiveHighInstant(effectiveTime);
        final TemporalAmount duration = IvlTsUtils.getWidth(effectiveTime);
        if (high != null) {
            return Optional.of(new RenewalInterval(low, high));
        } else if (duration != null) {
            return Optional.of(new RenewalInterval(low, duration));
        } else {
            throw new IllegalArgumentException("The renewal period has no higher bound and duration");
        }
    }
}
