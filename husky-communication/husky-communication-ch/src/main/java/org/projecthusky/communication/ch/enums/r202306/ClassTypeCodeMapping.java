/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.communication.ch.enums.r202306;

import java.util.Objects;
import javax.annotation.processing.Generated;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.common.enums.CodeSystems;
import org.projecthusky.common.enums.LanguageCode;
import org.projecthusky.common.enums.ValueSetEnumInterface;

/**
 * Enumeration of DocumentEntry.classCode_DocumentEntry.typeCode_mapping values
 * <p>
 * EN: No designation found.<br>
 * DE: Das folgende Valueset zeigt das Mapping zwischen den Dokumentklassen und Dokumenttypen (gemäss Kapitel 2.11 Anhang 3 EPDV). Das Valueset dient als Hilfestellung bei der Implementierung. Für die konkreten Werte in documentTypeCode und documentClassCode dienen weiterhin die beiden definierten Valuesets ( &lt;span class="xforms-control xforms-select1 xforms-incremental xforms-select1-appearance-xxforms-tree xforms-visited" id="valueSetNavigation"&gt;&lt;span class="ygtvlabel node-sdraft xforms-tree-label-selected" id="ygtvlabelel10"&gt;EprDocumentTypeCode resp. &lt;/span&gt;&lt;/span&gt; &lt;span class="xforms-control xforms-select1 xforms-incremental xforms-select1-appearance-xxforms-tree xforms-visited" id="valueSetNavigation"&gt;&lt;span class="ygtvlabel node-sdraft xforms-tree-label-selected" id="ygtvlabelel10"&gt;EprDocumentClassCode)&lt;/span&gt;&lt;/span&gt; . &lt;br/&gt;.<br>
 * FR: No designation found.<br>
 * IT: No designation found.<br>
 * <p>
 * Identifier: 2.16.756.5.30.1.127.3.10.1.30<br>
 * Effective date: 2021-04-01 16:58<br>
 * Version: 202104.0-stable<br>
 * Status: DEPRECATED
 */
@Generated(value = "org.projecthusky.codegenerator.ch.valuesets.UpdateValueSets", date = "2024-07-02")
public enum ClassTypeCodeMapping implements ValueSetEnumInterface {

