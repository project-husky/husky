/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by
 * medshare GmbH, Switzerland. All rights reserved.
 * http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the
 * Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the
 * Creative Commons Attribution-ShareAlike 3.0 Switzerland License.
 *
 * Year of publication: 2014
 *
 *******************************************************************************/

package org.ehealth_connector.communication.ch;

import java.io.File;
import java.util.ArrayList;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.cda.ch.CdaCh;
import org.ehealth_connector.cda.ch.CdaChVacd;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.DateUtil;
import org.ehealth_connector.common.XdsUtil;
import org.ehealth_connector.communication.Destination;
import org.ehealth_connector.communication.DocumentMetadata;
import org.ehealth_connector.communication.Response;
import org.openhealthtools.mdht.uml.cda.ClinicalDocument;

import java.net.URISyntaxException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.openhealthtools.ihe.atna.auditor.XDSSourceAuditor;
import org.openhealthtools.ihe.common.hl7v2.CX;
import org.openhealthtools.ihe.utils.OID;
import org.openhealthtools.ihe.xds.document.DocumentDescriptor;
import org.openhealthtools.ihe.xds.document.XDSDocument;
import org.openhealthtools.ihe.xds.document.XDSDocumentFromFile;
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
public class DocumentSourceClient {

	// IBM Audit Repository
	//public static final String IBM_ARR ="syslog://lswin10.dfw.ibm.com:515";

	// logger
	private static final Logger logger = Logger.getLogger(DocumentSourceClient.class);

	// Source instance
	private B_Source source = null;
	private String organizationalId;
	SubmitTransactionData txnData;

	public DocumentSourceClient(String organizationalId, String repositoryUri, boolean auditorEnabled, String log4jConfigPath) throws Exception {
		txnData = new SubmitTransactionData();
		this.organizationalId = organizationalId;
		if (log4jConfigPath==null) {
			log4jConfigPath = "./rsc/log4jInfo.xml";
		}
		setUp(repositoryUri, auditorEnabled, log4jConfigPath);
	}
	
	public DocumentSourceClient(String organizationalId, String repositoryUri, boolean auditorEnabled, String keystorePath, String keystorePassword, String truststorePath, String truststorePassowrd, String log4jConfigPath) throws Exception {
	    System.setProperty("javax.net.ssl.keyStore",keystorePath);
	    System.setProperty("javax.net.ssl.keyStorePassword",keystorePassword);
	    System.setProperty("javax.net.ssl.trustStore",truststorePath);
	    System.setProperty("javax.net.ssl.trustStorePassword",truststorePassowrd);
		
		txnData = new SubmitTransactionData();
		this.organizationalId = organizationalId;
		if (log4jConfigPath==null) {
			log4jConfigPath = "./rsc/log4jInfo.xml";
		}
		setUp(repositoryUri, auditorEnabled, log4jConfigPath);
	}

	/**
	 * Test set up
	 */
	protected void setUp(String repositoryUri, boolean auditorEnabled, String log4jConfigPath) throws Exception {
		//super.setUp();
		File conf = new File(log4jConfigPath);
		org.apache.log4j.xml.DOMConfigurator.configure(conf.getAbsolutePath());
		java.net.URI repositoryURI = null;
		try {
			repositoryURI = new java.net.URI(repositoryUri);
		} catch (URISyntaxException e) {
			logger.fatal("SOURCE URI CANNOT BE SET: \n" + e.getMessage());
			throw e;
		}
		source = new B_Source(repositoryURI);
		XDSSourceAuditor.getAuditor().getConfig().setAuditorEnabled(auditorEnabled);
	}

	public DocumentMetadata addDocument(DocumentDescriptor desc, String filePath) throws Exception {
		//Cda Metadata extration is not implemented yet
		XDSDocument doc = new XDSDocumentFromFile(desc,filePath);
		String docEntryUUID = txnData.addDocument(doc);
		DocumentMetadata docMetadata = new DocumentMetadata(txnData.getDocumentEntry(docEntryUUID));
		if (DocumentDescriptor.CDA_R2.equals(desc)) {
			cdaFixes(docMetadata);
		}

		return docMetadata;
	}
	
//	public DocumentMetadata addDocument(ClinicalDocument cdaDoc) throws Exception {
//		//From Bytestream
//		ByteArrayOutputStream baos = new ByteArrayOutputStream();
//		try {
//			CDAUtil.save(cdaDoc, baos);
//		} catch (final Exception e) {
//			e.printStackTrace();
//		}
//		XDSDocument clinicalDocument = new XDSDocumentFromByteArray(DocumentDescriptor.CDA_R2, baos.toByteArray());
//		String docEntryUUID = txnData.addDocument(clinicalDocument);
//		DocumentMetadata docMetadata = new DocumentMetadata(txnData.getDocumentEntry(docEntryUUID));
//
//		return docMetadata;
//	}
	
