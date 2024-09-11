/**
 * 
 */
package org.projecthusky.fhir.vacd.ch.common.resource;

import static org.junit.jupiter.api.Assertions.*;

import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Reference;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.projecthusky.fhir.core.ch.ChCoreImmunization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.fhir.context.FhirContext;

/**
 * 
 */
class ChCoreImmunizationTest {
	private Logger logger = LoggerFactory.getLogger(ChCoreImmunizationTest.class);

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

	/**
	 * Test method for
	 * {@link org.projecthusky.fhir.core.ch.ChCoreImmunization#setRecorder(org.hl7.fhir.r4.model.Reference)}.
	 */
	@Test
	void testSetGetRecorder() {
		ChCoreImmunization ref = new ChCoreImmunization();
		ref.setRecorder(new Reference(testPatient));

		FhirContext ctx = FhirContext.forR4();
		System.out.println(ctx.newJsonParser().setPrettyPrint(true).encodeResourceToString(ref));

	}

}
