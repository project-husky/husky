package org.ehealth_connector.cda.ch.lab;

import static org.junit.Assert.assertTrue;

import javax.xml.xpath.XPathExpressionException;

import org.ehealth_connector.cda.testhelper.TestUtils;
import org.junit.Test;
import org.w3c.dom.Document;

public class SpecimenCollectionEntryTest extends TestUtils {
	@Test
	public void testModel() throws XPathExpressionException {
		super.init();
		// Constructor with effectiveTime and id unknown
		SpecimenCollectionEntry sce = new SpecimenCollectionEntry(id1, "testRef");

		Document document = sce.getDocument();

		assertTrue(xExist(document, "//effectiveTime[@nullFlavor='UNK']"));
		assertTrue(xExist(document, "//participant/participantRole/id[@nullFlavor='NA']"));
	}
}
