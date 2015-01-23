package ch.ehc.cda.enums;

public enum RouteOfAdministration {

	/** 
	*<div class="de">Injektion, intradermal</div>
	*<div class="fr">Injection intradermique</div>
	*/
	INJECTION_INTRADERMAL ("IDINJ", "Injection, intradermal "),
	/** 
	*<div class="de">Inhalation, Vernebelung, nasal</div>
	*<div class="fr">Inhalation par nébulisation nasale</div>
	*/
	INHALATION_NEBULIZATION_NASAL ("NASNEB", "Inhalation, nebulization, nasal "),
	/** 
	*<div class="de">Schlucken, oral</div>
	*<div class="fr">Prendre par la bouche</div>
	*/
	SWALLOW_ORAL ("PO", "Swallow, oral "),
	/** 
	*<div class="de">Injektion, subkutan</div>
	*<div class="fr">Injection sous-cutanée</div>
	*/
	INJECTION_SUBCUTANEOUS ("SQ", "Injection, subcutaneous "),
	/** 
	*<div class="de">Diffusion, transdermal</div>
	*<div class="fr">Diffusion transdermique</div>
	*/
	DIFFUSION_TRANSDERMAL ("TRNSDERMD", "Diffusion, transdermal "),
	/** 
	*<div class="de">Injektion, intramuskulär</div>
	*<div class="fr">Injection intra-musculaire</div>
	*/
	INJECTION_INTRAMUSCULAR ("IM", "Injection, intramuscular");

	private String code;
	private String displayName;

	RouteOfAdministration (String code, String displayName) {
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