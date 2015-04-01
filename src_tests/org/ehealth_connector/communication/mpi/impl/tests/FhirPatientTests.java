/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2015
 *
 *******************************************************************************/
package org.ehealth_connector.communication.mpi.impl.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ehealth_connector.cda.enums.AddressUse;
import org.ehealth_connector.cda.enums.AdministrativeGender;
import org.ehealth_connector.common.Address;
import org.ehealth_connector.common.Name;
import org.ehealth_connector.common.Patient;
import org.ehealth_connector.communication.mpi.FhirPatient;
import org.junit.Test;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.dstu2.composite.AddressDt;
import ca.uhn.fhir.model.dstu2.composite.CodeableConceptDt;
import ca.uhn.fhir.model.dstu2.composite.ContactPointDt;
import ca.uhn.fhir.model.dstu2.composite.HumanNameDt;
import ca.uhn.fhir.model.dstu2.composite.IdentifierDt;
import ca.uhn.fhir.model.dstu2.resource.Organization;
import ca.uhn.fhir.model.dstu2.valueset.AdministrativeGenderEnum;
import ca.uhn.fhir.model.dstu2.valueset.ContactPointSystemEnum;
import ca.uhn.fhir.model.dstu2.valueset.ContactPointUseEnum;
import ca.uhn.fhir.model.dstu2.valueset.MaritalStatusCodesEnum;
import ca.uhn.fhir.model.primitive.BooleanDt;
import ca.uhn.fhir.model.primitive.DateDt;
import ca.uhn.fhir.model.primitive.DateTimeDt;
import ca.uhn.fhir.model.primitive.IntegerDt;
import ca.uhn.fhir.parser.IParser;
import ca.uhn.fhir.validation.FhirValidator;
import ca.uhn.fhir.validation.ValidationResult;

/**
 * Junit Tests for the FhirPatient
 * 
 * @see org.ehealth_connector.communication.mpi.FhirPatient
 */
public class FhirPatientTests {

	private FhirContext ctx = new FhirContext();
	private Log log = LogFactory.getLog(FhirPatientTests.class);

	@Test
	public void testConveniencePatient() {

		// ALPHA ALAN
		FhirPatient fhirPatient = new FhirPatient();
		HumanNameDt humanName = new HumanNameDt().addFamily("ALPHA").addGiven("ALAN");
		fhirPatient.getName().add(humanName);
		AddressDt address = new AddressDt().addLine("1 PINETREE").setPostalCode("63119")
				.setCity("WEBSTER").setState("MO");
		IdentifierDt identifier = new IdentifierDt();
		identifier.setValue("PIX");
		identifier.setSystem("urn:oid:2.16.840.1.113883.3.72.5.9.1");
		fhirPatient.getIdentifier().add(identifier);
		fhirPatient.setBirthDate(new DateDt("19380224"));
		fhirPatient.getAddress().add(address);
		fhirPatient.setGender(AdministrativeGenderEnum.MALE);
		fhirPatient.getManagingOrganization().setResource(getScopingOrganization());

		Patient patient = fhirPatient.getPatient();

		assertEquals("2.16.840.1.113883.3.72.5.9.1", patient.getIds().get(0).getRoot());
		assertEquals("PIX", patient.getIds().get(0).getExtension());
		assertEquals("1 PINETREE", patient.getAddress().getAddressline1());
		assertEquals("63119", patient.getAddress().getZip());
		assertEquals("WEBSTER", patient.getAddress().getCity());
		assertEquals("ALPHA", patient.getName().getFamilyName());
		assertEquals("ALAN", patient.getName().getGivenNames());

		org.openhealthtools.mdht.uml.hl7.datatypes.II ii = patient.getMdhtPatientRole()
				.getProviderOrganization().getIds().get(0);
		assertEquals("2.16.840.1.113883.3.72.5.9.2", ii.getRoot());

		FhirPatient fhirPatientEquals = new FhirPatient(patient);
		Patient patientEquals = fhirPatientEquals.getPatient();

		assertEquals("2.16.840.1.113883.3.72.5.9.1", patientEquals.getIds().get(0).getRoot());
		assertEquals("PIX", patientEquals.getIds().get(0).getExtension());
		assertEquals("1 PINETREE", patientEquals.getAddress().getAddressline1());
		assertEquals("63119", patientEquals.getAddress().getZip());
		assertEquals("WEBSTER", patientEquals.getAddress().getCity());
		assertEquals("ALPHA", patientEquals.getName().getFamilyName());
		assertEquals("ALAN", patientEquals.getName().getGivenNames());

		ii = patientEquals.getMdhtPatientRole().getProviderOrganization().getIds().get(0);
		assertEquals("2.16.840.1.113883.3.72.5.9.2", ii.getRoot());
	}

