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
package org.husky.fhir.structures.gen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBElement;

import org.hl7.fhir.r4.model.Address;
import org.hl7.fhir.r4.model.BooleanType;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.ContactPoint;
import org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem;
import org.hl7.fhir.r4.model.ContactPoint.ContactPointUse;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.Enumerations.AdministrativeGender;
import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.IntegerType;
import org.hl7.fhir.r4.model.Organization;
import org.hl7.fhir.r4.model.Patient.PatientCommunicationComponent;
import org.hl7.fhir.r4.model.codesystems.V3MaritalStatus;
import org.husky.common.basetypes.AddressBaseType;
import org.husky.common.enums.CountryCode;
import org.husky.common.enums.TelecomAddressUse;
import org.husky.common.hl7cdar2.AdxpCity;
import org.husky.common.hl7cdar2.II;
import org.husky.common.model.Name;
import org.husky.common.model.Patient;
import org.husky.common.model.Telecom;
import org.husky.common.utils.DateUtil;
import org.husky.fhir.structures.testhelper.TestPatient;
import org.junit.jupiter.api.Test;
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
 * @see org.org.husky.fhir.structures.gen.FhirPatient
 */
public class FhirPatientTest {

	private final FhirContext ctx = new FhirContext(FhirVersionEnum.R4);
	/** The SLF4J logger instance. */
	protected final Logger log = LoggerFactory.getLogger(getClass());

