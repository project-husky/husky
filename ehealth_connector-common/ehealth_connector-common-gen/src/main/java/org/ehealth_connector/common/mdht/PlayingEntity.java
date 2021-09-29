/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
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
package org.ehealth_connector.common.mdht;

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Name;
import org.ehealth_connector.common.hl7cdar2.PN;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040PlayingEntity;

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
