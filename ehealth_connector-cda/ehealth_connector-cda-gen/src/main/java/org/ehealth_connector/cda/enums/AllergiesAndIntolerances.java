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

import org.ehealth_connector.common.hl7cdar2.CD;
import org.ehealth_connector.common.model.Code;

/*
 *<div class="de">Dieses Subset ist eine empfohlene Auswahl für den vorliegenden Implementierungsleitfaden. Andere Codes aus HL7 ActCode dürfen ebenfalls verwendet werden. (Quelle für Subset: [IHE PCC TF-2], 6.3.4.15.4)</div>
 *<div class="fr">Ce sous-ensemble (Subset) est une sélection recommandée pour le présent guide d'implémentation. Il est également possible dutiliser dautres codes tirés de HL7 ActCode. (Source du sous-ensemble : [IHE PCC TF-2], 6.3.4.15.4)</div>
 */
public enum AllergiesAndIntolerances {

	/**
	 * <div class="de">Überempfindlichkeit des Immunsystems auf bestimmte
	 * pharmazeutische Produkte (Arzneimittel).</div>
	 * <div class="fr">Hyperréactivité du système immunitaire à certains
	 * produits pharmaceutiques (médicaments)</div>
	 */
	DRUG_ALLERGY("DALG", "Drug Allergy"),
	/**
	 * <div class="de">Unerwünschte Reaktion des Immunsystems bei Anwendung
	 * bestimmter Arzneimittel.</div> <div class="fr">Réaction indésirable du
	 * système immunitaire lors de l’utilisation de certains médicaments</div>
	 */
	DRUG_INTOLERANCE("DINT", "Drug Intolerance"),
	/**
	 * <div class="de">Überempfindlichkeit des Immunsystems auf bestimmte Stoffe
	 * in Nahrungsmitteln</div> <div class="fr">Hyperréactivité du système
	 * immunitaire à certaines substances contenues dans des aliments</div>
	 */
	FOOD_ALLERGY("FALG", "Food Allergy"),
	/**
	 * <div class="de">Unerwünschte Reaktion des Immunsystems bei Einnahme
	 * bestimmter Nahrungsmittel.</div> <div class="fr">Réaction indésirable du
	 * système immunitaire en cas d’absorption de certains aliments.</div>
	 */
	FOOD_INTOLERANCE("FINT", "Food Intolerance");

	public static final String CODE_SYSTEM_NAME = "HL7ActCode";
	public static final String CODE_SYSTEM_OID = "2.16.840.1.113883.5.4";
	public static final String DRUG_ALLERGY_CODE = "DALG";
	public static final String DRUG_INTOLERANCE_CODE = "DINT";

	public static final String FOOD_ALLERGY_CODE = "FALG";
	public static final String FOOD_INTOLERANCE_CODE = "FINT";

	/**
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 *
	 * @param code
	 *            <br>
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static AllergiesAndIntolerances getEnum(String code) {
		for (final AllergiesAndIntolerances x : values()) {
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
			Enum.valueOf(AllergiesAndIntolerances.class, enumName);
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
		for (AllergiesAndIntolerances x : values()) {
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
	private AllergiesAndIntolerances(String code, String displayName) {
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
