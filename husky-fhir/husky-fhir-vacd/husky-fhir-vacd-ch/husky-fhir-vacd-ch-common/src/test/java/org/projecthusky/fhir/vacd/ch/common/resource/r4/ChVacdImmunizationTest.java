/**
 * 
 */
package org.projecthusky.fhir.vacd.ch.common.resource.r4;

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
	void test() {
		ChVacdImmunization ref = new ChVacdImmunization();
		ref.setRecorder(new Reference(testPatient));

		prettyPrint(ref);
	}

}
