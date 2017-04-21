/*
 * 
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 * 
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
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
package org.ehealth_connector.cda.ch.lab.lrtp.enums;

import java.util.Date;

import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.utils.DateUtil;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/**
 * The Enum SpecialtySections.
 */
/*
 * <div class="en">Report group</div> <div class="de">Befundgruppe</div>
 */
public enum SpecialtySections {

	/** <div class="en">Blood bank studies</div>. */
	BLOOD_BANK_STUDIES("18717-9", "Blood bank studies", "20140101", ""),

	/** <div class="en">Blood gas studies</div>. */
	BLOOD_GAS_STUDIES("18767-4", "Blood gas studies", "20140101", ""),

	/** <div class="en">Cell counts+Differential studies</div>. */
	CELL_COUNTS_DIFFERENTIAL_STUDIES("18768-2", "Cell counts+Differential studies", "20140101", ""),

	/** <div class="en">Chemistry studies</div>. */
	CHEMISTRY_STUDIES("18719-5", "Chemistry studies", "20140101", ""),

	/** <div class="en">Coagulation studies</div>. */
	COAGULATION_STUDIES("18720-3", "Coagulation studies", "20140101", ""),

	/** <div class="en">Hematology studies</div>. */
	HEMATOLOGY_STUDIES("18723-7", "Hematology studies", "20140101", ""),

	/** <div class="en">HLA studies</div>. */
	HLA_STUDIES("18724-5", "HLA studies", "20140101", ""),

	/** <div class="en">Microbiology studies</div>. */
	MICROBIOLOGY_STUDIES("18725-2", "Microbiology studies", "20140101", ""),

	/** <div class="en">Serology studies</div>. */
	SEROLOGY_STUDIES("18727-8", "Serology studies", "20140101", ""),

	/** <div class="en">Urinalysis studies</div>. */
	URINALYSIS_STUDIES("18729-4", "Urinalysis studies", "20140101", "");

	/** <div class="en">Code for Blood bank studies</div>. */
	public static final String BLOOD_BANK_STUDIES_CODE = "18717-9";

	/** <div class="en">Code for Blood gas studies</div>. */
	public static final String BLOOD_GAS_STUDIES_CODE = "18767-4";

	/** <div class="en">Code for Cell counts+Differential studies</div>. */
	public static final String CELL_COUNTS_DIFFERENTIAL_STUDIES_CODE = "18768-2";

	/** <div class="en">Code for Chemistry studies</div>. */
	public static final String CHEMISTRY_STUDIES_CODE = "18719-5";

	/** <div class="en">Code for Coagulation studies</div>. */
	public static final String COAGULATION_STUDIES_CODE = "18720-3";

	/**
	 * <div class="en">Name of the Code System</div> <div class="de">Name des
	 * Codes Systems</div>.
	 */
	public static final String CODE_SYSTEM_NAME = "LOINC";

	/**
	 * <div class="en">Identifier of the Code System</div>
	 * <div class="de">Identifikator für das Code System</div>.
	 */
	public static final String CODE_SYSTEM_OID = "2.16.840.1.113883.6.1";

	/** <div class="en">Code for Hematology studies</div>. */
	public static final String HEMATOLOGY_STUDIES_CODE = "18723-7";

	/** <div class="en">Code for HLA studies</div>. */
	public static final String HLA_STUDIES_CODE = "18724-5";

	/** <div class="en">Code for Microbiology studies</div>. */
	public static final String MICROBIOLOGY_STUDIES_CODE = "18725-2";

	/** <div class="en">Code for Serology studies</div>. */
	public static final String SEROLOGY_STUDIES_CODE = "18727-8";

	/** <div class="en">Code for Urinalysis studies</div>. */
	public static final String URINALYSIS_STUDIES_CODE = "18729-4";

	/**
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>.
	 *
	 * @param code
	 *            the code (as present in this class with enumName_CODE)
	 * @return the according enum object
	 */
	public static SpecialtySections getEnum(String code) {
		for (final SpecialtySections x : values()) {
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
	 *            name of the enum (as present in this class)
	 * @return true, if the enum is in this value set
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
	 * <div class="de">Prüft, ob der gegebene code in diesem Value Set vorhanden
	 * ist.</div>
	 *
	 * @param codeValue
	 *            the code</div>
	 * @return true, if an enum with the given code is part of this value set
	 */
	public static boolean isInValueSet(String codeValue) {
		for (final SpecialtySections x : values()) {
			if (x.getCodeValue().equals(codeValue)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * <div class="en">Machine interpretable and (inside this class) unique
	 * code</div> <div class="de">Maschinen interpretierbarer und (innerhalb
	 * dieser Klasse) eindeutiger Code</div>.
	 */
	private String code;

	/**
	 * <div class="en">Human readable name</div>
	 * <div class="de">Menschenlesbarer Name</div>.
	 */
	private String displayName;

	/**
	 * <div class="en">Start date for the period in which this element can be
	 * used</div> <div class="de">Startdatum der Periode, innerhalb derer dieses
	 * Element valide ist</div>.
	 */
	private Date validFrom;

	/**
	 * <div class="en">End date for the period in which this element can be
	 * used</div> <div class="de">Enddatum der Periode, innerhalb derer dieses
	 * Element valide ist</div>.
	 */
	private Date validTo;

	/**
	 * <div class="en">Instantiates this Enum Object with given code,
	 * displayName, validFrom and validTo parameters</div>
	 * <div class="de">Instantiiert dieses Enum Object mittels der code,
	 * displayName, validFrom und validTo Parameter</div>.
	 *
	 * @param code
	 *            <br>
	 *            <div class="en">the code</div>
	 * @param displayName
	 *            <br>
	 *            <div class="en">the display name</div>
	 * @param validFrom
	 *            <br>
	 *            <div class="en">the valid from</div>
	 * @param validTo
	 *            <br>
	 *            <div class="en">the valid to</div>
	 */
	private SpecialtySections(String code, String displayName, String validFrom, String validTo) {
		this.code = code;
		this.displayName = displayName;
		if ((validFrom != null) && !"".equals(validFrom)) {
			this.validFrom = DateUtil.parseDateyyyyMMdd(validFrom);
		}
		if ((validTo != null) && !"".equals(validTo)) {
			this.validTo = DateUtil.parseDateyyyyMMdd(validTo);
		}
	}

	/**
	 * <div class="en">Gets the Code of this Enum as MDHT Object.</div>
	 * <div class="de">Liefert den Code dieses Enum als MDHT Objekt.</div>
	 *
	 * @return <div class="en">The MDHT Code</div>
	 */
	public CE getCE() {
		final CE ce = DatatypesFactory.eINSTANCE.createCE();
		ce.setCodeSystem(getCodeSystemOid());
		ce.setCode(code);
		ce.setDisplayName(displayName);
		return ce;
	}

	/**
	 * <div class="en">Gets the ehealthconnector Code Object</div>
	 * <div class="de">Liefert das ehealthconnector Code Objekt</div>.
	 *
	 * @return <div class="en">the code</div>
	 */
	public Code getCode() {
		final Code ehcCode = new Code(getCodeSystemOid(), code, CODE_SYSTEM_NAME, displayName);
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
	 * <div class="de">Liefert den eigentlichen Code als String</div>.
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
	public String getDisplayName() {
		return this.displayName;
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
	 * @return true, if it is valid
	 */
	public boolean isValid(Date date) {
		if (date == null) {
			date = new Date();
		}
		if ((validFrom != null) && validFrom.after(date)) {
			return false;
		}
		if ((validTo != null) && validTo.before(date)) {
			return false;
		}
		return true;
	}
}