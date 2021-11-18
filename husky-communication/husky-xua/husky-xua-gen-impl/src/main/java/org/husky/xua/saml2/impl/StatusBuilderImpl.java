/*
 * This code is made available under the terms of the Eclipse Public License v1.0 
 * in the github project https://github.com/project-husky/husky there you also 
 * find a list of the contributors and the license information.
 * 
 * This project has been developed further and modified by the joined working group Husky 
 * on the basis of the eHealth Connector opensource project from June 28, 2021, 
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.husky.xua.saml2.impl;

import org.husky.xua.core.SecurityObjectBuilder;
import org.husky.xua.saml2.Status;
import org.husky.xua.saml2.StatusBuilder;
import org.husky.xua.saml2.StatusCode;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.protocol.StatusType;
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
	 * @see org.husky.xua.saml2.StatusBuilder#create()
	 */
	@Override
	public Status create() {
		return new StatusImpl(status);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.core.SecurityObjectBuilder#create(java.lang.Object)
	 */
	@Override
	public Status create(org.opensaml.saml.saml2.core.Status aInternalObject) {
		return new StatusImpl(aInternalObject);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.saml2.StatusBuilder#create(StatusType)
	 */
	public Status create(StatusType statusType) {
		return new StatusImpl(statusType);
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.saml2.StatusBuilder#statusCode(org.husky.xua.saml2.StatusCode)
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
	 * @see org.husky.xua.saml2.StatusBuilder#statusMessage(java.lang.String)
	 */
	@Override
	public StatusBuilder statusMessage(String aStatusMessage) {
		statusMessage.setValue(aStatusMessage);
		return this;
	}

}
