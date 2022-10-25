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

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the X-User assertion response builder methods.</div>
 * <div class="de">Interface welches die Methoden des X-User assertion builders beschreibt.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface XUserAssertionResponseBuilder {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Creates a concrete instance of XUserAssertionResponse with setted params.</div>
	 * <div class="de">Erstellt die konkrete Instanz des XUserAssertionResponse mit den gesetzten Parametern.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 *  <div class="en">a new XUserAssertionResponse instance with the params set</div>
	 *  <div class="de">eine neue XUserAssertionResponse Instanz mit den gesetzten Parametern</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 *  <!-- @formatter:on -->
	 */
	XUserAssertionResponse create();

}
