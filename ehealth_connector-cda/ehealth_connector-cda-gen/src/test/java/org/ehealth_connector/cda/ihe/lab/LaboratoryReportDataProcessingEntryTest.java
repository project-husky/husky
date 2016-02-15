package org.ehealth_connector.cda.ihe.lab;

import static org.junit.Assert.assertTrue;

import javax.xml.xpath.XPathExpressionException;

import org.ehealth_connector.cda.testhelper.TestUtils;
import org.junit.Test;
import org.w3c.dom.Document;

public class LaboratoryReportDataProcessingEntryTest extends TestUtils {

	@Test
	public void testModel() throws XPathExpressionException {
		LaboratoryReportDataProcessingEntry entry = new LaboratoryReportDataProcessingEntry();
		Document document = entry.getDocument();
		assertTrue(xExist(document, "//templateId[@root='1.3.6.1.4.1.19376.1.3.1']"));

		// set SpecimenAct
		SpecimenAct act = new SpecimenAct();
		entry.setSpecimenAct(act);
		assertTrue(entry.getSpecimenAct() != null);

		document = entry.getDocument();
		assertTrue(xExist(document, "//act[@classCode='ACT' and @moodCode='EVN']"));
	}
}
