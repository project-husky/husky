package org.ehealth_connector.cda.ch.lab.lrph.enums;

import java.util.Date;

import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.utils.DateUtil;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/*
*<div class="de">Meldepflichtige Beobachtung</div>
*<div class="fr"></div>
*/
public enum LabObsListLoinc {

	/**
	 * <div class="en">Abnormal Prion Protein [Presence] in Brain by Electron
	 * microscopy</div>
	 */
	ABNORMAL_PRION_PROTEIN_PRESENCE_IN_BRAIN_BY_ELECTRON_MICROSCOPY("23381-7", "Abnormal Prion Protein [Presence] in Brain by Electron microscopy", "18725-2", "none", "20130527", ""),
	/**
	 * <div class="en">Brucella abortus Ab [Presence] in Cerebral spinal
	 * fluid</div>
	 */
	BRUCELLA_ABORTUS_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID("49196-9", "Brucella abortus Ab [Presence] in Cerebral spinal fluid", "18725-2", "initials", "20130527", "");

	/**
	 * <div class="en">Code for Abnormal Prion Protein [Presence] in Brain by
	 * Electron microscopy</div>
	 */
	public static final String ABNORMAL_PRION_PROTEIN_PRESENCE_IN_BRAIN_BY_ELECTRON_MICROSCOPY_CODE = "23381-7";

	/**
	 * <div class="en">Code for Brucella abortus Ab [Presence] in Cerebral spinal
	 * fluid</div>
	 */
	public static final String BRUCELLA_ABORTUS_AB_PRESENCE_IN_CEREBRAL_SPINAL_FLUID_CODE = "49196-9";

	/**
	 * <div class="en">Name of the Code System</div> <div class="de">Name des
	 * Codes Systems</div>
	 */
	public static final String CODE_SYSTEM_NAME = "LabReportListLoinc";

	/**
	 * <div class="en">Identifier of the Code System</div>
	 * <div class="de">Identifikator für das Code System</div>
	 */
	public static final String CODE_SYSTEM_OID = "2.16.840.1.113883.6.1";

	/**
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 *
	 * @param code
	 *          <br>
	 *          <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static LabObsListLoinc getEnum(String code) {
		for (LabObsListLoinc x : values()) {
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
	 *          <br>
	 *          <div class="de"> enumName</div>
	 * @return true, if enum is in this value set
	 */
	public static boolean isEnumOfValueSet(String enumName) {
		if (enumName == null) {
			return false;
		}
		try {
			Enum.valueOf(LabObsListLoinc.class, enumName);
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
	 *          <br>
	 *          <div class="de"> code</div>
	 * @return true, if is in value set
	 */
	public static boolean isInValueSet(String codeValue) {
		for (LabObsListLoinc x : values()) {
			if (x.getCodeValue().equals(codeValue)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * <div class="en">Machine interpretable and (inside this class) unique
	 * code</div> <div class="de">Maschinen interpretierbarer und (innerhalb
	 * dieser Klasse) eindeutiger Code</div>
	 */
	protected String code;

	/**
	 * <div class="en">Human readable name</div> <div class="de">Menschenlesbarer
	 * Name</div>
	 */
	protected String displayName;

	/**
	 * <div class="en">The Patient privacy filter is used to determine the
	 * anonymisation or pseudonymisation mode for the patient data.</div>
	 * <div class="de">Der Patient Privacy Filter wird verwendet, um die Art der
	 * Anonymisierung oder Pseudonymisierung der Patientendaten zu bestimmen</div>
	 */
	protected String patientPrivacyFilter;

	/**
	 * <div class="en">Section code for this Element</div> <div class="de">Section
	 * Code für dieses Element</div>
	 */
	protected String sectionCode;

	/**
	 * <div class="en">Start date for the period in which this element can be
	 * used</div> <div class="de">Startdatum der Periode, innerhalb derer dieses
	 * Element valide ist</div>
	 */
	protected Date validFrom;

	/**
	 * <div class="en">End date for the period in which this element can be
	 * used</div> <div class="de">Enddatum der Periode, innerhalb derer dieses
	 * Element valide ist</div>
	 */
	protected Date validTo;

	/**
	 * <div class="en">Instantiates this Enum Object with given code, displayName,
	 * specialitySectionCode, privacyFilter, validFrom and validTo
	 * parameters</div> <div class="de">Instantiiert dieses Enum Object mittels
	 * der code, displayName, specialitySectionCode, privacyFilter, validFrom und
	 * validTo Parameter</div>
	 *
	 * @param code
	 *          <br>
	 *          <div class="en">the code</div>
	 * @param displayName
	 *          <br>
	 *          <div class="en">the display name</div>
	 * @param sectionCode
	 *          <br>
	 *          <div class="en">the specialty section code</div>
	 * @param patientPrivacyFilter
	 *          <br>
	 *          <div class="en">the patient privacy filter</div>
	 * @param validFrom
	 *          <br>
	 *          <div class="en">the valid from</div>
	 * @param validTo
	 *          <br>
	 *          <div class="en">the valid to</div>
	 */
	private LabObsListLoinc(String code, String displayName, String sectionCode,
			String patientPrivacyFilter, String validFrom, String validTo) {
		this.code = code;
		this.displayName = displayName;
		this.sectionCode = sectionCode;
		this.patientPrivacyFilter = patientPrivacyFilter;
		if (validFrom != null && !"".equals(validFrom)) {
			this.validFrom = DateUtil.parseDateyyyyMMdd(validFrom);
		}
		if (validTo != null && !"".equals(validTo)) {
			this.validTo = DateUtil.parseDateyyyyMMdd(validTo);
		}
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
	 * <div class="en">Gets the code system name.</div> <div class="de">Liefert
	 * code system name.</div>
	 *
	 * @return <div class="en">the code system name</div>
	 */
	public String getCodeSystemName() {
		return CODE_SYSTEM_NAME;
	}

	/**
	 * <div class="en">Gets the code system id.</div> <div class="de">Liefert die
	 * code system id.</div>
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
	 * <div class="en">Gets the display name.</div> <div class="de">Liefert
	 * display name.</div>
	 *
	 * @return <div class="en">the display name</div>
	 */
	public String getDisplayName() {
		return this.displayName;
	}

	/**
	 * <div class="en">Gets the patient privacy filter</div>
	 * <div class="de">Liefert patient privacy filter</div>
	 *
	 * @return the patient privacy filter
	 */
	public String getPatientPrivacyFilter() {
		return this.patientPrivacyFilter;
	}

	/**
	 * <div class="en">Gets the section code</div> <div class="de">Liefert section
	 * code</div>
	 *
	 * @return the section code
	 */
	public String getSectionCode() {
		return this.sectionCode;
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
	 *          the date
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