/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.communication.at;

import java.io.IOException;
import java.io.InputStream;
import java.time.ZonedDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import jakarta.activation.DataHandler;
import jakarta.mail.util.ByteArrayDataSource;

import org.projecthusky.common.at.AuthorAt;
import org.projecthusky.common.at.enums.ConfidentialityCode;
import org.projecthusky.common.communication.AffinityDomain;
import org.projecthusky.common.communication.AtnaConfig.AtnaConfigMode;
import org.projecthusky.common.communication.DocumentMetadata.DocumentMetadataExtractionMode;
import org.projecthusky.common.communication.SubmissionSetMetadata.SubmissionSetMetadataExtractionMode;
import org.projecthusky.common.enums.DocumentDescriptor;
import org.projecthusky.common.hl7cdar2.POCDMT000040ClinicalDocument;
import org.projecthusky.common.model.Author;
import org.projecthusky.common.model.Code;
import org.projecthusky.common.model.Identificator;
import org.projecthusky.common.utils.XdsMetadataUtil;
import org.projecthusky.communication.ConvenienceCommunication;
import org.projecthusky.communication.exceptions.DocumentNotAccessibleException;
import org.projecthusky.communication.xd.storedquery.FindDocumentsQuery;
import org.projecthusky.xua.core.SecurityHeaderElement;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AvailabilityStatus;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Document;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Identifiable;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Organization;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Person;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.SubmissionSet;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Timestamp;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Timestamp.Precision;
import org.openehealth.ipf.commons.ihe.xds.core.responses.QueryResponse;
import org.openehealth.ipf.commons.ihe.xds.core.responses.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Implementation of ch specific convenience communication
 *
 */
public class ConvenienceCommunicationAt extends ConvenienceCommunication {

	/** The SLF4J logger instance. */
	private static Logger log = LoggerFactory.getLogger(ConvenienceCommunicationAt.class);

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
	 * 
	 */
	public ConvenienceCommunicationAt(AffinityDomain affinityDomain, AtnaConfigMode atnaConfigMode,
			org.projecthusky.common.communication.DocumentMetadata.DocumentMetadataExtractionMode documentMetadataExtractionMode,
			SubmissionSetMetadataExtractionMode submissionSetMetadataExtractionMode) {
		super(affinityDomain, atnaConfigMode, documentMetadataExtractionMode, submissionSetMetadataExtractionMode);
	}

	public DocumentMetadataAt addElgaDocument(DocumentDescriptor desc, InputStream inputStream,
			POCDMT000040ClinicalDocument cda, boolean urnOidNeeded) {
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
				metadata = new DocumentMetadataAt(cda, urnOidNeeded);
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
	 * Adds an XDSDocument to the Transaction data
	 *
	 * @param doc      the document
	 * @param desc     the Document descriptor
	 * @param metadata the metadata
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
			if (getAutomaticExtractionEnabled() == DocumentMetadataExtractionMode.DEFAULT_EXTRACTION) {
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
	 * Generate missing Submission Set attributes
	 *
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

			addAuthorToSubSet(subSet, author);
		}
	}

	private void addAuthorToSubSet(SubmissionSet subSet, Author author) {
		if (subSet.getAuthors().isEmpty()) {
			subSet.getAuthors().add(AuthorAt.getIpfAuthor(author));
		}

		if (subSet.getAuthors() != null && !subSet.getAuthors().isEmpty()) {
			for (org.openehealth.ipf.commons.ihe.xds.core.metadata.Author ipfAuthor : subSet.getAuthors()) {
				if (ipfAuthor != null) {

					fixAuthorInstitution(ipfAuthor.getAuthorInstitution());

					if (ipfAuthor.getAuthorRole() != null && !ipfAuthor.getAuthorRole().isEmpty()
							&& ipfAuthor.getAuthorRole().get(0) == null) {
						ipfAuthor.getAuthorRole().clear();
					}

					fixAuthorPerson(ipfAuthor.getAuthorPerson());
				}
			}

		}
	}

	private void fixAuthorPerson(Person authorPerson) {
		if (authorPerson != null && authorPerson.getId() != null && authorPerson.getId().getAssigningAuthority() != null
				&& authorPerson.getId().getAssigningAuthority().getUniversalId() != null
				&& authorPerson.getId().getId() == null) {
			authorPerson.getId().setId(authorPerson.getId().getAssigningAuthority().getUniversalId());
			authorPerson.getId().setAssigningAuthority(null);
		}
	}

	private void fixAuthorInstitution(List<Organization> institutions) {
		if (institutions != null) {
			Iterator<Organization> authorIterator = institutions.iterator();
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
	public QueryResponse queryDocumentReferencesOnly(Identificator patientId, SecurityHeaderElement assertion,
			String messageId)
			throws Exception {
		return this.queryDocumentReferencesOnly(new FindDocumentsQuery(patientId, AvailabilityStatus.APPROVED),
				assertion, messageId);
	}

	/**
	 * Queries the registry of the affinity domain for all documents of one patient.
	 *
	 * @param patientId the ID of the patient
	 * @param assertion which should be used for request
	 * @return the IPF QueryResponse containing full document metadata
	 * @throws Exception
	 */
	public QueryResponse queryDocuments(Identificator patientId, SecurityHeaderElement assertion, String messageId)
			throws Exception {
		return this.queryDocuments(new FindDocumentsQuery(patientId, AvailabilityStatus.APPROVED), assertion,
				messageId);
	}

	/**
	 * Submission of the previously prepared document(s) to the repository IHE
	 * [ITI-41] Provide and Register Document Set – b in the role of the IHE ITI
	 * Document Source actor
	 *
	 * @param author   The AuthorRole is one of the minimal required information
	 *                 according to IHE Suisse for classification of documents in
	 *                 Switzerland.
	 * @param security assertion which should be used for request
	 * @return the Response
	 * @throws Exception if the transfer is not successful
	 */
	public Response submit(Author author, Code codeContentType,
			SecurityHeaderElement security, String messageId) throws Exception {
		generateSubmissionSetMetadata(author, codeContentType);
		return submit(security, messageId);
	}

}
