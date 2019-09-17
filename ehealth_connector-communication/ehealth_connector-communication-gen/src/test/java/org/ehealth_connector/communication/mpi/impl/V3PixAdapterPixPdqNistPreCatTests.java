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

import static org.junit.Assert.assertTrue;

import java.net.URI;
import java.net.URISyntaxException;

import org.ehealth_connector.common.mdht.Identificator;
import org.ehealth_connector.common.utils.DateUtilMdht;
import org.ehealth_connector.communication.AffinityDomain;
import org.ehealth_connector.communication.ConvenienceMasterPatientIndexV3;
import org.ehealth_connector.communication.Destination;
import org.ehealth_connector.communication.MasterPatientIndexQuery;
import org.ehealth_connector.communication.MasterPatientIndexQueryResponse;
import org.ehealth_connector.fhir.structures.gen.FhirCommon;
import org.ehealth_connector.fhir.structures.gen.FhirPatient;
import org.hl7.fhir.dstu3.model.Enumerations.AdministrativeGender;
import org.hl7.fhir.dstu3.model.HumanName;
import org.hl7.fhir.dstu3.model.Identifier;
import org.hl7.fhir.dstu3.model.Organization;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
@Ignore
public class V3PixAdapterPixPdqNistPreCatTests {

	/** The SLF4J logger instance. */
	protected static Logger log = LoggerFactory.getLogger(V3PixAdapterPixPdqNistPreCatTests.class);

	private V3PixPdqAdapter v3PixPdqAdapter;
	private V3PixPdqAdapterConfig v3PixPdqAdapterCfg;

	// note: fill below in from test tool before running test and remove @Ignore
	// Annotation above to run the tests manual
	final private String applicationName = "2.16.840.1.113883.3.72.6.5.100.1399";
	final private String ipAddress = "129.6.24.81";
	final private String facilityName = null; // "2.16.840.1.113883.3.72.6.1";

	final private String senderApplicationOid = "1.2.3.4";

	final private String homeCommunityOid = "2.16.840.1.113883.3.72.5.9.1";
	final private String homeCommunityNamespace = "NIST2010";

	final private String domainToReturnOid = "2.16.840.1.113883.3.72.5.9.3";
	final private String domainToReturnNamespace = "NIST2010-3";

	private Organization getScopingOrganization() {
		final Organization org = new Organization();
		final Identifier identifier = new Identifier();
		identifier.setValue("OHT");
		identifier.setSystem(FhirCommon.addUrnOid(homeCommunityOid));
		org.getIdentifier().add(identifier);
		return org;
	}

	/**
	 * The purpose of this test is to check that your PIX Source can send a
	 * valid feed message (Patient Registry Record Added : PRPA_IN201301UV02).
	 * Your PIX Source is required to register a patient in domain
	 * 2.16.840.1.113883.3.72.5.9.1 (NIST2010).
	 *
	 * Send a valid feed message (PRPA_IN201301UV02) to the NIST PIX Manager.
	 * The message shall contain patient ALPHA (last name) ALAN (first name)
	 * with ID PIX in domain NIST2010. The NIST PIX Manager sends back an
	 * acknowledgement (MCCI_IN000002UV01) back to your PIX Source.
	 */
	@Test
	public void ITI44SourceFeedTest() {

		log.debug("ITI44SourceFeedTest with ipAdress Target " + ipAddress);
		v3PixPdqAdapterCfg = new V3PixPdqAdapterConfig(null,
				URI.create("http://" + ipAddress + ":9090"), null, senderApplicationOid, null,
				applicationName, facilityName, homeCommunityOid, homeCommunityNamespace, null, null,
				null, null, null, null);
		v3PixPdqAdapter = new V3PixPdqAdapter(v3PixPdqAdapterCfg);

		// ALPHA ALAN
		final FhirPatient patient = new FhirPatient();
		final HumanName humanName = new HumanName().setFamily("ALPHA").addGiven("ALAN");
		patient.getName().add(humanName);
		final org.hl7.fhir.dstu3.model.Address address = new org.hl7.fhir.dstu3.model.Address()
				.addLine("1 PINETREE").setPostalCode("63119").setCity("WEBSTER").setState("MO");
		final Identifier identifier = new Identifier();
		identifier.setValue("PIX");
		identifier.setSystem(FhirCommon.addUrnOid(homeCommunityOid));
		patient.getIdentifier().add(identifier);
		patient.setBirthDate(DateUtilMdht.date("19380224"));
		patient.getAddress().add(address);
		patient.setGender(AdministrativeGender.MALE);
		patient.getManagingOrganization().setResource(getScopingOrganization());

		final FhirContext ctx = new FhirContext(FhirVersionEnum.DSTU3);
		final String encoded = ctx.newXmlParser().encodeResourceToString(patient);
		log.debug(encoded);

		assertTrue(v3PixPdqAdapter.addPatient(patient));
	}

