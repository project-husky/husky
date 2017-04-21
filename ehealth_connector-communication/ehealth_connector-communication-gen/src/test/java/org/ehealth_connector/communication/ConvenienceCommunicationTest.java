/*
 * 
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 * 
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
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

import static org.junit.Assert.assertNotNull;

import java.net.URISyntaxException;

import org.ehealth_connector.common.utils.Util;
import org.ehealth_connector.communication.AtnaConfig.AtnaConfigMode;
import org.ehealth_connector.communication.DocumentMetadata.DocumentMetadataExtractionMode;
import org.ehealth_connector.communication.SubmissionSetMetadata.SubmissionSetMetadataExtractionMode;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openhealthtools.ihe.xds.document.DocumentDescriptor;
import org.openhealthtools.ihe.xds.response.XDSQueryResponseType;

@Ignore
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

	@Before
	public void init() {
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
	}

	@Test
	public void testAddDocument() {
		try {
			final DocumentMetadata d = c.addDocument(DocumentDescriptor.CDA_R2, cdaFilePath);
			assertNotNull(d.getMdhtDocumentEntryType().getEntryUUID());
			assertNotNull(c.getTxnData());
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}
