package ch.ehc.cda.enums;

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

	private String code;
	private String displayName;

	MedicationsSpecialConditions (String code, String displayName) {
		this.code = code;
		this.displayName = displayName;
	}

	public String getCode() {
		return this.code;
	}

	public String getdisplayName() {
		return this.displayName;
	}

}