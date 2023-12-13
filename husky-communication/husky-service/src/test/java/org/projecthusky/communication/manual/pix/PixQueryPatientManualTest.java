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

import java.net.URI;
import org.junit.jupiter.api.Test;
import org.projecthusky.common.communication.Destination;
import org.projecthusky.communication.requests.pix.PixPatientIDQuery;
import org.projecthusky.communication.services.HuskyWebServiceClient;
import org.projecthusky.communication.TestApplication;
import org.projecthusky.communication.config.IpfApplicationConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = { TestApplication.class, IpfApplicationConfig.class })
public class PixQueryPatientManualTest {
	@Value(value = "${test.pixq.uri:https://ehealthsuisse.ihe-europe.net/PAMSimulator-ejb/PIXManager_Service/PIXManager_PortType}")
    private String pixUri;

//	@Autowired
//	private ConvenienceMasterPatientIndexV3 convenienceMasterPatientIndexV3Client;

	@Autowired
	private HuskyWebServiceClient wsClient;

	final private String facilityName = null; // "2.16.840.1.113883.3.72.6.1";

	final private String receiverApplicationOid = "1.3.6.1.4.1.12559.11.20.1.10";
	final private String senderApplicationOid = "1.2.3.4";
	final private String facilityOid = "2.16.840.1.113883.3.72.6.1";

	final private String homeCommunityOid = "1.3.6.1.4.1.12559.11.20.1";
	final private String homeCommunityNamespace = "CHPAM2";

	final private String spidEprOid = "2.16.756.5.30.1.127.3.10.3";
	final private String spidEprNamespace = "SPID";

