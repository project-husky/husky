/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.emed.ch.models.entry.padv;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.emed.ch.enums.EmedEntryType;
import org.projecthusky.emed.ch.enums.PharmaceuticalAdviceStatus;
import org.projecthusky.emed.ch.models.common.AuthorDigest;
import org.projecthusky.emed.ch.models.common.EmedReference;
import org.projecthusky.emed.ch.models.entry.EmedPadvEntryDigest;

import java.time.Instant;
import java.util.UUID;

/**
 * Represents the digest of an EMED PADV document Refuse item entry.
 *
 * @author Quentin Ligier
 */
public class EmedPadvRefuseEntryDigest extends EmedPadvEntryDigest {

    /**
     * Constructor.
     *
     * @param pharmaceuticalAdviceTime The pharmaceutical advice time.
     * @param documentId               The parent document unique ID.
     * @param documentAuthor           The author of the original parent document or {@code null} if they're not known.
     * @param sectionAuthor            The author of the original parent section or {@code null} if they're not known.
     * @param entryId                  The item entry ID.
     * @param medicationTreatmentId    The ID of the medication treatment this item entry belongs to.
     * @param sequence                 The sequence of addition.
     * @param annotationComment        The annotation comment or {@code null} if it isn't provided.
     * @param completed                Whether the PADV status is completed or not.
     * @param effectiveTime            The instant at which the advice becomes effective.
     * @param targetedEntryRef         Reference to the targeted item entry.
     * @param targetedEntryType        Document type of the targeted item entry (MTP or PRE).
     */
    public EmedPadvRefuseEntryDigest(final Instant pharmaceuticalAdviceTime,
                                     final UUID documentId,
                                     @Nullable final AuthorDigest documentAuthor,
                                     @Nullable final AuthorDigest sectionAuthor,
                                     final UUID entryId,
                                     final UUID medicationTreatmentId,
                                     final int sequence,
                                     @Nullable final String annotationComment,
                                     final boolean completed,
                                     final Instant effectiveTime,
                                     final EmedReference targetedEntryRef,
                                     final EmedEntryType targetedEntryType) {
        super(pharmaceuticalAdviceTime, documentId, documentAuthor, sectionAuthor, entryId, medicationTreatmentId, sequence,
                annotationComment, completed, effectiveTime, targetedEntryRef, targetedEntryType);

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

    @Override
    public String toString() {
        return "EmedPadvRefuseEntryDigest{" +
                "annotationComment='" + this.annotationComment + '\'' +
                ", itemTime=" + this.itemTime +
                ", documentAuthor=" + this.documentAuthor +
                ", documentId='" + this.documentId + '\'' +
                ", entryId='" + this.entryId + '\'' +
                ", medicationTreatmentId='" + this.medicationTreatmentId + '\'' +
                ", sectionAuthor=" + this.sectionAuthor +
                ", sequence=" + this.sequence +
                ", effectiveTime=" + this.effectiveTime +
                ", completed=" + this.completed +
                ", targetedEntryRef=" + this.targetedEntryRef +
                ", targetedEntryType=" + this.targetedEntryType +
                '}';
    }
}
