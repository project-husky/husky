/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */
package org.ehealth_connector.communication.xd.storedquery;

import java.util.List;

import org.ehealth_connector.common.model.Identificator;
import org.ehealth_connector.common.utils.XdsMetadataUtil;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AvailabilityStatus;
import org.openehealth.ipf.commons.ihe.xds.core.requests.query.FindFoldersQuery;

/**
 * Represents a query to find XDS folders
 */
public class FindFoldersStoredQuery extends AbstractStoredQuery {

	/**
	 * Construct a find folders stored query.
	 *
	 * @param patientId ID of the patient (required)
	 * @param status    status the availability status of the document (required)
	 */
	public FindFoldersStoredQuery(Identificator patientId, AvailabilityStatus status) {
		var findFoldersQuery = new FindFoldersQuery();
		findFoldersQuery.setPatientId(XdsMetadataUtil.convertEhcIdentificator(patientId));
		findFoldersQuery.setStatus(List.of(status));

		setIpfStoredQuery(findFoldersQuery);
	}
}
