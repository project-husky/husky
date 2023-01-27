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
package org.projecthusky.fhir.emed.ch.common.model.datatype;

import java.util.UUID;

/**
 * Utilities for Hapi's {@link org.hl7.fhir.r4.model.Identifier}.
 *
 * @author Quentin Ligier
 **/
public class Identifier {

    /**
     * This class is not instantiable.
     */
    private Identifier() {
    }

    /**
     * Constructs an {@link org.hl7.fhir.r4.model.Identifier} from a {@link UUID}.
     *
     * @param uuid The UUID to use as identifier.
     * @return the constructed identifier.
     */
    public static org.hl7.fhir.r4.model.Identifier fromUuid(final UUID uuid) {
        final var identifier = new org.hl7.fhir.r4.model.Identifier();
        identifier.setValue("urn:uuid:" + uuid.toString());
        identifier.setSystem("urn:ietf:rfc:3986");
        return identifier;
    }

    /**
     * Constructs an {@link org.hl7.fhir.r4.model.Identifier} from an OID.
     *
     * @param oid The OID to use as identifier.
     * @return the constructed identifier.
     */
    public static org.hl7.fhir.r4.model.Identifier fromOid(final String oid) {
        final var identifier = new org.hl7.fhir.r4.model.Identifier();
        identifier.setValue("urn:oid:" + oid);
        identifier.setSystem("urn:ietf:rfc:3986"); // TODO ?
        return identifier;
    }
}
