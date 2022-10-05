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
package org.projecthusky.fhir.emed.ch.common.errors;

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
