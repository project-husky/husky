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

import java.net.URI;

import org.openhealthtools.ihe.xds.consumer.retrieve.DocumentRequestType;

/**
 * Represents request information for one Document
 */
public class DocumentRequest {
	private DocumentRequestType ohtDocReq;
	private URI xdsRepositoryUri;

	/**
	 * Standard constructor.
	 */
	public DocumentRequest() {
		this.ohtDocReq = org.openhealthtools.ihe.xds.consumer.retrieve.RetrieveFactory.eINSTANCE.createDocumentRequestType();
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
	public DocumentRequest(String repositoryId, URI repositoryUri, String documentId, String homeCommunityId) {
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
		return ohtDocReq.getDocumentUniqueId();
	}

	/**
	 * Gets the home community id
	 * 
	 * @return the Id of the community
	 */
	public String getHomeCommunityId() {
		return ohtDocReq.getHomeCommunityId();
	}

	/**
	 * Gets the OHT DocumentRequestType, which is wrapped by this class
	 * 
	 * @return the OHT DocumentRequestType
	 */
	public DocumentRequestType getOhtDocumentRequestType() {
		return this.ohtDocReq;
	}

	/**
	 * Gets the repository id.
	 * 
	 * @return the repositoryId
	 */
	public String getRepositoryId() {
		return ohtDocReq.getRepositoryUniqueId();
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
		ohtDocReq.setDocumentUniqueId(documentId.toString());
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
		ohtDocReq.setHomeCommunityId(homeCommunityId);
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
		ohtDocReq.setRepositoryUniqueId(repositoryId);
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
