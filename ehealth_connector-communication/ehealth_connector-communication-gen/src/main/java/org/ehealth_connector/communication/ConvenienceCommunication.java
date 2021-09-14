/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */
package org.ehealth_connector.communication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipFile;

import javax.activation.DataHandler;
import javax.mail.util.ByteArrayDataSource;

import org.apache.camel.CamelContext;
import org.apache.cxf.binding.soap.interceptor.SoapOutInterceptor;
import org.apache.cxf.interceptor.AttachmentOutInterceptor;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.communication.AffinityDomain;
import org.ehealth_connector.common.communication.AtnaConfig;
import org.ehealth_connector.common.communication.AtnaConfig.AtnaConfigMode;
import org.ehealth_connector.common.communication.Destination;
import org.ehealth_connector.common.communication.DocumentMetadata;
import org.ehealth_connector.common.communication.DocumentMetadata.DocumentMetadataExtractionMode;
import org.ehealth_connector.common.communication.SubmissionSetMetadata;
import org.ehealth_connector.common.communication.SubmissionSetMetadata.SubmissionSetMetadataExtractionMode;
import org.ehealth_connector.common.enums.DocumentDescriptor;
import org.ehealth_connector.common.enums.EhcVersions;
import org.ehealth_connector.common.utils.DateUtil;
import org.ehealth_connector.common.utils.DateUtilMdht;
import org.ehealth_connector.common.utils.Util;
import org.ehealth_connector.common.utils.XdsMetadataUtil;
import org.ehealth_connector.communication.xd.storedquery.AbstractStoredQuery;
import org.ehealth_connector.communication.xd.storedquery.FindDocumentsQuery;
import org.ehealth_connector.communication.xd.storedquery.FindFoldersStoredQuery;
import org.ehealth_connector.communication.xd.xdm.IndexHtm;
import org.ehealth_connector.communication.xd.xdm.ReadmeTxt;
import org.ehealth_connector.communication.xd.xdm.XdmContents;
import org.ehealth_connector.xua.core.SecurityHeaderElement;
import org.ehealth_connector.xua.exceptions.SerializeException;
import org.ehealth_connector.xua.saml2.Assertion;
import org.ehealth_connector.xua.serialization.impl.AssertionSerializerImpl;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Document;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.DocumentEntry;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Folder;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.SubmissionSet;
import org.openehealth.ipf.commons.ihe.xds.core.requests.ProvideAndRegisterDocumentSet;
import org.openehealth.ipf.commons.ihe.xds.core.requests.QueryRegistry;
import org.openehealth.ipf.commons.ihe.xds.core.requests.RetrieveDocumentSet;
import org.openehealth.ipf.commons.ihe.xds.core.requests.query.QueryReturnType;
import org.openehealth.ipf.commons.ihe.xds.core.responses.QueryResponse;
import org.openehealth.ipf.commons.ihe.xds.core.responses.Response;
import org.openehealth.ipf.commons.ihe.xds.core.responses.RetrievedDocumentSet;
import org.openhealthtools.ihe.atna.auditor.XDSSourceAuditor;
import org.openhealthtools.ihe.atna.auditor.context.AuditorModuleContext;
import org.openhealthtools.ihe.utils.OID;
import org.openhealthtools.ihe.xds.XDSConstants;
import org.openhealthtools.ihe.xds.metadata.AuthorType;
import org.openhealthtools.ihe.xua.XUAAssertion;
import org.openhealthtools.ihe.xua.context.XUAModuleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Element;

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
@Component
public class ConvenienceCommunication extends CamelService {

	/** The SLF4J logger instance. */
	private static Logger log = LoggerFactory.getLogger(ConvenienceCommunication.class);

	@Autowired
	private CamelContext context;

	/**
	 * <div class="en">The affinity domain set-up</div>
	 */
	private AffinityDomain affinityDomain = null;

	/**
	 * <div class="en">The ATNA config mode (secure or unsecure)</div>
	 */
	private AtnaConfig.AtnaConfigMode atnaConfigMode = AtnaConfigMode.UNSECURE;

	/**
	 * <div class="en">Determines if XDS document metadata will be extracted
	 * automatically (e.g. from CDA documents)</div>
	 */
	private DocumentMetadataExtractionMode documentMetadataExtractionMode = DocumentMetadataExtractionMode.DEFAULT_EXTRACTION;

	/**
	 * <div class="en">Determines if SubmissionSet metadata will be extracted
	 * automatically (e.g. from CDA documents)</div>
	 */
	private SubmissionSetMetadataExtractionMode submissionSetMetadataExtractionMode = SubmissionSetMetadataExtractionMode.DEFAULT_EXTRACTION;
	/**
	 * <div class="en">The IPF transaction data to send XDS Documents</div>
	 */
	private ProvideAndRegisterDocumentSet txnData = null;

	private String lastError = "";

	/**
	 * <div class="en">Instantiates a new convenience communication without affinity
	 * domain set-up. ATNA audit is disabled (unsecure) </div>
	 *
	 */
	public ConvenienceCommunication() {
		super();
		this.affinityDomain = null;
		this.atnaConfigMode = AtnaConfigMode.UNSECURE;
		// CustomHttpsTLSv11v12SocketFactory.setup();
		// AbstractAxis2Util.initAxis2Config();
	}

