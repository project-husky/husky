/*
 * This code is made available under the terms of the Eclipse Public License v1.0 
 * in the github project https://github.com/project-husky/husky there you also 
 * find a list of the contributors and the license information.
 * 
 * This project has been developed further and modified by the joined working group Husky 
 * on the basis of the eHealth Connector opensource project from June 28, 2021, 
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.projecthusky.xua.hl7v3.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.projecthusky.xua.hl7v3.OpenSamlInstanceIdentifier;
import org.projecthusky.xua.utilities.impl.InitializerTestHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opensaml.core.xml.io.UnmarshallingException;
import org.w3c.dom.Element;

class InstanceIdentifierUnmarshallerTest extends InitializerTestHelper {

	private Element testDomElement;

	@BeforeEach
	public void setUp() throws Exception {

		testDomElement = loadXmlDokument("/hl7v3/instance_identifier.xml");
	}

	@Test
	void testUnmarshall() throws UnmarshallingException {
		final InstanceIdentifierUnmarshaller unmarshaller = new InstanceIdentifierUnmarshaller();
		final OpenSamlInstanceIdentifier ref = unmarshaller.unmarshall(testDomElement);
		assertNotNull(ref);
		assertEquals("1.2.3.4.5.6.7.8.9", ref.getRoot());
		assertEquals("123456789", ref.getExtension());
	}

}
