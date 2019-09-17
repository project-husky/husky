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
package org.ehealth_connector.cda.ch.lab.lrtp;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.xml.xpath.XPathExpressionException;

import org.ehealth_connector.cda.testhelper.TestUtils;
import org.ehealth_connector.common.enums.LanguageCode;
import org.junit.Test;
import org.w3c.dom.Document;

public class CodedVitalSignsSectionTest extends TestUtils {
	@Test
	public void testModel() throws XPathExpressionException {
		CodedVitalSignsSection v = new CodedVitalSignsSection(LanguageCode.ENGLISH);

		Document document = v.getDocument();
		assertTrue(xExist(document, "/section/code[@code='8716-3']"));
		assertTrue(xExistTemplateId(document, "1.3.6.1.4.1.19376.1.5.3.1.1.5.3.2", null));
		assertTrue(xExistTemplateId(document, "1.3.6.1.4.1.19376.1.5.3.1.3.25", null));
		assertTrue(xExistTemplateId(document, "2.16.840.1.113883.10.20.1.16", null));

		// Convenience VitalSignsObservation
		// v.add(new VitalSignsObservation(), null);
		// assertFalse(v.getCodedVitalSignObservations().isEmpty());
		// document = v.getDocument();

		// VitalSignsOrganizer
		v.setVitalSignsOrganizer(new VitalSignsOrganizer());
		v.setVitalSignsOrganizer(new VitalSignsOrganizer());
		assertNotNull(v.getVitalSignsOrganizer());
		document = v.getDocument();
		assertTrue(xExistTemplateId(document, "1.3.6.1.4.1.19376.1.5.3.1.4.13.1", null));
	}
}
