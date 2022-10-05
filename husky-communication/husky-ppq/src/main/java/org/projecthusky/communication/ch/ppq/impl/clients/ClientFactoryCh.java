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
package org.projecthusky.communication.ch.ppq.impl.clients;

import org.projecthusky.communication.ch.ppq.api.config.PpClientConfig;
import org.projecthusky.xua.communication.clients.impl.ClientFactory;
import org.springframework.stereotype.Component;

/**
 * Class implementing the factory to instantiate correct clients according to the configuration for CH implementations.
 */

@Component
public class ClientFactoryCh extends ClientFactory {

	private ClientFactoryCh() throws IllegalStateException {
		super();
	}

	public static SimplePpfClient getPpfClient(PpClientConfig clientConfiguration) {
		return new SimplePpfClient(clientConfiguration);
	}

	public static SimplePpqClient getPpqClient(PpClientConfig clientConfiguration) {
		return new SimplePpqClient(clientConfiguration);
	}
}
