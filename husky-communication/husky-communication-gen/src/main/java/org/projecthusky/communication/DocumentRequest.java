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

import java.net.URI;

import org.openehealth.ipf.commons.ihe.xds.core.metadata.DocumentEntry;

/**
 * Represents request information for one Document
 */
public class DocumentRequest {
	private DocumentEntry ipfDocReq;
	private URI xdsRepositoryUri;

	/**
	 * Standard constructor.
	 */
	public DocumentRequest() {
		this.ipfDocReq = new DocumentEntry();
	}

	/**
	 * Minimal constructor.
	 *
	 * @param repositoryId
	 *            the ID of the repository. Typically you will find this id in
	 *            the object that you get after using
	 *            ConvenienceCommunication.queryForDocuments. (Using
	 *            XDSQueryResponseType
	 *            .getDocumentEntryResponses().getDocumentEntry
	 *            ().getRepositoryUniqueId())
	 * @param repositoryUri
	 *            the Uri of the repository. Typically you will find this id in
	 *            the object that you get after using
	 *            ConvenienceCommunication.queryForDocuments. (Using
	 *            XDSQueryResponseType
	 *            .getDocumentEntryResponses().getDocumentEntry
	 *            ().getRepositoryUri())
	 * @param documentId
	 *            the Uri of the repository. Typically you will find this id in
	 *            the object that you get after using
	 *            ConvenienceCommunication.queryForDocuments. (Using
	 *            XDSQueryResponseType
	 *            .getDocumentEntryResponses().getDocumentEntry().getUniqueId())
	 */
	public DocumentRequest(String repositoryId, URI repositoryUri, String documentId) {
		this(repositoryId, repositoryUri, documentId, null);
	}

	/**
	 * Constructor with homeCommunityID for the IHE XCA profile.
	 *
	 * @param repositoryId
	 *            the ID of the repository. Typically you will find this id in
	 *            the object that you get after using
	 *            ConvenienceCommunication.queryForDocuments. (Using
	 *            XDSQueryResponseType
	 *            .getDocumentEntryResponses().getDocumentEntry
	 *            ().getRepositoryUniqueId())
	 * @param repositoryUri
	 *            the Uri of the repository. Typically you will find this id in
	 *            the object that you get after using
	 *            ConvenienceCommunication.queryForDocuments. (Using
	 *            XDSQueryResponseType
	 *            .getDocumentEntryResponses().getDocumentEntry
	 *            ().getRepositoryUri())
	 * @param documentId
	 *            the Uri of the repository. Typically you will find this id in
	 *            the object that you get after using
	 *            ConvenienceCommunication.queryForDocuments. (Using
	 *            XDSQueryResponseType
	 *            .getDocumentEntryResponses().getDocumentEntry().getUniqueId())
	 * @param homeCommunityId
	 *            the id of the community. Typically you will find this id in
	 *            the object that you get after using
	 *            ConvenienceCommunication.queryForDocuments. (Using
	 *            XDSQueryResponseType
	 *            .getDocumentEntryResponses().getHomeCommunityId())
	 */
	public DocumentRequest(String repositoryId, URI repositoryUri, String documentId,
			String homeCommunityId) {
		this();
		setRepositoryId(repositoryId);
		setRepositoryUri(repositoryUri);
		setDocumentId(documentId);
		setHomeCommunityId(homeCommunityId);
	}

	/**
	 * Gets the document Id.
	 *
	 * @return the document Id
	 */
	public String getDocumentId() {
		return ipfDocReq.getUniqueId();
	}

	/**
	 * Gets the home community id
	 *
	 * @return the Id of the community
	 */
	public String getHomeCommunityId() {
		return ipfDocReq.getHomeCommunityId();
	}

	/**
	 * Gets the OHT DocumentRequestType, which is wrapped by this class
	 *
	 * @return the OHT DocumentRequestType
	 */
	public DocumentEntry getIpfDocumentEntry() {
		return this.ipfDocReq;
	}

	/**
	 * Gets the repository id.
	 *
	 * @return the repositoryId
	 */
	public String getRepositoryId() {
		return ipfDocReq.getRepositoryUniqueId();
	}

	/**
	 * Gets the repository URI.
	 *
	 * @return repositoryURI
	 */
	public URI getRepositoryUri() {
		return xdsRepositoryUri;
	}

	/**
	 * Sets the document Id.
	 *
	 * @param documentId
	 *            Typically you will find this id in the object that you get
	 *            after using ConvenienceCommunication.queryForDocuments. (Using
	 *            XDSQueryResponseType
	 *            .getDocumentEntryResponses().getDocumentEntry
	 *            ().getRepositoryUri())
	 */
	public void setDocumentId(String documentId) {
		ipfDocReq.setUniqueId(documentId);
	}

	/**
	 * Sets the home community Id.
	 *
	 * @param homeCommunityId
	 *            Typically you will find this id in the object that you get
	 *            after using ConvenienceCommunication.queryForDocuments. (Using
	 *            XDSQueryResponseType
	 *            .getDocumentEntryResponses().getHomeCommunityId())
	 */
	public void setHomeCommunityId(String homeCommunityId) {
		ipfDocReq.setHomeCommunityId(homeCommunityId);
	}

	/**
	 * Sets the repository id.
	 *
	 * @param repositoryId
	 *            Typically you will find this id in the object that you get
	 *            after using ConvenienceCommunication.queryForDocuments. (Using
	 *            XDSQueryResponseType
	 *            .getDocumentEntryResponses().getDocumentEntry
	 *            ().getRepositoryUniqueId())
	 */
	public void setRepositoryId(String repositoryId) {
		ipfDocReq.setRepositoryUniqueId(repositoryId);
	}

	/**
	 * Sets the repository URI.
	 *
	 * @param repositoryUri
	 *            Typically you will find this id in the object that you get
	 *            after using ConvenienceCommunication.queryForDocuments. (Using
	 *            XDSQueryResponseType
	 *            .getDocumentEntryResponses().getDocumentEntry().getUniqueId())
	 */
	public void setRepositoryUri(URI repositoryUri) {
		this.xdsRepositoryUri = repositoryUri;
	}
}
