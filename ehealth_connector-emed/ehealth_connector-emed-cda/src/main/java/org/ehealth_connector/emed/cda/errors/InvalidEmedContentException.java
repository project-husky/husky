package org.ehealth_connector.emed.cda.errors;

/**
 * An exception thrown when trying to read, parse or validate an Emed content (e.g. a document) that is invalid
 * regarding its specification.
 *
 * @author Quentin Ligier
 */
public class InvalidEmedContentException extends RuntimeException {
    static final long serialVersionUID = -5742843912864698384L;

    public InvalidEmedContentException() {
    }

    public InvalidEmedContentException(final String message) {
        super(message);
    }

    public InvalidEmedContentException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public InvalidEmedContentException(final Throwable cause) {
        super(cause);
    }

    protected InvalidEmedContentException(final String message,
                                          final Throwable cause,
                                          boolean enableSuppression,
                                          boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
