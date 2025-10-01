/**
 * Author: Roeland Luykx, RALY GmbH
 * 
 * Copyright (c) 2025+ by AD Swiss Net AG
 */
package org.projecthusky.communication.requests.xds;

import java.util.List;

import org.openehealth.ipf.commons.ihe.xds.core.requests.query.GetDocumentsAndAssociationsQuery;
import org.openehealth.ipf.commons.ihe.xds.core.requests.query.StoredQuery;

import lombok.Getter;
import lombok.Singular;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * This class is designed to contain all possible search parameters for finding
 * documents and their associations with the webservice. Parameters are optional
 * (except patientId and destination), only those which are set will be used by
 * the webservice.<br/>
 */
@Getter
@SuperBuilder
@ToString
public class XdsRegistryStoredGetDocumentsAndAssociationsQuery extends XdsStoredQuery {

	/** List of SubmissionSet UUIDs to retrieve */
	@Singular
	private List<String> logicalUuids;

	public static abstract class XdsRegistryStoredGetDocumentsAndAssociationsQueryBuilder<C extends XdsRegistryStoredGetDocumentsAndAssociationsQuery, B extends XdsRegistryStoredGetDocumentsAndAssociationsQuery.XdsRegistryStoredGetDocumentsAndAssociationsQueryBuilder<C, B>>
			extends XdsStoredQuery.XdsStoredQueryBuilder<C, B> {
	}

	@Override
	public StoredQuery getIpfQuery() {
		var query = new GetDocumentsAndAssociationsQuery();
		query.setHomeCommunityId(getHomeCommunityId());
		query.setMetadataLevel(getMetadataLevel());
		query.setUuids(logicalUuids);
		return query;
	}

}
