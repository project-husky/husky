package org.projecthusky.fhir.vacd.ch.common.resource.r4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ChVacdRecommendationRequestMessageTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testAddImmunization() {
		ChVacdRecommendationRequestMessage ref = new ChVacdRecommendationRequestMessage();
		ChVacdImmunization entry = ref.addImmunization();

		List<ChVacdImmunization> list = ref.resolveImmunizations();
		assertNotNull(list);
		assertEquals(1, list.size());
		assertEquals(entry, list.get(0));
	}

	@Test
	void testAddBasicImmunization() {
		ChVacdRecommendationRequestMessage ref = new ChVacdRecommendationRequestMessage();
		ChVacdBasicImmunization entry = ref.addBasicImmunization();

		List<ChVacdBasicImmunization> list = ref.resolveBasicImmunizations();
		assertNotNull(list);
		assertEquals(1, list.size());
		assertEquals(entry, list.get(0));
	}

	@Test
	void testAddMedicalProblem() {
		ChVacdRecommendationRequestMessage ref = new ChVacdRecommendationRequestMessage();
		ChVacdMedicalProblem entry = ref.addMedicalProblem();

		List<ChVacdMedicalProblem> list = ref.resolveMedicalProblems();
		assertNotNull(list);
		assertEquals(1, list.size());
		assertEquals(entry, list.get(0));
	}

	@Test
	void testAddLaboratoryAndSerology() {
		ChVacdRecommendationRequestMessage ref = new ChVacdRecommendationRequestMessage();
		ChVacdLaboratoryAndSerology entry = ref.addLaboratoryAndSerology();

		List<ChVacdLaboratoryAndSerology> list = ref.resolveLaboratoryAndSerologies();
		assertNotNull(list);
		assertEquals(1, list.size());
		assertEquals(entry, list.get(0));
	}

	@Test
	void testAddAllergyIntolerance() {
		ChVacdRecommendationRequestMessage ref = new ChVacdRecommendationRequestMessage();
		ChVacdAllergyIntolerance entry = ref.addAllergyIntolerance();

		List<ChVacdAllergyIntolerance> list = ref.resolveAllergyIntolerances();
		assertNotNull(list);
		assertEquals(1, list.size());
		assertEquals(entry, list.get(0));
	}

	@Test
	void testAddPastIllness() {
		ChVacdRecommendationRequestMessage ref = new ChVacdRecommendationRequestMessage();
		ChVacdPastIllness entry = ref.addPastIllness();

		List<ChVacdPastIllness> list = ref.resolvePastIllnesses();
		assertNotNull(list);
		assertEquals(1, list.size());
		assertEquals(entry, list.get(0));
	}

}
