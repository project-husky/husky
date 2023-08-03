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
package org.projecthusky.communication.ch.camel.chpharm5;

import ca.uhn.fhir.model.api.Include;
import ca.uhn.fhir.model.valueset.BundleTypeEnum;
import ca.uhn.fhir.rest.annotation.IncludeParam;
import ca.uhn.fhir.rest.annotation.Operation;
import ca.uhn.fhir.rest.annotation.OperationParam;
import ca.uhn.fhir.rest.annotation.Sort;
import ca.uhn.fhir.rest.api.SortSpec;
import ca.uhn.fhir.rest.api.server.IBundleProvider;
import ca.uhn.fhir.rest.api.server.RequestDetails;
import ca.uhn.fhir.rest.param.DateRangeParam;
import ca.uhn.fhir.rest.param.StringParam;
import ca.uhn.fhir.rest.param.TokenOrListParam;
import ca.uhn.fhir.rest.param.TokenParam;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.DocumentReference;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Practitioner;
import org.hl7.fhir.r4.model.ResourceType;
import org.openehealth.ipf.commons.ihe.fhir.AbstractPlainProvider;
import org.projecthusky.communication.ch.camel.chpharm5.requests.ChPharm5SearchParameters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;

/**
 * The CH:PHARM-5 resource provider.
 *
 * @author Quentin Ligier
 **/
public class ChPharm5ResourceProvider extends AbstractPlainProvider {
    public static final String SP_PATIENT_IDENTIFIER = DocumentReference.SP_PATIENT + "." + Patient.SP_IDENTIFIER;
    public static final String SP_AUTHOR_FAMILY = DocumentReference.SP_AUTHOR + "." + Practitioner.SP_FAMILY;
    public static final String SP_AUTHOR_GIVEN = DocumentReference.SP_AUTHOR + "." + Practitioner.SP_GIVEN;

    @Operation(name = "$find-medication-treatment-plans", type = DocumentReference.class, idempotent = true,
            bundleType = BundleTypeEnum.SEARCHSET)
    public IBundleProvider findMedicationTreatmentPlans(
            @OperationParam(name = SP_PATIENT_IDENTIFIER, min = 1, max = 1) TokenParam patient,
            @OperationParam(name = DocumentReference.SP_STATUS, min = 1, max = 2) TokenOrListParam status,
            @OperationParam(name = DocumentReference.SP_IDENTIFIER) TokenParam identifier,
            @OperationParam(name = DocumentReference.SP_SETTING) TokenOrListParam setting,
            @OperationParam(name = DocumentReference.SP_DATE) DateRangeParam date,
            @OperationParam(name = DocumentReference.SP_PERIOD) DateRangeParam period,
            @OperationParam(name = DocumentReference.SP_FORMAT) TokenOrListParam format,
            @OperationParam(name = DocumentReference.SP_FACILITY) TokenOrListParam facility,
            @OperationParam(name = DocumentReference.SP_EVENT) TokenOrListParam event,
            @OperationParam(name = DocumentReference.SP_SECURITY_LABEL) TokenOrListParam securityLabel,
            @OperationParam(name = SP_AUTHOR_FAMILY) StringParam authorFamily,
            @OperationParam(name = SP_AUTHOR_GIVEN) StringParam authorGiven,
            @Sort SortSpec sortSpec,
            @IncludeParam Set<Include> includeSpec,
            RequestDetails requestDetails,
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) {
        return this.searchRequestBundleProvider(patient, identifier, setting, date, period, format, facility, event, securityLabel,
                                                authorFamily, authorGiven, status, sortSpec, includeSpec, requestDetails, httpServletRequest,
                                                httpServletResponse, ChPharm5Operations.FIND_MEDICATION_TREATMENT_PLANS);
    }

