package org.ehealth_connector.cda.ch.lab;

import java.util.Date;

import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Participant;
import org.ehealth_connector.common.ParticipantRole;
import org.ehealth_connector.common.PlayingEntity;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.ihe.lab.SpecimenCollection;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;

public class SpecimenCollectionEntry
		extends org.ehealth_connector.cda.ihe.lab.SpecimenCollectionEntry {

	public SpecimenCollectionEntry() {
		super();
	}

	// /**
	// * Convenience Constructor that creates the Participant with the given id
	// * (participant/participantRole/id) an unknown point in time for the
	// specimen
	// * collection (effectiveTime/value='UNK') and no internal id for the
	// specimen
	// * (participant/participantRole/id='NA').
	// *
	// * @param effectiveTimeAndIdUnknown
	// * true if the effectiveTime element is unknown and the Id is not
	// * available. false otherwise (same effect as the standard
	// * constructor).
	// */
	// public SpecimenCollectionEntry(boolean effectiveTimeAndIdUnknown) {
	// this();
	// if (effectiveTimeAndIdUnknown) {
	// setEffectiveTimeNullFlavorUnk();
	// II ii = DatatypesFactory.eINSTANCE.createII();
	// ii.setNullFlavor(NullFlavor.NA);
	// addParticipant(ii);
	// }
	// }

	/**
	 * Convenience Constructor that creates the Participant with the given Id.
	 *
	 * @param effectiveTime
	 *          time of the day, when the sample extraction took place. If null
	 *          the effectiveTime element will be set to NullFlavor.UNK
	 * @param id
	 *          Id of your lab (as root) with the id of the specimen inside your
	 *          lab as extension
	 * @param textReference
	 *          Reference to the human readable text
	 */
	public SpecimenCollectionEntry(Date effectiveTime, Identificator id, String textReference) {
		this();
		if (effectiveTime == null) {
			setEffectiveTimeNullFlavorUnk();
		} else {
			setEffectiveTime(effectiveTime);
		}
		addParticipant(id);
		setTextReference(textReference);
	}

	/**
	 * Convenience Constructor that creates the Participant with the given Id.
	 *
	 * @param effectiveTime
	 *          time of the day, when the sample extraction took place. If null
	 *          the effectiveTime element will be set to NullFlavor.UNK
	 * @param participant
	 *          participant who performed the collection (typically a laboratory).
	 *          Id of your lab (as root) with the id of the specimen inside your
	 *          lab as extension have to be present
	 * @param textReference
	 *          Reference to the human readable text
	 */
	public SpecimenCollectionEntry(Date effectiveTime, Participant participant,
			String textReference) {
		this();
		if (effectiveTime == null) {
			setEffectiveTimeNullFlavorUnk();
		} else {
			setEffectiveTime(effectiveTime);
		}
		addParticipant(participant);
		setTextReference(textReference);
	}

	/**
	 * Convenience Constructor that creates the Participant with the given id and
	 * an unknown point in time for the specimen collection
	 * (effectiveTime/value=UNK).
	 *
	 * @param id
	 *          Id of your lab (as root) with the id of the specimen inside your
	 *          lab as extension
	 */
	public SpecimenCollectionEntry(Identificator id, String textReference) {
		this(null, id, textReference);
	}

	public SpecimenCollectionEntry(SpecimenCollection mdht) {
		super(mdht);
	}

	/**
	 * Convenience Function to create the Participant element automatically
	 *
	 * @param id
	 *          The Id of your lab (as root) with the id of the specimen inside
	 *          your lab as extension
	 */
	public void addParticipant(Identificator id) {
		addParticipant(id.getIi());
	}

	private void addParticipant(II id) {
		PlayingEntity pl = new PlayingEntity();
		ParticipantRole pr = new ParticipantRole();
		Participant participant = new Participant();

		// Fixed Loinc Code for Playing Entity
		pl.setCode(new Code("2.16.756.5.30.2.1.1.10", "LOINC"));
		pr.setPlayingEntity(pl);
		pr.getMdht().getIds().add(id);
		participant.setParticipantRole(pr);

		addParticipant(participant);
	}

	@Override
	public String getTextReference() {
		if ((this.getMdht().getText() != null) && (this.getMdht().getText().getReference() != null)) {
			return this.getMdht().getText().getReference().getValue();
		}
		return null;
	}

	/**
	 * If the point in time when the specimen has been collected is unknown, you
	 * can use this method to set the effective time value to nullFlavor UNK.
	 */
	public void setEffectiveTimeNullFlavorUnk() {
		getMdht().setEffectiveTime(Util.createEffectiveTimeNullFlavorUnk());
	}

	@Override
	public void setTextReference(String textReference) {
		if (!textReference.startsWith("#"))
			textReference = "#" + textReference;
		this.getMdht().setText(Util.createReference(textReference));
	}
}
