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
package org.projecthusky.cda;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.Serializable;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.xml.bind.JAXBElement;

import org.projecthusky.cda.elga.generated.artdecor.enums.EImpfImpfrollenVs;
import org.projecthusky.cda.elga.models.Appendix;
import org.projecthusky.cda.elga.models.PatientCdaAt;
import org.projecthusky.cda.elga.models.PerformerAt;
import org.projecthusky.cda.elga.models.PractitionerCdaAt;
import org.projecthusky.common.at.OrganizationAt;
import org.projecthusky.common.at.PatientAt;
import org.projecthusky.common.at.PractitionerAt;
import org.projecthusky.common.at.enums.CodeSystems;
import org.projecthusky.common.basetypes.AddressBaseType;
import org.projecthusky.common.basetypes.IdentificatorBaseType;
import org.projecthusky.common.basetypes.NameBaseType;
import org.projecthusky.common.basetypes.OrganizationBaseType;
import org.projecthusky.common.basetypes.TelecomBaseType;
import org.projecthusky.common.enums.AdministrativeGender;
import org.projecthusky.common.enums.PostalAddressUse;
import org.projecthusky.common.enums.TelecomAddressUse;
import org.projecthusky.common.hl7cdar2.AdxpCity;
import org.projecthusky.common.hl7cdar2.AdxpCountry;
import org.projecthusky.common.hl7cdar2.AdxpHouseNumber;
import org.projecthusky.common.hl7cdar2.AdxpPostalCode;
import org.projecthusky.common.hl7cdar2.AdxpState;
import org.projecthusky.common.hl7cdar2.AdxpStreetAddressLine;
import org.projecthusky.common.hl7cdar2.AdxpStreetName;
import org.projecthusky.common.hl7cdar2.EnFamily;
import org.projecthusky.common.hl7cdar2.EnGiven;
import org.projecthusky.common.hl7cdar2.EnPrefix;
import org.projecthusky.common.hl7cdar2.EnSuffix;
import org.projecthusky.common.hl7cdar2.INT;
import org.projecthusky.common.hl7cdar2.IVLINT;
import org.projecthusky.common.hl7cdar2.IVLPQ;
import org.projecthusky.common.hl7cdar2.IVLTS;
import org.projecthusky.common.hl7cdar2.PQ;
import org.projecthusky.common.hl7cdar2.QTY;
import org.projecthusky.common.hl7cdar2.TS;
import org.projecthusky.common.model.Address;
import org.projecthusky.common.model.Code;
import org.projecthusky.common.model.Identificator;
import org.projecthusky.common.model.Name;
import org.projecthusky.common.model.Telecom;
import org.projecthusky.common.model.Telecoms;

public class TestUtils {

	public static final int NUMBER_OF_RANDOM_STRING_LETTERS = 129;

	public static String generateString(int length) {
		final Random rng = new Random();
		final String characters = "abcëÙdÀÿeŒfúgËÛùhijàÊkÇlŸmœ�?çÚnÔÈoæûèp»ÙÈqùôêîïÆrsâÉtéÎuvwèxylïäüìöÄ�?ÒÜÂÖÌ?ßÓ/òó:#\\í�?~*É'é,´Àà";

		final char[] text = new char[length];
		for (int i = 0; i < length; i++) {
			text[i] = characters.charAt(rng.nextInt(characters.length()));
		}
		return new String(text);
	}

	public static boolean isEqual(PractitionerAt a1, PractitionerAt a2) {
		if (a1.getIdentifier() == null || a1.getIdentifier().isEmpty() || a2.getIdentifier() == null
				|| a2.getIdentifier().isEmpty()) {
			return false;
		}
		for (int i = 0; i < a1.getIdentifier().size(); i++) {
			if (!a1.getIdentifier().get(i).equals(a2.getIdentifier().get(i)))
				return false;
		}
		return true;
	}