    @Operation(name = "$find-prescriptions", type = DocumentReference.class, idempotent = true,
            bundleType = BundleTypeEnum.SEARCHSET)
    public IBundleProvider findPrescriptions(
            @OperationParam(name = SP_PATIENT_IDENTIFIER, min = 1, max = 1) TokenParam patient,
            @OperationParam(name = DocumentReference.SP_STATUS, min = 1, max = 2) TokenOrListParam status,
            @OperationParam(name = DocumentReference.SP_IDENTIFIER) TokenParam identifier,
            @OperationParam(name = DocumentReference.SP_SETTING) TokenOrListParam setting,
            @OperationParam(name = DocumentReference.SP_DATE) DateRangeParam date,
            @OperationParam(name = DocumentReference.SP_PERIOD) DateRangeParam period,
            @OperationParam(name = DocumentReference.SP_FORMAT) TokenOrListParam format,
            @OperationParam(name = DocumentReference.SP_FACILITY) TokenOrListParam facility,
            @OperationParam(name = DocumentReference.SP_EVENT) TokenOrListParam event,
            @OperationParam(name = DocumentReference.SP_SECURITY_LABEL) TokenOrListParam securityLabel,
            @OperationParam(name = SP_AUTHOR_FAMILY) StringParam authorFamily,
            @OperationParam(name = SP_AUTHOR_GIVEN) StringParam authorGiven,
            @Sort SortSpec sortSpec,
            @IncludeParam Set<Include> includeSpec,
            RequestDetails requestDetails,
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) {
        return this.searchRequestBundleProvider(patient, identifier, setting, date, period, format, facility, event, securityLabel,
                                                authorFamily, authorGiven, status, sortSpec, includeSpec, requestDetails, httpServletRequest, httpServletResponse,
                                                ChPharm5Operations.FIND_PRESCRIPTIONS);
    }

    @Operation(name = "$find-dispenses", type = DocumentReference.class, idempotent = true,
            bundleType = BundleTypeEnum.SEARCHSET)
    public IBundleProvider findDispenses(
            @OperationParam(name = SP_PATIENT_IDENTIFIER, min = 1, max = 1) TokenParam patient,
            @OperationParam(name = DocumentReference.SP_STATUS, min = 1, max = 2) TokenOrListParam status,
            @OperationParam(name = DocumentReference.SP_IDENTIFIER) TokenParam identifier,
            @OperationParam(name = DocumentReference.SP_SETTING) TokenOrListParam setting,
            @OperationParam(name = DocumentReference.SP_DATE) DateRangeParam date,
            @OperationParam(name = DocumentReference.SP_PERIOD) DateRangeParam period,
            @OperationParam(name = DocumentReference.SP_FORMAT) TokenOrListParam format,
            @OperationParam(name = DocumentReference.SP_FACILITY) TokenOrListParam facility,
            @OperationParam(name = DocumentReference.SP_EVENT) TokenOrListParam event,
            @OperationParam(name = DocumentReference.SP_SECURITY_LABEL) TokenOrListParam securityLabel,
            @OperationParam(name = SP_AUTHOR_FAMILY) StringParam authorFamily,
            @OperationParam(name = SP_AUTHOR_GIVEN) StringParam authorGiven,
            @Sort SortSpec sortSpec,
            @IncludeParam Set<Include> includeSpec,
            RequestDetails requestDetails,
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) {
        return this.searchRequestBundleProvider(patient, identifier, setting, date, period, format, facility, event, securityLabel,
                                                authorFamily, authorGiven, status, sortSpec, includeSpec, requestDetails, httpServletRequest, httpServletResponse,
                                                ChPharm5Operations.FIND_DISPENSES);
    }

    @Operation(name = "$find-medication-administrations", type = DocumentReference.class, idempotent = true,
            bundleType = BundleTypeEnum.SEARCHSET)
    public IBundleProvider findMedicationAdministrations(
            @OperationParam(name = SP_PATIENT_IDENTIFIER, min = 1, max = 1) TokenParam patient,
            @OperationParam(name = DocumentReference.SP_STATUS, min = 1, max = 2) TokenOrListParam status,
            @OperationParam(name = DocumentReference.SP_IDENTIFIER) TokenParam identifier,
            @OperationParam(name = DocumentReference.SP_SETTING) TokenOrListParam setting,
            @OperationParam(name = DocumentReference.SP_DATE) DateRangeParam date,
            @OperationParam(name = DocumentReference.SP_PERIOD) DateRangeParam period,
            @OperationParam(name = DocumentReference.SP_FORMAT) TokenOrListParam format,
            @OperationParam(name = DocumentReference.SP_FACILITY) TokenOrListParam facility,
            @OperationParam(name = DocumentReference.SP_EVENT) TokenOrListParam event,
            @OperationParam(name = DocumentReference.SP_SECURITY_LABEL) TokenOrListParam securityLabel,
            @OperationParam(name = SP_AUTHOR_FAMILY) StringParam authorFamily,
            @OperationParam(name = SP_AUTHOR_GIVEN) StringParam authorGiven,
            @Sort SortSpec sortSpec,
            @IncludeParam Set<Include> includeSpec,
            RequestDetails requestDetails,
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) {
        return this.searchRequestBundleProvider(patient, identifier, setting, date, period, format, facility, event, securityLabel,
                                                authorFamily, authorGiven, status, sortSpec, includeSpec, requestDetails, httpServletRequest, httpServletResponse,
                                                ChPharm5Operations.FIND_MEDICATION_ADMINISTRATIONS);
    }

