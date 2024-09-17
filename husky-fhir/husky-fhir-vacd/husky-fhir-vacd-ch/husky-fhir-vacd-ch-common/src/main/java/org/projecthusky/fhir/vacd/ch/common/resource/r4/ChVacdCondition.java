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

import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.fhir.core.ch.datatype.r4.CHCoreAddressEch11PlaceOfBirth;
import org.projecthusky.fhir.core.ch.resource.extension.r4.ChCoreResourceCrossReferenceExt;
import org.projecthusky.fhir.core.ch.resource.r4.ChCoreCondition;
import org.projecthusky.fhir.vacd.ch.common.resource.extension.r4.ChVacdExtMergingConflict;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;

/**
 * 
 */
@ResourceDef(profile = "http://fhir.ch/ig/ch-vacd/StructureDefinition/ch-vacd-condition")
public class ChVacdCondition extends ChCoreCondition {

	@Nullable
	@Child(name = "relatesTo", min = 0, max = 1)
	@Extension(url = "http://fhir.ch/ig/ch-core/StructureDefinition/ch-core-ext-entry-resource-cross-references", definedLocally = false)
	protected ChCoreResourceCrossReferenceExt relatesTo;

	@Nullable
	@Child(name = "conflict", min = 0, max = 1)
	@Extension(url = "http://fhir.ch/ig/ch-vacd/StructureDefinition/ch-vacd-ext-merging-conflict-entry-reference", definedLocally = false)
	protected ChVacdExtMergingConflict conflict;

	public ChCoreResourceCrossReferenceExt getRelatesTo() {
		return relatesTo;
	}

	public void setRelatesTo(ChCoreResourceCrossReferenceExt relatesTo) {
		this.relatesTo = relatesTo;
	}

	public ChVacdExtMergingConflict getConflict() {
		return conflict;
	}

	public void setConflict(ChVacdExtMergingConflict conflict) {
		this.conflict = conflict;
	}
	
	

}
