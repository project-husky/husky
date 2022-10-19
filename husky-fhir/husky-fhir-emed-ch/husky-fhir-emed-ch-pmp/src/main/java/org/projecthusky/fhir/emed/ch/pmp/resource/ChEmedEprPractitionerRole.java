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
package org.projecthusky.fhir.emed.ch.pmp.resource;

import org.hl7.fhir.r4.model.PractitionerRole;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;

/**
 * husky
 *
 * @author Quentin Ligier
 **/
public class ChEmedEprPractitionerRole extends PractitionerRole {

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
}
