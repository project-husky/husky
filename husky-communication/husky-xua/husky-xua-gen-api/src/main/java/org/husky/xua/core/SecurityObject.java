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
 *
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the generic methods of SecurityObject for the templated type T.</div>
 * <div class="de">Interface welches die Methoden des SecurityObject für den templated Typ T beschreibt.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * @param <T>
 * <div class="en">the type T.</div>
 * <div class="de">der Typ T.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface SecurityObject<T> {

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the wrapped inner object.</div>
	 * <div class="de">Methode um das Innere, gewrappte object zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 *
	 * @return returns the wrapped inner object (depends on implementation)
	 */
	T getWrappedObject();

}
