package org.ehealth_connector.cda.ch.lab.lrph;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.xml.xpath.XPathExpressionException;

import org.ehealth_connector.cda.ihe.lab.LaboratorySpecialtySection;
import org.ehealth_connector.cda.testhelper.TestUtils;
import org.junit.Test;
import org.w3c.dom.Document;

public class LaboratorySpecialtySectionTest extends TestUtils {
	@Test
	public void testModel() throws XPathExpressionException {
		super.init();
		LaboratorySpecialtySection lss = new LaboratorySpecialtySection();

		Document document = lss.getDocument();
		assertTrue(xExist(document, "//templateId[@root='1.3.6.1.4.1.19376.1.3.3.2.1']"));

		lss.setCode(code1);
		assertTrue(code1.equals(lss.getCode()));

		// LaboratoryReportDataProcessingEntry
		org.ehealth_connector.cda.ihe.lab.LaboratoryReportDataProcessingEntry lrdpe = new org.ehealth_connector.cda.ihe.lab.LaboratoryReportDataProcessingEntry();
		lss.setLaboratoryReportDataProcessingEntry(lrdpe);
		assertNotNull(lss.getLaboratoryReportDataProcessingEntry());
		document = lss.getDocument();
		assertTrue(xExist(document, "//templateId[@root='1.3.6.1.4.1.19376.1.3.1']"));
		assertTrue(xExist(document, "//entry[@typeCode='DRIV']"));

	}
}
