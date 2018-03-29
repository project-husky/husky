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
package org.ehealth_connector.security.saml2;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the methods of Attribute. </div>
 * <div class="de">Interface beschreibt die Methoden von Attribute.</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * <!-- @formatter:on -->
 */
public interface Attribute {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the name.</div>
	 * <div class="de">Methode um den namen zu holen.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @return
	 * <div class="en">the name as {@link java.lang.String}</div>
	 * <div class="de">der Name als {@link java.lang.String}</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	String getName();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the NameFormat.</div>
	 * <div class="de">Methode um das NameFormat zu holen.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @return
	 * <div class="en">the NameFormat as {@link java.lang.String}</div>
	 * <div class="de">der NameFormat als {@link java.lang.String}</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	String getNameFormat();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the FriendlyName.</div>
	 * <div class="de">Methode um das FriendlyName zu holen.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @return
	 * <div class="en">the FriendlyName as {@link java.lang.String}</div>
	 * <div class="de">der FriendlyName als {@link java.lang.String}</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	String getFriendlyName();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the value.</div>
	 * <div class="de">Methode um das value zu holen.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @return
	 * <div class="en">the value as {@link java.lang.String}</div>
	 * <div class="de">der value als {@link java.lang.String}</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	String getValue();

}
