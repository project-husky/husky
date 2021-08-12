/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
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
package org.ehealth_connector.cda.ch.vacd.v210.enums;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.processing.Generated;

import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.mdht.enums.ValueSetEnumInterface;

/**
 * <!-- @formatter:off -->
 * <div class="en"><span lang="EN-GB" style="font-size:9.0pt;font-family: &#34;Arial&#34;,sans-serif;mso-fareast-font-family:&#34;Times New Roman&#34;;mso-bidi-font-family: &#34;Times New Roman&#34;;color:black;mso-themecolor:text1;mso-ansi-language:EN-GB; mso-fareast-language:EN-US;mso-bidi-language:AR-SA">These are past illnesses which result in a natural immunization.</span></div>
 * <div class="de">Es handelt sich hier um durchgemachte Erkrankungen, die einen Immunschutz zur Folge haben.</div>
 * <div class="fr">no designation found for language FRENCH</div>
 * <div class="it">no designation found for language ITALIAN</div>
 * <!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets")
public enum IllnessesUndergoneForImmunization implements ValueSetEnumInterface {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Central European encephalitis (disorder)</div>
	 * <!-- @formatter:on -->
	 */
	CENTRAL_EUROPEAN_ENCEPHALITIS_DISORDER("16901001", "2.16.840.1.113883.6.96",
			"Central European encephalitis (disorder)", "Central European encephalitis (disorder)",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Measles (disorder)</div>
	 * <!-- @formatter:on -->
	 */
	MEASLES_DISORDER("14189004", "2.16.840.1.113883.6.96", "Measles (disorder)",
			"Measles (disorder)", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Mumps (disorder)</div>
	 * <!-- @formatter:on -->
	 */
	MUMPS_DISORDER("36989005", "2.16.840.1.113883.6.96", "Mumps (disorder)", "Mumps (disorder)",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Rubella (disorder)</div>
	 * <!-- @formatter:on -->
	 */
	RUBELLA_DISORDER("36653000", "2.16.840.1.113883.6.96", "Rubella (disorder)",
			"Rubella (disorder)", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Tetanus (disorder)</div>
	 * <!-- @formatter:on -->
	 */
	TETANUS_DISORDER("76902006", "2.16.840.1.113883.6.96", "Tetanus (disorder)",
			"Tetanus (disorder)", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Varicella (disorder)</div>
	 * <!-- @formatter:on -->
	 */
	VARICELLA_DISORDER("38907003", "2.16.840.1.113883.6.96", "Varicella (disorder)",
			"Varicella (disorder)", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Viral hepatitis, type A (disorder)</div>
	 * <!-- @formatter:on -->
	 */
	VIRAL_HEPATITIS_TYPE_A_DISORDER("40468003", "2.16.840.1.113883.6.96",
			"Viral hepatitis, type A (disorder)", "Viral hepatitis, type A (disorder)",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Viral hepatitis type B (disorder)</div>
	 * <!-- @formatter:on -->
	 */
	VIRAL_HEPATITIS_TYPE_B_DISORDER("66071002", "2.16.840.1.113883.6.96",
			"Viral hepatitis type B (disorder)", "Viral hepatitis type B (disorder)", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Yellow fever (disorder)</div>
	 * <!-- @formatter:on -->
	 */
	YELLOW_FEVER_DISORDER("16541001", "2.16.840.1.113883.6.96", "Yellow fever (disorder)",
			"Yellow fever (disorder)", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE");

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Central European encephalitis (disorder)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CENTRAL_EUROPEAN_ENCEPHALITIS_DISORDER_CODE = "16901001";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Measles (disorder)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MEASLES_DISORDER_CODE = "14189004";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Mumps (disorder)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MUMPS_DISORDER_CODE = "36989005";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Rubella (disorder)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RUBELLA_DISORDER_CODE = "36653000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Tetanus (disorder)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TETANUS_DISORDER_CODE = "76902006";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Varicella (disorder)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VARICELLA_DISORDER_CODE = "38907003";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Viral hepatitis, type A (disorder)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VIRAL_HEPATITIS_TYPE_A_DISORDER_CODE = "40468003";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Viral hepatitis type B (disorder)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VIRAL_HEPATITIS_TYPE_B_DISORDER_CODE = "66071002";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Yellow fever (disorder)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String YELLOW_FEVER_DISORDER_CODE = "16541001";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Identifier of the value set</div>
	 * <div class="de">Identifikator für das Value Set</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_ID = "2.16.756.5.30.1.1.11.75";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Name of the value set</div>
	 * <div class="de">Name des Value Sets</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_NAME = "IllnessesUndergoneForImmunization";

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
	public static IllnessesUndergoneForImmunization getEnum(String code) {
		for (final IllnessesUndergoneForImmunization x : values()) {
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
			Enum.valueOf(IllnessesUndergoneForImmunization.class, enumName);
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
		for (final IllnessesUndergoneForImmunization x : values()) {
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
	IllnessesUndergoneForImmunization(String code, String codeSystem, String displayName,
			String displayNameEn, String displayNameDe, String displayNameFr,
			String displayNameIt) {
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
