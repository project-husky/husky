/*
 * This code is made available under the terms of the Eclipse Public License v1.0 in the github project https://github.com/project-husky/husky there you also find a list of the contributors and the license information.
This project has been developed further and modified by the joined working group Husky on the basis of the eHealth Connector opensource project from June 28, 2021, whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
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
 * <div class="en">Class implementing ValidationException.</div>
 * <div class="de">Klasse welche die ValidationException definiert.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class ValidationException extends Exception {

	/** Field referencing the serialVersionUID */
	private static final long serialVersionUID = -2778057777903172744L;

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
	public ValidationException() {
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
	 * <div class="en">the error message to be set.</div>
	 * <div class="de">Die Fehlermeldung welche gesetzt werden soll.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	public ValidationException(String message) {
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
	 * <div class="en">the reason of the exception.</div>
	 * <div class="de">Der Grund des Fehlers<./div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	public ValidationException(Throwable cause) {
		super(cause);
	}

}
