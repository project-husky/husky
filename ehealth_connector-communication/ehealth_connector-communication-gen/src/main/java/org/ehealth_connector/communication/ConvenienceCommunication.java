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
import java.util.UUID;
import java.util.zip.ZipFile;

import javax.activation.DataHandler;
import javax.mail.util.ByteArrayDataSource;

import org.apache.camel.CamelContext;
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
import org.ehealth_connector.common.utils.OID;
import org.ehealth_connector.common.utils.Util;
import org.ehealth_connector.common.utils.XdsMetadataUtil;
import org.ehealth_connector.communication.xd.storedquery.AbstractStoredQuery;
import org.ehealth_connector.communication.xd.storedquery.FindFoldersStoredQuery;
import org.ehealth_connector.communication.xd.xdm.IndexHtm;
import org.ehealth_connector.communication.xd.xdm.ReadmeTxt;
import org.ehealth_connector.communication.xd.xdm.XdmContents;
import org.ehealth_connector.xua.core.SecurityHeaderElement;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Association;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AssociationLabel;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AssociationType;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AvailabilityStatus;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Document;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.DocumentEntry;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Folder;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.SubmissionSet;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Timestamp;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Timestamp.Precision;
import org.openehealth.ipf.commons.ihe.xds.core.requests.ProvideAndRegisterDocumentSet;
import org.openehealth.ipf.commons.ihe.xds.core.requests.QueryRegistry;
import org.openehealth.ipf.commons.ihe.xds.core.requests.RetrieveDocumentSet;
import org.openehealth.ipf.commons.ihe.xds.core.requests.query.QueryReturnType;
import org.openehealth.ipf.commons.ihe.xds.core.responses.QueryResponse;
import org.openehealth.ipf.commons.ihe.xds.core.responses.Response;
import org.openehealth.ipf.commons.ihe.xds.core.responses.RetrievedDocumentSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

	private static final String SERVER_IN_LOGGER = "#serverInLogger";
	private static final String SERVER_OUT_LOGGER = "#serverOutLogger";
	private static final String AUDIT_CONTEXT = "#auditContext";

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

	/**
	 * <div class="en">Instantiates a new convenience communication without affinity
	 * domain set-up. ATNA audit is disabled (unsecure) </div>
	 *
	 */
	public ConvenienceCommunication() {
		super();
		this.affinityDomain = null;
		this.atnaConfigMode = AtnaConfigMode.UNSECURE;
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
		DocumentMetadata retVal = null;
		var doc = new Document();
		try {
			var doc4Metadata = new Document();
			doc4Metadata.setDocumentEntry(new DocumentEntry());
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
			log.error(e.getMessage(), e);
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
	 * <div class="en">Add a document to a folder by theirs ids</div>
	 *
	 * @param documentEntryUUID the entry uuid of the document
	 * @param folderEntryUUID   the entry uuid of the folder
	 */
	public void addDocumentToFolder(String documentEntryUUID, String folderEntryUUID) {
		var association = new Association(AssociationType.HAS_MEMBER, UUID.randomUUID().toString(),
				folderEntryUUID,
				documentEntryUUID);
		txnData.getAssociations().add(association);
	}

	/**
	 * <div class="en">Adds a xds folder.</div>
	 *
	 * @param submissionSetContentType the content type code for submission set
	 * @return the metadata of the new folder
	 */
	public FolderMetadata addFolder(Code submissionSetContentType) {
		if (txnData == null) {
			txnData = new ProvideAndRegisterDocumentSet();
		}

		var folder = new Folder();
		folder.assignEntryUuid();

		if (folder.getUniqueId() == null) {
			final String organizationalId = EhcVersions.getCurrentVersion().getOid();
			folder.setUniqueId(OID.createOIDGivenRoot(organizationalId, 64));
		}

		txnData.getFolders().add(folder);

		if (txnData.getSubmissionSet() == null) {
			txnData.setSubmissionSet(new SubmissionSet());
		}

		txnData.getSubmissionSet()
				.setContentTypeCode(XdsMetadataUtil.convertEhcCodeToCode(submissionSetContentType));

		return new FolderMetadata(folder);
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
		if (txnData == null) {
			txnData = new ProvideAndRegisterDocumentSet();
		}

		DocumentMetadata docMetadata = null;

		if (metadataDoc != null) {
			docMetadata = new DocumentMetadata(metadataDoc.getDocumentEntry());
			if (doc.getDocumentEntry() == null) {
				doc.setDocumentEntry(metadataDoc.getDocumentEntry());
			}
		} else {
			docMetadata = new DocumentMetadata(doc.getDocumentEntry());
		}

		txnData.getDocuments().add(doc);

		if (documentMetadataExtractionMode == DocumentMetadataExtractionMode.DEFAULT_EXTRACTION) {
			if (DocumentDescriptor.CDA_R2.equals(desc)) {
				cdaExtractionFixes(docMetadata);
			}
			generateDefaultDocEntryAttributes(docMetadata, doc, desc);
		} else {
			docMetadata.clear();
		}

		return docMetadata;
	}

	/**
	 * <div class="en">Cda fixes of CDAExtraction bugs and extraction methods, which
	 * are unsafe, because an XDS registry might use another value set.</div>
	 *
	 * @param docMetadata the doc metadata </div>
	 */
	private void cdaExtractionFixes(DocumentMetadata docMetadata) {
		// Fix the OHT CDAExtraction behavior, that uses the confidentiality
		// code from the cda for the XDS metadata. This leads to an error in the
		// swiss repository, where the value set is different. As precaution we
		// clean the list.
		docMetadata.clearExtracted();

		// Checks if the unique ID is longer than 64 or if no unique ID is set a new unique ID should be generated
		if (docMetadata.getUniqueId() == null
				|| (docMetadata.getUniqueId() != null && docMetadata.getUniqueId().length() > 64)) {
			docMetadata.setUniqueId(OID.createOIDGivenRoot(docMetadata.getDocSourceActorOrganizationId(), 64));
		}

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
			txnData.setSubmissionSet(generateDefaultSubmissionSetAttributes());
			linkDocumentEntryWithSubmissionSet();
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
			txnData.setSubmissionSet(generateDefaultSubmissionSetAttributes());
			linkDocumentEntryWithSubmissionSet();
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
			txnData.setSubmissionSet(generateDefaultSubmissionSetAttributes());
			linkDocumentEntryWithSubmissionSet();
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
			txnData.setSubmissionSet(generateDefaultSubmissionSetAttributes());
			linkDocumentEntryWithSubmissionSet();
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
		if (txnData.getSubmissionSet() == null) {
			txnData.setSubmissionSet(new SubmissionSet());
		}

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
	private void generateDefaultDocEntryAttributes(DocumentMetadata docMetadata, Document document,
			DocumentDescriptor documentDescriptor) {

		// Derive MimeType from DocumentDescriptor
		if (docMetadata.getDocumentEntry().getMimeType() == null) {
			docMetadata.setMimeType(documentDescriptor.getMimeType());
			document.getDocumentEntry().setMimeType(documentDescriptor.getMimeType());
		}

		// Generate the unique ID
		if (docMetadata.getDocumentEntry().getUniqueId() == null) {
			document.getDocumentEntry().assignUniqueId();
			docMetadata.setUniqueId(document.getDocumentEntry().getUniqueId());
			System.out.println(document.getDocumentEntry().getUniqueId().length());
		}

		// Generate the UUID
		if (docMetadata.getDocumentEntry().getEntryUuid() == null) {
			document.getDocumentEntry().assignEntryUuid();
			docMetadata.setEntryUUID(document.getDocumentEntry().getEntryUuid());
		}

		// Generate Creation Time with the current time
		if (docMetadata.getDocumentEntry().getCreationTime() == null) {
			docMetadata.setCreationTime(DateUtil.nowAsZonedDate());

			var timestamp = new org.openehealth.ipf.commons.ihe.xds.core.metadata.Timestamp(
					docMetadata.getCreationTime(), Precision.SECOND);
			document.getDocumentEntry().setCreationTime(timestamp);
		}
	}

	private void linkDocumentEntryWithSubmissionSet() {

		for (Document document : this.txnData.getDocuments()) {
			// link document entry to submission set
			var association = new Association();

			association.setAssociationType(AssociationType.HAS_MEMBER);
			association.setSourceUuid(this.txnData.getSubmissionSet().getEntryUuid());
			association.setTargetUuid(document.getDocumentEntry().getEntryUuid());
			association.setLabel(AssociationLabel.ORIGINAL);
			association.assignEntryUuid();

			this.txnData.getAssociations().add(association);
		}

		for (Folder folder : this.txnData.getFolders()) {
			// link folder to submission set
			var association = new Association(AssociationType.HAS_MEMBER,
					this.txnData.getSubmissionSet().getEntryUuid(), txnData.getSubmissionSet().getEntryUuid(),
					folder.getEntryUuid());
			association.assignEntryUuid();

			this.txnData.getAssociations().add(association);
		}

	}

	/**
	 * <div class="en">Generate missing Submission Set attributes</div>.
	 *
	 * @return the submission set
	 */
	public SubmissionSet generateDefaultSubmissionSetAttributes() {

		if (txnData.getSubmissionSet() == null) {
			txnData.setSubmissionSet(new SubmissionSet());
		}

		// Create SubmissionSet
		final var subSet = txnData.getSubmissionSet();

		if (txnData.getDocuments() != null && !txnData.getDocuments().isEmpty()) {

			for (Document document : txnData.getDocuments()) {
				final var docEntry = document.getDocumentEntry();
				if (docEntry.getPatientId() == null) {
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

					if (subSet.getEntryUuid() == null) {
						subSet.setEntryUuid(UUID.randomUUID().toString());
					}

					if (docEntry.getPatientId() != null) {
						organizationalId = docEntry.getPatientId().getAssigningAuthority().getUniversalId();
					}
					// set submission set source id
					if (subSet.getSourceId() == null) {
						subSet.setSourceId(organizationalId);
					}
				}

				// set submission time
				if (subSet.getSubmissionTime() == null) {
					subSet.setSubmissionTime(new Timestamp(DateUtil.nowAsZonedDate(), Precision.SECOND));
				}

				// Use the PatientId of the first Document for the Submission set ID
				if (subSet.getPatientId() == null) {
					subSet.setPatientId(docEntry.getPatientId());
				}

				// set ContentTypeCode
				if (subSet.getContentTypeCode() == null && docEntry.getTypeCode() != null) {
					subSet.setContentTypeCode(docEntry.getTypeCode());

				}
			}
		} else if (txnData.getFolders() != null && !txnData.getFolders().isEmpty()) {
			for (Folder folder : txnData.getFolders()) {
				if (folder.getPatientId() == null) {
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

					if (folder.getPatientId() != null) {
						organizationalId = folder.getPatientId().getAssigningAuthority().getUniversalId();
					}
					// set submission set source id
					if (subSet.getSourceId() == null) {
						subSet.setSourceId(organizationalId);
					}
				}

				// set submission time
				if (subSet.getSubmissionTime() == null) {
					subSet.setSubmissionTime(new Timestamp(DateUtil.nowAsZonedDate(), Precision.SECOND));
				}

				// Use the PatientId of the first Document for the Submission set ID
				if (subSet.getPatientId() == null) {
					subSet.setPatientId(folder.getPatientId());
				}

				if (subSet.getContentTypeCode() == null && folder.getCodeList() != null
						&& folder.getCodeList().get(0) != null) {
					subSet.setContentTypeCode(folder.getCodeList().get(0));
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
			affinityDomain = new AffinityDomain(null, null, new ArrayList<>());
		return affinityDomain;
	}

	/**
	 * Gets the status of the automatic metadata extraction
	 *
	 * @return true, if metadata will be extracted as far as possible)
	 *         automatically, false otherwise
	 */
	public DocumentMetadataExtractionMode getAutomaticExtractionEnabled() {
		return documentMetadataExtractionMode;
	}

	/**
	 * <div class="en">Gets the IPF transaction data (SubmissionSet and
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
	 * @param security       a security header element for example an assertion
	 * 
	 * @return the IPF QueryResponse containing references instead of the complete
	 *         document metadata</div>
	 * @throws Exception
	 */
	public QueryResponse queryDocumentReferencesOnly(AbstractStoredQuery queryParameter,
			SecurityHeaderElement securityHeader) throws Exception {
		return queryDocumentQuery(queryParameter, securityHeader, QueryReturnType.OBJECT_REF);
	}

	/**
	 * <div class="en">Queries the document registry of the affinity domain for
	 * documents, using a find documents query.
	 *
	 * @param queryParameter a findDocumentsQuery object filled with your query
	 *                       parameters
	 * @param security       a security header element for example an assertion
	 * 
	 * @return the IPF QueryResponse containing full document metadata</div>
	 * @throws Exception
	 */
	public QueryResponse queryDocuments(AbstractStoredQuery queryParameter, SecurityHeaderElement securityHeader)
			throws Exception {
		return queryDocumentQuery(queryParameter, securityHeader, QueryReturnType.LEAF_CLASS);
	}

	/**
	 * <div class="en">Queries the registry of the affinity domain for all documents
	 * satisfying the given query parameters.
	 *
	 * @param query      one of the given queries (@see
	 *                   org.ehealth_connector.communication.storedquery and
	 *                   org.ehealth_connector.communication.storedquery.ch)
	 * @param security   a security header element for example an assertion
	 * @param returnType return type for XDS query
	 * 
	 * @return the IPF QueryResponse containing full document metadata</div>
	 * @throws Exception
	 */
	protected QueryResponse queryDocumentQuery(AbstractStoredQuery query, SecurityHeaderElement securityHeader,
			QueryReturnType returnType)
			throws Exception {
		final var queryRegistry = new QueryRegistry(query.getIpfQuery());
		queryRegistry.setReturnType(returnType);

		boolean secure = this.affinityDomain.getRepositoryDestination().getUri().toString().contains("https://");

		final var endpoint = String.format(
				"xds-iti18://%s?inInterceptors=%s&inFaultInterceptors=%s&outInterceptors=%s&outFaultInterceptors=%s&secure=%s&audit=%s&auditContext=%s",
				this.affinityDomain.getRepositoryDestination().getUri().toString().replace("https://", "").replace(
						"http://", ""),
				SERVER_IN_LOGGER, SERVER_IN_LOGGER, SERVER_OUT_LOGGER, SERVER_OUT_LOGGER, secure,
				this.atnaConfigMode.equals(AtnaConfigMode.SECURE), AUDIT_CONTEXT);
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
	 * @param security       a security header element for example an assertion
	 * 
	 * @return the IPF QueryResponse containing full folder metadata </div>
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
	 * @param docReq   the document request
	 * @param security a security header element for example an assertion
	 * 
	 * @return the IPF RetrievedDocumentSet </div>
	 * @throws Exception
	 */
	public RetrievedDocumentSet retrieveDocument(DocumentRequest docReq, SecurityHeaderElement security)
			throws Exception {
		return retrieveDocuments(new DocumentRequest[] { docReq }, security);
	}

	/**
	 * <div class="en">Retrieves multiple documents from one or more Repositories
	 *
	 * @param docReq   an array of document requests
	 * @param security a security header element for example an assertion
	 * 
	 * @return the IPF RetrievedDocumentSet </div>
	 * @throws Exception
	 */
	public RetrievedDocumentSet retrieveDocuments(DocumentRequest[] docReq, SecurityHeaderElement security)
			throws Exception {
		final var retrieveDocumentSet = new RetrieveDocumentSet();

		for (final DocumentRequest element : docReq) {
			if (element != null) {
				retrieveDocumentSet.addReferenceTo(element.getIpfDocumentEntry());
			}
		}

		boolean secure = this.affinityDomain.getRepositoryDestination().getUri().toString().contains("https://");
		final var endpoint = String.format(
				"xds-iti43://%s?inInterceptors=%s&inFaultInterceptors=%s&outInterceptors=%s&outFaultInterceptors=%s&secure=%s&audit=%s&auditContext=%s",
				this.affinityDomain.getRepositoryDestination().getUri().toString().replace("https://", "").replace(
						"http://", ""),
				SERVER_IN_LOGGER, SERVER_IN_LOGGER, SERVER_OUT_LOGGER, SERVER_OUT_LOGGER, secure,
				this.atnaConfigMode.equals(AtnaConfigMode.SECURE), AUDIT_CONTEXT);
		log.info("Sending request to '{}' endpoint", endpoint);

		final var exchange = send(endpoint, retrieveDocumentSet, security, null);

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
	 * Sets the status of the automatic metadata extraction
	 *
	 * @param automaticExtractionEnabled true, if metadata will be extracted as far
	 *                                   as possible) automatically, false otherwise
	 */
	public void setAutomaticExtractionEnabled(SubmissionSetMetadataExtractionMode automaticExtractionEnabled) {
		this.submissionSetMetadataExtractionMode = automaticExtractionEnabled;
	}

	/**
	 * Sets the atna config
	 *
	 * @param atnaConfigMode secure or unsecure config
	 */
	public void setAtnaConfig(AtnaConfigMode atnaConfigMode) {
		this.atnaConfigMode = atnaConfigMode;
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
	}

	/**
	 * <div class="en">Submission of the previously prepared document(s) to the
	 * repository<br>
	 * IHE [ITI-41] Provide and Register Document Set – b in the role of the IHE ITI
	 * Document Source actor
	 *
	 * @param security a security header element for example an assertion
	 *
	 * @return the IPF Response</div>
	 * @throws Exception if the transfer is not successful
	 */
	public Response submit(SecurityHeaderElement security) throws Exception {
		return submit(security, null);
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
	 * @param security              a security header element for example an
	 *                              assertion
	 * @return the IPF Response</div>
	 * @throws Exception if the transfer is not successful
	 */
	public Response submit(SubmissionSetMetadata submissionSetMetadata, SecurityHeaderElement security)
			throws Exception {
		if (txnData.getSubmissionSet() == null) {
			txnData.setSubmissionSet(new SubmissionSet());
		}

		submissionSetMetadata.toOhtSubmissionSetType(txnData.getSubmissionSet());
		return submit(security);
	}

	/**
	 * <div class="en">Submission of the previously prepared document(s) to the
	 * repository to replace another document. The restriction of this method is
	 * that only one document could be replaced<br>
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
	 * @param idOfOriginDocument    ID of the document, which should be replaced
	 * @param security              a security header element for example an
	 *                              assertion
	 * @return the IPF Response</div>
	 * @throws Exception if the transfer is not successful
	 */
	public Response submitReplacement(SubmissionSetMetadata submissionSetMetadata, String idOfOriginDocument,
			SecurityHeaderElement security)
			throws Exception {
		if (txnData.getSubmissionSet() == null) {
			txnData.setSubmissionSet(new SubmissionSet());
		}

		var association = new Association();
		association.setAssociationType(AssociationType.REPLACE);
		association.setAvailabilityStatus(AvailabilityStatus.APPROVED);
		association.setTargetUuid(idOfOriginDocument);
		association.assignEntryUuid();

		txnData.getAssociations().add(association);

		submissionSetMetadata.toOhtSubmissionSetType(txnData.getSubmissionSet());
		return submit(security, association);
	}
	
	/**
	 * <div class="en">Submission of the previously prepared document(s) to the
	 * repository<br>
	 * IHE [ITI-41] Provide and Register Document Set – b in the role of the IHE ITI
	 * Document Source actor
	 *
	 * @param security a security header element for example an assertion
	 *
	 * @return the IPF Response</div>
	 * @throws Exception if the transfer is not successful
	 */
	private Response submit(SecurityHeaderElement security, Association association) throws Exception {
		setDefaultKeystoreTruststore(affinityDomain.getRepositoryDestination());

		if (submissionSetMetadataExtractionMode == SubmissionSetMetadataExtractionMode.DEFAULT_EXTRACTION) {
			txnData.setSubmissionSet(generateDefaultSubmissionSetAttributes());
			linkDocumentEntryWithSubmissionSet();
		}

		if (association != null) {
			if (txnData.getDocuments() != null && !txnData.getDocuments().isEmpty()
					&& txnData.getDocuments().get(0) != null) {
				association.setSourceUuid(txnData.getDocuments().get(0).getDocumentEntry().getEntryUuid());
			} else if (txnData.getFolders() != null && !txnData.getFolders().isEmpty()
					&& txnData.getFolders().get(0) != null) {
				association.setSourceUuid(txnData.getFolders().get(0).getEntryUuid());
			}
		}

		boolean secure = this.affinityDomain.getRepositoryDestination().getUri().toString().contains("https://");
		final var endpoint = String.format(
				"xds-iti41://%s?inInterceptors=%s&inFaultInterceptors=%s&outInterceptors=%s&outFaultInterceptors=%s&secure=%s&audit=%s&auditContext=%s",
				this.affinityDomain.getRepositoryDestination().getUri().toString().replace("https://", "")
						.replace("http://", ""),
				SERVER_IN_LOGGER, SERVER_IN_LOGGER, SERVER_OUT_LOGGER, SERVER_OUT_LOGGER, secure,
				this.atnaConfigMode.equals(AtnaConfigMode.SECURE), AUDIT_CONTEXT);
		log.info("Sending request to '{}' endpoint", endpoint);

		final var exchange = send(endpoint, txnData, security, null);

		return exchange.getMessage().getBody(Response.class);
	}

}
