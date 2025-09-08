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
package org.projecthusky.fhir.core.ch.datatype.r4;

import org.hl7.fhir.r4.model.ContactPoint;

import ca.uhn.fhir.model.api.annotation.DatatypeDef;

/**
 * The HAPI custom structure for CH-Core ContactPoint Phone.
 * 
 * @author <a href="roeland.luykx@raly.ch">Roeland Luykx</a>
 */
@DatatypeDef(name = "CHCoreContactPointECH46Phone", isSpecialization = true, profileOf = ContactPoint.class)
public class CHCoreContactPointECH46Phone extends CHCoreContactPointECH46Abstract {

	private static final long serialVersionUID = 7394461489216981345L;

	public CHCoreContactPointECH46Phone() {
		this.setSystem(ContactPoint.ContactPointSystem.PHONE);
	}

}