    /**
     * EN: Administrative documentation (record artifact).<br>
     */
    ADMINISTRATIVE_DOCUMENTATION_RECORD_ARTIFACT("405624007",
                                                 "2.16.840.1.113883.6.96",
                                                 "Administrative documentation (record artifact)",
                                                 "Administrative documentation (record artifact)",
                                                 "TOTRANSLATE",
                                                 "TOTRANSLATE",
                                                 "TOTRANSLATE"),
    /**
     * EN: Advance directive report (record artifact).<br>
     */
    ADVANCE_DIRECTIVE_REPORT_RECORD_ARTIFACT("371538006",
                                             "2.16.840.1.113883.6.96",
                                             "Advance directive report (record artifact)",
                                             "Advance directive report (record artifact)",
                                             "TOTRANSLATE",
                                             "TOTRANSLATE",
                                             "TOTRANSLATE"),
    /**
     * EN: Allergy record (record artifact).<br>
     */
    ALLERGY_RECORD_RECORD_ARTIFACT_L1("722446000",
                                      "2.16.840.1.113883.6.96",
                                      "Allergy record (record artifact)",
                                      "Allergy record (record artifact)",
                                      "TOTRANSLATE",
                                      "TOTRANSLATE",
                                      "TOTRANSLATE"),
    /**
     * EN: Audit trail report (record artifact).<br>
     */
    AUDIT_TRAIL_REPORT_RECORD_ARTIFACT("722160009",
                                       "2.16.840.1.113883.6.96",
                                       "Audit trail report (record artifact)",
                                       "Audit trail report (record artifact)",
                                       "TOTRANSLATE",
                                       "TOTRANSLATE",
                                       "TOTRANSLATE"),
    /**
     * EN: Care Plan (record artifact).<br>
     */
    CARE_PLAN_RECORD_ARTIFACT("734163000",
                              "2.16.840.1.113883.6.96",
                              "Care Plan (record artifact)",
                              "Care Plan (record artifact)",
                              "TOTRANSLATE",
                              "TOTRANSLATE",
                              "TOTRANSLATE"),
    /**
     * EN: Clinical consultation report (record artifact).<br>
     */
    CLINICAL_CONSULTATION_REPORT_RECORD_ARTIFACT_L1("371530004",
                                                    "2.16.840.1.113883.6.96",
                                                    "Clinical consultation report (record artifact)",
                                                    "Clinical consultation report (record artifact)",
                                                    "TOTRANSLATE",
                                                    "TOTRANSLATE",
                                                    "TOTRANSLATE"),
    /**
     * EN: Clinical Management plan (record artifact).<br>
     */
    CLINICAL_MANAGEMENT_PLAN_RECORD_ARTIFACT_L1("737427001",
                                                "2.16.840.1.113883.6.96",
                                                "Clinical Management plan (record artifact)",
                                                "Clinical Management plan (record artifact)",
                                                "TOTRANSLATE",
                                                "TOTRANSLATE",
                                                "TOTRANSLATE"),
    /**
     * EN: Clinical procedure report (record artifact).<br>
     */
    CLINICAL_PROCEDURE_REPORT_RECORD_ARTIFACT("371525003",
                                              "2.16.840.1.113883.6.96",
                                              "Clinical procedure report (record artifact)",
                                              "Clinical procedure report (record artifact)",
                                              "TOTRANSLATE",
                                              "TOTRANSLATE",
                                              "TOTRANSLATE"),
    /**
     * EN: Consent report (record artifact).<br>
     */
    CONSENT_REPORT_RECORD_ARTIFACT("371537001",
                                   "2.16.840.1.113883.6.96",
                                   "Consent report (record artifact)",
                                   "Consent report (record artifact)",
                                   "TOTRANSLATE",
                                   "TOTRANSLATE",
                                   "TOTRANSLATE"),
    /**
     * EN: Discharge summary (record artifact).<br>
     */
    DISCHARGE_SUMMARY_RECORD_ARTIFACT_L1("373942005",
                                         "2.16.840.1.113883.6.96",
                                         "Discharge summary (record artifact)",
                                         "Discharge summary (record artifact)",
                                         "TOTRANSLATE",
                                         "TOTRANSLATE",
                                         "TOTRANSLATE"),
    /**
     * EN: Emergency department record (record artifact).<br>
     */
    EMERGENCY_DEPARTMENT_RECORD_RECORD_ARTIFACT_L1("445300006",
                                                   "2.16.840.1.113883.6.96",
                                                   "Emergency department record (record artifact)",
                                                   "Emergency department record (record artifact)",
                                                   "TOTRANSLATE",
                                                   "TOTRANSLATE",
                                                   "TOTRANSLATE"),
    /**
     * EN: Emergency medical identification record (record artifact).<br>
     */
    EMERGENCY_MEDICAL_IDENTIFICATION_RECORD_RECORD_ARTIFACT("722216001",
                                                            "2.16.840.1.113883.6.96",
                                                            "Emergency medical identification record (record artifact)",
                                                            "Emergency medical identification record (record artifact)",
                                                            "TOTRANSLATE",
                                                            "TOTRANSLATE",
                                                            "TOTRANSLATE"),
    /**
     * EN: History and physical report (record artifact).<br>
     */
    HISTORY_AND_PHYSICAL_REPORT_RECORD_ARTIFACT_L1("371529009",
                                                   "2.16.840.1.113883.6.96",
                                                   "History and physical report (record artifact)",
                                                   "History and physical report (record artifact)",
                                                   "TOTRANSLATE",
                                                   "TOTRANSLATE",
                                                   "TOTRANSLATE"),
    /**
     * EN: Image reference (foundation metadata concept).<br>
     */
    IMAGE_REFERENCE_FOUNDATION_METADATA_CONCEPT_L1("900000000000471006",
                                                   "2.16.840.1.113883.6.96",
                                                   "Image reference (foundation metadata concept)",
                                                   "Image reference (foundation metadata concept)",
                                                   "TOTRANSLATE",
                                                   "TOTRANSLATE",
                                                   "TOTRANSLATE"),
    /**
     * EN: Imaging Order (record artifact).<br>
     */
    IMAGING_ORDER_RECORD_ARTIFACT_L1("2161000195103",
                                     "2.16.840.1.113883.6.96",
                                     "Imaging Order (record artifact)",
                                     "Imaging Order (record artifact)",
                                     "TOTRANSLATE",
                                     "TOTRANSLATE",
                                     "TOTRANSLATE"),
    /**
     * EN: Imaging report (record artifact).<br>
     */
    IMAGING_REPORT_RECORD_ARTIFACT_L1("4201000179104",
                                      "2.16.756.5.30.1.127.3.4",
                                      "Imaging report (record artifact)",
                                      "Imaging report (record artifact)",
                                      "TOTRANSLATE",
                                      "TOTRANSLATE",
                                      "TOTRANSLATE"),
    /**
     * EN: Immunization record (record artifact).<br>
     */
    IMMUNIZATION_RECORD_RECORD_ARTIFACT_L1("41000179103",
                                           "2.16.840.1.113883.6.96",
                                           "Immunization record (record artifact)",
                                           "Immunization record (record artifact)",
                                           "TOTRANSLATE",
                                           "TOTRANSLATE",
                                           "TOTRANSLATE"),
    /**
     * EN: Laboratory Order (record artifact).<br>
     */
    LABORATORY_ORDER_RECORD_ARTIFACT_L1("721965002",
                                        "2.16.840.1.113883.6.96",
                                        "Laboratory Order (record artifact)",
                                        "Laboratory Order (record artifact)",
                                        "TOTRANSLATE",
                                        "TOTRANSLATE",
                                        "TOTRANSLATE"),
    /**
     * EN: Laboratory report (record artifact).<br>
     */
    LABORATORY_REPORT_RECORD_ARTIFACT_L1("4241000179101",
                                         "2.16.840.1.113883.6.96",
                                         "Laboratory report (record artifact)",
                                         "Laboratory report (record artifact)",
                                         "TOTRANSLATE",
                                         "TOTRANSLATE",
                                         "TOTRANSLATE"),
    /**
     * EN: Medical certificate (record artifact).<br>
     */
    MEDICAL_CERTIFICATE_RECORD_ARTIFACT_L1("772786005",
                                           "2.16.840.1.113883.6.96",
                                           "Medical certificate (record artifact)",
                                           "Medical certificate (record artifact)",
                                           "TOTRANSLATE",
                                           "TOTRANSLATE",
                                           "TOTRANSLATE"),
    /**
     * EN: Medical Prescription record (record artifact).<br>
     */
    MEDICAL_PRESCRIPTION_RECORD_RECORD_ARTIFACT_L1("761938008",
                                                   "2.16.840.1.113883.6.96",
                                                   "Medical Prescription record (record artifact)",
                                                   "Medical Prescription record (record artifact)",
                                                   "TOTRANSLATE",
                                                   "TOTRANSLATE",
                                                   "TOTRANSLATE"),
    /**
     * EN: Medication summary document (record artifact).<br>
     */
    MEDICATION_SUMMARY_DOCUMENT_RECORD_ARTIFACT_L1("721912009",
                                                   "2.16.840.1.113883.6.96",
                                                   "Medication summary document (record artifact)",
                                                   "Medication summary document (record artifact)",
                                                   "TOTRANSLATE",
                                                   "TOTRANSLATE",
                                                   "TOTRANSLATE"),
    /**
     * EN: Non-drug prescription record (record artifact).<br>
     */
    NON_DRUG_PRESCRIPTION_RECORD_RECORD_ARTIFACT_L1("765492005",
                                                    "2.16.840.1.113883.6.96",
                                                    "Non-drug prescription record (record artifact)",
                                                    "Non-drug prescription record (record artifact)",
                                                    "TOTRANSLATE",
                                                    "TOTRANSLATE",
                                                    "TOTRANSLATE"),
    /**
     * EN: Nursing care plan (record artifact).<br>
     */
    NURSING_CARE_PLAN_RECORD_ARTIFACT_L1("773130005",
                                         "2.16.840.1.113883.6.96",
                                         "Nursing care plan (record artifact)",
                                         "Nursing care plan (record artifact)",
                                         "TOTRANSLATE",
                                         "TOTRANSLATE",
                                         "TOTRANSLATE"),
    /**
     * EN: Obstetrical Record (record artifact).<br>
     */
    OBSTETRICAL_RECORD_RECORD_ARTIFACT("2171000195109",
                                       "2.16.756.5.30.1.127.3.4",
                                       "Obstetrical Record (record artifact)",
                                       "Obstetrical Record (record artifact)",
                                       "TOTRANSLATE",
                                       "TOTRANSLATE",
                                       "TOTRANSLATE"),
    /**
     * EN: Operative report (record artifact).<br>
     */
    OPERATIVE_REPORT_RECORD_ARTIFACT_L1("371526002",
                                        "2.16.840.1.113883.6.96",
                                        "Operative report (record artifact)",
                                        "Operative report (record artifact)",
                                        "TOTRANSLATE",
                                        "TOTRANSLATE",
                                        "TOTRANSLATE"),
    /**
     * EN: Order (record artifact).<br>
     */
    ORDER_RECORD_ARTIFACT("721963009",
                          "2.16.840.1.113883.6.96",
                          "Order (record artifact)",
                          "Order (record artifact)",
                          "TOTRANSLATE",
                          "TOTRANSLATE",
                          "TOTRANSLATE"),
    /**
     * EN: Organ donor card (record artifact).<br>
     */
    ORGAN_DONOR_CARD_RECORD_ARTIFACT("772790007",
                                     "2.16.840.1.113883.6.96",
                                     "Organ donor card (record artifact)",
                                     "Organ donor card (record artifact)",
                                     "TOTRANSLATE",
                                     "TOTRANSLATE",
                                     "TOTRANSLATE"),
    /**
     * EN: Pathology order (record artifact.<br>
     */
    PATHOLOGY_ORDER_RECORD_ARTIFACT_L1("721966001",
                                       "2.16.840.1.113883.6.96",
                                       "Pathology order (record artifact",
                                       "Pathology order (record artifact",
                                       "TOTRANSLATE",
                                       "TOTRANSLATE",
                                       "TOTRANSLATE"),
    /**
     * EN: Pathology report (record artifact).<br>
     */
    PATHOLOGY_REPORT_RECORD_ARTIFACT_L1("371528001",
                                        "2.16.840.1.113883.6.96",
                                        "Pathology report (record artifact)",
                                        "Pathology report (record artifact)",
                                        "TOTRANSLATE",
                                        "TOTRANSLATE",
                                        "TOTRANSLATE"),
    /**
     * EN: Patient record type (record artifact).<br>
     */
    PATIENT_RECORD_TYPE_RECORD_ARTIFACT("184216000",
                                        "2.16.840.1.113883.6.96",
                                        "Patient record type (record artifact)",
                                        "Patient record type (record artifact)",
                                        "TOTRANSLATE",
                                        "TOTRANSLATE",
                                        "TOTRANSLATE"),
    /**
     * EN: Prescription record (record artifact).<br>
     */
    PRESCRIPTION_RECORD_RECORD_ARTIFACT("440545006",
                                        "2.16.840.1.113883.6.96",
                                        "Prescription record (record artifact)",
                                        "Prescription record (record artifact)",
                                        "TOTRANSLATE",
                                        "TOTRANSLATE",
                                        "TOTRANSLATE"),
    /**
     * EN: Professional allied to medicine clinical report (record artifact).<br>
     */
    PROFESSIONAL_ALLIED_TO_MEDICINE_CLINICAL_REPORT_RECORD_ARTIFACT_L1("445418005",
                                                                       "2.16.840.1.113883.6.96",
                                                                       "Professional allied to medicine clinical report (record artifact)",
                                                                       "Professional allied to medicine clinical report (record artifact)",
                                                                       "TOTRANSLATE",
                                                                       "TOTRANSLATE",
                                                                       "TOTRANSLATE"),
    /**
     * EN: Progress report (record artifact).<br>
     */
    PROGRESS_REPORT_RECORD_ARTIFACT_L1("371532007",
                                       "2.16.840.1.113883.6.96",
                                       "Progress report (record artifact)",
                                       "Progress report (record artifact)",
                                       "TOTRANSLATE",
                                       "TOTRANSLATE",
                                       "TOTRANSLATE"),
    /**
     * EN: Record artifact (record artifact).<br>
     */
    RECORD_ARTIFACT_RECORD_ARTIFACT("419891008",
                                    "2.16.840.1.113883.6.96",
                                    "Record artifact (record artifact)",
                                    "Record artifact (record artifact)",
                                    "TOTRANSLATE",
                                    "TOTRANSLATE",
                                    "TOTRANSLATE"),
    /**
     * EN: Record artifact (record artifact).<br>
     */
    RECORD_ARTIFACT_RECORD_ARTIFACT_L1("419891008",
                                       "2.16.840.1.113883.6.96",
                                       "Record artifact (record artifact)",
                                       "Record artifact (record artifact)",
                                       "TOTRANSLATE",
                                       "TOTRANSLATE",
                                       "TOTRANSLATE"),
    /**
     * EN: Record of health event (record artifact).<br>
     */
    RECORD_OF_HEALTH_EVENT_RECORD_ARTIFACT("417319006",
                                           "2.16.840.1.113883.6.96",
                                           "Record of health event (record artifact)",
                                           "Record of health event (record artifact)",
                                           "TOTRANSLATE",
                                           "TOTRANSLATE",
                                           "TOTRANSLATE"),
    /**
     * EN: Referral note (record artifact).<br>
     */
    REFERRAL_NOTE_RECORD_ARTIFACT("721927009",
                                  "2.16.840.1.113883.6.96",
                                  "Referral note (record artifact)",
                                  "Referral note (record artifact)",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE",
                                  "TOTRANSLATE"),
    /**
     * EN: Rehabilitation care plan (record artifact).<br>
     */
    REHABILITATION_CARE_PLAN_RECORD_ARTIFACT_L1("736055001",
                                                "2.16.840.1.113883.6.96",
                                                "Rehabilitation care plan (record artifact)",
                                                "Rehabilitation care plan (record artifact)",
                                                "TOTRANSLATE",
                                                "TOTRANSLATE",
                                                "TOTRANSLATE"),
    /**
     * EN: Report of clinical encounter (record artifact).<br>
     */
    REPORT_OF_CLINICAL_ENCOUNTER_RECORD_ARTIFACT("371531000",
                                                 "2.16.840.1.113883.6.96",
                                                 "Report of clinical encounter (record artifact)",
                                                 "Report of clinical encounter (record artifact)",
                                                 "TOTRANSLATE",
                                                 "TOTRANSLATE",
                                                 "TOTRANSLATE"),
    /**
     * EN: Summary clinical document (record artifact).<br>
     */
    SUMMARY_CLINICAL_DOCUMENT_RECORD_ARTIFACT("422735006",
                                              "2.16.840.1.113883.6.96",
                                              "Summary clinical document (record artifact)",
                                              "Summary clinical document (record artifact)",
                                              "TOTRANSLATE",
                                              "TOTRANSLATE",
                                              "TOTRANSLATE"),
    /**
     * EN: Transfer summary report (record artifact).<br>
     */
    TRANSFER_SUMMARY_REPORT_RECORD_ARTIFACT_L1("371535009",
                                               "2.16.840.1.113883.6.96",
                                               "Transfer summary report (record artifact)",
                                               "Transfer summary report (record artifact)",
                                               "TOTRANSLATE",
                                               "TOTRANSLATE",
                                               "TOTRANSLATE");

