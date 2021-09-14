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
package org.ehealth_connector.communication.xd;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.net.URISyntaxException;

import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.communication.AffinityDomain;
import org.ehealth_connector.common.communication.Destination;
import org.ehealth_connector.communication.ConvenienceCommunication;
import org.ehealth_connector.communication.testhelper.TestApplication;
import org.ehealth_connector.communication.xd.storedquery.FindDocumentsQuery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AvailabilityStatus;
import org.openehealth.ipf.commons.ihe.xds.core.responses.QueryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Test of class ConvenienceCommunication
 */
@ExtendWith(value = SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = { TestApplication.class })
@EnableAutoConfiguration
@Disabled
public class ConvenienceCommunicationIpfTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(ConvenienceCommunication.class.getName());

	@Autowired
	private ConvenienceCommunication convenienceCommunication;

	final private String repositoryUri = "https://ehealthsuisse.ihe-europe.net:8280/xdstools7/sim/epr-testing__for_doc_source_testing/rep/ret";
	final private String registryUri = "https://ehealthsuisse.ihe-europe.net:8280/xdstools7/sim/epr-testing__for_init_gw_testing/rep/ret";

	final private String applicationName = "2.16.840.1.113883.3.72.6.5.100.1399";
	final private String facilityName = null;

	final private String senderApplicationOid = "1.2.3.4";

	/**
	 * Method implementing
	 *
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		var app = new SpringApplication(TestApplication.class);
		app.setWebApplicationType(WebApplicationType.NONE);

		var context = app.run();
	}

	@Test
	public void contextLoads() {
		assertNotNull(convenienceCommunication);
		assertNotNull(convenienceCommunication.getCamelContext());
	}

	@Test
	public void ITI18QueryMetadataTest() throws Exception {
		LOGGER.debug("ITI18QueryMetadata with ipAdress Target {}", registryUri);

		final AffinityDomain affinityDomain = new AffinityDomain();
		final Destination dest = new Destination();

		try {
			dest.setUri(new URI(registryUri));
		} catch (final URISyntaxException e) {
			e.printStackTrace();
		}
		dest.setSenderApplicationOid(senderApplicationOid);
		dest.setReceiverApplicationOid(applicationName);
		dest.setReceiverFacilityOid(facilityName);
		affinityDomain.setRegistryDestination(dest);
		affinityDomain.setRepositoryDestination(dest);

		Identificator patientId = new Identificator("1.3.6.1.4.1.21367.13.20.3000", "IHEBLUE-2737");

		FindDocumentsQuery findDocumentsQuery = new FindDocumentsQuery(patientId, AvailabilityStatus.APPROVED);

		convenienceCommunication.setAffinityDomain(affinityDomain);
		
		final QueryResponse response = convenienceCommunication.queryDocuments(findDocumentsQuery,
				null);
		assertTrue(response.getErrors().isEmpty());
	}

	@Test
	public void ITI43QueryMetadataTest() throws Exception {
		LOGGER.debug("ITI43QueryMetadata with ipAdress Target {}", registryUri);

		final AffinityDomain affinityDomain = new AffinityDomain();
		final Destination dest = new Destination();

		try {
			dest.setUri(new URI(registryUri));
		} catch (final URISyntaxException e) {
			e.printStackTrace();
		}
		dest.setSenderApplicationOid(senderApplicationOid);
		dest.setReceiverApplicationOid(applicationName);
		dest.setReceiverFacilityOid(facilityName);
		affinityDomain.setRegistryDestination(dest);
		affinityDomain.setRepositoryDestination(dest);

		Identificator patientId = new Identificator("1.3.6.1.4.1.21367.13.20.3000", "IHEBLUE-2737");

		FindDocumentsQuery findDocumentsQuery = new FindDocumentsQuery(patientId, AvailabilityStatus.APPROVED);

		convenienceCommunication.setAffinityDomain(affinityDomain);

		final QueryResponse response = convenienceCommunication.queryDocuments(findDocumentsQuery, null);
		assertTrue(response.getErrors().isEmpty());
	}

}
