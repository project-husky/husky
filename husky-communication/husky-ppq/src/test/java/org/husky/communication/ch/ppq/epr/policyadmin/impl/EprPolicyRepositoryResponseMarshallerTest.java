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
package org.husky.communication.ch.ppq.epr.policyadmin.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.husky.communication.ch.ppq.epr.policyadmin.api.OpenSamlEprPolicyRepositoryResponse;
import org.husky.communication.ch.ppq.utilities.impl.InitializerTestHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opensaml.core.xml.config.XMLObjectProviderRegistrySupport;
import org.opensaml.core.xml.io.Marshaller;
import org.opensaml.core.xml.io.MarshallerFactory;
import org.opensaml.core.xml.io.MarshallingException;
import org.w3c.dom.Element;

class EprPolicyRepositoryResponseMarshallerTest extends InitializerTestHelper {

	private OpenSamlEprPolicyRepositoryResponse testOpenSamlEpdPolicyRepositoryResponse;
	private String testStatus;

	@BeforeEach
	public void setUp() throws Exception {
		testStatus = "This is a status";
		testOpenSamlEpdPolicyRepositoryResponse = new EprPolicyRepositoryResponseBuilderImpl()
				.status(testStatus).buildObject();
	}

	/**
	 * Test method for
	 * {@link org.opensaml.core.xml.io.AbstractXMLObjectMarshaller#marshall(org.opensaml.core.xml.XMLObject)}.
	 *
	 * @throws MarshallingException
	 */
	@Test
	void testMarshallXMLObject() throws MarshallingException {
		final MarshallerFactory marshallerFactory = XMLObjectProviderRegistrySupport
				.getMarshallerFactory();
		final Marshaller marshaller = marshallerFactory
				.getMarshaller(testOpenSamlEpdPolicyRepositoryResponse);

		final Element serialized = marshaller.marshall(testOpenSamlEpdPolicyRepositoryResponse);
		assertNotNull(serialized);
		assertEquals(testStatus, serialized.getAttribute("status"));
	}

}
