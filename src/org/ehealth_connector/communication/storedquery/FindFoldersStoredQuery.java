package org.ehealth_connector.communication.storedquery;

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
	 * 
	 * @param patientId ID of the patient (required)
	 * @param status status the availability status of the document (required)
	 * @throws MalformedStoredQueryException
	 */
	public FindFoldersStoredQuery(Identificator patientId, AvailabilityStatus status) throws MalformedStoredQueryException {
		ohtStoredQuery = new org.openhealthtools.ihe.xds.consumer.storedquery.FindFoldersStoredQuery(XdsUtil.convertEhcIdentificator(patientId), new AvailabilityStatusType[]{status.getAsOhtAvailabilityStatusType()});
	}
}
