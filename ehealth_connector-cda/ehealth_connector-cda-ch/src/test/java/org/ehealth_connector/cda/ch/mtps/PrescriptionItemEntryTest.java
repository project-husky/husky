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

import org.ehealth_connector.cda.ch.mtps.enums.RouteOfAdministration;
import org.ehealth_connector.cda.ihe.pharm.PrescriptionItemEntry;
import org.ehealth_connector.common.enums.LanguageCode;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 * The Class PrescriptionItemEntry.
 */
public class PrescriptionItemEntryTest {

	private XPathFactory xpathFactory = XPathFactory.newInstance();
	private XPath xpath = xpathFactory.newXPath();

	@Test
	public void testMedicationsSpecialConditions() throws Exception {

		final PrescriptionItemEntry entry = new PrescriptionItemEntry();

		entry.setRouteOfAdministration(
				RouteOfAdministration.CHEW_ORAL.getCode(LanguageCode.FRENCH));

		final Document document = entry.getDocument();

		XPathExpression expr = xpath
				.compile("//routeCode[@code='CHEW' and @codeSystem='2.16.840.1.113883.5.112']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
		assertEquals(RouteOfAdministration.CHEW_ORAL,
				RouteOfAdministration.getEnum(entry.getRouteOfAdministration().getCode()));
	}

}
