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
package org.husky.xua.communication.config;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the XuaClientConfigBuilder methods.</div>
 * <div class="de">Interface welches die Methoden des XuaClientConfigBuilders beschreibt.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface XuaClientConfigBuilder extends SoapClientConfigBuilder {

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.communication.config.SoapClientConfigBuilder#clientKeyStore(java.lang.String)
	 */
	@Override
	XuaClientConfigBuilder clientKeyStore(String clientKeyStoreFile);

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.communication.config.SoapClientConfigBuilder#clientKeyStorePassword(java.lang.String)
	 */
	@Override
	XuaClientConfigBuilder clientKeyStorePassword(String clientKeyStorePassword);

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.communication.config.SoapClientConfigBuilder#clientKeyStoreType(java.lang.String)
	 */
	@Override
	XuaClientConfigBuilder clientKeyStoreType(String clientKeyStoreType);

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to create the config with the parameters set.</div>
	 * <div class="de">Methode um die Konfiguration mit den gesetzten Parametern zu erstellen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">the creakted XuaClientConfig instace.</div>
	 * <div class="de">Die erstellte XuaClientConfig Instanz.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	XuaClientConfig create();

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.communication.config.SoapClientConfigBuilder#portName(java.lang.String)
	 */
	@Override
	XuaClientConfigBuilder portName(String portName);

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.communication.config.SoapClientConfigBuilder#portNamespace(java.lang.String)
	 */
	@Override
	XuaClientConfigBuilder portNamespace(String portNamespace);

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.communication.config.SoapClientConfigBuilder#serviceName(java.lang.String)
	 */
	@Override
	XuaClientConfigBuilder serviceName(String serviceName);

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.communication.config.SoapClientConfigBuilder#serviceNamespace(java.lang.String)
	 */
	@Override
	XuaClientConfigBuilder serviceNamespace(String serviceNamespace);

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.communication.config.SoapClientConfigBuilder#simple(boolean)
	 */
	@Override
	XuaClientConfigBuilder simple(boolean aSimple);

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.communication.config.ClientConfigBuilder#url(java.lang.String)
	 */
	@Override
	XuaClientConfigBuilder url(String aEndpointUri);
}
