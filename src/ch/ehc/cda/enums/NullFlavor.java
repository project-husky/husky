package ch.ehc.cda.enums;

public enum NullFlavor {

	/** 
	*<div class="de">Gefragt, aber keine Antwort erhalten</div>
	*<div class="fr">Question posée, mais aucune réponse reçue</div>
	*/
	ASKED_BUT_UNKNOWN ("ASKU", "asked but unknown"),
	/** 
	*<div class="de">Patient wünscht keine Weitergabe dieser Information</div>
	*<div class="fr">Le patient ne souhaite pas que cette information soit transmise.</div>
	*/
	MASKED ("MSK", "masked"),
	/** 
	*<div class="de">Nicht gefragt</div>
	*<div class="fr">Non demandé</div>
	*/
	NOT_ASKED ("NASK", "not asked"),
	/** 
	*<div class="de">Vorübergehend unbekannt, wird später ausgefüllt</div>
	*<div class="fr">Actuellement non connu, sera rempli plus tard.</div>
	*/
	TEMPORARILY_UNAVAILABLE ("NAV", "temporarily unavailable"),
	/** 
	*<div class="de">Unbekannt, ohne weitere Präzisierung</div>
	*<div class="fr">Non connu, sans autre précision</div>
	*/
	UNKNOWN ("UNK", "unknown");

	private String code;
	private String displayName;

	NullFlavor (String code, String displayName) {
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