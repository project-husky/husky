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

/**
 * <!-- @formatter:off -->
 * <div class="en">Abstract implementation class of Interface SoapClientConfig</div>
 * <div class="de">Abstrakte Implementations Klasse des Interfaces SoapClientConfig</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class BaseSoapClientConfigImpl extends AbstractClientConfig implements SoapClientConfig {
	private String keyStoreFile;
	private String keyStorePassword;
	private String keyStoreType;
	private String portName;

	private String portNamespace;
	private String serviceName;
	private String serviceNamespace;

	private boolean simple;
	private SoapVersion version;

	protected BaseSoapClientConfigImpl() {
		version = SoapVersion.SOAP_12;
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
	public SoapVersion getSoapVersion() {
		return version;
	}

	@Override
	public boolean isSimple() {
		return simple;
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

	public void setSimple(boolean aSimple) {
		simple = aSimple;
	}

	@Override
	public void setSoapVersion(SoapVersion aVersion) {
		version = aVersion;
	}
}