	/**
	 * <div class="en">Instantiates a new convenience communication with the given
	 * affinity domain set-up. ATNA audit is disabled (unsecure) </div>
	 *
	 * @param affinityDomain the affinity domain configuration
	 */
	public ConvenienceCommunication(AffinityDomain affinityDomain) {
		this.affinityDomain = affinityDomain;
		this.atnaConfigMode = AtnaConfigMode.UNSECURE;
		// CustomHttpsTLSv11v12SocketFactory.setup();
		// AbstractAxis2Util.initAxis2Config();
	}

	/**
	 * <div class="en">Instantiates a new convenience communication with the given
	 * affinity domain set-up.</div>
	 *
	 * @param affinityDomain                      the affinity domain configuration
	 * @param atnaConfigMode                      the ATNA config mode (secure or
	 *                                            unsecure)
	 * @param documentMetadataExtractionMode      determines, if and how document
	 *                                            metadata should be extracted
	 *                                            automatically. Extracted metadata
	 *                                            attributes will not overwrite
	 *                                            attributes that have been set,
	 *                                            manually.
	 * @param submissionSetMetadataExtractionMode determines, if and how submission
	 *                                            set metadata should be extracted,
	 *                                            automatically. Extracted metadata
	 *                                            attributes will not overwrite
	 *                                            attributes that have been set,
	 *                                            manually.
	 */
	public ConvenienceCommunication(AffinityDomain affinityDomain, AtnaConfigMode atnaConfigMode,
			DocumentMetadataExtractionMode documentMetadataExtractionMode,
			SubmissionSetMetadataExtractionMode submissionSetMetadataExtractionMode) {
		this.affinityDomain = affinityDomain;
		this.atnaConfigMode = atnaConfigMode;
		this.documentMetadataExtractionMode = documentMetadataExtractionMode;
		this.submissionSetMetadataExtractionMode = submissionSetMetadataExtractionMode;
		// CustomHttpsTLSv11v12SocketFactory.setup();
		// AbstractAxis2Util.initAxis2Config();
	}

	/**
	 * <div class="en">Adds a document to the XDS Submission set.
	 *
	 * @param desc        the document descriptor (which kind of document do you
	 *                    want to transfer? e.g. PDF, CDA,...)
	 * @param inputStream The input stream to the document
	 * @return the document metadata (which have to be completed)</div>
	 */
	public DocumentMetadata addDocument(DocumentDescriptor desc, InputStream inputStream) {
		return addDocument(desc, inputStream, null);
	}

	/**
	 * <div class="en">Adds a document to the XDS Submission set.
	 *
	 * @param desc                 the document descriptor (which kind of document
	 *                             do you want to transfer? e.g. PDF, CDA,...)
	 * @param inputStream          The input stream to the document
	 * @param inputStream4Metadata the input stream that is only used to get the
	 *                             metadata from (it's texts will be ascii conform
	 *                             for registry purposes)
	 * @return the document metadata (which have to be completed)</div>
	 */
	public DocumentMetadata addDocument(DocumentDescriptor desc, InputStream inputStream,
			InputStream inputStream4Metadata) {
		lastError = "";
		DocumentMetadata retVal = null;
		Document doc = new Document();
		try {
			var doc4Metadata = new Document();
			if (inputStream4Metadata != null) {
				InputStream unicodeStream = Util.convertNonAsciiText2Unicode(inputStream4Metadata);
				var dataSource = new ByteArrayDataSource(unicodeStream, desc.getMimeType());
				doc4Metadata.setDataHandler(new DataHandler(dataSource));
			}

			var dataSource = new ByteArrayDataSource(inputStream, desc.getMimeType());
			doc.setDataHandler(new DataHandler(dataSource));
			retVal = addXdsDocument(doc, desc, doc4Metadata);
		} catch (final IOException e) {
			log.error("Error adding document from inputstream.", e);
			String message = e.getMessage();
			if (e.getCause() != null)
				message = e.getCause().getMessage() + ": " + message;
			lastError = "Error adding document from inputstream: " + message;
			if (Util.isDebug())
				e.printStackTrace();
		}
		if (retVal != null)
			retVal.setDocumentDescriptor(desc);
		return retVal;
	}

	/**
	 * <div class="en"> Adds a document to the XDS Submission set.
	 *
	 * @param desc     the document descriptor (which kind of document do you want
	 *                 to transfer? e.g. PDF, CDA,...)
	 * @param filePath the file path
	 * @return the document metadata (which have to be completed) </div>
	 * @throws FileNotFoundException exception
	 */
	public DocumentMetadata addDocument(DocumentDescriptor desc, String filePath) throws FileNotFoundException {
		return addDocument(desc, filePath, null);
	}