    @Operation(name = "$find-prescriptions-for-validation", type = DocumentReference.class, idempotent = true,
            bundleType = BundleTypeEnum.SEARCHSET)
    public IBundleProvider findPrescriptionsForValidation(
            @OperationParam(name = SP_PATIENT_IDENTIFIER, min = 1, max = 1) TokenParam patient,
            @OperationParam(name = DocumentReference.SP_STATUS, min = 1, max = 2) TokenOrListParam status,
            @OperationParam(name = DocumentReference.SP_IDENTIFIER) TokenParam identifier,
            @OperationParam(name = DocumentReference.SP_SETTING) TokenOrListParam setting,
            @OperationParam(name = DocumentReference.SP_DATE) DateRangeParam date,
            @OperationParam(name = DocumentReference.SP_PERIOD) DateRangeParam period,
            @OperationParam(name = DocumentReference.SP_FORMAT) TokenOrListParam format,
            @OperationParam(name = DocumentReference.SP_FACILITY) TokenOrListParam facility,
            @OperationParam(name = DocumentReference.SP_EVENT) TokenOrListParam event,
            @OperationParam(name = DocumentReference.SP_SECURITY_LABEL) TokenOrListParam securityLabel,
            @OperationParam(name = SP_AUTHOR_FAMILY) StringParam authorFamily,
            @OperationParam(name = SP_AUTHOR_GIVEN) StringParam authorGiven,
            @Sort SortSpec sortSpec,
            @IncludeParam Set<Include> includeSpec,
            RequestDetails requestDetails,
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) {
        return this.searchRequestBundleProvider(patient, identifier, setting, date, period, format, facility, event, securityLabel,
                                                authorFamily, authorGiven, status, sortSpec, includeSpec, requestDetails, httpServletRequest, httpServletResponse,
                                                ChPharm5Operations.FIND_PRESCRIPTIONS_FOR_VALIDATION);
    }

    @Operation(name = "$find-prescriptions-for-dispense", type = DocumentReference.class, idempotent = true,
            bundleType = BundleTypeEnum.SEARCHSET)
    public IBundleProvider findPrescriptionsForDispense(
            @OperationParam(name = SP_PATIENT_IDENTIFIER, min = 1, max = 1) TokenParam patient,
            @OperationParam(name = DocumentReference.SP_STATUS, min = 1, max = 2) TokenOrListParam status,
            @OperationParam(name = DocumentReference.SP_IDENTIFIER) TokenParam identifier,
            @OperationParam(name = DocumentReference.SP_SETTING) TokenOrListParam setting,
            @OperationParam(name = DocumentReference.SP_DATE) DateRangeParam date,
            @OperationParam(name = DocumentReference.SP_PERIOD) DateRangeParam period,
            @OperationParam(name = DocumentReference.SP_FORMAT) TokenOrListParam format,
            @OperationParam(name = DocumentReference.SP_FACILITY) TokenOrListParam facility,
            @OperationParam(name = DocumentReference.SP_EVENT) TokenOrListParam event,
            @OperationParam(name = DocumentReference.SP_SECURITY_LABEL) TokenOrListParam securityLabel,
            @OperationParam(name = SP_AUTHOR_FAMILY) StringParam authorFamily,
            @OperationParam(name = SP_AUTHOR_GIVEN) StringParam authorGiven,
            @Sort SortSpec sortSpec,
            @IncludeParam Set<Include> includeSpec,
            RequestDetails requestDetails,
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) {
        return this.searchRequestBundleProvider(patient, identifier, setting, date, period, format, facility, event, securityLabel,
                                                authorFamily, authorGiven, status, sortSpec, includeSpec, requestDetails, httpServletRequest, httpServletResponse,
                                                ChPharm5Operations.FIND_PRESCRIPTIONS_FOR_DISPENSE);
    }

