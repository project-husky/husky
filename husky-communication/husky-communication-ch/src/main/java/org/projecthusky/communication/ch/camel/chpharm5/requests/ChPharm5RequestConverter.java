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
package org.projecthusky.communication.ch.camel.chpharm5.requests;

import ca.uhn.fhir.rest.server.exceptions.InvalidRequestException;
import ca.uhn.fhir.rest.server.exceptions.UnprocessableEntityException;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.projecthusky.communication.ch.camel.chpharm1.requests.query.ChPharmacyDocumentsQuery;
import org.projecthusky.communication.ch.camel.chpharm5.ChPharm5Operations;

/**
 * Converter of {@link ChPharm5SearchParameters} to {@link ChPharmacyDocumentsQuery}.
 *
 * @author Quentin Ligier
 * @author Oliver Egger
 * @see <a href="https://github.com/i4mi/MobileAccessGateway/blob/1f99e596e80cc03a81cf08634be3b996b7d918f2/src/main/java/ch/bfh/ti/i4mi/mag/mhd/pharm5/Pharm5RequestConverter.java">Pharm5RequestConverter</a>
 **/
public class ChPharm5RequestConverter {

    /**
     * Validates a PHARM-5 request, throwing an {@link UnprocessableEntityException} on validation failure
     */
    public ChPharmacyDocumentsQuery requestConverter(final ChPharm5SearchParameters searchParameters) {
        ensureNotNull(searchParameters.getPatientIdentifier(), "patient.identifier", searchParameters.getOperation());
        ensureNotNull(searchParameters.getPatientIdentifier().getValue(), "patient.identifier[value]",
                searchParameters.getOperation());
        ensureNotNull(searchParameters.getPatientIdentifier().getSystem(), "patient.identifier[system]",
                searchParameters.getOperation());

        ensureNotNull(searchParameters.getStatus(), "status", searchParameters.getOperation());

        searchParameters.getStatus().getValuesAsQueryTokens().stream()
                .filter(t -> !"current".equals(t.getValue()) && !"superseded".equals(t.getValue()))
                .findAny()
                .ifPresent(t -> {throw invalidRequestException(
                        OperationOutcome.IssueType.CODEINVALID,
                        "In PHARM-5 %s operation, the 'status' value '%s' is invalid ('current' or 'superseded' expected)",
                        searchParameters.getOperation().getOperation(),
                        t.getValue()
                );});
        return null;
    }

    void ensureNotNull(final Object parameter,
                              final String parameterName,
                              final ChPharm5Operations operation) {
        if (parameter == null) {
            throw invalidRequestException(
                    OperationOutcome.IssueType.REQUIRED,
                    "In PHARM-5 %s operation, the parameter '%s' shall be set",
                    operation.getOperation(),
                    parameterName
            );
        }
    }

    InvalidRequestException invalidRequestException(final OperationOutcome.IssueType type,
                                                           final String message,
                                                           final Object... args) {
        final var msg = String.format(message,  args);
        final var operationOutcome = new OperationOutcome();
        operationOutcome.addIssue()
                .setSeverity(OperationOutcome.IssueSeverity.ERROR)
                .setCode(type)
                .setDiagnostics(msg);

        final var exception = new InvalidRequestException(msg);
        exception.setOperationOutcome(operationOutcome);
        return exception;
    }
}
