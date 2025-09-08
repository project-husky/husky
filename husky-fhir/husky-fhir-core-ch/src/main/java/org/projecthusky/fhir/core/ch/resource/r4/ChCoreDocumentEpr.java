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

import org.hl7.fhir.r4.model.Composition;
import org.projecthusky.fhir.core.ch.annotation.ExpectsValidResource;
import org.projecthusky.fhir.core.ch.exceptions.InvalidContentException;

import ca.uhn.fhir.model.api.annotation.ResourceDef;

import java.io.Serial;

/**
 * The HAPI custom structure for CH-Core Document.
 * 
 * @author <a href="roeland.luykx@raly.ch">Roeland Luykx</a>
 */
@ResourceDef(profile = "http://fhir.ch/ig/ch-core/StructureDefinition/ch-core-document-epr")
public class ChCoreDocumentEpr  extends ChCoreDocument {

	@Serial
	private static final long serialVersionUID = -2385277944968532844L;

	public ChCoreDocumentEpr() {
		super();
	}

	/**
	 * Creates a composition resource and adds it to the document.
	 * @return The composition resource.
	 * @throws InvalidContentException if the document contains a composition already.
	 */
	@Override
	public ChCoreCompositionEpr addComposition() throws InvalidContentException {
		final var composition = new ChCoreCompositionEpr();
		return addComposition(composition);
	}

	/**
	 * Adds a composition to the document.
	 * @param composition The composition to be added to the document.
	 * @return The composition.
	 * @throws InvalidContentException if the document already contains a composition.
	 */
	public ChCoreCompositionEpr addComposition(final ChCoreCompositionEpr composition) throws InvalidContentException {
		if (this.getEntryComponentByResourceType(Composition.class) != null)
			throw new InvalidContentException("The document already contains a composition.");
		this.getEntry().add(new BundleEntryComponent().setResource(composition));
		return composition;
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
