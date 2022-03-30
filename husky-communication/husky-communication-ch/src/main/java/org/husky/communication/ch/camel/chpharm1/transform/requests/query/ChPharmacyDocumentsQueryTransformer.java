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
package org.husky.communication.ch.camel.chpharm1.transform.requests.query;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.communication.ch.camel.chpharm1.requests.query.ChPharmacyDocumentsQuery;
import org.openehealth.ipf.commons.ihe.xds.core.ebxml.EbXMLAdhocQueryRequest;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Hl7v2Based;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Identifiable;
import org.openehealth.ipf.commons.ihe.xds.core.transform.requests.QueryParameter;
import org.openehealth.ipf.commons.ihe.xds.core.transform.requests.query.QuerySlotHelper;

import static org.openehealth.ipf.commons.ihe.xds.core.transform.requests.QueryParameter.*;

/**
 * Base transformations for all CH:PHARM-1 queries.
 *
 * @author Quentin Ligier
 **/
public class ChPharmacyDocumentsQueryTransformer<T extends ChPharmacyDocumentsQuery> {

    /**
     * Transforms the query into its ebXML representation.
     * <p>
     * Does not perform any transformation if one of the parameters is <code>null</code>.
     *
     * @param query the query. Can be <code>null</code>.
     * @param ebXML the ebXML representation. Can be <code>null</code>.
     */
    public void toEbXML(@Nullable final T query,
                        @Nullable final EbXMLAdhocQueryRequest ebXML) {
        if (query == null || ebXML == null) {
            return;
        }

        ebXML.setId(query.getType().getId());
        ebXML.setHome(query.getHomeCommunityId());

        var slotHelper = new QuerySlotHelper(ebXML);
        for (var entry : query.getExtraParameters().entrySet()) {
            slotHelper.fromStringList(entry.getKey(), entry.getValue());
        }
        var slots = new QuerySlotHelper(ebXML);

        slots.fromInteger(METADATA_LEVEL, query.getMetadataLevel());
        slots.fromString(DOC_ENTRY_PATIENT_ID, Hl7v2Based.render(query.getPatientId()));
        slots.fromStatus(DOC_ENTRY_STATUS, query.getStatus());
    }

    /**
     * Transforms the ebXML representation of a query into a query object.
     * <p>
     * Does not perform any transformation if one of the parameters is <code>null</code>.
     *
     * @param query the query. Can be <code>null</code>.
     * @param ebXML the ebXML representation. Can be <code>null</code>.
     */
    public void fromEbXML(@Nullable final T query,
                          @Nullable final EbXMLAdhocQueryRequest ebXML) {
        if (query == null || ebXML == null) {
            return;
        }

        query.setHomeCommunityId(ebXML.getHome());

        var slotHelper = new QuerySlotHelper(ebXML);
        for (var slot : ebXML.getSlots()) {
            var slotName = slot.getName();
            if ((QueryParameter.valueOfSlotName(slotName) == null) && (!query.getExtraParameters().containsKey(slotName))) {
                var queryList = slotHelper.toStringQueryList(slotName);
                if (queryList != null) {
                    query.getExtraParameters().put(slotName, queryList);
                }
            }
        }
        var slots = new QuerySlotHelper(ebXML);

        query.setMetadataLevel(slots.toInteger(METADATA_LEVEL));
        query.setPatientId(Hl7v2Based.parse(slots.toString(DOC_ENTRY_PATIENT_ID), Identifiable.class));
        query.setStatus(slots.toStatus(DOC_ENTRY_STATUS));
    }
}
