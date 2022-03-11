/*
 * Copyright 2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.husky.communication.ch.camel.chpharm1.transform.requests;

import org.husky.communication.ch.camel.chpharm1.requests.query.*;
import org.husky.communication.ch.camel.chpharm1.transform.requests.query.*;
import org.openehealth.ipf.commons.ihe.xds.core.ebxml.EbXMLAdhocQueryRequest;

import static org.apache.commons.lang3.Validate.notNull;

/**
 * Query visitor to transform an ebXML representation into a query.
 * @author Jens Riemschneider
 */
final class FromEbXMLVisitor implements ChPharmacyDocumentsQuery.Visitor {
    private final EbXMLAdhocQueryRequest ebXML;

    /**
     * Constructs the visitor.
     * @param ebXML
     *          the ebXML object that is transformed.
     */
    FromEbXMLVisitor(EbXMLAdhocQueryRequest ebXML) {
        notNull(ebXML, "ebXML cannot be null");
        this.ebXML = ebXML;
    }

    @Override
    public void visit(final ChFindMedicationTreatmentPlansQuery query) {
        new ChFindMedicationTreatmentPlansQueryTransformer().fromEbXML(query, ebXML);
    }

    @Override
    public void visit(final ChFindPrescriptionsQuery query) {
       new ChFindPrescriptionsQueryTransformer().fromEbXML(query, ebXML);
    }

    @Override
    public void visit(final ChFindDispensesQuery query) {
        new ChFindDispensesQueryTransformer().fromEbXML(query, ebXML);
    }

    @Override
    public void visit(final ChFindMedicationAdministrationsQuery query) {
       new ChFindMedicationAdministrationsQueryTransformer().fromEbXML(query, ebXML);
    }

    @Override
    public void visit(final ChFindPrescriptionsForValidationQuery query) {
        new ChFindPrescriptionsForValidationQueryTransformer().fromEbXML(query, ebXML);
    }

    @Override
    public void visit(final ChFindPrescriptionsForDispenseQuery query) {
        new ChFindPrescriptionsForDispenseQueryTransformer().fromEbXML(query, ebXML);
    }

    @Override
    public void visit(final ChFindMedicationListQuery query) {
        new ChFindMedicationListQueryTransformer().fromEbXML(query, ebXML);
    }

    @Override
    public void visit(final ChFindMedicationCardQuery query) {
        new ChFindMedicationCardQueryTransformer().fromEbXML(query, ebXML);
    }
}
