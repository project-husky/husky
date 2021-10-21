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
package org.ehealth_connector.communication.mpi.impl;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.ehealth_connector.common.communication.AffinityDomain;
import org.ehealth_connector.common.communication.Destination;
import org.ehealth_connector.common.utils.DateUtil;
import org.ehealth_connector.communication.ConvenienceMasterPatientIndexV3;
import org.ehealth_connector.communication.testhelper.TestApplication;
import org.ehealth_connector.fhir.structures.gen.FhirCommon;
import org.ehealth_connector.fhir.structures.gen.FhirPatient;
import org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGender;
import org.hl7.fhir.dstu3.model.HumanName;
import org.hl7.fhir.dstu3.model.Identifier;
import org.hl7.fhir.dstu3.model.Organization;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.context.FhirVersionEnum;

/**
 * See https://pixpdqtests.nist.gov/pixpdqtool/ IHE PIX and PDQ Pre-Connectathon
 * Test Tool
 *
 * Configuration for 2015 Europe
 *
 * Application Name: provided by test tool Facility Name: provided by test tool
 * IP Address: provided by test tool Port Number: V3 Message (Non Secure: 9090 )
 *
 * ATTENTION: You need to start the testtool and need to get the parameters from
 * webpage otherwise the test will not run through, you need also to remove
 * the @Ignore to perform the tests directly
 */
@ExtendWith(value = SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = { TestApplication.class })
@EnableAutoConfiguration
public class PixV3QueryTest {

	/** The SLF4J logger instance. */
	protected static Logger log = LoggerFactory.getLogger(PixV3QueryTest.class);

	@Autowired
	private ConvenienceMasterPatientIndexV3 convenienceMasterPatientIndexV3Client;

	@Autowired
	protected AuditContext auditContext;

	// note: fill below in from test tool before running test and remove @Ignore
	// Annotation above to run the tests manual
	final private String pixUri = "https://ehealthsuisse.ihe-europe.net/PAMSimulator-ejb/PIXManager_Service/PIXManager_PortType";

	final private String facilityName = null; // "2.16.840.1.113883.3.72.6.1";

	final private String receiverApplicationOid = "1.3.6.1.4.1.12559.11.20.1.10";
	final private String senderApplicationOid = "1.2.3.4";

	final private String homeCommunityOid = "1.3.6.1.4.1.12559.11.20.1";
	final private String homeCommunityNamespace = "CHPAM2";

	final private String domainToReturnOid = "2.16.756.5.30.1.127.3.10.3";
	final private String domainToReturnNamespace = "SPID";

	private Organization getScopingOrganization() {
		final Organization org = new Organization();
		final Identifier identifier = new Identifier();
		identifier.setValue("eHealth Connector");
		identifier.setSystem(FhirCommon.addUrnOid(homeCommunityOid));
		org.getIdentifier().add(identifier);
		return org;
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
		assertNotNull(auditContext);
	}

	/**
	 * The purpose of this test is to check that your PIX Source can send a valid
	 * feed message (Patient Registry Record Added : PRPA_IN201301UV02). Your PIX
	 * Source is required to register a patient in domain 1.3.6.1.4.1.12559.11.20.1
	 * (CHPAM2).
	 *
	 * Send a valid feed message (PRPA_IN201301UV02) to the PIX Manager. The message
	 * shall contain patient Huber (last name) Franz (first name) with ID PIX in
	 * domain CHPAM2. The NIST PIX Manager sends back an acknowledgement
	 * (MCCI_IN000002UV01) back to your PIX Source.
	 */
	/*
	@Test
    @Disabled	
	public void ITI44SourceFeedTest() {

		log.debug("ITI44SourceFeedTest with target " + pixUri);

		final AffinityDomain affinityDomain = new AffinityDomain();
		final Destination dest = new Destination();

		dest.setUri(URI.create(pixUri));
		dest.setSenderApplicationOid(senderApplicationOid);
		dest.setReceiverApplicationOid(receiverApplicationOid);
		dest.setReceiverFacilityOid(facilityName);
		affinityDomain.setPdqDestination(dest);
		affinityDomain.setPixDestination(dest);

		PixV3Query pixV3Query = new PixV3Query(affinityDomain, homeCommunityOid, homeCommunityNamespace, null, null,
				convenienceMasterPatientIndexV3Client.getContext(),
				convenienceMasterPatientIndexV3Client.getAuditContext());

		final FhirPatient patient = new FhirPatient();
		final HumanName humanName = new HumanName().setFamily("Maier").addGiven("Hubert");
		patient.getName().add(humanName);
		final org.hl7.fhir.dstu3.model.Address address = new org.hl7.fhir.dstu3.model.Address()
				.addLine("Testgasse 15").setPostalCode("1020").setCity("Wien").setState("AUT");
		final Identifier identifier = new Identifier();

		identifier.setValue(String.valueOf(System.currentTimeMillis()));
		identifier.setSystem(homeCommunityOid);
		patient.getIdentifier().add(identifier);
	
		final Identifier identifier2 = new Identifier();
		identifier2.setValue("SPID"+String.valueOf(System.currentTimeMillis()));
		identifier2.setSystem(domainToReturnOid);
		patient.getIdentifier().add(identifier2);
		
		
		try {
			patient.setBirthDate(new SimpleDateFormat("dd.MM.yyyy").parse("24.03.1950"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		patient.getAddress().add(address);
		patient.setGender(AdministrativeGender.MALE);
		patient.getManagingOrganization().setResource(getScopingOrganization());
		

		final FhirContext ctx = new FhirContext(FhirVersionEnum.DSTU3);
		final String encoded = ctx.newXmlParser().encodeResourceToString(patient);
		log.debug(encoded);

		assertTrue(pixV3Query.addPatient(patient, null));
		
	}*/
	
	
	@Test
	
