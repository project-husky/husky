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
package org.husky.xua.communication.xua.impl;

import org.husky.xua.communication.xua.XUserAssertionResponse;
import org.husky.xua.communication.xua.XUserAssertionResponseBuilder;
import org.husky.xua.core.SecurityObjectBuilder;
import org.opensaml.soap.wstrust.RequestSecurityTokenResponse;
import org.opensaml.soap.wstrust.impl.RequestSecurityTokenResponseBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the corresponding interfaces XUserAssertionResponseBuilder and SecurityObjectBuilder.</div>
 * <div class="de">Die Klasse implementiert die entsprechenden Interfaces XUserAssertionResponseBuilder und SecurityObjectBuilder.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class XUserAssertionResponseBuilderImpl implements XUserAssertionResponseBuilder,
		SecurityObjectBuilder<RequestSecurityTokenResponse, XUserAssertionResponse> {

	private RequestSecurityTokenResponse response;

	public XUserAssertionResponseBuilderImpl() {
		response = new RequestSecurityTokenResponseBuilder().buildObject();
	}

	@Override
	public XUserAssertionResponse create() {
		return new XUserAssertionResponseImpl(response);
	}

	@Override
	public XUserAssertionResponse create(RequestSecurityTokenResponse aInternalObject) {
		return new XUserAssertionResponseImpl(aInternalObject);
	}

}
