package org.ehealth_connector.common;

import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.hl7.vocab.RoleClassRoot;

public class ParticipantRole {
	org.openhealthtools.mdht.uml.cda.ParticipantRole mParticipantRole;

	public ParticipantRole() {
		mParticipantRole = CDAFactory.eINSTANCE.createParticipantRole();
	}

	public ParticipantRole(org.openhealthtools.mdht.uml.cda.ParticipantRole mdht) {
		this.mParticipantRole = mdht;
	}

	public void addId(Identificator id) {
		mParticipantRole.getIds().add(id.getIi());
	}

	public org.openhealthtools.mdht.uml.cda.ParticipantRole copy() {
		return EcoreUtil.copy(mParticipantRole);
	}

	public RoleClassRoot getClassCode() {
		return mParticipantRole.getClassCode();
	}

	public List<Identificator> getIdList() {
		return Util.convertIds(mParticipantRole.getIds());
	}

	public org.openhealthtools.mdht.uml.cda.ParticipantRole getMdht() {
		return this.mParticipantRole;
	}

	public void setClassCode(RoleClassRoot classCode) {
		mParticipantRole.setClassCode(classCode);
	}
}
