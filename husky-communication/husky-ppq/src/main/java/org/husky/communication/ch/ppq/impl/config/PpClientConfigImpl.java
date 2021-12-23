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
import org.husky.xua.communication.config.impl.BaseSoapClientConfigImpl;

/**
 * Implementation class of Interface PpClientConfig
 */
public class PpClientConfigImpl extends BaseSoapClientConfigImpl implements PpClientConfig {

	// There are no special methods defined, but the interface has to be
	// declared for selection reasons.
	protected PpClientConfigImpl() {
		setSoapVersion(SoapVersion.SOAP_12);
	}

}
