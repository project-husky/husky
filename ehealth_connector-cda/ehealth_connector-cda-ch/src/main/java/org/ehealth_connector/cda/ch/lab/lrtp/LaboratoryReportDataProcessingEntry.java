/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2016
 *
 *******************************************************************************/
package org.ehealth_connector.cda.ch.lab.lrtp;

import org.ehealth_connector.cda.ihe.lab.AbstractLaboratoryReportDataProcessingEntry;

/**
 * The Class LaboratoryReportDataProcessingEntry.
 *
 * <div class="en">Each Laboratory Specialty section MUST contain exactly one
 * Laboratory Report Data Processing Entry</div> <div class="de">Jede Befundart
 * MUSS nach der Vorlage von IHE XD-LAB genau eine Befundgruppe (CDA Body Entry)
 * enthalten. </div>
 */
public class LaboratoryReportDataProcessingEntry
		extends AbstractLaboratoryReportDataProcessingEntry {

	/**
	 * Instantiates a new laboratory report data processing entry.
	 */
	public LaboratoryReportDataProcessingEntry() {
		super();
	}

	/**
	 * Instantiates a new laboratory report data processing entry.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public LaboratoryReportDataProcessingEntry(
			org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryReportDataProcessingEntry mdht) {
		super(mdht);
	}

	/**
	 * Instantiates the class with the required elements.
	 *
	 * @param act
	 *            the SpecimentAct
	 */
	public LaboratoryReportDataProcessingEntry(SpecimenAct act) {
		this();
		setSpecimenAct(act);
	}

	/**
	 * Gets the specimen act.
	 *
	 * @return the specimen act
	 */
	public SpecimenAct getSpecimenAct() {
		if (getMdht().getAct() != null) {
			return new SpecimenAct(getMdht().getAct());
		}
		return null;
	}

	/**
	 * Sets the specimen act.
	 *
	 * @param specimenAct
	 *            the new specimen act
	 */
	public void setSpecimenAct(SpecimenAct specimenAct) {
		getMdht().setAct(specimenAct.copy());
	}
}