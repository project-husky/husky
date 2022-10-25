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
package org.projecthusky.communication.ch.camel.chpharm1.transform.requests.query;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.communication.ch.camel.chpharm1.requests.query.ChPharmacyStableDocumentsQuery;
import org.openehealth.ipf.commons.ihe.xds.core.ebxml.EbXMLAdhocQueryRequest;
import org.openehealth.ipf.commons.ihe.xds.core.transform.requests.query.QuerySlotHelper;

import static org.openehealth.ipf.commons.ihe.xds.core.metadata.Timestamp.toHL7;
import static org.openehealth.ipf.commons.ihe.xds.core.transform.requests.QueryParameter.*;
import static org.openehealth.ipf.commons.ihe.xds.core.transform.requests.QueryParameter.DOC_ENTRY_SERVICE_STOP_TIME_TO;

/**
 * Base transformations for all stable-documents CH:PHARM-1 queries.
 *
 * @author Quentin Ligier
 **/
public class ChPharmacyStableDocumentsQueryTransformer<T extends ChPharmacyStableDocumentsQuery> extends ChPharmacyDocumentsQueryTransformer<T> {

    /**
     * Transforms the query into its ebXML representation.
     * <p>
     * Does not perform any transformation if one of the parameters is <code>null</code>.
     * @param query
     *          the query. Can be <code>null</code>.
     * @param ebXML
     *          the ebXML representation. Can be <code>null</code>.
     */
    @Override
    public void toEbXML(@Nullable final T query,
                        @Nullable final EbXMLAdhocQueryRequest ebXML) {
        if (query == null || ebXML == null) {
            return;
        }

        super.toEbXML(query, ebXML);
        var slots = new QuerySlotHelper(ebXML);

        slots.fromStringList(DOC_ENTRY_AUTHOR_PERSON, query.getAuthorPersons());
        slots.fromStringList(DOC_ENTRY_UUID, query.getUuids());
        slots.fromStringList(DOC_ENTRY_UNIQUE_ID, query.getUniqueIds());
        slots.fromNumber(DOC_ENTRY_CREATION_TIME_FROM, toHL7(query.getCreationTime().getFrom()));
        slots.fromNumber(DOC_ENTRY_CREATION_TIME_TO, toHL7(query.getCreationTime().getTo()));
        slots.fromCode(DOC_ENTRY_HEALTHCARE_FACILITY_TYPE_CODE, query.getHealthcareFacilityTypeCodes());
        slots.fromCode(DOC_ENTRY_PRACTICE_SETTING_CODE, query.getPracticeSettingCodes());
        slots.fromCode(DOC_ENTRY_EVENT_CODE, query.getEventCodes());
        slots.fromCode(DOC_ENTRY_CONFIDENTIALITY_CODE, query.getConfidentialityCodes());

        slots.fromNumber(DOC_ENTRY_SERVICE_START_TIME_FROM, toHL7(query.getServiceStartTime().getFrom()));
        slots.fromNumber(DOC_ENTRY_SERVICE_START_TIME_TO, toHL7(query.getServiceStartTime().getTo()));

        slots.fromNumber(DOC_ENTRY_SERVICE_STOP_TIME_FROM, toHL7(query.getServiceStopTime().getFrom()));
        slots.fromNumber(DOC_ENTRY_SERVICE_STOP_TIME_TO, toHL7(query.getServiceStopTime().getTo()));
    }

    /**
     * Transforms the ebXML representation of a query into a query object.
     * <p>
     * Does not perform any transformation if one of the parameters is <code>null</code>.
     * @param query
     *          the query. Can be <code>null</code>.
     * @param ebXML
     *          the ebXML representation. Can be <code>null</code>.
     */
    @Override
    public void fromEbXML(@Nullable final T query,
                          @Nullable final EbXMLAdhocQueryRequest ebXML) {
        if (query == null || ebXML == null) {
            return;
        }

        super.fromEbXML(query, ebXML);
        var slots = new QuerySlotHelper(ebXML);

        query.setAuthorPersons(slots.toStringList(DOC_ENTRY_AUTHOR_PERSON));
        query.setConfidentialityCodes(slots.toCodeList(DOC_ENTRY_CONFIDENTIALITY_CODE));
        query.getCreationTime().setFrom(slots.toNumber(DOC_ENTRY_CREATION_TIME_FROM));
        query.getCreationTime().setTo(slots.toNumber(DOC_ENTRY_CREATION_TIME_TO));
        query.setEventCodes(slots.toCodeList(DOC_ENTRY_EVENT_CODE));
        query.setHealthcareFacilityTypeCodes(slots.toCodeList(DOC_ENTRY_HEALTHCARE_FACILITY_TYPE_CODE));
        query.setPracticeSettingCodes(slots.toCodeList(DOC_ENTRY_PRACTICE_SETTING_CODE));
        query.setUniqueIds(slots.toStringList(DOC_ENTRY_UNIQUE_ID));
        query.setUuids(slots.toStringList(DOC_ENTRY_UUID));

        query.getServiceStartTime().setFrom(slots.toNumber(DOC_ENTRY_SERVICE_START_TIME_FROM));
        query.getServiceStartTime().setTo(slots.toNumber(DOC_ENTRY_SERVICE_START_TIME_TO));

        query.getServiceStopTime().setFrom(slots.toNumber(DOC_ENTRY_SERVICE_STOP_TIME_FROM));
        query.getServiceStopTime().setTo(slots.toNumber(DOC_ENTRY_SERVICE_STOP_TIME_TO));
    }
}
