package org.ehealth_connector.cda.ch.lab.lrtp.enums;

import org.ehealth_connector.common.Code;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.CS;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

import java.util.Date;
import org.ehealth_connector.common.utils.DateUtil;
/*
*<div class="de">Liste der Vitalzeichen</div>
*<div class="fr"></div>
*/
public enum VitalSignList {

	/** 
	*<div class="en">Body height</div>
	*/
	BODY_HEIGHT ("8302-2", "Body height", "20140101", ""),
	/** 
	*<div class="en">Body temperature</div>
	*/
	BODY_TEMPERATURE ("8310-5", "Body temperature", "20140101", ""),
	/** 
	*<div class="en">Body weight Measured</div>
	*/
	BODY_WEIGHT_MEASURED ("3141-9", "Body weight Measured", "20140101", ""),
	/** 
	*<div class="en">Diastolic blood pressure</div>
	*/
	DIASTOLIC_BLOOD_PRESSURE ("8462-4", "Diastolic blood pressure", "20140101", ""),
	/** 
	*<div class="en">Heart rate</div>
	*/
	HEART_RATE ("8867-4", "Heart rate", "20140101", ""),
	/** 
	*<div class="en">Systolic blood pressure</div>
	*/
	SYSTOLIC_BLOOD_PRESSURE ("8480-6", "Systolic blood pressure", "20140101", "");

	/** 
	*<div class="en">Code for Body height</div>
	*/
	public static final String BODY_HEIGHT_CODE="8302-2";

	/** 
	*<div class="en">Code for Body temperature</div>
	*/
	public static final String BODY_TEMPERATURE_CODE="8310-5";

	/** 
	*<div class="en">Code for Body weight Measured</div>
	*/
	public static final String BODY_WEIGHT_MEASURED_CODE="3141-9";

	/** 
	*<div class="en">Code for Diastolic blood pressure</div>
	*/
	public static final String DIASTOLIC_BLOOD_PRESSURE_CODE="8462-4";

	/** 
	*<div class="en">Code for Heart rate</div>
	*/
	public static final String HEART_RATE_CODE="8867-4";

	/** 
	*<div class="en">Code for Systolic blood pressure</div>
	*/
	public static final String SYSTOLIC_BLOOD_PRESSURE_CODE="8480-6";



	/**
	* <div class="en">Identifier of the Code System</div>
	* <div class="de">Identifikator für das Code System</div>
	*/
	public static final String CODE_SYSTEM_OID="2.16.840.1.113883.6.1";

	/**
	* <div class="en">Name of the Code System</div>
	* <div class="de">Name des Codes Systems</div>
	*/
	public static final String CODE_SYSTEM_NAME="Liste der Vitalzeichen";


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
	* <div class="en">Start date for the period in which this element can be used</div>
	* <div class="de">Startdatum der Periode, innerhalb derer dieses Element valide ist</div>
	*/
	protected Date validFrom;

	/**
	* <div class="en">End date for the period in which this element can be used</div>
	* <div class="de">Enddatum der Periode, innerhalb derer dieses Element valide ist</div>
	*/
	protected Date validTo;
	
	/**
	* <div class="en">Instantiates this Enum Object with given code, displayName, validFrom and validTo parameters</div>
	* <div class="de">Instantiiert dieses Enum Object mittels der code, displayName, validFrom und validTo Parameter</div>
	*
	* @param code <br>
	*	<div class="en">the code</div>
	* @param displayName <br>
	*	<div class="en">the display name</div>
	* @param validFrom <br>
	*<div class="en">the valid from</div>
	* @param validTo <br>
	*<div class="en">the valid to</div>
	*/
	private VitalSignList(String code, String displayName, String validFrom, String validTo) {
		this.code = code;
		this.displayName = displayName;
		if (validFrom != null && !"".equals(validFrom)) {
			this.validFrom = DateUtil.parseDateyyyyMMdd(validFrom);
		}
		if (validTo != null && !"".equals(validTo)) {
			this.validTo = DateUtil.parseDateyyyyMMdd(validTo);
		}
	}

	/**
	* <div class="en">Gets the ehealthconnector Code Object</div>
	* <div class="de">Liefert das ehealthconnector Code Objekt</div>
	*
	* @return <div class="en">the code</div>
	*/
	public Code getCode() {
		Code ehcCode = new Code(CODE_SYSTEM_OID, code, displayName);
		return ehcCode;
	}

	/**
	* <div class="en">Gets the Code of this Enum as MDHT Object.</div>
	* <div class="de">Liefert den Code dieses Enum als MDHT Objekt.</div>
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
	public static VitalSignList getEnum(String code) {
		for (VitalSignList x : values()) {
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
			Enum.valueOf(VitalSignList.class, enumName);
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
		for (VitalSignList x : values()) {
			if (x.getCodeValue().equals(codeValue)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if the code is valid now.
	 *
	 * @return true, if is valid
	 */
	public boolean isValid() {
		return isValid(null);
	}

	/**
	 * Checks if the code is valid for the specified date.
	 *
	 * @param date
	 *            the date
	 * @return true, if is valid
	 */
	public boolean isValid(Date date) {
		if (date == null) {
			date = new Date();
		}
		if (validFrom != null && validFrom.after(date)) {
			return false;
		}
		if (validTo != null && validTo.before(date)) {
			return false;
		}
		return true;
	}
}