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
package org.ehealth_connector.cda.ch.vacd.v140.enums;

import org.ehealth_connector.common.mdht.Code;
import org.ehealth_connector.common.mdht.enums.ObservationInterpretation;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;

/*
 *<div class="de">Das folgende Subset (siehe auch OID 2.16.756.5.30.1.127.3.2.20121101.3) ist für den vorliegenden Implementierungsleitfaden abschliessend. Andere Codes sind NICHT ERLAUBT.</div>
 *<div class="fr">Domaine de valeurs pour « Code dinterprétation »</div>
 */
public enum ObservationInterpretationForImmunization {

	//@formatter:off
	/**
	 * <div class="de">Negativ: Erreger konnte in Probe nicht nachgewiesen
	 * werden</div> <div class="fr">Négatif: L’agent pathogène n’a pas pu être
	 * dépisté dans l’échantillon</div> <div class="it"></div>
	 */
	NEGATIVE_PATHOGEN_COULDNT_BE_DETERMINED_IN_SPECIMEN(ObservationInterpretation.NEG,
			"Negative: Pathogen couldn't be determined in specimen"),
	/**
	 * <div class="de">Positiv Erreger in Probe nachgewiesen</div>
	 * <div class="fr">Positif: Agent pathogène dépisté dans l’échantillon</div>
	 * <div class="it"></div>
	 */
	POSITIVE_PATHOGEN_FOUND_IN_SPECIMEN(ObservationInterpretation.POS, "Positive: Pathogen found in specimen");
	//@formatter:on

	public static final String NEGATIVE_PATHOGEN_COULDNT_BE_DETERMINED_IN_SPECIMEN_CODE = "NEG";

	public static final String POSITIVE_PATHOGEN_FOUND_IN_SPECIMEN_CODE = "POS";

	/**
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 *
	 * @param code
	 *            <br>
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static ObservationInterpretationForImmunization getEnum(String code) {
		for (final ObservationInterpretationForImmunization x : values()) {
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
			Enum.valueOf(ObservationInterpretationForImmunization.class, enumName);
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
		for (final ObservationInterpretationForImmunization x : values()) {
			if (x.getCodeValue().equals(codeValue)) {
				return true;
			}
		}
		return false;
	}

	private String displayName;

	private ObservationInterpretation root;

	private ObservationInterpretationForImmunization(ObservationInterpretation root,
			String displayName) {
		this.root = root;
		this.displayName = displayName;
	}

	/**
	 * <div class="en">Gets the Code of this Enum as MDHT Object.</div>
	 * <div class="de">Liefert den Code dieses Enum als MDHT Objekt.</div>
	 *
	 * @return <div class="en">The MDHT Code</div>
	 */
	public CE getCE() {
		final CE ce = root.getCE();
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
		final Code ehcCode = root.getCode();
		ehcCode.setDisplayName(displayName);
		return ehcCode;
	}

	/**
	 * <div class="en">Gets the code system name.</div> <div class="de">Liefert
	 * code system name.</div>
	 *
	 * @return <div class="en">the code system name</div>
	 */
	public String getCodeSystemName() {
		return root.getCodeSystemName();
	}

	/**
	 * <div class="en">Gets the code system id.</div> <div class="de">Liefert
	 * die code system id.</div>
	 *
	 * @return <div class="en">the code system id</div>
	 */
	public String getCodeSystemOid() {
		return root.getCodeSystemOid();
	}

	/**
	 * <div class="en">Gets the actual Code as string</div>
	 * <div class="de">Liefert den eigentlichen Code als String</div>
	 *
	 * @return <div class="en">the code</div>
	 */
	public String getCodeValue() {
		return root.getCodeValue();
	}

	/**
	 * <div class="en">Gets the display name.</div> <div class="de">Liefert
	 * display name.</div>
	 *
	 * @return <div class="en">the display name</div>
	 */
	public String getDisplayName() {
		return this.displayName;
	}
}
