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

import java.util.List;
import java.util.UUID;

import org.hl7.fhir.r4.model.Composition.CompositionStatus;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Reference;
import org.projecthusky.fhir.core.ch.annotation.ExpectsValidResource;
import org.projecthusky.fhir.core.ch.exceptions.InvalidContentException;
import org.projecthusky.fhir.core.ch.resource.r4.ChCoreDocumentEpr;

import ca.uhn.fhir.model.api.annotation.ResourceDef;

/**
 * 
 */
@ResourceDef(profile = "http://fhir.ch/ig/ch-vacd/StructureDefinition/ch-vacd-document-immunization-administration")
public class ChVacdImmunizationAdministrationDocument extends ChCoreDocumentEpr {

	public ChVacdImmunizationAdministrationDocument() {
		super();

		ChVacdImmunizationAdministrationComposition composition = new ChVacdImmunizationAdministrationComposition();
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
	public ChVacdImmunizationAdministrationComposition resolveComposition() {
		final var entry = this
				.getEntryByResourceType(ChVacdImmunizationAdministrationComposition.class);
		if (entry != null) {
			return entry;
		}
		throw new InvalidContentException(
				"The ChVacdImmunizationAdministrationComposition is missing in the document Bundle");
	}

	public void addImmunization(ChVacdImmunization immunization) {
		if(this.resolveComposition().hasSubject()) {
			immunization.setPatient(this.resolveComposition().getSubject());
		}
		
		this.getEntry().add(new BundleEntryComponent().setResource(immunization)
				.setFullUrl("urn:uuid:" + immunization.getId()));
		this.resolveComposition().resolveAdministrationSection()
				.addEntry(new Reference(immunization));
	}

	public List<ChVacdImmunization> resolveImmunizations() {
		return this.getEntryResourceByResourceType(ChVacdImmunization.class);
	}

	public void setPatient(Patient testPatient) {
		this.getEntry().add(new BundleEntryComponent().setResource(testPatient)
				.setFullUrl("urn:uuid:" + testPatient.getId()));
		this.resolveComposition().setSubject(new Reference(testPatient));
	}

}
