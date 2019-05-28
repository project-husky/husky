/*
 *
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
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
package org.ehealth_connector.fhir.structures.gen;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.Map;

import org.ehealth_connector.common.Name;
import org.ehealth_connector.common.Patient;
import org.ehealth_connector.common.enums.CountryCode;
import org.ehealth_connector.common.enums.PostalAddressUse;
import org.ehealth_connector.common.enums.TelecomAddressUse;
import org.ehealth_connector.common.utils.DateUtil;
import org.ehealth_connector.fhir.structures.testhelper.TestPatient;
import org.hl7.fhir.dstu3.model.Address;
import org.hl7.fhir.dstu3.model.BooleanType;
import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.Coding;
import org.hl7.fhir.dstu3.model.ContactPoint;
import org.hl7.fhir.dstu3.model.ContactPoint.ContactPointSystem;
import org.hl7.fhir.dstu3.model.ContactPoint.ContactPointUse;
import org.hl7.fhir.dstu3.model.DateTimeType;
import org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGender;
import org.hl7.fhir.dstu3.model.HumanName;
import org.hl7.fhir.dstu3.model.Identifier;
import org.hl7.fhir.dstu3.model.IntegerType;
import org.hl7.fhir.dstu3.model.Organization;
import org.hl7.fhir.dstu3.model.Patient.PatientCommunicationComponent;
import org.hl7.fhir.dstu3.model.codesystems.V3MaritalStatus;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.context.FhirVersionEnum;
import ca.uhn.fhir.parser.IParser;
import ca.uhn.fhir.validation.FhirValidator;
import ca.uhn.fhir.validation.ValidationResult;

/**
 * Junit Tests for the FhirPatient
 *
 * @see org.org.ehealth_connector.fhir.structures.gen.FhirPatient
 */
public class FhirPatientTest {

	private final FhirContext ctx = new FhirContext(FhirVersionEnum.DSTU3);
	/** The SLF4J logger instance. */
	protected final Logger log = LoggerFactory.getLogger(getClass());

	private Patient getPatient(TestPatient patientMueller) {
		final Name name = new Name(patientMueller.given, patientMueller.family);
		org.ehealth_connector.common.enums.AdministrativeGender gender;
		if ("male".equals(patientMueller.gender.toLowerCase())) {
			gender = org.ehealth_connector.common.enums.AdministrativeGender.MALE;
		} else if ("female".equals(patientMueller.gender.toLowerCase())) {
			gender = org.ehealth_connector.common.enums.AdministrativeGender.FEMALE;
		} else {
			gender = org.ehealth_connector.common.enums.AdministrativeGender.UNDIFFERENTIATED;
		}
		final Patient conveniencePatient = new Patient(name, gender, patientMueller.getBirthDate());
		return conveniencePatient;
	}

	private Organization getScopingOrganization() {
		return this.getScopingOrganization("2.16.840.1.113883.3.72.5.9.2", "OHT", null);
	}

	private Organization getScopingOrganization(String oid, String name, String tel) {
		final Organization org = new Organization();
		if (oid != null) {
			final Identifier identifier = new Identifier();
			identifier.setSystem(FhirCommon.addUrnOid(oid));
			org.getIdentifier().add(identifier);
		}
		if (name != null) {
			org.setName(name);
		}
		if (tel != null) {
			final ContactPoint fhirTel = org.addTelecom();
			fhirTel.setValue(tel);
		}
		return org;
	}

