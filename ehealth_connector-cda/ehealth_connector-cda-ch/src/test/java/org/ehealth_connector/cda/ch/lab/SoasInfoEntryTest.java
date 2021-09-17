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
package org.ehealth_connector.cda.ch.lab;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.xml.xpath.XPathExpressionException;

import org.ehealth_connector.cda.testhelper.TestUtils;
import org.ehealth_connector.common.enums.NullFlavor;
import org.ehealth_connector.common.mdht.Code;
import org.ehealth_connector.common.mdht.Value;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;

public class SoasInfoEntryTest extends TestUtils {
	@Test
	public void modelTest() throws XPathExpressionException {
		SoasInfoEntry s = new SoasInfoEntry();

		Document document = s.getDocument();
		assertTrue(xExist(document,
				"//templateId[@root='2.16.756.5.30.1.1.1.1.3.4.1' and @extension='CDA-CH.LRTP.SOASInfo']"));

		// code
		Code csa = new Code("2.16.756.5.30.1.129.1.1.2", "001");
		s.setCode(csa);
		assertTrue(csa.equals(s.getCode()));
		assertTrue(s.isCenterSpecificAvoid());
		assertFalse(s.isPreviousTx());

		// value
		Value v = new Value(true);
		s.setValue(v);
		assertTrue(s.getValue().isBl());

		// Convenience setCenterSpecifiAvoid
		s.setCenterSpecificAvoid(false);
		assertTrue(s.isCenterSpecificAvoid());
		document = s.getDocument();
		assertTrue(xExist(document, "/observation/value[@type='BL' and @value='false']"));

		// Convenience setPreviousTx
		s.setPreviousTx(true);
		assertFalse(s.isCenterSpecificAvoid());
		assertTrue(s.isPreviousTx());
		document = s.getDocument();
		assertTrue(xExist(document, "/observation/value[@type='BL' and @value='true']"));

		s.setPreviousTx(NullFlavor.NOINFORMATION);
		document = s.getDocument();
		assertTrue(xExist(document, "/observation/value[@type='BL' and @nullFlavor='NI']"));
	}
}
