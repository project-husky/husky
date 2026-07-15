package org.projecthusky.fhir.vacd.ch.common.resource.r4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ChVacdRecommendationResponseMessageTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testAddImmunizationRecommendation() {
		ChVacdRecommendationResponseMessage ref = new ChVacdRecommendationResponseMessage();
		ChVacdImmunizationRecommendation entry = ref.addImmunizationRecommendation();

		List<ChVacdImmunizationRecommendation> list = ref.resolveImmunizationRecommendations();
		assertNotNull(list);
		assertEquals(1, list.size());
		assertEquals(entry, list.get(0));
	}

}
