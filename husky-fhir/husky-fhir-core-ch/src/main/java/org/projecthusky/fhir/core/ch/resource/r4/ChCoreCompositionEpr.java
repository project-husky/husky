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
import org.hl7.fhir.r4.model.Reference;
import org.projecthusky.fhir.core.ch.resource.extension.r4.ChExtEprDataEnterer;

import java.util.ArrayList;
import java.util.List;

/**
 * The HAPI custom structure for CH-Core Composition.
 * 
 * @author <a href="roeland.luykx@raly.ch">Roeland Luykx</a>
 */
@ResourceDef(profile = "http://fhir.ch/ig/ch-core/StructureDefinition/ch-core-composition-epr")
public class ChCoreCompositionEpr extends ChCoreComposition {
	private static final long serialVersionUID = 6290265510559327928L;

	/**
	 * Extension for a list of recipients of this document (corresponds to the addressee of a letter - person or
	 * organization), equivalent to CDA informationRecipient.
	 */
	@Nullable
	@Child(name = "informationRecipient", min = 1, max = Child.MAX_UNLIMITED)
	@Extension(url = "http://fhir.ch/ig/ch-core/StructureDefinition/ch-ext-epr-informationrecipient", definedLocally = false)
	protected List<Reference> informationRecipient;

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
	 * Gets the list of recipients of this document.
	 *
	 * @return the list of recipients of this document.
	 */
	public List<Reference> getInformationRecipient() {
		if (this.informationRecipient == null) {
			this.informationRecipient = new ArrayList<>(0);
		}
		return this.informationRecipient;
	}

	/**
	 * Sets list of recipients of this document.
	 *
	 * @param informationRecipient the list of recipients of this document.
	 * @return this.
	 */
	public ChCoreComposition setInformationRecipient(final List<Reference> informationRecipient) {
		this.informationRecipient = informationRecipient;
		return this;
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
