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
package org.ehealth_connector.cda.ch.lab.lrph;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.xml.xpath.XPathExpressionException;

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
		org.ehealth_connector.cda.ch.lab.lrph.LaboratoryReportDataProcessingEntry lrdpe = new org.ehealth_connector.cda.ch.lab.lrph.LaboratoryReportDataProcessingEntry();
		lss.setLaboratoryReportDataProcessingEntry(lrdpe);
		lss.setLaboratoryReportDataProcessingEntry(
				new org.ehealth_connector.cda.ch.lab.lrph.LaboratoryReportDataProcessingEntry());
		assertNotNull(lss.getLaboratoryReportDataProcessingEntry());
		document = lss.getDocument();
		assertTrue(xExist(document, "//templateId[@root='1.3.6.1.4.1.19376.1.3.1']"));
		assertTrue(xExist(document, "//entry[@typeCode='DRIV']"));
	}
}
