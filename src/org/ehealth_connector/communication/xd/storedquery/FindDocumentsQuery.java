package org.ehealth_connector.communication.xd.storedquery;

import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.XdsUtil;
import org.ehealth_connector.communication.ch.enums.AvailabilityStatus;
import org.openhealthtools.ihe.common.hl7v2.XCN;
import org.openhealthtools.ihe.xds.consumer.storedquery.MalformedStoredQueryException;
import org.openhealthtools.ihe.xds.consumer.storedquery.StoredQuery;
import org.openhealthtools.ihe.xds.metadata.AvailabilityStatusType;

/**
 * Represents a query to find documents in an XDS Registry (XDS
 * FindDocumentsQuery)
 */
public class FindDocumentsQuery implements StoredQueryInterface {
	private org.openhealthtools.ihe.xds.consumer.storedquery.FindDocumentsQuery ohtStoredQuery;

	/**
	 * Constructs a FindDocuments Query
	 *
	 * @param patientId
	 *            ID of the patient
	 * @param status
	 *            Status of the document
	 */
	public FindDocumentsQuery(Identificator patientId, AvailabilityStatus status) {
		try {
			ohtStoredQuery = new org.openhealthtools.ihe.xds.consumer.storedquery.FindDocumentsQuery(
					XdsUtil.convertEhcIdentificator(patientId),
					new AvailabilityStatusType[] { status.getAsOhtAvailabilityStatusType() });
		} catch (MalformedStoredQueryException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Constructs a FindDocuments Query
	 *
	 * @param patientId
	 *            ID of the patient (required)
	 * @param classCodes
	 *            an array of codes, which classify the document (can be null)
	 * @param dateTimeRanges
	 *            an array of DateTimeRange objects (can be null)
	 * @param practiceSettingCodes
	 *            an array of codes, which classify the institution, where the
	 *            document was created (can be null)
	 * @param healthCareFacilityCodes
	 *            an array of codes, which classify the type of healthcare
	 *            facility, where the document was created (can be null)
	 * @param confidentialityCodes
	 *            an array of codes, which classify the confidentiality of the
	 *            document (can be null)
	 * @param formatCodes
	 *            an array of codes, which classify the format of the document
	 *            (can be null)
	 * @param authorPerson
	 *            information about the author of the document (can be null)
	 * @param status
	 *            the availability status of the document (required)
	 */
	public FindDocumentsQuery(Identificator patientId, Code[] classCodes,
			org.ehealth_connector.communication.xd.storedquery.DateTimeRange[] dateTimeRanges,
			Code[] practiceSettingCodes, Code[] healthCareFacilityCodes,
			Code[] confidentialityCodes, Code[] formatCodes, XCN authorPerson,
			AvailabilityStatus status) {

		try {
			ohtStoredQuery = new org.openhealthtools.ihe.xds.consumer.storedquery.FindDocumentsQuery(
					XdsUtil.convertEhcIdentificator(patientId),
					XdsUtil.convertEhcCodeToCodedMetadataType(classCodes),
					XdsUtil.convertEhcDateTimeRange(dateTimeRanges),
					XdsUtil.convertEhcCodeToCodedMetadataType(practiceSettingCodes),
					XdsUtil.convertEhcCodeToCodedMetadataType(healthCareFacilityCodes),
					null, // Event code is currently not used in Switzerland
					XdsUtil.convertEhcCodeToCodedMetadataType(confidentialityCodes),
					XdsUtil.convertEhcCodeToCodedMetadataType(formatCodes), authorPerson,
					new AvailabilityStatusType[] { status.getAsOhtAvailabilityStatusType() });
		} catch (MalformedStoredQueryException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Adds an additional disjunctive clause of confidentiality codes to the
	 * query. Per IHE 2008-2009 ITI CP 228, codes with in the parameter will be
	 * interpreted with OR semantics. The resultant disjunctive clause will be
	 * AND-ed together with any confidentialityCode clauses previously added.
	 * Calling this method sequentially will result in the AND-ing of multiple
	 * clauses.
	 *
	 * @param confidentialityCodes
	 *            array of confidentiality codes
	 */
	public void addConfidentialityCodes(Code[] confidentialityCodes) {
		try {
			ohtStoredQuery.addConfidentialityCodes(XdsUtil
					.convertEhcCodeToCodedMetadataType(confidentialityCodes));
		} catch (MalformedStoredQueryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Gets the OHT StoredQuery object, which is being wrapped by this class
	 * 
	 * @see org.ehealth_connector.communication.storedquery.StoredQueryInterface#
	 *      getOhtStoredQuery()
	 * 
	 * @returns the OHT StoredQuery
	 */
	@Override
	public StoredQuery getOhtStoredQuery() {
		return ohtStoredQuery;
	}
}
