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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.net.URI;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.xml.bind.DataBindingException;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.projecthusky.common.communication.Destination;
import org.projecthusky.common.model.Identificator;
import org.projecthusky.common.model.Name;
import org.projecthusky.common.model.Telecom;
import org.projecthusky.communication.requests.pdq.PdqSearchQuery;
import org.projecthusky.communication.responses.pdq.PdqSearchResults;
import org.projecthusky.communication.config.IpfApplicationConfig;
import org.projecthusky.communication.TestApplication;
import org.projecthusky.communication.services.HuskyService;
import org.projecthusky.fhir.structures.gen.FhirPatient;
import org.projecthusky.xua.exceptions.SerializeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = { TestApplication.class, IpfApplicationConfig.class })
@ActiveProfiles("atna")
public class PdqSearchQueryTest {
	@Value(value = "${test.pdq.uri:https://ehealthsuisse.ihe-europe.net/PAMSimulator-ejb/PDQSupplier_Service/PDQSupplier_PortType}")
	private String searchWebServiceUri;
	
	@Autowired
	private HuskyService service;
	
	private Destination testWSDestination;
	
	@BeforeEach
	public void setUp() {
		String senderApplicationOidTestValue = "1.2.3.4";
		this.testWSDestination = new Destination();
		this.testWSDestination.setUri(URI.create(searchWebServiceUri));
		this.testWSDestination.setSenderApplicationOid(senderApplicationOidTestValue);
	}
	
	@Test
	public void whenQueryingForCommonPatientName_thenPatientsAreReturned() throws Exception {
		Name patientName = new Name(Name.builder().withFamily("Anders").build());
		
		PdqSearchQuery patientNameQuery = this.service.createPdqSearchQuery(testWSDestination).patientName(patientName).build();
		PdqSearchResults results =  this.service.send(patientNameQuery);

		assertNotNull(results);
		assertEquals(9, results.getPatients().size(), "Results have not the expected amount of patients.");
	}
	
	@Test
	@Disabled("This test should either return 2 or 11 results, but not 9 as it does. Probably the error is in the paging.")
	//TODO: Figure out correct paging mechanism.
	public void whenQueryingForCommonPatientName_thatShouldReturnOnly2Results_then2PatientsAreReturned() throws Exception {
		Name patientName = new Name(Name.builder().withFamily("Sanders").build());
		
		PdqSearchQuery patientNameQuery = this.service.createPdqSearchQuery(testWSDestination).patientName(patientName).build();
		PdqSearchResults results =  this.service.send(patientNameQuery);
		assertNotNull(results);
		assertEquals(2, results.getPatients().size(), "Results have not the expected amount of patients.");
	}
	
	@Test
	public void whenQueryingForCommonPatientNameWithFuzzySearch_thenPatientsAreReturned() throws Exception {
		Name patientName = new Name(Name.builder().withFamily("Anders").build());
		
		PdqSearchQuery patientNameQuery = this.service.createPdqSearchQuery(testWSDestination).patientName(patientName).useFuzzyNameSearch(true).build();
		PdqSearchResults results =  this.service.send(patientNameQuery);
		
		for (FhirPatient patient: results.getPatients()) {
			System.out.println(patient);
		}
		assertNotNull(results);
		assertEquals(9, results.getPatients().size(), "Results have not the expected amount of patients.");
	}
	
	@Test
	public void whenQueryingForPatientID_thenPatientIsReturned() throws Exception {
		Identificator identificator = new Identificator("1.3.6.1.4.1.12559.11.20.1", "27");
		
		PdqSearchQuery patientQuery = this.service.createPdqSearchQuery(testWSDestination).identificator(identificator).build();
		PdqSearchResults results =  this.service.send(patientQuery);
		assertNotNull(results);
		assertEquals(1, results.getPatients().size());
		FhirPatient patient = results.getPatients().get(0);
		assertNotNull(patient);
		assertNull(patient.getId());
		assertEquals("1.3.6.1.4.1.12559.11.20.1", patient.getIdentificators().get(0).getRoot());
		assertEquals("Richard", patient.getName().get(0).getGivenAsSingleString());
		assertEquals("Sanders", patient.getName().get(0).getFamily());
		assertEquals("754-3310", patient.getTelecom().get(0).getValue());
	}
	
