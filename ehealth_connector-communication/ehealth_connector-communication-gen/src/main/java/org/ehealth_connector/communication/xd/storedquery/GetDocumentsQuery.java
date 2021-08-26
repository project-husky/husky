/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
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

import java.util.List;

/**
 * Represents a query to get XDS documents by their document IDs
 */
public class GetDocumentsQuery extends AbstractStoredQuery {

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
	public GetDocumentsQuery(List<String> docIds, boolean isUUID) {

		var query = new org.openehealth.ipf.commons.ihe.xds.core.requests.query.GetDocumentsQuery();

		if (isUUID) {
			query.setUuids(docIds);
		} else {
			query.setUniqueIds(docIds);
		}

		setIpfStoredQuery(query);
	}

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
	public GetDocumentsQuery(List<String> docIds, boolean isUUID, String homeCommunityId) {

		var query = new org.openehealth.ipf.commons.ihe.xds.core.requests.query.GetDocumentsQuery();

		if (isUUID) {
			query.setUuids(docIds);
		} else {
			query.setUniqueIds(docIds);
		}

		query.setHomeCommunityId(homeCommunityId);

		setIpfStoredQuery(query);
	}
}
