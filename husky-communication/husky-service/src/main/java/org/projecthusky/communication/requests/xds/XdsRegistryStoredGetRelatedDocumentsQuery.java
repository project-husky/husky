/**
 * Author: Roeland Luykx, RALY GmbH
 * 
 * Copyright (c) 2025+ by AD Swiss Net AG
 */
package org.projecthusky.communication.requests.xds;

import java.util.List;

import org.openehealth.ipf.commons.ihe.xds.core.metadata.AssociationType;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AvailabilityStatus;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.DocumentEntryType;
import org.openehealth.ipf.commons.ihe.xds.core.requests.query.GetRelatedDocumentsQuery;
import org.openehealth.ipf.commons.ihe.xds.core.requests.query.StoredQuery;

import lombok.Getter;
import lombok.Singular;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * This class is designed to contain all possible search parameters for finding
 * related documents with the webservice. Parameters are optional (except
 * patientId and destination), only those which are set will be used by the
 * webservice.<br/>
 */
@Getter
@SuperBuilder
@ToString
public class XdsRegistryStoredGetRelatedDocumentsQuery extends XdsStoredQuery {

	/** list of association statuses */
	@Singular
	private List<AvailabilityStatus> associationStatuses;
	/** list of association types */
	@Singular
	private List<AssociationType> associationTypes;
	/** list of document entry types */
	@Singular
	private List<DocumentEntryType> documentEntryTypes;
	/** uniqueId of the document to retrieve related documents for */
	private String uniqueId;
	/** uuid of the document to retrieve related documents for */
	private String uuid;

	public static abstract class XdsRegistryStoredGetRelatedDocumentsQueryBuilder<C extends XdsRegistryStoredGetRelatedDocumentsQuery, B extends XdsRegistryStoredGetRelatedDocumentsQuery.XdsRegistryStoredGetRelatedDocumentsQueryBuilder<C, B>>
			extends XdsStoredQuery.XdsStoredQueryBuilder<C, B> {
	}

	@Override
	public StoredQuery getIpfQuery() {
		var query = new GetRelatedDocumentsQuery();
		query.setAssociationStatuses(associationStatuses);
		query.setAssociationTypes(associationTypes);
		query.setDocumentEntryTypes(documentEntryTypes);
		query.setHomeCommunityId(getHomeCommunityId());
		query.setMetadataLevel(getMetadataLevel());
		query.setUniqueId(uniqueId);
		query.setUuid(uuid);
		return query;
	}

}
