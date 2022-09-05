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

import org.hl7.fhir.r4.model.*;
import org.husky.common.communication.AffinityDomain;
import org.husky.common.communication.Destination;
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

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
@ExtendWith(value = SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = { TestApplication.class })
@EnableAutoConfiguration
class CHPixV3QueryTest {

	protected static Logger LOGGER = LoggerFactory.getLogger(CHPixV3QueryTest.class);

	@Autowired
	private ConvenienceMasterPatientIndexV3 convenienceMasterPatientIndexV3Client;

	@Autowired
	protected AuditContext auditContext;
	final private String pixUri = "https://ehealthsuisse.ihe-europe.net/PAMSimulator-ejb/PIXManager_Service/PIXManager_PortType";

	final private String facilityName = "Waldspital Bern"; // "2.16.840.1.113883.3.72.6.1";

	final private String receiverApplicationOid = "1.3.6.1.4.1.12559.11.20.1.10";
	final private String senderApplicationOid = "1.2.3.4";

	final private String homeCommunityOid = "1.3.6.1.4.1.12559.11.20.1";
	final private String homeCommunityNamespace = "CHPAM2";
	
	final private String spidEprOid = "2.16.756.5.30.1.127.3.10.3";
	final private String spidEprNamespace = "SPID";

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
	 * The purpose of this test is to cross reference the id of patient Léo Gerard
	 * retrieve SPID of patient using home community ID CHPAM4489
	 * 
	 * ids of patient in patient manager
	 * 761337610436974489^^^&1.3.6.1.4.1.21367.2017.2.5.10&
     * CHPAM4489^^^&1.3.6.1.4.1.12559.11.20.1&
	 */
	@Test
	void queryTest() {

		final AffinityDomain affinityDomain = new AffinityDomain();

		final Destination dest = new Destination();
		dest.setUri(URI.create(pixUri));
		dest.setSenderApplicationOid(senderApplicationOid);
		dest.setReceiverApplicationOid(receiverApplicationOid);
		dest.setReceiverFacilityOid(facilityName);
		affinityDomain.setPdqDestination(dest);
		affinityDomain.setPixDestination(dest);

		PixV3Query pixV3Query = new PixV3Query(affinityDomain, homeCommunityOid, homeCommunityNamespace,
				spidEprOid, spidEprNamespace,
				convenienceMasterPatientIndexV3Client.getContext(),
				convenienceMasterPatientIndexV3Client.getAuditContext());

		//
		final Identifier identifier = new Identifier();
		identifier.setValue("CHPAM4489");
		identifier.setSystem(FhirCommon.addUrnOid(homeCommunityOid));

		final FhirPatient patient = new FhirPatient();
		patient.getIdentifier().add(identifier);

		String patId = pixV3Query.queryPatientId(patient, null, null);

		assertEquals("761337610436974489", patId);
	}

}