	public static boolean isEqual(IVLTS time1, String lowTime, String highTime) {
		boolean result = true;
		if (time1 == null || time1.getRest() == null) {
			return false;
		}

		for (JAXBElement<? extends QTY> element : time1.getRest()) {
			if (element == null) {
				return false;
			}

			if ("low".equalsIgnoreCase(element.getName().getLocalPart()) && element.getValue() instanceof TS
					&& !((TS) element.getValue()).getValue()
							.equalsIgnoreCase(lowTime)) {
				result = false;
			} else if ("high".equalsIgnoreCase(element.getName().getLocalPart()) && element.getValue() instanceof TS
					&& !((TS) element.getValue()).getValue()
							.equalsIgnoreCase(highTime)) {
				result = false;
			}

		}

		return result;
	}

	@SuppressWarnings("unlikely-arg-type")
	public static boolean isEqual(Telecoms t1, Telecoms t2) {
		if (t1.getEMails() != null) {
			for (int i = 0; i < t1.getEMails().size(); i++) {
				if (t1.getEMails().get(i) != t2.getEMails().get(i))
					return false;
			}
		}
		if (t1.getFaxes() != null) {
			for (int i = 0; i < t1.getFaxes().size(); i++) {
				if (t1.getFaxes().get(i) != t2.getFaxes().get(i))
					return false;
			}
		}
		if (t1.getPhones() != null) {
			for (int i = 0; i < t1.getPhones().size(); i++) {
				if (t1.getPhones().get(i) != t2.getPhones().get(i))
					return false;
			}
		}

		return true;
	}

	public boolean isEqual(IVLPQ ivlpq, String expectedLowValue, String expectedHighValue, String expectedUnit) {
		boolean result = true;
		boolean expectNullFlavor = false;
		if (ivlpq == null || ivlpq.getRest() == null) {
			return false;
		}

		if (expectedHighValue == null) {
			expectNullFlavor = true;
		}

		for (JAXBElement<? extends PQ> element : ivlpq.getRest()) {
			if (element == null) {
				return false;
			}

			if ("low".equalsIgnoreCase(element.getName().getLocalPart()) && element.getValue() instanceof PQ
					&& (!((PQ) element.getValue()).getValue()
							.equalsIgnoreCase(expectedLowValue)
							|| !((PQ) element.getValue()).getUnit()
									.equalsIgnoreCase(expectedUnit))) {
				result = false;
			} else if (!expectNullFlavor && "high".equalsIgnoreCase(element.getName().getLocalPart())
					&& element.getValue() instanceof PQ
					&& !((PQ) element.getValue()).getValue()
							.equalsIgnoreCase(expectedHighValue)) {
				result = false;
			} else if (expectNullFlavor && "high".equalsIgnoreCase(element.getName().getLocalPart())
					&& (element.getValue().getNullFlavor() == null || element.getValue().getNullFlavor().isEmpty())) {
				result = false;
			}
		}

		return result;
	}

	public boolean isEqual(IVLINT ivlint, Integer expectedLowValue, Integer expectedHighValue) {
		boolean result = true;
		boolean expectNullFlavor = false;
		if (ivlint == null || ivlint.getRest() == null) {
			return false;
		}

		if (expectedHighValue == null) {
			expectNullFlavor = true;
		}

		for (JAXBElement<? extends INT> element : ivlint.getRest()) {
			if (element == null) {
				return false;
			}

			if ("low".equalsIgnoreCase(element.getName().getLocalPart()) && element.getValue() instanceof INT
					&& ((INT) element.getValue()).getValue()
							.intValue() != expectedLowValue) {
				result = false;
			} else if (!expectNullFlavor && "high".equalsIgnoreCase(element.getName().getLocalPart())
					&& element.getValue() instanceof INT
					&& ((INT) element.getValue()).getValue()
							.intValue() != expectedHighValue) {
				result = false;
			} else if (expectNullFlavor && "high".equalsIgnoreCase(element.getName().getLocalPart())
					&& (element.getValue().getNullFlavor() != null && !element.getValue().getNullFlavor().isEmpty())) {
				result = false;
			}
		}

		return result;
	}

