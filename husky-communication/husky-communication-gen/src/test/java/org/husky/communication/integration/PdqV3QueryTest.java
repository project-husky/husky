/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */
package org.husky.communication.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.InputStream;
import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.xml.bind.JAXBContext;

import org.hl7.fhir.dstu3.model.Organization;
import org.husky.common.basetypes.AddressBaseType;
import org.husky.common.communication.AffinityDomain;
import org.husky.common.communication.Destination;
import org.husky.common.enums.AdministrativeGender;
import org.husky.common.model.Address;
import org.husky.common.model.Identificator;
import org.husky.common.model.Name;
import org.husky.common.model.Patient;
import org.husky.communication.ConvenienceMasterPatientIndexV3;
import org.husky.communication.MasterPatientIndexQuery;
import org.husky.communication.MasterPatientIndexQueryResponse;
import org.husky.communication.mpi.impl.PdqV3Query;
import org.husky.communication.mpi.impl.pdq.V3PdqConsumerResponse;
import org.husky.communication.testhelper.TestApplication;
import org.husky.fhir.structures.gen.FhirCommon;
import org.husky.fhir.structures.gen.FhirPatient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import net.ihe.gazelle.hl7v3.prpain201306UV02.PRPAIN201306UV02Type;


/**
 * Test of class PdqV3Query
 */
