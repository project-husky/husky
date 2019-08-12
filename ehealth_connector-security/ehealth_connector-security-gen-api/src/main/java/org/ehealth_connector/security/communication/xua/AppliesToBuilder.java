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
package org.ehealth_connector.security.communication.xua;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the methods of the AppliesTo builder.</div>
 * <div class="de">Interface welches die Methoden des AppliesTo Builders beschreibt.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface AppliesToBuilder {

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the endpoint address</div>
	 * <div class="de">Methode um die Endpunktadresse zu setzen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aAddress
	 * <div class="en">The adress to be set.</div>
	 * <div class="de">Die Adresse die gesetzt werden soll.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return
	 * <!-- @formatter:on -->
	 */
	AppliesToBuilder address(String aAddress);

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Creates a concrete instance of XUserAssertionRequest with setted params.</div>
	 * <div class="de">Erstellt die konkrete Instanz des XUserAssertionRequest mit den gesetzten Parametern.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 *  <div class="en">a new AppliesTo instance with the params set</div>
	 *  <div class="de">eine neue AppliesTo Instanz mit den gesetzten Parametern</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 *  <!-- @formatter:on -->
	 */
	AppliesTo create();

}
