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
 * <div class="en">Type of document as per Annex 3  EPRO-FDHA.<br clear="none"/><br clear="none"/>The code defines a document’s type (e.g. discharge report, laboratory report). Each document type should be assigned to precisely one document class.<br clear="none"/></div>
 * <div class="de">Typ des Dokumentes (2.16.756.5.30.1.127.3.10.1.27) gemäss Anhang 3 der Verordnungen zum EPDG.<br clear="none"/><br clear="none"/>Der Code definiert den Typ eines Dokuments (z.B.  Austrittsbericht, Labor-Bericht). Jeder Dokumenten-Typ sollte genau einer Dokumentenklasse zugeordnet sein.<br clear="none"/></div>
 * <div class="fr">Type du document selon l'annexe 3 ODEP-DFI.<br clear="none"/><br clear="none"/>Le code définit le type de document (p. ex. rapport de sortie, rapport de laboratoire). Chaque type de document doit être  associé à une seule classification.<br clear="none"/></div>
 * <div class="it">Tipo di documento secondo l'allegato 3 OCIP-DFI.<br clear="none"/><br clear="none"/>Il codice definisce il tipo di documento (p. es. rapporto di dimissione, rapporto di laboratorio). Ciascun tipo di documento dovrebbe essere associato a una sola classe di documenti.<br clear="none"/></div>
 * <!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets")
