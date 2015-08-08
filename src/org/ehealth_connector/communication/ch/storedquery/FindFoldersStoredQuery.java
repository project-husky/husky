package org.ehealth_connector.communication.ch.storedquery;

import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.XdsUtil;
import org.ehealth_connector.communication.ch.enums.AvailabilityStatus;
import org.openhealthtools.ihe.xds.consumer.storedquery.MalformedStoredQueryException;
import org.openhealthtools.ihe.xds.metadata.AvailabilityStatusType;

public class FindFoldersStoredQuery extends AbstractStoredQuery {

	public FindFoldersStoredQuery(Identificator patientId, AvailabilityStatus status) throws MalformedStoredQueryException {
		ohtStoredQuery = new org.openhealthtools.ihe.xds.consumer.storedquery.FindFoldersStoredQuery(XdsUtil.convertIdentificator(patientId), new AvailabilityStatusType[]{status.getAsOhtAvailabilityStatusType()});
	}
}
