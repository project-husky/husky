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
package org.projecthusky.fhir.emed.ch.epr.resource;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import org.hl7.fhir.r4.model.PractitionerRole;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;

/**
 * The HAPI custom structure for CH-EMED-EPR PractitionerRole.
 *
 * @author Quentin Ligier
 **/
@ResourceDef(profile = "http://fhir.ch/ig/ch-emed-epr/StructureDefinition/ch-emed-epr-practitionerrole")
public class ChEmedEprPractitionerRole extends PractitionerRole {

    /**
     * Empty constructor for the parser.
     */
    public ChEmedEprPractitionerRole() {
        super();
    }

    /**
     * Resolves the practitioner related to this role.
     *
     * @return the practitioner.
     */
    @ExpectsValidResource
    public ChEmedEprPractitioner resolvePractitioner() {
        if (this.practitioner == null || this.practitioner.isEmpty()) {
            throw new InvalidEmedContentException("The practitioner is missing");
        }
        final var resource = this.practitioner.getResource();
        if (resource instanceof final ChEmedEprPractitioner thisPractitioner) {
            return thisPractitioner;
        }
        throw new InvalidEmedContentException("The practitioner is invalid");
    }

    /**
     * Resolves the organization related to this role if possible.
     *
     * @return the organization.
     * @throws InvalidEmedContentException if the organization is unspecified or invalid.
     */
    @ExpectsValidResource
    public ChEmedEprOrganization resolveOrganization() throws InvalidEmedContentException {
        if (!this.hasOrganization()) throw new InvalidEmedContentException("The organization is not specified");

        final var resource = this.getOrganization().getResource();
        if (resource instanceof final ChEmedEprOrganization chOrganization) {
            return chOrganization;
        }
        throw new InvalidEmedContentException("The organization is not specified");
    }

    @Override
    public ChEmedEprPractitionerRole copy() {
      final var copy = new ChEmedEprPractitionerRole();
      this.copyValues(copy);
      return copy;
    }
}
