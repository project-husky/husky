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
import org.hl7.fhir.r4.model.CodeType;
import org.hl7.fhir.r4.model.Reference;
import org.projecthusky.fhir.core.ch.resource.extension.r4.ChCoreResourceCrossReferenceExt;

import ca.uhn.fhir.model.api.annotation.Block;
import ca.uhn.fhir.model.api.annotation.Child;

/**
 * 
 */
@Block
public class ChVacdExtMergingConflict extends BackboneElement {

	@Nullable
	@Child(name = "entry", min = 0, max = 1)
	@ca.uhn.fhir.model.api.annotation.Extension(url = "entry", definedLocally = false)
	protected Reference entry;
	
	@Nullable
	@Child(name = "conflict", min = 0, max = 1)
	@ca.uhn.fhir.model.api.annotation.Extension(url = "conflict", definedLocally = false)
	protected CodeType conflict;


	public Reference getEntry() {
		return entry;
	}


	public void setEntry(Reference entry) {
		this.entry = entry;
	}


	public CodeType getConflict() {
		return conflict;
	}


	public void setConflict(CodeType conflict) {
		this.conflict = conflict;
	}


	@Override
	public BackboneElement copy() {
		final var copy = new ChCoreResourceCrossReferenceExt();
		this.copyValues(copy);
		return copy;
	}

	@Override
	public void copyValues(BackboneElement dst) {
		super.copyValues(dst);
		if (dst instanceof final ChVacdExtMergingConflict als) {
			als.entry = entry == null ? null : entry.copy();
			als.conflict = conflict == null ? null : conflict.copy();
		}
	}
}
