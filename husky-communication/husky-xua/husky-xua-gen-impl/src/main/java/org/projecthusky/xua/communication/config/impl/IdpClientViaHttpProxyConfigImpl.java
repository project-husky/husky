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
package org.projecthusky.xua.communication.config.impl;

import org.projecthusky.xua.communication.config.IdpClientConfig;

/**
 * <!-- @formatter:off -->
 * <div class="en">Implementation class of Interface IdpClientViaHttpProxyConfig</div>
 * <div class="de">Implementations Klasse von Interface IdpClientViaHttpProxyConfig</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class IdpClientViaHttpProxyConfigImpl extends AbstractClientConfig implements IdpClientConfig {

	private String proxyHost;

	private int proxyPort;

	private String proxyProtocol;

	/**
	 * Default constructor
	 */
	protected IdpClientViaHttpProxyConfigImpl() {

	}

	/**
	 * Method to get
	 * 
	 * @return the proxyHost
	 */
	public String getProxyHost() {
		return proxyHost;
	}

	/**
	 * Method to get
	 * 
	 * @return the proxyPort
	 */
	public int getProxyPort() {
		return proxyPort;
	}

	/**
	 * Method to get
	 * 
	 * @return the proxyProtocol
	 */
	public String getProxyProtocol() {
		return proxyProtocol;
	}

	/**
	 * Method to set
	 * 
	 * @param proxyHost the proxy host
	 */
	public void setProxyHost(String proxyHost) {
		this.proxyHost = proxyHost;
	}

	/**
	 * Method to set
	 * 
	 * @param proxyPort the proxy host
	 */
	public void setProxyPort(int proxyPort) {
		this.proxyPort = proxyPort;
	}

	/**
	 * Method to set
	 * 
	 * @param proxyProtocol the proxy protocol
	 */
	public void setProxyProtocol(String proxyProtocol) {
		this.proxyProtocol = proxyProtocol;
	}

}