	private Patient getPatient(TestPatient patientMueller) {
		final Name name = new Name();
		name.setGiven(patientMueller.given);
		name.setFamily(patientMueller.family);
		org.husky.common.enums.AdministrativeGender gender;
		if ("male".equals(patientMueller.gender.toLowerCase())) {
			gender = org.husky.common.enums.AdministrativeGender.MALE;
		} else if ("female".equals(patientMueller.gender.toLowerCase())) {
			gender = org.husky.common.enums.AdministrativeGender.FEMALE;
		} else {
			gender = org.husky.common.enums.AdministrativeGender.UNDIFFERENTIATED;
		}

		Calendar calendar = new GregorianCalendar();
		calendar.setTime(patientMueller.getBirthDate());
		final Patient conveniencePatient = new Patient(name, gender, calendar);
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
			fhirTel.setSystem(ContactPointSystem.PHONE);
			org.addTelecom(fhirTel);
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
		assertEquals("1 PINETREE", patient.getAddress().getStreetAddressLine1());
		assertEquals("63119", patient.getAddress().getPostalCode());
		assertEquals("WEBSTER", patient.getAddress().getCity());
		assertEquals("ALPHA", patient.getName().getFamily());
		assertEquals("ALAN", patient.getName().getGiven());

		II ii = patient.getMdhtPatientRole()
				.getProviderOrganization().getId().get(0);
		assertEquals("2.16.840.1.113883.3.72.5.9.2", ii.getRoot());

		final FhirPatient fhirPatientEquals = new FhirPatient(patient);
		final Patient patientEquals = fhirPatientEquals.getPatient();

		assertEquals("2.16.840.1.113883.3.72.5.9.1", patientEquals.getIds().get(0).getRoot());
		assertEquals("PIX", patientEquals.getIds().get(0).getExtension());
		assertEquals("1 PINETREE", patientEquals.getAddress().getStreetAddressLine1());
		assertEquals("63119", patientEquals.getAddress().getPostalCode());
		assertEquals("WEBSTER", patientEquals.getAddress().getCity());
		assertEquals("ALPHA", patientEquals.getName().getFamily());
		assertEquals("ALAN", patientEquals.getName().getGiven());

		ii = patientEquals.getMdhtPatientRole().getProviderOrganization().getId().get(0);
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

		AdxpCity city = null;
		for (Serializable element : patient.getMdhtPatient().getBirthplace().getPlace().getAddr().getContent()) {
			if (element instanceof JAXBElement
					&& ((JAXBElement) element).getDeclaredType().equals(AdxpCity.class)) {
				city = ((JAXBElement<AdxpCity>) element).getValue();
			}

		}
		assertEquals("Doncaster", city.getTextContent());

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
		assertEquals("de-CH", patient.getMdhtPatient().getLanguageCommunication().get(0)
				.getLanguageCode().getCode());
		assertEquals("fr-CH", patient.getMdhtPatient().getLanguageCommunication().get(1)
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

		org.hl7.fhir.r4.model.Organization org = (org.hl7.fhir.r4.model.Organization) fhirPatient
				.getManagingOrganization().getResource();

		assertEquals("1234", org.getIdentifierFirstRep().getSystem().substring(8));
		assertEquals("Test", org.getName());
		assertEquals("+417600000000", org.getTelecomFirstRep().getValue());

		final Patient patient = fhirPatient.getPatient();
		assertEquals("Test",
				patient.getMdhtPatientRole().getProviderOrganization().getName().get(0).getMergedXmlMixed());
		assertEquals("1234",
				patient.getMdhtPatientRole().getProviderOrganization().getId().get(0).getRoot());
		assertEquals("tel:+417600000000", patient.getMdhtPatientRole().getProviderOrganization()
				.getTelecom().get(0).getValue());

		final FhirPatient fhirPatient2 = new FhirPatient(patient);
		org = (org.hl7.fhir.r4.model.Organization) fhirPatient2.getManagingOrganization()
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

		final Map<String, TelecomAddressUse> phones = new HashMap<>();
		final Map<String, TelecomAddressUse> emails = new HashMap<>();
		for (Telecom telecom : patient.getTelecoms()) {
			if (telecom.getValue().contains("tel:")) {
				phones.put(telecom.getValue(), telecom.getUsage());
			}

			if (telecom.getValue().contains("mailto:")) {
				emails.put(telecom.getValue(), telecom.getUsage());
			}
		}

		assertEquals(TelecomAddressUse.PRIVATE, phones.get("tel:+4144000000000"));
		assertEquals(TelecomAddressUse.BUSINESS, phones.get("tel:+4188000000000"));
		assertEquals(TelecomAddressUse.MOBILE, phones.get("tel:+4176000000000"));

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
		final Name name = new Name();
		name.setGiven("given");
		name.setFamily("family");
		name.setPrefix("prefix");
		name.setSuffix("suffix");
		final org.husky.common.model.Patient conveniencePatient = new org.husky.common.model.Patient(
				name, org.husky.common.enums.AdministrativeGender.MALE,
				new GregorianCalendar());

		final org.husky.common.model.Address address = new org.husky.common.model.Address(
				new AddressBaseType());
		address.setStreetAddressLine1("addressline1");
		address.setStreetAddressLine2("addressline2");
		address.setPostalCode("zip");
		address.setCity("city");
		address.setUsage(org.husky.common.enums.PostalAddressUse.PRIMARY_HOME);
		address.setCountry("cty");
		address.setState("state");

		conveniencePatient.addAddress(address);

		final FhirPatient fhirPatient = new FhirPatient(conveniencePatient);

		assertEquals("addressline1", fhirPatient.getAddressFirstRep().getLine().get(0).getValue());
		assertEquals("addressline2", fhirPatient.getAddressFirstRep().getLine().get(1).getValue());
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
		final Name name = new Name();
		name.setGiven("given middle");
		name.setFamily("family");
		name.setPrefix("prefix prefix2");
		name.setSuffix("suffix suffix2");

		final Patient conveniencePatient = new Patient(name,
				org.husky.common.enums.AdministrativeGender.MALE, new GregorianCalendar());
		final FhirPatient fhirPatient = new FhirPatient(conveniencePatient);
		assertEquals("given middle", fhirPatient.getNameFirstRep().getGivenAsSingleString());

		// Note with FHIR DSTU3 Family changed. ONly the latest Family Name
		// remains...
		assertEquals("family", fhirPatient.getNameFirstRep().getFamily());

		assertEquals("prefix prefix2", fhirPatient.getNameFirstRep().getPrefixAsSingleString());
		assertEquals("suffix suffix2", fhirPatient.getNameFirstRep().getSuffixAsSingleString());
	}

	@Test
	public void testFhirPatientNames() {
		final Name name = new Name();
		name.setGiven("given");
		name.setFamily("family");
		name.setPrefix("prefix");
		name.setSuffix("suffix");

		final Patient conveniencePatient = new Patient(name,
				org.husky.common.enums.AdministrativeGender.MALE, new GregorianCalendar());
		final FhirPatient fhirPatient = new FhirPatient(conveniencePatient);
		assertEquals("given", fhirPatient.getNameFirstRep().getGivenAsSingleString());
		assertEquals("family", fhirPatient.getNameFirstRep().getFamily());
		assertEquals("prefix", fhirPatient.getNameFirstRep().getPrefixAsSingleString());
		assertEquals("suffix", fhirPatient.getNameFirstRep().getSuffixAsSingleString());
	}

	@Test
	public void testFhirSerializeDeserialize() throws ParseException {

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
		assertNotNull(fhirPatientDeserialized);

	}

}
