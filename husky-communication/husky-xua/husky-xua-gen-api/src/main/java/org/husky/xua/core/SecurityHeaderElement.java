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
package org.husky.xua.core;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the methods of SecurityHeaderElement. </div>
 * <div class="de">Interface welches die Methoden von SecurityHeaderElement beschreibt.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface SecurityHeaderElement {

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the wrapped object.</div>
	 * <div class="de">Methode um das gewrappte Objekt zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">The wrapped object.</div>
	 * <div class="de">Das gewrappte Objekt.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	Object getWrappedObject();

}
