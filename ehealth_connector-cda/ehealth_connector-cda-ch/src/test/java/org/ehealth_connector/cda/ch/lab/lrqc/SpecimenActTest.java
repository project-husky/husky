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
package org.ehealth_connector.cda.ch.lab.lrqc;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.xml.xpath.XPathExpressionException;

import org.ehealth_connector.cda.ch.lab.BaseChSpecimenAct;
import org.ehealth_connector.cda.ihe.lab.NonHumanSubject;
import org.ehealth_connector.cda.testhelper.TestUtils;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;

public class SpecimenActTest extends TestUtils {

	@Test
	public void testModel() throws XPathExpressionException {
		NonHumanSubject nhs = new NonHumanSubject();
		BaseChSpecimenAct spa = new BaseChSpecimenAct();

		spa.setNonHumanSubject(nhs);
		assertNotNull(spa.getNonHumanSubject());
		Document document = spa.getDocument();

		xExistTemplateId(document, "1.3.6.1.4.1.19376.1.3.3.1.2.1", null);

	}

}
