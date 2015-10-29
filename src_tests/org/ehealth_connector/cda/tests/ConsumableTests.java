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

package org.ehealth_connector.cda.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.ehealth_connector.cda.ch.Consumable;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Organization;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 * The Class ConsumableTests.
 */
public class ConsumableTests {

	private XPathFactory xpathFactory = XPathFactory.newInstance();
	private XPath xpath = xpathFactory.newXPath();

	@Test
	public void testSerializeEmpty() throws Exception {
		Consumable consumable = new Consumable(false);

		Document document = consumable.getDocument();

		XPathExpression expr = xpath
				.compile("//templateId[@root='1.3.6.1.4.1.19376.1.5.3.1.4.7.2']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile("//templateId[@root='2.16.840.1.113883.10.20.1.53']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
	}

	// <consumable typeCode='CSM'>
	// <manufacturedProduct>
	// <templateId root='1.3.6.1.4.1.19376.1.5.3.1.4.7.2'/>
	// <templateId root='2.16.840.1.113883.10.20.1.53'/> <id root='1.3.160'
	// extension='7680006370012' />
	// <manufacturedMaterial>
	// <code code='J07CA02' codeSystem='2.16.840.1.113883.6.73' > <originalText>
	// diphtheria-pertussis-poliomyelitis-tetanus
	// <reference value='#ii1'/>
	// </originalText>
	// </code>
	// <name>BOOSTRIX Polio Inj Susp</name> </manufacturedMaterial>
	// <manufacturerOrganization>
	// <name>GlaxoSmithKline AG</name> </manufacturerOrganization>
	// </manufacturedProduct>
	// </consumable>
	@Test
	public void testConsumable() throws XPathExpressionException {
		Consumable consumable = new Consumable("BOOSTRIX Polio Inj Susp");

		Code whoAtc = new Code("2.16.840.1.113883.6.73", "J07CA02");

		Organization organization = new Organization("GlaxoSmithKline");
		consumable.setManufacturer(organization);
		Identificator gtin = new Identificator("1.3.160", "7680006370012");
		consumable.setManufacturedProductId(gtin);
		consumable.setLotNr("lotNr");
		consumable.setWhoAtcCode(whoAtc);

		assertEquals(whoAtc, consumable.getWhoAtcCode());
		assertEquals(gtin, consumable.getManufacturedProductId());
		assertEquals("BOOSTRIX Polio Inj Susp", consumable.getTradeName());

		Document document = consumable.getDocument();

		XPathExpression expr = xpath.compile(
				"consumable/manufacturedProduct/templateId[@root='1.3.6.1.4.1.19376.1.5.3.1.4.7.2']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile(
				"consumable/manufacturedProduct/id[@root='1.3.160' and @extension='7680006370012']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile(
				"consumable/manufacturedProduct/manufacturedMaterial/name='BOOSTRIX Polio Inj Susp'");
		assertTrue((Boolean) expr.evaluate(document, XPathConstants.BOOLEAN));
	}

}
