/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
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
package org.ehealth_connector.xua.saml2.impl;

import org.ehealth_connector.xua.core.SecurityObjectBuilder;
import org.ehealth_connector.xua.saml2.Status;
import org.ehealth_connector.xua.saml2.StatusBuilder;
import org.ehealth_connector.xua.saml2.StatusCode;
import org.opensaml.saml.saml2.core.impl.StatusMessageBuilder;

/**
 * @since Feb 22, 2018 9:26:34 AM
 *
 */
public class StatusBuilderImpl implements StatusBuilder,
		SecurityObjectBuilder<org.opensaml.saml.saml2.core.Status, Status> {

	private org.opensaml.saml.saml2.core.Status status;
	private org.opensaml.saml.saml2.core.StatusCode statusCode;
	private org.opensaml.saml.saml2.core.StatusMessage statusMessage;

	public StatusBuilderImpl() {
		status = new org.opensaml.saml.saml2.core.impl.StatusBuilder().buildObject();

		statusCode = new org.opensaml.saml.saml2.core.impl.StatusCodeBuilder().buildObject();
		status.setStatusCode(statusCode);

		statusMessage = new StatusMessageBuilder().buildObject();
		status.setStatusMessage(statusMessage);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.saml2.StatusBuilder#create()
	 */
	@Override
	public Status create() {
		return new StatusImpl(status);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.core.SecurityObjectBuilder#create(java.lang.Object)
	 */
	@Override
	public Status create(org.opensaml.saml.saml2.core.Status aInternalObject) {
		return new StatusImpl(aInternalObject);
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.saml2.StatusBuilder#statusCode(org.ehealth_connector.xua.saml2.StatusCode)
	 */
	@Override
	public StatusBuilder statusCode(StatusCode aStatusCode) {
		statusCode.setValue(aStatusCode.toString());
		return this;
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.saml2.StatusBuilder#statusMessage(java.lang.String)
	 */
	@Override
	public StatusBuilder statusMessage(String aStatusMessage) {
		statusMessage.setValue(aStatusMessage);
		return this;
	}

}