	@Test
	public void testConveniencePatient() {

		// ALPHA ALAN
		final FhirPatient fhirPatient = new FhirPatient();
		final HumanName humanName = new HumanName().setFamily("ALPHA").addGiven("ALAN");
		fhirPatient.getName().add(humanName);
		final Address address = new Address().addLine("1 PINETREE").setPostalCode("63119")
				.setCity("WEBSTER").setState("MO");
		final Identifier identifier = new Identifier();
		identifier.setValue("PIX");
		identifier.setSystem(FhirCommon.addUrnOid("2.16.840.1.113883.3.72.5.9.1"));
		fhirPatient.getIdentifier().add(identifier);
		fhirPatient.setBirthDate(DateUtil.parseDateyyyyMMdd("19380224"));
		fhirPatient.getAddress().add(address);
		fhirPatient.setGender(AdministrativeGender.MALE);
		fhirPatient.getManagingOrganization().setResource(getScopingOrganization());

		final Patient patient = fhirPatient.getPatient();

		assertEquals("2.16.840.1.113883.3.72.5.9.1", patient.getIds().get(0).getRoot());
		assertEquals("PIX", patient.getIds().get(0).getExtension());
		assertEquals("1 PINETREE", patient.getAddress().getAddressline1());
		assertEquals("63119", patient.getAddress().getZip());
		assertEquals("WEBSTER", patient.getAddress().getCity());
		assertEquals("ALPHA", patient.getName().getFamilyName());
		assertEquals("ALAN", patient.getName().getAllGivenNames());

		org.openhealthtools.mdht.uml.hl7.datatypes.II ii = patient.getMdhtPatientRole()
				.getProviderOrganization().getIds().get(0);
		assertEquals("2.16.840.1.113883.3.72.5.9.2", ii.getRoot());

		final FhirPatient fhirPatientEquals = new FhirPatient(patient);
		final Patient patientEquals = fhirPatientEquals.getPatient();

		assertEquals("2.16.840.1.113883.3.72.5.9.1", patientEquals.getIds().get(0).getRoot());
		assertEquals("PIX", patientEquals.getIds().get(0).getExtension());
		assertEquals("1 PINETREE", patientEquals.getAddress().getAddressline1());
		assertEquals("63119", patientEquals.getAddress().getZip());
		assertEquals("WEBSTER", patientEquals.getAddress().getCity());
		assertEquals("ALPHA", patientEquals.getName().getFamilyName());
		assertEquals("ALAN", patientEquals.getName().getAllGivenNames());

		ii = patientEquals.getMdhtPatientRole().getProviderOrganization().getIds().get(0);
		assertEquals("2.16.840.1.113883.3.72.5.9.2", ii.getRoot());
	}

	@Test
	public void testConveniencePatientBirthPlace() {
		final FhirPatient fhirPatient = new FhirPatient();

		final Address Address = new Address();
		Address.setCity("Doncaster");

		fhirPatient.setBirthPlace(Address);

		assertEquals("Doncaster", fhirPatient.getBirthPlace().getCity());

		final Patient patient = fhirPatient.getPatient();
		assertEquals("Doncaster", patient.getMdhtPatient().getBirthplace().getPlace().getAddr()
				.getCities().get(0).getText());

		final FhirPatient fhirPatient2 = new FhirPatient(patient);
		assertEquals("Doncaster", fhirPatient2.getBirthPlace().getCity());
	}

	@Test
	public void testConveniencePatientDeceasedDateTime() {
		final FhirPatient fhirPatient = new FhirPatient();
		final Date dtNow = new Date();
		final DateTimeType DateTime = new DateTimeType(dtNow);

		fhirPatient.setDeceased(DateTime);

		final Patient patient = fhirPatient.getPatient();
		assertEquals(dtNow, patient.getDeceasedTime());

		final FhirPatient fhirPatient2 = new FhirPatient(patient);
		assertEquals(dtNow, ((DateTimeType) fhirPatient2.getDeceased()).getValue());
	}

	@Test
	public void testConveniencePatientDeceasedIndicator() {
		final FhirPatient fhirPatient = new FhirPatient();
		final BooleanType Boolean = new BooleanType();
		Boolean.setValue(true);
		fhirPatient.setDeceased(Boolean);

		final Patient patient = fhirPatient.getPatient();
		assertTrue(patient.getDeceasedInd().booleanValue());

		final FhirPatient fhirPatient2 = new FhirPatient(patient);
		assertTrue(((BooleanType) fhirPatient2.getDeceased()).getValue().booleanValue());
	}

	@Test
	public void testConveniencePatientEmployeeOccupationCode() {
		final FhirPatient fhirPatient = new FhirPatient();
		final CodeableConcept employeeOccupationCode = new CodeableConcept();
		employeeOccupationCode.setText("employeeOccupationCode");
		fhirPatient.setEmployeeOccupation(employeeOccupationCode);

		final Patient patient = fhirPatient.getPatient();
		assertEquals("employeeOccupationCode", patient.getEmployeeOccupation());

		final FhirPatient fhirPatient2 = new FhirPatient(patient);
		assertEquals("employeeOccupationCode", fhirPatient2.getEmployeeOccupation().getText());
	}

