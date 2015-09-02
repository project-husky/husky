package org.ehealth_connector.communication.storedquery;

import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.XdsUtil;
import org.openhealthtools.ihe.xds.consumer.storedquery.MalformedStoredQueryException;
import org.openhealthtools.ihe.xds.consumer.storedquery.ObjectType;
import org.openhealthtools.ihe.xds.consumer.storedquery.StoredQuery;

/**
 * Represents a query to get folders and its contents (associations, documents) from an XDS Registry.
 */
public class GetFolderAndContentsQuery implements StoredQueryInterface {
	org.openhealthtools.ihe.xds.consumer.storedquery.GetFolderAndContentsQuery ohtStoredQuery;
	
	/**
	 * Constructor. All arrays of codes are interpreted with as a disjunction (OR - semantics).
	 * 
	 * @param folderId id of the folder (either uniqueId or entryUUID) (required)
	 * @param isUUID set to true if folderID is the entryUUID (internal registry identifier) of the folder and set to false if it is the uniqueID (external to registry) of the folder. In most user cases, this should be set to false
	 * @param formatCodes array of formatCodes to query for (can be null)
	 * @param confidentialityCodes array of confidentiality codes to query for (can be null)
	 * @throws MalformedStoredQueryException
	 */
	public GetFolderAndContentsQuery (String folderId, boolean isUUID, Code[] formatCodes, Code[] confidentialityCodes) throws MalformedStoredQueryException {
		ohtStoredQuery = new org.openhealthtools.ihe.xds.consumer.storedquery.GetFolderAndContentsQuery(folderId, isUUID, XdsUtil.convertEhcCodeToCodedMetadataType(formatCodes), XdsUtil.convertEhcCodeToCodedMetadataType(confidentialityCodes));
	}
	
	/**
	 * Constructor that allows for the addition of a homeCommunityId to the query to support the XCA (Cross Community Access) profile extension of this query.
	 * 
	 * @param folderId id of the folder (either uniqueId or entryUUID) (required)
	 * @param isUUID set to true if folderID is the entryUUID (internal registry identifier) of the folder and set to false if it is the uniqueID (external to registry) of the folder. In most user cases, this should be set to false
	 * @param formatCodes array of formatCodes to query for (can be null)
	 * @param confidentialityCodes array of confidentiality codes to query for (can be null)
	 * @param homeCommunityId  this is the id of the home community as specified by the XCA profile. Value may be null or empty, in which case it is not added to the query.
	 * @throws MalformedStoredQueryException
	 */
	public GetFolderAndContentsQuery (String folderId, boolean isUUID, Code[] formatCodes, Code[] confidentialityCodes, String homeCommunityId) throws MalformedStoredQueryException {
		ohtStoredQuery = new org.openhealthtools.ihe.xds.consumer.storedquery.GetFolderAndContentsQuery(folderId, isUUID, XdsUtil.convertEhcCodeToCodedMetadataType(formatCodes), XdsUtil.convertEhcCodeToCodedMetadataType(confidentialityCodes), homeCommunityId);
	}
	
	/**
	 * Constructor that allows for the addition of a homeCommunityId to the query to support the XCA profile extension of this query.
	 * 
	 * @param folderId id of the folder (either uniqueId or entryUUID) (required)
	 * @param isUUID set to true if folderID is the entryUUID (internal registry identifier) of the folder and set to false if it is the uniqueID (external to registry) of the folder. In most user cases, this should be set to false
	 * @param formatCodes array of formatCodes to query for (can be null)
	 * @param confidentialityCodes array of confidentiality codes to query for (can be null)
	 * @param homeCommunityId  this is the id of the home community as specified by the XCA profile. Value may be null or empty, in which case it is not added to the query.
	 * @param objectType  for the OnDemand document feature. Tells whether you want static docs, on demand docs, or both
	 * @throws MalformedStoredQueryException
	 */
	public GetFolderAndContentsQuery (String folderId, boolean isUUID, Code[] formatCodes, Code[] confidentialityCodes, String homeCommunityId, ObjectType objectType) throws MalformedStoredQueryException {
		ohtStoredQuery = new org.openhealthtools.ihe.xds.consumer.storedquery.GetFolderAndContentsQuery(folderId, isUUID, XdsUtil.convertEhcCodeToCodedMetadataType(formatCodes), XdsUtil.convertEhcCodeToCodedMetadataType(confidentialityCodes), homeCommunityId, objectType);
	}
	
	/**
	 * Adds an additional disjunctive clause of confidentiality codes to the query. Per IHE 2008-2009 ITI CP 228, codes with in the parameter will be interpreted with OR semantics. The resultant disjunctive clause will be AND-ed together with any confidentialityCode clauses previously added. Calling this method sequentially will result in the AND-ing of multiple clauses.
	 * 
	 * @param confidentialityCodes  array of confidentialityCodes, interpreted as a disjunctive clause in which each confidentialityCodes[i] will be a literal of that clause, to add to the query.
	 * @throws MalformedStoredQueryException
	 */
	public void addConfidentialityCodes(Code[] confidentialityCodes) throws MalformedStoredQueryException {
		ohtStoredQuery.addConfidentialityCodes(XdsUtil.convertEhcCodeToCodedMetadataType(confidentialityCodes));
	}

	/* 
	 * Gets the OHT StoredQuery object, which is being wrapped by this class
	 * 
	 * @see org.ehealth_connector.communication.storedquery.StoredQueryInterface#getOhtStoredQuery()
	 * @returns the OHT StoredQuery
	 */
	@Override
	public StoredQuery getOhtStoredQuery() {
		return (StoredQuery) ohtStoredQuery;
	}
}
