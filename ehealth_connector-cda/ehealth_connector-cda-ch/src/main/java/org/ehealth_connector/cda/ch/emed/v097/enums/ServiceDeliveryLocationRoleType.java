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
package org.ehealth_connector.cda.ch.emed.v097.enums;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.processing.Generated;

import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.mdht.enums.ValueSetEnumInterface;

/**
 * <!-- @formatter:off -->
 * Enumeration of ServiceDeliveryLocationRoleType values
 *
 * <div class="en"><p> <b>History description 2014-03-26: </b>Lock all vaue sets untouched since 2014-03-26 to trackingId 2014T1_2014_03_26</p><b>description: </b><p>A role of a place that further classifies the setting (e.g., accident site, road side, work site, community location) in which services are delivered.</p></div>
 * <div class="de">no designation found for language GERMAN</div>
 * <div class="fr">no designation found for language FRENCH</div>
 * <div class="it">no designation found for language ITALIAN</div>
 *
 * Identifier: 2.16.840.1.113883.1.11.17660
 * Effective date: 2014-03-26 00:00
 * Version: DEFN=UV=VO=1360-20160323
 * Status: FINAL
 * <!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets", date = "2021-03-05")
public enum ServiceDeliveryLocationRoleType implements ValueSetEnumInterface {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">accident site</div>
	 * <!-- @formatter:on -->
	 */
	ACCIDENT_SITE_L2("ACC", "2.16.840.1.113883.5.111", "accident site", "accident site",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">addiction treatment center</div>
	 * <!-- @formatter:on -->
	 */
	ADDICTION_TREATMENT_CENTER_L5("RHAT", "2.16.840.1.113883.5.111", "addiction treatment center",
			"addiction treatment center", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Allergy clinic</div>
	 * <!-- @formatter:on -->
	 */
	ALLERGY_CLINIC_L4("ALL", "2.16.840.1.113883.5.111", "Allergy clinic", "Allergy clinic",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Ambulance</div>
	 * <!-- @formatter:on -->
	 */
	AMBULANCE_L4("AMB", "2.16.840.1.113883.5.111", "Ambulance", "Ambulance", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Ambulatory Health Care Facilities; Clinic/Center; Rehabilitation: Cardiac Facilities Cardiology clinic</div>
	 * <!-- @formatter:on -->
	 */
	AMBULATORY_HEALTH_CARE_FACILITIES_CLINIC_CENTER_REHABILITATION_CARDIAC_FACILITIES_CARDIOLOGY_CLINIC_L4(
			"CARD", "2.16.840.1.113883.5.111",
			"Ambulatory Health Care Facilities; Clinic/Center; Rehabilitation: Cardiac Facilities Cardiology clinic",
			"Ambulatory Health Care Facilities; Clinic/Center; Rehabilitation: Cardiac Facilities Cardiology clinic",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Amputee clinic</div>
	 * <!-- @formatter:on -->
	 */
	AMPUTEE_CLINIC_L4("AMPUT", "2.16.840.1.113883.5.111", "Amputee clinic", "Amputee clinic",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Bone marrow transplant clinic</div>
	 * <!-- @formatter:on -->
	 */
	BONE_MARROW_TRANSPLANT_CLINIC_L4("BMTC", "2.16.840.1.113883.5.111",
			"Bone marrow transplant clinic", "Bone marrow transplant clinic", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Bone marrow transplant unit</div>
	 * <!-- @formatter:on -->
	 */
	BONE_MARROW_TRANSPLANT_UNIT_L4("BMTU", "2.16.840.1.113883.5.111", "Bone marrow transplant unit",
			"Bone marrow transplant unit", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Breast clinic</div>
	 * <!-- @formatter:on -->
	 */
	BREAST_CLINIC_L4("BREAST", "2.16.840.1.113883.5.111", "Breast clinic", "Breast clinic",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Cardiac catheterization lab</div>
	 * <!-- @formatter:on -->
	 */
	CARDIAC_CATHETERIZATION_LAB_L5("CATH", "2.16.840.1.113883.5.111", "Cardiac catheterization lab",
			"Cardiac catheterization lab", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Cardiovascular diagnostics or therapeutics unit</div>
	 * <!-- @formatter:on -->
	 */
	CARDIOVASCULAR_DIAGNOSTICS_OR_THERAPEUTICS_UNIT_L4("CVDX", "2.16.840.1.113883.5.111",
			"Cardiovascular diagnostics or therapeutics unit",
			"Cardiovascular diagnostics or therapeutics unit", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Chest unit</div>
	 * <!-- @formatter:on -->
	 */
	CHEST_UNIT_L4("CHEST", "2.16.840.1.113883.5.111", "Chest unit", "Chest unit", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Child and adolescent neurology clinic</div>
	 * <!-- @formatter:on -->
	 */
	CHILD_AND_ADOLESCENT_NEUROLOGY_CLINIC_L4("CANC", "2.16.840.1.113883.5.111",
			"Child and adolescent neurology clinic", "Child and adolescent neurology clinic",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Child and adolescent psychiatry clinic</div>
	 * <!-- @formatter:on -->
	 */
	CHILD_AND_ADOLESCENT_PSYCHIATRY_CLINIC_L4("CAPC", "2.16.840.1.113883.5.111",
			"Child and adolescent psychiatry clinic", "Child and adolescent psychiatry clinic",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Chronic Care Facility Hospitals; Chronic Disease Hospital</div>
	 * <!-- @formatter:on -->
	 */
	CHRONIC_CARE_FACILITY_HOSPITALS_CHRONIC_DISEASE_HOSPITAL_L4("CHR", "2.16.840.1.113883.5.111",
			"Chronic Care Facility Hospitals; Chronic Disease Hospital",
			"Chronic Care Facility Hospitals; Chronic Disease Hospital", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Coagulation clinic</div>
	 * <!-- @formatter:on -->
	 */
	COAGULATION_CLINIC_L4("COAG", "2.16.840.1.113883.5.111", "Coagulation clinic",
			"Coagulation clinic", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Colon and rectal surgery clinic</div>
	 * <!-- @formatter:on -->
	 */
	COLON_AND_RECTAL_SURGERY_CLINIC_L4("CRS", "2.16.840.1.113883.5.111",
			"Colon and rectal surgery clinic", "Colon and rectal surgery clinic", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Community Location</div>
	 * <!-- @formatter:on -->
	 */
	COMMUNITY_LOCATION_L2("COMM", "2.16.840.1.113883.5.111", "Community Location",
			"Community Location", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">community service center</div>
	 * <!-- @formatter:on -->
	 */
	COMMUNITY_SERVICE_CENTER_L3("CSC", "2.16.840.1.113883.5.111", "community service center",
			"community service center", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Coronary care unit</div>
	 * <!-- @formatter:on -->
	 */
	CORONARY_CARE_UNIT_L4("CCU", "2.16.840.1.113883.5.111", "Coronary care unit",
			"Coronary care unit", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">DedicatedClinicalLocationRoleType</div>
	 * <!-- @formatter:on -->
	 */
	DEDICATEDCLINICALLOCATIONROLETYPE_L2("_DedicatedClinicalLocationRoleType",
			"2.16.840.1.113883.5.111", "DedicatedClinicalLocationRoleType",
			"DedicatedClinicalLocationRoleType", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">DedicatedNonClinicalLocationRoleType</div>
	 * <!-- @formatter:on -->
	 */
	DEDICATEDNONCLINICALLOCATIONROLETYPE_L2("_DedicatedNonClinicalLocationRoleType",
			"2.16.840.1.113883.5.111", "DedicatedNonClinicalLocationRoleType",
			"DedicatedNonClinicalLocationRoleType", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">DedicatedServiceDeliveryLocationRoleType</div>
	 * <!-- @formatter:on -->
	 */
	DEDICATEDSERVICEDELIVERYLOCATIONROLETYPE_L1("_DedicatedServiceDeliveryLocationRoleType",
			"2.16.840.1.113883.5.111", "DedicatedServiceDeliveryLocationRoleType",
			"DedicatedServiceDeliveryLocationRoleType", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Delivery Address</div>
	 * <!-- @formatter:on -->
	 */
	DELIVERY_ADDRESS_L3("DADDR", "2.16.840.1.113883.5.111", "Delivery Address", "Delivery Address",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Dermatology clinic</div>
	 * <!-- @formatter:on -->
	 */
	DERMATOLOGY_CLINIC_L4("DERM", "2.16.840.1.113883.5.111", "Dermatology clinic",
			"Dermatology clinic", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Diagnostics or therapeutics unit</div>
	 * <!-- @formatter:on -->
	 */
	DIAGNOSTICS_OR_THERAPEUTICS_UNIT_L3("DX", "2.16.840.1.113883.5.111",
			"Diagnostics or therapeutics unit", "Diagnostics or therapeutics unit", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Echocardiography lab</div>
	 * <!-- @formatter:on -->
	 */
	ECHOCARDIOGRAPHY_LAB_L5("ECHO", "2.16.840.1.113883.5.111", "Echocardiography lab",
			"Echocardiography lab", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Emergency room</div>
	 * <!-- @formatter:on -->
	 */
	EMERGENCY_ROOM_L4("ER", "2.16.840.1.113883.5.111", "Emergency room", "Emergency room",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Emergency trauma unit</div>
	 * <!-- @formatter:on -->
	 */
	EMERGENCY_TRAUMA_UNIT_L5("ETU", "2.16.840.1.113883.5.111", "Emergency trauma unit",
			"Emergency trauma unit", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Endocrinology clinic</div>
	 * <!-- @formatter:on -->
	 */
	ENDOCRINOLOGY_CLINIC_L4("ENDO", "2.16.840.1.113883.5.111", "Endocrinology clinic",
			"Endocrinology clinic", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Endoscopy lab Ambulatory Health Care Facilities; Clinic/Center; Endoscopy</div>
	 * <!-- @formatter:on -->
	 */
	ENDOSCOPY_LAB_AMBULATORY_HEALTH_CARE_FACILITIES_CLINIC_CENTER_ENDOSCOPY_L5("ENDOS",
			"2.16.840.1.113883.5.111",
			"Endoscopy lab Ambulatory Health Care Facilities; Clinic/Center; Endoscopy",
			"Endoscopy lab Ambulatory Health Care Facilities; Clinic/Center; Endoscopy",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Epilepsy unit</div>
	 * <!-- @formatter:on -->
	 */
	EPILEPSY_UNIT_L4("EPIL", "2.16.840.1.113883.5.111", "Epilepsy unit", "Epilepsy unit",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Family medicine clinic</div>
	 * <!-- @formatter:on -->
	 */
	FAMILY_MEDICINE_CLINIC_L4("FMC", "2.16.840.1.113883.5.111", "Family medicine clinic",
			"Family medicine clinic", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gastroenterology clinic</div>
	 * <!-- @formatter:on -->
	 */
	GASTROENTEROLOGY_CLINIC_L4("GI", "2.16.840.1.113883.5.111", "Gastroenterology clinic",
			"Gastroenterology clinic", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gastroenterology diagnostics or therapeutics lab</div>
	 * <!-- @formatter:on -->
	 */
	GASTROENTEROLOGY_DIAGNOSTICS_OR_THERAPEUTICS_LAB_L4("GIDX", "2.16.840.1.113883.5.111",
			"Gastroenterology diagnostics or therapeutics lab",
			"Gastroenterology diagnostics or therapeutics lab", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">General internal medicine clinic</div>
	 * <!-- @formatter:on -->
	 */
	GENERAL_INTERNAL_MEDICINE_CLINIC_L4("GIM", "2.16.840.1.113883.5.111",
			"General internal medicine clinic", "General internal medicine clinic", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gynecology clinic</div>
	 * <!-- @formatter:on -->
	 */
	GYNECOLOGY_CLINIC_L4("GYN", "2.16.840.1.113883.5.111", "Gynecology clinic", "Gynecology clinic",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Hand clinic</div>
	 * <!-- @formatter:on -->
	 */
	HAND_CLINIC_L5("HAND", "2.16.840.1.113883.5.111", "Hand clinic", "Hand clinic", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Hematology clinic</div>
	 * <!-- @formatter:on -->
	 */
	HEMATOLOGY_CLINIC_L4("HEM", "2.16.840.1.113883.5.111", "Hematology clinic", "Hematology clinic",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Hemodialysis unit</div>
	 * <!-- @formatter:on -->
	 */
	HEMODIALYSIS_UNIT_L4("HD", "2.16.840.1.113883.5.111", "Hemodialysis unit", "Hemodialysis unit",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Hospitals; General Acute Care Hospital General acute care hospital</div>
	 * <!-- @formatter:on -->
	 */
	HOSPITALS_GENERAL_ACUTE_CARE_HOSPITAL_GENERAL_ACUTE_CARE_HOSPITAL_L4("GACH",
			"2.16.840.1.113883.5.111",
			"Hospitals; General Acute Care Hospital General acute care hospital",
			"Hospitals; General Acute Care Hospital General acute care hospital", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Hospital</div>
	 * <!-- @formatter:on -->
	 */
	HOSPITAL_L3("HOSP", "2.16.840.1.113883.5.111", "Hospital", "Hospital", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">hospital laboratory</div>
	 * <!-- @formatter:on -->
	 */
	HOSPITAL_LABORATORY_L4("HLAB", "2.16.840.1.113883.5.111", "hospital laboratory",
			"hospital laboratory", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Hospital unit</div>
	 * <!-- @formatter:on -->
	 */
	HOSPITAL_UNIT_L3("HU", "2.16.840.1.113883.5.111", "Hospital unit", "Hospital unit",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Hypertension clinic</div>
	 * <!-- @formatter:on -->
	 */
	HYPERTENSION_CLINIC_L4("HTN", "2.16.840.1.113883.5.111", "Hypertension clinic",
			"Hypertension clinic", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Impairment evaluation center</div>
	 * <!-- @formatter:on -->
	 */
	IMPAIRMENT_EVALUATION_CENTER_L4("IEC", "2.16.840.1.113883.5.111",
			"Impairment evaluation center", "Impairment evaluation center", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">IncidentalServiceDeliveryLocationRoleType</div>
	 * <!-- @formatter:on -->
	 */
	INCIDENTALSERVICEDELIVERYLOCATIONROLETYPE_L1("_IncidentalServiceDeliveryLocationRoleType",
			"2.16.840.1.113883.5.111", "IncidentalServiceDeliveryLocationRoleType",
			"IncidentalServiceDeliveryLocationRoleType", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Infectious disease clinic</div>
	 * <!-- @formatter:on -->
	 */
	INFECTIOUS_DISEASE_CLINIC_L4("INFD", "2.16.840.1.113883.5.111", "Infectious disease clinic",
			"Infectious disease clinic", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Infertility clinic</div>
	 * <!-- @formatter:on -->
	 */
	INFERTILITY_CLINIC_L4("INV", "2.16.840.1.113883.5.111", "Infertility clinic",
			"Infertility clinic", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">inpatient laboratory</div>
	 * <!-- @formatter:on -->
	 */
	INPATIENT_LABORATORY_L5("INLAB", "2.16.840.1.113883.5.111", "inpatient laboratory",
			"inpatient laboratory", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">inpatient pharmacy</div>
	 * <!-- @formatter:on -->
	 */
	INPATIENT_PHARMACY_L4("INPHARM", "2.16.840.1.113883.5.111", "inpatient pharmacy",
			"inpatient pharmacy", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">intellectual impairment center</div>
	 * <!-- @formatter:on -->
	 */
	INTELLECTUAL_IMPAIRMENT_CENTER_L5("RHII", "2.16.840.1.113883.5.111",
			"intellectual impairment center", "intellectual impairment center", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Intensive care unit</div>
	 * <!-- @formatter:on -->
	 */
	INTENSIVE_CARE_UNIT_L4("ICU", "2.16.840.1.113883.5.111", "Intensive care unit",
			"Intensive care unit", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Lympedema clinic</div>
	 * <!-- @formatter:on -->
	 */
	LYMPEDEMA_CLINIC_L4("LYMPH", "2.16.840.1.113883.5.111", "Lympedema clinic", "Lympedema clinic",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Medical genetics clinic</div>
	 * <!-- @formatter:on -->
	 */
	MEDICAL_GENETICS_CLINIC_L4("MGEN", "2.16.840.1.113883.5.111", "Medical genetics clinic",
			"Medical genetics clinic", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">medical laboratory</div>
	 * <!-- @formatter:on -->
	 */
	MEDICAL_LABORATORY_L4("MBL", "2.16.840.1.113883.5.111", "medical laboratory",
			"medical laboratory", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Medical oncology clinic</div>
	 * <!-- @formatter:on -->
	 */
	MEDICAL_ONCOLOGY_CLINIC_L4("ONCL", "2.16.840.1.113883.5.111", "Medical oncology clinic",
			"Medical oncology clinic", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Military Hospital MilitaryHospital</div>
	 * <!-- @formatter:on -->
	 */
	MILITARY_HOSPITAL_MILITARYHOSPITAL_L4("MHSP", "2.16.840.1.113883.5.111",
			"Military Hospital MilitaryHospital", "Military Hospital MilitaryHospital",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Mobile Unit</div>
	 * <!-- @formatter:on -->
	 */
	MOBILE_UNIT_L3("MOBL", "2.16.840.1.113883.5.111", "Mobile Unit", "Mobile Unit", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Nephrology clinic</div>
	 * <!-- @formatter:on -->
	 */
	NEPHROLOGY_CLINIC_L4("NEPH", "2.16.840.1.113883.5.111", "Nephrology clinic",
			"Nephrology clinic", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Neurology clinic</div>
	 * <!-- @formatter:on -->
	 */
	NEUROLOGY_CLINIC_L4("NEUR", "2.16.840.1.113883.5.111", "Neurology clinic", "Neurology clinic",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Neurology critical care and stroke unit</div>
	 * <!-- @formatter:on -->
	 */
	NEUROLOGY_CRITICAL_CARE_AND_STROKE_UNIT_L4("NCCS", "2.16.840.1.113883.5.111",
			"Neurology critical care and stroke unit", "Neurology critical care and stroke unit",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Neuroradiology unit</div>
	 * <!-- @formatter:on -->
	 */
	NEURORADIOLOGY_UNIT_L5("RNEU", "2.16.840.1.113883.5.111", "Neuroradiology unit",
			"Neuroradiology unit", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Neurosurgery unit</div>
	 * <!-- @formatter:on -->
	 */
	NEUROSURGERY_UNIT_L4("NS", "2.16.840.1.113883.5.111", "Neurosurgery unit", "Neurosurgery unit",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Nursing or custodial care facility</div>
	 * <!-- @formatter:on -->
	 */
	NURSING_OR_CUSTODIAL_CARE_FACILITY_L3("NCCF", "2.16.840.1.113883.5.111",
			"Nursing or custodial care facility", "Nursing or custodial care facility",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Obstetrics clinic</div>
	 * <!-- @formatter:on -->
	 */
	OBSTETRICS_CLINIC_L4("OB", "2.16.840.1.113883.5.111", "Obstetrics clinic", "Obstetrics clinic",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Opthalmology clinic</div>
	 * <!-- @formatter:on -->
	 */
	OPTHALMOLOGY_CLINIC_L4("OPH", "2.16.840.1.113883.5.111", "Opthalmology clinic",
			"Opthalmology clinic", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">optometry clinic</div>
	 * <!-- @formatter:on -->
	 */
	OPTOMETRY_CLINIC_L4("OPTC", "2.16.840.1.113883.5.111", "optometry clinic", "optometry clinic",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Oral and maxillofacial surgery clinic Ambulatory Health Care Facilities; Clinic/Center; Surgery, Oral/Maxillofacial</div>
	 * <!-- @formatter:on -->
	 */
	ORAL_AND_MAXILLOFACIAL_SURGERY_CLINIC_AMBULATORY_HEALTH_CARE_FACILITIES_CLINIC_CENTER_SURGERY_ORAL_MAXILLOFACIAL_L4(
			"OMS", "2.16.840.1.113883.5.111",
			"Oral and maxillofacial surgery clinic Ambulatory Health Care Facilities; Clinic/Center; Surgery, Oral/Maxillofacial",
			"Oral and maxillofacial surgery clinic Ambulatory Health Care Facilities; Clinic/Center; Surgery, Oral/Maxillofacial",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Orthopedics clinic</div>
	 * <!-- @formatter:on -->
	 */
	ORTHOPEDICS_CLINIC_L4("ORTHO", "2.16.840.1.113883.5.111", "Orthopedics clinic",
			"Orthopedics clinic", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Otorhinolaryngology clinic</div>
	 * <!-- @formatter:on -->
	 */
	OTORHINOLARYNGOLOGY_CLINIC_L4("ENT", "2.16.840.1.113883.5.111", "Otorhinolaryngology clinic",
			"Otorhinolaryngology clinic", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Outpatient facility</div>
	 * <!-- @formatter:on -->
	 */
	OUTPATIENT_FACILITY_L3("OF", "2.16.840.1.113883.5.111", "Outpatient facility",
			"Outpatient facility", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">outpatient laboratory</div>
	 * <!-- @formatter:on -->
	 */
	OUTPATIENT_LABORATORY_L5("OUTLAB", "2.16.840.1.113883.5.111", "outpatient laboratory",
			"outpatient laboratory", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">outpatient pharmacy</div>
	 * <!-- @formatter:on -->
	 */
	OUTPATIENT_PHARMACY_L4("OUTPHARM", "2.16.840.1.113883.5.111", "outpatient pharmacy",
			"outpatient pharmacy", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Pain clinic Ambulatory Health Care Facilities; Clinic/Center; Pain</div>
	 * <!-- @formatter:on -->
	 */
	PAIN_CLINIC_AMBULATORY_HEALTH_CARE_FACILITIES_CLINIC_CENTER_PAIN_L4("PAINCL",
			"2.16.840.1.113883.5.111",
			"Pain clinic Ambulatory Health Care Facilities; Clinic/Center; Pain",
			"Pain clinic Ambulatory Health Care Facilities; Clinic/Center; Pain", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Pain rehabilitation center</div>
	 * <!-- @formatter:on -->
	 */
	PAIN_REHABILITATION_CENTER_L4("PRC", "2.16.840.1.113883.5.111", "Pain rehabilitation center",
			"Pain rehabilitation center", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">parents with adjustment difficulties center</div>
	 * <!-- @formatter:on -->
	 */
	PARENTS_WITH_ADJUSTMENT_DIFFICULTIES_CENTER_L5("RHMAD", "2.16.840.1.113883.5.111",
			"parents with adjustment difficulties center",
			"parents with adjustment difficulties center", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Patient's Residence</div>
	 * <!-- @formatter:on -->
	 */
	PATIENT_RESIDENCE_L2("PTRES", "2.16.840.1.113883.5.111", "Patient's Residence",
			"Patient's Residence", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Pediatrics clinic</div>
	 * <!-- @formatter:on -->
	 */
	PEDIATRICS_CLINIC_L4("PEDC", "2.16.840.1.113883.5.111", "Pediatrics clinic",
			"Pediatrics clinic", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Pediatric cardiology clinic</div>
	 * <!-- @formatter:on -->
	 */
	PEDIATRIC_CARDIOLOGY_CLINIC_L5("PEDCARD", "2.16.840.1.113883.5.111",
			"Pediatric cardiology clinic", "Pediatric cardiology clinic", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Pediatric endocrinology clinic</div>
	 * <!-- @formatter:on -->
	 */
	PEDIATRIC_ENDOCRINOLOGY_CLINIC_L5("PEDE", "2.16.840.1.113883.5.111",
			"Pediatric endocrinology clinic", "Pediatric endocrinology clinic", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Pediatric gastroenterology clinic</div>
	 * <!-- @formatter:on -->
	 */
	PEDIATRIC_GASTROENTEROLOGY_CLINIC_L5("PEDGI", "2.16.840.1.113883.5.111",
			"Pediatric gastroenterology clinic", "Pediatric gastroenterology clinic", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Pediatric hematology clinic</div>
	 * <!-- @formatter:on -->
	 */
	PEDIATRIC_HEMATOLOGY_CLINIC_L5("PEDHEM", "2.16.840.1.113883.5.111",
			"Pediatric hematology clinic", "Pediatric hematology clinic", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Pediatric infectious disease clinic</div>
	 * <!-- @formatter:on -->
	 */
	PEDIATRIC_INFECTIOUS_DISEASE_CLINIC_L5("PEDID", "2.16.840.1.113883.5.111",
			"Pediatric infectious disease clinic", "Pediatric infectious disease clinic",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Pediatric intensive care unit</div>
	 * <!-- @formatter:on -->
	 */
	PEDIATRIC_INTENSIVE_CARE_UNIT_L5("PEDICU", "2.16.840.1.113883.5.111",
			"Pediatric intensive care unit", "Pediatric intensive care unit", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Pediatric neonatal intensive care unit</div>
	 * <!-- @formatter:on -->
	 */
	PEDIATRIC_NEONATAL_INTENSIVE_CARE_UNIT_L6("PEDNICU", "2.16.840.1.113883.5.111",
			"Pediatric neonatal intensive care unit", "Pediatric neonatal intensive care unit",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Pediatric nephrology clinic</div>
	 * <!-- @formatter:on -->
	 */
	PEDIATRIC_NEPHROLOGY_CLINIC_L5("PEDNEPH", "2.16.840.1.113883.5.111",
			"Pediatric nephrology clinic", "Pediatric nephrology clinic", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Pediatric oncology clinic</div>
	 * <!-- @formatter:on -->
	 */
	PEDIATRIC_ONCOLOGY_CLINIC_L5("PEDHO", "2.16.840.1.113883.5.111", "Pediatric oncology clinic",
			"Pediatric oncology clinic", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Pediatric rheumatology clinic</div>
	 * <!-- @formatter:on -->
	 */
	PEDIATRIC_RHEUMATOLOGY_CLINIC_L5("PEDRHEUM", "2.16.840.1.113883.5.111",
			"Pediatric rheumatology clinic", "Pediatric rheumatology clinic", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Pediatric unit</div>
	 * <!-- @formatter:on -->
	 */
	PEDIATRIC_UNIT_L4("PEDU", "2.16.840.1.113883.5.111", "Pediatric unit", "Pediatric unit",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Pharmacy</div>
	 * <!-- @formatter:on -->
	 */
	PHARMACY_L3("PHARM", "2.16.840.1.113883.5.111", "Pharmacy", "Pharmacy", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">physical impairment center</div>
	 * <!-- @formatter:on -->
	 */
	PHYSICAL_IMPAIRMENT_CENTER_L5("RHPI", "2.16.840.1.113883.5.111", "physical impairment center",
			"physical impairment center", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">physical impairment - hearing center</div>
	 * <!-- @formatter:on -->
	 */
	PHYSICAL_IMPAIRMENT_HEARING_CENTER_L6("RHPIH", "2.16.840.1.113883.5.111",
			"physical impairment - hearing center", "physical impairment - hearing center",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">physical impairment - motor skills center</div>
	 * <!-- @formatter:on -->
	 */
	PHYSICAL_IMPAIRMENT_MOTOR_SKILLS_CENTER_L6("RHPIMS", "2.16.840.1.113883.5.111",
			"physical impairment - motor skills center",
			"physical impairment - motor skills center", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">physical impairment - visual skills center</div>
	 * <!-- @formatter:on -->
	 */
	PHYSICAL_IMPAIRMENT_VISUAL_SKILLS_CENTER_L6("RHPIVS", "2.16.840.1.113883.5.111",
			"physical impairment - visual skills center",
			"physical impairment - visual skills center", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Plastic surgery clinic</div>
	 * <!-- @formatter:on -->
	 */
	PLASTIC_SURGERY_CLINIC_L5("PLS", "2.16.840.1.113883.5.111", "Plastic surgery clinic",
			"Plastic surgery clinic", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Podiatry clinic Ambulatory Health Care Facilities; Clinic/Center; Podiatric</div>
	 * <!-- @formatter:on -->
	 */
	PODIATRY_CLINIC_AMBULATORY_HEALTH_CARE_FACILITIES_CLINIC_CENTER_PODIATRIC_L4("POD",
			"2.16.840.1.113883.5.111",
			"Podiatry clinic Ambulatory Health Care Facilities; Clinic/Center; Podiatric",
			"Podiatry clinic Ambulatory Health Care Facilities; Clinic/Center; Podiatric",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Preventive medicine clinic</div>
	 * <!-- @formatter:on -->
	 */
	PREVENTIVE_MEDICINE_CLINIC_L4("PREV", "2.16.840.1.113883.5.111", "Preventive medicine clinic",
			"Preventive medicine clinic", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Primary care clinic Ambulatory Health Care Facilities; Clinic/Center; Primary Care</div>
	 * <!-- @formatter:on -->
	 */
	PRIMARY_CARE_CLINIC_AMBULATORY_HEALTH_CARE_FACILITIES_CLINIC_CENTER_PRIMARY_CARE_L4("PC",
			"2.16.840.1.113883.5.111",
			"Primary care clinic Ambulatory Health Care Facilities; Clinic/Center; Primary Care",
			"Primary care clinic Ambulatory Health Care Facilities; Clinic/Center; Primary Care",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Proctology clinic</div>
	 * <!-- @formatter:on -->
	 */
	PROCTOLOGY_CLINIC_L4("PROCTO", "2.16.840.1.113883.5.111", "Proctology clinic",
			"Proctology clinic", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Prosthodontics clinic</div>
	 * <!-- @formatter:on -->
	 */
	PROSTHODONTICS_CLINIC_L4("PROS", "2.16.840.1.113883.5.111", "Prosthodontics clinic",
			"Prosthodontics clinic", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Provider's Office</div>
	 * <!-- @formatter:on -->
	 */
	PROVIDER_S_OFFICE_L4("PROFF", "2.16.840.1.113883.5.111", "Provider's Office",
			"Provider's Office", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Psychatric Care Facility</div>
	 * <!-- @formatter:on -->
	 */
	PSYCHATRIC_CARE_FACILITY_L4("PSYCHF", "2.16.840.1.113883.5.111", "Psychatric Care Facility",
			"Psychatric Care Facility", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Psychiatric hospital unit Hospital Units; Psychiatric Unit</div>
	 * <!-- @formatter:on -->
	 */
	PSYCHIATRIC_HOSPITAL_UNIT_HOSPITAL_UNITS_PSYCHIATRIC_UNIT_L4("PHU", "2.16.840.1.113883.5.111",
			"Psychiatric hospital unit Hospital Units; Psychiatric Unit",
			"Psychiatric hospital unit Hospital Units; Psychiatric Unit", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Psychiatry clinic</div>
	 * <!-- @formatter:on -->
	 */
	PSYCHIATRY_CLINIC_L4("PSY", "2.16.840.1.113883.5.111", "Psychiatry clinic", "Psychiatry clinic",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Psychology clinic</div>
	 * <!-- @formatter:on -->
	 */
	PSYCHOLOGY_CLINIC_L4("PSI", "2.16.840.1.113883.5.111", "Psychology clinic", "Psychology clinic",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Radiation oncology unit Ambulatory Health Care Facilities; Clinic/Center; Oncology, Radiation</div>
	 * <!-- @formatter:on -->
	 */
	RADIATION_ONCOLOGY_UNIT_AMBULATORY_HEALTH_CARE_FACILITIES_CLINIC_CENTER_ONCOLOGY_RADIATION_L5(
			"RADO", "2.16.840.1.113883.5.111",
			"Radiation oncology unit Ambulatory Health Care Facilities; Clinic/Center; Oncology, Radiation",
			"Radiation oncology unit Ambulatory Health Care Facilities; Clinic/Center; Oncology, Radiation",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Radiology diagnostics or therapeutics unit Ambulatory Health Care Facilities; Clinic/Center; Radiology</div>
	 * <!-- @formatter:on -->
	 */
	RADIOLOGY_DIAGNOSTICS_OR_THERAPEUTICS_UNIT_AMBULATORY_HEALTH_CARE_FACILITIES_CLINIC_CENTER_RADIOLOGY_L4(
			"RADDX", "2.16.840.1.113883.5.111",
			"Radiology diagnostics or therapeutics unit Ambulatory Health Care Facilities; Clinic/Center; Radiology",
			"Radiology diagnostics or therapeutics unit Ambulatory Health Care Facilities; Clinic/Center; Radiology",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">radiology unit</div>
	 * <!-- @formatter:on -->
	 */
	RADIOLOGY_UNIT_L4("HRAD", "2.16.840.1.113883.5.111", "radiology unit", "radiology unit",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Rehabilitation hospital Hospitals; Rehabilitation Hospital</div>
	 * <!-- @formatter:on -->
	 */
	REHABILITATION_HOSPITAL_HOSPITALS_REHABILITATION_HOSPITAL_L4("RH", "2.16.840.1.113883.5.111",
			"Rehabilitation hospital Hospitals; Rehabilitation Hospital",
			"Rehabilitation hospital Hospitals; Rehabilitation Hospital", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Rehabilitation hospital unit Hospital Units; Rehabilitation Unit</div>
	 * <!-- @formatter:on -->
	 */
	REHABILITATION_HOSPITAL_UNIT_HOSPITAL_UNITS_REHABILITATION_UNIT_L4("RHU",
			"2.16.840.1.113883.5.111",
			"Rehabilitation hospital unit Hospital Units; Rehabilitation Unit",
			"Rehabilitation hospital unit Hospital Units; Rehabilitation Unit", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Residential treatment facility</div>
	 * <!-- @formatter:on -->
	 */
	RESIDENTIAL_TREATMENT_FACILITY_L3("RTF", "2.16.840.1.113883.5.111",
			"Residential treatment facility", "Residential treatment facility", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Rheumatology clinic</div>
	 * <!-- @formatter:on -->
	 */
	RHEUMATOLOGY_CLINIC_L4("RHEUM", "2.16.840.1.113883.5.111", "Rheumatology clinic",
			"Rheumatology clinic", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">school</div>
	 * <!-- @formatter:on -->
	 */
	SCHOOL_L2("SCHOOL", "2.16.840.1.113883.5.111", "school", "school", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Skilled nursing facility Nursing & Custodial Care Facilities; Skilled Nursing Facility</div>
	 * <!-- @formatter:on -->
	 */
	SKILLED_NURSING_FACILITY_NURSING_CUSTODIAL_CARE_FACILITIES_SKILLED_NURSING_FACILITY_L4("SNF",
			"2.16.840.1.113883.5.111",
			"Skilled nursing facility Nursing & Custodial Care Facilities; Skilled Nursing Facility",
			"Skilled nursing facility Nursing & Custodial Care Facilities; Skilled Nursing Facility",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Sleep disorders unit</div>
	 * <!-- @formatter:on -->
	 */
	SLEEP_DISORDERS_UNIT_L4("SLEEP", "2.16.840.1.113883.5.111", "Sleep disorders unit",
			"Sleep disorders unit", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">specimen collection site</div>
	 * <!-- @formatter:on -->
	 */
	SPECIMEN_COLLECTION_SITE_L4("HUSCS", "2.16.840.1.113883.5.111", "specimen collection site",
			"specimen collection site", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Sports medicine clinic</div>
	 * <!-- @formatter:on -->
	 */
	SPORTS_MEDICINE_CLINIC_L4("SPMED", "2.16.840.1.113883.5.111", "Sports medicine clinic",
			"Sports medicine clinic", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Substance use rehabilitation facility Residential Treatment Facilities; Substance Use Rehabilitation Facility</div>
	 * <!-- @formatter:on -->
	 */
	SUBSTANCE_USE_REHABILITATION_FACILITY_RESIDENTIAL_TREATMENT_FACILITIES_SUBSTANCE_USE_REHABILITATION_FACILITY_L4(
			"SURF", "2.16.840.1.113883.5.111",
			"Substance use rehabilitation facility Residential Treatment Facilities; Substance Use Rehabilitation Facility",
			"Substance use rehabilitation facility Residential Treatment Facilities; Substance Use Rehabilitation Facility",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Surgery clinic</div>
	 * <!-- @formatter:on -->
	 */
	SURGERY_CLINIC_L4("SU", "2.16.840.1.113883.5.111", "Surgery clinic", "Surgery clinic",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Transplant clinic</div>
	 * <!-- @formatter:on -->
	 */
	TRANSPLANT_CLINIC_L4("TR", "2.16.840.1.113883.5.111", "Transplant clinic", "Transplant clinic",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Travel and geographic medicine clinic</div>
	 * <!-- @formatter:on -->
	 */
	TRAVEL_AND_GEOGRAPHIC_MEDICINE_CLINIC_L4("TRAVEL", "2.16.840.1.113883.5.111",
			"Travel and geographic medicine clinic", "Travel and geographic medicine clinic",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">underage protection center</div>
	 * <!-- @formatter:on -->
	 */
	UNDERAGE_PROTECTION_CENTER_L2("UPC", "2.16.840.1.113883.5.111", "underage protection center",
			"underage protection center", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Urology clinic</div>
	 * <!-- @formatter:on -->
	 */
	UROLOGY_CLINIC_L5("URO", "2.16.840.1.113883.5.111", "Urology clinic", "Urology clinic",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">work site</div>
	 * <!-- @formatter:on -->
	 */
	WORK_SITE_L2("WORK", "2.16.840.1.113883.5.111", "work site", "work site", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Wound clinic</div>
	 * <!-- @formatter:on -->
	 */
	WOUND_CLINIC_L4("WND", "2.16.840.1.113883.5.111", "Wound clinic", "Wound clinic", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">youths with adjustment difficulties center</div>
	 * <!-- @formatter:on -->
	 */
	YOUTHS_WITH_ADJUSTMENT_DIFFICULTIES_CENTER_L5("RHYAD", "2.16.840.1.113883.5.111",
			"youths with adjustment difficulties center",
			"youths with adjustment difficulties center", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE");

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for accident site</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ACCIDENT_SITE_L2_CODE = "ACC";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for addiction treatment center</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ADDICTION_TREATMENT_CENTER_L5_CODE = "RHAT";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Allergy clinic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ALLERGY_CLINIC_L4_CODE = "ALL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Ambulance</div>
	 * <!-- @formatter:on -->
	 */
	public static final String AMBULANCE_L4_CODE = "AMB";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Ambulatory Health Care Facilities; Clinic/Center; Rehabilitation: Cardiac Facilities Cardiology clinic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String AMBULATORY_HEALTH_CARE_FACILITIES_CLINIC_CENTER_REHABILITATION_CARDIAC_FACILITIES_CARDIOLOGY_CLINIC_L4_CODE = "CARD";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Amputee clinic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String AMPUTEE_CLINIC_L4_CODE = "AMPUT";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Bone marrow transplant clinic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BONE_MARROW_TRANSPLANT_CLINIC_L4_CODE = "BMTC";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Bone marrow transplant unit</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BONE_MARROW_TRANSPLANT_UNIT_L4_CODE = "BMTU";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Breast clinic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String BREAST_CLINIC_L4_CODE = "BREAST";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Cardiac catheterization lab</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CARDIAC_CATHETERIZATION_LAB_L5_CODE = "CATH";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Cardiovascular diagnostics or therapeutics unit</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CARDIOVASCULAR_DIAGNOSTICS_OR_THERAPEUTICS_UNIT_L4_CODE = "CVDX";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Chest unit</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CHEST_UNIT_L4_CODE = "CHEST";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Child and adolescent neurology clinic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CHILD_AND_ADOLESCENT_NEUROLOGY_CLINIC_L4_CODE = "CANC";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Child and adolescent psychiatry clinic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CHILD_AND_ADOLESCENT_PSYCHIATRY_CLINIC_L4_CODE = "CAPC";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Chronic Care Facility Hospitals; Chronic Disease Hospital</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CHRONIC_CARE_FACILITY_HOSPITALS_CHRONIC_DISEASE_HOSPITAL_L4_CODE = "CHR";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Coagulation clinic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String COAGULATION_CLINIC_L4_CODE = "COAG";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Colon and rectal surgery clinic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String COLON_AND_RECTAL_SURGERY_CLINIC_L4_CODE = "CRS";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Community Location</div>
	 * <!-- @formatter:on -->
	 */
	public static final String COMMUNITY_LOCATION_L2_CODE = "COMM";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for community service center</div>
	 * <!-- @formatter:on -->
	 */
	public static final String COMMUNITY_SERVICE_CENTER_L3_CODE = "CSC";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Coronary care unit</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CORONARY_CARE_UNIT_L4_CODE = "CCU";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for DedicatedClinicalLocationRoleType</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DEDICATEDCLINICALLOCATIONROLETYPE_L2_CODE = "_DedicatedClinicalLocationRoleType";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for DedicatedNonClinicalLocationRoleType</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DEDICATEDNONCLINICALLOCATIONROLETYPE_L2_CODE = "_DedicatedNonClinicalLocationRoleType";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for DedicatedServiceDeliveryLocationRoleType</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DEDICATEDSERVICEDELIVERYLOCATIONROLETYPE_L1_CODE = "_DedicatedServiceDeliveryLocationRoleType";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Delivery Address</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DELIVERY_ADDRESS_L3_CODE = "DADDR";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Dermatology clinic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DERMATOLOGY_CLINIC_L4_CODE = "DERM";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Diagnostics or therapeutics unit</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DIAGNOSTICS_OR_THERAPEUTICS_UNIT_L3_CODE = "DX";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Echocardiography lab</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ECHOCARDIOGRAPHY_LAB_L5_CODE = "ECHO";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Emergency room</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EMERGENCY_ROOM_L4_CODE = "ER";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Emergency trauma unit</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EMERGENCY_TRAUMA_UNIT_L5_CODE = "ETU";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Endocrinology clinic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ENDOCRINOLOGY_CLINIC_L4_CODE = "ENDO";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Endoscopy lab Ambulatory Health Care Facilities; Clinic/Center; Endoscopy</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ENDOSCOPY_LAB_AMBULATORY_HEALTH_CARE_FACILITIES_CLINIC_CENTER_ENDOSCOPY_L5_CODE = "ENDOS";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Epilepsy unit</div>
	 * <!-- @formatter:on -->
	 */
	public static final String EPILEPSY_UNIT_L4_CODE = "EPIL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Family medicine clinic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String FAMILY_MEDICINE_CLINIC_L4_CODE = "FMC";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Gastroenterology clinic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GASTROENTEROLOGY_CLINIC_L4_CODE = "GI";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Gastroenterology diagnostics or therapeutics lab</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GASTROENTEROLOGY_DIAGNOSTICS_OR_THERAPEUTICS_LAB_L4_CODE = "GIDX";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for General internal medicine clinic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GENERAL_INTERNAL_MEDICINE_CLINIC_L4_CODE = "GIM";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Gynecology clinic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GYNECOLOGY_CLINIC_L4_CODE = "GYN";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Hand clinic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HAND_CLINIC_L5_CODE = "HAND";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Hematology clinic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HEMATOLOGY_CLINIC_L4_CODE = "HEM";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Hemodialysis unit</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HEMODIALYSIS_UNIT_L4_CODE = "HD";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Hospitals; General Acute Care Hospital General acute care hospital</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HOSPITALS_GENERAL_ACUTE_CARE_HOSPITAL_GENERAL_ACUTE_CARE_HOSPITAL_L4_CODE = "GACH";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Hospital</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HOSPITAL_L3_CODE = "HOSP";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for hospital laboratory</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HOSPITAL_LABORATORY_L4_CODE = "HLAB";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Hospital unit</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HOSPITAL_UNIT_L3_CODE = "HU";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Hypertension clinic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HYPERTENSION_CLINIC_L4_CODE = "HTN";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Impairment evaluation center</div>
	 * <!-- @formatter:on -->
	 */
	public static final String IMPAIRMENT_EVALUATION_CENTER_L4_CODE = "IEC";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for IncidentalServiceDeliveryLocationRoleType</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INCIDENTALSERVICEDELIVERYLOCATIONROLETYPE_L1_CODE = "_IncidentalServiceDeliveryLocationRoleType";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Infectious disease clinic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INFECTIOUS_DISEASE_CLINIC_L4_CODE = "INFD";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Infertility clinic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INFERTILITY_CLINIC_L4_CODE = "INV";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for inpatient laboratory</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INPATIENT_LABORATORY_L5_CODE = "INLAB";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for inpatient pharmacy</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INPATIENT_PHARMACY_L4_CODE = "INPHARM";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for intellectual impairment center</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTELLECTUAL_IMPAIRMENT_CENTER_L5_CODE = "RHII";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Intensive care unit</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTENSIVE_CARE_UNIT_L4_CODE = "ICU";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Lympedema clinic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String LYMPEDEMA_CLINIC_L4_CODE = "LYMPH";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Medical genetics clinic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MEDICAL_GENETICS_CLINIC_L4_CODE = "MGEN";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for medical laboratory</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MEDICAL_LABORATORY_L4_CODE = "MBL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Medical oncology clinic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MEDICAL_ONCOLOGY_CLINIC_L4_CODE = "ONCL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Military Hospital MilitaryHospital</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MILITARY_HOSPITAL_MILITARYHOSPITAL_L4_CODE = "MHSP";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Mobile Unit</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MOBILE_UNIT_L3_CODE = "MOBL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Nephrology clinic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NEPHROLOGY_CLINIC_L4_CODE = "NEPH";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Neurology clinic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NEUROLOGY_CLINIC_L4_CODE = "NEUR";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Neurology critical care and stroke unit</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NEUROLOGY_CRITICAL_CARE_AND_STROKE_UNIT_L4_CODE = "NCCS";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Neuroradiology unit</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NEURORADIOLOGY_UNIT_L5_CODE = "RNEU";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Neurosurgery unit</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NEUROSURGERY_UNIT_L4_CODE = "NS";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Nursing or custodial care facility</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NURSING_OR_CUSTODIAL_CARE_FACILITY_L3_CODE = "NCCF";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Obstetrics clinic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OBSTETRICS_CLINIC_L4_CODE = "OB";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Opthalmology clinic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OPTHALMOLOGY_CLINIC_L4_CODE = "OPH";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for optometry clinic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OPTOMETRY_CLINIC_L4_CODE = "OPTC";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Oral and maxillofacial surgery clinic Ambulatory Health Care Facilities; Clinic/Center; Surgery, Oral/Maxillofacial</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ORAL_AND_MAXILLOFACIAL_SURGERY_CLINIC_AMBULATORY_HEALTH_CARE_FACILITIES_CLINIC_CENTER_SURGERY_ORAL_MAXILLOFACIAL_L4_CODE = "OMS";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Orthopedics clinic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ORTHOPEDICS_CLINIC_L4_CODE = "ORTHO";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Otorhinolaryngology clinic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OTORHINOLARYNGOLOGY_CLINIC_L4_CODE = "ENT";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Outpatient facility</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OUTPATIENT_FACILITY_L3_CODE = "OF";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for outpatient laboratory</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OUTPATIENT_LABORATORY_L5_CODE = "OUTLAB";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for outpatient pharmacy</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OUTPATIENT_PHARMACY_L4_CODE = "OUTPHARM";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Pain clinic Ambulatory Health Care Facilities; Clinic/Center; Pain</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PAIN_CLINIC_AMBULATORY_HEALTH_CARE_FACILITIES_CLINIC_CENTER_PAIN_L4_CODE = "PAINCL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Pain rehabilitation center</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PAIN_REHABILITATION_CENTER_L4_CODE = "PRC";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for parents with adjustment difficulties center</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PARENTS_WITH_ADJUSTMENT_DIFFICULTIES_CENTER_L5_CODE = "RHMAD";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Patient's Residence</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PATIENT_RESIDENCE_L2_CODE = "PTRES";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Pediatrics clinic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PEDIATRICS_CLINIC_L4_CODE = "PEDC";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Pediatric cardiology clinic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PEDIATRIC_CARDIOLOGY_CLINIC_L5_CODE = "PEDCARD";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Pediatric endocrinology clinic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PEDIATRIC_ENDOCRINOLOGY_CLINIC_L5_CODE = "PEDE";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Pediatric gastroenterology clinic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PEDIATRIC_GASTROENTEROLOGY_CLINIC_L5_CODE = "PEDGI";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Pediatric hematology clinic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PEDIATRIC_HEMATOLOGY_CLINIC_L5_CODE = "PEDHEM";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Pediatric infectious disease clinic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PEDIATRIC_INFECTIOUS_DISEASE_CLINIC_L5_CODE = "PEDID";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Pediatric intensive care unit</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PEDIATRIC_INTENSIVE_CARE_UNIT_L5_CODE = "PEDICU";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Pediatric neonatal intensive care unit</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PEDIATRIC_NEONATAL_INTENSIVE_CARE_UNIT_L6_CODE = "PEDNICU";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Pediatric nephrology clinic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PEDIATRIC_NEPHROLOGY_CLINIC_L5_CODE = "PEDNEPH";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Pediatric oncology clinic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PEDIATRIC_ONCOLOGY_CLINIC_L5_CODE = "PEDHO";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Pediatric rheumatology clinic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PEDIATRIC_RHEUMATOLOGY_CLINIC_L5_CODE = "PEDRHEUM";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Pediatric unit</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PEDIATRIC_UNIT_L4_CODE = "PEDU";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Pharmacy</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PHARMACY_L3_CODE = "PHARM";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for physical impairment center</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PHYSICAL_IMPAIRMENT_CENTER_L5_CODE = "RHPI";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for physical impairment - hearing center</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PHYSICAL_IMPAIRMENT_HEARING_CENTER_L6_CODE = "RHPIH";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for physical impairment - motor skills center</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PHYSICAL_IMPAIRMENT_MOTOR_SKILLS_CENTER_L6_CODE = "RHPIMS";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for physical impairment - visual skills center</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PHYSICAL_IMPAIRMENT_VISUAL_SKILLS_CENTER_L6_CODE = "RHPIVS";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Plastic surgery clinic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PLASTIC_SURGERY_CLINIC_L5_CODE = "PLS";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Podiatry clinic Ambulatory Health Care Facilities; Clinic/Center; Podiatric</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PODIATRY_CLINIC_AMBULATORY_HEALTH_CARE_FACILITIES_CLINIC_CENTER_PODIATRIC_L4_CODE = "POD";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Preventive medicine clinic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PREVENTIVE_MEDICINE_CLINIC_L4_CODE = "PREV";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Primary care clinic Ambulatory Health Care Facilities; Clinic/Center; Primary Care</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PRIMARY_CARE_CLINIC_AMBULATORY_HEALTH_CARE_FACILITIES_CLINIC_CENTER_PRIMARY_CARE_L4_CODE = "PC";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Proctology clinic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PROCTOLOGY_CLINIC_L4_CODE = "PROCTO";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Prosthodontics clinic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PROSTHODONTICS_CLINIC_L4_CODE = "PROS";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Provider's Office</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PROVIDER_S_OFFICE_L4_CODE = "PROFF";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Psychatric Care Facility</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PSYCHATRIC_CARE_FACILITY_L4_CODE = "PSYCHF";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Psychiatric hospital unit Hospital Units; Psychiatric Unit</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PSYCHIATRIC_HOSPITAL_UNIT_HOSPITAL_UNITS_PSYCHIATRIC_UNIT_L4_CODE = "PHU";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Psychiatry clinic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PSYCHIATRY_CLINIC_L4_CODE = "PSY";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Psychology clinic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PSYCHOLOGY_CLINIC_L4_CODE = "PSI";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Radiation oncology unit Ambulatory Health Care Facilities; Clinic/Center; Oncology, Radiation</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RADIATION_ONCOLOGY_UNIT_AMBULATORY_HEALTH_CARE_FACILITIES_CLINIC_CENTER_ONCOLOGY_RADIATION_L5_CODE = "RADO";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Radiology diagnostics or therapeutics unit Ambulatory Health Care Facilities; Clinic/Center; Radiology</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RADIOLOGY_DIAGNOSTICS_OR_THERAPEUTICS_UNIT_AMBULATORY_HEALTH_CARE_FACILITIES_CLINIC_CENTER_RADIOLOGY_L4_CODE = "RADDX";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for radiology unit</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RADIOLOGY_UNIT_L4_CODE = "HRAD";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Rehabilitation hospital Hospitals; Rehabilitation Hospital</div>
	 * <!-- @formatter:on -->
	 */
	public static final String REHABILITATION_HOSPITAL_HOSPITALS_REHABILITATION_HOSPITAL_L4_CODE = "RH";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Rehabilitation hospital unit Hospital Units; Rehabilitation Unit</div>
	 * <!-- @formatter:on -->
	 */
	public static final String REHABILITATION_HOSPITAL_UNIT_HOSPITAL_UNITS_REHABILITATION_UNIT_L4_CODE = "RHU";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Residential treatment facility</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RESIDENTIAL_TREATMENT_FACILITY_L3_CODE = "RTF";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Rheumatology clinic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RHEUMATOLOGY_CLINIC_L4_CODE = "RHEUM";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for school</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SCHOOL_L2_CODE = "SCHOOL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Skilled nursing facility Nursing & Custodial Care Facilities; Skilled Nursing Facility</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SKILLED_NURSING_FACILITY_NURSING_CUSTODIAL_CARE_FACILITIES_SKILLED_NURSING_FACILITY_L4_CODE = "SNF";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Sleep disorders unit</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SLEEP_DISORDERS_UNIT_L4_CODE = "SLEEP";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for specimen collection site</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SPECIMEN_COLLECTION_SITE_L4_CODE = "HUSCS";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Sports medicine clinic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SPORTS_MEDICINE_CLINIC_L4_CODE = "SPMED";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Substance use rehabilitation facility Residential Treatment Facilities; Substance Use Rehabilitation Facility</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SUBSTANCE_USE_REHABILITATION_FACILITY_RESIDENTIAL_TREATMENT_FACILITIES_SUBSTANCE_USE_REHABILITATION_FACILITY_L4_CODE = "SURF";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Surgery clinic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SURGERY_CLINIC_L4_CODE = "SU";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Transplant clinic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TRANSPLANT_CLINIC_L4_CODE = "TR";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Travel and geographic medicine clinic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TRAVEL_AND_GEOGRAPHIC_MEDICINE_CLINIC_L4_CODE = "TRAVEL";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for underage protection center</div>
	 * <!-- @formatter:on -->
	 */
	public static final String UNDERAGE_PROTECTION_CENTER_L2_CODE = "UPC";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Urology clinic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String UROLOGY_CLINIC_L5_CODE = "URO";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for work site</div>
	 * <!-- @formatter:on -->
	 */
	public static final String WORK_SITE_L2_CODE = "WORK";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Wound clinic</div>
	 * <!-- @formatter:on -->
	 */
	public static final String WOUND_CLINIC_L4_CODE = "WND";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for youths with adjustment difficulties center</div>
	 * <!-- @formatter:on -->
	 */
	public static final String YOUTHS_WITH_ADJUSTMENT_DIFFICULTIES_CENTER_L5_CODE = "RHYAD";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Identifier of the value set</div>
	 * <div class="de">Identifikator für das Value Set</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_ID = "2.16.840.1.113883.1.11.17660";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Name of the value set</div>
	 * <div class="de">Name des Value Sets</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_NAME = "ServiceDeliveryLocationRoleType";

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
	public static ServiceDeliveryLocationRoleType getEnum(final String code) {
		for (final ServiceDeliveryLocationRoleType x : values()) {
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
			Enum.valueOf(ServiceDeliveryLocationRoleType.class, enumName);
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
		for (final ServiceDeliveryLocationRoleType x : values()) {
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
	ServiceDeliveryLocationRoleType(final String code, final String codeSystem,
			final String displayName, final String displayNameEn, final String displayNameDe,
			final String displayNameFr, final String displayNameIt) {
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
