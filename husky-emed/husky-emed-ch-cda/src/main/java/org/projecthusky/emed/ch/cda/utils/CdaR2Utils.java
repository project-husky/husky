/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.emed.ch.cda.utils;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.checkerframework.dataflow.qual.SideEffectFree;
import org.projecthusky.common.hl7cdar2.*;
import org.projecthusky.emed.ch.errors.InvalidEmedContentException;
import org.projecthusky.emed.ch.models.common.EmedReference;

import java.util.*;

/**
 * Utilities for CDA R2 classes.
 *
 * @author Quentin Ligier
 */
public class CdaR2Utils {

    /**
     * This class is not instantiable.
     */
    private CdaR2Utils() {}

    /**
     * Returns the single non-blank string of the {@code xmlMixed} parameter of an {@link ANY} instance. If no string
     * or more than one strings are present, the method throws an exception.
     *
     * @param any The {@link ANY} instance.
     * @return the single non-blank string from {@code xmlMixed}.
     * @throws IllegalArgumentException if there is zero or more than one {@code xmlMixed} value.
     */
    public static String getSingleNonNullMixedOrThrow(final ANY any) {
        final List<String> mixed = any.getXmlMixed();
        if (mixed == null || mixed.size() != 1) {
            throw new IllegalArgumentException("");
        }
        return mixed.get(0);
    }

    /**
     * Returns the single non-blank string of the {@code xmlMixed} parameter of an {@link ANY} instance. If no string
     * is present, {@code null} is returned and if more than one strings are present, the method throws an exception.
     *
     * @param any The {@link ANY} instance or {@code null}.
     * @return the single non-blank string from {@code xmlMixed} or {@code null}.
     * @throws IllegalArgumentException if there is more than one {@code xmlMixed} value.
     */
    @Nullable
    public static String getSingleNullableMixedOrThrow(@Nullable final ANY any) {
        if (any == null) {
            return null;
        }
        final List<String> mixed = any.getXmlMixed();
        if (mixed == null || mixed.isEmpty()) {
            return null;
        } else if (mixed.size() > 1) {
            throw new IllegalArgumentException("");
        } else {
            return mixed.get(0);
        }
    }

    /**
     * Returns the content section (that contains the item entries).
     *
     * @return the content section.
     */
    @SideEffectFree
    public static Optional<POCDMT000040Section> getContentSection(final POCDMT000040ClinicalDocument cce) {
        return Optional.ofNullable(Objects.requireNonNull(cce).getComponent())
                .map(POCDMT000040Component2::getStructuredBody)
                .map(POCDMT000040StructuredBody::getComponent)
                .orElse(Collections.emptyList())
                .stream()
                .map(POCDMT000040Component3::getSection)
                .filter(Objects::nonNull)
                .filter(section -> TemplateIds.hasAllIds(TemplateIds.MTP_SECTION, section.getTemplateId())
                        || TemplateIds.hasAllIds(TemplateIds.PRE_SECTION, section.getTemplateId())
                        || TemplateIds.hasAllIds(TemplateIds.DIS_SECTION, section.getTemplateId())
                        || TemplateIds.hasAllIds(TemplateIds.PADV_SECTION, section.getTemplateId())
                        || TemplateIds.hasAllIds(TemplateIds.PML_SECTION, section.getTemplateId())
                        || TemplateIds.hasAllIds(TemplateIds.PMLC_SECTION, section.getTemplateId()))
                .findAny();
    }

    /**
     * Constructs a new eMed reference from a Supply reference.
     *
     * @param supply The Supply element.
     * @return the created eMed reference.
     * @throws InvalidEmedContentException if the CCE document is invalid.
     */
    public static EmedReference toEmedReference(final POCDMT000040Supply supply) {
        Objects.requireNonNull(supply);
        final II id = (!supply.getId().isEmpty()) ? supply.getId().get(0) : null;
        if (!IiUtils.isValidUid(id) || supply.getId().size() > 1) {
            throw new InvalidEmedContentException("The Supply item ID is invalid");
        }
        final var entryId = IiUtils.getUuid(supply.getId().get(0));
        final UUID documentId;
        if (!supply.getReference().isEmpty()) {
            final II docIi = supply.getReference().get(0).getExternalDocument().getId().get(0);
            if (!IiUtils.isValidUuid(docIi)) {
                throw new InvalidEmedContentException("The Supply document ID is invalid");
            }
            documentId = IiUtils.getUuid(docIi);
        } else {
            documentId = null;
        }
        return new EmedReference(documentId, entryId);
    }


    /**
     * Constructs a new eMed reference from an Observation reference.
     *
     * @param observation The Observation element.
     * @return the created eMed reference.
     * @throws InvalidEmedContentException if the CCE document is invalid.
     */
    public static EmedReference toEmedReference(final POCDMT000040Observation observation) throws InvalidEmedContentException {
        Objects.requireNonNull(observation);
        final II id = (!observation.getId().isEmpty()) ? observation.getId().get(0) : null;
        if (!IiUtils.isValidUid(id) || observation.getId().size() > 1) {
            throw new InvalidEmedContentException("The Observation item ID is invalid");
        }
        final UUID documentId;
        if (!observation.getReference().isEmpty()) {
            final II docIi = observation.getReference().get(0).getExternalDocument().getId().get(0);
            if (!IiUtils.isValidUuid(docIi)) {
                throw new InvalidEmedContentException("The Observation document ID is invalid");
            }
            documentId = IiUtils.getUuid(docIi);
        } else {
            documentId = null;
        }
        return new EmedReference(documentId, null);
    }

    /**
     * Constructs a new eMed reference from a SubstanceAdministration reference.
     *
     * @param substanceAdministration The SubstanceAdministration element.
     * @return the created eMed reference.
     * @throws InvalidEmedContentException if the CCE document is invalid.
     */
    public static EmedReference toEmedReference(final POCDMT000040SubstanceAdministration substanceAdministration) throws InvalidEmedContentException {
        Objects.requireNonNull(substanceAdministration);
        final II id = (!substanceAdministration.getId().isEmpty()) ? substanceAdministration.getId().get(0) : null;
        if (!IiUtils.isValidUid(id) || substanceAdministration.getId().size() > 1) {
            throw new InvalidEmedContentException("The SubstanceAdministration item ID is invalid");
        }
        final var entryId = IiUtils.getUuid(substanceAdministration.getId().get(0));
        final UUID documentId;
        if (!substanceAdministration.getReference().isEmpty()) {
            final II docIi = substanceAdministration.getReference().get(0).getExternalDocument().getId().get(0);
            if (!IiUtils.isValidUuid(docIi)) {
                throw new InvalidEmedContentException("The SubstanceAdministration document ID is invalid");
            }
            documentId = IiUtils.getUuid(docIi);
        } else {
            documentId = null;
        }
        return new EmedReference(documentId, entryId);
    }
}
