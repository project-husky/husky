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
package org.husky.communication.ch;

import org.husky.common.ch.AuthorCh;
import org.husky.common.ch.enums.stable.AuthorRole;
import org.husky.common.communication.AffinityDomain;
import org.husky.common.communication.AtnaConfig.AtnaConfigMode;
import org.husky.common.communication.DocumentMetadata.DocumentMetadataExtractionMode;
import org.husky.common.communication.SubmissionSetMetadata;
import org.husky.common.communication.SubmissionSetMetadata.SubmissionSetMetadataExtractionMode;
import org.husky.common.enums.DocumentDescriptor;
import org.husky.common.model.Identificator;
import org.husky.communication.ConvenienceCommunication;
import org.husky.communication.ch.enums.AvailabilityStatus;
import org.husky.communication.ch.xd.storedquery.FindDocumentsQuery;
import org.husky.communication.exceptions.DocumentNotAccessibleException;
import org.husky.xua.core.SecurityHeaderElement;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Document;
import org.openehealth.ipf.commons.ihe.xds.core.requests.query.QueryReturnType;
import org.openehealth.ipf.commons.ihe.xds.core.responses.QueryResponse;
import org.openehealth.ipf.commons.ihe.xds.core.responses.Response;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.activation.DataHandler;
import javax.mail.util.ByteArrayDataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * Implementation of ch specific convenience communication
 *
 */
@Component
public class ConvenienceCommunicationCh extends ConvenienceCommunication {

	/** The SLF4J logger instance. */
	private static org.slf4j.Logger log = LoggerFactory.getLogger(ConvenienceCommunicationCh.class);

	/**
	 * Default constructor to instanciate the object
	 */
	public ConvenienceCommunicationCh() {
		super();
	}

	/**
	 * Default constructor to instanciate the object
	 *
	 * @param affinityDomain
	 *            the affinity Domain
	 */
	public ConvenienceCommunicationCh(AffinityDomain affinityDomain) {
		super(affinityDomain);
	}

	/**
	 * Instantiates a new convenience communication ch.
	 *
	 * @param affinityDomain
	 *            the affinity domain
	 * @param atnaConfigMode
	 *            the atna config mode
	 * @param documentMetadataExtractionMode
	 *            the document metadata extraction mode
	 * @param submissionSetMetadataExtractionMode
	 *            the submission set metadata extraction mode
	 */
	public ConvenienceCommunicationCh(AffinityDomain affinityDomain, AtnaConfigMode atnaConfigMode,
			DocumentMetadataExtractionMode documentMetadataExtractionMode,
			SubmissionSetMetadataExtractionMode submissionSetMetadataExtractionMode) {
		super(affinityDomain, atnaConfigMode, documentMetadataExtractionMode,
				submissionSetMetadataExtractionMode);
	}

	/**
	 * Adds a document to the XDS Submission set.
	 *
	 * @param desc
	 *            the document descriptor (which kind of document do you want to
	 *            transfer? e.g. PDF, CDA,...)
	 * @param inputStream
	 *            the input stream to the document
	 * @return the document metadata (which have to be completed)
	 */
	public DocumentMetadataCh addChDocument(DocumentDescriptor desc, InputStream inputStream) {
		return addChDocument(desc, inputStream, null);
	}

	/**
	 * Adds a document to the XDS Submission set.
	 *
	 * @param desc
	 *            the document descriptor (which kind of document do you want to
	 *            transfer? e.g. PDF, CDA,...)
	 * @param inputStream
	 *            the input stream to the document
	 * @param inputStream4Metadata
	 *            the input stream 4 metadata
	 * @return the document metadata (which have to be completed)
	 */
	public DocumentMetadataCh addChDocument(DocumentDescriptor desc, InputStream inputStream,
			InputStream inputStream4Metadata) {
		DocumentMetadataCh retVal = null;
		if (inputStream == null)
			try {
				throw new DocumentNotAccessibleException();
			} catch (final DocumentNotAccessibleException e) {
				log.error(e.getMessage(), e);
			}
		var doc = new Document();
		var doc4Metadata = new Document();
		InputStream unicodeStream = null;
		try {

			if (inputStream4Metadata != null) {
				unicodeStream = convertNonAsciiText2Unicode(inputStream4Metadata);
				var dataSource = new ByteArrayDataSource(unicodeStream, desc.getMimeType());
				doc4Metadata.setDataHandler(new DataHandler(dataSource));
			}
			var dataSource = new ByteArrayDataSource(inputStream, desc.getMimeType());
			doc.setDataHandler(new DataHandler(dataSource));
			retVal = new DocumentMetadataCh(addXdsDocument(doc, desc, doc4Metadata));
		} catch (final IOException e) {
			log.error(e.getMessage(), e);
		} finally {
			if (unicodeStream != null) {
				try {
					unicodeStream.close();
				} catch (IOException e) {
					log.error(e.getMessage(), e);
				}
			}
		}

		if (retVal != null)
			retVal.setDocumentDescriptor(desc);
		return retVal;
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
	public DocumentMetadataCh addChDocument(DocumentDescriptor desc, String filePath)
			throws IOException {
		try (InputStream is = new FileInputStream(new File(filePath))) {
			return addChDocument(desc, is);
		}
	}

	/**
	 * Queries the registry of the affinity domain for all documents
	 * of one patient. This is useful if the number of results is limited in the
	 * registry and your query would exceed this limit. In this case, precise your
	 * query or do a query for references first, choose the possible matches (e.g.
	 * the last 10 results) and then query for metadata.
	 *
	 * @param patientId the ID of the patient
	 * @param security  a security header element for example an assertion
	 * 
	 * @return the IPF QueryResponse containing references instead of the complete
	 *         document metadata
	 * @throws Exception
	 */
	public QueryResponse queryDocumentReferencesOnly(Identificator patientId, SecurityHeaderElement security)
			throws Exception {
		return queryDocumentQuery(new FindDocumentsQuery(patientId, AvailabilityStatus.APPROVED), security,
				QueryReturnType.OBJECT_REF, null);
	}

	/**
	 * Queries the registry of the affinity domain for all documents
	 * of one patient.
	 *
	 * @param patientId the ID of the patient
	 * @param security  a security header element for example an assertion
	 * 
	 * @return the IPF Response containing full document metadata
	 * @throws Exception
	 */
	public QueryResponse queryDocuments(Identificator patientId, SecurityHeaderElement security)
			throws Exception {
		return queryDocumentQuery(new FindDocumentsQuery(patientId, AvailabilityStatus.APPROVED), security,
				QueryReturnType.LEAF_CLASS, null);
	}

	/**
	 * Submission of the previously prepared document(s) to the
	 * repository<br>
	 * IHE [ITI-41] Provide and Register Document Set – b in the role of the IHE ITI
	 * Document Source actor
	 *
	 * @param authorRole The AuthorRole is one of the minimal required information
	 *                   according to IHE Suisse for classification of documents in
	 *                   Switzerland.
	 * @param security   a security header element for example an assertion
	 * 
	 * @return the IPF Response
	 * @throws Exception if the transfer is not successful
	 */
	public Response submit(AuthorRole authorRole, SecurityHeaderElement security) throws Exception {
		final var subSet = new SubmissionSetMetadata(getTxnData().getSubmissionSet());
		final var author = new AuthorCh();
		author.setRoleFunction(authorRole);
		subSet.setAuthor(author);
		return submit(subSet, security, null);
	}

}
