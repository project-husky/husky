package org.husky.common.utils.datatypes;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.framework.qual.DefaultQualifier;
import org.checkerframework.framework.qual.TypeUseLocation;

import java.util.Objects;

/**
 * Helpers related to UIDs. UID (Unique Identifier String) is a data type described in the CDA specification (2.14 in
 * ANSI/HL7 V3 XMLITSDT, R1-2004, 4/8/2004).
 * <p>
 * An UID can be either an OID, an UUID or a RUID.
 *
 * @author Quentin Ligier
 * @see Uuids
 * @see Oids
 * @see Ruids
 */
@DefaultQualifier(value = NonNull.class, locations = {TypeUseLocation.PARAMETER, TypeUseLocation.RETURN})
public class Uids {

    /**
     * This class is not instantiable.
     */
    private Uids() {}

    /**
     * Normalizes an UID.
     */
    public static String normalize(final String uid) {
        Objects.requireNonNull(uid);
        if (Uuids.PATTERN.matcher(uid).matches() || Uuids.PATTERN_WITH_URN.matcher(uid).matches()) {
            return Uuids.normalize(uid);
        } else if (Oids.PATTERN.matcher(uid).matches() || Oids.PATTERN_WITH_URN.matcher(uid).matches()) {
            return Oids.normalize(uid);
        } else {
            // A RUID doesn't need to be normalized
            return uid;
        }
    }
}
