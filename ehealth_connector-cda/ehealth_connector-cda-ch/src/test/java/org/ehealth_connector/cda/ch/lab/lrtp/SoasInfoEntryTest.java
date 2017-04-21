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
package org.ehealth_connector.cda.ch.lab.lrtp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.xml.xpath.XPathExpressionException;

import org.ehealth_connector.cda.ch.lab.SoasInfoEntry;
import org.ehealth_connector.cda.testhelper.TestUtils;
import org.junit.Test;
import org.w3c.dom.Document;

public class SoasInfoEntryTest extends TestUtils {
	@Test
	public void testModel() throws XPathExpressionException {
		SoasInfoEntry sie = new SoasInfoEntry();

		// TemplateIds
		Document document = sie.getDocument();
		assertTrue(xExistTemplateId(document, "1.3.6.1.4.1.19376.1.3.1.6", null));
		assertTrue(
				xExistTemplateId(document, "2.16.756.5.30.1.1.1.1.3.4.1", "CDA-CH.LRTP.SOASInfo"));

		// Center specific avoid
		sie.setCenterSpecificAvoid(true);
		assertTrue(sie.isCenterSpecificAvoid());
		assertFalse(sie.isPreviousTx());
		assertEquals("001", sie.getCode().getCode());
		assertTrue(sie.getValue().getBoolean());

		// PreviousTx
		sie.setPreviousTx(false);
		assertTrue(sie.isPreviousTx());
		assertFalse(sie.isCenterSpecificAvoid());
		assertEquals("002", sie.getCode().getCode());
		assertFalse(sie.getValue().getBoolean());

		document = sie.getDocument();

	}
}