	@Test
	public void testConveniencePatientLanguage() {
		final FhirPatient fhirPatient = new FhirPatient();
		final CodeableConcept deCH = new CodeableConcept();
		deCH.setText("de-CH");
		final CodeableConcept frCH = new CodeableConcept();
		frCH.setText("fr-CH");

		fhirPatient.getCommunication().add(new PatientCommunicationComponent().setLanguage(deCH));
		fhirPatient.getCommunication().add(new PatientCommunicationComponent().setLanguage(frCH));

		final Patient patient = fhirPatient.getPatient();
		assertEquals("de-CH", patient.getMdhtPatient().getLanguageCommunications().get(0)
				.getLanguageCode().getCode());
		assertEquals("fr-CH", patient.getMdhtPatient().getLanguageCommunications().get(1)
				.getLanguageCode().getCode());

		final FhirPatient fhirPatient2 = new FhirPatient(patient);

		assertEquals("de-CH", fhirPatient2.getCommunication().get(0).getLanguage().getText());
		assertEquals("fr-CH", fhirPatient2.getCommunication().get(1).getLanguage().getText());
	}

	@Test
	public void testConveniencePatientMaritalStatus() {
		final FhirPatient fhirPatient = new FhirPatient();
		final CodeableConcept maritalStatus = new CodeableConcept();
		maritalStatus.addCoding(
				new Coding(null, V3MaritalStatus.M.toCode(), V3MaritalStatus.M.getDisplay()));// married
		fhirPatient.setMaritalStatus(maritalStatus);

		final Patient patient = fhirPatient.getPatient();
		assertEquals("M", patient.getMdhtPatient().getMaritalStatusCode().getCode());

		final FhirPatient fhirPatient2 = new FhirPatient(patient);
		assertEquals("M", fhirPatient2.getMaritalStatus().getCodingFirstRep().getCode());
	}

	@Test
	public void testConveniencePatientMothersName() {
		final FhirPatient fhirPatient = new FhirPatient();

		assertTrue(fhirPatient.getMothersMaidenName().isEmpty());

		final HumanName mothersMaidenName = new HumanName();
		mothersMaidenName.setFamily("Wiedmer");
		fhirPatient.setMothersMaidenName(mothersMaidenName);

		assertEquals("Wiedmer", fhirPatient.getMothersMaidenName().getFamily());

		final Patient patient = fhirPatient.getPatient();
		assertEquals("Wiedmer", patient.getMothersMaidenName());

		final FhirPatient fhirPatient2 = new FhirPatient(patient);
		assertEquals("Wiedmer", fhirPatient2.getMothersMaidenName().getFamily());
	}

	@Test
	public void testConveniencePatientMultipleBirthIndicator() {
		final FhirPatient fhirPatient = new FhirPatient();
		final BooleanType Boolean = new BooleanType();
		Boolean.setValue(true);
		fhirPatient.setMultipleBirth(Boolean);

		final Patient patient = fhirPatient.getPatient();
		assertTrue(patient.getMultipleBirthInd().booleanValue());

		final FhirPatient fhirPatient2 = new FhirPatient(patient);
		assertTrue(((BooleanType) fhirPatient2.getMultipleBirth()).getValue().booleanValue());
	}

	@Test
	public void testConveniencePatientMultipleBirthOrder() {
		final FhirPatient fhirPatient = new FhirPatient();
		final IntegerType Integer = new IntegerType(2);
		fhirPatient.setMultipleBirth(Integer);

		final Patient patient = fhirPatient.getPatient();
		assertEquals(2, patient.getMultipleBirthOrderNumber().intValue());

		final FhirPatient fhirPatient2 = new FhirPatient(patient);
		assertEquals(2, ((IntegerType) fhirPatient2.getMultipleBirth()).getValue().intValue());
	}

	@Test
	public void testConveniencePatientNation() {
		final FhirPatient fhirPatient = new FhirPatient();
		final CodeableConcept nation = new CodeableConcept();
		nation.setText(CountryCode.SWITZERLAND.getCodeAlpha3());

		fhirPatient.setNation(nation);

		final Patient patient = fhirPatient.getPatient();
		assertEquals(CountryCode.SWITZERLAND.getCodeAlpha3(), patient.getNation());

		final FhirPatient fhirPatient2 = new FhirPatient(patient);

		assertEquals(CountryCode.SWITZERLAND.getCodeAlpha3(), fhirPatient2.getNation().getText());
	}