	@Test
	public void testConveniencePatientBirthPlace() {
		FhirPatient fhirPatient = new FhirPatient();

		AddressDt addressDt = new AddressDt();
		addressDt.setCity("Doncaster");

		fhirPatient.setBirthPlace(addressDt);

		assertEquals("Doncaster", fhirPatient.getBirthPlace().getCity());

		Patient patient = fhirPatient.getPatient();
		assertEquals("Doncaster", patient.getMdhtPatient().getBirthplace().getPlace().getAddr()
				.getCities().get(0).getText());

		FhirPatient fhirPatient2 = new FhirPatient(patient);
		assertEquals("Doncaster", fhirPatient2.getBirthPlace().getCity());
	}

	@Test
	public void testConveniencePatientDeceasedDateTime() {
		FhirPatient fhirPatient = new FhirPatient();
		Date dtNow = new Date();
		DateTimeDt dateTimeDt = new DateTimeDt(dtNow);

		fhirPatient.setDeceased(dateTimeDt);

		Patient patient = fhirPatient.getPatient();
		assertEquals(dtNow, patient.getDeceasedTime());

		FhirPatient fhirPatient2 = new FhirPatient(patient);
		assertEquals(dtNow, ((DateTimeDt) fhirPatient2.getDeceased()).getValue());
	}

	@Test
	public void testConveniencePatientDeceasedIndicator() {
		FhirPatient fhirPatient = new FhirPatient();
		BooleanDt booleanDt = new BooleanDt();
		booleanDt.setValue(true);
		fhirPatient.setDeceased(booleanDt);

		Patient patient = fhirPatient.getPatient();
		assertTrue(patient.getDeceasedInd().booleanValue());

		FhirPatient fhirPatient2 = new FhirPatient(patient);
		assertTrue(((BooleanDt) fhirPatient2.getDeceased()).getValue().booleanValue());
	}

	@Test
	public void testConveniencePatientEmployeeOccupationCode() {
		FhirPatient fhirPatient = new FhirPatient();
		CodeableConceptDt employeeOccupationCode = new CodeableConceptDt();
		employeeOccupationCode.setText("employeeOccupationCode");
		fhirPatient.setEmployeeOccupation(employeeOccupationCode);

		Patient patient = fhirPatient.getPatient();
		assertEquals("employeeOccupationCode", patient.getEmployeeOccupation());

		FhirPatient fhirPatient2 = new FhirPatient(patient);
		assertEquals("employeeOccupationCode", fhirPatient2.getEmployeeOccupation().getText());
	}

	@Test
	public void testConveniencePatientLanguage() {
		FhirPatient fhirPatient = new FhirPatient();
		CodeableConceptDt deCH = new CodeableConceptDt();
		deCH.setText("de-CH");
		CodeableConceptDt frCH = new CodeableConceptDt();
		frCH.setText("fr-CH");

		fhirPatient.getCommunication().add(deCH);
		fhirPatient.getCommunication().add(frCH);

		Patient patient = fhirPatient.getPatient();
		assertEquals("de-CH", patient.getMdhtPatient().getLanguageCommunications().get(0)
				.getLanguageCode().getCode());
		assertEquals("fr-CH", patient.getMdhtPatient().getLanguageCommunications().get(1)
				.getLanguageCode().getCode());

		FhirPatient fhirPatient2 = new FhirPatient(patient);

		assertEquals("de-CH", fhirPatient2.getCommunication().get(0).getText());
		assertEquals("fr-CH", fhirPatient2.getCommunication().get(1).getText());
	}

	@Test
	public void testConveniencePatientMaritialStatus() {
		FhirPatient fhirPatient = new FhirPatient();
		fhirPatient.setMaritalStatus(MaritalStatusCodesEnum.M); // married

		Patient patient = fhirPatient.getPatient();
		assertEquals("M", patient.getMdhtPatient().getMaritalStatusCode().getCode());

		FhirPatient fhirPatient2 = new FhirPatient(patient);
		assertEquals("M", fhirPatient2.getMaritalStatus().getValueAsEnum().toArray()[0].toString());
	}