	/**
	 * The purpose of this test is to check that your PIX Source can send an
	 * merge message (Patient Registry Duplicates Resolved : PRPA_IN201304UV02).
	 *
	 * Send a valid merge message (PRPA_IN201304UV02) to the NIST PIX Manager.
	 * The message shall contain patient LINCOLN MARY with ID PIXL in domain
	 * NIST2010 in replacement of ID PIXW (MARY WASHINGTON) in domain NIST2010.
	 * The NIST PIX Manager sends an acknowledgement (MCCI_IN000002UV01) back to
	 * your PIX Source.
	 */
	@Test
	public void ITI44SourceMergeTest() {
		log.debug("ITI44SourceMergeTest with ipAdress Target " + ipAddress);

		v3PixPdqAdapterCfg = new V3PixPdqAdapterConfig(null,
				URI.create("http://" + ipAddress + ":9090"), null, senderApplicationOid, null,
				applicationName, facilityName, homeCommunityOid, homeCommunityNamespace, null, null,
				null, null, null, null);
		v3PixPdqAdapter = new V3PixPdqAdapter(v3PixPdqAdapterCfg);

		// LINCOLN MARY
		final FhirPatient patient = new FhirPatient();
		final HumanName humanName = new HumanName().setFamily("LINCOLN").addGiven("MARY");
		patient.getName().add(humanName);
		final org.hl7.fhir.dstu3.model.Address address = new org.hl7.fhir.dstu3.model.Address()
				.addLine("100 JORIE BLVD").setPostalCode("60523").setCity("CHICAGO").setState("IL");
		final Identifier identifier = new Identifier();
		identifier.setValue("PIXL");
		identifier.setSystem(FhirCommon.addUrnOid(homeCommunityOid));
		patient.getIdentifier().add(identifier);
		patient.setBirthDate(DateUtilMdht.date("19771208"));
		patient.getAddress().add(address);
		patient.setGender(AdministrativeGender.FEMALE);
		patient.getManagingOrganization().setResource(getScopingOrganization());

		final FhirContext ctx = new FhirContext(FhirVersionEnum.DSTU3);
		final String encoded = ctx.newXmlParser().encodeResourceToString(patient);
		log.debug(encoded);

		assertTrue(v3PixPdqAdapter.mergePatient(patient, "PIXW"));
	}

	/*
	 * 2/19/15 7:33:13 AM - Test: ITI-44-Source-Feed , Step: 1 2/19/15 7:33:13
	 * AM - 2.16.840.1.113883.3.72.6.5.100.1055 / null configuration started
	 * 2/19/15 7:33:14 AM - 2.16.840.1.113883.3.72.6.5.100.1055 / null
	 * configuration finished 2/19/15 7:33:14 AM - Waiting for the incoming
	 * message...time elapsed=0s, time left=120s 2/19/15 7:33:34 AM - Incoming
	 * message received from 1.2.3.4 / null <v3:PRPA_IN201301UV02
	 * ITSVersion="XML_1.0" xmlns:v3="urn:hl7-org:v3"> <v3:id
	 * root="1.2.3.4.103000030016104137.1424349214353.1"/> <v3:creationTime
	 * value="20150219133334"/> <v3:interactionId extension="PRPA_IN201301UV02"
	 * root="2.16.840.1.113883.1.6"/> <v3:processingCode code="P"/>
	 * <v3:processingModeCode code="T"/> <v3:acceptAckCode code="AL"/>
	 * <v3:receiver typeCode="RCV"> <v3:device classCode="DEV"
	 * determinerCode="INSTANCE"> <v3:id
	 * root="2.16.840.1.113883.3.72.6.5.100.1055"/> </v3:device> </v3:receiver>
	 * <v3:sender typeCode="SND"> <v3:device classCode="DEV"
	 * determinerCode="INSTANCE"> <v3:id root="1.2.3.4"/> </v3:device>
	 * </v3:sender> <v3:controlActProcess classCode="CACT" moodCode="EVN">
	 * <v3:code code="PRPA_TE201301UV02" codeSystem="2.16.840.1.113883.1.18"/>
	 * <v3:subject typeCode="SUBJ"> <v3:registrationEvent classCode="REG"
	 * moodCode="EVN"> <v3:id nullFlavor="NA"/> <v3:statusCode code="active"/>
	 * <v3:subject1 typeCode="SBJ"> <v3:patient classCode="PAT"> <v3:id
	 * assigningAuthorityName="NIST2010" extension="PIX"
	 * root="2.16.840.1.113883.3.72.5.9.1"/> <v3:statusCode code="active"/>
	 * <v3:patientPerson classCode="PSN" determinerCode="INSTANCE"> <v3:name>
	 * <v3:family>ALPHA</v3:family> <v3:given>ALAN</v3:given> </v3:name>
	 * <v3:administrativeGenderCode code="male"
	 * codeSystem="2.16.840.1.113883.5.1"/> <v3:birthTime value="19380224"/>
	 * <v3:addr> <v3:streetAddressLine>1 PINETREE</v3:streetAddressLine>
	 * <v3:city>WEBSTER</v3:city> <v3:state>MO</v3:state>
	 * <v3:postalCode>63119</v3:postalCode> </v3:addr> </v3:patientPerson>
	 * <v3:providerOrganization classCode="ORG" determinerCode="INSTANCE">
	 * <v3:id root="2.16.840.1.113883.3.72.5.9.2"/> <v3:name>OHT</v3:name>
	 * <v3:contactParty classCode="CON"> <v3:telecom value=""/>
	 * </v3:contactParty> </v3:providerOrganization> </v3:patient>
	 * </v3:subject1> <v3:custodian typeCode="CST"> <v3:assignedEntity
	 * classCode="ASSIGNED"> <v3:id root="2.16.840.1.113883.3.72.5.9.2"/>
	 * <v3:assignedOrganization classCode="ORG" determinerCode="INSTANCE">
	 * <v3:name>OHT</v3:name> </v3:assignedOrganization> </v3:assignedEntity>
	 * </v3:custodian> </v3:registrationEvent> </v3:subject>
	 * </v3:controlActProcess> </v3:PRPA_IN201301UV02>
	 *
	 * 2/19/15 7:33:34 AM - We are trying to send the response to your
	 * system.Please wait... 2/19/15 7:33:34 AM - Message validation: started
	 * 2/19/15 7:33:34 AM - Html report creation: started 2/19/15 7:33:34 AM -
	 * Html report creation: finished 2/19/15 7:33:34 AM - Message validation:
	 * finished 2/19/15 7:33:34 AM - Response sent to 1.2.3.4 / null
	 * <MCCI_IN000002UV01 ITSVersion="XML_1.0" xmlns="urn:hl7-org:v3"> <id
	 * root="151ca168-1d30-4e2b-a935-46d5b349398f"/> <creationTime
	 * value="20150219073334"/> <interactionId extension="MCCI_IN000002UV01"
	 * root="2.16.840.1.113883.1.6"/> <processingCode code="P"/>
	 * <processingModeCode code="R"/> <acceptAckCode code="NE"/> <receiver
	 * typeCode="RCV"> <device classCode="DEV" determinerCode="INSTANCE"> <id
	 * root="1.2.3.4"/> </device> </receiver> <sender typeCode="SND"> <device
	 * classCode="DEV" determinerCode="INSTANCE"> <id
	 * root="2.16.840.1.113883.3.72.6.5.100.1055"/> </device> </sender>
	 * <acknowledgement> <typeCode code="CA"/> <targetMessage> <id
	 * root="1.2.3.4.103000030016104137.1424349214353.1"/> </targetMessage>
	 * </acknowledgement> </MCCI_IN000002UV01> 2/19/15 7:33:34 AM - Transaction
	 * finished
	 */

