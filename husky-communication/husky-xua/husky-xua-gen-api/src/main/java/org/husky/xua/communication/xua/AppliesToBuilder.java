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
package org.husky.xua.communication.xua;

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
