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
 * Year of publication: 2015
 *
 *******************************************************************************/

package org.ehealth_connector.validation.service.api;

/**
 * @author ich
 *
 */
public class XsdValidationResult {

	private boolean isXsdValid;

	private String xsdValidationMsg = "";

	public String getXsdValidationMsg() {
		return xsdValidationMsg;
	}

	public boolean isXsdValid() {
		return isXsdValid;
	}

	public void setXsdValid(boolean isXsdValid) {
		this.isXsdValid = isXsdValid;
	}

	public void setXsdValidationMsg(String xsdValidationMsg) {
		this.xsdValidationMsg = xsdValidationMsg;
	}
}
