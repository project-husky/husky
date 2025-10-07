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
import org.openehealth.ipf.commons.ihe.xds.core.requests.query.FindSubmissionSetsQuery;
import org.openehealth.ipf.commons.ihe.xds.core.requests.query.StoredQuery;
import org.projecthusky.common.model.Identificator;
import org.projecthusky.common.utils.XdsMetadataUtil;

import lombok.Getter;
import lombok.NonNull;
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
public class XdsRegistryStoredFindSubmissionSetsQuery extends XdsStoredQuery {

	/** patientId as CX */
	@NonNull
	private Identificator patientId;
	/** list of availability statuses */
	private List<AvailabilityStatus> availabilityStatuses;

	public static abstract class XdsRegistryStoredFindSubmissionSetQueryBuilder<C extends XdsRegistryStoredFindSubmissionSetsQuery, B extends XdsRegistryStoredFindSubmissionSetsQuery.XdsRegistryStoredFindSubmissionSetQueryBuilder<C, B>>
			extends XdsStoredQuery.XdsStoredQueryBuilder<C, B> {
	}

	@Override
	public StoredQuery getIpfQuery() {
		var query = new FindSubmissionSetsQuery();
		query.setPatientId(XdsMetadataUtil.convertEhcIdentificator(patientId));
		query.setHomeCommunityId(getHomeCommunityId());
		query.setStatus(availabilityStatuses);

		return query;
	}

}
