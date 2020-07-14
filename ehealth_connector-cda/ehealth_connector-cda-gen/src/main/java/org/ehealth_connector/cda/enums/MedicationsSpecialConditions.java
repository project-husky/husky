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
package org.ehealth_connector.cda.enums;

import org.ehealth_connector.common.mdht.Code;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/*
 *<div class="de">Quelle für Subset: [IHE PCC TF-2], Table 6.3.4.16.7-1</div>
 *<div class="fr">Source du sous-ensemble : [IHE PCC TF-2],Table 6.3.4.16.7-1</div>
 */
public enum MedicationsSpecialConditions {

	/**
	 * <div class="de">Medikamentöse Therapie unbekannt</div>
	 * <div class="fr">Traitement médicamenteux inconnu</div>
	 */
	DRUG_TREATMENT_UNKNOWN("182904002", "Drug Treatment Unknown"),
	/**
	 * <div class="de">Patient lehnt die Impfung ab</div> <div class="fr">Le
	 * patient refuse la vaccination.</div>
	 */
	MEDICATION_REFUSED_PATIENT_OBJECTIVE("406149000", "Medication refused, Patient Objective"),
	/**
	 * <div class="de">Keine medikamentöse Therapie verschrieben</div>
	 * <div class="fr">Aucun traitement médicamenteux prescrit</div>
	 */
	NO_DRUG_THERAPY_PRESCRIBED("182849000", "No Drug Therapy Prescribed"),
	/**
	 * <div class="de">Patient gibt an, keine Medikamente einzunehmen</div>
	 * <div class="fr">Le patient indique qu’il ne prend pas de
	 * médicaments.</div>
	 */
	PATIENT_NOT_ON_SELF_MEDICATIONS("408350003", "Patient Not On Self-Medications");

	public static final String CODE_SYSTEM_NAME = "SNOMED CT";
	public static final String CODE_SYSTEM_OID = "2.16.840.1.113883.6.96";
	public static final String DRUG_TREATMENT_UNKNOWN_CODE = "182904002";
	public static final String MEDICATION_REFUSED_PATIENT_OBJECTIVE_CODE = "406149000";

	public static final String NO_DRUG_THERAPY_PRESCRIBED_CODE = "182849000";
	public static final String PATIENT_NOT_ON_SELF_MEDICATIONS_CODE = "408350003";

	/**
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 *
	 * @param code
	 *            <br>
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static MedicationsSpecialConditions getEnum(String code) {
		for (final MedicationsSpecialConditions x : values()) {
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
			Enum.valueOf(MedicationsSpecialConditions.class, enumName);
			return true;
		} catch (final IllegalArgumentException ex) {
			return false;
		}
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
	private MedicationsSpecialConditions(String code, String displayName) {
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
		final CD cd = DatatypesFactory.eINSTANCE.createCD();
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