	private void cdaFixes(DocumentMetadata docMetadata) {
		docMetadata.getMdhtDocumentEntryType().setLanguageCode(null);
		docMetadata.getMdhtDocumentEntryType().setClassCode(null);
		docMetadata.getMdhtDocumentEntryType().setPatientId(null);
		//Fix the OHT CDAExtraction bug(?), that authorTelecommunication is not a known Slot for the NIST Registry by deleting all authorTelecommunications
		for (Object object: docMetadata.getMdhtDocumentEntryType().getAuthors()) {
			AuthorType at = (AuthorType) object;
			at.getAuthorTelecommunication().clear();
		}
		
		//Fix the OHT CDAExtraction bug(?) that generates Unique Ids, which are to long for the registry (EXT part is larger than the allowed 16 characters)
		docMetadata.setUniqueId(OID.createOIDGivenRoot(organizationalId,64));
	}

	private void generateMissingDocEntryAttributes(String docEntryUuid) throws Exception {

		DocumentMetadata docMetadata = new DocumentMetadata(txnData.getDocumentEntry(docEntryUuid));
		DocumentDescriptor desc = txnData.getDocument(docEntryUuid).getDescriptor();
		
		//Automatically create the formatCode of the Document according to the DocumentDescriptor
		if (DocumentDescriptor.PDF.equals(desc)) {
			Code formatCode = new Code("1.3.6.1.4.1.19376.1.2.3", "urn:ihe:iti:xds-sd:pdf:2008", "1.3.6.1.4.1.19376.1.2.20 (Scanned Document)");
			docMetadata.getMdhtDocumentEntryType().setFormatCode(XdsUtil.convertCode(formatCode));
		}
	
//		//If the given doc is a CDA Doc load it for further processing
//		if (desc.equals(DocumentDescriptor.CDA_R2)) {
//			generateMissingDocEntryAttributesCda(docEntryUuid);
//		}

		//Derive MimeType from DocumentDescriptor
		if (docMetadata.getMdhtDocumentEntryType().getMimeType()==null) {
			docMetadata.setMimeType(desc.getMimeType());
		}
		
		//Generate the UUID
		if (docMetadata.getMdhtDocumentEntryType().getUniqueId()==null) {
			docMetadata.setUniqueId(OID.createOIDGivenRoot(organizationalId,64));
		}
		
		//Set ConfidentiallyCode to Normal ("N");
		if (docMetadata.getMdhtDocumentEntryType().getConfidentialityCode().isEmpty() || docMetadata.getMdhtDocumentEntryType().getConfidentialityCode()==null) {
			docMetadata.getMdhtDocumentEntryType().getConfidentialityCode().clear();
			docMetadata.getMdhtDocumentEntryType().getConfidentialityCode().add(XdsUtil.createCodedMetadata("2.16.840.1.113883.5.25", "N", null, null));
		}
		
		//Generate Creation Time with the current time
		if (docMetadata.getMdhtDocumentEntryType().getCreationTime() == null) {
			docMetadata.setCreationTime(DateUtil.nowAsDate());
		}
		
		//Use the TypeCode for ClassCode
		if (docMetadata.getMdhtDocumentEntryType().getClassCode() == null && docMetadata.getMdhtDocumentEntryType().getTypeCode() != null){
			docMetadata.getMdhtDocumentEntryType().setClassCode(EcoreUtil.copy(docMetadata.getMdhtDocumentEntryType().getTypeCode()));
		}
	}

//	private void generateMissingDocEntryAttributesCda(String docEntryUuid) throws Exception {
//		ClinicalDocument cda = CDAUtil.load(txnData.getDocument(docEntryUuid).getStream());
//		DocumentMetadata docMetadata = new DocumentMetadata(txnData.getDocumentEntry(docEntryUuid));
//		
//		//PatientId from recordTarget/patientRole
//		if (cda.getPatientRoles()!=null && docMetadata.getMdhtDocumentEntryType().getPatientId()==null) {
//			if (cda.getPatientRoles().get(0).getIds()!=null) {
//				docMetadata.getMdhtDocumentEntryType().setPatientId(XdsUtil.convertII(cda.getPatientRoles().get(0).getIds().get(0)));
//			}
//		}
//		
//		//TODO Später: Kann bei CDA Dokumenten gemacht werden, indem die TemplateIDs mit dieser Liste (als Enum) verglichen werden: http://wiki.ihe.net/index.php?title=IHE_Format_Codes
//		//Currently only mapping to CDA-CH-VACD
//		II medicalDocumentII = DatatypesFactory.eINSTANCE.createII("1.3.6.1.4.1.19376.1.5.3.1.1.18.1.2");
//		II ii = org.ehealth_connector.common.Util.findII(cda.getTemplateIds(), medicalDocumentII);
//		if (ii!=null) {
//			Code formatCode = new Code("1.3.6.1.4.1.19376.1.2.3", "urn:ihe:pcc:ic:2009");
//			docMetadata.setFormatCode(formatCode);
//		}
//		
//		//Set the Document Code as TypeCode
//		if (cda.getCode()!=null) {
//			Code code = new Code(cda.getCode());
//			docMetadata.setTypeCode(code);
//		}
//		
//		//Fix the OHT CDAExtraction bug(?), that authorTelecommunication is not a known Slot for the NIST Registry by deleting all authorTelecommunications
//		for (Object object: docMetadata.getMdhtDocumentEntryType().getAuthors()) {
//			AuthorType at = (AuthorType) object;
//			at.getAuthorTelecommunication().clear();
//		}
//		
//		//Fix the OHT CDAExtraction bug(?) that generates Unique Ids, which are to long for the registry (EXT part is larger than the allowed 16 characters)
//		docMetadata.setUniqueId(OID.createOIDGivenRoot(cda.getId().getRoot()));
//	}

