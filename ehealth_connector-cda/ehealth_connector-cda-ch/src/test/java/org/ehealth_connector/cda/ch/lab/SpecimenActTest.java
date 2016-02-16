package org.ehealth_connector.cda.ch.lab;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.xml.xpath.XPathExpressionException;

import org.ehealth_connector.cda.ihe.lab.SpecimenCollectionEntry;
import org.ehealth_connector.cda.testhelper.TestUtils;
import org.junit.Test;
import org.w3c.dom.Document;

public class SpecimenActTest extends TestUtils {

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