	/**
	 * <div class="en"> Adds a document to the XDS Submission set.
	 *
	 * @param desc             the document descriptor (which kind of document do
	 *                         you want to transfer? e.g. PDF, CDA,...)
	 * @param filePath         the file path
	 * @param filePathMetadata the file path metadata
	 * @return the document metadata (which have to be completed) </div>
	 * @throws FileNotFoundException exception
	 */
	public DocumentMetadata addDocument(DocumentDescriptor desc, String filePath, String filePathMetadata)
			throws FileNotFoundException {
		return addDocument(desc, new FileInputStream(new File(filePath)));
	}

	/**
	 *
	 * <div class="en">Add a document to a folder by theire ids</div>
	 *
	 * @param documentEntryUUID the entry uuid of the document
	 * @param folderEntryUUID   the entry uuid of the folder
	 */
	public void addDocumentToFolder(String documentEntryUUID, String folderEntryUUID) {
		
		Folder folder = new Folder();
		folder.setEntryUuid(folderEntryUUID);
		folder.setLogicalUuid(documentEntryUUID);
		txnData.getFolders().add(folder);
	}

	/**
	 * <div class="en">Adds a xds folder.</div>
	 *
	 * @param submissionSetContentType the contenttype code for submission set
	 * @return the metadata of the new fold
	 */
	public Folder addFolder(Code submissionSetContentType) {
		if (txnData == null) {
			txnData = new ProvideAndRegisterDocumentSet();
		}
		XDSSourceAuditor.getAuditor().getConfig().setAuditorEnabled(this.atnaConfigMode == AtnaConfigMode.SECURE);

		Folder folder = new Folder();
		folder.assignEntryUuid();

		if (folder.getUniqueId() == null) {
			final String organizationalId = EhcVersions.getCurrentVersion().getOid();
			folder.setUniqueId(OID.createOIDGivenRoot(organizationalId, 64));
		}

		txnData.getFolders().add(folder);

		txnData.getSubmissionSet()
				.setContentTypeCode(XdsMetadataUtil.convertEhcCodeToCode(submissionSetContentType));

		return folder;
	}

	/**
	 * <div class="en">Adds an XDSDocument to the Transaction data</div>
	 *
	 * @param doc  the document
	 * @param desc the Document descriptor
	 * @return the DocumentMetadata
	 */
	protected DocumentMetadata addXdsDocument(Document doc, DocumentDescriptor desc) {
		return addXdsDocument(doc, desc, null);
	}

	/**
	 * <div class="en">Adds an XDSDocument to the Transaction data</div>.
	 *
	 * @param doc         the document
	 * @param desc        the Document descriptor
	 * @param metadataDoc the metadata doc
	 * @return the doc to get the metadata from
	 */
	protected DocumentMetadata addXdsDocument(Document doc, DocumentDescriptor desc, Document metadataDoc) {
		lastError = "";
		if (txnData == null) {
			txnData = new ProvideAndRegisterDocumentSet();
		}
		XDSSourceAuditor.getAuditor().getConfig().setAuditorEnabled(this.atnaConfigMode == AtnaConfigMode.SECURE);

		DocumentMetadata docMetadata = null;

		txnData.getDocuments().add(doc);
		if (metadataDoc != null) {
			docMetadata = new DocumentMetadata(metadataDoc.getDocumentEntry());
		} else {
			docMetadata = new DocumentMetadata(doc.getDocumentEntry());
		}

		if (documentMetadataExtractionMode == DocumentMetadataExtractionMode.DEFAULT_EXTRACTION) {
			if (DocumentDescriptor.CDA_R2.equals(desc)) {
				cdaExtractionFixes(docMetadata);
			}
			generateDefaultDocEntryAttributes(docMetadata, doc);
		} else {
			docMetadata.clear();
		}

		return docMetadata;
	}

	/**
	 *
	 * <div class="en">Method to add a xuser assertion to allow authentication on
	 * XDS.b transactions.</div>
	 *
	 * @param assertion The assertion to be added to the soap header
	 * @throws SerializeException if there are problems adding the assertion
	 */
	public void addXUserAssertion(Assertion assertion) throws SerializeException {
		final XUAModuleContext xuaContext = XUAModuleContext.getContext();
		final Element assertionElement = new AssertionSerializerImpl().toXmlElement(assertion);
		final XUAAssertion ohtAssertion = new XUAAssertion(assertionElement);
		xuaContext.cacheAssertion(ohtAssertion);
		xuaContext.getConfig().getXUAEnabledActions().add(XDSConstants.PROVIDE_AND_REGISTER_DOCUMENT_SET_ACTION);
		AuditorModuleContext.getContext().getConfig().setSystemUserName(ohtAssertion.getAtnaUsername());
		xuaContext.setXUAEnabled(true);
		xuaContext.setActiveAssertion(ohtAssertion);
	}

	/**
	 * <div class="en">Cda fixes of OHT CDAExtraction bugs and extraction methods,
	 * which are unsafe, because an XDS registry might use another value set.</div>
	 *
	 * @param docMetadata the doc metadata </div>
	 */
	private void cdaExtractionFixes(DocumentMetadata docMetadata) {
		// Fix the OHT CDAExtraction behaviour, that uses the confidentiality
		// code from the cda for the XDS metadata. This leads to an error in the
		// swiss repository, where the value set is differnt. As procausion we
		// clean the list.
		docMetadata.clearExtracted();

		// Fix the OHT for invalid empty authorTelecommunicationentries by
		// deleting all authorTelecommunications
		for (final Object object : docMetadata.getDocumentEntry().getAuthors()) {
			final AuthorType at = (AuthorType) object;
			at.getAuthorTelecommunication().clear();
		}

		// Fix the OHT CDAExtraction bug(?) that generates Unique Ids, which are
		// to long for the registry (EXT part is larger than the allowed 16
		// characters)
		docMetadata.setUniqueId(OID.createOIDGivenRoot(docMetadata.getDocSourceActorOrganizationId(), 64));
	}

