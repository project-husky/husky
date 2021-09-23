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
package org.ehealth_connector.xua.saml2;

import java.util.Calendar;

import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.AuthnStatementType;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the methods of the AuthnStatementBuilder. </div>
 * <div class="de">Interface welches die Methoden des AuthnStatementBuilder beschreibt.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface AuthnStatementBuilder extends SimpleBuilder<AuthnStatementType> {

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the AuthnContextClassRef as Calendar.</div>
	 * <div class="de">Methode um die AuthnContextClassRef as Calendar.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aAuthnContextClassRef
	 * 	<div class="en">the AuthnContextClassRef string to be set.</div>
	 *  <div class="de">der AuthnContextClassRef String der gesetzt werden soll.</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @return
	 * 	<div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	AuthnStatementBuilder authnContextClassRef(String aAuthnContextClassRef);

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the AuthnInstant as Calendar.</div>
	 * <div class="de">Methode um die AuthnInstant as Calendar.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aCalendar
	 * <div class="en">The Calendar value to be set as AuthnInstant.</div>
	 * <div class="de">Der Calendar Wert der als AuthnInstant gesetzt werden soll.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	AuthnStatementBuilder authnInstant(Calendar aCalendar);

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the SessionIndex as Calendar.</div>
	 * <div class="de">Methode um die SessionIndex as Calendar.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aSessionIndex
	 * 	<div class="en">the sessionIndex string to be set.</div>
	 *  <div class="de">der SessionIndex String der gesetzt werden soll.</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @return
	 * 	<div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	AuthnStatementBuilder sessionIndex(String aSessionIndex);

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the SessionNotOnOrAfter as Calendar.</div>
	 * <div class="de">Methode um die SessionNotOnOrAfter als Calendar zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aSessionNotOnOrAfter
	 * 	<div class="en">the SessionNotOnOrAfter as Calendar to be set</div>
	 *  <div class="de">der SessionNotOnOrAfter als Calendar der gesetzt werden soll</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 *
	 * @return
	 * 	<div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	AuthnStatementBuilder sessionNotOnOrAfter(Calendar aSessionNotOnOrAfter);

}
