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

import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Practitioner;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import org.projecthusky.fhir.core.ch.annotation.ExpectsValidResource;
import org.projecthusky.fhir.core.ch.util.FhirSystem;
import org.projecthusky.fhir.core.ch.util.Identifiers;

import java.util.List;

/**
* The HAPI custom structure for CH-Core practitioner.
* 
* @author <a href="roeland.luykx@raly.ch">Roeland Luykx</a>
*/
@ResourceDef(profile = "http://fhir.ch/ig/ch-core/StructureDefinition/ch-core-practitioner")
public class ChCorePractitioner extends Practitioner {
	private static final long serialVersionUID = -8264091688845034534L;

	/**
	 * Resolves the practitioner's GLN identifier. A single identifier is expected.
	 *
	 * @return the GLN identifier if present, otherwise {@code null}.
	 */
	@ExpectsValidResource
	public @Nullable String resolveGln() {
		final var identifier = Identifiers.getBySystem(this.getIdentifier(), FhirSystem.GLN);
		return identifier == null? null : identifier.getValue();
	}

	/**
	 * Sets the practitioner's GLN identifier. If the GLN already exists, it's replaced.
	 *
	 * @param gln the practitioner's GLN identifier.
	 * @return the created Identifier.
	 */
	public Identifier setGln(final String gln) {
		var identifier = Identifiers.getBySystem(this.getIdentifier(), FhirSystem.GLN);
		if (identifier == null) {
			identifier = this.addIdentifier();
			identifier.setSystem(FhirSystem.GLN);
		}
		identifier.setValue(gln);
		return identifier;
	}

	/**
	 * Resolves the practitioner ZSR number(s). Zero or more identifiers are expected; in a prescription, at least one
	 * identifier is required.
	 *
	 * @return a list of ZSR numbers.
	 */
	public List<String> resolveZsr() {
		return Identifiers.findBySystem(this.getIdentifier(), FhirSystem.ZSR).stream()
				.map(Identifier::getValue)
				.toList();
	}

	/**
	 * Adds a practitioner's ZSR number.
	 *
	 * @param zsr The ZSR number.
	 * @return the created Identifier.
	 */
	public Identifier addZsr(final String zsr) {
		final var identifier = this.addIdentifier();
		identifier.setSystem(FhirSystem.ZSR);
		identifier.setValue(zsr);
		return identifier;
	}
}
