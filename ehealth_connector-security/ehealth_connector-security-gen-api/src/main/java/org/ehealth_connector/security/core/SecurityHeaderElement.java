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
package org.ehealth_connector.security.core;

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