	@Test
	public void testConveniencePatientMothersName() {
		FhirPatient fhirPatient = new FhirPatient();

		assertTrue(fhirPatient.getMothersMaidenName().isEmpty());

		HumanNameDt mothersMaidenName = new HumanNameDt();
		mothersMaidenName.addFamily("Wiedmer");
		fhirPatient.setMothersMaidenName(mothersMaidenName);

		assertEquals("Wiedmer", fhirPatient.getMothersMaidenName().getFamilyAsSingleString());

		Patient patient = fhirPatient.getPatient();
		assertEquals("Wiedmer", patient.getMothersMaidenName());

		FhirPatient fhirPatient2 = new FhirPatient(patient);
		assertEquals("Wiedmer", fhirPatient2.getMothersMaidenName().getFamilyAsSingleString());
	}

	@Test
	public void testConveniencePatientMultipleBirthIndicator() {
		FhirPatient fhirPatient = new FhirPatient();
		BooleanDt booleanDt = new BooleanDt();
		booleanDt.setValue(true);
		fhirPatient.setMultipleBirth(booleanDt);

		Patient patient = fhirPatient.getPatient();
		assertTrue(patient.getMultipleBirthInd().booleanValue());

		FhirPatient fhirPatient2 = new FhirPatient(patient);
		assertTrue(((BooleanDt) fhirPatient2.getMultipleBirth()).getValue().booleanValue());
	}

	@Test
	public void testConveniencePatientMultipleBirthOrder() {
		FhirPatient fhirPatient = new FhirPatient();
		IntegerDt integerDt = new IntegerDt(2);
		fhirPatient.setMultipleBirth(integerDt);

		Patient patient = fhirPatient.getPatient();
		assertEquals(2, patient.getMultipleBirthOrderNumber().intValue());

		FhirPatient fhirPatient2 = new FhirPatient(patient);
		assertEquals(2, ((IntegerDt) fhirPatient2.getMultipleBirth()).getValue().intValue());
	}

	@Test
	public void testConveniencePatientNation() {
		FhirPatient fhirPatient = new FhirPatient();
		CodeableConceptDt nation = new CodeableConceptDt();
		nation.setText("CHE");

		fhirPatient.setNation(nation);

		Patient patient = fhirPatient.getPatient();
		assertEquals("CHE", patient.getNation());

		FhirPatient fhirPatient2 = new FhirPatient(patient);

		assertEquals("CHE", fhirPatient2.getNation().getText());
	}

	@Test
	public void testConveniencePatientOrganization() {
		FhirPatient fhirPatient = new FhirPatient();
		fhirPatient.getManagingOrganization().setResource(
				getScopingOrganization("1234", "Test", "+417600000000"));

		ca.uhn.fhir.model.dstu2.resource.Organization org = (ca.uhn.fhir.model.dstu2.resource.Organization) fhirPatient
				.getManagingOrganization().getResource();

		assertEquals("1234", org.getIdentifierFirstRep().getSystem().substring(8));
		assertEquals("Test", org.getName());
		assertEquals("+417600000000", org.getTelecomFirstRep().getValue());

		Patient patient = fhirPatient.getPatient();
		assertEquals("Test", patient.getMdhtPatientRole().getProviderOrganization().getNames().get(0)
				.getText());
		assertEquals("1234", patient.getMdhtPatientRole().getProviderOrganization().getIds().get(0)
				.getRoot());
		assertEquals("tel:+417600000000", patient.getMdhtPatientRole().getProviderOrganization()
				.getTelecoms().get(0).getValue());

		FhirPatient fhirPatient2 = new FhirPatient(patient);
		org = (ca.uhn.fhir.model.dstu2.resource.Organization) fhirPatient2.getManagingOrganization()
				.getResource();

		assertEquals("1234", org.getIdentifierFirstRep().getSystem().substring(8));
		assertEquals("Test", org.getName());
		assertEquals("+417600000000", org.getTelecomFirstRep().getValue());
	}

