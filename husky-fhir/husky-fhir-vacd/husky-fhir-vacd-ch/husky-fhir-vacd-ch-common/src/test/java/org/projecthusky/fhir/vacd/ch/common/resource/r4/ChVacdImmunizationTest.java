/**
 * 
 */
package org.projecthusky.fhir.vacd.ch.common.resource.r4;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.r4.model.CodeType;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Reference;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.projecthusky.fhir.core.ch.resource.extension.r4.ChCoreResourceCrossReferenceExt;
import org.projecthusky.fhir.vacd.ch.common.TestHelper;
import org.projecthusky.fhir.vacd.ch.common.resource.extension.r4.ChVacdMergingConflictExt;

/**		
 * 	
 */
class ChVacdImmunizationTest extends TestHelper {

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
	void testRelatesTo() {
		ChVacdImmunization ref = new ChVacdImmunization();
		ChCoreResourceCrossReferenceExt ext = new ChCoreResourceCrossReferenceExt();
		ext.setEntry(new Reference("http://example.org/Immunization/123"));
		ext.setContainer(new Reference("http://example.org/Composition/123"));
		ext.setRelationcode(new CodeType("source"));
		ref.setRelatesTo(ext);

		String refString = toString(ref);
		logger.info(refString);
		assertNotNull(refString);
		assertTrue(refString.contains("ch-core-ext-entry-resource-cross-references"));
	}

	@Test
	void testRecorder() {
		ChVacdImmunization ref = new ChVacdImmunization();
		ref.setRecorder(new Reference(testPatient));

		String refString = toString(ref);
		logger.info(refString);
		assertNotNull(refString);
		assertTrue(refString.contains("http://fhir.ch/ig/ch-core/StructureDefinition/ch-ext-author"));
	}

	@Test
	void testVerificationStatus() {
		ChVacdImmunization ref = new ChVacdImmunization();
		ref.setVerificationStatus(new Coding("http://snomed.info/sct", "59156000", "Confirmed"));

		String refString = toString(ref);
		logger.info(refString);
		assertNotNull(refString);
		assertTrue(refString.contains("ch-vacd-ext-verification-status"));

	}
	
	@Test
	void testMedication() {
		ChVacdImmunization ref = new ChVacdImmunization();
		
		ChVacdMedicationForImmunization medication = new ChVacdMedicationForImmunization();
		ref.setMedication(medication);

		String refString = toString(ref);
		logger.info(refString);
		assertNotNull(refString);
		assertTrue(refString.contains("http://fhir.ch/ig/ch-vacd/StructureDefinition/ch-vacd-ext-immunization-medication-reference"));
	}

	@Test
	void testConflicts1() {
		ChVacdImmunization ref = new ChVacdImmunization();

		ChVacdMergingConflictExt conflict = ref.addConflict();
		conflict.setEntry(new Reference("http://example.org/Immunization/123"));
		conflict.setConflict(new CodeType("duplicate"));
		
		String refString = toString(ref);
		logger.info(refString);
		assertNotNull(refString);
		assertTrue(refString.contains("ch-vacd-ext-merging-conflict-entry-reference"));
	}

	@Test
	void testConflicts2() {
		ChVacdImmunization ref = new ChVacdImmunization();
		{
			ChVacdMergingConflictExt conflict = ref.addConflict();
			conflict.setEntry(new Reference("http://example.org/Immunization/123"));
			conflict.setConflict(new CodeType("duplicate"));
		}
		{
			ChVacdMergingConflictExt conflict = new ChVacdMergingConflictExt();
			conflict.setEntry(new Reference("http://example.org/Immunization/456"));
			conflict.setConflict(new CodeType("duplicate"));
			ref.addConflict(conflict);
		}
		
		String refString = toString(ref);
		logger.info(refString);
		assertNotNull(refString);
		assertTrue(refString.contains("http://fhir.ch/ig/ch-vacd/StructureDefinition/ch-vacd-ext-merging-conflict-entry-reference"));
		
		int pos1 = refString.indexOf("http://fhir.ch/ig/ch-vacd/StructureDefinition/ch-vacd-ext-merging-conflict-entry-reference");
		assertTrue(pos1 > 0);
		int pos2 = refString.indexOf("http://fhir.ch/ig/ch-vacd/StructureDefinition/ch-vacd-ext-merging-conflict-entry-reference", pos1+2);
		assertTrue(pos2 > pos1);
		int pos3 = refString.indexOf("http://fhir.ch/ig/ch-vacd/StructureDefinition/ch-vacd-ext-merging-conflict-entry-reference", pos2+2);
		assertTrue(pos3 < 0);
	}
	
	@Test
	void testConflicts3() {
		ChVacdImmunization ref = new ChVacdImmunization();
		List<ChVacdMergingConflictExt> conflicts = new ArrayList<>();
		{
			ChVacdMergingConflictExt conflict = new ChVacdMergingConflictExt();
			conflict.setEntry(new Reference("http://example.org/Immunization/123"));
			conflict.setConflict(new CodeType("duplicate"));
			conflicts.add(conflict);
		}
		{
			ChVacdMergingConflictExt conflict = new ChVacdMergingConflictExt();
			conflict.setEntry(new Reference("http://example.org/Immunization/456"));
			conflict.setConflict(new CodeType("duplicate"));
			conflicts.add(conflict);
		}
		ref.setConflict(conflicts);
		
		String refString = toString(ref);
		logger.info(refString);
		assertNotNull(refString);
	}

}
