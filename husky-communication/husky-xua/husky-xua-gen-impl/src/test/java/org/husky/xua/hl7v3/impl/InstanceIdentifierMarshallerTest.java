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
package org.husky.xua.hl7v3.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.husky.xua.hl7v3.OpenSamlInstanceIdentifier;
import org.husky.xua.hl7v3.impl.InstanceIdentifierBuilder;
import org.husky.xua.hl7v3.impl.InstanceIdentifierMarshaller;
import org.husky.xua.utilities.impl.InitializerTestHelper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opensaml.core.config.InitializationService;
import org.opensaml.core.xml.io.MarshallingException;
import org.w3c.dom.Element;

public class InstanceIdentifierMarshallerTest extends InitializerTestHelper {

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		// Initialize the library
		InitializationService.initialize();
	}

	private String testExtension;
	private String testRoot;

	private OpenSamlInstanceIdentifier testXmlObject;

	@BeforeEach
	public void setUp() throws Exception {
		testRoot = "1.2.3.4.5.6.7.8.9";
		testExtension = "123456789";

		testXmlObject = new InstanceIdentifierBuilder().buildObject();
		testXmlObject.setRoot(testRoot);
		testXmlObject.setExtension(testExtension);
	}

	/**
	 * Test method for
	 * {@link org.opensaml.core.xml.io.AbstractXMLObjectMarshaller#marshall(org.opensaml.core.xml.XMLObject, org.w3c.dom.Document)}.
	 *
	 * @throws MarshallingException
	 */
	@Test
	void testMarshallXMLObjectDocument() throws MarshallingException {
		final InstanceIdentifierMarshaller marshaller = new InstanceIdentifierMarshaller();
		final Element ref = marshaller.marshall(testXmlObject);
		assertNotNull(ref);
		logXmlObject(ref);
		assertEquals(testRoot, ref.getAttribute("root"));
		assertEquals(testExtension, ref.getAttribute("extension"));
	}

}
