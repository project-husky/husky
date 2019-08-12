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
package org.ehealth_connector.communication.ch.enums;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.mdht.enums.ValueSetEnumInterface;

/**
 * <!-- @formatter:off -->
 * <div class="en">no designation found for language ENGLISH</div>
 * <div class="de">Das folgende Valueset zeigt das Mapping zwischen den Dokumentklassen und Dokumenttypen (gemäss Kapitel 2.11 Anhang 3 EPDV). Das Valueset dient als Hilfestellung bei der Implementierung. Für die konkreten Werte in documentTypeCode und documentClassCode dienen weiterhin die beiden definierten Valuesets (<span class="xforms-control xforms-select1 xforms-incremental xforms-select1-appearance-xxforms-tree xforms-visited" id="valueSetNavigation">    <span class="ygtvlabel node-sdraft xforms-tree-label-selected" id="ygtvlabelel10">EprDocumentTypeCode resp. </span></span><span class="xforms-control xforms-select1 xforms-incremental xforms-select1-appearance-xxforms-tree xforms-visited" id="valueSetNavigation">    <span class="ygtvlabel node-sdraft xforms-tree-label-selected" id="ygtvlabelel10">EprDocumentClassCode)</span></span>. <br clear="none"/></div>
 * <div class="fr">no designation found for language FRENCH</div>
 * <div class="it">no designation found for language ITALIAN</div>
 * <!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets")
public enum ClassTypeCodeMapping implements ValueSetEnumInterface {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Administrative documentation (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	ADMINISTRATIVE_DOCUMENTATION_RECORD_ARTIFACT("405624007", "2.16.840.1.113883.6.96",
			"Administrative documentation (record artifact)",
			"Administrative documentation (record artifact)", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Advance directive report (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	ADVANCE_DIRECTIVE_REPORT_RECORD_ARTIFACT("371538006", "2.16.840.1.113883.6.96",
			"Advance directive report (record artifact)",
			"Advance directive report (record artifact)", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Audit trail report (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	AUDIT_TRAIL_REPORT_RECORD_ARTIFACT("722160009", "2.16.840.1.113883.6.96",
			"Audit trail report (record artifact)", "Audit trail report (record artifact)",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Care Plan (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	CARE_PLAN_RECORD_ARTIFACT("734163000", "2.16.840.1.113883.6.96", "Care Plan (record artifact)",
			"Care Plan (record artifact)", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Clinical procedure report (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	CLINICAL_PROCEDURE_REPORT_RECORD_ARTIFACT("371525003", "2.16.840.1.113883.6.96",
			"Clinical procedure report (record artifact)",
			"Clinical procedure report (record artifact)", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Consent report (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	CONSENT_REPORT_RECORD_ARTIFACT("371537001", "2.16.840.1.113883.6.96",
			"Consent report (record artifact)", "Consent report (record artifact)", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Emergency medical identification record (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	EMERGENCY_MEDICAL_IDENTIFICATION_RECORD_RECORD_ARTIFACT("722216001", "2.16.840.1.113883.6.96",
			"Emergency medical identification record (record artifact)",
			"Emergency medical identification record (record artifact)", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Obstetrical Record (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	OBSTETRICAL_RECORD_RECORD_ARTIFACT("2171000195109", "2.16.756.5.30.1.127.3.4",
			"Obstetrical Record (record artifact)", "Obstetrical Record (record artifact)",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Order (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	ORDER_RECORD_ARTIFACT("721963009", "2.16.840.1.113883.6.96", "Order (record artifact)",
			"Order (record artifact)", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Organ donor card (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	ORGAN_DONOR_CARD_RECORD_ARTIFACT("772790007", "2.16.840.1.113883.6.96",
			"Organ donor card (record artifact)", "Organ donor card (record artifact)",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Patient record type (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	PATIENT_RECORD_TYPE_RECORD_ARTIFACT("184216000", "2.16.840.1.113883.6.96",
			"Patient record type (record artifact)", "Patient record type (record artifact)",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Prescription record (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	PRESCRIPTION_RECORD_RECORD_ARTIFACT("440545006", "2.16.840.1.113883.6.96",
			"Prescription record (record artifact)", "Prescription record (record artifact)",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Record artifact (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	RECORD_ARTIFACT_RECORD_ARTIFACT("419891008", "2.16.840.1.113883.6.96",
			"Record artifact (record artifact)", "Record artifact (record artifact)", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Record of health event (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	RECORD_OF_HEALTH_EVENT_RECORD_ARTIFACT("417319006", "2.16.840.1.113883.6.96",
			"Record of health event (record artifact)", "Record of health event (record artifact)",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Referral note (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	REFERRAL_NOTE_RECORD_ARTIFACT("721927009", "2.16.840.1.113883.6.96",
			"Referral note (record artifact)", "Referral note (record artifact)", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Report of clinical encounter (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	REPORT_OF_CLINICAL_ENCOUNTER_RECORD_ARTIFACT("371531000", "2.16.840.1.113883.6.96",
			"Report of clinical encounter (record artifact)",
			"Report of clinical encounter (record artifact)", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Summary clinical document (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	SUMMARY_CLINICAL_DOCUMENT_RECORD_ARTIFACT("422735006", "2.16.840.1.113883.6.96",
			"Summary clinical document (record artifact)",
			"Summary clinical document (record artifact)", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE");

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Administrative documentation (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ADMINISTRATIVE_DOCUMENTATION_RECORD_ARTIFACT_CODE = "405624007";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Advance directive report (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ADVANCE_DIRECTIVE_REPORT_RECORD_ARTIFACT_CODE = "371538006";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Audit trail report (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String AUDIT_TRAIL_REPORT_RECORD_ARTIFACT_CODE = "722160009";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Care Plan (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CARE_PLAN_RECORD_ARTIFACT_CODE = "734163000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Clinical procedure report (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CLINICAL_PROCEDURE_REPORT_RECORD_ARTIFACT_CODE = "371525003";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Consent report (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CONSENT_REPORT_RECORD_ARTIFACT_CODE = "371537001";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Emergency medical identification record (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EMERGENCY_MEDICAL_IDENTIFICATION_RECORD_RECORD_ARTIFACT_CODE = "722216001";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Obstetrical Record (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OBSTETRICAL_RECORD_RECORD_ARTIFACT_CODE = "2171000195109";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Order (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ORDER_RECORD_ARTIFACT_CODE = "721963009";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Organ donor card (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ORGAN_DONOR_CARD_RECORD_ARTIFACT_CODE = "772790007";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Patient record type (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PATIENT_RECORD_TYPE_RECORD_ARTIFACT_CODE = "184216000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Prescription record (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PRESCRIPTION_RECORD_RECORD_ARTIFACT_CODE = "440545006";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Record artifact (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RECORD_ARTIFACT_RECORD_ARTIFACT_CODE = "419891008";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Record of health event (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RECORD_OF_HEALTH_EVENT_RECORD_ARTIFACT_CODE = "417319006";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Referral note (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String REFERRAL_NOTE_RECORD_ARTIFACT_CODE = "721927009";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Report of clinical encounter (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String REPORT_OF_CLINICAL_ENCOUNTER_RECORD_ARTIFACT_CODE = "371531000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Summary clinical document (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SUMMARY_CLINICAL_DOCUMENT_RECORD_ARTIFACT_CODE = "422735006";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Identifier of the value set</div>
	 * <div class="de">Identifikator für das Value Set</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_ID = "2.16.756.5.30.1.127.3.10.1.30";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Name of the value set</div>
	 * <div class="de">Name des Value Sets</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_NAME = "DocumentEntry.classCode_DocumentEntry.typeCode_mapping";

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
	public static ClassTypeCodeMapping getEnum(String code) {
		for (final ClassTypeCodeMapping x : values()) {
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
			Enum.valueOf(ClassTypeCodeMapping.class, enumName);
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
		for (final ClassTypeCodeMapping x : values()) {
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
	ClassTypeCodeMapping(String code, String codeSystem, String displayName, String displayNameEn,
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
