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
import org.ehealth_connector.common.ch.enums.ValueSetEnumInterface;

/**
 *<!-- @formatter:off -->
 * <div class="en">Document class as per EPRO-FDHA Annex 3, Chapter 2.3. &lt;br clear="none"/&gt;
 *    </div>
 * <div class="de">Dokumentenklasse gemäss EPDV-EDI Anhang 3, Kapitel 2.3. &lt;span style="text-decoration: none;"&gt;
 *      &lt;br clear="none"/&gt;
 *      &lt;/span&gt;
 *    </div>
 * <div class="fr">Classification du document selon l'annexe 3 ODEP-DFI, chapitre 2.3&lt;br clear="none"/&gt;
 *    </div>
 * <div class="it">Classe del documento secondo l'allegato 3 OCIP-DFI, capitolo 2.3.&lt;br clear="none"/&gt;
 *    </div>
 *<!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets")
public enum ClassCode implements ValueSetEnumInterface {

	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Alerts</div>
	 * <div class="de">Warnungen/Risiken</div>
	 * <div class="fr">Alertes</div>
	 * <div class="it">Avvertenze</div>
	 *<!-- @formatter:on -->
	 */
	ALERTS("1331000195101", "2.16.840.1.113883.6.96", "Alert (record artifact)", "Alerts", "Warnungen/Risiken", "Alertes", "Avvertenze"),
	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Care Plans</div>
	 * <div class="de">Behandlungspläne/Behandlungsschemata</div>
	 * <div class="fr">Plans de soins</div>
	 * <div class="it">Piani di cura</div>
	 *<!-- @formatter:on -->
	 */
	CARE_PLANS("1321000195103", "2.16.840.1.113883.6.96", "Care Plan (record artifact)", "Care Plans", "Behandlungspläne/Behandlungsschemata", "Plans de soins", "Piani di cura"),
	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Certificate</div>
	 * <div class="de">Zeugnis</div>
	 * <div class="fr">Certificat</div>
	 * <div class="it">Certificato</div>
	 *<!-- @formatter:on -->
	 */
	CERTIFICATE("308707006", "2.16.840.1.113883.6.96", "Certificate (record artifact)", "Certificate", "Zeugnis", "Certificat", "Certificato"),
	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Clinical Care Referrals</div>
	 * <div class="de">Zuweisungen/Überweisungen</div>
	 * <div class="fr">Demandes de prise en charge</div>
	 * <div class="it">Richieste di presa a carico</div>
	 *<!-- @formatter:on -->
	 */
	CLINICAL_CARE_REFERRALS("1261000195102", "2.16.840.1.113883.6.96", "Clinical Care Referral (record artifact)", "Clinical Care Referrals", "Zuweisungen/Überweisungen", "Demandes de prise en charge", "Richieste di presa a carico"),
	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Data from Patient</div>
	 * <div class="de">Eigene Daten des Patienten</div>
	 * <div class="fr">Documents introduits par le patient</div>
	 * <div class="it">Documenti inseriti dal paziente</div>
	 *<!-- @formatter:on -->
	 */
	DATA_FROM_PATIENT("1351000195107", "2.16.840.1.113883.6.96", "Data from Patient (record artifact)", "Data from Patient", "Eigene Daten des Patienten", "Documents introduits par le patient", "Documenti inseriti dal paziente"),
	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Diagnostic Test Results</div>
	 * <div class="de">Diagnostische Untersuchungsbefunde</div>
	 * <div class="fr">Résultats d'examen diagnostic</div>
	 * <div class="it">Risultati di esame diagnostico</div>
	 *<!-- @formatter:on -->
	 */
	DIAGNOSTIC_TEST_RESULTS("1291000195107", "2.16.840.1.113883.6.96", "Diagnostic Test Result (record artifact)", "Diagnostic Test Results", "Diagnostische Untersuchungsbefunde", "Résultats d'examen diagnostic", "Risultati di esame diagnostico"),
	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Episode Summary Reports</div>
	 * <div class="de">Zusammenfassende Berichte</div>
	 * <div class="fr">Résumés d'épisode</div>
	 * <div class="it">Riassunti di episodio</div>
	 *<!-- @formatter:on -->
	 */
	EPISODE_SUMMARY_REPORTS("1271000195108", "2.16.840.1.113883.6.96", "Episode Summary Report (record artifact)", "Episode Summary Reports", "Zusammenfassende Berichte", "Résumés d'épisode", "Riassunti di episodio"),
	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Historic Overviews</div>
	 * <div class="de">Medizinische Vorgeschichte</div>
	 * <div class="fr">Résumés d'antécédents</div>
	 * <div class="it">Riassunti della storia clinica</div>
	 *<!-- @formatter:on -->
	 */
	HISTORIC_OVERVIEWS("1281000195105", "2.16.840.1.113883.6.96", "Historic Overview (record artifact)", "Historic Overviews", "Medizinische Vorgeschichte", "Résumés d'antécédents", "Riassunti della storia clinica"),
	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Notes on Consultations</div>
	 * <div class="de">Konsultationseinträge/-notizen</div>
	 * <div class="fr">Notes de consultation</div>
	 * <div class="it">Rapporti e note di consultazione</div>
	 *<!-- @formatter:on -->
	 */
	NOTES_ON_CONSULTATIONS("1211000195104", "2.16.840.1.113883.6.96", "Note on Consultation (record artifact)", "Notes on Consultations", "Konsultationseinträge/-notizen", "Notes de consultation", "Rapporti e note di consultazione"),
	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Notes on Procedures</div>
	 * <div class="de">Interventionseinträge/-notizen</div>
	 * <div class="fr">Notes d'intervention</div>
	 * <div class="it">Rapporti e note d'intervento</div>
	 *<!-- @formatter:on -->
	 */
	NOTES_ON_PROCEDURES("1241000195103", "2.16.840.1.113883.6.96", "Note on Procedure (record artifact)", "Notes on Procedures", "Interventionseinträge/-notizen", "Notes d'intervention", "Rapporti e note d'intervento"),
	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Notifications</div>
	 * <div class="de">Meldungen</div>
	 * <div class="fr">Notifications / déclarations</div>
	 * <div class="it">Notifiche / dichiarazioni</div>
	 *<!-- @formatter:on -->
	 */
	NOTIFICATIONS("1301000195106", "2.16.840.1.113883.6.96", "Notification (record artifact)", "Notifications", "Meldungen", "Notifications / déclarations", "Notifiche / dichiarazioni"),
	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Other Composition</div>
	 * <div class="de">Anderweitige Dokumente</div>
	 * <div class="fr">Autre</div>
	 * <div class="it">Altro</div>
	 *<!-- @formatter:on -->
	 */
	OTHER_COMPOSITION("419891008", "2.16.840.1.113883.6.96", "Other Composition", "Other Composition", "Anderweitige Dokumente", "Autre", "Altro"),
	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Present State Summaries</div>
	 * <div class="de">Aktueller Zustand</div>
	 * <div class="fr">Résumés de l'état actuel</div>
	 * <div class="it">Riassunti dello stato attuale</div>
	 *<!-- @formatter:on -->
	 */
	PRESENT_STATE_SUMMARIES("1311000195108", "2.16.840.1.113883.6.96", "Present State Summary (record artifact)", "Present State Summaries", "Aktueller Zustand", "Résumés de l'état actuel", "Riassunti dello stato attuale"),
	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Progress Notes</div>
	 * <div class="de">Verlaufseinträge/-notizen</div>
	 * <div class="fr">Notes de suivi</div>
	 * <div class="it">Diario clinico</div>
	 *<!-- @formatter:on -->
	 */
	PROGRESS_NOTES("1231000195106", "2.16.840.1.113883.6.96", "Progress Note (record artifact)", "Progress Notes", "Verlaufseinträge/-notizen", "Notes de suivi", "Diario clinico"),
	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Progress Reports</div>
	 * <div class="de">Verlaufsberichte</div>
	 * <div class="fr">Rapports d'évolution</div>
	 * <div class="it">Rapporti di evoluzione</div>
	 *<!-- @formatter:on -->
	 */
	PROGRESS_REPORTS("371532007", "2.16.840.1.113883.6.96", "Progress report (qualifier value)", "Progress Reports", "Verlaufsberichte", "Rapports d'évolution", "Rapporti di evoluzione"),
	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Tests/Procedure Requests</div>
	 * <div class="de">Untersuchungs-/Prozeduranforderungen</div>
	 * <div class="fr">Demandes d'examen / procédure</div>
	 * <div class="it">Richieste d'esame</div>
	 *<!-- @formatter:on -->
	 */
	TESTS_PROCEDURE_REQUESTS("1251000195100", "2.16.840.1.113883.6.96", "Test or Procedure Request (record artifact)", "Tests/Procedure Requests", "Untersuchungs-/Prozeduranforderungen", "Demandes d'examen / procédure", "Richieste d'esame");

	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Code for Alerts</div>
	 * <div class="de">Code für Warnungen/Risiken</div>
	 * <div class="fr">Code de Alertes</div>
	 * <div class="it">Code per Avvertenze</div>
	 *<!-- @formatter:on -->
	 */
	public static final String ALERTS_CODE = "1331000195101";

	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Code for Care Plans</div>
	 * <div class="de">Code für Behandlungspläne/Behandlungsschemata</div>
	 * <div class="fr">Code de Plans de soins</div>
	 * <div class="it">Code per Piani di cura</div>
	 *<!-- @formatter:on -->
	 */
	public static final String CARE_PLANS_CODE = "1321000195103";

	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Code for Certificate</div>
	 * <div class="de">Code für Zeugnis</div>
	 * <div class="fr">Code de Certificat</div>
	 * <div class="it">Code per Certificato</div>
	 *<!-- @formatter:on -->
	 */
	public static final String CERTIFICATE_CODE = "308707006";

	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Code for Clinical Care Referrals</div>
	 * <div class="de">Code für Zuweisungen/Überweisungen</div>
	 * <div class="fr">Code de Demandes de prise en charge</div>
	 * <div class="it">Code per Richieste di presa a carico</div>
	 *<!-- @formatter:on -->
	 */
	public static final String CLINICAL_CARE_REFERRALS_CODE = "1261000195102";

	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Code for Data from Patient</div>
	 * <div class="de">Code für Eigene Daten des Patienten</div>
	 * <div class="fr">Code de Documents introduits par le patient</div>
	 * <div class="it">Code per Documenti inseriti dal paziente</div>
	 *<!-- @formatter:on -->
	 */
	public static final String DATA_FROM_PATIENT_CODE = "1351000195107";

	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Code for Diagnostic Test Results</div>
	 * <div class="de">Code für Diagnostische Untersuchungsbefunde</div>
	 * <div class="fr">Code de Résultats d'examen diagnostic</div>
	 * <div class="it">Code per Risultati di esame diagnostico</div>
	 *<!-- @formatter:on -->
	 */
	public static final String DIAGNOSTIC_TEST_RESULTS_CODE = "1291000195107";

	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Code for Episode Summary Reports</div>
	 * <div class="de">Code für Zusammenfassende Berichte</div>
	 * <div class="fr">Code de Résumés d'épisode</div>
	 * <div class="it">Code per Riassunti di episodio</div>
	 *<!-- @formatter:on -->
	 */
	public static final String EPISODE_SUMMARY_REPORTS_CODE = "1271000195108";

	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Code for Historic Overviews</div>
	 * <div class="de">Code für Medizinische Vorgeschichte</div>
	 * <div class="fr">Code de Résumés d'antécédents</div>
	 * <div class="it">Code per Riassunti della storia clinica</div>
	 *<!-- @formatter:on -->
	 */
	public static final String HISTORIC_OVERVIEWS_CODE = "1281000195105";

	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Code for Notes on Consultations</div>
	 * <div class="de">Code für Konsultationseinträge/-notizen</div>
	 * <div class="fr">Code de Notes de consultation</div>
	 * <div class="it">Code per Rapporti e note di consultazione</div>
	 *<!-- @formatter:on -->
	 */
	public static final String NOTES_ON_CONSULTATIONS_CODE = "1211000195104";

	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Code for Notes on Procedures</div>
	 * <div class="de">Code für Interventionseinträge/-notizen</div>
	 * <div class="fr">Code de Notes d'intervention</div>
	 * <div class="it">Code per Rapporti e note d'intervento</div>
	 *<!-- @formatter:on -->
	 */
	public static final String NOTES_ON_PROCEDURES_CODE = "1241000195103";

	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Code for Notifications</div>
	 * <div class="de">Code für Meldungen</div>
	 * <div class="fr">Code de Notifications / déclarations</div>
	 * <div class="it">Code per Notifiche / dichiarazioni</div>
	 *<!-- @formatter:on -->
	 */
	public static final String NOTIFICATIONS_CODE = "1301000195106";

	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Code for Other Composition</div>
	 * <div class="de">Code für Anderweitige Dokumente</div>
	 * <div class="fr">Code de Autre</div>
	 * <div class="it">Code per Altro</div>
	 *<!-- @formatter:on -->
	 */
	public static final String OTHER_COMPOSITION_CODE = "419891008";

	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Code for Present State Summaries</div>
	 * <div class="de">Code für Aktueller Zustand</div>
	 * <div class="fr">Code de Résumés de l'état actuel</div>
	 * <div class="it">Code per Riassunti dello stato attuale</div>
	 *<!-- @formatter:on -->
	 */
	public static final String PRESENT_STATE_SUMMARIES_CODE = "1311000195108";

	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Code for Progress Notes</div>
	 * <div class="de">Code für Verlaufseinträge/-notizen</div>
	 * <div class="fr">Code de Notes de suivi</div>
	 * <div class="it">Code per Diario clinico</div>
	 *<!-- @formatter:on -->
	 */
	public static final String PROGRESS_NOTES_CODE = "1231000195106";

	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Code for Progress Reports</div>
	 * <div class="de">Code für Verlaufsberichte</div>
	 * <div class="fr">Code de Rapports d'évolution</div>
	 * <div class="it">Code per Rapporti di evoluzione</div>
	 *<!-- @formatter:on -->
	 */
	public static final String PROGRESS_REPORTS_CODE = "371532007";

	/**
	 *<!-- @formatter:off -->
	 * <div class="en">Code for Tests/Procedure Requests</div>
	 * <div class="de">Code für Untersuchungs-/Prozeduranforderungen</div>
	 * <div class="fr">Code de Demandes d'examen / procédure</div>
	 * <div class="it">Code per Richieste d'esame</div>
	 *<!-- @formatter:on -->
	 */
	public static final String TESTS_PROCEDURE_REQUESTS_CODE = "1251000195100";

	/**
	 * <div class="en">Identifier of the value set</div>
	 * <div class="de">Identifikator fÃ¼r das Value Set</div>
	 */
	public static final String VALUE_SET_ID = "2.16.756.5.30.1.127.3.10.1.3";

	/**
	 * <div class="en">Name of the value set</div>
	 * <div class="de">Name des Value Sets</div>
	 */
	public static final String VALUE_SET_NAME = "EprDocumentClassCode";

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
