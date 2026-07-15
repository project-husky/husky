package org.projecthusky.fhir.core.ch.resource.r4;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.ImmunizationRecommendation;
import org.hl7.fhir.r4.model.StringType;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Extension;

public class ChCoreImmunizationRecommendation extends ImmunizationRecommendation {

	private static final long serialVersionUID = 929758367577498974L;

	@Nullable
	@Child(name = "indicationCode", min = 0, max = 1)
	@Extension(url = "http://fhir.ch/ig/ch-core/StructureDefinition/ch-ext-epl-regulated-authorization-limitation-indication-code", definedLocally = false)
	protected StringType indicationCode;

	public ChCoreImmunizationRecommendation() {
		super();
	}

	public boolean hasIndicationCode() {
		return indicationCode != null;
	}

	public StringType getIndicationCode() {
		return indicationCode;
	}

	public void setIndicationCode(StringType indicationCode) {
		this.indicationCode = indicationCode;
	}

	@Override
	public ChCoreImmunizationRecommendation copy() {
		final var copy = new ChCoreImmunizationRecommendation();
		this.copyValues(copy);
		return copy;
	}

	@Override
	public void copyValues(final ImmunizationRecommendation dst) {
		super.copyValues(dst);
		if (dst instanceof final ChCoreImmunizationRecommendation als) {
			als.indicationCode = indicationCode;
		}
	}

}
