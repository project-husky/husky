/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.ch.cda.utils;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.common.utils.datatypes.Hl7v25;
import org.husky.common.utils.datatypes.Oids;
import org.husky.common.utils.datatypes.Uuids;
import org.husky.common.hl7cdar2.II;
import org.husky.emed.ch.models.common.QualifiedIdentifier;

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

    /**
     * Normalizes an HL7 V2.5 CX field. The code is escaped, the code system ID shall be an OID so escaping it
     * shouldn't be needed.
     *
     * @param ii The validated identifier to normalizes.
     * @return the normalized CX field.
     */
    public static String getNormalizedCx(final II ii) {
        if (ii.getRoot() == null) {
            return "";
        }
        return String.format(
                "%s^^^&%s&ISO",
                Hl7v25.encodeSt(ii.getRoot()),
                ii.getExtension()
        );
    }

    /**
     * Transforms an HL7 II instance into a qualified identifier.
     *
     * @param ii The identifier to transform.
     * @return the qualified identifier.
     */
    public static QualifiedIdentifier toQualifiedIdentifier(final II ii) {
        return new QualifiedIdentifier(
                ii.getExtension(),
                ii.getRoot()
        );
    }

    /**
     * Transforms a qualified identifier into an HL7 II.
     *
     * @param qualifiedIdentifier The qualified identifier to transform.
     * @return the HL7 II instance.
     */
    public static II fromQualifiedIdentifier(final QualifiedIdentifier qualifiedIdentifier) {
        return new II(qualifiedIdentifier.getAssigningAuthority(), qualifiedIdentifier.getIdentifier());
    }
}
