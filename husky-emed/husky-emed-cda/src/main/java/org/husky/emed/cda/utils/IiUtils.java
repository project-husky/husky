package org.husky.emed.cda.utils;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.common.utils.datatypes.Oids;
import org.husky.common.utils.datatypes.Uuids;
import org.husky.emed.cda.generated.hl7cdar2.II;

import java.util.Objects;

/**
 * Helpers for identifiers.
 *
 * @author Quentin Ligier
 */
public class IiUtils {

    /**
     * This class is not instantiable.
     */
    private IiUtils() {}

    /**
     * The maximum length of the root attribute.
     */
    private static final int MAX_ROOT_LENGTH = 128;

    /**
     * The maximum length of the extension attribute.
     */
    private static final int MAX_EXTENSION_LENGTH = 64;

    /**
     * Validates an {@link II} instance as an UID.
     *
     * @param ii The identifier to validate.
     * @return {@code true} if it's valid, {@code false} otherwise.
     */
    public static boolean isValidUid(@Nullable final II ii) {
        if (ii == null) {
            return false;
        }
        if (ii.getRoot() == null || ii.getRoot().length() > MAX_ROOT_LENGTH) {
            return false;
        }
        if (ii.getExtension() != null && ii.getExtension().length() > MAX_EXTENSION_LENGTH) {
            return false;
        }
        if (Uuids.PATTERN.matcher(ii.getRoot()).matches() || Uuids.PATTERN_WITH_URN.matcher(ii.getRoot()).matches()) {
            return ii.getExtension() == null;
        } else if (Oids.PATTERN.matcher(ii.getRoot()).matches() || Oids.PATTERN_WITH_URN.matcher(ii.getRoot()).matches()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Normalizes an UID. The {@link II} instance should have been validated before.
     *
     * @param ii The validated identifier to normalizes.
     * @return the normalized UID identifier.
     */
    public static String getNormalizedUid(final II ii) {
        Objects.requireNonNull(ii);
        if (ii.getRoot() == null) {
            return "";
        }
        if (Uuids.PATTERN.matcher(ii.getRoot()).matches() || Uuids.PATTERN_WITH_URN.matcher(ii.getRoot()).matches()) {
            return Uuids.normalize(ii.getRoot());
        } else {
            final String oid = Oids.normalize(ii.getRoot());
            if (ii.getExtension() != null) {
                return oid + "^" + ii.getExtension();
            } else {
                return oid;
            }
        }
    }

    /**
     * Validates an {@link II} instance as an UUID.
     *
     * @param ii The identifier to validate.
     * @return {@code true} if it's valid, {@code false} otherwise.
     */
    public static boolean isValidUuid(@Nullable final II ii) {
        return ii != null && ii.getRoot() != null && ii.getRoot().length() <= MAX_ROOT_LENGTH
                && ii.getExtension() == null &&
                (Uuids.PATTERN.matcher(ii.getRoot()).matches() || Uuids.PATTERN_WITH_URN.matcher(ii.getRoot()).matches());
    }

    /**
     * Normalizes an UUID.
     *
     * @param ii The validated identifier to normalizes.
     * @return the normalized UUID identifier.
     */
    public static String getNormalizedUuid(final II ii) {
        Objects.requireNonNull(ii);
        if (ii.getRoot() == null) {
            return "";
        }
        return Uuids.normalize(ii.getRoot());
    }
}
