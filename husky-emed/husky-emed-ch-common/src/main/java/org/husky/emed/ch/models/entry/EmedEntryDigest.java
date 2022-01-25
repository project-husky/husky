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

import lombok.Getter;
import lombok.Setter;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.emed.ch.enums.EmedEntryType;
import org.husky.emed.ch.models.common.AuthorDigest;

import java.time.Instant;
import java.util.Objects;

/**
 * Represents the digest of an EMED document item entry. This class is declined in subclasses {@link
 * EmedMtpEntryDigest}, {@link EmedPreEntryDigest}, {@link EmedDisEntryDigest} and {@link EmedPadvEntryDigest}.
 *
 * @author Quentin Ligier
 */
@Getter
@Setter
public abstract class EmedEntryDigest {

    /**
     * The annotation comment or {@code null} if it isn't provided.
     */
    @Nullable
    protected String annotationComment;

    /**
     * The instant at which the item entry was created.
     */
    protected Instant creationTime;

    /**
     * The author of the original parent document or {@code null} if they're not known.
     */
    @Nullable
    protected AuthorDigest documentAuthor;

    /**
     * The parent document unique ID.
     */
    protected String documentId;

    /**
     * The item entry ID.
     */
    protected String entryId;

    /**
     * The ID of the medication treatment this item entry belongs to.
     */
    protected String medicationTreatmentId;

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
     * @param creationTime          The instant at which the item entry was created.
     * @param documentId            The parent document unique ID.
     * @param documentAuthor        The author of the original parent document or {@code null} if they're not known.
     * @param sectionAuthor         The author of the original parent section or {@code null} if they're not known.
     * @param entryId               The item entry ID.
     * @param medicationTreatmentId The ID of the medication treatment this item entry belongs to.
     * @param sequence              The sequence of addition.
     * @param annotationComment     The annotation comment or {@code null} if it isn't provided.
     */
    protected EmedEntryDigest(final Instant creationTime,
                              final String documentId,
                              @Nullable final AuthorDigest documentAuthor,
                              @Nullable final AuthorDigest sectionAuthor,
                              final String entryId,
                              final String medicationTreatmentId,
                              final int sequence,
                              @Nullable final String annotationComment) {
        this.creationTime = Objects.requireNonNull(creationTime);
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

    @Override
    public String toString() {
        return "EmedEntryDigest{" +
                "creationTime=" + creationTime +
                ", documentId='" + documentId + '\'' +
                ", sectionAuthor=" + sectionAuthor +
                ", documentAuthor=" + documentAuthor +
                ", entryId='" + entryId + '\'' +
                ", medicationTreatmentId='" + medicationTreatmentId + '\'' +
                ", sequence=" + sequence +
                ", annotationComment='" + annotationComment + '\'' +
                '}';
    }
}
