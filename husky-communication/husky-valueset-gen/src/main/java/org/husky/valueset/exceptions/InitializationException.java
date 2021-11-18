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
package org.husky.valueset.exceptions;

/**
 * <div class="en">Exception in case the value set initialization fails.</div>
 *
 * <div class="de">Ausnahme für den Fall, dass die Initialisierung der
 * Wertemenge fehlschlägt.<div>
 */
public class InitializationException extends Exception {

	/** The generated constant serialVersionUID. */
	private static final long serialVersionUID = 1057252687989322065L;

	/**
	 * div class="en">Default constructor to instantiate the object. A
	 * predefined text message will be used.</div>
	 *
	 * <div class="de">Standardkonstruktor zum Instanziieren des Objekts. Eine
	 * vordefinierte Textnachricht wird verwendet.<div>
	 */
	public InitializationException() {
		super("The value set cannot be loaded. Please check the content of the file/stream.");
	}

	/**
	 * div class="en">Instantiates a new initialization exception by using the
	 * given text message.</div>
	 *
	 * <div class="de">Instanziiert eine neue Initialisierungsausnahme unter
	 * Verwendung der angegebenen Textnachricht.<div>
	 *
	 * @param message
	 *            the message
	 */
	public InitializationException(String message) {
		super(message);
	}
}
