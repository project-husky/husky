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

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.openhealthtools.mdht.uml.cda.CDAFactory;

/**
 * The Class Specimen.
 */
public class Specimen extends SpecimenRole {

	/** The MDHT specimen. */
	org.openhealthtools.mdht.uml.cda.Specimen mSpecimen;

	/**
	 * Instantiates a new specimen.
	 */
	public Specimen() {
		super();
		mSpecimen = CDAFactory.eINSTANCE.createSpecimen();
		mSpecimen.setSpecimenRole(mSpecimenRole);
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
