/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.communication.at;

import java.io.IOException;
import java.io.InputStream;
import java.time.ZonedDateTime;
import java.util.Iterator;
import java.util.UUID;

import javax.activation.DataHandler;
import javax.mail.util.ByteArrayDataSource;

import org.apache.camel.CamelContext;
import org.husky.common.at.AuthorAt;
import org.husky.common.at.enums.ConfidentialityCode;
import org.husky.common.communication.AffinityDomain;
import org.husky.common.communication.AtnaConfig.AtnaConfigMode;
import org.husky.common.communication.DocumentMetadata.DocumentMetadataExtractionMode;
import org.husky.common.communication.SubmissionSetMetadata.SubmissionSetMetadataExtractionMode;
import org.husky.common.enums.DocumentDescriptor;
import org.husky.common.hl7cdar2.POCDMT000040ClinicalDocument;
import org.husky.common.model.Author;
import org.husky.common.model.Code;
import org.husky.common.model.Identificator;
import org.husky.common.utils.XdsMetadataUtil;
import org.husky.communication.ConvenienceCommunication;
import org.husky.communication.exceptions.DocumentNotAccessibleException;
import org.husky.communication.xd.storedquery.FindDocumentsQuery;
import org.husky.xua.core.SecurityHeaderElement;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AvailabilityStatus;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Document;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Identifiable;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Organization;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.SubmissionSet;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Timestamp;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Timestamp.Precision;
import org.openehealth.ipf.commons.ihe.xds.core.responses.QueryResponse;
import org.openehealth.ipf.commons.ihe.xds.core.responses.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * Implementation of ch specific convenience communication
 *
 */
public class ConvenienceCommunicationAt extends ConvenienceCommunication {

	/** The SLF4J logger instance. */
	private static Logger log = LoggerFactory.getLogger(ConvenienceCommunicationAt.class);

	@Autowired
	private CamelContext context;

	private String lastError = "";

	/**
	 * <div class="en">The affinity domain set-up</div>
	 */
	private AffinityDomain affinityDomain = null;

	/**
	 * Default constructor to instanciate the object
	 */
	public ConvenienceCommunicationAt() {
		super(null);
	}

	/**
	 * Default constructor to instanciate the object
	 *
	 * @param affinityDomain the affinity Domain
	 */
	public ConvenienceCommunicationAt(AffinityDomain affinityDomain) {
		super(affinityDomain);
		this.affinityDomain = affinityDomain;
	}

	/**
	 * Instantiates a new convenience communication at.
	 *
	 * @param affinityDomain                      the affinity domain
	 * @param atnaConfigMode                      the atna config mode
	 * @param documentMetadataExtractionMode      the document metadata extraction
	 *                                            mode
	 * @param submissionSetMetadataExtractionMode the submission set metadata
	 *                                            extraction mode
	 * @param srcPath                             path for the axis2 config file
	 */
	public ConvenienceCommunicationAt(AffinityDomain affinityDomain, AtnaConfigMode atnaConfigMode,
			org.husky.common.communication.DocumentMetadata.DocumentMetadataExtractionMode documentMetadataExtractionMode,
			SubmissionSetMetadataExtractionMode submissionSetMetadataExtractionMode) {
		super(affinityDomain, atnaConfigMode, documentMetadataExtractionMode, submissionSetMetadataExtractionMode);
		this.affinityDomain = affinityDomain;
	}

	public DocumentMetadataAt addElgaDocument(DocumentDescriptor desc, InputStream inputStream,
			POCDMT000040ClinicalDocument cda, boolean urnOidNeeded, boolean orgUrnOidNeeded) {
		DocumentMetadataAt metadata = null;
		if (inputStream == null)
			try {
				throw new DocumentNotAccessibleException();
			} catch (final DocumentNotAccessibleException e) {
				log.error(e.getMessage());
			}

		clearDocuments();

		Document doc;
		try {
			if (cda != null) {
				metadata = new DocumentMetadataAt(cda, urnOidNeeded, orgUrnOidNeeded);
			}
			doc = new Document();
			var dataSource = new ByteArrayDataSource(inputStream, desc.getMimeType());
			doc.setDataHandler(new DataHandler(dataSource));

			metadata = addXdsDocument(doc, desc, metadata);
			log.debug("document entry uuid: {}, document unique id: {}", doc.getDocumentEntry().getEntryUuid(),
					doc.getDocumentEntry().getUniqueId());

		} catch (final IOException e) {
			log.error(e.getMessage());
		}

		return metadata;
	}

