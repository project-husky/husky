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

import org.projecthusky.xua.communication.config.SoapClientConfig;
import org.projecthusky.xua.communication.config.SoapClientConfigBuilder;
import org.projecthusky.xua.communication.config.SoapClientConfig.SoapVersion;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the interface ClientConfigBuilder serving as builder to create config for client with basic authentication.</div>
 * <div class="de">Klasse die das Interface ClienConfiguilder implementiert. Dient dazu eine Client Konfiguration zu bilden für die Kommunikation mit BasicAuthentication.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class SoapClientConfigBuilderImpl implements SoapClientConfigBuilder {

	private SoapClientConfig config;

	/**
	 * Default Constructor
	 */
	public SoapClientConfigBuilderImpl() {
		config = new BaseSoapClientConfigImpl();
	}

	@Override
	public SoapClientConfigBuilderImpl clientKeyStore(String clientKeyStore) {
		config.setKeyStore(clientKeyStore);
		return this;
	}

	@Override
	public SoapClientConfigBuilderImpl clientKeyStorePassword(String clientKeyStorePassword) {
		config.setKeyStorePassword(clientKeyStorePassword);
		return this;
	}

	@Override
	public SoapClientConfigBuilderImpl clientKeyStoreType(String clientKeyStoreType) {
		config.setKeyStoreType(clientKeyStoreType);
		return this;
	}

	/**
	 * Method to create the config.
	 * @return the config created
	 */
	public SoapClientConfig create() {
		return config;
	}

	@Override
	public SoapClientConfigBuilderImpl portName(String portName) {
		config.setPortName(portName);
		return this;
	}

	@Override
	public SoapClientConfigBuilderImpl portNamespace(String portNamespace) {
		config.setPortNamespace(portNamespace);
		return this;
	}

	@Override
	public SoapClientConfigBuilderImpl serviceName(String serviceName) {
		config.setServiceName(serviceName);
		return this;
	}

	@Override
	public SoapClientConfigBuilderImpl serviceNamespace(String serviceNamespace) {
		config.setServiceNamespace(serviceNamespace);
		return this;
	}

	@Override
	public SoapClientConfigBuilder simple(boolean aSimple) {

		return this;
	}

	@Override
	public SoapClientConfigBuilderImpl soapVersion(SoapVersion soapVersion) {
		config.setSoapVersion(soapVersion);
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.projecthusky.xua.communication.config.ClientConfigBuilder#url(java.lang.String)
	 */
	@Override
	public SoapClientConfigBuilderImpl url(String aEndpointUrl) {
		config.setUrl(aEndpointUrl);
		return this;
	}

}
