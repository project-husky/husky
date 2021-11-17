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
package org.husky.xua.communication.config.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.husky.xua.communication.config.XuaClientConfig;
import org.husky.xua.communication.config.XuaClientConfigBuilder;
import org.husky.xua.communication.config.impl.XuaClientConfigBuilderImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class XuaClientConfigBuilderImplTest {

	private XuaClientConfigBuilder builder;
	private String testEndpointUrl;
	private String testPortName;
	private String testPortNamespace;
	private String testServiceName;
	private String testServiceNamespace;

	@BeforeEach
	public void setUp() throws Exception {
		builder = new XuaClientConfigBuilderImpl();
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.communication.config.impl.XuaClientConfigBuilderImpl#portName(java.lang.String)}.
	 */
	@Test
	public void testPortName() {
		final XuaClientConfig ref = builder.portName(testPortName).create();
		assertNotNull(ref);
		assertEquals(testPortName, ref.getPortName());
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.communication.config.impl.XuaClientConfigBuilderImpl#portNamespace(java.lang.String)}.
	 */
	@Test
	public void testPortNamespace() {
		final XuaClientConfig ref = builder.portNamespace(testPortNamespace).create();
		assertNotNull(ref);
		assertEquals(testPortNamespace, ref.getPortNamespace());
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.communication.config.impl.XuaClientConfigBuilderImpl#serviceName(java.lang.String)}.
	 */
	@Test
	public void testServiceName() {
		final XuaClientConfig ref = builder.serviceName(testServiceName).create();
		assertNotNull(ref);
		assertEquals(testServiceName, ref.getServiceName());
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.communication.config.impl.XuaClientConfigBuilderImpl#serviceNamespace(java.lang.String)}.
	 */
	@Test
	public void testServiceNamespace() {
		final XuaClientConfig ref = builder.serviceNamespace(testServiceNamespace).create();
		assertNotNull(ref);
		assertEquals(testServiceNamespace, ref.getServiceNamespace());
	}

	/**
	 * Test method for
	 * {@link org.husky.xua.communication.config.impl.XuaClientConfigBuilderImpl#url(java.lang.String)}.
	 */
	@Test
	public void testUrl() {
		final XuaClientConfig ref = builder.url(testEndpointUrl).create();
		assertNotNull(ref);
		assertEquals(testEndpointUrl, ref.getUrl());
	}

}
