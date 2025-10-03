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
package org.projecthusky.fhir.emed.ch.common.resource;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import org.hl7.fhir.r4.model.Address;
import org.projecthusky.fhir.core.ch.annotation.ExpectsValidResource;
import org.projecthusky.fhir.core.ch.resource.r4.ChCoreOrganizationEpr;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;

/**
 * The HAPI custom structure for CH-EMED Organization.
 *
 * @author Quentin Ligier
 **/
@ResourceDef(profile = "http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-organization")
public class ChEmedOrganization extends ChCoreOrganizationEpr {

    /**
     * Empty constructor for the parser.
     */
    public ChEmedOrganization() {
        super();
    }

    /**
     * Resolves the organization's address identifier or throws.
     *
     * @return the address.
     * @throws InvalidEmedContentException if the organization's address is missing.
     */
    @ExpectsValidResource
    public Address resolveAddress() throws InvalidEmedContentException {
        if (!this.hasAddress()) {
            throw new InvalidEmedContentException("The organization's address is missing.");
        }
        return this.getAddress().getFirst();
    }

    @Override
    public ChEmedOrganization copy() {
        final var copy = new ChEmedOrganization();
        this.copyValues(copy);
        return copy;
    }
}
