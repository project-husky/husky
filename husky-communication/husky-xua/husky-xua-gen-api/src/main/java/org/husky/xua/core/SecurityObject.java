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
