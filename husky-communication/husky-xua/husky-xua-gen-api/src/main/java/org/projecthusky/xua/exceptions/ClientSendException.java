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
 * <div class="en">Class implementing ClientSendException.</div>
 * <div class="de">Klasse welche die ClientSendException implementiert.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class ClientSendException extends Exception {

	/** <!-- @formatter:off -->
	 * <div class="en">Field referencing the serialVersionUID </div>
	 * <div class="de">Feld mit der serialVersionUID reference</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	*/
	private static final long serialVersionUID = -7999422268809408320L;

	public ClientSendException(String message) {
		super(message);
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Default constructor to instanciate the object.</div>
	 * <div class="de">Default Konstruktor für die Instanziierung des Objekts.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param message
	 * <div class="en">the textual descriptin of the exception.</div>
	 * <div class="de">Die textuelle Beschreibung des Fehlers.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param cause
	 * <div class="en">The reason of the exception.</div>
	 * <div class="de">Der Grund des Fehlers.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	public ClientSendException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Default constructor to instanciate the object.</div>
	 * <div class="de">Default Konstruktor für die Instanziierung des Objekts.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param cause
	 * <div class="en">The reason of the exception.</div>
	 * <div class="de">Der Grund des Fehlers.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	public ClientSendException(Throwable cause) {
		super(cause);
	}

}
