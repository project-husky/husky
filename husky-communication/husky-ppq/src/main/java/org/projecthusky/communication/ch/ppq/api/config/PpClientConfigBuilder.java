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
package org.projecthusky.communication.ch.ppq.api.config;

import org.projecthusky.xua.communication.config.SoapClientConfigBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the PpClientConfigBuilder methods.</div>
 * <div class="de">Interface beschreibt die Methoden des PpClientConfigBuilder.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface PpClientConfigBuilder extends SoapClientConfigBuilder {

	@Override
	PpClientConfigBuilder clientKeyStore(String clientKeyStoreFile);

	@Override
	PpClientConfigBuilder clientKeyStorePassword(String clientKeyStorePassword);

	@Override
	PpClientConfigBuilder clientKeyStoreType(String clientKeyStoreType);

	/**
	  * <!-- @formatter:off -->
	 * <div class="en">Creates a concrete instance of PpClientConfig with setted params.</div>
	 * <div class="de">Erstellt die konkrete Instanz des PpClientConfig mit den gesetzten Parametern.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 *  <div class="en">a new PpClientConfig instance with the params set</div>
	 *  <div class="de">eine neue PpClientConfig Instanz mit den gesetzten Parametern</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 *  <!-- @formatter:on -->
	 */
	PpClientConfig create();

	/**
	 * {@inheritDoc}
	 *
	 * @see org.projecthusky.xua.communication.config.SoapClientConfigBuilder#portName(java.lang.String)
	 */
	@Override
	PpClientConfigBuilder portName(String portName);

	/**
	 * {@inheritDoc}
	 *
	 * @see org.projecthusky.xua.communication.config.SoapClientConfigBuilder#portNamespace(java.lang.String)
	 */
	@Override
	PpClientConfigBuilder portNamespace(String portNamespace);

	/**
	 * {@inheritDoc}
	 *
	 * @see org.projecthusky.xua.communication.config.SoapClientConfigBuilder#serviceName(java.lang.String)
	 */
	@Override
	PpClientConfigBuilder serviceName(String serviceName);

	/**
	 * {@inheritDoc}
	 *
	 * @see org.projecthusky.xua.communication.config.SoapClientConfigBuilder#serviceNamespace(java.lang.String)
	 */
	@Override
	PpClientConfigBuilder serviceNamespace(String serviceNamespace);

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.projecthusky.xua.communication.config.ClientConfigBuilder#url(java.lang.String)
	 */
	@Override
	PpClientConfigBuilder url(String aEndpointUrl);

}
