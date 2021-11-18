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
package org.husky.xua.hl7v3.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.husky.xua.hl7v3.OpenSamlRole;
import org.husky.xua.hl7v3.impl.RoleUnmarshaller;
import org.husky.xua.utilities.impl.InitializerTestHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opensaml.core.xml.io.UnmarshallingException;
import org.w3c.dom.Element;

public class RoleUnmarshallerTest extends InitializerTestHelper {

	private Element testDomElement;

	@BeforeEach
	public void setUp() throws Exception {

		testDomElement = loadXmlDokument("/hl7v3/role.xml");
	}

	@Test
	public void testUnmarshall() throws UnmarshallingException {
		final RoleUnmarshaller unmarshaller = new RoleUnmarshaller();
		final OpenSamlRole ref = unmarshaller.unmarshall(testDomElement);
		assertNotNull(ref);
		assertEquals("HCP", ref.getCode());
		assertEquals("2.16.756.5.30.1.127.3.10.6", ref.getCodeSystem());
		assertEquals("eHealth Suisse EPR Akteure", ref.getCodeSystemName());
		assertEquals("CE", ref.getSchemaType().getLocalPart());
	}

}
