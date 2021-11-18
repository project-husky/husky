/*
 * This code is made available under the terms of the Eclipse Public License v1.0 
 * in the github project https://github.com/project-husky/husky there you also 
 * find a list of the contributors and the license information.
 * 
 * This project has been developed further and modified by the joined working group Husky 
 * on the basis of the eHealth Connector opensource project from June 28, 2021, 
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.husky.common.model;

import java.util.ArrayList;
import java.util.List;

import org.husky.common.hl7cdar2.PN;
import org.husky.common.hl7cdar2.POCDMT000040PlayingEntity;

/**
 * The Class PlayingEntity. An entity with a name.
 */
public class PlayingEntity {

	/** The MDHT playing entity. */
	private POCDMT000040PlayingEntity mPlayingEntity;

	/**
	 * Instantiates a new playing entity.
	 */
	public PlayingEntity() {
		setPlayingEntity(new POCDMT000040PlayingEntity());
		// mPlayingEntity.setClassCode(EntityClassRoot.MIC);
	}

	/**
	 * Instantiates a new playing entity.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public PlayingEntity(POCDMT000040PlayingEntity mdht) {
		setPlayingEntity(mdht);
	}

	/**
	 * <div class="en">Adds the name.</div> <div class="de"></div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @param name
	 *            name
	 */
	public void addName(Name name) {
		getPlayingEntity().getName().add(name.getHl7CdaR2Pn());
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public Code getCode() {
		return new Code(getPlayingEntity().getCode());
	}

	/**
	 * <div class="en">Gets the names.</div> <div class="de">Liefert alle
	 * Nachnamen</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return <div class="en">the names</div>
	 */
	public List<Name> getNames() {
		final List<Name> nl = new ArrayList<>();
		for (final PN mName : getPlayingEntity().getName()) {
			nl.add(new Name(mName));
		}
		return nl;
	}

	/**
	 * Method to get
	 *
	 * @return the playingEntity
	 */
	public POCDMT000040PlayingEntity getPlayingEntity() {
		return mPlayingEntity;
	}

	/**
	 * Sets the code.
	 *
	 * @param code
	 *            the new code
	 */
	public void setCode(Code code) {
		getPlayingEntity().setCode(code.getHl7CdaR2Ce());
	}

	/**
	 * Method to set
	 *
	 * @param playingEntity
	 *            the playingEntity to set
	 */
	public void setPlayingEntity(POCDMT000040PlayingEntity playingEntity) {
		mPlayingEntity = playingEntity;
	}
}
