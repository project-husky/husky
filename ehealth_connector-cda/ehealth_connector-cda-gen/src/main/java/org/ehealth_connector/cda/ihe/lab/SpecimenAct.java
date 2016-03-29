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
package org.ehealth_connector.cda.ihe.lab;

import org.ehealth_connector.common.Code;

/**
 * The Class SpecimenAct.
 */
public class SpecimenAct extends AbstractSpecimenAct {

	/**
	 * Instantiates a new specimen act. One Laboratory Report Data Processing
	 * Entry SHALL be present in each leaf section of the report. The entry
	 * SHALL contain a single act sub-element. This act is referred to as the
	 * Specimen Act. All other CDA level 3 content modules are nested in this
	 * one act. The Specimen Act shall contain at least one Laboratory
	 * Observation. If all observations of the entry have been produced on the
	 * same specimen, this specimen SHALL be attached to the top Specimen Act as
	 * a specimen collection procedure sub-element.
	 */
	public SpecimenAct() {
		super();
	}

	/**
	 * Instantiates a new specimen act.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public SpecimenAct(org.openhealthtools.mdht.uml.cda.ihe.lab.SpecimenAct mdht) {
		super(mdht);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.cda.ihe.lab.AbstractSpecimenAct#getStatusCode()
	 */
	@Override
	public Code getStatusCode() {
		if (getMdht() != null && getMdht().getStatusCode() != null) {
			return new Code(getMdht().getStatusCode());
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.cda.ihe.lab.AbstractSpecimenAct#setStatusCode(org.ehealth_connector.common.Code)
	 */
	@Override
	public void setStatusCode(Code code) {
		getMdht().setStatusCode(code.getCS());
	}

}