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
package org.ehealth_connector.communication.ch;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.ch.AuthorCh;
import org.ehealth_connector.common.ch.enums.AuthorRole;
import org.ehealth_connector.communication.AffinityDomain;
import org.ehealth_connector.communication.AtnaConfig.AtnaConfigMode;
import org.ehealth_connector.communication.ConvenienceCommunication;
import org.ehealth_connector.communication.DocumentMetadata.DocumentMetadataExtractionMode;
import org.ehealth_connector.communication.SubmissionSetMetadata;
import org.ehealth_connector.communication.SubmissionSetMetadata.SubmissionSetMetadataExtractionMode;
import org.ehealth_connector.communication.ch.enums.AvailabilityStatus;
import org.ehealth_connector.communication.ch.xd.storedquery.FindDocumentsQuery;
import org.ehealth_connector.communication.exceptions.DocumentNotAccessibleException;
import org.openhealthtools.ihe.xds.document.DocumentDescriptor;
import org.openhealthtools.ihe.xds.document.XDSDocument;
import org.openhealthtools.ihe.xds.document.XDSDocumentFromStream;
import org.openhealthtools.ihe.xds.response.XDSQueryResponseType;
import org.openhealthtools.ihe.xds.response.XDSResponseType;

/**
 * 
 * @author roeland
 * @version 1.0
 * @since Dec 15, 2015 11:21:55 AM
 *
 */
public class ConvenienceCommunicationCh extends ConvenienceCommunication {

	/**
	 * Default constructor to instanciate the object
	 */
	public ConvenienceCommunicationCh() {
	}

	/**
	 * Default constructor to instanciate the object
	 * 
	 * @param affinityDomain
	 */
	public ConvenienceCommunicationCh(AffinityDomain affinityDomain) {
		super(affinityDomain);
	}

	/**
	 * Default constructor to instanciate the object
	 * 
	 * @param affinityDomain
	 * @param atnaConfigMode
	 * @param documentMetadataExtractionMode
	 * @param submissionSetMetadataExtractionMode
	 */
	public ConvenienceCommunicationCh(AffinityDomain affinityDomain, AtnaConfigMode atnaConfigMode,
			DocumentMetadataExtractionMode documentMetadataExtractionMode,
			SubmissionSetMetadataExtractionMode submissionSetMetadataExtractionMode) {
		super(affinityDomain, atnaConfigMode, documentMetadataExtractionMode,
				submissionSetMetadataExtractionMode);
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
	public DocumentMetadataCh addChDocument(DocumentDescriptor desc, InputStream inputStream) {
		DocumentMetadataCh retVal = null;
		if (inputStream == null)
			try {
				throw new DocumentNotAccessibleException();
			} catch (final DocumentNotAccessibleException e) {
				e.printStackTrace();
			}
		XDSDocument doc;
		try {
			doc = new XDSDocumentFromStream(desc, inputStream);
			retVal = new DocumentMetadataCh(addXdsDocument(doc, desc));
		} catch (final IOException e) {
			e.printStackTrace();
		}
		if (retVal != null)
			retVal.setDocumentDescriptor(desc);
		return retVal;
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
	 * @throws FileNotFoundException
	 */
	public DocumentMetadataCh addChDocument(DocumentDescriptor desc, String filePath)
			throws FileNotFoundException {
		return addChDocument(desc, new FileInputStream(new File(filePath)));
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
		final SubmissionSetMetadata subSet = new SubmissionSetMetadata();
		final AuthorCh author = new AuthorCh();
		author.setRoleFunction(authorRole);
		subSet.setAuthor(author);
		return submit(subSet);
	}

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

}
