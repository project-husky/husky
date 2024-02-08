/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.communication.requests.xds;

import java.util.List;

import lombok.experimental.SuperBuilder;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AvailabilityStatus;
import org.openehealth.ipf.commons.ihe.xds.core.requests.query.StoredQuery;
import org.projecthusky.common.communication.Destination;
import org.projecthusky.common.enums.DateTimeRangeAttributes;
import org.projecthusky.common.model.Code;
import org.projecthusky.common.model.Identificator;
import org.projecthusky.common.model.Person;
import org.projecthusky.common.utils.XdsMetadataUtil;
import org.projecthusky.communication.xd.storedquery.DateTimeRange;

import lombok.Getter;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

/**
 * This class is designed to contain all possible search parameters for finding a document with the webservice. Paramerers are optional (except patientID and destination), only
 * those which are set will be used by the webservice.<br/>
 * The patient {@link Identificator} is required.
 * Possible parameters to search Documents by are:
 * <ul>
 * <li>Availability status</li>
 * <li>Type code</li>
 * <li>Class code</li>
 * <li>Format code</li>
 * <li>Practice setting code</li>
 * <li>Healthcare facility code</li>
 * <li>Confidentiality code</li>
 * <li>Datetime range code</li>
 * <li>Author</li>
 * </ul>
 * @author szalai
 * @see RegistryStoredFindDocumentsQueryTest
 */
@Getter
@SuperBuilder
@ToString
public class XdsRegistryStoredFindDocumentsQuery {
	@NonNull
	private Destination destination;
	@NonNull
	private Identificator patientID;

	@Singular("availabilityStatus")
	private List<AvailabilityStatus> availabilityStatus;
	@Singular
	private List<Code> typeCodes;
	@Singular
	private List<Code> classCodes;
	@Singular
	private List<Code> formatCodes;
	@Singular
	private List<Code> practiceSettingCodes;
	@Singular
	private List<Code> healthCareFacilityCodes;
	@Singular
	private List<Code> confidentialityCodes;
	@Singular
	private List<DateTimeRange> dateTimeRanges;
	private Person authorPerson;
	
	public static abstract class XdsRegistryStoredFindDocumentsQueryBuilder<C extends XdsRegistryStoredFindDocumentsQuery, B extends XdsRegistryStoredFindDocumentsQuery.XdsRegistryStoredFindDocumentsQueryBuilder<C, B>> {}
	
	public StoredQuery getIpfQuery() {
		var findDocumentsQuery = new org.openehealth.ipf.commons.ihe.xds.core.requests.query.FindDocumentsQuery();
		findDocumentsQuery.setPatientId(XdsMetadataUtil.convertEhcIdentificator(this.patientID));
		findDocumentsQuery.setStatus(this.availabilityStatus);
		findDocumentsQuery.setTypeCodes(XdsMetadataUtil.convertEhcCodeToCode(typeCodes));
		findDocumentsQuery.setClassCodes(XdsMetadataUtil.convertEhcCodeToCode(classCodes));
		findDocumentsQuery.setFormatCodes(XdsMetadataUtil.convertEhcCodeToCode(formatCodes));
		findDocumentsQuery.setPracticeSettingCodes(XdsMetadataUtil.convertEhcCodeToCode(practiceSettingCodes));
		findDocumentsQuery.setHealthcareFacilityTypeCodes(XdsMetadataUtil.convertEhcCodeToCode(healthCareFacilityCodes));
		findDocumentsQuery.setConfidentialityCodes(XdsMetadataUtil.convertEhcCodeToQueryListCode(confidentialityCodes));

		if (authorPerson != null) {
			findDocumentsQuery.setTypedAuthorPersons(List.of(authorPerson.getIpfPerson()));
		}

		if (dateTimeRanges != null) {
			for (var index = 0; index < dateTimeRanges.size(); index++) {
				if (dateTimeRanges.get(index) != null) {
					if (dateTimeRanges.get(index).getDateTimeRangeAttribute().equals(DateTimeRangeAttributes.SERVICE_START_TIME)) {
						findDocumentsQuery.getServiceStartTime().setFrom(dateTimeRanges.get(index).getFromAsUsFormattedString());
						findDocumentsQuery.getServiceStartTime().setTo(dateTimeRanges.get(index).getToAsUsFormattedString());
					} else if (dateTimeRanges.get(index).getDateTimeRangeAttribute().equals(DateTimeRangeAttributes.SERVICE_STOP_TIME)) {
						findDocumentsQuery.getServiceStopTime().setFrom(dateTimeRanges.get(index).getFromAsUsFormattedString());
						findDocumentsQuery.getServiceStopTime().setTo(dateTimeRanges.get(index).getToAsUsFormattedString());
					}
				}
			}
		}
		return findDocumentsQuery;
	}
}