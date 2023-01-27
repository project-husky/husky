package org.projecthusky.common.utils.datatypes;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.framework.qual.DefaultQualifier;
import org.checkerframework.framework.qual.TypeUseLocation;

import java.util.Objects;
import java.util.UUID;
import java.util.regex.Pattern;

/**
 * Helpers related to UUIDs (as per RFC4122).
 * <p>
 * In XDS.b and FHIR, UUIDs should be lower-cased. In CDA, they should be upper-cased.
 *
 * @author Quentin Ligier
 */
@DefaultQualifier(value = NonNull.class, locations = {TypeUseLocation.PARAMETER, TypeUseLocation.RETURN})
public class Uuids {

    public static final String URN_PREFIX = "urn:uuid:";

    /**
     * This class is not instantiable.
     */
    private Uuids() {
    }

    /**
     * Pattern that matches a UUID.
     */
    public static final Pattern PATTERN = Pattern.compile("^[0-9A-Fa-f]{8}(?:-[0-9A-Fa-f]{4}){3}-[0-9A-Fa-f]{12}$");

    /**
     * Pattern that matches a URN-encoded UUID.
     */
    public static final Pattern PATTERN_WITH_URN =
            Pattern.compile("^urn:uuid:[0-9A-Fa-f]{8}(?:-[0-9A-Fa-f]{4}){3}-[0-9A-Fa-f]{12}$");

    /**
     * Normalizes a UUID by removing the URN-encoding part if needed and lowercasing it.
     */
    public static String normalize(final String uuid) {
        Objects.requireNonNull(uuid);
        if (uuid.startsWith(URN_PREFIX)) {
            return uuid.substring(9).toLowerCase();
        }
        return uuid.toLowerCase();
    }

    /**
     * Generates a new random UUID.
     */
    public static String generate() {
        return UUID.randomUUID().toString();
    }

    public static UUID parseUrnEncoded(final String urn) {
        return UUID.fromString(normalize(urn));
    }
}
