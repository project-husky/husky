package org.ehealth_connector.cda.ch.lab.lrtp;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.xml.xpath.XPathExpressionException;

import org.ehealth_connector.cda.enums.NullFlavor;
import org.ehealth_connector.cda.testhelper.TestUtils;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Value;
import org.junit.Test;
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
