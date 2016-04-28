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
package org.ehealth_connector.cda.ch.lab.lrqc;

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.cda.ch.lab.lrqc.enums.SpecialtySections;
import org.ehealth_connector.cda.ihe.lab.NonHumanSubject;
import org.ehealth_connector.cda.ihe.lab.SpecimenCollectionEntry;
import org.ehealth_connector.cda.utils.CdaUtil;
import org.openhealthtools.mdht.uml.cda.Act;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.cda.Organizer;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;

/**
 * The Class SpecimenAct <div class="de">Probenuntersuchung</div>.
 */
public class SpecimenAct extends org.ehealth_connector.cda.ch.lab.AbstractSpecimenAct {

	/**
	 * Standard constructor.
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
	 * Instantiates the class with the required elements.
	 *
	 * @param code
	 *            the code for the SpecimenAct
	 * @param entry
	 *            the SpecimenCollectionEntry
	 * @param organizer
	 *            the LaboratoryBatteryOrganizer
	 * @param nonHumanSubject
	 *            the specimen <div class="de">Angaben zur Probe.</div>
	 */
	public SpecimenAct(SpecialtySections code, SpecimenCollectionEntry entry,
			LaboratoryBatteryOrganizer organizer, NonHumanSubject nonHumanSubject) {
		this();
		setCode(code);
		addSpecimenCollectionEntry(entry);
		addLaboratoryBatteryOrganizer(organizer);
		setNonHumanSubject(nonHumanSubject);
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
	 * Adds the specimen collection entry.
	 *
	 * @param entry
	 *            the entry
	 */
	public void addSpecimenCollectionEntry(SpecimenCollectionEntry entry) {
		getMdht().addProcedure(entry.copy());
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
	 * Gets information regarding the specimen.
	 *
	 * @return nonHumanSubject the specimen <div class="de">Angaben zur
	 *         Probe.</div>
	 */
	public NonHumanSubject getNonHumanSubject() {
		if (getMdht().getSubject() != null) {
			return new NonHumanSubject(
					(org.openhealthtools.mdht.uml.cda.ihe.lab.NonHumanSubject) getMdht()
							.getSubject());
		}
		return null;
	}

	/**
	 * Gets the specimen collection entries.
	 *
	 * @return the specimen collection entries
	 */
	public List<SpecimenCollectionEntry> getSpecimenCollectionEntries() {
		final List<SpecimenCollectionEntry> scel = new ArrayList<SpecimenCollectionEntry>();
		for (final EntryRelationship e : getMdht().getEntryRelationships()) {
			if (e.getProcedure() instanceof org.openhealthtools.mdht.uml.cda.ihe.lab.SpecimenCollection) {
				scel.add(new SpecimenCollectionEntry(
						(org.openhealthtools.mdht.uml.cda.ihe.lab.SpecimenCollection) e
								.getProcedure()));
			}
		}
		return scel;
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

	/**
	 * Sets information regarding the specimen.
	 *
	 * @param nonHumanSubject
	 *            the specimen <div class="de">Angaben zur Probe.</div>
	 */
	public void setNonHumanSubject(NonHumanSubject nonHumanSubject) {
		getMdht().setSubject(nonHumanSubject.copy());
	}
}
