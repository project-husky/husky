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
package org.ehealth_connector.security.saml2;

import java.util.Calendar;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the methods of AuthnStatement. </div>
 * <div class="de">Interface welches die Methoden von AuthnStatement beschreibt.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface AuthnStatement {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the AuthnContextClassRef.</div>
	 * <div class="de">Methode um die AuthnContextClassRef zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return
	 * <div class="en">the ClassRef as string.</div>
	 * <div class="de">der ClassRef als String.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	String getAuthnContextClassRef();

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">method to get the AuthInstant.</div>
	 * <div class="de">Methode um die AuthInstant zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return
	 * <div class="en">the Calendar instance representing the value of AuthnInstant.</div>
	 * <div class="de">die Calendar Instanz die den AuthInstance Wert repräsentiert.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	Calendar getAuthnInstant();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the Date Index of the Session.</div>
	 * <div class="de">Methode um das Datum Index der Session zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return
	 * <div class="en">the Index as string.</div>
	 * <div class="de">der Index als String.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	String getSessionIndex();

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the Date NotOnOrAfter of the Session.</div>
	 * <div class="de">Methode um das Datum NotOnOrAfter der Session zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return
	 * <div class="en">the Calendar instance representing the value of NotOnOrAfter.</div>
	 * <div class="de">die Calendar Instanz die den NotOnOrAfter Wert repräsentiert.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	Calendar getSessionNotOnOrAfter();
}
