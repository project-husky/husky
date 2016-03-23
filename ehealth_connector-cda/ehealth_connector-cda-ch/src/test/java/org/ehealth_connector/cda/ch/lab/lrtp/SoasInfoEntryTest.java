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
