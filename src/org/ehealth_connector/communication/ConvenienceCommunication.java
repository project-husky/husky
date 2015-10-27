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

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.zip.ZipFile;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.cda.ch.AuthorCh;
import org.ehealth_connector.common.DateUtil;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.communication.AtnaConfig.AtnaConfigMode;
import org.ehealth_connector.communication.DocumentMetadata.DocumentMetadataExtractionMode;
import org.ehealth_connector.communication.SubmissionSetMetadata.SubmissionSetMetadataExtractionMode;
import org.ehealth_connector.communication.ch.DocumentMetadataCh;
import org.ehealth_connector.communication.ch.enums.AuthorRole;
import org.ehealth_connector.communication.ch.enums.AvailabilityStatus;
import org.ehealth_connector.communication.xd.storedquery.FindDocumentsQuery;
import org.ehealth_connector.communication.xd.storedquery.StoredQueryInterface;
import org.ehealth_connector.communication.xd.xdm.IndexHtm;
import org.ehealth_connector.communication.xd.xdm.ReadmeTxt;
import org.ehealth_connector.communication.xd.xdm.XdmContents;
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
import org.openhealthtools.ihe.xds.metadata.DocumentEntryType;
import org.openhealthtools.ihe.xds.metadata.SubmissionSetType;
import org.openhealthtools.ihe.xds.metadata.extract.MetadataExtractionException;
import org.openhealthtools.ihe.xds.response.XDSQueryResponseType;
import org.openhealthtools.ihe.xds.response.XDSResponseType;
import org.openhealthtools.ihe.xds.response.XDSRetrieveResponseType;
import org.openhealthtools.ihe.xds.source.B_Source;
import org.openhealthtools.ihe.xds.source.SubmitTransactionCompositionException;
import org.openhealthtools.ihe.xds.source.SubmitTransactionData;

/**
 * <div class="en">The ConvenienceCommunication class provides a convenience API
 * for transactions to different destinations such as registries and
 * repositories over media.<br>
 * <br>
 * It implements the following IHE actors:
 * <ul>
 * <li>IHE ITI Document Consumer</li>
 * <li>IHE ITI Document Source</li>
 * <li>IHE ITI Portable Media Creator</li>
 * <li>IHE ITI Portable Media Importer</li>
 * </ul>
 * <br>
 * It implements the following IHE transactions:
 * <ul>
 * <li>[ITI-18] Registry Stored Query</li>
 * <li>[ITI-32] Distribute Document Set on Media</li>
 * <li>[ITI-41] Provide and Register Document Set – b</li>
 * <li>[ITI-43] Retrieve Document Set</li>
 * </ul>
 * </div>
 */
public class ConvenienceCommunication {

	/**
	 * <div class="en">Exception in case when no document found</div>
	 */
	public class DocumentNotAccessibleException extends Exception {
		private static final long serialVersionUID = 1L;

		DocumentNotAccessibleException() {
			super("The Document could not be found. Is the path correct?");
		}
	}

	/**
	 * <div class="en">The affinity domain set-up</div>
	 */
	private AffinityDomain affinityDomain = null;

	/**
	 * <div class="en">The OHT source</div>
	 */
	private B_Source source = null;

	/**
	 * <div class="en">The OHT transaction data to send XDS Documents</div>
	 */
	private SubmitTransactionData txnData = null;

	/**
	 * <div class="en">The ATNA config mode (secure or unsecure)</div>
	 */
	private AtnaConfig.AtnaConfigMode atnaConfigMode = AtnaConfigMode.UNSECURE;

	/**
	 * <div class="en">Determines if XDS document metadata will be extracted
	 * automatically (e.g. from CDA documents)</div>
	 */
	private DocumentMetadataExtractionMode automaticDocumentMetadataExtractionMode = DocumentMetadataExtractionMode.DEFAULT_EXTRACTION;
	/**
	 * <div class="en">Determines if SubmissionSet metadata will be extracted
	 * automatically (e.g. from CDA documents)</div>
	 */
	private DocumentMetadataExtractionMode automaticSubSetMetadataExtractionMode = DocumentMetadataExtractionMode.DEFAULT_EXTRACTION;

