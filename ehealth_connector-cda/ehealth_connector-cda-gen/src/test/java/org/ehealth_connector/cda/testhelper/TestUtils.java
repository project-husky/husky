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
package org.ehealth_connector.cda.testhelper;

import java.io.File;
import java.util.Date;
import java.util.Random;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.ehealth_connector.cda.BaseAllergyProblem;
import org.ehealth_connector.cda.BaseProblemEntry;
import org.ehealth_connector.cda.Consumable;
import org.ehealth_connector.common.Address;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Name;
import org.ehealth_connector.common.Organization;
import org.ehealth_connector.common.Patient;
import org.ehealth_connector.common.Performer;
import org.ehealth_connector.common.Telecoms;
import org.ehealth_connector.common.Value;
import org.ehealth_connector.common.enums.AddressUse;
import org.ehealth_connector.common.enums.AdministrativeGender;
import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.utils.DateUtil;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

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

	public static boolean isEqual(BaseAllergyProblem p1, BaseAllergyProblem p2) {
		if (!isEqual(p1.getCode(), p2.getCode()))
			return false;
		if ((p1.getEndDate() != null) && !p1.getEndDate().equals(p2.getEndDate()))
			return false;
		if ((p1.getStartDate() != null) && !p1.getStartDate().equals(p2.getStartDate()))
			return false;
		if (!isEqual(p1.getId(), p2.getId()))
			return false;
		for (int i = 0; i < p1.getValues().size(); i++) {
			if (!isEqual(p1.getValues().get(i), p2.getValues().get(i)))
				return false;
		}
		return true;
	}

	public static boolean isEqual(BaseProblemEntry p1, BaseProblemEntry p2) {
		if (p1 == null) {
			return false;
		}
		return p1.equals(p2);
	}

	public static boolean isEqual(Author a1, Author a2) {
		if (a1.getGln() != null) {
			if (!a1.getGln().equals(a2.getGln()))
				return false;
		}
		for (int i = 0; i < a1.getIds().size(); i++) {
			if (!isEqual(a1.getIds().get(i), a2.getIds().get(i)))
				return false;
		}
		return true;
	}

	public static boolean isEqual(Code c1, Code c2) {
		if ((c1 == null) && (c2 == null)) {
			return true;
		}
		if (((c1 != null) && (c2 == null)) || ((c1 == null) && (c2 != null)))
			return false;
		if (!c1.getCode().equals(c2.getCode()))
			return false;
		if (c1.getCodeSystem() != null) {
			if (!c1.getCodeSystem().equals(c2.getCodeSystem()))
				return false;
		} else {
			if (c2.getCodeSystem() != null)
				return false;
		}
		if (c1.getDisplayName() != null) {
			if (!c1.getDisplayName().equals(c2.getDisplayName()))
				return false;
		} else {
			if (c2.getDisplayName() != null)
				return false;
		}
		return true;
	}

	public static boolean isEqual(Consumable c1, Consumable c2) {
		if (!isEqual(c1.getManufacturedMaterialCode(), c2.getManufacturedMaterialCode()))
			return false;
		if (!isEqual(c1.getManufacturedProductId(), c2.getManufacturedProductId()))
			return false;
		if (!c1.getTradeName().equals(c2.getTradeName()))
			return false;
		if (!isEqual(c1.getWhoAtcCode(), c2.getWhoAtcCode()))
			return false;
		return true;
	}

	public static boolean isEqual(Identificator i1, Identificator i2) {
		if (!i1.getRoot().equals(i2.getRoot()))
			return false;
		if (!i1.getExtension().equals(i2.getExtension()))
			return false;
		return true;
	}

	public static boolean isEqual(Name n1, Name n2) {
		if (!n1.getPrefixes().equals(n2.getPrefixes()))
			return false;
		if (!n1.getAllGivenNames().equals(n2.getAllGivenNames()))
			return false;
		if (!n1.getFamilyNames().equals(n2.getFamilyNames()))
			return false;
		if (!n1.getSuffixes().equals(n2.getSuffixes()))
			return false;
		return true;
	}

	public static boolean isEqual(Organization o1, Organization o2) {
		if (!o1.getId().equals(o2.getId()))
			return false;
		if (!o1.getName().equals(o2.getName()))
			return false;
		if (!isEqual(o1.getTelecoms(), o2.getTelecoms()))
			return false;
		return true;
	}

	public static boolean isEqual(Patient p1, Patient p2) {
		if (!isEqual(p1.getName(), p2.getName()))
			return false;
		if (!isEqual(p1.getAdministrativeGenderCode().getCode(),
				p2.getAdministrativeGenderCode().getCode()))
			return false;
		if (p1.getBirthday().getTime() != p1.getBirthday().getTime())
			return false;
		return true;
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

	// Compare Test Objects
	public static boolean isEqual(Value v1, Value v2) {
		// Check Code
		if (v1.getCode() != null) {
			if (!isEqual(v1.getCode(), v2.getCode()))
				return false;
			if (!v1.isCode() == v2.isCode())
				return false;
		}

		// Check PQ
		if (v1.getPhysicalQuantityUnit() != null) {
			if (!v1.getPhysicalQuantityUnit().equals(v2.getPhysicalQuantityUnit()))
				return false;
			if (!v1.isPhysicalQuantity() == v2.isPhysicalQuantity())
				return false;
		}

		if (v1.getPhysicalQuantityValue() != null) {
			if (!v1.getPhysicalQuantityValue().equals(v2.getPhysicalQuantityValue()))
				return false;
		}

		return true;
	}

	public Address address1;
	public Author author1;

	public Author author2;
	public Code code1;
	public Code code2;
	public Date endDate;
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
	public Organization organization1;
	public Patient patient1;

	public Code problemCode;

	public Date startDate;
	public String startDateString;

	public Telecoms telecoms1;

	public String telS1;

	public String telS2;

	public String ts1;

	public String ts2;

	public String ts3;

	public String ts4;

	public String ts5;

	public Value value1;

	public Value value2;

	protected XPath xpath;

	protected XPathFactory xpathFactory;

	public TestUtils() {
		xpathFactory = XPathFactory.newInstance();
		xpath = xpathFactory.newXPath();
	}

	public Address createAddress1() {
		final Address a = new Address("Baurat-Gerber-Str.", "18", "37073", "Göttingen",
				AddressUse.BUSINESS);
		return a;
	}

	public Author createAuthor1() {
		final Author a = new Author(createName1(), numS1);
		return a;
	}

	public Author createAuthor2() {
		final Author a = new Author(createName2(), numS2);
		return a;
	}

	// Create Test Objects
	public Code createCode1() {
		final Code code = new Code(ts1, ts2, ts3, ts4);
		return code;
	}

	public Code createCode2() {
		final Code code = new Code(ts5, ts4, ts3, ts2);
		return code;
	}

	public Code createGtinCode() {
		final Code code = new Code(CodeSystems.GTIN, ts3);
		return code;
	}

	public Identificator createIdentificator1() {
		final Identificator id = new Identificator(CodeSystems.GLN, numS1);
		return id;
	}

	public Identificator createIdentificator2() {
		final Identificator id = new Identificator(CodeSystems.ICD10, numS2);
		return id;
	}

	public Name createName1() {
		final Name n = new Name(ts1, ts2, ts3, ts4);
		return n;
	}

	public Name createName2() {
		final Name n = new Name(ts5, ts4, ts3, ts2);
		return n;
	}

	public Organization createOrganization1() {
		final Organization o = new Organization(ts1, numS1);
		o.setTelecoms(telecoms1);
		telecoms1.addEMail("testMail", AddressUse.BUSINESS);
		telecoms1.addPhone(numS1, AddressUse.PRIVATE);
		return o;
	}

	public Patient createPatient() {
		Patient patient = new Patient(createName1(), AdministrativeGender.FEMALE,
				createStartDate());
		patient.addAddress(createAddress1());
		patient.setBirthday(createStartDate());
		patient.setTelecoms(createTelecoms1());
		return patient;
	}

	public Performer createPerformer1() {
		final Performer p = new Performer(createName1(), numS1);
		return p;
	}

	public Performer createPerformer2() {
		final Performer p = new Performer(createName2(), numS2);
		return p;
	}

	public Date createStartDate() {
		return DateUtil.date("15.12.2014");
	}

	public Telecoms createTelecoms1() {
		final Telecoms t = new Telecoms();
		t.addEMail(telS1, AddressUse.BUSINESS);
		t.addEMail(telS2, AddressUse.PRIVATE);
		t.addFax(telS1, AddressUse.BUSINESS);
		t.addFax(telS2, AddressUse.PRIVATE);
		t.addPhone(telS1, AddressUse.BUSINESS);
		t.addPhone(telS2, AddressUse.PRIVATE);
		return t;
	}

	protected Value createValue1() {
		final Value value = new Value("500", "ml");
		return value;
	}

	protected Value createValue2() {
		final Value value = new Value(ts1, ts2);
		return value;
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

		startDate = DateUtil.date("28.02.2015");
		endDate = DateUtil.date("28.02.2018");

		// Test String with German, French and Italic special characters
		ts1 = TestUtils.generateString(NUMBER_OF_RANDOM_STRING_LETTERS);
		ts2 = TestUtils.generateString(NUMBER_OF_RANDOM_STRING_LETTERS);
		ts3 = TestUtils.generateString(NUMBER_OF_RANDOM_STRING_LETTERS);
		ts4 = TestUtils.generateString(NUMBER_OF_RANDOM_STRING_LETTERS);
		ts5 = TestUtils.generateString(NUMBER_OF_RANDOM_STRING_LETTERS);
		numS1 = "1231425352";
		numS2 = "987653";
		number = 121241241.212323;
		telS1 = "+41.32.234.66.77";
		telS2 = "+44.32.234.66.99";

		// Convenience API Types
		code1 = createCode1();
		code2 = createCode2();
		loincCode = new Code("2.16.840.1.113883.6.1", numS1);
		problemCode = new Code("2.16.840.1.113883.6.139", numS2);
		value1 = createValue1();
		value2 = createValue2();
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
	}

	public boolean xCount(Document document, String xPath, int numberOfElements)
			throws XPathExpressionException {
		XPathExpression expr = xpath.compile(xPath);
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		if (nodes.getLength() == numberOfElements)
			return true;
		else
			return false;
	}

	public boolean xExist(Document document, String xPath) throws XPathExpressionException {
		XPathExpression expr = xpath.compile(xPath);
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		if (nodes.getLength() == 1)
			return true;
		else
			return false;
	}

	public boolean xExistTemplateId(Document document, String templateIdRoot,
			String templateIdExtension) throws XPathExpressionException {
		if (templateIdExtension == null) {
			return xExist(document, "//templateId[@root='" + templateIdRoot + "']");
		} else {
			return xExist(document, "//templateId[@root='" + templateIdRoot + "' and @extension='"
					+ templateIdExtension + "']");
		}
	}
}
