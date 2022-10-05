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
package org.projecthusky.communication.ch.camel.chpharm1.transform;

import org.apache.camel.Converter;
import org.projecthusky.communication.ch.camel.chpharm1.requests.ChQueryRegistry;
import org.projecthusky.communication.ch.camel.chpharm1.requests.query.*;
import org.projecthusky.communication.ch.camel.chpharm1.transform.requests.ChQueryRegistryTransformer;
import org.projecthusky.communication.ch.camel.chpharm1.transform.requests.query.*;
import org.openehealth.ipf.commons.ihe.xds.core.ebxml.EbXMLAdhocQueryRequest;
import org.openehealth.ipf.commons.ihe.xds.core.ebxml.ebxml30.EbXMLAdhocQueryRequest30;
import org.openehealth.ipf.commons.ihe.xds.core.stub.ebrs30.query.AdhocQueryRequest;

/**
 * Camel type converters for CH:PHARM-1.
 *
 * @author Quentin Ligier
 **/
@Converter(generateLoader = true)
public class ChPharm1Converters {

    /*
     * ChQueryRegistry
     */
    @Converter
    public AdhocQueryRequest convertChQueryRegistry(final ChQueryRegistry queryRegistry) {
        return (AdhocQueryRequest)(new ChQueryRegistryTransformer()).toEbXML(queryRegistry).getInternal();
    }

    @Converter
    public ChQueryRegistry convertChQueryRegistry(final AdhocQueryRequest ebXML) {
        return (new ChQueryRegistryTransformer()).fromEbXML(new EbXMLAdhocQueryRequest30(ebXML));
    }

    /*
     * ChFindMedicationTreatmentPlansQuery
     */
    @Converter
    public EbXMLAdhocQueryRequest convertFindMedicationTreatmentPlansQuery(final ChFindMedicationTreatmentPlansQuery query) {
        final var transformer = new ChFindMedicationTreatmentPlansQueryTransformer();
        final var ebXML = new EbXMLAdhocQueryRequest30(new AdhocQueryRequest());
        transformer.toEbXML(query, ebXML);
        return ebXML;
    }

    @Converter
    public ChFindMedicationTreatmentPlansQuery convertFindMedicationTreatmentPlansQuery(final EbXMLAdhocQueryRequest30 ebXML) {
        final var transformer = new ChFindMedicationTreatmentPlansQueryTransformer();
        final var query = new ChFindMedicationTreatmentPlansQuery();
        transformer.fromEbXML(query, ebXML);
        return query;
    }

    /*
     * ChFindPrescriptionsQuery
     */
    @Converter
    public EbXMLAdhocQueryRequest convertFindPrescriptionsQuery(final ChFindPrescriptionsQuery query) {
        final var transformer = new ChFindPrescriptionsQueryTransformer();
        final var ebXML = new EbXMLAdhocQueryRequest30(new AdhocQueryRequest());
        transformer.toEbXML(query, ebXML);
        return ebXML;
    }

    @Converter
    public ChFindPrescriptionsQuery convertFindPrescriptionsQuery(final EbXMLAdhocQueryRequest30 ebXML) {
        final var transformer = new ChFindPrescriptionsQueryTransformer();
        final var query = new ChFindPrescriptionsQuery();
        transformer.fromEbXML(query, ebXML);
        return query;
    }

    /*
     * ChFindDispensesQuery
     */
    @Converter
    public EbXMLAdhocQueryRequest convertChFindDispensesQuery(final ChFindDispensesQuery query) {
        final var transformer = new ChFindDispensesQueryTransformer();
        final var ebXML = new EbXMLAdhocQueryRequest30(new AdhocQueryRequest());
        transformer.toEbXML(query, ebXML);
        return ebXML;
    }

    @Converter
    public ChFindDispensesQuery convertChFindDispensesQuery(final EbXMLAdhocQueryRequest30 ebXML) {
        final var transformer = new ChFindDispensesQueryTransformer();
        final var query = new ChFindDispensesQuery();
        transformer.fromEbXML(query, ebXML);
        return query;
    }

