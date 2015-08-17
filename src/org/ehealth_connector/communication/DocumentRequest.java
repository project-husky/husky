package org.ehealth_connector.communication;

import org.openhealthtools.ihe.xds.consumer.retrieve.DocumentRequestType;

public class DocumentRequest {
	DocumentRequestType ohtDocReq;
	
	public DocumentRequest () {
		this.ohtDocReq = org.openhealthtools.ihe.xds.consumer.retrieve.RetrieveFactory.eINSTANCE.createDocumentRequestType();
	}
	
	public DocumentRequest(String repositoryId, String documentId, String homeCommunityId) {
		this();
		setReposioryId(repositoryId);
		setDocumentId(documentId);
		setHomeCommunityId(homeCommunityId);
	}
	
	
	public void setReposioryId(String repositoryId) {
		ohtDocReq.setRepositoryUniqueId(repositoryId);
	}
	
	public void setDocumentId(String documentId) {
		ohtDocReq.setDocumentUniqueId(documentId);
	}
	
	public void setHomeCommunityId(String homeCommunityId) {
		ohtDocReq.setHomeCommunityId(homeCommunityId);
	}
	
	public DocumentRequestType getOhtDocumentRequestType() {
		return this.ohtDocReq;
	}
}
