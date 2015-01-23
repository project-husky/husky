package ch.ehc.cda.enums;

public enum ImmunologicalDisorders {

	/** 
	*<div class="de">Autoimunkrankheit</div>
	*<div class="fr">Maladie auto-immune</div>
	*/
	AUTOIMMUNE_DISEASE ("85828009", "Autoimmune disease"),
	/** 
	*<div class="de">Rheumatismus</div>
	*<div class="fr">Rhumatisme</div>
	*/
	RHEUMATISM ("396332003", "Rheumatism"),
	/** 
	*<div class="de">Medikamentöse Immunsuppression</div>
	*<div class="fr">Immunosuppression médicamenteuse</div>
	*/
	DRUG_INDUCED_IMMUNODEFICIENCY ("234645009", "Drug-induced immunodeficiency"),
	/** 
	*<div class="de">HIV-Infektion</div>
	*<div class="fr">Infection VIH</div>
	*/
	HUMAN_IMMUNODEFICIENCY_VIRUS_INFECTION ("86406008", "Human immunodeficiency virus infection"),
	/** 
	*<div class="de">Splenektomie</div>
	*<div class="fr">Splénectomie</div>
	*/
	HO_SPLENECTOMY ("161626009", "H/O: splenectomy"),
	/** 
	*<div class="de">Asplenie</div>
	*<div class="fr">Asplénie</div>
	*/
	FUNCTIONAL_ASPLENIA ("38096003", "Functional asplenia"),
	/** 
	*<div class="de">Antikörpermangel</div>
	*<div class="fr">Déficience en anticorps</div>
	*/
	SPECIFIC_ANTIBODY_DEFICIENCY ("234556002", "Specific antibody deficiency"),
	/** 
	*<div class="de">Defizite des Komplementsystems</div>
	*<div class="fr">Déficits du système du complément</div>
	*/
	COMPLEMENT_DEFICIENCY_DISEASE ("24743004", "Complement deficiency disease"),
	/** 
	*<div class="de">Sichelzellenanämie</div>
	*<div class="fr">Anémie falciforme</div>
	*/
	SICKLE_CELL_ANEMIA ("160320002", "Sickle cell anemia"),
	/** 
	*<div class="de">Defizite im Mannan-bindenden Lektin</div>
	*<div class="fr">Déficits de la lectine de liaison des mannanes</div>
	*/
	MANNAN_BINDING_PROTEIN_DEFICIENCY ("234579001", "Mannan-binding protein deficiency"),
	/** 
	*<div class="de">Protein-C-Defizit</div>
	*<div class="fr"> Déficit en protéine C</div>
	*/
	PROTEIN_C_DEFICIENCY_DISEASE ("76407009", "Protein C deficiency disease"),
	/** 
	*<div class="de">Protein-S-Defizit</div>
	*<div class="fr"> Déficit en protéine S</div>
	*/
	PROTEIN_S_DEFICIENCY_DISEASE ("1563006", "Protein S deficiency disease ");

	private String code;
	private String displayName;

	ImmunologicalDisorders (String code, String displayName) {
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