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

import org.ehealth_connector.common.Identificator;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 * The Class PrescriptionItemReferenceEntry.
 */
public class PrescriptionItemReferenceEntryTest {

	private XPath xpath = PharmXPath.getXPath();

	@Test
	public void testIdentifier() throws Exception {

		final PrescriptionItemReferenceEntry entry = new PrescriptionItemReferenceEntry();

		entry.setId(new Identificator("oid", "id"));
		final Document document = entry.getDocument();

		XPathExpression expr = xpath.compile("//id[@root='oid' and @extension='id']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
	}

	@Test
	public void testSerializeEmpty() throws Exception {
		final PrescriptionItemReferenceEntry entry = new PrescriptionItemReferenceEntry();

		final Document document = entry.getDocument();

		XPathExpression expr = xpath
				.compile("//templateId[@root='1.3.6.1.4.1.19376.1.9.1.3.11']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile(
				"//code[@code='PREItem' and @codeSystem='1.3.6.1.4.1.19376.1.9.2.2' and @codeSystemName='IHE Pharmacy Item Type List']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath
				.compile("//consumable/manufacturedProduct/manufacturedMaterial[@nullFlavor='NA']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
	}

}
