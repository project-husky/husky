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
package org.ehealth_connector.cda.ch.lab;

import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.enums.StatusCode;
import org.openhealthtools.mdht.uml.cda.Act;

/**
 * The Class AbstractSpecimenAct.
 */
public abstract class AbstractSpecimenAct
		extends org.ehealth_connector.cda.ihe.lab.AbstractSpecimenAct {

	/**
	 * Instantiates a new abstract specimen act.
	 */
	public AbstractSpecimenAct() {
		super();
		super.setStatusCode(StatusCode.COMPLETED.getCode());
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
	 * Gets the code.
	 *
	 * @return the code
	 */
	public Code getCode() {
		return new Code(getMdht().getCode());
	}

	/**
	 * Sets the code.
	 *
	 * @param code
	 *            the new code
	 */
	public void setCode(Code code) {
		if (code != null) {
			getMdht().setCode(code.getCD());
		}
	}
}
