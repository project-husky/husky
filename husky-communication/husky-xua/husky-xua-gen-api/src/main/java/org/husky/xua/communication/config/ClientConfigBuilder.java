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
package org.husky.xua.communication.config;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the ClientConfigBuilder methods.</div>
 * <div class="de">Interface welches die Methoden des ClientConfigBuilders beschreibt.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface ClientConfigBuilder {

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the enpoint URI.</div>
	 * <div class="de">Methode um die Enpunkt URI zu bilden.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aEndpointUrl
	 * <div class="en">the enpoint URI to be set.</div>
	 * <div class="de">Die Enpunkt URI die zu setzen ist.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return
	 * <div class="en">the actual instance of this builder</div>
	 * <div class="de">die aktuelle Instanz des Builders</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	ClientConfigBuilder url(String aEndpointUrl);

}
