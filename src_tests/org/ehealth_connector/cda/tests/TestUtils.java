/********************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 Switzerland License.
 *
 * Year of publication: 2015
 *
 ********************************************************************************/
package org.ehealth_connector.cda.tests;

import java.util.Date;
import java.util.Random;

import org.ehealth_connector.cda.AllergyProblem;
import org.ehealth_connector.cda.Consumable;
import org.ehealth_connector.cda.Problem;
import org.ehealth_connector.cda.ch.enums.CodeSystems;
import org.ehealth_connector.cda.enums.AddressUse;
import org.ehealth_connector.common.Address;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Name;
import org.ehealth_connector.common.Organization;
import org.ehealth_connector.common.Performer;
import org.ehealth_connector.common.Telecoms;
import org.ehealth_connector.common.Value;

public class TestUtils {

	public static String generateString(int length) {
		Random rng = new Random();
		String characters = "abcëÙdÀÿeŒfúgËÛùhijàÊkÇlŸmœ�?çÚnÔÈoæûèp»ÙÈqùôêîïÆrsâÉtéÎuvwèxylïäüìöÄ�?ÒÜÂÖÌ?ßÓ/òó:#\\í�?~*É'é,´Àà";

		char[] text = new char[length];
		for (int i = 0; i < length; i++) {
			text[i] = characters.charAt(rng.nextInt(characters.length()));
		}
		return new String(text);
	}

	public static boolean isEqual(AllergyProblem p1, AllergyProblem p2) {
		if (!isEqual(p1.getCode(), p2.getCode()))
			return false;
		if (p1.getEnd() != null && !p1.getEnd().equals(p2.getEnd()))
			return false;
		if (p1.getStart() != null && !p1.getStart().equals(p2.getStart()))
			return false;
		if (!isEqual(p1.getId(), p2.getId()))
			return false;
		for (int i = 0; i < p1.getValues().size(); i++) {
			if (!isEqual(p1.getValues().get(i), p2.getValues().get(i)))
				return false;
		}
		return true;
	}

	public static boolean isEqual(Author a1, Author a2) {
		if (!a1.getGln().equals(a2.getGln()))
			return false;
		for (int i = 0; i < a1.getIds().size(); i++) {
			if (!isEqual(a1.getIds().get(i), a2.getIds().get(i)))
				return false;
		}
		return true;
	}

	public static boolean isEqual(Code c1, Code c2) {
		if (c1 == null && c2 == null) {
			return true;
		}
		if ((c1 != null && c2 == null) || (c1 == null && c2 != null))
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
		if (!isEqual(c1.getManufacturedMaterialCode(),
				c2.getManufacturedMaterialCode()))
			return false;
		if (!isEqual(c1.getManufacturedProductId(),
				c2.getManufacturedProductId()))
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
		if (!n1.getGivenNames().equals(n2.getGivenNames()))
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

	public static boolean isEqual(Problem p1, Problem p2) {
		if (!isEqual(p1.getCode(), p2.getCode()))
			return false;
		if (p1.getEnd() != null && !p1.getEnd().equals(p2.getEnd()))
			return false;
		if (p1.getStart() != null && !p1.getStart().equals(p2.getStart()))
			return false;
		if (!isEqual(p1.getId(), p2.getId()))
			return false;
		for (int i = 0; i < p1.getValues().size(); i++) {
			if (!isEqual(p1.getValues().get(i), p2.getValues().get(i)))
				return false;
		}
		return true;
	}

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
			if (!v1.getPhysicalQuantityUnit().equals(
					v2.getPhysicalQuantityUnit()))
				return false;
			if (!v1.isPhysicalQuantity() == v2.isPhysicalQuantity())
				return false;
		}

		if (v1.getPhysicalQuantityValue() != null) {
			if (!v1.getPhysicalQuantityValue().equals(
					v2.getPhysicalQuantityValue()))
				return false;
		}

		return true;
	}

	public static final int NUMBER_OF_RANDOM_STRING_LETTERS = 129;
	public String startDateString;
	public String endDateString;
	public Date startDate;

	public Date endDate;
	public String ts1;
	public String ts2;
	public String ts3;
	public String ts4;
	public String ts5;
	public String numS1;
	public String numS2;
	public Double number;
	public String telS1;
	public String telS2;
	public Code code1;
	public Code code2;
	public Code loincCode;
	public Code problemCode;

	public Value value1;

	public Value value2;

	public Identificator id1;

	public Identificator id2;

	public Name name1;

	public Name name2;

	public Author author1;

	public Author author2;

	public Organization organization1;

	public Code gtinCode;

	public Telecoms telecoms1;

	public Address address1;

	public TestUtils() {
		// initTestData();
	}

	public Address createAddress1() {
		Address a = new Address("Baurat-Gerber-Str.", "18", "37073",
				"Göttingen", AddressUse.BUSINESS);
		return a;
	}

	public Author createAuthor1() {
		Author a = new Author(createName1(), numS1);
		return a;
	}

	public Author createAuthor2() {
		Author a = new Author(createName2(), numS2);
		return a;
	}

	// Create Test Objects
	public Code createCode1() {
		Code code = new Code(ts1, ts2, ts3, ts4);
		return code;
	}

	public Code createCode2() {
		Code code = new Code(ts5, ts4, ts3, ts2);
		return code;
	}

	public Code createGtinCode() {
		Code code = new Code(CodeSystems.GTIN, ts3);
		return code;
	}

	public Identificator createIdentificator1() {
		Identificator id = new Identificator(CodeSystems.GLN, numS1);
		return id;
	}

	public Identificator createIdentificator2() {
		Identificator id = new Identificator(CodeSystems.ICD10, numS2);
		return id;
	}

	public Name createName1() {
		Name n = new Name(ts1, ts2, ts3, ts4);
		return n;
	}

	public Name createName2() {
		Name n = new Name(ts5, ts4, ts3, ts2);
		return n;
	}

	public Organization createOrganization1() {
		Organization o = new Organization(ts1, numS1);
		o.setTelecoms(telecoms1);
		return o;
	}

	public Performer createPerformer1() {
		Performer p = new Performer(createName1(), numS1);
		return p;
	}

	public Performer createPerformer2() {
		Performer p = new Performer(createName2(), numS2);
		return p;
	}

	public Telecoms createTelecoms1() {
		Telecoms t = new Telecoms();
		t.addEMail(telS1, AddressUse.BUSINESS);
		t.addEMail(telS2, AddressUse.PRIVATE);
		t.addFax(telS1, AddressUse.BUSINESS);
		t.addFax(telS2, AddressUse.PRIVATE);
		t.addPhone(telS1, AddressUse.BUSINESS);
		t.addPhone(telS2, AddressUse.PRIVATE);
		return t;
	}

	protected Value createValue1() {
		Value value = new Value("500", "ml");
		return value;
	}

	protected Value createValue2() {
		Value value = new Value(ts1, ts2);
		return value;
	}
}
