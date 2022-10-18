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
package org.projecthusky.fhir.emed.ch.pmp.model.common;

import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.UUID;

/**
 * A reference to an eMedication document and/or entry.
 *
 * @author Quentin Ligier
 */
public class EmedReference {

    /**
     * The document ID; {@code null} if not specified.
     */
    @Nullable
    private UUID documentId;

    /**
     * The entry ID; {@code null} if not specified.
     */
    @Nullable
    private UUID entryId;

    /**
     * Constructs a new eMedication reference from a document ID and/or an entry ID.
     *
     * @param documentId The document ID or {@code null} if not specified.
     * @param entryId    The entry ID or {@code null} if not specified.
     * @throws IllegalArgumentException if both documentId and entryId are null.
     */
    public EmedReference(@Nullable final UUID documentId,
                         @Nullable final UUID entryId) {
        if (documentId == null && entryId == null) {
            throw new IllegalArgumentException("The document and entry IDs shall not be both null");
        }
        this.documentId = documentId;
        this.entryId = entryId;
    }

    /**
     * Returns whether this instance references an entry ({@code true}) or a document ({@code false}).
     */
    public boolean isEntryReference() {
        return this.entryId != null;
    }

    public String toText() {
        if (this.entryId != null) {
            if (this.documentId != null) {
                return String.format("entry '%s' (in document '%s')", this.entryId, this.documentId);
            }
            return String.format("entry '%s'", this.entryId);
        }
        return String.format("document '%s'", this.documentId);
    }

    @Nullable
    public UUID getDocumentId() {
        return this.documentId;
    }

    @Nullable
    public UUID getEntryId() {
        return this.entryId;
    }

    public void setDocumentId(@Nullable final UUID documentId) {
        this.documentId = documentId;
    }

    public void setEntryId(@Nullable final UUID entryId) {
        this.entryId = entryId;
    }

    public String toString() {
        return "EmedReference(documentId=" + this.getDocumentId() + ", entryId=" + this.getEntryId() + ")";
    }
}
