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

package org.husky.common.utils.datatypes;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.framework.qual.DefaultQualifier;
import org.checkerframework.framework.qual.TypeUseLocation;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Helpers related to GLNs.
 *
 * @author Quentin Ligier
 **/
@DefaultQualifier(value = NonNull.class, locations = {TypeUseLocation.PARAMETER, TypeUseLocation.RETURN})
public class Gln {

    /**
     * Pattern that matches a GLN.
     */
    public static final Pattern PATTERN = Pattern.compile("^\\d{13}$");

    /**
     * This class is not instantiable.
     */
    private Gln() {
    }

    /**
     * Checks if a string matches the GLN format.
     */
    public static boolean match(final String string) {
        Objects.requireNonNull(string);
        return PATTERN.matcher(string).matches() && validateCheckDigit(string);
    }

    /**
     * Validates a GLN identifier with its check digit.
     *
     * <p>As described in
     * <a href="https://github.com/tmattsson/gs1utils/blob/master/src/main/java/se/injoin/gs1utils/CheckDigit.java">tmattsson/gs1utils</a>
     * (under Apache 2.0 license).
     *
     * @param gln The GLN identifier.
     */
    private static boolean validateCheckDigit(final String gln) {
        final int checkDigit = gln.charAt(12) - '0';
        int sum = 0;
        for (int i = 0; i < gln.length() - 1; i++) {
            int n = gln.charAt(i) - '0';
            sum += n + (n + n) * (i & 1);
        }
        final int expectedCheckDigit = (10 - (sum % 10)) % 10;
        return checkDigit == expectedCheckDigit;
    }
}
