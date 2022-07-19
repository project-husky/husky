/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.husky.emed.ch.cda.digesters;

import org.apache.commons.lang3.ObjectUtils;
import org.husky.common.hl7cdar2.*;
import org.husky.common.utils.OptionalUtils;
import org.husky.emed.ch.cda.utils.IiUtils;
import org.husky.emed.ch.cda.utils.TemplateIds;
import org.husky.emed.ch.cda.utils.readers.AuthorReader;
import org.husky.emed.ch.cda.utils.readers.SubAdmEntryReader;
import org.husky.emed.ch.errors.InvalidEmedContentException;
import org.husky.emed.ch.models.common.AuthorDigest;
import org.husky.emed.ch.models.common.EmedReference;
import org.husky.emed.ch.models.entry.EmedMtpEntryDigest;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

/**
 * Creator of CDA-CH-EMED MTP item entry digests.
 *
 * @author Quentin Ligier
 */
@Component
public class CceMtpEntryDigester {

    /**
     * Creates a new {@link EmedMtpEntryDigest} from an MTP SubstanceAdministration element.
     *
     * @param substanceAdministration The MTP SubstanceAdministration element.
     * @param documentId              The document ID (MTP or PADV).
     * @param planningDate            The planning date.
     * @param parentDocumentAuthor    The parent document author (not the original document author).
     * @param parentSectionAuthor     The parent section author (not the original section author).
     * @return a digest of the element.
     */
    protected EmedMtpEntryDigest createDigest(final POCDMT000040SubstanceAdministration substanceAdministration,
                                              final UUID documentId,
                                              final Instant planningDate,
                                              final AuthorDigest parentDocumentAuthor,
                                              final AuthorDigest parentSectionAuthor) throws InvalidEmedContentException {
        if (!TemplateIds.hasAllIds(TemplateIds.MTP_ENTRY, substanceAdministration.getTemplateId())) {
            throw new InvalidEmedContentException("The given substance administration is not an MTP item entry");
        }
        final var mtpEntry = new SubAdmEntryReader(Objects.requireNonNull(substanceAdministration));

        final AuthorDigest documentAuthor;
        final AuthorDigest sectionAuthor;
        /*
         * In a PADV CHANGE, the original authors may be referenced in the entry and be different from the
         * document/section authors.
         */
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

        final Instant plannedItemValidityStart = ObjectUtils.firstNonNull(
                mtpEntry.getEffectiveStartTime().orElse(null),
                planningDate
        );

        return new EmedMtpEntryDigest(
                planningDate,
                documentId,
                documentAuthor,
                sectionAuthor,
                IiUtils.getUuid(mtpEntry.getEntryId()),
                IiUtils.getUuid(mtpEntry.getEntryId()), // Use the MTP entry ID as treatment ID
                0,
                mtpEntry.getAnnotationComment().orElse(null),
                mtpEntry.getDosageInstructions(),
                mtpEntry.getManufacturedMaterialReader().toMedicationProduct(),
                mtpEntry.getRepeatNumber().orElse(null),
                mtpEntry.getRouteOfAdministration().orElse(null),
                plannedItemValidityStart,
                mtpEntry.getEffectiveStopTime().orElse(null),
                mtpEntry.isSubstitutionPermitted(),
                this.getReferenceToOriginalMtpEntry(substanceAdministration).orElse(null),
                mtpEntry.getTreatmentReason().orElse(null),
                mtpEntry.getPatientMedicationInstructions().orElse(null),
                mtpEntry.getFulfillmentInstructions().orElse(null),
                mtpEntry.isInReserve(),
                mtpEntry.getQuantityToDispense().orElse(null)
        );
    }

    /**
     * Finds the reference to the original MTP item if that's a consolidated MTP item entry.
     *
     * @param substanceAdministration The MTP item SubstanceAdministration.
     * @return an {@link Optional} that may contain a reference to the original MTP item entry.
     */
    private Optional<EmedReference> getReferenceToOriginalMtpEntry(final POCDMT000040SubstanceAdministration substanceAdministration) {
        var sa = substanceAdministration.getEntryRelationship().stream()
                .filter(entryRelationship -> entryRelationship.getTypeCode() == XActRelationshipEntryRelationship.REFR)
                .findAny()
                .map(POCDMT000040EntryRelationship::getSubstanceAdministration)
                .orElse(null);
        if (sa == null) {
            return Optional.empty();
        }
        final EmedReference reference = new EmedReference(
                Optional.of(sa.getReference())
                        .map(OptionalUtils::getListFirstElement)
                        .map(POCDMT000040Reference::getExternalDocument)
                        .map(POCDMT000040ExternalDocument::getId)
                        .map(OptionalUtils::getListFirstElement)
                        .map(IiUtils::getUuid)
                        .orElse(null),
                Optional.ofNullable(sa.getId().get(0)).map(IiUtils::getUuid).orElse(null)
        );
        return Optional.of(reference);
    }
}
