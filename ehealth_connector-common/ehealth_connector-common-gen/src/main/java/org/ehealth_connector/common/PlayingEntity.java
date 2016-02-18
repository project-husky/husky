package org.ehealth_connector.common;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.PN;
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

	/**
	 * <div class="en">Adds the name.</div> <div class="de"></div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @param name
	 *          name
	 */
	public void addName(Name name) {
		mPlayingEntity.getNames().add(name.copyMdhtPn());
	}

	public org.openhealthtools.mdht.uml.cda.PlayingEntity copyPlayingEntity() {
		return EcoreUtil.copy(mPlayingEntity);
	}

	public Code getCode() {
		return new Code(mPlayingEntity.getCode());
	}

	public org.openhealthtools.mdht.uml.cda.PlayingEntity getMdhtPlayingEntity() {
		return mPlayingEntity;
	}

	/**
	 * <div class="en">Gets the names.</div> <div class="de">Liefert alle
	 * Nachnamen</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return <div class="en">the names</div>
	 */
	public List<Name> getNames() {
		final List<Name> nl = new ArrayList<Name>();
		for (final PN mName : mPlayingEntity.getNames()) {
			final Name name = new Name(mName);
			nl.add(name);
		}
		return nl;
	}

	public void setCode(Code code) {
		mPlayingEntity.setCode(code.getCE());
	}
}
