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
package org.ehealth_connector.xua.hl7v3.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.ehealth_connector.xua.hl7v3.OpenSamlPurposeOfUse;
import org.ehealth_connector.xua.utilities.impl.InitializerTestHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opensaml.core.xml.io.UnmarshallingException;
import org.w3c.dom.Element;

public class PurposeOfUseUnmarshallerTest extends InitializerTestHelper {

	private Element testDomElement;

	@BeforeEach
	public void setUp() throws Exception {

		testDomElement = loadXmlDokument("/hl7v3/purose_of_use.xml");
	}

	@Test
	public void testUnmarshall() throws UnmarshallingException {
		final PurposeOfUseUnmarshaller unmarshaller = new PurposeOfUseUnmarshaller();
		final OpenSamlPurposeOfUse ref = unmarshaller.unmarshall(testDomElement);
		assertNotNull(ref);
		assertEquals("NORM", ref.getCode());
		assertEquals("2.16.756.5.30.1.127.3.10.5", ref.getCodeSystem());
		assertEquals("eHealth Suisse Verwendungszweck", ref.getCodeSystemName());
		assertEquals("CE", ref.getSchemaType().getLocalPart());
	}

}
