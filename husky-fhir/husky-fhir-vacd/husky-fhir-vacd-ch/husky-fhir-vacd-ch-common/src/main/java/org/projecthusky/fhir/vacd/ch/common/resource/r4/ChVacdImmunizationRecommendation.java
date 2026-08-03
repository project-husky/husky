package org.projecthusky.fhir.vacd.ch.common.resource.r4;

import org.hl7.fhir.r4.model.ImmunizationRecommendation;
import org.projecthusky.fhir.core.ch.resource.r4.ChCoreImmunizationRecommendation;

public class ChVacdImmunizationRecommendation extends ChCoreImmunizationRecommendation {

	private static final long serialVersionUID = 6775247442297255105L;

	public ChVacdImmunizationRecommendation() {
		super();
	}

	@Override
	public ChVacdImmunizationRecommendation copy() {
		final var copy = new ChVacdImmunizationRecommendation();
		this.copyValues(copy);
		return copy;
	}

	@Override
	public void copyValues(final ImmunizationRecommendation dst) {
		super.copyValues(dst);

	}

}
