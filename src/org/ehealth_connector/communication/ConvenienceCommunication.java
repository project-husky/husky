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

import java.io.InputStream;
import java.net.URI;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

import javax.crypto.Cipher;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.cda.ch.AuthorCh;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.DateUtil;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.XdsUtil;
import org.ehealth_connector.communication.ch.DocumentMetadataCh;
import org.ehealth_connector.communication.ch.enums.AuthorRole;
import org.ehealth_connector.communication.ch.enums.AvailabilityStatus;
import org.ehealth_connector.communication.storedquery.FindDocumentsQuery;
import org.ehealth_connector.communication.storedquery.StoredQueryInterface;
import org.openhealthtools.ihe.atna.auditor.XDSSourceAuditor;
import org.openhealthtools.ihe.common.hl7v2.CX;
import org.openhealthtools.ihe.utils.OID;
import org.openhealthtools.ihe.xds.consumer.B_Consumer;
import org.openhealthtools.ihe.xds.consumer.retrieve.RetrieveDocumentSetRequestType;
import org.openhealthtools.ihe.xds.document.DocumentDescriptor;
import org.openhealthtools.ihe.xds.document.XDSDocument;
import org.openhealthtools.ihe.xds.document.XDSDocumentFromFile;
import org.openhealthtools.ihe.xds.document.XDSDocumentFromStream;
import org.openhealthtools.ihe.xds.metadata.AuthorType;
import org.openhealthtools.ihe.xds.metadata.LocalizedStringType;
import org.openhealthtools.ihe.xds.metadata.SubmissionSetType;
import org.openhealthtools.ihe.xds.metadata.extract.MetadataExtractionException;
import org.openhealthtools.ihe.xds.response.XDSQueryResponseType;
import org.openhealthtools.ihe.xds.response.XDSResponseType;
import org.openhealthtools.ihe.xds.response.XDSRetrieveResponseType;
import org.openhealthtools.ihe.xds.source.B_Source;
import org.openhealthtools.ihe.xds.source.SubmitTransactionCompositionException;
import org.openhealthtools.ihe.xds.source.SubmitTransactionData;

/**
 * <p>
 * The ConvenienceCommunication class provides methods to realize the
 * transmission of documents to different destinations
 * 
 * The class implements the following profiles and actors <b>IHE ITI Document
 * Source Actor</b>
 * 
 * [ITI-41] Provide and Register Document Set – b
 * 
 * <b>IHE ITI Document Consumer Akteur</b> [ITI-18] Registry Stored Query // *
 * [ITI-43] Retrieve Document Set // * <b>IHE ITI Portable Media Creator und
 * Media Importer Akteur</b> // * [ITI-32] Distribute Document Set on Media // *
 * <b>IHE PCC Care Manager und Decision Support Service Akteur</b> // * [PCC-12]
 * Request for Clinical Guidance
 */
public class ConvenienceCommunication {

	public class DocumentNotAccessibleException extends Exception{
		private static final long serialVersionUID = 1L;

		DocumentNotAccessibleException() {
			super("The Document could not be found. Is the path correct?");
		}
	}

	private final Log log = LogFactory.getLog(ConvenienceCommunication.class);
	
	private Destination destination = null;

	/** The source. */
	private B_Source source = null;

	/** The organizational id. */
	private String organizationalId;

	/** The transaction data to send XDS Documents. */
	private SubmitTransactionData txnData = null;

	private boolean auditorEnabled = false;

	/**
	 * Instantiates a new convenience communication.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public ConvenienceCommunication() throws Exception {
	}

	// Übermittlung per XDM (Speichern und Laden von einem Datenträger) - A10,
	// A11

	/**
	 * Instantiates a new convenience communication.
	 * 
	 * @param dest
	 *            the destination
	 * @param auditorEnabled
	 *            sets whether the ATNA audit is enable (secure) or disabled
	 *            (unsecure)
	 * @throws Exception
	 *             the exception
	 */
	public ConvenienceCommunication(Destination dest, boolean auditorEnabled)
			throws Exception {
		setDestination(dest);
		auditorEnabled = this.auditorEnabled;
	}

	/**
	 * Adds a document to the XDS Submission set.
	 * 
	 * @param desc
	 *            the document descriptor (which kind of document do you want to
	 *            transfer? e.g. PDF, CDA,...)
	 * @param inputStream
	 *            The input stream to the document
	 * @return the document metadata (which have to be completed)
	 * @throws Exception
	 *             the exception
	 */
	public org.ehealth_connector.communication.ch.DocumentMetadataCh addChDocument(DocumentDescriptor desc,
			InputStream inputStream) throws Exception {
		if (inputStream == null) throw new DocumentNotAccessibleException();
		XDSDocument doc = new XDSDocumentFromStream(desc, inputStream);

		return new DocumentMetadataCh(addXdsDocument(doc, desc));
	}

