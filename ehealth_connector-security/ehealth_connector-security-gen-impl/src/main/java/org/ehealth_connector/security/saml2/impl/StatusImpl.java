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
package org.ehealth_connector.security.saml2.impl;

import org.ehealth_connector.security.core.SecurityObject;
import org.ehealth_connector.security.saml2.Status;
import org.ehealth_connector.security.saml2.StatusCode;

/**
 * <!-- @formatter:off -->
 * <div class="en">Implementation class of Status</div>
 * <div class="de">Implementations Klasse von Status</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * <!-- @formatter:on -->
 */
public class StatusImpl implements Status, SecurityObject<org.opensaml.saml.saml2.core.Status> {

	private org.opensaml.saml.saml2.core.Status status;

	protected StatusImpl(org.opensaml.saml.saml2.core.Status aStatus) {
		status = aStatus;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.Status#getStatusCode()
	 */
	@Override
	public StatusCode getStatusCode() {
		if (status.getStatusCode() != null) {

			return StatusCode.getEnum(status.getStatusCode().getValue());
		}
		return StatusCode.VERSION_MISMATCH;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.Status#getStatusMessage()
	 */
	@Override
	public String getStatusMessage() {
		if (status.getStatusMessage() != null) {
			return status.getStatusMessage().getMessage();
		}
		return "";
	}

	@Override
	public org.opensaml.saml.saml2.core.Status getWrappedObject() {
		return status;
	}

}
