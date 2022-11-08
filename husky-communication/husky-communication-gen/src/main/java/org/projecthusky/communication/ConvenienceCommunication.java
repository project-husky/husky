/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.projecthusky.communication;

import org.apache.camel.CamelContext;
import org.apache.commons.text.StringEscapeUtils;
import org.openehealth.ipf.commons.core.OidGenerator;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.*;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Timestamp.Precision;
import org.openehealth.ipf.commons.ihe.xds.core.requests.ProvideAndRegisterDocumentSet;
import org.openehealth.ipf.commons.ihe.xds.core.requests.QueryRegistry;
import org.openehealth.ipf.commons.ihe.xds.core.requests.RetrieveDocumentSet;
import org.openehealth.ipf.commons.ihe.xds.core.requests.query.QueryReturnType;
import org.openehealth.ipf.commons.ihe.xds.core.responses.QueryResponse;
import org.openehealth.ipf.commons.ihe.xds.core.responses.Response;
import org.openehealth.ipf.commons.ihe.xds.core.responses.RetrievedDocumentSet;
import org.projecthusky.common.communication.*;
import org.projecthusky.common.communication.AtnaConfig.AtnaConfigMode;
import org.projecthusky.common.communication.DocumentMetadata.DocumentMetadataExtractionMode;
import org.projecthusky.common.communication.SubmissionSetMetadata.SubmissionSetMetadataExtractionMode;
import org.projecthusky.common.enums.DocumentDescriptor;
import org.projecthusky.common.enums.EhcVersions;
import org.projecthusky.common.model.Code;
import org.projecthusky.common.utils.XdsMetadataUtil;
import org.projecthusky.common.utils.xml.XmlFactories;
import org.projecthusky.communication.xd.storedquery.AbstractStoredQuery;
import org.projecthusky.communication.xd.storedquery.FindFoldersStoredQuery;
import org.projecthusky.communication.xd.xdm.IndexHtm;
import org.projecthusky.communication.xd.xdm.ReadmeTxt;
import org.projecthusky.communication.xd.xdm.XdmContents;
import org.projecthusky.xua.core.SecurityHeaderElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.activation.DataHandler;
import javax.mail.util.ByteArrayDataSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.UUID;
import java.util.zip.ZipFile;

/**
 * The ConvenienceCommunication class provides a convenience API for transactions to different destinations such as
 * registries and repositories over media.<br>
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
 */
@Component
public class ConvenienceCommunication extends CamelService {

    private static final String SERVER_IN_LOGGER = "#serverInLogger";
    private static final String SERVER_OUT_LOGGER = "#serverOutLogger";
    private static final String AUDIT_CONTEXT = "#auditContext";
	private static final String HTTPS_LITERAL = "https://";
	private static final String HTTP_LITERAL = "http://";
	private static final String LOG_SEND_REQUEST = "Sending request to '{}' endpoint";

    /**
     * The SLF4J logger instance.
     */
    private static Logger log = LoggerFactory.getLogger(ConvenienceCommunication.class);
    @Autowired
    private CamelContext context;

    /**
     * The affinity domain set-up
     */
    private AffinityDomain affinityDomain = null;

    /**
     * The ATNA config mode (secure or unsecure)
     */
    private AtnaConfig.AtnaConfigMode atnaConfigMode = AtnaConfigMode.UNSECURE;

    /**
     * Determines if XDS document metadata will be extracted automatically (e.g. from CDA documents)
     */
	private DocumentMetadataExtractionMode documentMetadataExtractionMode = DocumentMetadataExtractionMode.DEFAULT_EXTRACTION;

    /**
     * Determines if SubmissionSet metadata will be extracted automatically (e.g. from CDA documents)
     */
    private SubmissionSetMetadataExtractionMode submissionSetMetadataExtractionMode = SubmissionSetMetadataExtractionMode.DEFAULT_EXTRACTION;
    /**
     * The IPF transaction data to send XDS Documents
     */
	private ProvideAndRegisterDocumentSet txnData = null;

