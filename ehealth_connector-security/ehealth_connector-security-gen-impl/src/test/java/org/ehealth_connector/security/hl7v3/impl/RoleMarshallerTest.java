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
import org.junit.BeforeClass;
import org.junit.Test;
import org.opensaml.core.config.InitializationService;
import org.opensaml.core.xml.io.MarshallingException;
import org.w3c.dom.Element;

/**
 * <!-- @formatter:off -->
 * <div class="en">HEREISENGLISH</div>
 * <div class="de">HIERISTDEUTSCH</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * 
 * <!-- @formatter:on -->
 */
public class RoleMarshallerTest extends InitializerTestHelper {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// Initialize the library
		InitializationService.initialize();
	}

	private OpenSamlRole testXmlObject;
	private String testCode;
	private String testCodeSystem;
	private String testCodeSystemName;

	@Before
	public void setUp() throws Exception {
		testCode = "MyCode";
		testCodeSystem = "1.2.3.4.5.6.7.8.9.0";
		testCodeSystemName = "My Code System";

		testXmlObject = new RoleBuilder().buildObject();
		testXmlObject.setCode(testCode);
		testXmlObject.setCodeSystem(testCodeSystem);
		testXmlObject.setCodeSystemName(testCodeSystemName);
	}

	@Test
	public void testMarshallXMLObjectDocument() throws MarshallingException {
		final RoleMarshaller marshaller = new RoleMarshaller();
		final Element ref = marshaller.marshall(testXmlObject);
		assertNotNull(ref);
		logXmlObject(ref);
		assertEquals(testCode, ref.getAttribute("code"));
		assertEquals(testCodeSystem, ref.getAttribute("codeSystem"));
		assertEquals(testCodeSystemName, ref.getAttribute("codeSystemName"));
	}

}