	@Test
	public void testConveniencePatientOrganization() {
		final FhirPatient fhirPatient = new FhirPatient();
		fhirPatient.getManagingOrganization()
				.setResource(getScopingOrganization("1234", "Test", "+417600000000"));

		org.hl7.fhir.dstu3.model.Organization org = (org.hl7.fhir.dstu3.model.Organization) fhirPatient
				.getManagingOrganization().getResource();

		assertEquals("1234", org.getIdentifierFirstRep().getSystem().substring(8));
		assertEquals("Test", org.getName());
		assertEquals("+417600000000", org.getTelecomFirstRep().getValue());

		final Patient patient = fhirPatient.getPatient();
		assertEquals("Test",
				patient.getMdhtPatientRole().getProviderOrganization().getNames().get(0).getText());
		assertEquals("1234",
				patient.getMdhtPatientRole().getProviderOrganization().getIds().get(0).getRoot());
		assertEquals("tel:+417600000000", patient.getMdhtPatientRole().getProviderOrganization()
				.getTelecoms().get(0).getValue());

		final FhirPatient fhirPatient2 = new FhirPatient(patient);
		org = (org.hl7.fhir.dstu3.model.Organization) fhirPatient2.getManagingOrganization()
				.getResource();

		assertEquals("1234", org.getIdentifierFirstRep().getSystem().substring(8));
		assertEquals("Test", org.getName());
		assertEquals("+417600000000", org.getTelecomFirstRep().getValue());
	}

	@Test
	public void testConveniencePatientReligiousAffiliation() {
		final FhirPatient fhirPatient = new FhirPatient();
		final CodeableConcept religion = new CodeableConcept();
		religion.setText("1077");

		fhirPatient.setReligiousAffiliation(religion);

		final Patient patient = fhirPatient.getPatient();
		assertEquals("1077", patient.getReligiousAffiliation());

		final FhirPatient fhirPatient2 = new FhirPatient(patient);

		assertEquals("1077", fhirPatient2.getReligiousAffiliation().getText());
	}

	@Test
	public void testConveniencePatientTelecom() {

		final FhirPatient fhirPatient = new FhirPatient();

		final ContactPoint telHome = new ContactPoint();
		telHome.setUse(ContactPointUse.HOME);
		telHome.setSystem(ContactPointSystem.PHONE);
		telHome.setValue("+4144000000000");

		final ContactPoint telWork = new ContactPoint();
		telWork.setUse(ContactPointUse.WORK);
		telWork.setSystem(ContactPointSystem.PHONE);
		telWork.setValue("+4188000000000");

		final ContactPoint telMobile = new ContactPoint();
		telMobile.setUse(ContactPointUse.MOBILE);
		telMobile.setSystem(ContactPointSystem.PHONE);
		telMobile.setValue("+4176000000000");

		final ContactPoint eMail = new ContactPoint();
		eMail.setUse(ContactPointUse.WORK);
		eMail.setSystem(ContactPointSystem.EMAIL);
		eMail.setValue("xyz@abc.ch");

		fhirPatient.getTelecom().add(telHome);
		fhirPatient.getTelecom().add(telWork);
		fhirPatient.getTelecom().add(telMobile);
		fhirPatient.getTelecom().add(eMail);

		final Patient patient = fhirPatient.getPatient();

		final Map<String, TelecomAddressUse> phones = patient.getTelecoms().getPhones();

		assertEquals(TelecomAddressUse.PRIVATE, phones.get("tel:+4144000000000"));
		assertEquals(TelecomAddressUse.BUSINESS, phones.get("tel:+4188000000000"));
		assertEquals(TelecomAddressUse.MOBILE, phones.get("tel:+4176000000000"));

		final Map<String, TelecomAddressUse> emails = patient.getTelecoms().getEMails();
		assertEquals(TelecomAddressUse.BUSINESS, emails.get("mailto:xyz@abc.ch"));

		final FhirPatient fhirPatient2 = new FhirPatient(patient);

		assertEquals(ContactPointUse.HOME,
				fhirPatient2.getTelecom().get(0).getUseElement().getValue());
		assertEquals(ContactPointSystem.PHONE,
				fhirPatient2.getTelecom().get(0).getSystemElement().getValue());
		assertEquals("+4144000000000", fhirPatient2.getTelecom().get(0).getValue());

		assertEquals(ContactPointUse.WORK,
				fhirPatient2.getTelecom().get(1).getUseElement().getValue());
		assertEquals(ContactPointSystem.PHONE,
				fhirPatient2.getTelecom().get(1).getSystemElement().getValue());
		assertEquals("+4188000000000", fhirPatient2.getTelecom().get(1).getValue());

		assertEquals(ContactPointUse.MOBILE,
				fhirPatient2.getTelecom().get(2).getUseElement().getValue());
		assertEquals(ContactPointSystem.PHONE,
				fhirPatient2.getTelecom().get(2).getSystemElement().getValue());
		assertEquals("+4176000000000", fhirPatient2.getTelecom().get(2).getValue());

		assertEquals(ContactPointUse.WORK,
				fhirPatient2.getTelecom().get(3).getUseElement().getValue());
		assertEquals(ContactPointSystem.EMAIL,
				fhirPatient2.getTelecom().get(3).getSystemElement().getValue());
		assertEquals("xyz@abc.ch", fhirPatient2.getTelecom().get(3).getValue());
	}

