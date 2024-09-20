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

import java.util.UUID;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.Condition;
import org.projecthusky.fhir.core.ch.resource.extension.r4.ChCoreResourceCrossReferenceExt;
import org.projecthusky.fhir.core.ch.resource.r4.ChCoreCondition;
import org.projecthusky.fhir.vacd.ch.common.resource.extension.r4.ChVacdMergingConflictExt;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;

/**
 * The HAPI custom structure for CH-VACD Condition.
 * 
 * @author <a href="roeland.luykx@raly.ch">Roeland Luykx</a>
 */
@ResourceDef(profile = "http://fhir.ch/ig/ch-vacd/StructureDefinition/ch-vacd-condition")
public class ChVacdCondition extends ChCoreCondition {

	private static final long serialVersionUID = -3030953292200998968L;

	@Nullable
	@Child(name = "relatesTo", min = 0, max = 1)
	@Extension(url = "http://fhir.ch/ig/ch-core/StructureDefinition/ch-core-ext-entry-resource-cross-references", definedLocally = false)
	protected ChCoreResourceCrossReferenceExt relatesTo;

	@Nullable
	@Child(name = "conflict", min = 0, max = 1)
	@Extension(url = "http://fhir.ch/ig/ch-vacd/StructureDefinition/ch-vacd-ext-merging-conflict-entry-reference", definedLocally = false)
	protected ChVacdMergingConflictExt conflict;

	public ChVacdCondition() {
		addIdentifier().setSystem("urn:ietf:rfc:3986")
				.setValue("urn:uuid:" + UUID.randomUUID().toString());
	}

	public ChCoreResourceCrossReferenceExt getRelatesTo() {
		return relatesTo;
	}

	public void setRelatesTo(ChCoreResourceCrossReferenceExt relatesTo) {
		this.relatesTo = relatesTo;
	}

	public ChVacdMergingConflictExt getConflict() {
		return conflict;
	}

	public void setConflict(ChVacdMergingConflictExt conflict) {
		this.conflict = conflict;
	}

	@Override
	public ChVacdCondition copy() {
		final var copy = new ChVacdCondition();
		this.copyValues(copy);
		return copy;
	}

	@Override
	public void copyValues(Condition dst) {
		super.copyValues(dst);
		if (dst instanceof final ChVacdCondition als) {
			als.relatesTo = relatesTo == null ? null : relatesTo.copy();
			als.conflict = conflict == null ? null : conflict.copy();
		}
	}

}
