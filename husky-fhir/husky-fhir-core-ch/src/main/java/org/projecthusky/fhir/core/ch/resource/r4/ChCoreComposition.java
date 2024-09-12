/**
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

	public Optional<SectionComponent> resolveSectionByCode(Coding code) {
		return this.getSection().stream()
				.filter(section -> section.getCode().getCoding().stream()
						.anyMatch(coding -> (code.getSystem().equals(coding.getSystem())
								&& code.getCode().equals(coding.getCode()))))
				.findFirst();
	}

}
