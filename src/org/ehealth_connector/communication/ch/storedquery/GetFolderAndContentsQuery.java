package org.ehealth_connector.communication.ch.storedquery;

import org.ehealth_connector.common.XdsUtil;
import org.ehealth_connector.communication.ch.enums.ConfidentialityCode;
import org.ehealth_connector.communication.ch.enums.FormatCode;
import org.openhealthtools.ihe.xds.consumer.storedquery.MalformedStoredQueryException;
import org.openhealthtools.ihe.xds.consumer.storedquery.ObjectType;
import org.openhealthtools.ihe.xds.consumer.storedquery.StoredQuery;

public class GetFolderAndContentsQuery implements StoredQueryInterface {
	org.openhealthtools.ihe.xds.consumer.storedquery.GetFolderAndContentsQuery ohtStoredQuery;
	
	public GetFolderAndContentsQuery (String folderId, boolean isUUID, FormatCode[] formatCodes, ConfidentialityCode[] confidentialityCodes) throws MalformedStoredQueryException {
		ohtStoredQuery = new org.openhealthtools.ihe.xds.consumer.storedquery.GetFolderAndContentsQuery(folderId, isUUID, XdsUtil.convertEhcEnumToCodedMetadataType(formatCodes), XdsUtil.convertEhcEnumToCodedMetadataType(confidentialityCodes));
	}
	
	public GetFolderAndContentsQuery (String folderId, boolean isUUID, FormatCode[] formatCodes, ConfidentialityCode[] confidentialityCodes, String homeCommunityId) throws MalformedStoredQueryException {
		ohtStoredQuery = new org.openhealthtools.ihe.xds.consumer.storedquery.GetFolderAndContentsQuery(folderId, isUUID, XdsUtil.convertEhcEnumToCodedMetadataType(formatCodes), XdsUtil.convertEhcEnumToCodedMetadataType(confidentialityCodes), homeCommunityId);
	}
	
	public GetFolderAndContentsQuery (String folderId, boolean isUUID, FormatCode[] formatCodes, ConfidentialityCode[] confidentialityCodes, String homeCommunityId, ObjectType objectType) throws MalformedStoredQueryException {
		ohtStoredQuery = new org.openhealthtools.ihe.xds.consumer.storedquery.GetFolderAndContentsQuery(folderId, isUUID, XdsUtil.convertEhcEnumToCodedMetadataType(formatCodes), XdsUtil.convertEhcEnumToCodedMetadataType(confidentialityCodes), homeCommunityId, objectType);
	}
	
	public void addConfidentialityCodes(ConfidentialityCode[] confidentialityCodes) throws MalformedStoredQueryException {
		ohtStoredQuery.addConfidentialityCodes(XdsUtil.convertEhcEnumToCodedMetadataType(confidentialityCodes));
	}

	@Override
	public StoredQuery getOhtStoredQuery() {
		return (StoredQuery) ohtStoredQuery;
	}
}
