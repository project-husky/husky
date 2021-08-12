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
package org.ehealth_connector.common.ch.enums;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.processing.Generated;

import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.mdht.enums.ValueSetEnumInterface;

/**
 * <!-- @formatter:off -->
 * Enumeration of HCProfessional.hcProfessionSpecialisationMap values
 *
 * <div class="en">no designation found for language ENGLISH</div>
 * <div class="de">no designation found for language GERMAN</div>
 * <div class="fr">no designation found for language FRENCH</div>
 * <div class="it">no designation found for language ITALIAN</div>
 *
 * Identifier: 2.16.756.5.30.1.127.3.10.8.3
 * Effective date: 2020-05-18 20:00
 * Version: 202004.1-stable
 * Status: FINAL
 * <!-- @formatter:on -->
 */
@Generated(value = "org.ehealth_connector.codegenerator.ch.valuesets.UpdateValueSets", date = "2021-04-22")
public enum HcpProfessionSpecialisationMap implements ValueSetEnumInterface {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Allergology and clinical immunology</div>
	 * <!-- @formatter:on -->
	 */
	ALLERGOLOGY_AND_CLINICAL_IMMUNOLOGY_L1("1019", "2.16.756.5.30.1.127.3.5",
			"Allergology and clinical immunology", "Allergology and clinical immunology",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Anaesthesiology</div>
	 * <!-- @formatter:on -->
	 */
	ANAESTHESIOLOGY_L1("1012", "2.16.756.5.30.1.127.3.5", "Anaesthesiology", "Anaesthesiology",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Angiology</div>
	 * <!-- @formatter:on -->
	 */
	ANGIOLOGY_L1("1041", "2.16.756.5.30.1.127.3.5", "Angiology", "Angiology", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Cardiac and thoracic vascular surgery</div>
	 * <!-- @formatter:on -->
	 */
	CARDIAC_AND_THORACIC_VASCULAR_SURGERY_L1("1004", "2.16.756.5.30.1.127.3.5",
			"Cardiac and thoracic vascular surgery", "Cardiac and thoracic vascular surgery",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Cardiology</div>
	 * <!-- @formatter:on -->
	 */
	CARDIOLOGY_L1("1025", "2.16.756.5.30.1.127.3.5", "Cardiology", "Cardiology", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Child and adolescent psychiatry and psychotherapy</div>
	 * <!-- @formatter:on -->
	 */
	CHILD_AND_ADOLESCENT_PSYCHIATRY_AND_PSYCHOTHERAPY_L1("1027", "2.16.756.5.30.1.127.3.5",
			"Child and adolescent psychiatry and psychotherapy",
			"Child and adolescent psychiatry and psychotherapy", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Child and adolescent psychology</div>
	 * <!-- @formatter:on -->
	 */
	CHILD_AND_ADOLESCENT_PSYCHOLOGY_L1("1055", "2.16.756.5.30.1.127.3.5",
			"Child and adolescent psychology", "Child and adolescent psychology", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Chiropractic specialist</div>
	 * <!-- @formatter:on -->
	 */
	CHIROPRACTIC_SPECIALIST_L1("1011", "2.16.756.5.30.1.127.3.5", "Chiropractic specialist",
			"Chiropractic specialist", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Chiropractor (occupation)</div>
	 * <!-- @formatter:on -->
	 */
	CHIROPRACTOR_OCCUPATION("3842006", "2.16.840.1.113883.6.96", "Chiropractor (occupation)",
			"Chiropractor (occupation)", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Clinical pharmacology and toxicology</div>
	 * <!-- @formatter:on -->
	 */
	CLINICAL_PHARMACOLOGY_AND_TOXICOLOGY_L1("1029", "2.16.756.5.30.1.127.3.5",
			"Clinical pharmacology and toxicology", "Clinical pharmacology and toxicology",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Clinical psychology</div>
	 * <!-- @formatter:on -->
	 */
	CLINICAL_PSYCHOLOGY_L1("1056", "2.16.756.5.30.1.127.3.5", "Clinical psychology",
			"Clinical psychology", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Community pharmacy</div>
	 * <!-- @formatter:on -->
	 */
	COMMUNITY_PHARMACY_L1("1052", "2.16.756.5.30.1.127.3.5", "Community pharmacy",
			"Community pharmacy", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Dentist (occupation)</div>
	 * <!-- @formatter:on -->
	 */
	DENTIST_OCCUPATION("106289002", "2.16.840.1.113883.6.96", "Dentist (occupation)",
			"Dentist (occupation)", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Dermatology and venereology</div>
	 * <!-- @formatter:on -->
	 */
	DERMATOLOGY_AND_VENEREOLOGY_L1("1021", "2.16.756.5.30.1.127.3.5", "Dermatology and venereology",
			"Dermatology and venereology", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Endocrinology – Diabetology</div>
	 * <!-- @formatter:on -->
	 */
	ENDOCRINOLOGY_DIABETOLOGY_L1("1022", "2.16.756.5.30.1.127.3.5", "Endocrinology – Diabetology",
			"Endocrinology – Diabetology", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Forensic medicine</div>
	 * <!-- @formatter:on -->
	 */
	FORENSIC_MEDICINE_L1("1046", "2.16.756.5.30.1.127.3.5", "Forensic medicine",
			"Forensic medicine", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gastroenterology</div>
	 * <!-- @formatter:on -->
	 */
	GASTROENTEROLOGY_L1("1023", "2.16.756.5.30.1.127.3.5", "Gastroenterology", "Gastroenterology",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">General internal medicine</div>
	 * <!-- @formatter:on -->
	 */
	GENERAL_INTERNAL_MEDICINE_L1("1051", "2.16.756.5.30.1.127.3.5", "General internal medicine",
			"General internal medicine", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">General medical practitioner</div>
	 * <!-- @formatter:on -->
	 */
	GENERAL_MEDICAL_PRACTITIONER_L1("1040", "2.16.756.5.30.1.127.3.5",
			"General medical practitioner", "General medical practitioner", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Gynaecology and obstetrics</div>
	 * <!-- @formatter:on -->
	 */
	GYNAECOLOGY_AND_OBSTETRICS_L1("1003", "2.16.756.5.30.1.127.3.5", "Gynaecology and obstetrics",
			"Gynaecology and obstetrics", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Haematology</div>
	 * <!-- @formatter:on -->
	 */
	HAEMATOLOGY_L1("1024", "2.16.756.5.30.1.127.3.5", "Haematology", "Haematology", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Hand surgery</div>
	 * <!-- @formatter:on -->
	 */
	HAND_SURGERY_L1("1059", "2.16.756.5.30.1.127.3.5", "Hand surgery", "Hand surgery",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Health psychology</div>
	 * <!-- @formatter:on -->
	 */
	HEALTH_PSYCHOLOGY_L1("1058", "2.16.756.5.30.1.127.3.5", "Health psychology",
			"Health psychology", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Hospital pharmacy</div>
	 * <!-- @formatter:on -->
	 */
	HOSPITAL_PHARMACY_L1("1053", "2.16.756.5.30.1.127.3.5", "Hospital pharmacy",
			"Hospital pharmacy", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Infectology</div>
	 * <!-- @formatter:on -->
	 */
	INFECTOLOGY_L1("1039", "2.16.756.5.30.1.127.3.5", "Infectology", "Infectology", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Intensive care medicine</div>
	 * <!-- @formatter:on -->
	 */
	INTENSIVE_CARE_MEDICINE_L1("1042", "2.16.756.5.30.1.127.3.5", "Intensive care medicine",
			"Intensive care medicine", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Medical genetics</div>
	 * <!-- @formatter:on -->
	 */
	MEDICAL_GENETICS_L1("1043", "2.16.756.5.30.1.127.3.5", "Medical genetics", "Medical genetics",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Medical oncology</div>
	 * <!-- @formatter:on -->
	 */
	MEDICAL_ONCOLOGY_L1("1044", "2.16.756.5.30.1.127.3.5", "Medical oncology", "Medical oncology",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Nephrology</div>
	 * <!-- @formatter:on -->
	 */
	NEPHROLOGY_L1("1033", "2.16.756.5.30.1.127.3.5", "Nephrology", "Nephrology", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Neurology</div>
	 * <!-- @formatter:on -->
	 */
	NEUROLOGY_L1("1014", "2.16.756.5.30.1.127.3.5", "Neurology", "Neurology", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Neuropsychology</div>
	 * <!-- @formatter:on -->
	 */
	NEUROPSYCHOLOGY_L1("1057", "2.16.756.5.30.1.127.3.5", "Neuropsychology", "Neuropsychology",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Neurosurgery</div>
	 * <!-- @formatter:on -->
	 */
	NEUROSURGERY_L1("1013", "2.16.756.5.30.1.127.3.5", "Neurosurgery", "Neurosurgery",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Nuclear medicine</div>
	 * <!-- @formatter:on -->
	 */
	NUCLEAR_MEDICINE_L1("1031", "2.16.756.5.30.1.127.3.5", "Nuclear medicine", "Nuclear medicine",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Occupational medicine</div>
	 * <!-- @formatter:on -->
	 */
	OCCUPATIONAL_MEDICINE_L1("1020", "2.16.756.5.30.1.127.3.5", "Occupational medicine",
			"Occupational medicine", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Ophthalmology</div>
	 * <!-- @formatter:on -->
	 */
	OPHTHALMOLOGY_L1("1007", "2.16.756.5.30.1.127.3.5", "Ophthalmology", "Ophthalmology",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Oral and maxillofacial surgery</div>
	 * <!-- @formatter:on -->
	 */
	ORAL_AND_MAXILLOFACIAL_SURGERY_L1("1026", "2.16.756.5.30.1.127.3.5",
			"Oral and maxillofacial surgery", "Oral and maxillofacial surgery", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Oral surgery</div>
	 * <!-- @formatter:on -->
	 */
	ORAL_SURGERY_L1("1047", "2.16.756.5.30.1.127.3.5", "Oral surgery", "Oral surgery",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Orthodontics</div>
	 * <!-- @formatter:on -->
	 */
	ORTHODONTICS_L1("1010", "2.16.756.5.30.1.127.3.5", "Orthodontics", "Orthodontics",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Orthopaedic surgery and traumatology of the locomotor apparatus</div>
	 * <!-- @formatter:on -->
	 */
	ORTHOPAEDIC_SURGERY_AND_TRAUMATOLOGY_OF_THE_LOCOMOTOR_APPARATUS_L1("1015",
			"2.16.756.5.30.1.127.3.5",
			"Orthopaedic surgery and traumatology of the locomotor apparatus",
			"Orthopaedic surgery and traumatology of the locomotor apparatus", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Otorhinolaryngology</div>
	 * <!-- @formatter:on -->
	 */
	OTORHINOLARYNGOLOGY_L1("1008", "2.16.756.5.30.1.127.3.5", "Otorhinolaryngology",
			"Otorhinolaryngology", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Paediatrics</div>
	 * <!-- @formatter:on -->
	 */
	PAEDIATRICS_L1("1006", "2.16.756.5.30.1.127.3.5", "Paediatrics", "Paediatrics", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Paediatric surgery</div>
	 * <!-- @formatter:on -->
	 */
	PAEDIATRIC_SURGERY_L1("1028", "2.16.756.5.30.1.127.3.5", "Paediatric surgery",
			"Paediatric surgery", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Paradontology</div>
	 * <!-- @formatter:on -->
	 */
	PARADONTOLOGY_L1("1048", "2.16.756.5.30.1.127.3.5", "Paradontology", "Paradontology",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Pathology</div>
	 * <!-- @formatter:on -->
	 */
	PATHOLOGY_L1("1009", "2.16.756.5.30.1.127.3.5", "Pathology", "Pathology", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Pharmaceutical medicine</div>
	 * <!-- @formatter:on -->
	 */
	PHARMACEUTICAL_MEDICINE_L1("1045", "2.16.756.5.30.1.127.3.5", "Pharmaceutical medicine",
			"Pharmaceutical medicine", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Pharmacist (occupation)</div>
	 * <!-- @formatter:on -->
	 */
	PHARMACIST_OCCUPATION("46255001", "2.16.840.1.113883.6.96", "Pharmacist (occupation)",
			"Pharmacist (occupation)", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Physical medicine and rehabilitation</div>
	 * <!-- @formatter:on -->
	 */
	PHYSICAL_MEDICINE_AND_REHABILITATION_L1("1034", "2.16.756.5.30.1.127.3.5",
			"Physical medicine and rehabilitation", "Physical medicine and rehabilitation",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Physician (occupation)</div>
	 * <!-- @formatter:on -->
	 */
	PHYSICIAN_OCCUPATION("309343006", "2.16.840.1.113883.6.96", "Physician (occupation)",
			"Physician (occupation)", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Plastic, reconstructive and aesthetic surgery</div>
	 * <!-- @formatter:on -->
	 */
	PLASTIC_RECONSTRUCTIVE_AND_AESTHETIC_SURGERY_L1("1035", "2.16.756.5.30.1.127.3.5",
			"Plastic, reconstructive and aesthetic surgery",
			"Plastic, reconstructive and aesthetic surgery", "TOTRANSLATE", "TOTRANSLATE",
			"TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Pneumology</div>
	 * <!-- @formatter:on -->
	 */
	PNEUMOLOGY_L1("1016", "2.16.756.5.30.1.127.3.5", "Pneumology", "Pneumology", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Prevention and public health</div>
	 * <!-- @formatter:on -->
	 */
	PREVENTION_AND_PUBLIC_HEALTH_L1("1036", "2.16.756.5.30.1.127.3.5",
			"Prevention and public health", "Prevention and public health", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Psychiatry and psychotherapy</div>
	 * <!-- @formatter:on -->
	 */
	PSYCHIATRY_AND_PSYCHOTHERAPY_L1("1017", "2.16.756.5.30.1.127.3.5",
			"Psychiatry and psychotherapy", "Psychiatry and psychotherapy", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Psychologist (occupation)</div>
	 * <!-- @formatter:on -->
	 */
	PSYCHOLOGIST_OCCUPATION("59944000", "2.16.840.1.113883.6.96", "Psychologist (occupation)",
			"Psychologist (occupation)", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Psychotherapy</div>
	 * <!-- @formatter:on -->
	 */
	PSYCHOTHERAPY_L1("1054", "2.16.756.5.30.1.127.3.5", "Psychotherapy", "Psychotherapy",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Radiology</div>
	 * <!-- @formatter:on -->
	 */
	RADIOLOGY_L1("1030", "2.16.756.5.30.1.127.3.5", "Radiology", "Radiology", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Radio-oncology / radiotherapy</div>
	 * <!-- @formatter:on -->
	 */
	RADIO_ONCOLOGY_RADIOTHERAPY_L1("1032", "2.16.756.5.30.1.127.3.5",
			"Radio-oncology / radiotherapy", "Radio-oncology / radiotherapy", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Reconstructive dentistry</div>
	 * <!-- @formatter:on -->
	 */
	RECONSTRUCTIVE_DENTISTRY_L1("1049", "2.16.756.5.30.1.127.3.5", "Reconstructive dentistry",
			"Reconstructive dentistry", "TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Rheumatology</div>
	 * <!-- @formatter:on -->
	 */
	RHEUMATOLOGY_L1("1037", "2.16.756.5.30.1.127.3.5", "Rheumatology", "Rheumatology",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Surgery</div>
	 * <!-- @formatter:on -->
	 */
	SURGERY_L1("1002", "2.16.756.5.30.1.127.3.5", "Surgery", "Surgery", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Thoracic surgery</div>
	 * <!-- @formatter:on -->
	 */
	THORACIC_SURGERY_L1("1061", "2.16.756.5.30.1.127.3.5", "Thoracic surgery", "Thoracic surgery",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Tropical and travel medicine</div>
	 * <!-- @formatter:on -->
	 */
	TROPICAL_AND_TRAVEL_MEDICINE_L1("1038", "2.16.756.5.30.1.127.3.5",
			"Tropical and travel medicine", "Tropical and travel medicine", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Urology</div>
	 * <!-- @formatter:on -->
	 */
	UROLOGY_L1("1018", "2.16.756.5.30.1.127.3.5", "Urology", "Urology", "TOTRANSLATE",
			"TOTRANSLATE", "TOTRANSLATE"),
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Vascular surgery</div>
	 * <!-- @formatter:on -->
	 */
	VASCULAR_SURGERY_L1("1060", "2.16.756.5.30.1.127.3.5", "Vascular surgery", "Vascular surgery",
			"TOTRANSLATE", "TOTRANSLATE", "TOTRANSLATE");

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Allergology and clinical immunology</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ALLERGOLOGY_AND_CLINICAL_IMMUNOLOGY_L1_CODE = "1019";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Anaesthesiology</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ANAESTHESIOLOGY_L1_CODE = "1012";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Angiology</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ANGIOLOGY_L1_CODE = "1041";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Cardiac and thoracic vascular surgery</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CARDIAC_AND_THORACIC_VASCULAR_SURGERY_L1_CODE = "1004";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Cardiology</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CARDIOLOGY_L1_CODE = "1025";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Child and adolescent psychiatry and psychotherapy</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CHILD_AND_ADOLESCENT_PSYCHIATRY_AND_PSYCHOTHERAPY_L1_CODE = "1027";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Child and adolescent psychology</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CHILD_AND_ADOLESCENT_PSYCHOLOGY_L1_CODE = "1055";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Chiropractic specialist</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CHIROPRACTIC_SPECIALIST_L1_CODE = "1011";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Chiropractor (occupation)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CHIROPRACTOR_OCCUPATION_CODE = "3842006";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Clinical pharmacology and toxicology</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CLINICAL_PHARMACOLOGY_AND_TOXICOLOGY_L1_CODE = "1029";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Clinical psychology</div>
	 * <!-- @formatter:on -->
	 */
	public static final String CLINICAL_PSYCHOLOGY_L1_CODE = "1056";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Community pharmacy</div>
	 * <!-- @formatter:on -->
	 */
	public static final String COMMUNITY_PHARMACY_L1_CODE = "1052";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Dentist (occupation)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DENTIST_OCCUPATION_CODE = "106289002";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Dermatology and venereology</div>
	 * <!-- @formatter:on -->
	 */
	public static final String DERMATOLOGY_AND_VENEREOLOGY_L1_CODE = "1021";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Endocrinology – Diabetology</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ENDOCRINOLOGY_DIABETOLOGY_L1_CODE = "1022";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Forensic medicine</div>
	 * <!-- @formatter:on -->
	 */
	public static final String FORENSIC_MEDICINE_L1_CODE = "1046";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Gastroenterology</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GASTROENTEROLOGY_L1_CODE = "1023";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for General internal medicine</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GENERAL_INTERNAL_MEDICINE_L1_CODE = "1051";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for General medical practitioner</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GENERAL_MEDICAL_PRACTITIONER_L1_CODE = "1040";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Gynaecology and obstetrics</div>
	 * <!-- @formatter:on -->
	 */
	public static final String GYNAECOLOGY_AND_OBSTETRICS_L1_CODE = "1003";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Haematology</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HAEMATOLOGY_L1_CODE = "1024";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Hand surgery</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HAND_SURGERY_L1_CODE = "1059";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Health psychology</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HEALTH_PSYCHOLOGY_L1_CODE = "1058";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Hospital pharmacy</div>
	 * <!-- @formatter:on -->
	 */
	public static final String HOSPITAL_PHARMACY_L1_CODE = "1053";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Infectology</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INFECTOLOGY_L1_CODE = "1039";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Intensive care medicine</div>
	 * <!-- @formatter:on -->
	 */
	public static final String INTENSIVE_CARE_MEDICINE_L1_CODE = "1042";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Medical genetics</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MEDICAL_GENETICS_L1_CODE = "1043";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Medical oncology</div>
	 * <!-- @formatter:on -->
	 */
	public static final String MEDICAL_ONCOLOGY_L1_CODE = "1044";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Nephrology</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NEPHROLOGY_L1_CODE = "1033";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Neurology</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NEUROLOGY_L1_CODE = "1014";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Neuropsychology</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NEUROPSYCHOLOGY_L1_CODE = "1057";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Neurosurgery</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NEUROSURGERY_L1_CODE = "1013";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Nuclear medicine</div>
	 * <!-- @formatter:on -->
	 */
	public static final String NUCLEAR_MEDICINE_L1_CODE = "1031";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Occupational medicine</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OCCUPATIONAL_MEDICINE_L1_CODE = "1020";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Ophthalmology</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OPHTHALMOLOGY_L1_CODE = "1007";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Oral and maxillofacial surgery</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ORAL_AND_MAXILLOFACIAL_SURGERY_L1_CODE = "1026";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Oral surgery</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ORAL_SURGERY_L1_CODE = "1047";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Orthodontics</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ORTHODONTICS_L1_CODE = "1010";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Orthopaedic surgery and traumatology of the locomotor apparatus</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ORTHOPAEDIC_SURGERY_AND_TRAUMATOLOGY_OF_THE_LOCOMOTOR_APPARATUS_L1_CODE = "1015";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Otorhinolaryngology</div>
	 * <!-- @formatter:on -->
	 */
	public static final String OTORHINOLARYNGOLOGY_L1_CODE = "1008";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Paediatrics</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PAEDIATRICS_L1_CODE = "1006";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Paediatric surgery</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PAEDIATRIC_SURGERY_L1_CODE = "1028";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Paradontology</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PARADONTOLOGY_L1_CODE = "1048";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Pathology</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PATHOLOGY_L1_CODE = "1009";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Pharmaceutical medicine</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PHARMACEUTICAL_MEDICINE_L1_CODE = "1045";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Pharmacist (occupation)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PHARMACIST_OCCUPATION_CODE = "46255001";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Physical medicine and rehabilitation</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PHYSICAL_MEDICINE_AND_REHABILITATION_L1_CODE = "1034";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Physician (occupation)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PHYSICIAN_OCCUPATION_CODE = "309343006";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Plastic, reconstructive and aesthetic surgery</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PLASTIC_RECONSTRUCTIVE_AND_AESTHETIC_SURGERY_L1_CODE = "1035";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Pneumology</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PNEUMOLOGY_L1_CODE = "1016";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Prevention and public health</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PREVENTION_AND_PUBLIC_HEALTH_L1_CODE = "1036";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Psychiatry and psychotherapy</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PSYCHIATRY_AND_PSYCHOTHERAPY_L1_CODE = "1017";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Psychologist (occupation)</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PSYCHOLOGIST_OCCUPATION_CODE = "59944000";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Psychotherapy</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PSYCHOTHERAPY_L1_CODE = "1054";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Radiology</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RADIOLOGY_L1_CODE = "1030";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Radio-oncology / radiotherapy</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RADIO_ONCOLOGY_RADIOTHERAPY_L1_CODE = "1032";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Reconstructive dentistry</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RECONSTRUCTIVE_DENTISTRY_L1_CODE = "1049";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Rheumatology</div>
	 * <!-- @formatter:on -->
	 */
	public static final String RHEUMATOLOGY_L1_CODE = "1037";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Surgery</div>
	 * <!-- @formatter:on -->
	 */
	public static final String SURGERY_L1_CODE = "1002";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Thoracic surgery</div>
	 * <!-- @formatter:on -->
	 */
	public static final String THORACIC_SURGERY_L1_CODE = "1061";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Tropical and travel medicine</div>
	 * <!-- @formatter:on -->
	 */
	public static final String TROPICAL_AND_TRAVEL_MEDICINE_L1_CODE = "1038";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Urology</div>
	 * <!-- @formatter:on -->
	 */
	public static final String UROLOGY_L1_CODE = "1018";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Code for Vascular surgery</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VASCULAR_SURGERY_L1_CODE = "1060";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Identifier of the value set</div>
	 * <div class="de">Identifikator für das Value Set</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_ID = "2.16.756.5.30.1.127.3.10.8.3";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Name of the value set</div>
	 * <div class="de">Name des Value Sets</div>
	 * <!-- @formatter:on -->
	 */
	public static final String VALUE_SET_NAME = "HCProfessional.hcProfessionSpecialisationMap";

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
	public static HcpProfessionSpecialisationMap getEnum(final String code) {
		for (final HcpProfessionSpecialisationMap x : values()) {
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
			Enum.valueOf(HcpProfessionSpecialisationMap.class, enumName);
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
		for (final HcpProfessionSpecialisationMap x : values()) {
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
	HcpProfessionSpecialisationMap(final String code, final String codeSystem,
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
