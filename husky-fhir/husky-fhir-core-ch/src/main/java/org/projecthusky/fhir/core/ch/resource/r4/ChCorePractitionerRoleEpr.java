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

import org.hl7.fhir.instance.model.api.IBaseReference;
import org.hl7.fhir.r4.model.Reference;

import ca.uhn.fhir.model.api.annotation.ResourceDef;

/**
 * 
 */
@ResourceDef(profile = "http://fhir.ch/ig/ch-core/StructureDefinition/ch-core-practitionerrole-epr")
public class ChCorePractitionerRoleEpr extends ChCorePractitionerRole {

	private static final long serialVersionUID = 5424644269273541146L;

	@Override
	public ChCorePractitionerEpr addPractitioner() {
		ChCorePractitionerEpr practitioner = new ChCorePractitionerEpr();
		practitioner.setId(UUID.randomUUID().toString());
		Reference ref = new Reference();
		ref.setReference("urn:uuid:" + practitioner.getId()).setResource(practitioner);
		this.setPractitioner(ref);
		return practitioner;
	}

	@Override
	public ChCoreOrganizationEpr addOrganization() {
		ChCoreOrganizationEpr organization = new ChCoreOrganizationEpr();
		organization.setId(UUID.randomUUID().toString());
		Reference ref = new Reference();
		ref.setReference("urn:uuid:" + organization.getId()).setResource(organization);
		this.setOrganization(ref);
		return organization;
	}

}