    /**
     * EN: Code for Administrative documentation (record artifact).<br>
     */
    public static final String ADMINISTRATIVE_DOCUMENTATION_RECORD_ARTIFACT_CODE = "405624007";

    /**
     * EN: Code for Advance directive report (record artifact).<br>
     */
    public static final String ADVANCE_DIRECTIVE_REPORT_RECORD_ARTIFACT_CODE = "371538006";

    /**
     * EN: Code for Allergy record (record artifact).<br>
     */
    public static final String ALLERGY_RECORD_RECORD_ARTIFACT_L1_CODE = "722446000";

    /**
     * EN: Code for Audit trail report (record artifact).<br>
     */
    public static final String AUDIT_TRAIL_REPORT_RECORD_ARTIFACT_CODE = "722160009";

    /**
     * EN: Code for Care Plan (record artifact).<br>
     */
    public static final String CARE_PLAN_RECORD_ARTIFACT_CODE = "734163000";

    /**
     * EN: Code for Clinical consultation report (record artifact).<br>
     */
    public static final String CLINICAL_CONSULTATION_REPORT_RECORD_ARTIFACT_L1_CODE = "371530004";

    /**
     * EN: Code for Clinical Management plan (record artifact).<br>
     */
    public static final String CLINICAL_MANAGEMENT_PLAN_RECORD_ARTIFACT_L1_CODE = "737427001";

