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
import org.hl7.fhir.r4.model.CodeType;
import org.hl7.fhir.r4.model.Reference;

import ca.uhn.fhir.model.api.annotation.Block;
import ca.uhn.fhir.model.api.annotation.Child;

/**
 * @author <a href="roeland.luykx@raly.ch">Roeland Luykx</a>
 */
@Block
public class ChCoreResourceCrossReferenceExt extends BackboneElement {

	@Nullable
	@Child(name = "entry", min = 0, max = 1)
	@ca.uhn.fhir.model.api.annotation.Extension(url = "entry", definedLocally = false)
	protected Reference entry;

	@Nullable
	@Child(name = "container", min = 0, max = 1)
	@ca.uhn.fhir.model.api.annotation.Extension(url = "container", definedLocally = false)
	protected Reference container;

	@Nullable
	@Child(name = "relationcode", min = 0, max = 1)
	@ca.uhn.fhir.model.api.annotation.Extension(url = "relationcode", definedLocally = false)
	protected CodeType relationcode;

	public Reference getEntry() {
		return entry;
	}

	public void setEntry(Reference entry) {
		this.entry = entry;
	}

	public Reference getContainer() {
		return container;
	}

	public void setContainer(Reference container) {
		this.container = container;
	}

	public CodeType getRelationcode() {
		return relationcode;
	}

	public void setRelationcode(CodeType relationcode) {
		this.relationcode = relationcode;
	}

	@Override
	public ChCoreResourceCrossReferenceExt copy() {
		final var copy = new ChCoreResourceCrossReferenceExt();
		this.copyValues(copy);
		return copy;
	}

	@Override
	public void copyValues(BackboneElement dst) {
		super.copyValues(dst);
		if (dst instanceof final ChCoreResourceCrossReferenceExt copy) {
			copy.entry = entry == null ? null : entry.copy();
			copy.container = container == null ? null : container.copy();
			copy.relationcode = relationcode == null ? null : relationcode.copy();
		}
	}

}
