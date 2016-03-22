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

public class SpecimenAct extends org.ehealth_connector.cda.ch.lab.AbstractSpecimenAct {

	/**
	 * Standard constructor
	 */
	public SpecimenAct() {
		super();
	}

	/**
	 * Instantiates this class with the underlying MDHT object
	 *
	 * @param mdht
	 *          the MDHT object
	 */
	public SpecimenAct(Act mdht) {
		super(mdht);
	}

	/**
	 * Instantiates the class with the required elements
	 *
	 * @param code
	 *          the code for the SpecimenAct
	 * @param entry
	 *          the SpecimenCollectionEntry
	 * @param organizer
	 *          the LaboratoryBatteryOrganizer
	 * @param nonHumanSubject
	 *          the specimen <div class="de">Angaben zur Probe.</div>
	 */
	public SpecimenAct(SpecialtySections code, SpecimenCollectionEntry entry,
			LaboratoryBatteryOrganizer organizer, NonHumanSubject nonHumanSubject) {
		this();
		setCode(code);
		addSpecimenCollectionEntry(entry);
		addLaboratoryBatteryOrganizer(organizer);
		setNonHumanSubject(nonHumanSubject);
	}

	public void addLaboratoryBatteryOrganizer(LaboratoryBatteryOrganizer laboratoryBatteryOrganizer) {
		getMdht().addOrganizer(laboratoryBatteryOrganizer.copy());
		// Set the right type for the entryRelationship
		CdaUtil.setEntryRelationshipTypeCode(getMdht().getEntryRelationships(),
				x_ActRelationshipEntryRelationship.COMP);
	}

	public void addSpecimenCollectionEntry(SpecimenCollectionEntry entry) {
		getMdht().addProcedure(entry.copy());
		CdaUtil.setEntryRelationshipTypeCode(getMdht().getEntryRelationships(),
				x_ActRelationshipEntryRelationship.COMP);
	}

	public List<LaboratoryBatteryOrganizer> getLaboratoryBatteryOrganizers() {
		ArrayList<LaboratoryBatteryOrganizer> list = new ArrayList<LaboratoryBatteryOrganizer>();
		if (getMdht() != null && getMdht().getOrganizers() != null) {
			for (Organizer organizer : this.getMdht().getOrganizers()) {
				if (organizer instanceof org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryBatteryOrganizer) {
					org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryBatteryOrganizer iheOrganizer = (org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryBatteryOrganizer) organizer;
					list.add(new LaboratoryBatteryOrganizer(iheOrganizer));
				}
			}
		}
		return list;
	}

	/**
	 * Gets information regarding the specimen
	 *
	 * @return nonHumanSubject the specimen <div class="de">Angaben zur
	 *         Probe.</div>
	 */
	public NonHumanSubject getNonHumanSubject() {
		if (getMdht().getSubject() != null) {
			return new NonHumanSubject(
					(org.openhealthtools.mdht.uml.cda.ihe.lab.NonHumanSubject) getMdht().getSubject());
		}
		return null;
	}

	public List<SpecimenCollectionEntry> getSpecimenCollectionEntries() {
		ArrayList<SpecimenCollectionEntry> scel = new ArrayList<SpecimenCollectionEntry>();
		for (EntryRelationship e : getMdht().getEntryRelationships()) {
			if (e.getProcedure() instanceof org.openhealthtools.mdht.uml.cda.ihe.lab.SpecimenCollection) {
				scel.add(new SpecimenCollectionEntry(
						(org.openhealthtools.mdht.uml.cda.ihe.lab.SpecimenCollection) e.getProcedure()));
			}
		}
		return scel;
	}

	public void setCode(SpecialtySections code) {
		getMdht().setCode(code.getCE());
	}

	/**
	 * Sets information regarding the specimen
	 *
	 * @param nonHumanSubject
	 *          the specimen <div class="de">Angaben zur Probe.</div>
	 */
	public void setNonHumanSubject(NonHumanSubject nonHumanSubject) {
		getMdht().setSubject(nonHumanSubject.copy());
	}
}
