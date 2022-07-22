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
package org.husky.cda.elga.generated.artdecor.enums;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.processing.Generated;

import org.husky.common.enums.CodeSystems;
import org.husky.common.enums.LanguageCode;
import org.husky.common.enums.ValueSetEnumInterface;

/**
 * <!-- @formatter:off -->
 * <div class="en">no designation found for language ENGLISH</div>
 * <div class="de">no designation found for language GERMAN</div>
 * <div class="fr">no designation found for language FRENCH</div>
 * <div class="it">no designation found for language ITALIAN</div>
 * <!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets")
public enum ElgaObservationInterpretation implements ValueSetEnumInterface {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Abnormal</div>
	 * <!-- @formatter:on -->
	 */
	ABNORMAL("A", "2.16.840.1.113883.5.83", "Abnormal", "Abnormal", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">decreased</div>
	 * <!-- @formatter:on -->
	 */
	DECREASED("D", "2.16.840.1.113883.5.83", "decreased", "decreased", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">High</div>
	 * <!-- @formatter:on -->
	 */
	HIGH("H", "2.16.840.1.113883.5.83", "High", "High", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">high off scale</div>
	 * <!-- @formatter:on -->
	 */
	HIGH_OFF_SCALE(">", "2.16.840.1.113883.5.83", "high off scale", "high off scale", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">increased</div>
	 * <!-- @formatter:on -->
	 */
	INCREASED("U", "2.16.840.1.113883.5.83", "increased", "increased", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Indeterminate</div>
	 * <!-- @formatter:on -->
	 */
	INDETERMINATE("IND", "2.16.840.1.113883.5.83", "Indeterminate", "Indeterminate", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Intermediate</div>
	 * <!-- @formatter:on -->
	 */
	INTERMEDIATE("I", "2.16.840.1.113883.5.83", "Intermediate", "Intermediate", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Low</div>
	 * <!-- @formatter:on -->
	 */
	LOW("L", "2.16.840.1.113883.5.83", "Low", "Low", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">low off scale</div>
	 * <!-- @formatter:on -->
	 */
	LOW_OFF_SCALE("<", "2.16.840.1.113883.5.83", "low off scale", "low off scale", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Negative</div>
	 * <!-- @formatter:on -->
	 */
	NEGATIVE("NEG", "2.16.840.1.113883.5.83", "Negative", "Negative", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">normal</div>
	 * <!-- @formatter:on -->
	 */
	NORMAL("N", "2.16.840.1.113883.5.83", "normal", "normal", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">outside threshold</div>
	 * <!-- @formatter:on -->
	 */
	OUTSIDE_THRESHOLD("EX", "2.16.840.1.113883.5.83", "outside threshold", "outside threshold",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Positive</div>
	 * <!-- @formatter:on -->
	 */
	POSITIVE("POS", "2.16.840.1.113883.5.83", "Positive", "Positive", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Resistent</div>
	 * <!-- @formatter:on -->
	 */
	RESISTENT("R", "2.16.840.1.113883.5.83", "Resistent", "Resistent", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Susceptible</div>
	 * <!-- @formatter:on -->
	 */
	SUSCEPTIBLE("S", "2.16.840.1.113883.5.83", "Susceptible", "Susceptible", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE");

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Abnormal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ABNORMAL_CODE = "A";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for decreased</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DECREASED_CODE = "D";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for High</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HIGH_CODE = "H";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for high off scale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HIGH_OFF_SCALE_CODE = ">";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for increased</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INCREASED_CODE = "U";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Indeterminate</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INDETERMINATE_CODE = "IND";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Intermediate</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTERMEDIATE_CODE = "I";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Low</div>
	 * <!-- @formatter:on -->
	 */
	public static final String LOW_CODE = "L";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for low off scale</div>
	 * <!-- @formatter:on -->
	 */
	public static final String LOW_OFF_SCALE_CODE = "<";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Negative</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NEGATIVE_CODE = "NEG";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for normal</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NORMAL_CODE = "N";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for outside threshold</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OUTSIDE_THRESHOLD_CODE = "EX";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Positive</div>
	 * <!-- @formatter:on -->
	 */
	public static final String POSITIVE_CODE = "POS";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Resistent</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RESISTENT_CODE = "R";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Susceptible</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SUSCEPTIBLE_CODE = "S";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Identifier of the value set</div>
	 * <div class="de">Identifikator für das Value Set</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_ID = "1.2.40.0.34.10.13";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Name of the value set</div>
	 * <div class="de">Name des Value Sets</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_NAME = "ELGA_ObservationInterpretation";

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
	public static ElgaObservationInterpretation getEnum(String code) {
		for (final ElgaObservationInterpretation x : values()) {
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
			Enum.valueOf(ElgaObservationInterpretation.class, enumName);
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
		for (final ElgaObservationInterpretation x : values()) {
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
	ElgaObservationInterpretation(String code, String codeSystem, String displayName,
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
