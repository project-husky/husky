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
package org.ehealth_connector.valueset.exceptions;

/**
 * <div class="en">Exception in case the value set configuration is
 * invalid.</div>
 *
 * <div class="de">Ausnahme für den Fall, dass die Wertemenegenkonfiguration
 * ungültig ist.<div>
 */
public class ConfigurationException extends Exception {

	/** The generated constant serialVersionUID. */
	private static final long serialVersionUID = 5998358174203522368L;

	/**
	 * <div class="en">Default constructor to instantiate the object. A
	 * predefined text message will be used.</div>
	 *
	 * <div class="de">Standardkonstruktor zum Instanziieren des Objekts. Eine
	 * vordefinierte Textnachricht wird verwendet.<div>
	 */
	public ConfigurationException() {
		super("The value set configuration cannot be loaded. Please check the config file/stream.");
	}

	/**
	 * <div class="en">Instantiates a new configuration exception by using the
	 * given text message.</div>
	 *
	 * <div class="de">Instanziiert eine neue Konfigurationsausnahme unter
	 * Verwendung der angegebenen Textnachricht.<div>
	 *
	 * @param message
	 *            the message
	 */
	public ConfigurationException(String message) {
		super(message);
	}
}
