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

package org.ehealth_connector.cda.ch.mtps;

import static org.junit.Assert.assertEquals;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.ehealth_connector.cda.ihe.pharm.DispenseItemEntry;
import org.ehealth_connector.cda.ihe.pharm.enums.DispenseCodeList;
import org.ehealth_connector.common.mdht.enums.LanguageCode;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 * The Class DispenseItemEntry.
 */
public class DispenseItemEntryTest {

	private final XPathFactory xpathFactory = XPathFactory.newInstance();
	private final XPath xpath = xpathFactory.newXPath();

	/**
	 * <div class="en">Test class for the Dispense Code List of the
	 * DispenseItemEntry.</div> <div class="de"></div>
	 */
	@Test
	public void testDispenseCodeList() throws Exception {

		final DispenseItemEntry entry = new DispenseItemEntry();

		entry.setDispenseCode(DispenseCodeList.REFILL_COMPLETE.getCode(LanguageCode.FRENCH));

		final Document document = entry.getDocument();

		final XPathExpression expr = xpath
				.compile("//code[@code='RFC' and @codeSystem='2.16.840.1.113883.5.4']");
		final NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
		assertEquals(DispenseCodeList.REFILL_COMPLETE,
				DispenseCodeList.getEnum(entry.getDispenseCode().getCode()));
	}

}
