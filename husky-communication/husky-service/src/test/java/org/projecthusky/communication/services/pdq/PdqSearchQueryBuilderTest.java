/*
 * This code is made available under the terms of the Eclipse Public License v1.0 
 * in the github project https://github.com/project-husky/husky there you also 
 * find a list of the contributors and the license information.
 * 
 * This project has been developed further and modified by the joined working group Husky 
 * on the basis of the eHealth Connector opensource project from June 28, 2021, 
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.communication.services.pdq;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.projecthusky.common.communication.Destination;
import org.projecthusky.communication.requests.pdq.PdqSearchQuery;

public class PdqSearchQueryBuilderTest {
	
	@Test
	public void whenNoDestinationIsSet_thenBuildingTheQueryThrowsAnException() {
		NullPointerException resultingException = assertThrows(NullPointerException.class, () -> {
			PdqSearchQuery.builder().build();
		});
		assertEquals("destination is marked non-null but is null", resultingException.getMessage());
	}
	
	@Test
	public void whenDestinationIsSetToNull_thenExceptionIsThrown() {
		NullPointerException resultingException = assertThrows(NullPointerException.class, () -> {
			PdqSearchQuery.builder().destination(null);
		});
		assertEquals("destination is marked non-null but is null", resultingException.getMessage());
	}
	
	@Test
	public void whenDomainsToReturnAreNotAdded_thenListIsStillNotNull() {
		PdqSearchQuery query = PdqSearchQuery.builder().destination(new Destination()).build();
		assertNotNull(query);
		assertNotNull(query.getDomainsToReturn());
	}
}
