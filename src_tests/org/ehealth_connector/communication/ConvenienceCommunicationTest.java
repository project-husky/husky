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

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.XdsUtil;
import org.ehealth_connector.communication.ch.enums.AvailabilityStatus;
import org.ehealth_connector.communication.ch.storedquery.*;
import org.openhealthtools.ihe.xds.consumer.B_Consumer;
import org.openhealthtools.ihe.xds.consumer.retrieve.DocumentRequestType;
import org.openhealthtools.ihe.xds.consumer.retrieve.RetrieveDocumentSetRequestType;
import org.openhealthtools.ihe.xds.consumer.storedquery.MalformedStoredQueryException;
import org.openhealthtools.ihe.xds.document.DocumentDescriptor;
import org.openhealthtools.ihe.xds.metadata.AvailabilityStatusType;
import org.openhealthtools.ihe.xds.response.XDSQueryResponseType;
import org.openhealthtools.ihe.xds.response.XDSRetrieveResponseType;
import org.openhealthtools.ihe.xds.utils.XDSUtils;

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
	public static final String pdfFilePath = "../demo/java/ehealthconnectorDemo/rsc/demoDocSource/patientconsent.pdf";
	public static final String cdaFilePath = "../demo/java/ehealthconnectorDemo/rsc/demoDocSource/CDA-CH-VACD_Impfausweis.xml";
	java.net.URI repUri;
	Destination dest;
	ConvenienceCommunication c;

	@Before
	public void init() {
		try {
			repUri = new java.net.URI(NIST_SECURED);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		dest = new Destination(ORGANIZATIONAL_ID, repUri, KEY_STORE, KEY_STORE_PASS, TRUST_STORE,
				TRUST_STORE_PASS);

		try {
			c = new ConvenienceCommunication(dest, false);
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

	@Test
	public void testConstructors() {
		// Set System Properties to null
		System.setProperty("javax.net.ssl.keyStore", "Null");
		System.setProperty("javax.net.ssl.keyStorePassword", "Null");
		System.setProperty("javax.net.ssl.trustStore", "Null");
		System.setProperty("javax.net.ssl.trustStorePassword", "Null");

		try {
			c = new ConvenienceCommunication(dest, false);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Check if the System Properties have been set
		assertEquals(KEY_STORE, System.getProperty("javax.net.ssl.keyStore"));
		assertEquals(KEY_STORE_PASS, System.getProperty("javax.net.ssl.keyStorePassword"));
		assertEquals(TRUST_STORE, System.getProperty("javax.net.ssl.trustStore"));
		assertEquals(TRUST_STORE_PASS, System.getProperty("javax.net.ssl.trustStorePassword"));
	}
	
	@Test
	public void testXdsConsumerQueries() {
		//Create query
		try {
			String host = "ahdis-ihetest.cloudapp.net:8100/";
			String registryUrl = "http://" + host
					+ "/xdstools2/sim/305cd4eb-1724-45ae-b489-d10678342c97/reg/sq";
			String repositoryUrl = "http://" + host
					+ "/xdstools2/sim/305cd4eb-1724-45ae-b489-d10678342c97/rep/prb";
			dest.setRegistryUri(URI.create(registryUrl));
						
			FindDocumentsQuery q = new FindDocumentsQuery(new Identificator("1.3.6.1.4.1.21367.13.20.2005.1000", "IHERED-1644"), null, null, null, null, null, null, null, AvailabilityStatus.APPROVED);
			XDSQueryResponseType qr = c.invokeStoredQuery(q.getOhtStoredQuery(), false);
			
			if (qr.getErrorList() != null) {
				System.out.println("ERRORS: "+qr.getErrorList().toString());
			}
			else {
				System.out.println("No Errors.");
			}
			System.out.println("Found Documents: "+qr.getDocumentEntryResponses().size());
			assertEquals(qr.getErrorList(),null);
		} catch (MalformedStoredQueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testXdsConsumerRetrieve() {
		String host = "ahdis-ihetest.cloudapp.net:8100/";
		String repositoryUrlRetrieve = "http://" + host
				+ "/xdstools2/sim/305cd4eb-1724-45ae-b489-d10678342c97/rep/ret";
		String registryUrl = "http://" + host
				+ "/xdstools2/sim/305cd4eb-1724-45ae-b489-d10678342c97/reg/sq";
		
		//TODO
		//1. Create DocumentRequest Object (Convencience Version of DocumentRequestType, without Factory)
		//2. Set DocumentRequest Parameters
		//3. Create XdsRepository Object
		//4. Create Destination Object (Constructor for One and one for more Repositories)
		//5. Add to Destination Object
		//6. Create ConvenienceCommunication with Destination Object
		//7. Use ConvenienceCommunication with (DocumentRequest, PatientId)
		//8. Check for errors and attachments and print inputStream
		
		//c.getConfig().setAuditorEnabled(false);
		
		//1. & 2.
		DocumentRequest docReq = new DocumentRequest("1.1.4567332.1.1", "69d1a952-29c8-9024-8ab8-afee90bf9db4", null);
		
		//3.
		XdsRepository xdsRep = null;
		try {
			xdsRep = new XdsRepository("1.1.4567332.1.1", new URI(repositoryUrlRetrieve));
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//4. TODO
		
		//5.
		dest.addXdsRepository(xdsRep);
		
		//6.
		c.setDestination(dest);
		
		//7.
		XDSRetrieveResponseType rrt = c.retrieveDocumentSet(docReq, new Identificator("1.3.6.1.4.1.21367.13.20.2005.1000", "IHERED-1644"));
		System.out.println("Errors: "+rrt.getErrorList()+". Found "+rrt.getAttachments().size()+" Documents.");
		
//		BufferedReader reader = new BufferedReader(new InputStreamReader(rrt.getAttachments().get(0).getStream()));
//        StringBuilder out = new StringBuilder();
//        String line;
//        try {
//			while ((line = reader.readLine()) != null) {
//			    out.append(line);
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        System.out.println(out.toString());   //Prints the string content read from input stream
//        try {
//			reader.close();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//d.getAuditor().getConfig().setAuditorEnabled(false);
		
		
//		dest.setRegistryUri(URI.create(registryUrl));
//		
//		java.net.URI initiatingGatewayUrl = null;
//		HashMap repositoryUriMap = null;
//		try {
//			dest.addXdsRepository(new XdsRepository("1.1.4567332.1.1", new java.net.URI(repositoryUrlRetrieve)));
//			
//			repositoryUriMap = new HashMap();
//			
//			initiatingGatewayUrl = new java.net.URI("http://38.112.155.180:8080/ServicesGE/HS.IHE.XCA.InitiatingGateway.Services.cls");
//			repositoryUriMap.put("1.3.6.1.4.1.21367.2009.1.2.1030", new java.net.URI("http://38.112.155.180:8080/ServicesGE/HS.IHE.XCA.InitiatingGateway.Services.cls"));
//			repositoryUriMap.put("1.19.6.24.109.42.1.6", new java.net.URI("http://localhost:8080/axis2/services/XDSBRepository"));
//			repositoryUriMap.put("1.1.4567332.1.1", new java.net.URI(repositoryUrlRetrieve));
//		} catch (URISyntaxException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		//TODO: Konfiguration der Repositories in das Destination Objekt auslagern. Ebenso: Initiating Gateway.
//		B_Consumer d = new B_Consumer(URI.create(registryUrl), initiatingGatewayUrl, repositoryUriMap);
//		

//		
//		RetrieveDocumentSetRequestType retrieveRequest = org.openhealthtools.ihe.xds.consumer.retrieve.RetrieveFactory.eINSTANCE.createRetrieveDocumentSetRequestType();
//		XDSRetrieveResponseType rrt = d.retrieveDocumentSet(retrieveRequest, XdsUtil.convertIdentificator(new Identificator("1.3.6.1.4.1.21367.13.20.2005.1000", "IHERED-1644")));
//		rrt.getAttachments();
//		//XDSRetrieveResponseType rr = d.retrieveDocumentSet(new Identificator("1.3.6.1.4.1.21367.13.20.2005.1000", "IHERED-1644"), docReq);
	}
}
