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

import java.util.List;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Patient;
import org.projecthusky.fhir.core.ch.datatype.r4.CHCoreAddressECH11PlaceOfOrigin;
import org.projecthusky.fhir.core.ch.datatype.r4.CHCoreAddressEch11PlaceOfBirth;
import org.projecthusky.fhir.core.ch.resource.extension.r4.ChCoreCitizenshipExt;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;

/**
 * The HAPI custom structure for CH-Core patient.
 * 
 * @author <a href="roeland.luykx@raly.ch">Roeland Luykx</a>
 */
@ResourceDef(profile = "http://fhir.ch/ig/ch-core/StructureDefinition/ch-core-patient")
public class ChCorePatient extends Patient {

	/**
	 * Extension for a placeOfBirth.
	 */
	@Nullable
	@Child(name = "placeOfBirth", min = 0, max = 1)
	@Extension(url = "http://hl7.org/fhir/StructureDefinition/patient-birthPlace", definedLocally = false)
	protected CHCoreAddressEch11PlaceOfBirth placeOfBirth;

	/**
	 * Extension for a placeOfOrigin.
	 */
	@Nullable
	@Child(name = "placeOfOrigin", min = 0, max = 1)
	@Extension(url = "http://fhir.ch/ig/ch-core/StructureDefinition/ch-core-patient-ech-11-placeoforigin", definedLocally = false)
	protected List<CHCoreAddressECH11PlaceOfOrigin> placeOfOrigin;

	/**
	 * Extension for a citizenship.
	 */
	@Nullable
	@Child(name = "citizenship", min = 0, max = 1)
	@Extension(url = "http://hl7.org/fhir/StructureDefinition/patient-citizenship", definedLocally = false)
	protected List<ChCoreCitizenshipExt> citizenship;

	/**
	 * Extension for a religion.
	 */
	@Nullable
	@Child(name = "religion", min = 0, max = 1)
	@Extension(url = "http://hl7.org/fhir/StructureDefinition/patient-religion", definedLocally = false)
	protected CodeableConcept religion;

	public CHCoreAddressEch11PlaceOfBirth getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(CHCoreAddressEch11PlaceOfBirth placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public List<CHCoreAddressECH11PlaceOfOrigin> getPlaceOfOrigin() {
		return placeOfOrigin;
	}

	public void setPlaceOfOrigin(List<CHCoreAddressECH11PlaceOfOrigin> placeOfOrigin) {
		this.placeOfOrigin = placeOfOrigin;
	}

	public List<ChCoreCitizenshipExt> getCitizenship() {
		return citizenship;
	}

	public void setCitizenship(List<ChCoreCitizenshipExt> citizenship) {
		this.citizenship = citizenship;
	}

	public CodeableConcept getReligion() {
		return religion;
	}

	public void setReligion(CodeableConcept religion) {
		this.religion = religion;
	}

}
