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

import org.hl7.fhir.r4.model.Patient;

import ca.uhn.fhir.model.api.annotation.ResourceDef;

/**
 * The HAPI custom structure for CH-Core patient EPR.
 * 
 * @author <a href="roeland.luykx@raly.ch">Roeland Luykx</a>
 */
@ResourceDef(profile = "http://fhir.ch/ig/ch-core/StructureDefinition/ch-core-patient-epr")
public class ChCorePatientEpr extends ChCorePatient {

	private static final long serialVersionUID = -1433886416088854398L;

	@Override
	public ChCorePatientEpr copy() {
		final var copy = new ChCorePatientEpr();
		this.copyValues(copy);
		return copy;
	}

	@Override
	public void copyValues(final Patient dst) {
		super.copyValues(dst);
		if (dst instanceof final ChCorePatientEpr als) {
			als.placeOfBirth = placeOfBirth == null ? null : placeOfBirth.copy();
			als.placeOfOrigin = placeOfOrigin == null ? null : placeOfOrigin;
			als.citizenship = citizenship == null ? null : citizenship;
			als.religion = religion == null ? null : religion.copy();
		}
	}
}
