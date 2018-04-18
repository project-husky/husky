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
package org.ehealth_connector.security.hl7v3.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.ehealth_connector.security.hl7v3.OpenSamlInstanceIdentifier;
import org.ehealth_connector.security.utilities.impl.InitializerTestHelper;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.opensaml.core.config.InitializationService;
import org.opensaml.core.xml.io.MarshallingException;
import org.w3c.dom.Element;

public class InstanceIdentifierMarshallerTest extends InitializerTestHelper {

	private OpenSamlInstanceIdentifier testXmlObject;
	private String testRoot;
	private String testExtension;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// Initialize the library
		InitializationService.initialize();
	}

	@Before
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
	public void testMarshallXMLObjectDocument() throws MarshallingException {
		final InstanceIdentifierMarshaller marshaller = new InstanceIdentifierMarshaller();
		final Element ref = marshaller.marshall(testXmlObject);
		assertNotNull(ref);
		logXmlObject(ref);
		assertEquals(testRoot, ref.getAttribute("root"));
		assertEquals(testExtension, ref.getAttribute("extension"));
	}

}
