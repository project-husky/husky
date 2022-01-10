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
package org.husky.communication;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URISyntaxException;

import org.husky.common.communication.Destination;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DestinationTest {

	public static final String NIST = "http://test.url";

	// NIST SECURED Repository (query interface)
	public static final String NIST_SECURED = "https://test.url";
	// Keystore and Truststore for secured communication (in this example, we
	// use one keystore file for those two)
	public static final String KEY_STORE = "docConsumer/security/keystore.jks";
	public static final String KEY_STORE_PASS = "nistbill";
	public static final String TRUST_STORE = "docConsumer/security/keystore.jks";
	public static final String TRUST_STORE_PASS = "nistbill";

	// The ID of your Organization
	public static final String ORGANIZATIONAL_ID = "1.3.6.1.4.1.21367.2010.1.2.666";

	// One PDF and one CDA Document that will be transfered
	public static final String pdfFilePath = "./rsc/patientconsent.pdf";
	public static final String cdaFilePath = "./rsc/CDA-CH-VACD_Impfausweis.xml";

	java.net.URI repUri = null;
	java.net.URI u1 = null;
	java.net.URI u2 = null;

	@BeforeEach
	public void init() {
		try {
			repUri = new java.net.URI(NIST_SECURED);
			u1 = new java.net.URI("https://foo.bar:9090");
			u2 = new java.net.URI("http://eheahlt-connector.org");
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testKeyStoreConstructor() {
		Destination dest = new Destination(ORGANIZATIONAL_ID, repUri, KEY_STORE, KEY_STORE_PASS);
		assertEquals(ORGANIZATIONAL_ID, dest.getSenderOrganizationalOid());
		assertEquals(repUri, dest.getUri());
		assertEquals(KEY_STORE, dest.getKeyStore());
		assertEquals(KEY_STORE_PASS, dest.getKeyStorePassword());
		assertEquals(KEY_STORE, dest.getTrustStore());
		assertEquals(KEY_STORE_PASS, dest.getTrustStorePassword());
	}

	@Test
	void testKeyStoreTrustStoreConstructor() {
		Destination dest = new Destination(ORGANIZATIONAL_ID, repUri, KEY_STORE, KEY_STORE_PASS,
				TRUST_STORE, TRUST_STORE_PASS);
		assertEquals(ORGANIZATIONAL_ID, dest.getSenderOrganizationalOid());
		assertEquals(repUri, dest.getUri());
		assertEquals(KEY_STORE, dest.getKeyStore());
		assertEquals(KEY_STORE_PASS, dest.getKeyStorePassword());
		assertEquals(TRUST_STORE, dest.getTrustStore());
		assertEquals(TRUST_STORE_PASS, dest.getTrustStorePassword());
	}

	@Test
	void testSetterGetter() {
		Destination dest = new Destination();
		dest.setKeyStore(KEY_STORE);
		assertEquals(KEY_STORE, dest.getKeyStore());
		dest.setKeyStorePassword(KEY_STORE_PASS);
		assertEquals(KEY_STORE_PASS, dest.getKeyStorePassword());
		dest.setUri(u1);
		assertEquals(u1, dest.getUri());
		dest.setUri(u2);
		assertEquals(u2, dest.getUri());
		dest.setReceiverApplicationOid("1");
		assertEquals("1", dest.getReceiverApplicationOid());
		dest.setReceiverFacilityOid(ORGANIZATIONAL_ID);
		assertEquals(ORGANIZATIONAL_ID, dest.getReceiverFacilityOid());
		dest.setUri(repUri);
		assertEquals(repUri, dest.getUri());
		dest.setSenderApplicationOid(ORGANIZATIONAL_ID);
		assertEquals(ORGANIZATIONAL_ID, dest.getSenderApplicationOid());
		dest.setSenderOrganizationalOid(ORGANIZATIONAL_ID);
		assertEquals(ORGANIZATIONAL_ID, dest.getSenderOrganizationalOid());
		dest.setTrustStore(TRUST_STORE);
		assertEquals(TRUST_STORE, dest.getTrustStore());
		dest.setTrustStorePassword(TRUST_STORE_PASS);
		assertEquals(TRUST_STORE_PASS, dest.getTrustStorePassword());
	}
}
