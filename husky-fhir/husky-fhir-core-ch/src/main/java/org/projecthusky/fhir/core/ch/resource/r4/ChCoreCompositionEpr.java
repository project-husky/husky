/**
 * 
 */
package org.projecthusky.fhir.core.ch.resource.r4;

import ca.uhn.fhir.model.api.annotation.ResourceDef;

/**
 * The HAPI custom structure for CH-Core Composition.
 * 
 * @author <a href="roeland.luykx@raly.ch">Roeland Luykx</a>
 */
@ResourceDef(profile = "http://fhir.ch/ig/ch-core/StructureDefinition/ch-core-composition-epr")
public class ChCoreCompositionEpr extends ChCoreComposition {

	
	public ChCoreCompositionEpr() {
		super();
		setLanguage("de-CH");
	}
	
}
