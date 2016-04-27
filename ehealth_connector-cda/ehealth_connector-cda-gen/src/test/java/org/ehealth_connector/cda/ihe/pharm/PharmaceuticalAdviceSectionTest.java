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

import org.ehealth_connector.common.enums.LanguageCode;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 * The Class PharmaceuticalAdviceSectionTest.
 */
public class PharmaceuticalAdviceSectionTest {

	private XPath xpath = PharmXPath.getXPath();

	@Test
	public void testReplaceDispense() throws Exception {

		final PharmaceuticalAdviceSection section = new PharmaceuticalAdviceSection(
				LanguageCode.ENGLISH);

		final PharmaceuticalAdviceItemEntry padvEntry = new PharmaceuticalAdviceItemEntry();
		padvEntry.setTextReference("#padv");
		section.setPharmaceuticalAdviceItemEntry(padvEntry);

		assertEquals("#padv", section.getPharmaceuticalAdviceItemEntry().getTextReference());

		final PharmaceuticalAdviceItemEntry padvEntry2 = new PharmaceuticalAdviceItemEntry();
		padvEntry2.setTextReference("#padv2");
		section.setPharmaceuticalAdviceItemEntry(padvEntry2);

		assertEquals("#padv2", section.getPharmaceuticalAdviceItemEntry().getTextReference());

		section.getDocument();
	}

	@Test
	public void testSerialize() throws Exception {

		final PharmaceuticalAdviceSection section = new PharmaceuticalAdviceSection(
				LanguageCode.ENGLISH);

		final PharmaceuticalAdviceItemEntry padvEntry = new PharmaceuticalAdviceItemEntry();
		padvEntry.setTextReference("#padv");
		section.setPharmaceuticalAdviceItemEntry(padvEntry);

		final Document document = section.getDocument();

		// Section
		XPathExpression expr = xpath.compile("//templateId[@root='1.3.6.1.4.1.19376.1.9.1.2.2']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		assertEquals("#padv", section.getPharmaceuticalAdviceItemEntry().getTextReference());
	}

}
