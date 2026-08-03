package org.projecthusky.fhir.vacd.ch.common.resource.r4;

import org.hl7.fhir.r4.model.Coding;

import ca.uhn.fhir.model.api.annotation.ResourceDef;

@ResourceDef(profile = "http://fhir.ch/ig/ch-vacd/StructureDefinition/ch-vacd-recommendation-request-messageheader")
public class ChVacdRecommendationRequestMessageHeader extends ChVacdAbstractMessageHeader {

	private static final long serialVersionUID = 1L;

	public ChVacdRecommendationRequestMessageHeader() {
		super();
		setEvent(new Coding().setSystem(
				"http://fhir.ch/ig/ch-vacd/CodeSystem/ch-vacd-clinical-decision-support-event-cs")
				.setCode("immunrecorequest").setDisplay("Immunization Recommendation Request"));

	}

}