	@Test
	public void ITI44SourceUpdateTest() {
		v3PixPdqAdapterCfg = new V3PixPdqAdapterConfig(null,
				URI.create("http://" + ipAddress + ":9090"), null, senderApplicationOid, null,
				applicationName, facilityName, homeCommunityOid, homeCommunityNamespace, null, null,
				null, null, null, null);
		v3PixPdqAdapter = new V3PixPdqAdapter(v3PixPdqAdapterCfg);

		// TAU TERI
		final FhirPatient patient = new FhirPatient();
		final HumanName humanName = new HumanName().setFamily("TAU").addGiven("TERI");
		patient.getName().add(humanName);
		final org.hl7.fhir.dstu3.model.Address address = new org.hl7.fhir.dstu3.model.Address()
				.addLine("202 KEN HABOR").setPostalCode("61000").setCity("NEW YORK CITY")
				.setState("NY");
		final Identifier identifier = new Identifier();
		identifier.setValue("PIX");
		identifier.setSystem(FhirCommon.addUrnOid(homeCommunityOid));
		patient.getIdentifier().add(identifier);
		patient.setBirthDate(DateUtilMdht.date("19780510"));
		patient.getAddress().add(address);
		patient.setGender(AdministrativeGender.FEMALE);
		patient.getManagingOrganization().setResource(getScopingOrganization());

		final FhirContext ctx = new FhirContext(FhirVersionEnum.DSTU3);
		final String encoded = ctx.newXmlParser().encodeResourceToString(patient);
		log.debug(encoded);

		assertTrue(v3PixPdqAdapter.updatePatient(patient));
	}