public enum TypeCode implements ValueSetEnumInterface {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Allergy record</div>
	 * <div class="de">TODO</div>
	 * <div class="fr">TODO</div>
	 * <div class="it">TODO</div>
	 * <!-- @formatter:on -->
	 */
	ALLERGY_RECORD("722446000", "2.16.840.1.113883.6.96", "Allergy record (record artifact)",
			"Allergy record", "TODO", "TODO", "TODO"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Clinical Management plan</div>
	 * <div class="de">TODO</div>
	 * <div class="fr">TODO</div>
	 * <div class="it">TODO</div>
	 * <!-- @formatter:on -->
	 */
	CLINICAL_MANAGEMENT_PLAN("737427001", "2.16.840.1.113883.6.96",
			"Clinical Management plan (record artifact)", "Clinical Management plan", "TODO",
			"TODO", "TODO"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Consultation report</div>
	 * <div class="de">Konsultationsbericht</div>
	 * <div class="fr">Rapport de consultation</div>
	 * <div class="it">Rapporto di consultazione</div>
	 * <!-- @formatter:on -->
	 */
	CONSULTATION_REPORT("371530004", "2.16.840.1.113883.6.96",
			"Clinical consultation report (record artifact)", "Consultation report",
			"Konsultationsbericht", "Rapport de consultation", "Rapporto di consultazione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Discharge summary</div>
	 * <div class="de">Austrittsbericht</div>
	 * <div class="fr">Lettre de sortie</div>
	 * <div class="it">Rapporto/lettera d'uscita</div>
	 * <!-- @formatter:on -->
	 */
	DISCHARGE_SUMMARY("373942005", "2.16.840.1.113883.6.96", "Discharge summary (record artifact)",
			"Discharge summary", "Austrittsbericht", "Lettre de sortie",
			"Rapporto/lettera d'uscita"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Emergency department record</div>
	 * <div class="de">TODO</div>
	 * <div class="fr">TODO</div>
	 * <div class="it">TODO</div>
	 * <!-- @formatter:on -->
	 */
	EMERGENCY_DEPARTMENT_RECORD("445300006", "2.16.840.1.113883.6.96",
			"Emergency department record (record artifact)", "Emergency department record", "TODO",
			"TODO", "TODO"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">History and physical report</div>
	 * <div class="de">TODO</div>
	 * <div class="fr">TODO</div>
	 * <div class="it">TODO</div>
	 * <!-- @formatter:on -->
	 */
	HISTORY_AND_PHYSICAL_REPORT("371529009", "2.16.840.1.113883.6.96",
			"History and physical report (record artifact)", "History and physical report", "TODO",
			"TODO", "TODO"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Image reference</div>
	 * <div class="de">Referenz auf Bilddaten</div>
	 * <div class="fr">Référence d'Image</div>
	 * <div class="it">Referenza nei dati immagine</div>
	 * <!-- @formatter:on -->
	 */
	IMAGE_REFERENCE("900000000000471006", "2.16.840.1.113883.6.96",
			"Image reference (foundation metadata concept)", "Image reference",
			"Referenz auf Bilddaten", "Référence d'Image", "Referenza nei dati immagine"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Imaging Order</div>
	 * <div class="de">TODO</div>
	 * <div class="fr">TODO</div>
	 * <div class="it">TODO</div>
	 * <!-- @formatter:on -->
	 */
	IMAGING_ORDER("2161000195103", "2.16.840.1.113883.6.96", "Imaging Order (record articact)",
			"Imaging Order", "TODO", "TODO", "TODO"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Imaging report</div>
	 * <div class="de">TODO</div>
	 * <div class="fr">TODO</div>
	 * <div class="it">TODO</div>
	 * <!-- @formatter:on -->
	 */
	IMAGING_REPORT("4201000179104", "2.16.756.5.30.1.127.3.4", "Imaging report (record artifact)",
			"Imaging report", "TODO", "TODO", "TODO"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Immunization record</div>
	 * <div class="de">Impfausweis/Impfdossier</div>
	 * <div class="fr">Certificat / carnet de vaccination</div>
	 * <div class="it">Certificato/libretto di vaccinazione</div>
	 * <!-- @formatter:on -->
	 */
	IMMUNIZATION_RECORD("41000179103", "2.16.840.1.113883.6.96",
			"Immunization record (record artifact)", "Immunization record",
			"Impfausweis/Impfdossier", "Certificat / carnet de vaccination",
			"Certificato/libretto di vaccinazione"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Laboratory Order</div>
	 * <div class="de">TODO</div>
	 * <div class="fr">TODO</div>
	 * <div class="it">TODO</div>
	 * <!-- @formatter:on -->
	 */
	LABORATORY_ORDER("721965002", "2.16.840.1.113883.6.96", "Laboratory Order (record artifact)",
			"Laboratory Order", "TODO", "TODO", "TODO"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Laboratory report</div>
	 * <div class="de">Labor-Befund</div>
	 * <div class="fr">Résultat de laboratoire</div>
	 * <div class="it">Referto di laboratorio</div>
	 * <!-- @formatter:on -->
	 */
	LABORATORY_REPORT("4241000179101", "2.16.840.1.113883.6.96",
			"Laboratory report (record artifact)", "Laboratory report", "Labor-Befund",
			"Résultat de laboratoire", "Referto di laboratorio"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Medical certificate</div>
	 * <div class="de">TODO</div>
	 * <div class="fr">TODO</div>
	 * <div class="it">TODO</div>
	 * <!-- @formatter:on -->
	 */
	MEDICAL_CERTIFICATE("772786005", "2.16.840.1.113883.6.96",
			"Medical certificate (record artifact)", "Medical certificate", "TODO", "TODO", "TODO"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Medical Prescription record</div>
	 * <div class="de">TODO</div>
	 * <div class="fr">TODO</div>
	 * <div class="it">TODO</div>
	 * <!-- @formatter:on -->
	 */
	MEDICAL_PRESCRIPTION_RECORD("761938008", "2.16.840.1.113883.6.96",
			"Medical Prescription record (record artifact)", "Medical Prescription record", "TODO",
			"TODO", "TODO"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Medication summary document</div>
	 * <div class="de">TODO</div>
	 * <div class="fr">TODO</div>
	 * <div class="it">TODO</div>
	 * <!-- @formatter:on -->
	 */
	MEDICATION_SUMMARY_DOCUMENT("721912009", "2.16.840.1.113883.6.96",
			"Medication summary document (record artifact)", "Medication summary document", "TODO",
			"TODO", "TODO"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Non-drug prescription</div>
	 * <div class="de">Nicht-Arzneimittelbezogene Verordnung</div>
	 * <div class="fr">Ordonnance nonmédicamenteuse</div>
	 * <div class="it">Richiesta di prestazione sanitaria</div>
	 * <!-- @formatter:on -->
	 */
	NON_DRUG_PRESCRIPTION("765492005", "2.16.840.1.113883.6.96",
			"Non-drug prescription record (record artifact)", "Non-drug prescription",
			"Nicht-Arzneimittelbezogene Verordnung", "Ordonnance nonmédicamenteuse",
			"Richiesta di prestazione sanitaria"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Nursing care plan</div>
	 * <div class="de">TODO</div>
	 * <div class="fr">TODO</div>
	 * <div class="it">TODO</div>
	 * <!-- @formatter:on -->
	 */
	NURSING_CARE_PLAN("773130005", "2.16.840.1.113883.6.96", "Nursing care plan (record artifact)",
			"Nursing care plan", "TODO", "TODO", "TODO"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Operative report</div>
	 * <div class="de">OP-Bericht</div>
	 * <div class="fr">Protocole opératoire</div>
	 * <div class="it">Referto operatorio</div>
	 * <!-- @formatter:on -->
	 */
	OPERATIVE_REPORT("371526002", "2.16.840.1.113883.6.96", "Operative report (record artifact)",
			"Operative report", "OP-Bericht", "Protocole opératoire", "Referto operatorio"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Pathology order</div>
	 * <div class="de">TODO</div>
	 * <div class="fr">TODO</div>
	 * <div class="it">TODO</div>
	 * <!-- @formatter:on -->
	 */
	PATHOLOGY_ORDER("721966001", "2.16.840.1.113883.6.96", "Pathology order (record artifact",
			"Pathology order", "TODO", "TODO", "TODO"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Pathology report</div>
	 * <div class="de">TODO</div>
	 * <div class="fr">TODO</div>
	 * <div class="it">TODO</div>
	 * <!-- @formatter:on -->
	 */
	PATHOLOGY_REPORT("371528001", "2.16.840.1.113883.6.96", "Pathology report (record artifact)",
			"Pathology report", "TODO", "TODO", "TODO"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Professional allied to medicine clinical report</div>
	 * <div class="de">TODO</div>
	 * <div class="fr">TODO</div>
	 * <div class="it">TODO</div>
	 * <!-- @formatter:on -->
	 */
	PROFESSIONAL_ALLIED_TO_MEDICINE_CLINICAL_REPORT("445418005", "2.16.840.1.113883.6.96",
			"Professional allied to medicine clinical report (record artifact)",
			"Professional allied to medicine clinical report", "TODO", "TODO", "TODO"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Progress note</div>
	 * <div class="de">Klinisches Verlaufsblatt</div>
	 * <div class="fr">Note de suite</div>
	 * <div class="it">Diario clinico</div>
	 * <!-- @formatter:on -->
	 */
	PROGRESS_NOTE("371532007", "2.16.840.1.113883.6.96", "Progress report (record artifact)",
			"Progress note", "Klinisches Verlaufsblatt", "Note de suite", "Diario clinico"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Record artifact</div>
	 * <div class="de">TODO</div>
	 * <div class="fr">TODO</div>
	 * <div class="it">TODO</div>
	 * <!-- @formatter:on -->
	 */
	RECORD_ARTIFACT("419891008", "2.16.840.1.113883.6.96", "Record artifact (record artifact)",
			"Record artifact", "TODO", "TODO", "TODO"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Rehabilitation care plan</div>
	 * <div class="de">TODO</div>
	 * <div class="fr">TODO</div>
	 * <div class="it">TODO</div>
	 * <!-- @formatter:on -->
	 */
	REHABILITATION_CARE_PLAN("736055001", "2.16.840.1.113883.6.96",
			"Rehabilitation care plan (record articact)", "Rehabilitation care plan", "TODO",
			"TODO", "TODO"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Transfer summary report</div>
	 * <div class="de">Verlegungsbericht</div>
	 * <div class="fr">Rapport de transfert</div>
	 * <div class="it">Rapporto di trasferimento</div>
	 * <!-- @formatter:on -->
	 */
	TRANSFER_SUMMARY_REPORT("371535009", "2.16.840.1.113883.6.96",
			"Transfer summary report (record artifact)", "Transfer summary report",
			"Verlegungsbericht", "Rapport de transfert", "Rapporto di trasferimento");

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Allergy record</div>
	 * <div class="de">Code für TODO</div>
	 * <div class="fr">Code de TODO</div>
	 * <div class="it">Code per TODO</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ALLERGY_RECORD_CODE = "722446000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Clinical Management plan</div>
	 * <div class="de">Code für TODO</div>
	 * <div class="fr">Code de TODO</div>
	 * <div class="it">Code per TODO</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CLINICAL_MANAGEMENT_PLAN_CODE = "737427001";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Consultation report</div>
	 * <div class="de">Code für Konsultationsbericht</div>
	 * <div class="fr">Code de Rapport de consultation</div>
	 * <div class="it">Code per Rapporto di consultazione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CONSULTATION_REPORT_CODE = "371530004";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Discharge summary</div>
	 * <div class="de">Code für Austrittsbericht</div>
	 * <div class="fr">Code de Lettre de sortie</div>
	 * <div class="it">Code per Rapporto/lettera d'uscita</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DISCHARGE_SUMMARY_CODE = "373942005";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Emergency department record</div>
	 * <div class="de">Code für TODO</div>
	 * <div class="fr">Code de TODO</div>
	 * <div class="it">Code per TODO</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EMERGENCY_DEPARTMENT_RECORD_CODE = "445300006";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for History and physical report</div>
	 * <div class="de">Code für TODO</div>
	 * <div class="fr">Code de TODO</div>
	 * <div class="it">Code per TODO</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HISTORY_AND_PHYSICAL_REPORT_CODE = "371529009";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Image reference</div>
	 * <div class="de">Code für Referenz auf Bilddaten</div>
	 * <div class="fr">Code de Référence d'Image</div>
	 * <div class="it">Code per Referenza nei dati immagine</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IMAGE_REFERENCE_CODE = "900000000000471006";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Imaging Order</div>
	 * <div class="de">Code für TODO</div>
	 * <div class="fr">Code de TODO</div>
	 * <div class="it">Code per TODO</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IMAGING_ORDER_CODE = "2161000195103";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Imaging report</div>
	 * <div class="de">Code für TODO</div>
	 * <div class="fr">Code de TODO</div>
	 * <div class="it">Code per TODO</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IMAGING_REPORT_CODE = "4201000179104";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Immunization record</div>
	 * <div class="de">Code für Impfausweis/Impfdossier</div>
	 * <div class="fr">Code de Certificat / carnet de vaccination</div>
	 * <div class="it">Code per Certificato/libretto di vaccinazione</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IMMUNIZATION_RECORD_CODE = "41000179103";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Laboratory Order</div>
	 * <div class="de">Code für TODO</div>
	 * <div class="fr">Code de TODO</div>
	 * <div class="it">Code per TODO</div>
	 * <!-- @formatter:on -->
	 */
	public static final String LABORATORY_ORDER_CODE = "721965002";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Laboratory report</div>
	 * <div class="de">Code für Labor-Befund</div>
	 * <div class="fr">Code de Résultat de laboratoire</div>
	 * <div class="it">Code per Referto di laboratorio</div>
	 * <!-- @formatter:on -->
	 */
	public static final String LABORATORY_REPORT_CODE = "4241000179101";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Medical certificate</div>
	 * <div class="de">Code für TODO</div>
	 * <div class="fr">Code de TODO</div>
	 * <div class="it">Code per TODO</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MEDICAL_CERTIFICATE_CODE = "772786005";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Medical Prescription record</div>
	 * <div class="de">Code für TODO</div>
	 * <div class="fr">Code de TODO</div>
	 * <div class="it">Code per TODO</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MEDICAL_PRESCRIPTION_RECORD_CODE = "761938008";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Medication summary document</div>
	 * <div class="de">Code für TODO</div>
	 * <div class="fr">Code de TODO</div>
	 * <div class="it">Code per TODO</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MEDICATION_SUMMARY_DOCUMENT_CODE = "721912009";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Non-drug prescription</div>
	 * <div class="de">Code für Nicht-Arzneimittelbezogene Verordnung</div>
	 * <div class="fr">Code de Ordonnance nonmédicamenteuse</div>
	 * <div class="it">Code per Richiesta di prestazione sanitaria</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NON_DRUG_PRESCRIPTION_CODE = "765492005";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Nursing care plan</div>
	 * <div class="de">Code für TODO</div>
	 * <div class="fr">Code de TODO</div>
	 * <div class="it">Code per TODO</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NURSING_CARE_PLAN_CODE = "773130005";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Operative report</div>
	 * <div class="de">Code für OP-Bericht</div>
	 * <div class="fr">Code de Protocole opératoire</div>
	 * <div class="it">Code per Referto operatorio</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OPERATIVE_REPORT_CODE = "371526002";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Pathology order</div>
	 * <div class="de">Code für TODO</div>
	 * <div class="fr">Code de TODO</div>
	 * <div class="it">Code per TODO</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PATHOLOGY_ORDER_CODE = "721966001";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Pathology report</div>
	 * <div class="de">Code für TODO</div>
	 * <div class="fr">Code de TODO</div>
	 * <div class="it">Code per TODO</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PATHOLOGY_REPORT_CODE = "371528001";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Professional allied to medicine clinical report</div>
	 * <div class="de">Code für TODO</div>
	 * <div class="fr">Code de TODO</div>
	 * <div class="it">Code per TODO</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PROFESSIONAL_ALLIED_TO_MEDICINE_CLINICAL_REPORT_CODE = "445418005";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Progress note</div>
	 * <div class="de">Code für Klinisches Verlaufsblatt</div>
	 * <div class="fr">Code de Note de suite</div>
	 * <div class="it">Code per Diario clinico</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PROGRESS_NOTE_CODE = "371532007";

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
	 * <div class="en">Code for Rehabilitation care plan</div>
	 * <div class="de">Code für TODO</div>
	 * <div class="fr">Code de TODO</div>
	 * <div class="it">Code per TODO</div>
	 * <!-- @formatter:on -->
	 */
	public static final String REHABILITATION_CARE_PLAN_CODE = "736055001";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Transfer summary report</div>
	 * <div class="de">Code für Verlegungsbericht</div>
	 * <div class="fr">Code de Rapport de transfert</div>
	 * <div class="it">Code per Rapporto di trasferimento</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TRANSFER_SUMMARY_REPORT_CODE = "371535009";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Identifier of the value set</div>
	 * <div class="de">Identifikator für das Value Set</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_ID = "2.16.756.5.30.1.127.3.10.1.27";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Name of the value set</div>
	 * <div class="de">Name des Value Sets</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_NAME = "xds-typeCo";

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
	public static TypeCode getEnum(String code) {
		for (final TypeCode x : values()) {
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
			Enum.valueOf(TypeCode.class, enumName);
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
		for (final TypeCode x : values()) {
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
