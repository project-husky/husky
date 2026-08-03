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

import java.util.List;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Immunization;
import org.hl7.fhir.r4.model.Reference;
import org.projecthusky.fhir.core.ch.resource.extension.r4.ChCoreResourceCrossReferenceExt;
import org.projecthusky.fhir.core.ch.resource.r4.ChCoreImmunization;
import org.projecthusky.fhir.vacd.ch.common.resource.extension.r4.ChVacdMergingConflictExt;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;

/**
 * The HAPI custom structure for CH-VACD Immunization.
 * 
 * @author <a href="roeland.luykx@raly.ch">Roeland Luykx</a>
 */
@ResourceDef(profile = "http://fhir.ch/ig/ch-vacd/StructureDefinition/ch-vacd-immunization", id = "ch-vacd-immunization")
public class ChVacdImmunization extends ChCoreImmunization {

	private static final long serialVersionUID = 6995187686545492514L;

	@Nullable
	@Child(name = "relatesTo", min = 0, max = 1)
	@Extension(url = "http://fhir.ch/ig/ch-core/StructureDefinition/ch-core-ext-entry-resource-cross-references", definedLocally = false)
	protected ChCoreResourceCrossReferenceExt relatesTo;

	@Nullable
	@Child(name = "medication", min = 0, max = 1)
	@Extension(url = "http://fhir.ch/ig/ch-vacd/StructureDefinition/ch-vacd-ext-immunization-medication-reference", definedLocally = false)
	protected Reference medication;

	@Nullable
	@Child(name = "conflict", min = 0, max = Child.MAX_UNLIMITED)
	@Extension(url = "http://fhir.ch/ig/ch-vacd/StructureDefinition/ch-vacd-ext-merging-conflict-entry-reference", definedLocally = false)
	protected List<ChVacdMergingConflictExt> conflict;

	@Nullable
	@Child(name = "verificationStatus", min = 1, max = 1)
	@Extension(url = "http://fhir.ch/ig/ch-vacd/StructureDefinition/ch-vacd-ext-verification-status", definedLocally = false)
	protected Coding verificationStatus;

	public ChVacdImmunization() {
		setStatus(ImmunizationStatus.COMPLETED);
	}

	public boolean hasRelatesTo() {
		return this.relatesTo != null && !this.relatesTo.isEmpty();
	}

	public ChCoreResourceCrossReferenceExt getRelatesTo() {
		return relatesTo;
	}

	public ChVacdImmunization setRelatesTo(ChCoreResourceCrossReferenceExt relatesTo) {
		this.relatesTo = relatesTo;
		return this;
	}

	public boolean hasConflict() {
		return this.conflict != null && !this.conflict.isEmpty();
	}

	public List<ChVacdMergingConflictExt> getConflict() {
		if (this.conflict == null) {
			this.conflict = new java.util.ArrayList<>();
		}
		return conflict;
	}

	public ChVacdImmunization setConflict(List<ChVacdMergingConflictExt> conflicts) {
		this.conflict = conflicts;
		return this;
	}

	public ChVacdImmunization addConflict(ChVacdMergingConflictExt conflict) {
		this.getConflict().add(conflict);
		return this;
	}

	public ChVacdMergingConflictExt addConflict() {
		ChVacdMergingConflictExt conflict = new ChVacdMergingConflictExt();
		this.getConflict().add(conflict);
		return conflict;
	}

	public void removeConflict(ChVacdMergingConflictExt conflict) {
		this.getConflict().remove(conflict);
	}

	public boolean hasMedication() {
		return this.medication != null && !this.medication.isEmpty();
	}

	public ChVacdMedicationForImmunization getMedication() {
		if (hasMedication()) {
			return (ChVacdMedicationForImmunization) medication.getResource();
		}
		return null;
	}

	public ChVacdImmunization setMedication(ChVacdMedicationForImmunization medication) {
		this.medication = new Reference(medication);
		return this;
	}

	public boolean hasVerificationStatus() {
		return this.verificationStatus != null && !this.verificationStatus.isEmpty();
	}

	public Coding getVerificationStatu() {
		if (verificationStatus == null) {
			verificationStatus = new Coding("http://snomed.info/sct", "59156000", "Confirmed");
		}
		return verificationStatus;
	}

	public ChVacdImmunization setVerificationStatus(Coding verificationStatus) {
		this.verificationStatus = verificationStatus;
		return this;
	}

	@Override
	public ChVacdImmunization copy() {
		final var copy = new ChVacdImmunization();
		this.copyValues(copy);
		return copy;
	}

	@Override
	public void copyValues(final Immunization dst) {
		super.copyValues(dst);
		if (dst instanceof final ChVacdImmunization als) {
			als.relatesTo = relatesTo == null ? null : relatesTo.copy();
			if (conflict != null) {
				als.conflict = new java.util.ArrayList<>();
				for (final ChVacdMergingConflictExt conflict : conflict) {
					als.conflict.add(conflict.copy());
				}
			}
			als.medication = medication == null ? null : medication.copy();
			als.verificationStatus = verificationStatus == null ? null : verificationStatus.copy();
		}
	}

}
