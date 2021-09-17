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

package org.ehealth_connector.cda.ihe.pharm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;

import org.ehealth_connector.common.enums.LanguageCode;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 * The Class DispenseSectionTest.
 */
public class DispenseSectionTest {

	private XPath xpath = PharmXPath.getXPath();

	@Test
	public void testReplaceDispense() throws Exception {

		final DispenseSection section = new DispenseSection(LanguageCode.ENGLISH);

		final DispenseItemEntry disEntry = new DispenseItemEntry();
		disEntry.setTextReference("#dis");
		section.setDispenseItemEntry(disEntry);

		assertEquals("#dis", section.getDispenseItemEntry().getTextReference());

		final DispenseItemEntry disEntry2 = new DispenseItemEntry();
		disEntry2.setTextReference("#dis2");
		section.setDispenseItemEntry(disEntry2);

		assertEquals("#dis2", section.getDispenseItemEntry().getTextReference());

		section.getDocument();
	}

	@Test
	public void testSerialize() throws Exception {

		final DispenseSection section = new DispenseSection(LanguageCode.ENGLISH);

		final DispenseItemEntry disEntry = new DispenseItemEntry();
		disEntry.setTextReference("#dis");
		section.setDispenseItemEntry(disEntry);

		final Document document = section.getDocument();

		// Section
		XPathExpression expr = xpath.compile("//templateId[@root='1.3.6.1.4.1.19376.1.9.1.2.3']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		assertEquals("#dis", section.getDispenseItemEntry().getTextReference());
	}

}
