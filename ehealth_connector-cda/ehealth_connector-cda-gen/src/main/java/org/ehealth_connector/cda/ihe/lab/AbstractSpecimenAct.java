/*
 *
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
