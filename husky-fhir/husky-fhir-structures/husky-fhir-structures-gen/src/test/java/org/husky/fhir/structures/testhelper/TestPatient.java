/*
 * This code is made available under the terms of the Eclipse Public License v1.0 in the github project https://github.com/project-husky/husky there you also find a list of the contributors and the license information.
This project has been developed further and modified by the joined working group Husky on the basis of the eHealth Connector opensource project from June 28, 2021, whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */

package org.husky.fhir.structures.testhelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hl7.fhir.r4.model.Address.AddressUse;
import org.hl7.fhir.r4.model.Enumerations.AdministrativeGender;
import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Identifier.IdentifierUse;
import org.husky.common.enums.CountryCode;
import org.husky.common.utils.DateUtil;
import org.husky.fhir.structures.gen.FhirCommon;
import org.husky.fhir.structures.gen.FhirPatient;

/**
 * Helper class TestPatient.
 */
public class TestPatient {

	static public String oidInsuranceCard = FhirCommon.addUrnOid("2.16.756.5.30.1.123.100.1.1.1");

	static private String oidLocalId = "1.2.3.4";

	public static FhirPatient getFhirPatientMueller() {
		final FhirPatient patient = new FhirPatient();
		final TestPatient testPatient = TestPatient.getTestPatientMueller();

		final org.hl7.fhir.r4.model.Address address = new org.hl7.fhir.r4.model.Address()
				.addLine(testPatient.addrLine1).setPostalCode(testPatient.addrPostalCode)
				.setCity(testPatient.addrCity).setState(testPatient.addrState)
				.setCountry(testPatient.addrCountry);
		address.setUse(AddressUse.valueOf(testPatient.addrUse.toUpperCase()));

		final HumanName humanName = new HumanName().setFamily(testPatient.family)
				.addGiven(testPatient.given);
		patient.getName().add(humanName);

		final Identifier identifier = new Identifier();
		identifier.setUse(IdentifierUse.USUAL);
		identifier.setSystem(FhirCommon.addUrnOid(oidLocalId));
		identifier.setValue(testPatient.localId);

		patient.getIdentifier().add(identifier);

		patient.setBirthDate(DateUtil.parseDateyyyyMMdd2(testPatient.birthDate));

		patient.getAddress().add(address);
		patient.setGender(AdministrativeGender.valueOf(testPatient.gender.toUpperCase()));

		return patient;
	}

	public static FhirPatient getFhirPatientMuellerObsoleteId() {
		final FhirPatient patient = new FhirPatient();
		final TestPatient testPatient = TestPatient.getTestPatientMuellerObsolete();

		final org.hl7.fhir.r4.model.Address address = new org.hl7.fhir.r4.model.Address()
				.addLine(testPatient.addrLine1).setPostalCode(testPatient.addrPostalCode)
				.setCity(testPatient.addrCity).setState(testPatient.addrState)
				.setCountry(testPatient.addrCountry);
		address.setUse(AddressUse.valueOf(testPatient.addrUse.toUpperCase()));

		final HumanName humanName = new HumanName().setFamily(testPatient.family)
				.addGiven(testPatient.given);
		patient.getName().add(humanName);

		final Identifier identifier = new Identifier();
		identifier.setUse(IdentifierUse.USUAL);
		identifier.setSystem(FhirCommon.addUrnOid(oidLocalId));
		identifier.setValue(testPatient.localId);

		patient.getIdentifier().add(identifier);

		patient.setBirthDate(DateUtil.parseDateyyyyMMdd2(testPatient.birthDate));

		patient.getAddress().add(address);
		patient.setGender(AdministrativeGender.valueOf(testPatient.gender.toUpperCase()));

		return patient;
	}

	static public TestPatient getTestPatientMueller() {
		final TestPatient testPatient = new TestPatient();
		testPatient.family = "Müller";
		testPatient.given = "Franz";
		testPatient.birthDate = "1967-10-02";

		testPatient.addrLine1 = "Leidensweg 10";
		testPatient.addrState = "ZH";
		testPatient.addrPostalCode = "9876";
		testPatient.addrCountry = CountryCode.SWITZERLAND.getCodeAlpha3();
		testPatient.addrCity = "Musterhausen";
		testPatient.addrUse = "home";
		testPatient.gender = "male";

		testPatient.idInsuranceCard = "8077560000000000000000";
		testPatient.localId = "121212";

		return testPatient;
	}

	static public TestPatient getTestPatientMuellerObsolete() {
		final TestPatient testPatient = new TestPatient();
		testPatient.family = "Müller";
		testPatient.given = "Franz";
		testPatient.birthDate = "1967-10-02";

		testPatient.addrLine1 = "Leidensweg 10";
		testPatient.addrState = "ZH";
		testPatient.addrPostalCode = "9876";
		testPatient.addrCountry = CountryCode.SWITZERLAND.getCodeAlpha3();
		testPatient.addrCity = "Musterhausen";
		testPatient.addrUse = "home";
		testPatient.gender = "male";

		testPatient.idInsuranceCard = "8077560000000000000000";
		testPatient.localId = "1212";

		return testPatient;
	}

	static public TestPatient getTestPatientMuellerPauline() {
		final TestPatient testPatient = new TestPatient();
		testPatient.family = "Müller";
		testPatient.given = "Pauline";
		testPatient.birthDate = "1971-02-28";

		testPatient.addrLine1 = "Leidensweg 10";
		testPatient.addrState = "ZH";
		testPatient.addrPostalCode = "9876";
		testPatient.addrCountry = CountryCode.SWITZERLAND.getCodeAlpha3();
		testPatient.addrCity = "Musterhausen";
		testPatient.addrUse = "home";
		testPatient.gender = "female";

		testPatient.idInsuranceCard = "8097560000000000000000";
		testPatient.localId = "121215";

		return testPatient;
	}

	public String given;
	public String family;

	public String birthDate;

	public String addrLine1;
	public String addrCity;
	public String addrState;
	public String addrCountry;

	public String addrUse;

	public String addrPostalCode;

	public String gender;

	public String idInsuranceCard;

	public String localId;

	public Date getBirthDate() {
		try {
			final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			return sdf.parse(birthDate);
		} catch (final ParseException e) {
			// convert to RuntimeException
			throw new IllegalArgumentException(e);
		}
	}

}
