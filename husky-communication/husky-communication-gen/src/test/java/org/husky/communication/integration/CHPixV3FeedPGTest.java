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
package org.husky.communication.integration;


import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.context.FhirVersionEnum;
import org.hl7.fhir.r4.model.*;
import org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem;
import org.hl7.fhir.r4.model.ContactPoint.ContactPointUse;
import org.hl7.fhir.r4.model.Enumerations.AdministrativeGender;
import org.hl7.fhir.r4.model.HumanName.NameUse;
import org.hl7.fhir.r4.model.Patient.PatientCommunicationComponent;
import org.hl7.fhir.r4.model.codesystems.V3MaritalStatus;
import org.husky.common.communication.AffinityDomain;
import org.husky.common.communication.Destination;
import org.husky.common.enums.CountryCode;
import org.husky.communication.ConvenienceMasterPatientIndexV3;
import org.husky.communication.mpi.impl.PixV3Query;
import org.husky.communication.testhelper.TestApplication;
import org.husky.fhir.structures.gen.FhirCommon;
import org.husky.fhir.structures.gen.FhirPatient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openehealth.ipf.commons.audit.AuditContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.net.URI;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 *
 */
@ExtendWith(value = SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = { TestApplication.class })
@EnableAutoConfiguration
class CHPixV3FeedPGTest {


	/** The SLF4J logger instance. */
	protected static Logger LOGGER = LoggerFactory.getLogger(CHPixV3FeedPGTest.class);

	@Autowired
	private ConvenienceMasterPatientIndexV3 convenienceMasterPatientIndexV3Client;

	@Autowired
	protected AuditContext auditContext;

	final private String pixUri = "https://epdplayground.i4mi.bfh.ch:7443/PIXPDQ/services/PIXPDQV3ManagerService";
	final String facilityName = "Waldspital Bern"; // "2.16.840.1.113883.3.72.6.1";

	final String receiverApplicationOid = "1.1.1.99.1";
	final String senderApplicationOid = "1.2.3.4.123456";

	// local ID settings
	final String localAssigningAuthorityOid = "1.2.3.4.123456.1";
	final String localIdNamespace = "WALDSPITAL";
	final String localId = "waldspital-Id-1234";

	// EPR-SPID settings
	final String spidAssigningAuthorityOid = "2.16.756.5.30.1.127.3.10.3";
	final String spidNamespace = "SPID";
	final String eprSPID = "761337637673823141";

	/**
	 * @throws Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		var app = new SpringApplication(TestApplication.class);
		app.setWebApplicationType(WebApplicationType.NONE);
		app.run();
	}

	/**
	 *
	 */
	@Test
	void feedTest() throws Exception {

		final AffinityDomain affinityDomain = new AffinityDomain();
		final Destination dest = new Destination();

		dest.setUri(URI.create(pixUri));
		dest.setSenderApplicationOid(senderApplicationOid);
		dest.setReceiverApplicationOid(receiverApplicationOid);
		dest.setReceiverFacilityOid(facilityName);
		affinityDomain.setPdqDestination(dest);
		affinityDomain.setPixDestination(dest);

		PixV3Query pixV3Query = new PixV3Query(affinityDomain, localAssigningAuthorityOid, localIdNamespace, spidAssigningAuthorityOid, spidNamespace,
				convenienceMasterPatientIndexV3Client.getContext(),
				convenienceMasterPatientIndexV3Client.getAuditContext());

		final FhirPatient patient = new FhirPatient();

		// the local ID
		final Identifier identifier = new Identifier();
		identifier.setValue(localId);
		identifier.setSystem(FhirCommon.addUrnOid(localAssigningAuthorityOid));
		patient.getIdentifier().add(identifier);

		// the EPR SPID
		final Identifier identifier2 = new Identifier();
		identifier2.setValue(eprSPID);
		identifier2.setSystem(spidAssigningAuthorityOid);
		patient.getIdentifier().add(identifier2);

		final HumanName humanName = new HumanName().setFamily("Piazza-Baumann").addGiven("Eliane").setUse(NameUse.OFFICIAL);
		patient.getName().add(humanName);
		patient.setBirthDate(new SimpleDateFormat("dd.MM.yyyy").parse("15.01.1967"));
		patient.setGender(AdministrativeGender.FEMALE);
		
		final CodeableConcept nation = new CodeableConcept();
		nation.setText(CountryCode.SWITZERLAND.getCodeAlpha3());
		patient.setNation(nation);
		
		patient.getManagingOrganization().setResource(getScopingOrganization());

		final FhirContext ctx = new FhirContext(FhirVersionEnum.R4);
		final String encoded = ctx.newXmlParser().encodeResourceToString(patient);
		LOGGER.debug(encoded);

		assertTrue(pixV3Query.addPatient(patient, null, null));

	}

	private Organization getScopingOrganization() {
		final Organization org = new Organization();
		final Identifier identifier = new Identifier();
		identifier.setValue("Husky");
		identifier.setSystem(FhirCommon.addUrnOid(localAssigningAuthorityOid));
		org.getIdentifier().add(identifier);
		return org;
	}

}
