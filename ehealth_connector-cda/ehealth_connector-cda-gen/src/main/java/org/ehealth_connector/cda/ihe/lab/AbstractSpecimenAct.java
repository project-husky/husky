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

import org.ehealth_connector.cda.MdhtActFacade;
import org.ehealth_connector.common.Code;
import org.openhealthtools.mdht.uml.cda.Act;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LABFactory;

/**
 * The Class AbstractSpecimenAct.
 */
public abstract class AbstractSpecimenAct extends MdhtActFacade<Act> {

	/**
	 * Instantiates a new abstract specimen act.
	 */
	public AbstractSpecimenAct() {
		super(LABFactory.eINSTANCE.createSpecimenAct().init());
	}

	/**
	 * Instantiates a new abstract specimen act.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public AbstractSpecimenAct(Act mdht) {
		super(mdht);
	}

	/**
	 * Gets the status code.
	 *
	 * @return the status code
	 */
	public Code getStatusCode() {
		if (getMdht() != null && getMdht().getStatusCode() != null) {
			return new Code(getMdht().getStatusCode());
		}
		return null;
	}

	/**
	 * Sets the status code.
	 *
	 * @param code
	 *            the new status code
	 */
	public void setStatusCode(Code code) {
		getMdht().setStatusCode(code.getCS());
	}

}
