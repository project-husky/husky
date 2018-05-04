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
package org.ehealth_connector.communication.ch.epr.policyadmin.impl;

import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.ehealth_connector.communication.ch.epr.policyadmin.AssertionBasedRequest;
import org.ehealth_connector.security.utilities.impl.InitializerTestHelper;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.opensaml.core.xml.XMLObject;
import org.opensaml.core.xml.config.XMLObjectProviderRegistrySupport;
import org.opensaml.core.xml.io.Unmarshaller;
import org.opensaml.core.xml.io.UnmarshallerFactory;
import org.opensaml.core.xml.io.UnmarshallingException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

@Ignore
public class AssertionBasedRequestUnmarshallerTest extends InitializerTestHelper {

	private Element testXmlElementAddPol;
	private Element testXmlElementUpdPol;
	private Element testXmlElementDelPol;

	@Before
	public void setUp() throws Exception {
		testXmlElementAddPol = getAssertionAsElement(
				Files.readAllBytes(Paths.get(getClass().getResource("/ch-ppq/add_policy_request.xml").toURI())));
		testXmlElementUpdPol = getAssertionAsElement(
				Files.readAllBytes(Paths.get(getClass().getResource("/ch-ppq/update_policy_request.xml").toURI())));
		testXmlElementDelPol = getAssertionAsElement(
				Files.readAllBytes(Paths.get(getClass().getResource("/ch-ppq/delete_policy_request.xml").toURI())));
	}

	/**
	 * Test method for {@link org.opensaml.core.xml.io.AbstractXMLObjectUnmarshaller#unmarshall(org.w3c.dom.Element)}.
	 * 
	 * @throws UnmarshallingException
	 */
	@Test
	public void testUnmarshallAddpolicy() throws UnmarshallingException {
		final UnmarshallerFactory unmarshallerFactory = XMLObjectProviderRegistrySupport.getUnmarshallerFactory();
		final Unmarshaller unmarshaller = unmarshallerFactory.getUnmarshaller(testXmlElementAddPol);
		final XMLObject xmlObject = unmarshaller.unmarshall(testXmlElementAddPol);
		assertNotNull(xmlObject);
		final AssertionBasedRequest request = (AssertionBasedRequest) xmlObject;

	}

	/**
	 * Test method for {@link org.opensaml.core.xml.io.AbstractXMLObjectUnmarshaller#unmarshall(org.w3c.dom.Element)}.
	 * 
	 * @throws UnmarshallingException
	 */
	@Test
	public void testUnmarshallUpdatepolicy() throws UnmarshallingException {
		final AssertionBasedRequestUnmarshaller unmarshaller = new AssertionBasedRequestUnmarshaller();
		final XMLObject xmlObject = unmarshaller.unmarshall(testXmlElementUpdPol);
		assertNotNull(xmlObject);
		final AssertionBasedRequest request = (AssertionBasedRequest) xmlObject;

	}

	/**
	 * Test method for {@link org.opensaml.core.xml.io.AbstractXMLObjectUnmarshaller#unmarshall(org.w3c.dom.Element)}.
	 * 
	 * @throws UnmarshallingException
	 */
	@Test
	public void testUnmarshallDeletepolicy() throws UnmarshallingException {
		final AssertionBasedRequestUnmarshaller unmarshaller = new AssertionBasedRequestUnmarshaller();
		final XMLObject xmlObject = unmarshaller.unmarshall(testXmlElementDelPol);
		assertNotNull(xmlObject);
		final AssertionBasedRequest request = (AssertionBasedRequest) xmlObject;

	}

	private Element getAssertionAsElement(byte[] readAllBytes)
			throws SAXException, IOException, ParserConfigurationException {
		final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
		final Document doc = dbf.newDocumentBuilder().parse(new ByteArrayInputStream(readAllBytes));
		return doc.getDocumentElement();
	}

}
