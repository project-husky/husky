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

import javax.annotation.processing.Generated;

import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.mdht.enums.ValueSetEnumInterface;

/**
 * <!-- @formatter:off -->
 * Enumeration of DocumentEntry.classCode values
 *
 * <div class="en">Document class as per EPRO-FDHA Annex 3</div>
 * <div class="de">Dokumentenklasse gemäss EPDV-EDI Anhang 3</div>
 * <div class="fr">Classification du document selon l'annexe 3 ODEP-DFI</div>
 * <div class="it">Classe del documento secondo l'allegato 3 OCIP-DFI</div>
 *
 * Identifier: 2.16.756.5.30.1.127.3.10.1.3
 * Effective date: 2021-04-01 16:32
 * Version: 202104.0-stable
 * Status: FINAL
 * <!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets", date = "2021-04-22")
public enum ClassCode implements ValueSetEnumInterface {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Administrative documentation</div>
	 * <div class="de">Administratives Dokument</div>
	 * <div class="fr">Document administratif</div>
	 * <div class="it">Documento amministrativo</div>
	 * <!-- @formatter:on -->
	 */
	ADMINISTRATIVE_DOCUMENTATION("405624007", "2.16.840.1.113883.6.96",
			"Administrative documentation (record artifact)", "Administrative documentation",
			"Administratives Dokument", "Document administratif", "Documento amministrativo"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Advance directive report</div>
	 * <div class="de">Patientenverfügung</div>
	 * <div class="fr">Directives anticipées</div>
	 * <div class="it">Direttive del paziente</div>
	 * <!-- @formatter:on -->
	 */
	ADVANCE_DIRECTIVE_REPORT("371538006", "2.16.840.1.113883.6.96",
			"Advance directive report (record artifact)", "Advance directive report",
			"Patientenverfügung", "Directives anticipées", "Direttive del paziente"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Audit trail report</div>
	 * <div class="de">Rückverfolgung der EPD Zugriffe</div>
	 * <div class="fr">Traçabilité des accès aux DEP</div>
	 * <div class="it">Cronologia degli accessi alla CIP</div>
	 * <!-- @formatter:on -->
	 */
	AUDIT_TRAIL_REPORT("722160009", "2.16.840.1.113883.6.96",
			"Audit trail report (record artifact)", "Audit trail report",
			"Rückverfolgung der EPD Zugriffe", "Traçabilité des accès aux DEP",
			"Cronologia degli accessi alla CIP"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Care Plan</div>
	 * <div class="de">Behandlungsplan</div>
	 * <div class="fr">Plan de traitement</div>
	 * <div class="it">Piano di trattamento</div>
	 * <!-- @formatter:on -->
	 */
	CARE_PLAN("734163000", "2.16.840.1.113883.6.96", "Care Plan (record artifact)", "Care Plan",
			"Behandlungsplan", "Plan de traitement", "Piano di trattamento"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Clinical procedure report</div>
	 * <div class="de">Interventionsbericht / Untersuchungsresultat</div>
	 * <div class="fr">Rapport d’intervention / résultat de l’analyse</div>
	 * <div class="it">Rapporto operatorio / Referto di analisi</div>
	 * <!-- @formatter:on -->
	 */
	CLINICAL_PROCEDURE_REPORT("371525003", "2.16.840.1.113883.6.96",
			"Clinical procedure report (record artifact)", "Clinical procedure report",
			"Interventionsbericht / Untersuchungsresultat",
			"Rapport d’intervention / résultat de l’analyse",
			"Rapporto operatorio / Referto di analisi"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Consent report</div>
	 * <div class="de">Einwilligung zur Behandlung</div>
	 * <div class="fr">Consentement au traitement</div>
	 * <div class="it">Consenso al trattamento</div>
	 * <!-- @formatter:on -->
	 */
	CONSENT_REPORT("371537001", "2.16.840.1.113883.6.96", "Consent report (record artifact)",
			"Consent report", "Einwilligung zur Behandlung", "Consentement au traitement",
			"Consenso al trattamento"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Emergency medical identification record</div>
	 * <div class="de">Notfall-ID / Ausweis</div>
	 * <div class="fr">ID d’urgence / carte d’urgence</div>
	 * <div class="it">Identificativo d'emergenza / scheda d'emergenza</div>
	 * <!-- @formatter:on -->
	 */
	EMERGENCY_MEDICAL_IDENTIFICATION_RECORD("722216001", "2.16.840.1.113883.6.96",
			"Emergency medical identification record (record artifact)",
			"Emergency medical identification record", "Notfall-ID / Ausweis",
			"ID d’urgence / carte d’urgence",
			"Identificativo d'emergenza / scheda d'emergenza"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Obstetrical Record</div>
	 * <div class="de">Schwangerschafts-/ Geburtsbericht</div>
	 * <div class="fr">Rapport de grossesse / de naissance</div>
	 * <div class="it">Referto della gravidanza / del parto</div>
	 * <!-- @formatter:on -->
	 */
	OBSTETRICAL_RECORD("2171000195109", "2.16.756.5.30.1.127.3.4",
			"Obstetrical Record (record artifact)", "Obstetrical Record",
			"Schwangerschafts-/ Geburtsbericht", "Rapport de grossesse / de naissance",
			"Referto della gravidanza / del parto"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Order</div>
	 * <div class="de">Untersuchungsauftrag</div>
	 * <div class="fr">Mandat d’analyse</div>
	 * <div class="it">Prescrizione di analisi</div>
	 * <!-- @formatter:on -->
	 */
	ORDER("721963009", "2.16.840.1.113883.6.96", "Order (record artifact)", "Order",
			"Untersuchungsauftrag", "Mandat d’analyse", "Prescrizione di analisi"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Organ donor card</div>
	 * <div class="de">Organspendeausweis</div>
	 * <div class="fr">Carte de donneur d’organes</div>
	 * <div class="it">Tessera di donatore di organi</div>
	 * <!-- @formatter:on -->
	 */
	ORGAN_DONOR_CARD("772790007", "2.16.840.1.113883.6.96", "Organ donor card (record artifact)",
			"Organ donor card", "Organspendeausweis", "Carte de donneur d’organes",
			"Tessera di donatore di organi"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Patient record type</div>
	 * <div class="de">Langzeitdokumentation</div>
	 * <div class="fr">Documentation à long terme</div>
	 * <div class="it">Documentazione a lungo termine</div>
	 * <!-- @formatter:on -->
	 */
	PATIENT_RECORD_TYPE("184216000", "2.16.840.1.113883.6.96",
			"Patient record type (record artifact)", "Patient record type", "Langzeitdokumentation",
			"Documentation à long terme", "Documentazione a lungo termine"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Prescription record</div>
	 * <div class="de">Verschreibung / Rezept</div>
	 * <div class="fr">Prescription / ordonnance</div>
	 * <div class="it">Prescrizione medica</div>
	 * <!-- @formatter:on -->
	 */
	PRESCRIPTION_RECORD("440545006", "2.16.840.1.113883.6.96",
			"Prescription record (record artifact)", "Prescription record",
			"Verschreibung / Rezept", "Prescription / ordonnance", "Prescrizione medica"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Record artifact</div>
	 * <div class="de">Nicht näher bezeichnetes Dokument</div>
	 * <div class="fr">Document non précisé</div>
	 * <div class="it">Documento non meglio specificato</div>
	 * <!-- @formatter:on -->
	 */
	RECORD_ARTIFACT("419891008", "2.16.840.1.113883.6.96", "Record artifact (record artifact)",
			"Record artifact", "Nicht näher bezeichnetes Dokument", "Document non précisé",
			"Documento non meglio specificato"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Record of health event</div>
	 * <div class="de">Dokument zu gesundheitsrelevantem Ereignis</div>
	 * <div class="fr">Document sur l’événement sanitaire</div>
	 * <div class="it">Documento concernente un evento rilevante per la salute</div>
	 * <!-- @formatter:on -->
	 */
	RECORD_OF_HEALTH_EVENT("417319006", "2.16.840.1.113883.6.96",
			"Record of health event (record artifact)", "Record of health event",
			"Dokument zu gesundheitsrelevantem Ereignis", "Document sur l’événement sanitaire",
			"Documento concernente un evento rilevante per la salute"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Referral note</div>
	 * <div class="de">Zuweisungsschreiben</div>
	 * <div class="fr">Lettre de référence</div>
	 * <div class="it">Lettera d'invio</div>
	 * <!-- @formatter:on -->
	 */
	REFERRAL_NOTE("721927009", "2.16.840.1.113883.6.96", "Referral note (record artifact)",
			"Referral note", "Zuweisungsschreiben", "Lettre de référence", "Lettera d'invio"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Report of clinical encounter</div>
	 * <div class="de">Bericht aufgrund einer Konsultation</div>
	 * <div class="fr">Rapport suite à une consultation</div>
	 * <div class="it">Rapporto di visita medica</div>
	 * <!-- @formatter:on -->
	 */
	REPORT_OF_CLINICAL_ENCOUNTER("371531000", "2.16.840.1.113883.6.96",
			"Report of clinical encounter (record artifact)", "Report of clinical encounter",
			"Bericht aufgrund einer Konsultation", "Rapport suite à une consultation",
			"Rapporto di visita medica"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Summary clinical document</div>
	 * <div class="de">Zusammenfassender Bericht</div>
	 * <div class="fr">Rapport de synthèse</div>
	 * <div class="it">Rapporto riassuntivo</div>
	 * <!-- @formatter:on -->
	 */
	SUMMARY_CLINICAL_DOCUMENT("422735006", "2.16.840.1.113883.6.96",
			"Summary clinical document (record artifact)", "Summary clinical document",
			"Zusammenfassender Bericht", "Rapport de synthèse", "Rapporto riassuntivo");

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Administrative documentation</div>
	 * <div class="de">Code für Administratives Dokument</div>
	 * <div class="fr">Code de Document administratif</div>
	 * <div class="it">Code per Documento amministrativo</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ADMINISTRATIVE_DOCUMENTATION_CODE = "405624007";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Advance directive report</div>
	 * <div class="de">Code für Patientenverfügung</div>
	 * <div class="fr">Code de Directives anticipées</div>
	 * <div class="it">Code per Direttive del paziente</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ADVANCE_DIRECTIVE_REPORT_CODE = "371538006";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Audit trail report</div>
	 * <div class="de">Code für Rückverfolgung der EPD Zugriffe</div>
	 * <div class="fr">Code de Traçabilité des accès aux DEP</div>
	 * <div class="it">Code per Cronologia degli accessi alla CIP</div>
	 * <!-- @formatter:on -->
	 */
	public static final String AUDIT_TRAIL_REPORT_CODE = "722160009";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Care Plan</div>
	 * <div class="de">Code für Behandlungsplan</div>
	 * <div class="fr">Code de Plan de traitement</div>
	 * <div class="it">Code per Piano di trattamento</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CARE_PLAN_CODE = "734163000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Clinical procedure report</div>
	 * <div class="de">Code für Interventionsbericht / Untersuchungsresultat</div>
	 * <div class="fr">Code de Rapport d’intervention / résultat de l’analyse</div>
	 * <div class="it">Code per Rapporto operatorio / Referto di analisi</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CLINICAL_PROCEDURE_REPORT_CODE = "371525003";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Consent report</div>
	 * <div class="de">Code für Einwilligung zur Behandlung</div>
	 * <div class="fr">Code de Consentement au traitement</div>
	 * <div class="it">Code per Consenso al trattamento</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CONSENT_REPORT_CODE = "371537001";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Emergency medical identification record</div>
	 * <div class="de">Code für Notfall-ID / Ausweis</div>
	 * <div class="fr">Code de ID d’urgence / carte d’urgence</div>
	 * <div class="it">Code per Identificativo d'emergenza / scheda d'emergenza</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EMERGENCY_MEDICAL_IDENTIFICATION_RECORD_CODE = "722216001";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Obstetrical Record</div>
	 * <div class="de">Code für Schwangerschafts-/ Geburtsbericht</div>
	 * <div class="fr">Code de Rapport de grossesse / de naissance</div>
	 * <div class="it">Code per Referto della gravidanza / del parto</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OBSTETRICAL_RECORD_CODE = "2171000195109";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Order</div>
	 * <div class="de">Code für Untersuchungsauftrag</div>
	 * <div class="fr">Code de Mandat d’analyse</div>
	 * <div class="it">Code per Prescrizione di analisi</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ORDER_CODE = "721963009";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Organ donor card</div>
	 * <div class="de">Code für Organspendeausweis</div>
	 * <div class="fr">Code de Carte de donneur d’organes</div>
	 * <div class="it">Code per Tessera di donatore di organi</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ORGAN_DONOR_CARD_CODE = "772790007";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Patient record type</div>
	 * <div class="de">Code für Langzeitdokumentation</div>
	 * <div class="fr">Code de Documentation à long terme</div>
	 * <div class="it">Code per Documentazione a lungo termine</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PATIENT_RECORD_TYPE_CODE = "184216000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Prescription record</div>
	 * <div class="de">Code für Verschreibung / Rezept</div>
	 * <div class="fr">Code de Prescription / ordonnance</div>
	 * <div class="it">Code per Prescrizione medica</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PRESCRIPTION_RECORD_CODE = "440545006";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Record artifact</div>
	 * <div class="de">Code für Nicht näher bezeichnetes Dokument</div>
	 * <div class="fr">Code de Document non précisé</div>
	 * <div class="it">Code per Documento non meglio specificato</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RECORD_ARTIFACT_CODE = "419891008";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Record of health event</div>
	 * <div class="de">Code für Dokument zu gesundheitsrelevantem Ereignis</div>
	 * <div class="fr">Code de Document sur l’événement sanitaire</div>
	 * <div class="it">Code per Documento concernente un evento rilevante per la salute</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RECORD_OF_HEALTH_EVENT_CODE = "417319006";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Referral note</div>
	 * <div class="de">Code für Zuweisungsschreiben</div>
	 * <div class="fr">Code de Lettre de référence</div>
	 * <div class="it">Code per Lettera d'invio</div>
	 * <!-- @formatter:on -->
	 */
	public static final String REFERRAL_NOTE_CODE = "721927009";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Report of clinical encounter</div>
	 * <div class="de">Code für Bericht aufgrund einer Konsultation</div>
	 * <div class="fr">Code de Rapport suite à une consultation</div>
	 * <div class="it">Code per Rapporto di visita medica</div>
	 * <!-- @formatter:on -->
	 */
	public static final String REPORT_OF_CLINICAL_ENCOUNTER_CODE = "371531000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Summary clinical document</div>
	 * <div class="de">Code für Zusammenfassender Bericht</div>
	 * <div class="fr">Code de Rapport de synthèse</div>
	 * <div class="it">Code per Rapporto riassuntivo</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SUMMARY_CLINICAL_DOCUMENT_CODE = "422735006";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Identifier of the value set</div>
	 * <div class="de">Identifikator für das Value Set</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_ID = "2.16.756.5.30.1.127.3.10.1.3";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Name of the value set</div>
	 * <div class="de">Name des Value Sets</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_NAME = "DocumentEntry.classCode";

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
	public static ClassCode getEnum(final String code) {
		for (final ClassCode x : values()) {
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
	public static boolean isEnumOfValueSet(final String enumName) {
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
	 * <!-- @formatter:off -->
	 * <div class="en">Checks if a given code value is in this value set.</div>
	 * <div class="de">Prüft, ob der angegebene code in diesem Value Set vorhanden ist.</div>
	 * <!-- @formatter:on -->
	 *
	 * @param codeValue
	 *            <div class="de"> code</div>
	 * @return true, if is in value set
	 */
	public static boolean isInValueSet(final String codeValue) {
		for (final ClassCode x : values()) {
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
	ClassCode(final String code, final String codeSystem, final String displayName,
			final String displayNameEn, final String displayNameDe, final String displayNameFr,
			final String displayNameIt) {
		this.code = code;
		this.codeSystem = codeSystem;
		this.displayNames = new HashMap<>();
		this.displayNames.put(null, displayName);
		this.displayNames.put(LanguageCode.ENGLISH, displayNameEn);
		this.displayNames.put(LanguageCode.GERMAN, displayNameDe);
		this.displayNames.put(LanguageCode.FRENCH, displayNameFr);
		this.displayNames.put(LanguageCode.ITALIAN, displayNameIt);
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
		String displayName = this.displayNames.get(languageCode);
		if (displayName == null && languageCode == LanguageCode.ENGLISH) {
			return this.displayNames.get(null);
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
