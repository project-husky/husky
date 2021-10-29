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
package org.husky.common.testhelpers;

import java.util.Random;

import org.husky.common.basetypes.TelecomBaseType;
import org.husky.common.model.Author;
import org.husky.common.model.Code;
import org.husky.common.model.Identificator;
import org.husky.common.model.Name;
import org.husky.common.model.Organization;
import org.husky.common.model.Patient;
import org.husky.common.model.Value;

/**
 * Helper Class for Tests
 */
public abstract class AbstractTestHelper {

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

	// public static boolean isEqual(AllergyProblem p1, AllergyProblem p2) {
	// if (!isEqual(p1.getCode(), p2.getCode()))
	// return false;
	// if (p1.getEndDate() != null && !p1.getEndDate().equals(p2.getEndDate()))
	// return false;
	// if (p1.getStartDate() != null &&
	// !p1.getStartDate().equals(p2.getStartDate()))
	// return false;
	// if (!isEqual(p1.getId(), p2.getId()))
	// return false;
	// for (int i = 0; i < p1.getValues().size(); i++) {
	// if (!isEqual(p1.getValues().get(i), p2.getValues().get(i)))
	// return false;
	// }
	// return true;
	// }

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

	// public static boolean isEqual(Consumable c1, Consumable c2) {
	// if (!isEqual(c1.getManufacturedMaterialCode(),
	// c2.getManufacturedMaterialCode()))
	// return false;
	// if (!isEqual(c1.getManufacturedProductId(),
	// c2.getManufacturedProductId()))
	// return false;
	// if (!c1.getTradeName().equals(c2.getTradeName()))
	// return false;
	// if (!isEqual(c1.getWhoAtcCode(), c2.getWhoAtcCode()))
	// return false;
	// return true;
	// }

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
		if (!isEqual(o1.getPrimaryTelecom(), o2.getPrimaryTelecom()))
			return false;
		return true;
	}

	// public static boolean isEqual(Problem p1, Problem p2) {
	// if (!isEqual(p1.getCode(), p2.getCode()))
	// return false;
	// if (p1.getEndDate() != null && !p1.getEndDate().equals(p2.getEndDate()))
	// return false;
	// if (p1.getStartDate() != null &&
	// !p1.getStartDate().equals(p2.getStartDate()))
	// return false;
	// if (!isEqual(p1.getId(), p2.getId()))
	// return false;
	// for (int i = 0; i < p1.getValues().size(); i++) {
	// if (!isEqual(p1.getValues().get(i), p2.getValues().get(i)))
	// return false;
	// }
	// return true;
	// }

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

	public static boolean isEqual(TelecomBaseType t1, TelecomBaseType t2) {
		if (t1.getValue() != null) {
			return t1.getValue().equalsIgnoreCase(t2.getValue());
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

	// public Address createAddress1() {
	// Address a = new Address("Baurat-Gerber-Str.", "18", "37073", "Göttingen",
	// AddressUse.BUSINESS);
	// return a;
	// }
	//
	// public Author createAuthor1() {
	// Author a = new Author(createName1(), numS1);
	// return a;
	// }
	//
	// public Author createAuthor2() {
	// Author a = new Author(createName2(), numS2);
	// return a;
	// }
	//
	// // Create Test Objects
	// public Code createCode1() {
	// Code code = new Code(ts1, ts2, ts3, ts4);
	// return code;
	// }
	//
	// public Code createCode2() {
	// Code code = new Code(ts5, ts4, ts3, ts2);
	// return code;
	// }
	//
	// public Code createGtinCode() {
	// Code code = new Code(CodeSystems.GTIN, ts3);
	// return code;
	// }
	//
	// public Identificator createIdentificator1() {
	// Identificator id = new Identificator(CodeSystems.GLN, numS1);
	// return id;
	// }
	//
	// public Identificator createIdentificator2() {
	// Identificator id = new Identificator(CodeSystems.ICD10, numS2);
	// return id;
	// }
	//
	// public Name createName1() {
	// Name n = new Name(ts1, ts2, ts3, ts4);
	// return n;
	// }
	//
	// public Name createName2() {
	// Name n = new Name(ts5, ts4, ts3, ts2);
	// return n;
	// }
	//
	// public Organization createOrganization1() {
	// Organization o = new Organization(ts1, numS1);
	// o.setTelecoms(telecoms1);
	// telecoms1.addEMail("testMail", AddressUse.BUSINESS);
	// telecoms1.addPhone(numS1, AddressUse.PRIVATE);
	// return o;
	// }
	//
	// public Performer createPerformer1() {
	// Performer p = new Performer(createName1(), numS1);
	// return p;
	// }
	//
	// public Performer createPerformer2() {
	// Performer p = new Performer(createName2(), numS2);
	// return p;
	// }
	//
	// public Telecoms createTelecoms1() {
	// Telecoms t = new Telecoms();
	// t.addEMail(telS1, AddressUse.BUSINESS);
	// t.addEMail(telS2, AddressUse.PRIVATE);
	// t.addFax(telS1, AddressUse.BUSINESS);
	// t.addFax(telS2, AddressUse.PRIVATE);
	// t.addPhone(telS1, AddressUse.BUSINESS);
	// t.addPhone(telS2, AddressUse.PRIVATE);
	// return t;
	// }
	//
	// protected Value createValue1() {
	// Value value = new Value("500", "ml");
	// return value;
	// }
	//
	// protected Value createValue2() {
	// Value value = new Value(ts1, ts2);
	// return value;
	// }
	//
	// public Date createStartDate() {
	// return DateUtil.date("15.12.2014");
	// }
	//
	// public Patient createPatient() {
	// return new Patient(createName1(), AdministrativeGender.FEMALE,
	// createStartDate());
	// }

}
