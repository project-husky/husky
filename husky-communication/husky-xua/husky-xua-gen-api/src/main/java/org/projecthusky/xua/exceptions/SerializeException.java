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
 *
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the SerializeException.</div>
 * <div class="de">Klasse implemetiert die SerializeException.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 *
 * <!-- @formatter:on -->
 */
public class SerializeException extends Exception {

	/** Field referencing the serialVersionUID */
	private static final long serialVersionUID = 7674424286398103789L;

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Default constructor to instanciate the object.</div>
	 * <div class="de">Default Konstruktor für die Instanziierung des Objekts.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * <!-- @formatter:on -->
	 */
	public SerializeException() {
		super();
	}

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Default constructor to instanciate the object.</div>
	 * <div class="de">Default Konstruktor für die Instanziierung des Objekts.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param message
	 * <div class="en">the error message to be set</div>
	 * <div class="de">Die Fehlermeldung welche gesetzt werden soll</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	public SerializeException(String message) {
		super(message);
	}

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Default constructor to instanciate the object.</div>
	 * <div class="de">Default Konstruktor für die Instanziierung des Objekts.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param cause
	 * <div class="en">the cause to be set</div>
	 * <div class="de">der Grund der gesetzt werden soll</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	public SerializeException(Throwable cause) {
		super(cause);
	}

}
