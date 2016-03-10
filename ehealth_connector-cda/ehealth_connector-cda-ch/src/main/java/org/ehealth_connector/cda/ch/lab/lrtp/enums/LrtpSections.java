package org.ehealth_connector.cda.ch.lab.lrtp.enums;

import org.ehealth_connector.common.Code;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.CS;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;


/*
*<div class="de">LRTP CDA Body Level 2 Section Codes</div>
*<div class="fr"></div>
*/
public enum LrtpSections {

	/** 
	*<div class="en">Relevant diagnostic tests/laboratory data</div>
	*<div class="de">Blutgruppe</div>
	*/
	RELEVANT_DIAGNOSTIC_TESTSLABORATORY_DATA ("30954-2", "Relevant diagnostic tests/laboratory data"),
	/** 
	*<div class="en">Vital signs</div>
	*<div class="de">Vitalzeichen</div>
	*/
	VITAL_SIGNS ("8716-3", "Vital signs");

	/** 
	*<div class="en">Code for Relevant diagnostic tests/laboratory data</div>
	*<div class="de">Code für Blutgruppe</div>
	*/
	public static final String RELEVANT_DIAGNOSTIC_TESTSLABORATORY_DATA_CODE="30954-2";

	/** 
	*<div class="en">Code for Vital signs</div>
	*<div class="de">Code für Vitalzeichen</div>
	*/
	public static final String VITAL_SIGNS_CODE="8716-3";



	/**
	* <div class="en">Identifier of the Code System</div>
	* <div class="de">Identifikator für das Code System</div>
	*/
	public static final String CODE_SYSTEM_OID="2.16.840.1.113883.6.1";

	/**
	* <div class="en">Name of the Code System</div>
	* <div class="de">Name des Codes Systems</div>
	*/
	public static final String CODE_SYSTEM_NAME="LOINC";


	/**
	* <div class="en">Machine interpretable and (inside this class) unique code</div>
	* <div class="de">Maschinen interpretierbarer und (innerhalb dieser Klasse) eindeutiger Code</div>
	*/
	protected String code;

	/**
	* <div class="en">Human readable name</div>
	* <div class="de">Menschenlesbarer Name</div>
	*/
	protected String displayName;
	
	/**
	* <div class="en">Instantiates this Enum Object with a given Code and Display Name</div>
	* <div class="de">Instantiiert dieses Enum Object mittels eines Codes und einem Display Name</div>
	*
	* @param code <br>
	*	<div class="de"> code</div>
	* @param displayName <br>
	*	<div class="de"> display name</div>
	*/
	private LrtpSections (String code, String displayName) {
		this.code = code;
		this.displayName = displayName;
	}

	/**
	* <div class="en">Gets the ehealthconnector Code Object</div>
	* <div class="de">Liefert das ehealthconnector Code Objekt</div>
	*
	* @return <div class="en">the code</div>
	*/
	public Code getCode() {
		Code ehcCode = new Code(CODE_SYSTEM_OID, code, CODE_SYSTEM_NAME, displayName);
		return ehcCode;
	}

	/**
	* <div class="en">Gets the Code of this Enum as MDHT Object.</div>
	* <div class="de">Liefert den Code dieses Enum als MDHT Objekt.</div>
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
	* <div class="en">Gets the code system name.</div>
	* <div class="de">Liefert code system name.</div>
	*
	* @return <div class="en">the code system name</div>
	*/
	public String getCodeSystemName() {
		return CODE_SYSTEM_NAME;
	}

	/**
	* <div class="en">Gets the code system id.</div>
	* <div class="de">Liefert die code system id.</div>
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
		return this.code;
	}

	/**
	* <div class="en">Gets the display name.</div>
	* <div class="de">Liefert display name.</div>
	*
	* @return <div class="en">the display name</div>
	*/
	public String getDisplayName() {
		return this.displayName;
	}
 
	/**
	* <div class="en">Gets the Enum with a given code</div>
	* <div class="de">Liefert den Enum anhand eines gegebenen codes</div>
	*
	* @param code <br>
	*      <div class="de"> code</div>
	* @return <div class="en">the enum</div>
	*/
	public static LrtpSections getEnum(String code) {
		for (LrtpSections x : values()) {
			if (x.getCodeValue().equals(code)) {
				return x;
			}
		}
		return null;
	}
  
	/**
	* <div class="en">Checks if a given enum is part of this value set.</div>
	* <div class="de">Prüft, ob der gegebene enum Teil dieses Value Sets ist.</div>
	*
	*
	* @param enumName <br>
	*      <div class="de"> enumName</div>
	* @return true, if enum is in this value set
	*/
	public static boolean isEnumOfValueSet(String enumName) {
		if (enumName == null) {
			return false;
		}
		try {
			Enum.valueOf(LrtpSections.class, enumName);
			return true;
		} catch (final IllegalArgumentException ex) {
			return false;
		}
	}


	/**
	* <div class="en">Checks if a given code value is in this value set.</div>
	* <div class="de">Prüft, ob der gegebene code in diesem Value Set vorhanden ist.</div>
	*
	* @param codeValue <br>
	*      <div class="de"> code</div>
	* @return true, if is in value set
	*/
	public static boolean isInValueSet(String codeValue) {
		for (LrtpSections x : values()) {
			if (x.getCodeValue().equals(codeValue)) {
				return true;
			}
		}
		return false;
	}

}