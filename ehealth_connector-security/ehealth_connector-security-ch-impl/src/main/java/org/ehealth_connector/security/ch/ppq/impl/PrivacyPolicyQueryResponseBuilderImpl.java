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
package org.ehealth_connector.security.ch.ppq.impl;

import org.ehealth_connector.security.ch.ppq.PrivacyPolicyQueryResponse;
import org.ehealth_connector.security.ch.ppq.PrivacyPolicyQueryResponseBuilder;
import org.ehealth_connector.security.core.SecurityObjectBuilder;
import org.opensaml.saml.saml2.core.Response;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the interfaces PrivacyPolicyQueryResponseBuilder and SecurityObjectBuilder.</div>
 * <div class="de">Klasse welche das Interface PrivacyPolicyQueryResponseBuilder and SecurityObjectBuilder implementiert.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->/div>
 * <!-- @formatter:on -->
 */
public class PrivacyPolicyQueryResponseBuilderImpl implements PrivacyPolicyQueryResponseBuilder,
		SecurityObjectBuilder<Response, PrivacyPolicyQueryResponse> {

	@Override
	public PrivacyPolicyQueryResponse create(Response request) {
		return new PrivacyPolicyQueryResponseImpl(request);
	}

}