	/*
	 * 2/19/15 7:38:29 AM - Test: ITI-44-Source-Merge , Step: 1 2/19/15 7:38:29
	 * AM - 2.16.840.1.113883.3.72.6.5.100.1325 / null configuration started
	 * 2/19/15 7:38:29 AM - 2.16.840.1.113883.3.72.6.5.100.1325 / null
	 * configuration finished 2/19/15 7:38:29 AM - Waiting for the incoming
	 * message...time elapsed=0s, time left=120s 2/19/15 7:38:41 AM - Incoming
	 * message received from 1.2.3.4 / null <v3:PRPA_IN201304UV02
	 * ITSVersion="XML_1.0" xmlns:v3="urn:hl7-org:v3"> <v3:id
	 * root="1.2.3.4.108001117012129067.1424349520773.1"/> <v3:creationTime
	 * value="20150219133840"/> <v3:interactionId extension="PRPA_IN201304UV02"
	 * root="2.16.840.1.113883.1.6"/> <v3:processingCode code="P"/>
	 * <v3:processingModeCode code="T"/> <v3:acceptAckCode code="AL"/>
	 * <v3:receiver typeCode="RCV"> <v3:device classCode="DEV"
	 * determinerCode="INSTANCE"> <v3:id
	 * root="2.16.840.1.113883.3.72.6.5.100.1325"/> </v3:device> </v3:receiver>
	 * <v3:sender typeCode="SND"> <v3:device classCode="DEV"
	 * determinerCode="INSTANCE"> <v3:id root="1.2.3.4"/> </v3:device>
	 * </v3:sender> <v3:controlActProcess classCode="CACT" moodCode="EVN">
	 * <v3:code code="PRPA_TE201304UV02" codeSystem="2.16.840.1.113883.1.18"/>
	 * <v3:subject typeCode="SUBJ"> <v3:registrationEvent classCode="REG"
	 * moodCode="EVN"> <v3:id nullFlavor="NA"/> <v3:statusCode code="active"/>
	 * <v3:subject1 typeCode="SBJ"> <v3:patient classCode="PAT"> <v3:id
	 * assigningAuthorityName="NIST2010" extension="PIXL"
	 * root="2.16.840.1.113883.3.72.5.9.1"/> <v3:statusCode code="active"/>
	 * <v3:patientPerson classCode="PSN" determinerCode="INSTANCE"> <v3:name>
	 * <v3:family>LINCOLN</v3:family> <v3:given>MARY</v3:given> </v3:name>
	 * <v3:administrativeGenderCode code="female"
	 * codeSystem="2.16.840.1.113883.5.1"/> <v3:birthTime value="19771208"/>
	 * <v3:addr> <v3:streetAddressLine>100 JORIE BLVD</v3:streetAddressLine>
	 * <v3:city>CHICAGO</v3:city> <v3:state>IL</v3:state>
	 * <v3:postalCode>60523</v3:postalCode> </v3:addr> </v3:patientPerson>
	 * <v3:providerOrganization classCode="ORG" determinerCode="INSTANCE">
	 * <v3:id root="2.16.840.1.113883.3.72.5.9.2"/> <v3:name>OHT</v3:name>
	 * <v3:contactParty classCode="CON"> <v3:telecom value=""/>
	 * </v3:contactParty> </v3:providerOrganization> </v3:patient>
	 * </v3:subject1> <v3:custodian typeCode="CST"> <v3:assignedEntity
	 * classCode="ASSIGNED"> <v3:id root="2.16.840.1.113883.3.72.5.9.2"/>
	 * <v3:assignedOrganization classCode="ORG" determinerCode="INSTANCE">
	 * <v3:name>OHT</v3:name> </v3:assignedOrganization> </v3:assignedEntity>
	 * </v3:custodian> <v3:replacementOf typeCode="RPLC"> <v3:priorRegistration
	 * classCode="REG" moodCode="EVN"> <v3:statusCode code="obsolete"/>
	 * <v3:subject1 typeCode="SBJ"> <v3:priorRegisteredRole classCode="PAT">
	 * <v3:id assigningAuthorityName="NIST2010" extension="PIXW"
	 * root="2.16.840.1.113883.3.72.5.9.1"/> </v3:priorRegisteredRole>
	 * </v3:subject1> </v3:priorRegistration> </v3:replacementOf>
	 * </v3:registrationEvent> </v3:subject> </v3:controlActProcess>
	 * </v3:PRPA_IN201304UV02> 2/19/15 7:38:41 AM - We are trying to send the
	 * response to your system.Please wait... 2/19/15 7:38:41 AM - Message
	 * validation: started 2/19/15 7:38:41 AM - Html report creation: started
	 * 2/19/15 7:38:41 AM - Html report creation: finished 2/19/15 7:38:41 AM -
	 * Message validation: finished 2/19/15 7:38:41 AM - Response sent to
	 * 1.2.3.4 / null <MCCI_IN000002UV01 ITSVersion="XML_1.0"
	 * xmlns="urn:hl7-org:v3"> <id root="8d0e22cb-484a-4c7c-a071-ffaefb464c1f"/>
	 * <creationTime value="20150219073841"/> <interactionId
	 * extension="MCCI_IN000002UV01" root="2.16.840.1.113883.1.6"/>
	 * <processingCode code="P"/> <processingModeCode code="R"/> <acceptAckCode
	 * code="NE"/> <receiver typeCode="RCV"> <device classCode="DEV"
	 * determinerCode="INSTANCE"> <id root="1.2.3.4"/> </device> </receiver>
	 * <sender typeCode="SND"> <device classCode="DEV"
	 * determinerCode="INSTANCE"> <id
	 * root="2.16.840.1.113883.3.72.6.5.100.1325"/> </device> </sender>
	 * <acknowledgement> <typeCode code="CA"/> <targetMessage> <id
	 * root="1.2.3.4.108001117012129067.1424349520773.1"/> </targetMessage>
	 * </acknowledgement> </MCCI_IN000002UV01> 2/19/15 7:38:41 AM - Transaction
	 * finished
	 */

	@Test
	public void ITI45ConsumperStep1Test() {

		log.debug("ITI45ConsumperStep1Test with ipAdress Target " + ipAddress);
		v3PixPdqAdapterCfg = new V3PixPdqAdapterConfig(URI.create("http://" + ipAddress + ":9090"),
				null, null, senderApplicationOid, null, applicationName, facilityName,
				homeCommunityOid, homeCommunityNamespace, domainToReturnOid,
				domainToReturnNamespace, null, null, null, null);
		v3PixPdqAdapter = new V3PixPdqAdapter(v3PixPdqAdapterCfg);

		final FhirPatient patient = new FhirPatient();
		final Identifier identifier = new Identifier();
		identifier.setValue("PIXL1");
		identifier.setSystem(FhirCommon.addUrnOid(homeCommunityOid));
		patient.getIdentifier().add(identifier);

		final FhirContext ctx = new FhirContext(FhirVersionEnum.DSTU3);
		final String encoded = ctx.newXmlParser().encodeResourceToString(patient);
		log.debug(encoded);

		// note: response in precat tool doest not contain response with id
		v3PixPdqAdapter.queryPatientId(patient);
	}

