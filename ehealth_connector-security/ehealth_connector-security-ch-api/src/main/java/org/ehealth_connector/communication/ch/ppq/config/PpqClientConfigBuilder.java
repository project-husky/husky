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
package org.ehealth_connector.communication.ch.ppq.config;

import org.ehealth_connector.security.communication.config.SoapClientConfigBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the PpqClientConfigBuilder methods.</div>
 * <div class="de">Interface beschreibende methoden des PpqClientConfigBuilder.</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * <!-- @formatter:on -->
 */
public interface PpqClientConfigBuilder extends SoapClientConfigBuilder {

	/**
	 * 
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.communication.config.ClientConfigBuilder#url(java.lang.String)
	 */
	@Override
	PpqClientConfigBuilder url(String aEndpointUrl);

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.communication.config.SoapClientConfigBuilder#portName(java.lang.String)
	 */
	@Override
	default SoapClientConfigBuilder portName(String portName) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.communication.config.SoapClientConfigBuilder#portNamespace(java.lang.String)
	 */
	@Override
	default SoapClientConfigBuilder portNamespace(String portNamespace) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.communication.config.SoapClientConfigBuilder#serviceName(java.lang.String)
	 */
	@Override
	default SoapClientConfigBuilder serviceName(String serviceName) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.communication.config.SoapClientConfigBuilder#serviceNamespace(java.lang.String)
	 */
	@Override
	default SoapClientConfigBuilder serviceNamespace(String serviceNamespace) {
		return null;
	}

	/**
	  * <!-- @formatter:off -->
	 * <div class="en">Creates a concrete instance of PpqClientConfig with setted params.</div>
	 * <div class="de">Erstellt die konkrete instanz des PpqClientConfig mit den gesetzten parametern.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @return 
	 *  <div class="en">a new PpqClientConfig instance with the params set</div>
	 *  <div class="de">eine neue PpqClientConfig instanz mit den gesetzten parametern</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 *  <!-- @formatter:on -->
	 */
	PpqClientConfig create();

}
