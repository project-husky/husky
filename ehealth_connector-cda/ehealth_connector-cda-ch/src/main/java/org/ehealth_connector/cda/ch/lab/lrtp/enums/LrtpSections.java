package org.ehealth_connector.cda.ch.lab.lrtp.enums;

import org.ehealth_connector.cda.enums.ContentIdPrefix;
import org.ehealth_connector.cda.enums.LanguageCode;
import org.ehealth_connector.common.Code;
import org.openhealthtools.mdht.uml.cda.Section;
import org.openhealthtools.mdht.uml.cda.ch.CdaChLrtp;
import org.openhealthtools.mdht.uml.hl7.datatypes.CS;

/*
*<div class="de">LRTP CDA Body Level 2 Section Codes</div>
*<div class="fr"></div>
*/
public enum LrtpSections implements ContentIdPrefix {

	/**
	 * <div class="en">Relevant diagnostic tests/laboratory data</div>
	 * <div class="de">Blutgruppe</div>
	 */
	RELEVANT_DIAGNOSTIC_TESTSLABORATORY_DATA("30954-2", "blood", "Blutgruppe", "Groupe sanguin",
			"Gruppo sanguigno", "Blood Group"),
	/**
	 * <div class="en">Vital signs</div> <div class="de">Vitalzeichen</div>
	 */
	VITAL_SIGNS("8716-3", "vital", "Codierte Vitalzeichenliste ", "Signes vitaux codés",
			"Elenco codificato dei segni vitali", "Vital signs");

	/**
	 * <div class="en">Name of the Code System</div> <div class="de">Name des
	 * Codes Systems</div>
	 */
	public static final String CODE_SYSTEM_NAME = "LOINC";

	/**
	 * <div class="en">Identifier of the Code System</div>
	 * <div class="de">Identifikator für das Code System</div>
	 */
	public static final String CODE_SYSTEM_OID = "2.16.840.1.113883.6.1";

	/**
	 * <div class="en">Code for Relevant diagnostic tests/laboratory data</div>
	 * <div class="de">Code für Blutgruppe</div>
	 */
	public static final String RELEVANT_DIAGNOSTIC_TESTSLABORATORY_DATA_CODE = "30954-2";

	/**
	 * <div class="en">Code for Vital signs</div> <div class="de">Code für
	 * Vitalzeichen</div>
	 */
	public static final String VITAL_SIGNS_CODE = "8716-3";

	/**
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 *
	 * @param code
	 *          <br>
	 *          <div class="de"> code</div>
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
	 * <div class="de">Prüft, ob der gegebene enum Teil dieses Value Sets
	 * ist.</div>
	 *
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
			Enum.valueOf(LrtpSections.class, enumName);
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
		for (LrtpSections x : values()) {
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

	private String contentIdPrefix;

	private String loincCode;

	private String sectionTitleDe;

	private String sectionTitleEn;

	private String sectionTitleFr;

	private String sectionTitleIt;

	/**
	 * <div class="en">Instantiates this Enum Object with a given Code and Display
	 * Name</div> <div class="de">Instantiiert dieses Enum Object mittels eines
	 * Codes und einem Display Name</div>
	 *
	 * @param code
	 *          <br>
	 *          <div class="de"> code</div>
	 * @param displayName
	 *          <br>
	 *          <div class="de"> display name</div>
	 */
	LrtpSections(String code, String contentIdPrefix, String sectionTitleDe, String sectionTitleFr,
			String sectionTitleIt, String sectionTitleEn) {
		this.contentIdPrefix = contentIdPrefix;
		this.sectionTitleDe = sectionTitleDe;
		this.sectionTitleFr = sectionTitleFr;
		this.sectionTitleIt = sectionTitleIt;
		this.sectionTitleEn = sectionTitleEn;
		this.code = code;
	}

	public Section findSection(CdaChLrtp lrtpDocument) {
		for (final Section section : lrtpDocument.getSections()) {
			if (section.getCode() != null) {
				if (loincCode.equals(section.getCode().getCode())) {
					return section;
				}
			}
		}
		return null;
	}

	/**
	 * <div class="en">Gets the ehealthconnector Code Object</div>
	 * <div class="de">Liefert das ehealthconnector Code Objekt</div>
	 *
	 * @return <div class="en">the code</div>
	 */
	public Code getCode() {
		Code ehcCode = new Code(CODE_SYSTEM_OID, code);
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

	@Override
	public String getContentIdPrefix() {
		return contentIdPrefix;
	}

	public String getLoincCode() {
		return loincCode;
	}

	public String getSectionTitle(CS lc) {
		String lcStr = LanguageCode.ENGLISH.getCodeValue();
		if (lc != null) {
			lcStr = lc.getCode().toLowerCase();
		}
		if (lcStr.equals(LanguageCode.GERMAN.getCodeValue().toLowerCase()))
			return getSectionTitleDe();
		if (lcStr.equals(LanguageCode.FRENCH.getCodeValue().toLowerCase()))
			return getSectionTitleFr();
		if (lcStr.equals(LanguageCode.ITALIAN.getCodeValue().toLowerCase()))
			return getSectionTitleIt();
		if ("de".equals(lcStr))
			return getSectionTitleDe();
		if ("fr".equals(lcStr))
			return getSectionTitleFr();
		if ("it".equals(lcStr))
			return getSectionTitleIt();
		if ("en".equals(lcStr))
			return getSectionTitleEn();
		return getSectionTitleDe();
	}

	public String getSectionTitleDe() {
		return sectionTitleDe;
	}

	public String getSectionTitleEn() {
		return sectionTitleEn;
	}

	public String getSectionTitleFr() {
		return sectionTitleFr;
	}

	public String getSectionTitleIt() {
		return sectionTitleIt;
	}

}