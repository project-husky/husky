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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.model.Period;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.projecthusky.fhir.core.ch.TestHelper;
import org.projecthusky.fhir.core.ch.datatype.r4.CHCoreAddressECH11PlaceOfOrigin;
import org.projecthusky.fhir.core.ch.datatype.r4.CHCoreAddressEch11PlaceOfBirth;
import org.projecthusky.fhir.core.ch.enums.ReligiousAffiliation;
import org.projecthusky.fhir.core.ch.resource.extension.r4.ChCoreCitizenshipExt;

/**
 * 
 */
class ChCorePatientTest extends TestHelper {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.fhir.core.ch.resource.r4.ChCorePatient#setPlaceOfBirth(org.projecthusky.fhir.core.ch.datatype.r4.CHCoreAddressEch11PlaceOfBirth)}.
	 */
	@Test
	void testSetPlaceOfBirth() {
		ChCorePatient ref = new ChCorePatient();
		ref.addName(new HumanName().setFamily("Muster").addGiven("Max"));
		CHCoreAddressEch11PlaceOfBirth placeOfBirth = new CHCoreAddressEch11PlaceOfBirth();
		placeOfBirth.setCity("Musterhausen");
		ref.setPlaceOfBirth(placeOfBirth);

		prettyPrint(ref);
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.fhir.core.ch.resource.r4.ChCorePatient#setPlaceOfOrigin(java.util.List)}.
	 */
	@Test
	void testSetPlaceOfOrigin() {
		ChCorePatient ref = new ChCorePatient();
		ref.addName(new HumanName().setFamily("Muster").addGiven("Max"));
		List<CHCoreAddressECH11PlaceOfOrigin> listPlaceOfOrigin = new ArrayList<>();
		CHCoreAddressECH11PlaceOfOrigin placeOfOrigin = new CHCoreAddressECH11PlaceOfOrigin();
		placeOfOrigin.setCity("Testinghausen");
		listPlaceOfOrigin.add(placeOfOrigin);
		ref.setPlaceOfOrigin(listPlaceOfOrigin);

		prettyPrint(ref);
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.fhir.core.ch.resource.r4.ChCorePatient#setCitizenship(java.util.List)}.
	 */
	@Test
	void testSetCitizenship() {
		ChCorePatient ref = new ChCorePatient();
		ref.addName(new HumanName().setFamily("Muster").addGiven("Max"));
		List<ChCoreCitizenshipExt> citizenShipList = new ArrayList<>();
		ChCoreCitizenshipExt chCoreCitizenshipExt = new ChCoreCitizenshipExt();
		chCoreCitizenshipExt.setId(UUID.randomUUID().toString());
		chCoreCitizenshipExt.setCode(new CodeableConcept(new Coding("http://hl7.org/fhir/ValueSet/iso3166-1-2", "CH", "Switzerland")));
		chCoreCitizenshipExt.setPeriod(new Period().setStart(new Date()).setEnd(new Date()));
		citizenShipList.add(chCoreCitizenshipExt);
		ref.setCitizenship(citizenShipList);

		prettyPrint(ref);
	}
//
//	/**
//	 * Test method for
//	 * {@link org.projecthusky.fhir.core.ch.resource.r4.ChCorePatient#setReligion(org.hl7.fhir.r4.model.CodeableConcept)}.
//	 */
//	@Test
//	void testSetReligion() {
//		ChCorePatient ref = new ChCorePatient();
//		ref.addName(new HumanName().setFamily("Muster").addGiven("Max"));
////		CodeableConcept religion = new CodeableConcept(
////				new Coding("http://hl7.org/fhir/v3/ReligiousAffiliation", "B", "Buddhist"));
//		
////		ReligiousAffiliation religion = new ReligiousAffiliation.getEnum(null)
//		ref.setReligion(null);
//
//		prettyPrint(ref);
//	}

}
