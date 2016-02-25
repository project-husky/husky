package org.ehealth_connector.cda.ch.lab;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.xml.xpath.XPathExpressionException;

import org.ehealth_connector.cda.testhelper.TestUtils;
import org.junit.Test;
import org.w3c.dom.Document;

public class StudiesSummarySectionTest extends TestUtils {
	@Test
	public void testModel() throws XPathExpressionException {
		super.init();
		StudiesSummarySection sse = new StudiesSummarySection();

		BloodGroupObservation bgo = new BloodGroupObservation();
		BloodGroupObservation bgo2 = new BloodGroupObservation();
		sse.setBloodGroup(bgo);
		sse.setBloodGroup(bgo2);
		assertNotNull(sse.getBloodGroup());
		Document document = sse.getDocument();
		assertTrue(xExistTemplateId(document, "2.16.756.5.30.1.1.1.1.3.4.1",
				"CDA-CH.LRTP.Body.StudiesSummaryL3.Bloodgroup"));
		assertTrue(xExist(document, "//code[@code='30954-2']"));
	}
}
