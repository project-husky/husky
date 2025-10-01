/**
 * Author: Roeland Luykx, RALY GmbH
 * 
 * Copyright (c) 2025+ by AD Swiss Net AG
 */
package org.projecthusky.communication.requests.xds;

import java.util.List;

import org.openehealth.ipf.commons.ihe.xds.core.metadata.AvailabilityStatus;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.DocumentEntryType;
import org.openehealth.ipf.commons.ihe.xds.core.requests.query.GetAllQuery;
import org.openehealth.ipf.commons.ihe.xds.core.requests.query.StoredQuery;
import org.projecthusky.common.model.Code;
import org.projecthusky.common.model.Identificator;
import org.projecthusky.common.utils.XdsMetadataUtil;

import lombok.Getter;
import lombok.NonNull;
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
public class XdsRegistryStoredGetAllQuery extends XdsStoredQuery {

	public static abstract class XdsRegistryStoredGetAllQueryBuilder<C extends XdsRegistryStoredGetAllQuery, B extends XdsRegistryStoredGetAllQuery.XdsRegistryStoredGetAllQueryBuilder<C, B>>
			extends XdsStoredQuery.XdsStoredQueryBuilder<C, B> {
	}

	@NonNull
	private Identificator patientID;
	/** association statuses */
	@Singular
	private List<AvailabilityStatus> associationStatuses;
	/** confidentiality codes */
	@Singular
	private List<Code> confidentialityCodes;
	/** document entry types */
	@Singular
	private List<DocumentEntryType> documentEntryTypes;
	/** format codes */
	@Singular
	private List<Code> formatCodes;
	/** status of documents */
	@Singular
	private List<AvailabilityStatus> statusDocuments;
	/** status of folders */
	@Singular
	private List<AvailabilityStatus> statusFolders;
	/** target community IDs */
	@Singular
	private List<String> targetCommunityIds;

	@Override
	public StoredQuery getIpfQuery() {
		var query = new GetAllQuery();
		query.setHomeCommunityId(getHomeCommunityId());
		query.setMetadataLevel(getMetadataLevel());
		query.setAssociationStatuses(associationStatuses);
		query.setConfidentialityCodes(XdsMetadataUtil.convertEhcCodeToQueryListCode(confidentialityCodes));
		query.setDocumentEntryTypes(documentEntryTypes);
		query.setFormatCodes(XdsMetadataUtil.convertEhcCodeToCode(formatCodes));
		query.setPatientId(XdsMetadataUtil.convertEhcIdentificator(this.getPatientID()));
		query.setStatusDocuments(statusDocuments);
		query.setStatusFolders(statusFolders);
		query.setTargetCommunityIds(targetCommunityIds);
		return query;
	}

}
