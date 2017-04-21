/*
 * 
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 * 
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
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
package org.ehealth_connector.communication.ch.xd.storedquery;

import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.utils.XdsMetadataUtil;
import org.ehealth_connector.communication.ch.enums.AvailabilityStatus;
import org.ehealth_connector.communication.ch.enums.ConfidentialityCode;
import org.ehealth_connector.communication.ch.enums.HealthcareFacilityTypeCode;
import org.ehealth_connector.communication.utils.XdsUtil;
import org.ehealth_connector.communication.xd.storedquery.StoredQueryInterface;
import org.openhealthtools.ihe.common.hl7v2.XCN;
import org.openhealthtools.ihe.xds.consumer.storedquery.MalformedStoredQueryException;
import org.openhealthtools.ihe.xds.consumer.storedquery.StoredQuery;
import org.openhealthtools.ihe.xds.metadata.AvailabilityStatusType;

/**
 * Represents a query to find documents in an XDS Registry (XDS
 * FindDocumentsQuery). This class uses only enums for XDS metadata which are
 * specified by eHealth Suisse for the usage in Switzerland.
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
					XdsMetadataUtil.convertEhcIdentificator(patientId),
					new AvailabilityStatusType[] { status.getAsOhtAvailabilityStatusType() });
		} catch (final MalformedStoredQueryException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Constructs a FindDocuments Query
	 *
	 * @param patientId
	 *            ID of the patient (required)
	 * @param classCodes
	 *            an array of enums, which classify the document (can be null)
	 * @param dateTimeRanges
	 *            an array of DateTimeRange objects (can be null)
	 * @param practiceSettingCodes
	 *            an array of enums, which classify the institution, where the
	 *            document was created (can be null)
	 * @param healthCareFacilityCodes
	 *            an array of enums, which classify the type of healthcare
	 *            facility, where the document was created (can be null)
	 * @param confidentialityCodes
	 *            an array of enums, which classify the confidentiality of the
	 *            document (can be null)
	 * @param formatCodes
	 *            an array of enums, which classify the format of the document
	 *            (can be null)
	 * @param authorPerson
	 *            information about the author of the document (can be null)
	 * @param status
	 *            the availability status of the document (required)
	 */
	public FindDocumentsQuery(Identificator patientId,
			org.ehealth_connector.communication.ch.enums.ClassCode[] classCodes,
			org.ehealth_connector.communication.xd.storedquery.DateTimeRange[] dateTimeRanges,
			org.ehealth_connector.communication.ch.enums.PracticeSettingCode[] practiceSettingCodes,
			HealthcareFacilityTypeCode[] healthCareFacilityCodes,
			org.ehealth_connector.communication.ch.enums.ConfidentialityCode[] confidentialityCodes,
			org.ehealth_connector.communication.ch.enums.FormatCode[] formatCodes, XCN authorPerson,
			AvailabilityStatus status) {

		try {
			ohtStoredQuery = new org.openhealthtools.ihe.xds.consumer.storedquery.FindDocumentsQuery(
					XdsMetadataUtil.convertEhcIdentificator(patientId),
					XdsMetadataUtil.convertEhcEnumToCodedMetadataType(classCodes),
					XdsUtil.convertEhcDateTimeRange(dateTimeRanges),
					XdsMetadataUtil.convertEhcEnumToCodedMetadataType(practiceSettingCodes),
					XdsMetadataUtil.convertEhcEnumToCodedMetadataType(healthCareFacilityCodes),
					null, // Event
					// Code
					// is
					// currently
					// not
					// used
					// in
					// Switzerland
					XdsMetadataUtil.convertEhcEnumToCodedMetadataType(confidentialityCodes),
					XdsMetadataUtil.convertEhcEnumToCodedMetadataType(formatCodes), authorPerson,
					new AvailabilityStatusType[] { status.getAsOhtAvailabilityStatusType() });
		} catch (final MalformedStoredQueryException e) {
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
	public void addConfidentialityCodes(ConfidentialityCode[] confidentialityCodes) {
		try {
			ohtStoredQuery.addConfidentialityCodes(
					XdsMetadataUtil.convertEhcEnumToCodedMetadataType(confidentialityCodes));
		} catch (final MalformedStoredQueryException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets the OHT StoredQuery object, which is being wrapped by this class
	 *
	 * @return the OHT StoredQuery
	 */
	@Override
	public StoredQuery getOhtStoredQuery() {
		return ohtStoredQuery;
	}
}
