package org.ehealth_connector.cda.ch.lab.lrph;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.xml.xpath.XPathExpressionException;

import org.ehealth_connector.cda.ch.lab.lrph.LaboratoryBatteryOrganizer;
import org.ehealth_connector.cda.ch.lab.lrph.LaboratoryIsolateOrganizer;
import org.ehealth_connector.cda.ch.lab.lrph.NotificationOrganizer;
import org.ehealth_connector.cda.ch.lab.lrph.OutbreakIdentificationObservation;
import org.ehealth_connector.cda.ch.lab.lrph.SpecimenAct;
import org.ehealth_connector.cda.ihe.lab.SpecimenCollectionEntry;
import org.ehealth_connector.cda.testhelper.TestUtils;
import org.junit.Test;
import org.w3c.dom.Document;

public class SpecimenActTest extends TestUtils {

	@Test
	public void testLrph() throws XPathExpressionException {
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

	@Test
	public void testModel() throws XPathExpressionException {
		SpecimenAct act = new SpecimenAct();
		// add
		// LabortatoryBatteryOrganizer
		act.addLaboratoryBatteryOrganizer(new LaboratoryBatteryOrganizer());

		assertTrue(act.getLaboratoryBatteryOrganizers() != null
				&& !act.getLaboratoryBatteryOrganizers().isEmpty());
		Document document = act.getDocument();
		assertTrue(xExist(document, "//entryRelationship[@typeCode='COMP']"));
		assertTrue(xExist(document, "//templateId[@root='1.3.6.1.4.1.19376.1.3.1.4']"));

		// SpecimenCollectionEntry
		SpecimenCollectionEntry entry = new SpecimenCollectionEntry();
		act.setSpecimenCollectionEntry(entry);
		assertNotNull(act.getSpecimenCollectionEntry());
		document = act.getDocument();
		xCount(document, "//entryRelationship[@typeCode='COMP']", 2);
		assertTrue(xExist(document, "//templateId[@root='1.3.6.1.4.1.19376.1.3.1.2']"));
	}
}
