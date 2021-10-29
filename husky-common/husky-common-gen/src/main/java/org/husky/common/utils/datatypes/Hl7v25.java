package org.husky.common.utils.datatypes;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.framework.qual.DefaultQualifier;
import org.checkerframework.framework.qual.TypeUseLocation;

import java.util.Objects;

/**
 * Utilities for HL7 v2.5 data types.
 *
 * @author Quentin Ligier
 */
@DefaultQualifier(value = NonNull.class, locations = {TypeUseLocation.PARAMETER, TypeUseLocation.RETURN})
public class Hl7v25 {

    /**
     * This class is not instantiable.
     */
    private Hl7v25() {}

    /**
     * Safely encodes Hl7 separators from an ST value.
     *
     * @param st The ST to encode.
     * @return the encoded ST value.
     */
    public static String encodeSt(final String st) {
        Objects.requireNonNull(st);
        String encodedSt = st.replace("\\", "\\E\\"); // Escape character
        encodedSt = encodedSt.replace("|", "\\F\\"); // Field separator
        encodedSt = encodedSt.replace("^", "\\S\\"); // Component separator
        encodedSt = encodedSt.replace("&", "\\T\\"); // Subcomponent separator
        encodedSt = encodedSt.replace("~", "\\R\\"); // Repetition separator
        return encodedSt;
    }
}
