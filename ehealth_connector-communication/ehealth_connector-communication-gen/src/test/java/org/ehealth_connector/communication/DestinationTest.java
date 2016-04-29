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

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.net.URISyntaxException;

import org.junit.Before;
import org.junit.Test;

public class DestinationTest {

	public static final String NIST = "http://ihexds.nist.gov/tf6/services/xdsrepositoryb";

	// NIST SECURED Repository (query interface)
	public static final String NIST_SECURED = "https://ihexds.nist.gov:12091/tf6/services/xdsrepositoryb";
	// Keystore and Truststore for secured communication (in this example, we
	// use one keystore file for those two)
	public static final String KEY_STORE = "src/test/resources/security/keystore.jks";
	public static final String KEY_STORE_PASS = "nistbill";
	public static final String TRUST_STORE = "src/test/resources/security/keystore.jks";
	public static final String TRUST_STORE_PASS = "nistbill";

	// The ID of your Organization
	public static final String ORGANIZATIONAL_ID = "1.3.6.1.4.1.21367.2010.1.2.666";

	// One PDF and one CDA Document that will be transfered
	public static final String pdfFilePath = "./rsc/patientconsent.pdf";
	public static final String cdaFilePath = "./rsc/CDA-CH-VACD_Impfausweis.xml";

	java.net.URI repUri = null;
	java.net.URI u1 = null;
	java.net.URI u2 = null;

	@Before
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
	public void testKeyStoreConstructor() {
		File keyFile = new File(System.getProperty("user.dir"), KEY_STORE);
		final String keystore = keyFile.getAbsolutePath();
		
		Destination dest = new Destination(ORGANIZATIONAL_ID, repUri, keystore, KEY_STORE_PASS);
		assertEquals(ORGANIZATIONAL_ID, dest.getSenderOrganizationalOid());
		assertEquals(repUri, dest.getUri());
		assertEquals(keystore, dest.getKeyStore());
		assertEquals(KEY_STORE_PASS, dest.getKeyStorePassword());
		assertEquals(keystore, dest.getTrustStore());
		assertEquals(KEY_STORE_PASS, dest.getTrustStorePassword());
	}

	@Test
	public void testKeyStoreTrustStoreConstructor() {
		File keyFile = new File(System.getProperty("user.dir"), KEY_STORE);
		final String keystore = keyFile.getAbsolutePath();
		File trustFile = new File(System.getProperty("user.dir"), TRUST_STORE);
		final String truststore = trustFile.getAbsolutePath();
		Destination dest = new Destination(ORGANIZATIONAL_ID, repUri, keystore, KEY_STORE_PASS,
				truststore, TRUST_STORE_PASS);
		assertEquals(ORGANIZATIONAL_ID, dest.getSenderOrganizationalOid());
		assertEquals(repUri, dest.getUri());
		assertEquals(keystore, dest.getKeyStore());
		assertEquals(KEY_STORE_PASS, dest.getKeyStorePassword());
		assertEquals(truststore, dest.getTrustStore());
		assertEquals(TRUST_STORE_PASS, dest.getTrustStorePassword());
	}

	@Test
	public void testSetterGetter() {
		Destination dest = new Destination();
		File keyFile = new File(System.getProperty("user.dir"), KEY_STORE);
		final String keystore = keyFile.getAbsolutePath();
		dest.setKeyStore(keystore);
		assertEquals(keystore, dest.getKeyStore());
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
		
		File trustFile = new File(System.getProperty("user.dir"), TRUST_STORE);
		final String truststore = trustFile.getAbsolutePath();
		dest.setTrustStore(truststore);
		assertEquals(truststore, dest.getTrustStore());
		dest.setTrustStorePassword(TRUST_STORE_PASS);
		assertEquals(TRUST_STORE_PASS, dest.getTrustStorePassword());
	}
}
