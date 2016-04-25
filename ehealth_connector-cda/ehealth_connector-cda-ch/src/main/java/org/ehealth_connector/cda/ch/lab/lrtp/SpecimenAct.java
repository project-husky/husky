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

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.cda.ch.lab.lrtp.enums.SpecialtySections;
import org.ehealth_connector.cda.utils.CdaUtil;
import org.openhealthtools.mdht.uml.cda.Act;
import org.openhealthtools.mdht.uml.cda.Organizer;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;

/**
 * The Class SpecimenAct <div class="de">Probenuntersuchung</div>.
 */
public class SpecimenAct extends org.ehealth_connector.cda.ch.lab.AbstractSpecimenAct {

	/**
	 * Instantiates a new specimen act.
	 */
	public SpecimenAct() {
		super();
	}

	/**
	 * Instantiates this class with the underlying MDHT object.
	 *
	 * @param mdht
	 *            the MDHT object
	 */
	public SpecimenAct(Act mdht) {
		super(mdht);
	}

	/**
	 * Instantiates a new specimen act.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public SpecimenAct(org.openhealthtools.mdht.uml.cda.ihe.lab.SpecimenAct mdht) {
		super(mdht);
	}

	/**
	 * Instantiates the class with the required elements.
	 *
	 * @param code
	 *            the code for the SpecimenAct
	 * @param organizer
	 *            the LaboratoryBatteryOrganizer
	 */
	public SpecimenAct(SpecialtySections code, LaboratoryBatteryOrganizer organizer) {
		this();
		setCode(code);
		addLaboratoryBatteryOrganizer(organizer);
	}

	/**
	 * Adds the laboratory battery organizer.
	 *
	 * @param laboratoryBatteryOrganizer
	 *            the laboratory battery organizer
	 */
	public void addLaboratoryBatteryOrganizer(
			LaboratoryBatteryOrganizer laboratoryBatteryOrganizer) {
		getMdht().addOrganizer(laboratoryBatteryOrganizer.copy());
		// Set the right type for the entryRelationship
		CdaUtil.setEntryRelationshipTypeCode(getMdht().getEntryRelationships(),
				x_ActRelationshipEntryRelationship.COMP);
	}

	/**
	 * Gets the laboratory battery organizers.
	 *
	 * @return the laboratory battery organizers
	 */
	public List<LaboratoryBatteryOrganizer> getLaboratoryBatteryOrganizers() {
		final List<LaboratoryBatteryOrganizer> list = new ArrayList<LaboratoryBatteryOrganizer>();
		if ((getMdht() != null) && (getMdht().getOrganizers() != null)) {
			for (final Organizer organizer : this.getMdht().getOrganizers()) {
				if (organizer instanceof org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryBatteryOrganizer) {
					final org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryBatteryOrganizer iheOrganizer = (org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryBatteryOrganizer) organizer;
					list.add(new LaboratoryBatteryOrganizer(iheOrganizer));
				}
			}
		}
		return list;
	}

	/**
	 * Sets the code.
	 *
	 * @param code
	 *            the new code
	 */
	public void setCode(SpecialtySections code) {
		getMdht().setCode(code.getCE());
	}
}
