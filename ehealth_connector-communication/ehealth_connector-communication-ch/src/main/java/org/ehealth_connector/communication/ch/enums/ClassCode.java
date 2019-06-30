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
package org.ehealth_connector.communication.ch.enums;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.enums.ValueSetEnumInterface;

/**
 * <!-- @formatter:off -->
 * <div class="en">Document class as per EPRO-FDHA Annex 3&lt;br clear="none"/&gt;</div>
 * <div class="de">Dokumentenklasse gemäss EPDV-EDI Anhang 3&lt;span style="text-decoration: none;"&gt;
 *     &lt;br clear="none"/&gt;
 * &lt;/span&gt;</div>
 * <div class="fr">Classification du document selon l'annexe 3 ODEP-DFI&lt;br clear="none"/&gt;</div>
 * <div class="it">Classe del documento secondo l'allegato 3 OCIP-DFI&lt;br clear="none"/&gt;</div>
 * <!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets")
public enum ClassCode implements ValueSetEnumInterface {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Administrative documentation</div>
	 * <div class="de">TODO</div>
	 * <div class="fr">TODO</div>
	 * <div class="it">TODO</div>
	 * <!-- @formatter:on -->
	 */
	ADMINISTRATIVE_DOCUMENTATION("405624007", "2.16.840.1.113883.6.96", "Administrative documentation (record artifact)", "Administrative documentation", "TODO", "TODO", "TODO"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Advance directive report</div>
	 * <div class="de">Patientenverfügung</div>
	 * <div class="fr">Directives anticipées du patient</div>
	 * <div class="it">Direttive anticipate del paziente</div>
	 * <!-- @formatter:on -->
	 */
	ADVANCE_DIRECTIVE_REPORT("371538006", "2.16.840.1.113883.6.96", "Advance directive report (record artifact)", "Advance directive report", "Patientenverfügung", "Directives anticipées du patient", "Direttive anticipate del paziente"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Audit trail</div>
	 * <div class="de">Audit trail</div>
	 * <div class="fr">Journal d'audit</div>
	 * <div class="it">Audit trail</div>
	 * <!-- @formatter:on -->
	 */
	AUDIT_TRAIL("722160009", "2.16.840.1.113883.6.96", "Audit trail report (record artifact)", "Audit trail", "Audit trail", "Journal d'audit", "Audit trail"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Care Plan</div>
	 * <div class="de">TODO</div>
	 * <div class="fr">TODO</div>
	 * <div class="it">TODO</div>
	 * <!-- @formatter:on -->
	 */
	CARE_PLAN("734163000", "2.16.840.1.113883.6.96", "Care Plan (record artifact)", "Care Plan", "TODO", "TODO", "TODO"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Clinical procedure report</div>
	 * <div class="de">Untersuchungsbefund</div>
	 * <div class="fr">Rapport d'examen</div>
	 * <div class="it">Risultato d'esame</div>
	 * <!-- @formatter:on -->
	 */
	CLINICAL_PROCEDURE_REPORT("371525003", "2.16.840.1.113883.6.96", "Clinical procedure report (record artifact)", "Clinical procedure report", "Untersuchungsbefund", "Rapport d'examen", "Risultato d'esame"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Drug prescription</div>
	 * <div class="de">Rezept</div>
	 * <div class="fr">Ordonnance</div>
	 * <div class="it">Ricetta medica</div>
	 * <!-- @formatter:on -->
	 */
	DRUG_PRESCRIPTION("440545006", "2.16.840.1.113883.6.96", "Prescription record (record artifact)", "Drug prescription", "Rezept", "Ordonnance", "Ricetta medica"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Emergency medical identification record</div>
	 * <div class="de">Notfallpass</div>
	 * <div class="fr">Passeport d'urgence</div>
	 * <div class="it">Passaporto d'emergenza</div>
	 * <!-- @formatter:on -->
	 */
	EMERGENCY_MEDICAL_IDENTIFICATION_RECORD("722216001", "2.16.840.1.113883.6.96", "Emergency medical identification record (record artifact)", "Emergency medical identification record", "Notfallpass", "Passeport d'urgence", "Passaporto d'emergenza"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Obstetrical Record</div>
	 * <div class="de">TODO</div>
	 * <div class="fr">TODO</div>
	 * <div class="it">TODO</div>
	 * <!-- @formatter:on -->
	 */
	OBSTETRICAL_RECORD("2171000195109", "2.16.756.5.30.1.127.3.4", "Obstetrical Record (record artifact)", "Obstetrical Record", "TODO", "TODO", "TODO"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Order</div>
	 * <div class="de">Auftrag</div>
	 * <div class="fr">Demande</div>
	 * <div class="it">Ordine</div>
	 * <!-- @formatter:on -->
	 */
	ORDER("721963009", "2.16.840.1.113883.6.96", "Order (record artifact)", "Order", "Auftrag", "Demande", "Ordine"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Organ donor card</div>
	 * <div class="de">Willensäusserung zur Organspende</div>
	 * <div class="fr">Volonté sur le don d'organes</div>
	 * <div class="it">Volontà di donare organi </div>
	 * <!-- @formatter:on -->
	 */
	ORGAN_DONOR_CARD("772790007", "2.16.840.1.113883.6.96", "Organ donor card (record artifact)", "Organ donor card", "Willensäusserung zur Organspende", "Volonté sur le don d'organes", "Volontà di donare organi "),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Patient consent</div>
	 * <div class="de">Patienteneinwilligung</div>
	 * <div class="fr">Consentement du patient</div>
	 * <div class="it">Consenso del paziente</div>
	 * <!-- @formatter:on -->
	 */
	PATIENT_CONSENT("371537001", "2.16.840.1.113883.6.96", "Consent report (record artifact)", "Patient consent", "Patienteneinwilligung", "Consentement du patient", "Consenso del paziente"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Patient record type</div>
	 * <div class="de">TODO</div>
	 * <div class="fr">TODO</div>
	 * <div class="it">TODO</div>
	 * <!-- @formatter:on -->
	 */
	PATIENT_RECORD_TYPE("184216000", "2.16.840.1.113883.6.96", "Patient record type (record artifact)", "Patient record type", "TODO", "TODO", "TODO"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Record artifact</div>
	 * <div class="de">TODO</div>
	 * <div class="fr">TODO</div>
	 * <div class="it">TODO</div>
	 * <!-- @formatter:on -->
	 */
	RECORD_ARTIFACT("419891008", "2.16.840.1.113883.6.96", "Record artifact (record artifact)", "Record artifact", "TODO", "TODO", "TODO"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Record of health event</div>
	 * <div class="de">TODO</div>
	 * <div class="fr">TODO</div>
	 * <div class="it">TODO</div>
	 * <!-- @formatter:on -->
	 */
	RECORD_OF_HEALTH_EVENT("417319006", "2.16.840.1.113883.6.96", "Record of health event (record artifact)", "Record of health event", "TODO", "TODO", "TODO"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Referral note</div>
	 * <div class="de">Konsilauftrag</div>
	 * <div class="fr">Demande de consultation</div>
	 * <div class="it">Richiesta di consulto</div>
	 * <!-- @formatter:on -->
	 */
	REFERRAL_NOTE("721927009", "2.16.840.1.113883.6.96", "Referral note (record artifact)", "Referral note", "Konsilauftrag", "Demande de consultation", "Richiesta di consulto"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Report of clinical encounter</div>
	 * <div class="de">TODO</div>
	 * <div class="fr">TODO</div>
	 * <div class="it">TODO</div>
	 * <!-- @formatter:on -->
	 */
	REPORT_OF_CLINICAL_ENCOUNTER("371531000", "2.16.840.1.113883.6.96", "Report of clinical encounter (record artifact)", "Report of clinical encounter", "TODO", "TODO", "TODO"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Summary clinical document</div>
	 * <div class="de">TODO</div>
	 * <div class="fr">TODO</div>
	 * <div class="it">TODO</div>
	 * <!-- @formatter:on -->
	 */
	SUMMARY_CLINICAL_DOCUMENT("422735006", "2.16.840.1.113883.6.96", "Summary clinical document (record artifact)", "Summary clinical document", "TODO", "TODO", "TODO");

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Administrative documentation</div>
	 * <div class="de">Code für TODO</div>
	 * <div class="fr">Code de TODO</div>
	 * <div class="it">Code per TODO</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ADMINISTRATIVE_DOCUMENTATION_CODE = "405624007";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Advance directive report</div>
	 * <div class="de">Code für Patientenverfügung</div>
	 * <div class="fr">Code de Directives anticipées du patient</div>
	 * <div class="it">Code per Direttive anticipate del paziente</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ADVANCE_DIRECTIVE_REPORT_CODE = "371538006";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Audit trail</div>
	 * <div class="de">Code für Audit trail</div>
	 * <div class="fr">Code de Journal d'audit</div>
	 * <div class="it">Code per Audit trail</div>
	 * <!-- @formatter:on -->
	 */
	public static final String AUDIT_TRAIL_CODE = "722160009";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Care Plan</div>
	 * <div class="de">Code für TODO</div>
	 * <div class="fr">Code de TODO</div>
	 * <div class="it">Code per TODO</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CARE_PLAN_CODE = "734163000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Clinical procedure report</div>
	 * <div class="de">Code für Untersuchungsbefund</div>
	 * <div class="fr">Code de Rapport d'examen</div>
	 * <div class="it">Code per Risultato d'esame</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CLINICAL_PROCEDURE_REPORT_CODE = "371525003";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Drug prescription</div>
	 * <div class="de">Code für Rezept</div>
	 * <div class="fr">Code de Ordonnance</div>
	 * <div class="it">Code per Ricetta medica</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DRUG_PRESCRIPTION_CODE = "440545006";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Emergency medical identification record</div>
	 * <div class="de">Code für Notfallpass</div>
	 * <div class="fr">Code de Passeport d'urgence</div>
	 * <div class="it">Code per Passaporto d'emergenza</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EMERGENCY_MEDICAL_IDENTIFICATION_RECORD_CODE = "722216001";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Obstetrical Record</div>
	 * <div class="de">Code für TODO</div>
	 * <div class="fr">Code de TODO</div>
	 * <div class="it">Code per TODO</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OBSTETRICAL_RECORD_CODE = "2171000195109";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Order</div>
	 * <div class="de">Code für Auftrag</div>
	 * <div class="fr">Code de Demande</div>
	 * <div class="it">Code per Ordine</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ORDER_CODE = "721963009";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Organ donor card</div>
	 * <div class="de">Code für Willensäusserung zur Organspende</div>
	 * <div class="fr">Code de Volonté sur le don d'organes</div>
	 * <div class="it">Code per Volontà di donare organi </div>
	 * <!-- @formatter:on -->
	 */
	public static final String ORGAN_DONOR_CARD_CODE = "772790007";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Patient consent</div>
	 * <div class="de">Code für Patienteneinwilligung</div>
	 * <div class="fr">Code de Consentement du patient</div>
	 * <div class="it">Code per Consenso del paziente</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PATIENT_CONSENT_CODE = "371537001";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Patient record type</div>
	 * <div class="de">Code für TODO</div>
	 * <div class="fr">Code de TODO</div>
	 * <div class="it">Code per TODO</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PATIENT_RECORD_TYPE_CODE = "184216000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Record artifact</div>
	 * <div class="de">Code für TODO</div>
	 * <div class="fr">Code de TODO</div>
	 * <div class="it">Code per TODO</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RECORD_ARTIFACT_CODE = "419891008";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Record of health event</div>
	 * <div class="de">Code für TODO</div>
	 * <div class="fr">Code de TODO</div>
	 * <div class="it">Code per TODO</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RECORD_OF_HEALTH_EVENT_CODE = "417319006";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Referral note</div>
	 * <div class="de">Code für Konsilauftrag</div>
	 * <div class="fr">Code de Demande de consultation</div>
	 * <div class="it">Code per Richiesta di consulto</div>
	 * <!-- @formatter:on -->
	 */
	public static final String REFERRAL_NOTE_CODE = "721927009";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Report of clinical encounter</div>
	 * <div class="de">Code für TODO</div>
	 * <div class="fr">Code de TODO</div>
	 * <div class="it">Code per TODO</div>
	 * <!-- @formatter:on -->
	 */
	public static final String REPORT_OF_CLINICAL_ENCOUNTER_CODE = "371531000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Summary clinical document</div>
	 * <div class="de">Code für TODO</div>
	 * <div class="fr">Code de TODO</div>
	 * <div class="it">Code per TODO</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SUMMARY_CLINICAL_DOCUMENT_CODE = "422735006";

	/**
	 * <div class="en">Identifier of the value set</div>
	 * <div class="de">Identifikator für das Value Set</div>
	 */
	public static final String VALUE_SET_ID = "2.16.756.5.30.1.127.3.10.1.3";

	/**
	 * <div class="en">Name of the value set</div>
	 * <div class="de">Name des Value Sets</div>
	 */
	public static final String VALUE_SET_NAME = "xds-clasCod";

	/**
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 *
	 * @param code
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static ClassCode getEnum(String code) {
		for (final ClassCode x : values()) {
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
	 *            <div class="de"> enumName</div>
	 * @return true, if enum is in this value set
	 */
	public static boolean isEnumOfValueSet(String enumName) {
		if (enumName == null) {
			return false;
		}
		try {
			Enum.valueOf(ClassCode.class, enumName);
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
	 *            <div class="de"> code</div>
	 * @return true, if is in value set
	 */
	public static boolean isInValueSet(String codeValue) {
		for (final ClassCode x : values()) {
			if (x.getCodeValue().equals(codeValue)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * <div class="en">Machine interpretable and (inside this class) unique
	 * code</div>
	 * <div class="de">Maschinen interpretierbarer und (innerhalb dieser Klasse)
	 * eindeutiger Code</div>
	 */
	private String code;

	/**
	 * <div class="en">Identifier of the referencing code system.</div>
	 * <div class="de">Identifikator des referenzierende Codesystems.</div>
	 */
	private String codeSystem;

	/**
	 * The display names per language
	 */
	private Map<LanguageCode, String> displayNames;

	/**
	 * <div class="en">Instantiates this Enum Object with a given Code and
	 * Display Name</div>
	 * <div class="de">Instanziiert dieses Enum Object mittels eines Codes
	 * und einem Display Name</div>.
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
	ClassCode(String code, String codeSystem, String displayName, String displayNameEn, String displayNameDe, String displayNameFr, String displayNameIt) {
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
	 * <div class="en">Gets the code system identifier.</div>
	 * <div class="de">Liefert den Code System Identifikator.</div>
	 *
	 * @return <div class="en">the code system identifier</div>
	 */
	@Override
	public String getCodeSystemId() {
		return this.codeSystem;
	}

	/**
	 * <div class="en">Gets the code system name.</div> <div class="de">Liefert
	 * den Code System Namen.</div>
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
	 * <div class="en">Gets the actual Code as string</div>
	 * <div class="de">Liefert den eigentlichen Code als String</div>
	 *
	 * @return <div class="en">the code</div>
	 */
	@Override
	public String getCodeValue() {
		return this.code;
	}

	/**
	 * <div class="en">Gets the display name defined by the language param. If
	 * there is no english translation, the default display name is returned.</div>
	 * <div class="de">Liefert display name gemäss Parameter, falls es keine
	 * Englische Übersetzung gibt, wird der default-Name zurückgegeben.</div>
	 *
	 * @param languageCode
	 *            the language code to get the display name for
	 * @return returns the display name in the desired language. if language not
	 *         found, display name in german will returned
	 */
	public String getDisplayName(LanguageCode languageCode) {
		String displayName = displayNames.get(languageCode);
		if (displayName == null && languageCode == LanguageCode.ENGLISH) {
			return displayNames.get(null);
		}
		return displayName;
	}

	/**
	 * <div class="en">Gets the value set identifier.</div> <div class="de">Liefert
	 * den Value Set Identifikator.</div>
	 *
	 * @return <div class="en">the value set identifier</div>
	 */
	@Override
	public String getValueSetId() {
		return VALUE_SET_ID;
	}

	/**
	 * <div class="en">Gets the value set name.</div> <div class="de">Liefert
	 * den Value Set Namen.</div>
	 *
	 * @return <div class="en">the value set name</div>
	 */
	@Override
	public String getValueSetName() {
		return VALUE_SET_NAME;
	}
}
