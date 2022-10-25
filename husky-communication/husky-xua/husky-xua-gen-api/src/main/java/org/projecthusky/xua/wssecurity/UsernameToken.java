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
package org.projecthusky.xua.wssecurity;

import org.projecthusky.xua.core.SecurityHeaderElement;

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
