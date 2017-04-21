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

package org.ehealth_connector.validation.service.api;

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
