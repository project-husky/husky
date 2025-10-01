/**
 * Author: Roeland Luykx, RALY GmbH
 * 
 * Copyright (c) 2025+ by AD Swiss Net AG
 */
package org.projecthusky.communication.requests.xds;

import java.util.List;

import org.openehealth.ipf.commons.ihe.xds.core.requests.query.GetDocumentsQuery;
import org.openehealth.ipf.commons.ihe.xds.core.requests.query.StoredQuery;

import lombok.Getter;
import lombok.Singular;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * This class is designed to contain all possible search parameters for finding
 * documents with the webservice. Parameters are optional (except patientId and
 * destination), only those which are set will be used by the webservice.<br/>
 */
@Getter
@SuperBuilder
@ToString
public class XdsRegistryStoredGetDocumentsQuery extends XdsStoredQuery {

	/** List of SubmissionSet UUIDs to retrieve */
	@Singular
	private List<String> logicalUuids;
	/** List of document uniqueIds (repositoryUniqueId + documentId) */
	@Singular
	private List<String> uniqueIds;
	/** List of document UUIDs */
	@Singular
	private List<String> uuids;

	public static abstract class XdsRegistryStoredGetDocumentsQueryBuilder<C extends XdsRegistryStoredGetDocumentsQuery, B extends XdsRegistryStoredGetDocumentsQuery.XdsRegistryStoredGetDocumentsQueryBuilder<C, B>>
			extends XdsStoredQuery.XdsStoredQueryBuilder<C, B> {
	}

	@Override
	public StoredQuery getIpfQuery() {
		var query = new GetDocumentsQuery();
		query.setHomeCommunityId(getHomeCommunityId());
		query.setLogicalUuid(logicalUuids);
		query.setMetadataLevel(getMetadataLevel());
		query.setUniqueIds(uniqueIds);
		query.setUuids(uuids);
		return query;
	}

}
