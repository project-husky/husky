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

import org.hl7.fhir.r4.model.Parameters;
import org.hl7.fhir.r4.model.StringType;
import org.openehealth.ipf.commons.audit.AuditContext;
import org.openehealth.ipf.commons.audit.codes.ParticipantObjectTypeCode;
import org.openehealth.ipf.commons.audit.codes.ParticipantObjectTypeCodeRole;
import org.openehealth.ipf.commons.audit.model.AuditMessage;
import org.openehealth.ipf.commons.audit.model.TypeValuePairType;
import org.openehealth.ipf.commons.ihe.core.atna.event.DefaultQueryInformationBuilder;
import org.openehealth.ipf.commons.ihe.fhir.Constants;
import org.openehealth.ipf.commons.ihe.fhir.audit.FhirQueryAuditDataset;
import org.openehealth.ipf.commons.ihe.fhir.audit.FhirQueryAuditStrategy;
import org.openehealth.ipf.commons.ihe.fhir.audit.codes.FhirEventTypeCode;
import org.openehealth.ipf.commons.ihe.fhir.audit.codes.FhirParticipantObjectIdTypeCode;
import org.openehealth.ipf.commons.ihe.fhir.pharm5.Pharm5SearchParameters;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

import static org.openehealth.ipf.commons.ihe.fhir.Constants.HTTP_QUERY;
import static org.openehealth.ipf.commons.ihe.fhir.Constants.HTTP_URL;

/**
 * Generic Audit Strategy for CH:PHARM-5 query transactions
 *
 * @author Quentin Ligier
 **/
public class ChPharm5AuditStrategy extends FhirQueryAuditStrategy {

    public ChPharm5AuditStrategy(final boolean serverSide) {
        super(serverSide);
    }


    public AuditMessage[] makeAuditMessage(final AuditContext auditContext,
                                           final FhirQueryAuditDataset auditDataset) {
        var operation = "unknown";
        final var endpointUrl = auditDataset.getDestinationUserId();
        if (endpointUrl != null && endpointUrl.lastIndexOf("$") >= 0) {
            operation = endpointUrl.substring(endpointUrl.lastIndexOf("$"));
        }
        return new DefaultQueryInformationBuilder(auditContext,
                                             auditDataset,
                                             FhirEventTypeCode.QueryPharmacyDocumentsOverMhd)
                .addPatients(auditDataset.getPatientIds())
                .setQueryParameters(
                        operation,
                        FhirParticipantObjectIdTypeCode.QueryPharmacyDocumentsOverMhd,
                        auditDataset.getQueryString(),
                        ParticipantObjectTypeCode.System,
                        ParticipantObjectTypeCodeRole.Query,
                        List.of(new TypeValuePairType("QueryEncoding", "UTF-8")))
                .getMessages();
    }

    /**
     * Further enrich the audit dataset: add query string and patient IDs in the search parameter (if available).
     *
     * @param auditDataset audit dataset
     * @param request      request object
     * @param parameters   request parameters
     * @return enriched audit dataset
     */
    @Override
    public FhirQueryAuditDataset enrichAuditDatasetFromRequest(final FhirQueryAuditDataset auditDataset,
                                                               final Object request,
                                                               final Map<String, Object> parameters) {
        final var dataset = super.enrichAuditDatasetFromRequest(auditDataset, request, parameters);

        final BiConsumer<String, String> addPatientId = (value, system) -> {
            system = (system.startsWith("urn:oid:")) ?
                    system.substring(8) :
                    system;
            dataset.getPatientIds().add(String.format("%s^^^&%s&ISO", value, system));
        };

        final var searchParameters = (Pharm5SearchParameters) parameters.get(Constants.FHIR_REQUEST_PARAMETERS);
        if (searchParameters != null) {
            final var tokenParams = searchParameters.getPatientIdParam();
            if (tokenParams != null) {
                tokenParams.forEach(t -> addPatientId.accept(t.getValue(), t.getSystem()));
            }
        } else if (request instanceof final Parameters bodyParameters) {
            final var patientIdentifier = bodyParameters.getParameterValues(ChPharm5ResourceProvider.SP_PATIENT_IDENTIFIER);
            if (patientIdentifier instanceof StringType) {
                final var parts = ((StringType) patientIdentifier).getValue().split("\\|");
                addPatientId.accept(parts[1], parts[0]);
            }
        }

        if (parameters.containsKey(HTTP_QUERY)) {
            dataset.setQueryString(URLDecoder.decode((String) parameters.get(HTTP_QUERY), StandardCharsets.UTF_8));
        }
        if (parameters.containsKey(HTTP_URL)) {
            dataset.setServiceEndpointUrl(URLDecoder.decode((String) parameters.get(HTTP_URL), StandardCharsets.UTF_8));
        }

        return dataset;
    }

    @Override
    public FhirQueryAuditDataset createAuditDataset() {
        return new FhirQueryAuditDataset(isServerSide());
    }
}
