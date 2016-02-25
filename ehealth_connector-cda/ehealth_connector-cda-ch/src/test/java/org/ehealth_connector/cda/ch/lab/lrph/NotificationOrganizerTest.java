package org.ehealth_connector.cda.ch.lab.lrph;

import static org.junit.Assert.assertTrue;

import javax.xml.xpath.XPathExpressionException;

import org.ehealth_connector.cda.testhelper.TestUtils;
import org.junit.Test;
import org.w3c.dom.Document;

public class NotificationOrganizerTest extends TestUtils {
	@Test
	public void testModel() throws XPathExpressionException {
		NotificationOrganizer no = new NotificationOrganizer();

		Document document = no.getDocument();
		assertTrue(xExist(document, "//statusCode[@code='completed']"));

		// Outbreak Identification
		no.setOutbreakIdentification(new OutbreakIdentificationObservation());
		no.setOutbreakIdentification(new OutbreakIdentificationObservation());
		assertTrue(no.getOutbreakIdentificationObservation() != null);

		document = no.getDocument();
		assertTrue(xExist(document, "//templateId[@root='1.3.6.1.4.1.19376.1.3.1.1.3']"));
	}
}
