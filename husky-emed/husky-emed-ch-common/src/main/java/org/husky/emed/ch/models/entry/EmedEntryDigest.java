/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.ch.models.entry;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.emed.ch.enums.EmedEntryType;
import org.husky.emed.ch.models.common.AuthorDigest;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

/**
 * Represents the digest of an EMED document item entry. This class is declined in subclasses {@link
 * EmedMtpEntryDigest}, {@link EmedPreEntryDigest}, {@link EmedDisEntryDigest} and {@link EmedPadvEntryDigest}.
 *
 * @author Quentin Ligier
 */
public abstract class EmedEntryDigest {

    /**
     * The annotation comment or {@code null} if it isn't provided.
     */
    @Nullable
    protected String annotationComment;

    /**
     * The planning time, prescription time, dispense time or pharmaceutical advice time.
     */
    protected Instant itemTime;

    /**
     * The author of the original parent document or {@code null} if they're not known.
     */
    @Nullable
    protected AuthorDigest documentAuthor;

    /**
     * The parent document unique ID.
     */
    protected UUID documentId;

    /**
     * The item entry ID.
     */
    protected UUID entryId;

    /**
     * The ID of the medication treatment this item entry belongs to.
     */
    protected UUID medicationTreatmentId;

    /**
     * The author of the original parent section or {@code null} if they're not known.
     */
    @Nullable
    protected AuthorDigest sectionAuthor;

    /**
     * The sequence of creation, if multiple documents in the same medication treatment share the same creation time (it
     * usually happens when the creation date is only precise to the day).
     */
    protected int sequence;

    /**
     * Constructor.
     *
     * @param itemTime              The planning time, prescription time, dispense time or pharmaceutical advice time.
     * @param documentId            The parent document unique ID.
     * @param documentAuthor        The author of the original parent document or {@code null} if they're not known.
     * @param sectionAuthor         The author of the original parent section or {@code null} if they're not known.
     * @param entryId               The item entry ID.
     * @param medicationTreatmentId The ID of the medication treatment this item entry belongs to.
     * @param sequence              The sequence of addition.
     * @param annotationComment     The annotation comment or {@code null} if it isn't provided.
     */
    protected EmedEntryDigest(final Instant itemTime,
                              final UUID documentId,
                              @Nullable final AuthorDigest documentAuthor,
                              @Nullable final AuthorDigest sectionAuthor,
                              final UUID entryId,
                              final UUID medicationTreatmentId,
                              final int sequence,
                              @Nullable final String annotationComment) {
        this.itemTime = Objects.requireNonNull(itemTime);
        this.documentId = Objects.requireNonNull(documentId);
        this.documentAuthor = documentAuthor;
        this.sectionAuthor = sectionAuthor;
        this.entryId = Objects.requireNonNull(entryId);
        this.medicationTreatmentId = Objects.requireNonNull(medicationTreatmentId);
        this.sequence = sequence;
        this.annotationComment = annotationComment;
    }

    /**
     * Returns the non-null type of the item entry digest.
     */
    public abstract EmedEntryType getEmedEntryType();

    @Nullable
    public String getAnnotationComment() {
        return this.annotationComment;
    }

    public void setAnnotationComment(@Nullable final String annotationComment) {
        this.annotationComment = annotationComment;
    }

    @Nullable
    public AuthorDigest getDocumentAuthor() {
        return this.documentAuthor;
    }

    public void setDocumentAuthor(@Nullable final AuthorDigest documentAuthor) {
        this.documentAuthor = documentAuthor;
    }

    public UUID getDocumentId() {
        return this.documentId;
    }

    public void setDocumentId(final UUID documentId) {
        this.documentId = documentId;
    }

    public UUID getEntryId() {
        return this.entryId;
    }

    public void setEntryId(final UUID entryId) {
        this.entryId = entryId;
    }

    public UUID getMedicationTreatmentId() {
        return this.medicationTreatmentId;
    }

    public void setMedicationTreatmentId(final UUID medicationTreatmentId) {
        this.medicationTreatmentId = medicationTreatmentId;
    }

    @Nullable
    public AuthorDigest getSectionAuthor() {
        return this.sectionAuthor;
    }

    public void setSectionAuthor(@Nullable final AuthorDigest sectionAuthor) {
        this.sectionAuthor = sectionAuthor;
    }

    public int getSequence() {
        return this.sequence;
    }

    public void setSequence(final int sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof final EmedEntryDigest that)) return false;
        return sequence == that.sequence
                && Objects.equals(annotationComment, that.annotationComment)
                && Objects.equals(itemTime, that.itemTime)
                && Objects.equals(documentAuthor, that.documentAuthor)
                && Objects.equals(documentId, that.documentId)
                && Objects.equals(entryId, that.entryId)
                && Objects.equals(medicationTreatmentId, that.medicationTreatmentId)
                && Objects.equals(sectionAuthor, that.sectionAuthor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(annotationComment, itemTime, documentAuthor, documentId, entryId, medicationTreatmentId, sectionAuthor, sequence);
    }

    @Override
    public String toString() {
        return "EmedEntryDigest{" +
                "annotationComment='" + this.annotationComment + '\'' +
                ", itemTime=" + this.itemTime +
                ", documentAuthor=" + this.documentAuthor +
                ", documentId='" + this.documentId + '\'' +
                ", entryId='" + this.entryId + '\'' +
                ", medicationTreatmentId='" + this.medicationTreatmentId + '\'' +
                ", sectionAuthor=" + this.sectionAuthor +
                ", sequence=" + this.sequence +
                '}';
    }
}
