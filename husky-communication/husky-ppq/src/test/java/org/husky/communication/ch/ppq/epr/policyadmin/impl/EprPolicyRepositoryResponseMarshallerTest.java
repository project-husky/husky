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
package org.husky.communication.ch.ppq.epr.policyadmin.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.husky.communication.ch.ppq.epr.policyadmin.api.OpenSamlEprPolicyRepositoryResponse;
import org.husky.communication.ch.ppq.epr.policyadmin.impl.EprPolicyRepositoryResponseBuilderImpl;
import org.husky.communication.ch.ppq.utilities.impl.InitializerTestHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opensaml.core.xml.config.XMLObjectProviderRegistrySupport;
import org.opensaml.core.xml.io.Marshaller;
import org.opensaml.core.xml.io.MarshallerFactory;
import org.opensaml.core.xml.io.MarshallingException;
import org.w3c.dom.Element;

public class EprPolicyRepositoryResponseMarshallerTest extends InitializerTestHelper {

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
	public void testMarshallXMLObject() throws MarshallingException {
		final MarshallerFactory marshallerFactory = XMLObjectProviderRegistrySupport
				.getMarshallerFactory();
		final Marshaller marshaller = marshallerFactory
				.getMarshaller(testOpenSamlEpdPolicyRepositoryResponse);

		final Element serialized = marshaller.marshall(testOpenSamlEpdPolicyRepositoryResponse);
		assertNotNull(serialized);
		assertEquals(testStatus, serialized.getAttribute("status"));
	}

}
