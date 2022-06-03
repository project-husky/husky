/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.ch.cda.utils;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.common.hl7cdar2.II;

import java.util.List;
import java.util.Objects;

/**
 * Specifications of CDA documents.
 *
 * @author Quentin Ligier
 */
public class TemplateIds {

    /**
     * This class is not instantiable.
     */
    private TemplateIds() {}

    /**
     * Template IDs for references to external documents.
     */
    public static final List<String> REFERENCE_TO_MTP = List.of("1.3.6.1.4.1.19376.1.9.1.3.10", "2.16.756.5.30.1.1.10.4.45");
    public static final List<String> REFERENCE_TO_PRE = List.of("1.3.6.1.4.1.19376.1.9.1.3.11", "2.16.756.5.30.1.1.10.4.47");
    public static final List<String> REFERENCE_TO_DIS = List.of("1.3.6.1.4.1.19376.1.9.1.3.12", "2.16.756.5.30.1.1.10.4.46");
    public static final List<String> REFERENCE_TO_PADV = List.of("1.3.6.1.4.1.19376.1.9.1.3.13", "2.16.756.5.30.1.1.10.4.53");

    /**
     * Template IDs in MTP documents.
     */
    public static final List<String> MTP_DOCUMENT = List.of("1.3.6.1.4.1.19376.1.9.1.1.6", "2.16.756.5.30.1.1.10.1.7");
    public static final List<String> MTP_SECTION = List.of("1.3.6.1.4.1.19376.1.9.1.2.6", "2.16.756.5.30.1.1.10.3.13");
    public static final List<String> MTP_ENTRY = List.of("1.3.6.1.4.1.19376.1.9.1.3.7", "2.16.756.5.30.1.1.10.4.34");

    /**
     * Template IDs in PRE documents.
     */
    public static final List<String> PRE_DOCUMENT = List.of("1.3.6.1.4.1.19376.1.9.1.1.1", "2.16.756.5.30.1.1.10.1.4");
    public static final List<String> PRE_SECTION = List.of("1.3.6.1.4.1.19376.1.9.1.2.1", "2.16.756.5.30.1.1.10.3.10");
    public static final List<String> PRE_ENTRY = List.of("1.3.6.1.4.1.19376.1.9.1.3.2", "2.16.756.5.30.1.1.10.4.43");

    /**
     * Template IDs in DIS documents.
     */
    public static final List<String> DIS_DOCUMENT = List.of("1.3.6.1.4.1.19376.1.9.1.1.3", "2.16.756.5.30.1.1.10.1.5");
    public static final List<String> DIS_SECTION = List.of("1.3.6.1.4.1.19376.1.9.1.2.3", "2.16.756.5.30.1.1.10.3.11");
    public static final List<String> DIS_ENTRY = List.of("1.3.6.1.4.1.19376.1.9.1.3.4", "2.16.756.5.30.1.1.10.4.42");

    /**
     * Template IDs in PADV documents.
     */
    public static final List<String> PADV_DOCUMENT = List.of("1.3.6.1.4.1.19376.1.9.1.1.2", "2.16.756.5.30.1.1.10.1.6");
    public static final List<String> PADV_SECTION = List.of("1.3.6.1.4.1.19376.1.9.1.2.2", "2.16.756.5.30.1.1.10.3.12");
    public static final List<String> PADV_ENTRY = List.of("1.3.6.1.4.1.19376.1.9.1.3.3", "2.16.756.5.30.1.1.10.4.44");

    /**
     * Template IDs in PML documents.
     */
    public static final List<String> PML_DOCUMENT = List.of("1.3.6.1.4.1.19376.1.9.1.1.5", "2.16.756.5.30.1.1.10.1.13");
    public static final List<String> PML_SECTION = List.of("1.3.6.1.4.1.19376.1.9.1.2.5", "2.16.756.5.30.1.1.10.3.44");

    /**
     * Template IDs in PMLC documents.
     */
    public static final List<String> PMLC_DOCUMENT = List.of("1.3.6.1.4.1.19376.1.9.1.1.5", "2.16.756.5.30.1.1.10.1.3");
    public static final List<String> PMLC_SECTION = List.of("1.3.6.1.4.1.19376.1.9.1.2.5", "2.16.756.5.30.1.1.10.3.9");

