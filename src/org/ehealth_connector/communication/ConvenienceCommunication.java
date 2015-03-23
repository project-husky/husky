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

import java.io.InputStream;
import java.security.KeyStore;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.DateUtil;
import org.ehealth_connector.common.XdsUtil;
import org.openhealthtools.ihe.atna.auditor.XDSSourceAuditor;
import org.openhealthtools.ihe.common.hl7v2.CX;
import org.openhealthtools.ihe.utils.OID;
import org.openhealthtools.ihe.xds.document.DocumentDescriptor;
import org.openhealthtools.ihe.xds.document.XDSDocument;
import org.openhealthtools.ihe.xds.document.XDSDocumentFromStream;
import org.openhealthtools.ihe.xds.metadata.AuthorType;
import org.openhealthtools.ihe.xds.metadata.SubmissionSetType;
import org.openhealthtools.ihe.xds.response.XDSResponseType;
import org.openhealthtools.ihe.xds.source.B_Source;
import org.openhealthtools.ihe.xds.source.SubmitTransactionData;

/**
 * <p>
 * Die ConvenienceCommunication Klasse stellt Methoden für die Kommunikation von
 * CDA-Dokumenten mit IHE Transaktionen von und zu einer beliebigen Destination
 * bereit.
 * 
 * Die Klasse implementiert folgende IHE Akteure und Transaktionen:
 * <ul>
 * <li><b>IHE ITI Document Source Akteur</b></li>
 * <ul>
 * <li>[ITI-41] Provide & Register Document Set – b</li>
 * </ul>
 * <li><b>IHE ITI Document Consumer Akteur</b></li>
 * <ul>
 * <li>[ITI-18] Registry Stored Query</li>
 * <li>[ITI-43] Retrieve Document Set</li>
 * </ul>
 * <li><b>IHE ITI Portable Media Creator und Media Importer Akteur</b></li>
 * <ul>
 * <li>[ITI-32] Distribute Document Set on Media</li>
 * </ul>
 * <li><b>IHE PCC Care Manager und Decision Support Service Akteur</b></li>
 * <ul>
 * <li>[PCC-12] Request for Clinical Guidance</li>
 * </ul>
 * </ul>
 * </p>
 */
public class ConvenienceCommunication {

	private static void setSSLFactories(InputStream keyStream,
			String keyStorePassword, InputStream trustStream,
			String trustStorePassword) throws Exception {
		// Get keyStore
		KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());

		// if your store is password protected then declare it (it can be null
		// however)
		char[] keyPassword = keyStorePassword.toCharArray();

		// load the stream to your store
		keyStore.load(keyStream, keyPassword);

		// initialize a trust manager factory with the trusted store
		KeyManagerFactory keyFactory = KeyManagerFactory
				.getInstance(KeyManagerFactory.getDefaultAlgorithm());
		keyFactory.init(keyStore, keyPassword);

		// get the trust managers from the factory
		KeyManager[] keyManagers = keyFactory.getKeyManagers();

