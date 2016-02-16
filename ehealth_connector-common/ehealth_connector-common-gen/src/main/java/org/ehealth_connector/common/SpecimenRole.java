package org.ehealth_connector.common;

import java.util.List;

import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.CDAFactory;

public class SpecimenRole extends PlayingEntity {
	org.openhealthtools.mdht.uml.cda.SpecimenRole mSpecimenRole;

	public SpecimenRole() {
		super();
		mSpecimenRole = CDAFactory.eINSTANCE.createSpecimenRole();
		mSpecimenRole.setSpecimenPlayingEntity(mPlayingEntity);
	}

	public SpecimenRole(org.openhealthtools.mdht.uml.cda.SpecimenRole mdht) {
		super(mdht.getSpecimenPlayingEntity());
		mSpecimenRole = mdht;
	}

	public void addId(Identificator id) {
		mSpecimenRole.getIds().add(id.getIi());
	}

	public List<Identificator> getIdList() {
		return Util.convertIds(mSpecimenRole.getIds());
	}
}