    /**
     * Other sections.
     */
    public static final String REMARKS_SECTION = "2.16.756.5.30.1.1.10.3.2";
    public static final String ORIGINAL_REPRESENTATION_SECTION = "2.16.756.5.30.1.1.10.3.45";

    /**
     * Others template IDs.
     */
    public static final String PATIENT_MEDICATION_INSTRUCTIONS = "1.3.6.1.4.1.19376.1.5.3.1.4.3";
    public static final String FULFILLMENT_INSTRUCTIONS = "1.3.6.1.4.1.19376.1.5.3.1.4.3.1";
    public static final String VALIDATION_STEP = "1.3.6.1.4.1.19376.1.9.1.3.16";
    public static final String TREATMENT_REASON = "2.16.756.5.30.1.1.10.4.41";
    public static final String DOSAGE_INTAKE_MODE = "2.16.756.5.30.1.1.10.4.37";
    public static final String DOSAGE_INSTRUCTIONS_NON_STRUCTURED = "2.16.756.5.30.1.1.10.4.52";
    public static final String ANNOTATION_COMMENT = "2.16.756.5.30.1.1.10.4.2";
    public static final String DOSAGE_TYPE_NORMAL = "1.3.6.1.4.1.19376.1.5.3.1.4.7.1";
    public static final String DOSAGE_TYPE_TAPERED = "1.3.6.1.4.1.19376.1.5.3.1.4.8";
    public static final String DOSAGE_TYPE_SPLIT = "1.3.6.1.4.1.19376.1.5.3.1.4.9";
    public static final String DOSAGE_INSTRUCTIONS = "1.3.6.1.4.1.19376.1.9.1.3.6";
    public static final String SUBSTITUTION_PERMISSION = "1.3.6.1.4.1.19376.1.9.1.3.9.1";
    public static final String SUBSTITUTION_ACT = "1.3.6.1.4.1.19376.1.9.1.3.9.2";
    public static final String RENEWAL_PERIOD = "1.3.6.1.4.1.19376.1.9.1.3.15";
    public static final String IN_RESERVE = "2.16.756.5.30.1.1.10.10";

    /**
     * CDA-CH Author (cdach_other_Author).
     */
    public static final String CDA_CH_AUTHOR = "2.16.756.5.30.1.1.10.9.23";

    /**
     * Searches whether an ID is in a list of template IDs.
     *
     * @param searchedId  The ID to find.
     * @param templateIds The list of template IDs to search in.
     */
    public static boolean isInList(final String searchedId,
                                   @Nullable final List<II> templateIds) {
        Objects.requireNonNull(searchedId);
        if (templateIds == null || templateIds.isEmpty()) {
            return false;
        }
        return templateIds.stream().map(II::getRoot).anyMatch(searchedId::equals);
    }

    /**
     * Searches whether all IDs from a list are present in a list of template IDs.
     *
     * @param searchedIds The IDs to find. If the list is empty, the method returns {@code true}.
     * @param templateIds The list of template IDs to search in.
     */
    public static boolean hasAllIds(final List<String> searchedIds,
                                    @Nullable final List<II> templateIds) {
        if (searchedIds.isEmpty()) {
            return true;
        }
        if (templateIds == null || templateIds.isEmpty()) {
            return false;
        }
        return templateIds.stream().map(II::getRoot).toList().containsAll(Objects.requireNonNull(searchedIds));
    }

    /**
     * Searches whether any ID from a list is present in a list of template IDs.
     *
     * @param searchedIds The IDs to find. If the list is empty, the method returns {@code true}.
     * @param templateIds The list of template IDs to search in.
     */
    public static boolean anyInList(final List<String> searchedIds,
                                    @Nullable final List<II> templateIds) {
        if (searchedIds.isEmpty()) {
            return true;
        }
        if (templateIds == null || templateIds.isEmpty()) {
            return false;
        }
        return templateIds.stream().map(II::getRoot).anyMatch(searchedIds::contains);
    }
}
