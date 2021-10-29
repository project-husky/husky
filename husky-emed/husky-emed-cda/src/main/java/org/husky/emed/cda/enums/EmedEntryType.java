package org.husky.emed.cda.enums;

import java.util.Objects;

/**
 * Enumeration of the different kind of CDA-CH-EMED item entries.
 *
 * @author Quentin Ligier
 */
public enum EmedEntryType {

    /** <div class="en"> Medication Treatment Plan Item</div> */
    MTP("Medication Treatment Plan Item"),

    /** <div class="en"> Prescription Item</div> */
    PRE("Prescription Item"),

    /** <div class="en"> Dispense Item</div> */
    DIS("Dispense Item"),

    /** <div class="en"> Pharmaceutical Advice Item</div> */
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
}
