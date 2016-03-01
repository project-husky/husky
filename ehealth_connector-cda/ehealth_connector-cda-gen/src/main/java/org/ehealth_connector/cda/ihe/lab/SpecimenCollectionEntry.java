package org.ehealth_connector.cda.ihe.lab;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.ehealth_connector.cda.MdhtProcedureFacade;
import org.ehealth_connector.cda.utils.CdaUtil;
import org.ehealth_connector.common.Participant;
import org.ehealth_connector.common.utils.DateUtil;
import org.openhealthtools.mdht.uml.cda.Act;
import org.openhealthtools.mdht.uml.cda.Participant2;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LABFactory;
import org.openhealthtools.mdht.uml.cda.ihe.lab.SpecimenCollection;
import org.openhealthtools.mdht.uml.hl7.vocab.ParticipationType;
import org.openhealthtools.mdht.uml.hl7.vocab.RoleClassRoot;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;

public class SpecimenCollectionEntry
		extends MdhtProcedureFacade<org.openhealthtools.mdht.uml.cda.ihe.lab.SpecimenCollection> {

	public SpecimenCollectionEntry() {
		super(LABFactory.eINSTANCE.createSpecimenCollection().init());
	}

	public SpecimenCollectionEntry(SpecimenCollection mdht) {
		super(mdht);
	}

	public void addParticipant(Participant participant) {
		// set ParticipantionType and ParticipantClassRole
		participant.setTypeCode(ParticipationType.PRD);
		participant.getParticipantRole().setClassCode(RoleClassRoot.SPEC);

		getMdht().getParticipants().add(participant.copy());
	}

	protected Date getEffectiveTime() {
		return DateUtil.parseIVL_TSVDateTimeValue(getMdht().getEffectiveTime());
	}

	public List<Participant> getParticipants() {
		ArrayList<Participant> list = new ArrayList<Participant>();
		if (getMdht() != null && getMdht().getParticipants() != null) {
			for (Participant2 p : this.getMdht().getParticipants()) {
				list.add(new Participant(p));
			}
		}
		return list;
	}

	public SpecimenReceivedEntry getSpecimenReceivedEntry() {
		return new SpecimenReceivedEntry(getMdht().getSpecimenReceived());
	}

	protected void setEffectiveTime(Date date) {
		getMdht().setEffectiveTime(DateUtil.convertDateyyyyMMddHHmmssZZZZ(date));
	}

	public void setSpecimenReceivedEntry(SpecimenReceivedEntry entry) {
		// Check if the element already exist, if so, replace it, if not add it
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
