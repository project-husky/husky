/*
 * This code is made available under the terms of the Eclipse Public License v1.0 in the github project https://github.com/project-husky/husky there you also find a list of the contributors and the license information.
This project has been developed further and modified by the joined working group Husky on the basis of the eHealth Connector opensource project from June 28, 2021, whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
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
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the generic methods for SecurityObjectBuilder using the templated type T and U.</div>
 * <div class="de">Interface welches die Methoden des SecurityObjectBuilder unter der Verwendung der templated Typen T und U beschreibt.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 *
 * @param <T>
 * @param <U>
 * <!-- @formatter:on -->
 */
public interface SecurityObjectBuilder<T, U> {

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to create an instance of type T.</div>
	 * <div class="de">Methode um eine Instanc des Typs T zu erstellen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aInternalObject
	 * <div class="en">the internal wrapped object of type T</div>
	 * <div class="de">das Innere, gewrappte Object vom Typ T</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return the Object ot the type U
	 * <div class="en">the instance of type U</div>
	 * <div class="de">die erstellte Instanz vom Typ U</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *  <!-- @formatter:on -->
	 */
	U create(T aInternalObject);

}