	public XDSResponseType submit() throws Exception {
		//generate missing information for all documents
		for (XDSDocument xdsDoc : txnData.getDocList()) {
			generateMissingDocEntryAttributes(xdsDoc.getDocumentEntryUUID());
		}
		
		//Create SubmissionSet
		SubmissionSetType subSet = txnData.getSubmissionSet();
		subSet.setUniqueId(OID.createOIDGivenRoot((organizationalId),64));
		
		// set submission set source id
		subSet.setSourceId(organizationalId);

		// set submission time
		subSet.setSubmissionTime(DateUtil.nowAsTS().getValue());
		txnData.saveMetadataToFile("C:/temp/metadata.xml");

		//Use the PatientId of the first Document for the SubmissionSet/patientId
		String uuid = txnData.getDocList().get(0).getDocumentEntryUUID();
		//CX testCx = XdsUtil.createCx("TESTAuthority", "TestId");
		//subSet.setPatientId(testCx);
		CX testCx = txnData.getDocumentEntry(uuid).getPatientId();
		subSet.setPatientId(EcoreUtil.copy(testCx));

		// set ContentTypeCode
		subSet.setContentTypeCode(XdsUtil.createCodedMetadata("2.16.840.1.113883.6.1", "34133-9", "Summary of Episode Note" , null));

		txnData.saveMetadataToFile("C:/temp/meta.xml");
		return source.submit(txnData);
	}

	/**
	 * <p>
	 * Anfrage einer Impfempfehlung (pseudonymisiert das Dokument vor dem
	 * eigentlichen Versand ans Expertensystem). Die Kommunikation zum
	 * Kommunikations-Endpunkt erfolgt gemäss <b>IHE [PCC-12] Request for Clinical
	 * Guidance</b>.
	 * </p>
	 * <p>
	 * Rolle der API resp. der aufrufenden Anwendung für diese Methode: <b>IHE PCC
	 * Care Manager Akteur</b>
	 * </p>
	 * 
	 * @param destination
	 *          Ziel der Übertragung (Kommunikations-Endpunkt)
	 * @param doc
	 *          CDA-CH-VACD Dokument mit den Impfungen und anderen für die
	 *          Impfempfehlung relevanten Angaben eines Patienten.
	 * @return CDA-CH-VACD Dokument, welches mit dem Parameter doc übergeben
	 *         worden ist und nun zusätzlich die Section mit den Impfempfehlungen
	 *         enthält
	 * 
	 * @throws Exception
	 *           Fehler während der Übertragung
	 */
	public static CdaChVacd getImmunizationRecommendationRequest(
			Destination destination, CdaChVacd doc) throws Exception {
		return null;
	}

	/**
	 * <p>
	 * Lädt CDA-Dokumente von einem Medium (Datenträger oder Pfad im Dateisystem;
	 * gemäss IHE XDM). Die Verarbeitung des Mediums erfolgt gemäss <b>[ITI-32]
	 * Distribute Document Set on Media</b>.
	 * </p>
	 * <p>
	 * Rolle der API resp. der aufrufenden Anwendung für diese Methode: <b>IHE ITI
	 * Portable Media Importer Akteur</b>
	 * </p>
	 * 
	 * @param destination
	 *          Pfad zum Datenträger von dem XDM-konforme Daten geladen werden
	 * @return eine Liste von CDA-Dokumenten
	 * @throws Exception
	 */
	public static ArrayList<ClinicalDocument> parseStoredCdaChVacd(File destination)
			throws Exception {
		return null;
	}

