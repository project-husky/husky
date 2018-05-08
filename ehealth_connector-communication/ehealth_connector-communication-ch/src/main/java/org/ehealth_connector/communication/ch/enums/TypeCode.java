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

import org.ehealth_connector.common.ch.enums.ValueSetEnumInterface;
import org.ehealth_connector.common.enums.LanguageCode;

/**
 * <div class="en">Type of document as per Annex 3&amp;#160; EPRO-FDHA, Chapter
 * 2.11. &lt;br clear="none"/&gt; &lt;br clear="none"/&gt;The code defines a
 * document’s type (e.g. discharge report, laboratory report). Each document
 * type should be assigned to precisely one document class.&lt;br
 * clear="none"/&gt; </div> <div class="de">Typ des Dokumentes
 * (2.16.756.5.30.1.127.3.10.1.27) gemäss Anhang 3 der Verordnungen zum
 * EPDG.&lt;br clear="none"/&gt; &lt;br clear="none"/&gt;Der Code definiert den
 * Typ eines Dokuments (z.B.&amp;#160; Austrittsbericht, Labor-Bericht). Jeder
 * Dokumenten-Typ sollte genau einer Dokumentenklasse zugeordnet sein.&lt;br
 * clear="none"/&gt; </div> <div class="fr">Type du document selon l'annexe 3
 * ODEP-DFI, chapitre 2.11. &lt;br clear="none"/&gt; &lt;br clear="none"/&gt;Le
 * code définit le type de document (p. ex. rapport de sortie, rapport de
 * laboratoire). Chaque type de document doit être&amp;#160; associé à une seule
 * classification.&lt;br clear="none"/&gt; </div> <div class="it">Tipo di
 * documento secondo l'allegato 3 OCIP-DFI, capitolo 2.11. &lt;br
 * clear="none"/&gt; &lt;br clear="none"/&gt;Il codice definisce il tipo di
 * documento (p. es. rapporto di dimissione, rapporto di laboratorio). Ciascun
 * tipo di documento dovrebbe essere associato a una sola classe di
 * documenti.&lt;br clear="none"/&gt; </div>
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets")
public enum TypeCode implements ValueSetEnumInterface {

	/**
	 * <div class="en">Patient Consent</div>
	 * <div class="de">Patienteneinwilligung</div> <div class="fr">Consentement
	 * du patient</div> <div class="it">Consenso del paziente</div>
	 */
	PATIENT_CONSENT("371537001", "2.16.840.1.113883.6.96", "Consent report (record artifact)", "Patient Consent", "Patienteneinwilligung", "Consentement du patient", "Consenso del paziente"),
	/**
	 * <div class="en">Advance directive report</div>
	 * <div class="de">Patientenverfügung</div> <div class="fr">Directives
	 * anticipées du patient</div> <div class="it">Direttive anticipate del
	 * paziente</div>
	 */
	ADVANCE_DIRECTIVE_REPORT("371538006", "2.16.840.1.113883.6.96", "Advance directive report (record artifact)", "Advance directive report", "Patientenverfügung", "Directives anticipées du patient", "Direttive anticipate del paziente"),
	/**
	 * <div class="en">Patient Summary</div> <div class="de">Patient Summary
	 * (medizinische Zusammenfassung)</div> <div class="fr">Résumé du dossier
	 * médical</div> <div class="it">Patient Summary (riassunto medico)</div>
	 */
	PATIENT_SUMMARY("371534008", "2.16.840.1.113883.6.96", "Summary report (record artifact)", "Patient Summary", "Patient Summary (medizinische Zusammenfassung)", "Résumé du dossier médical", "Patient Summary (riassunto medico)"),
	/**
	 * <div class="en">Medication summary</div>
	 * <div class="de">Medikamentenliste (aktuell)</div> <div class="fr">Liste
	 * des médicaments</div> <div class="it">Elenco dei medicamenti</div>
	 */
	MEDICATION_SUMMARY("721912009", "2.16.840.1.113883.6.96", "Medication summary document (record artifact)", "Medication summary", "Medikamentenliste (aktuell)", "Liste des médicaments", "Elenco dei medicamenti"),
	/**
	 * <div class="en">Drug prescription</div> <div class="de">Rezept</div>
	 * <div class="fr">Ordonnance</div> <div class="it">Ricetta medica</div>
	 */
	DRUG_PRESCRIPTION("440545006", "2.16.840.1.113883.6.96", "Prescription record (record artifact)", "Drug prescription", "Rezept", "Ordonnance", "Ricetta medica"),
	/**
	 * <div class="en">Non-drug prescription</div>
	 * <div class="de">Nicht-Arzneimittelbezogene Verordnung</div>
	 * <div class="fr">Ordonnance nonmédicamenteuse</div>
	 * <div class="it">Richiesta di prestazione sanitaria</div>
	 */
	NON_DRUG_PRESCRIPTION("1371000195104", "2.16.840.1.113883.6.96", "Non-drug prescription record (record artifact)", "Non-drug prescription", "Nicht-Arzneimittelbezogene Verordnung", "Ordonnance nonmédicamenteuse", "Richiesta di prestazione sanitaria"),
	/**
	 * <div class="en">Medication Dispensation </div>
	 * <div class="de">Dispensation</div> <div class="fr">Dispensation</div>
	 * <div class="it">Dispensazione</div>
	 */
	MEDICATION_DISPENSATION("275670009", "2.16.840.1.113883.6.96", "Prescription exemption certificate (record artifact)", "Medication Dispensation ", "Dispensation", "Dispensation", "Dispensazione"),
	/**
	 * <div class="en">Medication Comment</div> <div class="de">Kommentar zu
	 * Medikation</div> <div class="fr">Commentaire sur la médication</div>
	 * <div class="it">Commento alla terapia farmacologica</div>
	 */
	MEDICATION_COMMENT("1221000195109", "2.16.840.1.113883.6.96", "Medication Comment (record artifact)", "Medication Comment", "Kommentar zu Medikation", "Commentaire sur la médication", "Commento alla terapia farmacologica"),
	/**
	 * <div class="en">Medication Treatment Plan</div>
	 * <div class="de">Therapieentscheid </div> <div class="fr">Plan de
	 * traitement pharmacologique</div> <div class="it">Programma di trattamento
	 * farmacologico</div>
	 */
	MEDICATION_TREATMENT_PLAN("761931002", "2.16.840.1.113883.6.96", "Medication treatment plan report (record artifact)", "Medication Treatment Plan", "Therapieentscheid ", "Plan de traitement pharmacologique", "Programma di trattamento farmacologico"),
	/**
	 * <div class="en">Admission request</div>
	 * <div class="de">Zuweisungsschreiben/Einweisungsschreiben</div>
	 * <div class="fr">Demande d'admission</div> <div class="it">Richiesta di
	 * ricovero/ammissione</div>
	 */
	ADMISSION_REQUEST("721915006", "2.16.840.1.113883.6.96", "Admission request document (record artifact)", "Admission request", "Zuweisungsschreiben/Einweisungsschreiben", "Demande d'admission", "Richiesta di ricovero/ammissione"),
	/**
	 * <div class="en">Admission report</div>
	 * <div class="de">Eintrittsbericht</div> <div class="fr">Rapport
	 * d'admission</div> <div class="it">Rapporto di ammissione</div>
	 */
	ADMISSION_REPORT("371542009", "2.16.840.1.113883.6.96", "Admission history and physical report (record artifact)", "Admission report", "Eintrittsbericht", "Rapport d'admission", "Rapporto di ammissione"),
	/**
	 * <div class="en">Discharge summary</div>
	 * <div class="de">Austrittsbericht</div> <div class="fr">Lettre de
	 * sortie</div> <div class="it">Rapporto/lettera d'uscita</div>
	 */
	DISCHARGE_SUMMARY("373942005", "2.16.840.1.113883.6.96", "Discharge summary (record artifact)", "Discharge summary", "Austrittsbericht", "Lettre de sortie", "Rapporto/lettera d'uscita"),
	/**
	 * <div class="en">Transfer summary report</div>
	 * <div class="de">Verlegungsbericht</div> <div class="fr">Rapport de
	 * transfert</div> <div class="it">Rapporto di trasferimento</div>
	 */
	TRANSFER_SUMMARY_REPORT("371535009", "2.16.840.1.113883.6.96", "Transfer summary report (record artifact)", "Transfer summary report", "Verlegungsbericht", "Rapport de transfert", "Rapporto di trasferimento"),
	/**
	 * <div class="en">Care plan</div> <div class="de">Pflegeplan
	 * (allgemein)</div> <div class="fr">Plan de soins</div>
	 * <div class="it">Piano di cura</div>
	 */
	CARE_PLAN("278448002", "2.16.840.1.113883.6.96", "Care plan (qualifier value)", "Care plan", "Pflegeplan (allgemein)", "Plan de soins", "Piano di cura"),
	/**
	 * <div class="en">Nursing report</div> <div class="de">Pflegebericht</div>
	 * <div class="fr">Rapport de soins infirmiers</div>
	 * <div class="it">Rapporto infermieristico</div>
	 */
	NURSING_REPORT("5531000179105", "2.16.840.1.113883.6.96", "Nursing report (record artifact)", "Nursing report", "Pflegebericht", "Rapport de soins infirmiers", "Rapporto infermieristico"),
	/**
	 * <div class="en">Referral request</div> <div class="de">Konsilauftrag
	 * (allgemein)</div> <div class="fr">Demande de consultation</div>
	 * <div class="it">Richiesta di consulto</div>
	 */
	REFERRAL_REQUEST("721927009", "2.16.840.1.113883.6.96", "Referral note (record artifact)", "Referral request", "Konsilauftrag (allgemein)", "Demande de consultation", "Richiesta di consulto"),
	/**
	 * <div class="en">Consultation report</div>
	 * <div class="de">Konsultationsbericht</div> <div class="fr">Rapport de
	 * consultation</div> <div class="it">Rapporto di consultazione</div>
	 */
	CONSULTATION_REPORT("371530004", "2.16.840.1.113883.6.96", "Clinical consultation report (record artifact)", "Consultation report", "Konsultationsbericht", "Rapport de consultation", "Rapporto di consultazione"),
	/**
	 * <div class="en">Clinical procedure report</div>
	 * <div class="de">Untersuchungsbefund (allgemein)</div>
	 * <div class="fr">Rapport d'examen</div> <div class="it">Risultato d'esame
	 * (generale)</div>
	 */
	CLINICAL_PROCEDURE_REPORT("371525003", "2.16.840.1.113883.6.96", "Clinical procedure report (record artifact)", "Clinical procedure report", "Untersuchungsbefund (allgemein)", "Rapport d'examen", "Risultato d'esame (generale)"),
	/**
	 * <div class="en">Laboratory report</div>
	 * <div class="de">Labor-Befund</div> <div class="fr">Résultat de
	 * laboratoire</div> <div class="it">Referto di laboratorio</div>
	 */
	LABORATORY_REPORT("4241000179101", "2.16.840.1.113883.6.96", "Laboratory report (record artifact)", "Laboratory report", "Labor-Befund", "Résultat de laboratoire", "Referto di laboratorio"),
	/**
	 * <div class="en">Pathology report</div>
	 * <div class="de">Pathologie-Befund</div> <div class="fr">Rapport de
	 * pathologie</div> <div class="it">Referto di patologia</div>
	 */
	PATHOLOGY_REPORT("371528001", "2.16.840.1.113883.6.96", "Pathology report (record artifact)", "Pathology report", "Pathologie-Befund", "Rapport de pathologie", "Referto di patologia"),
	/**
	 * <div class="en">Bone marrow Pathology biopsy report</div>
	 * <div class="de">Knochenmark-Biopsie-Befund</div> <div class="fr">Rapport
	 * de la biopsie de la moelle osseuse</div> <div class="it">Referto di
	 * biopsia del midollo osseo</div>
	 */
	BONE_MARROW_PATHOLOGY_BIOPSY_REPORT("721631001", "2.16.840.1.113883.6.96", "Bone marrow pathology biopsy report (record artifact)", "Bone marrow Pathology biopsy report", "Knochenmark-Biopsie-Befund", "Rapport de la biopsie de la moelle osseuse", "Referto di biopsia del midollo osseo"),
	/**
	 * <div class="en">Cardiac catheterization report</div>
	 * <div class="de">Herzkatheter-Befund</div> <div class="fr">Rapport du
	 * cathétérisme cardiaque</div> <div class="it">Referto di cateterismo
	 * cardiaco</div>
	 */
	CARDIAC_CATHETERIZATION_REPORT("721968000", "2.16.840.1.113883.6.96", "Cardiac catheterization report (record artifact)", "Cardiac catheterization report", "Herzkatheter-Befund", "Rapport du cathétérisme cardiaque", "Referto di cateterismo cardiaco"),
	/**
	 * <div class="en">Electrocardiogram report</div>
	 * <div class="de">Echokardiographie Befund</div> <div class="fr">Rapport
	 * d'électrocardiographie (ECG)</div> <div class="it">Referto di
	 * ecocardiografia </div>
	 */
	ELECTROCARDIOGRAM_REPORT("399345000", "2.16.840.1.113883.6.96", "Adult echocardiography procedure report (record artifact)", "Electrocardiogram report", "Echokardiographie Befund", "Rapport d'électrocardiographie (ECG)", "Referto di ecocardiografia "),
	/**
	 * <div class="en">Ultrasound imaging report</div>
	 * <div class="de">Ultraschall-Befund</div> <div class="fr">Rapport de
	 * l'ultrason</div> <div class="it">Referto ecografico</div>
	 */
	ULTRASOUND_IMAGING_REPORT("4221000179107", "2.16.840.1.113883.6.96", "Ultrasound imaging report (record artifact)", "Ultrasound imaging report", "Ultraschall-Befund", "Rapport de l'ultrason", "Referto ecografico"),
	/**
	 * <div class="en">Radiology report</div>
	 * <div class="de">Radiologie-Befund</div> <div class="fr">Rapport de
	 * l'examen radiologique</div> <div class="it">Referto radiologico</div>
	 */
	RADIOLOGY_REPORT("371527006", "2.16.840.1.113883.6.96", "Radiology report (record artifact)", "Radiology report", "Radiologie-Befund", "Rapport de l'examen radiologique", "Referto radiologico"),
	/**
	 * <div class="en">Anaesthesiology report</div>
	 * <div class="de">Anästhesie-Befund</div> <div class="fr">Rapport de
	 * l'anésthésie</div> <div class="it">Referto anestesiologico</div>
	 */
	ANAESTHESIOLOGY_REPORT("416779005", "2.16.840.1.113883.6.96", "Anesthesia record (record artifact)", "Anaesthesiology report", "Anästhesie-Befund", "Rapport de l'anésthésie", "Referto anestesiologico"),
	/**
	 * <div class="en">Operative report</div> <div class="de">OP-Bericht</div>
	 * <div class="fr">Protocole opératoire</div> <div class="it">Referto
	 * operatorio</div>
	 */
	OPERATIVE_REPORT("371526002", "2.16.840.1.113883.6.96", "Operative report (record artifact)", "Operative report", "OP-Bericht", "Protocole opératoire", "Referto operatorio"),
	/**
	 * <div class="en">Birth certificate</div>
	 * <div class="de">Geburtsurkunde</div> <div class="fr">Certificat de
	 * naissance</div> <div class="it">Cerificato di nascita</div>
	 */
	BIRTH_CERTIFICATE("444561001", "2.16.840.1.113883.6.96", "Birth certificate (record artifact)", "Birth certificate", "Geburtsurkunde", "Certificat de naissance", "Cerificato di nascita"),
	/**
	 * <div class="en">Death certificate</div>
	 * <div class="de">Todesbescheinigung</div> <div class="fr">Certificat de
	 * décès</div> <div class="it">Certificato di morte</div>
	 */
	DEATH_CERTIFICATE("307930005", "2.16.840.1.113883.6.96", "Death certificate (record artifact)", "Death certificate", "Todesbescheinigung", "Certificat de décès", "Certificato di morte"),
	/**
	 * <div class="en">Wound report</div> <div class="de">Wund-Befund</div>
	 * <div class="fr">Rapport sur les blessures</div> <div class="it">Rapporto
	 * sulle ferite</div>
	 */
	WOUND_REPORT("721599005", "2.16.840.1.113883.6.96", "Wound care management note (record artifact)", "Wound report", "Wund-Befund", "Rapport sur les blessures", "Rapporto sulle ferite"),
	/**
	 * <div class="en">Progress note</div> <div class="de">Klinisches
	 * Verlaufsblatt</div> <div class="fr">Note de suite</div>
	 * <div class="it">Diario clinico</div>
	 */
	PROGRESS_NOTE("371532007", "2.16.840.1.113883.6.96", "Progress report (record artifact)", "Progress note", "Klinisches Verlaufsblatt", "Note de suite", "Diario clinico"),
	/**
	 * <div class="en">Conclusion interpretation document</div>
	 * <div class="de">Beschlussprotokoll</div> <div class="fr">Rapport de
	 * décision</div> <div class="it">Rapporto decisionale</div>
	 */
	CONCLUSION_INTERPRETATION_DOCUMENT("722091001", "2.16.840.1.113883.6.96", "Conclusion interpretation document (record artifact)", "Conclusion interpretation document", "Beschlussprotokoll", "Rapport de décision", "Rapporto decisionale"),
	/**
	 * <div class="en">Image reference</div> <div class="de">Referenz auf
	 * Bilddaten</div> <div class="fr">Référence d'Image</div>
	 * <div class="it">Referenza nei dati immagine</div>
	 */
	IMAGE_REFERENCE("900000000000471000", "2.16.840.1.113883.6.96", "Image reference (foundation metadata concept)", "Image reference", "Referenz auf Bilddaten", "Référence d'Image", "Referenza nei dati immagine"),
	/**
	 * <div class="en">Immunization record</div>
	 * <div class="de">Impfausweis/Impfdossier</div> <div class="fr">Certificat
	 * / carnet de vaccination</div> <div class="it">Certificato/libretto di
	 * vaccinazione</div>
	 */
	IMMUNIZATION_RECORD("41000179103", "2.16.840.1.113883.6.96", "Immunization record (record artifact)", "Immunization record", "Impfausweis/Impfdossier", "Certificat / carnet de vaccination", "Certificato/libretto di vaccinazione"),
	/**
	 * <div class="en">Other EPD-document type</div> <div class="de">Anderer EPD
	 * Dokumenten-Typ</div> <div class="fr">Autre type de document DEP</div>
	 * <div class="it">Altri tipi di documento CIP</div>
	 */
	OTHER_EPD_DOCUMENT_TYPE("424975005", "2.16.840.1.113883.6.96", "Record entry (record artifact)", "Other EPD-document type", "Anderer EPD Dokumenten-Typ", "Autre type de document DEP", "Altri tipi di documento CIP"),
	/**
	 * <div class="en">Audit trail</div> <div class="de">Audit trail</div>
	 * <div class="fr">Journal d'audit</div> <div class="it">Audit trail</div>
	 */
	AUDIT_TRAIL("722160009", "2.16.840.1.113883.6.96", "Audit trail report (record artifact) ", "Audit trail", "Audit trail", "Journal d'audit", "Audit trail"),
	/**
	 * <div class="en">Order</div> <div class="de">Auftrag</div>
	 * <div class="fr">Demande</div> <div class="it">Ordine</div>
	 */
	ORDER("721963009", "2.16.840.1.113883.6.96", "Order (record artifact)", "Order", "Auftrag", "Demande", "Ordine");

	/**
	 * <div class="en">Code for Patient Consent</div> <div class="de">Code für
	 * Patienteneinwilligung</div> <div class="fr">Code de Consentement du
	 * patient</div> <div class="it">Code per Consenso del paziente</div>
	 */
	public static final String PATIENT_CONSENT_CODE = "371537001";

	/**
	 * <div class="en">Code for Advance directive report</div>
	 * <div class="de">Code für Patientenverfügung</div> <div class="fr">Code de
	 * Directives anticipées du patient</div> <div class="it">Code per Direttive
	 * anticipate del paziente</div>
	 */
	public static final String ADVANCE_DIRECTIVE_REPORT_CODE = "371538006";

	/**
	 * <div class="en">Code for Patient Summary</div> <div class="de">Code für
	 * Patient Summary (medizinische Zusammenfassung)</div> <div class="fr">Code
	 * de Résumé du dossier médical</div> <div class="it">Code per Patient
	 * Summary (riassunto medico)</div>
	 */
	public static final String PATIENT_SUMMARY_CODE = "371534008";

	/**
	 * <div class="en">Code for Medication summary</div> <div class="de">Code
	 * für Medikamentenliste (aktuell)</div> <div class="fr">Code de Liste des
	 * médicaments</div> <div class="it">Code per Elenco dei medicamenti</div>
	 */
	public static final String MEDICATION_SUMMARY_CODE = "721912009";

	/**
	 * <div class="en">Code for Drug prescription</div> <div class="de">Code für
	 * Rezept</div> <div class="fr">Code de Ordonnance</div>
	 * <div class="it">Code per Ricetta medica</div>
	 */
	public static final String DRUG_PRESCRIPTION_CODE = "440545006";

	/**
	 * <div class="en">Code for Non-drug prescription</div> <div class="de">Code
	 * für Nicht-Arzneimittelbezogene Verordnung</div> <div class="fr">Code de
	 * Ordonnance nonmédicamenteuse</div> <div class="it">Code per Richiesta di
	 * prestazione sanitaria</div>
	 */
	public static final String NON_DRUG_PRESCRIPTION_CODE = "1371000195104";

	/**
	 * <div class="en">Code for Medication Dispensation </div>
	 * <div class="de">Code für Dispensation</div> <div class="fr">Code de
	 * Dispensation</div> <div class="it">Code per Dispensazione</div>
	 */
	public static final String MEDICATION_DISPENSATION_CODE = "275670009";

	/**
	 * <div class="en">Code for Medication Comment</div> <div class="de">Code
	 * für Kommentar zu Medikation</div> <div class="fr">Code de Commentaire sur
	 * la médication</div> <div class="it">Code per Commento alla terapia
	 * farmacologica</div>
	 */
	public static final String MEDICATION_COMMENT_CODE = "1221000195109";

	/**
	 * <div class="en">Code for Medication Treatment Plan</div>
	 * <div class="de">Code für Therapieentscheid </div> <div class="fr">Code de
	 * Plan de traitement pharmacologique</div> <div class="it">Code per
	 * Programma di trattamento farmacologico</div>
	 */
	public static final String MEDICATION_TREATMENT_PLAN_CODE = "761931002";

	/**
	 * <div class="en">Code for Admission request</div> <div class="de">Code für
	 * Zuweisungsschreiben/Einweisungsschreiben</div> <div class="fr">Code de
	 * Demande d'admission</div> <div class="it">Code per Richiesta di
	 * ricovero/ammissione</div>
	 */
	public static final String ADMISSION_REQUEST_CODE = "721915006";

	/**
	 * <div class="en">Code for Admission report</div> <div class="de">Code für
	 * Eintrittsbericht</div> <div class="fr">Code de Rapport d'admission</div>
	 * <div class="it">Code per Rapporto di ammissione</div>
	 */
	public static final String ADMISSION_REPORT_CODE = "371542009";

	/**
	 * <div class="en">Code for Discharge summary</div> <div class="de">Code für
	 * Austrittsbericht</div> <div class="fr">Code de Lettre de sortie</div>
	 * <div class="it">Code per Rapporto/lettera d'uscita</div>
	 */
	public static final String DISCHARGE_SUMMARY_CODE = "373942005";

	/**
	 * <div class="en">Code for Transfer summary report</div>
	 * <div class="de">Code für Verlegungsbericht</div> <div class="fr">Code de
	 * Rapport de transfert</div> <div class="it">Code per Rapporto di
	 * trasferimento</div>
	 */
	public static final String TRANSFER_SUMMARY_REPORT_CODE = "371535009";

	/**
	 * <div class="en">Code for Care plan</div> <div class="de">Code für
	 * Pflegeplan (allgemein)</div> <div class="fr">Code de Plan de soins</div>
	 * <div class="it">Code per Piano di cura</div>
	 */
	public static final String CARE_PLAN_CODE = "278448002";

	/**
	 * <div class="en">Code for Nursing report</div> <div class="de">Code für
	 * Pflegebericht</div> <div class="fr">Code de Rapport de soins
	 * infirmiers</div> <div class="it">Code per Rapporto infermieristico</div>
	 */
	public static final String NURSING_REPORT_CODE = "5531000179105";

	/**
	 * <div class="en">Code for Referral request</div> <div class="de">Code für
	 * Konsilauftrag (allgemein)</div> <div class="fr">Code de Demande de
	 * consultation</div> <div class="it">Code per Richiesta di consulto</div>
	 */
	public static final String REFERRAL_REQUEST_CODE = "721927009";

	/**
	 * <div class="en">Code for Consultation report</div> <div class="de">Code
	 * für Konsultationsbericht</div> <div class="fr">Code de Rapport de
	 * consultation</div> <div class="it">Code per Rapporto di
	 * consultazione</div>
	 */
	public static final String CONSULTATION_REPORT_CODE = "371530004";

	/**
	 * <div class="en">Code for Clinical procedure report</div>
	 * <div class="de">Code für Untersuchungsbefund (allgemein)</div>
	 * <div class="fr">Code de Rapport d'examen</div> <div class="it">Code per
	 * Risultato d'esame (generale)</div>
	 */
	public static final String CLINICAL_PROCEDURE_REPORT_CODE = "371525003";

	/**
	 * <div class="en">Code for Laboratory report</div> <div class="de">Code für
	 * Labor-Befund</div> <div class="fr">Code de Résultat de laboratoire</div>
	 * <div class="it">Code per Referto di laboratorio</div>
	 */
	public static final String LABORATORY_REPORT_CODE = "4241000179101";

	/**
	 * <div class="en">Code for Pathology report</div> <div class="de">Code für
	 * Pathologie-Befund</div> <div class="fr">Code de Rapport de
	 * pathologie</div> <div class="it">Code per Referto di patologia</div>
	 */
	public static final String PATHOLOGY_REPORT_CODE = "371528001";

	/**
	 * <div class="en">Code for Bone marrow Pathology biopsy report</div>
	 * <div class="de">Code für Knochenmark-Biopsie-Befund</div>
	 * <div class="fr">Code de Rapport de la biopsie de la moelle osseuse</div>
	 * <div class="it">Code per Referto di biopsia del midollo osseo</div>
	 */
	public static final String BONE_MARROW_PATHOLOGY_BIOPSY_REPORT_CODE = "721631001";

	/**
	 * <div class="en">Code for Cardiac catheterization report</div>
	 * <div class="de">Code für Herzkatheter-Befund</div> <div class="fr">Code
	 * de Rapport du cathétérisme cardiaque</div> <div class="it">Code per
	 * Referto di cateterismo cardiaco</div>
	 */
	public static final String CARDIAC_CATHETERIZATION_REPORT_CODE = "721968000";

	/**
	 * <div class="en">Code for Electrocardiogram report</div>
	 * <div class="de">Code für Echokardiographie Befund</div>
	 * <div class="fr">Code de Rapport d'électrocardiographie (ECG)</div>
	 * <div class="it">Code per Referto di ecocardiografia </div>
	 */
	public static final String ELECTROCARDIOGRAM_REPORT_CODE = "399345000";

	/**
	 * <div class="en">Code for Ultrasound imaging report</div>
	 * <div class="de">Code für Ultraschall-Befund</div> <div class="fr">Code de
	 * Rapport de l'ultrason</div> <div class="it">Code per Referto
	 * ecografico</div>
	 */
	public static final String ULTRASOUND_IMAGING_REPORT_CODE = "4221000179107";

	/**
	 * <div class="en">Code for Radiology report</div> <div class="de">Code für
	 * Radiologie-Befund</div> <div class="fr">Code de Rapport de l'examen
	 * radiologique</div> <div class="it">Code per Referto radiologico</div>
	 */
	public static final String RADIOLOGY_REPORT_CODE = "371527006";

	/**
	 * <div class="en">Code for Anaesthesiology report</div>
	 * <div class="de">Code für Anästhesie-Befund</div> <div class="fr">Code de
	 * Rapport de l'anésthésie</div> <div class="it">Code per Referto
	 * anestesiologico</div>
	 */
	public static final String ANAESTHESIOLOGY_REPORT_CODE = "416779005";

	/**
	 * <div class="en">Code for Operative report</div> <div class="de">Code für
	 * OP-Bericht</div> <div class="fr">Code de Protocole opératoire</div>
	 * <div class="it">Code per Referto operatorio</div>
	 */
	public static final String OPERATIVE_REPORT_CODE = "371526002";

	/**
	 * <div class="en">Code for Birth certificate</div> <div class="de">Code für
	 * Geburtsurkunde</div> <div class="fr">Code de Certificat de
	 * naissance</div> <div class="it">Code per Cerificato di nascita</div>
	 */
	public static final String BIRTH_CERTIFICATE_CODE = "444561001";

	/**
	 * <div class="en">Code for Death certificate</div> <div class="de">Code für
	 * Todesbescheinigung</div> <div class="fr">Code de Certificat de
	 * décès</div> <div class="it">Code per Certificato di morte</div>
	 */
	public static final String DEATH_CERTIFICATE_CODE = "307930005";

	/**
	 * <div class="en">Code for Wound report</div> <div class="de">Code für
	 * Wund-Befund</div> <div class="fr">Code de Rapport sur les blessures</div>
	 * <div class="it">Code per Rapporto sulle ferite</div>
	 */
	public static final String WOUND_REPORT_CODE = "721599005";

	/**
	 * <div class="en">Code for Progress note</div> <div class="de">Code für
	 * Klinisches Verlaufsblatt</div> <div class="fr">Code de Note de
	 * suite</div> <div class="it">Code per Diario clinico</div>
	 */
	public static final String PROGRESS_NOTE_CODE = "371532007";

	/**
	 * <div class="en">Code for Conclusion interpretation document</div>
	 * <div class="de">Code für Beschlussprotokoll</div> <div class="fr">Code de
	 * Rapport de décision</div> <div class="it">Code per Rapporto
	 * decisionale</div>
	 */
	public static final String CONCLUSION_INTERPRETATION_DOCUMENT_CODE = "722091001";

	/**
	 * <div class="en">Code for Image reference</div> <div class="de">Code für
	 * Referenz auf Bilddaten</div> <div class="fr">Code de Référence
	 * d'Image</div> <div class="it">Code per Referenza nei dati immagine</div>
	 */
	public static final String IMAGE_REFERENCE_CODE = "900000000000471000";

	/**
	 * <div class="en">Code for Immunization record</div> <div class="de">Code
	 * für Impfausweis/Impfdossier</div> <div class="fr">Code de Certificat /
	 * carnet de vaccination</div> <div class="it">Code per Certificato/libretto
	 * di vaccinazione</div>
	 */
	public static final String IMMUNIZATION_RECORD_CODE = "41000179103";

	/**
	 * <div class="en">Code for Other EPD-document type</div>
	 * <div class="de">Code für Anderer EPD Dokumenten-Typ</div>
	 * <div class="fr">Code de Autre type de document DEP</div>
	 * <div class="it">Code per Altri tipi di documento CIP</div>
	 */
	public static final String OTHER_EPD_DOCUMENT_TYPE_CODE = "424975005";

	/**
	 * <div class="en">Code for Audit trail</div> <div class="de">Code für Audit
	 * trail</div> <div class="fr">Code de Journal d'audit</div>
	 * <div class="it">Code per Audit trail</div>
	 */
	public static final String AUDIT_TRAIL_CODE = "722160009";

	/**
	 * <div class="en">Code for Order</div> <div class="de">Code für
	 * Auftrag</div> <div class="fr">Code de Demande</div> <div class="it">Code
	 * per Ordine</div>
	 */
	public static final String ORDER_CODE = "721963009";

	/**
	 * <div class="en">Name of the value set</div> <div class="de">Name des
	 * Value Sets</div>
	 */
	public static final String VALUE_SET_NAME = "epd_xds_typeCode";

	/**
	 * <div class="en">Identifier of the value set</div>
	 * <div class="de">Identifikator für das Value Set</div>
	 */
	public static final String VALUE_SET_ID = "2.16.756.5.30.1.127.3.10.1.27";

	/**
	 * <div class="en">Gets the Enum with a given code</div>
	 * <div class="de">Liefert den Enum anhand eines gegebenen codes</div>
	 *
	 * @param code
	 *            <div class="de"> code</div>
	 * @return <div class="en">the enum</div>
	 */
	public static TypeCode getEnum(String code) {
		for (final TypeCode x : values()) {
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
			Enum.valueOf(TypeCode.class, enumName);
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
		for (final TypeCode x : values()) {
			if (x.getCodeValue().equals(codeValue)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * The display names per language
	 */
	private Map<LanguageCode, String> displayNames;

	/**
	 * <div class="en">Machine interpretable and (inside this class) unique
	 * code</div> <div class="de">Maschinen interpretierbarer und (innerhalb
	 * dieser Klasse) eindeutiger Code</div>
	 */
	private String code;

	/**
	 * <div class="en">Identifier of the referencing code system.</div>
	 * <div class="de">Identifikator des referenzierende Codesystems.</div>
	 */
	private String codeSystem;

	/**
	 * <div class="en">Instantiates this Enum Object with a given Code and
	 * Display Name</div> <div class="de">Instanziiert dieses Enum Object
	 * mittels eines Codes und einem Display Name</div>.
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
	TypeCode(String code, String codeSystem, String displayName, String displayNameEn,
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
	 * <div class="en">Gets the code system identifier.</div>
	 * <div class="de">Liefert den Code System Identifikator.</div>
	 *
	 * @return <div class="en">the code system identifier</div>
	 */
	@Override
	public String getCodeSystemValue() {
		return this.codeSystem;
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
	 * there is no english translation, the default display name is
	 * returned.</div> <div class="de">Liefert display name gemäss Parameter,
	 * falls es keine Englische Übersetzung gibt, wird der default-Name
	 * zurückgegeben.</div>
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
	 * <div class="en">Gets the value set identifier.</div>
	 * <div class="de">Liefert den Value Set Identifikator.</div>
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
