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

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the methods of the AppliesTo builder.</div>
 * <div class="de">Interface beschreibende methoden des AppliesTo builders.</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * <!-- @formatter:on -->
 */
public interface AppliesToBuilder {

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the endpoint ref address</div>
	 * <div class="de">Method um die Endpunktadresse zu setzen.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @param aAddress
	 * <div class="en">The adress to be set.</div>
	 * <div class="de">Die Adresse die gesetzt werden soll.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @return
	 * <!-- @formatter:on -->
	 */
	AppliesToBuilder address(String aAddress);

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Creates a concrete instance of XUserAssertionRequest with setted params.</div>
	 * <div class="de">Erstellt die konkrete instanz des XUserAssertionRequest mit den gesetzten parametern.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @return 
	 *  <div class="en">a new AuthnRequest instance with the params set</div>
	 *  <div class="de">eine neue AuthRequest instanz mit den gesetzten parametern</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 *  <!-- @formatter:on -->
	 */
	AppliesTo create();

}
