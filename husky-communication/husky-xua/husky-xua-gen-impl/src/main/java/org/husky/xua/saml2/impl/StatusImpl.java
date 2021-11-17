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
package org.husky.xua.saml2.impl;

import org.husky.xua.core.SecurityObject;
import org.husky.xua.saml2.Status;
import org.husky.xua.saml2.StatusCode;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.protocol.StatusCodeType;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.protocol.StatusType;
import org.opensaml.saml.saml2.core.impl.StatusBuilder;
import org.opensaml.saml.saml2.core.impl.StatusCodeBuilder;
import org.opensaml.saml.saml2.core.impl.StatusMessageBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Implementation class of Status</div>
 * <div class="de">Implementations Klasse von Status</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class StatusImpl implements Status, SecurityObject<org.opensaml.saml.saml2.core.Status> {

	private org.opensaml.saml.saml2.core.Status status;

	protected StatusImpl(org.opensaml.saml.saml2.core.Status aStatus) {
		status = aStatus;
	}

	protected StatusImpl(StatusType aStatus) {
		status = new StatusBuilder().buildObject();
		status.setStatusCode(getStatusCode(aStatus.getStatusCode()));
		status.setStatusMessage(getStatusMessage(aStatus.getStatusMessage()));
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.saml2.Status#getStatusCode()
	 */
	@Override
	public StatusCode getStatusCode() {
		if (status.getStatusCode() != null) {

			return StatusCode.getEnum(status.getStatusCode().getValue());
		}
		return StatusCode.VERSION_MISMATCH;
	}

	private org.opensaml.saml.saml2.core.StatusCode getStatusCode(StatusCodeType aStatusCode) {
		var statusCode = new StatusCodeBuilder().buildObject();

		if (aStatusCode.getValue() != null) {
			statusCode.setValue(aStatusCode.getValue());
		}

		if (aStatusCode.getStatusCode() != null) {
			statusCode.setStatusCode(getStatusCode(aStatusCode.getStatusCode()));
		}

		return statusCode;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.saml2.Status#getStatusMessage()
	 */
	@Override
	public String getStatusMessage() {
		if (status.getStatusMessage() != null) {
			return status.getStatusMessage().getValue();
		}
		return "";
	}

	private org.opensaml.saml.saml2.core.StatusMessage getStatusMessage(String message) {
		var statusMessage = new StatusMessageBuilder().buildObject();
		statusMessage.setValue(message);
		return statusMessage;
	}

	@Override
	public org.opensaml.saml.saml2.core.Status getWrappedObject() {
		return status;
	}

	@Override
	public String toString() {
		return "Status ["
				+ (status.getStatusCode() != null ? status.getStatusCode().getValue() : "n/a")
				+ (status.getStatusMessage() != null ? "," + status.getStatusMessage().getMessage()
						: "")
				+ "]";
	}
}
