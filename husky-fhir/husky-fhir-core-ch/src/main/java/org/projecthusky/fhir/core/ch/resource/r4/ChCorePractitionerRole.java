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
package org.projecthusky.fhir.core.ch.resource.r4;

import java.util.UUID;

import org.hl7.fhir.r4.model.PractitionerRole;
import org.hl7.fhir.r4.model.Reference;

import ca.uhn.fhir.model.api.annotation.ResourceDef;

/**
 * 
 */
@ResourceDef(profile = "http://fhir.ch/ig/ch-core/StructureDefinition/ch-core-practitionerrole")
public class ChCorePractitionerRole extends PractitionerRole {

	private static final long serialVersionUID = -107133923169312532L;

	/**
	 * Method to create a new practitioner and set it as the practitioner.
	 * 
	 * @return the created practitioner
	 */
	public ChCorePractitioner addPractitioner() {
		ChCorePractitioner practitioner = new ChCorePractitioner();
		practitioner.setId(UUID.randomUUID().toString());
		this.setPractitioner(new Reference(practitioner));
		return practitioner;
	}

	/**
	 * Method to create a new organization and set it as the organization of
	 * this.
	 * 
	 * @return the created organization
	 */
	public ChCoreOrganization addOrganization() {
		ChCoreOrganization organization = new ChCoreOrganization();
		organization.setId(UUID.randomUUID().toString());
		this.setOrganization(new Reference(organization));
		return organization;
	}
}