	/**
	 * Adds a document to the XDS Submission set.
	 * 
	 * @param desc
	 *            the document descriptor (which kind of document do you want to
	 *            transfer? e.g. PDF, CDA,...)
	 * @param filePath
	 *            the file path
	 * @return the document metadata (which has to be completed)
	 * @throws Exception
	 *             the exception
	 */
	public DocumentMetadata addChDocument(DocumentDescriptor desc, String filePath)
			throws Exception {
		XDSDocument doc = new XDSDocumentFromFile(desc, filePath);

		return new DocumentMetadataCh(addXdsDocument(doc, desc));
	}
	
	/**
	 * Adds a document to the XDS Submission set.
	 * 
	 * @param desc
	 *            the document descriptor (which kind of document do you want to
	 *            transfer? e.g. PDF, CDA,...)
	 * @param inputStream
	 *            The input stream to the document
	 * @return the document metadata (which have to be completed)
	 * @throws Exception
	 *             the exception
	 */
	public DocumentMetadata addDocument(DocumentDescriptor desc,
			InputStream inputStream) throws Exception {
		XDSDocument doc = new XDSDocumentFromStream(desc, inputStream);

		return addXdsDocument(doc, desc);
	}

	/**
	 * Adds a document to the XDS Submission set.
	 * 
	 * @param desc
	 *            the document descriptor (which kind of document do you want to
	 *            transfer? e.g. PDF, CDA,...)
	 * @param filePath
	 *            the file path
	 * @return the document metadata (which has to be completed)
	 * @throws Exception
	 *             the exception
	 */
	public DocumentMetadata addDocument(DocumentDescriptor desc, String filePath)
			throws Exception {
		XDSDocument doc = new XDSDocumentFromFile(desc, filePath);

		return addXdsDocument(doc, desc);
	}

	/**
	 * Resets the transaction data (SubmissionSet and DocumentMetadata)
	 */
	public void clearDocuments() {
		txnData = new SubmitTransactionData();
	}

	/**
	 * Returns the current destination
	 * 
	 * @return the destination
	 */
	public Destination getDestination() {
		return destination;
	}

	/**
	 * Gets the OHT transaction data (SubmissionSet and DocumentMetadata)
	 * 
	 * @return the transaction data object
	 */
	public SubmitTransactionData getTxnData() {
		return this.txnData;
	}
	
	/**
	 * Query a registry for all documents of one patient.
	 *
	 * @param patientId the ID of the patient
	 * @param returnReferencesOnly if set to false, the registry response will contain the document metadata. If set to true, the response will contain references instead of the complete document metadata. This is useful if the number of results is limited in the registry and your query would exceed this limit. In this case, precise your query or do a query for references first, choose the possible matches (e.g. the last 10 results) and then query for metadata.  
	 * @return the XDSQueryResponseType
	 * @throws Exception
	 */
	public XDSQueryResponseType queryDocuments(Identificator patientId, boolean returnReferencesOnly) throws Exception {
		return this.queryDocuments(new FindDocumentsQuery(patientId, AvailabilityStatus.APPROVED), returnReferencesOnly);
	}

	/**
	 * Query a registry for documents, using a find documents query.
	 * 
	 * @param queryParameter a findDocumentsQuery object filled with your query parameters
	 * @param returnReferencesOnly if set to false, the registry response will contain the document metadata. If set to true, the response will contain references instead of the complete document metadata. This is useful if the number of results is limited in the registry and your query would exceed this limit. In this case, precise your query or do a query for references first, choose the possible matches (e.g. the last 10 results) and then query for metadata.  
	 * @return the XDSQueryResponseType
	 * @throws Exception
	 */
	public XDSQueryResponseType queryDocuments(FindDocumentsQuery queryParameter, boolean returnReferencesOnly) throws Exception {
		return this.queryDocuments((StoredQueryInterface)queryParameter, returnReferencesOnly);
	}
	
