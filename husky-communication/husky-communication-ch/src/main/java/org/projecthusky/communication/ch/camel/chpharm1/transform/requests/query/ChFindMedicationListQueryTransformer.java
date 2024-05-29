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
import org.projecthusky.communication.ch.camel.chpharm1.requests.query.ChFindMedicationListQuery;
import org.openehealth.ipf.commons.ihe.xds.core.ebxml.EbXMLAdhocQueryRequest;
import org.openehealth.ipf.commons.ihe.xds.core.transform.requests.query.QuerySlotHelper;

import static org.openehealth.ipf.commons.ihe.xds.core.transform.requests.QueryParameter.*;

/**
 * Transforms between {@link ChFindMedicationListQuery} and {@link EbXMLAdhocQueryRequest}.
 *
 * @author Quentin Ligier
 **/
public class ChFindMedicationListQueryTransformer extends ChPharmacyDocumentsQueryTransformer<ChFindMedicationListQuery> {

    /**
     * Transforms the query into its EbXML representation.
     * <p>
     * Does not perform any transformation if one of the parameters is <code>null</code>.
     *
     * @param query the query to transform.
     * @param ebXML the EbXML representation.
     */
    @Override
    public void toEbXML(@Nullable final ChFindMedicationListQuery query,
                        @Nullable final EbXMLAdhocQueryRequest ebXML) {
        if (query == null || ebXML == null) {
            return;
        }

        super.toEbXML(query, ebXML);
        var slots = new QuerySlotHelper(ebXML);

        slots.fromCode(DOC_ENTRY_FORMAT_CODE, query.getFormatCodes());
        slots.fromDocumentEntryType(DOC_ENTRY_TYPE, query.getDocumentEntryTypes());

        slots.fromTimestamp(DOC_ENTRY_SERVICE_START_FROM, query.getServiceStart().getFrom());
        slots.fromTimestamp(DOC_ENTRY_SERVICE_START_TO, query.getServiceStart().getTo());

        slots.fromTimestamp(DOC_ENTRY_SERVICE_END_FROM, query.getServiceEnd().getFrom());
        slots.fromTimestamp(DOC_ENTRY_SERVICE_END_TO, query.getServiceEnd().getTo());
    }

    /**
     * Transforms the ebXML representation of a query into a query object.
     * <p>
     * Does not perform any transformation if one of the parameters is <code>null</code>.
     *
     * @param query the query. Can be <code>null</code>.
     * @param ebXML the ebXML representation. Can be <code>null</code>.
     */
    @Override
    public void fromEbXML(@Nullable final ChFindMedicationListQuery query,
                          @Nullable final EbXMLAdhocQueryRequest ebXML) {
        if (query == null || ebXML == null) {
            return;
        }

        super.fromEbXML(query, ebXML);
        var slots = new QuerySlotHelper(ebXML);

        query.setFormatCodes(slots.toCodeList(DOC_ENTRY_FORMAT_CODE));
        query.setDocumentEntryTypes(slots.toDocumentEntryType(DOC_ENTRY_TYPE));

        query.getServiceStart().setFrom(slots.toTimestamp(DOC_ENTRY_SERVICE_START_FROM));
        query.getServiceStart().setTo(slots.toTimestamp(DOC_ENTRY_SERVICE_START_TO));

        query.getServiceEnd().setFrom(slots.toTimestamp(DOC_ENTRY_SERVICE_END_FROM));
        query.getServiceEnd().setTo(slots.toTimestamp(DOC_ENTRY_SERVICE_END_TO));
    }
}
