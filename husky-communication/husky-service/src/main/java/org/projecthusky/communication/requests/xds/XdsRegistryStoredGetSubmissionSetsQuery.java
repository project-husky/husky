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
package org.projecthusky.communication.requests.xds;

import java.util.List;

import org.openehealth.ipf.commons.ihe.xds.core.requests.query.GetSubmissionSetsQuery;
import org.openehealth.ipf.commons.ihe.xds.core.requests.query.StoredQuery;

import lombok.Getter;
import lombok.Singular;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * This class is designed to contain all possible search parameters for finding
 * submission sets with the webservice. Parameters are optional (except
 * patientId and destination), only those which are set will be used by the
 * webservice.<br/>
 */
@Getter
@SuperBuilder
@ToString
public class XdsRegistryStoredGetSubmissionSetsQuery extends XdsStoredQuery {

	/** List of SubmissionSet UUIDs to retrieve */
	@Singular
	private List<String> logicalUuids;

	public static abstract class XdsRegistryStoredGetSubmissionSetQueryBuilder<C extends XdsRegistryStoredGetSubmissionSetsQuery, B extends XdsRegistryStoredGetSubmissionSetsQuery.XdsRegistryStoredGetSubmissionSetQueryBuilder<C, B>>
			extends XdsStoredQuery.XdsStoredQueryBuilder<C, B> {
	}

	@Override
	public StoredQuery getIpfQuery() {
		var query = new GetSubmissionSetsQuery();
		query.setHomeCommunityId(getHomeCommunityId());
		query.setMetadataLevel(getMetadataLevel());
		query.setUuids(logicalUuids);
		return query;
	}

}
