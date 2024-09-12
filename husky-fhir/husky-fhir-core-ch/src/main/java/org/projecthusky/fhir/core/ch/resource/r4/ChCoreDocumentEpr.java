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
 */
@ResourceDef(profile = "http://fhir.ch/ig/ch-core/StructureDefinition/ch-core-document-epr")
public class ChCoreDocumentEpr  extends AbstractDocument {

	public ChCoreDocumentEpr() {
		super();
		this.getEntry().add(new BundleEntryComponent().setResource(new ChCoreCompositionEpr()));
	}

	/**
	 * Returns the composition or throws.
	 *
	 * @return the composition.
	 * @throws InvalidContentException
	 *             if the composition is missing.
	 */
	@ExpectsValidResource
	public ChCoreCompositionEpr resolveComposition() {
		final var entry = this.getEntryByResourceType(ChCoreCompositionEpr.class);
		if (entry != null) {
			return entry;
		}
		throw new InvalidContentException(
				"The ChCoreCompositionEpr is missing in the document Bundle");
	}
}
