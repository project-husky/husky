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
package org.projecthusky.fhir.vacd.ch.common.resource.extension.r4;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.BackboneElement;
import org.hl7.fhir.r4.model.Coding;

import ca.uhn.fhir.model.api.annotation.Block;
import ca.uhn.fhir.model.api.annotation.Child;

/**
 * 
 */
@Block
public class ChVacdExtensionVerificationStatusExt extends BackboneElement {
	private static final long serialVersionUID = -6962170083806333637L;
	@Nullable
	@Child(name = "valueCoding", min = 0, max = 1)
//	@ca.uhn.fhir.model.api.annotation.Extension(url = "conflict", definedLocally = false)
	protected Coding valueCoding;

	/**
	 * Default Constructor
	 */
	public ChVacdExtensionVerificationStatusExt() {
		valueCoding = new Coding("http://snomed.info/sct", "59156000", "Confirmed");
	}

	@Override
	public ChVacdExtensionVerificationStatusExt copy() {
		final var copy = new ChVacdExtensionVerificationStatusExt();
		this.copyValues(copy);
		return copy;
	}

	@Override
	public void copyValues(BackboneElement dst) {
		super.copyValues(dst);
		if (dst instanceof final ChVacdExtensionVerificationStatusExt als) {
			als.valueCoding = valueCoding == null ? null : valueCoding.copy();
		}
	}

	public Coding getValueCoding() {
		return valueCoding;
	}

	public void setValueCoding(Coding valueCoding) {
		this.valueCoding = valueCoding;
	}
}
