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
package org.projecthusky.fhir.vacd.ch.common.resource.r4;

import java.util.UUID;

import org.hl7.fhir.r4.model.Composition.CompositionStatus;
import org.projecthusky.fhir.core.ch.annotation.ExpectsValidResource;
import org.projecthusky.fhir.core.ch.exceptions.InvalidContentException;

import ca.uhn.fhir.model.api.annotation.ResourceDef;

/**
 * The HAPI custom structure for CH-VACD ImmunizationAdministrationDocument.
 * 
 * @author <a href="roeland.luykx@raly.ch">Roeland Luykx</a>
 */
@ResourceDef(profile = "http://fhir.ch/ig/ch-vacd/StructureDefinition/ch-vacd-document-immunization-administration")
public class ChVacdImmunizationAdministrationDocument extends ChVacdAbstractDocument {

	private static final long serialVersionUID = -5008469947339799878L;

	public ChVacdImmunizationAdministrationDocument() {
		super();
//		ChVacdImmunizationAdministrationComposition composition = new ChVacdImmunizationAdministrationComposition();
//		composition.setId(UUID.randomUUID().toString());
//
//		this.getEntry().add(new BundleEntryComponent().setResource(composition)
//				.setFullUrl("urn:uuid:" + composition.getId()));
	}

	/**
	 * Returns the composition or throws.
	 *
	 * @return the composition.
	 * @throws InvalidContentException
	 *             if the composition is missing.
	 */
	@ExpectsValidResource
	public ChVacdImmunizationAdministrationComposition resolveComposition() {
		final var entry = this
				.getEntryByResourceType(ChVacdImmunizationAdministrationComposition.class);
		if (entry != null) {
			return entry;
		}else {
			ChVacdImmunizationAdministrationComposition composition = new ChVacdImmunizationAdministrationComposition();
			composition.setId(UUID.randomUUID().toString());

			this.getEntry().add(new BundleEntryComponent().setResource(composition)
					.setFullUrl("urn:uuid:" + composition.getId()));
			return composition;
		}
//		throw new InvalidContentException(
//				"The ChVacdImmunizationAdministrationComposition is missing in the document Bundle");
	}

}
