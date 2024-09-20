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
package org.projecthusky.fhir.vacd.ch.common.resource.r4;

import java.util.UUID;

import org.hl7.fhir.r4.model.Observation;

import ca.uhn.fhir.model.api.annotation.ResourceDef;

/**
 * The HAPI custom structure for CH-VACD LaboratoryAndSerology.
 * 
 * @author <a href="roeland.luykx@raly.ch">Roeland Luykx</a>
 */
@ResourceDef(profile = "http://fhir.ch/ig/ch-vacd/StructureDefinition/ch-vacd-laboratory-serology")
public class ChVacdLaboratoryAndSerology extends Observation {

	private static final long serialVersionUID = -5282679759940081789L;

	public ChVacdLaboratoryAndSerology() {
		addIdentifier().setSystem("urn:ietf:rfc:3986")
				.setValue("urn:uuid:" + UUID.randomUUID().toString());
	}
}
