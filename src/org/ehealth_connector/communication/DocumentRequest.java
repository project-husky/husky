package org.ehealth_connector.communication;

import java.net.URI;

import org.openhealthtools.ihe.xds.consumer.retrieve.DocumentRequestType;

/**
 * Represents request information for one Document
 */
public class DocumentRequest {
	DocumentRequestType ohtDocReq;
	URI xdsRepositoryUri;
	
	/**
	 * Standard constructor.
	 */
	public DocumentRequest () {
		this.ohtDocReq = org.openhealthtools.ihe.xds.consumer.retrieve.RetrieveFactory.eINSTANCE.createDocumentRequestType();
	}
	
	/**
	 * Minimal constructor.
	 * 
	 * @param repositoryId the ID of the repository. Typically you will find this id in the object that you get after using ConvenienceCommunication.queryForDocuments. (Using XDSQueryResponseType.getDocumentEntryResponses().getDocumentEntry().getRepositoryUniqueId())
	 * @param repositoryUri the Uri of the repository.  Typically you will find this id in the object that you get after using ConvenienceCommunication.queryForDocuments. (Using XDSQueryResponseType.getDocumentEntryResponses().getDocumentEntry().getRepositoryUri())
	 * @param documentId the Uri of the repository.  Typically you will find this id in the object that you get after using ConvenienceCommunication.queryForDocuments. (Using XDSQueryResponseType.getDocumentEntryResponses().getDocumentEntry().getUniqueId())
	 */
	public DocumentRequest(String repositoryId, URI repositoryUri, String documentId) {
		this(repositoryId, repositoryUri, documentId, null);
	}
	
	/**
	 * Constructor with homeCommunityID for the IHE XCA profile.
	 * 
	 * @param repositoryId the ID of the repository. Typically you will find this id in the object that you get after using ConvenienceCommunication.queryForDocuments. (Using XDSQueryResponseType.getDocumentEntryResponses().getDocumentEntry().getRepositoryUniqueId())
	 * @param repositoryUri the Uri of the repository.  Typically you will find this id in the object that you get after using ConvenienceCommunication.queryForDocuments. (Using XDSQueryResponseType.getDocumentEntryResponses().getDocumentEntry().getRepositoryUri())
	 * @param documentId the Uri of the repository.  Typically you will find this id in the object that you get after using ConvenienceCommunication.queryForDocuments. (Using XDSQueryResponseType.getDocumentEntryResponses().getDocumentEntry().getUniqueId())
	 * @param homeCommunityId the id of the community. Typically you will find this id in the object that you get after using ConvenienceCommunication.queryForDocuments. (Using XDSQueryResponseType.getDocumentEntryResponses().getHomeCommunityId())
	 */
	public DocumentRequest(String repositoryId, URI repositoryUri, String documentId, String homeCommunityId) {
		this();
		setRepositoryId(repositoryId);
		setRepositoryUri(repositoryUri);
		setDocumentId(documentId);
		setHomeCommunityId(homeCommunityId);
	}
	
	/**
	 * Sets the repository id.
	 * 
	 * @param repositoryId Typically you will find this id in the object that you get after using ConvenienceCommunication.queryForDocuments. (Using XDSQueryResponseType.getDocumentEntryResponses().getDocumentEntry().getRepositoryUniqueId())
	 */
	public void setRepositoryId(String repositoryId) {
		ohtDocReq.setRepositoryUniqueId(repositoryId);
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
	 * Sets the repository URI.
	 * 
	 * @param repositoryURI Typically you will find this id in the object that you get after using ConvenienceCommunication.queryForDocuments. (Using XDSQueryResponseType.getDocumentEntryResponses().getDocumentEntry().getUniqueId())
	 */
	public void setRepositoryUri(URI repositoryUri) {
		this.xdsRepositoryUri = repositoryUri;
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
	 * @param documentId Typically you will find this id in the object that you get after using ConvenienceCommunication.queryForDocuments. (Using XDSQueryResponseType.getDocumentEntryResponses().getDocumentEntry().getRepositoryUri())
	 */
	public void setDocumentId(String documentId) {
		ohtDocReq.setDocumentUniqueId(documentId.toString());
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
	 * Sets the home community Id.
	 * 
	 * @param homeCommunityId Typically you will find this id in the object that you get after using ConvenienceCommunication.queryForDocuments. (Using XDSQueryResponseType.getDocumentEntryResponses().getHomeCommunityId())
	 */
	public void setHomeCommunityId(String homeCommunityId) {
		ohtDocReq.setHomeCommunityId(homeCommunityId);
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
}