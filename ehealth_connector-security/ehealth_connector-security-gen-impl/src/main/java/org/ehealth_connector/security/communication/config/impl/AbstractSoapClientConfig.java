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
package org.ehealth_connector.security.communication.config.impl;

import org.ehealth_connector.security.communication.config.SoapClientConfig;

/**
 * <!-- @formatter:off -->
 * <div class="en">Abstract implementation class of Interface SoapClientConfig</div>
 * <div class="de">Abstrakte implementations Klasse des Interfaces SoapClientConfig</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * <!-- @formatter:on -->
 */
public class AbstractSoapClientConfig extends AbstractClientConfig implements SoapClientConfig {
	public String portName;
	public String portNamespace;
	public String serviceName;
	public String serviceNamespace;

	public String keyStoreFile;
	public String keyStorePassword;
	public String keyStoreType;

	private boolean simple;

	@Override
	public String getPortName() {
		return portName;
	}

	@Override
	public String getPortNamespace() {
		return portNamespace;
	}

	@Override
	public String getServiceName() {
		return serviceName;
	}

	@Override
	public String getServiceNamespace() {
		return serviceNamespace;
	}

	@Override
	public void setPortName(String portName) {
		this.portName = portName;
	}

	@Override
	public void setPortNamespace(String portNamespace) {
		this.portNamespace = portNamespace;
	}

	@Override
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	@Override
	public void setServiceNamespace(String serviceNamespace) {
		this.serviceNamespace = serviceNamespace;
	}

	@Override
	public String getKeyStore() {
		return keyStoreFile;
	}

	@Override
	public String getKeyStorePassword() {
		return keyStorePassword;
	}

	@Override
	public String getKeyStoreType() {
		return keyStoreType;
	}

	@Override
	public void setKeyStore(String aKeyStore) {
		keyStoreFile = aKeyStore;
	}

	@Override
	public void setKeyStorePassword(String aKeyStorePassword) {
		keyStorePassword = aKeyStorePassword;
	}

	@Override
	public void setKeyStoreType(String aKeyStoreType) {
		keyStoreType = aKeyStoreType;
	}

	@Override
	public boolean isSimple() {
		return simple;
	}

	public void setSimple(boolean aSimple) {
		simple = aSimple;
	}
}
