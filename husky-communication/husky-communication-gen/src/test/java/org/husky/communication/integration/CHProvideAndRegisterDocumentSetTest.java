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

import org.husky.common.basetypes.NameBaseType;
import org.husky.common.communication.AffinityDomain;
import org.husky.common.communication.Destination;
import org.husky.common.communication.DocumentMetadata;
import org.husky.common.communication.SubmissionSetMetadata;
import org.husky.common.enums.DocumentDescriptor;
import org.husky.common.enums.EhcVersions;
import org.husky.common.enums.LanguageCode;
import org.husky.common.model.Author;
import org.husky.common.model.Code;
import org.husky.common.model.Identificator;
import org.husky.common.model.Name;
import org.husky.communication.ConvenienceCommunication;
import org.husky.communication.testhelper.TestApplication;
import org.husky.communication.testhelper.XdsTestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openehealth.ipf.commons.core.OidGenerator;
import org.openehealth.ipf.commons.ihe.xds.core.responses.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.File;
import java.io.FileInputStream;
import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class to test the ProvideAndRegisterDocumentSet [ITI-41] transaction with Swiss metadata requirements.
 */
@ExtendWith(value = SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = { TestApplication.class })
@EnableAutoConfiguration
class CHProvideAndRegisterDocumentSetTest extends XdsTestUtils {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(CHProvideAndRegisterDocumentSetTest.class.getName());

	@Autowired
	private ConvenienceCommunication convenienceCommunication;

	final private String applicationName = "2.16.840.1.113883.3.72.6.5.100.1399";
	final private String facilityName = null;

	final private String senderApplicationOid = "1.2.3.4";

	private AffinityDomain affinityDomain = null;


	/**
	 * Creates and start spring test application and set the endpoint of XDS Repository.
	 *
	 * @throws Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {

		// create and start spring test application
		var app = new SpringApplication(TestApplication.class);
		app.setWebApplicationType(WebApplicationType.NONE);
		app.run();

		// sets XDS service endpoint
		affinityDomain = new AffinityDomain();
		final Destination dest = new Destination();

		final String repositoryURL = "http://ehealthsuisse.ihe-europe.net:8280/xdstools7/sim/epr-testing__for_init_gw_testing/rep/prb";
		dest.setUri(new URI(repositoryURL));

		dest.setSenderApplicationOid(senderApplicationOid);
		dest.setReceiverApplicationOid(applicationName);
		dest.setReceiverFacilityOid(facilityName);

		affinityDomain.setRegistryDestination(dest);
		affinityDomain.setRepositoryDestination(dest);

		// remove cached documents in ConvenienceCommunication
		convenienceCommunication.clearDocuments();
	}

	/**
	 * This method checks if initialization of {@link ConvenienceCommunication} was
	 * correct.
	 */
	@Test
	void contextLoads() {
		assertNotNull(convenienceCommunication);
		assertNotNull(convenienceCommunication.getCamelContext());
	}

	/**
	 * This test checks the behavior of the
	 * {@link ConvenienceCommunication#submit(SubmissionSetMetadata, org.husky.xua.core.SecurityHeaderElement, String)}
	 * when a PDF document is submitted with separate submission set metadata.
	 * 
	 * @throws Exception
	 */
	@Test
	void submitJSONDocTest() throws Exception {

		convenienceCommunication.setAffinityDomain(affinityDomain);
		convenienceCommunication.clearDocuments();

		// read and add file
		final File file = new File("src/test/resources/docSource/FHIR-Vaccination.json");
		final DocumentMetadata documentMetadata = convenienceCommunication.addDocument(DocumentDescriptor.FHIR_JSON, new FileInputStream(file));

		documentMetadata.setTitle("Impfung");

		// set the author data
		final Name name = new Name(new NameBaseType());
		name.setGiven("Gerald");
		name.setFamily("Smitty");

		final Author author = new Author();
		author.addName(name);

		final Code role = new Code("HCP", "2.16.756.5.30.1.127.3.10.1.1.3", "Healthcare professional");
		author.setRoleFunction(role);

		documentMetadata.addAuthor(author);

		final Identificator globalPatientId = new Identificator("1.3.6.1.4.1.21367.13.20.1000", "IHERED-1024");
		documentMetadata.setDestinationPatientId(globalPatientId); // TODO verify

		final Identificator localPatientId = new Identificator("1.2.3.4", "2342134localid");
		documentMetadata.setSourcePatientId(localPatientId);

		documentMetadata.setCodedLanguage(LanguageCode.GERMAN_CODE);

		final Code type = new Code("419891008", "2.16.840.1.113883.6.96", "Record artifact (record artifact)");
		documentMetadata.setTypeCode(type);

		final Code format = new Code("urn:ihe:iti:xds-sd:pdf:2008", "1.3.6.1.4.1.19376.1.2.3",
				"1.3.6.1.4.1.19376.1.2.20 (Scanned Document)");
		documentMetadata.setFormatCode(format);

		final Code clazz = new Code("184216000", "2.16.840.1.113883.6.96", "Patient record type (record artifact)");
		documentMetadata.setClassCode(clazz);

		final Code facility = new Code("394747008", "2.16.840.1.113883.6.96", "Health Authority");
		documentMetadata.setHealthcareFacilityTypeCode(facility);

		final Code practice = new Code("394802001", "2.16.840.1.113883.6.96", "General medicine (qualifier value)");
		documentMetadata.setPracticeSettingCode(practice);

		final Code confidentiality = new Code("17621005", "2.16.840.1.113883.6.96", "Normal (qualifier value)");
		documentMetadata.addConfidentialityCode(confidentiality);


		// submission set metadata settings
		final SubmissionSetMetadata submissionSetMetadata = new SubmissionSetMetadata();
		setSubmissionMetadata(submissionSetMetadata, globalPatientId);

		submissionSetMetadata.getAuthor().add(authorPerson);
		submissionSetMetadata.setUniqueId(OidGenerator.uniqueOid().toString());

		submissionSetMetadata.setSourceId(EhcVersions.getCurrentVersion().getOid());
		submissionSetMetadata.setEntryUUID(UUID.randomUUID().toString());

		submissionSetMetadata.setDestinationPatientId(globalPatientId); // TODO verify

		final Code contentType = new Code("71388002", "2.16.840.1.113883.6.96", "Procedure (procedure)");
		submissionSetMetadata.setContentTypeCode(contentType);


		// provide and register the document
		final Response response = convenienceCommunication.submit(submissionSetMetadata, null, null);

		// checks whether the document has been successfully submitted
		assertTrue(response.getErrors().isEmpty());
		assertEquals(Status.SUCCESS, response.getStatus());
	}

}