    /**
     * EN: Code for Clinical procedure report (record artifact).<br>
     */
    public static final String CLINICAL_PROCEDURE_REPORT_RECORD_ARTIFACT_CODE = "371525003";

    /**
     * EN: Code for Consent report (record artifact).<br>
     */
    public static final String CONSENT_REPORT_RECORD_ARTIFACT_CODE = "371537001";

    /**
     * EN: Code for Discharge summary (record artifact).<br>
     */
    public static final String DISCHARGE_SUMMARY_RECORD_ARTIFACT_L1_CODE = "373942005";

    /**
     * EN: Code for Emergency department record (record artifact).<br>
     */
    public static final String EMERGENCY_DEPARTMENT_RECORD_RECORD_ARTIFACT_L1_CODE = "445300006";

    /**
     * EN: Code for Emergency medical identification record (record artifact).<br>
     */
    public static final String EMERGENCY_MEDICAL_IDENTIFICATION_RECORD_RECORD_ARTIFACT_CODE = "722216001";

    /**
     * EN: Code for History and physical report (record artifact).<br>
     */
    public static final String HISTORY_AND_PHYSICAL_REPORT_RECORD_ARTIFACT_L1_CODE = "371529009";

    /**
     * EN: Code for Image reference (foundation metadata concept).<br>
     */
    public static final String IMAGE_REFERENCE_FOUNDATION_METADATA_CONCEPT_L1_CODE = "900000000000471006";

