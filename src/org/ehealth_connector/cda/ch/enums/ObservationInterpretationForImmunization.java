package org.ehealth_connector.cda.ch.enums;

import java.util.Arrays;

import org.ehealth_connector.common.Code;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/*
 *<div class="de">Codesystem: HL7 ObservationInterpretation (OID: 2.16.840.1.113883.5.83). Das folgende Subset (siehe auch OID 2.16.756.5.30.1.127.3.2.20121101.3) ist für den vorliegenden Implementierungsleitfaden abschliessend. Andere Codes sind NICHT ERLAUBT.</div>
 *<div class="fr">Domaine de valeurs pour « Code dinterprétation »</div>
 */
public enum ObservationInterpretationForImmunization {

	/**
	 * <div class="de">Positiv Erreger in Probe nachgewiesen</div> <div
	 * class="fr">Positif: Agent pathogène dépisté dans l’échantillon</div>
	 */
	POSITIVE_PATHOGEN_FOUND_IN_SPECIMEN("POS",
			"Positive: Pathogen found in specimen"),
			/**
			 * <div class="de">Negativ: Erreger konnte in Probe nicht nachgewiesen
			 * werden</div> <div class="fr">Négatif: L’agent pathogène n’a pas pu être
			 * dépisté dans l’échantillon</div>
			 */
			NEGATIVE_PATHOGEN_COULDNT_BE_DETERMINED_IN_SPECIMEN("NEG",
					"Negative: Pathogen couldn't be determined in specimen");
	public static final String POSITIVE_PATHOGEN_FOUND_IN_SPECIMEN_CODE = "POS";
	public static final String NEGATIVE_PATHOGEN_COULDNT_BE_DETERMINED_IN_SPECIMEN_CODE = "NEG";

	public static final String CODE_SYSTEM_OID = "2.16.840.1.113883.5.83";
	public static final String CODE_SYSTEM_NAME = "HL7ObservationInterpretation ";

	/**
	 * <div class="en">Gets the Enum with a given code</div> <div
	 * class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 *
	 * @param code
	 * <br>
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static ObservationInterpretationForImmunization getEnum(String code) {
		for (ObservationInterpretationForImmunization x : values()) {
			if (x.getCodeValue().equals(code)) {
				return x;
			}
		}
		return null;
	}
	private String code;

	private String displayName;

	/**
	 * <div class="en">Instantiates this Enum Object with a given Code and
	 * Display Name</div> <div class="de">Instantiiert dieses Enum Object
	 * mittels eines Codes und einem Display Name</div>
	 *
	 * @param code
	 * <br>
	 *            <div class="de"> code</div>
	 * @param displayName
	 * <br>
	 *            <div class="de"> display name</div>
	 */
	private ObservationInterpretationForImmunization(String code,
			String displayName) {
		this.code = code;
		this.displayName = displayName;
	}

	/**
	 * <div class="en">Gets the Code of this Enum as MDHT Object.</div> <div
	 * class="de">Liefert den Code dieses Enum als MDHT Objekt.</div>
	 *
	 * @return <div class="en">The MDHT Code</div>
	 */
	public CE getCE() {
		CE ce = DatatypesFactory.eINSTANCE.createCE();
		ce.setCodeSystem(CODE_SYSTEM_OID);
		ce.setCode(code);
		ce.setDisplayName(displayName);
		return ce;
	}

	/**
	 * <div class="en">Gets the ehealthconnector Code Object</div> <div
	 * class="de">Liefert das ehealthconnector Code Objekt</div>
	 *
	 * @return <div class="en">the code</div>
	 */
	public Code getCode() {
		Code ehcCode = new Code(CODE_SYSTEM_OID, code, displayName);
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
	 * <div class="en">Gets the actual Code as string</div> <div
	 * class="de">Liefert den eigentlichen Code als String</div>
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
	public String getdisplayName() {
		return displayName;
	}

	/**
	 * <div class="en">Checks if a given enum is part of this value set.</div>
	 * <div class="de">Prüft, ob der gegebene enum Teil dieses Value Sets
	 * ist.</div>
	 *
	 *
	 * @param enumName
	 * <br>
	 *            <div class="de"> enumName</div>
	 * @return true, if enum is in this value set
	 */
	public boolean isEnumOfValueSet(String enumName) {
		return Arrays.asList(values()).contains(enumName);
	}

	/**
	 * <div class="en">Checks if a given code value is in this value set.</div>
	 * <div class="de">Prüft, ob der gegebene code in diesem Value Sets
	 * vorhanden ist.</div>
	 *
	 * @param codeValue
	 * <br>
	 *            <div class="de"> code</div>
	 * @return true, if is in value set
	 */
	public boolean isInValueSet(String codeValue) {
		for (ObservationInterpretationForImmunization x : values()) {
			if (x.getCodeValue().equals(code)) {
				return true;
			}
		}
		return false;
	}

}