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
package org.projecthusky.fhir.core.ch.exceptions;

/**
 * An exception thrown when trying to read, parse or validate an content (e.g. a
 * document) that is invalid regarding its specification.
 *
 * @author <a href="roeland.luykx@raly.ch">Roeland Luykx</a>
 */
public class InvalidResourceException extends RuntimeException {

	private static final long serialVersionUID = 2882627095758269008L;

	public InvalidResourceException() {
	}

	public InvalidResourceException(final String message) {
		super(message);
	}

	public InvalidResourceException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public InvalidResourceException(final Throwable cause) {
		super(cause);
	}

	protected InvalidResourceException(final String message, final Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
