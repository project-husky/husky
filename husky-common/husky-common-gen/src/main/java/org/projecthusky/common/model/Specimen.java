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

import org.projecthusky.common.hl7cdar2.POCDMT000040Specimen;

/**
 * The Class Specimen.
 */
public class Specimen extends SpecimenRole {

    /**
     * The specimen.
     */
    private POCDMT000040Specimen mSpecimen;

    /**
     * Instantiates a new specimen.
     */
    public Specimen() {
        super();
        mSpecimen = new POCDMT000040Specimen();
        mSpecimen.setSpecimenRole(getSpecimenRole());
    }

    /**
     * Instantiates a new specimen.
     *
     * @param mdht the mdht
     */
    public Specimen(POCDMT000040Specimen mdht) {
        super(mdht.getSpecimenRole());
        mSpecimen = mdht;
    }

    /**
     * Gets the mdht.
     *
     * @return the mdht
     */
    public POCDMT000040Specimen getMdht() {
        return mSpecimen;
    }
}