	/*
	 * 2/19/15 8:26:09 AM - Test: ITI-44-Source-Update , Step: 1 2/19/15 8:26:09
	 * AM - 2.16.840.1.113883.3.72.6.5.100.1162 / 2.16.840.1.113883.3.72.6.1
	 * configuration started 2/19/15 8:26:10 AM -
	 * 2.16.840.1.113883.3.72.6.5.100.1162 / 2.16.840.1.113883.3.72.6.1
	 * configuration finished 2/19/15 8:26:10 AM - Waiting for the incoming
	 * message...time elapsed=0s, time left=120s 2/19/15 8:26:25 AM - Incoming
	 * message received from 1.2.3.4 / null <v3:PRPA_IN201302UV02
	 * ITSVersion="XML_1.0" xmlns:v3="urn:hl7-org:v3"> <v3:id
	 * root="1.2.3.4.105001128020063083.1424352384592.1"/> <v3:creationTime
	 * value="20150219142624"/> <v3:interactionId extension="PRPA_IN201302UV02"
	 * root="2.16.840.1.113883.1.6"/> <v3:processingCode code="P"/>
	 * <v3:processingModeCode code="T"/> <v3:acceptAckCode code="AL"/>
	 * <v3:receiver typeCode="RCV"> <v3:device classCode="DEV"
	 * determinerCode="INSTANCE"> <v3:id
	 * root="2.16.840.1.113883.3.72.6.5.100.1162"/> <v3:asAgent
	 * classCode="AGNT"> <v3:representedOrganization classCode="ORG"
	 * determinerCode="INSTANCE"> <v3:id root="2.16.840.1.113883.3.72.6.1"/>
	 * </v3:representedOrganization> </v3:asAgent> </v3:device> </v3:receiver>
	 * <v3:sender typeCode="SND"> <v3:device classCode="DEV"
	 * determinerCode="INSTANCE"> <v3:id root="1.2.3.4"/> </v3:device>
	 * </v3:sender> <v3:controlActProcess classCode="CACT" moodCode="EVN">
	 * <v3:code code="PRPA_TE201302UV02" codeSystem="2.16.840.1.113883.1.18"/>
	 * <v3:subject typeCode="SUBJ"> <v3:registrationEvent classCode="REG"
	 * moodCode="EVN"> <v3:id nullFlavor="NA"/> <v3:statusCode code="active"/>
	 * <v3:subject1 typeCode="SBJ"> <v3:patient classCode="PAT"> <v3:id
	 * assigningAuthorityName="NIST2010" extension="PIX"
	 * root="2.16.840.1.113883.3.72.5.9.1"/> <v3:statusCode code="active"/>
	 * <v3:patientPerson classCode="PSN" determinerCode="INSTANCE"> <v3:name>
	 * <v3:family>TAU</v3:family> <v3:given>TERI</v3:given> </v3:name>
	 * <v3:administrativeGenderCode code="female"
	 * codeSystem="2.16.840.1.113883.5.1"/> <v3:birthTime value="19780510"/>
	 * <v3:addr> <v3:streetAddressLine>202 KEN HABOR</v3:streetAddressLine>
	 * <v3:city>NEW YORK CITY</v3:city> <v3:state>NY</v3:state>
	 * <v3:postalCode>61000</v3:postalCode> </v3:addr> </v3:patientPerson>
	 * <v3:providerOrganization classCode="ORG" determinerCode="INSTANCE">
	 * <v3:id root="2.16.840.1.113883.3.72.5.9.2"/> <v3:name>OHT</v3:name>
	 * <v3:contactParty classCode="CON"> <v3:telecom value=""/>
	 * </v3:contactParty> </v3:providerOrganization> </v3:patient>
	 * </v3:subject1> <v3:custodian typeCode="CST"> <v3:assignedEntity
	 * classCode="ASSIGNED"> <v3:id root="2.16.840.1.113883.3.72.5.9.2"/>
	 * <v3:assignedOrganization classCode="ORG" determinerCode="INSTANCE">
	 * <v3:name>OHT</v3:name> </v3:assignedOrganization> </v3:assignedEntity>
	 * </v3:custodian> </v3:registrationEvent> </v3:subject>
	 * </v3:controlActProcess> </v3:PRPA_IN201302UV02> 2/19/15 8:26:25 AM - We
	 * are trying to send the response to your system.Please wait... 2/19/15
	 * 8:26:25 AM - Message validation: started 2/19/15 8:26:25 AM - Html report
	 * creation: started 2/19/15 8:26:25 AM - Html report creation: finished
	 * 2/19/15 8:26:25 AM - Message validation: finished 2/19/15 8:26:25 AM -
	 * Response sent to 1.2.3.4 / null <MCCI_IN000002UV01 ITSVersion="XML_1.0"
	 * xmlns="urn:hl7-org:v3"> <id root="aa5e281b-d3e9-44b1-a85f-d18a8658d8e3"/>
	 * <creationTime value="20150219082625"/> <interactionId
	 * extension="MCCI_IN000002UV01" root="2.16.840.1.113883.1.6"/>
	 * <processingCode code="P"/> <processingModeCode code="R"/> <acceptAckCode
	 * code="NE"/> <receiver typeCode="RCV"> <device classCode="DEV"
	 * determinerCode="INSTANCE"> <id root="1.2.3.4"/> </device> </receiver>
	 * <sender typeCode="SND"> <device classCode="DEV"
	 * determinerCode="INSTANCE"> <id
	 * root="2.16.840.1.113883.3.72.6.5.100.1162"/> <asAgent classCode="AGNT">
	 * <representedOrganization determinerCode="INSTANCE" classCode="ORG"> <id
	 * root="2.16.840.1.113883.3.72.6.1"/> </representedOrganization> </asAgent>
	 * </device> </sender> <acknowledgement> <typeCode code="CA"/>
	 * <targetMessage> <id root="1.2.3.4.105001128020063083.1424352384592.1"/>
	 * </targetMessage> </acknowledgement> </MCCI_IN000002UV01> 2/19/15 8:26:25
	 * AM - Transaction finished
	 */

