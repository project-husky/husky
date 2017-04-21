/*
 *
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */
package org.ehealth_connector.communication.xd.storedquery;

import org.openhealthtools.ihe.xds.consumer.storedquery.MalformedStoredQueryException;
import org.openhealthtools.ihe.xds.consumer.storedquery.ObjectType;
import org.openhealthtools.ihe.xds.metadata.ParentDocumentRelationshipType;

/**
 * Represents a query to get documents, which are associated with a given
 * document from an XDS Registry
 */
public class GetRelatedDocumentsQuery extends AbstractStoredQuery {
	/**
	 * Constructor.
	 *
	 * @param docId
	 *            ID of the document
	 * @param isUUID
	 *            set to true if docID is the entryUUID (internal registry
	 *            identifier) of the document and set to false if it is the
	 *            uniqueID (external to registry) of the document. In most user
	 *            cases, this should be set to false
	 * @param relationshipTypes
	 *            list of relationship types that relate the document in
	 *            question to other documents and that are desired to be
	 *            queried.
	 */
	public GetRelatedDocumentsQuery(String docId, boolean isUUID,
			ParentDocumentRelationshipType[] relationshipTypes) {
		try {
			setOhtStoredQuery(
					new org.openhealthtools.ihe.xds.consumer.storedquery.GetRelatedDocumentsQuery(
							docId, isUUID, relationshipTypes));
		} catch (final MalformedStoredQueryException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Constructor that allows for the addition of a homeCommunityId to the
	 * query to support the XCA profile extension of this query.
	 *
	 * @param docId
	 *            ID of the document
	 * @param isUUID
	 *            set to true if docID is the entryUUID (internal registry
	 *            identifier) of the document and set to false if it is the
	 *            uniqueID (external to registry) of the document. In most user
	 *            cases, this should be set to false
	 * @param relationshipTypes
	 *            list of relationship types that relate the document in
	 *            question to other documents and that are desired to be
	 *            queried.
	 * @param homeCommunityId
	 *            this is the id of the home community as specified by the XCA
	 *            profile. Value may be null or empty, in which case it is not
	 *            added to the query.
	 */
	public GetRelatedDocumentsQuery(String docId, boolean isUUID,
			ParentDocumentRelationshipType[] relationshipTypes, String homeCommunityId) {
		try {
			setOhtStoredQuery(
					new org.openhealthtools.ihe.xds.consumer.storedquery.GetRelatedDocumentsQuery(
							docId, isUUID, relationshipTypes, homeCommunityId));
		} catch (final MalformedStoredQueryException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Constructor that allows for the addition of a homeCommunityId to the
	 * query to support the XCA profile extension of this query.
	 *
	 * @param docId
	 *            ID of the document
	 * @param isUUID
	 *            set to true if docID is the entryUUID (internal registry
	 *            identifier) of the document and set to false if it is the
	 *            uniqueID (external to registry) of the document. In most user
	 *            cases, this should be set to false
	 * @param relationshipTypes
	 *            list of relationship types that relate the document in
	 *            question to other documents and that are desired to be
	 *            queried.
	 * @param homeCommunityId
	 *            this is the id of the home community as specified by the XCA
	 *            profile. Value may be null or empty, in which case it is not
	 *            added to the query.
	 * @param objectType
	 *            for the OnDemand document feature. Tells whether you want
	 *            static docs, on demand docs, or both
	 */
	public GetRelatedDocumentsQuery(String docId, boolean isUUID,
			ParentDocumentRelationshipType[] relationshipTypes, String homeCommunityId,
			ObjectType objectType) {
		try {
			setOhtStoredQuery(
					new org.openhealthtools.ihe.xds.consumer.storedquery.GetRelatedDocumentsQuery(
							docId, isUUID, relationshipTypes, homeCommunityId, objectType));
		} catch (final MalformedStoredQueryException e) {
			e.printStackTrace();
		}
	}
}
