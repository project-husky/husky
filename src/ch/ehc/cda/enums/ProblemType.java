package ch.ehc.cda.enums;

public enum ProblemType {

	/** 
	*<div class="de">Problem</div>
	*<div class="fr">Problème</div>
	*/
	PROBLEM ("55607006", "Problem "),
	/** 
	*<div class="de">Krankheit</div>
	*<div class="fr">Maladie</div>
	*/
	CONDITION ("64572001", "Condition"),
	/** 
	*<div class="de">Funktionale Einschränkung</div>
	*<div class="fr">Limitation fonctionnelle</div>
	*/
	FUNCTIONAL_LIMITATION ("248536006", "Functional limitation "),
	/** 
	*<div class="de">Diagnose</div>
	*<div class="fr">Diagnostic</div>
	*/
	DIAGNOSIS ("282291009", "Diagnosis"),
	/** 
	*<div class="de">Befund</div>
	*<div class="fr">Résultat</div>
	*/
	FINDING ("404684003", "Finding "),
	/** 
	*<div class="de">Beschwerde</div>
	*<div class="fr">Plainte</div>
	*/
	COMPLAINT ("409586006", "Complaint "),
	/** 
	*<div class="de">Symptom</div>
	*<div class="fr">Symptôme</div>
	*/
	SYMPTOM ("418799008", "Symptom ");

	private String code;
	private String displayName;

	ProblemType (String code, String displayName) {
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