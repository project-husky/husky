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
package org.husky.xua.communication.clients.impl;

import java.io.UnsupportedEncodingException;

import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpPost;
import org.husky.xua.authentication.AuthnRequest;
import org.husky.xua.communication.config.IdpClientConfig;
import org.husky.xua.exceptions.SerializeException;

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
		final var post = super.getHttpPost(config);
		post.setConfig(getRequestConfig());
		post.setHeader(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
		post.setEntity(getUrlFormEntity(aAuthnRequest));
		return post;
	}

}
