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

import org.husky.xua.hl7v3.Role;
import org.husky.xua.utilities.impl.InitializerTestHelper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
public class CodedWithEquivalentsMarshallerTest extends InitializerTestHelper {

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		// Initialize the library
		InitializationService.initialize();
	}

	private CodedWithEquivalentImpl testXmlObject;
	private String testCode;
	private String testCodeSystem;
	private String testCodeSystemName;

	@BeforeEach
	public void setUp() throws Exception {
		testCode = "MyCode";
		testCodeSystem = "1.2.3.4.5.6.7.8.9.0";
		testCodeSystemName = "My Code System";

		testXmlObject = new CodedWithEquivalentsBuilder().buildObject(Role.DEFAULT_NS_URI,
				Role.DEFAULT_ELEMENT_LOCAL_NAME,
				Role.DEFAULT_PREFIX);
		testXmlObject.setCode(testCode);
		testXmlObject.setCodeSystem(testCodeSystem);
		testXmlObject.setCodeSystemName(testCodeSystemName);
	}

	@Test
	public void testMarshallXMLObjectDocument() throws MarshallingException {
		final CodedWithEquivalentsMarshaller marshaller = new CodedWithEquivalentsMarshaller();
		final Element ref = marshaller.marshall(testXmlObject);
		assertNotNull(ref);
		logXmlObject(ref);
		assertEquals(testCode, ref.getAttribute("code"));
		assertEquals(testCodeSystem, ref.getAttribute("codeSystem"));
		assertEquals(testCodeSystemName, ref.getAttribute("codeSystemName"));
	}

}
