package ch.ehc.cda.enums;

public enum HistoryOfPastIllness {

	/** 
	*<div class="de">Windpocken</div>
	*<div class="fr">Varicelle</div>
	*/
	HO_CHICKENPOX ("38907003", "H/O: chickenpox"),
	/** 
	*<div class="de">Masern</div>
	*<div class="fr">Rougeole</div>
	*/
	HO_MEASLES ("14189004", "H/O: measles"),
	/** 
	*<div class="de">Mumps</div>
	*<div class="fr">Oreillons</div>
	*/
	HO_MUMPS ("36989005", "H/O: mumps"),
	/** 
	*<div class="de">Röteln</div>
	*<div class="fr">Rubéole</div>
	*/
	HO_RUBELLA ("36653000", "H/O: rubella"),
	/** 
	*<div class="de">Hepatitis A</div>
	*<div class="fr">Hépatite A</div>
	*/
	HEPATITIS_A ("40468003", "Hepatitis A"),
	/** 
	*<div class="de">Hepatitis B</div>
	*<div class="fr">Hépatite B</div>
	*/
	HEPATITIS_B ("66071002", "Hepatitis B"),
	/** 
	*<div class="de">FSM</div>
	*<div class="fr">Encéphalite à tiques</div>
	*/
	CENTRAL_EUROPEAN_ENCEPHALITIS ("16901001", "Central European encephalitis"),
	/** 
	*<div class="de">Gelbfieber</div>
	*<div class="fr">Fièvre jaune</div>
	*/
	YELLOW_FEVER ("16541001", "Yellow Fever"),
	/** 
	*<div class="de">Tetanus</div>
	*<div class="fr">Tétanos</div>
	*/
	TETANUS ("76902006", "Tetanus");

	private String code;
	private String displayName;

	HistoryOfPastIllness (String code, String displayName) {
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