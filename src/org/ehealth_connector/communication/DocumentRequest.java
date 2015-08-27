package org.ehealth_connector.communication;

import java.net.URI;

import org.openhealthtools.ihe.xds.consumer.retrieve.DocumentRequestType;

public class DocumentRequest {
	DocumentRequestType ohtDocReq;
	URI xdsRepositoryUri;
	
	public DocumentRequest () {
		this.ohtDocReq = org.openhealthtools.ihe.xds.consumer.retrieve.RetrieveFactory.eINSTANCE.createDocumentRequestType();
	}
	
	public DocumentRequest(String repositoryId, URI repositoryUri, String documentId) {
		this(repositoryId, repositoryUri, documentId, null);
	}
	
	public DocumentRequest(String repositoryId, URI repositoryUri, String documentId, String homeCommunityId) {
		this();
		setRepositoryId(repositoryId);
		setRepositoryUri(repositoryUri);
		setDocumentId(documentId);
		setHomeCommunityId(homeCommunityId);
	}
	
	public void setRepositoryId(String repositoryId) {
		ohtDocReq.setRepositoryUniqueId(repositoryId);
	}

	public String getRepositoryId() {
		return ohtDocReq.getRepositoryUniqueId();
	}
	
	public void setRepositoryUri(URI repositoryUri) {
		this.xdsRepositoryUri = repositoryUri;
	}
	
	public URI getRepositoryUri() {
		return xdsRepositoryUri;
	}
	
	public void setDocumentId(String documentId) {
		ohtDocReq.setDocumentUniqueId(documentId.toString());
	}
	
	public String getDocumentId() {
		return ohtDocReq.getDocumentUniqueId();
	}
	
	public void setHomeCommunityId(String homeCommunityId) {
		ohtDocReq.setHomeCommunityId(homeCommunityId);
	}
	
	public String getHomeCommunityId() {
		return ohtDocReq.getHomeCommunityId();
	}
	
	public DocumentRequestType getOhtDocumentRequestType() {
		return this.ohtDocReq;
	}
}