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
package org.husky.communication.ch.ppq.impl.config;

import org.husky.communication.ch.ppq.api.config.PpClientConfig;
import org.husky.communication.ch.ppq.api.config.PpClientConfigBuilder;
import org.husky.xua.communication.config.SoapClientConfigBuilder;
import org.husky.xua.communication.config.SoapClientConfig.SoapVersion;

/**
 * Class implementing the interface PpClientConfigBuilder.
 */
public class PpClientConfigBuilderImpl implements PpClientConfigBuilder {

	private PpClientConfigImpl config;

	public PpClientConfigBuilderImpl() {
		config = new PpClientConfigImpl();
		config.setSoapVersion(SoapVersion.SOAP_12);
	}

	@Override
	public PpClientConfigBuilder clientKeyStore(String clientKeyStore) {
		config.setKeyStore(clientKeyStore);
		return this;
	}

	@Override
	public PpClientConfigBuilder clientKeyStorePassword(String clientKeyStorePassword) {
		config.setKeyStorePassword(clientKeyStorePassword);
		return this;
	}

	@Override
	public PpClientConfigBuilder clientKeyStoreType(String clientKeyStoreType) {
		config.setKeyStoreType(clientKeyStoreType);
		return this;
	}

	@Override
	public PpClientConfig create() {
		return config;
	}

	@Override
	public PpClientConfigBuilder portName(String portName) {
		config.setPortName(portName);
		return this;
	}

	@Override
	public PpClientConfigBuilder portNamespace(String portNamespace) {
		config.setPortNamespace(portNamespace);
		return this;
	}

	@Override
	public PpClientConfigBuilder serviceName(String serviceName) {
		config.setServiceName(serviceName);
		return this;
	}

	@Override
	public PpClientConfigBuilder serviceNamespace(String serviceNamespace) {
		config.setServiceNamespace(serviceNamespace);
		return this;
	}

	@Override
	public SoapClientConfigBuilder simple(boolean aSimple) {
		config.setSimple(aSimple);
		return this;
	}

	@Override
	public SoapClientConfigBuilder soapVersion(SoapVersion soapVersion) {
		config.setSoapVersion(soapVersion);
		return this;
	}

	@Override
	public PpClientConfigBuilder url(String aEndpointUrl) {
		config.setUrl(aEndpointUrl);
		return this;
	}

}
