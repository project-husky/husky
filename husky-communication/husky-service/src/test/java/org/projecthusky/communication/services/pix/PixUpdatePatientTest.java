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

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

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
import org.projecthusky.communication.requests.pix.PixUpdatePatientFeed;
import org.projecthusky.communication.TestApplication;
import org.projecthusky.communication.services.HuskyService;
import org.projecthusky.fhir.structures.gen.FhirCommon;
import org.projecthusky.xua.exceptions.SerializeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = { TestApplication.class })
@ActiveProfiles("atna")
public class PixUpdatePatientTest {

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
	public void updatePatient() throws ParseException, JAXBException, SerializeException, ParserConfigurationException, IOException {
		Organization organization = new Organization().addIdentifier(new Identifier().setValue("Husky").setSystem(FhirCommon.addUrnOid(homeCommunityOid)));
		PixUpdatePatientFeed feed = this.service.createPixUpdatePatientFeed(testWSDestination, organization)
			.identifier(new Identifier().setValue("1634793774730").setSystem(FhirCommon.addUrnOid(homeCommunityOid)))
			.identifier(new Identifier().setValue("SPID-101").setSystem(spidEprOid))
			.patientName(new HumanName().setFamily("Anton").addGiven("Bauer-Maier").addPrefix("Dr.").addSuffix("Msc.").setUse(NameUse.OFFICIAL))
			.birthday(new SimpleDateFormat("dd.MM.yyyy").parse("24.04.1955"))
			.gender(AdministrativeGender.MALE)
			.mothersMaidenName(new HumanName().setFamily("Müllers"))
			.address(new Address().addLine("Testgasse 88").setPostalCode("1020").setCity("Wien").setState("Wien").addLine("Eingang 2, Tür 34").setCountry("AUT"))
			.nation(new CodeableConcept().setText(CountryCode.AUSTRIA.getCodeAlpha3()))
			.religion(new CodeableConcept().setText("Agnostic"))
			.maritalStatus(new CodeableConcept().addCoding(new Coding(null, V3MaritalStatus.M.toCode(), V3MaritalStatus.M.getDisplay())))
			.language(new CodeableConcept().setText("de-AT"))
			.language(new CodeableConcept().setText("en"))
			.telecomContact(new ContactPoint().setUse(ContactPointUse.HOME).setSystem(ContactPointSystem.PHONE).setValue("+4366793385111"))
			.telecomContact(new ContactPoint().setUse(ContactPointUse.WORK).setSystem(ContactPointSystem.PHONE).setValue("+4366793385222"))
			.telecomContact(new ContactPoint().setUse(ContactPointUse.MOBILE).setSystem(ContactPointSystem.PHONE).setValue("+4366793384433"))
			.telecomContact(new ContactPoint().setUse(ContactPointUse.WORK).setSystem(ContactPointSystem.EMAIL).setValue("anton.chiguhr@texasstate.us"))
			.employeeOccupation(new CodeableConcept().setText("Chief Solver"))
			.build();
		assertTrue(this.service.send(feed));
	}

	/**
	 * <b>WARNING!</b></br>
	 * As stated in the documentation, this will remove all other infos about a patient than the IDs and the organization providing it. Use like this only for testing purposes!
	 */
	@Test
	@Disabled("This test is disabled because how the webservice works (replace vs. update, see query documentation), but is fully working if enabled.")
	public void updatePatientWithAbsoluteMinimalInformation() throws JAXBException, SerializeException, ParserConfigurationException, IOException {
		Organization organization = new Organization().addIdentifier(new Identifier().setValue("Husky").setSystem(FhirCommon.addUrnOid(homeCommunityOid)));
		PixUpdatePatientFeed feed = this.service.createPixUpdatePatientFeed(testWSDestination, organization)
			.identifier(new Identifier().setValue("1634793774730").setSystem(FhirCommon.addUrnOid(homeCommunityOid)))
			.identifier(new Identifier().setValue("SPID-101").setSystem(spidEprOid))
			.build();
		assertTrue(this.service.send(feed));
	}

}
