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
package org.ehealth_connector.security.communication.xua.impl;

import org.ehealth_connector.security.communication.xua.XUserAssertionResponse;
import org.ehealth_connector.security.core.SecurityObject;
import org.opensaml.soap.wstrust.RequestSecurityTokenResponse;

/**
 * <!-- @formatter:off -->
 * <div class="en">Implementation class of Interface XUserAssertionResponse and SecurityObject</div>
 * <div class="de">Implementations Klasse von  Interface XUserAssertionResponse und SecurityObject</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * <!-- @formatter:on -->
 */
public class XUserAssertionResponseImpl
		implements XUserAssertionResponse, SecurityObject<org.opensaml.soap.wstrust.RequestSecurityTokenResponse> {

	private RequestSecurityTokenResponse responseCollection;

	protected XUserAssertionResponseImpl(RequestSecurityTokenResponse aRequestSecurityTokenResponse) {
		responseCollection = aRequestSecurityTokenResponse;
	}

	@Override
	public RequestSecurityTokenResponse getWrappedObject() {
		return responseCollection;
	}

	@Override
	public String getContext() {
		return responseCollection.getContext();
	}

}
