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
package org.husky.communication.ch.camel.chpharm5.requests;

import ca.uhn.fhir.rest.param.TokenOrListParam;
import ca.uhn.fhir.rest.param.TokenParam;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Objects;

/**
 * husky
 *
 * @author Quentin Ligier
 **/
public abstract class ChPharm5SearchParameters {

    /**
     * The FHIR operation associated with the search.
     */
    protected final String operation;

    @Nullable
    protected TokenParam patientIdentifier;
    @Nullable
    protected TokenOrListParam format;
    @Nullable
    protected TokenOrListParam status;

    protected ChPharm5SearchParameters(final String operation) {
        this.operation = Objects.requireNonNull(operation);
    }

    public String getOperation() {
        return operation;
    }

    @Nullable
    public TokenParam getPatientIdentifier() {
        return patientIdentifier;
    }

    public void setPatientIdentifier(@Nullable final TokenParam patientIdentifier) {
        this.patientIdentifier = patientIdentifier;
    }

    @Nullable
    public TokenOrListParam getFormat() {
        return format;
    }

    public void setFormat(@Nullable final TokenOrListParam format) {
        this.format = format;
    }

    @Nullable
    public TokenOrListParam getStatus() {
        return status;
    }

    public void setStatus(@Nullable final TokenOrListParam status) {
        this.status = status;
    }
}
