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

import org.projecthusky.xua.communication.config.ClientConfigBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the interface ClientConfigBuilder serving as builder to create config for client with basic authentication.</div>
 * <div class="de">Klasse die das Interface ClienConfiguilder implementiert. Dient dazu eine Client Konfiguration zu bilden für die Kommunikation mit BasicAuthentication.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class IdpClientBasicAuthConfigBuilderImpl implements ClientConfigBuilder {

	private IdpClientBasicAuthConfigImpl config;

	/**
	 * Default constructor
	 */
	public IdpClientBasicAuthConfigBuilderImpl() {
		config = new IdpClientBasicAuthConfigImpl();
	}

	/**
	 * to set basicAuthPassword
	 * 
	 * @param aBasicAuthPassword the basicAuthPassword to be set
	 * @return this instance of builder
	 */
	public IdpClientBasicAuthConfigBuilderImpl basicAuthPassword(String aBasicAuthPassword) {
		config.setBasicAuthPassword(aBasicAuthPassword);
		return this;
	}

	/**
	 * to set aBasicAuthUsername
	 * 
	 * @param aBasicAuthUsername the aBasicAuthUsername to be set
	 * @return this instance of builder
	 */
	public IdpClientBasicAuthConfigBuilderImpl basicAuthUsername(String aBasicAuthUsername) {
		config.setBasicAuthUsername(aBasicAuthUsername);
		return this;
	}

	/**
	 * Method to create instance.
	 * 
	 * @return the instance be returned
	 */
	public IdpClientBasicAuthConfigImpl create() {
		return config;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.projecthusky.xua.communication.config.ClientConfigBuilder#url(java.lang.String)
	 */
	@Override
	public IdpClientBasicAuthConfigBuilderImpl url(String aEndpointUrl) {
		config.setUrl(aEndpointUrl);
		return this;
	}

}
