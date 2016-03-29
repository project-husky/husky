/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2016
 *
 *******************************************************************************/
package org.ehealth_connector.common;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.PN;
import org.openhealthtools.mdht.uml.hl7.vocab.EntityClassRoot;

/**
 * The Class PlayingEntity. An entity with a name.
 */
public class PlayingEntity {

	/** The MDHT playing entity. */
	org.openhealthtools.mdht.uml.cda.PlayingEntity mPlayingEntity;

	/**
	 * Instantiates a new playing entity.
	 */
	public PlayingEntity() {
		mPlayingEntity = CDAFactory.eINSTANCE.createPlayingEntity();
		mPlayingEntity.setClassCode(EntityClassRoot.MIC);
	}

	/**
	 * Instantiates a new playing entity.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public PlayingEntity(org.openhealthtools.mdht.uml.cda.PlayingEntity mdht) {
		mPlayingEntity = mdht;
	}

	/**
	 * <div class="en">Adds the name.</div> <div class="de"></div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @param name
	 *            name
	 */
	public void addName(Name name) {
		mPlayingEntity.getNames().add(name.copyMdhtPn());
	}

	/**
	 * Copy playing entity.
	 *
	 * @return the org.openhealthtools.mdht.uml.cda. playing entity
	 */
	public org.openhealthtools.mdht.uml.cda.PlayingEntity copyPlayingEntity() {
		return EcoreUtil.copy(mPlayingEntity);
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public Code getCode() {
		return new Code(mPlayingEntity.getCode());
	}

	/**
	 * Gets the mdht playing entity.
	 *
	 * @return the mdht playing entity
	 */
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

	/**
	 * Sets the code.
	 *
	 * @param code
	 *            the new code
	 */
	public void setCode(Code code) {
		mPlayingEntity.setCode(code.getCE());
	}
}
