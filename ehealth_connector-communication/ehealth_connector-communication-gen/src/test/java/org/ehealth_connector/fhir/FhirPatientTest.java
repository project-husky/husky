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
package org.ehealth_connector.fhir;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.Map;

import org.ehealth_connector.common.Address;
import org.ehealth_connector.common.Name;
import org.ehealth_connector.common.Patient;
import org.ehealth_connector.common.enums.AddressUse;
import org.ehealth_connector.common.enums.AdministrativeGender;
import org.ehealth_connector.common.enums.CountryCode;
import org.ehealth_connector.fhir.testhelper.TestPatient;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.dstu2.composite.AddressDt;
import ca.uhn.fhir.model.dstu2.composite.CodeableConceptDt;
import ca.uhn.fhir.model.dstu2.composite.ContactPointDt;
import ca.uhn.fhir.model.dstu2.composite.HumanNameDt;
import ca.uhn.fhir.model.dstu2.composite.IdentifierDt;
import ca.uhn.fhir.model.dstu2.resource.Organization;
import ca.uhn.fhir.model.dstu2.resource.Patient.Communication;
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
public class FhirPatientTest {

	private final FhirContext ctx = new FhirContext();
	/** The SLF4J logger instance. */
	protected final Logger log = LoggerFactory.getLogger(getClass());

	private Patient getPatient(TestPatient patientMueller) {
		final Name name = new Name(patientMueller.given, patientMueller.family);
		AdministrativeGender gender;
		if ("male".equals(patientMueller.gender)) {
			gender = AdministrativeGender.MALE;
		} else if ("female".equals(patientMueller.gender)) {
			gender = AdministrativeGender.FEMALE;
		} else {
			gender = AdministrativeGender.UNDIFFERENTIATED;
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
			final IdentifierDt identifier = new IdentifierDt();
			identifier.setSystem("urn:oid:" + oid);
			org.getIdentifier().add(identifier);
		}
		if (name != null) {
			org.setName(name);
		}
		if (tel != null) {
			final ContactPointDt fhirTel = org.addTelecom();
			fhirTel.setValue(tel);
		}
		return org;
	}

	@Test
	public void testConveniencePatient() {

		// ALPHA ALAN
		final FhirPatient fhirPatient = new FhirPatient();
		final HumanNameDt humanName = new HumanNameDt().addFamily("ALPHA").addGiven("ALAN");
		fhirPatient.getName().add(humanName);
		final AddressDt address = new AddressDt().addLine("1 PINETREE").setPostalCode("63119")
				.setCity("WEBSTER").setState("MO");
		final IdentifierDt identifier = new IdentifierDt();
		identifier.setValue("PIX");
		identifier.setSystem("urn:oid:2.16.840.1.113883.3.72.5.9.1");
		fhirPatient.getIdentifier().add(identifier);
		fhirPatient.setBirthDate(new DateDt("19380224"));
		fhirPatient.getAddress().add(address);
		fhirPatient.setGender(AdministrativeGenderEnum.MALE);
		fhirPatient.getManagingOrganization().setResource(getScopingOrganization());

		final Patient patient = fhirPatient.getPatient();

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

		final FhirPatient fhirPatientEquals = new FhirPatient(patient);
		final Patient patientEquals = fhirPatientEquals.getPatient();

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
		final FhirPatient fhirPatient = new FhirPatient();

		final AddressDt addressDt = new AddressDt();
		addressDt.setCity("Doncaster");

		fhirPatient.setBirthPlace(addressDt);

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
		final DateTimeDt dateTimeDt = new DateTimeDt(dtNow);

		fhirPatient.setDeceased(dateTimeDt);

		final Patient patient = fhirPatient.getPatient();
		assertEquals(dtNow, patient.getDeceasedTime());

		final FhirPatient fhirPatient2 = new FhirPatient(patient);
		assertEquals(dtNow, ((DateTimeDt) fhirPatient2.getDeceased()).getValue());
	}

	@Test
	public void testConveniencePatientDeceasedIndicator() {
		final FhirPatient fhirPatient = new FhirPatient();
		final BooleanDt booleanDt = new BooleanDt();
		booleanDt.setValue(true);
		fhirPatient.setDeceased(booleanDt);

		final Patient patient = fhirPatient.getPatient();
		assertTrue(patient.getDeceasedInd().booleanValue());

		final FhirPatient fhirPatient2 = new FhirPatient(patient);
		assertTrue(((BooleanDt) fhirPatient2.getDeceased()).getValue().booleanValue());
	}

