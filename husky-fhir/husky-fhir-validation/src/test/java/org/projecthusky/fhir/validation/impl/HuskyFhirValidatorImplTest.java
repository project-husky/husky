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
package org.projecthusky.fhir.validation.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hl7.fhir.r4.model.Bundle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.projecthusky.fhir.validation.HuskyFhirValidator;
import org.projecthusky.fhir.validation.model.ValidationResult;

import ca.uhn.fhir.context.FhirContext;

/**
 * 
 */
class HuskyFhirValidatorImplTest {
	private HuskyFhirValidator validator;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		List<String> resourceList = List.of(
	            "/packages/ch.fhir.ig.ch-term#3.4.0.tgz",
	            "/packages/ch.fhir.ig.ch-core#7.0.0-ballot.tgz");
		validator = new HuskyFhirValidatorImpl(FhirContext.forR4(), resourceList, null);
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.fhir.validation.impl.HuskyFhirValidatorImpl#validateDocumentBundle(org.hl7.fhir.r4.model.Bundle, java.lang.String)}.
	 * 
	 * @throws IOException
	 */
	@Test
	void testValidateDocumentBundle1() throws IOException {
		Bundle bundle = new Bundle();
		ValidationResult ref = validator.validateDocumentBundle(bundle,
				"http://hl7.org/fhir/StructureDefinition/Bundle");
		assertNotNull(ref);
		assertNotNull(ref.getIssues());
		assertEquals(5, ref.getIssues().size());
		assertEquals(5, ref.getErrors().size());
		assertEquals(0, ref.getWarnings().size());
		assertEquals(0, ref.getFatals().size());
		assertEquals(0, ref.getInformations().size());
	}

	@Test
	void testValidateDocumentBundle2() throws IOException {
		Bundle bundle = new Bundle();
		bundle.setType(Bundle.BundleType.TRANSACTION);
		bundle.setTimestamp(new Date());
		ValidationResult ref = validator.validateDocumentBundle(bundle,
				"http://hl7.org/fhir/StructureDefinition/Bundle");
		assertNotNull(ref);
		assertNotNull(ref.getIssues());
		assertEquals(1, ref.getIssues().size());
		assertEquals(0, ref.getErrors().size());
		assertEquals(0, ref.getWarnings().size());
		assertEquals(0, ref.getFatals().size());
		assertEquals(1, ref.getInformations().size());
	}
	
	@Test
	void testValidateDocumentBundle3() throws IOException {
		InputStream is = this.getClass().getResourceAsStream("/examples/Bundle-1-ZuweisungZurRadiologischenDiagnostik-FHIR.json");
		Bundle bundle = FhirContext.forR4().newJsonParser().parseResource(Bundle.class, is);
		ValidationResult ref = validator.validateDocumentBundle(bundle,"http://fhir.ch/ig/ch-core/StructureDefinition/ch-core-document-epr");
		assertNotNull(ref);
		assertNotNull(ref.getIssues());
		assertEquals(125, ref.getIssues().size());
		assertEquals(4, ref.getErrors().size());
		assertEquals(6, ref.getWarnings().size());
		assertEquals(0, ref.getFatals().size());
		assertEquals(115, ref.getInformations().size());
		
	}

}
