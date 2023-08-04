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
package org.projecthusky.communication.xds_mhd;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.common.utils.datatypes.Oids;
import org.projecthusky.common.utils.datatypes.Uuids;

/**
 * Some utility methods for MHD.
 *
 * @author Quentin Ligier
 **/
public class MhdUtils {

    /**
     * This class is not instantiable.
     */
    private MhdUtils() {
    }

    public static @Nullable String asUuid(final @Nullable String urn) {
        if (urn == null) {
            return null;
        }
        if (urn.startsWith(Uuids.URN_PREFIX)) {
            return urn;
        }
        return Uuids.URN_PREFIX + urn;
    }

    public static @Nullable String noUuidPrefix(final @Nullable String urn) {
        if (urn == null) {
            return null;
        }
        if (urn.startsWith(Uuids.URN_PREFIX)) {
            return urn.substring(Uuids.URN_PREFIX.length());
        }
        return urn;
    }

    public static @Nullable String noOidPrefix(final @Nullable String urn) {
        if (urn == null) {
            return null;
        }
        if (urn.startsWith(Oids.PREFIX_OID)) {
            return urn.substring(Oids.PREFIX_OID.length());
        }
        return urn;
    }
}
