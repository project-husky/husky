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
package org.projecthusky.xua.communication.clients.impl;

import org.projecthusky.xua.communication.clients.IdpClient;
import org.projecthusky.xua.communication.clients.XuaClient;
import org.projecthusky.xua.communication.config.IdpClientConfig;
import org.projecthusky.xua.communication.config.XuaClientConfig;
import org.projecthusky.xua.communication.config.impl.IdpClientBasicAuthConfigImpl;
import org.projecthusky.xua.communication.config.impl.IdpClientByBrowserAndProtocolHandlerConfigImpl;
import org.projecthusky.xua.communication.config.impl.IdpClientCertificateAuthConfigImpl;
import org.projecthusky.xua.communication.config.impl.IdpClientViaHttpProxyConfigImpl;

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
		if (clientConfiguration instanceof IdpClientViaHttpProxyConfigImpl idpClientViaHttpProxyConfigImpl) {
			return new IdpClientByProxy(idpClientViaHttpProxyConfigImpl);
		} else if (clientConfiguration instanceof IdpClientCertificateAuthConfigImpl idpClientCertificateAuthConfigImpl) {
			return new IdpClientByCert(idpClientCertificateAuthConfigImpl);
		} else if (clientConfiguration instanceof IdpClientBasicAuthConfigImpl idpClientBasicAuthConfigImpl) {
			return new IdpSoapBindingClientByBasicAuth(idpClientBasicAuthConfigImpl);
		} else if (clientConfiguration instanceof IdpClientByBrowserAndProtocolHandlerConfigImpl idpClientByBrowserAndProtocolHandlerConfigImpl) {
			return new IdpClientByBrowserAndProtocolHandler(idpClientByBrowserAndProtocolHandlerConfigImpl);
		}
		return null;
	}

	public static XuaClient getXuaClient(XuaClientConfig clientConfiguration) {
		return new SimpleXuaClient(clientConfiguration);
	}
}
