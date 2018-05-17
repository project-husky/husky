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
package org.ehealth_connector.security.communication.ch.ppq.config;

import org.ehealth_connector.security.communication.config.SoapClientConfigBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the PpClientConfigBuilder methods.</div>
 * <div class="de">Interface beschreibende methoden des PpClientConfigBuilder.</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * <!-- @formatter:on -->
 */
public interface PpClientConfigBuilder extends SoapClientConfigBuilder {

	/**
	 * 
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.communication.config.ClientConfigBuilder#url(java.lang.String)
	 */
	@Override
	PpClientConfigBuilder url(String aEndpointUrl);

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.communication.config.SoapClientConfigBuilder#portName(java.lang.String)
	 */
	@Override
	PpClientConfigBuilder portName(String portName);

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.communication.config.SoapClientConfigBuilder#portNamespace(java.lang.String)
	 */
	@Override
	PpClientConfigBuilder portNamespace(String portNamespace);

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.communication.config.SoapClientConfigBuilder#serviceName(java.lang.String)
	 */
	@Override
	PpClientConfigBuilder serviceName(String serviceName);

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.communication.config.SoapClientConfigBuilder#serviceNamespace(java.lang.String)
	 */
	@Override
	PpClientConfigBuilder serviceNamespace(String serviceNamespace);

	@Override
	PpClientConfigBuilder clientKeyStore(String clientKeyStoreFile);

	@Override
	PpClientConfigBuilder clientKeyStorePassword(String clientKeyStorePassword);

	@Override
	PpClientConfigBuilder clientKeyStoreType(String clientKeyStoreType);

	/**
	  * <!-- @formatter:off -->
	 * <div class="en">Creates a concrete instance of PpClientConfig with setted params.</div>
	 * <div class="de">Erstellt die konkrete instanz des PpClientConfig mit den gesetzten parametern.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @return 
	 *  <div class="en">a new PpClientConfig instance with the params set</div>
	 *  <div class="de">eine neue PpClientConfig instanz mit den gesetzten parametern</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 *  <!-- @formatter:on -->
	 */
	PpClientConfig create();

}
