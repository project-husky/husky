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
package org.ehealth_connector.cda.ch.enums;

import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.hl7cdar2.CE;

/*
 *<div class="de"></div>
 *<div class="fr">Ce sous-ensemble (Subset) correspond aux professions actuellement définies dans CDA-CH (chapitre 7.3.13).</div>
 */

public enum ParticipationFunction {

	/**
	 * <div class="en">admitting physician</div> <div class="fr">Médecin
	 * instruisant l'admission</div>
	 */
	ADMITTING_PHYSICIAN("ADMPHYS", "admitting physician"),

	/**
	 * <div class="en">anesthesia nurse</div> <div class="fr">Infirmière
	 * anesthésiste</div>
	 */
	ANESTHESIA_NURSE("ANRS", "anesthesia nurse"),

	/**
	 * <div class="en">Anesthesist</div> <div class="fr">Anesthésiste</div>
	 */
	ANESTHESIST("ANEST", "Anesthesist"),

	/**
	 * <div class="en">attending physician</div> <div class="fr">Médecin
	 * traitant</div>
	 */
	ATTENDING_PHYSICIAN("ATTPHYS", "attending physician"),

	/**
	 * <div class="en">discharging physician</div> <div class="fr">Médecin
	 * autorisant la sortie</div>
	 */
	DISCHARGING_PHYSICIAN("DISPHYS", "discharging physician"),

	/**
	 * <div class="en">first assistant surgeon</div> <div class="fr">Premier
	 * assistant chirurgien</div>
	 */
	FIRST_ASSISTANT_SURGEON("FASST", "first assistant surgeon"),

	/**
	 * <div class="en">Midwife</div> <div class="fr">Sage-femme</div>
	 */
	MIDWIFE("MDWF", "Midwife"),

	/**
	 * <div class="en">nurse assistant</div> <div class="fr">Aide
	 * soignant(e)</div>
	 */
	NURSE_ASSISTANT("NASST", "nurse assistant"),

	/**
	 * <div class="en">primary care physician</div> <div class="fr">Médecin de
	 * famille, médecin généraliste</div>
	 */
	PRIMARY_CARE_PHYSICIAN("PCP", "primary care physician"),

	/**
	 * <div class="en">primary surgeon</div> <div class="fr">Chirurgien
	 * responsable</div>
	 */
	PRIMARY_SURGEON("PRISURG", "primary surgeon"),

	/**
	 * <div class="en">rounding physician</div> <div class="fr">N/A</div>
	 */
	ROUNDING_PHYSICIAN("RNDPHYS", "rounding physician"),

	/**
	 * <div class="en">scrub nurse</div> <div class="fr">Infirmière de salle
	 * d'opération/div>
	 */
	SCRUB_NURSE("SNRS", "scrub nurse"),

	/**
	 * <div class="en">second assistant surgeon</div> <div class="fr">Deuxième
	 * assistant chirurgien</div>
	 */
	SECOND_ASSISANT("SASST", "second assistant surgeon"),

	/**
	 * <div class="en">third assistant</div> <div class="fr">Autre
	 * assistant</div>
	 */
	THIRD_ASSISANT("TASST", "third assistant");

	public static final String CODE_SYSTEM_OID = "2.16.756.5.30.2.1.1.1";
	public static final String CODE_SYSTEM_NAME = "eCH ParticipationFunction";

	/**
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 *
	 * @param code
	 *            <br>
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static ParticipationFunction getEnum(String code) {
		for (final ParticipationFunction x : values()) {
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
			Enum.valueOf(ParticipationFunction.class, enumName);
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
		for (ParticipationFunction x : values()) {
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
	private ParticipationFunction(String code, String displayName) {
		this.code = code;
		this.displayName = displayName;
	}

	/**
	 * <div class="en">Gets the Code of this Enum as MDHT Object.</div>
	 * <div class="de">Liefert den Code dieses Enum als MDHT Objekt.</div>
	 *
	 * @return <div class="en">The MDHT Code</div>
	 */
	public CE getCE() {
		final CE ce = new CE();
		ce.setCodeSystem(CODE_SYSTEM_OID);
		ce.setCodeSystemName(CODE_SYSTEM_NAME);
		ce.setCode(code);
		ce.setDisplayName(displayName);
		return ce;
	}

	/**
	 * <div class="en">Gets the ehealthconnector Code Object</div>
	 * <div class="de">Liefert das ehealthconnector Code Objekt</div>
	 *
	 * @return <div class="en">the code</div>
	 */
	public Code getCode() {
		final Code ehcCode = new Code(CODE_SYSTEM_OID, code, CODE_SYSTEM_NAME, displayName);
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
