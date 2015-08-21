package org.ehealth_connector.communication.storedquery;

import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.XdsUtil;
import org.openhealthtools.ihe.xds.consumer.storedquery.MalformedStoredQueryException;
import org.openhealthtools.ihe.xds.consumer.storedquery.ObjectType;
import org.openhealthtools.ihe.xds.consumer.storedquery.StoredQuery;

public class GetFolderAndContentsQuery implements StoredQueryInterface {
	org.openhealthtools.ihe.xds.consumer.storedquery.GetFolderAndContentsQuery ohtStoredQuery;
	
	public GetFolderAndContentsQuery (String folderId, boolean isUUID, Code[] formatCodes, Code[] confidentialityCodes) throws MalformedStoredQueryException {
		ohtStoredQuery = new org.openhealthtools.ihe.xds.consumer.storedquery.GetFolderAndContentsQuery(folderId, isUUID, XdsUtil.convertEhcCodeToCodedMetadataType(formatCodes), XdsUtil.convertEhcCodeToCodedMetadataType(confidentialityCodes));
	}
	
	public GetFolderAndContentsQuery (String folderId, boolean isUUID, Code[] formatCodes, Code[] confidentialityCodes, String homeCommunityId) throws MalformedStoredQueryException {
		ohtStoredQuery = new org.openhealthtools.ihe.xds.consumer.storedquery.GetFolderAndContentsQuery(folderId, isUUID, XdsUtil.convertEhcCodeToCodedMetadataType(formatCodes), XdsUtil.convertEhcCodeToCodedMetadataType(confidentialityCodes), homeCommunityId);
	}
	
	public GetFolderAndContentsQuery (String folderId, boolean isUUID, Code[] formatCodes, Code[] confidentialityCodes, String homeCommunityId, ObjectType objectType) throws MalformedStoredQueryException {
		ohtStoredQuery = new org.openhealthtools.ihe.xds.consumer.storedquery.GetFolderAndContentsQuery(folderId, isUUID, XdsUtil.convertEhcCodeToCodedMetadataType(formatCodes), XdsUtil.convertEhcCodeToCodedMetadataType(confidentialityCodes), homeCommunityId, objectType);
	}
	
	public void addConfidentialityCodes(Code[] confidentialityCodes) throws MalformedStoredQueryException {
		ohtStoredQuery.addConfidentialityCodes(XdsUtil.convertEhcCodeToCodedMetadataType(confidentialityCodes));
	}

	@Override
	public StoredQuery getOhtStoredQuery() {
		return (StoredQuery) ohtStoredQuery;
	}
}
