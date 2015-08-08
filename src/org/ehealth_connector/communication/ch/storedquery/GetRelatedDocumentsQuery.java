package org.ehealth_connector.communication.ch.storedquery;

import org.openhealthtools.ihe.xds.consumer.storedquery.MalformedStoredQueryException;
import org.openhealthtools.ihe.xds.consumer.storedquery.ObjectType;
import org.openhealthtools.ihe.xds.metadata.ParentDocumentRelationshipType;

public class GetRelatedDocumentsQuery extends AbstractStoredQuery {
	//TODO Evtl. einen eigenen Enum für ParentRelationshipType erstellen
	public GetRelatedDocumentsQuery(String docId, boolean isUUID, ParentDocumentRelationshipType[] relationshipTypes) throws MalformedStoredQueryException {
		ohtStoredQuery = new org.openhealthtools.ihe.xds.consumer.storedquery.GetRelatedDocumentsQuery(docId, isUUID, relationshipTypes);
	}
	
	public GetRelatedDocumentsQuery(String docId, boolean isUUID, ParentDocumentRelationshipType[] relationshipTypes, String homeCommunityId) throws MalformedStoredQueryException {
		ohtStoredQuery = new org.openhealthtools.ihe.xds.consumer.storedquery.GetRelatedDocumentsQuery(docId, isUUID, relationshipTypes, homeCommunityId);
	}
	
	public GetRelatedDocumentsQuery(String docId, boolean isUUID, ParentDocumentRelationshipType[] relationshipTypes, String homeCommunityId, ObjectType objectType) throws MalformedStoredQueryException {
		ohtStoredQuery = new org.openhealthtools.ihe.xds.consumer.storedquery.GetRelatedDocumentsQuery(docId, isUUID, relationshipTypes, homeCommunityId, objectType);
	}
}
