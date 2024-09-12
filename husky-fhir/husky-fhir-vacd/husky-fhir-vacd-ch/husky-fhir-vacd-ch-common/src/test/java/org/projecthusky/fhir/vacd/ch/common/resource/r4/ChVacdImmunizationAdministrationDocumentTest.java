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
package org.projecthusky.fhir.vacd.ch.common.resource.r4;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.UUID;

import org.hl7.fhir.instance.model.api.IBaseResource;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Reference;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.projecthusky.fhir.vacd.ch.common.TestHelper;
import org.slf4j.LoggerFactory;

import ca.uhn.fhir.context.FhirContext;
/**	
 * 
 */
class ChVacdImmunizationAdministrationDocumentTest extends TestHelper {

	private Patient testPatient;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		testPatient = new Patient();
		testPatient.setId("testPatient");
		testPatient.addName().setFamily("Test").addGiven("Patient");
	}
	@Test
	void testResolveComposion() {
		ChVacdImmunizationAdministrationDocument doc = new ChVacdImmunizationAdministrationDocument();
		ChVacdImmunizationAdministrationComposition ref = doc.resolveComposition();
		assertNotNull(ref);
		
		
		prettyPrint(doc);
	}
	
	@Test
	void testAddImmunization() {
		ChVacdImmunizationAdministrationDocument doc = new ChVacdImmunizationAdministrationDocument();
		ChVacdImmunization imm = new ChVacdImmunization();
		imm.setId(UUID.randomUUID().toString());
		imm.setRecorder(new Reference(testPatient));
		
		doc.addImmunization(imm);
		
		prettyPrint(doc);
	}
	
	
	@Test
	void testResolveImmunizations() {
		ChVacdImmunizationAdministrationDocument doc = new ChVacdImmunizationAdministrationDocument();
		
		doc.setPatient(testPatient);
		
		ChVacdImmunization imm1 = new ChVacdImmunization();
		imm1.setId(UUID.randomUUID().toString());
		imm1.setRecorder(new Reference(testPatient));
		doc.addImmunization(imm1);
		
		ChVacdImmunization imm2 = new ChVacdImmunization();
		imm2.setId(UUID.randomUUID().toString());
		imm2.setRecorder(new Reference(testPatient));
		doc.addImmunization(imm2);
		
		prettyPrint(doc);
		
		List<ChVacdImmunization> ref = doc.resolveImmunizations();
		assertNotNull(ref);
		assertTrue(ref.size() == 2);
		
		
	}
	
	
	@Test
	void testSerialize() {
		ChVacdImmunizationAdministrationDocument ref = new ChVacdImmunizationAdministrationDocument();

		prettyPrint(ref);
	}

}