	@Test
	public void testFhirPatientAddress() {
		final Name name = new Name("given", "family", "prefix", "suffix");
		final org.ehealth_connector.common.Patient conveniencePatient = new org.ehealth_connector.common.Patient(
				name, org.ehealth_connector.common.enums.AdministrativeGender.MALE, new Date());

		final org.ehealth_connector.common.Address address = new org.ehealth_connector.common.Address(
				"addressline1", "addressline2", "addressline3", "zip", "city",
				PostalAddressUse.PRIVATE);

		address.getMdhtAdress().addCountry("cty");
		address.getMdhtAdress().addState("state");

		conveniencePatient.addAddress(address);

		final FhirPatient fhirPatient = new FhirPatient(conveniencePatient);

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
		final TestPatient patientMueller = TestPatient.getTestPatientMuellerPauline();
		final Patient conveniencePatient = getPatient(patientMueller);
		final FhirPatient fhirPatient = new FhirPatient(conveniencePatient);
		assertEquals(patientMueller.given, fhirPatient.getNameFirstRep().getGivenAsSingleString());
		assertEquals(patientMueller.family, fhirPatient.getNameFirstRep().getFamily());
		assertEquals(patientMueller.getBirthDate(), fhirPatient.getBirthDate());
		assertEquals(patientMueller.gender.toLowerCase(),
				fhirPatient.getGender().toCode().toLowerCase());
	}

	@Test
	public void testFhirPatientLastGivenGenderBirthDayGenderMale() {
		final TestPatient patientMueller = TestPatient.getTestPatientMueller();
		final Patient conveniencePatient = getPatient(patientMueller);
		final FhirPatient fhirPatient = new FhirPatient(conveniencePatient);
		assertEquals(patientMueller.given, fhirPatient.getNameFirstRep().getGivenAsSingleString());
		assertEquals(patientMueller.family, fhirPatient.getNameFirstRep().getFamily());
		assertEquals(patientMueller.getBirthDate(), fhirPatient.getBirthDate());
		assertEquals(patientMueller.gender.toLowerCase(),
				fhirPatient.getGender().toCode().toLowerCase());
	}

	@Test
	public void testFhirPatientMiddleName() {
		final Name name = new Name("given", "family", "prefix", "suffix");
		name.getMdhtPn().addGiven("middle");
		name.getMdhtPn().addFamily("family2");
		name.getMdhtPn().addPrefix("prefix2");
		name.getMdhtPn().addSuffix("suffix2");
		final Patient conveniencePatient = new Patient(name,
				org.ehealth_connector.common.enums.AdministrativeGender.MALE, new Date());
		final FhirPatient fhirPatient = new FhirPatient(conveniencePatient);
		assertEquals("given middle", fhirPatient.getNameFirstRep().getGivenAsSingleString());

		// Note with FHIR DSTU3 Family changed. ONly the latest Family Name
		// remains...
		assertEquals("family2", fhirPatient.getNameFirstRep().getFamily());

		assertEquals("prefix prefix2", fhirPatient.getNameFirstRep().getPrefixAsSingleString());
		assertEquals("suffix suffix2", fhirPatient.getNameFirstRep().getSuffixAsSingleString());
	}

