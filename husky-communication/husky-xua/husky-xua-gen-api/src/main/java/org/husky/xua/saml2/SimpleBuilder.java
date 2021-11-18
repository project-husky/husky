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
package org.husky.xua.saml2;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the methods of the SimpleBuilder.</div>
 * <div class="de">Interface welches die Methoden des SimpleBuilders beschreibt.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 * @param <T>
 * <div class="en">the type T.</div>
 * <div class="de">der Typ T.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface SimpleBuilder<T> {
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Creates a concrete instance of T with setted params.</div>
	 * <div class="de">Erstellt die konkrete Instanz von T mit den gesetzten Parametern.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 *  <div class="en">a new instance of T with the params set</div>
	 *  <div class="de">eine neue Instanz von T mit den gesetzten Parametern</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 *  <!-- @formatter:on -->
	 */
	T create();
}