	public void ITI44SourceFeedTestPatToMerge() {

		log.debug("ITI44SourceFeedTest with target " + pixUri);

		final AffinityDomain affinityDomain = new AffinityDomain();
		final Destination dest = new Destination();

		dest.setUri(URI.create(pixUri));
		dest.setSenderApplicationOid(senderApplicationOid);
		dest.setReceiverApplicationOid(receiverApplicationOid);
		dest.setReceiverFacilityOid(facilityName);
		affinityDomain.setPdqDestination(dest);
		affinityDomain.setPixDestination(dest);

		PixV3Query pixV3Query = new PixV3Query(affinityDomain, homeCommunityOid, homeCommunityNamespace, null, null,
				convenienceMasterPatientIndexV3Client.getContext(),
				convenienceMasterPatientIndexV3Client.getAuditContext());

		final FhirPatient patient = new FhirPatient();
		final HumanName humanName = new HumanName().setFamily("Bauer").addGiven("Anton");
		patient.getName().add(humanName);
		final org.hl7.fhir.dstu3.model.Address address = new org.hl7.fhir.dstu3.model.Address()
				.addLine("Traisengasse 1").setPostalCode("1200").setCity("Wien").setState("AUT");
		final Identifier identifier = new Identifier();

		identifier.setValue(String.valueOf(System.currentTimeMillis()));
		identifier.setSystem(homeCommunityOid);
		patient.getIdentifier().add(identifier);
	
		final Identifier identifier2 = new Identifier();
		identifier2.setValue("SPID-100");
		identifier2.setSystem(domainToReturnOid);
		patient.getIdentifier().add(identifier2);
		
		
		try {
			patient.setBirthDate(new SimpleDateFormat("dd.MM.yyyy").parse("24.03.1950"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		patient.getAddress().add(address);
		patient.setGender(AdministrativeGender.MALE);
		patient.getManagingOrganization().setResource(getScopingOrganization());
		

		final FhirContext ctx = new FhirContext(FhirVersionEnum.DSTU3);
		final String encoded = ctx.newXmlParser().encodeResourceToString(patient);
		log.debug(encoded);

		assertTrue(pixV3Query.addPatient(patient, null));
		
	}


	/**
	 * The purpose of this test is to check that your PIX Source can send an merge
	 * message (Patient Registry Duplicates Resolved : PRPA_IN201304UV02).
	 *
	 * Send a valid merge message (PRPA_IN201304UV02) to the PIX Manager. The
	 * message shall contain patient Maier Hubert in domain CHPAM2 replacement
	 * of ID 1630332840196 (Maier Hubertus) in domain CHPAM2. The PIX Manager sends an
	 * acknowledgement (MCCI_IN000002UV01) back to your PIX Source.
	 */
	/*
	@Test
	public void ITI44SourceMergeTest() {
		log.debug("ITI44SourceMergeTest with target {}", pixUri);

		final AffinityDomain affinityDomain = new AffinityDomain();
		final Destination dest = new Destination();

		dest.setUri(URI.create(pixUri));
		dest.setSenderApplicationOid(senderApplicationOid);
		dest.setReceiverApplicationOid(receiverApplicationOid);
		dest.setReceiverFacilityOid(facilityName);
		affinityDomain.setPdqDestination(dest);
		affinityDomain.setPixDestination(dest);

		PixV3Query pixV3Query = new PixV3Query(affinityDomain, homeCommunityOid, homeCommunityNamespace, null, null,
				convenienceMasterPatientIndexV3Client.getContext(),
				convenienceMasterPatientIndexV3Client.getAuditContext());

		final FhirPatient patient = new FhirPatient();
		final HumanName humanName = new HumanName().setFamily("Maier").addGiven("Hubert");
		patient.getName().add(humanName);
		final org.hl7.fhir.dstu3.model.Address address = new org.hl7.fhir.dstu3.model.Address()
				.addLine("Testgasse 15").setPostalCode("1020").setCity("Wien").setState("AUT");
		final Identifier identifier = new Identifier();
		identifier.setValue(String.valueOf(System.currentTimeMillis()));
		identifier.setSystem(FhirCommon.addUrnOid(homeCommunityOid));
		patient.getIdentifier().add(identifier);
		patient.setBirthDate(DateUtil.parseDateyyyyMMdd("19771208"));
		patient.getAddress().add(address);
		patient.setGender(AdministrativeGender.MALE);
		patient.getManagingOrganization().setResource(getScopingOrganization());

		final FhirContext ctx = new FhirContext(FhirVersionEnum.DSTU3);
		final String encoded = ctx.newXmlParser().encodeResourceToString(patient);
		log.debug(encoded);

		assertTrue(pixV3Query.mergePatient(patient, "1630334309175", null));
	}*/

	//@Test
	/*
	public void ITI44SourceUpdateTest() {
		final AffinityDomain affinityDomain = new AffinityDomain();
		final Destination dest = new Destination();

		dest.setUri(URI.create(pixUri));
		dest.setSenderApplicationOid(senderApplicationOid);
		dest.setReceiverApplicationOid(receiverApplicationOid);
		dest.setReceiverFacilityOid(facilityName);
		affinityDomain.setPdqDestination(dest);
		affinityDomain.setPixDestination(dest);

		PixV3Query pixV3Query = new PixV3Query(affinityDomain, homeCommunityOid, homeCommunityNamespace, null, null,
				convenienceMasterPatientIndexV3Client.getContext(),
				convenienceMasterPatientIndexV3Client.getAuditContext());


		final FhirPatient patient = new FhirPatient();
		final HumanName humanName = new HumanName().setFamily("Huber").addGiven("Franz");
		patient.getName().add(humanName);
		final org.hl7.fhir.dstu3.model.Address address = new org.hl7.fhir.dstu3.model.Address()
				.addLine("Testgasse 18").setPostalCode("1020").setCity("Wien").setState("AUT");
		final Identifier identifier = new Identifier();
		identifier.setValue("1630334473749");
		identifier.setSystem(FhirCommon.addUrnOid(homeCommunityOid));
		patient.getIdentifier().add(identifier);

		patient.setBirthDate(DateUtil.parseDateyyyyMMdd("19550224"));
		patient.getAddress().add(address);
		patient.setGender(AdministrativeGender.MALE);
		patient.getManagingOrganization().setResource(getScopingOrganization());

		final FhirContext ctx = new FhirContext(FhirVersionEnum.DSTU3);
		final String encoded = ctx.newXmlParser().encodeResourceToString(patient);
		log.debug(encoded);

		assertTrue(pixV3Query.updatePatient(patient, null));
	}*/

	/*
	@Test
	public void ITI45ConsumerTest() {

		log.debug("ITI45ConsumerTest with target " + pixUri);
		final AffinityDomain affinityDomain = new AffinityDomain();
		final Destination dest = new Destination();

		dest.setUri(URI.create(pixUri));
		dest.setSenderApplicationOid(senderApplicationOid);
		dest.setReceiverApplicationOid(receiverApplicationOid);
		dest.setReceiverFacilityOid(facilityName);
		affinityDomain.setPdqDestination(dest);
		affinityDomain.setPixDestination(dest);

		PixV3Query pixV3Query = new PixV3Query(affinityDomain, homeCommunityOid, homeCommunityNamespace,
				domainToReturnOid, domainToReturnNamespace,
				convenienceMasterPatientIndexV3Client.getContext(),
				convenienceMasterPatientIndexV3Client.getAuditContext());

		final FhirPatient patient = new FhirPatient();
		final Identifier identifier = new Identifier();
		identifier.setValue("CHPAM4489");
		identifier.setSystem(FhirCommon.addUrnOid(homeCommunityOid));
		patient.getIdentifier().add(identifier);

		String patId = pixV3Query.queryPatientId(patient, null);

		assertEquals("761337610436974489", patId);
	}*/

}
