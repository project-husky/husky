/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2015
 *
 *******************************************************************************/
package org.ehealth_connector.communication;

import static org.junit.Assert.assertNotNull;

import java.net.URISyntaxException;

import org.ehealth_connector.communication.AtnaConfig.AtnaConfigMode;
import org.junit.Before;
import org.junit.Test;
import org.openhealthtools.ihe.xds.document.DocumentDescriptor;
import org.openhealthtools.ihe.xds.response.XDSQueryResponseType;

public class ConvenienceCommunicationTest {

	// NIST Repository
	public static final String NIST = "http://ihexds.nist.gov/tf6/services/xdsrepositoryb";

	public static final String NIST_CONSUMER = "http://localhost:8888/xdstools2/sim/b5e2987f-ceaf-44dd-91a3-903c202f9812/rep/rb";

	// NIST SECURED Repository (query interface)
	public static final String NIST_SECURED = "https://ihexds.nist.gov:12091/tf6/services/xdsrepositoryb";
	// Keystore and Truststore for secured communication (in this example, we
	// use one keystore file for those two)
	public static final String KEY_STORE = "../demo/java/ehealthconnectorDemo/rsc/demoDocSource/security/keystore";
	public static final String KEY_STORE_PASS = "nistbill";
	public static final String TRUST_STORE = "../demo/java/ehealthconnectorDemo/rsc/demoDocSource/security/keystore";
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
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		repo = new Destination(ORGANIZATIONAL_ID, repUri, KEY_STORE, KEY_STORE_PASS, TRUST_STORE,
				TRUST_STORE_PASS);

		affinityDomain = new AffinityDomain(null, null, repo);

		try {

			c = new ConvenienceCommunication(affinityDomain, AtnaConfigMode.UNSECURE,
					DocumentMetadataExtractionMode.defaultExtraction,
					SubmissionSetMetadataExtractionMode.defaultExtraction);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testAddDocument() {
		try {
			DocumentMetadata d = c.addDocument(DocumentDescriptor.CDA_R2, cdaFilePath);
			assertNotNull(d.getMdhtDocumentEntryType().getEntryUUID());
			assertNotNull(c.getTxnData());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