	@Test
	public void testConveniencePatientReligiousAffiliation() {
		FhirPatient fhirPatient = new FhirPatient();
		CodeableConceptDt religion = new CodeableConceptDt();
		religion.setText("1077");

		fhirPatient.setReligiousAffiliation(religion);

		Patient patient = fhirPatient.getPatient();
		assertEquals("1077", patient.getReligiousAffiliation());

		FhirPatient fhirPatient2 = new FhirPatient(patient);

		assertEquals("1077", fhirPatient2.getReligiousAffiliation().getText());
	}

	@Test
	public void testConveniencePatientTelecom() {

		FhirPatient fhirPatient = new FhirPatient();

		ContactPointDt telHome = new ContactPointDt();
		telHome.setUse(ContactPointUseEnum.HOME);
		telHome.setSystem(ContactPointSystemEnum.PHONE);
		telHome.setValue("+4144000000000");

		ContactPointDt telWork = new ContactPointDt();
		telWork.setUse(ContactPointUseEnum.WORK);
		telWork.setSystem(ContactPointSystemEnum.PHONE);
		telWork.setValue("+4188000000000");

		ContactPointDt telMobile = new ContactPointDt();
		telMobile.setUse(ContactPointUseEnum.MOBILE);
		telMobile.setSystem(ContactPointSystemEnum.PHONE);
		telMobile.setValue("+4176000000000");

		ContactPointDt eMail = new ContactPointDt();
		eMail.setUse(ContactPointUseEnum.WORK);
		eMail.setSystem(ContactPointSystemEnum.EMAIL);
		eMail.setValue("xyz@abc.ch");

		fhirPatient.getTelecom().add(telHome);
		fhirPatient.getTelecom().add(telWork);
		fhirPatient.getTelecom().add(telMobile);
		fhirPatient.getTelecom().add(eMail);

		Patient patient = fhirPatient.getPatient();

		HashMap<String, AddressUse> phones = patient.getTelecoms().getPhones();

		assertEquals(AddressUse.PRIVATE, phones.get("tel:+4144000000000"));
		assertEquals(AddressUse.BUSINESS, phones.get("tel:+4188000000000"));
		assertEquals(AddressUse.MOBILE, phones.get("tel:+4176000000000"));

		HashMap<String, AddressUse> emails = patient.getTelecoms().getEMails();
		assertEquals(AddressUse.BUSINESS, emails.get("mailto:xyz@abc.ch"));

		FhirPatient fhirPatient2 = new FhirPatient(patient);

		assertEquals(ContactPointUseEnum.HOME, fhirPatient2.getTelecom().get(0).getUseElement()
				.getValueAsEnum());
		assertEquals(ContactPointSystemEnum.PHONE, fhirPatient2.getTelecom().get(0).getSystemElement()
				.getValueAsEnum());
		assertEquals("+4144000000000", fhirPatient2.getTelecom().get(0).getValue());

		assertEquals(ContactPointUseEnum.WORK, fhirPatient2.getTelecom().get(1).getUseElement()
				.getValueAsEnum());
		assertEquals(ContactPointSystemEnum.PHONE, fhirPatient2.getTelecom().get(1).getSystemElement()
				.getValueAsEnum());
		assertEquals("+4188000000000", fhirPatient2.getTelecom().get(1).getValue());

		assertEquals(ContactPointUseEnum.MOBILE, fhirPatient2.getTelecom().get(2).getUseElement()
				.getValueAsEnum());
		assertEquals(ContactPointSystemEnum.PHONE, fhirPatient2.getTelecom().get(2).getSystemElement()
				.getValueAsEnum());
		assertEquals("+4176000000000", fhirPatient2.getTelecom().get(2).getValue());

		assertEquals(ContactPointUseEnum.WORK, fhirPatient2.getTelecom().get(3).getUseElement()
				.getValueAsEnum());
		assertEquals(ContactPointSystemEnum.EMAIL, fhirPatient2.getTelecom().get(3).getSystemElement()
				.getValueAsEnum());
		assertEquals("xyz@abc.ch", fhirPatient2.getTelecom().get(3).getValue());
	}

