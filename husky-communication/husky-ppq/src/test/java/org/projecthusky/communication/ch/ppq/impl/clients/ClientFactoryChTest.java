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

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.projecthusky.communication.ch.ppq.api.clients.PpfClient;
import org.projecthusky.communication.ch.ppq.api.clients.PpqClient;
import org.projecthusky.communication.ch.ppq.api.config.PpClientConfig;
import org.projecthusky.communication.ch.ppq.impl.config.PpClientConfigBuilderImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testclass to the the CH specific client factory.
 */
class ClientFactoryChTest {

	private PpClientConfig testPpClientConfiguration;
	private String testPortName;

	/**
	 * Setup test parameters
	 */
	@BeforeEach
	public void setUp() throws Exception {
		testPortName = "My Port Name";
		testPpClientConfiguration = new PpClientConfigBuilderImpl().portName(testPortName).create();
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.communication.ch.ppq.impl.clients.ClientFactoryCh#getPpfClient(org.projecthusky.communication.ch.ppq.api.config.PpClientConfig)}.
	 */
	@Test
	void testGetPpfClient() {
		final PpfClient ref = ClientFactoryCh.getPpfClient(testPpClientConfiguration);
		assertNotNull(ref);
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.communication.ch.ppq.impl.clients.ClientFactoryCh#getPpqClient(org.projecthusky.communication.ch.ppq.api.config.PpClientConfig)}.
	 */
	@Test
	void testGetPpqClient() {
		final PpqClient ref = ClientFactoryCh.getPpqClient(testPpClientConfiguration);
		assertNotNull(ref);
	}

}