    /**
     * Instantiates a new convenience communication without affinity domain set-up. ATNA audit is disabled (unsecure)
     */
    public ConvenienceCommunication() {
        super();
        this.affinityDomain = null;
        this.atnaConfigMode = AtnaConfigMode.UNSECURE;
    }

    /**
     * Instantiates a new convenience communication with the given affinity domain set-up. ATNA audit is disabled
     * (unsecure)
     *
     * @param affinityDomain the affinity domain configuration
     */
    public ConvenienceCommunication(AffinityDomain affinityDomain) {
        this.affinityDomain = affinityDomain;
        this.atnaConfigMode = AtnaConfigMode.UNSECURE;
    }

    /**
     * Instantiates a new convenience communication with the given affinity domain set-up.
     *
     * @param affinityDomain                      the affinity domain configuration
     * @param atnaConfigMode                      the ATNA config mode (secure or unsecure)
     * @param documentMetadataExtractionMode      determines, if and how document metadata should be extracted
     *                                            automatically. Extracted metadata attributes will not overwrite
     *                                            attributes that have been set, manually.
     * @param submissionSetMetadataExtractionMode determines, if and how submission set metadata should be extracted,
     *                                            automatically. Extracted metadata attributes will not overwrite
     *                                            attributes that have been set, manually.
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
     * Adds a document to the XDS Submission set.
     *
     * @param desc        the document descriptor (which kind of document do you want to transfer? e.g. PDF, CDA,...)
     * @param inputStream The input stream to the document
     * @return the document metadata (which have to be completed)
     */
    public DocumentMetadata addDocument(DocumentDescriptor desc, InputStream inputStream) {
        return addDocument(desc, inputStream, null);
    }

    /**
     * Adds a document to the XDS Submission set.
     *
     * @param desc                 the document descriptor (which kind of document do you want to transfer? e.g. PDF,
     *                             CDA,...)
     * @param inputStream          The input stream to the document
     * @param inputStream4Metadata the input stream that is only used to get the metadata from (it's texts will be ascii
     *                             conform for registry purposes)
     * @return the document metadata (which have to be completed)
     */
    public DocumentMetadata addDocument(DocumentDescriptor desc, InputStream inputStream,
                                        InputStream inputStream4Metadata) {
        DocumentMetadata retVal = null;
        var doc = new Document();
		var doc4Metadata = new Document();
		doc4Metadata.setDocumentEntry(new DocumentEntry());

		InputStream unicodeStream = null;
        try {

            if (inputStream4Metadata != null) {
				unicodeStream = convertNonAsciiText2Unicode(inputStream4Metadata);
                var dataSource = new ByteArrayDataSource(unicodeStream, desc.getMimeType());
                doc4Metadata.setDataHandler(new DataHandler(dataSource));
            }

            var dataSource = new ByteArrayDataSource(inputStream, desc.getMimeType());
            doc.setDataHandler(new DataHandler(dataSource));
            retVal = addXdsDocument(doc, desc, doc4Metadata);
        } catch (final IOException e) {
            log.error("Error adding document from inputstream.", e);
            log.error(e.getMessage(), e);
		} finally {
			if (unicodeStream != null) {
				try {
					unicodeStream.close();
				} catch (IOException e) {
					log.error("Error adding document from inputstream.", e);
					log.error(e.getMessage(), e);
				}
			}
        }
        if (retVal != null)
            retVal.setDocumentDescriptor(desc);
        return retVal;
    }

	/**
	 * Escapes all non java character in the inputsream that is expected as XML.
	 *
	 * @param inputStream the input stream to be escaped
	 * @return the input stream
	 */
	protected InputStream convertNonAsciiText2Unicode(InputStream inputStream) {
		InputStream retVal = null;
		DocumentBuilder docBuilder;
		try (var outputStream = new ByteArrayOutputStream()) {
			docBuilder = XmlFactories.newSafeDocumentBuilder();
			var document = docBuilder.parse(inputStream);
			convertNonAsciiText2Unicode(document.getDocumentElement());
			Source xmlSource = new DOMSource(document);
			Result outputTarget = new StreamResult(outputStream);

			var transformer = XmlFactories.newTransformer();
			transformer.transform(xmlSource, outputTarget);
			retVal = new ByteArrayInputStream(outputStream.toByteArray());
		} catch (ParserConfigurationException | SAXException | IOException | TransformerException
				| TransformerFactoryConfigurationError e) {
			// Do nothing
		}
		return retVal;
	}

