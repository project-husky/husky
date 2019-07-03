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
package org.ehealth_connector.security.hl7v3.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.ehealth_connector.security.hl7v3.OpenSamlRole;
import org.ehealth_connector.security.utilities.impl.InitializerTestHelper;
import org.junit.Before;
import org.junit.Test;
import org.opensaml.core.xml.io.UnmarshallingException;
import org.w3c.dom.Element;

public class RoleUnmarshallerTest extends InitializerTestHelper {

	private Element testDomElement;

	@Before
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
