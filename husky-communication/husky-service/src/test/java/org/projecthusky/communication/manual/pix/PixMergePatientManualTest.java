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
package org.projecthusky.communication.manual.pix;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.hl7.fhir.r4.model.Enumerations.AdministrativeGender;
import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Organization;
import org.junit.jupiter.api.Test;
import org.projecthusky.common.communication.AffinityDomain;
import org.projecthusky.common.communication.Destination;
import org.projecthusky.communication.ConvenienceMasterPatientIndexV3;
import org.projecthusky.communication.mpi.impl.PixV3Query;
import org.projecthusky.communication.requests.pix.PixMergePatientFeed;
import org.projecthusky.communication.services.HuskyWebServiceClient;
import org.projecthusky.communication.TestApplication;
import org.projecthusky.communication.config.IpfApplicationConfig;
import org.projecthusky.fhir.structures.gen.FhirCommon;
import org.projecthusky.fhir.structures.gen.FhirPatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = { TestApplication.class, IpfApplicationConfig.class })
public class PixMergePatientManualTest {

	@Autowired
	private ConvenienceMasterPatientIndexV3 convenienceMasterPatientIndexV3Client;

	@Autowired
	private HuskyWebServiceClient wsClient;

	// note: fill below in from test tool before running test and remove @Ignore
	// Annotation above to run the tests manual
	@Value(value = "${test.pixq.uri:https://ehealthsuisse.ihe-europe.net/PAMSimulator-ejb/PIXManager_Service/PIXManager_PortType}")
    private String pixUri;

	final private String facilityName = null;
	final private String receiverApplicationOid = "1.3.6.1.4.1.12559.11.20.1.10";
	final private String senderApplicationOid = "1.2.3.4";
	final private String homeCommunityOid = "1.3.6.1.4.1.12559.11.20.1";
	final private String homeCommunityNamespace = "CHPAM2";
	final private String spidEprOid = "2.16.756.5.30.1.127.3.10.3";

	private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

	private Organization getScopingOrganization() {
		Organization org = new Organization();
		Identifier identifier = new Identifier();
		identifier.setValue("Husky");
		identifier.setSystem(FhirCommon.addUrnOid(homeCommunityOid));
		org.getIdentifier().add(identifier);
		return org;
	}

	/**
	 * The purpose of this test is to check that your PIX Source can send an merge
	 * message (Patient Registry Duplicates Resolved : PRPA_IN201304UV02).
	 *
	 * Send a valid merge message (PRPA_IN201304UV02) to the PIX Manager. The
	 * message shall contain patient Maier Hubert in domain CHPAM2 replacement
	 * of ID 1634721569120 (Maier Hubertus) in domain CHPAM2. The PIX Manager sends an
	 * acknowledgement (MCCI_IN000002UV01) back to your PIX Source.
	 * @throws ParseException
	 */
	@Test
	void ITI44SourceMergeTest() throws ParseException {

		AffinityDomain affinityDomain = new AffinityDomain();
		Destination dest = new Destination();

		dest.setUri(URI.create(pixUri));
		dest.setSenderApplicationOid(senderApplicationOid);
		dest.setReceiverApplicationOid(receiverApplicationOid);
		dest.setReceiverFacilityOid(facilityName);
		affinityDomain.setPdqDestination(dest);
		affinityDomain.setPixDestination(dest);

		PixV3Query pixV3Query = new PixV3Query(affinityDomain, homeCommunityOid, homeCommunityNamespace, null, null,
				convenienceMasterPatientIndexV3Client.getContext(),
				convenienceMasterPatientIndexV3Client.getAuditContext());

		FhirPatient patient = new FhirPatient();
		HumanName humanName = new HumanName().setFamily("Maier").addGiven("Hubert");
		patient.getName().add(humanName);

		Identifier identifier = new Identifier();
		identifier.setValue("1634641399206");
		identifier.setSystem(FhirCommon.addUrnOid(homeCommunityOid));
		patient.getIdentifier().add(identifier);

		Identifier identifier2 = new Identifier();
		identifier2.setValue("SPID-1");
		identifier2.setSystem(spidEprOid);
		patient.getIdentifier().add(identifier2);

		patient.setBirthDate(this.dateFormat.parse("19500324"));
		patient.setGender(AdministrativeGender.MALE);
		patient.getManagingOrganization().setResource(getScopingOrganization());

		assertTrue(pixV3Query.mergePatient(patient, "1634721569120", null, null));
	}

	@Test
	void whenMergeQueryBuiltWithQueryBuilder_andSentWIthWSClient_thenSameHappensAsWithPixV3Query() throws Exception {
		Destination dest = new Destination();
		dest.setUri(URI.create(pixUri));
		dest.setSenderApplicationOid(senderApplicationOid);
		dest.setReceiverApplicationOid(receiverApplicationOid);

		Organization organization = new Organization().addIdentifier(new Identifier().setValue("Husky").setSystem(FhirCommon.addUrnOid(homeCommunityOid)));

		PixMergePatientFeed query = PixMergePatientFeed.builder().destination(dest).scopingOrganization(organization)
				.identifier(new Identifier().setValue("1634641399206").setSystem(FhirCommon.addUrnOid(homeCommunityOid)))
				.identifier(new Identifier().setValue("SPID-1").setSystem(FhirCommon.addUrnOid(spidEprOid)))
				.homeCommunityOID(homeCommunityOid).homeCommunityNamespace(homeCommunityNamespace)
				.obsolatePatientID("1634721569120")
				.birthday(this.dateFormat.parse("19500324"))
				.gender(AdministrativeGender.MALE)
				.build();
		this.wsClient.sendITI44Query(query.build().getRootElement(), null, query.getDestination().getUri(), "urn:hl7-org:v3:PRPA_IN201304UV02", null);
	}

}
