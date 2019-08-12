/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */
package org.ehealth_connector.cda.ch.lab.lrep;

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.cda.ch.lab.BaseChSpecimenAct;
import org.ehealth_connector.cda.ihe.lab.AbstractLaboratoryReportDataProcessingEntry;
import org.ehealth_connector.cda.utils.CdaUtil;
import org.ehealth_connector.common.mdht.Identificator;
import org.openhealthtools.mdht.uml.cda.Act;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.cda.ihe.lab.impl.LaboratoryBatteryOrganizerImpl;

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
		CdaUtil.addTemplateIdOnce(getMdht(), new Identificator("2.16.756.5.30.1.1.10.4.4"));
	}

	/**
	 * Instantiates the class with the required elements.
	 *
	 * @param act
	 *            the SpecimentAct
	 */
	public LaboratoryReportDataProcessingEntry(BaseChSpecimenAct act) {
		this();
		setSpecimenAct(act);
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
		CdaUtil.addTemplateIdOnce(getMdht(), new Identificator("2.16.756.5.30.1.1.10.4.4"));
	}

	/**
	 * Gets a list with all laboratory battery organizers.
	 *
	 * @return the laboratory battery organizer liust
	 */
	public List<LaboratoryBatteryOrganizer> getLaboratoryBatteryOrganizers() {
		List<LaboratoryBatteryOrganizer> retVal = new ArrayList<LaboratoryBatteryOrganizer>();

		for (EntryRelationship er : getMdht().getAct().getEntryRelationships()) {
			if (er.getOrganizer() instanceof LaboratoryBatteryOrganizerImpl)
				retVal.add(new LaboratoryBatteryOrganizer(
						((LaboratoryBatteryOrganizerImpl) er.getOrganizer())));
		}
		return retVal;
	}

	/**
	 * Gets the specimen act.
	 *
	 * @return the specimen act
	 */
	public BaseChSpecimenAct getSpecimenAct() {
		if (getMdht().getAct() != null) {
			return new BaseChSpecimenAct(getMdht().getAct());
		}
		return null;
	}

	/**
	 * Sets the specimen act.
	 *
	 * @param specimenAct
	 *            the new specimen act
	 */
	public void setSpecimenAct(BaseChSpecimenAct specimenAct) {
		Act act = specimenAct.copy();
		getMdht().setAct(act);
	}
}
