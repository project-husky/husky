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

import org.hl7.fhir.r4.model.Condition;
import org.projecthusky.fhir.core.ch.exceptions.InvalidContentException;

import ca.uhn.fhir.model.api.annotation.ResourceDef;

/**
 * The HAPI custom structure for CH-Core Condition.
 * @author <a href="roeland.luykx@raly.ch">Roeland Luykx</a>
 */
@ResourceDef(profile = "http://fhir.ch/ig/ch-core/StructureDefinition/ch-core-condition")
public class ChCoreCondition extends Condition {

	private static final long serialVersionUID = -3632827230730919633L;

	public ChCorePatient resolvePatient() {
		final var reference = this.getSubject();
		if (reference != null) {
			if (reference.getResource() instanceof ChCorePatient) {
				return (ChCorePatient) reference.getResource();
			}
		}
		throw new InvalidContentException("The ChCorePatient is missing as subject in the Condition");
	}

}
