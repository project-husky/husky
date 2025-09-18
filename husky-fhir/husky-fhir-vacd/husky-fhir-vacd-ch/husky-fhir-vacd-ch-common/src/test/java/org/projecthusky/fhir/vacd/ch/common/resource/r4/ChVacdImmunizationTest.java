/**
 * 
 */
package org.projecthusky.fhir.vacd.ch.common.resource.r4;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Reference;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.projecthusky.fhir.vacd.ch.common.TestHelper;

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
	void testRecorder() {
		ChVacdImmunization ref = new ChVacdImmunization();
		ref.setRecorder(new Reference(testPatient));

		prettyPrint(ref);
	}

	@Test
	void testVerificationStatus() {
		ChVacdImmunization ref = new ChVacdImmunization();
		ref.setVerificationStatus(new Coding("http://snomed.info/sct", "59156000", "Confirmed"));

		prettyPrint(ref);
		String refString = toString(ref);
		assertNotNull(refString);
		assertTrue(refString.contains("ch-vacd-ext-verification-status"));

	}

}
