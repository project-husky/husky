package org.ehc.cda;

/**
 * Defines all diseases used in a Immunization context.
 * 
 * The procedure codes can be found in file cda-ch-vacd-voc.xml
 * (Schematron validation file).
 * 
 * @author gsc
 */
public enum Disease {
	DIPHTERIE("397428000", "76668005"), 
	TETANUS("76902006", "127786006"), 
	PERTUSSIS("27836007", "39343008"), 
	POLIO("398102009", "72093006"), 
	HIB("91428005", "127787002"), 
	HEPATITE_B("66071002", "16584000"), 
	MEASLES("14189004", "47435007"),
	MUMPS("36989005", "50583002"), 
	RUBELLA("36653000", "82314000"),
	VARICELLA("38907003", "68525005"),
	HEPATITE_A("40468003", "243789007"),
	CE_ENCEPHALITIS("16901001", "281658005"),
	YELLOW_FEVER("16541001", "67308009");
	
	private String snomedCode;
	private String snomedCodeProcedure;

	private Disease() {
		this(null);
	}
		
	private Disease(String snomedCode) {
		this.snomedCode = snomedCode;
		this.snomedCodeProcedure = "tbd";
	}
	
	Disease(String snomedCode, String procedureCode) {
		this.snomedCode = snomedCode;
		this.snomedCodeProcedure = procedureCode;
	}	

	public String getSnomedCode() {
		return snomedCode;
	}
	
	public String getProcedureCode() {
		return snomedCodeProcedure;
	}
}
