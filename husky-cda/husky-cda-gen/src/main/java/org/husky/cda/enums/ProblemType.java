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
package org.husky.cda.enums;

import org.husky.common.hl7cdar2.CD;
import org.husky.common.model.Code;

/*
 *<div class="de">Wertebereich für Art des Problems (SNOMED CT; 2.16.840.1.113883.6.96)</div>
 *<div class="fr">Domaine de valeurs pour « Type du problème » (SNOMED CT; 2.16.840.1.113883.6.96)</div>
 */
public enum ProblemType {

	/**
	 * <div class="de">Problem</div> <div class="fr">Problème</div>
	 */
	PROBLEM("55607006", "Problem"),
	/**
	 * <div class="de">Krankheit</div> <div class="fr">Maladie</div>
	 */
	CONDITION("64572001", "Condition"),
	/**
	 * <div class="de">Funktionale Einschränkung</div>
	 * <div class="fr">Limitation fonctionnelle</div>
	 */
	FUNCTIONAL_LIMITATION("248536006", "Functional limitation "),
	/**
	 * <div class="de">Diagnose</div> <div class="fr">Diagnostic</div>
	 */
	DIAGNOSIS("282291009", "Diagnosis"),
	/**
	 * <div class="de">Befund</div> <div class="fr">Résultat</div>
	 */
	FINDING("404684003", "Finding "),
	/**
	 * <div class="de">Beschwerde</div> <div class="fr">Plainte</div>
	 */
	COMPLAINT("409586006", "Complaint "),
	/**
	 * <div class="de">Symptom</div> <div class="fr">Symptôme</div>
	 */
	SYMPTOM("418799008", "Symptom ");

	public static final String PROBLEM_CODE = "55607006";
	public static final String CONDITION_CODE = "64572001";
	public static final String FUNCTIONAL_LIMITATION_CODE = "248536006";
	public static final String DIAGNOSIS_CODE = "282291009";
	public static final String FINDING_CODE = "404684003";
	public static final String COMPLAINT_CODE = "409586006";
	public static final String SYMPTOM_CODE = "418799008";

	public static final String CODE_SYSTEM_OID = "2.16.840.1.113883.6.96";
	public static final String CODE_SYSTEM_NAME = "SNOMED CT";

	/**
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 *
	 * @param code
	 *            <br>
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static ProblemType getEnum(String code) {
		for (final ProblemType x : values()) {
			if (x.getCodeValue().equals(code)) {
				return x;
			}
		}
		return null;
	}

	/**
	 * <div class="en">Checks if a given enum is part of this value set.</div>
	 * <div class="de">Prüft, ob der gegebene enum Teil dieses Value Sets
	 * ist.</div>
	 *
	 * @param enumName
	 *            <br>
	 *            <div class="de"> enumName</div>
	 * @return true, if enum is in this value set
	 */
	public static boolean isEnumOfValueSet(String enumName) {
		if (enumName == null) {
			return false;
		}
		try {
			Enum.valueOf(ProblemType.class, enumName);
			return true;
		} catch (final IllegalArgumentException ex) {
			return false;
		}
	}

	/**
	 * <div class="en">Checks if a given code value is in this value set.</div>
	 * <div class="de">Prüft, ob der gegebene code in diesem Value Set vorhanden
	 * ist.</div>
	 *
	 * @param codeValue
	 *            <div class="de">code</div>
	 * @return true, if one enum of this valueset contains the given code
	 */
	public static boolean isInValueSet(String codeValue) {
		for (ProblemType x : values()) {
			if (x.getCodeValue().equals(codeValue)) {
				return true;
			}
		}
		return false;
	}

	private String code;

	private String displayName;

	/**
	 * <div class="en">Instantiates this Enum Object with a given Code and
	 * Display Name</div> <div class="de">Instantiiert dieses Enum Object
	 * mittels eines Codes und einem Display Name</div>
	 *
	 * @param code
	 *            <br>
	 *            <div class="de"> code</div>
	 * @param displayName
	 *            <br>
	 *            <div class="de"> display name</div>
	 */
	private ProblemType(String code, String displayName) {
		this.code = code;
		this.displayName = displayName;
	}

	/**
	 * <div class="en">Gets the Code of this Enum as MDHT Object.</div>
	 * <div class="de">Liefert den Code dieses Enum als MDHT Objekt.</div>
	 *
	 * @return <div class="en">The MDHT Code</div>
	 */
	public CD getCD() {
		final CD cd = new CD();
		cd.setCodeSystem(CODE_SYSTEM_OID);
		cd.setCodeSystemName(CODE_SYSTEM_NAME);
		cd.setCode(code);
		cd.setDisplayName(displayName);
		return cd;
	}

	/**
	 * <div class="en">Gets the ehealthconnector Code Object</div>
	 * <div class="de">Liefert das ehealthconnector Code Objekt</div>
	 *
	 * @return <div class="en">the code</div>
	 */
	public Code getCode() {
		final Code ehcCode = new Code(CODE_SYSTEM_OID, code, displayName);
		return ehcCode;
	}

	/**
	 * <div class="en">Gets the code system name.</div> <div class="de">Liefert
	 * code system name.</div>
	 *
	 * @return <div class="en">the code system name</div>
	 */
	public String getCodeSystemName() {
		return CODE_SYSTEM_NAME;
	}

	/**
	 * <div class="en">Gets the code system id.</div> <div class="de">Liefert
	 * die code system id.</div>
	 *
	 * @return <div class="en">the code system id</div>
	 */
	public String getCodeSystemOid() {
		return CODE_SYSTEM_OID;
	}

	/**
	 * <div class="en">Gets the actual Code as string</div>
	 * <div class="de">Liefert den eigentlichen Code als String</div>
	 *
	 * @return <div class="en">the code</div>
	 */
	public String getCodeValue() {
		return code;
	}

	/**
	 * <div class="en">Gets the display name.</div> <div class="de">Liefert
	 * display name.</div>
	 *
	 * @return <div class="en">the display name</div>
	 */
	public String getDisplayName() {
		return displayName;
	}
}