	@Test
	public void ITI45ConsumperStep2Test() {

		log.debug("ITI45ConsumperStep2Test with ipAdress Target " + ipAddress);
		v3PixPdqAdapterCfg = new V3PixPdqAdapterConfig(URI.create("http://" + ipAddress + ":9090"),
				null, null, senderApplicationOid, null, applicationName, facilityName,
				homeCommunityOid, homeCommunityNamespace, null, null, null, null, null, null);
		v3PixPdqAdapter = new V3PixPdqAdapter(v3PixPdqAdapterCfg);

		final FhirPatient patient = new FhirPatient();
		final Identifier identifier = new Identifier();
		identifier.setValue("PIXL1");
		identifier.setSystem(FhirCommon.addUrnOid(homeCommunityOid));
		patient.getIdentifier().add(identifier);

		final FhirContext ctx = new FhirContext(FhirVersionEnum.DSTU3);
		final String encoded = ctx.newXmlParser().encodeResourceToString(patient);
		log.debug(encoded);

		// NOTE: response in precat tool doest not contain response id
		v3PixPdqAdapter.queryPatientId(patient);
	}

	/*
	 * 2/19/15 9:09:58 AM - Test: ITI-45-Consumer , Step: 1
	 *
	 * 2/19/15 9:09:58 AM - 2.16.840.1.113883.3.72.6.5.100.1461 / null
	 * configuration started
	 *
	 * 2/19/15 9:09:58 AM - 2.16.840.1.113883.3.72.6.5.100.1461 / null
	 * configuration finished
	 *
	 * 2/19/15 9:09:58 AM - Waiting for the incoming message...time elapsed=0s,
	 * time left=120s
	 *
	 * 2/19/15 9:10:17 AM - Incoming message received from 1.2.3.4 / null
	 *
	 * <v3:PRPA_IN201309UV02 ITSVersion="XML_1.0" xmlns:v3="urn:hl7-org:v3">
	 * <v3:id root="1.2.3.4.103000069043208096.1424355010083.1"/>
	 * <v3:creationTime value="20150219151010"/> <v3:interactionId
	 * extension="PRPA_IN201309UV02" root="2.16.840.1.113883.1.6"/>
	 * <v3:processingCode code="P"/> <v3:processingModeCode code="T"/>
	 * <v3:acceptAckCode code="AL"/> <v3:receiver typeCode="RCV"> <v3:device
	 * classCode="DEV" determinerCode="INSTANCE"> <v3:id
	 * root="2.16.840.1.113883.3.72.6.5.100.1461"/> </v3:device> </v3:receiver>
	 * <v3:sender typeCode="SND"> <v3:device classCode="DEV"
	 * determinerCode="INSTANCE"> <v3:id root="1.2.3.4"/> </v3:device>
	 * </v3:sender> <v3:controlActProcess classCode="CACT" moodCode="EVN">
	 * <v3:code code="PRPA_TE201309UV02" codeSystem="2.16.840.1.113883.1.18"/>
	 * <v3:authorOrPerformer typeCode="AUT"> <v3:assignedDevice
	 * classCode="ASSIGNED"/> </v3:authorOrPerformer> <v3:queryByParameter>
	 * <v3:queryId extension="14243550101781"
	 * root="1.2.840.114350.1.13.28.1.18.5.999"/> <v3:statusCode code="new"/>
	 * <v3:responsePriorityCode code="I"/> <v3:parameterList> <v3:dataSource>
	 * <v3:value assigningAuthorityName="NIST2010-3"
	 * root="2.16.840.1.113883.3.72.5.9.3"/>
	 * <v3:semanticsText>DataSource.id</v3:semanticsText> </v3:dataSource>
	 * <v3:patientIdentifier> <v3:value assigningAuthorityName="NIST2010"
	 * extension="PIXL1" root="2.16.840.1.113883.3.72.5.9.1"/>
	 * <v3:semanticsText>Patient.Id</v3:semanticsText> </v3:patientIdentifier>
	 * </v3:parameterList> </v3:queryByParameter> </v3:controlActProcess>
	 * </v3:PRPA_IN201309UV02>
	 *
	 * 2/19/15 9:10:17 AM - We are trying to send the response to your
	 * system.Please wait... 2/19/15 9:10:17 AM - Message validation: started
	 * 2/19/15 9:10:17 AM - Html report creation: started
	 *
	 * 2/19/15 9:10:17 AM - Html report creation: finished
	 *
	 * 2/19/15 9:10:17 AM - Message validation: finished
	 *
	 * 2/19/15 9:10:17 AM - Response sent to 1.2.3.4 / null <PRPA_IN201310UV02
	 * ITSVersion="XML_1.0" xmlns="urn:hl7-org:v3"
	 * xmlns:env="http://www.w3.org/2003/05/soap-envelope"
	 * xmlns:wsa="http://schemas.xmlsoap.org/ws/2004/08/addressing"
	 * xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"> <id
	 * root="b58774a1-75ff-45ec-a33d-51b49bfcf877"/> <creationTime
	 * value="20150219091017"/> <interactionId extension="PRPA_IN201310UV02"
	 * root="2.16.840.1.113883.1.6"/> <processingCode code="P"/>
	 * <processingModeCode code="T"/> <acceptAckCode code="NE"/> <receiver
	 * typeCode="RCV"> <device classCode="DEV" determinerCode="INSTANCE"> <id
	 * root="1.2.3.4"/> </device> </receiver> <sender typeCode="SND"> <device
	 * classCode="DEV" determinerCode="INSTANCE"> <id
	 * root="2.16.840.1.113883.3.72.6.5.100.1461"/> </device> </sender>
	 * <acknowledgement> <typeCode code="AA"/> <targetMessage> <id
	 * root="1.2.3.4.103000069043208096.1424355010083.1"/> </targetMessage>
	 * </acknowledgement> <controlActProcess classCode="CACT" moodCode="EVN">
	 * <code code="PRPA_TE201310UV02" codeSystem="2.16.840.1.113883.1.6"/>
	 * <queryAck> <queryId extension="14243550101781"
	 * root="1.2.840.114350.1.13.28.1.18.5.999" xmlns:v3="urn:hl7-org:v3"/>
	 * <queryResponseCode code="NF"/> </queryAck> <queryByParameter
	 * xmlns:v3="urn:hl7-org:v3"> <v3:queryId extension="14243550101781"
	 * root="1.2.840.114350.1.13.28.1.18.5.999"/> <v3:statusCode code="new"/>
	 * <v3:responsePriorityCode code="I"/> <v3:parameterList> <v3:dataSource>
	 * <v3:value assigningAuthorityName="NIST2010-3"
	 * root="2.16.840.1.113883.3.72.5.9.3"/>
	 * <v3:semanticsText>DataSource.id</v3:semanticsText> </v3:dataSource>
	 * <v3:patientIdentifier> <v3:value assigningAuthorityName="NIST2010"
	 * extension="PIXL1" root="2.16.840.1.113883.3.72.5.9.1"/>
	 * <v3:semanticsText>Patient.Id</v3:semanticsText> </v3:patientIdentifier>
	 * </v3:parameterList> </queryByParameter> </controlActProcess>
	 * </PRPA_IN201310UV02>
	 *
	 * 2/19/15 9:10:17 AM - Transaction finished
	 */

