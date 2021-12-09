/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.cda.services.digesters;

import java.time.Instant;
import java.time.temporal.TemporalAmount;
import java.util.Objects;
import java.util.Optional;

import org.husky.common.hl7cdar2.*;
import org.husky.common.utils.StreamUtils;
import org.husky.emed.errors.InvalidEmedContentException;
import org.husky.emed.models.common.AuthorDigest;
import org.husky.emed.models.common.EmedReference;
import org.husky.emed.models.common.RenewalInterval;
import org.husky.emed.models.entry.EmedEntryDigest;
import org.husky.emed.models.entry.EmedPreEntryDigest;
import org.husky.emed.cda.services.EmedEntryDigestService;
import org.husky.emed.cda.services.readers.SubAdmEntryReader;
import org.husky.emed.cda.utils.IiUtils;
import org.husky.emed.cda.utils.IvlTsUtils;
import org.husky.emed.cda.utils.TemplateIds;
import org.springframework.stereotype.Component;

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
    private final EmedEntryDigestService emedEntryService;

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
     * @param substanceAdministration   The PRE SubstanceAdministration element.
     * @param preDocumentId             The PRE document ID.
     * @param preDocumentEffectiveTime  The PRE document effective time.
     * @param prescriptionValidityStart The prescription validity start time (inclusive).
     * @param prescriptionValidityStop  The prescription validity stop time (inclusive).
     * @param patientId                 The patient ID.
     * @return a digest of the element.
     */
    protected EmedPreEntryDigest createDigest(final POCDMT000040SubstanceAdministration substanceAdministration,
                                              final String preDocumentId,
                                              final Instant preDocumentEffectiveTime,
                                              final Instant prescriptionValidityStart,
                                              final Instant prescriptionValidityStop,
                                              final String patientId) throws InvalidEmedContentException {
        if (!TemplateIds.hasAllIds(TemplateIds.PRE_ENTRY, substanceAdministration.getTemplateId())) {
            throw new InvalidEmedContentException("The given substance administration is not a PRE item entry");
        }
        final var preEntry = new SubAdmEntryReader(substanceAdministration);

        final EmedEntryDigest targetedMtp = this.getTargetedEntryDigest(substanceAdministration).orElse(null);

        final int sequence;
        final String medicationTreatmentId;
        if (targetedMtp != null) {
            sequence = (int) this.emedEntryService.getSequence(targetedMtp.getMedicationTreatmentId(),
                    preDocumentEffectiveTime);
            medicationTreatmentId = targetedMtp.getMedicationTreatmentId();
        } else {
            sequence = 0;
            medicationTreatmentId = IiUtils.getNormalizedUid(preEntry.getEntryId());
        }

        return new EmedPreEntryDigest(
                Objects.requireNonNull(preDocumentEffectiveTime),
                Objects.requireNonNull(preDocumentId),
                new AuthorDigest(), // TODO
                new AuthorDigest(), // TODO
                IiUtils.getNormalizedUid(preEntry.getEntryId()),
                medicationTreatmentId,
                Objects.requireNonNull(patientId),
                sequence,
                preEntry.getAnnotationComment().orElse(null),
                preEntry.getDosageInstructions(),
                preEntry.getManufacturedMaterialReader().toMedicationProduct(),
                preEntry.getRepeatNumber().orElse(null),
                preEntry.getRouteOfAdministration().orElse(null),
                prescriptionValidityStart,
                prescriptionValidityStop,
                this.getServiceStartTime(preEntry, prescriptionValidityStart),
                this.getServiceStopTime(preEntry, prescriptionValidityStop),
                this.getRenewalInterval(substanceAdministration).orElse(null),
                this.getTargetedMtpReference(substanceAdministration).orElse(null),
                this.isProvisional(substanceAdministration),
                preEntry.getSubstitutionPermissions(),
                preEntry.getTreatmentReason().orElse(null),
                preEntry.getPatientMedicationInstructions().orElse(null),
                preEntry.getFulfillmentInstructions().orElse(null)
        );
    }

    /**
     * Returns the starting time of the PRE item. It's the first known time from:
     * <li>The treatment period start time, defined by the first “effectiveTime” of each PRE Item;
     * <li>The start date of the PRE document.
     *
     * @param preEntry                  The PRE item reader.
     * @param prescriptionValidityStart The prescription validity start time (inclusive).
     * @return the starting time of the PRE item.
     */
    private Instant getServiceStartTime(final SubAdmEntryReader preEntry,
                                        final Instant prescriptionValidityStart) {
        return preEntry.getEffectiveStartTime().orElse(prescriptionValidityStart);
    }

    /**
     * Returns the ending time of the PRE item. It's the first known time from:
     * <li>The end date of the 'renewalPeriod' of the PRE item; TODO: mistake?
     * <li>The treatment period end date, defined by the first 'effectiveTime' of the PRE item;
     * <li>The end date of the PRE document.
     * <p>
     * TODO: Renewal period not considered yet
     *
     * @param preEntry                 The PRE item reader.
     * @param prescriptionValidityStop The prescription validity stop time (inclusive).
     * @return the ending time of the PRE item.
     */
    private Instant getServiceStopTime(final SubAdmEntryReader preEntry,
                                       final Instant prescriptionValidityStop) {
        return preEntry.getEffectiveStopTime().orElse(prescriptionValidityStop);
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
    private Optional<EmedReference> getTargetedMtpReference(final POCDMT000040SubstanceAdministration substanceAdministration) throws InvalidEmedContentException {
        return substanceAdministration.getEntryRelationship().stream()
                .filter(entryRelationship -> entryRelationship.getTypeCode() == XActRelationshipEntryRelationship.REFR)
                .findAny()
                .map(POCDMT000040EntryRelationship::getSubstanceAdministration)
                .map(EmedReference::new);
    }

    /**
     * Returns whether the PRE entry is provisional or not. It's provisional if it contains a single
     * validation step, as per IHE Pharm PRE 6.3.4.16.
     *
     * @param substanceAdministration The PRE item SubstanceAdministration.
     */
    private boolean isProvisional(final POCDMT000040SubstanceAdministration substanceAdministration) {
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
    private Optional<RenewalInterval> getRenewalInterval(final POCDMT000040SubstanceAdministration substanceAdministration) {
        final var effectiveTime = substanceAdministration.getEntryRelationship().stream()
                .filter(entryRelationship -> entryRelationship.getTypeCode() == XActRelationshipEntryRelationship.COMP)
                .map(POCDMT000040EntryRelationship::getSupply)
                .filter(Objects::nonNull)
                .filter(supply -> TemplateIds.isInList(TemplateIds.RENEWAL_PERIOD, supply.getTemplateId()))
                .findAny()
                .map(POCDMT000040Supply::getEffectiveTime)
                .map(StreamUtils::getListFirst)
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
