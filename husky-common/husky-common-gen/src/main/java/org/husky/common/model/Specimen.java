/*
 * This code is made available under the terms of the Eclipse Public License v1.0 in the github project https://github.com/project-husky/husky there you also find a list of the contributors and the license information.
This project has been developed further and modified by the joined working group Husky on the basis of the eHealth Connector opensource project from June 28, 2021, whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
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
package org.husky.common.model;

import org.husky.common.hl7cdar2.POCDMT000040Specimen;

/**
 * The Class Specimen.
 */
public class Specimen extends SpecimenRole {

	/** The MDHT specimen. */
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
	 * @param mdht
	 *            the mdht
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
