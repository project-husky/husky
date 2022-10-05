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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.projecthusky.xua.communication.config.XuaClientConfig;
import org.projecthusky.xua.communication.config.XuaClientConfigBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class XuaClientConfigBuilderImplTest {

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
	 * {@link org.projecthusky.xua.communication.config.impl.XuaClientConfigBuilderImpl#portName(java.lang.String)}.
	 */
	@Test
	void testPortName() {
		final XuaClientConfig ref = builder.portName(testPortName).create();
		assertNotNull(ref);
		assertEquals(testPortName, ref.getPortName());
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.xua.communication.config.impl.XuaClientConfigBuilderImpl#portNamespace(java.lang.String)}.
	 */
	@Test
	void testPortNamespace() {
		final XuaClientConfig ref = builder.portNamespace(testPortNamespace).create();
		assertNotNull(ref);
		assertEquals(testPortNamespace, ref.getPortNamespace());
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.xua.communication.config.impl.XuaClientConfigBuilderImpl#serviceName(java.lang.String)}.
	 */
	@Test
	void testServiceName() {
		final XuaClientConfig ref = builder.serviceName(testServiceName).create();
		assertNotNull(ref);
		assertEquals(testServiceName, ref.getServiceName());
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.xua.communication.config.impl.XuaClientConfigBuilderImpl#serviceNamespace(java.lang.String)}.
	 */
	@Test
	void testServiceNamespace() {
		final XuaClientConfig ref = builder.serviceNamespace(testServiceNamespace).create();
		assertNotNull(ref);
		assertEquals(testServiceNamespace, ref.getServiceNamespace());
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.xua.communication.config.impl.XuaClientConfigBuilderImpl#url(java.lang.String)}.
	 */
	@Test
	void testUrl() {
		final XuaClientConfig ref = builder.url(testEndpointUrl).create();
		assertNotNull(ref);
		assertEquals(testEndpointUrl, ref.getUrl());
	}

}