    /**
     * EN: Code for Imaging Order (record artifact).<br>
     */
    public static final String IMAGING_ORDER_RECORD_ARTIFACT_L1_CODE = "2161000195103";

    /**
     * EN: Code for Imaging report (record artifact).<br>
     */
    public static final String IMAGING_REPORT_RECORD_ARTIFACT_L1_CODE = "4201000179104";

    /**
     * EN: Code for Immunization record (record artifact).<br>
     */
    public static final String IMMUNIZATION_RECORD_RECORD_ARTIFACT_L1_CODE = "41000179103";

    /**
     * EN: Code for Laboratory Order (record artifact).<br>
     */
    public static final String LABORATORY_ORDER_RECORD_ARTIFACT_L1_CODE = "721965002";

    /**
     * EN: Code for Laboratory report (record artifact).<br>
     */
    public static final String LABORATORY_REPORT_RECORD_ARTIFACT_L1_CODE = "4241000179101";

    /**
     * EN: Code for Medical certificate (record artifact).<br>
     */
    public static final String MEDICAL_CERTIFICATE_RECORD_ARTIFACT_L1_CODE = "772786005";

    /**
     * EN: Code for Medical Prescription record (record artifact).<br>
     */
    public static final String MEDICAL_PRESCRIPTION_RECORD_RECORD_ARTIFACT_L1_CODE = "761938008";