	/**
	 * <div class="en">Instantiates a new convenience communication without
	 * affinity domain set-up. ATNA audit is disabled (unsecure) </div>
	 *
	 */
	public ConvenienceCommunication() {
		this.affinityDomain = null;
		this.atnaConfigMode = AtnaConfigMode.UNSECURE;
	}

	/**
	 * <div class="en">Instantiates a new convenience communication with the
	 * given affinity domain set-up. ATNA audit is disabled (unsecure) </div>
	 *
	 * @param affinityDomain
	 *            the affinity domain configuration
	 */
	public ConvenienceCommunication(AffinityDomain affinityDomain) {
		this.affinityDomain = affinityDomain;
		this.atnaConfigMode = AtnaConfigMode.UNSECURE;
	}

	/**
	 * <div class="en">Instantiates a new convenience communication with the
	 * given affinity domain set-up.</div>
	 *
	 * @param affinityDomain
	 *            the affinity domain configuration
	 * @param atnaConfigMode
	 *            the ATNA config mode (secure or unsecure)
	 * @param documentMetadataExtractionMode
	 *            determines, if and how document metadata should be extracted
	 *            automatically. Extracted metadata attributes will not
	 *            overwrite attributes that have been set, manually.
	 * @param submissionSetMetadataExtractionMode
	 *            determines, if and how submission set metadata should be
	 *            extracted, automatically. Extracted metadata attributes will
	 *            not overwrite attributes that have been set, manually.
	 */
	public ConvenienceCommunication(AffinityDomain affinityDomain, AtnaConfigMode atnaConfigMode,
			DocumentMetadataExtractionMode documentMetadataExtractionMode,
			SubmissionSetMetadataExtractionMode submissionSetMetadataExtractionMode) {
		this.affinityDomain = affinityDomain;
		this.atnaConfigMode = atnaConfigMode;
		this.automaticDocumentMetadataExtractionMode = documentMetadataExtractionMode;
	}

