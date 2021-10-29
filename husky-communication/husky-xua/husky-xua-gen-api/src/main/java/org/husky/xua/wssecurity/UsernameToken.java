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
package org.husky.xua.wssecurity;

import org.husky.xua.core.SecurityHeaderElement;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface decribing the methods of UsernameToken</div>
 * <div class="de">Interface welches die Methoden von UsernameToken beschreibt</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface UsernameToken extends SecurityHeaderElement {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the nonce.</div>
	 * <div class="de">Methode um den Nonce zu erhalten</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">the nonce (random value) as string.</div>
	 * <div class="de">Den Nonce (Zufallswert) als String.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	String getNonce();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the password.</div>
	 * <div class="de">Methode um das Passwort zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">the password.</div>
	 * <div class="de">das Passwort.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	String getPassword();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the username.</div>
	 * <div class="de">Methode um den Usernamen zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">the username.</div>
	 * <div class="de">den Username.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	String getUsername();

}
