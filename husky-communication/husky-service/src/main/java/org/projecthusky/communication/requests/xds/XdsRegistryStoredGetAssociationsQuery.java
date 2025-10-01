/**
 * Author: Roeland Luykx, RALY GmbH
 * 
 * Copyright (c) 2025+ by AD Swiss Net AG
 */
package org.projecthusky.communication.requests.xds;

import java.util.List;

import org.openehealth.ipf.commons.ihe.xds.core.metadata.AvailabilityStatus;
import org.openehealth.ipf.commons.ihe.xds.core.requests.query.GetAssociationsQuery;
import org.openehealth.ipf.commons.ihe.xds.core.requests.query.StoredQuery;

import lombok.Getter;
import lombok.Singular;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * This class is designed to contain all possible search parameters for finding
 * associations with the webservice. Parameters are optional (except patientId
 * and destination), only those which are set will be used by the
 * webservice.<br/>
 */
@Getter
@SuperBuilder
@ToString
public class XdsRegistryStoredGetAssociationsQuery extends XdsStoredQuery {

	/** List of UUIDs to retrieve associations for */
	@Singular
	private List<String> uuids;
	/** list of association statuses */
	@Singular
	private List<AvailabilityStatus> associationStatuses;

	public static abstract class XdsRegistryStoredGetAssociationsQueryBuilder<C extends XdsRegistryStoredGetAssociationsQuery, B extends XdsRegistryStoredGetAssociationsQuery.XdsRegistryStoredGetAssociationsQueryBuilder<C, B>>
			extends XdsStoredQuery.XdsStoredQueryBuilder<C, B> {
	}

	@Override
	public StoredQuery getIpfQuery() {
		var query = new GetAssociationsQuery();
		query.setAssociationStatuses(associationStatuses);
		query.setMetadataLevel(getMetadataLevel());
		query.setHomeCommunityId(getHomeCommunityId());
		query.setUuids(uuids);
		return query;
	}

}
