/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
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
package org.ehealth_connector.common;

import java.util.List;

import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.CDAFactory;

/**
 * The Class SpecimenRole.
 */
public class SpecimenRole extends PlayingEntity {

	/** The MDHT specimen role. */
	private org.openhealthtools.mdht.uml.cda.SpecimenRole mSpecimenRole;

	/**
	 * Instantiates a new specimen role.
	 */
	public SpecimenRole() {
		super();
		setSpecimenRole(CDAFactory.eINSTANCE.createSpecimenRole());
		getSpecimenRole().setSpecimenPlayingEntity(getPlayingEntity());
	}

	/**
	 * Instantiates a new specimen role.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public SpecimenRole(org.openhealthtools.mdht.uml.cda.SpecimenRole mdht) {
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
		getSpecimenRole().getIds().add(id.getIi());
	}

	/**
	 * Gets the id list.
	 *
	 * @return the id list
	 */
	public List<Identificator> getIdList() {
		return Util.convertIds(getSpecimenRole().getIds());
	}

	/**
	 * Method to get
	 *
	 * @return the specimenRole
	 */
	public org.openhealthtools.mdht.uml.cda.SpecimenRole getSpecimenRole() {
		return mSpecimenRole;
	}

	/**
	 * Method to set
	 *
	 * @param specimenRole
	 *            the specimenRole to set
	 */
	public void setSpecimenRole(org.openhealthtools.mdht.uml.cda.SpecimenRole specimenRole) {
		mSpecimenRole = specimenRole;
	}
}
