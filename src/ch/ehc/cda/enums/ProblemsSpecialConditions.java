package ch.ehc.cda.enums;

public enum ProblemsSpecialConditions {

	/** 
	*<div class="de">Keine relevante Anamnese</div>
	*<div class="fr">Aucune anamnèse pertinente</div>
	*/
	NO_SIGNIFICANT_MEDICAL_HISTORY ("160243008", "No Significant Medical History"),
	/** 
	*<div class="de">Patient hat keine aktuellen Probleme</div>
	*<div class="fr">Aucun problème actuel</div>
	*/
	NO_CURRENT_PROBLEMS_OR_DISABILITY ("160245001", "No current problems or disability"),
	/** 
	*<div class="de">Keine Anamnese bekannt</div>
	*<div class="fr">Aucune anamnèse connue</div>
	*/
	HISTORY_OF_PAST_ILLNESS_UNKNOWN ("396782006", "History of Past Illness unknown"),
	/** 
	*<div class="de">Keine Familienanamnese bekannt</div>
	*<div class="fr">Aucun antécédent familial connu</div>
	*/
	FAMILY_HISTORY_UNKNOWN ("407559004", "Family History Unknown");

	private String code;
	private String displayName;

	ProblemsSpecialConditions (String code, String displayName) {
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