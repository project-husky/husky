package org.husky.emed.cda.models.common;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.common.hl7cdar2.*;
import org.husky.emed.cda.errors.InvalidEmedContentException;
import org.husky.emed.cda.utils.IiUtils;

import java.util.Objects;
import java.util.Optional;

/**
 * A reference to an Emed document and/or item.
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
     * Constructs a new EMED reference from a Reference element.
     * <p>
     * TODO/SPEC: multiple IDs in a reference?
     *
     * @param reference The Reference element.
     * @throws InvalidEmedContentException if the CCE document is invalid.
     */
    public EmedReference(final POCDMT000040Reference reference) throws InvalidEmedContentException {
        Objects.requireNonNull(reference);
        final II ii = Optional.ofNullable(reference.getExternalDocument())
            .map(POCDMT000040ExternalDocument::getId)
            .flatMap(ids -> ids.stream()
                .filter(Objects::nonNull)
                .findAny()
            ).orElse(null);
        if (!IiUtils.isValidUuid(ii)) {
            throw new InvalidEmedContentException("The Reference ID is invalid");
        }
        this.documentId = IiUtils.getNormalizedUuid(ii);
        this.itemId = null;
    }

    /**
     * Constructs a new EMED reference from a SubstanceAdministration reference.
     *
     * @param substanceAdministration The SubstanceAdministration element.
     * @throws InvalidEmedContentException if the CCE document is invalid.
     */
    public EmedReference(final POCDMT000040SubstanceAdministration substanceAdministration) throws InvalidEmedContentException {
        Objects.requireNonNull(substanceAdministration);
        final II id = (!substanceAdministration.getId().isEmpty()) ? substanceAdministration.getId().get(0) : null;
        if (!IiUtils.isValidUid(id) || substanceAdministration.getId().size() > 1) {
            throw new InvalidEmedContentException("The SubstanceAdministration item ID is invalid");
        }
        this.itemId = IiUtils.getNormalizedUid(substanceAdministration.getId().get(0));
        if (!substanceAdministration.getReference().isEmpty()) {
            final II docIi = substanceAdministration.getReference().get(0).getExternalDocument().getId().get(0);
            if (!IiUtils.isValidUuid(docIi)) {
                throw new InvalidEmedContentException("The SubstanceAdministration document ID is invalid");
            }
            this.documentId = IiUtils.getNormalizedUuid(docIi);
        } else {
            this.documentId = null;
        }
    }

    /**
     * Constructs a new EMED reference from a Supply reference.
     *
     * @param supply The Supply element.
     * @throws InvalidEmedContentException if the CCE document is invalid.
     */
    public EmedReference(final POCDMT000040Supply supply) throws InvalidEmedContentException {
        Objects.requireNonNull(supply);
        final II id = (!supply.getId().isEmpty()) ? supply.getId().get(0) : null;
        if (!IiUtils.isValidUid(id) || supply.getId().size() > 1) {
            throw new InvalidEmedContentException("The Supply item ID is invalid");
        }
        if (!supply.getReference().isEmpty()) {
            final II docIi = supply.getReference().get(0).getExternalDocument().getId().get(0);
            if (!IiUtils.isValidUuid(docIi)) {
                throw new InvalidEmedContentException("The Supply document ID is invalid");
            }
            this.documentId = IiUtils.getNormalizedUuid(docIi);
        } else {
            this.documentId = null;
        }
        this.itemId = null;
    }

    /**
     * Constructs a new EMED reference from an Observation reference.
     *
     * @param observation The Observation element.
     * @throws InvalidEmedContentException if the CCE document is invalid.
     */
    public EmedReference(final POCDMT000040Observation observation) throws InvalidEmedContentException {
        Objects.requireNonNull(observation);
        final II id = (!observation.getId().isEmpty()) ? observation.getId().get(0) : null;
        if (!IiUtils.isValidUid(id) || observation.getId().size() > 1) {
            throw new InvalidEmedContentException("The Observation item ID is invalid");
        }
        if (!observation.getReference().isEmpty()) {
            final II docIi = observation.getReference().get(0).getExternalDocument().getId().get(0);
            if (!IiUtils.isValidUuid(docIi)) {
                throw new InvalidEmedContentException("The Observation document ID is invalid");
            }
            this.documentId = IiUtils.getNormalizedUuid(docIi);
        } else {
            this.documentId = null;
        }
        this.itemId = null;
    }

    /**
     * Constructs a new EMED reference from a ParentDocument element.
     *
     * @param parentDocument The PatentDocument element.
     * @throws InvalidEmedContentException if the CCE document is invalid.
     */
    public EmedReference(final POCDMT000040ParentDocument parentDocument) throws InvalidEmedContentException {
        Objects.requireNonNull(parentDocument);
        if (!IiUtils.isValidUuid(parentDocument.getId().get(0))) {
            throw new InvalidEmedContentException("The ParentDocument ID is invalid");
        }
        this.documentId = IiUtils.getNormalizedUuid(parentDocument.getId().get(0));
        this.itemId = null;
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
