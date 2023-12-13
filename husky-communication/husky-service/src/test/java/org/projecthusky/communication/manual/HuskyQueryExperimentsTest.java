/*
 * This code is made available under the terms of the Eclipse Public License v1.0 
 * in the github project https://github.com/project-husky/husky there you also 
 * find a list of the contributors and the license information.
 * 
 * This project has been developed further and modified by the joined working group Husky 
 * on the basis of the eHealth Connector opensource project from June 28, 2021, 
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.communication.manual;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URI;
import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.projecthusky.common.communication.Destination;
import org.projecthusky.common.enums.AdministrativeGender;
import org.projecthusky.common.model.Address;
import org.projecthusky.common.model.Identificator;
import org.projecthusky.common.model.Name;
import org.projecthusky.common.model.Telecom;
import org.projecthusky.communication.TestApplication;
import org.projecthusky.communication.config.IpfApplicationConfig;
import org.projecthusky.communication.requests.pdq.PdqSearchQuery;
import org.projecthusky.communication.services.HuskyWebServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * These tests are experiments that prove the new service implementation of the search is working with integration of the old low-level XML classes 
 * and with the sending and receiving of the SOAP messages without any syntactical or semantical error.<br/>
 * Business cases are not proven here.
 * @author szalai
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = { TestApplication.class, IpfApplicationConfig.class })
@ActiveProfiles("atna")
public class HuskyQueryExperimentsTest {
	@Value(value = "${test.pdq.uri:https://ehealthsuisse.ihe-europe.net/PAMSimulator-ejb/PDQSupplier_Service/PDQSupplier_PortType}")
	private String webserviceUri;
	
	@Autowired
	private HuskyWebServiceClient wsClient;

	private Destination dest;

	@BeforeEach
	public void setUp() {
		dest = new Destination();
		dest.setUri(URI.create(webserviceUri));
		dest.setSenderApplicationOid("1.2.3.4");
	}
	
	@Test
	public void whenPatientQueriedByName_thenPatientIsReturned() throws Exception {
		Name patientName = new Name(Name.builder().withName("Bergan").withFamily("Ovie").build());
		PdqSearchQuery query = PdqSearchQuery.builder().destination(dest).patientName(patientName).build();
		assertNotNull(this.wsClient.sendPdqSearchQueryRequest(query.build(), null, query.getDestination().getUri(), null));
	}
	
	@Test
	public void whenPatientQueriedByName_andFuzzyNameSearchIsSet_thenPatientIsReturned() throws Exception {
		Name patientName = new Name(Name.builder().withName("Bergan").withFamily("Ovie").build());
		PdqSearchQuery query = PdqSearchQuery.builder().destination(dest).patientName(patientName).useFuzzyNameSearch(true).build();
		assertNotNull(this.wsClient.sendPdqSearchQueryRequest(query.build(), null, query.getDestination().getUri(), null));
	}
	
	@Test //This test will not find an existing patient but runs smooth. See querying by mother's maiden name.
	public void whenPatientQueriedByMothersMaidenName_thenPatientIsReturned() throws Exception {
		Name mothersMaidenName = new Name(Name.builder().withName("Bergan").withFamily("Ovie").build());
		PdqSearchQuery query = PdqSearchQuery.builder().destination(dest).mothersMaidenName(mothersMaidenName).build();
		assertNotNull(this.wsClient.sendPdqSearchQueryRequest(query.build(), null, query.getDestination().getUri(), null));
	}
	
	@Test //This test will not find an existing patient but runs smooth. See querying by mother's maiden name.
	public void whenPatientQueriedByMothersMaidenName_andFuzzyNameSearchIsSet_thenPatientIsReturned() throws Exception {
		Name mothersMaidenName = new Name(Name.builder().withName("Bergan").withFamily("Ovie").build());
		PdqSearchQuery query = PdqSearchQuery.builder().destination(dest).mothersMaidenName(mothersMaidenName).useFuzzyNameSearch(true).build();
		assertNotNull(this.wsClient.sendPdqSearchQueryRequest(query.build(), null, query.getDestination().getUri(), null));
	}
	
	@Test
	public void whenPatientQueriedByID_thenPatientIsReturned() throws Exception {
		Identificator identificator = new Identificator("1.3.6.1.4.1.12559.11.20.1", "4711");
		PdqSearchQuery query = PdqSearchQuery.builder().destination(dest).identificator(identificator).build();
		assertNotNull(this.wsClient.sendPdqSearchQueryRequest(query.build(), null, query.getDestination().getUri(), null));
	}
	
	@Test
	public void whenPatientQueriedByPatientAddress_thenPatientIsReturned() throws Exception {
		Address adress = new Address(Address.builder().withCity("Bern").build());
		PdqSearchQuery query = PdqSearchQuery.builder().destination(dest).patientAddress(adress).build();
		assertNotNull(this.wsClient.sendPdqSearchQueryRequest(query.build(), null, query.getDestination().getUri(), null));
	}
	
	@Test
	public void whenPatientQueriedByDateOfBirth_thenPatientIsReturned() throws Exception {
		Date patientBirthDay = new GregorianCalendar(1975, 3, 25).getTime();
		PdqSearchQuery query = PdqSearchQuery.builder().destination(dest).patientDateOfBirth(patientBirthDay).build();
		assertNotNull(this.wsClient.sendPdqSearchQueryRequest(query.build(), null, query.getDestination().getUri(), null));
	}
	
	@Test
	public void whenPatientQueriedByGender_thenPatientIsReturned() throws Exception {
		PdqSearchQuery query = PdqSearchQuery.builder().destination(dest).patientGender(AdministrativeGender.MALE).build();
		assertNotNull(this.wsClient.sendPdqSearchQueryRequest(query.build(), null, query.getDestination().getUri(), null));
	}
	
	@Test
	public void whenPatientQueriedByTelecomContact_thenPatientIsReturned() throws Exception {
		Telecom telecomContact = new Telecom();
		telecomContact.setPhone("754-3210"); //This also sets the "system" type of the telecom contact to "tel"
		PdqSearchQuery query = PdqSearchQuery.builder().destination(dest).telecomContact(telecomContact).build();
		assertNotNull(this.wsClient.sendPdqSearchQueryRequest(query.build(), null, query.getDestination().getUri(), null));
	}
	
	@Test
	public void whenDomainsToReturnAreSet_andSentAsQuery_thenNoErrorIsThrown() throws Exception {
		PdqSearchQuery query = PdqSearchQuery.builder().destination(dest).domainToReturn("2.3.4.5").domainToReturn("3.4.5.6").build();
		assertNotNull(this.wsClient.sendPdqSearchQueryRequest(query.build(), null, query.getDestination().getUri(), null));
	}

}