	/*
	 * 2/19/15 9:13:47 AM - Test: ITI-45-Consumer , Step: 2 2/19/15 9:13:47 AM -
	 * 2.16.840.1.113883.3.72.6.5.100.1461 / null configuration started 2/19/15
	 * 9:13:47 AM - 2.16.840.1.113883.3.72.6.5.100.1461 / null configuration
	 * finished 2/19/15 9:13:47 AM - Waiting for the incoming message...time
	 * elapsed=0s, time left=120s 2/19/15 9:14:00 AM - Incoming message received
	 * from 1.2.3.4 / null <v3:PRPA_IN201309UV02 ITSVersion="XML_1.0"
	 * xmlns:v3="urn:hl7-org:v3"> <v3:id
	 * root="1.2.3.4.109000086048081104.1424355240025.1"/> <v3:creationTime
	 * value="20150219151400"/> <v3:interactionId extension="PRPA_IN201309UV02"
	 * root="2.16.840.1.113883.1.6"/> <v3:processingCode code="P"/>
	 * <v3:processingModeCode code="T"/> <v3:acceptAckCode code="AL"/>
	 * <v3:receiver typeCode="RCV"> <v3:device classCode="DEV"
	 * determinerCode="INSTANCE"> <v3:id
	 * root="2.16.840.1.113883.3.72.6.5.100.1461"/> </v3:device> </v3:receiver>
	 * <v3:sender typeCode="SND"> <v3:device classCode="DEV"
	 * determinerCode="INSTANCE"> <v3:id root="1.2.3.4"/> </v3:device>
	 * </v3:sender> <v3:controlActProcess classCode="CACT" moodCode="EVN">
	 * <v3:code code="PRPA_TE201309UV02" codeSystem="2.16.840.1.113883.1.18"/>
	 * <v3:authorOrPerformer typeCode="AUT"> <v3:assignedDevice
	 * classCode="ASSIGNED"/> </v3:authorOrPerformer> <v3:queryByParameter>
	 * <v3:queryId extension="14243552401241"
	 * root="1.2.840.114350.1.13.28.1.18.5.999"/> <v3:statusCode code="new"/>
	 * <v3:responsePriorityCode code="I"/> <v3:parameterList>
	 * <v3:patientIdentifier> <v3:value assigningAuthorityName="NIST2010"
	 * extension="PIXL1" root="2.16.840.1.113883.3.72.5.9.1"/>
	 * <v3:semanticsText>Patient.Id</v3:semanticsText> </v3:patientIdentifier>
	 * </v3:parameterList> </v3:queryByParameter> </v3:controlActProcess>
	 * </v3:PRPA_IN201309UV02>
	 *
	 * 2/19/15 9:14:00 AM - We are trying to send the response to your
	 * system.Please wait...
	 *
	 * 2/19/15 9:14:00 AM - Message validation: started
	 *
	 * 2/19/15 9:14:00 AM - Html report creation: started
	 *
	 * 2/19/15 9:14:01 AM - Html report creation: finished
	 *
	 * 2/19/15 9:14:01 AM - Message validation: finished
	 *
	 * 2/19/15 9:14:01 AM - Response sent to 1.2.3.4 / null <PRPA_IN201310UV02
	 * ITSVersion="XML_1.0" xmlns="urn:hl7-org:v3"
	 * xmlns:env="http://www.w3.org/2003/05/soap-envelope"
	 * xmlns:wsa="http://schemas.xmlsoap.org/ws/2004/08/addressing"
	 * xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"> <id
	 * root="4fc19b49-d97d-4c09-9505-d1bcf9788811"/> <creationTime
	 * value="20150219091400"/> <interactionId extension="PRPA_IN201310UV02"
	 * root="2.16.840.1.113883.1.6"/> <processingCode code="P"/>
	 * <processingModeCode code="T"/> <acceptAckCode code="NE"/> <receiver
	 * typeCode="RCV"> <device classCode="DEV" determinerCode="INSTANCE"> <id
	 * root="1.2.3.4"/> </device> </receiver> <sender typeCode="SND"> <device
	 * classCode="DEV" determinerCode="INSTANCE"> <id
	 * root="2.16.840.1.113883.3.72.6.5.100.1461"/> </device> </sender>
	 * <acknowledgement> <typeCode code="AA"/> <targetMessage> <id
	 * root="1.2.3.4.109000086048081104.1424355240025.1"/> </targetMessage>
	 * </acknowledgement> <controlActProcess classCode="CACT" moodCode="EVN">
	 * <code code="PRPA_TE201310UV02" codeSystem="2.16.840.1.113883.1.6"/>
	 * <queryAck> <queryId extension="14243552401241"
	 * root="1.2.840.114350.1.13.28.1.18.5.999" xmlns:v3="urn:hl7-org:v3"/>
	 * <queryResponseCode code="NF"/> </queryAck> <queryByParameter
	 * xmlns:v3="urn:hl7-org:v3"> <v3:queryId extension="14243552401241"
	 * root="1.2.840.114350.1.13.28.1.18.5.999"/> <v3:statusCode code="new"/>
	 * <v3:responsePriorityCode code="I"/> <v3:parameterList>
	 * <v3:patientIdentifier> <v3:value assigningAuthorityName="NIST2010"
	 * extension="PIXL1" root="2.16.840.1.113883.3.72.5.9.1"/>
	 * <v3:semanticsText>Patient.Id</v3:semanticsText> </v3:patientIdentifier>
	 * </v3:parameterList> </queryByParameter> </controlActProcess>
	 * </PRPA_IN201310UV02>
	 *
	 * 2/19/15 9:14:01 AM - Transaction finished
	 */

