/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
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
package org.ehealth_connector.communication.testhelper;

import java.io.File;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.ehealth_connector.common.Address;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Name;
import org.ehealth_connector.common.Organization;
import org.ehealth_connector.common.Patient;
import org.ehealth_connector.common.Telecom;
import org.ehealth_connector.common.basetypes.AddressBaseType;
import org.ehealth_connector.common.basetypes.IdentificatorBaseType;
import org.ehealth_connector.common.basetypes.NameBaseType;
import org.ehealth_connector.common.basetypes.OrganizationBaseType;
import org.ehealth_connector.common.basetypes.TelecomBaseType;
import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.TelecomAddressUse;
import org.ehealth_connector.common.mdht.Performer;
import org.ehealth_connector.common.mdht.Value;
import org.ehealth_connector.common.mdht.enums.AdministrativeGender;
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

	public static boolean isEqual(Identificator i1, Identificator i2) {
		if (!i1.getRoot().equals(i2.getRoot()))
			return false;
		if (!i1.getExtension().equals(i2.getExtension()))
			return false;
		return true;
	}

	public static boolean isEqual(Name n1, Name n2) {
		if (!n1.getPrefix().equals(n2.getPrefix()))
			return false;
		if (!n1.getGiven().equals(n2.getGiven()))
			return false;
		if (!n1.getFamily().equals(n2.getFamily()))
			return false;
		if (!n1.getSuffix().equals(n2.getSuffix()))
			return false;
		return true;
	}

	public static boolean isEqual(Organization o1, Organization o2) {
		if (!o1.getPrimaryIdentificator().equals(o2.getPrimaryIdentificator()))
			return false;
		if (!o1.getPrimaryName().equals(o2.getPrimaryName()))
			return false;
		if (!isEquals(o1.getTelecomList(), o2.getTelecomList()))
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

	public static boolean isEqual(Telecom t1, Telecom t2) {

		if (t1 == null && t2 == null) {
			return true;
		}

		if (t1.getValue() == null && t2.getValue() == null && t1.getUsage() == null && t2.getUsage() == null) {
			return true;
		}

		if (t1.getValue() == null && t2.getValue() == null && t1.getUsage() != null
				&& t1.getUsage().equals(t2.getUsage())) {
			return true;
		}

		if (t1.getValue() != null && t1.getValue().equalsIgnoreCase(t2.getValue()) && t1.getUsage() == null
				&& t2.getUsage() == null) {
			return true;
		}

		if (t1.getValue().equals(t2.getValue()) && t1.getUsage().equals(t2.getUsage())) {
			return true;
		}

		return false;
	}

	public static boolean isEquals(List<TelecomBaseType> t1, List<TelecomBaseType> t2) {
		for (TelecomBaseType t : t1) {
			if (t != null) {
				if (!t2.contains(t)) {
					return false;
				}
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

	public List<TelecomBaseType> telecoms1;

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
		final Address a = new Address(new AddressBaseType());
		a.setStreetName("Baurat-Gerber-Str.");
		a.setBuildingNumber("18");
		a.setPostalCode("37073");
		a.setCity("Göttingen");
		a.setUsage(org.ehealth_connector.common.enums.PostalAddressUse.WORK_PLACE);
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
		final Code code = new Code(ts1, ts2, ts3);
		return code;
	}

	public Code createCode2() {
		final Code code = new Code(ts5, ts4, ts3);
		return code;
	}

	public Code createGtinCode() {
		final Code code = new Code(CodeSystems.GTIN.getCodeSystemId(), ts3, null);
		return code;
	}

	public Identificator createIdentificator1() {
		final Identificator id = new Identificator();
		id.setRoot(CodeSystems.GLN.getCodeSystemId());
		id.setExtension(numS1);
		return id;
	}

	public Identificator createIdentificator2() {
		final Identificator id = new Identificator();
		id.setRoot(CodeSystems.ICD10.getCodeSystemId());
		id.setExtension(numS2);
		return id;
	}

	public Name createName1() {
		final Name n = new Name();
		n.setGiven(ts1);
		n.setFamily(ts2);
		n.setPrefix(ts3);
		n.setSuffix(ts4);
		return n;
	}

	public Name createName2() {
		final Name n = new Name();
		n.setGiven(ts5);
		n.setFamily(ts4);
		n.setPrefix(ts3);
		n.setSuffix(ts2);
		return n;
	}

	public Organization createOrganization1() {
		final Organization o = new Organization(new OrganizationBaseType());
		o.setPrimaryName(new NameBaseType());
		o.getPrimaryName().setName(ts1);

		o.setPrimaryIdentificator(new IdentificatorBaseType());
		o.getPrimaryIdentificator().setExtension(numS1);

		TelecomBaseType t1 = new Telecom();
		t1.setMail("testMail");
		t1.setUsage(TelecomAddressUse.BUSINESS);
		telecoms1.add(t1);

		TelecomBaseType t2 = new Telecom();
		t2.setPhone(numS1);
		t2.setUsage(TelecomAddressUse.PRIVATE);
		telecoms1.add(t2);

		o.setTelecomList(telecoms1);

		return o;
	}

	public Patient createPatient() {
		Patient patient = new Patient(createName1(), AdministrativeGender.FEMALE,
				createStartDate());
		patient.addAddress(createAddress1());
		patient.setBirthday(createStartDate());

		List<TelecomBaseType> telecoms = createTelecoms1();

		for (TelecomBaseType telecom : telecoms) {
			patient.getTelecoms().add(new Telecom(telecom));
		}

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
		return DateUtil.parseDateyyyyMMdd("20141215");
	}

	public List<TelecomBaseType> createTelecoms1() {
		final List<TelecomBaseType> t = new LinkedList<>();

		Telecom t1 = new Telecom();
		t1.setMail(telS1);
		t1.setUsage(TelecomAddressUse.BUSINESS);

		t.add(t1);

		Telecom t2 = new Telecom();
		t2.setMail(telS2);
		t2.setUsage(TelecomAddressUse.PRIVATE);
		t.add(t2);

		Telecom t3 = new Telecom();
		t3.setFax(telS1);
		t3.setUsage(TelecomAddressUse.BUSINESS);
		t.add(t3);

		Telecom t4 = new Telecom();
		t4.setFax(telS2);
		t4.setUsage(TelecomAddressUse.PRIVATE);
		t.add(t4);

		Telecom t5 = new Telecom();
		t5.setPhone(telS1);
		t5.setUsage(TelecomAddressUse.BUSINESS);
		t.add(t5);

		Telecom t6 = new Telecom();
		t6.setPhone(telS2);
		t6.setUsage(TelecomAddressUse.PRIVATE);
		t.add(t6);

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

		startDate = DateUtil.parseDateyyyyMMdd("20150228");
		endDate = DateUtil.parseDateyyyyMMdd("20180228");

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
		loincCode = new Code("2.16.840.1.113883.6.1", numS1, null);
		problemCode = new Code("2.16.840.1.113883.6.139", numS2, null);
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
