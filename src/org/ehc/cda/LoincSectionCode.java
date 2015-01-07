package org.ehc.cda;

/**
 * Defines the LOINC codes used for the different sections in CDA document.
 * 
 * @see document Austauschformat, p. 80. CDA Body Level 2 Section Codes.
 * @author gsc
 */
public enum LoincSectionCode {
	HISTORY_OF_IMMUNIZATION("11369-6"),
	HISTORY_OF_PAST_ILLNESS("11348-0"),
	ACTIVE_PROBLEMS("11450-4"),
	SEROLOGY_STUDIES("18727-8"),
	ALLERGIES_REACTIONS("48765-2"),
	TREATMENT_PLAN("18776-5");

	
	private String loincCode;
	
	LoincSectionCode(String loincCode) {
		this.loincCode = loincCode;
	}

	public String getLoincCode() {
		return loincCode;
	}

	public static boolean isHistoryOfPastIllness(String code) {
		return HISTORY_OF_PAST_ILLNESS.getLoincCode().equals(code);
	}

	public static boolean isHistoryOfImmunization(String code) {
		return HISTORY_OF_IMMUNIZATION.getLoincCode().equals(code);
	}
	
	public static boolean isAllergiesReactions(String code) {
		return ALLERGIES_REACTIONS.getLoincCode().equals(code);
	}


	public static boolean isActiveProblems(String code) {
		return ACTIVE_PROBLEMS.getLoincCode().equals(code);
	}

	public static boolean isLaboratorySpeciality(String code) {
		return SEROLOGY_STUDIES.getLoincCode().equals(code);
	}
	
	public static boolean isTreatmentPlan(String code) {
		return TREATMENT_PLAN.getLoincCode().equals(code);
	}
}
