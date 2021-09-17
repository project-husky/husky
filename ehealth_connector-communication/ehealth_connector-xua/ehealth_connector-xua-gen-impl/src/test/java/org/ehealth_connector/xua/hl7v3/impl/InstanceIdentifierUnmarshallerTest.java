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

import org.ehealth_connector.xua.hl7v3.OpenSamlInstanceIdentifier;
import org.ehealth_connector.xua.utilities.impl.InitializerTestHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opensaml.core.xml.io.UnmarshallingException;
import org.w3c.dom.Element;

public class InstanceIdentifierUnmarshallerTest extends InitializerTestHelper {

	private Element testDomElement;

	@BeforeEach
	public void setUp() throws Exception {

		testDomElement = loadXmlDokument("/hl7v3/instance_identifier.xml");
	}

	@Test
	public void testUnmarshall() throws UnmarshallingException {
		final InstanceIdentifierUnmarshaller unmarshaller = new InstanceIdentifierUnmarshaller();
		final OpenSamlInstanceIdentifier ref = unmarshaller.unmarshall(testDomElement);
		assertNotNull(ref);
		assertEquals("1.2.3.4.5.6.7.8.9", ref.getRoot());
		assertEquals("123456789", ref.getExtension());
	}

}
