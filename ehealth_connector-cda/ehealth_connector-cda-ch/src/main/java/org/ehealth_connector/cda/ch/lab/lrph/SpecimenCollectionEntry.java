package org.ehealth_connector.cda.ch.lab.lrph;

import java.util.Date;

import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Participant;
import org.ehealth_connector.common.ParticipantRole;
import org.ehealth_connector.common.PlayingEntity;
import org.openhealthtools.mdht.uml.cda.ihe.lab.SpecimenCollection;

public class SpecimenCollectionEntry
		extends org.ehealth_connector.cda.ihe.lab.SpecimenCollectionEntry {

	public SpecimenCollectionEntry() {
		super();
	}

	/**
	 * Convenience Constructor that creates the Participant with the given Id
	 *
	 * @param effectiveTime
	 *          time of the day, when the sample extraction took place
	 * @param The
	 *          Id of your lab (as root) with the id of the specimen inside your
	 *          lab as extension
	 */
	public SpecimenCollectionEntry(Date effectiveTime, Identificator id) {
		this();
		setEffectiveTime(effectiveTime);
		addParticipant(id);
	}

	// Required Elements
	public SpecimenCollectionEntry(Date effectiveTime, Participant participant) {
		this();
		setEffectiveTime(effectiveTime);
		addParticipant(participant);
	}

	public SpecimenCollectionEntry(SpecimenCollection mdht) {
		super(mdht);
	}

	/**
	 * Convenience Function to create the Participant element automatically
	 *
	 * @param id
	 *          The Id of your lab (as root) with the id of the speciment inside
	 *          your lab as extension
	 */
	public void addParticipant(Identificator id) {
		PlayingEntity pl = new PlayingEntity();
		ParticipantRole pr = new ParticipantRole();
		Participant participant = new Participant();

		// Fixed Loinc Code for Playing Entity
		pl.setCode(new Code("2.16.756.5.30.2.1.1.10", "LOINC"));
		pr.setPlayingEntity(pl);
		pr.addId(id);
		participant.setParticipantRole(pr);

		addParticipant(participant);
	}
}
