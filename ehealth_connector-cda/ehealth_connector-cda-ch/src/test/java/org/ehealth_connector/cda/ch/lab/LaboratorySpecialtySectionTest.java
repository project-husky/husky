package org.ehealth_connector.cda.ch.lab;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.xml.xpath.XPathExpressionException;

import org.ehealth_connector.cda.ihe.lab.LaboratoryReportDataProcessingEntry;
import org.ehealth_connector.cda.ihe.lab.LaboratorySpecialtySection;
import org.ehealth_connector.cda.testhelper.TestUtils;
import org.junit.Test;
import org.w3c.dom.Document;

public class LaboratorySpecialtySectionTest extends TestUtils {
	@Test
	public void testModel() throws XPathExpressionException {
		LaboratorySpecialtySection l = new LaboratorySpecialtySection();

		Document document = l.getDocument();
		assertTrue(xExistTemplateId(document, "1.3.6.1.4.1.19376.1.3.3.2.1", null));

		// Laboratory Report Data Processing Entry
		l.setLaboratoryReportDataProcessingEntry(new LaboratoryReportDataProcessingEntry());
		assertNotNull(l.getLaboratoryReportDataProcessingEntry());
	}
}