		// Now get trustStore
		KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());

		// if your store is password protected then declare it (it can be null
		// however)
		char[] trustPassword = trustStorePassword.toCharArray();

		// load the stream to your store
		trustStore.load(trustStream, trustPassword);

		// initialize a trust manager factory with the trusted store
		TrustManagerFactory trustFactory = TrustManagerFactory
				.getInstance(TrustManagerFactory.getDefaultAlgorithm());
		trustFactory.init(trustStore);

		// get the trust managers from the factory
		TrustManager[] trustManagers = trustFactory.getTrustManagers();

		// initialize an ssl context to use these managers and set as default
		sslContext = SSLContext.getInstance("SSL");
		sslContext.init(keyManagers, trustManagers, null);
		SSLContext.setDefault(sslContext);
	}

	// IBM Audit Repository
	// public static final String IBM_ARR ="syslog://lswin10.dfw.ibm.com:515";

	static SSLContext sslContext;

	// /**
	// * <p>
	// * Anfrage einer Impfempfehlung (pseudonymisiert das Dokument vor dem
	// * eigentlichen Versand ans Expertensystem). Die Kommunikation zum
	// * Kommunikations-Endpunkt erfolgt gemäss <b>IHE [PCC-12] Request for
	// Clinical
	// * Guidance</b>.
	// * </p>
	// * <p>
	// * Rolle der API resp. der aufrufenden Anwendung für diese Methode: <b>IHE
	// PCC
	// * Care Manager Akteur</b>
	// * </p>
	// *
	// * @param destination
	// * Ziel der Übertragung (Kommunikations-Endpunkt)
	// * @param doc
	// * CDA-CH-VACD Dokument mit den Impfungen und anderen für die
	// * Impfempfehlung relevanten Angaben eines Patienten.
	// * @return CDA-CH-VACD Dokument, welches mit dem Parameter doc übergeben
	// * worden ist und nun zusätzlich die Section mit den Impfempfehlungen
	// * enthält
	// *
	// * @throws Exception
	// * Fehler während der Übertragung
	// */
	// public static CdaChVacd getImmunizationRecommendationRequest(
	// Destination destination, CdaChVacd doc) throws Exception {
	// //TODO
	// return null;
	// }
	//
	// /**
	// * <p>
	// * Lädt CDA-Dokumente von einem Medium (Datenträger oder Pfad im
	// Dateisystem;
	// * gemäss IHE XDM). Die Verarbeitung des Mediums erfolgt gemäss
	// <b>[ITI-32]
	// * Distribute Document Set on Media</b>.
	// * </p>
	// * <p>
	// * Rolle der API resp. der aufrufenden Anwendung für diese Methode: <b>IHE
	// ITI
	// * Portable Media Importer Akteur</b>
	// * </p>
	// *
	// * @param destination Pfad zum Datenträger von dem XDM-konforme Daten
	// geladen werden
	// * @return eine Liste von CDA-Dokumenten
	// * @throws Exception the exception
	// */
	// public static ArrayList<ClinicalDocument> parseStoredCdaChVacd(File
	// destination)
	// throws Exception {
	// //TODO
	// return null;
	// }
	//
	// /**
	// * Speichert ein CDA Dokument für den Versand zu einer beliebigen
	// Destination
	// * auf einem Medium.
	// *
	// * @param destination Ziel der Übertragung (Kommunikations-Endpunkt)
	// * @param doc CDA-CH Dokument
	// */
	// public static void storeOnMedia(Destination destination, CdaCh doc) {
	// // TODO Auto-generated method stub
	// }
	//
	// /**
	// * <p>
	// * Speichert ein CDA-Dokument inkl. der benötigten Metadaten auf einem
	// * Datenträger (gemäss IHE XDM). Die Speicherung auf dem Medium erfolgt
	// gemäss
	// * <b>[ITI-32] Distribute Document Set on Media</b>.
	// * </p>
	// * <p>
	// * Rolle der API resp. der aufrufenden Anwendung für diese Methode: <b>IHE
	// ITI
	// * Portable Media Creator Akteur</b>
	// * </p>
	// *
	// * @param destination Pfad zum Datenträger auf dem XDM-konforme Daten
	// gespeichert werden
	// * @param doc das CDA-Dokument, welches gespeichert werden soll
	// * @return true, wenn das Dokument erfolgreich gespeichert wurde. Sonst:
	// * false.
	// * @throws Exception the exception
	// */
	// public static boolean storeOnMedia(File destination, ClinicalDocument
	// doc)
	// throws Exception {
	// //TODO
	// return false;
	// }

	// logger
	/** The Constant logger. */
	private static final Logger logger = Logger
			.getLogger(ConvenienceCommunication.class);

	// public DocumentMetadata addDocument(ClinicalDocument cdaDoc) throws
	// Exception {
	// //From Bytestream
	// ByteArrayOutputStream baos = new ByteArrayOutputStream();
	// try {
	// CDAUtil.save(cdaDoc, baos);
	// } catch (final Exception e) {
	// e.printStackTrace();
	// }
	// XDSDocument clinicalDocument = new
	// XDSDocumentFromByteArray(DocumentDescriptor.CDA_R2, baos.toByteArray());
	// String docEntryUUID = txnData.addDocument(clinicalDocument);
	// DocumentMetadata docMetadata = new
	// DocumentMetadata(txnData.getDocumentEntry(docEntryUUID));
	//
	// return docMetadata;
	// }

	/** The source. */
	private B_Source source = null;

	/** The organizational id. */
	private final String organizationalId;

	// private void generateMissingDocEntryAttributesCda(String docEntryUuid)
	// throws Exception {
	// ClinicalDocument cda =
	// CDAUtil.load(txnData.getDocument(docEntryUuid).getStream());
	// DocumentMetadata docMetadata = new
	// DocumentMetadata(txnData.getDocumentEntry(docEntryUuid));
	//
	// //PatientId from recordTarget/patientRole
	// if (cda.getPatientRoles()!=null &&
	// docMetadata.getMdhtDocumentEntryType().getPatientId()==null) {
	// if (cda.getPatientRoles().get(0).getIds()!=null) {
	// docMetadata.getMdhtDocumentEntryType().setPatientId(XdsUtil.convertII(cda.getPatientRoles().get(0).getIds().get(0)));
	// }
	// }
	//
	// //TODO Später: Kann bei CDA Dokumenten gemacht werden, indem die
	// TemplateIDs mit dieser Liste (als Enum) verglichen werden:
	// http://wiki.ihe.net/index.php?title=IHE_Format_Codes
	// //Currently only mapping to CDA-CH-VACD
	// II medicalDocumentII =
	// DatatypesFactory.eINSTANCE.createII("1.3.6.1.4.1.19376.1.5.3.1.1.18.1.2");
	// II ii = org.ehealth_connector.common.Util.findII(cda.getTemplateIds(),
	// medicalDocumentII);
	// if (ii!=null) {
	// Code formatCode = new Code("1.3.6.1.4.1.19376.1.2.3",
	// "urn:ihe:pcc:ic:2009");
	// docMetadata.setFormatCode(formatCode);
	// }
	//
	// //Set the Document Code as TypeCode
	// if (cda.getCode()!=null) {
	// Code code = new Code(cda.getCode());
	// docMetadata.setTypeCode(code);
	// }
	//
	// //Fix the OHT CDAExtraction bug(?), that authorTelecommunication is not a
	// known Slot for the NIST Registry by deleting all authorTelecommunications
	// for (Object object: docMetadata.getMdhtDocumentEntryType().getAuthors())
	// {
	// AuthorType at = (AuthorType) object;
	// at.getAuthorTelecommunication().clear();
	// }
	//
	// //Fix the OHT CDAExtraction bug(?) that generates Unique Ids, which are
	// to long for the registry (EXT part is larger than the allowed 16
	// characters)
	// docMetadata.setUniqueId(OID.createOIDGivenRoot(cda.getId().getRoot()));
	// }

	/** The transaction data. */
	SubmitTransactionData txnData;

	/**
	 * Instantiates a new convenience communication.
	 * 
	 * @param organizationalId
	 *            the organizational id (the OID of your Organization, e.g.
	 *            "1.3.6.1.4.1.21367.2010.1.2.1")
	 * @param repositoryUri
	 *            the repository uri (the URI of the Communication Endpoint,
	 *            e.g. the NIST Repository
	 *            "http://ihexds.nist.gov/tf6/services/xdsrepositoryb")
	 * @param auditorEnabled
	 *            the auditor enabled
	 * @throws Exception
	 *             the exception
	 */
	public ConvenienceCommunication(Destination dest, boolean auditorEnabled)
			throws Exception {
		txnData = new SubmitTransactionData();
		organizationalId = dest.getSenderOrganizationalOid();
		setUp(dest, auditorEnabled);
	}

	// Übermittlung per XDM (Speichern und Laden von einem Datenträger) - A10,
	// A11

	/**
	 * Adds a document to the XDS Submission set.
	 * 
	 * @param desc
	 *            the document descriptor (which kind of document do you want to
	 *            transfer? e.g. PDF, CDA,...)
	 * @param filePath
	 *            the file path
	 * @return the document metadata (which have to be completed)
	 * @throws Exception
	 *             the exception
	 */
	public DocumentMetadata addDocument(DocumentDescriptor desc, String filePath)
			throws Exception {
		// Cda Metadata extration is not implemented yet
		System.out
				.println("Trying to load from relative filePath: " + filePath);
		InputStream inputStream = getClass().getResourceAsStream(filePath);
		System.out.println("InputStream is:" + inputStream.toString());
		XDSDocument doc = new XDSDocumentFromStream(desc, inputStream);
		// XDSDocument doc = new
		// XDSDocumentFromStream(desc,this.getClass().getResourceAsStream(filePath));
		String docEntryUUID = txnData.addDocument(doc);
		DocumentMetadata docMetadata = new DocumentMetadata(
				txnData.getDocumentEntry(docEntryUUID));
		if (DocumentDescriptor.CDA_R2.equals(desc)) {
			cdaFixes(docMetadata);
		}

		return docMetadata;
	}

	// XDS: Interaktion mit einer IHE Registry - A8

	/**
	 * Cda fixes.
	 * 
	 * @param docMetadata
	 *            the doc metadata
	 */
	private void cdaFixes(DocumentMetadata docMetadata) {
		docMetadata.getMdhtDocumentEntryType().setLanguageCode(null);
		docMetadata.getMdhtDocumentEntryType().setClassCode(null);
		docMetadata.getMdhtDocumentEntryType().setPatientId(null);
		// Fix the OHT CDAExtraction bug(?), that authorTelecommunication is not
		// a known Slot for the NIST Registry by deleting all
		// authorTelecommunications
		for (Object object : docMetadata.getMdhtDocumentEntryType()
				.getAuthors()) {
			AuthorType at = (AuthorType) object;
			at.getAuthorTelecommunication().clear();
		}

		// Fix the OHT CDAExtraction bug(?) that generates Unique Ids, which are
		// to long for the registry (EXT part is larger than the allowed 16
		// characters)
		docMetadata.setUniqueId(OID.createOIDGivenRoot(organizationalId, 64));
	}

	// XDS: Herunterladen eines Impfdokuments von einem IHE XDS Repository - A9

	// Anfrage einer Immunization Recommendation (Senden der Anfrage und
	// Empfangen
	// der Antwort) - A4, A5, A6

	/**
	 * Generate missing doc entry attributes.
	 * 
	 * @param docEntryUuid
	 *            the doc entry uuid
	 * @throws Exception
	 *             the exception
	 */
	private void generateMissingDocEntryAttributes(String docEntryUuid)
			throws Exception {

		DocumentMetadata docMetadata = new DocumentMetadata(
				txnData.getDocumentEntry(docEntryUuid));
		DocumentDescriptor desc = txnData.getDocument(docEntryUuid)
				.getDescriptor();

		// Automatically create the formatCode of the Document according to the
		// DocumentDescriptor
		if (DocumentDescriptor.PDF.equals(desc)) {
			Code formatCode = new Code("1.3.6.1.4.1.19376.1.2.3",
					"urn:ihe:iti:xds-sd:pdf:2008",
					"1.3.6.1.4.1.19376.1.2.20 (Scanned Document)");
			docMetadata.getMdhtDocumentEntryType().setFormatCode(
					XdsUtil.convertCode(formatCode));
		}

		// //If the given doc is a CDA Doc load it for further processing
		// if (desc.equals(DocumentDescriptor.CDA_R2)) {
		// generateMissingDocEntryAttributesCda(docEntryUuid);
		// }

		// Derive MimeType from DocumentDescriptor
		if (docMetadata.getMdhtDocumentEntryType().getMimeType() == null) {
			docMetadata.setMimeType(desc.getMimeType());
		}

		// Generate the UUID
		if (docMetadata.getMdhtDocumentEntryType().getUniqueId() == null) {
			docMetadata.setUniqueId(OID
					.createOIDGivenRoot(organizationalId, 64));
		}

		// Set ConfidentiallyCode to Normal ("N");
		if (docMetadata.getMdhtDocumentEntryType().getConfidentialityCode()
				.isEmpty()
				|| docMetadata.getMdhtDocumentEntryType()
				.getConfidentialityCode() == null) {
			docMetadata.getMdhtDocumentEntryType().getConfidentialityCode()
			.clear();
			docMetadata
			.getMdhtDocumentEntryType()
			.getConfidentialityCode()
			.add(XdsUtil.createCodedMetadata("2.16.840.1.113883.5.25",
					"N", null, null));
		}

		// Generate Creation Time with the current time
		if (docMetadata.getMdhtDocumentEntryType().getCreationTime() == null) {
			docMetadata.setCreationTime(DateUtil.nowAsDate());
		}

		// Use the TypeCode for ClassCode
		if (docMetadata.getMdhtDocumentEntryType().getClassCode() == null
				&& docMetadata.getMdhtDocumentEntryType().getTypeCode() != null) {
			docMetadata.getMdhtDocumentEntryType().setClassCode(
					EcoreUtil.copy(docMetadata.getMdhtDocumentEntryType()
							.getTypeCode()));
		}
	}

	/**
	 * Setting up the communication endpoint and the logger
	 * 
	 * @param repositoryUri
	 *            the repository uri
	 * @param auditorEnabled
	 *            the auditor enabled
	 * @param log4jConfigPath
	 *            the log4j config path
	 * @throws Exception
	 *             the exception
	 */
	protected void setUp(Destination dest, boolean auditorEnabled)
			throws Exception {
		// URL resourceUrl = getClass().getResource(log4jConfigPath);
		// org.apache.log4j.xml.DOMConfigurator.configure(resourceUrl);

		if (dest.getKeyStore() != null) {
			System.setProperty("javax.net.ssl.keyStore", dest.getKeyStore());
			System.setProperty("javax.net.ssl.keyStorePassword",
					dest.getKeyStorePassword());
			System.setProperty("javax.net.ssl.trustStore", dest.getTrustStore());
			System.setProperty("javax.net.ssl.trustStorePassword",
					dest.getTrustStorePassword());
		}

		source = new B_Source(dest.getRegistryUri());
		XDSSourceAuditor.getAuditor().getConfig()
		.setAuditorEnabled(auditorEnabled);
	}

	/**
	 * <p>
	 * Sendet ein CDA Dokument an einen Empfänger (Repository Akteur gemäss IHE
	 * XDR oder IHE XDS). Die Kommunikation zum Kommunikations-Endpunkt erfolgt
	 * gemäss <b>IHE [ITI-41] Provide & Register Document Set – b</b>.
	 * </p>
	 * <p>
	 * Rolle der API resp. der aufrufenden Anwendung für diese Methode: <b>IHE
	 * ITI Document Source Actor</b>
	 * </p>
	 * 
	 * @return XDSResponseType
	 * @throws Exception
	 *             the exception
	 */
	public XDSResponseType submit() throws Exception {
		// generate missing information for all documents
		for (XDSDocument xdsDoc : txnData.getDocList()) {
			generateMissingDocEntryAttributes(xdsDoc.getDocumentEntryUUID());
		}

		// Create SubmissionSet
		SubmissionSetType subSet = txnData.getSubmissionSet();
		subSet.setUniqueId(OID.createOIDGivenRoot((organizationalId), 64));

		// set submission set source id
		subSet.setSourceId(organizationalId);

		// set submission time
		subSet.setSubmissionTime(DateUtil.nowAsTS().getValue());
		// txnData.saveMetadataToFile("C:/temp/metadata.xml");

		// Use the PatientId of the first Document for the
		// SubmissionSet/patientId
		String uuid = txnData.getDocList().get(0).getDocumentEntryUUID();
		// CX testCx = XdsUtil.createCx("TESTAuthority", "TestId");
		// subSet.setPatientId(testCx);
		CX testCx = txnData.getDocumentEntry(uuid).getPatientId();
		subSet.setPatientId(EcoreUtil.copy(testCx));

		// set ContentTypeCode
		subSet.setContentTypeCode(XdsUtil.createCodedMetadata(
				"2.16.840.1.113883.6.1", "34133-9", "Summary of Episode Note",
				null));

		// txnData.saveMetadataToFile("C:/temp/meta.xml");
		XDSResponseType xdsr = source.submit(txnData);
		System.out.println("XDSResponseType: " + xdsr);
		return xdsr;
	}
}
