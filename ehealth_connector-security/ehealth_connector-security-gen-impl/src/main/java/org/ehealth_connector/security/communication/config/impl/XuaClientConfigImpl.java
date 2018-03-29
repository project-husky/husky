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

import org.ehealth_connector.security.communication.config.XuaClientConfig;

/**
 * <!-- @formatter:off -->
 * <div class="en">Implementation class of Interface XuaClientConfig</div>
 * <div class="de">Implementations Klasse von  Interface XuaClientConfig</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * <!-- @formatter:on -->
 */
public class XuaClientConfigImpl extends AbstractClientConfig implements XuaClientConfig {

	public String portName;
	public String portNamespace;
	public String serviceName;
	public String serviceNamespace;

	protected XuaClientConfigImpl() {

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

	protected void setPortName(String portName) {
		this.portName = portName;
	}

	protected void setPortNamespace(String portNamespace) {
		this.portNamespace = portNamespace;
	}

	protected void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	protected void setServiceNamespace(String serviceNamespace) {
		this.serviceNamespace = serviceNamespace;
	}

}
