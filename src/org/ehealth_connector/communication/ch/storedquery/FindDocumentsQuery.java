package org.ehealth_connector.communication.ch.storedquery;

import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.XdsUtil;
import org.ehealth_connector.communication.ch.enums.AvailabilityStatus;
import org.ehealth_connector.communication.ch.enums.ConfidentialityCode;
import org.ehealth_connector.communication.ch.enums.HealthcareFacilityTypeCode;
import org.ehealth_connector.communication.storedquery.StoredQueryInterface;
import org.openhealthtools.ihe.common.hl7v2.XCN;
import org.openhealthtools.ihe.xds.consumer.storedquery.MalformedStoredQueryException;
import org.openhealthtools.ihe.xds.consumer.storedquery.StoredQuery;
import org.openhealthtools.ihe.xds.metadata.AvailabilityStatusType;

/**
 * Represents a query to find documents in an XDS Registry (XDS FindDocumentsQuery). This class uses only enums for XDS metadata which are specified by eHealth Suisse for the usage in Switzerland. 
 */
public class FindDocumentsQuery implements StoredQueryInterface {
	private org.openhealthtools.ihe.xds.consumer.storedquery.FindDocumentsQuery ohtStoredQuery;

	/**
	 * Constructs a FindDocuments Query
	 * 
	 * @param patientId ID of the patient
	 * @param status Status of the document
	 * @throws MalformedStoredQueryException 
	 */
	public FindDocumentsQuery(Identificator patientId, AvailabilityStatus status) throws MalformedStoredQueryException {
		ohtStoredQuery = new org.openhealthtools.ihe.xds.consumer.storedquery.FindDocumentsQuery(
				XdsUtil.convertEhcIdentificator(patientId), new AvailabilityStatusType[]{status.getAsOhtAvailabilityStatusType()});
	}

	/**
	 * Constructs a FindDocuments Query
	 * 
	 * @param patientId ID of the patient (required)
	 * @param classCodes an array of enums, which classify the document (can be null)
	 * @param dateTimeRanges an array of DateTimeRange objects (can be null)
	 * @param practiceSettingCodes an array of enums, which classify the institution, where the document was created (can be null)
	 * @param healthCareFacilityCodes an array of enums, which classify the type of healthcare facility, where the document was created (can be null)
	 * @param confidentialityCodes an array of enums, which classify the confidentiality of the document (can be null)
	 * @param formatCodes an array of enums, which classify the format of the document (can be null)
	 * @param authorPerson information about the author of the document (can be null)
	 * @param status the availability status of the document (required)
	 */
	public FindDocumentsQuery(
			Identificator patientId,
			org.ehealth_connector.communication.ch.enums.ClassCode[] classCodes,
			org.ehealth_connector.communication.storedquery.DateTimeRange[] dateTimeRanges,
			org.ehealth_connector.communication.ch.enums.PracticeSettingCode[] practiceSettingCodes,
			HealthcareFacilityTypeCode[] healthCareFacilityCodes,
			org.ehealth_connector.communication.ch.enums.ConfidentialityCode[] confidentialityCodes,
			org.ehealth_connector.communication.ch.enums.FormatCode[] formatCodes,
			XCN authorPerson,
			AvailabilityStatus status) throws MalformedStoredQueryException {

		ohtStoredQuery = new org.openhealthtools.ihe.xds.consumer.storedquery.FindDocumentsQuery(
				XdsUtil.convertEhcIdentificator(patientId),
				XdsUtil.convertEhcEnumToCodedMetadataType(classCodes),
				XdsUtil.convertEhcDateTimeRange(dateTimeRanges), 
				XdsUtil.convertEhcEnumToCodedMetadataType(practiceSettingCodes), 
				XdsUtil.convertEhcEnumToCodedMetadataType(healthCareFacilityCodes),
				null, //Event Code is currently not used in Switzerland
				XdsUtil.convertEhcEnumToCodedMetadataType(confidentialityCodes), 
				XdsUtil.convertEhcEnumToCodedMetadataType(formatCodes), 
				authorPerson, 
				new AvailabilityStatusType[]{status.getAsOhtAvailabilityStatusType()});
	}

	/**
	 * Adds an additional disjunctive clause of confidentiality codes to the query. Per IHE 2008-2009 ITI CP 228, codes with in the parameter will be interpreted with OR semantics. The resultant disjunctive clause will be AND-ed together with any confidentialityCode clauses previously added. Calling this method sequentially will result in the AND-ing of multiple clauses.
	 * 
	 * @param confidentialityCodes array of confidentiality codes
	 * @throws MalformedStoredQueryException
	 */
	public void addConfidentialityCodes (ConfidentialityCode[] confidentialityCodes) throws MalformedStoredQueryException {
		ohtStoredQuery.addConfidentialityCodes(XdsUtil.convertEhcEnumToCodedMetadataType(confidentialityCodes));
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
