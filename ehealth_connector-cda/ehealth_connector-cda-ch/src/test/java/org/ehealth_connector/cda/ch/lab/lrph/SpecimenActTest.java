package org.ehealth_connector.cda.ch.lab.lrph;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.xml.xpath.XPathExpressionException;

import org.ehealth_connector.cda.testhelper.TestUtils;
import org.junit.Test;
import org.w3c.dom.Document;

public class SpecimenActTest extends TestUtils {
	@Test
	public void testModel() throws XPathExpressionException {
		SpecimenAct act = new SpecimenAct();

		// LaboratoryIsolateOrganizer
		LaboratoryIsolateOrganizer labIsolateOrganizer = new LaboratoryIsolateOrganizer();
		act.addLaboratoryIsolateOrganizer(labIsolateOrganizer);

		assertNotNull(act.getLaboratoryIsolateOrganizers());
		assertTrue(!act.getLaboratoryIsolateOrganizers().isEmpty());
		Document document = act.getDocument();
		assertTrue(xExist(document, "//templateId[@root='1.3.6.1.4.1.19376.1.3.1.5']"));

		// NotificationOrganizer
		NotificationOrganizer notificationOrganizer = new NotificationOrganizer();
		act.setNotificationOrganizer(notificationOrganizer);

		assertNotNull(act.getNotificationOrganizer());
		document = act.getDocument();
		assertTrue(xExist(document, "//templateId[@root='1.3.6.1.4.1.19376.1.3.1.1']"));

		// OutbreakIdentification
		OutbreakIdentificationObservation oio = new OutbreakIdentificationObservation();
		act.setOutbreakIdentification(oio);

		assertNotNull(act.getOutbreakIdentification());
		document = act.getDocument();
		assertTrue(xExist(document, "//templateId[@root='1.3.6.1.4.1.19376.1.3.1.1.3']"));
	}
}
