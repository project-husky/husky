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
 * <div class="en">Implementation class of Interface IdpClientConfig</div>
 * <div class="de">Implementations Klasse von Interface IdpClientConfig</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class IdpClientBasicAuthConfigImpl extends AbstractClientConfig implements IdpClientConfig {

	private String basicAuthPassword;

	private String basicAuthUsername;

	/**
	 * Default constructor
	 */
	protected IdpClientBasicAuthConfigImpl() {

	}

	/**
	 * Method to get the
	 * 
	 * @return basicAuthPassword
	 */
	public String getBasicAuthPassword() {
		return basicAuthPassword;
	}

	/**
	 * Method to get the
	 * 
	 * @return basicAuthUsername
	 */
	public String getBasicAuthUsername() {
		return basicAuthUsername;
	}

	/**
	 * Method to set the
	 * 
	 * @param basicAuthPassword the auth password
	 */
	public void setBasicAuthPassword(String basicAuthPassword) {
		this.basicAuthPassword = basicAuthPassword;
	}

	/**
	 * Method to set the
	 * 
	 * @param basicAuthUsername the auth username
	 */
	public void setBasicAuthUsername(String basicAuthUsername) {
		this.basicAuthUsername = basicAuthUsername;
	}
}
