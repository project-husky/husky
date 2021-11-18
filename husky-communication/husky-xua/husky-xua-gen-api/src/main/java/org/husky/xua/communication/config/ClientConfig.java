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
 * <div class="en">Interface describing the methods of client configuration.</div>
 * <div class="de">Interface welches die Methoden für die Client Konfiguration beschreibt.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface ClientConfig {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the enpoint url.</div>
	 * <div class="de">Methode um die Ziel Url zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">the enpoind URI.</div>
	 * <div class="de">Die Ziel URI.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	String getUrl();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the enpoint URI.</div>
	 * <div class="de">Methode um die Url des Zielpunktes zu setzen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @param aUrl
	 * <div class="en">the url to be set.</div>
	 * <div class="de">Die Url die zu setzen ist.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	void setUrl(String aUrl);
}