	@Test
	public void testFhirPatientAddress() {
		Name name = new Name("given", "family", "prefix", "suffix");
		Patient conveniencePatient = new Patient(name, AdministrativeGender.MALE, new Date());

		Address address = new Address("addressline1", "addressline2", "addressline3", "zip", "city",
				AddressUse.PRIVATE);

		address.getMdhtAdress().addCountry("cty");
		address.getMdhtAdress().addState("state");

		conveniencePatient.addAddress(address);

		FhirPatient fhirPatient = new FhirPatient(conveniencePatient);

		assertEquals("addressline1", fhirPatient.getAddressFirstRep().getLine().get(0).getValue());
		assertEquals("addressline2", fhirPatient.getAddressFirstRep().getLine().get(1).getValue());
		assertEquals("addressline3", fhirPatient.getAddressFirstRep().getLine().get(2).getValue());
		assertEquals("zip", fhirPatient.getAddressFirstRep().getPostalCode());
		assertEquals("city", fhirPatient.getAddressFirstRep().getCity());
		assertEquals("cty", fhirPatient.getAddressFirstRep().getCountry());
		assertEquals("state", fhirPatient.getAddressFirstRep().getState());
	}

	@Test
	public void testFhirPatientLastGivenGenderBirthDayGenderFemale() {
		TestPatient patientMueller = TestPatient.getTestPatientMuellerPauline();
		Patient conveniencePatient = getPatient(patientMueller);
		FhirPatient fhirPatient = new FhirPatient(conveniencePatient);
		assertEquals(patientMueller.given, fhirPatient.getNameFirstRep().getGivenAsSingleString());
		assertEquals(patientMueller.family, fhirPatient.getNameFirstRep().getFamilyAsSingleString());
		assertEquals(patientMueller.getBirthDate(), fhirPatient.getBirthDate());
		assertEquals(patientMueller.gender, fhirPatient.getGender());
	}

	@Test
	public void testFhirPatientLastGivenGenderBirthDayGenderMale() {
		TestPatient patientMueller = TestPatient.getTestPatientMueller();
		Patient conveniencePatient = getPatient(patientMueller);
		FhirPatient fhirPatient = new FhirPatient(conveniencePatient);
		assertEquals(patientMueller.given, fhirPatient.getNameFirstRep().getGivenAsSingleString());
		assertEquals(patientMueller.family, fhirPatient.getNameFirstRep().getFamilyAsSingleString());
		assertEquals(patientMueller.getBirthDate(), fhirPatient.getBirthDate());
		assertEquals(patientMueller.gender, fhirPatient.getGender());
	}

	@Test
	public void testFhirPatientMiddleName() {
		Name name = new Name("given", "family", "prefix", "suffix");
		name.getMdhtPn().addGiven("middle");
		name.getMdhtPn().addFamily("family2");
		name.getMdhtPn().addPrefix("prefix2");
		name.getMdhtPn().addSuffix("suffix2");
		Patient conveniencePatient = new Patient(name, AdministrativeGender.MALE, new Date());
		FhirPatient fhirPatient = new FhirPatient(conveniencePatient);
		assertEquals("given middle", fhirPatient.getNameFirstRep().getGivenAsSingleString());
		assertEquals("family family2", fhirPatient.getNameFirstRep().getFamilyAsSingleString());
		assertEquals("prefix prefix2", fhirPatient.getNameFirstRep().getPrefixAsSingleString());
		assertEquals("suffix suffix2", fhirPatient.getNameFirstRep().getSuffixAsSingleString());
	}

	@Test
	public void testFhirPatientNames() {
		Name name = new Name("given", "family", "prefix", "suffix");
		Patient conveniencePatient = new Patient(name, AdministrativeGender.MALE, new Date());
		FhirPatient fhirPatient = new FhirPatient(conveniencePatient);
		assertEquals("given", fhirPatient.getNameFirstRep().getGivenAsSingleString());
		assertEquals("family", fhirPatient.getNameFirstRep().getFamilyAsSingleString());
		assertEquals("prefix", fhirPatient.getNameFirstRep().getPrefixAsSingleString());
		assertEquals("suffix", fhirPatient.getNameFirstRep().getSuffixAsSingleString());
	}