    /**
     * EN: Code for Medication summary document (record artifact).<br>
     */
    public static final String MEDICATION_SUMMARY_DOCUMENT_RECORD_ARTIFACT_L1_CODE = "721912009";

    /**
     * EN: Code for Non-drug prescription record (record artifact).<br>
     */
    public static final String NON_DRUG_PRESCRIPTION_RECORD_RECORD_ARTIFACT_L1_CODE = "765492005";

    /**
     * EN: Code for Nursing care plan (record artifact).<br>
     */
    public static final String NURSING_CARE_PLAN_RECORD_ARTIFACT_L1_CODE = "773130005";

    /**
     * EN: Code for Obstetrical Record (record artifact).<br>
     */
    public static final String OBSTETRICAL_RECORD_RECORD_ARTIFACT_CODE = "2171000195109";

    /**
     * EN: Code for Operative report (record artifact).<br>
     */
    public static final String OPERATIVE_REPORT_RECORD_ARTIFACT_L1_CODE = "371526002";

    /**
     * EN: Code for Order (record artifact).<br>
     */
    public static final String ORDER_RECORD_ARTIFACT_CODE = "721963009";

    /**
     * EN: Code for Organ donor card (record artifact).<br>
     */
    public static final String ORGAN_DONOR_CARD_RECORD_ARTIFACT_CODE = "772790007";

