package org.ehealth_connector.common;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.Participant2;
import org.openhealthtools.mdht.uml.hl7.vocab.ParticipationType;

public class Participant {
	Participant2 mParticipant;

	public Participant() {
		mParticipant = CDAFactory.eINSTANCE.createParticipant2();
	}

	public Participant(Participant2 mdht) {
		this.mParticipant = mdht;
	}

	public Participant2 copy() {
		return EcoreUtil.copy(mParticipant);
	}

	public Participant2 getMdht() {
		return this.mParticipant;
	}

	public org.ehealth_connector.common.ParticipantRole getParticipantRole() {
		return new org.ehealth_connector.common.ParticipantRole(mParticipant.getParticipantRole());
	}

	public ParticipationType getTypeCode() {
		return mParticipant.getTypeCode();
	}

	public void setParticipantRole(org.ehealth_connector.common.ParticipantRole p) {
		mParticipant.setParticipantRole(p.copy());
	}

	public void setTypeCode(ParticipationType typeCode) {
		mParticipant.setTypeCode(typeCode);
	}
}
