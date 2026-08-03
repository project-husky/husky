/**
 * 
 */
package org.projecthusky.fhir.core.ch.resource.r4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.StringType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.projecthusky.fhir.core.ch.TestHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 */
class ChCoreImmunizationTest extends TestHelper {

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
	 * {@link org.projecthusky.fhir.core.ch.resource.r4.ChCoreImmunization#setRecorder(org.hl7.fhir.r4.model.Reference)}.
	 */
	@Test
	void testSetGetRecorder() {
		ChCoreImmunization ref = new ChCoreImmunization();
		ref.setRecorder(new Reference(testPatient));

		prettyPrint(ref);
		assertNotNull(ref.getRecorder());
	}

	@Test
	void testSetGetIndication() {
		ChCoreImmunization ref = new ChCoreImmunization();
		ref.setIndicationCode(new StringType("IndicationCode"));

		prettyPrint(ref);

		assertNotNull(ref.getIndicationCode());
		assertEquals("IndicationCode", ref.getIndicationCode().getValue());

	}

}
