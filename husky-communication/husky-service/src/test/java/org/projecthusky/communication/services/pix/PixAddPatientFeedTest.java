/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.projecthusky.communication.services.pix;

import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.model.Organization;
import org.hl7.fhir.r4.model.Identifier;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.projecthusky.common.communication.Destination;
import org.projecthusky.communication.requests.pix.PixAddPatientFeed;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PixAddPatientFeedTest {

	@Test
	public void whenNoDestinationIsSet_thenBuildingTheQueryThrowsAnException() {
		NullPointerException resultingException = assertThrows(NullPointerException.class, () -> {
			PixAddPatientFeed.builder().build();
		});
		assertEquals("destination is marked non-null but is null", resultingException.getMessage());
	}

	@Test
	public void whenDestinationIsSetToNull_thenExceptionIsThrown() {
		NullPointerException resultingException = assertThrows(NullPointerException.class, () -> {
			PixAddPatientFeed.builder().destination(null);
		});
		assertEquals("destination is marked non-null but is null", resultingException.getMessage());
	}

	@Test
	@Disabled("Until scoping organization is no longer used as fallback")
	void whenDestinationIsNotNull_butProviderOrganizationIsNotSet_thenExceptionIsThrown() throws Exception {
		NullPointerException resultingException = assertThrows(NullPointerException.class, () -> {
			PixAddPatientFeed.builder().destination(new Destination()).build();
		});
		assertEquals("providerOrganization is marked non-null but is null", resultingException.getMessage());
	}

	@Test
	@Disabled("Until scoping organization is no longer used as fallback")
	void whenDestinationIsNotNull_andProviderOrganizationIsSetToNull_thenExceptionIsThrown() throws Exception {
		NullPointerException resultingException = assertThrows(NullPointerException.class, () -> {
			PixAddPatientFeed.builder().destination(new Destination()).providerOrganization(null);
		});
		assertEquals("providerOrganization is marked non-null but is null", resultingException.getMessage());
	}

	@Test
	public void whenBuilderIsBuilt_withMinimalParameters_thenListsAreInitializedByLombokAsEmplty() {
		PixAddPatientFeed addPatientQuery = PixAddPatientFeed.builder().destination(new Destination()).providerOrganization(new Organization()).build();
		assertNotNull(addPatientQuery);
		assertNotNull(addPatientQuery.getIdentifiers());
		assertNotNull(addPatientQuery.getNonMedicalIdentifiers());
		assertNotNull(addPatientQuery.getAddresses());
		assertNotNull(addPatientQuery.getLanguages());
		assertNotNull(addPatientQuery.getTelecomContacts());
		assertEquals(0, addPatientQuery.getIdentifiers().size());
		assertEquals(0, addPatientQuery.getNonMedicalIdentifiers().size());
		assertEquals(0, addPatientQuery.getAddresses().size());
		assertEquals(0, addPatientQuery.getLanguages().size());
		assertEquals(0, addPatientQuery.getTelecomContacts().size());
	}

	@Test
	public void testBuilding() {
		PixAddPatientFeed.PixAddPatientFeedBuilder pixAddPatientFeed = PixAddPatientFeed.builder().destination(new Destination()).providerOrganization(new Organization());
		pixAddPatientFeed.homeCommunityOID("1.2.3");

		Identifier localPatientIdentifier = new Identifier();
		localPatientIdentifier.setSystem("4.5.6");
		localPatientIdentifier.setValue("localId");

		Identifier eprPatientIdentifier = new Identifier();
		eprPatientIdentifier.setSystem("7.8.9");
		eprPatientIdentifier.setValue("7654554452452");

		pixAddPatientFeed.identifiers(List.of(localPatientIdentifier, eprPatientIdentifier));
		pixAddPatientFeed.birthday(new Date());

		HumanName patientName = new HumanName();
		patientName.addGiven("Hector");
		patientName.setFamily("Jones");
		pixAddPatientFeed.patientName(patientName);

		final var root = pixAddPatientFeed.build().build().getRootElement();
		assertNotNull(root);
		assertNotNull(root.getControlActProcess());
		assertNotNull(root.getControlActProcess().getSubject());
		final var subject = root.getControlActProcess().getSubject().get(0);
		assertNotNull(subject);
		assertFalse(subject.getContextConductionInd());
		assertEquals("SUBJ", subject.getTypeCode());
		assertNotNull(subject.getRegistrationEvent());
		assertNotNull(subject.getRegistrationEvent().getCustodian());
		assertNotNull(subject.getRegistrationEvent().getSubject1());
		final var patient = subject.getRegistrationEvent().getSubject1().getPatient();
		assertNotNull(patient);
		assertEquals(2, patient.getId().size());
	}
}