	public void testAddress(List<Serializable> list, String streetname, String buildingNumber, String postalCode,
			String city, String state, String country, String addressline1, String addressline2) {
		assertNotNull(list);
		for (Serializable element : list) {
			assertNotNull(element);

			if (element instanceof JAXBElement) {
				JAXBElement<?> elem = (JAXBElement<?>) element;
				if (elem.getValue() instanceof AdxpStreetName) {
					AdxpStreetName obj = (AdxpStreetName) elem.getValue();
					assertEquals(streetname, obj.getMergedXmlMixed());
				} else if (elem.getValue() instanceof AdxpHouseNumber) {
					AdxpHouseNumber obj = (AdxpHouseNumber) elem.getValue();
					assertEquals(buildingNumber, obj.getMergedXmlMixed());
				} else if (elem.getValue() instanceof AdxpPostalCode) {
					AdxpPostalCode obj = (AdxpPostalCode) elem.getValue();
					assertEquals(postalCode, obj.getMergedXmlMixed());
				} else if (elem.getValue() instanceof AdxpCity) {
					AdxpCity obj = (AdxpCity) elem.getValue();
					assertEquals(city, obj.getMergedXmlMixed());
				} else if (elem.getValue() instanceof AdxpCountry) {
					AdxpCountry obj = (AdxpCountry) elem.getValue();
					assertEquals(country, obj.getMergedXmlMixed());
				} else if (elem.getValue() instanceof AdxpState) {
					AdxpState obj = (AdxpState) elem.getValue();
					assertEquals(state, obj.getMergedXmlMixed());
				} else if (elem.getValue() instanceof AdxpStreetAddressLine) {
					AdxpStreetAddressLine obj = (AdxpStreetAddressLine) elem.getValue();
					assertTrue(addressline1.equalsIgnoreCase(obj.getMergedXmlMixed())
							|| addressline2.equalsIgnoreCase(obj.getMergedXmlMixed()));
				}
			}
		}
	}

	public void testName(List<Serializable> list, String prefix, String suffix, String givenName, String familyName) {
		assertNotNull(list);
		for (Serializable element : list) {
			assertNotNull(element);

			if (element != null) {
				JAXBElement<?> elem = (JAXBElement<?>) element;
				if (elem.getValue() instanceof EnFamily) {
					EnFamily obj = (EnFamily) elem.getValue();
					assertEquals(familyName, obj.getMergedXmlMixed());
				} else if (elem.getValue() instanceof EnGiven) {
					EnGiven obj = (EnGiven) elem.getValue();
					assertEquals(givenName, obj.getMergedXmlMixed());
				} else if (elem.getValue() instanceof EnPrefix) {
					EnPrefix obj = (EnPrefix) elem.getValue();
					assertEquals(prefix, obj.getMergedXmlMixed());
				} else if (elem.getValue() instanceof EnSuffix) {
					EnSuffix obj = (EnSuffix) elem.getValue();
					assertEquals(suffix, obj.getMergedXmlMixed());
				}
			}
		}
	}

	public Address address1;
	public PractitionerCdaAt author1;

	public PractitionerCdaAt author2;
	public Code code1;
	public Code code2;
	public ZonedDateTime endDate;
	public String endDateString;
	public Code gtinCode;
	public Identificator id1;
	public Identificator id2;
	public Code loincCode;
	public Name name1;
	public Name name2;
	public Double number;
	public String numS1;
	public String numS2;
	public OrganizationAt organization1;
	public PatientAt patient1;
	public Appendix appendix;

	public Code problemCode;

	public ZonedDateTime startDate;
	public String startDateString;

	public List<Telecom> telecoms1;

	public String telS1;

	public String telS2;

	public String ts1;

	public String ts2;

	public String ts3;

	public String ts4;

	public String ts5;

	public TestUtils() {

	}

	public Address createAddress1() {
		final Address address = new Address(new AddressBaseType());
		address.setStreetName("Teststraße");
		address.setBuildingNumber("54a");
		address.setCity("Wien");
		address.setPostalCode("1040");
		address.setCountry("Austria");
		address.setUsage(PostalAddressUse.WORK_PLACE);
		return address;
	}

	public PractitionerCdaAt createAuthor1() {
		final PractitionerCdaAt a = new PractitionerCdaAt();
		a.setNames(Arrays.asList(createName1()));
		a.setIdentifier(Arrays.asList(new Identificator(numS1)));
		a.setAddresses(Arrays.asList(createAddress1()));
		a.setTelecom(createTelecoms1());
		a.setCode(createCode1());
		a.setSpeciality(createCode2());
		a.setOrganization(createOrganization1());
		return a;
	}

