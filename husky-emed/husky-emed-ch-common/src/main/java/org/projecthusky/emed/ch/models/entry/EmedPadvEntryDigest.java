/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.emed.ch.models.entry;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.emed.ch.enums.EmedEntryType;
import org.projecthusky.emed.ch.enums.PharmaceuticalAdviceStatus;
import org.projecthusky.emed.ch.errors.InvalidEmedContentException;
import org.projecthusky.emed.ch.models.common.AuthorDigest;
import org.projecthusky.emed.ch.models.common.EmedReference;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

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
    protected boolean completed;

    /**
     * Reference to the targeted item entry.
     */
    protected EmedReference targetedEntryRef;

    /**
     * Document type of the targeted item entry.
     */
    protected EmedEntryType targetedEntryType;

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
     * @param targetedEntryType        Document type of the targeted item entry.
     */
    protected EmedPadvEntryDigest(final Instant pharmaceuticalAdviceTime,
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
                annotationComment);
        this.completed = completed;
        this.effectiveTime = Objects.requireNonNull(effectiveTime);
        this.targetedEntryRef = Objects.requireNonNull(targetedEntryRef);
        this.targetedEntryType = Objects.requireNonNull(targetedEntryType);
        if (targetedEntryType == EmedEntryType.PADV) {
            throw new InvalidEmedContentException("The entry targeted by a PADV CANCEL shall be of MTP, PRE or DIS type");
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

    public Instant getPharmaceuticalAdviceTime() {
        return this.itemTime;
    }

    public void setPharmaceuticalAdviceTime(final Instant pharmaceuticalAdviceTime) {
        this.itemTime = Objects.requireNonNull(pharmaceuticalAdviceTime);
    }

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
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof final EmedPadvEntryDigest that)) return false;
        if (!super.equals(o)) return false;
        return completed == that.completed
                && Objects.equals(effectiveTime, that.effectiveTime)
                && Objects.equals(targetedEntryRef, that.targetedEntryRef)
                && targetedEntryType == that.targetedEntryType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), effectiveTime, completed, targetedEntryRef, targetedEntryType);
    }

    @Override
    public String toString() {
        return "EmedPadvEntryDigest{" +
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
