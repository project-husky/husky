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
package org.ehealth_connector.xua.wssecurity;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the methods of the UsernameTokenBuilder.</div>
 * <div class="de">Interface welches die Methoden des UsernameTokenBuilders beschreibt.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface UsernameTokenBuilder {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Creates a concrete instance of UsernameToken with setted params.</div>
	 * <div class="de">Erstellt die konkrete Instanz von UsernameToken mit den gesetzten Parametern.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 *  <div class="en">a new instance of UsernameToken with the params set</div>
	 *  <div class="de">eine neue Instanz von UsernameToken mit den gesetzten Parametern</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 *  <!-- @formatter:on -->
	 */
	UsernameToken create();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the nonce (randonm value) of the UsernameToken to be build.</div>
	 * <div class="de">Methode um den Nonce (Zufallswert) dem UsernameToken hinzuzufügen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aNonce
	 *  <div class="en">the nonce to be set</div>
	 *  <div class="de">der Nonce der gesetzt werden soll</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @return
	 * 	<div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	UsernameTokenBuilder nonce(String aNonce);

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the password of the UsernameToken to be build.</div>
	 * <div class="de">Methode um das Passwort dem UsernameToken hinzuzufügen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aPassword
	 *  <div class="en">the password to be set</div>
	 *  <div class="de">das Passwort das gesetzt werden soll</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @return
	 * 	<div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	UsernameTokenBuilder password(String aPassword);

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the username of the UsernameToken to be build.</div>
	 * <div class="de">Methode um den Usernamen dem UsernameToken hinzuzufügen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aUsername
	 *  <div class="en">the username to be set</div>
	 *  <div class="de">der Usernamen der gesetzt werden soll</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @return
	 * 	<div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	UsernameTokenBuilder username(String aUsername);
}
