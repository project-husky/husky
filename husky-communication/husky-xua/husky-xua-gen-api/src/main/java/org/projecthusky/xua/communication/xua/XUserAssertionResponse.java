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
package org.projecthusky.xua.communication.xua;

import org.projecthusky.xua.saml2.Assertion;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the methods of XUserAssertionResponse.</div>
 * <div class="de">Interface welches die Methoden für den XUserAssertionResponse beschreibt.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface XUserAssertionResponse {

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the assertion.</div>
	 * <div class="de">Methode um die Assertion zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">The assertion.</div>
	 * <div class="de">Die Assertion.</div>
	 * <!-- @formatter:on -->
	 */
	Assertion getAssertion();

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the context.</div>
	 * <div class="de">Methode um den Context zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">The context.</div>
	 * <div class="de">Der Context.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	String getContext();

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the status.</div>
	 * <div class="de">Methode um den Status zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">The status.</div>
	 * <div class="de">Die Status.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	String getStatus();

}
