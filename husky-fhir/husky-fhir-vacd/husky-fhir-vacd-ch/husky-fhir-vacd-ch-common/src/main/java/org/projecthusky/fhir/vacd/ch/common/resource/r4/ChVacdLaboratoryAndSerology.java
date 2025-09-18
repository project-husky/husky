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
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Reference;
import org.projecthusky.fhir.core.ch.resource.extension.r4.ChCoreResourceCrossReferenceExt;
import org.projecthusky.fhir.vacd.ch.common.resource.extension.r4.ChVacdExtensionVerificationStatusExt;
import org.projecthusky.fhir.vacd.ch.common.resource.extension.r4.ChVacdMergingConflictExt;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;

/**
 * The HAPI custom structure for CH-VACD LaboratoryAndSerology.
 * 
 * @author <a href="roeland.luykx@raly.ch">Roeland Luykx</a>
 */
@ResourceDef(profile = "http://fhir.ch/ig/ch-vacd/StructureDefinition/ch-vacd-laboratory-serology")
public class ChVacdLaboratoryAndSerology extends Observation {

	private static final long serialVersionUID = -5282679759940081789L;

	@Nullable
	@Child(name = "recorder", min = 0, max = 1)
	@Extension(url = "http://fhir.ch/ig/ch-core/StructureDefinition/ch-ext-author", definedLocally = false)
	protected Reference recorder;

	@Nullable
	@Child(name = "relatesTo", min = 0, max = 1)
	@Extension(url = "http://fhir.ch/ig/ch-core/StructureDefinition/ch-core-ext-entry-resource-cross-references", definedLocally = false)
	protected ChCoreResourceCrossReferenceExt relatesTo;

	@Nullable
	@Child(name = "conflict", min = 0, max = 1)
	@Extension(url = "http://fhir.ch/ig/ch-vacd/StructureDefinition/ch-vacd-ext-merging-conflict-entry-reference", definedLocally = false)
	protected ChVacdMergingConflictExt conflict;

	@Nullable
	@Child(name = "verificationStatus", min = 0, max = 1)
	@Extension(url = "http://fhir.ch/ig/ch-vacd/StructureDefinition/ch-vacd-ext-verification-status", definedLocally = false)
	protected Coding verificationStatus;

	public ChVacdLaboratoryAndSerology() {
		addIdentifier().setSystem("urn:ietf:rfc:3986").setValue("urn:uuid:" + UUID.randomUUID().toString());
//		setVerificationStatus(new ChVacdExtensionVerificationStatusExt());
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

	public ChCoreResourceCrossReferenceExt getRelatesTo() {
		return relatesTo;
	}

	public void setRelatesTo(ChCoreResourceCrossReferenceExt relatesTo) {
		this.relatesTo = relatesTo;
	}

	public Coding getVerificationStatus() {
		if (verificationStatus == null) {
			verificationStatus = new Coding("http://snomed.info/sct", "59156000", "Confirmed");
		}
		return verificationStatus;
	}

	public void setVerificationStatus(Coding verificationStatus) {
		this.verificationStatus = verificationStatus;
	}

	public boolean hasVerificationStatus() {
		return this.verificationStatus != null && !this.verificationStatus.isEmpty();
	}

	@Override
	public ChVacdLaboratoryAndSerology copy() {
		final var copy = new ChVacdLaboratoryAndSerology();
		this.copyValues(copy);
		return copy;
	}

	@Override
	public void copyValues(final Observation dst) {
		super.copyValues(dst);
		if (dst instanceof final ChVacdLaboratoryAndSerology als) {
			als.recorder = recorder == null ? null : recorder.copy();
			als.relatesTo = relatesTo == null ? null : relatesTo.copy();
			als.verificationStatus = verificationStatus == null ? null : verificationStatus.copy();
		}
	}
}