	/**
	 * Query a registry for documents, using a query at will.
	 * 
	 * @param query one of the given queries (@see org.ehealth_connector.communication.storedquery and org.ehealth_connector.communication.storedquery.ch)
	 * @param returnReferencesOnly if set to false, the registry response will contain the document metadata. If set to true, the response will contain references instead of the complete document metadata. This is useful if the number of results is limited in the registry and your query would exceed this limit. In this case, precise your query or do a query for references first, choose the possible matches (e.g. the last 10 results) and then query for metadata.  
	 * @return the XDSQueryResponseType
	 * @throws Exception
	 */
	public XDSQueryResponseType queryDocuments(StoredQueryInterface query, boolean returnReferencesOnly) throws Exception {
		B_Consumer consumer = new B_Consumer(destination.getRegistryUri());

		return consumer.invokeStoredQuery(query.getOhtStoredQuery(), returnReferencesOnly);
	}
	
	/**
	 * Retrieves a document from a Repository
	 * 
	 * @param docReq the document request
	 * @param auditorEnabled sets whether the ATNA audit is enable (secure) or disabled
	 * @return the XDSRetrieveResponseType
	 */
	public XDSRetrieveResponseType retrieveDocument(DocumentRequest docReq, boolean auditorEnabled) {
		return retrieveDocuments(new DocumentRequest[]{docReq}, auditorEnabled);
	}

	/**
	 * Retrieves multiple documents from one or more Repositories
	 * 
	 * @param docReq an array of document requests
	 * @param auditorEnabled sets whether the ATNA audit is enable (secure) or disabled
	 * @return the XDSRetrieveResponseType
	 */
	@SuppressWarnings("unchecked")
	public XDSRetrieveResponseType retrieveDocuments(DocumentRequest[] docReq, boolean auditorEnabled) {
		B_Consumer consumer = new B_Consumer(destination.getRegistryUri());
		
		//Create RetrieveSetRequestType
		RetrieveDocumentSetRequestType retrieveDocumentSetRequest = org.openhealthtools.ihe.xds.consumer.retrieve.RetrieveFactory.eINSTANCE.createRetrieveDocumentSetRequestType();
		
		//Put the Repository to the OHT Repository HashMap
		HashMap<String, URI> repositoryMap = null;
		for (int i=0;i<docReq.length;i++) {
			repositoryMap = new HashMap<String, URI>();
			repositoryMap.put(docReq[i].getRepositoryId(), docReq[i].getRepositoryUri());
			
			//Add Document Request
			retrieveDocumentSetRequest.getDocumentRequest().add(docReq[i].getOhtDocumentRequestType());
		}
		consumer.setRepositoryMap(repositoryMap);
		consumer.getAuditor().getConfig().setAuditorEnabled(false);

		//invoke retrieve documentSet
		XDSRetrieveResponseType response = consumer.retrieveDocumentSet(false, retrieveDocumentSetRequest, null);

		return response;
	}

