/*
 *
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
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
package org.ehealth_connector.security.exceptions;

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