	@Test
	public void testFhirSerializeDeserialize() {

		FhirPatient fhirPatient = TestPatient.getFhirPatientMueller();

		fhirPatient.getManagingOrganization().setResource(
				getScopingOrganization("1234", "Test", "+417600000000"));

		// telecom
		ContactPointDt telHome = new ContactPointDt();
		telHome.setUse(ContactPointUseEnum.HOME);
		telHome.setSystem(ContactPointSystemEnum.PHONE);
		telHome.setValue("+4144000000000");

		ContactPointDt telWork = new ContactPointDt();
		telWork.setUse(ContactPointUseEnum.WORK);
		telWork.setSystem(ContactPointSystemEnum.PHONE);
		telWork.setValue("+4188000000000");

		ContactPointDt telMobile = new ContactPointDt();
		telMobile.setUse(ContactPointUseEnum.MOBILE);
		telMobile.setSystem(ContactPointSystemEnum.PHONE);
		telMobile.setValue("+4176000000000");

		ContactPointDt eMail = new ContactPointDt();
		eMail.setUse(ContactPointUseEnum.WORK);
		eMail.setSystem(ContactPointSystemEnum.EMAIL);
		eMail.setValue("xyz@abc.ch");

		fhirPatient.getTelecom().add(telHome);
		fhirPatient.getTelecom().add(telWork);
		fhirPatient.getTelecom().add(telMobile);
		fhirPatient.getTelecom().add(eMail);

		// communication
		CodeableConceptDt deCH = new CodeableConceptDt();
		deCH.setText("de-CH");

		fhirPatient.getCommunication().add(deCH);

		fhirPatient.setMaritalStatus(MaritalStatusCodesEnum.M); // married

		HumanNameDt mothersMaidenName = new HumanNameDt();
		mothersMaidenName.addFamily("Meier");
		fhirPatient.setMothersMaidenName(mothersMaidenName);

		BooleanDt booleanDt = new BooleanDt();
		booleanDt.setValue(false);
		fhirPatient.setDeceased(booleanDt);

		AddressDt addressDt = new AddressDt();

		addressDt.setCity("Doncaster");
		fhirPatient.setBirthPlace(addressDt);

		CodeableConceptDt religion = new CodeableConceptDt();
		religion.setText("1077");
		fhirPatient.setReligiousAffiliation(religion);

		CodeableConceptDt nation = new CodeableConceptDt();
		nation.setText("CHE");
		fhirPatient.setNation(nation);

		CodeableConceptDt employeeOccupationCode = new CodeableConceptDt();
		employeeOccupationCode.setText("employeeOccupationCode");
		fhirPatient.setEmployeeOccupation(employeeOccupationCode);

		FhirValidator val = ctx.newValidator();
		ValidationResult result = val.validateWithResult(fhirPatient);
		if (result.isSuccessful()) {
			System.out.println("Validation passed");
		} else {
			// We failed validation!
			System.out.println("Validation failed");
			// The result contains an OperationOutcome outlining the failures
			String results = ctx.newXmlParser().setPrettyPrint(true)
					.encodeResourceToString(result.getOperationOutcome());
			System.out.println(results);
		}
		assertTrue(result.isSuccessful());

		String stringPatient = ctx.newXmlParser().encodeResourceToString(fhirPatient);

		log.debug(stringPatient);

		IParser parser = ctx.newXmlParser();
		FhirPatient fhirPatientDeserialized = parser.parseResource(FhirPatient.class, stringPatient);
		assertTrue(fhirPatientDeserialized != null);

	}

	private Patient getPatient(TestPatient patientMueller) {
		Name name = new Name(patientMueller.given, patientMueller.family);
		AdministrativeGender gender;
		if ("male".equals(patientMueller.gender)) {
			gender = AdministrativeGender.MALE;
		} else if ("female".equals(patientMueller.gender)) {
			gender = AdministrativeGender.FEMALE;
		} else {
			gender = AdministrativeGender.UNDIFFERENTIATED;
		}
		Patient conveniencePatient = new Patient(name, gender, patientMueller.getBirthDate());
		return conveniencePatient;
	}

	private Organization getScopingOrganization() {
		return this.getScopingOrganization("2.16.840.1.113883.3.72.5.9.2", "OHT", null);
	}

	private Organization getScopingOrganization(String oid, String name, String tel) {
		Organization org = new Organization();
		if (oid != null) {
			IdentifierDt identifier = new IdentifierDt();
			identifier.setSystem("urn:oid:" + oid);
			org.getIdentifier().add(identifier);
		}
		if (name != null) {
			org.setName(name);
		}
		if (tel != null) {
			ContactPointDt fhirTel = org.addTelecom();
			fhirTel.setValue(tel);
		}
		return org;
	}

}
