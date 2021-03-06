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
import org.husky.xua.saml2.Response;
import org.husky.xua.saml2.ResponseBuilder;

/**
 * @since Feb 22, 2018 9:26:34 AM
 *
 */
public class ResponseBuilderImpl implements ResponseBuilder,
		SecurityObjectBuilder<org.opensaml.saml.saml2.core.Response, Response> {

	private org.opensaml.saml.saml2.core.Response wrappedObject;

	public ResponseBuilderImpl() {
		wrappedObject = new org.opensaml.saml.saml2.core.impl.ResponseBuilder().buildObject();
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.saml2.ResponseBuilder#create()
	 */
	@Override
	public Response create() {
		return new ResponseImpl(wrappedObject);
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.core.SecurityObjectBuilder#create(java.lang.Object)
	 */
	@Override
	public Response create(org.opensaml.saml.saml2.core.Response aInternalObject) {
		return new ResponseImpl(aInternalObject);
	}

}
