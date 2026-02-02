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

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.fhir.core.ch.resource.extension.r4.ChExtEprDataEnterer;

/**
 * The HAPI custom structure for CH-Core Composition.
 * 
 * @author <a href="roeland.luykx@raly.ch">Roeland Luykx</a>
 */
@ResourceDef(profile = "http://fhir.ch/ig/ch-core/StructureDefinition/ch-core-composition-epr")
public class ChCoreCompositionEpr extends ChCoreComposition {
	private static final long serialVersionUID = 6290265510559327928L;

	/**
	 * Person who entered information into this document if it is a person other than the author.
	 */
	@Nullable
	@Child(name = "dataEnterer")
	@Extension(url = "http://fhir.ch/ig/ch-core/StructureDefinition/ch-ext-epr-dataenterer", definedLocally = false)
	protected ChExtEprDataEnterer dataEnterer;

	public ChCoreCompositionEpr() {
		super();
		setLanguage("de-CH");
	}

	/**
	 * Gets the person who entered information into this document.
	 *
	 * @return the person who entered information into this document.
	 */
	public ChExtEprDataEnterer getDataEnterer() {
		if (this.dataEnterer == null) {
			this.dataEnterer = new ChExtEprDataEnterer();
		}
		return dataEnterer;
	}

	/**
	 * Sets the person who entered information into this document.
	 *
	 * @param dataEnterer the person who entered information into this document.
	 * @return this.
	 */
	public ChCoreComposition setDataEnterer(final ChExtEprDataEnterer dataEnterer) {
		this.dataEnterer = dataEnterer;
		return this;
	}
}
