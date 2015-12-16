/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2015
 *
 *******************************************************************************/
package org.ehealth_connector.communication.xd.storedquery;

import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.utils.XdsMetadataUtil;
import org.openhealthtools.ihe.xds.consumer.storedquery.MalformedStoredQueryException;
import org.openhealthtools.ihe.xds.metadata.AvailabilityStatusType;

/**
 * Represents a query to find XDS folders
 */
public class FindFoldersStoredQuery extends AbstractStoredQuery {

	/**
	 * Construct a find folders stored query.
	 * 
	 * @param patientId
	 *            ID of the patient (required)
	 * @param status
	 *            status the availability status of the document (required)
	 */
	public FindFoldersStoredQuery(Identificator patientId, AvailabilityStatusType status) {
		try {
			setOhtStoredQuery(
					new org.openhealthtools.ihe.xds.consumer.storedquery.FindFoldersStoredQuery(
							XdsMetadataUtil.convertEhcIdentificator(patientId),
							new AvailabilityStatusType[] { status }));
		} catch (final MalformedStoredQueryException e) {
			e.printStackTrace();
		}
	}
}
