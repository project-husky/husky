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
package org.ehealth_connector.security.communication.xua;

import org.ehealth_connector.security.saml2.Assertion;

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