    /*
     * ChFindMedicationAdministrationsQuery
     */
    @Converter
    public EbXMLAdhocQueryRequest convertChFindMedicationAdministrationsQuery(final ChFindMedicationAdministrationsQuery query) {
        final var transformer = new ChFindMedicationAdministrationsQueryTransformer();
        final var ebXML = new EbXMLAdhocQueryRequest30(new AdhocQueryRequest());
        transformer.toEbXML(query, ebXML);
        return ebXML;
    }

    @Converter
    public ChFindMedicationAdministrationsQuery convertChFindMedicationAdministrationsQuery(final EbXMLAdhocQueryRequest30 ebXML) {
        final var transformer = new ChFindMedicationAdministrationsQueryTransformer();
        final var query = new ChFindMedicationAdministrationsQuery();
        transformer.fromEbXML(query, ebXML);
        return query;
    }

    /*
     * ChFindPrescriptionsForDispenseQuery
     */
    @Converter
    public EbXMLAdhocQueryRequest convertChFindPrescriptionsForDispenseQuery(final ChFindPrescriptionsForDispenseQuery query) {
        final var transformer = new ChFindPrescriptionsForDispenseQueryTransformer();
        final var ebXML = new EbXMLAdhocQueryRequest30(new AdhocQueryRequest());
        transformer.toEbXML(query, ebXML);
        return ebXML;
    }

    @Converter
    public ChFindPrescriptionsForDispenseQuery convertChFindPrescriptionsForDispenseQuery(final EbXMLAdhocQueryRequest30 ebXML) {
        final var transformer = new ChFindPrescriptionsForDispenseQueryTransformer();
        final var query = new ChFindPrescriptionsForDispenseQuery();
        transformer.fromEbXML(query, ebXML);
        return query;
    }

    /*
     * ChFindPrescriptionsForValidationQuery
     */
    @Converter
    public EbXMLAdhocQueryRequest convertChFindPrescriptionsForValidationQuery(final ChFindPrescriptionsForValidationQuery query) {
        final var transformer = new ChFindPrescriptionsForValidationQueryTransformer();
        final var ebXML = new EbXMLAdhocQueryRequest30(new AdhocQueryRequest());
        transformer.toEbXML(query, ebXML);
        return ebXML;
    }

    @Converter
    public ChFindPrescriptionsForValidationQuery convertChFindPrescriptionsForValidationQuery(final EbXMLAdhocQueryRequest30 ebXML) {
        final var transformer = new ChFindPrescriptionsForValidationQueryTransformer();
        final var query = new ChFindPrescriptionsForValidationQuery();
        transformer.fromEbXML(query, ebXML);
        return query;
    }

    /*
     * ChFindMedicationListQuery
     */
    @Converter
    public EbXMLAdhocQueryRequest convertChFindMedicationListQuery(final ChFindMedicationListQuery query) {
        final var transformer = new ChFindMedicationListQueryTransformer();
        final var ebXML = new EbXMLAdhocQueryRequest30(new AdhocQueryRequest());
        transformer.toEbXML(query, ebXML);
        return ebXML;
    }

    @Converter
    public ChFindMedicationListQuery convertChFindMedicationListQuery(final EbXMLAdhocQueryRequest30 ebXML) {
        final var transformer = new ChFindMedicationListQueryTransformer();
        final var query = new ChFindMedicationListQuery();
        transformer.fromEbXML(query, ebXML);
        return query;
    }

    /*
     * ChFindMedicationCardQuery
     */
    @Converter
    public EbXMLAdhocQueryRequest convertChFindMedicationCardQuery(final ChFindMedicationCardQuery query) {
        final var transformer = new ChFindMedicationCardQueryTransformer();
        final var ebXML = new EbXMLAdhocQueryRequest30(new AdhocQueryRequest());
        transformer.toEbXML(query, ebXML);
        return ebXML;
    }

    @Converter
    public ChFindMedicationCardQuery convertChFindMedicationCardQuery(final EbXMLAdhocQueryRequest30 ebXML) {
        final var transformer = new ChFindMedicationCardQueryTransformer();
        final var query = new ChFindMedicationCardQuery();
        transformer.fromEbXML(query, ebXML);
        return query;
    }
}
