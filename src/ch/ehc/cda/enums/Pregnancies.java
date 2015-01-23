package ch.ehc.cda.enums;

public enum Pregnancies {

	/** 
	*<div class="de">Entbindungsdatum (klinische Schätzung)</div>
	*<div class="fr">Date de l’accouchement (estimation clinique)</div>
	*/
	DELIVERY_DATE_CLINICAL_ESTIMATE ("11778-8", "DELIVERY DATE (CLINICAL ESTIMATE)");

	private String code;
	private String displayName;

	Pregnancies (String code, String displayName) {
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