	/**
	 * Escapes all non java character in the node text.
	 *
	 * @param node the node to be escaped
	 */
	protected void convertNonAsciiText2Unicode(Node node) {
		if (node.getFirstChild() != null) {
			String nodeValue = node.getFirstChild().getNodeValue();
			if (nodeValue != null) {
				nodeValue = nodeValue.replace("\n", "").replace("\t", "");
				node.getFirstChild().setNodeValue(StringEscapeUtils.escapeJava(nodeValue));
			}
		}
		var nodeList = node.getChildNodes();
		for (var i = 0; i < nodeList.getLength(); i++) {
			var currentNode = nodeList.item(i);
			if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
				// calls this method for all the children which is Element
				convertNonAsciiText2Unicode(currentNode);
			}
		}
	}

    /**
	 * Adds a document to the XDS Submission set.
	 *
	 * @param desc     the document descriptor (which kind of document do you want
	 *                 to transfer? e.g. PDF, CDA,...)
	 * @param filePath the file path
	 * @return the document metadata (which have to be completed)
	 * @throws IOException
	 */
	public DocumentMetadata addDocument(DocumentDescriptor desc, String filePath) throws IOException {
        return addDocument(desc, filePath, null);
    }

    /**
	 * Adds a document to the XDS Submission set.
	 *
	 * @param desc             the document descriptor (which kind of document do
	 *                         you want to transfer? e.g. PDF, CDA,...)
	 * @param filePath         the file path
	 * @param filePathMetadata the file path metadata
	 * @return the document metadata (which have to be completed)
	 * @throws IOException
	 */
    public DocumentMetadata addDocument(DocumentDescriptor desc, String filePath, String filePathMetadata)
			throws IOException {
		try (InputStream is = new FileInputStream(new File(filePath))) {
			return addDocument(desc, is);
		}
    }

    /**
     * Add a document to a folder by theirs ids
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
     * Adds a xds folder.
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
			folder.assignUniqueId();
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
     * Adds an XDSDocument to the Transaction data
     *
     * @param doc  the document
     * @param desc the Document descriptor
     * @return the DocumentMetadata
     */
    protected DocumentMetadata addXdsDocument(Document doc, DocumentDescriptor desc) {
        return addXdsDocument(doc, desc, null);
    }

    /**
     * Adds an XDSDocument to the Transaction data.
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
     * Cda fixes of CDAExtraction bugs and extraction methods, which are unsafe, because an XDS registry might use
     * another value set.
     *
     * @param docMetadata the doc metadata
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
			docMetadata.setUniqueId(OidGenerator.uniqueOid().toString());
        }

    }

    /**
     * Resets the transaction data (SubmissionSet and DocumentMetadata)
     */
    public void clearDocuments() {
        txnData = new ProvideAndRegisterDocumentSet();
    }

    /**
     * creates an XDM volume with default values. You have to add a document to this class first.
     *
     * @param outputStream The outputStream object where the contents will be written to.
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
     * creates an XDM volume with a given XdmContents object. This method will be used, if you want to create your own
     * INDEX.HTM and README.TXT for your XDM volume. You have to add a document to this class first.
     *
     * @param outputStream The outputStream object where the contents will be written to.
     * @param xdmContents  The xdmContents object containing your own INDEX.HTM and README.TXT
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
     * creates an XDM volume with default values. You have to add a document to this class first.
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
     * creates an XDM volume with default values. You have to add a document to this class first.
     *
     * @param filePath    The filePath where the contents will be written to.
     * @param xdmContents The xdmContents object containing your own INDEX.HTM and README.TXT
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
     * creates an XDM volume with the given submission set metadata. You have to add a document to this class first.
     *
     * @param submissionSetMetadata The metadata of the submission set
     * @param outputStream          The outputStream object where the contents will be written to.
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
     * Generate missing doc entry attributes.
     *
     * @param docMetadata
     * @param document
     * @param documentDescriptor
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
        }

        // Generate the UUID
        if (docMetadata.getDocumentEntry().getEntryUuid() == null) {
            document.getDocumentEntry().assignEntryUuid();
            docMetadata.setEntryUUID(document.getDocumentEntry().getEntryUuid());
        }

        // Generate Creation Time with the current time
        if (docMetadata.getDocumentEntry().getCreationTime() == null) {
            docMetadata.setCreationTime(ZonedDateTime.now());

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
     * Generate missing Submission Set attributes.
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
			setSubSetDetailsFromDocument(subSet);
        } else if (txnData.getFolders() != null && !txnData.getFolders().isEmpty()) {
			setSubSetDetailsFromFolder(subSet);
        }
        return subSet;
    }

	private void setSubSetDetailsFromDocument(SubmissionSet subSet) {
		log.info("count of documents {}", txnData.getDocuments().size());
		for (Document document : txnData.getDocuments()) {
			final var docEntry = document.getDocumentEntry();
			
			if (docEntry.getPatientId() == null) {
				log.warn("Missing destination patient ID in DocumentMetadata of document.");
			}

			// set ContentTypeCode
			if (subSet.getContentTypeCode() == null && docEntry.getTypeCode() != null) {
				subSet.setContentTypeCode(docEntry.getTypeCode());
			}

			setGeneralSubSetDetails(subSet, docEntry.getPatientId());
		}
	}

	private void setSubSetDetailsFromFolder(SubmissionSet subSet) {
		for (Folder folder : txnData.getFolders()) {
			if (folder.getPatientId() == null) {
				throw new IllegalStateException(
						"Missing destination patient ID in DocumentMetadata of first document.");
			}

			if (subSet.getContentTypeCode() == null && folder.getCodeList() != null
					&& folder.getCodeList().get(0) != null) {
				subSet.setContentTypeCode(folder.getCodeList().get(0));
			}

			setGeneralSubSetDetails(subSet, folder.getPatientId());
		}
	}

	protected void setGeneralSubSetDetails(SubmissionSet subSet, Identifiable patientId) {
		// set submission time
		if (subSet.getSubmissionTime() == null) {
			subSet.setSubmissionTime(new Timestamp(ZonedDateTime.now(), Precision.SECOND));
		}

		if (subSet.getEntryUuid() == null) {
			subSet.setEntryUuid(UUID.randomUUID().toString());
		}

		if ((subSet.getUniqueId() == null) || (subSet.getSourceId() == null)) {

			if (subSet.getUniqueId() == null) {
				subSet.assignUniqueId();
			}

			// set submission set source id
			if (subSet.getSourceId() == null) {
				subSet.setSourceId(getSourceId(patientId));
			}
		}

		// Use the PatientId of the first Document for the Submission set ID
		if (subSet.getPatientId() == null) {
			subSet.setPatientId(patientId);
		}
	}

	protected String getSourceId(Identifiable patientId) {
		if (patientId != null) {
			return patientId.getAssigningAuthority().getUniversalId();
		} else {
			return EhcVersions.getCurrentVersion().getOid();
		}
	}


    /**
     * Returns the current affinity domain
     *
     * @return the affinity domain
     */
    public AffinityDomain getAffinityDomain() {
        if (affinityDomain == null)
            affinityDomain = new AffinityDomain(null, null, new ArrayList<>());
        return affinityDomain;
    }

    /**
     * Sets the affinity domain set-up
     *
     * @param affinityDomain the affinity domain set-up
     */
    public void setAffinityDomain(AffinityDomain affinityDomain) {
        this.affinityDomain = affinityDomain;
    }

    /**
     * Gets the status of the automatic metadata extraction
     *
     * @return true, if metadata will be extracted as far as possible) automatically, false otherwise
     */
    public DocumentMetadataExtractionMode getAutomaticExtractionEnabled() {
        return documentMetadataExtractionMode;
    }

    /**
     * Sets the status of the automatic metadata extraction
     *
     * @param automaticExtractionEnabled true, if metadata will be extracted as far as possible) automatically, false
     *                                   otherwise
     */
    public void setAutomaticExtractionEnabled(DocumentMetadataExtractionMode automaticExtractionEnabled) {
        this.documentMetadataExtractionMode = automaticExtractionEnabled;
    }

    /**
     * Sets the status of the automatic metadata extraction
     *
     * @param automaticExtractionEnabled true, if metadata will be extracted as far as possible) automatically, false
     *                                   otherwise
     */
    public void setAutomaticExtractionEnabled(SubmissionSetMetadataExtractionMode automaticExtractionEnabled) {
        this.submissionSetMetadataExtractionMode = automaticExtractionEnabled;
    }

    /**
     * Gets the IPF transaction data (SubmissionSet and DocumentMetadata)
     *
     * @return the transaction data object
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
     * Queries the document registry of the affinity domain for documents, using a find documents query. This is useful
     * if the number of results is limited in the registry and your query would exceed this limit. In this case, precise
     * your query or do a query for references first, choose the possible matches (e.g. the last 10 results) and then
     * query for metadata.
     *
     * @param queryParameter a findDocumentsQuery object filled with your query parameters
     * @param securityHeader a security header element for example an assertion
     * @return the IPF QueryResponse containing references instead of the complete document metadata
     * @throws Exception
     */
    public QueryResponse queryDocumentReferencesOnly(AbstractStoredQuery queryParameter,
			SecurityHeaderElement securityHeader, String messageId) throws Exception {
		return queryDocumentQuery(queryParameter, securityHeader, QueryReturnType.OBJECT_REF, messageId);
    }

    /**
     * Queries the document registry of the affinity domain for documents, using a find documents query.
     *
     * @param queryParameter a findDocumentsQuery object filled with your query parameters
     * @param securityHeader a security header element for example an assertion
     * @return the IPF QueryResponse containing full document metadata
     * @throws Exception
     */
	public QueryResponse queryDocuments(AbstractStoredQuery queryParameter, SecurityHeaderElement securityHeader,
			String messageId)
            throws Exception {
		return queryDocumentQuery(queryParameter, securityHeader, QueryReturnType.LEAF_CLASS, messageId);
    }

    /**
     * Queries the registry of the affinity domain for all documents satisfying the given query parameters.
     *
     * @param query          one of the given queries (@see org.projecthusky.communication.storedquery and
     *                       org.projecthusky.communication.storedquery.ch)
     * @param securityHeader a security header element for example an assertion
     * @param returnType     return type for XDS query
     * @return the IPF QueryResponse containing full document metadata
     * @throws Exception
     */
    protected QueryResponse queryDocumentQuery(AbstractStoredQuery query, SecurityHeaderElement securityHeader,
			QueryReturnType returnType, String messageId)
            throws Exception {
        final var queryRegistry = new QueryRegistry(query.getIpfQuery());
        queryRegistry.setReturnType(returnType);

		boolean secure = this.affinityDomain.getRepositoryDestination().getUri().toString().contains(HTTPS_LITERAL);

        final var endpoint = String.format(
                "xds-iti18://%s?inInterceptors=%s&inFaultInterceptors=%s&outInterceptors=%s&outFaultInterceptors=%s&secure=%s&audit=%s&auditContext=%s",
				this.affinityDomain.getRepositoryDestination().getUri().toString().replace(HTTPS_LITERAL, "")
						.replace(HTTP_LITERAL, ""),
                SERVER_IN_LOGGER, SERVER_IN_LOGGER, SERVER_OUT_LOGGER, SERVER_OUT_LOGGER, secure,
                this.atnaConfigMode.equals(AtnaConfigMode.SECURE), AUDIT_CONTEXT);
        log.info(LOG_SEND_REQUEST, endpoint);

		final var exchange = send(endpoint, queryRegistry, securityHeader, messageId, null);

        return exchange.getMessage().getBody(QueryResponse.class);
    }

    /**
     * Queries the document registry of the affinity domain for documents, using a find documents query.
     *
     * @param queryParameter a findFoldersQuery object filled with your query parameters
     * @param security       a security header element for example an assertion
     * @return the IPF QueryResponse containing full folder metadata
     * @throws Exception
     */
	public QueryResponse queryFolders(FindFoldersStoredQuery queryParameter, SecurityHeaderElement security,
			String messageId)
            throws Exception {
		return queryDocumentQuery(queryParameter, security, QueryReturnType.LEAF_CLASS, messageId);
    }

    /**
     * Retrieves a document from a Repository
     *
     * @param docReq   the document request
     * @param security a security header element for example an assertion
     * @return the IPF RetrievedDocumentSet
     * @throws Exception
     */
	public RetrievedDocumentSet retrieveDocument(DocumentRequest docReq, SecurityHeaderElement security,
			String messageId)
            throws Exception {
		return retrieveDocuments(new DocumentRequest[] { docReq }, security, messageId);
    }

    /**
     * Retrieves multiple documents from one or more Repositories
     *
     * @param docReq   an array of document requests
     * @param security a security header element for example an assertion
     * @return the IPF RetrievedDocumentSet
     * @throws Exception
     */
	public RetrievedDocumentSet retrieveDocuments(DocumentRequest[] docReq, SecurityHeaderElement security,
			String messageId)
            throws Exception {
        final var retrieveDocumentSet = new RetrieveDocumentSet();

        for (final DocumentRequest element : docReq) {
            if (element != null) {
                retrieveDocumentSet.addReferenceTo(element.getIpfDocumentEntry());
            }
        }

		boolean secure = this.affinityDomain.getRepositoryDestination().getUri().toString().contains(HTTPS_LITERAL);
        final var endpoint = String.format(
                "xds-iti43://%s?inInterceptors=%s&inFaultInterceptors=%s&outInterceptors=%s&outFaultInterceptors=%s&secure=%s&audit=%s&auditContext=%s",
				this.affinityDomain.getRepositoryDestination().getUri().toString().replace(HTTPS_LITERAL, "")
						.replace(HTTP_LITERAL, ""),
                SERVER_IN_LOGGER, SERVER_IN_LOGGER, SERVER_OUT_LOGGER, SERVER_OUT_LOGGER, secure,
                this.atnaConfigMode.equals(AtnaConfigMode.SECURE), AUDIT_CONTEXT);
        log.info(LOG_SEND_REQUEST, endpoint);

		final var exchange = send(endpoint, retrieveDocumentSet, security, messageId, null);

        return exchange.getMessage().getBody(RetrievedDocumentSet.class);
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
            System.clearProperty("javax.net.ssl.keyStoreType");
            System.clearProperty("javax.net.ssl.trustStore");
            System.clearProperty("javax.net.ssl.trustStorePassword");
            System.clearProperty("javax.net.ssl.trustStoreType");
        } else {
            System.setProperty("javax.net.ssl.keyStore", dest.getKeyStore());
            System.setProperty("javax.net.ssl.keyStorePassword", dest.getKeyStorePassword());
            System.setProperty("javax.net.ssl.keyStoreType",  dest.getKeyStoreType());
            System.setProperty("javax.net.ssl.trustStore", dest.getTrustStore());
            System.setProperty("javax.net.ssl.trustStorePassword", dest.getTrustStorePassword());
            System.setProperty("javax.net.ssl.trustStoreType", dest.getTrustStoreType());
        }
    }

    /**
     * Submission of the previously prepared document(s) to the repository<br> IHE [ITI-41] Provide and Register
     * Document Set – b in the role of the IHE ITI Document Source actor
     *
     * @param security a security header element for example an assertion
     * @return the IPF Response
     * @throws Exception if the transfer is not successful
     */
	public Response submit(SecurityHeaderElement security, String messageId) throws Exception {
		return submit(security, null, messageId);
    }

    /**
     * Submission of the previously prepared document(s) to the repository<br> IHE [ITI-41] Provide and Register
     * Document Set – b in the role of the IHE ITI Document Source actor
     *
     * @param submissionSetMetadata The information in this object will be used to create comprehensive meta data about
     *                              this submission (e.g. with AuthorRole, AuthorInstitution, ContentType and Title).
     *                              Although, some of this information can be derived automatically, some may be
     *                              required in your country (e.g. AuthorRole in Switzerland)
     * @param security              a security header element for example an assertion
     * @return the IPF Response
     * @throws Exception if the transfer is not successful
     */
	public Response submit(SubmissionSetMetadata submissionSetMetadata, SecurityHeaderElement security,
			String messageId)
            throws Exception {
        if (txnData.getSubmissionSet() == null) {
            txnData.setSubmissionSet(new SubmissionSet());
        }

        submissionSetMetadata.toOhtSubmissionSetType(txnData.getSubmissionSet());
		return submit(security, messageId);
    }

    /**
     * Submission of the previously prepared document(s) to the repository to replace another document. The restriction
     * of this method is that only one document could be replaced<br> IHE [ITI-41] Provide and Register Document Set – b
     * in the role of the IHE ITI Document Source actor
     *
     * @param submissionSetMetadata The information in this object will be used to create comprehensive meta data about
     *                              this submission (e.g. with AuthorRole, AuthorInstitution, ContentType and Title).
     *                              Although, some of this information can be derived automatically, some may be
     *                              required in your country (e.g. AuthorRole in Switzerland)
     * @param idOfOriginDocument    ID of the document, which should be replaced
     * @param security              a security header element for example an assertion
     * @return the IPF Response
     * @throws Exception if the transfer is not successful
     */
    public Response submitReplacement(SubmissionSetMetadata submissionSetMetadata, String idOfOriginDocument,
			SecurityHeaderElement security, String messageId)
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
		return submit(security, association, messageId);
    }

    /**
     * Submission of the previously prepared document(s) to the repository<br> IHE [ITI-41] Provide and Register
     * Document Set – b in the role of the IHE ITI Document Source actor
     *
     * @param security a security header element for example an assertion
     * @return the IPF Response
     * @throws Exception if the transfer is not successful
     */
	private Response submit(SecurityHeaderElement security, Association association, String messageId)
			throws Exception {
		log.debug("submit document");
		setDefaultKeystoreTruststore(affinityDomain.getRepositoryDestination());

        if (submissionSetMetadataExtractionMode == SubmissionSetMetadataExtractionMode.DEFAULT_EXTRACTION) {
			log.debug("extract submission set metadata");
            txnData.setSubmissionSet(generateDefaultSubmissionSetAttributes());
            linkDocumentEntryWithSubmissionSet();
        }

        if (association != null) {
			log.debug("set association data");
            if (txnData.getDocuments() != null && !txnData.getDocuments().isEmpty()
                    && txnData.getDocuments().get(0) != null) {
                association.setSourceUuid(txnData.getDocuments().get(0).getDocumentEntry().getEntryUuid());
            } else if (txnData.getFolders() != null && !txnData.getFolders().isEmpty()
                    && txnData.getFolders().get(0) != null) {
                association.setSourceUuid(txnData.getFolders().get(0).getEntryUuid());
            }
        }

		log.debug("prepare submit of document");
		boolean secure = this.affinityDomain.getRepositoryDestination().getUri().toString().contains(HTTPS_LITERAL);
		final var endpoint = String.format(
				"xds-iti41://%s?inInterceptors=%s&inFaultInterceptors=%s&outInterceptors=%s&outFaultInterceptors=%s&secure=%s&audit=%s&auditContext=%s",
				this.affinityDomain.getRepositoryDestination().getUri().toString().replace(HTTPS_LITERAL, "")
						.replace(HTTP_LITERAL, ""),
                SERVER_IN_LOGGER, SERVER_IN_LOGGER, SERVER_OUT_LOGGER, SERVER_OUT_LOGGER, secure,
				this.atnaConfigMode.equals(AtnaConfigMode.SECURE), AUDIT_CONTEXT);
		log.debug(LOG_SEND_REQUEST, endpoint);

		final var exchange = send(endpoint, txnData, security, messageId, null);

        return exchange.getMessage().getBody(Response.class);
    }

}
