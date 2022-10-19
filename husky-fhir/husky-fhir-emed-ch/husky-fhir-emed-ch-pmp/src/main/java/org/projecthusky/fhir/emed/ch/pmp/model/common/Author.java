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
package org.projecthusky.fhir.emed.ch.pmp.model.common;

import lombok.Data;
import org.hl7.fhir.r4.model.Device;
import org.hl7.fhir.r4.model.RelatedPerson;
import org.projecthusky.fhir.emed.ch.common.resource.ChCoreOrganizationEpr;
import org.projecthusky.fhir.emed.ch.common.resource.ChCorePatientEpr;
import org.projecthusky.fhir.emed.ch.pmp.resource.ChEmedEprPractitioner;
import org.projecthusky.fhir.emed.ch.pmp.resource.ChEmedEprPractitionerRole;

/**
 * An author in the CH-EMED-EPR IG. It can be made up of a single (e.g. patient) or multiple resources (e.g.
 * practitionerRole, practitioner and organization).
 *
 * @author Quentin Ligier
 **/
@Data
public class Author {

    private ChEmedEprPractitioner practitioner;

    private ChEmedEprPractitionerRole practitionerRole;

    private Device device;

    private RelatedPerson relatedPerson;

    private ChCorePatientEpr patient;

    private ChCoreOrganizationEpr organization;
}
