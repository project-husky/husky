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

import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.utils.XdsMetadataUtil;
import org.ehealth_connector.communication.utils.XdsUtil;
import org.openhealthtools.ihe.common.hl7v2.XCN;
import org.openhealthtools.ihe.xds.consumer.storedquery.MalformedStoredQueryException;
import org.openhealthtools.ihe.xds.metadata.AvailabilityStatusType;

/**
 * Represents a query to find documents in an XDS Registry (XDS
 * FindDocumentsQuery)
 */
public class FindDocumentsQuery /* implements StoredQueryInterface */ extends AbstractStoredQuery {
	// private
	// org.openhealthtools.ihe.xds.consumer.storedquery.FindDocumentsQuery
	// ohtStoredQuery;

	/**
	 * Constructs a FindDocuments Query
	 *
	 * @param patientId
	 *            ID of the patient
	 * @param status
	 *            Status of the document
	 */
	public FindDocumentsQuery(Identificator patientId, AvailabilityStatusType status) {
		try {
			// ohtStoredQuery = new
			// org.openhealthtools.ihe.xds.consumer.storedquery.FindDocumentsQuery(
			// XdsMetadataUtil.convertEhcIdentificator(patientId),
			// new AvailabilityStatusType[] { status });
			setOhtStoredQuery(
					new org.openhealthtools.ihe.xds.consumer.storedquery.FindDocumentsQuery(
							XdsMetadataUtil.convertEhcIdentificator(patientId),
							new AvailabilityStatusType[] { status }));
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
			AvailabilityStatusType status) {

		try {
			// ohtStoredQuery = new
			// org.openhealthtools.ihe.xds.consumer.storedquery.FindDocumentsQuery(
			// XdsMetadataUtil.convertEhcIdentificator(patientId),
			// XdsMetadataUtil.convertEhcCodeToCodedMetadataType(classCodes),
			// XdsUtil.convertEhcDateTimeRange(dateTimeRanges),
			// XdsMetadataUtil.convertEhcCodeToCodedMetadataType(practiceSettingCodes),
			// XdsMetadataUtil.convertEhcCodeToCodedMetadataType(healthCareFacilityCodes),
			// null, // Event
			// // code
			// // is
			// // currently
			// // not
			// // used
			// // in
			// // Switzerland
			// XdsMetadataUtil.convertEhcCodeToCodedMetadataType(confidentialityCodes),
			// XdsMetadataUtil.convertEhcCodeToCodedMetadataType(formatCodes),
			// authorPerson,
			// new AvailabilityStatusType[] { status });

			setOhtStoredQuery(
					new org.openhealthtools.ihe.xds.consumer.storedquery.FindDocumentsQuery(
							XdsMetadataUtil.convertEhcIdentificator(patientId),
							XdsMetadataUtil.convertEhcCodeToCodedMetadataType(classCodes),
							XdsUtil.convertEhcDateTimeRange(dateTimeRanges),
							XdsMetadataUtil.convertEhcCodeToCodedMetadataType(practiceSettingCodes),
							XdsMetadataUtil.convertEhcCodeToCodedMetadataType(
									healthCareFacilityCodes),
							null, // Event
							// code
							// is
							// currently
							// not
							// used
							// in
							// Switzerland
							XdsMetadataUtil.convertEhcCodeToCodedMetadataType(confidentialityCodes),
							XdsMetadataUtil.convertEhcCodeToCodedMetadataType(formatCodes),
							authorPerson, new AvailabilityStatusType[] { status }));
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
	public void addConfidentialityCodes(Code[] confidentialityCodes) {
		try {
			// ohtStoredQuery.addConfidentialityCodes(
			// XdsMetadataUtil.convertEhcCodeToCodedMetadataType(confidentialityCodes));
			((org.openhealthtools.ihe.xds.consumer.storedquery.FindDocumentsQuery) getOhtStoredQuery())
					.addConfidentialityCodes(XdsMetadataUtil
							.convertEhcCodeToCodedMetadataType(confidentialityCodes));
		} catch (final MalformedStoredQueryException e) {
			e.printStackTrace();
		} catch (final ClassCastException e) {
			e.printStackTrace();
		}
	}
	//
	// /**
	// * Gets the OHT StoredQuery object, which is being wrapped by this class
	// *
	// * @return the OHT StoredQuery
	// */
	// @Override
	// public StoredQuery getOhtStoredQuery() {
	// return ohtStoredQuery;
	// }
}
