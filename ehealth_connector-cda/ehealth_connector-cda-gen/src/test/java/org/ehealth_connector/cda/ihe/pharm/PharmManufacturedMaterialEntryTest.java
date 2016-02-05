/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2015
 *
 *******************************************************************************/

package org.ehealth_connector.cda.ihe.pharm;

import static org.junit.Assert.assertEquals;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.ehealth_connector.common.Code;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 * The Class PharmManufacturedMaterialEntryTest.
 */
public class PharmManufacturedMaterialEntryTest {

	private XPathFactory xpathFactory = XPathFactory.newInstance();
	private XPath xpath = xpathFactory.newXPath();

	@Test
	public void testSerializeEmpty() throws Exception {
		final PharmManufacturedMaterialEntry entry = new PharmManufacturedMaterialEntry();

		final Document document = entry.getDocument();

		XPathExpression expr = xpath
				.compile("//templateId[@root='1.3.6.1.4.1.19376.1.9.1.3.1']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
		
//		expr = xpath
//				.compile("//material[@classCode='MMAT' and @determinerCode='KIND']");
//		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
//		assertEquals(1, nodes.getLength());
		
	}

	@Test
	public void testContent() throws XPathExpressionException {

		final PharmManufacturedMaterialEntry entry = new PharmManufacturedMaterialEntry();
		String name = "BOOSTRIX Polio Inj Susp";

		Code whoAtc = new Code("2.16.840.1.113883.6.73", "J07CA02");

		entry.setName(name);
		entry.setLotNr("lotNr");
		entry.setWhoAtcCode(whoAtc);

		assertEquals(whoAtc, entry.getWhoAtcCode());
		assertEquals("BOOSTRIX Polio Inj Susp", entry.getName());
		assertEquals("lotNr",entry.getLotNr());

		Document document = entry.getDocument();
		
		XPathExpression expr = xpath
				.compile("//templateId[@root='1.3.6.1.4.1.19376.1.9.1.3.1']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
	}

//	@Test
//	public void testFormCode() throws XPathExpressionException {
//
//		final PharmManufacturedMaterialEntry entry = new PharmManufacturedMaterialEntry();
//		Code formCode = new Code("todo", "todo");
//
//		entry.setFormCode(formCode);
//		
//
//		Document document = entry.getDocument();
//		XPathExpression expr = xpath
//				.compile("//templateId[@root='1.3.6.1.4.1.19376.1.9.1.3.1']");
//		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
//		assertEquals(1, nodes.getLength());
//	}



}
