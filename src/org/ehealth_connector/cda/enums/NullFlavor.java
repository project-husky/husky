package org.ehealth_connector.cda.enums;

import java.util.Arrays;

import org.ehealth_connector.common.Code;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/**
 * <div class="de">Codesystem: HL7 nullFlavor Tabelle (OID:
 * 2.16.840.1.113883.5.1008). Dieses Subset ist für den vorliegenden
 * Implementierungsleitfaden abschliessend. Andere Codes sind NICHT
 * ERLAUBT.</div> <div class="fr">Source du sous-ensemble : [IHE PCC TF-2],Table
 * 6.3.4.16.7-1</div>
 */
public enum NullFlavor {

	/**
	 * <div class="de">Gefragt, aber keine Antwort erhalten</div> <div
	 * class="fr">Question posée, mais aucune réponse reçue</div>
	 */
	ASKED_BUT_UNKNOWN("ASKU", "asked but unknown"),

	/**
	 * <div class="de">Patient wünscht keine Weitergabe dieser Information</div>
	 * <div class="fr">Le patient ne souhaite pas que cette information soit
	 * transmise.</div>
	 */
	MASKED("MSK", "masked"),

	/**
	 * <div class="de">Nicht gefragt</div> <div class="fr">Non demandé</div>
	 */
	NOT_ASKED("NASK", "not asked"),

	/**
	 * <div class="de">Vorübergehend unbekannt, wird später ausgefüllt</div>
	 * <div class="fr">Actuellement non connu, sera rempli plus tard.</div>
	 */
	TEMPORARILY_UNAVAILABLE("NAV", "temporarily unavailable"),

	/**
	 * <div class="de">Unbekannt, ohne weitere Präzisierung</div> <div
	 * class="fr">Non connu, sans autre précision</div>
	 */
	UNKNOWN("UNK", "unknown"),

	/** Known to have no proper value */
	NOT_APPLICABLE("NA", "not applicable");

	public static final String CODE_SYSTEM_OID = "2.16.840.1.113883.5.1008";
	public static final String CODE_SYSTEM_NAME = "HL7nullFlavor ";

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
	private NullFlavor(String code, String displayName) {
		this.code = code;
		this.displayName = displayName;
	}

	/**
	 * <div class="en">Gets the Enum with a given code</div> <div
	 * class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 * 
	 * @param code
	 * <br>
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static NullFlavor getEnum(String code) {
		for (NullFlavor x : values()) {
			if (x.getCodeValue().equals(code)) {
				return x;
			}
		}
		return null;
	}

	/**
	 * <div class="en">Gets the Code of this Enum as MDHT Object.</div> <div
	 * class="de">Liefert den Code dieses Enum als MDHT Objekt.</div>
	 * 
	 * @return <div class="en">The MDHT Code</div>
	 */
	public CD getCD() {
		CD cd = DatatypesFactory.eINSTANCE.createCD();
		cd.setCodeSystem(CODE_SYSTEM_OID);
		cd.setCode(code);
		cd.setDisplayName(displayName);
		return cd;
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
		return this.code;
	}

	/**
	 * <div class="en">Gets the display name.</div> <div class="de">Liefert
	 * display name.</div>
	 * 
	 * @return <div class="en">the display name</div>
	 */
	public String getdisplayName() {
		return this.displayName;
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
		for (NullFlavor x : values()) {
			if (x.getCodeValue().equals(code)) {
				return true;
			}
		}
		return false;
	}

}