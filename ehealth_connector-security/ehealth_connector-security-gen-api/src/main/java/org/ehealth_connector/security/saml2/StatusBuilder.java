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

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the methods of the StatusBuilder.</div>
 * <div class="de">Interface beschreibt die Methoden des StatusBuilder.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface StatusBuilder extends SimpleBuilder<Status> {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the StatusCode of the Status to be build.</div>
	 * <div class="de">Methode um ein StatusCode dem Status hinzuzufügen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aStatusCode
	 *  <div class="en">the StatusCode to be set</div>
	 * 	<div class="de">der StatusCode der gesetzt werden soll</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @return
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle instanz des builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	StatusBuilder statusCode(StatusCode aStatusCode);

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the StatusMessage of the Status to be build.</div>
	 * <div class="de">Methode um ein StatusMessage dem Status hinzuzufügen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aStatusMessage
	 *  <div class="en">the StatusMessage to be set</div>
	 * 	<div class="de">der StatusMessage der gesetzt werden soll</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @return
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle instanz des builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	StatusBuilder statusMessage(String aStatusMessage);

}