	/**
	 * Sets the destination
	 * 
	 * @param dest
	 *            the destination
	 */
	public void setDestination(Destination dest) {
		destination = dest;
		organizationalId = dest.getSenderOrganizationalOid();
		try {
			boolean unlimited = Cipher.getMaxAllowedKeyLength("RC5") >= 256;
			 log.debug("Unlimited cryptography enabled: " + unlimited);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		if (dest.getKeyStore() == null) {
			System.clearProperty("javax.net.ssl.keyStore");
			System.clearProperty("javax.net.ssl.keyStorePassword");
			System.clearProperty("javax.net.ssl.trustStore");
			System.clearProperty("javax.net.ssl.trustStorePassword");
		} else {
			System.setProperty("javax.net.ssl.keyStore", dest.getKeyStore());
			System.setProperty("javax.net.ssl.keyStorePassword",
					dest.getKeyStorePassword());
			System.setProperty("javax.net.ssl.trustStore", dest.getTrustStore());
			System.setProperty("javax.net.ssl.trustStorePassword",
					dest.getTrustStorePassword());
			
			System.setProperty("javax.net.debug", "all");
			//System.setProperty("https.protocols", "TLSv1.2");
			//System.setProperty("https.protocols", "TLSv1.2");
			//System.setProperty("https.ciphersuites", "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256");
			
			//System.setProperty("https.ciphersuites", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384,TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384,TLS_RSA_WITH_AES_256_CBC_SHA256,TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384,TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384,TLS_DHE_RSA_WITH_AES_256_CBC_SHA256,TLS_DHE_DSS_WITH_AES_256_CBC_SHA256,TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA,TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA,TLS_RSA_WITH_AES_256_CBC_SHA,TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA,TLS_ECDH_RSA_WITH_AES_256_CBC_SHA,TLS_DHE_RSA_WITH_AES_256_CBC_SHA,TLS_DHE_DSS_WITH_AES_256_CBC_SHA,TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256,TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256,TLS_RSA_WITH_AES_128_CBC_SHA256,TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256,TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256,TLS_DHE_RSA_WITH_AES_128_CBC_SHA256,TLS_DHE_DSS_WITH_AES_128_CBC_SHA256,TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA,TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA,TLS_RSA_WITH_AES_128_CBC_SHA,TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA,TLS_ECDH_RSA_WITH_AES_128_CBC_SHA,TLS_DHE_RSA_WITH_AES_128_CBC_SHA,TLS_DHE_DSS_WITH_AES_128_CBC_SHA,TLS_ECDHE_ECDSA_WITH_RC4_128_SHA,TLS_ECDHE_RSA_WITH_RC4_128_SHA,SSL_RSA_WITH_RC4_128_SHA,TLS_ECDH_ECDSA_WITH_RC4_128_SHA,TLS_ECDH_RSA_WITH_RC4_128_SHA,TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA,TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA,SSL_RSA_WITH_3DES_EDE_CBC_SHA,TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA,TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA,SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA,SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA,SSL_RSA_WITH_RC4_128_MD5");
			
			
		}
	}

	// XDS: Herunterladen eines Impfdokuments von einem IHE XDS Repository - A9

	// Anfrage einer Immunization Recommendation (Senden der Anfrage und
	// Empfangen
	// der Antwort) - A4, A5, A6

	/**
	 * <p>
	 * Sends the current document to the according recipient (repository actor
	 * as specified in IHE XDR or IHE XDS). The transmission is performed as
	 * specified in <b>IHE [ITI-41] Provide and Register Document Set – b</b>
	 * 
	 * </p>
	 * <p>
	 * Role of the API or the application: <b>IHE ITI Document Source Actor</b>
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
//			LocalizedStringType test = (LocalizedStringType) txnData.getDocumentEntry(xdsDoc.getDocumentEntryUUID()).getFormatCode().getDisplayName().getLocalizedString().get(0);
//			LocalizedStringType test2 = (LocalizedStringType) txnData.getDocumentEntry(xdsDoc.getDocumentEntryUUID()).getTitle().getLocalizedString().get(0);
//			System.out.println("XYZ: FORMAT CODE:"+test.getLang());
//			if (test2 != null) System.out.println(" TITLE:"+test2.getLang());
		}

		generateMissingSubmissionSetAttributes();

		//txnData.saveMetadataToFile("C:/temp/meta.xml");
		XDSResponseType xdsr = source.submit(txnData);

		return xdsr;
	}

	/**
	 * <p>
	 * Sends the current document to the according recipient (repository actor
	 * as specified in IHE XDR or IHE XDS). The AuthorRole is one of the minimal required information according to IHE Suisse for classification of documents in Switzerland. The transmission is performed as
	 * specified in <b>IHE [ITI-41] Provide and Register Document Set – b</b>
	 * 
	 * </p>
	 * <p>
	 * Role of the API or the application: <b>IHE ITI Document Source Actor</b>
	 * </p>
	 * 
	 * @param authorRole the role of the author of the document. This is part of the submission set metadata and required for switzerland.
	 * @return XDSResponseType
	 * @throws Exception
	 *             the exception
	 */
	public XDSResponseType submit(AuthorRole authorRole) throws Exception {
		SubmissionSetMetadata subSet = new SubmissionSetMetadata();
		AuthorCh author = new AuthorCh();
		author.setRoleFunction(authorRole);
		subSet.setAuthor(author);
		return submit(subSet);
	}

	/**
	 * <p>
	 * Sends the current document to the according recipient (repository actor
	 * as specified in IHE XDR or IHE XDS). The information in the subSet Object will be used to create comprehensive meta data about this submission (e.g. with AuthorRole, AuthorInstitution, ContentType and Title). The transmission is performed as
	 * specified in <b>IHE [ITI-41] Provide and Register Document Set – b</b>
	 * 
	 * </p>
	 * <p>
	 * Role of the API or the application: <b>IHE ITI Document Source Actor</b>
	 * </p>
	 * 
	 * @param subSet the metadata object for the submission set. Although, some of this information can be derived automatically, some may be required in your country (e.g. AuthorRole in Switzerland)
	 * @return XDSResponseType
	 * @throws Exception
	 *             the exception
	 */
	public XDSResponseType submit(SubmissionSetMetadata subSet) throws Exception {
		subSet.toOhtSubmissionSetType(txnData.getSubmissionSet());
		return submit();
	}
	
	/**
	 * Setting up the communication endpoint and the logger
	 * 
	 * @param repositoryUri
	 *            the repository uri
	 * @param auditorEnabled
	 *            sets whether the ATNA audit is enable (secure) or disabled
	 *            (unsecure)
	 * @throws Exception
	 *             the exception
	 */
	protected void setUp(Destination dest, boolean auditorEnabled)
			throws Exception {

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
		
	private DocumentMetadata addXdsDocument (XDSDocument doc, DocumentDescriptor desc) throws MetadataExtractionException, SubmitTransactionCompositionException {
		source = new B_Source(destination.getRepositoryUri());

		if (txnData == null) {
			txnData = new SubmitTransactionData();
		}
		XDSSourceAuditor.getAuditor().getConfig().setAuditorEnabled(auditorEnabled);
		String docEntryUUID = txnData.addDocument(doc);
		DocumentMetadata docMetadata = new DocumentMetadata(
				txnData.getDocumentEntry(docEntryUUID));
		if (DocumentDescriptor.CDA_R2.equals(desc)) {
			cdaFixes(docMetadata);
		}

		return docMetadata;
	}

	/**
	 * Cda fixes.
	 * 
	 * @param docMetadata
	 *            the doc metadata
	 */
	private void cdaFixes(DocumentMetadata docMetadata) {
		docMetadata.getMdhtDocumentEntryType().getConfidentialityCode().clear();
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
	
	/**
	 * Generate missing doc entry attributes.
	 * 
	 * @param docEntryUuid
	 *            the doc entry uuid
	 * @throws Exception
	 *             the exception
	 */
	@SuppressWarnings("unchecked")
	private void generateMissingDocEntryAttributes(String docEntryUuid)
			throws Exception {

		DocumentMetadata docMetadata = new DocumentMetadata(
				txnData.getDocumentEntry(docEntryUuid));
		DocumentDescriptor desc = txnData.getDocument(docEntryUuid)
				.getDescriptor();

		// Automatically create the formatCode of the Document according to the
		// DocumentDescriptor
		if (DocumentDescriptor.PDF.equals(desc) && docMetadata.getMdhtDocumentEntryType().getFormatCode() == null) {
			Code formatCode = new Code("1.3.6.1.4.1.19376.1.2.3",
					"urn:ihe:iti:xds-sd:pdf:2008",
					"1.3.6.1.4.1.19376.1.2.20 (Scanned Document)");
			docMetadata.getMdhtDocumentEntryType().setFormatCode(
					XdsUtil.convertCode(formatCode));
		}

		// Derive MimeType from DocumentDescriptor
		if (docMetadata.getMdhtDocumentEntryType().getMimeType() == null) {
			docMetadata.setMimeType(desc.getMimeType());
		}

		// Generate the UUID
		if (docMetadata.getMdhtDocumentEntryType().getUniqueId() == null) {
			docMetadata.setUniqueId(OID
					.createOIDGivenRoot(organizationalId, 64));
		}

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
	
	private void generateMissingSubmissionSetAttributes() {
		// Create SubmissionSet
		SubmissionSetType subSet = txnData.getSubmissionSet();
		if (subSet.getUniqueId() == null) {
			subSet.setUniqueId(OID.createOIDGivenRoot((organizationalId), 64));
		}
	
		// set submission set source id
		if (subSet.getSourceId() == null) {
			subSet.setSourceId(organizationalId);
		}
	
		// set submission time
		if (subSet.getSubmissionTime() == null) {
			subSet.setSubmissionTime(DateUtil.nowAsTS().getValue());
		}
		// txnData.saveMetadataToFile("C:/temp/metadata.xml");
	
		String uuid = txnData.getDocList().get(0).getDocumentEntryUUID();
		// Use the PatientId of the first Document for the Submission set ID
		if (subSet.getPatientId() == null) {
			CX testCx = txnData.getDocumentEntry(uuid).getPatientId();
			subSet.setPatientId(EcoreUtil.copy(testCx));
		}
	
		// set ContentTypeCode
		if (subSet.getContentTypeCode() == null) {
			if (txnData.getDocumentEntry(uuid).getTypeCode()!=null) {
				subSet.setContentTypeCode(EcoreUtil.copy(txnData.getDocumentEntry(uuid).getTypeCode()));
			}
			else {
				subSet.setContentTypeCode(XdsUtil.createCodedMetadata(
						"2.16.840.1.113883.6.1", "34133-9", "Summary of Episode Note",
						null));
			}
		}
	}
}
