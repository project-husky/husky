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
package org.projecthusky.common.model;

import java.util.List;

import org.projecthusky.common.hl7cdar2.POCDMT000040SpecimenRole;

/**
 * The Class SpecimenRole.
 */
public class SpecimenRole extends PlayingEntity {

    /**
     * The specimen role.
     */
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
     * @param mdht the mdht
     */
    public SpecimenRole(POCDMT000040SpecimenRole mdht) {
        super(mdht.getSpecimenPlayingEntity());
        setSpecimenRole(mdht);
    }

    /**
     * Adds the id.
     *
     * @param id the id
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
		return Identificator.getIdentificatorList(getSpecimenRole().getId());
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
     * @param specimenRole the specimenRole to set
     */
    public void setSpecimenRole(POCDMT000040SpecimenRole specimenRole) {
        mSpecimenRole = specimenRole;
    }
}
