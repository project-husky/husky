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

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import org.hl7.fhir.r4.model.Address;

/**
 * 
 */
@ResourceDef(profile = "http://fhir.ch/ig/ch-core/StructureDefinition/ch-core-organization-epr")
public class ChCoreOrganizationEpr extends ChCoreOrganization {
	private static final long serialVersionUID = 3227289686864894282L;

	/**
	 * Sets the organization's address. If the address already exists, it's replaced.
	 *
	 * @param address the organization's address.
	 * @return this.
	 */
	public ChCoreOrganizationEpr setAddress(final Address address) {
		if (this.hasAddress()) {
			this.getAddress().set(0, address);
		} else {
			this.addAddress(address);
		}
		return this;
	}
}
