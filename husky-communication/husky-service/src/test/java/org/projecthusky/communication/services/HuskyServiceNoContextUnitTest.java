/*
 * This code is made available under the terms of the Eclipse Public License v1.0 
 * in the github project https://github.com/project-husky/husky there you also 
 * find a list of the contributors and the license information.
 * 
 * This project has been developed further and modified by the joined working group Husky 
 * on the basis of the eHealth Connector opensource project from June 28, 2021, 
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.communication.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Organization;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.projecthusky.common.communication.Destination;
import org.projecthusky.communication.requests.pdq.PdqSearchQuery;
import org.projecthusky.communication.requests.pix.PixAddPatientFeed;

public class HuskyServiceNoContextUnitTest {
	private HuskyService service = new HuskyService(null); //Actual webservice is not used.
	
	@Test
	void queryCreatorSelectorsAreReal() {
		assertNotNull(this.service.createPdqSearchQuery(new Destination()));
	}
	
	@Test
	void whenQueryPatientsQueryBuilderIsStarted_thenNotNullObjectIsReturned() {
		assertNotNull(this.service.createPdqSearchQuery(new Destination()).build());
	}
	
	@Test
	public void whenBuildingQueryWithNullDestination_thenExceptionIsThrown() {
		NullPointerException exception = assertThrows(NullPointerException.class, () -> {
			this.service.createPdqSearchQuery(null);
		});
		assertEquals("destination is marked non-null but is null", exception.getMessage());
	}
	
	@Test
	public void whenBuildingQueryWithDestination_andSettingNullLater_thenExceptionIsThrown() {
		NullPointerException exception = assertThrows(NullPointerException.class, () -> {
			this.service.createPdqSearchQuery(new Destination()).destination(null);
		});
		assertEquals("destination is marked non-null but is null", exception.getMessage());
	}
	
	@Test
	public void whenSendingNullQuery_thenIllegalArgumentExceptionIsThrown() {
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()->{
			this.service.send((PdqSearchQuery) null);
		});
		assertEquals("The search query can not be null.", exception.getMessage());
	}
	
	@Test
	public void whenAddingTwoIdentifiersForNewPatient_thenListIsFilledWithTwo() {
		PixAddPatientFeed feed = this.service.createPixAddPatientFeed(new Destination(), new Organization())
				.identifier(new Identifier()).identifier(new Identifier()).build();
		assertEquals(2, feed.getIdentifiers().size());
	}
	
	@Test
	@Disabled("Until scoping organization is no longer used as fallback")
	public void whenNoScopingOrganizationIsPresentInAddFeed_thenExceptionIsThrown() {
		NullPointerException exception = assertThrows(NullPointerException.class, () -> {
			this.service.createPixAddPatientFeed(new Destination(), null).build();
		});
		assertEquals("scopingOrganization is marked non-null but is null", exception.getMessage());
	}

}
