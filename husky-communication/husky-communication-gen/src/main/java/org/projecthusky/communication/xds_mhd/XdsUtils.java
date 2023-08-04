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
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Author;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Identifiable;

/**
 * Some utility methods for XDS.
 *
 * @author Quentin Ligier
 **/
public class XdsUtils {

    /**
     * This class is not instantiable.
     */
    private XdsUtils() {
    }

    public static boolean isPatientAuthor(final @Nullable Author author) {
        if (author == null) {
            return false;
        }
        if (author.getAuthorRole() == null) {
            return false;
        }
        for (final Identifiable roles : author.getAuthorRole()) {
            if ("PAT".equalsIgnoreCase(roles.getId()) || "REP".equalsIgnoreCase(roles.getId())) {
                return true;
            }
        }
        return false;
    }
}
