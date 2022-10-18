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
package org.projecthusky.fhir.emed.ch.common.error;

import java.util.Objects;

/**
 * Exception thrown when encountering an Emed item that would put the medication treatment into an invalid state if
 * aggregated.
 *
 * @author Quentin Ligier
 */
public class InvalidMedicationTreatmentStateException extends RuntimeException {

    /**
     * Constructor.
     *
     * @param message The detail message.
     */
    public InvalidMedicationTreatmentStateException(final String message) {
        super(message);
        Objects.requireNonNull(message);
    }
}
