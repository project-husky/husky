/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.communication.at.xd.storedquery;

import java.util.List;

import org.husky.common.at.enums.ConfidentialityCode;
import org.husky.common.at.enums.HealthcareFacilityTypeCode;
import org.husky.common.enums.DateTimeRangeAttributes;
import org.husky.common.model.Author;
import org.husky.common.model.Identificator;
import org.husky.common.utils.XdsMetadataUtil;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AvailabilityStatus;

/**
 * Represents a query to find documents in an XDS Registry (XDS
 * FindDocumentsQuery). This class uses only enums for XDS metadata which are
 * specified by eHealth Suisse for the usage in Switzerland.
 */
public class FindDocumentsQueryAt extends org.husky.communication.xd.storedquery.FindDocumentsQuery {

	/**
	 * Constructs a FindDocuments Query
	 *
	 * @param patientId               ID of the patient (required)
	 * @param classCodes              an array of enums, which classify the document
	 *                                (can be null)
	 * @param dateTimeRanges          an array of DateTimeRange objects (can be
	 *                                null)
	 * @param practiceSettingCodes    an array of enums, which classify the
	 *                                institution, where the document was created
	 *                                (can be null)
	 * @param healthCareFacilityCodes an array of enums, which classify the type of
	 *                                healthcare facility, where the document was
	 *                                created (can be null)
	 * @param confidentialityCodes    an array of enums, which classify the
	 *                                confidentiality of the document (can be null)
	 * @param formatCodes             an array of enums, which classify the format
	 *                                of the document (can be null)
	 * @param authorPerson            information about the author of the document
	 *                                (can be null)
	 * @param status                  the availability status of the document
	 *                                (required)
	 */
	/* in use by external libraries */
	@SuppressWarnings("java:S107")
	public FindDocumentsQueryAt(Identificator patientId, org.husky.common.at.enums.ClassCode[] classCodes,
			org.husky.communication.xd.storedquery.DateTimeRange[] dateTimeRanges,
			org.husky.common.at.enums.PracticeSettingCode[] practiceSettingCodes,
			HealthcareFacilityTypeCode[] healthCareFacilityCodes,
			org.husky.common.at.enums.ConfidentialityCode[] confidentialityCodes,
			org.husky.common.at.enums.FormatCode[] formatCodes, Author authorPerson,
			AvailabilityStatus status) {

		super(patientId, status);

		var ipfStoredQuery = (org.openehealth.ipf.commons.ihe.xds.core.requests.query.FindDocumentsQuery) getIpfQuery();
		ipfStoredQuery.setPatientId(XdsMetadataUtil.convertEhcIdentificator(patientId));
		ipfStoredQuery.setClassCodes(XdsMetadataUtil.convertEhcCodeToCode(classCodes));
		ipfStoredQuery.setPracticeSettingCodes(XdsMetadataUtil.convertEhcCodeToCode(practiceSettingCodes));
		ipfStoredQuery.setHealthcareFacilityTypeCodes(XdsMetadataUtil.convertEhcCodeToCode(healthCareFacilityCodes));
		ipfStoredQuery.setConfidentialityCodes(XdsMetadataUtil.convertEhcCodeToQueryListCode(confidentialityCodes));
		ipfStoredQuery.setFormatCodes(XdsMetadataUtil.convertEhcCodeToCode(formatCodes));

		ipfStoredQuery.setStatus(List.of(status));

		if (dateTimeRanges != null) {
			for (var index = 0; index < dateTimeRanges.length; index++) {
				if (dateTimeRanges[index] != null) {
					if (dateTimeRanges[index].getDateTimeRangeAttribute()
							.equals(DateTimeRangeAttributes.SERVICE_START_TIME)) {
						ipfStoredQuery.getServiceStartTime()
								.setFrom(dateTimeRanges[index].getFromAsUsFormattedString());
						ipfStoredQuery.getServiceStartTime().setTo(dateTimeRanges[index].getToAsUsFormattedString());
					} else if (dateTimeRanges[index].getDateTimeRangeAttribute()
							.equals(DateTimeRangeAttributes.SERVICE_STOP_TIME)) {
						ipfStoredQuery.getServiceStopTime().setFrom(dateTimeRanges[index].getFromAsUsFormattedString());
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
		setIpfStoredQuery(ipfStoredQuery);
	}


	/**
	 * Adds an additional disjunctive clause of confidentiality codes to the query.
	 * Per IHE 2008-2009 ITI CP 228, codes with in the parameter will be interpreted
	 * with OR semantics. The resultant disjunctive clause will be AND-ed together
	 * with any confidentialityCode clauses previously added. Calling this method
	 * sequentially will result in the AND-ing of multiple clauses.
	 *
	 * @param confidentialityCodes array of confidentiality codes
	 */
	public void addConfidentialityCodes(ConfidentialityCode[] confidentialityCodes) {
		((org.openehealth.ipf.commons.ihe.xds.core.requests.query.FindDocumentsQuery) getIpfQuery())
				.setConfidentialityCodes(XdsMetadataUtil.convertEhcCodeToQueryListCode(confidentialityCodes));
	}

}
