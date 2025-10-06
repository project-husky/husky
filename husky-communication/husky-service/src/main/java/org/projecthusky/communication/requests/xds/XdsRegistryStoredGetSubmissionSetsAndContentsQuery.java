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

import org.openehealth.ipf.commons.ihe.xds.core.metadata.DocumentEntryType;
import org.openehealth.ipf.commons.ihe.xds.core.requests.query.GetSubmissionSetAndContentsQuery;
import org.openehealth.ipf.commons.ihe.xds.core.requests.query.StoredQuery;
import org.projecthusky.common.model.Code;
import org.projecthusky.common.utils.XdsMetadataUtil;

import lombok.Getter;
import lombok.Singular;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * This class is designed to contain all possible search parameters for finding
 * submission sets with their contents using the webservice. Parameters are
 * optional (except patientId and destination), only those which are set will be
 * used by the webservice.<br/>
 */
@Getter
@SuperBuilder
@ToString
public class XdsRegistryStoredGetSubmissionSetsAndContentsQuery extends XdsStoredQuery {

	/** confidentiality codes */
	@Singular
	private List<Code> confidentialityCodes;
	/** document entry types */
	@Singular
	private List<DocumentEntryType> documentEntryTypes;
	/** format codes */
	@Singular
	private List<Code> formatCodes;
	/** List of document uniqueIds (repositoryUniqueId + documentId) */
	private String uniqueIds;
	/** List of SubmissionSet UUIDs to retrieve */
	private String uuids;

	public static abstract class XdsRegistryStoredGetSubmissionSetsAndContentsQueryBuilder<C extends XdsRegistryStoredGetSubmissionSetsAndContentsQuery, B extends XdsRegistryStoredGetSubmissionSetsAndContentsQuery.XdsRegistryStoredGetSubmissionSetsAndContentsQueryBuilder<C, B>>
			extends XdsStoredQuery.XdsStoredQueryBuilder<C, B> {
	}

	@Override
	public StoredQuery getIpfQuery() {
		var query = new GetSubmissionSetAndContentsQuery();
		query.setConfidentialityCodes(XdsMetadataUtil.convertEhcCodeToQueryListCode(confidentialityCodes));
		query.setDocumentEntryTypes(documentEntryTypes);
		query.setFormatCodes(XdsMetadataUtil.convertEhcCodeToCode(formatCodes));
		query.setHomeCommunityId(getHomeCommunityId());
		query.setMetadataLevel(getMetadataLevel());
		query.setUniqueId(uniqueIds);
		query.setUuid(uuids);

		return query;
	}

}
