/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */
package org.husky.xua.exceptions;

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
