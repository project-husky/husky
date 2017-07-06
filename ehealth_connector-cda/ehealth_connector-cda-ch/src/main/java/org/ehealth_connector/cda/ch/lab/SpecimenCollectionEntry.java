/*
 *
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
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
package org.ehealth_connector.cda.ch.lab;

import java.util.Date;

import org.ehealth_connector.cda.ihe.lab.SpecimenReceivedEntry;
import org.ehealth_connector.cda.utils.CdaUtil;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Participant;
import org.ehealth_connector.common.ParticipantRole;
import org.ehealth_connector.common.PlayingEntity;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.Act;
import org.openhealthtools.mdht.uml.cda.ihe.lab.SpecimenCollection;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;

/**
 * The Class SpecimenCollectionEntry.
 *
 * <div class="en">Information about the specimen</div> <div class="de">Angaben
 * zur Probe</div>
 */
public class SpecimenCollectionEntry
		extends org.ehealth_connector.cda.ihe.lab.SpecimenCollectionEntry {

	/**
	 * Instantiates a new specimen collection entry.
	 */
	public SpecimenCollectionEntry() {
		super();
	}

	/**
	 * Convenience Constructor that creates the Participant with the given Id.
	 *
	 * @param effectiveTime
	 *            time of the day, when the sample extraction took place. If
	 *            null the effectiveTime element will be set to NullFlavor.UNK
	 * @param id
	 *            Id of your lab (as root) with the id of the specimen inside
	 *            your lab as extension
	 * @param textReference
	 *            Reference to the human readable text
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
	 *            time of the day, when the sample extraction took place. If
	 *            null the effectiveTime element will be set to NullFlavor.UNK
	 * @param participant
	 *            participant who performed the collection (typically a
	 *            laboratory). Id of your lab (as root) with the id of the
	 *            specimen inside your lab as extension have to be present
	 * @param textReference
	 *            Reference to the human readable text
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
	 * Convenience Constructor that creates the Participant with the given id
	 * and an unknown point in time for the specimen collection
	 * (effectiveTime/value=UNK).
	 *
	 * @param id
	 *            Id of your lab (as root) with the id of the specimen inside
	 *            your lab as extension
	 * @param textReference
	 *            the text reference
	 */
	public SpecimenCollectionEntry(Identificator id, String textReference) {
		this(null, id, textReference);
	}

	/**
	 * Instantiates a new specimen collection entry.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public SpecimenCollectionEntry(SpecimenCollection mdht) {
		super(mdht);
	}

	/**
	 * Convenience Function to create the Participant element automatically.
	 *
	 * @param id
	 *            The Id of your lab (as root) with the id of the specimen
	 *            inside your lab as extension
	 */
	public void addParticipant(Identificator id) {
		if (id != null) {
			addParticipant(id.getIi());
		} else {
			final II ii = DatatypesFactory.eINSTANCE.createII();
			ii.setNullFlavor(NullFlavor.NA);
			addParticipant(ii);
		}
	}

	/**
	 * Adds the participant (typically, a laboratory).
	 *
	 * @param id
	 *            the id
	 */
	private void addParticipant(II id) {
		final PlayingEntity pl = new PlayingEntity();
		final ParticipantRole pr = new ParticipantRole();
		final Participant participant = new Participant();

		// Fixed Loinc Code for Playing Entity
		Code code = new Code("2.16.756.5.30.2.1.1.10", "LOINC");
		pl.setCode(code);
		pr.setPlayingEntity(pl);
		pr.getMdht().getIds().add(id);
		participant.setParticipantRole(pr);

		addParticipant(participant);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.cda.MdhtFacade#getTextReference()
	 */
	@Override
	public String getTextReference() {
		if ((this.getMdht().getText() != null)
				&& (this.getMdht().getText().getReference() != null)) {
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

	/**
	 * Sets the specimen material original text
	 *
	 * @param originalText
	 *            the new specimen material original text
	 */
	public void setSpecimenMaterialOriginalText(String originalText) {
		setSpecimenMaterialOriginalText(originalText, null);
	}

	/**
	 * Sets the specimen material original text element including the reference
	 * to the narrative part
	 *
	 * @param originalText
	 *            the original text
	 * @param textReference
	 *            the text reference
	 */
	public void setSpecimenMaterialOriginalText(String originalText, String textReference) {
		CD cd = null;
		if (this.getMdht() != null)
			if (this.getMdht().getParticipants() != null)
				if (this.getMdht().getParticipants().size() > 0)
					if (this.getMdht().getParticipants().get(0) != null)
						if (this.getMdht().getParticipants().get(0).getParticipantRole() != null)
							if (this.getMdht().getParticipants().get(0).getParticipantRole()
									.getPlayingEntity() != null)
								cd = this.getMdht().getParticipants().get(0).getParticipantRole()
										.getPlayingEntity().getCode();
		if (cd != null) {
			Code code = new Code(cd);
			code.setOriginalText(originalText, textReference);
		}
	}

	/**
	 * Sets the specimen received entry.
	 *
	 * @param entry
	 *            the new specimen received entry
	 */
	@Override
	public void setSpecimenReceivedEntry(SpecimenReceivedEntry entry) {
		if (entry != null) {
			// Check if the element already exist, if so, replace it, if not add
			// it
			boolean added = false;
			for (Act o : getMdht().getActs()) {
				if (o instanceof org.openhealthtools.mdht.uml.cda.ihe.lab.SpecimenReceived) {
					o = entry.getMdht();
					added = true;
				}
			}
			if (added == false) {
				getMdht().addAct(entry.copy());
			}
			CdaUtil.setEntryRelationshipTypeCode(getMdht().getEntryRelationships(),
					x_ActRelationshipEntryRelationship.COMP);
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.cda.MdhtFacade#setTextReference(java.lang.String)
	 */
	@Override
	public void setTextReference(String textReference) {
		if (textReference != null) {
			if (!textReference.startsWith("#"))
				textReference = "#" + textReference;
			this.getMdht().setText(Util.createReference(textReference));
		}
	}

	/**
	 * TODO tsc
	 */
	public void SpecimenCollectionApproachSiteCodeOriginalText(String originalText) {
		SpecimenCollectionApproachSiteCodeOriginalText(originalText, null);
	}

	/**
	 * TODO tsc
	 */
	public void SpecimenCollectionApproachSiteCodeOriginalText(String originalText,
			String textReference) {
		CD cd = null;
		if (this.getMdht() != null)
			if (this.getMdht().getApproachSiteCodes() != null)
				if (this.getMdht().getApproachSiteCodes().size() > 0)
					if (this.getMdht().getApproachSiteCodes().get(0) != null)
						cd = this.getMdht().getApproachSiteCodes().get(0);
		Code code = null;
		if (cd != null) {
			code = new Code(cd);
			code.setOriginalText(originalText, textReference);
		} else {
			code = new Code(org.ehealth_connector.common.enums.NullFlavor.ASKED_BUT_UNKNOWN);
			code.setOriginalText(originalText, textReference);
			this.getMdht().getApproachSiteCodes().add(code.getCD());
		}
	}
}
