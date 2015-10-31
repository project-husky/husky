/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2015
 *
 *******************************************************************************/
package org.ehealth_connector.cda.ch.enums;

import java.util.Arrays;
import java.util.Date;

import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.DateUtil;

/**
 * This subset contains immunization for which an vaccine can be given in
 * switzerland. The sortorder is equivalent to the ordering of the vaccines in
 * the offical document for immunization recording. Value Set valid from
 * 20130101 Codesystem: SNOMED CT (OID: 2.16.840.1.113883.6.96) Value-Set:
 * CDA-CH-VACD immunizations (OID: 2.16.756.5.30.1.127.3.3.3)
 */
public enum CdaChVacdImmunizations {

	/** BCG vaccination */
	BCG("42284007", "BCG vaccination", "20130101", "", 25),

	/** Diphtheria vaccination (procedure) */
	DIPHTHERIA("76668005", "Diphtheria vaccination (procedure)", "20130101", "", 1),

	/** Haemophilus influenzae type b vaccination (procedure) */
	HAEMOPHILUS("127787002", "Haemophilus influenzae type b vaccination (procedure)", "20130101",
			"", 5),

	/** Hepatitis A immunization (procedure) */
	HEPA("243789007", "Hepatitis A immunization (procedure)", "20130101", "", 7),

	/** Hepatitis B vaccination (procedure) */
	HEPB("16584000", "Hepatitis B vaccination (procedure)", "20130101", "", 6),

	/** Influenza vaccination (procedure) */
	INFLUENZA("86198006", "Influenza vaccination (procedure)", "20130101", "", 31),

	/** Japanese encephalitis vaccination (procedure) */
	JAPANESE("314759000", "Japanese encephalitis vaccination (procedure)", "20130101", "", 32),

	/** Measles vaccination (procedure) */
	MEASLES("47435007", "Measles vaccination (procedure)", "20130101", "", 8),

	/** Meningococcus vaccination (procedure) */
	MENINGOCOCCUS("41088001", "Meningococcus vaccination (procedure)", "20130101", "", 23),

	/** Mumps vaccination (procedure) */
	MUMPS("50583002", "Mumps vaccination (procedure)", "20130101", "", 9),

	/** Pertussis vaccination (procedure) */
	PERTUSSIS("39343008", "Pertussis vaccination (procedure)", "20130101", "", 3),

	/** Pneumococcal vaccination (procedure) */
	PNEUMOCOCCAL("12866006", "Pneumococcal vaccination (procedure)", "20130101", "", 21),

	/** Poliomyelitis vaccination (procedure) */
	POLIOMYELITIS("72093006", "Poliomyelitis vaccination (procedure)", "20130101", "", 4),

	/** Rabies vaccination (procedure) */
	RABIES("34631000", "Rabies vaccination (procedure)", "20130101", "", 33),

	/** Rubella vaccination (procedure) */
	RUBELLA("82314000", "Rubella vaccination (procedure)", "20130101", "", 10),

	/** Tetanus vaccination (procedure) */
	TETANUS("127786006", "Tetanus vaccination (procedure)", "20130101", "", 2),

	/** Tick-borne encephalitis vaccination (procedure) */
	TICKBORNENCEPHALITIS("281658005", "Tick-borne encephalitis vaccination (procedure)",
			"20130101", "", 24),

	/** Typhus vaccination (procedure) */
	TYPHUS("30338008", "Typhus vaccination (procedure)", "20130101", "", 34),

	/** Vaccination for human papillomavirus (procedure) */
	PAPILLOMAVIRUS("428570002", "Vaccination for human papillomavirus (procedure)", "20130101", "",
			12),

	/** Varicella vaccination (procedure) */
	VARICELLA("68525005", "Varicella vaccination (procedure)", "20130101", "", 20),

	/** Yellow fever vaccination (procedure) */
	YELLOFEVER("67308009", "Yellow fever vaccination (procedure)", "20130101", "", 25);

	/** The Constant CODE_SYSTEM_OID. */
	public static final String CODE_SYSTEM_OID = "2.16.840.1.113883.6.96";

	/** The Constant CODE_SYSTEM_NAME. */
	public static final String CODE_SYSTEM_NAME = "CDA-CH-VACD immunizations";

	/** The code. */
	private String code;

	/** The display name. */
	private String displayName;

	/** The valid from Date. */
	private Date validFrom;

	/** The valid to Date. */
	private Date validTo;

	/** The sort order. */
	private int sortOrder;

	/**
	 * <div class="en">Instantiates this Enum Object with a given Code and
	 * Display Name</div> <div class="de">Instantiiert dieses Enum Object
	 * mittels eines Codes und einem Display Name</div>.
	 * 
	 * @param code
	 * <br>
	 *            <div class="de"> code</div>
	 * @param displayName
	 * <br>
	 *            <div class="de"> display name</div>
	 */
	private CdaChVacdImmunizations(String code, String displayName, String validFrom,
			String validTo, int sortOrder) {
		this.code = code;
		this.displayName = displayName;
		if (validFrom != null && !"".equals(validFrom)) {
			this.validFrom = DateUtil.parseDateyyyyMMdd(validFrom);
		}
		if (validTo != null && !"".equals(validTo)) {
			this.validTo = DateUtil.parseDateyyyyMMdd(validTo);
		}
		this.sortOrder = sortOrder;
	}

	/**
	 * <div class="en">Gets the Enum with a given code</div> <div
	 * class="de">Liefert den Enum anhand eines gegebenen codes</div>.
	 * 
	 * @param code
	 * <br>
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static CdaChVacdImmunizations getEnum(String code) {
		for (CdaChVacdImmunizations x : values()) {
			if (x.getCodeValue().equals(code)) {
				return x;
			}
		}
		return null;
	}

	/**
	 * <div class="en">Gets the ehealthconnector Code Object</div> <div
	 * class="de">Liefert das ehealthconnector Code Objekt</div>.
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
	 * class="de">Liefert den eigentlichen Code als String</div>.
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

	/**
	 * Gets the sort order.
	 * 
	 * @return the sort order
	 */
	public int getSortOrder() {
		return sortOrder;
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
		for (CdaChVacdImmunizations x : values()) {
			if (x.getCodeValue().equals(code)) {
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
	 * Checks if the code is valid for the specified date
	 * 
	 * @param date
	 *            the date
	 * @return true, if is valid
	 */
	public boolean isValid(Date date) {
		if (date == null) {
			date = new Date();
		}
		if (this.validFrom != null && validFrom.after(date)) {
			return false;
		}
		if (this.validTo != null && validTo.before(date)) {
			return false;
		}
		return true;
	}

}