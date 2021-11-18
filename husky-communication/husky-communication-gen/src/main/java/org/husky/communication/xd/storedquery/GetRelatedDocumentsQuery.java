/*
 * This code is made available under the terms of the Eclipse Public License v1.0 
 * in the github project https://github.com/project-husky/husky there you also 
 * find a list of the contributors and the license information.
 * 
 * This project has been developed further and modified by the joined working group Husky 
 * on the basis of the eHealth Connector opensource project from June 28, 2021, 
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.husky.communication.xd.storedquery;

import java.util.List;

import org.openehealth.ipf.commons.ihe.xds.core.metadata.AssociationType;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.DocumentEntryType;

/**
 * Represents a query to get documents, which are associated with a given
 * document from an XDS Registry
 */
public class GetRelatedDocumentsQuery extends AbstractStoredQuery {
	/**
	 * Constructor.
	 *
	 * @param docId             ID of the document
	 * @param isUUID            set to true if docID is the entryUUID (internal
	 *                          registry identifier) of the document and set to
	 *                          false if it is the uniqueID (external to registry)
	 *                          of the document. In most user cases, this should be
	 *                          set to false
	 * @param relationshipTypes list of relationship types that relate the document
	 *                          in question to other documents and that are desired
	 *                          to be queried.
	 */
	public GetRelatedDocumentsQuery(String docId, boolean isUUID, List<AssociationType> relationshipTypes) {
		var query = new org.openehealth.ipf.commons.ihe.xds.core.requests.query.GetRelatedDocumentsQuery();

		if (isUUID) {
			query.setUuid(docId);
		} else {
			query.setUniqueId(docId);
		}

		query.setAssociationTypes(relationshipTypes);

		setIpfStoredQuery(query);
	}

	/**
	 * Constructor that allows for the addition of a homeCommunityId to the query to
	 * support the XCA profile extension of this query.
	 *
	 * @param docId             ID of the document
	 * @param isUUID            set to true if docID is the entryUUID (internal
	 *                          registry identifier) of the document and set to
	 *                          false if it is the uniqueID (external to registry)
	 *                          of the document. In most user cases, this should be
	 *                          set to false
	 * @param relationshipTypes list of relationship types that relate the document
	 *                          in question to other documents and that are desired
	 *                          to be queried.
	 * @param homeCommunityId   this is the id of the home community as specified by
	 *                          the XCA profile. Value may be null or empty, in
	 *                          which case it is not added to the query.
	 */
	public GetRelatedDocumentsQuery(String docId, boolean isUUID, List<AssociationType> relationshipTypes,
			String homeCommunityId) {

		var query = new org.openehealth.ipf.commons.ihe.xds.core.requests.query.GetRelatedDocumentsQuery();

		if (isUUID) {
			query.setUuid(docId);
		} else {
			query.setUniqueId(docId);
		}

		query.setAssociationTypes(relationshipTypes);
		query.setHomeCommunityId(homeCommunityId);

		setIpfStoredQuery(query);
	}

	/**
	 * Constructor that allows for the addition of a homeCommunityId to the query to
	 * support the XCA profile extension of this query.
	 *
	 * @param docId             ID of the document
	 * @param isUUID            set to true if docID is the entryUUID (internal
	 *                          registry identifier) of the document and set to
	 *                          false if it is the uniqueID (external to registry)
	 *                          of the document. In most user cases, this should be
	 *                          set to false
	 * @param relationshipTypes list of relationship types that relate the document
	 *                          in question to other documents and that are desired
	 *                          to be queried.
	 * @param homeCommunityId   this is the id of the home community as specified by
	 *                          the XCA profile. Value may be null or empty, in
	 *                          which case it is not added to the query.
	 * @param objectType        for the OnDemand document feature. Tells whether you
	 *                          want static docs, on demand docs, or both
	 */
	public GetRelatedDocumentsQuery(String docId, boolean isUUID, List<AssociationType> relationshipTypes,
			String homeCommunityId, DocumentEntryType objectType) {

		var query = new org.openehealth.ipf.commons.ihe.xds.core.requests.query.GetRelatedDocumentsQuery();

		if (isUUID) {
			query.setUuid(docId);
		} else {
			query.setUniqueId(docId);
		}

		query.setAssociationTypes(relationshipTypes);
		query.setHomeCommunityId(homeCommunityId);

		query.setDocumentEntryTypes(List.of(objectType));

		setIpfStoredQuery(query);
	}
}
