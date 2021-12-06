/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.cda.enums;

import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Objects;

/**
 * The different types of a Pharmaceutical Advice entry item.
 *
 * @see <a href="https://www.ihe.net/uploadedFiles/Documents/Pharmacy/IHE_Pharmacy_Suppl_PADV.pdf">IHE PHARM PADV 6.5.1
 * IHE Pharmaceutical Advice Status List</>
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
     * Gets the enum.
     *
     * @param code The code to find.
     * @return the enum or {@code null} if it has not been found.
     */
    @Nullable
    public static PharmaceuticalAdviceStatus getEnum(@Nullable final String code) {
        for (final PharmaceuticalAdviceStatus x : values()) {
            if (x.code.equals(code)) {
                return x;
            }
        }
        return null;
    }

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
        this.code = Objects.requireNonNull(code);
    }

    /**
     * Returns the code.
     */
    public String getCode() {
        return this.code;
    }
}
