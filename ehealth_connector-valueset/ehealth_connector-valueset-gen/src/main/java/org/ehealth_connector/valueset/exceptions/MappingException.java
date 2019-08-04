/*
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
package org.ehealth_connector.valueset.exceptions;

/**
 * <div class="en">Exception in case the value set mapping does not exist.</div>
 *
 * <div class="de">Ausnahme für den Fall, dass die Wertemengenzuordnung nicht
 * existiert.<div>
 */
public class MappingException extends Exception {

	/** The generated constant serialVersionUID. */
	private static final long serialVersionUID = -1454634787837958402L;

	/**
	 * div class="en">Default constructor to instantiate the object. A
	 * predefined text message will be used.</div>
	 *
	 * <div class="de">Standardkonstruktor zum Instanziieren des Objekts. Eine
	 * vordefinierte Textnachricht wird verwendet.<div>
	 */
	public MappingException() {
		super("The requested mapping does not exist.");
	}

	/**
	 * div class="en">Instantiates a new mapping exception by using the given
	 * text message.</div>
	 *
	 * <div class="de">Instanziiert eine neue Zuordnungsausnahme mithilfe der
	 * angegebenen Textnachricht.<div>
	 *
	 * @param message
	 *            the message
	 */
	public MappingException(String message) {
		super(message);
	}

}