	// Übermittlung per XDM (Speichern und Laden von einem Datenträger) - A10, A11

	/**
	 * Pseudonymisierung eines ClinicalDocument nach der CDA-CH-VACD Spezifikation
	 * (siehe CDA-CH-VACD, UseCases ab Kapitel 6.3 und insbesondere Kapitel
	 * "7.4 CDA Header", Regel <CH-VACD-HPAT> )
	 * 
	 * @return das pseudonymisierte CdaChVacd
	 */
	public static CdaChVacd pseudonymize(CdaChVacd doc) {
		return null;
	}

	// XDS: Interaktion mit einer IHE Registry - A8

	/**
	 * <p>
	 * Sendet ein CDA Dokument an einen Empfänger (Repository Akteur gemäss IHE
	 * XDR oder IHE XDS). Die Kommunikation zum Kommunikations-Endpunkt erfolgt
	 * gemäss <b>IHE [ITI-41] Provide & Register Document Set – b</b>.
	 * </p>
	 * <p>
	 * Rolle der API resp. der aufrufenden Anwendung für diese Methode: <b>IHE ITI
	 * Document Source Actor</b>
	 * </p>
	 * 
	 * @param metadata
	 *          Zusätzliche Metadaten für die Übertragung
	 * @param destination
	 *          Ziel der Übertragung (Kommunikations-Endpunkt)
	 * @param doc
	 *          das CDA-Dokument, welches verschickt werden soll
	 * @return status der XDS-Übertragung
	 * @throws Exception
	 */
	public static Response sendCdaDocument(XdsMetadata metadata,
			Destination destination, CdaCh doc) throws Exception {
		return null;
	}

	// XDS: Herunterladen eines Impfdokuments von einem IHE XDS Repository - A9

	/**
	 * <p>
	 * Sendet eine beliebige Datei an einen Empfänger (Repository Akteur gemäss IHE
	 * XDR oder IHE XDS). Die Kommunikation zum Kommunikations-Endpunkt erfolgt
	 * gemäss <b>IHE [ITI-41] Provide & Register Document Set – b</b>.
	 * </p>
	 * <p>
	 * Rolle der API resp. der aufrufenden Anwendung für diese Methode: <b>IHE ITI
	 * Document Source Actor</b>
	 * </p>
	 * 
	 * @param metadata
	 *          Metadaten zum Dokument
	 * @param destination
	 *          Ziel der Übertragung (Kommunikations-Endpunkt)
	 * @param filePath
	 *          Datei (inkl. Pfad), welche verschickt werden soll
	 * @return status der XDS-Übertragung
	 * @throws Exception
	 */
	public Response sendDocument(DocumentMetadata metadata, DocumentDescriptor docDesc, String filePath) throws Exception {
		return null;
	}

	// Anfrage einer Immunization Recommendation (Senden der Anfrage und Empfangen
	// der Antwort) - A4, A5, A6

	/**
	 * Speichert ein CDA Dokument für den Versand zu einer beliebigen Destination
	 * auf einem Medium
	 * 
	 * @param destination
	 *          Ziel der Übertragung (Kommunikations-Endpunkt)
	 * @param doc
	 *          CDA-CH Dokument
	 */
	public static void storeOnMedia(Destination destination, CdaCh doc) {
		// TODO Auto-generated method stub

	}

	/**
	 * <p>
	 * Speichert ein CDA-Dokument inkl. der benötigten Metadaten auf einem
	 * Datenträger (gemäss IHE XDM). Die Speicherung auf dem Medium erfolgt gemäss
	 * <b>[ITI-32] Distribute Document Set on Media</b>.
	 * </p>
	 * <p>
	 * Rolle der API resp. der aufrufenden Anwendung für diese Methode: <b>IHE ITI
	 * Portable Media Creator Akteur</b>
	 * </p>
	 * 
	 * @param destination
	 *          Pfad zum Datenträger auf dem XDM-konforme Daten gespeichert werden
	 * @param doc
	 *          das CDA-Dokument, welches gespeichert werden soll
	 * @return true, wenn das Dokument erfolgreich gespeichert wurde. Sonst:
	 *         false.
	 * @throws Exception
	 */
	public static boolean storeOnMedia(File destination, ClinicalDocument doc)
			throws Exception {
		return false;
	}
}
