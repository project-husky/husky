package org.projecthusky.communication.mpi.impl.pdq;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;
import java.util.List;

import jakarta.xml.bind.JAXBContext;

import org.hl7.fhir.r4.model.Organization;
import org.junit.jupiter.api.Test;
import org.projecthusky.common.communication.AffinityDomain;
import org.projecthusky.common.communication.Destination;
import org.projecthusky.communication.mpi.impl.PdqV3Query;
import org.projecthusky.fhir.structures.gen.FhirCommon;
import org.projecthusky.fhir.structures.gen.FhirPatient;

import net.ihe.gazelle.hl7v3.prpain201306UV02.PRPAIN201306UV02Type;


/**
 * Test of class PdqV3Query
 */

public class PdqV3QueryTest {

	/**
	 * Method implementing
	 *
	 * @return
	 * @throws Exception
	 */
	private V3PdqConsumerResponse loadV3PdqResponse() throws Exception {

		try (InputStream inputStream = new FileInputStream("src/test/resources/02_PDQQuery1Response.xml")) {
			final var unmarshaller = JAXBContext.newInstance(PRPAIN201306UV02Type.class).createUnmarshaller();
			var rootElement = (PRPAIN201306UV02Type) unmarshaller.unmarshal(inputStream);

			return new V3PdqConsumerResponse(rootElement);
		}
	}

	@Test
	@SuppressWarnings("java:S5961")
	void testGetPatientsFromPdqQuery() throws Exception {

		final AffinityDomain affinityDomain = new AffinityDomain();
		final Destination dest = new Destination();
		dest.setUri(URI.create(""));
		dest.setSenderApplicationOid("");
		dest.setReceiverApplicationOid("");
		dest.setReceiverFacilityOid("");
		affinityDomain.setPdqDestination(dest);
		affinityDomain.setPixDestination(dest);

		final V3PdqConsumerResponse response = loadV3PdqResponse();
		assertNotNull(response);

		final var v3PdqQuery = new PdqV3Query(affinityDomain, null, null, null);
		final List<FhirPatient> patients = v3PdqQuery.getPatientsFromPdqQuery(response);
		assertEquals(2, patients.size());
		final FhirPatient james = patients.get(0);
		assertEquals("Jones", james.getNameFirstRep().getFamily());
		assertEquals("James", james.getNameFirstRep().getGivenAsSingleString());

		assertEquals("work", james.getTelecom().get(0).getUse().toCode().toLowerCase());
		assertEquals("+1-481-555-7684;ext=2342", james.getTelecom().get(0).getValue());
		assertEquals("home", james.getTelecom().get(1).getUse().toCode().toLowerCase());
		assertEquals("+1-765-555-4352", james.getTelecom().get(1).getValue());
		assertEquals("male", james.getGender().toCode().toLowerCase());
		assertEquals("1963-08-04", james.getBirthDateElement().getValueAsString());
		assertEquals("3443 North Arctic Avenue", james.getAddressFirstRep().getLine().get(0).getValue());
		assertEquals("Some City", james.getAddressFirstRep().getCity());
		assertEquals("IL", james.getAddressFirstRep().getState());

		assertEquals(FhirCommon.addUrnOid("1.2.840.114350.1.13.99998.8734"), james.getIdentifierFirstRep().getSystem());
		assertEquals("34827K410", james.getIdentifierFirstRep().getValue());
		assertEquals(FhirCommon.addUrnOid("1.2.840.114350.1.13.99997.2.3412"),
				james.getIdentifier().get(1).getSystem());
		assertEquals("38273D433", james.getIdentifier().get(1).getValue());
		assertEquals(FhirCommon.addUrnOid("2.16.840.1.113883.4.1"), james.getIdentifier().get(2).getSystem());
		assertEquals("999-88-6345", james.getIdentifier().get(2).getValue());

		assertNotNull(james.getManagingOrganization().getResource());
		Organization organization = (Organization) james.getManagingOrganization().getResource();
		assertEquals(FhirCommon.addUrnOid("1.2.840.114350.1.13.99998.8734"),
				organization.getIdentifier().get(0).getValue());
		assertEquals("Good Health Clinic", organization.getName());
		assertEquals("+1-342-555-8394", organization.getTelecomFirstRep().getValue());

	}

}
