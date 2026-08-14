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

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Reference;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.projecthusky.fhir.core.ch.resource.r4.ChCoreOrganizationEpr;
import org.projecthusky.fhir.core.ch.resource.r4.ChCorePractitionerEpr;
import org.projecthusky.fhir.core.ch.resource.r4.ChCorePractitionerRoleEpr;
import org.projecthusky.fhir.core.ch.util.IdUtil;
import org.projecthusky.fhir.vacd.ch.common.TestHelper;

/**	
 * 
 */
class ChVacdImmunizationAdministrationDocumentTest extends TestHelper {

	private Patient testPatient;

	private ChCorePractitionerRoleEpr testAuthor;

	private ChVacdMedicationForImmunization testMedication;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		testPatient = new Patient();
		testPatient.setId(IdUtil.generateUrnUuid());
		testPatient.addName().setFamily("Test").addGiven("Patient");

		testAuthor = new ChCorePractitionerRoleEpr();
		testAuthor.setId(UUID.randomUUID().toString());
		ChCorePractitionerEpr practitioner = new ChCorePractitionerEpr();
		practitioner.setId(UUID.randomUUID().toString());
		testAuthor.setPractitioner(new Reference(practitioner));
		ChCoreOrganizationEpr organization = new ChCoreOrganizationEpr();
		organization.setId(UUID.randomUUID().toString());
		testAuthor.setOrganization(new Reference(organization));

		testMedication = new ChVacdMedicationForImmunization();
		testMedication.setId(UUID.randomUUID().toString());
	}

	@Test
	void testResolveComposion() {
		ChVacdImmunizationAdministrationDocument doc = new ChVacdImmunizationAdministrationDocument();
		ChVacdImmunizationAdministrationComposition ref = doc.resolveComposition();
		assertNotNull(ref);

		assertTrue(doc.getEntryFirstRep() != null && //
				doc.getEntryFirstRep()
						.getResource() instanceof ChVacdImmunizationAdministrationComposition);

		prettyPrint(doc);
	}

	@Test
	void testAddImmunization() {
		ChVacdImmunizationAdministrationDocument doc = new ChVacdImmunizationAdministrationDocument();
		doc.setPatient(testPatient);
		doc.addAuthor(testAuthor, new Date());
		ChVacdImmunization imm = doc.addImmunization();
		imm.setRecorder(new Reference(testAuthor));
		imm.setMedication(doc.addMedication());

		assertTrue(doc.getEntryFirstRep() != null && //
				doc.getEntryFirstRep()
						.getResource() instanceof ChVacdImmunizationAdministrationComposition);

		prettyPrint(doc);
	}

	@Test
	void testBundle() {
		// Create a Patient
		Patient patient = new Patient();
		// patient.setId("Patient-01");
		patient.setId("urn:uuid:" + UUID.randomUUID().toString());
		patient.addName().setFamily("Smith").addGiven("John");

		// Create an Observation and reference the Patient
		Observation observation = new Observation();
		observation.setId("Observation-01");
		observation.setSubject(new Reference(patient));

		// Serialize Bundle or individual resource containing the reference
		Bundle bundle = new Bundle();
		bundle.setType(Bundle.BundleType.DOCUMENT);
		bundle.addEntry().setResource(patient).setFullUrl(patient.getIdElement().getIdPart());
		bundle.addEntry().setResource(observation);

		prettyPrint(bundle);

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

		assertTrue(doc.getEntryFirstRep() != null && //
				doc.getEntryFirstRep()
						.getResource() instanceof ChVacdImmunizationAdministrationComposition);

	}

	@Test
	void testSerialize() {
		ChVacdImmunizationAdministrationDocument doc = new ChVacdImmunizationAdministrationDocument();
		doc.setPatient(testPatient);
		prettyPrint(doc);

		assertTrue(doc.getEntryFirstRep() != null && //
				doc.getEntryFirstRep()
						.getResource() instanceof ChVacdImmunizationAdministrationComposition);
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.fhir.vacd.ch.common.resource.r4.ChVacdAbstractDocument#addBasicImmunization()}.
	 */
	@Test
	void testAddResolveBasicImmunization() {
		ChVacdImmunizationAdministrationDocument doc = new ChVacdImmunizationAdministrationDocument();
		doc.setPatient(testPatient);
		ChVacdBasicImmunization ref = doc.addBasicImmunization();

		assertNotNull(ref);
		assertNotNull(doc.resolveBasicImmunizations());

		assertTrue(doc.getEntryFirstRep() != null && //
				doc.getEntryFirstRep()
						.getResource() instanceof ChVacdImmunizationAdministrationComposition);
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.fhir.vacd.ch.common.resource.r4.ChVacdAbstractDocument#addMedicalProblem()}.
	 */
	@Test
	void testAddResolveMedicalProblem() {
		ChVacdImmunizationAdministrationDocument doc = new ChVacdImmunizationAdministrationDocument();
		doc.setPatient(testPatient);
		ChVacdMedicalProblem ref = doc.addMedicalProblem();

		assertNotNull(ref);
		assertNotNull(doc.resolveMedicalProblems());

		assertTrue(doc.getEntryFirstRep() != null && //
				doc.getEntryFirstRep()
						.getResource() instanceof ChVacdImmunizationAdministrationComposition);
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.fhir.vacd.ch.common.resource.r4.ChVacdAbstractDocument#addLaboratoryAndSerology()}.
	 */
	@Test
	void testAddResolveLaboratoryAndSerology() {
		ChVacdImmunizationAdministrationDocument doc = new ChVacdImmunizationAdministrationDocument();
		doc.setPatient(testPatient);
		ChVacdLaboratoryAndSerology ref = doc.addLaboratoryAndSerology();

		assertNotNull(ref);
		assertNotNull(doc.resolveLaboratoryAndSerologies());

		assertTrue(doc.getEntryFirstRep() != null && //
				doc.getEntryFirstRep()
						.getResource() instanceof ChVacdImmunizationAdministrationComposition);
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.fhir.vacd.ch.common.resource.r4.ChVacdAbstractDocument#addAllergyIntolerance()}.
	 */
	@Test
	void testAddResolveAllergyIntolerance() {
		ChVacdImmunizationAdministrationDocument doc = new ChVacdImmunizationAdministrationDocument();
		doc.setPatient(testPatient);
		ChVacdAllergyIntolerance ref = doc.addAllergyIntolerance();

		assertNotNull(ref);
		assertNotNull(doc.resolveAllergyIntolerances());
	}

	/**
	 * Test method for
	 * {@link org.projecthusky.fhir.vacd.ch.common.resource.r4.ChVacdAbstractDocument#addPastIllness()}.
	 */
	@Test
	void testAddPastIllness() {
		ChVacdImmunizationAdministrationDocument doc = new ChVacdImmunizationAdministrationDocument();
		doc.setPatient(testPatient);
		ChVacdPastIllness ref = doc.addPastIllness();

		assertNotNull(ref);
		assertNotNull(doc.resolvePastIllnesses());
	}

}
