package org.projecthusky.fhir.vacd.ch.common.resource.r4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.projecthusky.fhir.vacd.ch.common.TestHelper;

class ChVacdRecommendationResponseMessageTest extends TestHelper {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testAddImmunizationRecommendation() {
		ChVacdRecommendationResponseMessage ref = new ChVacdRecommendationResponseMessage();
		ChVacdImmunizationRecommendation entry = ref.addImmunizationRecommendation();
		entry.setDate(new java.util.Date());

		List<ChVacdImmunizationRecommendation> list = ref.resolveImmunizationRecommendations();
		assertNotNull(list);
		assertEquals(1, list.size());
		assertEquals(entry, list.get(0));

		assertTrue(ref.getEntryFirstRep() != null && //
				ref.getEntryFirstRep()
						.getResource() instanceof ChVacdRecommendationResponseMessageHeader);

		prettyPrint(ref);
	}

}