	/**
	 * <div class="en">Adds an XDSDocument to the Transaction data</div>.
	 *
	 * @param doc         the document
	 * @param desc        the Document descriptor
	 * @param metadataDoc the metadata doc
	 * @return the doc to get the metadata from
	 */
	protected DocumentMetadataAt addXdsDocument(Document doc, DocumentDescriptor desc, DocumentMetadataAt metadata) {
		clearDocuments();

		DocumentMetadataAt docMetadata = null;

		if (metadata != null) {
			docMetadata = new DocumentMetadataAt(metadata.getDocumentEntry(), metadata.getCda(),
					metadata.getPatientIdsHl7Cdar2());
			if (doc.getDocumentEntry() == null) {
				doc.setDocumentEntry(metadata.getDocumentEntry());
			}
		} else {
			log.warn("Document entry is null. No metadata known");
		}

		getTxnData().getDocuments().add(doc);

		if (docMetadata != null) {
			if (documentMetadataExtractionMode == DocumentMetadataExtractionMode.DEFAULT_EXTRACTION) {
				if (DocumentDescriptor.CDA_R2.equals(desc)) {
					fixDocEntryAttributes(doc, docMetadata, desc);
				}
				generateDefaultSubmissionSetAttributes();
			} else {
				docMetadata.clear();
			}
		}


		return docMetadata;
	}

	private void fixDocEntryAttributes(Document targetDoc, DocumentMetadataAt metadata, DocumentDescriptor desc) {
		if (targetDoc == null) {
			return;
		}

		final DocumentMetadataAt docMetadata = new DocumentMetadataAt(targetDoc.getDocumentEntry(), metadata.getCda(),
				metadata.getPatientIdsHl7Cdar2());

		// Derive MimeType from DocumentDescriptor
		if (docMetadata.getDocumentEntry().getMimeType() == null) {
			docMetadata.setMimeType(desc.getMimeType());
		}

		// Generate the UUID
		if (docMetadata.getDocumentEntry().getUniqueId() == null) {
			docMetadata.getDocumentEntry().assignUniqueId();
		}

		// Generate Creation Time with the current time
		if (docMetadata.getDocumentEntry().getCreationTime() == null) {
			docMetadata.setCreationTime(ZonedDateTime.now());
		}

		// Generate confidentiality code
		if (docMetadata.getDocumentEntry().getConfidentialityCodes().isEmpty()) {
			docMetadata.addConfidentialityCodeHl7Cdar2(ConfidentialityCode.NORMAL);
			log.debug("confidentiality code: {}", docMetadata.getDocumentEntry().getConfidentialityCodes().get(0));
		}

		// Generate event code
		if (!docMetadata.getDocumentEntry().getEventCodeList().isEmpty()) {
			log.debug("event codes: {}", docMetadata.getDocumentEntry().getEventCodeList().get(0));
		}

		// Generate Creation Time with the current time
		if (docMetadata.getDocumentEntry().getClassCode() != null) {
			log.debug("class codes: {}", docMetadata.getDocumentEntry().getClassCode().getDisplayName());
		}

		if (docMetadata.getDocumentEntry().getUniqueId() != null) {
			log.debug("unique id: {}", docMetadata.getDocumentEntry().getUniqueId());
		}

	}

	/**
	 * <div class="en">Generate missing Submission Set attributes</div>.
	 *
	 * @return the submission set
	 */

	public void generateSubmissionSetMetadata(Author author, Code contentTypeCode) {

		if (getTxnData().getSubmissionSet() == null) {
			getTxnData().setSubmissionSet(new SubmissionSet());
		}

		// Create SubmissionSet
		final var subSet = getTxnData().getSubmissionSet();

		if (getTxnData().getDocuments() != null && !getTxnData().getDocuments().isEmpty()) {
			setSubSetDetailsForDocuments(subSet, author, contentTypeCode);
		}
	}