@ExtendWith(value = SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = { TestApplication.class })
@EnableAutoConfiguration
public class PdqV3QueryTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(PdqV3QueryTest.class.getName());

	@Autowired
	private ConvenienceMasterPatientIndexV3 convenienceMasterPatientIndexV3Client;

	final private String pdqUri = "https://ehealthsuisse.ihe-europe.net/PAMSimulator-ejb/PDQSupplier_Service/PDQSupplier_PortType";

	final private String applicationName = "2.16.840.1.113883.3.72.6.5.100.1399"; //oid of nist healthcare
	final private String facilityName = null;

	final private String senderApplicationOid = "1.2.3.4";
	
	
	
	
	
	/**
	 * Method implementing
	 *
	 * @return
	 * @throws Exception
	 */
	private V3PdqConsumerResponse loadV3PdqResponse() throws Exception {

		final InputStream inputStream = getClass().getResourceAsStream("/02_PDQQuery1Response.xml");
		final var unmarshaller = JAXBContext.newInstance(PRPAIN201306UV02Type.class).createUnmarshaller();
		var rootElement = (PRPAIN201306UV02Type) unmarshaller.unmarshal(inputStream);

		return new V3PdqConsumerResponse(rootElement);
	}
    
	

	/**
	 * Method implementing
	 *
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		var app = new SpringApplication(TestApplication.class);
		app.setWebApplicationType(WebApplicationType.NONE);
		app.run();
	}

	@Test
	public void contextLoads() {
		assertNotNull(convenienceMasterPatientIndexV3Client);
		assertNotNull(convenienceMasterPatientIndexV3Client.getContext());
	}

	/**
	 * Test method for
	 * {@link org.husky.communication.mpi.impl.V3PixPdqAdapter#getPatientsFromPdqQuery(org.openhealthtools.ihe.pdq.consumer.v3.V3PdqConsumerResponse)}
	 * .
	 *
	 * @throws Exception
	 */
	@Test
	public void testGetPatientsFromPdqQuery() throws Exception {
		
		final AffinityDomain affinityDomain = new AffinityDomain();
		final Destination dest = new Destination();
		dest.setUri(URI.create(pdqUri));
		dest.setSenderApplicationOid(senderApplicationOid);
		dest.setReceiverApplicationOid(applicationName);
		dest.setReceiverFacilityOid(facilityName);
		affinityDomain.setPdqDestination(dest);
		affinityDomain.setPixDestination(dest);
		
		final V3PdqConsumerResponse response = loadV3PdqResponse();
		assertNotNull(response);

		final var v3PdqQuery = new PdqV3Query(affinityDomain, null, null,
				convenienceMasterPatientIndexV3Client.getAuditContext());
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
		assertEquals("3443 North Arctic Avenue",
				james.getAddressFirstRep().getLine().get(0).getValue());
		assertEquals("Some City", james.getAddressFirstRep().getCity());
		assertEquals("IL", james.getAddressFirstRep().getState());

		assertEquals(FhirCommon.addUrnOid("1.2.840.114350.1.13.99998.8734"),
				james.getIdentifierFirstRep().getSystem());
		assertEquals("34827K410", james.getIdentifierFirstRep().getValue());
		assertEquals(FhirCommon.addUrnOid("1.2.840.114350.1.13.99997.2.3412"),
				james.getIdentifier().get(1).getSystem());
		assertEquals("38273D433", james.getIdentifier().get(1).getValue());
		assertEquals(FhirCommon.addUrnOid("2.16.840.1.113883.4.1"),
				james.getIdentifier().get(2).getSystem());
		assertEquals("999-88-6345", james.getIdentifier().get(2).getValue());

		assertNotNull(james.getManagingOrganization().getResource());
		Organization organization = (Organization) james.getManagingOrganization().getResource();
		assertEquals(FhirCommon.addUrnOid("1.2.840.114350.1.13.99998.8734"),
				organization.getIdentifier().get(0).getValue());
		assertEquals("Good Health Clinic", organization.getName());
		assertEquals("+1-342-555-8394", organization.getTelecomFirstRep().getValue());

		final FhirPatient jim = patients.get(1);
		assertEquals("Jones", jim.getNameFirstRep().getFamily());
		assertEquals("Jim", jim.getNameFirstRep().getGivenAsSingleString());
		assertEquals("home", jim.getTelecom().get(0).getUse().toCode().toLowerCase());
		assertEquals("+1-795-555-4745", jim.getTelecom().get(0).getValue());
		assertEquals("1963-07-13", jim.getBirthDateElement().getValueAsString());
		assertEquals("8734 Blue Ocean Street",
				jim.getAddressFirstRep().getLine().get(0).getValue());
		assertEquals("Other City", jim.getAddressFirstRep().getCity());
		assertEquals("IL", jim.getAddressFirstRep().getState());

		organization = (Organization) jim.getManagingOrganization().getResource();
		assertEquals(FhirCommon.addUrnOid("1.2.840.114350.1.13.99998.8734"),
				organization.getIdentifier().get(0).getValue());
		assertEquals("Good Health Clinic", organization.getName());
		assertEquals("+1-342-555-8394", organization.getTelecomFirstRep().getValue());

		assertEquals(FhirCommon.addUrnOid("1.2.840.114350.1.13.99998.8734"),
				jim.getIdentifierFirstRep().getSystem());
		assertEquals("34827R534", jim.getIdentifierFirstRep().getValue());
	}

	
	@Test
	/*
	 * check if the patient is correctly not found in case a random  identificator that does not
	 * identify any patient in the database is used
	 */
	public void ITI47ConsumerQueryPatientPatientIdNotFoundTest() {
		

		final AffinityDomain affinityDomain = new AffinityDomain();
		final Destination dest = new Destination();
		dest.setUri(URI.create(pdqUri));
		dest.setSenderApplicationOid(senderApplicationOid);
		dest.setReceiverApplicationOid(applicationName);
		dest.setReceiverFacilityOid(facilityName);
		affinityDomain.setPdqDestination(dest);
		affinityDomain.setPixDestination(dest); 
		
		LOGGER.debug("ITI47ConsumerQueryPatientPatientIdNotFoundTest with ipAdress Target " + pdqUri);

		final MasterPatientIndexQuery mpiQuery = new MasterPatientIndexQuery(affinityDomain.getPdqDestination());
		final Identificator identificator = new Identificator("1.3.6.1.4.1.12559.11.20.1", "4711");
		mpiQuery.addPatientIdentificator(identificator);
		
		final MasterPatientIndexQueryResponse response = convenienceMasterPatientIndexV3Client
				.queryPatientDemographics(
				mpiQuery,
				affinityDomain, null);
		
		// test patient not found 
		assertTrue(response.getSuccess());
	    assertEquals(0,response.getTotalNumbers());
	    
	}
	
	
	@Test
	public void ITI47ConsumerQueryPatientPatientIdFoundTest() {
		

		final AffinityDomain affinityDomain = new AffinityDomain();
		final Destination dest = new Destination();
		dest.setUri(URI.create(pdqUri));
		dest.setSenderApplicationOid(senderApplicationOid);
		dest.setReceiverApplicationOid(applicationName);
		dest.setReceiverFacilityOid(facilityName);
		affinityDomain.setPdqDestination(dest);
		affinityDomain.setPixDestination(dest); 
		
		LOGGER.debug("ITI47ConsumerQueryPatientPatientIdFoundTest with ipAdress Target " + pdqUri);
		
		//CHPAM18^^^CHPAM&1.3.6.1.4.1.12559.11.20.1&ISO Jasmin Schaub query Patient Demographic Supplier (PDS)
		final MasterPatientIndexQuery mpiQuery2 = new MasterPatientIndexQuery(affinityDomain.getPdqDestination());
		final Identificator identificator2 = new Identificator("1.3.6.1.4.1.12559.11.20.1", "CHPAM18");
		
        mpiQuery2.addPatientIdentificator(identificator2);
	    
		final MasterPatientIndexQueryResponse response2 = convenienceMasterPatientIndexV3Client
				.queryPatientDemographics(
				mpiQuery2,
				affinityDomain, null);
		
		List<Patient> patients = response2.getPatients();
		assertTrue(response2.getSuccess());
		assertEquals(patients.size(),1);
		Patient patient = patients.get(0);
		
		assertEquals(patient.getCompleteName().trim(),"Jasmin Schaub");

		assertEquals(patient.getAdministrativeGenderCode().getCodeValue(),AdministrativeGender.FEMALE.getCodeValue());
		assertEquals(patient.getAddress().getCountry(),"CHE");
	    
	}

	@Test
	public void ITI47ConsumerQueryPatientPatientIdSearchByName() {
		
		final AffinityDomain affinityDomain = new AffinityDomain();
		final Destination dest = new Destination();
		dest.setUri(URI.create(pdqUri));
		dest.setSenderApplicationOid(senderApplicationOid);
		dest.setReceiverApplicationOid(applicationName);
		dest.setReceiverFacilityOid(facilityName);
		affinityDomain.setPdqDestination(dest);
		affinityDomain.setPixDestination(dest); 

		LOGGER.debug("ITI47ConsumerQueryPatientPatientIdSearchByName with ipAdress Target " + pdqUri);
		final MasterPatientIndexQuery mpiQuery = new MasterPatientIndexQuery(affinityDomain.getPdqDestination());
		
		Name patientName = new Name();
		patientName.setFamily("Sanders");
		mpiQuery.addPatientName(false, patientName);
		
		final MasterPatientIndexQueryResponse response = convenienceMasterPatientIndexV3Client
				.queryPatientDemographics(mpiQuery, affinityDomain, null);
		
		assertTrue(response.getSuccess());
		assertEquals(response.getPatients().size(),9);
	} 
	
	
	@Test
	public void ITI47ConsumerQueryPatientPatientIdSearchByfirstNameAndBirthdate() {
		
		final AffinityDomain affinityDomain = new AffinityDomain();
		final Destination dest = new Destination();
		dest.setUri(URI.create(pdqUri));
		dest.setSenderApplicationOid(senderApplicationOid);
		dest.setReceiverApplicationOid(applicationName);
		dest.setReceiverFacilityOid(facilityName);
		affinityDomain.setPdqDestination(dest);
		affinityDomain.setPixDestination(dest); 

		LOGGER.debug("ITI47ConsumerQueryPatientPatientIdSearchByName with ipAdress Target " + pdqUri);
		final MasterPatientIndexQuery mpiQuery = new MasterPatientIndexQuery(affinityDomain.getPdqDestination());
		
		try {
			mpiQuery.setPatientDateOfBirth(new SimpleDateFormat("dd.MM.yyyy").parse("22.06.1958"));
		} catch (ParseException e) {
			e.printStackTrace();
		}  
	  
		Name patientName = new Name();
		patientName.setGiven("David");
		mpiQuery.addPatientName(false, patientName);
	    Address address = new Address(new AddressBaseType());
	    address.setCity("Acworth");
	    address.setPostalCode("30101");
	    address.setStreetName("Southside Drive");
	    mpiQuery.addPatientAddress(address);
		
		final MasterPatientIndexQueryResponse response = convenienceMasterPatientIndexV3Client
				.queryPatientDemographics(mpiQuery, affinityDomain, null);
		
		assertTrue(response.getSuccess());
		assertEquals(response.getPatients().size(),1);
		Patient patient = response.getPatients().get(0);
		assertEquals(patient.getCompleteName().trim(),"David Sanders");
		
	} 


}
