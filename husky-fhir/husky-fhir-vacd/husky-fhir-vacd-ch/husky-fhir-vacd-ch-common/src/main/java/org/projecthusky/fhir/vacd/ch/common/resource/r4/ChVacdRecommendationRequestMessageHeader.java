package org.projecthusky.fhir.vacd.ch.common.resource.r4;

import ca.uhn.fhir.model.api.annotation.ResourceDef;

@ResourceDef(profile = "http://fhir.ch/ig/ch-vacd/StructureDefinition/ch-vacd-recommendation-request-messageheader")
public class ChVacdRecommendationRequestMessageHeader extends ChVacdAbstractMessageHeader {

	private static final long serialVersionUID = 1L;

	public ChVacdRecommendationRequestMessageHeader() {
		super();
		this.setId("urn:uuid:" + this.getId());
		
	}

}
