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

import java.util.List;

import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040SpecimenRole;
import org.ehealth_connector.common.utils.Util;

/**
 * The Class SpecimenRole.
 */
public class SpecimenRole extends PlayingEntity {

	/** The MDHT specimen role. */
	private POCDMT000040SpecimenRole mSpecimenRole;

	/**
	 * Instantiates a new specimen role.
	 */
	public SpecimenRole() {
		super();
		setSpecimenRole(new POCDMT000040SpecimenRole());
		getSpecimenRole().setSpecimenPlayingEntity(getPlayingEntity());
	}

	/**
	 * Instantiates a new specimen role.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public SpecimenRole(POCDMT000040SpecimenRole mdht) {
		super(mdht.getSpecimenPlayingEntity());
		setSpecimenRole(mdht);
	}

	/**
	 * Adds the id.
	 *
	 * @param id
	 *            the id
	 */
	public void addId(Identificator id) {
		getSpecimenRole().getId().add(id.getHl7CdaR2Ii());
	}

	/**
	 * Gets the id list.
	 *
	 * @return the id list
	 */
	public List<Identificator> getIdList() {
		return Util.convertIds(getSpecimenRole().getId());
	}

	/**
	 * Method to get
	 *
	 * @return the specimenRole
	 */
	public POCDMT000040SpecimenRole getSpecimenRole() {
		return mSpecimenRole;
	}

	/**
	 * Method to set
	 *
	 * @param specimenRole
	 *            the specimenRole to set
	 */
	public void setSpecimenRole(POCDMT000040SpecimenRole specimenRole) {
		mSpecimenRole = specimenRole;
	}
}
