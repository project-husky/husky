package org.ehealth_connector.communication.xd.storedquery;

import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.XdsUtil;
import org.ehealth_connector.communication.ch.enums.AvailabilityStatus;
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
	public FindFoldersStoredQuery(Identificator patientId, AvailabilityStatus status) {
		try {
			ohtStoredQuery = new org.openhealthtools.ihe.xds.consumer.storedquery.FindFoldersStoredQuery(
					XdsUtil.convertEhcIdentificator(patientId),
					new AvailabilityStatusType[] { status.getAsOhtAvailabilityStatusType() });
		} catch (MalformedStoredQueryException e) {
			e.printStackTrace();
		}
	}
}
