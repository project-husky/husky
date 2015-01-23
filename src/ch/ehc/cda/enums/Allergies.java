package ch.ehc.cda.enums;

public enum Allergies {

	/** 
	*<div class="de">Hühnereiweiss</div>
	*<div class="fr">Protéine d’œufs de poule</div>
	*/
	EGG_PROTEIN_SUBSTANCE ("303300008", "Egg protein (substance)"),
	/** 
	*<div class="de">Atopisches Ekzem</div>
	*<div class="fr">Eczéma atopique</div>
	*/
	ATOPIC_DERMATITIS ("24079001", "Atopic dermatitis");

	private String code;
	private String displayName;

	Allergies (String code, String displayName) {
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