	/**
	 * <div class="en">Resets the transaction data (SubmissionSet and
	 * DocumentMetadata)</div>
	 */
	public void clearDocuments() {
		txnData = new ProvideAndRegisterDocumentSet();
	}

	/**
	 * <div class="en">creates an XDM volume with default values. You have to add a
	 * document to this class first.</div>
	 *
	 * @param outputStream The outputStream object where the contents will be
	 *                     written to.
	 * @return the XdmContents object
	 */
	public XdmContents createXdmContents(OutputStream outputStream) {
		if (submissionSetMetadataExtractionMode == SubmissionSetMetadataExtractionMode.DEFAULT_EXTRACTION) {
			generateDefaultSubmissionSetAttributes();
		}
		final var xdmContents = new XdmContents(new IndexHtm(txnData), new ReadmeTxt(txnData));
		xdmContents.createZip(outputStream, txnData);
		return xdmContents;
	}

	/**
	 * <div class="en">creates an XDM volume with a given XdmContents object. This
	 * method will be used, if you want to create your own INDEX.HTM and README.TXT
	 * for your XDM volume. You have to add a document to this class first.</div>
	 *
	 * @param outputStream The outputStream object where the contents will be
	 *                     written to.
	 * @param xdmContents  The xdmContents object containing your own INDEX.HTM and
	 *                     README.TXT
	 * @return the XdmContents object
	 */
	public XdmContents createXdmContents(OutputStream outputStream, XdmContents xdmContents) {
		if (submissionSetMetadataExtractionMode == SubmissionSetMetadataExtractionMode.DEFAULT_EXTRACTION) {
			generateDefaultSubmissionSetAttributes();
		}
		xdmContents.createZip(outputStream, txnData);
		return xdmContents;
	}

	/**
	 * <div class="en">creates an XDM volume with default values. You have to add a
	 * document to this class first.</div>
	 *
	 * @param filePath The filePath where the contents will be written to.
	 * @return the XdmContents object
	 */
	public XdmContents createXdmContents(String filePath) {
		if (submissionSetMetadataExtractionMode == SubmissionSetMetadataExtractionMode.DEFAULT_EXTRACTION) {
			generateDefaultSubmissionSetAttributes();
		}
		final var xdmContents = new XdmContents(new IndexHtm(txnData), new ReadmeTxt(txnData));
		xdmContents.createZip(filePath, txnData);
		return xdmContents;
	}

	/**
	 * <div class="en">creates an XDM volume with default values. You have to add a
	 * document to this class first.</div>
	 *
	 * @param filePath    The filePath where the contents will be written to.
	 * @param xdmContents The xdmContents object containing your own INDEX.HTM and
	 *                    README.TXT
	 *
	 * @return the XdmContents object
	 */
	public XdmContents createXdmContents(String filePath, XdmContents xdmContents) {
		if (submissionSetMetadataExtractionMode == SubmissionSetMetadataExtractionMode.DEFAULT_EXTRACTION) {
			generateDefaultSubmissionSetAttributes();
		}
		xdmContents.createZip(filePath, txnData);
		return xdmContents;
	}

	/**
	 * <div class="en">creates an XDM volume with the given submission set metadata.
	 * You have to add a document to this class first.</div>
	 *
	 * @param submissionSetMetadata The metadata of the submission set
	 * @param outputStream          The outputStream object where the contents will
	 *                              be written to.
	 * @return the XdmContents object
	 */
	public XdmContents createXdmContents(SubmissionSetMetadata submissionSetMetadata, OutputStream outputStream) {
		submissionSetMetadata.toOhtSubmissionSetType(txnData.getSubmissionSet());
		final var xdmContents = new XdmContents(new IndexHtm(txnData), new ReadmeTxt(txnData));
		xdmContents.createZip(outputStream, txnData);
		return xdmContents;
	}

	/**
	 * <div class="en">Generate missing doc entry attributes.</div>
	 *
	 * @param docEntryUuid the doc entry uuid </div>
	 */
	private void generateDefaultDocEntryAttributes(DocumentMetadata docMetadata, Document document) {

		// Derive MimeType from DocumentDescriptor
		if (docMetadata.getDocumentEntry().getMimeType() == null) {
			docMetadata.setMimeType(document.getDocumentEntry().getMimeType());
		}

		// Generate the UUID
		if (docMetadata.getDocumentEntry().getUniqueId() == null) {
			docMetadata.setUniqueId(OID.createOIDGivenRoot(docMetadata.getDocSourceActorOrganizationId(), 64));
		}

		// Generate Creation Time with the current time
		if (docMetadata.getDocumentEntry().getCreationTime() == null) {
			docMetadata.setCreationTime(DateUtil.nowAsZonedDate());
		}
	}

