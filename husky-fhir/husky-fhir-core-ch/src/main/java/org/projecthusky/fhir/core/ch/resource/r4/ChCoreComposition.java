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

import java.util.Optional;

import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Composition;

import ca.uhn.fhir.model.api.annotation.ResourceDef;

/**
 * The HAPI custom structure for CH-Core Composition.
 * 
 * @author <a href="roeland.luykx@raly.ch">Roeland Luykx</a>
 */
@ResourceDef(profile = "http://fhir.ch/ig/ch-core/StructureDefinition/ch-core-immunization")
public class ChCoreComposition extends Composition {

	private static final long serialVersionUID = -5411389020203169082L;

	public Optional<SectionComponent> resolveSectionByCode(Coding code) {
		return this.getSection().stream()
				.filter(section -> section.getCode().getCoding().stream()
						.anyMatch(coding -> (code.getSystem().equals(coding.getSystem())
								&& code.getCode().equals(coding.getCode()))))
				.findFirst();
	}

}
