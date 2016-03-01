package org.ehealth_connector.cda.ch.lab.lrph.enums;

public enum LabObsListLoinc {

	/**
	 * <div class="en">Brucella</div>
	 */
	BRUCELLA("25178-5", "Amikacin 30 ug/mL [Susceptibility] by Method for Slow-growing mycobacteria",
			"18725-2", "initials", "20130527", "");

	public static LabObsListLoinc getEnum(String code) {
		return BRUCELLA;
	}

	private LabObsListLoinc(String code, String displayName, String sectionCode,
			String patientPrivacyFilter, String validFrom, String validTo) {
	}

	public String getSectionCode() {
		return "18769-0";
	}

}