	/**
	 * <div class="en">Generate missing Submission Set attributes</div>.
	 *
	 * @return the submission set
	 */
	public SubmissionSet generateDefaultSubmissionSetAttributes() {

		// Create SubmissionSet
		final SubmissionSet subSet = txnData.getSubmissionSet();

		if (txnData.getDocuments() != null && !txnData.getDocuments().isEmpty() && txnData.getDocuments().get(0) != null
				&& txnData.getDocuments().get(0).getDocumentEntry() != null) {
			final DocumentEntry firstDocEntry = txnData.getDocuments().get(0).getDocumentEntry();
			if (firstDocEntry.getPatientId() == null) {
				throw new IllegalStateException(
						"Missing destination patient ID in DocumentMetadata of first document.");
			}

			if ((subSet.getUniqueId() == null) || (subSet.getSourceId() == null)) {

				// This is the eHealth Connector Root OID
				// default value just in case...
				String organizationalId = EhcVersions.getCurrentVersion().getOid();

				if (subSet.getUniqueId() == null) {
					subSet.setUniqueId(OID.createOIDGivenRoot(organizationalId, 64));
				}

				if (firstDocEntry.getPatientId() != null) {
					organizationalId = firstDocEntry.getPatientId()
							.getAssigningAuthority().getUniversalId();
				}
				// set submission set source id
				if (subSet.getSourceId() == null) {
					subSet.setSourceId(organizationalId);
				}
			}

			// set submission time
			if (subSet.getSubmissionTime() == null) {
				subSet.setSubmissionTime(DateUtilMdht.nowAsTS().getValue());
			}
			// txnData.saveMetadataToFile("C:/temp/metadata.xml");

			// Use the PatientId of the first Document for the Submission set ID
			if (subSet.getPatientId() == null) {
				subSet.setPatientId(firstDocEntry.getPatientId());
			}

			// set ContentTypeCode
			if (subSet.getContentTypeCode() == null) {
				if (firstDocEntry.getTypeCode() != null) {
					subSet.setContentTypeCode(firstDocEntry.getTypeCode());
				}
			}
		} else if (txnData.getFolders() != null && !txnData.getFolders().isEmpty()
				&& txnData.getFolders().get(0) != null) {
			final Folder firstFolder = txnData.getFolders().get(0);
			if (firstFolder.getPatientId() == null) {
				throw new IllegalStateException(
						"Missing destination patient ID in DocumentMetadata of first document.");
			}

			if ((subSet.getUniqueId() == null) || (subSet.getSourceId() == null)) {

				// This is the eHealth Connector Root OID
				// default value just in case...
				String organizationalId = EhcVersions.getCurrentVersion().getOid();

				if (subSet.getUniqueId() == null) {
					subSet.setUniqueId(OID.createOIDGivenRoot(organizationalId, 64));
				}

				if (firstFolder.getPatientId() != null) {
					organizationalId = firstFolder.getPatientId().getAssigningAuthority().getUniversalId();
				}
				// set submission set source id
				if (subSet.getSourceId() == null) {
					subSet.setSourceId(organizationalId);
				}
			}

			// set submission time
			if (subSet.getSubmissionTime() == null) {
				subSet.setSubmissionTime(DateUtilMdht.nowAsTS().getValue());
			}
			// txnData.saveMetadataToFile("C:/temp/metadata.xml");

			// Use the PatientId of the first Document for the Submission set ID
			if (subSet.getPatientId() == null) {
				subSet.setPatientId(firstFolder.getPatientId());
			}

			if (subSet.getContentTypeCode() == null) {
				if ((firstFolder.getCodeList() != null) && (firstFolder.getCodeList().get(0) != null)) {
					subSet.setContentTypeCode(firstFolder.getCodeList().get(0));
				}
			}

		}
		return subSet;
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
	 * Query a registry for documents, using a find documents query.
	 *
	 * @param queryParameter       a findDocumentsQuery object filled with your
	 *                             query parameters
	 * @param returnReferencesOnly if set to false, the registry response will
	 *                             contain the document metadata. If set to true,
	 *                             the response will contain references instead of
	 *                             the complete document metadata.
	 * @return the XDSQueryResponseType
	 */

	/**
	 * Gets the status of the automatic metadata extraction
	 *
	 * @return true, if metadata will be extracted as far as possible)
	 *         automatically, false otherwise
	 */
	public DocumentMetadataExtractionMode getAutomaticExtractionEnabled() {
		return documentMetadataExtractionMode;
	}

	public String getLastError() {
		return lastError;
	}

	/**
	 * <div class="en">Gets the OHT transaction data (SubmissionSet and
	 * DocumentMetadata)
	 *
	 * @return the transaction data object </div>
	 */
	public ProvideAndRegisterDocumentSet getTxnData() {
		return this.txnData;
	}

	/**
	 * Returns the contents of an existing XDM volume.
	 *
	 * @param filePath the XDM volume as ZipFile
	 * @return the XDMContents
	 */
	public XdmContents getXdmContents(String filePath) {
		return new XdmContents(filePath);
	}

	/**
	 * Returns the contents of an existing XDM volume.
	 *
	 * @param zipFile the XDM volume as ZipFile
	 * @return the XDMContents
	 */
	public XdmContents getXdmContents(ZipFile zipFile) {
		return new XdmContents(zipFile);
	}

	/**
	 * <div class="en">Queries the document registry of the affinity domain for
	 * documents, using a find documents query. This is useful if the number of
	 * results is limited in the registry and your query would exceed this limit. In
	 * this case, precise your query or do a query for references first, choose the
	 * possible matches (e.g. the last 10 results) and then query for metadata.
	 *
	 * @param queryParameter a findDocumentsQuery object filled with your query
	 *                       parameters
	 * @return the OHT XDSQueryResponseType containing references instead of the
	 *         complete document metadata</div>
	 * @throws Exception
	 */
	public QueryResponse queryDocumentReferencesOnly(FindDocumentsQuery queryParameter,
			SecurityHeaderElement securityHeader) throws Exception {
		return queryDocumentQuery(queryParameter, securityHeader, QueryReturnType.OBJECT_REF);
	}

	/**
	 * <div class="en">Queries the document registry of the affinity domain for
	 * documents, using a find documents query.
	 *
	 * @param queryParameter a findDocumentsQuery object filled with your query
	 *                       parameters
	 * @return the OHT XDSQueryResponseType containing full document metadata</div>
	 * @throws Exception
	 */
	public QueryResponse queryDocuments(FindDocumentsQuery queryParameter, SecurityHeaderElement securityHeader)
			throws Exception {
		return queryDocumentQuery(queryParameter, securityHeader, QueryReturnType.LEAF_CLASS);
	}

	/**
	 * <div class="en">Queries the registry of the affinity domain for all documents
	 * satisfying the given query parameters.
	 *
	 * @param query one of the given queries (@see
	 *              org.ehealth_connector.communication.storedquery and
	 *              org.ehealth_connector.communication.storedquery.ch)
	 * @return the OHT XDSQueryResponseType containing full document metadata</div>
	 * @throws Exception
	 */
	public QueryResponse queryDocumentQuery(AbstractStoredQuery query, SecurityHeaderElement securityHeader,
			QueryReturnType returnType)
			throws Exception {
		/*
		 * lastError = "";
		 * setDefaultKeystoreTruststore(affinityDomain.getRegistryDestination()); final
		 * B_Consumer consumer = new B_Consumer(
		 * affinityDomain.getRegistryDestination().getUri());
		 * 
		 * try { return consumer.invokeStoredQuery(query.getOhtStoredQuery(), false); }
		 * catch (final Exception e) { log.error("Exception", e); String message =
		 * e.getMessage(); if (e.getCause() != null) message = e.getCause().getMessage()
		 * + ": " + message; lastError = "Query for documents failed: " + message; if
		 * (Util.isDebug()) e.printStackTrace();
		 * 
		 * }
		 */

		final var queryRegistry = new QueryRegistry(query.getIpfQuery());
		queryRegistry.setReturnType(returnType);

		final var serverInLogger = "#serverInLogger";
		final var serverOutLogger = "#serverOutLogger";
		final var attachmentOutInterceptor = "#AttachmentOutInterceptor";
		AttachmentOutInterceptor interceptor = new AttachmentOutInterceptor();
		SoapOutInterceptor soapOutInterceptor = new SoapOutInterceptor(null);

		final var endpoint = String.format(
				"xds-iti18://%s?inInterceptors=%s&inFaultInterceptors=%s&outInterceptors=%s&outFaultInterceptors=%s&secure=%s",
				this.affinityDomain.getRepositoryDestination().getUri().toString().replace("https://", ""),
				serverInLogger, serverInLogger, serverOutLogger, serverOutLogger,
				atnaConfigMode == AtnaConfigMode.SECURE);
		log.info("Sending request to '{}' endpoint", endpoint);

		Map<String, String> outgoingHeaders = new HashMap<>();
		// outgoingHeaders.put("Accept", "application/soap+xml");
		outgoingHeaders.put("transfer-encoding", "chunked");
		outgoingHeaders.put("Content-Type",
				"application/soap+xml; charset=UTF-8; action=\"urn:ihe:iti:2007:RegistryStoredQuery\"");
		outgoingHeaders.put("Force MTOM", "false");

		final var exchange = send(endpoint, queryRegistry, securityHeader, outgoingHeaders);

		return exchange.getMessage().getBody(QueryResponse.class);
	}

	/**
	 * <div class="en">Queries the registry of the affinity domain for all documents
	 * satisfying the given query parameters. This is useful if the number of
	 * results is limited in the registry and your query would exceed this limit. In
	 * this case, precise your query or do a query for references first, choose the
	 * possible matches (e.g. the last 10 results) and then query for metadata.
	 *
	 * @param query one of the given queries (@see
	 *              org.ehealth_connector.communication.storedquery and
	 *              org.ehealth_connector.communication.storedquery.ch)
	 * @return the OHT XDSQueryResponseType containing references instead of the
	 *         complete document metadata</div>
	 * @throws Exception
	 */
	public QueryResponse queryDocumentsReferencesOnly(AbstractStoredQuery query, SecurityHeaderElement securityHeader)
			throws Exception {
		/*
		 * lastError = "";
		 * setDefaultKeystoreTruststore(affinityDomain.getRegistryDestination()); final
		 * B_Consumer consumer = new B_Consumer(
		 * affinityDomain.getRegistryDestination().getUri());
		 * 
		 * try { return consumer.invokeStoredQuery(query.getOhtStoredQuery(), true); }
		 * catch (final Exception e) { log.error("Exception", e); String message =
		 * e.getMessage(); if (e.getCause() != null) message = e.getCause().getMessage()
		 * + ": " + message; lastError = "Query for document references failed: " +
		 * message; if (Util.isDebug()) e.printStackTrace();
		 * 
		 * } return null;
		 */

		final var queryRegistry = new QueryRegistry(query.getIpfQuery());

		final var serverInLogger = "#serverInLogger";
		final var serverOutLogger = "#serverOutLogger";
		final var endpoint = String.format(
				"xds-iti18://%s?inInterceptors=%s&inFaultInterceptors=%s&outInterceptors=%s&outFaultInterceptors=%s&secure=%s",
				affinityDomain.getRegistryDestination().getUri().toString().replace("https://", ""), serverInLogger,
				serverInLogger, serverOutLogger, serverOutLogger, atnaConfigMode == AtnaConfigMode.SECURE);
		log.info("Sending request to '{}' endpoint", endpoint);
		final var exchange = send(endpoint, queryRegistry, securityHeader, null);

		return exchange.getMessage().getBody(QueryResponse.class);
	}

	/**
	 * <div class="en">Queries the document registry of the affinity domain for
	 * documents, using a find documents query.
	 *
	 * @param queryParameter a findFoldersQuery object filled with your query
	 *                       parameters
	 * @return the OHT XDSQueryResponseType containing full folder metadata </div>
	 * @throws Exception
	 *
	 */
	public QueryResponse queryFolders(FindFoldersStoredQuery queryParameter, SecurityHeaderElement security)
			throws Exception {
		return queryDocumentQuery(queryParameter, security, QueryReturnType.LEAF_CLASS);
	}

	/**
	 * <div class="en">Retrieves a document from a Repository
	 *
	 * @param docReq the document request
	 * @return the OHT XDSRetrieveResponseType </div>
	 * @throws Exception
	 */
	public RetrievedDocumentSet retrieveDocument(DocumentRequest docReq, SecurityHeaderElement securityHeader)
			throws Exception {
		return retrieveDocuments(new DocumentRequest[] { docReq }, securityHeader);
	}

	/**
	 * <div class="en">Retrieves multiple documents from one or more Repositories
	 *
	 * @param docReq an array of document requests
	 * @return the OHT XDSRetrieveResponseType </div>
	 * @throws Exception
	 */
	public RetrievedDocumentSet retrieveDocuments(DocumentRequest[] docReq, SecurityHeaderElement securityHeader)
			throws Exception {
		final var retrieveDocumentSet = new RetrieveDocumentSet();

		for (final DocumentRequest element : docReq) {
			if (element != null) {
				retrieveDocumentSet.addReferenceTo(element.getIpfDocumentEntry());
			}
		}

		final var serverInLogger = "#serverInLogger";
		final var serverOutLogger = "#serverOutLogger";
		final var endpoint = String.format(
				"xds-iti43://%s?inInterceptors=%s&inFaultInterceptors=%s&outInterceptors=%s&outFaultInterceptors=%s&secure=%s",
				this.affinityDomain.getRepositoryDestination().getUri().toString().replace("https://", ""),
				serverInLogger, serverInLogger, serverOutLogger, serverOutLogger,
				atnaConfigMode == AtnaConfigMode.SECURE);
		log.info("Sending request to '{}' endpoint", endpoint);

		Map<String, String> outgoingHeaders = new HashMap<>();
		outgoingHeaders.put("Accept", "application/soap+xml");
		outgoingHeaders.put("Content-Type",
				"multipart/related; charset=UTF-8; action=\"urn:ihe:iti:2007:RetrieveDocumentSet\"");

		final var exchange = send(endpoint, retrieveDocumentSet, securityHeader, outgoingHeaders);

		return exchange.getMessage().getBody(RetrievedDocumentSet.class);
	}

	/**
	 * <div class="en">Sets the affinity domain set-up
	 *
	 * @param affinityDomain the affinity domain set-up </div>
	 */
	public void setAffinityDomain(AffinityDomain affinityDomain) {
		this.affinityDomain = affinityDomain;
	}

	/**
	 * Sets the status of the automatic metadata extraction
	 *
	 * @param automaticExtractionEnabled true, if metadata will be extracted as far
	 *                                   as possible) automatically, false otherwise
	 */
	public void setAutomaticExtractionEnabled(DocumentMetadataExtractionMode automaticExtractionEnabled) {
		this.documentMetadataExtractionMode = automaticExtractionEnabled;
	}

	/**
	 * Sets the key- and truststore for the default security domain
	 *
	 * @param dest the Destination Object
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
		// "TLS_RSA_WITH_AES_128_CBC_SHA,SSL_RSA_WITH_3DES_EDE_CBC_SHA");

		// System.setProperty("https.ciphersuites",
		// "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384,TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384,TLS_RSA_WITH_AES_256_CBC_SHA256,TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384,TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384,TLS_DHE_RSA_WITH_AES_256_CBC_SHA256,TLS_DHE_DSS_WITH_AES_256_CBC_SHA256,TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA,TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA,TLS_RSA_WITH_AES_256_CBC_SHA,TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA,TLS_ECDH_RSA_WITH_AES_256_CBC_SHA,TLS_DHE_RSA_WITH_AES_256_CBC_SHA,TLS_DHE_DSS_WITH_AES_256_CBC_SHA,TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256,TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256,TLS_RSA_WITH_AES_128_CBC_SHA256,TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256,TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256,TLS_DHE_RSA_WITH_AES_128_CBC_SHA256,TLS_DHE_DSS_WITH_AES_128_CBC_SHA256,TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA,TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA,TLS_RSA_WITH_AES_128_CBC_SHA,TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA,TLS_ECDH_RSA_WITH_AES_128_CBC_SHA,TLS_DHE_RSA_WITH_AES_128_CBC_SHA,TLS_DHE_DSS_WITH_AES_128_CBC_SHA,TLS_ECDHE_ECDSA_WITH_RC4_128_SHA,TLS_ECDHE_RSA_WITH_RC4_128_SHA,SSL_RSA_WITH_RC4_128_SHA,TLS_ECDH_ECDSA_WITH_RC4_128_SHA,TLS_ECDH_RSA_WITH_RC4_128_SHA,TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA,TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA,SSL_RSA_WITH_3DES_EDE_CBC_SHA,TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA,TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA,SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA,SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA,SSL_RSA_WITH_RC4_128_MD5");
	}

	/**
	 * Setting up the communication endpoints for the affinity domain and the logger
	 *
	 * @param affinityDomain the affinity domain
	 * @param atnaConfigMode the ATNA config mode (secure or unsecure)
	 */
	protected void setUp(AffinityDomain affinityDomain, AtnaConfigMode atnaConfigMode) {
		XDSSourceAuditor.getAuditor().getConfig().setAuditorEnabled(atnaConfigMode == AtnaConfigMode.SECURE);
	}

	/**
	 * <div class="en">Submission of the previously prepared document(s) to the
	 * repository<br>
	 * IHE [ITI-41] Provide and Register Document Set – b in the role of the IHE ITI
	 * Document Source actor
	 *
	 * @return the OHT XDSResponseType</div>
	 * @throws Exception if the transfer is not successful
	 */
	public Response submit(SecurityHeaderElement securityHeader) throws Exception {
		setDefaultKeystoreTruststore(affinityDomain.getRepositoryDestination());

		if (submissionSetMetadataExtractionMode == SubmissionSetMetadataExtractionMode.DEFAULT_EXTRACTION) {
			generateDefaultSubmissionSetAttributes();
		}

		final var serverInLogger = "#serverInLogger";
		final var serverOutLogger = "#serverOutLogger";
		final var endpoint = String.format(
				"xds-iti41://%s?inInterceptors=%s&inFaultInterceptors=%s&outInterceptors=%s&outFaultInterceptors=%s&secure=%s",
				this.affinityDomain.getRepositoryDestination().getUri().toString().replace("https://", ""),
				serverInLogger, serverInLogger, serverOutLogger, serverOutLogger,
				atnaConfigMode == AtnaConfigMode.SECURE);
		log.info("Sending request to '{}' endpoint", endpoint);

		Map<String, String> outgoingHeaders = new HashMap<>();
		outgoingHeaders.put("Accept", "application/soap+xml");
		outgoingHeaders.put("Content-Type",
				"multipart/related; charset=UTF-8; action=\"urn:ihe:iti:2007:RegistryStoredQuery\"");

		final var exchange = send(endpoint, txnData, securityHeader, outgoingHeaders);

		return exchange.getMessage().getBody(Response.class);
	}

	/**
	 * <div class="en">Submission of the previously prepared document(s) to the
	 * repository<br>
	 * IHE [ITI-41] Provide and Register Document Set – b in the role of the IHE ITI
	 * Document Source actor
	 *
	 * @param submissionSetMetadata The information in this object will be used to
	 *                              create comprehensive meta data about this
	 *                              submission (e.g. with AuthorRole,
	 *                              AuthorInstitution, ContentType and Title).
	 *                              Although, some of this information can be
	 *                              derived automatically, some may be required in
	 *                              your country (e.g. AuthorRole in Switzerland)
	 * @return the OHT XDSResponseType</div>
	 * @throws Exception if the transfer is not successful
	 */
	public Response submit(SubmissionSetMetadata submissionSetMetadata, SecurityHeaderElement securityHeader)
			throws Exception {
		submissionSetMetadata.toOhtSubmissionSetType(txnData.getSubmissionSet());
		// txnData.saveMetadataToFile("C:/temp/metadata_fhir.xml");
		return submit(securityHeader);
	}
}
