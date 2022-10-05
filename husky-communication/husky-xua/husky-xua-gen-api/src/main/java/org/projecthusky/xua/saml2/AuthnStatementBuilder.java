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
package org.projecthusky.xua.saml2;

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