	/**
	 * The purpose of this test is to cross reference id of patient Léo Gerard, retrieve SPID of patient using home community ID CHPAM4489 ids of patient in patient manager.
	 * 761337610436974489^^^&1.3.6.1.4.1.21367.2017.2.5.10&
	 * CHPAM4489^^^&1.3.6.1.4.1.12559.11.20.1&
	 */
//	@Test
//	void ITI45ConsumerTest() {
//		final AffinityDomain affinityDomain = new AffinityDomain();
//		final Destination dest = new Destination();
//
//		dest.setUri(URI.create(pixUri));
//		dest.setSenderApplicationOid(senderApplicationOid);
//		dest.setReceiverApplicationOid(receiverApplicationOid);
//		dest.setReceiverFacilityOid(facilityName);
//		affinityDomain.setPdqDestination(dest);
//		affinityDomain.setPixDestination(dest);
//
//		PixV3Query pixV3Query = new PixV3Query(affinityDomain, homeCommunityOid, homeCommunityNamespace,
//				spidEprOid, spidEprNamespace,
//				convenienceMasterPatientIndexV3Client.getContext(),
//				convenienceMasterPatientIndexV3Client.getAuditContext());
//
//		final FhirPatient patient = new FhirPatient();
//		final Identifier identifier = new Identifier();
//		identifier.setValue("CHPAM4489");
//		identifier.setSystem(FhirCommon.addUrnOid(homeCommunityOid));
//		patient.getIdentifier().add(identifier);
//
//		String patId = pixV3Query.queryPatientId(patient, null, null);
//
//		assertEquals("761337610436974489", patId);
//	}

//	@Test
//	void queryPatientIdTest() throws IOException {
//
//		// sets endpoint of PIX service
//		final AffinityDomain affinityDomain = new AffinityDomain();
//		final Destination dest = new Destination();
//
//		dest.setUri(URI.create(pixUri));
//		dest.setSenderApplicationOid(senderApplicationOid);
//		dest.setReceiverApplicationOid(receiverApplicationOid);
//		dest.setReceiverFacilityOid(facilityName);
//		affinityDomain.setPdqDestination(dest);
//		affinityDomain.setPixDestination(dest);
//
//		PixV3Query pixV3Query = new PixV3Query(affinityDomain, homeCommunityOid, homeCommunityNamespace, spidEprOid,
//				spidEprNamespace, convenienceMasterPatientIndexV3Client.getContext(),
//				convenienceMasterPatientIndexV3Client.getAuditContext());
//
//		final FhirPatient patient = new FhirPatient();
//		final Identifier identifier = new Identifier();
//		identifier.setValue("CHPAM4489");
//		identifier.setSystem(FhirCommon.addUrnOid(homeCommunityOid));
//		patient.getIdentifier().add(identifier);
//
//		String patId = pixV3Query.queryPatientId(patient, null, null);
//
//		assertEquals("761337610436974489", patId);
//	}

//	@Test
//	void queryTest() {
//		final AffinityDomain affinityDomain = new AffinityDomain();
//
//		final Destination dest = new Destination();
//		dest.setUri(URI.create(pixUri));
//		dest.setSenderApplicationOid(senderApplicationOid);
//		dest.setReceiverApplicationOid(receiverApplicationOid);
//		dest.setReceiverFacilityOid(facilityOid);
//		affinityDomain.setPdqDestination(dest);
//		affinityDomain.setPixDestination(dest);
//
//		String localAssigningAuthorityOid = "1.2.3.4.123456.1";
//		String localIdNamespace = "WALDSPITAL";
//		String spidAssigningAuthorityOid = "2.16.756.5.30.1.127.3.10.3";
//		String spidNamespace = "SPID";
//		String localPatientId = "waldspital-Id-1234";
//		String globalAssigningAuthorityOid = "1.1.1.99.1";
//
//		PixV3Query pixV3Query = new PixV3Query(affinityDomain, localAssigningAuthorityOid, localIdNamespace,
//				spidAssigningAuthorityOid, spidNamespace,
//				convenienceMasterPatientIndexV3Client.getContext(),
//				convenienceMasterPatientIndexV3Client.getAuditContext());
//
//		// set the local patient id as input for the pix query
//		Identifier localIdentifier = new Identifier();
//		localIdentifier.setValue(localPatientId);
//		localIdentifier.setSystem(FhirCommon.addUrnOid(localAssigningAuthorityOid));
//
//		FhirPatient patient = new FhirPatient();
//		patient.getIdentifier().add(localIdentifier);
//
//		// data source settings. By setting the assigning authority oid we tell the PIX Manager to return
//		// the patient Id assigned by the authority. The query should return the patient identifiers
//		// in the order the assigning authority oids are added.
//		List<String> queryDomainOids = new ArrayList<String>();
//		queryDomainOids.add(spidAssigningAuthorityOid);
//		queryDomainOids.add(globalAssigningAuthorityOid);
//
//		List<String> returnedIds = pixV3Query.queryPatientId(patient, queryDomainOids, null, null, null);
//
//		assertTrue(returnedIds.size() > 0);
//		//761337637673823141
//		//761337713436974989
//		returnedIds.forEach(id -> System.out.println(id));
//		assertEquals("761337713436974989", returnedIds.get(0));
//		//assertEquals("2dc7a783-78b1-4627-94fb-610a23135c42", returnedIds.get(1)); //Testsystem returns null instead of this expected ID
//	}

//	@Test
//	void queryTest2() {
//
//		final AffinityDomain affinityDomain = new AffinityDomain();
//
//		final Destination dest = new Destination();
//		dest.setUri(URI.create(pixUri));
//		dest.setSenderApplicationOid(senderApplicationOid);
//		dest.setReceiverApplicationOid(receiverApplicationOid);
//		dest.setReceiverFacilityOid(facilityOid);
//		affinityDomain.setPdqDestination(dest);
//		affinityDomain.setPixDestination(dest);
//
//		String localAssigningAuthorityOid = "1.2.3.4.123456.1";
//		String localIdNamespace = "WALDSPITAL";
//		String spidAssigningAuthorityOid = "2.16.756.5.30.1.127.3.10.3";
//		String spidNamespace = "SPID";
//		String localPatientId = "waldspital-Id-1234";
//		String globalAssigningAuthorityOid = "1.1.1.99.1";
//
//		PixV3Query pixV3Query = new PixV3Query(affinityDomain, localAssigningAuthorityOid, localIdNamespace,
//				spidAssigningAuthorityOid, spidNamespace,
//				convenienceMasterPatientIndexV3Client.getContext(),
//				convenienceMasterPatientIndexV3Client.getAuditContext());
//
//		// set the local patient id as input for the pix query
//		final Identifier localIdentifier = new Identifier();
//		localIdentifier.setValue(localPatientId);
//		localIdentifier.setSystem(FhirCommon.addUrnOid(localAssigningAuthorityOid));
//
//		final FhirPatient patient = new FhirPatient();
//		patient.getIdentifier().add(localIdentifier);
//
//		// data source settings. By setting the assigning authority oid we tell the PIX Manager to return
//		// the patient Id assigned by the authority. The query should return the patient identifiers
//		// in the order the assigning authority oids are added.
//		List<String> queryDomainOids = new ArrayList();
//		queryDomainOids.add(spidAssigningAuthorityOid);
//		queryDomainOids.add(globalAssigningAuthorityOid);
//
//		List<String> returnedIds = pixV3Query.queryPatientId(patient, queryDomainOids, null, null, null);
//
//		assertTrue(returnedIds.size() > 0);
//
//		assertEquals("761337713436974989", returnedIds.get(0));
//
//		// In the Swiss EPR the PIX Manager should return the ids in the order set in the queryDomainIds, but does not so in
//		// gazelle test system.
//		// assertEquals(returnedIds.get(1), communityId);
//	}

	@Test
	void test1() throws Exception {
		Destination dest = new Destination();
		dest.setUri(URI.create(pixUri));
		dest.setSenderApplicationOid("1.2.3.4");
		dest.setReceiverApplicationOid("1.3.6.1.4.1.12559.11.20.1.10");

		PixPatientIDQuery query = PixPatientIDQuery.builder().destination(dest)
				.homeCommunityPatientOid("waldspital-Id-1234").homeCommunityOid("2.16.756.5.30.1.127.3.10.3").homeCommunityNamespace("WALDSPITAL")
				.build();
		this.wsClient.sendQuery(query.build(), null, query.getDestination().getUri(), facilityName);
	}

}
