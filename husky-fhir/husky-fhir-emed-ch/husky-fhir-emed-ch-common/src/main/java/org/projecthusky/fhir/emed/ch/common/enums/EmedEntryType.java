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
package org.projecthusky.fhir.emed.ch.common.enums;

import java.util.Objects;

/**
 * Enumeration of the different kind of CDA-CH-EMED item entries.
 *
 * @author Quentin Ligier
 */
public enum EmedEntryType {

    /**
     * Medication Treatment Plan Item
     */
    MTP("Medication Treatment Plan Item"),

    /**
     * Prescription Item
     */
    PRE("Prescription Item"),

    /**
     * Dispense Item
     */
    DIS("Dispense Item"),

    /**
     * Pharmaceutical Advice Item
     */
    PADV("Pharmaceutical Advice Item");

    /**
     * The Constant CODE_SYSTEM_NAME.
     */
    public static final String CODE_SYSTEM_NAME = "IHE Pharmacy Item Type List";

    /**
     * The Constant CODE_SYSTEM_OID.
     */
    public static final String CODE_SYSTEM_OID = "1.3.6.1.4.1.19376.1.9.2.2";

    /**
     * The display name.
     */
    private final String displayName;

    /**
     * Instantiates a new EmedEntryType.
     *
     * @param displayName The display name.
     */
    EmedEntryType(final String displayName) {
        Objects.requireNonNull(displayName);
        this.displayName = displayName;
    }

    /**
     * Returns the display name.
     */
    public String getDisplayName() {
        return displayName;
    }
}
