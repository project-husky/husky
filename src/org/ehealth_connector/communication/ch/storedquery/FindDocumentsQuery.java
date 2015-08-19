package org.ehealth_connector.communication.ch.storedquery;

import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.XdsUtil;
import org.ehealth_connector.communication.ch.enums.AvailabilityStatus;
import org.ehealth_connector.communication.ch.enums.ConfidentialityCode;
import org.ehealth_connector.communication.ch.enums.HealthcareFacilityTypeCode;
import org.openhealthtools.ihe.common.hl7v2.XCN;
import org.openhealthtools.ihe.xds.consumer.query.DateTimeRange;
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
			org.ehealth_connector.communication.ch.enums.ClassCode[] classCodes,
			org.ehealth_connector.communication.ch.storedquery.DateTimeRange[] dateTimeRanges,
			org.ehealth_connector.communication.ch.enums.PracticeSettingCode[] practiceSettingCodes,
			HealthcareFacilityTypeCode[] healthCareFacilityCodes,
			
			//TODO Check, what happend to the swiss event code
			//org.ehealth_connector.communication.ch.enums.EventCode[] eventCodeList,
			org.ehealth_connector.communication.ch.enums.ConfidentialityCode[] confidentialityCodes,
			org.ehealth_connector.communication.ch.enums.FormatCode[] formatCodes,
			XCN authorPerson,
			AvailabilityStatus status) throws MalformedStoredQueryException {

		ohtStoredQuery = new org.openhealthtools.ihe.xds.consumer.storedquery.FindDocumentsQuery(
				XdsUtil.convertIdentificator(patientId),
				XdsUtil.convertEhcEnumToCodedMetadataType(classCodes),
				XdsUtil.convertEhcDateTimeRangeToOht(dateTimeRanges), 
				XdsUtil.convertEhcEnumToCodedMetadataType(practiceSettingCodes), 
				XdsUtil.convertEhcEnumToCodedMetadataType(healthCareFacilityCodes),
				null, 
				XdsUtil.convertEhcEnumToCodedMetadataType(confidentialityCodes), 
				XdsUtil.convertEhcEnumToCodedMetadataType(formatCodes), 
				authorPerson, 
				new AvailabilityStatusType[]{status.getAsOhtAvailabilityStatusType()});
	}
	
	//TODO Evtl. Methode für AddEventCodes vorsehen
	
	public void addConfidentialityCodes (ConfidentialityCode[] confidentialityCodes) throws MalformedStoredQueryException {
		ohtStoredQuery.addConfidentialityCodes(XdsUtil.convertEhcEnumToCodedMetadataType(confidentialityCodes));
	}

	@Override
	public StoredQuery getOhtStoredQuery() {
		return (StoredQuery) ohtStoredQuery;
	}
}
