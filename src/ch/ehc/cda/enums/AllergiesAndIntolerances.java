package ch.ehc.cda.enums;

public enum AllergiesAndIntolerances {

	/** 
	*<div class="de">Überempfindlichkeit des Immunsystems auf bestimmte pharmazeutische Produkte (Arzneimittel).</div>
	*<div class="fr">Hyperréactivité du système immunitaire à certains produits pharmaceutiques (médicaments)</div>
	*/
	DRUG_ALLERGY ("DALG", "Drug Allergy"),
	/** 
	*<div class="de">Unerwünschte Reaktion des Immunsystems bei Anwendung bestimmter Arzneimittel.</div>
	*<div class="fr">Réaction indésirable du système immunitaire lors de l’utilisation de certains médicaments</div>
	*/
	DRUG_INTOLERANCE ("DINT", "Drug Intolerance"),
	/** 
	*<div class="de">Überempfindlichkeit des Immunsystems auf bestimmte Stoffe in Nahrungsmitteln</div>
	*<div class="fr">Hyperréactivité du système immunitaire à certaines substances contenues dans des aliments</div>
	*/
	FOOD_ALLERGY ("FALG", "Food Allergy"),
	/** 
	*<div class="de">Unerwünschte Reaktion des Immunsystems bei Einnahme bestimmter Nahrungsmittel.</div>
	*<div class="fr">Réaction indésirable du système immunitaire en cas d’absorption de certains aliments.</div>
	*/
	FOOD_INTOLERANCE ("FINT", "Food Intolerance");

	private String code;
	private String displayName;

	AllergiesAndIntolerances (String code, String displayName) {
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