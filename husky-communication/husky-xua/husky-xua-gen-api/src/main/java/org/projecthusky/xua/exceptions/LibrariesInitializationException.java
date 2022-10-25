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
package org.projecthusky.xua.exceptions;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the DeserializeException.</div>
 * <div class="de">Klasse implemetiert die DeserializeException.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class LibrariesInitializationException extends Exception {

	private static final long serialVersionUID = -558241448346503409L;

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Default constructor to instanciate the object.</div>
	 * <div class="de">Default Konstruktor für die instanziierung des objects.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param message
	 * <div class="en">The message of the exception.</div>
	 * <div class="de">Die Nachricht des Fehlers.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	public LibrariesInitializationException(String message) {
		super(message);
	}

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Default constructor to instanciate the object.</div>
	 * <div class="de">Default Konstruktor für die instanziierung des objects.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param message
	 * <div class="en">The message of the exception.</div>
	 * <div class="de">Die Nachricht des Fehlers.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @param cause
	 * <div class="en">The cause of the exception.</div>
	 * <div class="de">Der Grund des Fehlers.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	public LibrariesInitializationException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Default constructor to instanciate the object.</div>
	 * <div class="de">Default Konstruktor für die instanziierung des objects.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param cause
	 * <div class="en">The cause of the exception.</div>
	 * <div class="de">Der Grund des Fehlers.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	public LibrariesInitializationException(Throwable cause) {
		super(cause);
	}

}
