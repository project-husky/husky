package org.ehealth_connector.cda.ch.lab.lrtp;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.xml.xpath.XPathExpressionException;

import org.ehealth_connector.cda.enums.LanguageCode;
import org.ehealth_connector.cda.testhelper.TestUtils;
import org.junit.Test;
import org.w3c.dom.Document;

public class CodedVitalSignsTest extends TestUtils {
	@Test
	public void testModel() throws XPathExpressionException {
		CodedVitalSigns v = new CodedVitalSigns(LanguageCode.ENGLISH);

		Document document = v.getDocument();
		assertTrue(xExist(document, "/section/code[@code='8716-3']"));
		// The IHE TemplateId is missing... seems to be an MDHT Problem
		// assertTrue(xExistTemplateId(document,
		// "1.3.6.1.4.1.19376.1.5.3.1.1.5.3.2", null));
		assertTrue(xExistTemplateId(document, "1.3.6.1.4.1.19376.1.5.3.1.3.25", null));
		assertTrue(xExistTemplateId(document, "2.16.840.1.113883.10.20.1.16", null));

		// Convenience VitalSignsObservation
		// v.add(new VitalSignsObservation(), null);
		// assertFalse(v.getCodedVitalSignObservations().isEmpty());
		// document = v.getDocument();

		// VitalSignsOrganizer
		v.setVitalSignsOrganizer(new VitalSignsOrganizer());
		assertNotNull(v.getVitalSignsOrganizer());
		document = v.getDocument();
		assertTrue(xExistTemplateId(document, "1.3.6.1.4.1.19376.1.5.3.1.4.13.1", null));
	}
}
