package org.ehealth_connector.cda.ihe.lab;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.xml.xpath.XPathExpressionException;

import org.ehealth_connector.cda.testhelper.TestUtils;
import org.junit.Test;
import org.w3c.dom.Document;

public class SpecimenReceivedEntryTest extends TestUtils {
	@Test
	public void testModelAndEffectiveTime() throws XPathExpressionException {
		super.init();
		SpecimenReceivedEntry sre = new SpecimenReceivedEntry();

		sre.setEffectiveTime(endDate);
		assertEquals(endDate, sre.getEffectiveTime());

		Document document = sre.getDocument();
		assertTrue(xExist(document, "//code[@code='SPRECEIVE']"));
	}
}