	/**
	 * <div class="en">Adds a document to the XDS Submission set.
	 *
	 * @param desc
	 *            the document descriptor (which kind of document do you want to
	 *            transfer? e.g. PDF, CDA,...)
	 * @param inputStream
	 *            the input stream to the document
	 * @return the document metadata (which have to be completed)</div>
	 */
	public org.ehealth_connector.communication.ch.DocumentMetadataCh addChDocument(
			DocumentDescriptor desc, InputStream inputStream) {
		if (inputStream == null)
			try {
				throw new DocumentNotAccessibleException();
			} catch (DocumentNotAccessibleException e) {
				e.printStackTrace();
			}
		XDSDocument doc;
		try {
			doc = new XDSDocumentFromStream(desc, inputStream);
			return new DocumentMetadataCh(addXdsDocument(doc, desc));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * <div class="en">Adds a document to the XDS Submission set.
	 *
	 * @param desc
	 *            the document descriptor (which kind of document do you want to
	 *            transfer? e.g. PDF, CDA,...)
	 * @param filePath
	 *            the file path
	 * @return the document metadata (which have to be completed)</div>
	 */
	public DocumentMetadata addChDocument(DocumentDescriptor desc, String filePath) {
		XDSDocument doc;
		try {
			doc = new XDSDocumentFromFile(desc, filePath);
			return new DocumentMetadataCh(addXdsDocument(doc, desc));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * <div class="en">Adds a document to the XDS Submission set.
	 *
	 * @param desc
	 *            the document descriptor (which kind of document do you want to
	 *            transfer? e.g. PDF, CDA,...)
	 * @param inputStream
	 *            The input stream to the document
	 * @return the document metadata (which have to be completed)</div>
	 */
	public DocumentMetadata addDocument(DocumentDescriptor desc, InputStream inputStream) {
		XDSDocument doc;
		try {
			doc = new XDSDocumentFromStream(desc, inputStream);
			return addXdsDocument(doc, desc);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * <div class="en"> Adds a document to the XDS Submission set.
	 *
	 * @param desc
	 *            the document descriptor (which kind of document do you want to
	 *            transfer? e.g. PDF, CDA,...)
	 * @param filePath
	 *            the file path
	 * @return the document metadata (which have to be completed) </div>
	 */
	public DocumentMetadata addDocument(DocumentDescriptor desc, String filePath) {
		XDSDocument doc;
		try {
			doc = new XDSDocumentFromFile(desc, filePath);
			return addXdsDocument(doc, desc);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * <div class="en">Resets the transaction data (SubmissionSet and
	 * DocumentMetadata)</div>
	 */
	public void clearDocuments() {
		txnData = new SubmitTransactionData();
	}

	/**
	 * <div class="en">creates an XDM volume with default values. You have to
	 * add a document to this class first.</div>
	 *
	 * @param outputStream
	 *            The outputStream object where the contents will be written to.
	 * @return the XdmContents object
	 */
	public XdmContents createXdmContents(OutputStream outputStream) {
		if (automaticSubSetMetadataExtractionMode == DocumentMetadataExtractionMode.DEFAULT_EXTRACTION) {
			generateDefaultSubmissionSetAttributes();
		}
		XdmContents xdmContents = new XdmContents(new IndexHtm(txnData), new ReadmeTxt(txnData));
		xdmContents.createZip(outputStream, txnData);
		return xdmContents;
	}

	/**
	 * <div class="en">creates an XDM volume with a given XdmContents object.
	 * This method will be used, if you want to create your own INDEX.HTM and
	 * README.TXT for your XDM volume. You have to add a document to this class
	 * first.</div>
	 *
	 * @param outputStream
	 *            The outputStream object where the contents will be written to.
	 * @param xdmContents
	 *            The xdmContents object containing your own INDEX.HTM and
	 *            README.TXT
	 * @return the XdmContents object
	 */
	public XdmContents createXdmContents(OutputStream outputStream, XdmContents xdmContents) {
		if (automaticSubSetMetadataExtractionMode == DocumentMetadataExtractionMode.DEFAULT_EXTRACTION) {
			generateDefaultSubmissionSetAttributes();
		}
		xdmContents.createZip(outputStream, txnData);
		return xdmContents;
	}

	/**
	 * <div class="en">creates an XDM volume with default values. You have to
	 * add a document to this class first.</div>
	 *
	 * @param filePath
	 *            The filePath where the contents will be written to.
	 * @return the XdmContents object
	 */
	public XdmContents createXdmContents(String filePath) {
		if (automaticSubSetMetadataExtractionMode == DocumentMetadataExtractionMode.DEFAULT_EXTRACTION) {
			generateDefaultSubmissionSetAttributes();
		}
		XdmContents xdmContents = new XdmContents(new IndexHtm(txnData), new ReadmeTxt(txnData));
		xdmContents.createZip(filePath, txnData);
		return xdmContents;
	}

	/**
	 * <div class="en">creates an XDM volume with default values. You have to
	 * add a document to this class first.</div>
	 *
	 * @param filePath
	 *            The filePath where the contents will be written to.
	 * @param xdmContents
	 *            The xdmContents object containing your own INDEX.HTM and
	 *            README.TXT
	 *
	 * @return the XdmContents object
	 */
	public XdmContents createXdmContents(String filePath, XdmContents xdmContents) {
		if (automaticSubSetMetadataExtractionMode == DocumentMetadataExtractionMode.DEFAULT_EXTRACTION) {
			generateDefaultSubmissionSetAttributes();
		}
		xdmContents.createZip(filePath, txnData);
		return xdmContents;
	}

	/**
	 * <div class="en">Returns the current affinity domain
	 *
	 * @return the affinity domain </div>
	 */
	public AffinityDomain getAffinityDomain() {
		if (affinityDomain == null)
			affinityDomain = new AffinityDomain(null, null, new ArrayList<Destination>());
		return affinityDomain;
	}

	/**
	 * Gets the status of the automatic metadata extraction
	 *
	 * @return true, if metadata will be extracted as far as possible)
	 *         automatically, false otherwise
	 */
	public DocumentMetadataExtractionMode getAutomaticExtractionEnabled() {
		return automaticDocumentMetadataExtractionMode;
	}

	/**
	 * <div class="en">Gets the OHT transaction data (SubmissionSet and
	 * DocumentMetadata)
	 *
	 * @return the transaction data object </div>
	 */
	public SubmitTransactionData getTxnData() {
		return this.txnData;
	}

	/**
	 * Returns the contents of an existing XDM volume.
	 *
	 * @param filePath
	 *            the XDM volume as ZipFile
	 * @return the XDMContents
	 */
	public XdmContents getXdmContents(String filePath) {
		return new XdmContents(filePath);
	}

	/**
	 * Returns the contents of an existing XDM volume.
	 *
	 * @param zipFile
	 *            the XDM volume as ZipFile
	 * @return the XDMContents
	 */
	public XdmContents getXdmContents(ZipFile zipFile) {
		return new XdmContents(zipFile);
	}

	/**
	 * <div class="en">Queries the document registry of the affinity domain for
	 * documents, using a find documents query. This is useful if the number of
	 * results is limited in the registry and your query would exceed this
	 * limit. In this case, precise your query or do a query for references
	 * first, choose the possible matches (e.g. the last 10 results) and then
	 * query for metadata.
	 *
	 * @param queryParameter
	 *            a findDocumentsQuery object filled with your query parameters
	 * @return the OHT XDSQueryResponseType containing references instead of the
	 *         complete document metadata</div>
	 */
	public XDSQueryResponseType queryDocumentReferencesOnly(FindDocumentsQuery queryParameter) {
		return this.queryDocuments((StoredQueryInterface) queryParameter);
	}

	/**
	 * Query a registry for documents, using a find documents query.
	 *
	 * @param queryParameter
	 *            a findDocumentsQuery object filled with your query parameters
	 * @param returnReferencesOnly
	 *            if set to false, the registry response will contain the
	 *            document metadata. If set to true, the response will contain
	 *            references instead of the complete document metadata.
	 * @return the XDSQueryResponseType
	 */

	/**
	 * <div class="en">Queries the registry of the affinity domain for all
	 * documents of one patient. This is useful if the number of results is
	 * limited in the registry and your query would exceed this limit. In this
	 * case, precise your query or do a query for references first, choose the
	 * possible matches (e.g. the last 10 results) and then query for metadata.
	 *
	 * @param patientId
	 *            the ID of the patient
	 * @return the OHT XDSQueryResponseType containing references instead of the
	 *         complete document metadata</div>
	 */
	public XDSQueryResponseType queryDocumentReferencesOnly(Identificator patientId) {
		return this.queryDocuments(new FindDocumentsQuery(patientId, AvailabilityStatus.APPROVED));
	}

	/**
	 * <div class="en">Queries the document registry of the affinity domain for
	 * documents, using a find documents query.
	 *
	 * @param queryParameter
	 *            a findDocumentsQuery object filled with your query parameters
	 * @return the OHT XDSQueryResponseType containing full document
	 *         metadata</div>
	 */
	public XDSQueryResponseType queryDocuments(FindDocumentsQuery queryParameter) {
		return this.queryDocuments((StoredQueryInterface) queryParameter);
	}

	/**
	 * <div class="en">Queries the registry of the affinity domain for all
	 * documents of one patient.
	 *
	 * @param patientId
	 *            the ID of the patient
	 * @return the OHT XDSQueryResponseType containing full document
	 *         metadata</div>
	 */
	public XDSQueryResponseType queryDocuments(Identificator patientId) {
		return this.queryDocuments(new FindDocumentsQuery(patientId, AvailabilityStatus.APPROVED));
	}

	/**
	 * <div class="en">Queries the registry of the affinity domain for all
	 * documents satisfying the given query parameters.
	 *
	 * @param query
	 *            one of the given queries (@see
	 *            org.ehealth_connector.communication.storedquery and
	 *            org.ehealth_connector.communication.storedquery.ch)
	 * @return the OHT XDSQueryResponseType containing full document
	 *         metadata</div>
	 */
	public XDSQueryResponseType queryDocuments(StoredQueryInterface query) {
		setDefaultKeystoreTruststore(affinityDomain.getRegistryDestination());
		B_Consumer consumer = new B_Consumer(affinityDomain.getRegistryDestination().getUri());

		try {
			return consumer.invokeStoredQuery(query.getOhtStoredQuery(), false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * <div class="en">Queries the registry of the affinity domain for all
	 * documents satisfying the given query parameters. This is useful if the
	 * number of results is limited in the registry and your query would exceed
	 * this limit. In this case, precise your query or do a query for references
	 * first, choose the possible matches (e.g. the last 10 results) and then
	 * query for metadata.
	 *
	 * @param query
	 *            one of the given queries (@see
	 *            org.ehealth_connector.communication.storedquery and
	 *            org.ehealth_connector.communication.storedquery.ch)
	 * @return the OHT XDSQueryResponseType containing references instead of the
	 *         complete document metadata</div>
	 */
	public XDSQueryResponseType queryDocumentsReferencesOnly(StoredQueryInterface query) {
		setDefaultKeystoreTruststore(affinityDomain.getRegistryDestination());
		B_Consumer consumer = new B_Consumer(affinityDomain.getRegistryDestination().getUri());

		try {
			return consumer.invokeStoredQuery(query.getOhtStoredQuery(), true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * <div class="en">Retrieves a document from a Repository
	 *
	 * @param docReq
	 *            the document request
	 * @return the OHT XDSRetrieveResponseType </div>
	 */
	public XDSRetrieveResponseType retrieveDocument(DocumentRequest docReq) {
		return retrieveDocuments(new DocumentRequest[] { docReq });
	}

	/**
	 * <div class="en">Retrieves multiple documents from one or more
	 * Repositories
	 *
	 * @param docReq
	 *            an array of document requests
	 * @return the OHT XDSRetrieveResponseType </div>
	 */
	@SuppressWarnings("unchecked")
	public XDSRetrieveResponseType retrieveDocuments(DocumentRequest[] docReq) {
		B_Consumer consumer = new B_Consumer(affinityDomain.getRegistryDestination().getUri());

		// Create RetrieveSetRequestType
		RetrieveDocumentSetRequestType retrieveDocumentSetRequest = org.openhealthtools.ihe.xds.consumer.retrieve.RetrieveFactory.eINSTANCE
				.createRetrieveDocumentSetRequestType();

		// Put the Repository to the OHT Repository HashMap
		HashMap<String, URI> repositoryMap = null;
		for (int i = 0; i < docReq.length; i++) {
			repositoryMap = new HashMap<String, URI>();
			repositoryMap.put(docReq[i].getRepositoryId(), docReq[i].getRepositoryUri());

			// Add Document Request
			retrieveDocumentSetRequest.getDocumentRequest().add(
					docReq[i].getOhtDocumentRequestType());
		}
		consumer.setRepositoryMap(repositoryMap);

		// invoke retrieve documentSet
		XDSRetrieveResponseType response = consumer.retrieveDocumentSet(false,
				retrieveDocumentSetRequest, null);

		return response;
	}

	/**
	 * <div class="en">Sets the affinity domain set-up
	 *
	 * @param affinityDomain
	 *            the affinity domain set-up </div>
	 */
	public void setAffinityDomain(AffinityDomain affinityDomain) {
		this.affinityDomain = affinityDomain;
	}

	/**
	 * Sets the status of the automatic metadata extraction
	 *
	 * @param automaticExtractionEnabled
	 *            true, if metadata will be extracted as far as possible)
	 *            automatically, false otherwise
	 */
	public void setAutomaticExtractionEnabled(
			DocumentMetadataExtractionMode automaticExtractionEnabled) {
		this.automaticDocumentMetadataExtractionMode = automaticExtractionEnabled;
	}

	/**
	 * <div class="en">Submission of the previously prepared document(s) to the
	 * repository<br>
	 * IHE [ITI-41] Provide and Register Document Set – b in the role of the IHE
	 * ITI Document Source actor
	 *
	 * @return the OHT XDSResponseType</div>
	 * @throws Exception
	 *             if the transfer is not successful
	 */
	public XDSResponseType submit() throws Exception {
		setDefaultKeystoreTruststore(affinityDomain.getRepositoryDestination());
		source = new B_Source(affinityDomain.getRepositoryDestination().getUri());

		if (automaticSubSetMetadataExtractionMode == DocumentMetadataExtractionMode.DEFAULT_EXTRACTION) {
			generateDefaultSubmissionSetAttributes();
		}

		return source.submit(txnData);
	}

	/**
	 * <div class="en">Submission of the previously prepared document(s) to the
	 * repository<br>
	 * IHE [ITI-41] Provide and Register Document Set – b in the role of the IHE
	 * ITI Document Source actor
	 *
	 * @param authorRole
	 *            The AuthorRole is one of the minimal required information
	 *            according to IHE Suisse for classification of documents in
	 *            Switzerland.
	 * @return the OHT XDSResponseType</div>
	 * @throws Exception
	 *             if the transfer is not successful
	 */
	public XDSResponseType submit(AuthorRole authorRole) throws Exception {
		SubmissionSetMetadata subSet = new SubmissionSetMetadata();
		AuthorCh author = new AuthorCh();
		author.setRoleFunction(authorRole);
		subSet.setAuthor(author);
		return submit(subSet);
	}

	/**
	 * <div class="en">Submission of the previously prepared document(s) to the
	 * repository<br>
	 * IHE [ITI-41] Provide and Register Document Set – b in the role of the IHE
	 * ITI Document Source actor
	 *
	 * @param submissionSetMetadata
	 *            The information in this object will be used to create
	 *            comprehensive meta data about this submission (e.g. with
	 *            AuthorRole, AuthorInstitution, ContentType and Title).
	 *            Although, some of this information can be derived
	 *            automatically, some may be required in your country (e.g.
	 *            AuthorRole in Switzerland)
	 * @return the OHT XDSResponseType</div>
	 * @throws Exception
	 *             if the transfer is not successful
	 */
	public XDSResponseType submit(SubmissionSetMetadata submissionSetMetadata) throws Exception {
		submissionSetMetadata.toOhtSubmissionSetType(txnData.getSubmissionSet());
		return submit();
	}

	/**
	 * <div class="en">Setting up the communication endpoints for the affinity
	 * domain and the logger
	 *
	 * @param affinityDomain
	 *            the affinity domain
	 * @param atnaConfigMode
	 *            the ATNA config mode (secure or unsecure) </div> </div>
	 */
	protected void setUp(AffinityDomain affinityDomain, AtnaConfigMode atnaConfigMode) {
		XDSSourceAuditor.getAuditor().getConfig()
				.setAuditorEnabled(atnaConfigMode == AtnaConfigMode.SECURE);
	}

	/**
	 * <div class="en">Adds an XDSDocument to the Transaction data</div>
	 *
	 * @param doc
	 *            the document
	 * @param desc
	 *            the Document descriptor
	 * @return the DocumentMetadata
	 */
	private DocumentMetadata addXdsDocument(XDSDocument doc, DocumentDescriptor desc) {
		if (txnData == null) {
			txnData = new SubmitTransactionData();
		}
		XDSSourceAuditor.getAuditor().getConfig()
				.setAuditorEnabled(this.atnaConfigMode == AtnaConfigMode.SECURE);
		String docEntryUUID;
		try {

			docEntryUUID = txnData.addDocument(doc);

			DocumentMetadata docMetadata = new DocumentMetadata(
					txnData.getDocumentEntry(docEntryUUID));

			if (automaticDocumentMetadataExtractionMode == DocumentMetadataExtractionMode.DEFAULT_EXTRACTION) {
				if (DocumentDescriptor.CDA_R2.equals(desc)) {
					// extractDocMetadataFromCda(docMetadata);
					cdaExtractionFixes(docMetadata);
				}
				generateDefaultDocEntryAttributes(doc.getDocumentEntryUUID());
			} else {
				docMetadata.clear();
			}

			return docMetadata;
		} catch (MetadataExtractionException e) {
			e.printStackTrace();
		} catch (SubmitTransactionCompositionException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * <div class="en">Cda fixes of OHT CDAExtraction bugs and extraction
	 * methods, which are unsafe, because an XDS registry might use another
	 * value set.</div>
	 *
	 * @param docMetadata
	 *            the doc metadata </div>
	 */
	private void cdaExtractionFixes(DocumentMetadata docMetadata) {
		// Fix the OHT CDAExtraction behaviour, that uses the confidentiality
		// code from the cda for the XDS metadata. This leads to an error in the
		// swiss repository, where the value set is differnt. As procausion we
		// clean the list.
		docMetadata.clearExtracted();

		// Fix the OHT CDAExtraction bug(?), that authorTelecommunication is not
		// a known Slot for the NIST Registry by deleting all
		// authorTelecommunications
		for (Object object : docMetadata.getMdhtDocumentEntryType().getAuthors()) {
			AuthorType at = (AuthorType) object;
			at.getAuthorTelecommunication().clear();
		}

		// Fix the OHT CDAExtraction bug(?) that generates Unique Ids, which are
		// to long for the registry (EXT part is larger than the allowed 16
		// characters)
		docMetadata.setUniqueId(OID.createOIDGivenRoot(
				docMetadata.getDocSourceActorOrganizationId(), 64));
	}

	/**
	 * <div class="en">Generate missing doc entry attributes.</div>
	 *
	 * @param docEntryUuid
	 *            the doc entry uuid </div>
	 */
	private void generateDefaultDocEntryAttributes(String docEntryUuid) {

		DocumentMetadata docMetadata = new DocumentMetadata(txnData.getDocumentEntry(docEntryUuid));
		DocumentDescriptor desc = txnData.getDocument(docEntryUuid).getDescriptor();

		// Derive MimeType from DocumentDescriptor
		if (docMetadata.getMdhtDocumentEntryType().getMimeType() == null) {
			docMetadata.setMimeType(desc.getMimeType());
		}

		// Generate the UUID
		if (docMetadata.getMdhtDocumentEntryType().getUniqueId() == null) {
			docMetadata.setUniqueId(OID.createOIDGivenRoot(
					docMetadata.getDocSourceActorOrganizationId(), 64));
		}

		// Generate Creation Time with the current time
		if (docMetadata.getMdhtDocumentEntryType().getCreationTime() == null) {
			docMetadata.setCreationTime(DateUtil.nowAsDate());
		}
	}

	/**
	 * <div class="en">Generate missing Submission Set attributes</div>
	 */
	private void generateDefaultSubmissionSetAttributes() {
		// Create SubmissionSet
		SubmissionSetType subSet = txnData.getSubmissionSet();

		if ((subSet.getUniqueId() == null) || (subSet.getSourceId() == null)) {

			// This is the eHealth Connector Root OID
			// default value just in case...
			String organizationalId = "2.16.756.5.30.1.139.1.1";

			if (subSet.getUniqueId() == null) {
				subSet.setUniqueId(OID.createOIDGivenRoot(organizationalId, 64));
			}

			if (!txnData.getMetadata().getDocumentEntry().isEmpty()) {
				DocumentEntryType docEntry = (DocumentEntryType) txnData.getMetadata()
						.getDocumentEntry().get(0);
				organizationalId = docEntry.getPatientId().getAssigningAuthorityUniversalId();
			}
			// set submission set source id
			if (subSet.getSourceId() == null) {
				subSet.setSourceId(organizationalId);
			}
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
			if (txnData.getDocumentEntry(uuid).getTypeCode() != null) {
				subSet.setContentTypeCode(EcoreUtil.copy(txnData.getDocumentEntry(uuid)
						.getTypeCode()));
			}
		}
	}

	/**
	 * Sets the key- and truststore for the default security domain
	 *
	 * @param dest
	 *            the Destination Object
	 */
	private void setDefaultKeystoreTruststore(Destination dest) {
		if (dest.getKeyStore() == null) {
			System.clearProperty("javax.net.ssl.keyStore");
			System.clearProperty("javax.net.ssl.keyStorePassword");
			System.clearProperty("javax.net.ssl.trustStore");
			System.clearProperty("javax.net.ssl.trustStorePassword");
		} else {
			System.setProperty("javax.net.ssl.keyStore", dest.getKeyStore());
			System.setProperty("javax.net.ssl.keyStorePassword", dest.getKeyStorePassword());
			System.setProperty("javax.net.ssl.trustStore", dest.getTrustStore());
			System.setProperty("javax.net.ssl.trustStorePassword", dest.getTrustStorePassword());
		}
		// System.setProperty("javax.net.debug", "all");
		// System.setProperty("https.protocols", "TLSv1.2");
		// System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
		// System.setProperty("https.ciphersuites",
		// "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256");

		// System.setProperty("https.ciphersuites",
		// "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384,TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384,TLS_RSA_WITH_AES_256_CBC_SHA256,TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384,TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384,TLS_DHE_RSA_WITH_AES_256_CBC_SHA256,TLS_DHE_DSS_WITH_AES_256_CBC_SHA256,TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA,TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA,TLS_RSA_WITH_AES_256_CBC_SHA,TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA,TLS_ECDH_RSA_WITH_AES_256_CBC_SHA,TLS_DHE_RSA_WITH_AES_256_CBC_SHA,TLS_DHE_DSS_WITH_AES_256_CBC_SHA,TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256,TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256,TLS_RSA_WITH_AES_128_CBC_SHA256,TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256,TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256,TLS_DHE_RSA_WITH_AES_128_CBC_SHA256,TLS_DHE_DSS_WITH_AES_128_CBC_SHA256,TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA,TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA,TLS_RSA_WITH_AES_128_CBC_SHA,TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA,TLS_ECDH_RSA_WITH_AES_128_CBC_SHA,TLS_DHE_RSA_WITH_AES_128_CBC_SHA,TLS_DHE_DSS_WITH_AES_128_CBC_SHA,TLS_ECDHE_ECDSA_WITH_RC4_128_SHA,TLS_ECDHE_RSA_WITH_RC4_128_SHA,SSL_RSA_WITH_RC4_128_SHA,TLS_ECDH_ECDSA_WITH_RC4_128_SHA,TLS_ECDH_RSA_WITH_RC4_128_SHA,TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA,TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA,SSL_RSA_WITH_3DES_EDE_CBC_SHA,TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA,TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA,SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA,SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA,SSL_RSA_WITH_RC4_128_MD5");
	}
}
