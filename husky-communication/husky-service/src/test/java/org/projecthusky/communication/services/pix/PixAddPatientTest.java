/*
 * This code is made available under the terms of the Eclipse Public License v1.0 
 * in the github project https://github.com/project-husky/husky there you also 
 * find a list of the contributors and the license information.
 * 
 * This project has been developed further and modified by the joined working group Husky 
 * on the basis of the eHealth Connector opensource project from June 28, 2021, 
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.communication.services.pix;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.net.URI;
import java.text.SimpleDateFormat;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.ws.soap.SOAPFaultException;

import org.hl7.fhir.r4.model.Address;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.ContactPoint;
import org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem;
import org.hl7.fhir.r4.model.ContactPoint.ContactPointUse;
import org.hl7.fhir.r4.model.Enumerations.AdministrativeGender;
import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.model.HumanName.NameUse;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Organization;
import org.hl7.fhir.r4.model.codesystems.V3MaritalStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.projecthusky.common.communication.Destination;
import org.projecthusky.common.enums.CountryCode;
import org.projecthusky.communication.requests.pix.PixAddPatientFeed;
import org.projecthusky.communication.config.IpfApplicationConfig;
import org.projecthusky.communication.TestApplication;
import org.projecthusky.communication.services.HuskyService;
import org.projecthusky.fhir.structures.gen.FhirCommon;
import org.projecthusky.xua.exceptions.SerializeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = { TestApplication.class, IpfApplicationConfig.class })
@ActiveProfiles("atna")
public class PixAddPatientTest {
	@Value(value = "${test.pixq.uri:https://ehealthsuisse.ihe-europe.net/PAMSimulator-ejb/PIXManager_Service/PIXManager_PortType}")
	private String searchWebServiceUri;
	
	@Autowired
	private HuskyService service;
	
	private Destination testWSDestination;
	
	final private String homeCommunityOid = "1.3.6.1.4.1.12559.11.20.1";
	
	final private String spidEprOid = "2.16.756.5.30.1.127.3.10.3";
	
	@BeforeEach
	public void setUp() {
		String senderApplicationOidTestValue = "1.2.3.4";
		String receiverApplicationOid = "1.3.6.1.4.1.12559.11.20.1.10";
		this.testWSDestination = new Destination();
		this.testWSDestination.setUri(URI.create(searchWebServiceUri));
		this.testWSDestination.setSenderApplicationOid(senderApplicationOidTestValue);
		this.testWSDestination.setReceiverApplicationOid(receiverApplicationOid);
	}
	
	@Test
	public void addPatient() throws Exception {
		Organization organization = new Organization().addIdentifier(new Identifier().setValue("Husky").setSystem(FhirCommon.addUrnOid(homeCommunityOid)));
		PixAddPatientFeed query = this.service.createPixAddPatientFeed(testWSDestination, organization)
			.identifier(new Identifier().setValue(String.valueOf(System.currentTimeMillis())).setSystem(FhirCommon.addUrnOid(homeCommunityOid)))
			.identifier(new Identifier().setValue(String.valueOf(System.currentTimeMillis())).setSystem(spidEprOid))
			.patientName(new HumanName().setFamily("Anders").addGiven("Miriam").addGiven("Maria").addPrefix("Dr.").addSuffix("Msc.").setUse(NameUse.OFFICIAL))
			.birthday(new SimpleDateFormat("dd.MM.yyyy").parse("24.03.1950"))
			.gender(AdministrativeGender.OTHER)
			.mothersMaidenName(new HumanName().setFamily("Müllers"))
			.address(new Address().addLine("Hauptstrasse 11").setPostalCode("3002").setCity("Purkersdorf").setState("Niederösterreich").addLine("Eingang 2, Tür 34").setCountry("AUT"))
			.nation(new CodeableConcept().setText(CountryCode.AUSTRIA.getCodeAlpha3()))
			.religion(new CodeableConcept().setText("Agnostic"))
			.maritalStatus(new CodeableConcept().addCoding(new Coding(null, V3MaritalStatus.S.toCode(), V3MaritalStatus.S.getDisplay())))
			.language(new CodeableConcept().setText("de-AT"))
			.language(new CodeableConcept().setText("en"))
			.telecomContact(new ContactPoint().setUse(ContactPointUse.HOME).setSystem(ContactPointSystem.PHONE).setValue("+4366793384455"))
			.telecomContact(new ContactPoint().setUse(ContactPointUse.WORK).setSystem(ContactPointSystem.PHONE).setValue("+4366793384400"))
			.telecomContact(new ContactPoint().setUse(ContactPointUse.MOBILE).setSystem(ContactPointSystem.PHONE).setValue("+4366793384433"))
			.telecomContact(new ContactPoint().setUse(ContactPointUse.WORK).setSystem(ContactPointSystem.EMAIL).setValue("sunshine@garten.at"))
			.employeeOccupation(new CodeableConcept().setText("Senior Lamp Technicial"))
			.build();
		assertTrue(this.service.send(query));
	}
	
	@Test
	public void addMinimalPatient() throws JAXBException, SerializeException, ParserConfigurationException, IOException {
		Organization organization = new Organization().addIdentifier(new Identifier().setValue("Husky").setSystem(FhirCommon.addUrnOid(homeCommunityOid)));
		PixAddPatientFeed query = this.service.createPixAddPatientFeed(testWSDestination, organization)
				.identifier(new Identifier().setValue(String.valueOf(System.currentTimeMillis())).setSystem(FhirCommon.addUrnOid(homeCommunityOid)))
				.identifier(new Identifier().setValue(String.valueOf(System.currentTimeMillis())).setSystem(spidEprOid))
				.patientName(new HumanName().setFamily("Anders").addGiven("Miriam").addGiven("Maria").addPrefix("Dr.").addSuffix("Msc.").setUse(NameUse.OFFICIAL))
				.build();
			assertTrue(this.service.send(query));
	}
	
	@Test
	@Disabled("This test is to prove that adding a patient without a name works (unfortunately).")
	public void addSubminimalPatient() throws JAXBException, SerializeException, ParserConfigurationException, IOException {
		Organization organization = new Organization().addIdentifier(new Identifier().setValue("Husky").setSystem(FhirCommon.addUrnOid(homeCommunityOid)));
		PixAddPatientFeed query = this.service.createPixAddPatientFeed(testWSDestination, organization)
				.identifier(new Identifier().setValue(String.valueOf(System.currentTimeMillis())).setSystem(FhirCommon.addUrnOid(homeCommunityOid)))
				.identifier(new Identifier().setValue(String.valueOf(System.currentTimeMillis())).setSystem(spidEprOid))
				.build();
			assertTrue(this.service.send(query));
	}
	
	@Test
	public void addSubminimalPatient_notEvenID() {
		RuntimeException exception = assertThrows(RuntimeException.class, () -> {
			PixAddPatientFeed query = this.service.createPixAddPatientFeed(testWSDestination,
					new Organization().addIdentifier(new Identifier().setValue("Husky").setSystem(FhirCommon.addUrnOid(homeCommunityOid))))
					.identifier(new Identifier().setValue(String.valueOf(System.currentTimeMillis())).setSystem(FhirCommon.addUrnOid(homeCommunityOid)))
					.build();
			assertTrue(this.service.send(query));
		});
		assertTrue(exception.getCause() instanceof SOAPFaultException);
		assertEquals("javax.xml.ws.soap.SOAPFaultException: A patient must contain exactly 2 patient identifier (1 provided)", exception.getMessage());
	}
	
	@Test
	@Disabled("This is a showcase test: what happens when the scoping organization is missing (SOAPFaultExpetion). Case is prevented by the current builder logic in the query.")
	public void addSubminimalPatient_noScopingOrganization() {
		RuntimeException exception = assertThrows(RuntimeException.class, () -> {
			PixAddPatientFeed query = this.service.createPixAddPatientFeed(testWSDestination, null)
					.identifier(new Identifier().setValue(String.valueOf(System.currentTimeMillis())).setSystem(FhirCommon.addUrnOid(homeCommunityOid)))
					.identifier(new Identifier().setValue(String.valueOf(System.currentTimeMillis())).setSystem(spidEprOid))
					.build();
			assertTrue(this.service.send(query));
		});
		assertTrue(exception.getCause() instanceof SOAPFaultException);
		assertEquals("javax.xml.ws.soap.SOAPFaultException: providerOrganization is missing", exception.getMessage());
	}
	
}
