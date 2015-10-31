package org.ehealth_connector.communication.mpi.impl.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.ehealth_connector.communication.mpi.FhirPatient;
import org.ehealth_connector.communication.mpi.impl.V3PixPdqAdapter;
import org.junit.Before;
import org.junit.Test;
import org.openhealthtools.ihe.pdq.consumer.v3.V3PdqConsumerResponse;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import ca.uhn.fhir.model.dstu2.resource.Organization;

/**
 * Perform Mockup tests of the V3PixPdqApater with the supplied ITI Sample
 * Material PDQ Response 02_PDQQuery1Response.xml
 * 
 */
public class PdqConsumerTests {

	private V3PdqConsumerResponse response;

	@Before
	public void load02_PDQQuery1Response() {
		InputStream inputStream = getClass().getResourceAsStream("02_PDQQuery1Response.xml");
		DocumentBuilder db = null;
		try {
			db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			fail(e.toString());
		}
		org.w3c.dom.Document doc = null;
		try {
			doc = db.parse(inputStream);
		} catch (SAXException e) {
			fail(e.toString());
		} catch (IOException e) {
			fail(e.toString());
		}
		Element rootElement = doc.getDocumentElement();
		assertNotNull(rootElement);

		try {
			response = new V3PdqConsumerResponse(rootElement);
		} catch (Exception e) {
			fail(e.toString());
		}

	}

	@Test
	public void testConsumerResponseHeader() {
		assertEquals("AA", response.getAcknowledgementCode());
		assertEquals("1.2.840.114350.1.13.28.1.18.5.999", response.getAckQueryID().getRoot());
		assertEquals("18204", response.getAckQueryID().getExtension());
		assertEquals(2, response.getNumRecordsCurrent());
		assertEquals(3, response.getNumRecordsRemaining());
	}

	@Test
	public void testFhirResponsePatient() {
		V3PixPdqAdapter v3PixPdqAdapter = new V3PixPdqAdapter();
		List<FhirPatient> patients = v3PixPdqAdapter.getPatientsFromPdqQuery(response);
		assertEquals(2, patients.size());
		FhirPatient james = patients.get(0);
		assertEquals("Jones", james.getNameFirstRep().getFamilyAsSingleString());
		assertEquals("James", james.getNameFirstRep().getGivenAsSingleString());

		assertEquals("work", james.getTelecom().get(0).getUse());
		assertEquals("+1-481-555-7684;ext=2342", james.getTelecom().get(0).getValue());
		assertEquals("home", james.getTelecom().get(1).getUse());
		assertEquals("+1-765-555-4352", james.getTelecom().get(1).getValue());
		assertEquals("male", james.getGender());
		assertEquals("1963-08-04", james.getBirthDateElement().getValueAsString());
		assertEquals("3443 North Arctic Avenue", james.getAddressFirstRep().getLineFirstRep()
				.getValue());
		assertEquals("Some City", james.getAddressFirstRep().getCity());
		assertEquals("IL", james.getAddressFirstRep().getState());

		assertEquals("urn:oid:1.2.840.114350.1.13.99998.8734", james.getIdentifierFirstRep()
				.getSystem());
		assertEquals("34827K410", james.getIdentifierFirstRep().getValue());
		assertEquals("urn:oid:1.2.840.114350.1.13.99997.2.3412", james.getIdentifier().get(1)
				.getSystem());
		assertEquals("38273D433", james.getIdentifier().get(1).getValue());
		assertEquals("urn:oid:2.16.840.1.113883.4.1", james.getIdentifier().get(2).getSystem());
		assertEquals("999-88-6345", james.getIdentifier().get(2).getValue());

		assertNotNull(james.getManagingOrganization().getResource());
		Organization organization = (Organization) james.getManagingOrganization().getResource();
		assertEquals("urn:oid:1.2.840.114350.1.13.99998.8734", organization.getIdentifier().get(0)
				.getValue());
		assertEquals("Good Health Clinic", organization.getName());
		assertEquals("+1-342-555-8394", organization.getTelecomFirstRep().getValue());

		FhirPatient jim = patients.get(1);
		assertEquals("Jones", jim.getNameFirstRep().getFamilyAsSingleString());
		assertEquals("Jim", jim.getNameFirstRep().getGivenAsSingleString());
		assertEquals("home", jim.getTelecom().get(0).getUse());
		assertEquals("+1-795-555-4745", jim.getTelecom().get(0).getValue());
		assertEquals("1963-07-13", jim.getBirthDateElement().getValueAsString());
		assertEquals("8734 Blue Ocean Street", jim.getAddressFirstRep().getLineFirstRep()
				.getValue());
		assertEquals("Other City", jim.getAddressFirstRep().getCity());
		assertEquals("IL", jim.getAddressFirstRep().getState());

		organization = (Organization) jim.getManagingOrganization().getResource();
		assertEquals("urn:oid:1.2.840.114350.1.13.99998.8734", organization.getIdentifier().get(0)
				.getValue());
		assertEquals("Good Health Clinic", organization.getName());
		assertEquals("+1-342-555-8394", organization.getTelecomFirstRep().getValue());

		assertEquals("urn:oid:1.2.840.114350.1.13.99998.8734", jim.getIdentifierFirstRep()
				.getSystem());
		assertEquals("34827R534", jim.getIdentifierFirstRep().getValue());

	}

}
