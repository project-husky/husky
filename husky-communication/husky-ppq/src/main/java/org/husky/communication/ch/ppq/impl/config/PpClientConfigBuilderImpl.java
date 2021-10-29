/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
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
package org.husky.communication.ch.ppq.impl.config;

import org.husky.communication.ch.ppq.api.config.PpClientConfig;
import org.husky.communication.ch.ppq.api.config.PpClientConfigBuilder;
import org.husky.xua.communication.config.SoapClientConfigBuilder;
import org.husky.xua.communication.config.SoapClientConfig.SoapVersion;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the interface PpClientConfigBuilder.</div>
 * <div class="de">Klasse die das Interface PpClientConfigBuilder implementiert.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
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
