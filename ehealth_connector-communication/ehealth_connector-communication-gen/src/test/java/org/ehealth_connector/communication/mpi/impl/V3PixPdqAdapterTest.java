/* **********************************************************************
 * Author: roeland
 * Date  : Dec 16, 2015
 * File  : V3PixPdqAdapterTest.java
 * **********************************************************************
 * ehealth_connector-communication-gen
 *
 * Copyright (c) 2015
 * Arpage AG, CH - 8700 Kuesnacht ZH
 * All rights reserved
 * **********************************************************************
 */
package org.ehealth_connector.communication.mpi.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.ehealth_connector.fhir.FhirPatient;
import org.junit.Before;
import org.junit.Test;
import org.openhealthtools.ihe.pdq.consumer.v3.V3PdqConsumerResponse;
import org.w3c.dom.Element;

import ca.uhn.fhir.model.dstu2.resource.Organization;

/**
 * 
 * @author roeland
 * @version 1.0
 * @since Dec 16, 2015 5:08:37 PM
 *
 */
public class V3PixPdqAdapterTest {

	private org.openhealthtools.mdht.uml.cda.CDAFactory factory = org.openhealthtools.mdht.uml.cda.impl.CDAFactoryImpl.eINSTANCE;

	/**
	 * Method implementing
	 *
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.communication.mpi.impl.V3PixPdqAdapter#getPatientsFromPdqQuery(org.openhealthtools.ihe.pdq.consumer.v3.V3PdqConsumerResponse)}
	 * .
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetPatientsFromPdqQuery() throws Exception {
		final V3PdqConsumerResponse response = loadV3PdqResponse();
		assertNotNull(response);

		final V3PixPdqAdapter v3PixPdqAdapter = new V3PixPdqAdapter();
		final List<FhirPatient> patients = v3PixPdqAdapter.getPatientsFromPdqQuery(response);
		assertEquals(2, patients.size());
		final FhirPatient james = patients.get(0);
		assertEquals("Jones", james.getNameFirstRep().getFamilyAsSingleString());
		assertEquals("James", james.getNameFirstRep().getGivenAsSingleString());

		assertEquals("work", james.getTelecom().get(0).getUse());
		assertEquals("+1-481-555-7684;ext=2342", james.getTelecom().get(0).getValue());
		assertEquals("home", james.getTelecom().get(1).getUse());
		assertEquals("+1-765-555-4352", james.getTelecom().get(1).getValue());
		assertEquals("male", james.getGender());
		assertEquals("1963-08-04", james.getBirthDateElement().getValueAsString());
		assertEquals("3443 North Arctic Avenue", james.getAddressFirstRep().getLineFirstRep().getValue());
		assertEquals("Some City", james.getAddressFirstRep().getCity());
		assertEquals("IL", james.getAddressFirstRep().getState());

		assertEquals("urn:oid:1.2.840.114350.1.13.99998.8734", james.getIdentifierFirstRep().getSystem());
		assertEquals("34827K410", james.getIdentifierFirstRep().getValue());
		assertEquals("urn:oid:1.2.840.114350.1.13.99997.2.3412", james.getIdentifier().get(1).getSystem());
		assertEquals("38273D433", james.getIdentifier().get(1).getValue());
		assertEquals("urn:oid:2.16.840.1.113883.4.1", james.getIdentifier().get(2).getSystem());
		assertEquals("999-88-6345", james.getIdentifier().get(2).getValue());

		assertNotNull(james.getManagingOrganization().getResource());
		Organization organization = (Organization) james.getManagingOrganization().getResource();
		assertEquals("urn:oid:1.2.840.114350.1.13.99998.8734", organization.getIdentifier().get(0).getValue());
		assertEquals("Good Health Clinic", organization.getName());
		assertEquals("+1-342-555-8394", organization.getTelecomFirstRep().getValue());

		final FhirPatient jim = patients.get(1);
		assertEquals("Jones", jim.getNameFirstRep().getFamilyAsSingleString());
		assertEquals("Jim", jim.getNameFirstRep().getGivenAsSingleString());
		assertEquals("home", jim.getTelecom().get(0).getUse());
		assertEquals("+1-795-555-4745", jim.getTelecom().get(0).getValue());
		assertEquals("1963-07-13", jim.getBirthDateElement().getValueAsString());
		assertEquals("8734 Blue Ocean Street", jim.getAddressFirstRep().getLineFirstRep().getValue());
		assertEquals("Other City", jim.getAddressFirstRep().getCity());
		assertEquals("IL", jim.getAddressFirstRep().getState());

		organization = (Organization) jim.getManagingOrganization().getResource();
		assertEquals("urn:oid:1.2.840.114350.1.13.99998.8734", organization.getIdentifier().get(0).getValue());
		assertEquals("Good Health Clinic", organization.getName());
		assertEquals("+1-342-555-8394", organization.getTelecomFirstRep().getValue());

		assertEquals("urn:oid:1.2.840.114350.1.13.99998.8734", jim.getIdentifierFirstRep().getSystem());
		assertEquals("34827R534", jim.getIdentifierFirstRep().getValue());
	}

	/**
	 * Method implementing
	 *
	 * @return
	 * @throws Exception
	 */
	private V3PdqConsumerResponse loadV3PdqResponse() throws Exception {

		final InputStream inputStream = getClass().getResourceAsStream("/02_PDQQuery1Response.xml");
		final DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();

		final org.w3c.dom.Document doc = db.parse(inputStream);

		final Element rootElement = doc.getDocumentElement();

		return new V3PdqConsumerResponse(rootElement);

	}

}
