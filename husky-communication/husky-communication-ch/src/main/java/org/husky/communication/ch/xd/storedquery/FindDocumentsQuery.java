/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
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
package org.husky.communication.ch.xd.storedquery;

import java.util.List;

import org.husky.common.ch.enums.ConfidentialityCode;
import org.husky.common.enums.DateTimeRangeAttributes;
import org.husky.common.model.Author;
import org.husky.common.model.Identificator;
import org.husky.common.utils.XdsMetadataUtil;
import org.husky.communication.ch.enums.AvailabilityStatus;
import org.husky.communication.ch.enums.HealthcareFacilityTypeCode;
import org.husky.communication.xd.storedquery.AbstractStoredQuery;
import org.openehealth.ipf.commons.ihe.xds.core.requests.query.StoredQuery;

/**
 * Represents a query to find documents in an XDS Registry (XDS
 * FindDocumentsQuery). This class uses only enums for XDS metadata which are
 * specified by eHealth Suisse for the usage in Switzerland.
 */
public class FindDocumentsQuery extends AbstractStoredQuery {
	private org.openehealth.ipf.commons.ihe.xds.core.requests.query.FindDocumentsQuery ipfStoredQuery;

	/**
	 * Constructs a FindDocuments Query
	 *
	 * @param patientId
	 *            ID of the patient
	 * @param status
	 *            Status of the document
	 */
	public FindDocumentsQuery(Identificator patientId, AvailabilityStatus status) {
		ipfStoredQuery = new org.openehealth.ipf.commons.ihe.xds.core.requests.query.FindDocumentsQuery();
		ipfStoredQuery.setPatientId(XdsMetadataUtil.convertEhcIdentificator(patientId));
		ipfStoredQuery.setStatus(List.of(org.openehealth.ipf.commons.ihe.xds.core.metadata.AvailabilityStatus
				.valueOfOpcode(status.getCodeValue())));
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
			org.husky.communication.ch.enums.ClassCode[] classCodes,
			org.husky.communication.xd.storedquery.DateTimeRange[] dateTimeRanges,
			org.husky.communication.ch.enums.PracticeSettingCode[] practiceSettingCodes,
			HealthcareFacilityTypeCode[] healthCareFacilityCodes,
			org.husky.common.ch.enums.ConfidentialityCode[] confidentialityCodes,
			org.husky.communication.ch.enums.FormatCode[] formatCodes, Author authorPerson,
			AvailabilityStatus status) {

		ipfStoredQuery = new org.openehealth.ipf.commons.ihe.xds.core.requests.query.FindDocumentsQuery();
		ipfStoredQuery.setPatientId(XdsMetadataUtil.convertEhcIdentificator(patientId));
		ipfStoredQuery.setClassCodes(XdsMetadataUtil.convertEhcCodeToCode(classCodes));
		ipfStoredQuery.setPracticeSettingCodes(XdsMetadataUtil.convertEhcCodeToCode(practiceSettingCodes));
		ipfStoredQuery
				.setHealthcareFacilityTypeCodes(XdsMetadataUtil.convertEhcCodeToCode(healthCareFacilityCodes));
		ipfStoredQuery.setConfidentialityCodes(XdsMetadataUtil.convertEhcCodeToQueryListCode(confidentialityCodes));
		ipfStoredQuery.setFormatCodes(XdsMetadataUtil.convertEhcCodeToCode(formatCodes));

		ipfStoredQuery.setStatus(List.of(org.openehealth.ipf.commons.ihe.xds.core.metadata.AvailabilityStatus
				.valueOfOpcode(status.getCodeValue())));

		if (dateTimeRanges != null) {
			for (var index = 0; index < dateTimeRanges.length; index++) {
				if (dateTimeRanges[index] != null) {
					if (dateTimeRanges[index].getDateTimeRangeAttribute()
							.equals(DateTimeRangeAttributes.SERVICE_START_TIME)) {
						ipfStoredQuery.getServiceStartTime()
								.setFrom(dateTimeRanges[index].getFromAsUsFormattedString());
						ipfStoredQuery.getServiceStartTime()
								.setTo(dateTimeRanges[index].getToAsUsFormattedString());
					} else if (dateTimeRanges[index].getDateTimeRangeAttribute()
							.equals(DateTimeRangeAttributes.SERVICE_STOP_TIME)) {
						ipfStoredQuery.getServiceStopTime()
								.setFrom(dateTimeRanges[index].getFromAsUsFormattedString());
						ipfStoredQuery.getServiceStopTime().setTo(dateTimeRanges[index].getToAsUsFormattedString());
					} else if (dateTimeRanges[index].getDateTimeRangeAttribute()
							.equals(DateTimeRangeAttributes.CREATION_TIME)) {
						ipfStoredQuery.getCreationTime().setFrom(dateTimeRanges[index].getFromAsUsFormattedString());
						ipfStoredQuery.getCreationTime().setTo(dateTimeRanges[index].getToAsUsFormattedString());
					}
				}
			}
		}

		var author = XdsMetadataUtil.converteHCAuthor(authorPerson);
		ipfStoredQuery.setTypedAuthorPersons(List.of(author.getAuthorPerson()));
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
		ipfStoredQuery.setConfidentialityCodes(XdsMetadataUtil.convertEhcCodeToQueryListCode(confidentialityCodes));
	}

	/**
	 * <div class="en">Gets the AvailabilityStatus as IPF AvailabilityStatusType
	 * Object.</div> <div class="de">Liefert AvailabilityStatus als IPF
	 * AvailabilityStatusType Objekt.</div>
	 *
	 * @return <div class="en">the address use as postal address use</div>
	 */
	public org.openehealth.ipf.commons.ihe.xds.core.metadata.AvailabilityStatus getAsIpfAvailabilityStatusType(
			AvailabilityStatus availabilityStatus) {
		switch (availabilityStatus) {
		case APPROVED:
			return org.openehealth.ipf.commons.ihe.xds.core.metadata.AvailabilityStatus.APPROVED;
		case DEPRECATED:
			return org.openehealth.ipf.commons.ihe.xds.core.metadata.AvailabilityStatus.DEPRECATED;
		default:
			return org.openehealth.ipf.commons.ihe.xds.core.metadata.AvailabilityStatus.APPROVED;
		}
	}

	/**
	 * Gets the IPF StoredQuery object, which is being wrapped by this class
	 *
	 * @return the IPF StoredQuery
	 */
	@Override
	public StoredQuery getIpfQuery() {
		return ipfStoredQuery;
	}
}
