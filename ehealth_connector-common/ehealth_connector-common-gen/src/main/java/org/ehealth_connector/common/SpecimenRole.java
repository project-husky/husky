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

import java.util.List;

import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.CDAFactory;

/**
 * The Class SpecimenRole.
 */
public class SpecimenRole extends PlayingEntity {

	/** The MDHT specimen role. */
	org.openhealthtools.mdht.uml.cda.SpecimenRole mSpecimenRole;

	/**
	 * Instantiates a new specimen role.
	 */
	public SpecimenRole() {
		super();
		mSpecimenRole = CDAFactory.eINSTANCE.createSpecimenRole();
		mSpecimenRole.setSpecimenPlayingEntity(mPlayingEntity);
	}

	/**
	 * Instantiates a new specimen role.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public SpecimenRole(org.openhealthtools.mdht.uml.cda.SpecimenRole mdht) {
		super(mdht.getSpecimenPlayingEntity());
		mSpecimenRole = mdht;
	}

	/**
	 * Adds the id.
	 *
	 * @param id
	 *            the id
	 */
	public void addId(Identificator id) {
		mSpecimenRole.getIds().add(id.getIi());
	}

	/**
	 * Gets the id list.
	 *
	 * @return the id list
	 */
	public List<Identificator> getIdList() {
		return Util.convertIds(mSpecimenRole.getIds());
	}
}
