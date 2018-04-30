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
package org.ehealth_connector.security.communication.config;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the XuaClientConfigBuilder methods.</div>
 * <div class="de">Interface beschreibende methoden des XuaClientConfigBuilder.</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * <!-- @formatter:on -->
 */
public interface XuaClientConfigBuilder extends SoapClientConfigBuilder {

	/**
	 * 
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.communication.config.ClientConfigBuilder#url(java.lang.String)
	 */
	@Override
	XuaClientConfigBuilder url(String aEndpointUri);

	/**
	 * 
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.communication.config.SoapClientConfigBuilder#portName(java.lang.String)
	 */
	@Override
	XuaClientConfigBuilder portName(String portName);

	/**
	 * 
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.communication.config.SoapClientConfigBuilder#portNamespace(java.lang.String)
	 */
	@Override
	XuaClientConfigBuilder portNamespace(String portNamespace);

	/**
	 * 
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.communication.config.SoapClientConfigBuilder#serviceName(java.lang.String)
	 */
	@Override
	XuaClientConfigBuilder serviceName(String serviceName);

	/**
	 * 
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.communication.config.SoapClientConfigBuilder#serviceNamespace(java.lang.String)
	 */
	@Override
	XuaClientConfigBuilder serviceNamespace(String serviceNamespace);

	/**
	 * 
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.communication.config.SoapClientConfigBuilder#clientKeyStore(java.lang.String)
	 */
	@Override
	XuaClientConfigBuilder clientKeyStore(String clientKeyStoreFile);

	/**
	 * 
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.communication.config.SoapClientConfigBuilder#clientKeyStorePassword(java.lang.String)
	 */
	@Override
	XuaClientConfigBuilder clientKeyStorePassword(String clientKeyStorePassword);

	/**
	 * 
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.communication.config.SoapClientConfigBuilder#clientKeyStoreType(java.lang.String)
	 */
	@Override
	XuaClientConfigBuilder clientKeyStoreType(String clientKeyStoreType);

	XuaClientConfigBuilder simple(boolean aSimple);

	/**
	 * 
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.communication.config.SoapClientConfigBuilder#create()
	 */
	XuaClientConfig create();
}
