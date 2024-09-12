/**
 * 
 */
package org.projecthusky.fhir.core.ch.resource.r4;

import org.projecthusky.fhir.core.ch.annotation.ExpectsValidResource;
import org.projecthusky.fhir.core.ch.exceptions.InvalidContentException;

import ca.uhn.fhir.model.api.annotation.ResourceDef;

/**
 * The HAPI custom structure for CH-Core Document.
 * 
 * @author <a href="roeland.luykx@raly.ch">Roeland Luykx</a>
 * @param <T>
 */
@ResourceDef(profile = "http://fhir.ch/ig/ch-core/StructureDefinition/ch-core-document")
public class ChCoreDocument extends AbstractDocument {

	public ChCoreDocument() {
		super();
		this.getEntry().add(new BundleEntryComponent().setResource(new ChCoreComposition()));
	}

	/**
	 * Returns the composition or throws.
	 *
	 * @return the composition.
	 * @throws InvalidContentException
	 *             if the composition is missing.
	 */
	@ExpectsValidResource
	public ChCoreComposition resolveComposition() {
		final var entry = this.getEntryByResourceType(ChCoreComposition.class);
		if (entry != null) {
			return entry;
		}
		throw new InvalidContentException(
				"The ChCoreComposition is missing in the document Bundle");
	}

}
