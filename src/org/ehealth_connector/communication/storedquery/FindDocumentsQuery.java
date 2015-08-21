package org.ehealth_connector.communication.storedquery;

import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.XdsUtil;
import org.ehealth_connector.communication.ch.enums.AvailabilityStatus;
import org.openhealthtools.ihe.common.hl7v2.XCN;
import org.openhealthtools.ihe.xds.consumer.storedquery.MalformedStoredQueryException;
import org.openhealthtools.ihe.xds.consumer.storedquery.StoredQuery;
import org.openhealthtools.ihe.xds.metadata.AvailabilityStatusType;

public class FindDocumentsQuery implements StoredQueryInterface {
	private org.openhealthtools.ihe.xds.consumer.storedquery.FindDocumentsQuery ohtStoredQuery;

	public FindDocumentsQuery(Identificator patientId, AvailabilityStatus status) throws MalformedStoredQueryException {
		ohtStoredQuery = new org.openhealthtools.ihe.xds.consumer.storedquery.FindDocumentsQuery(
				XdsUtil.convertIdentificator(patientId), new AvailabilityStatusType[]{status.getAsOhtAvailabilityStatusType()});
	}

	public FindDocumentsQuery(
			Identificator patientId,
			Code[] classCodes,
			org.ehealth_connector.communication.storedquery.DateTimeRange[] dateTimeRanges,
			Code[] practiceSettingCodes,
			Code[] healthCareFacilityCodes,
			Code[] confidentialityCodes,
			Code[] formatCodes,
			XCN authorPerson,
			AvailabilityStatus status) throws MalformedStoredQueryException {

		ohtStoredQuery = new org.openhealthtools.ihe.xds.consumer.storedquery.FindDocumentsQuery(
				XdsUtil.convertIdentificator(patientId),
				XdsUtil.convertEhcCodeToCodedMetadataType(classCodes),
				XdsUtil.convertEhcDateTimeRangeToOht(dateTimeRanges), 
				XdsUtil.convertEhcCodeToCodedMetadataType(practiceSettingCodes), 
				XdsUtil.convertEhcCodeToCodedMetadataType(healthCareFacilityCodes),
				null, //Event code is currently not used in Switzerland
				XdsUtil.convertEhcCodeToCodedMetadataType(confidentialityCodes), 
				XdsUtil.convertEhcCodeToCodedMetadataType(formatCodes), 
				authorPerson, 
				new AvailabilityStatusType[]{status.getAsOhtAvailabilityStatusType()});
	}
	
	public void addConfidentialityCodes (Code[] confidentialityCodes) throws MalformedStoredQueryException {
		ohtStoredQuery.addConfidentialityCodes(XdsUtil.convertEhcCodeToCodedMetadataType(confidentialityCodes));
	}

	@Override
	public StoredQuery getOhtStoredQuery() {
		return (StoredQuery) ohtStoredQuery;
	}
}
