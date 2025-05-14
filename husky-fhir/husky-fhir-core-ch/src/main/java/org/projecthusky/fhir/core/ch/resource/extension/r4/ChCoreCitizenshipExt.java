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
package org.projecthusky.fhir.core.ch.resource.extension.r4;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.BackboneElement;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Element;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.Period;

import ca.uhn.fhir.model.api.annotation.Block;
import ca.uhn.fhir.model.api.annotation.Child;

/**
 * @author <a href="roeland.luykx@raly.ch">Roeland Luykx</a>
 */
@Block
public class ChCoreCitizenshipExt extends BackboneElement {
	/**
	 * Extension for a placeOfBirth.
	 */
	@Nullable
	@Child(name = "code", min = 0, max = 1)
	@ca.uhn.fhir.model.api.annotation.Extension(url = "code", definedLocally = false)
	protected CodeableConcept code;

	/**
	 * Extension for a placeOfBirth.
	 */
	@Nullable
	@Child(name = "period", min = 0, max = 1)
	@ca.uhn.fhir.model.api.annotation.Extension(url = "period", definedLocally = false)
	protected Period period;

	public CodeableConcept getCode() {
		return code;
	}

	public void setCode(CodeableConcept code) {
		this.code = code;
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	@Override
	public BackboneElement copy() {
		final var copy = new ChCoreCitizenshipExt();
		this.copyValues(copy);
		return copy;
	}

	@Override
	public void copyValues(final BackboneElement dst) {
		super.copyValues(dst);
		if (dst instanceof final ChCoreCitizenshipExt als) {
			als.code = code == null ? null : code.copy();
			als.period = period == null ? null : period.copy();
		}
	}

}
