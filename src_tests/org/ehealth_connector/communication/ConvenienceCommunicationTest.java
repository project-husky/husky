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
* Attribution-ShareAlike 4.0 Switzerland License.
*
 * Year of publication: 2015
*
 *******************************************************************************/
package org.ehealth_connector.communication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.net.URISyntaxException;

import org.junit.Before;
import org.junit.Test;
import org.openhealthtools.ihe.xds.document.DocumentDescriptor;

public class ConvenienceCommunicationTest {

  // NIST Repository
  public static final String NIST = "http://ihexds.nist.gov/tf6/services/xdsrepositoryb";

  // NIST SECURED Repository (query interface)
  public static final String NIST_SECURED = "https://ihexds.nist.gov:12091/tf6/services/xdsrepositoryb";
  //Keystore and Truststore for secured communication (in this example, we use one keystore file for those two)
  public static final String KEY_STORE = "./rsc/security/keystore";
  public static final String KEY_STORE_PASS ="nistbill";
  public static final String TRUST_STORE="./rsc/security/keystore";
  public static final String TRUST_STORE_PASS="nistbill";

  //The ID of your Organization
  public static final String ORGANIZATIONAL_ID ="1.3.6.1.4.1.21367.2010.1.2.666";

  //One PDF and one CDA Document that will be transfered
  public static final String pdfFilePath = "./rsc/test/patientconsent.pdf";
  public static final String cdaFilePath = "./rsc/test/CDA-CH-VACD_Impfausweis.xml";
  java.net.URI repUri;
  Destination dest;
  ConvenienceCommunication c;

  @Before
  public void init() {
    try {
      repUri = new java.net.URI(NIST_SECURED);
    } catch (URISyntaxException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    dest = new Destination(ORGANIZATIONAL_ID, repUri, KEY_STORE, KEY_STORE_PASS, TRUST_STORE, TRUST_STORE_PASS);

    try {
      c = new ConvenienceCommunication(dest, false, null);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Test 
  public void testAddDocument() {
    try {
      DocumentMetadata d = c.addDocument(DocumentDescriptor.CDA_R2, cdaFilePath);
      assertNotNull(d.getMdhtDocumentEntryType().getEntryUUID());
      assertNotNull(c.txnData);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

  @Test
  public void testConstructors() {   
    //Set System Properties to null
    System.setProperty("javax.net.ssl.keyStore","Null");
    System.setProperty("javax.net.ssl.keyStorePassword","Null");
    System.setProperty("javax.net.ssl.trustStore","Null");
    System.setProperty("javax.net.ssl.trustStorePassword","Null");
    //System.out.println("keyPw: "+System.getProperty("javax.net.ssl.keyStore"));

    ConvenienceCommunication c;
    try {
      c = new ConvenienceCommunication(dest, false, null);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    //Check if the System Properties have been set
    assertEquals(KEY_STORE, System.getProperty("javax.net.ssl.keyStore"));
    assertEquals(KEY_STORE_PASS, System.getProperty("javax.net.ssl.keyStorePassword"));
    assertEquals(TRUST_STORE, System.getProperty("javax.net.ssl.trustStore"));
    assertEquals(TRUST_STORE_PASS, System.getProperty("javax.net.ssl.trustStorePassword"));
  }
}
