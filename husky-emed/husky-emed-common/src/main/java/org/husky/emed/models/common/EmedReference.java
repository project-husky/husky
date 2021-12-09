/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.models.common;

import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * A reference to an eMed document and/or item.
 *
 * @author Quentin Ligier
 */
public class EmedReference {

    /**
     * The EMED document ID; null if not specified.
     */
    @Nullable private String documentId;

    /**
     * The EMED item ID; null if not specified.
     */
    @Nullable private String itemId;

    /**
     * Constructs a new EMED reference from a document ID and/or an item ID.
     *
     * @param documentId The EMED document ID or {@code null} if not specified.
     * @param itemId     The EMED item ID or {@code null} if not specified.
     * @throws IllegalArgumentException if both documentId and itemId are null.
     */
    public EmedReference(@Nullable final String documentId,
                         @Nullable final String itemId) {
        if (documentId == null && itemId == null) {
            throw new IllegalArgumentException("The document and item IDs shall not be both null");
        }
        this.documentId = documentId;
        this.itemId = itemId;
    }

    /**
     * Returns whether this instances references an item ({@code true}) or a document ({@code false}).
     */
    public boolean isItemReference() {
        return this.itemId != null;
    }

    @Nullable
    public String getDocumentId() {
        return this.documentId;
    }

    @Nullable
    public String getItemId() {
        return this.itemId;
    }

    public void setDocumentId(@Nullable final String documentId) {
        this.documentId = documentId;
    }

    public void setItemId(@Nullable final String itemId) {
        this.itemId = itemId;
    }

    public String toString() {
        return "EmedReference(documentId=" + this.getDocumentId() + ", itemId=" + this.getItemId() + ")";
    }
}
