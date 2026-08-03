package org.projecthusky.fhir.vacd.ch.common.resource.r4;

import ca.uhn.fhir.model.api.annotation.ResourceDef;

@ResourceDef(profile = "http://fhir.ch/ig/ch-vacd/StructureDefinition/ch-vacd-recommendation-response-messageheader")
public class ChVacdRecommendationResponseMessageHeader extends ChVacdAbstractMessageHeader {

	private static final long serialVersionUID = 1L;

	public ChVacdRecommendationResponseMessageHeader() {
		super();
	}

}
