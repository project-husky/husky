package org.husky.emed.cda.enums;

import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Objects;

/**
 * The Enum PharmaceuticalAdviceStatus
 *
 * @see <a href="https://www.ihe.net/uploadedFiles/Documents/Pharmacy/IHE_Pharmacy_Suppl_PADV.pdf">IHE PHARM PADV 6.5.1
 * IHE Pharmaceutical Advice Status List</a>
 */
public enum PharmaceuticalAdviceStatus {

    CANCEL("CANCEL"),
    CHANGE("CHANGE"),
    OK("OK"),
    REFUSE("REFUSE"),
    SUSPEND("SUSPEND"),
    COMMENT("COMMENT");

    /**
     * The Constant CODE_SYSTEM_NAME.
     */
    public static final String CODE_SYSTEM_NAME = "IHE Pharmaceutical Advice Status List";

    /**
     * The Constant CODE_SYSTEM_OID.
     */
    public static final String CODE_SYSTEM_OID = "1.3.6.1.4.1.19376.1.9.2.1";
    /**
     * The code.
     */
    private final String code;

    /**
     * Instantiates a new pharmaceutical advice status.
     *
     * @param code The code.
     */
    PharmaceuticalAdviceStatus(final String code) {
        Objects.requireNonNull(code);
        this.code = code;
    }

    /**
     * Gets the enum.
     *
     * @param code The code to find.
     * @return the enum or {@code null} if it has not been found.
     */
    @Nullable
    public static PharmaceuticalAdviceStatus getEnum(final String code) {
        Objects.requireNonNull(code);
        for (final PharmaceuticalAdviceStatus x : values()) {
            if (x.code.equals(code)) {
                return x;
            }
        }
        return null;
    }
}
