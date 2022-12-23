package org.projecthusky.common.utils.datatypes;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.framework.qual.DefaultQualifier;
import org.checkerframework.framework.qual.TypeUseLocation;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Helpers related to OIDs.
 *
 * @author Quentin Ligier
 */
@DefaultQualifier(value = NonNull.class, locations = {TypeUseLocation.PARAMETER, TypeUseLocation.RETURN})
public class Oids {

    public static final String PREFIX_OID = "urn:oid:";

    /**
     * This class is not instantiable.
     */
    private Oids() {
    }

    /**
     * Pattern that matches a OID.
     */
    public static final Pattern PATTERN = Pattern.compile("^(?:[0-2])(?:(?:\\.0)|(?:\\.[1-9][0-9]*+))*+$");

    /**
     * Pattern that matches an URN-encoded OID.
     */
    public static final Pattern PATTERN_WITH_URN = Pattern
            .compile("^urn:oid:(?:[0-2])(?:(?:\\.0)|(?:\\.[1-9][0-9]*+))*+$");

    /**
     * Normalizes an OID by removing the URN-encoding part if needed.
     */
    public static String normalize(final String oid) {
        Objects.requireNonNull(oid);
        if (oid.startsWith("urn:oid:")) {
            return oid.substring(8);
        }
        return oid;
    }

    /**
     * Checks if a string matches the OID format (with or without URN encoding).
     */
    public static boolean match(final String string) {
        Objects.requireNonNull(string);
        return PATTERN.matcher(string).matches() || PATTERN_WITH_URN.matcher(string).matches();
    }

}
