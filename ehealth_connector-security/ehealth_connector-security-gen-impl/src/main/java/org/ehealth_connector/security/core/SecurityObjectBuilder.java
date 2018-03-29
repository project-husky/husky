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
 * <div class="en">Interface describing the generic methods for SecurityObjectBuilder using the templated type T and U.</div>
 * <div class="de">Interface beschreibt die Methoden des SecurityObjectBuilder unter der Verwendung der templated Typen T und T.</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
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
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @param aInternalObject 
	 * <div class="en">the internal wrapped object of type T</div>
	 * <div class="de">das innere gewrappte Object vom Typ T</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @return the Object ot the type U
	 * <div class="en">the instance of type U</div>
	 * <div class="de">die erstellte Instanz vom Typ U</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *  <!-- @formatter:on -->
	 */
	U create(T aInternalObject);
}
