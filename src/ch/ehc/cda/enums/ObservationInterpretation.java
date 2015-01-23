package ch.ehc.cda.enums;

public enum ObservationInterpretation {

	/** 
	*<div class="de">Positiv Erreger in Probe nachgewiesen</div>
	*<div class="fr">Positif: Agent pathogène dépisté dans l’échantillon</div>
	*/
	POSITIVE_PATHOGEN_FOUND_IN_SPECIMEN ("POS", "Positive: Pathogen found in specimen"),
	/** 
	*<div class="de">Negativ: Erreger konnte in Probe nicht nachgewiesen werden</div>
	*<div class="fr">Négatif: L’agent pathogène n’a pas pu être dépisté dans l’échantillon</div>
	*/
	NEGATIVE_PATHOGEN_COULDNT_BE_DETERMINED_IN_SPECI_MEN ("NEG", "Negative: Pathogen couldn't be determined in speci-men");

	private String code;
	private String displayName;

	ObservationInterpretation (String code, String displayName) {
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