    /**
     * EN: Code for Pathology order (record artifact.<br>
     */
    public static final String PATHOLOGY_ORDER_RECORD_ARTIFACT_L1_CODE = "721966001";

    /**
     * EN: Code for Pathology report (record artifact).<br>
     */
    public static final String PATHOLOGY_REPORT_RECORD_ARTIFACT_L1_CODE = "371528001";

    /**
     * EN: Code for Patient record type (record artifact).<br>
     */
    public static final String PATIENT_RECORD_TYPE_RECORD_ARTIFACT_CODE = "184216000";

    /**
     * EN: Code for Prescription record (record artifact).<br>
     */
    public static final String PRESCRIPTION_RECORD_RECORD_ARTIFACT_CODE = "440545006";

    /**
     * EN: Code for Professional allied to medicine clinical report (record artifact).<br>
     */
    public static final String PROFESSIONAL_ALLIED_TO_MEDICINE_CLINICAL_REPORT_RECORD_ARTIFACT_L1_CODE = "445418005";

    /**
     * EN: Code for Progress report (record artifact).<br>
     */
    public static final String PROGRESS_REPORT_RECORD_ARTIFACT_L1_CODE = "371532007";

    /**
     * EN: Code for Record artifact (record artifact).<br>
     */
    public static final String RECORD_ARTIFACT_RECORD_ARTIFACT_CODE = "419891008";

    /**
     * EN: Code for Record artifact (record artifact).<br>
     */
    public static final String RECORD_ARTIFACT_RECORD_ARTIFACT_L1_CODE = "419891008";

    /**
     * EN: Code for Record of health event (record artifact).<br>
     */
    public static final String RECORD_OF_HEALTH_EVENT_RECORD_ARTIFACT_CODE = "417319006";

    /**
     * EN: Code for Referral note (record artifact).<br>
     */
    public static final String REFERRAL_NOTE_RECORD_ARTIFACT_CODE = "721927009";

    /**
     * EN: Code for Rehabilitation care plan (record artifact).<br>
     */
    public static final String REHABILITATION_CARE_PLAN_RECORD_ARTIFACT_L1_CODE = "736055001";

    /**
     * EN: Code for Report of clinical encounter (record artifact).<br>
     */
    public static final String REPORT_OF_CLINICAL_ENCOUNTER_RECORD_ARTIFACT_CODE = "371531000";

    /**
     * EN: Code for Summary clinical document (record artifact).<br>
     */
    public static final String SUMMARY_CLINICAL_DOCUMENT_RECORD_ARTIFACT_CODE = "422735006";

    /**
     * EN: Code for Transfer summary report (record artifact).<br>
     */
    public static final String TRANSFER_SUMMARY_REPORT_RECORD_ARTIFACT_L1_CODE = "371535009";

    /**
     * Identifier of the value set.
     */
    public static final String VALUE_SET_ID = "2.16.756.5.30.1.127.3.10.1.30";

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "DocumentEntry.classCode_DocumentEntry.typeCode_mapping";

    /**
     * Gets the Enum with a given code.
     *
     * @param code The code value.
     * @return the enum value found or {@code null}.
     */
    @Nullable
    public static ClassTypeCodeMapping getEnum(@Nullable final String code) {
        for (final ClassTypeCodeMapping x : values()) {
            if (x.getCodeValue().equals(code)) {
                return x;
            }
        }
        return null;
    }

