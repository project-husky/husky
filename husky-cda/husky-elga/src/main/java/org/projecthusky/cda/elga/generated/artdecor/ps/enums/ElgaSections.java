package org.projecthusky.cda.elga.generated.artdecor.ps.enums;

import java.util.HashMap;
import java.util.Map;

import org.projecthusky.common.enums.CodeSystems;
import org.projecthusky.common.enums.LanguageCode;
import org.projecthusky.common.enums.ValueSetEnumInterface;


public enum ElgaSections implements ValueSetEnumInterface {

	BRIEFTEXT("BRIEFT", "1.2.40.0.34.5.40", "Brieftext", "Brieftext", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),

	ABBEM("ABBEM", "1.2.40.0.34.5.40", "Abschließende Bemerkungen", "Abschließende Bemerkungen", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),

	BEILAGEN("BEIL", "1.2.40.0.34.5.40", "Beilagen", "Beilagen",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),

	CLINICAL_INFORMATION("55752-0", "2.16.840.1.113883.6.1", "Clinical information", "Clinical information", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	
	DISCHARGE_MEDICATION("75311-1", "2.16.840.1.113883.6.1", "Discharge medications Narrative", "Discharge medications Narrative", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	
	ALLERGIES("48765-2", "2.16.840.1.113883.6.1", "Allergies and adverse reactions", "Allergies and adverse reactions", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	
	CHIEF_COMPLAINT("46239-0", "2.16.840.1.113883.6.1", "Chief complaint+Reason for visit", "Chief complaint+Reason for visit", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	
	ALERT("74018-3", "2.16.840.1.113883.6.1", "Alert", "Alert", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	
	HISTORY_OF_PAST_ILLNESS("11348-0", "2.16.840.1.113883.6.1", "HISTORY OF PAST ILLNESS", "HISTORY OF PAST ILLNESS", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	
	LABORATORIES_STUDIES("26436-6", "2.16.840.1.113883.6.1", "Laboratory studies (set)", "Laboratory studies (set)", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	
	TREATMENT_PLAN("18776-5", "2.16.840.1.113883.6.1", "Treatment plan", "Treatment plan", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	
	PROBLEM_LIST("11450-4", "2.16.840.1.113883.6.1", "Problem list", "Problem list", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	
	HISTORY_OF_IMMUNIZATIONS("11369-6", "2.16.840.1.113883.6.1", "HISTORY OF IMMUNIZATIONS", "HISTORY OF IMMUNIZATIONS", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE");


	public static final String BRIEFTEXT_CODE = "BRIEFT";

	public static final String ABBEM_CODE = "ABBEM";

	public static final String BEILAGEN_CODE = "BEIL";

	public static final String CLINICAL_INFORMATION_CODE = "55752-0";
	
	public static final String ALERT_CODE = "74018-3";
	
	public static final String DISCHARGE_MEDICATION_CODE = "75311-1";
	
	public static final String ALLERGIES_CODE = "48765-2";
	
	public static final String CHIEF_COMPLAINT_CODE = "46239-0";

	public static final String VALUE_SET_ID = "1.2.40.0.34.5.40";

	public static final String VALUE_SET_NAME = "ELGA_Sections";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 * <!-- @formatter:on -->
	 *
	 * @param code
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static ElgaSections getEnum(String code) {
		for (final ElgaSections x : values()) {
			if (x.getCodeValue().equals(code)) {
				return x;
			}
		}
		return null;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Checks if a given enum is part of this value set.</div>
	 * <div class="de">Prüft, ob der angegebene enum Teil dieses Value Sets ist.</div>
	 * <!-- @formatter:on -->
	 *
	 * @param enumName
	 *            <div class="de"> enumName</div>
	 * @return true, if enum is in this value set
	 */
	public static boolean isEnumOfValueSet(String enumName) {
		if (enumName == null) {
			return false;
		}
		try {
			Enum.valueOf(ElgaSections.class, enumName);
			return true;
		} catch (final IllegalArgumentException ex) {
			return false;
		}
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Checks if a given code value is in this value set.</div>
	 * <div class="de">Prüft, ob der angegebene code in diesem Value Set vorhanden ist.</div>
	 * <!-- @formatter:on -->
	 *
	 * @param codeValue
	 *            <div class="de"> code</div>
	 * @return true, if is in value set
	 */
	public static boolean isInValueSet(String codeValue) {
		for (final ElgaSections x : values()) {
			if (x.getCodeValue().equals(codeValue)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Machine interpretable and (inside this class) unique code</div>
	 * <div class="de">Maschinen interpretierbarer und (innerhalb dieser Klasse) eindeutiger Code</div>
	 * <!-- @formatter:on -->
	 */
	private String code;

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Identifier of the referencing code system.</div>
	 * <div class="de">Identifikator des referenzierende Codesystems.</div>
	 * <!-- @formatter:on -->
	 */
	private String codeSystem;

	/**
	 * The display names per language
	 */
	private Map<LanguageCode, String> displayNames;

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Instantiates this Enum Object with a given Code and Display Name</div>
	 * <div class="de">Instanziiert dieses Enum Object mittels eines Codes und einem Display Name</div>.
	 * <!-- @formatter:on -->
	 *
	 * @param code
	 *            code
	 * @param codeSystem
	 *            codeSystem
	 * @param displayName
	 *            the default display name
	 * @param displayNameEn
	 *            the display name en
	 * @param displayNameDe
	 *            the display name de
	 * @param displayNameFr
	 *            the display name fr
	 * @param displayNameIt
	 *            the display name it
	 */
	ElgaSections(String code, String codeSystem, String displayName, String displayNameEn,
			String displayNameDe, String displayNameFr, String displayNameIt) {
		this.code = code;
		this.codeSystem = codeSystem;
		displayNames = new HashMap<>();
		displayNames.put(null, displayName);
		displayNames.put(LanguageCode.ENGLISH, displayNameEn);
		displayNames.put(LanguageCode.GERMAN, displayNameDe);
		displayNames.put(LanguageCode.FRENCH, displayNameFr);
		displayNames.put(LanguageCode.ITALIAN, displayNameIt);
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the code system identifier.</div>
	 * <div class="de">Liefert den Code System Identifikator.</div>
	 * <!-- @formatter:on -->
	 *
	 * @return <div class="en">the code system identifier</div>
	 */
	@Override
	public String getCodeSystemId() {
		return this.codeSystem;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the code system name.</div>
	 * <div class="de">Liefert den Code System Namen.</div>
	 * <!-- @formatter:on -->
	 *
	 * @return <div class="en">the code system identifier</div>
	 */
	@Override
	public String getCodeSystemName() {
		String retVal = "";
		CodeSystems cs = CodeSystems.getEnum(this.codeSystem);
		if (cs != null)
			retVal = cs.getCodeSystemName();
		return retVal;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the actual Code as string</div>
	 * <div class="de">Liefert den eigentlichen Code als String</div>
	 * <!-- @formatter:on -->
	 *
	 * @return <div class="en">the code</div>
	 */
	@Override
	public String getCodeValue() {
		return this.code;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the display name defined by the language param. If
	 * there is no english translation, the default display name is returned.</div>
	 * <div class="de">Liefert display name gemäss Parameter, falls es keine
	 * Englische Übersetzung gibt, wird der default-Name zurückgegeben.</div>
	 * <!-- @formatter:on -->
	 *
	 * @param languageCode
	 *            the language code to get the display name for
	 * @return returns the display name in the desired language. if language not
	 *         found, display name in german will returned
	 */
	@Override
	public String getDisplayName(LanguageCode languageCode) {
		String displayName = displayNames.get(languageCode);
		if (displayName == null && languageCode == LanguageCode.ENGLISH) {
			return displayNames.get(null);
		}
		return displayName;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the value set identifier.</div>
	 * <div class="de">Liefert den Value Set Identifikator.</div>
	 * <!-- @formatter:on -->
	 *
	 * @return <div class="en">the value set identifier</div>
	 */
	@Override
	public String getValueSetId() {
		return VALUE_SET_ID;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gets the value set name.</div>
	 * <div class="de">Liefert den Value Set Namen.</div>
	 * <!-- @formatter:on -->
	 *
	 * @return <div class="en">the value set name</div>
	 */
	@Override
	public String getValueSetName() {
		return VALUE_SET_NAME;
	}
}
