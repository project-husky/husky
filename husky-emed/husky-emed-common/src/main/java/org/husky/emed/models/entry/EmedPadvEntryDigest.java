/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.models.entry;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.emed.enums.EmedEntryType;
import org.husky.emed.enums.PharmaceuticalAdviceStatus;
import org.husky.emed.models.common.AuthorDigest;
import org.husky.emed.models.common.EmedReference;

import java.time.Instant;
import java.util.Objects;

/**
 * Represents the digest of an eMed PADV document item entry.
 *
 * @author Quentin Ligier
 */
public abstract class EmedPadvEntryDigest extends EmedEntryDigest {

    /**
     * The instant at which the advice becomes effective.
     */
    protected Instant effectiveTime;

    /**
     * Whether the PADV status is completed or not.
     */
    private boolean completed;

    /**
     * Reference to the targeted item entry.
     */
    private EmedReference targetedEntryRef;

    /**
     * Document type of the targeted item entry.
     */
    private EmedEntryType targetedEntryType;

    /*
     * Pharmaceutical Advice Concerns
     */

    /**
     * Constructor.
     *
     * @param creationTime          The instant at which the item entry was created.
     * @param documentId            The parent document unique ID.
     * @param documentAuthor        The author of the original parent document.
     * @param sectionAuthor         The author of the original parent section.
     * @param entryId               The item entry ID.
     * @param medicationTreatmentId The ID of the medication treatment this item entry belongs to.
     * @param sequence              The sequence of addition.
     * @param annotationComment     The annotation comment or {@code null} if it isn't provided.
     * @param completed             Whether the PADV status is completed or not.
     * @param effectiveTime         The instant at which the advice becomes effective.
     * @param targetedEntryRef      Reference to the targeted item entry.
     * @param targetedEntryType     Document type of the targeted item entry.
     */
    protected EmedPadvEntryDigest(final Instant creationTime,
                                  final String documentId,
                                  final AuthorDigest documentAuthor,
                                  final AuthorDigest sectionAuthor,
                                  final String entryId,
                                  final String medicationTreatmentId,
                                  final int sequence,
                                  @Nullable final String annotationComment,
                                  final boolean completed,
                                  final Instant effectiveTime,
                                  final EmedReference targetedEntryRef,
                                  final EmedEntryType targetedEntryType) {
        super(creationTime, documentId, documentAuthor, sectionAuthor, entryId, medicationTreatmentId, sequence,
                annotationComment);
        this.completed = completed;
        this.effectiveTime = Objects.requireNonNull(effectiveTime);
        this.targetedEntryRef = Objects.requireNonNull(targetedEntryRef);
        this.targetedEntryType = Objects.requireNonNull(targetedEntryType);
        if (targetedEntryType == EmedEntryType.PADV) {
            throw new IllegalArgumentException("The entry targeted by a PADV CANCEL shall be of MTP, PRE or DIS type");
        }
    }

    /**
     * Returns the non-null type of the item entry digest.
     */
    public EmedEntryType getEmedEntryType() {
        return EmedEntryType.PADV;
    }

    /**
     * Returns the type of the PADV item entry digest.
     */
    public abstract PharmaceuticalAdviceStatus getPadvEntryType();

    public Instant getEffectiveTime() {
        return this.effectiveTime;
    }

    public void setEffectiveTime(final Instant effectiveTime) {
        this.effectiveTime = Objects.requireNonNull(effectiveTime);
    }

    public boolean isCompleted() {
        return this.completed;
    }

    public void setCompleted(final boolean completed) {
        this.completed = completed;
    }

    public EmedReference getTargetedEntryRef() {
        return this.targetedEntryRef;
    }

    public void setTargetedEntryRef(final EmedReference targetedEntryRef) {
        this.targetedEntryRef = Objects.requireNonNull(targetedEntryRef);
    }

    public EmedEntryType getTargetedEntryType() {
        return this.targetedEntryType;
    }

    public void setTargetedEntryType(final EmedEntryType targetedEntryType) {
        this.targetedEntryType = Objects.requireNonNull(targetedEntryType);
    }

    @Override
    public String toString() {
        return "EmedPadvEntryDigest{" +
                "creationTime=" + creationTime +
                ", documentId='" + documentId +
                ", documentAuthor=" + documentAuthor +
                ", sectionAuthor=" + sectionAuthor +
                ", entryId='" + entryId +
                ", medicationTreatmentId='" + medicationTreatmentId +
                ", sequence=" + sequence +
                ", effectiveTime=" + effectiveTime +
                ", completed=" + completed +
                ", targetedEntryRef=" + targetedEntryRef +
                ", targetedEntryType=" + targetedEntryType +
                '}';
    }
}
