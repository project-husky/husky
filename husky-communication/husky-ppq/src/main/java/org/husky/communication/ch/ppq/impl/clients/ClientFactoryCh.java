/*
 * This code is made available under the terms of the Eclipse Public License v1.0 in the github project https://github.com/project-husky/husky there you also find a list of the contributors and the license information.
This project has been developed further and modified by the joined working group Husky on the basis of the eHealth Connector opensource project from June 28, 2021, whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
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
package org.husky.communication.ch.ppq.impl.clients;

import org.husky.communication.ch.ppq.api.config.PpClientConfig;
import org.husky.xua.communication.clients.impl.ClientFactory;
import org.springframework.stereotype.Component;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the factory to instantiate correct clients according to the configuration for CH implementations.</div>
 * <div class="de">Klasse implementiert die factory um client instanzen entsprechend der Konfiguration zu erstellen für CH spezifische clients.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
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
