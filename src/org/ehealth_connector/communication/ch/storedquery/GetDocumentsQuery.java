package org.ehealth_connector.communication.ch.storedquery;

import org.openhealthtools.ihe.xds.consumer.storedquery.MalformedStoredQueryException;

public class GetDocumentsQuery extends AbstractStoredQuery {
	
	public GetDocumentsQuery(String[] docIds, boolean isUUID) throws MalformedStoredQueryException {
		ohtStoredQuery = new org.openhealthtools.ihe.xds.consumer.storedquery.GetDocumentsQuery(docIds, isUUID);
	}
	
	public GetDocumentsQuery(String docIds[], boolean isUUID, String homeCommunityId) throws MalformedStoredQueryException {
		ohtStoredQuery = new org.openhealthtools.ihe.xds.consumer.storedquery.GetDocumentsQuery(docIds, isUUID, homeCommunityId);
	}
}