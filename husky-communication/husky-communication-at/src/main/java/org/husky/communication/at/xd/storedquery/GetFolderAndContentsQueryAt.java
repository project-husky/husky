/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.communication.at.xd.storedquery;

import java.util.LinkedList;
import java.util.List;

import org.husky.common.at.enums.ConfidentialityCode;
import org.husky.common.at.enums.FormatCode;
import org.husky.common.model.Code;
import org.husky.common.utils.XdsMetadataUtil;
import org.husky.communication.xd.storedquery.GetFolderAndContentsQuery;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.DocumentEntryType;

/**
 * Represents a query to get folders and its contents (associations, documents)
 * from an XDS Registry. This class uses only enums for XDS metadata which are
 * specified by eHealth Suisse for the usage in Switzerland.
 */
public class GetFolderAndContentsQueryAt extends GetFolderAndContentsQuery {

	/**
	 * Constructor. All arrays of codes are interpreted with as a disjunction (OR -
	 * semantics).
	 *
	 * @param folderId             id of the folder (either uniqueId or entryUUID)
	 *                             (required)
	 * @param isUUID               set to true if folderID is the entryUUID
	 *                             (internal registry identifier) of the folder and
	 *                             set to false if it is the uniqueID (external to
	 *                             registry) of the folder. In most user cases, this
	 *                             should be set to false
	 * @param formatCodes          array of formatCodes to query for (can be null)
	 * @param confidentialityCodes array of confidentiality codes to query for (can
	 *                             be null)
	 */
	public GetFolderAndContentsQueryAt(String folderId, boolean isUUID, FormatCode[] formatCodes,
			ConfidentialityCode[] confidentialityCodes) {
		super(folderId, isUUID, null, null);
		
		var ipfQuery = (org.openehealth.ipf.commons.ihe.xds.core.requests.query.GetFolderAndContentsQuery) getIpfQuery();
		
		ipfQuery.setFormatCodes(XdsMetadataUtil.convertEhcCodeToCode(formatCodes));
		ipfQuery.setConfidentialityCodes(XdsMetadataUtil.convertEhcCodeToQueryListCode(confidentialityCodes));
	}

	/**
	 * Constructor that allows for the addition of a homeCommunityId to the query to
	 * support the XCA (Cross Community Access) profile extension of this query.
	 *
	 * @param folderId             id of the folder (either uniqueId or entryUUID)
	 *                             (required)
	 * @param isUUID               set to true if folderID is the entryUUID
	 *                             (internal registry identifier) of the folder and
	 *                             set to false if it is the uniqueID (external to
	 *                             registry) of the folder. In most user cases, this
	 *                             should be set to false
	 * @param formatCodes          array of formatCodes to query for (can be null)
	 * @param confidentialityCodes array of confidentiality codes to query for (can
	 *                             be null)
	 * @param homeCommunityId      this is the id of the home community as specified
	 *                             by the XCA profile. Value may be null or empty,
	 *                             in which case it is not added to the query.
	 */
	public GetFolderAndContentsQueryAt(String folderId, boolean isUUID, FormatCode[] formatCodes,
			ConfidentialityCode[] confidentialityCodes, String homeCommunityId) {
		super(folderId, isUUID, null, null, homeCommunityId);

		var ipfQuery = (org.openehealth.ipf.commons.ihe.xds.core.requests.query.GetFolderAndContentsQuery) getIpfQuery();

		ipfQuery.setFormatCodes(XdsMetadataUtil.convertEhcCodeToCode(formatCodes));
		ipfQuery.setConfidentialityCodes(XdsMetadataUtil.convertEhcCodeToQueryListCode(confidentialityCodes));

	}

	/**
	 * Constructor that allows for the addition of a homeCommunityId to the query to
	 * support the XCA profile extension of this query.
	 *
	 * @param folderId             id of the folder (either uniqueId or entryUUID)
	 *                             (required)
	 * @param isUUID               set to true if folderID is the entryUUID
	 *                             (internal registry identifier) of the folder and
	 *                             set to false if it is the uniqueID (external to
	 *                             registry) of the folder. In most user cases, this
	 *                             should be set to false
	 * @param formatCodes          array of formatCodes to query for (can be null)
	 * @param confidentialityCodes array of confidentiality codes to query for (can
	 *                             be null)
	 * @param homeCommunityId      this is the id of the home community as specified
	 *                             by the XCA profile. Value may be null or empty,
	 *                             in which case it is not added to the query.
	 * @param objectType           for the OnDemand document feature. Tells whether
	 *                             you want static docs, on demand docs, or both
	 */
	public GetFolderAndContentsQueryAt(String folderId, boolean isUUID, FormatCode[] formatCodes,
			ConfidentialityCode[] confidentialityCodes, String homeCommunityId, DocumentEntryType objectType) {
		super(folderId, isUUID, null, null, homeCommunityId, objectType);

		var ipfQuery = (org.openehealth.ipf.commons.ihe.xds.core.requests.query.GetFolderAndContentsQuery) getIpfQuery();

		ipfQuery.setFormatCodes(XdsMetadataUtil.convertEhcCodeToCode(formatCodes));
		ipfQuery.setConfidentialityCodes(XdsMetadataUtil.convertEhcCodeToQueryListCode(confidentialityCodes));

	}

	/**
	 * Adds an additional disjunctive clause of confidentiality codes to the query.
	 * Per IHE 2008-2009 ITI CP 228, codes with in the parameter will be interpreted
	 * with OR semantics. The resultant disjunctive clause will be AND-ed together
	 * with any confidentialityCode clauses previously added. Calling this method
	 * sequentially will result in the AND-ing of multiple clauses.
	 *
	 * @param confidentialityCodes array of confidentialityCodes, interpreted as a
	 *                             disjunctive clause in which each
	 *                             confidentialityCodes[i] will be a literal of that
	 *                             clause, to add to the query.
	 */
	public void addConfidentialityCodes(ConfidentialityCode[] confidentialityCodes) {
		if(confidentialityCodes == null) {
			return;
		}
		
		List<Code> confidentialityCodeList = new LinkedList<>();

		for (org.husky.common.at.enums.ConfidentialityCode confCode : confidentialityCodes) {
			if(confCode != null) {
				confidentialityCodeList.add(confCode.getCode());
			}
		}

		super.addConfidentialityCodes(confidentialityCodeList);
	}

}
