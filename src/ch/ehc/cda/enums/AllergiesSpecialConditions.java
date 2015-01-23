package ch.ehc.cda.enums;

public enum AllergiesSpecialConditions {

	/** 
	*<div class="de">Patient hat Allergie/Unverträglichkeit auf eine unbekannte Substanz</div>
	*<div class="fr">Le patient présente une allergie/intolérance à une substance inconnue.</div>
	*/
	SUBSTANCE_TYPE_UNKNOWN ("64970000", "Substance Type Unknown"),
	/** 
	*<div class="de">Keine Allergien bekannt</div>
	*<div class="fr">Aucune allergie connue</div>
	*/
	NO_KNOWN_ALLERGIES ("160244002", "No Known Allergies"),
	/** 
	*<div class="de">Keine Unverträglichkeiten von Medikamenten bekannt</div>
	*<div class="fr">Aucune intolérance à des médicaments connue</div>
	*/
	NO_KNOWN_DRUG_ALLERGIES ("409137002", "No Known Drug Allergies");

	private String code;
	private String displayName;

	AllergiesSpecialConditions (String code, String displayName) {
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