	public PractitionerCdaAt createAuthor2() {
		final PractitionerCdaAt a = new PractitionerCdaAt();
		a.setNames(Arrays.asList(createName2()));
		a.setIdentifier(Arrays.asList(new Identificator(numS2)));
		a.setOrganization(createOrganization1());
		return a;
	}

	// Create Test Objects
	public Code createCode1() {
		final Code code = new Code();
		code.setCode(ts1);
		code.setCodeSystem(ts2);
		code.setCodeSystemName(ts3);
		code.setDisplayName(ts4);
		return code;
	}

	public Code createCode2() {
		final Code code = new Code();
		code.setCode(ts5);
		code.setCodeSystem(ts4);
		code.setCodeSystemName(ts3);
		code.setDisplayName(ts2);
		return code;
	}

	public Code createGtinCode() {
		final Code code = new Code();
		code.setCode(ts3);
		code.setCodeSystem(CodeSystems.GTIN.getCodeSystemId());
		return code;
	}

	public Code createLoincCode() {
		final Code code = new Code();
		code.setCode(numS1);
		code.setCodeSystem("2.16.840.1.113883.6.1");
		return code;
	}

	public Code createProblemCode() {
		final Code code = new Code();
		code.setCode(numS2);
		code.setCodeSystem("2.16.840.1.113883.6.139");
		return code;
	}

	public Identificator createIdentificator1() {
		final Identificator id = new Identificator(CodeSystems.GLN.getCodeSystemId(), numS1);
		return id;
	}

	public Identificator createIdentificator2() {
		final Identificator id = new Identificator(CodeSystems.ICD10.getCodeSystemId(), numS2);
		return id;
	}

	public Name createName1() {
		final Name name = new Name();
		name.setPrefix(ts1);
		name.setSuffix(ts2);
		name.setGiven(ts3);
		name.setFamily(ts4);
		return name;
	}

	public Name createName2() {
		final Name name = new Name();
		name.setPrefix(ts5);
		name.setSuffix(ts4);
		name.setGiven(ts3);
		name.setFamily(ts2);
		return name;
	}

	public OrganizationAt createOrganization1() {
		final OrganizationAt o = new OrganizationAt(new OrganizationBaseType());
		ArrayList<NameBaseType> names = new ArrayList<>();
		NameBaseType name = new NameBaseType();
		name.setName(ts1);
		names.add(name);
		o.setNameList(names);

		ArrayList<IdentificatorBaseType> identificatorList = new ArrayList<>();
		IdentificatorBaseType id = new IdentificatorBaseType();
		id.setExtension(numS1);
		identificatorList.add(id);
		o.setIdentificatorList(identificatorList);

		ArrayList<TelecomBaseType> telecomList = new ArrayList<>();
		TelecomBaseType telecom = new TelecomBaseType();
		telecom.setMail("testMail");
		telecom.setUsage(TelecomAddressUse.BUSINESS);
		telecomList.add(telecom);
		TelecomBaseType telecom1 = new TelecomBaseType();
		telecom1.setPhone(numS1);
		telecom1.setUsage(TelecomAddressUse.PRIVATE);
		telecomList.add(telecom1);
		o.setTelecomList(telecomList);

		return o;
	}

	public PatientCdaAt createPatient() {
		PatientCdaAt patient = new PatientCdaAt();
		patient.addName(createName1());
		patient.setAdministrativeGender(AdministrativeGender.FEMALE);
		patient.setBirthday(createStartDate());
		patient.addAddress(createAddress1());
		patient.setTelecoms(createTelecoms1());
		return patient;
	}

	public PerformerAt createPerformer1() {
		final PerformerAt a = new PerformerAt();
		a.addName(createName1());
		a.addId(new Identificator(numS1));
		a.addAddress(createAddress1());
		a.getTelecoms().addAll(createTelecoms1());
		a.setOrganization(createOrganization1());
		a.setImmunizationRole(
				EImpfImpfrollenVs.DIPLOMIERTE_GESUNDHEITS_UND_KRANKENSCHWESTER_DIPLOMIERTER_GESUNDHEITS_UND_KRANKENPFLEGER
						.getCode());
		return a;
	}

