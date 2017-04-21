/*
 *
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;

import org.ehealth_connector.cda.testhelper.TestUtils;
import org.ehealth_connector.common.enums.StatusCode;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class LaboratoryBatteryOrganizerTest extends TestUtils {
	Document document;
	private LaboratoryBatteryOrganizer organizer;

	public LaboratoryBatteryOrganizerTest() {
		super.init();
		organizer = new LaboratoryBatteryOrganizer();
	}

	@Test
	public void testAddId() throws XPathExpressionException {
		organizer.addIdForHiv(id1);
		organizer.addIdForHiv(id2);
		assertTrue(isEqual(id1, organizer.getIdForHivList().get(0)));
		assertTrue(isEqual(id2, organizer.getIdForHivList().get(1)));
		document = organizer.getDocument();

		XPathExpression expr = xpath.compile("//id");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(2, nodes.getLength());
	}

	@Test
	public void testModel() throws XPathExpressionException {
		document = organizer.getDocument();
		assertTrue(xExist(document, "//templateId[@root='1.3.6.1.4.1.19376.1.3.1.4']"));
		assertTrue(xExist(document, "//statusCode[@code='completed']"));
		// reset status code for HIV
		organizer.setStatusCode(StatusCode.ABORTED);
		assertEquals(StatusCode.ABORTED.getCodeValue(), organizer.getStatusCode().getCodeValue());
		document = organizer.getDocument();
		assertTrue(xExist(document, "//statusCode[@code='aborted']"));

		// add Laboratory Observation
		LaboratoryObservation obs = new LaboratoryObservation();
		organizer.addLaboratoryObservation(obs);
		document = organizer.getDocument();
		assertFalse(organizer.getLaboratoryObservations().isEmpty());
		document = organizer.getDocument();
		assertTrue(xExist(document, "//templateId[@root='1.3.6.1.4.1.19376.1.3.1.6']"));
	}
}
