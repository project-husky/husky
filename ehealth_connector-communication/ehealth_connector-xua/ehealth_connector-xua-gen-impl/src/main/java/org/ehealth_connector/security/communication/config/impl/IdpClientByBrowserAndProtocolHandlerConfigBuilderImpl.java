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
package org.ehealth_connector.security.communication.config.impl;

import org.ehealth_connector.security.communication.config.ClientConfigBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the interface ClientConfigBuilder serving as builder to create config for client to communicate with client certificate.</div>
 * <div class="de">Klasse die das Interface ClienConfiguilder implementiert. Dient dazu eine Client Konfiguration zu bilden für die Kommunikation mit Client Zertifikat.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class IdpClientByBrowserAndProtocolHandlerConfigBuilderImpl implements ClientConfigBuilder {

	private IdpClientByBrowserAndProtocolHandlerConfigImpl clientConfig;

	public IdpClientByBrowserAndProtocolHandlerConfigBuilderImpl() {
		clientConfig = new IdpClientByBrowserAndProtocolHandlerConfigImpl();
		clientConfig.setSamlRequestType(
				IdpClientByBrowserAndProtocolHandlerConfigImpl.SamlRequestType.SAMLart);
	}

	public IdpClientByBrowserAndProtocolHandlerConfigImpl create() {
		return clientConfig;
	}

	public IdpClientByBrowserAndProtocolHandlerConfigBuilderImpl protocolHandlerName(
			String aProtocolHandlerName) {
		clientConfig.setProtocolHandlerName(aProtocolHandlerName);
		return this;
	}

	public IdpClientByBrowserAndProtocolHandlerConfigBuilderImpl samlRequestType(
			IdpClientByBrowserAndProtocolHandlerConfigImpl.SamlRequestType samlRequestType) {
		clientConfig.setSamlRequestType(samlRequestType);
		return this;
	}

	@Override
	public IdpClientByBrowserAndProtocolHandlerConfigBuilderImpl url(String aEndpointUrl) {
		clientConfig.setUrl(aEndpointUrl);
		return this;
	}

}