	@Test
	public void testConveniencePatientEmployeeOccupationCode() {
		final FhirPatient fhirPatient = new FhirPatient();
		final CodeableConceptDt employeeOccupationCode = new CodeableConceptDt();
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
		final CodeableConceptDt deCH = new CodeableConceptDt();
		deCH.setText("de-CH");
		final CodeableConceptDt frCH = new CodeableConceptDt();
		frCH.setText("fr-CH");

		fhirPatient.getCommunication().add(new Communication().setLanguage(deCH));
		fhirPatient.getCommunication().add(new Communication().setLanguage(frCH));

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
	public void testConveniencePatientMaritialStatus() {
		final FhirPatient fhirPatient = new FhirPatient();
		fhirPatient.setMaritalStatus(MaritalStatusCodesEnum.M); // married

		final Patient patient = fhirPatient.getPatient();
		assertEquals("M", patient.getMdhtPatient().getMaritalStatusCode().getCode());

		final FhirPatient fhirPatient2 = new FhirPatient(patient);
		assertEquals("M", fhirPatient2.getMaritalStatus().getValueAsEnum().toArray()[0].toString());
	}

	@Test
	public void testConveniencePatientMothersName() {
		final FhirPatient fhirPatient = new FhirPatient();

		assertTrue(fhirPatient.getMothersMaidenName().isEmpty());

		final HumanNameDt mothersMaidenName = new HumanNameDt();
		mothersMaidenName.addFamily("Wiedmer");
		fhirPatient.setMothersMaidenName(mothersMaidenName);

		assertEquals("Wiedmer", fhirPatient.getMothersMaidenName().getFamilyAsSingleString());

		final Patient patient = fhirPatient.getPatient();
		assertEquals("Wiedmer", patient.getMothersMaidenName());

		final FhirPatient fhirPatient2 = new FhirPatient(patient);
		assertEquals("Wiedmer", fhirPatient2.getMothersMaidenName().getFamilyAsSingleString());
	}

	@Test
	public void testConveniencePatientMultipleBirthIndicator() {
		final FhirPatient fhirPatient = new FhirPatient();
		final BooleanDt booleanDt = new BooleanDt();
		booleanDt.setValue(true);
		fhirPatient.setMultipleBirth(booleanDt);

		final Patient patient = fhirPatient.getPatient();
		assertTrue(patient.getMultipleBirthInd().booleanValue());

		final FhirPatient fhirPatient2 = new FhirPatient(patient);
		assertTrue(((BooleanDt) fhirPatient2.getMultipleBirth()).getValue().booleanValue());
	}

	@Test
	public void testConveniencePatientMultipleBirthOrder() {
		final FhirPatient fhirPatient = new FhirPatient();
		final IntegerDt integerDt = new IntegerDt(2);
		fhirPatient.setMultipleBirth(integerDt);

		final Patient patient = fhirPatient.getPatient();
		assertEquals(2, patient.getMultipleBirthOrderNumber().intValue());

		final FhirPatient fhirPatient2 = new FhirPatient(patient);
		assertEquals(2, ((IntegerDt) fhirPatient2.getMultipleBirth()).getValue().intValue());
	}

	@Test
	public void testConveniencePatientNation() {
		final FhirPatient fhirPatient = new FhirPatient();
		final CodeableConceptDt nation = new CodeableConceptDt();
		nation.setText(CountryCode.SWITZERLAND.getCodeValue());

		fhirPatient.setNation(nation);

		final Patient patient = fhirPatient.getPatient();
		assertEquals(CountryCode.SWITZERLAND.getCodeValue(), patient.getNation());

		final FhirPatient fhirPatient2 = new FhirPatient(patient);

		assertEquals(CountryCode.SWITZERLAND.getCodeValue(), fhirPatient2.getNation().getText());
	}

	@Test
	public void testConveniencePatientOrganization() {
		final FhirPatient fhirPatient = new FhirPatient();
		fhirPatient.getManagingOrganization()
				.setResource(getScopingOrganization("1234", "Test", "+417600000000"));

		ca.uhn.fhir.model.dstu2.resource.Organization org = (ca.uhn.fhir.model.dstu2.resource.Organization) fhirPatient
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
		org = (ca.uhn.fhir.model.dstu2.resource.Organization) fhirPatient2.getManagingOrganization()
				.getResource();

		assertEquals("1234", org.getIdentifierFirstRep().getSystem().substring(8));
		assertEquals("Test", org.getName());
		assertEquals("+417600000000", org.getTelecomFirstRep().getValue());
	}

	@Test
	public void testConveniencePatientReligiousAffiliation() {
		final FhirPatient fhirPatient = new FhirPatient();
		final CodeableConceptDt religion = new CodeableConceptDt();
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

		final ContactPointDt telHome = new ContactPointDt();
		telHome.setUse(ContactPointUseEnum.HOME);
		telHome.setSystem(ContactPointSystemEnum.PHONE);
		telHome.setValue("+4144000000000");

		final ContactPointDt telWork = new ContactPointDt();
		telWork.setUse(ContactPointUseEnum.WORK);
		telWork.setSystem(ContactPointSystemEnum.PHONE);
		telWork.setValue("+4188000000000");

		final ContactPointDt telMobile = new ContactPointDt();
		telMobile.setUse(ContactPointUseEnum.MOBILE);
		telMobile.setSystem(ContactPointSystemEnum.PHONE);
		telMobile.setValue("+4176000000000");

		final ContactPointDt eMail = new ContactPointDt();
		eMail.setUse(ContactPointUseEnum.WORK);
		eMail.setSystem(ContactPointSystemEnum.EMAIL);
		eMail.setValue("xyz@abc.ch");

		fhirPatient.getTelecom().add(telHome);
		fhirPatient.getTelecom().add(telWork);
		fhirPatient.getTelecom().add(telMobile);
		fhirPatient.getTelecom().add(eMail);

		final Patient patient = fhirPatient.getPatient();

		final Map<String, AddressUse> phones = patient.getTelecoms().getPhones();

		assertEquals(AddressUse.PRIVATE, phones.get("tel:+4144000000000"));
		assertEquals(AddressUse.BUSINESS, phones.get("tel:+4188000000000"));
		assertEquals(AddressUse.MOBILE, phones.get("tel:+4176000000000"));

		final Map<String, AddressUse> emails = patient.getTelecoms().getEMails();
		assertEquals(AddressUse.BUSINESS, emails.get("mailto:xyz@abc.ch"));

		final FhirPatient fhirPatient2 = new FhirPatient(patient);

		assertEquals(ContactPointUseEnum.HOME,
				fhirPatient2.getTelecom().get(0).getUseElement().getValueAsEnum());
		assertEquals(ContactPointSystemEnum.PHONE,
				fhirPatient2.getTelecom().get(0).getSystemElement().getValueAsEnum());
		assertEquals("+4144000000000", fhirPatient2.getTelecom().get(0).getValue());

		assertEquals(ContactPointUseEnum.WORK,
				fhirPatient2.getTelecom().get(1).getUseElement().getValueAsEnum());
		assertEquals(ContactPointSystemEnum.PHONE,
				fhirPatient2.getTelecom().get(1).getSystemElement().getValueAsEnum());
		assertEquals("+4188000000000", fhirPatient2.getTelecom().get(1).getValue());

		assertEquals(ContactPointUseEnum.MOBILE,
				fhirPatient2.getTelecom().get(2).getUseElement().getValueAsEnum());
		assertEquals(ContactPointSystemEnum.PHONE,
				fhirPatient2.getTelecom().get(2).getSystemElement().getValueAsEnum());
		assertEquals("+4176000000000", fhirPatient2.getTelecom().get(2).getValue());

		assertEquals(ContactPointUseEnum.WORK,
				fhirPatient2.getTelecom().get(3).getUseElement().getValueAsEnum());
		assertEquals(ContactPointSystemEnum.EMAIL,
				fhirPatient2.getTelecom().get(3).getSystemElement().getValueAsEnum());
		assertEquals("xyz@abc.ch", fhirPatient2.getTelecom().get(3).getValue());
	}

	@Test
	public void testFhirPatientAddress() {
		final Name name = new Name("given", "family", "prefix", "suffix");
		final Patient conveniencePatient = new Patient(name, AdministrativeGender.MALE, new Date());

		final Address address = new Address("addressline1", "addressline2", "addressline3", "zip",
				"city", AddressUse.PRIVATE);

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
		assertEquals(patientMueller.family,
				fhirPatient.getNameFirstRep().getFamilyAsSingleString());
		assertEquals(patientMueller.getBirthDate(), fhirPatient.getBirthDate());
		assertEquals(patientMueller.gender, fhirPatient.getGender());
	}

	@Test
	public void testFhirPatientLastGivenGenderBirthDayGenderMale() {
		final TestPatient patientMueller = TestPatient.getTestPatientMueller();
		final Patient conveniencePatient = getPatient(patientMueller);
		final FhirPatient fhirPatient = new FhirPatient(conveniencePatient);
		assertEquals(patientMueller.given, fhirPatient.getNameFirstRep().getGivenAsSingleString());
		assertEquals(patientMueller.family,
				fhirPatient.getNameFirstRep().getFamilyAsSingleString());
		assertEquals(patientMueller.getBirthDate(), fhirPatient.getBirthDate());
		assertEquals(patientMueller.gender, fhirPatient.getGender());
	}

	@Test
	public void testFhirPatientMiddleName() {
		final Name name = new Name("given", "family", "prefix", "suffix");
		name.getMdhtPn().addGiven("middle");
		name.getMdhtPn().addFamily("family2");
		name.getMdhtPn().addPrefix("prefix2");
		name.getMdhtPn().addSuffix("suffix2");
		final Patient conveniencePatient = new Patient(name, AdministrativeGender.MALE, new Date());
		final FhirPatient fhirPatient = new FhirPatient(conveniencePatient);
		assertEquals("given middle", fhirPatient.getNameFirstRep().getGivenAsSingleString());
		assertEquals("family family2", fhirPatient.getNameFirstRep().getFamilyAsSingleString());
		assertEquals("prefix prefix2", fhirPatient.getNameFirstRep().getPrefixAsSingleString());
		assertEquals("suffix suffix2", fhirPatient.getNameFirstRep().getSuffixAsSingleString());
	}

	@Test
	public void testFhirPatientNames() {
		final Name name = new Name("given", "family", "prefix", "suffix");
		final Patient conveniencePatient = new Patient(name, AdministrativeGender.MALE, new Date());
		final FhirPatient fhirPatient = new FhirPatient(conveniencePatient);
		assertEquals("given", fhirPatient.getNameFirstRep().getGivenAsSingleString());
		assertEquals("family", fhirPatient.getNameFirstRep().getFamilyAsSingleString());
		assertEquals("prefix", fhirPatient.getNameFirstRep().getPrefixAsSingleString());
		assertEquals("suffix", fhirPatient.getNameFirstRep().getSuffixAsSingleString());
	}

	@Test
	public void testFhirSerializeDeserialize() {

		final FhirPatient fhirPatient = TestPatient.getFhirPatientMueller();

		fhirPatient.getManagingOrganization()
				.setResource(getScopingOrganization("1234", "Test", "+417600000000"));

		// telecom
		final ContactPointDt telHome = new ContactPointDt();
		telHome.setUse(ContactPointUseEnum.HOME);
		telHome.setSystem(ContactPointSystemEnum.PHONE);
		telHome.setValue("+4144000000000");

		final ContactPointDt telWork = new ContactPointDt();
		telWork.setUse(ContactPointUseEnum.WORK);
		telWork.setSystem(ContactPointSystemEnum.PHONE);
		telWork.setValue("+4188000000000");

		final ContactPointDt telMobile = new ContactPointDt();
		telMobile.setUse(ContactPointUseEnum.MOBILE);
		telMobile.setSystem(ContactPointSystemEnum.PHONE);
		telMobile.setValue("+4176000000000");

		final ContactPointDt eMail = new ContactPointDt();
		eMail.setUse(ContactPointUseEnum.WORK);
		eMail.setSystem(ContactPointSystemEnum.EMAIL);
		eMail.setValue("xyz@abc.ch");

		fhirPatient.getTelecom().add(telHome);
		fhirPatient.getTelecom().add(telWork);
		fhirPatient.getTelecom().add(telMobile);
		fhirPatient.getTelecom().add(eMail);

		// communication
		final CodeableConceptDt deCH = new CodeableConceptDt();
		deCH.setText("de-CH");

		fhirPatient.getCommunication().add(new Communication().setLanguage(deCH));

		fhirPatient.setMaritalStatus(MaritalStatusCodesEnum.M); // married

		final HumanNameDt mothersMaidenName = new HumanNameDt();
		mothersMaidenName.addFamily("Meier");
		fhirPatient.setMothersMaidenName(mothersMaidenName);

		final BooleanDt booleanDt = new BooleanDt();
		booleanDt.setValue(false);
		fhirPatient.setDeceased(booleanDt);

		final AddressDt addressDt = new AddressDt();

		addressDt.setCity("Doncaster");
		fhirPatient.setBirthPlace(addressDt);

		final CodeableConceptDt religion = new CodeableConceptDt();
		religion.setText("1077");
		fhirPatient.setReligiousAffiliation(religion);

		final CodeableConceptDt nation = new CodeableConceptDt();
		nation.setText(CountryCode.SWITZERLAND.getCodeValue());
		fhirPatient.setNation(nation);

		final CodeableConceptDt employeeOccupationCode = new CodeableConceptDt();
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
