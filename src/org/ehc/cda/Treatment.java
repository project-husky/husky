package org.ehc.cda;

import java.util.List;

/**
 * Treatment ist eine Impfempfehlung die einen oder mehrere Impfstoffe an einem
 * bestimmten Datum oder Periode empfiehlt. 
 * 
 * @author gsc
 */
public class Treatment {

	private List<String> vaccineNames;

	public List<String> getVaccineNames() {
		return vaccineNames;
	}

	public void setVaccineNames(List<String> vaccineNames) {
		this.vaccineNames = vaccineNames;
	}
	
}
