package org.ehealth_connector.cda.ch.enums;

import java.util.Arrays;

import org.ehealth_connector.common.Code;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;

/*
 *<div class="de">Quelle für Subset: [IHE PCC TF-2], Table 6.3.4.16.7-1</div>
 *<div class="fr">Source du sous-ensemble : [IHE PCC TF-2],Table 6.3.4.16.7-1</div>
 */
public enum MedicationsSpecialConditions {

	/** 
	 *<div class="de">Medikamentöse Therapie unbekannt</div>
	 *<div class="fr">Traitement médicamenteux inconnu</div>
	 */
	DRUG_TREATMENT_UNKNOWN ("182904002", "Drug Treatment Unknown"),
	/** 
	 *<div class="de">Keine medikamentöse Therapie verschrieben</div>
	 *<div class="fr">Aucun traitement médicamenteux prescrit</div>
	 */
	NO_DRUG_THERAPY_PRESCRIBED ("182849000", "No Drug Therapy Prescribed"),
	/** 
	 *<div class="de">Patient gibt an, keine Medikamente einzunehmen</div>
	 *<div class="fr">Le patient indique qu’il ne prend pas de médicaments.</div>
	 */
	PATIENT_NOT_ON_SELF_MEDICATIONS ("408350003", "Patient Not On Self-Medications"),
	/** 
	 *<div class="de">Patient lehnt die Impfung ab</div>
	 *<div class="fr">Le patient refuse la vaccination.</div>
	 */
	MEDICATION_REFUSED_PATIENT_OBJECTIVE ("406149000", "Medication refused, Patient Objective");
	public static final String DRUG_TREATMENT_UNKNOWN_CODE="182904002";
	public static final String NO_DRUG_THERAPY_PRESCRIBED_CODE="182849000";
	public static final String PATIENT_NOT_ON_SELF_MEDICATIONS_CODE="408350003";
	public static final String MEDICATION_REFUSED_PATIENT_OBJECTIVE_CODE="406149000";


	public static final String CODE_SYSTEM="2.16.840.1.113883.6.96";
	public static final String CODE_SYSTEM_NAME="SNOMED CT";


	public static MedicationsSpecialConditions getEnum(String code) {
		for (MedicationsSpecialConditions x : values()) {
			if (x.getCodeValue().equals(code)) {
				return x;
			}
		}
		return null;
	}
	private String code;

	private String displayName;

	MedicationsSpecialConditions (String code, String displayName) {
		this.code = code;
		this.displayName = displayName;
	}

	public CD getCD() {
		CD cd = DatatypesFactory.eINSTANCE.createCD();
		cd.setCodeSystem(CODE_SYSTEM);
		cd.setCode(code);
		cd.setDisplayName(displayName);
		return cd;
	}

	public Code getCode() {
		Code ehcCode = new Code(CODE_SYSTEM, code, displayName);
		return ehcCode;
	}

	public String getCodeSystemId() {
		return CODE_SYSTEM;
	}

	public String getCodeSystemName() {
		return CODE_SYSTEM_NAME;
	}

	public String getCodeValue() {
		return code;
	}

	public String getdisplayName() {
		return displayName;
	}

	public boolean isEnumOfValueSet(String enumStr) {
		return Arrays.asList(values()).contains(enumStr);
	}
	public boolean isInValueSet(String code) {
		for (MedicationsSpecialConditions x : values()) {
			if (x.getCodeValue().equals(code)) {
				return true;
			}
		}
		return false;
	}

}