    // The method is not idempotent, but we need it to support GET requests
    @Operation(name = "$find-medication-list", type = DocumentReference.class, idempotent = true,
            bundleType = BundleTypeEnum.SEARCHSET)
    public IBundleProvider findMedicationList(
            @OperationParam(name = SP_PATIENT_IDENTIFIER, min = 1, max = 1) TokenParam patient,
            @OperationParam(name = DocumentReference.SP_STATUS, min = 1, max = 2) TokenOrListParam status,
            @OperationParam(name = DocumentReference.SP_PERIOD) DateRangeParam period,
            @OperationParam(name = DocumentReference.SP_FORMAT) TokenOrListParam format,
            @Sort SortSpec sortSpec,
            @IncludeParam Set<Include> includeSpec,
            RequestDetails requestDetails,
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) {
        return this.searchRequestBundleProvider(patient, null, null, null, period, format, null, null, null,
                                                null, null, status, sortSpec, includeSpec, requestDetails, httpServletRequest, httpServletResponse,
                                                ChPharm5Operations.FIND_MEDICATION_LIST);
    }

    // The method is not idempotent, but we need it to support GET requests
    @Operation(name = "$find-medication-card", type = DocumentReference.class, idempotent = true,
            bundleType = BundleTypeEnum.SEARCHSET)
    public IBundleProvider findMedicationCard(
            @OperationParam(name = SP_PATIENT_IDENTIFIER, min = 1, max = 1) TokenParam patient,
            @OperationParam(name = DocumentReference.SP_STATUS, min = 1, max = 2) TokenOrListParam status,
            @OperationParam(name = DocumentReference.SP_PERIOD) DateRangeParam period,
            @OperationParam(name = DocumentReference.SP_FORMAT) TokenOrListParam format,
            @Sort SortSpec sortSpec,
            @IncludeParam Set<Include> includeSpec,
            RequestDetails requestDetails,
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) {
        return this.searchRequestBundleProvider(patient, null, null, null, period, format, null, null, null,
                                                null, null, status, sortSpec, includeSpec, requestDetails, httpServletRequest, httpServletResponse,
                                                ChPharm5Operations.FIND_MEDICATION_LIST);
    }

    IBundleProvider searchRequestBundleProvider(final @Nullable TokenParam patient,
                                                final @Nullable TokenParam identifier,
                                                final @Nullable TokenOrListParam setting,
                                                final @Nullable DateRangeParam date,
                                                final @Nullable DateRangeParam period,
                                                final @Nullable TokenOrListParam format,
                                                final @Nullable TokenOrListParam facility,
                                                final @Nullable TokenOrListParam event,
                                                final @Nullable TokenOrListParam securityLabel,
                                                final @Nullable StringParam authorFamily,
                                                final @Nullable StringParam authorGiven,
                                                final @Nullable TokenOrListParam status,
                                                final @Nullable SortSpec sortSpec,
                                                final @Nullable Set<Include> includeSpec,
                                                final RequestDetails requestDetails,
                                                final HttpServletRequest httpServletRequest,
                                                final HttpServletResponse httpServletResponse,
                                                final ChPharm5Operations operation) {
        final var searchParameters = ChPharm5SearchParameters.builder()
                .patientIdentifier(patient)
                .status(status)
                .identifier(identifier)
                .setting(setting)
                .date(date)
                .period(period)
                .facility(facility)
                .event(event)
                .securityLabel(securityLabel)
                .format(format)
                .authorFamilyName(authorFamily)
                .authorGivenName(authorGiven)
                .sortSpec(sortSpec)
                .includeSpec(includeSpec)
                .fhirContext(getFhirContext())
                .operation(operation)
                .build();

        // Run down the route
        return requestBundleProvider(null, searchParameters, ResourceType.DocumentReference.name(),
                httpServletRequest, httpServletResponse, requestDetails);
    }
}
