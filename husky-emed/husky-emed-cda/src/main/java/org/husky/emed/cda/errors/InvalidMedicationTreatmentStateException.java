package org.husky.emed.cda.errors;

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
