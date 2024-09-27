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
 * The HAPI custom structure for CH-VACD VaccinationRecordDocument.
 * 
 * @author <a href="roeland.luykx@raly.ch">Roeland Luykx</a>
 */
@ResourceDef(profile = "http://fhir.ch/ig/ch-vacd/StructureDefinition/ch-vacd-document-vaccination-record")
public class ChVacdVaccinationRecordDocument extends ChVacdAbstractDocument {

	private static final long serialVersionUID = 6984812668517079767L;

	public ChVacdVaccinationRecordDocument() {
		super();
		ChVacdVaccinationRecordComposition composition = new ChVacdVaccinationRecordComposition();
		composition.setId(UUID.randomUUID().toString());
		composition.setStatus(CompositionStatus.FINAL);
		composition.setDate(getTimestamp());

		this.getEntry().add(new BundleEntryComponent().setResource(composition)
				.setFullUrl("urn:uuid:" + composition.getId()));
	}

	/**
	 * Returns the composition or throws.
	 *
	 * @return the composition.
	 * @throws InvalidContentException
	 *             if the composition is missing.
	 */
	@ExpectsValidResource
	public ChVacdVaccinationRecordComposition resolveComposition() {
		final var entry = this.getEntryByResourceType(ChVacdVaccinationRecordComposition.class);
		if (entry != null) {
			return entry;
		}
		throw new InvalidContentException(
				"The ChVacdVaccinationRecordComposition is missing in the document Bundle");
	}

}
