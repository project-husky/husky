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
			setOhtStoredQuery( new org.openhealthtools.ihe.xds.consumer.storedquery.GetDocumentsQuery(
					docIds, isUUID, homeCommunityId));
		} catch (final MalformedStoredQueryException e) {
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
			setOhtStoredQuery( new org.openhealthtools.ihe.xds.consumer.storedquery.GetDocumentsQuery(
					docIds, isUUID));
		} catch (final MalformedStoredQueryException e) {
			e.printStackTrace();
		}
	}
}