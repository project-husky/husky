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
package org.ehealth_connector.cda.ch.lab.lrtp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.ehealth_connector.cda.ch.lab.lrtp.enums.SpecialtySections;
import org.ehealth_connector.cda.utils.CdaUtilMdht;
import org.openhealthtools.mdht.uml.cda.Act;
import org.openhealthtools.mdht.uml.cda.Organizer;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;

/**
 * The Class SpecimenAct <div class="de">Probenuntersuchung</div>.
 */
public class SpecimenAct extends org.ehealth_connector.cda.ch.lab.BaseChSpecimenAct {

	/**
	 * This class implements the default comparison algorithm for HL7 CDA
	 * Battery Organizers.
	 */
	private class LaboratoryBatteryOrganizerComparator
			implements Comparator<LaboratoryBatteryOrganizer> {

		/**
		 *
		 * Compares two Organizers on their effective date timestamp.
		 *
		 * {@inheritDoc}
		 *
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		@Override
		public int compare(LaboratoryBatteryOrganizer a, LaboratoryBatteryOrganizer b) {
			if ((a == null) && (b == null))
				return 0;
			else if ((a == null) && (b != null))
				return -1;
			else if ((a != null) && (b == null))
				return 1;
			else {
				if ((a.getEffectiveTime() == null) && (b.getEffectiveTime() == null))
					return 0;
				else if ((a.getEffectiveTime() == null) && (b.getEffectiveTime() != null))
					return -1;
				else if ((a.getEffectiveTime() != null) && (b.getEffectiveTime() == null))
					return 1;
				else
					return a.getEffectiveTime().compareTo(b.getEffectiveTime());
			}
		}
	}

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
	@Override
	public void addLaboratoryBatteryOrganizer(
			LaboratoryBatteryOrganizer laboratoryBatteryOrganizer) {
		getMdht().addOrganizer(laboratoryBatteryOrganizer.copy());
		// Set the right type for the entryRelationship
		CdaUtilMdht.setEntryRelationshipTypeCode(getMdht().getEntryRelationships(),
				x_ActRelationshipEntryRelationship.COMP);
	}

	/**
	 * Gets the laboratory battery organizers.
	 *
	 * @return the laboratory battery organizers
	 */
	public List<LaboratoryBatteryOrganizer> getLrtpLaboratoryBatteryOrganizers() {
		final List<LaboratoryBatteryOrganizer> list = new ArrayList<LaboratoryBatteryOrganizer>();
		if ((getMdht() != null) && (getMdht().getOrganizers() != null)) {
			for (final Organizer organizer : this.getMdht().getOrganizers()) {
				if (organizer instanceof org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryBatteryOrganizer) {
					final org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryBatteryOrganizer iheOrganizer = (org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryBatteryOrganizer) organizer;
					list.add(new LaboratoryBatteryOrganizer(iheOrganizer));
				}
			}
		}
		list.sort(new LaboratoryBatteryOrganizerComparator());
		return list;
	}

	/**
	 * Sets the code.
	 *
	 * @param code
	 *            the new code
	 */
	@Override
	public void setCode(SpecialtySections code) {
		getMdht().setCode(code.getCE());
	}
}
