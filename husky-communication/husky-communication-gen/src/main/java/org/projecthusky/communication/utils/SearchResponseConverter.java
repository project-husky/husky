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
package org.projecthusky.communication.utils;

import org.apache.commons.lang3.NotImplementedException;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.hl7.fhir.r4.model.Resource;
import org.openehealth.ipf.commons.ihe.xds.core.responses.*;

/**
 * A converter of search responses between XDS and MHD (ITI-18 and ITI-66/67, PHARM-1 and PHARM-5).
 *
 * @author Quentin Ligier
 **/
public class SearchResponseConverter {

    /**
     *
     * @param resource Either a {@link Bundle} or an {@link OperationOutcome}.
     * @return
     */
    public static QueryResponse toXds(final Resource resource) {
        final var response = new QueryResponse();
        if (resource instanceof final OperationOutcome operationOutcome) {
            response.setStatus(Status.FAILURE); // An OperationOutcome is always an error
            operationOutcome.getIssue().forEach(issue -> response.getErrors().add(new ErrorInfo(
                    toXdsErrorCode(issue.getCode()),
                    issue.getDiagnostics(),
                    toXdsSeverity(issue.getSeverity()),
                    (issue.hasLocation()) ? issue.getLocation().get(0).getValue() : null,
                    null
            )));
        } else if (resource instanceof final Bundle bundle) {

            throw new NotImplementedException();
        } else {
            throw new IllegalArgumentException("SearchResponseConverter.toXds: the resource is neither a Bundle nor " +
                                                       "an OperationOutcome");
        }
        return response;
    }

    /**
     *
     * @param queryResponse
     * @return either a {@link Bundle} (in case of success) or an {@link OperationOutcome} (in case of error).
     */
    public static Resource toMhd(final QueryResponse queryResponse) {
        // First, process the issues
        if (queryResponse.getErrors() != null) {

        }

        throw new NotImplementedException();
    }

    public static Severity toXdsSeverity(final OperationOutcome.IssueSeverity severity) {
        if (severity == OperationOutcome.IssueSeverity.WARNING) {
            return Severity.WARNING;
        }
        return Severity.ERROR;
    }

    public static OperationOutcome.IssueSeverity toMhdSeverity(final Severity severity) {
        if (severity == Severity.WARNING) {
            return OperationOutcome.IssueSeverity.WARNING;
        }
        return OperationOutcome.IssueSeverity.ERROR;
    }

    public static ErrorCode toXdsErrorCode(final OperationOutcome.IssueType type) {
        return switch (type) {
            default -> ErrorCode.REGISTRY_ERROR;
        };
    }

    public static OperationOutcome.IssueType toMhdErrorCode(final ErrorCode code) {
        return switch (code) {
            default -> OperationOutcome.IssueType.INVALID;
        };
    }
}