	private void setSubSetDetailsForDocuments(SubmissionSet subSet, Author author, Code contentTypeCode) {
		log.info("count of documents {}", getTxnData().getDocuments().size());
		for (Document document : getTxnData().getDocuments()) {
			final var docEntry = document.getDocumentEntry();
			if (docEntry.getPatientId() == null) {
				throw new IllegalStateException(
						"Missing destination patient ID in DocumentMetadata of first document.");
			}

			// set ContentTypeCode
			if (contentTypeCode != null) {
				subSet.setContentTypeCode(XdsMetadataUtil.convertEhcCodeToCode(contentTypeCode));
			}

			if (subSet.getContentTypeCode() == null && docEntry.getTypeCode() != null) {
				subSet.setContentTypeCode(docEntry.getTypeCode());
			}

			setGeneralSubSetDetails(subSet, docEntry.getPatientId(), docEntry.getSourcePatientId());

			if (subSet.getAuthors().isEmpty()) {
				subSet.getAuthors().add(AuthorAt.getIpfAuthor(author));
			}

			if (subSet.getAuthors() != null && !subSet.getAuthors().isEmpty()) {
				for (org.openehealth.ipf.commons.ihe.xds.core.metadata.Author ipfAuthor : subSet.getAuthors()) {
					if (ipfAuthor != null && ipfAuthor.getAuthorInstitution() != null) {
						Iterator<Organization> authorIterator = ipfAuthor.getAuthorInstitution().iterator();
						while (authorIterator.hasNext()) {
							var authorXon = authorIterator.next();
							if (authorXon != null && authorXon.getAssigningAuthority() != null
									&& authorXon.getAssigningAuthority().getUniversalId() != null
									&& authorXon.getIdNumber() == null) {
								authorXon.setIdNumber(authorXon.getAssigningAuthority().getUniversalId());
								authorXon.setAssigningAuthority(null);
							}
						}
					}

					if (ipfAuthor.getAuthorRole() != null && !ipfAuthor.getAuthorRole().isEmpty()
							&& ipfAuthor.getAuthorRole().get(0) == null) {
						ipfAuthor.getAuthorRole().clear();
					}

					if (ipfAuthor.getAuthorPerson() != null) {
						var authorPerson = ipfAuthor.getAuthorPerson();
						if (authorPerson != null && authorPerson.getId() != null
								&& authorPerson.getId().getAssigningAuthority() != null
								&& authorPerson.getId().getAssigningAuthority().getUniversalId() != null
								&& authorPerson.getId().getId() == null) {
							authorPerson.getId().setId(authorPerson.getId().getAssigningAuthority().getUniversalId());
							authorPerson.getId().setAssigningAuthority(null);
						}
					}
				}

			}
		}
	}

