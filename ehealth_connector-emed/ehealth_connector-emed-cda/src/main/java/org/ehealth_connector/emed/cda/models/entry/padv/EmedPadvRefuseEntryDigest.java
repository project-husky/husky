package org.ehealth_connector.emed.cda.models.entry.padv;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.ehealth_connector.emed.cda.enums.EmedEntryType;
import org.ehealth_connector.emed.cda.enums.PharmaceuticalAdviceStatus;
import org.ehealth_connector.emed.cda.models.common.AuthorDigest;
import org.ehealth_connector.emed.cda.models.common.EmedReference;
import org.ehealth_connector.emed.cda.models.entry.EmedPadvEntryDigest;

import java.time.Instant;

/**
 * Represents the digest of an EMED PADV document Refuse item entry.
 *
 * @author Quentin Ligier
 */
public class EmedPadvRefuseEntryDigest extends EmedPadvEntryDigest {

    /**
     * Constructor.
     *
     * @param creationTime          The instant at which the item entry was created.
     * @param documentId            The parent document unique ID.
     * @param documentAuthor        The author of the original parent document.
     * @param sectionAuthor         The author of the original parent section.
     * @param entryId               The item entry ID.
     * @param medicationTreatmentId The ID of the medication treatment this item entry belongs to.
     * @param patientId             The patient ID.
     * @param sequence              The sequence of addition.
     * @param annotationComment     The annotation comment or {@code null} if it isn't provided.
     * @param completed             Whether the PADV status is completed or not.
     * @param effectiveTime         The instant at which the advice becomes effective.
     * @param targetedEntryRef      Reference to the targeted item entry.
     * @param targetedEntryType     Document type of the targeted item entry (MTP or PRE).
     */
    public EmedPadvRefuseEntryDigest(final Instant creationTime,
                                     final String documentId,
                                     final AuthorDigest documentAuthor,
                                     final AuthorDigest sectionAuthor,
                                     final String entryId,
                                     final String medicationTreatmentId,
                                     final String patientId,
                                     final int sequence,
                                     @Nullable final String annotationComment,
                                     final boolean completed,
                                     final Instant effectiveTime,
                                     final EmedReference targetedEntryRef,
                                     final EmedEntryType targetedEntryType) {
        super(creationTime, documentId, documentAuthor, sectionAuthor, entryId, medicationTreatmentId, patientId,
                sequence, annotationComment, completed, effectiveTime, targetedEntryRef, targetedEntryType);

        if (targetedEntryType != EmedEntryType.MTP && targetedEntryType != EmedEntryType.PRE) {
            throw new IllegalArgumentException("The entry targeted by a PADV REFUSE shall be of MTP or PRE type");
        }
    }

    /**
     * Returns the type of the PADV item entry digest.
     */
    public PharmaceuticalAdviceStatus getPadvEntryType() {
        return PharmaceuticalAdviceStatus.REFUSE;
    }
}
