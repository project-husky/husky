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
package org.husky.xua.communication.config.impl;

import org.husky.xua.communication.config.XuaClientConfig;
import org.husky.xua.communication.config.XuaClientConfigBuilder;
import org.husky.xua.communication.config.SoapClientConfig.SoapVersion;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the interface XuaClientConfigBuilder.</div>
 * <div class="de">Klasse die das Interface XuaClientConfigBuilder implementiert.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class XuaClientConfigBuilderImpl implements XuaClientConfigBuilder {

	private XuaClientConfigImpl config;

	public XuaClientConfigBuilderImpl() {
		config = new XuaClientConfigImpl();
		config.setSoapVersion(SoapVersion.SOAP_12);
	}

	@Override
	public XuaClientConfigBuilder clientKeyStore(String aClientKeyStoreFile) {
		config.setKeyStore(aClientKeyStoreFile);
		return this;
	}

	@Override
	public XuaClientConfigBuilder clientKeyStorePassword(String clientKeyStorePassword) {
		config.setKeyStorePassword(clientKeyStorePassword);
		return this;
	}

	@Override
	public XuaClientConfigBuilder clientKeyStoreType(String clientKeyStoreType) {
		config.setKeyStoreType(clientKeyStoreType);
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.communication.config.XuaClientConfigBuilder#create()
	 */
	@Override
	public XuaClientConfig create() {
		return config;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.communication.config.XuaClientConfigBuilder#portName(java.lang.String)
	 */
	@Override
	public XuaClientConfigBuilder portName(String portName) {
		config.setPortName(portName);
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.communication.config.XuaClientConfigBuilder#portNamespace(java.lang.String)
	 */
	@Override
	public XuaClientConfigBuilder portNamespace(String portNamespace) {
		config.setPortNamespace(portNamespace);
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.communication.config.XuaClientConfigBuilder#serviceName(java.lang.String)
	 */
	@Override
	public XuaClientConfigBuilder serviceName(String serviceName) {
		config.setServiceName(serviceName);
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.communication.config.XuaClientConfigBuilder#serviceNamespace(java.lang.String)
	 */
	@Override
	public XuaClientConfigBuilder serviceNamespace(String serviceNamespace) {
		config.setServiceNamespace(serviceNamespace);
		return this;
	}

	@Override
	public XuaClientConfigBuilder simple(boolean aSimple) {
		config.setSimple(aSimple);
		return this;
	}

	@Override
	public XuaClientConfigBuilder soapVersion(SoapVersion soapVersion) {
		config.setSoapVersion(soapVersion);
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.communication.config.ClientConfigBuilder#url(java.lang.String)
	 */
	@Override
	public XuaClientConfigBuilder url(String aEndpointUri) {
		config.setUrl(aEndpointUri);
		return this;
	}

}