	@Test
	public void testFhirPatientNames() {
		final Name name = new Name("given", "family", "prefix", "suffix");
		final Patient conveniencePatient = new Patient(name,
				org.ehealth_connector.common.enums.AdministrativeGender.MALE, new Date());
		final FhirPatient fhirPatient = new FhirPatient(conveniencePatient);
		assertEquals("given", fhirPatient.getNameFirstRep().getGivenAsSingleString());
		assertEquals("family", fhirPatient.getNameFirstRep().getFamily());
		assertEquals("prefix", fhirPatient.getNameFirstRep().getPrefixAsSingleString());
		assertEquals("suffix", fhirPatient.getNameFirstRep().getSuffixAsSingleString());
	}

	@Test
	public void testFhirSerializeDeserialize() {

		final FhirPatient fhirPatient = TestPatient.getFhirPatientMueller();

		fhirPatient.getManagingOrganization()
				.setResource(getScopingOrganization("1234", "Test", "+417600000000"));

		// telecom
		final ContactPoint telHome = new ContactPoint();
		telHome.setUse(ContactPointUse.HOME);
		telHome.setSystem(ContactPointSystem.PHONE);
		telHome.setValue("+4144000000000");

		final ContactPoint telWork = new ContactPoint();
		telWork.setUse(ContactPointUse.WORK);
		telWork.setSystem(ContactPointSystem.PHONE);
		telWork.setValue("+4188000000000");

		final ContactPoint telMobile = new ContactPoint();
		telMobile.setUse(ContactPointUse.MOBILE);
		telMobile.setSystem(ContactPointSystem.PHONE);
		telMobile.setValue("+4176000000000");

		final ContactPoint eMail = new ContactPoint();
		eMail.setUse(ContactPointUse.WORK);
		eMail.setSystem(ContactPointSystem.EMAIL);
		eMail.setValue("xyz@abc.ch");

		fhirPatient.getTelecom().add(telHome);
		fhirPatient.getTelecom().add(telWork);
		fhirPatient.getTelecom().add(telMobile);
		fhirPatient.getTelecom().add(eMail);

		// communication
		final CodeableConcept deCH = new CodeableConcept();
		deCH.setText("de-CH");

		fhirPatient.getCommunication().add(new PatientCommunicationComponent().setLanguage(deCH));

		final CodeableConcept maritalStatus = new CodeableConcept();
		maritalStatus.setText(V3MaritalStatus.M.toCode());// married
		fhirPatient.setMaritalStatus(maritalStatus);

		final HumanName mothersMaidenName = new HumanName();
		mothersMaidenName.setFamily("Meier");
		fhirPatient.setMothersMaidenName(mothersMaidenName);

		final BooleanType Boolean = new BooleanType();
		Boolean.setValue(false);
		fhirPatient.setDeceased(Boolean);

		final Address Address = new Address();

		Address.setCity("Doncaster");
		fhirPatient.setBirthPlace(Address);

		final CodeableConcept religion = new CodeableConcept();
		religion.setText("1077");
		fhirPatient.setReligiousAffiliation(religion);

		final CodeableConcept nation = new CodeableConcept();
		nation.setText(CountryCode.SWITZERLAND.getCodeAlpha3());
		fhirPatient.setNation(nation);

		final CodeableConcept employeeOccupationCode = new CodeableConcept();
		employeeOccupationCode.setText("employeeOccupationCode");
		fhirPatient.setEmployeeOccupation(employeeOccupationCode);

		final FhirValidator val = ctx.newValidator();
		final ValidationResult result = val.validateWithResult(fhirPatient);
		if (result.isSuccessful()) {
			System.out.println("Validation passed");
		} else {
			// We failed validation!
			System.out.println("Validation failed");
			// The result contains an OperationOutcome outlining the failures
			@SuppressWarnings("deprecation")
			final String results = ctx.newXmlParser().setPrettyPrint(true)
					.encodeResourceToString(result.getOperationOutcome());
			System.out.println(results);
		}
		assertTrue(result.isSuccessful());

		final String stringPatient = ctx.newXmlParser().encodeResourceToString(fhirPatient);

		log.debug(stringPatient);

		final IParser parser = ctx.newXmlParser();
		final FhirPatient fhirPatientDeserialized = parser.parseResource(FhirPatient.class,
				stringPatient);
		assertTrue(fhirPatientDeserialized != null);

	}

}
