package ch.ehc.cda.enums;

public enum Serologie {

	/** 
	*<div class="de">Windpocken</div>
	*<div class="fr">Varicelle</div>
	*/
	VARICELLA_ZOSTER_VIRUS_AB_IGG ("22602-7", "Varicella zoster virus Ab.IgG"),
	/** 
	*<div class="de">Masern</div>
	*<div class="fr">Rougeole</div>
	*/
	MEASLES_VIRUS_AB_IGG ("22502-9", "Measles virus Ab.IgG"),
	/** 
	*<div class="de">Mumps</div>
	*<div class="fr">Oreillons</div>
	*/
	MUMPS_VIRUS_AB_IGG ("22417-0", "Mumps virus Ab.IgG"),
	/** 
	*<div class="de">Röteln</div>
	*<div class="fr">Rubéole</div>
	*/
	RUBELLA_VIRUS_AB_IGG ("41763-4", "Rubella virus Ab.IgG"),
	/** 
	*<div class="de">Hepatitis A</div>
	*<div class="fr">Hépatite A</div>
	*/
	HEPATITIS_A_VIRUS_AB_IGG ("22313-1", "Hepatitis A virus Ab.IgG"),
	/** 
	*<div class="de">Hepatitis B</div>
	*<div class="fr">Hépatite B</div>
	*/
	HEPATITIS_B_VIRUS_SURFACE_AB_IGG ("16935-9", "Hepatitis B virus surface Ab.IgG"),
	/** 
	*<div class="de">FSME</div>
	*<div class="fr">Encéphalite à tiques</div>
	*/
	EUROPEAN_TICK_BORNE_ENCEPHALITIS_VIRUS_AB ("26061-2", "European tick borne encephalitis virus Ab"),
	/** 
	*<div class="de">Gelbfieber</div>
	*<div class="fr">Fièvre jaune</div>
	*/
	YELLOW_FEVER_VIRUS_AB ("6589-6", "Yellow fever virus Ab"),
	/** 
	*<div class="de">Tetanus</div>
	*<div class="fr">Tétanos</div>
	*/
	CLOSTRIDIUM_TETANI_TOXIN_AB_IGG ("58770-9", "Clostridium tetani toxin Ab.IgG");

	private String code;
	private String displayName;

	Serologie (String code, String displayName) {
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