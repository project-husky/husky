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
package org.ehealth_connector.security.communication.ch.clients.impl;

import static org.junit.Assert.assertNotNull;

import org.ehealth_connector.security.communication.ch.clients.PpfClient;
import org.ehealth_connector.security.communication.ch.clients.PpqClient;
import org.ehealth_connector.security.communication.ch.ppq.config.PpClientConfig;
import org.ehealth_connector.security.communication.ch.ppq.config.impl.PpClientConfigBuilderImpl;
import org.junit.Before;
import org.junit.Test;

/**
 * Testclass to the the CH specific client factory.
 */
public class ClientFactoryChTest {

	private PpClientConfig testPpClientConfiguration;
	private String testPortName;

	/**
	 * Setup test parameters
	 */
	@Before
	public void setUp() throws Exception {
		testPortName = "My Port Name";
		testPpClientConfiguration = new PpClientConfigBuilderImpl().portName(testPortName).create();
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.communication.ch.clients.impl.ClientFactoryCh#getPpfClient(org.ehealth_connector.security.communication.ch.ppq.config.PpClientConfig)}.
	 */
	@Test
	public void testGetPpfClient() {
		final PpfClient ref = ClientFactoryCh.getPpfClient(testPpClientConfiguration);
		assertNotNull(ref);
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.communication.ch.clients.impl.ClientFactoryCh#getPpqClient(org.ehealth_connector.security.communication.ch.ppq.config.PpClientConfig)}.
	 */
	@Test
	public void testGetPpqClient() {
		final PpqClient ref = ClientFactoryCh.getPpqClient(testPpClientConfiguration);
		assertNotNull(ref);
	}

}
