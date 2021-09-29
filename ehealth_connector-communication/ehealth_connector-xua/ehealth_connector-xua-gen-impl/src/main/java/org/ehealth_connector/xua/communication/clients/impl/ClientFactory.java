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
package org.ehealth_connector.xua.communication.clients.impl;

import org.ehealth_connector.xua.communication.clients.IdpClient;
import org.ehealth_connector.xua.communication.clients.XuaClient;
import org.ehealth_connector.xua.communication.config.IdpClientConfig;
import org.ehealth_connector.xua.communication.config.XuaClientConfig;
import org.ehealth_connector.xua.communication.config.impl.IdpClientBasicAuthConfigImpl;
import org.ehealth_connector.xua.communication.config.impl.IdpClientByBrowserAndProtocolHandlerConfigImpl;
import org.ehealth_connector.xua.communication.config.impl.IdpClientCertificateAuthConfigImpl;
import org.ehealth_connector.xua.communication.config.impl.IdpClientViaHttpProxyConfigImpl;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the factory to instantiate correct clients according to the configuration.</div>
 * <div class="de">Klasse welche die Factory implementiert um Client Instanzen entsprechend der Konfiguration zu erstellen.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class ClientFactory {
	
	protected ClientFactory() {
	}
	
	public static IdpClient getIdpClient(IdpClientConfig clientConfiguration) {
		if (clientConfiguration instanceof IdpClientViaHttpProxyConfigImpl) {
			return new IdpClientByProxy((IdpClientViaHttpProxyConfigImpl) clientConfiguration);
		} else if (clientConfiguration instanceof IdpClientCertificateAuthConfigImpl) {
			return new IdpClientByCert((IdpClientCertificateAuthConfigImpl) clientConfiguration);
		} else if (clientConfiguration instanceof IdpClientBasicAuthConfigImpl) {
			return new IdpSoapBindingClientByBasicAuth(
					(IdpClientBasicAuthConfigImpl) clientConfiguration);
		} else if (clientConfiguration instanceof IdpClientByBrowserAndProtocolHandlerConfigImpl) {
			return new IdpClientByBrowserAndProtocolHandler(
					(IdpClientByBrowserAndProtocolHandlerConfigImpl) clientConfiguration);
		}
		return null;
	}

	public static XuaClient getXuaClient(XuaClientConfig clientConfiguration) {
		return new SimpleXuaClient(clientConfiguration);
	}
}
