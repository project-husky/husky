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
package org.projecthusky.fhir.core.ch.resource.r4;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.Immunization;
import org.hl7.fhir.r4.model.Reference;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;

/**
 * The HAPI custom structure for CH-Core Immunization.
 * 
 * @author <a href="roeland.luykx@raly.ch">Roeland Luykx</a>
 */
@ResourceDef(profile = "http://fhir.ch/ig/ch-core/StructureDefinition/ch-core-immunization")
public class ChCoreImmunization extends Immunization {

	/**
	 * Extension for a recorder (Patient, RelatedPerson, PractitionerRole).
	 */
	@Nullable
	@Child(name = "recorder", min = 0, max = 1)
	@Extension(url = "http://fhir.ch/ig/ch-core/StructureDefinition/ch-ext-author", definedLocally = false)
	protected Reference recorder;

	public ChCoreImmunization() {
		super();
	}

	public boolean hasRecorder() {
		return recorder != null;
	}

	public Reference getRecorder() {
		return recorder;
	}

	public void setRecorder(Reference recorder) {
		this.recorder = recorder;
	}

	@Override
	public ChCoreImmunization copy() {
		final var copy = new ChCoreImmunization();
		this.copyValues(copy);
		return copy;
	}

	@Override
	public void copyValues(final Immunization dst) {
		super.copyValues(dst);
		if (dst instanceof final ChCoreImmunization als) {
			als.recorder = recorder == null ? null : recorder.copy();
		}
	}

}
