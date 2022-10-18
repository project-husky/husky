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
package org.projecthusky.fhir.emed.ch.pmp.model.treatment;

import org.projecthusky.fhir.emed.ch.pmp.model.common.AuthorDigest;
import org.projecthusky.fhir.emed.ch.pmp.model.common.EmedReference;

import java.time.Instant;
import java.util.Objects;

/**
 * A comment in a medication treatment.
 *
 * @author Quentin Ligier
 **/
public class MedicationTreatmentComment {

    /**
     * The author of the comment.
     */
    protected final AuthorDigest author;

    /**
     * The comment content.
     */
    protected final String comment;

    /**
     * The instant at which the comment was created.
     */
    protected final Instant created;

    /**
     * The reference to the PADV COMMENT.
     */
    protected final EmedReference padvReference;

    public MedicationTreatmentComment(final AuthorDigest author,
                                      final String comment,
                                      final Instant created,
                                      final EmedReference padvReference) {
        this.author = Objects.requireNonNull(author);
        this.comment = Objects.requireNonNull(comment);
        this.created = Objects.requireNonNull(created);
        this.padvReference = Objects.requireNonNull(padvReference);
    }

    public AuthorDigest getAuthor() {
        return this.author;
    }

    public String getComment() {
        return this.comment;
    }

    public Instant getCreated() {
        return this.created;
    }

    public EmedReference getPadvReference() {
        return this.padvReference;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof final MedicationTreatmentComment that)) return false;
        return Objects.equals(author, that.author)
                && Objects.equals(comment, that.comment)
                && Objects.equals(created, that.created)
                && Objects.equals(padvReference, that.padvReference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, comment, created, padvReference);
    }

    @Override
    public String toString() {
        return "MedicationTreatmentComment{" +
                "author=" + this.author +
                ", comment='" + this.comment + '\'' +
                ", created=" + this.created +
                ", padvReference=" + this.padvReference +
                '}';
    }
}
