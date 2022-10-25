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

import org.projecthusky.xua.communication.config.XuaClientConfig;

/**
 * <!-- @formatter:off -->
 * <div class="en">Implementation class of Interface XuaClientConfig</div>
 * <div class="de">Implementations Klasse von Interface XuaClientConfig</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class XuaClientConfigImpl extends BaseSoapClientConfigImpl implements XuaClientConfig {

	protected XuaClientConfigImpl() {
		setSoapVersion(SoapVersion.SOAP_12);
		setSimple(true);
	}

}
