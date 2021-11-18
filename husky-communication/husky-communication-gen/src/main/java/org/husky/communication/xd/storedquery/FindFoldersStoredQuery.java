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
package org.husky.communication.xd.storedquery;

import java.util.List;

import org.husky.common.model.Identificator;
import org.husky.common.utils.XdsMetadataUtil;
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
