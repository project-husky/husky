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

import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Reference;

import ca.uhn.fhir.model.api.annotation.ResourceDef;

/**
 * 
 */
@ResourceDef(profile = "http://fhir.ch/ig/ch-vacd/StructureDefinition/ch-vacd-recommendation-response-message")
public class ChVacdRecommendationResponseMessage extends ChVacdAbstractMessage {

	private static final long serialVersionUID = -4534977400325685315L;

	@Override
	public ChVacdRecommendationResponseMessageHeader resolveMessageHeader() {
		final var entry = this
				.getEntryByResourceType(ChVacdRecommendationResponseMessageHeader.class);
		if (entry != null) {
			return entry;
		} else {
			ChVacdRecommendationResponseMessageHeader messageHeader = new ChVacdRecommendationResponseMessageHeader();
			messageHeader.setId(UUID.randomUUID().toString());
			messageHeader.setEvent(new Coding().setSystem(
					"http://fhir.ch/ig/ch-vacd/CodeSystem/ch-vacd-clinical-decision-support-event-cs")
					.setCode("immunrecoresponse")
					.setDisplay("Immunization Recommendation Response"));

			this.getEntry().add(new BundleEntryComponent().setResource(messageHeader)
					.setFullUrl("urn:uuid:" + messageHeader.getId()));
			return messageHeader;
		}
	}

	/**
	 * Adds an immunization to the document.
	 * 
	 * @param immunization
	 *            the immunization to add.
	 */
	public void addImmunizationRecommendation(ChVacdImmunizationRecommendation immunization) {
		if (this.hasPatient()) {
			immunization.setPatient(new Reference(this.resolvePatient()));
		}

		if (immunization.getId() == null) {
			immunization.setId(UUID.randomUUID().toString());
		}

		if (immunization.getId().startsWith("urn:uuid:")) {
			this.getEntry().add(new BundleEntryComponent().setResource(immunization)
					.setFullUrl(immunization.getId()));
			this.resolveMessageHeader().addFocus(new Reference(immunization.getId()));
		} else {
			this.getEntry().add(new BundleEntryComponent().setResource(immunization)
					.setFullUrl("urn:uuid:" + immunization.getId()));
			this.resolveMessageHeader().addFocus(new Reference("urn:uuid:" + immunization.getId()));
		}
	}

	/**
	 * Adds an immunization to the document.
	 * 
	 * @return the created immunization resource.
	 */
	public ChVacdImmunizationRecommendation addImmunizationRecommendation() {
		ChVacdImmunizationRecommendation immunization = new ChVacdImmunizationRecommendation();
		immunization.setId(UUID.randomUUID().toString());
		addImmunizationRecommendation(immunization);
		return immunization;
	}

	/**
	 * get all immunization resources from the document.
	 * 
	 * @return list of immunization resources.
	 */
	public List<ChVacdImmunizationRecommendation> resolveImmunizationRecommendations() {
		return this.getEntryResourceByResourceType(ChVacdImmunizationRecommendation.class);
	}

}