	public PerformerAt createPerformer2() {
		final PerformerAt a = new PerformerAt();
		a.addName(createName2());
		a.addId(new Identificator(numS2));
		a.setOrganization(createOrganization1());
		a.setImmunizationRole(EImpfImpfrollenVs.FACH_RZTIN_FACHARZT.getCode());
		return a;
	}

	public ZonedDateTime createStartDate() {
		return ZonedDateTime.of(2020, 4, 6, 0, 0, 0, 0, ZoneId.systemDefault());
	}

	public List<Telecom> createTelecoms1() {
		List<Telecom> telecoms = new ArrayList<>();

		final Telecom t = new Telecom();
		t.setMail(telS1);
		t.setUsage(TelecomAddressUse.BUSINESS);
		telecoms.add(t);

		final Telecom t1 = new Telecom();
		t1.setMail(telS2);
		t1.setUsage(TelecomAddressUse.PRIVATE);
		telecoms.add(t1);

		final Telecom t2 = new Telecom();
		t2.setFax(telS1);
		t2.setUsage(TelecomAddressUse.BUSINESS);
		telecoms.add(t2);

		final Telecom t3 = new Telecom();
		t3.setFax(telS2);
		t3.setUsage(TelecomAddressUse.PRIVATE);
		telecoms.add(t3);

		final Telecom t4 = new Telecom();
		t4.setPhone(telS1);
		t4.setUsage(TelecomAddressUse.BUSINESS);
		telecoms.add(t4);

		final Telecom t5 = new Telecom();
		t5.setPhone(telS2);
		t5.setUsage(TelecomAddressUse.PRIVATE);
		telecoms.add(t5);

		return telecoms;
	}

	protected Appendix createPdfAttachment() {
		Appendix appendix = new Appendix();
		appendix.setMediaType("application/pdf");
		appendix.setDocument(generateString(NUMBER_OF_RANDOM_STRING_LETTERS));
		return appendix;
	}

	public String getTempFilePath(String aFileName) {
		String tmpPath = "";
		if (System.getProperty("java.io.tmpdir") != null) {
			tmpPath = System.getProperty("java.io.tmpdir");
		} else if (System.getenv("TMP") != null) {
			tmpPath = System.getenv("TMP");
		} else if (System.getenv("TEMP") != null) {
			tmpPath = System.getenv("TEMP");
		}
		tmpPath += File.separator + aFileName;
		return tmpPath;
	}

	public void init() {

		// Dates
		startDateString = "28.02.2015";
		endDateString = "28.02.2018";

		startDate = ZonedDateTime.of(2019, 9, 28, 0, 0, 0, 0, ZoneId.systemDefault());
		endDate = ZonedDateTime.of(2020, 2, 21, 0, 0, 0, 0, ZoneId.systemDefault());

		// Test String with German, French and Italic special characters
		ts1 = TestUtils.generateString(NUMBER_OF_RANDOM_STRING_LETTERS);
		ts2 = TestUtils.generateString(NUMBER_OF_RANDOM_STRING_LETTERS);
		ts3 = TestUtils.generateString(NUMBER_OF_RANDOM_STRING_LETTERS);
		ts4 = TestUtils.generateString(NUMBER_OF_RANDOM_STRING_LETTERS);
		ts5 = TestUtils.generateString(NUMBER_OF_RANDOM_STRING_LETTERS);
		numS1 = "1231425352";
		numS2 = "987653";
		number = 121241241.212323;
		telS1 = "+43.32.234.66.77";
		telS2 = "+44.32.234.66.99";

		// Convenience API Types
		code1 = createCode1();
		code2 = createCode2();
		loincCode = createLoincCode();
		problemCode = createProblemCode();
		gtinCode = createGtinCode();
		id1 = createIdentificator1();
		id2 = createIdentificator2();
		telecoms1 = createTelecoms1();
		name1 = createName1();
		name2 = createName2();
		author1 = createAuthor1();
		author2 = createAuthor2();
		organization1 = createOrganization1();
		address1 = createAddress1();

		// Patient
		patient1 = createPatient();

		// Different CDA elements
		appendix = createPdfAttachment();
	}

}
