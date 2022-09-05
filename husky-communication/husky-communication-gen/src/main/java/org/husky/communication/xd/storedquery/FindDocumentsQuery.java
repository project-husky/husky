/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.husky.communication.xd.storedquery;

import java.util.List;

import org.husky.common.enums.DateTimeRangeAttributes;
import org.husky.common.model.Code;
import org.husky.common.model.Identificator;
import org.husky.common.model.Person;
import org.husky.common.utils.XdsMetadataUtil;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AvailabilityStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents a query to find documents in an XDS Registry (XDS
 * FindDocumentsQuery)
 */
public class FindDocumentsQuery extends AbstractStoredQuery {

    /**
     * The SLF4J logger instance.
     */
    private static final Logger log = LoggerFactory.getLogger(FindDocumentsQuery.class);

    /**
     * Constructs a FindDocuments Query
     *
     * @param patientId ID of the patient
     * @param status    Status of the document
     */
    public FindDocumentsQuery(Identificator patientId, AvailabilityStatus status) {
        var findDocumentsQuery = new org.openehealth.ipf.commons.ihe.xds.core.requests.query.FindDocumentsQuery();
        findDocumentsQuery.setPatientId(XdsMetadataUtil.convertEhcIdentificator(patientId));
        findDocumentsQuery.setStatus(List.of(status));

        setIpfStoredQuery(findDocumentsQuery);
    }

    public FindDocumentsQuery(Identificator patientId, AvailabilityStatus status, Code typeCode,
							  Code classCode, Code formatCode) {

        var findDocumentsQuery = new org.openehealth.ipf.commons.ihe.xds.core.requests.query.FindDocumentsQuery();
        findDocumentsQuery.setPatientId(XdsMetadataUtil.convertEhcIdentificator(patientId));
        findDocumentsQuery.setStatus(List.of(status));

		findDocumentsQuery.setClassCodes(XdsMetadataUtil.convertEhcCodeToCode(List.of(classCode)));
		findDocumentsQuery.setFormatCodes(XdsMetadataUtil.convertEhcCodeToCode(List.of(formatCode)));
		findDocumentsQuery.setTypeCodes(XdsMetadataUtil.convertEhcCodeToCode(List.of(typeCode)));

        setIpfStoredQuery(findDocumentsQuery);
    }


    /**
     * Constructs a FindDocuments Query
     *
     * @param patientId               ID of the patient (required)
     * @param classCodes              an array of codes, which classify the document
     *                                (can be null)
     * @param dateTimeRanges          an array of DateTimeRange objects (can be
     *                                null)
     * @param practiceSettingCodes    an array of codes, which classify the
     *                                institution, where the document was created
     *                                (can be null)
     * @param healthCareFacilityCodes an array of codes, which classify the type of
     *                                healthcare facility, where the document was
     *                                created (can be null)
     * @param confidentialityCodes    an array of codes, which classify the
     *                                confidentiality of the document (can be null)
     * @param formatCodes             an array of codes, which classify the format
     *                                of the document (can be null)
     * @param authorPerson            information about the author of the document
     *                                (can be null)
     * @param status                  the availability status of the document
     *                                (required)
     */
    /* in use by external libraries */
    @SuppressWarnings("java:S107")
    public FindDocumentsQuery(Identificator patientId, List<Code> classCodes,
                              List<org.husky.communication.xd.storedquery.DateTimeRange> dateTimeRanges,
                              List<Code> practiceSettingCodes, List<Code> healthCareFacilityCodes, List<Code> confidentialityCodes,
                              List<Code> formatCodes, Person authorPerson, AvailabilityStatus status) {

        var findDocumentsQuery = new org.openehealth.ipf.commons.ihe.xds.core.requests.query.FindDocumentsQuery();
        findDocumentsQuery.setPatientId(XdsMetadataUtil.convertEhcIdentificator(patientId));
        findDocumentsQuery.setClassCodes(XdsMetadataUtil.convertEhcCodeToCode(classCodes));
        findDocumentsQuery.setPracticeSettingCodes(XdsMetadataUtil.convertEhcCodeToCode(practiceSettingCodes));
        findDocumentsQuery
                .setHealthcareFacilityTypeCodes(XdsMetadataUtil.convertEhcCodeToCode(healthCareFacilityCodes));
        findDocumentsQuery.setConfidentialityCodes(XdsMetadataUtil.convertEhcCodeToQueryListCode(confidentialityCodes));
        findDocumentsQuery.setFormatCodes(XdsMetadataUtil.convertEhcCodeToCode(formatCodes));

        if (authorPerson != null) {
            findDocumentsQuery.setTypedAuthorPersons(List.of(authorPerson.getIpfPerson()));
        }

        if (dateTimeRanges != null) {
            for (var index = 0; index < dateTimeRanges.size(); index++) {
                if (dateTimeRanges.get(index) != null) {
                    if (dateTimeRanges.get(index).getDateTimeRangeAttribute()
                            .equals(DateTimeRangeAttributes.SERVICE_START_TIME)) {
                        findDocumentsQuery.getServiceStartTime()
                                .setFrom(dateTimeRanges.get(index).getFromAsUsFormattedString());
                        findDocumentsQuery.getServiceStartTime()
                                .setTo(dateTimeRanges.get(index).getToAsUsFormattedString());
                    } else if (dateTimeRanges.get(index).getDateTimeRangeAttribute()
                            .equals(DateTimeRangeAttributes.SERVICE_STOP_TIME)) {
                        findDocumentsQuery.getServiceStopTime()
                                .setFrom(dateTimeRanges.get(index).getFromAsUsFormattedString());
                        findDocumentsQuery.getServiceStopTime()
                                .setTo(dateTimeRanges.get(index).getToAsUsFormattedString());
                    }
                }
            }
        }

        findDocumentsQuery.setStatus(List.of(status));

        setIpfStoredQuery(findDocumentsQuery);
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
    public void addConfidentialityCodes(List<Code> confidentialityCodes) {
        try {
            ((org.openehealth.ipf.commons.ihe.xds.core.requests.query.FindDocumentsQuery) getIpfQuery())
                    .getConfidentialityCodes().getOuterList()
                    .add(XdsMetadataUtil.convertEhcCodeToCode(confidentialityCodes));
        } catch (final ClassCastException e) {
            log.error(e.getMessage(), e);
        }
    }
}
