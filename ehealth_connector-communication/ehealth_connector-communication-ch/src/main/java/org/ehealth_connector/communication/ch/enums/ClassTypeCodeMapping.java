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
 * <div class="de">Das folgende Valueset zeigt das Mapping zwischen den Dokumentklassen und Dokumenttypen (gemäss Kapitel 2.11 Anhang 3 EPDV). Das Valueset dient als Hilfestellung bei der Implementierung. Für die konkreten Werte in documentTypeCode und documentClassCode dienen weiterhin die beiden definierten Valuesets (<span class="xforms-control xforms-select1 xforms-incremental xforms-select1-appearance-xxforms-tree xforms-visited" id="valueSetNavigation"> <span class="ygtvlabel node-sdraft xforms-tree-label-selected" id="ygtvlabelel10">EprDocumentTypeCode resp. </span></span><span class="xforms-control xforms-select1 xforms-incremental xforms-select1-appearance-xxforms-tree xforms-visited" id="valueSetNavigation"> <span class="ygtvlabel node-sdraft xforms-tree-label-selected" id="ygtvlabelel10">EprDocumentClassCode)</span></span>. <br clear="none"/></div>
 * <div class="fr">no designation found for language FRENCH</div>
 * <div class="it">no designation found for language ITALIAN</div>
 * <!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets", date = "2021-03-04")
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
	 * <div class="en">Allergy record (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	ALLERGY_RECORD_RECORD_ARTIFACT_L1("722446000", "2.16.840.1.113883.6.96",
			"Allergy record (record artifact)", "Allergy record (record artifact)", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
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
	 * <div class="en">Clinical consultation report (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	CLINICAL_CONSULTATION_REPORT_RECORD_ARTIFACT_L1("371530004", "2.16.840.1.113883.6.96",
			"Clinical consultation report (record artifact)",
			"Clinical consultation report (record artifact)", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Clinical Management plan (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	CLINICAL_MANAGEMENT_PLAN_RECORD_ARTIFACT_L1("737427001", "2.16.840.1.113883.6.96",
			"Clinical Management plan (record artifact)",
			"Clinical Management plan (record artifact)", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
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
	 * <div class="en">Discharge summary (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	DISCHARGE_SUMMARY_RECORD_ARTIFACT_L1("373942005", "2.16.840.1.113883.6.96",
			"Discharge summary (record artifact)", "Discharge summary (record artifact)",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Emergency department record (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	EMERGENCY_DEPARTMENT_RECORD_RECORD_ARTIFACT_L1("445300006", "2.16.840.1.113883.6.96",
			"Emergency department record (record artifact)",
			"Emergency department record (record artifact)", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
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
	 * <div class="en">History and physical report (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	HISTORY_AND_PHYSICAL_REPORT_RECORD_ARTIFACT_L1("371529009", "2.16.840.1.113883.6.96",
			"History and physical report (record artifact)",
			"History and physical report (record artifact)", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Image reference (foundation metadata concept)</div>
	 * <!-- @formatter:on -->
	 */
	IMAGE_REFERENCE_FOUNDATION_METADATA_CONCEPT_L1("900000000000471006", "2.16.840.1.113883.6.96",
			"Image reference (foundation metadata concept)",
			"Image reference (foundation metadata concept)", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Imaging Order (record articact)</div>
	 * <!-- @formatter:on -->
	 */
	IMAGING_ORDER_RECORD_ARTICACT_L1("2161000195103", "2.16.840.1.113883.6.96",
			"Imaging Order (record articact)", "Imaging Order (record articact)", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Imaging report (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	IMAGING_REPORT_RECORD_ARTIFACT_L1("4201000179104", "2.16.756.5.30.1.127.3.4",
			"Imaging report (record artifact)", "Imaging report (record artifact)", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Immunization record (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	IMMUNIZATION_RECORD_RECORD_ARTIFACT_L1("41000179103", "2.16.840.1.113883.6.96",
			"Immunization record (record artifact)", "Immunization record (record artifact)",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Laboratory Order (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	LABORATORY_ORDER_RECORD_ARTIFACT_L1("721965002", "2.16.840.1.113883.6.96",
			"Laboratory Order (record artifact)", "Laboratory Order (record artifact)",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Laboratory report (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	LABORATORY_REPORT_RECORD_ARTIFACT_L1("4241000179101", "2.16.840.1.113883.6.96",
			"Laboratory report (record artifact)", "Laboratory report (record artifact)",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Medical certificate (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	MEDICAL_CERTIFICATE_RECORD_ARTIFACT_L1("772786005", "2.16.840.1.113883.6.96",
			"Medical certificate (record artifact)", "Medical certificate (record artifact)",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Medical Prescription record (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	MEDICAL_PRESCRIPTION_RECORD_RECORD_ARTIFACT_L1("761938008", "2.16.840.1.113883.6.96",
			"Medical Prescription record (record artifact)",
			"Medical Prescription record (record artifact)", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Medication summary document (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	MEDICATION_SUMMARY_DOCUMENT_RECORD_ARTIFACT_L1("721912009", "2.16.840.1.113883.6.96",
			"Medication summary document (record artifact)",
			"Medication summary document (record artifact)", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Non-drug prescription record (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	NON_DRUG_PRESCRIPTION_RECORD_RECORD_ARTIFACT_L1("765492005", "2.16.840.1.113883.6.96",
			"Non-drug prescription record (record artifact)",
			"Non-drug prescription record (record artifact)", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Nursing care plan (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	NURSING_CARE_PLAN_RECORD_ARTIFACT_L1("773130005", "2.16.840.1.113883.6.96",
			"Nursing care plan (record artifact)", "Nursing care plan (record artifact)",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
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
	 * <div class="en">Operative report (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	OPERATIVE_REPORT_RECORD_ARTIFACT_L1("371526002", "2.16.840.1.113883.6.96",
			"Operative report (record artifact)", "Operative report (record artifact)",
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
	 * <div class="en">Pathology order (record artifact</div>
	 * <!-- @formatter:on -->
	 */
	PATHOLOGY_ORDER_RECORD_ARTIFACT_L1("721966001", "2.16.840.1.113883.6.96",
			"Pathology order (record artifact", "Pathology order (record artifact", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Pathology report (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	PATHOLOGY_REPORT_RECORD_ARTIFACT_L1("371528001", "2.16.840.1.113883.6.96",
			"Pathology report (record artifact)", "Pathology report (record artifact)",
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
	 * <div class="en">Professional allied to medicine clinical report (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	PROFESSIONAL_ALLIED_TO_MEDICINE_CLINICAL_REPORT_RECORD_ARTIFACT_L1("445418005",
			"2.16.840.1.113883.6.96",
			"Professional allied to medicine clinical report (record artifact)",
			"Professional allied to medicine clinical report (record artifact)", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Progress report (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	PROGRESS_REPORT_RECORD_ARTIFACT_L1("371532007", "2.16.840.1.113883.6.96",
			"Progress report (record artifact)", "Progress report (record artifact)", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
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
	 * <div class="en">Record artifact (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	RECORD_ARTIFACT_RECORD_ARTIFACT_L1("419891008", "2.16.840.1.113883.6.96",
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
	 * <div class="en">Rehabilitation care plan (record articact)</div>
	 * <!-- @formatter:on -->
	 */
	REHABILITATION_CARE_PLAN_RECORD_ARTICACT_L1("736055001", "2.16.840.1.113883.6.96",
			"Rehabilitation care plan (record articact)",
			"Rehabilitation care plan (record articact)", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
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
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Transfer summary report (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	TRANSFER_SUMMARY_REPORT_RECORD_ARTIFACT_L1("371535009", "2.16.840.1.113883.6.96",
			"Transfer summary report (record artifact)",
			"Transfer summary report (record artifact)", "TOTRANSLATE", "TOTRANSLATE",
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
	 * <div class="en">Code for Allergy record (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ALLERGY_RECORD_RECORD_ARTIFACT_L1_CODE = "722446000";

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
	 * <div class="en">Code for Clinical consultation report (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CLINICAL_CONSULTATION_REPORT_RECORD_ARTIFACT_L1_CODE = "371530004";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Clinical Management plan (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CLINICAL_MANAGEMENT_PLAN_RECORD_ARTIFACT_L1_CODE = "737427001";

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
	 * <div class="en">Code for Discharge summary (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DISCHARGE_SUMMARY_RECORD_ARTIFACT_L1_CODE = "373942005";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Emergency department record (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EMERGENCY_DEPARTMENT_RECORD_RECORD_ARTIFACT_L1_CODE = "445300006";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Emergency medical identification record (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EMERGENCY_MEDICAL_IDENTIFICATION_RECORD_RECORD_ARTIFACT_CODE = "722216001";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for History and physical report (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HISTORY_AND_PHYSICAL_REPORT_RECORD_ARTIFACT_L1_CODE = "371529009";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Image reference (foundation metadata concept)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IMAGE_REFERENCE_FOUNDATION_METADATA_CONCEPT_L1_CODE = "900000000000471006";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Imaging Order (record articact)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IMAGING_ORDER_RECORD_ARTICACT_L1_CODE = "2161000195103";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Imaging report (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IMAGING_REPORT_RECORD_ARTIFACT_L1_CODE = "4201000179104";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Immunization record (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IMMUNIZATION_RECORD_RECORD_ARTIFACT_L1_CODE = "41000179103";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Laboratory Order (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String LABORATORY_ORDER_RECORD_ARTIFACT_L1_CODE = "721965002";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Laboratory report (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String LABORATORY_REPORT_RECORD_ARTIFACT_L1_CODE = "4241000179101";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Medical certificate (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MEDICAL_CERTIFICATE_RECORD_ARTIFACT_L1_CODE = "772786005";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Medical Prescription record (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MEDICAL_PRESCRIPTION_RECORD_RECORD_ARTIFACT_L1_CODE = "761938008";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Medication summary document (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MEDICATION_SUMMARY_DOCUMENT_RECORD_ARTIFACT_L1_CODE = "721912009";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Non-drug prescription record (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NON_DRUG_PRESCRIPTION_RECORD_RECORD_ARTIFACT_L1_CODE = "765492005";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Nursing care plan (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NURSING_CARE_PLAN_RECORD_ARTIFACT_L1_CODE = "773130005";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Obstetrical Record (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OBSTETRICAL_RECORD_RECORD_ARTIFACT_CODE = "2171000195109";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Operative report (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OPERATIVE_REPORT_RECORD_ARTIFACT_L1_CODE = "371526002";

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
	 * <div class="en">Code for Pathology order (record artifact</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PATHOLOGY_ORDER_RECORD_ARTIFACT_L1_CODE = "721966001";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Pathology report (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PATHOLOGY_REPORT_RECORD_ARTIFACT_L1_CODE = "371528001";

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
	 * <div class="en">Code for Professional allied to medicine clinical report (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PROFESSIONAL_ALLIED_TO_MEDICINE_CLINICAL_REPORT_RECORD_ARTIFACT_L1_CODE = "445418005";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Progress report (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PROGRESS_REPORT_RECORD_ARTIFACT_L1_CODE = "371532007";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Record artifact (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RECORD_ARTIFACT_RECORD_ARTIFACT_CODE = "419891008";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Record artifact (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RECORD_ARTIFACT_RECORD_ARTIFACT_L1_CODE = "419891008";

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
	 * <div class="en">Code for Rehabilitation care plan (record articact)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String REHABILITATION_CARE_PLAN_RECORD_ARTICACT_L1_CODE = "736055001";

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
	 * <div class="en">Code for Transfer summary report (record artifact)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TRANSFER_SUMMARY_REPORT_RECORD_ARTIFACT_L1_CODE = "371535009";

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
	public static ClassTypeCodeMapping getEnum(final String code) {
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
	public static boolean isEnumOfValueSet(final String enumName) {
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
	public static boolean isInValueSet(final String codeValue) {
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
	ClassTypeCodeMapping(final String code, final String codeSystem, final String displayName,
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
