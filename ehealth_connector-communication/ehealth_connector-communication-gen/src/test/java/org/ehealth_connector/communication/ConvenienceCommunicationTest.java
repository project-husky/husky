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
package org.ehealth_connector.communication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.ehealth_connector.common.communication.AffinityDomain;
import org.ehealth_connector.common.communication.AtnaConfig.AtnaConfigMode;
import org.ehealth_connector.common.communication.Destination;
import org.ehealth_connector.common.communication.DocumentMetadata;
import org.ehealth_connector.common.communication.DocumentMetadata.DocumentMetadataExtractionMode;
import org.ehealth_connector.common.communication.SubmissionSetMetadata.SubmissionSetMetadataExtractionMode;
import org.ehealth_connector.common.utils.Util;
import org.ehealth_connector.xua.deserialization.impl.AssertionDeserializerImpl;
import org.ehealth_connector.xua.exceptions.DeserializeException;
import org.ehealth_connector.xua.exceptions.SerializeException;
import org.ehealth_connector.xua.saml2.Assertion;
import org.ehealth_connector.xua.serialization.impl.AssertionSerializerImpl;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openhealthtools.ihe.xds.document.DocumentDescriptor;
import org.openhealthtools.ihe.xds.response.XDSQueryResponseType;
import org.openhealthtools.ihe.xua.XUAAssertion;
import org.openhealthtools.ihe.xua.context.XUAModuleContext;
import org.opensaml.core.config.InitializationException;
import org.opensaml.core.config.InitializationService;
import org.w3c.dom.Element;

public class ConvenienceCommunicationTest {

	// NIST Repository
	public static final String NIST = "http://ihexds.nist.gov/tf6/services/xdsrepositoryb";

	public static final String NIST_CONSUMER = "http://localhost:8888/xdstools2/sim/b5e2987f-ceaf-44dd-91a3-903c202f9812/rep/rb";

	// NIST SECURED Repository (query interface)
	public static final String NIST_SECURED = "https://ihexds.nist.gov:12091/tf6/services/xdsrepositoryb";
	// Keystore and Truststore for secured communication (in this example, we
	// use one keystore file for those two)
	// public static final String KEY_STORE =
	// "../demo/java/ehealthconnectorDemo/rsc/demoDocSource/security/keystore.jks";
	public static final String KEY_STORE = "docConsumer/security/keystore.jks";
	public static final String KEY_STORE_PASS = "nistbill";
	// public static final String TRUST_STORE =
	// "../demo/java/ehealthconnectorDemo/rsc/demoDocSource/security/keystore.jks";
	public static final String TRUST_STORE = "docConsumer/security/keystore.jks";
	public static final String TRUST_STORE_PASS = "nistbill";

	// The ID of your Organization
	public static final String ORGANIZATIONAL_ID = "1.3.6.1.4.1.21367.2010.1.2.666";

	// One PDF and one CDA Document that will be transfered
	public static final String pdfFileName = "patientconsent.pdf";
	public static final String cdaFilePath = "../demo/java/ehealthconnectorDemo/rsc/demoDocSource/CDA-CH-VACD_Impfausweis.xml";

	java.net.URI repUri;
	AffinityDomain affinityDomain;
	Destination repo;
	ConvenienceCommunication c;
	XDSQueryResponseType qr;
	private Assertion testAssertion;

	@Before
	public void init()
			throws IOException, URISyntaxException, DeserializeException, InitializationException {
		try {
			repUri = new java.net.URI(NIST_SECURED);
		} catch (final URISyntaxException e) {
			e.printStackTrace();
		}

		final String keystore = Util.extractFileFromResource(KEY_STORE);
		final String truststore = Util.extractFileFromResource(TRUST_STORE);
		repo = new Destination(ORGANIZATIONAL_ID, repUri, keystore, KEY_STORE_PASS, truststore,
				TRUST_STORE_PASS);

		affinityDomain = new AffinityDomain(null, null, repo);

		try {

			c = new ConvenienceCommunication(affinityDomain, AtnaConfigMode.UNSECURE,
					DocumentMetadataExtractionMode.DEFAULT_EXTRACTION,
					SubmissionSetMetadataExtractionMode.DEFAULT_EXTRACTION);
		} catch (final Exception e) {
			e.printStackTrace();
		}

		InitializationService.initialize();
		final byte[] aByteArray = readInputFile(this.getClass().getResource("/xua/assertion.xml"));
		testAssertion = new AssertionDeserializerImpl().fromXmlByteArray(aByteArray);
	}

	private byte[] readInputFile(URL url) throws IOException, URISyntaxException {

		final File file = new File(url.toURI());
		final Path path = Paths.get(file.getParent(), file.getName());
		return Files.readAllBytes(path);
	}

	@Test
	@Ignore
	public void testAddDocument() {
		try {
			final DocumentMetadata d = c.addDocument(DocumentDescriptor.CDA_R2, cdaFilePath);
			assertNotNull(d.getMdhtDocumentEntryType().getEntryUUID());
			assertNotNull(c.getTxnData());
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testAddXUserAssertion() throws SerializeException {
		c.addXUserAssertion(testAssertion);

		final XUAModuleContext xuaContext = XUAModuleContext.getContext();
		assertTrue(xuaContext.isXUAEnabled());

		final List<String> activeActions = xuaContext.getConfig().getXUAEnabledActions();
		assertNotNull(activeActions);
		assertTrue(activeActions.contains("urn:ihe:iti:2007:ProvideAndRegisterDocumentSet-b"));

		final XUAAssertion activeAssertion = xuaContext.getActiveAssertion();
		assertNotNull(activeAssertion);

	}

	@Test
	public void testCreateXUAAssertion() throws SerializeException {
		final Element assertionElement = new AssertionSerializerImpl().toXmlElement(testAssertion);
		final XUAAssertion ohtAssertion = new XUAAssertion(assertionElement);
		final String atnaUserName = ohtAssertion.getAtnaUsername();
		assertNotNull(atnaUserName);
		assertEquals("<7601000080776@https://ehealthsuisse.ihe-europe.net/STS>", atnaUserName);
	}
}
