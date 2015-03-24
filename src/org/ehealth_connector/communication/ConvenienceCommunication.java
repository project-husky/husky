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

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.DateUtil;
import org.ehealth_connector.common.XdsUtil;
import org.openhealthtools.ihe.atna.auditor.XDSSourceAuditor;
import org.openhealthtools.ihe.common.hl7v2.CX;
import org.openhealthtools.ihe.utils.OID;
import org.openhealthtools.ihe.xds.document.DocumentDescriptor;
import org.openhealthtools.ihe.xds.document.XDSDocument;
import org.openhealthtools.ihe.xds.document.XDSDocumentFromFile;
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

	private Destination destination = null;

	/** The source. */
	private B_Source source = null;

	/** The organizational id. */
	private String organizationalId;

	/** The transaction data. */
	protected SubmitTransactionData txnData;

	/**
	 * Instantiates a new convenience communication.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public ConvenienceCommunication() throws Exception {
		txnData = new SubmitTransactionData();
		XDSSourceAuditor.getAuditor().getConfig().setAuditorEnabled(false);
	}

	/**
	 * Instantiates a new convenience communication.
	 * 
	 * @param dest
	 *            the destination
	 * @param auditorEnabled
	 *            the auditor enabled
	 * @throws Exception
	 *             the exception
	 */
	public ConvenienceCommunication(Destination dest, boolean auditorEnabled)
			throws Exception {
		txnData = new SubmitTransactionData();
		setDestination(dest);

		XDSSourceAuditor.getAuditor().getConfig()
				.setAuditorEnabled(auditorEnabled);
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
	public DocumentMetadata addDocument(DocumentDescriptor desc,
			InputStream inputStream) throws Exception {
		XDSDocument doc = new XDSDocumentFromStream(desc, inputStream);
		String docEntryUUID = txnData.addDocument(doc);
		DocumentMetadata docMetadata = new DocumentMetadata(
				txnData.getDocumentEntry(docEntryUUID));
		if (DocumentDescriptor.CDA_R2.equals(desc)) {
			cdaFixes(docMetadata);
		}

		return docMetadata;
	}

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
		XDSDocument doc = new XDSDocumentFromFile(desc, filePath);
		String docEntryUUID = txnData.addDocument(doc);
		DocumentMetadata docMetadata = new DocumentMetadata(
				txnData.getDocumentEntry(docEntryUUID));
		if (DocumentDescriptor.CDA_R2.equals(desc)) {
			cdaFixes(docMetadata);
		}

		return docMetadata;
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
		source = new B_Source(dest.getRegistryUri());

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
		}
	}

	/**
	 * Returns the current destination
	 * 
	 * @return the destination
	 */
	public Destination getDestination() {
		return destination;
	}

	public void clearDocuments() {
		txnData = new SubmitTransactionData();
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
	 * <<<<<<< .mine ======= Setting up the communication endpoint and the
	 * logger
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
	 * >>>>>>> .r360
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