	@Test
	public void ITI47ConsumerQueryPatientPatientIdStep1Test() {
		log.debug("ITI47ConsumerQueryPatientPatientIdStep1Test with ipAdress Target " + ipAddress);

		final AffinityDomain affinityDomain = new AffinityDomain();
		final Destination dest = new Destination();

		try {
			dest.setUri(new URI("http://" + ipAddress + ":9090"));
		} catch (final URISyntaxException e) {
			e.printStackTrace();
		}
		dest.setSenderApplicationOid(senderApplicationOid);
		dest.setReceiverApplicationOid(applicationName);
		dest.setReceiverFacilityOid(facilityName);
		affinityDomain.setPdqDestination(dest);
		affinityDomain.setPixDestination(dest);

		final MasterPatientIndexQuery mpiQuery = new MasterPatientIndexQuery(
				affinityDomain.getPdqDestination());
		final Identificator identificator = new Identificator("2.16.840.1.113883.3.72.5.9.1",
				"HJ-361");
		final MasterPatientIndexQueryResponse response = ConvenienceMasterPatientIndexV3
				.queryPatientDemographics(mpiQuery.addPatientIdentificator(identificator)
						.addDomainToReturn("2.16.840.1.113883.3.72.5.9.1"), affinityDomain);
		assertTrue(response.getSuccess());
	}

	@Test
	public void ITI47ConsumerQueryPatientPatientIdStep2Test() {

		log.debug("ITI47ConsumerQueryPatientPatientIdStep2Test with ipAdress Target " + ipAddress);

		final AffinityDomain affinityDomain = new AffinityDomain();
		final Destination dest = new Destination();

		try {
			dest.setUri(new URI("http://" + ipAddress + ":9090"));
		} catch (final URISyntaxException e) {
			e.printStackTrace();
		}
		dest.setSenderApplicationOid(senderApplicationOid);
		dest.setReceiverApplicationOid(applicationName);
		dest.setReceiverFacilityOid(facilityName);
		affinityDomain.setPdqDestination(dest);
		affinityDomain.setPixDestination(dest);

		final MasterPatientIndexQuery mpiQuery = new MasterPatientIndexQuery(
				affinityDomain.getPdqDestination());
		final Identificator identificator = new Identificator("2.16.840.1.113883.3.72.5.9.1",
				"HJ-361");
		final MasterPatientIndexQueryResponse response = ConvenienceMasterPatientIndexV3
				.queryPatientDemographics(mpiQuery.addPatientIdentificator(identificator)
						.addDomainToReturn("2.16.840.1.113883.3.72.5.9.1"), affinityDomain);
		assertTrue(response.getSuccess());
	}
}
