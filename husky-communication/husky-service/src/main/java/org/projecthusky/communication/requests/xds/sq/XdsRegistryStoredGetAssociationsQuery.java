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
package org.projecthusky.communication.requests.xds.sq;

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