	protected void setGeneralSubSetDetails(SubmissionSet subSet, Identifiable patientId, Identifiable sourcePatientId) {
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
				subSet.setSourceId(getSourceId(sourcePatientId));
			}
		}

		// Use the PatientId of the first Document for the Submission set ID
		if (subSet.getPatientId() == null) {
			subSet.setPatientId(patientId);
		}
	}

	/**
	 * Queries the registry of the affinity domain for all documents of one patient.
	 * This is useful if the number of results is limited in the registry and your
	 * query would exceed this limit. In this case, precise your query or do a query
	 * for references first, choose the possible matches (e.g. the last 10 results)
	 * and then query for metadata.
	 *
	 * @param patientId the ID of the patient
	 * @param assertion which should be used for request
	 * @return the IPF QueryResponse containing references instead of the complete
	 *         document metadata
	 * @throws Exception
	 */
	public QueryResponse queryDocumentReferencesOnly(Identificator patientId, SecurityHeaderElement assertion)
			throws Exception {
		return this.queryDocumentReferencesOnly(new FindDocumentsQuery(patientId, AvailabilityStatus.APPROVED),
				assertion);
	}

	/**
	 * <div class="en">Queries the registry of the affinity domain for all documents
	 * of one patient.
	 *
	 * @param patientId the ID of the patient
	 * @param assertion which should be used for request
	 * @return the IPF QueryResponse containing full document metadata</div>
	 * @throws Exception
	 */
	public QueryResponse queryDocuments(Identificator patientId, SecurityHeaderElement assertion) throws Exception {
		return this.queryDocuments(new FindDocumentsQuery(patientId, AvailabilityStatus.APPROVED), assertion);
	}

	/**
	 * <div class="en">Submission of the previously prepared document(s) to the
	 * repository<br>
	 * IHE [ITI-41] Provide and Register Document Set – b in the role of the IHE ITI
	 * Document Source actor
	 *
	 * @param authorRole The AuthorRole is one of the minimal required information
	 *                   according to IHE Suisse for classification of documents in
	 *                   Switzerland.
	 * @param security   assertion which should be used for request
	 * @return the OHT XDSResponseType</div>
	 * @throws Exception if the transfer is not successful
	 */
	public Response submit(boolean replace, Author author, Code codeContentType,
			SecurityHeaderElement security) throws Exception {
		generateSubmissionSetMetadata(author, codeContentType);
		return submit(security);
	}

	/**
	 * <div class="en">Submission of the previously prepared document(s) to the
	 * repository<br>
	 * IHE [ITI-41] Provide and Register Document Set – b in the role of the IHE ITI
	 * Document Source actor
	 *
	 * @param authorRole The AuthorRole is one of the minimal required information
	 *                   according to IHE Suisse for classification of documents in
	 *                   Switzerland.
	 * @param security   assertion which should be used for request
	 * @return the OHT XDSResponseType</div>
	 * @throws Exception if the transfer is not successful
	 */
	/*
	 * public Response submit(boolean replace, AuthorAt author, String
	 * organizationId, CodedMetadataType codeContentType, SecurityHeaderElement
	 * security) throws Exception { generateSubmissionSetMetadata(author,
	 * organizationId, codeContentType);
	 * 
	 * if (affinityDomain.getRepositoryDestination().getKeyStore() == null) {
	 * System.clearProperty("javax.net.ssl.keyStore");
	 * System.clearProperty("javax.net.ssl.keyStorePassword");
	 * System.clearProperty("javax.net.ssl.trustStore");
	 * System.clearProperty("javax.net.ssl.trustStorePassword"); } else {
	 * System.setProperty("javax.net.ssl.keyStore",
	 * affinityDomain.getRepositoryDestination().getKeyStore());
	 * System.setProperty("javax.net.ssl.keyStorePassword",
	 * affinityDomain.getRepositoryDestination().getKeyStorePassword());
	 * System.setProperty("javax.net.ssl.trustStore",
	 * affinityDomain.getRepositoryDestination().getTrustStore());
	 * System.setProperty("javax.net.ssl.trustStorePassword",
	 * affinityDomain.getRepositoryDestination().getTrustStorePassword()); }
	 * 
	 * B_Source source = new
	 * B_Source(affinityDomain.getRepositoryDestination().getUri(), this.context);
	 * 
	 * if (source.getRepositoryURI() == null) { throw new
	 * SourceException(SourceException.XDS_REPOSITORY_UNDEFINED,
	 * "Repository URI is null."); }
	 * 
	 * SourceAuditUtils.auditActorStart(source);
	 * 
	 * XDSResponseType responseObject = null;
	 * ProvideAndRegisterDocumentSetBMetadataHandler metadataHandler = new
	 * ProvideAndRegisterDocumentSetBMetadataHandler(); Element submitObjectsRequest
	 * = metadataHandler.processRequest(getTxnData());
	 * 
	 * NodeList children =
	 * submitObjectsRequest.getChildNodes().item(0).getChildNodes().item(0).
	 * getChildNodes();
	 * 
	 * Node classificationChildNew = null; Node registryPackageChildNew = null; Node
	 * classificationChildOld = null; Node registryPackageChildOld = null; Node
	 * extrinsicObjectChildNew = null; Node extrinsicObjectChildOld = null; Node
	 * associationRplcChildNew = null; Node associationRplcChildOld = null; Node
	 * associationHasMemberChildNew = null; Node associationHasMemberChildOld =
	 * null;
	 * 
	 * List<Node> nodesToDelete = new ArrayList<>();
	 * 
	 * for (int i = 0; i < children.getLength(); i++) { if
	 * (children.item(i).getNodeName().contains("ExtrinsicObject")) {
	 * extrinsicObjectChildNew = children.item(i).cloneNode(true);
	 * extrinsicObjectChildOld = children.item(i); } else if
	 * (children.item(i).getNodeName().contains("Classification")) {
	 * classificationChildNew = children.item(i).cloneNode(true);
	 * classificationChildOld = children.item(i); } else if
	 * (children.item(i).getNodeName().contains("RegistryPackage")) {
	 * registryPackageChildNew = children.item(i).cloneNode(true);
	 * registryPackageChildOld = children.item(i); } else if
	 * (children.item(i).getNodeName().contains("Association")) {
	 * log.info("Association: {}",
	 * children.item(i).getAttributes().getNamedItem("associationType").toString());
	 * log.info("Association node value: {}",
	 * children.item(i).getAttributes().getNamedItem("associationType").getNodeValue
	 * ()); if (children.item(i).getAttributes().getNamedItem("associationType").
	 * getNodeValue().contains("RPLC")) { log.debug("Association node value: {}",
	 * children.item(i).getAttributes().getNamedItem("associationType").getNodeValue
	 * ()); associationRplcChildNew = children.item(i).cloneNode(true);
	 * associationRplcChildOld = children.item(i); } else if
	 * (children.item(i).getAttributes().getNamedItem("associationType").
	 * getNodeValue() .contains("HasMember")) {
	 * log.debug("Association node value: {}",
	 * children.item(i).getAttributes().getNamedItem("associationType").getNodeValue
	 * ()); associationHasMemberChildNew = children.item(i).cloneNode(true);
	 * associationHasMemberChildOld = children.item(i); } } else if (replace &&
	 * children.item(i).getNodeName().contains("ObjectRef")) {
	 * nodesToDelete.add(children.item(i)); } }
	 * 
	 * if (!nodesToDelete.isEmpty()) { for (Node node : nodesToDelete) {
	 * submitObjectsRequest.getChildNodes().item(0).getChildNodes().item(0).
	 * removeChild(node); } }
	 * 
	 * submitObjectsRequest.getChildNodes().item(0).getChildNodes().item(0).
	 * replaceChild(classificationChildNew, registryPackageChildOld);
	 * submitObjectsRequest.getChildNodes().item(0).getChildNodes().item(0).
	 * replaceChild(extrinsicObjectChildNew, classificationChildOld);
	 * submitObjectsRequest.getChildNodes().item(0).getChildNodes().item(0).
	 * replaceChild(registryPackageChildNew, extrinsicObjectChildOld);
	 * 
	 * if (associationRplcChildNew != null && associationHasMemberChildNew != null)
	 * { log.info("Replace Associations");
	 * submitObjectsRequest.getChildNodes().item(0).getChildNodes().item(0)
	 * .replaceChild(associationHasMemberChildNew, associationRplcChildOld);
	 * submitObjectsRequest.getChildNodes().item(0).getChildNodes().item(0).
	 * replaceChild(associationRplcChildNew, associationHasMemberChildOld); }
	 * 
	 * log.info("Request Submit transaction: {}", submitObjectsRequest);
	 * 
	 * XDSSOAPResponsePayload responsePayload =
	 * source.getSenderClient().send(source.getRepositoryURI(),
	 * submitObjectsRequest, getTxnData().getDocList(),
	 * XDSConstants.PROVIDE_AND_REGISTER_DOCUMENT_SET_ACTION,
	 * affinityDomain.getRepositoryDestination().getSenderAddressingTo()); Element
	 * responseElement = responsePayload.getResponseElement();
	 * 
	 * log.info("Response Submit transaction: {}", responseElement); responseObject
	 * = metadataHandler.processResponse(new SynchronousXDSResponseType(),
	 * responseElement);
	 * 
	 * SourceAuditUtils.auditProvideAndRegister(source, getTxnData(),
	 * responseObject); SourceAuditUtils.auditActorStop(source); return
	 * responseObject;
	 * 
	 * }
	 */

}
