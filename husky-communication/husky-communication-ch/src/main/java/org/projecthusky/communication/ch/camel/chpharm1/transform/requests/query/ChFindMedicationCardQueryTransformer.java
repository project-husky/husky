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
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Code;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Hl7v2Based;
import org.projecthusky.communication.ch.camel.chpharm1.requests.query.ChFindMedicationCardQuery;
import org.openehealth.ipf.commons.ihe.xds.core.ebxml.EbXMLAdhocQueryRequest;
import org.openehealth.ipf.commons.ihe.xds.core.transform.requests.query.QuerySlotHelper;

import static org.openehealth.ipf.commons.ihe.xds.core.transform.requests.QueryParameter.*;

/**
 * Transforms between {@link ChFindMedicationCardQuery} and {@link EbXMLAdhocQueryRequest}.
 *
 * @author Quentin Ligier
 **/
public class ChFindMedicationCardQueryTransformer extends ChPharmacyDocumentsQueryTransformer<ChFindMedicationCardQuery> {

    /**
     * This parameter doesn't exist in {@link org.openehealth.ipf.commons.ihe.xds.core.transform.requests.QueryParameter}.
     */
    public static final String DOC_ENTRY_LANGUAGE_CODE = "$XDSDocumentEntryLanguageCode";
    public static final String PMLC_QUERY_INCLUDE_NON_ACTIVE = "$PMLCIncludeNonActive";
    public static final String PMLC_QUERY_PAPER_FORMAT = "$PMLCPaperFormat";

    /**
     * Transforms the query into its EbXML representation.
     * <p>
     * Does not perform any transformation if one of the parameters is <code>null</code>.
     *
     * @param query the query to transform.
     * @param ebXML the EbXML representation.
     */
    @Override
    public void toEbXML(@Nullable final ChFindMedicationCardQuery query,
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

        if (query.getLanguageCode() != null) {
            ebXML.addSlot(DOC_ENTRY_LANGUAGE_CODE, QuerySlotHelper.encodeAsString(query.getLanguageCode()));
        }

        if (query.getIncludeNonActive() != null) {
            ebXML.addSlot(PMLC_QUERY_INCLUDE_NON_ACTIVE, QuerySlotHelper.encodeAsString(query.getIncludeNonActive().toString()));
        }

        if (query.getPaperFormat() != null) {

            ebXML.addSlot(PMLC_QUERY_PAPER_FORMAT, QuerySlotHelper.encodeAsString(Hl7v2Based.render(query.getPaperFormat())));
        }
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
    public void fromEbXML(@Nullable final ChFindMedicationCardQuery query,
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

        query.setLanguageCode(QuerySlotHelper.decodeString(ebXML.getSingleSlotValue(DOC_ENTRY_LANGUAGE_CODE)));
        query.setIncludeNonActive(Boolean.valueOf(QuerySlotHelper.decodeString(ebXML.getSingleSlotValue(PMLC_QUERY_INCLUDE_NON_ACTIVE))));
        query.setPaperFormat(Hl7v2Based.parse(QuerySlotHelper.decodeString(ebXML.getSingleSlotValue(PMLC_QUERY_PAPER_FORMAT)), Code.class));
    }
}
