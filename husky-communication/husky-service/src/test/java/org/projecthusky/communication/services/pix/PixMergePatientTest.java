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

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.text.SimpleDateFormat;

import org.hl7.fhir.r4.model.Enumerations.AdministrativeGender;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Organization;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.projecthusky.common.communication.Destination;
import org.projecthusky.communication.requests.pix.PixMergePatientFeed;
import org.projecthusky.communication.config.IpfApplicationConfig;
import org.projecthusky.communication.TestApplication;
import org.projecthusky.communication.services.HuskyService;
import org.projecthusky.fhir.structures.gen.FhirCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = { TestApplication.class, IpfApplicationConfig.class })
@ActiveProfiles("atna")
public class PixMergePatientTest {

	@Value(value = "${test.pixq.uri:https://ehealthsuisse.ihe-europe.net/PAMSimulator-ejb/PIXManager_Service/PIXManager_PortType}")
	private String mergeWebServiceUri;

	@Autowired
	private HuskyService service;

	private Destination testWSDestination;
	private Organization testScopingOrganization;

	final private String receiverApplicationOid = "1.3.6.1.4.1.12559.11.20.1.10";
	final private String senderApplicationOid = "1.2.3.4";

	final private String homeCommunityOid = "1.3.6.1.4.1.12559.11.20.1";
	final private String homeCommunityNamespace = "CHPAM2";

	final private String spidEprOid = "2.16.756.5.30.1.127.3.10.3";

	private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

	@BeforeEach
	public void setUp() {
		this.testWSDestination = new Destination();
		this.testWSDestination.setUri(URI.create(mergeWebServiceUri));
		this.testWSDestination.setSenderApplicationOid(senderApplicationOid);
		this.testWSDestination.setReceiverApplicationOid(receiverApplicationOid);

		this.testScopingOrganization = new Organization().addIdentifier(new Identifier().setValue("Husky").setSystem(FhirCommon.addUrnOid(homeCommunityOid)));
	}

	@Test
	void whenBuildingMergeFeed_andSendingWithService_thenPatientIsMerged() throws Exception {
		String obsolatePatientId = "1634721569120";
		PixMergePatientFeed feed = this.service.createPixMergePatientFeed(testWSDestination, testScopingOrganization,
				obsolatePatientId, homeCommunityOid, homeCommunityNamespace)
				.identifier(new Identifier().setValue("1634641399206").setSystem(FhirCommon.addUrnOid(homeCommunityOid)))
				.identifier(new Identifier().setValue("SPID-1").setSystem(FhirCommon.addUrnOid(spidEprOid)))
				.homeCommunityOID(homeCommunityOid).homeCommunityNamespace(homeCommunityNamespace)
				.obsolatePatientID("1634721569120")
				.birthday(this.dateFormat.parse("19500324"))
				.gender(AdministrativeGender.MALE)
				.build();
		assertTrue(this.service.send(feed));
	}
}
