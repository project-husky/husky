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
 * <div class="en">Class implementing ValidationException.</div>
 * <div class="de">Klasse welche die ValidationException definiert.</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * <!-- @formatter:on -->
 */
public class ValidationException extends Exception {

	/** Field referencing the serialVersionUID */
	private static final long serialVersionUID = -2778057777903172744L;

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Default constructor to instanciate the object.</div>
	 * <div class="de">Default Konstruktor für die instanziierung des objects.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
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
	 * <div class="de">Default Konstruktor für die instanziierung des objects.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * 
	 * @param cause
	 * <div class="en">the reason of the exception.</div>
	 * <div class="de">Der Grund des Fehlers</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	public ValidationException(Throwable cause) {
		super(cause);
	}

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Default constructor to instanciate the object.</div>
	 * <div class="de">Default Konstruktor für die instanziierung des objects.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * 
	 * @param message
	 * <div class="en">the error message to be set</div>
	 * <div class="de">Die Errormessage welche gesetzt werde soll</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	public ValidationException(String message) {
		super(message);
	}

}