	@Test
	public void whenQueryingForPatientBirthday_thenPatientIsReturned() throws DataBindingException, JAXBException, ParserConfigurationException, SerializeException, IOException {
		LocalDate birthday = LocalDate.of(1950, 5, 31);
		PdqSearchQuery patienQuery = this.service.createPdqSearchQuery(testWSDestination)
				.patientDateOfBirth(Date.from(birthday.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant())).build();
		PdqSearchResults results =  this.service.send(patienQuery);
		assertNotNull(results);
		assertEquals(1, results.getPatients().size());

		FhirPatient patient = results.getPatients().get(0);
		assertNull(patient.getId());
		assertEquals("1.3.6.1.4.1.12559.11.20.1", patient.getIdentificators().get(0).getRoot());
		assertEquals("35", patient.getIdentificators().get(0).getExtension());
		assertEquals("Sherley", patient.getName().get(0).getGivenAsSingleString());
		assertEquals("Sands", patient.getName().get(0).getFamily());
		assertEquals("754-3015", patient.getTelecom().get(0).getValue());
		assertTrue(patient.getBirthDate().equals(Date.from(birthday.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant())));
	}
	
	@Test
	public void whenQueryingForPatientByTelecom_thenPatientIsReturned() throws Exception {
		Telecom telecomContact = new Telecom();
		telecomContact.setPhone("754-3310");
		
		PdqSearchQuery patienQuery = this.service.createPdqSearchQuery(testWSDestination).telecomContact(telecomContact).build();
		PdqSearchResults results =  this.service.send(patienQuery);
		assertNotNull(results);
		assertEquals(1, results.getPatients().size());
		FhirPatient patient = results.getPatients().get(0);
		assertNotNull(patient);
		assertNull(patient.getId());
		assertEquals("1.3.6.1.4.1.12559.11.20.1", patient.getIdentificators().get(0).getRoot());
		assertEquals("Richard", patient.getName().get(0).getGivenAsSingleString());
		assertEquals("Sanders", patient.getName().get(0).getFamily());
		assertEquals("754-3310", patient.getTelecom().get(0).getValue());
	}
	
	@Test
	public void whenQueryingForPatientIDAndCommonName_thenPatientIsReturned() throws Exception {
		Identificator identificator = new Identificator("1.3.6.1.4.1.12559.11.20.1", "27");
		Name patientName = new Name(Name.builder().withFamily("Sanders").build());
		
		PdqSearchQuery patientQuery = this.service.createPdqSearchQuery(testWSDestination).identificator(identificator).patientName(patientName).build();
		PdqSearchResults results =  this.service.send(patientQuery);
		
		assertNotNull(results);
		assertEquals(1, results.getPatients().size());
		FhirPatient patient = results.getPatients().get(0);
		assertNotNull(patient);
		assertNull(patient.getId());
		assertEquals("1.3.6.1.4.1.12559.11.20.1", patient.getIdentificators().get(0).getRoot());
		assertEquals("Richard", patient.getName().get(0).getGivenAsSingleString());
		assertEquals("Sanders", patient.getName().get(0).getFamily());
		assertEquals("754-3310", patient.getTelecom().get(0).getValue());
	}
	
	@Test
	@Disabled("This test was designed to figure out whether the search parameters are OR or AND interpreted. Looks like an AND to me.")
	public void whenQueryingForMultipleParameters_thenNothingIsFound_asParametersAreInterpretedWithANDLogic() throws Exception {
		Identificator identificator = new Identificator("1.3.6.1.4.1.12559.11.20.1", "27");
		Name patientName = new Name(Name.builder().withFamily("Dougon").build());
		Telecom telecomContact = new Telecom();
		telecomContact.setPhone("754-3333");
		
		PdqSearchQuery patientQuery = this.service.createPdqSearchQuery(testWSDestination).identificator(identificator).patientName(patientName).telecomContact(telecomContact).build();
		PdqSearchResults results =  this.service.send(patientQuery);
		
		assertNotNull(results);
		assertEquals(1, results.getPatients().size());
		FhirPatient patient = results.getPatients().get(0);
		assertNotNull(patient);
		assertNull(patient.getId());
		assertEquals("1.3.6.1.4.1.12559.11.20.1", patient.getIdentificators().get(0).getRoot());
		assertEquals("Richard", patient.getName().get(0).getGivenAsSingleString());
		assertEquals("Sanders", patient.getName().get(0).getFamily());
		assertEquals("754-3310", patient.getTelecom().get(0).getValue());
	}
	
	@Test
	@Disabled("This test does not find just the one patient with the mother specified, but finds 42. Fix is needed before it works.")
	//TODO: FIxing mother's maiden name query is needed for this to work correctly.
	public void whenQueryingForMothersMaidenName_thenPatientsAreFound() throws DataBindingException, JAXBException, ParserConfigurationException, SerializeException, IOException {
		Name patientName = new Name(Name.builder().withFamily("Ramelet").build());
		PdqSearchQuery patientQuery = this.service.createPdqSearchQuery(testWSDestination).mothersMaidenName(patientName).build();
		PdqSearchResults results =  this.service.send(patientQuery);
		assertNotNull(results);
		assertEquals(1, results.getPatients().size());
	}

}
