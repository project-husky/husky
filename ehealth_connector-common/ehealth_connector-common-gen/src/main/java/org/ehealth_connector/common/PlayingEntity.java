package org.ehealth_connector.common;

import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.hl7.vocab.EntityClassRoot;

public class PlayingEntity {
	org.openhealthtools.mdht.uml.cda.PlayingEntity mPlayingEntity;

	public PlayingEntity() {
		mPlayingEntity = CDAFactory.eINSTANCE.createPlayingEntity();
		mPlayingEntity.setClassCode(EntityClassRoot.MIC);
	}

	public PlayingEntity(org.openhealthtools.mdht.uml.cda.PlayingEntity mdht) {
		mPlayingEntity = mdht;
	}

	public Code getCode() {
		return new Code(mPlayingEntity.getCode());
	}

	public void setCode(Code code) {
		mPlayingEntity.setCode(code.getCE());
	}
}
