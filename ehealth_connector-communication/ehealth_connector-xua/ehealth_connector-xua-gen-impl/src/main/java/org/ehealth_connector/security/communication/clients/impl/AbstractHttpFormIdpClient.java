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
package org.ehealth_connector.security.communication.clients.impl;

import java.io.UnsupportedEncodingException;

import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpPost;
import org.ehealth_connector.security.authentication.AuthnRequest;
import org.ehealth_connector.security.communication.config.IdpClientConfig;
import org.ehealth_connector.security.exceptions.SerializeException;

/**
 * <!-- @formatter:off -->
 * <div class="en">Abstract class implementing common methods for the concrete IdpClient implementations.</div>
 * <div class="de">Abstrakte Klasse die die gemeinsamen Methoden für die konkreten IdpClient Implementationen implementiert.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public abstract class AbstractHttpFormIdpClient extends AbstractIdpClient {

	HttpPost getHttpPost(AuthnRequest aAuthnRequest, IdpClientConfig config)
			throws UnsupportedEncodingException, SerializeException {
		final HttpPost post = super.getHttpPost(config);
		post.setConfig(getRequestConfig());
		post.setHeader(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
		post.setEntity(getUrlFormEntity(aAuthnRequest));
		return post;
	}

}
