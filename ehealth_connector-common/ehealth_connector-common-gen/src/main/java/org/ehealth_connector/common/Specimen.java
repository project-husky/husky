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

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.openhealthtools.mdht.uml.cda.CDAFactory;

/**
 * The Class Specimen.
 */
public class Specimen extends SpecimenRole {

	/** The MDHT specimen. */
	private org.openhealthtools.mdht.uml.cda.Specimen mSpecimen;

	/**
	 * Instantiates a new specimen.
	 */
	public Specimen() {
		super();
		mSpecimen = CDAFactory.eINSTANCE.createSpecimen();
		mSpecimen.setSpecimenRole(getSpecimenRole());
	}

	/**
	 * Instantiates a new specimen.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public Specimen(org.openhealthtools.mdht.uml.cda.Specimen mdht) {
		super(mdht.getSpecimenRole());
		mSpecimen = mdht;
	}

	/**
	 * Copy.
	 *
	 * @return the org.openhealthtools.mdht.uml.cda. specimen
	 */
	public org.openhealthtools.mdht.uml.cda.Specimen copy() {
		return EcoreUtil.copy(mSpecimen);
	}

	/**
	 * Gets the mdht.
	 *
	 * @return the mdht
	 */
	public org.openhealthtools.mdht.uml.cda.Specimen getMdht() {
		return mSpecimen;
	}
}
