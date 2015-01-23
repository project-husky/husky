package ch.ehc.cda.enums;

public enum Severity {

	/** 
	*<div class="de">Hoher Schweregrad</div>
	*<div class="fr">Score de sévérité élevé</div>
	*/
	HIGH_SEVERITY ("H", "high severity"),
	/** 
	*<div class="de">Mittlerer Schweregrad</div>
	*<div class="fr">Score de sévérité moyen</div>
	*/
	MODERATE_SEVERITY ("M", "moderate severity"),
	/** 
	*<div class="de">Leichter Schweregrad</div>
	*<div class="fr">Score de sévérité bas</div>
	*/
	LOW_SEVERITY ("L", "low severity");

	private String code;
	private String displayName;

	Severity (String code, String displayName) {
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