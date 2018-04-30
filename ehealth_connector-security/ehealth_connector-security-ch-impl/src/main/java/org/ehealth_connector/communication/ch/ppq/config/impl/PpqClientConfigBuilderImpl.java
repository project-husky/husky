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
package org.ehealth_connector.communication.ch.ppq.config.impl;

import org.ehealth_connector.communication.ch.ppq.config.PpqClientConfig;
import org.ehealth_connector.communication.ch.ppq.config.PpqClientConfigBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the interface PpqClientConfigBuilder.</div>
 * <div class="de">Klasser die das Interface PpqClientConfigBuilder implementiert.</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * <!-- @formatter:on -->
 */
public class PpqClientConfigBuilderImpl implements PpqClientConfigBuilder {

	private PpqClientConfigImpl config;

	public PpqClientConfigBuilderImpl() {
		config = new PpqClientConfigImpl();
	}

	@Override
	public PpqClientConfigBuilder url(String aEndpointUrl) {
		config.setUrl(aEndpointUrl);
		return this;
	}

	@Override
	public PpqClientConfigBuilder portName(String portName) {
		config.setPortName(portName);
		return this;
	}

	@Override
	public PpqClientConfigBuilder portNamespace(String portNamespace) {
		config.setPortNamespace(portNamespace);
		return this;
	}

	@Override
	public PpqClientConfigBuilder serviceName(String serviceName) {
		config.setServiceName(serviceName);
		return this;
	}

	@Override
	public PpqClientConfigBuilder serviceNamespace(String serviceNamespace) {
		config.setServiceNamespace(serviceNamespace);
		return this;
	}

	@Override
	public PpqClientConfigBuilder clientKeyStore(String clientKeyStore) {
		config.setKeyStore(clientKeyStore);
		return this;
	}

	@Override
	public PpqClientConfigBuilder clientKeyStorePassword(String clientKeyStorePassword) {
		config.setKeyStorePassword(clientKeyStorePassword);
		return this;
	}

	@Override
	public PpqClientConfigBuilder clientKeyStoreType(String clientKeyStoreType) {
		config.setKeyStoreType(clientKeyStoreType);
		return this;
	}

	@Override
	public PpqClientConfig create() {
		return config;
	}

}
