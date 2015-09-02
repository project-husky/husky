package org.ehealth_connector.communication.storedquery;

import org.openhealthtools.ihe.xds.consumer.storedquery.MalformedStoredQueryException;
import org.openhealthtools.ihe.xds.consumer.storedquery.ObjectType;
import org.openhealthtools.ihe.xds.metadata.ParentDocumentRelationshipType;

/**
 * Represents a query to get documents, which are associated with a given document from an XDS Registry
 */
public class GetRelatedDocumentsQuery extends AbstractStoredQuery {
	/**
	 * Constructor.
	 * 
	 * @param docId ID of the document
	 * @param isUUID set to true if docID is the entryUUID (internal registry identifier) of the document and set to false if it is the uniqueID (external to registry) of the document. In most user cases, this should be set to false
	 * @param relationshipTypes list of relationship types that relate the document in question to other documents and that are desired to be queried.
	 * @throws MalformedStoredQueryException
	 */
	public GetRelatedDocumentsQuery(String docId, boolean isUUID, ParentDocumentRelationshipType[] relationshipTypes) throws MalformedStoredQueryException {
		ohtStoredQuery = new org.openhealthtools.ihe.xds.consumer.storedquery.GetRelatedDocumentsQuery(docId, isUUID, relationshipTypes);
	}
	
	/**
	 * Constructor that allows for the addition of a homeCommunityId to the query to support the XCA profile extension of this query.
	 * 
	 * @param docId ID of the document
	 * @param isUUID set to true if docID is the entryUUID (internal registry identifier) of the document and set to false if it is the uniqueID (external to registry) of the document. In most user cases, this should be set to false
	 * @param relationshipTypes list of relationship types that relate the document in question to other documents and that are desired to be queried.
	 * @param homeCommunityId this is the id of the home community as specified by the XCA profile. Value may be null or empty, in which case it is not added to the query.
	 * @throws MalformedStoredQueryException
	 */
	public GetRelatedDocumentsQuery(String docId, boolean isUUID, ParentDocumentRelationshipType[] relationshipTypes, String homeCommunityId) throws MalformedStoredQueryException {
		ohtStoredQuery = new org.openhealthtools.ihe.xds.consumer.storedquery.GetRelatedDocumentsQuery(docId, isUUID, relationshipTypes, homeCommunityId);
	}
	
	/**
	 * Constructor that allows for the addition of a homeCommunityId to the query to support the XCA profile extension of this query.
	 * 
	 * @param docId ID of the document
	 * @param isUUID set to true if docID is the entryUUID (internal registry identifier) of the document and set to false if it is the uniqueID (external to registry) of the document. In most user cases, this should be set to false
	 * @param relationshipTypes list of relationship types that relate the document in question to other documents and that are desired to be queried.
	 * @param homeCommunityId this is the id of the home community as specified by the XCA profile. Value may be null or empty, in which case it is not added to the query.
	 * @param objectType for the OnDemand document feature. Tells whether you want static docs, on demand docs, or both
	 * @throws MalformedStoredQueryException
	 */
	public GetRelatedDocumentsQuery(String docId, boolean isUUID, ParentDocumentRelationshipType[] relationshipTypes, String homeCommunityId, ObjectType objectType) throws MalformedStoredQueryException {
		ohtStoredQuery = new org.openhealthtools.ihe.xds.consumer.storedquery.GetRelatedDocumentsQuery(docId, isUUID, relationshipTypes, homeCommunityId, objectType);
	}
}