    /**
     * Checks if a given enum is part of this value set.
     *
     * @param enumName The name of the enum.
     * @return {@code true} if the name is found in this value set, {@code false} otherwise.
     */
    public static boolean isEnumOfValueSet(@Nullable final String enumName) {
        if (enumName == null) {
            return false;
        }
        try {
            Enum.valueOf(ClassTypeCodeMapping.class,
                         enumName);
            return true;
        } catch (final IllegalArgumentException ex) {
            return false;
        }
    }

    /**
     * Checks if a given code value is in this value set.
     *
     * @param codeValue The code value.
     * @return {@code true} if the value is found in this value set, {@code false} otherwise.
     */
    public static boolean isInValueSet(@Nullable final String codeValue) {
        for (final ClassTypeCodeMapping x : values()) {
            if (x.getCodeValue().equals(codeValue)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Machine interpretable and (inside this class) unique code.
     */
    @NonNull
    private final String code;

    /**
     * Identifier of the referencing code system.
     */
    @NonNull
    private final String codeSystem;

    /**
     * The display names per language. It's always stored in the given order: default display name (0), in English (1),
     * in German (2), in French (3) and in Italian (4).
     */
    @NonNull
    private final String[] displayNames;

    /**
     * Instantiates this enum with a given code and display names.
     *
     * @param code          The code value.
     * @param codeSystem    The code system (OID).
     * @param displayName   The default display name.
     * @param displayNameEn The display name in English.
     * @param displayNameDe The display name in German.
     * @param displayNameFr The display name in French.
     * @param displayNameIt The display name in Italian.
     */
    ClassTypeCodeMapping(@NonNull final String code, @NonNull final String codeSystem, @NonNull final String displayName, @NonNull final String displayNameEn, @NonNull final String displayNameDe, @NonNull final String displayNameFr, @NonNull final String displayNameIt) {
        this.code = Objects.requireNonNull(code);
        this.codeSystem = Objects.requireNonNull(codeSystem);
        this.displayNames = new String[5];
        this.displayNames[0] = Objects.requireNonNull(displayName);
        this.displayNames[1] = Objects.requireNonNull(displayNameEn);
        this.displayNames[2] = Objects.requireNonNull(displayNameDe);
        this.displayNames[3] = Objects.requireNonNull(displayNameFr);
        this.displayNames[4] = Objects.requireNonNull(displayNameIt);
    }

    /**
     * Gets the code system identifier.
     *
     * @return the code system identifier.
     */
    @Override
    @NonNull
    public String getCodeSystemId() {
        return this.codeSystem;
    }

    /**
     * Gets the code system name.
     *
     * @return the code system name.
     */
    @Override
    @NonNull
    public String getCodeSystemName() {
        final var codeSystem = CodeSystems.getEnum(this.codeSystem);
        if (codeSystem != null) {
            return codeSystem.getCodeSystemName();
        }
        return "";
    }

    /**
     * Gets the code value as a string.
     *
     * @return the code value.
     */
    @Override
    @NonNull
    public String getCodeValue() {
        return this.code;
    }

    /**
     * Gets the display name defined by the language param.
     *
     * @param languageCode The language code to get the display name for, {@code null} to get the default display name.
     * @return the display name in the desired language.
     */
    @Override
    @NonNull
    public String getDisplayName(@Nullable final LanguageCode languageCode) {
        if (languageCode == null) {
            return this.displayNames[0];
        }
        return switch(languageCode) {
            case ENGLISH ->
                this.displayNames[1];
            case GERMAN ->
                this.displayNames[2];
            case FRENCH ->
                this.displayNames[3];
            case ITALIAN ->
                this.displayNames[4];
            default ->
                "TOTRANSLATE";
        };
    }

    /**
     * Gets the value set identifier.
     *
     * @return the value set identifier.
     */
    @Override
    @NonNull
    public String getValueSetId() {
        return VALUE_SET_ID;
    }

    /**
     * Gets the value set name.
     *
     * @return the value set name.
     */
    @Override
    @NonNull
    public String getValueSetName() {
        return VALUE_SET_NAME;
    }
}
