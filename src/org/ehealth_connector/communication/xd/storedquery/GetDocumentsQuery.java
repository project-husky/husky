package org.ehealth_connector.communication.xd.storedquery;

import org.openhealthtools.ihe.xds.consumer.storedquery.MalformedStoredQueryException;

/**
 * Represents a query to get XDS documents by their document IDs
 */
public class GetDocumentsQuery extends AbstractStoredQuery {

	/**
	 * @param docIds
	 *            list of ids of the documents (either uniqueId or entryUUID)
	 * @param isUUID
	 *            isUUID set to true if docID is the entryUUID (internal
	 *            registry identifier) of the document and set to false if it is
	 *            the uniqueID (external to registry) of the document. In most
	 *            user cases, this should be set to false
	 * @param homeCommunityId
	 *            this is the id of the home community as specified by the XCA
	 *            profile. Value may be null or empty, in which case it is not
	 *            added to the query.
	 */
	public GetDocumentsQuery(String docIds[], boolean isUUID, String homeCommunityId) {
		try {
			ohtStoredQuery = new org.openhealthtools.ihe.xds.consumer.storedquery.GetDocumentsQuery(
					docIds, isUUID, homeCommunityId);
		} catch (MalformedStoredQueryException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates the query
	 * 
	 * @param docIds
	 *            list of ids of the documents (either uniqueId or entryUUID)
	 * @param isUUID
	 *            set to true if docID is the entryUUID (internal registry
	 *            identifier) of the document and set to false if it is the
	 *            uniqueID (external to registry) of the document. In most user
	 *            cases, this should be set to false
	 */
	public GetDocumentsQuery(String[] docIds, boolean isUUID) {
		try {
			ohtStoredQuery = new org.openhealthtools.ihe.xds.consumer.storedquery.GetDocumentsQuery(
					docIds, isUUID);
		} catch (MalformedStoredQueryException e) {
			e.printStackTrace();
		}
	}
}