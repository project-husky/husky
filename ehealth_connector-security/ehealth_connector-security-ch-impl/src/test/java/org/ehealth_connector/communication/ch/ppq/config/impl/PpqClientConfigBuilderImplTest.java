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
package org.ehealth_connector.communication.ch.ppq.config.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.ehealth_connector.security.communication.ch.ppq.config.PpClientConfig;
import org.ehealth_connector.security.communication.ch.ppq.config.impl.PpqClientConfigBuilderImpl;
import org.junit.Before;
import org.junit.Test;

public class PpqClientConfigBuilderImplTest {

	private PpqClientConfigBuilderImpl builder;
	private String testEnpointUrl;
	private String testPortName;
	private String testPortNamespace;
	private String testServiceName;
	private String testServiceNamespace;

	@Before
	public void setUp() throws Exception {
		builder = new PpqClientConfigBuilderImpl();
		testEnpointUrl = "https://guguseli.ch/not/a/very/endpoint";
		testPortName = "myPortName";
		testPortNamespace = "urn:this.ist.my.namspace";
		testServiceName = "MyServiceName";
		testServiceNamespace = "urn:this.ist.my.namspace";
	}

	/**
	 * Test method for {@link org.ehealth_connector.security.communication.ch.ppq.config.impl.PpqClientConfigBuilderImpl#url(java.lang.String)}.
	 */
	@Test
	public void testUrl() {
		final PpClientConfig ref = builder.url(testEnpointUrl).create();
		assertNotNull(ref);
		assertEquals(testEnpointUrl, ref.getUrl());
	}

	/**
	 * Test method for {@link org.ehealth_connector.security.communication.ch.ppq.config.impl.PpqClientConfigBuilderImpl#portName(java.lang.String)}.
	 */
	@Test
	public void testPortName() {
		final PpClientConfig ref = builder.portName(testPortName).create();
		assertNotNull(ref);
		assertEquals(testPortName, ref.getPortName());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.communication.ch.ppq.config.impl.PpqClientConfigBuilderImpl#portNamespace(java.lang.String)}.
	 */
	@Test
	public void testPortNamespace() {
		final PpClientConfig ref = builder.portNamespace(testPortNamespace).create();
		assertNotNull(ref);
		assertEquals(testPortNamespace, ref.getPortNamespace());
	}

	/**
	 * Test method for {@link org.ehealth_connector.security.communication.ch.ppq.config.impl.PpqClientConfigBuilderImpl#serviceName(java.lang.String)}.
	 */
	@Test
	public void testServiceName() {
		final PpClientConfig ref = builder.serviceName(testServiceName).create();
		assertNotNull(ref);
		assertEquals(testServiceName, ref.getServiceName());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.security.communication.ch.ppq.config.impl.PpqClientConfigBuilderImpl#serviceNamespace(java.lang.String)}.
	 */
	@Test
	public void testServiceNamespace() {
		final PpClientConfig ref = builder.serviceNamespace(testServiceNamespace).create();
		assertNotNull(ref);
		assertEquals(testServiceNamespace, ref.getServiceNamespace());
	}

}
