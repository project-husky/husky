package org.ehealth_connector.cda.ch.lab.lrqc.enums;

import org.ehealth_connector.common.Code;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.CS;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

import java.util.Date;
import org.ehealth_connector.common.utils.DateUtil;
/*
*<div class="de">Befundgruppen für die externe obligatorische Qualitätskontrolle </div>
*<div class="fr"></div>
*/
public enum SpecialtySections {

	/** 
	*<div class="en">Blood bank studies</div>
	*/
	BLOOD_BANK_STUDIES ("18717-9", "Blood bank studies", "20150101", ""),
	/** 
	*<div class="en">Blood gas studies</div>
	*/
	BLOOD_GAS_STUDIES ("18767-4", "Blood gas studies", "20150101", ""),
	/** 
	*<div class="en">Cell counts+Differential studies</div>
	*/
	CELL_COUNTS_DIFFERENTIAL_STUDIES ("18768-2", "Cell counts+Differential studies", "20150101", ""),
	/** 
	*<div class="en">Chemistry studies</div>
	*/
	CHEMISTRY_STUDIES ("18719-5", "Chemistry studies", "20150101", ""),
	/** 
	*<div class="en">Coagulation studies</div>
	*/
	COAGULATION_STUDIES ("18720-3", "Coagulation studies", "20150101", ""),
	/** 
	*<div class="en">displayName</div>
	*/
	DISPLAYNAME ("value", "displayName", "validFrom", "validTo"),
	/** 
	*<div class="en">Hematology studies</div>
	*/
	HEMATOLOGY_STUDIES ("18723-7", "Hematology studies", "20150101", ""),
	/** 
	*<div class="en">HLA studies</div>
	*/
	HLA_STUDIES ("18724-5", "HLA studies", "20150101", ""),
	/** 
	*<div class="en">Microbial susceptibility tests Set</div>
	*/
	MICROBIAL_SUSCEPTIBILITY_TESTS_SET ("18769-0", "Microbial susceptibility tests Set", "20150101", ""),
	/** 
	*<div class="en">Microbiology studies</div>
	*/
	MICROBIOLOGY_STUDIES ("18725-2", "Microbiology studies", "20150101", ""),
	/** 
	*<div class="en">Molecular pathology studies (set)</div>
	*/
	MOLECULAR_PATHOLOGY_STUDIES_SET ("26435-8", "Molecular pathology studies (set)", "20150101", ""),
	/** 
	*<div class="en">Serology studies</div>
	*/
	SEROLOGY_STUDIES ("18727-8", "Serology studies", "20150101", ""),
	/** 
	*<div class="en">Urinalysis studies</div>
	*/
	URINALYSIS_STUDIES ("18729-4", "Urinalysis studies", "20150101", "");

	/** 
	*<div class="en">Code for Blood bank studies</div>
	*/
	public static final String BLOOD_BANK_STUDIES_CODE="18717-9";

	/** 
	*<div class="en">Code for Blood gas studies</div>
	*/
	public static final String BLOOD_GAS_STUDIES_CODE="18767-4";

	/** 
	*<div class="en">Code for Cell counts+Differential studies</div>
	*/
	public static final String CELL_COUNTS_DIFFERENTIAL_STUDIES_CODE="18768-2";

	/** 
	*<div class="en">Code for Chemistry studies</div>
	*/
	public static final String CHEMISTRY_STUDIES_CODE="18719-5";

	/** 
	*<div class="en">Code for Coagulation studies</div>
	*/
	public static final String COAGULATION_STUDIES_CODE="18720-3";

	/** 
	*<div class="en">Code for displayName</div>
	*/
	public static final String DISPLAYNAME_CODE="value";

	/** 
	*<div class="en">Code for Hematology studies</div>
	*/
	public static final String HEMATOLOGY_STUDIES_CODE="18723-7";

	/** 
	*<div class="en">Code for HLA studies</div>
	*/
	public static final String HLA_STUDIES_CODE="18724-5";

	/** 
	*<div class="en">Code for Microbial susceptibility tests Set</div>
	*/
	public static final String MICROBIAL_SUSCEPTIBILITY_TESTS_SET_CODE="18769-0";

	/** 
	*<div class="en">Code for Microbiology studies</div>
	*/
	public static final String MICROBIOLOGY_STUDIES_CODE="18725-2";

	/** 
	*<div class="en">Code for Molecular pathology studies (set)</div>
	*/
	public static final String MOLECULAR_PATHOLOGY_STUDIES_SET_CODE="26435-8";

	/** 
	*<div class="en">Code for Serology studies</div>
	*/
	public static final String SEROLOGY_STUDIES_CODE="18727-8";

	/** 
	*<div class="en">Code for Urinalysis studies</div>
	*/
	public static final String URINALYSIS_STUDIES_CODE="18729-4";



	/**
	* <div class="en">Identifier of the Code System</div>
	* <div class="de">Identifikator für das Code System</div>
	*/
	public static final String CODE_SYSTEM_OID="2.16.756.5.30.1.144.1.2.2016";

	/**
	* <div class="en">Name of the Code System</div>
	* <div class="de">Name des Codes Systems</div>
	*/
	public static final String CODE_SYSTEM_NAME="qc-repGroup";


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
	private SpecialtySections(String code, String displayName, String validFrom, String validTo) {
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
	public static SpecialtySections getEnum(String code) {
		for (SpecialtySections x : values()) {
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
			Enum.valueOf(SpecialtySections.class, enumName);
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
		for (SpecialtySections x : values()) {
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