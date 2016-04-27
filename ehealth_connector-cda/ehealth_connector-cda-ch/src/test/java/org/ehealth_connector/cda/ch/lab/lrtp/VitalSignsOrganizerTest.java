package org.ehealth_connector.cda.ch.lab.lrtp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.xml.xpath.XPathExpressionException;

import org.ehealth_connector.cda.testhelper.TestUtils;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.Name;
import org.junit.Test;
import org.w3c.dom.Document;

public class VitalSignsOrganizerTest extends TestUtils {
	@Test
	public void testModel() throws XPathExpressionException {
		super.init();
		VitalSignsOrganizer o = new VitalSignsOrganizer();

		Document document = o.getDocument();
		assertTrue(xExistTemplateId(document, "1.3.6.1.4.1.19376.1.5.3.1.4.13.1", null));
		assertTrue(xExistTemplateId(document, "2.16.840.1.113883.10.20.1.32", null));
		assertTrue(xExistTemplateId(document, "2.16.840.1.113883.10.20.1.35", null));
		assertTrue(xExist(document, "/organizer/statusCode[@code='completed']"));
		assertTrue(xExist(document, "//code[@code='46680005']"));

		// Vital Signs Observation
		o.addVitalSignObservation(new VitalSignObservation());
		assertFalse(o.getVitalSignObservations().isEmpty());
		document = o.getDocument();
		assertTrue(xExistTemplateId(document, "2.16.756.5.30.1.1.1.1.3.4.1",
				"CDA-CH-LRTP.Body.VitalSignL3"));
		assertTrue(xExist(document, "/organizer/component[@typeCode='COMP']"));
		assertTrue(xExistTemplateId(document, "1.3.6.1.4.1.19376.1.5.3.1.4.13.2", null));

		// Effective Time
		o.setEffectiveTime(super.endDate);
		assertEquals(endDate, o.getEffectiveTime());

		// Author
		o.addAuthor(new Author(new Name("Axel", "Helmer")));
		assertFalse(o.getAuthors().isEmpty());
		assertEquals("Axel", o.getAuthors().get(0).getName().getGivenNames());
		document = o.getDocument();
		assertTrue(xExist(document, "//author[@typeCode='AUT']"));
	}
}
