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
package org.ehealth_connector.security.saml2;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the methods of the AttributeBuilder. </div>
 * <div class="de">Interface welches die Methoden des AttributeBuilder beschreibt.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface AttributeBuilder extends SimpleBuilder<Attribute> {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the FriendlyName of the Attribute to be build.</div>
	 * <div class="de">Methode um ein FriendlyName dem Attribute hinzuzufügen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aFriendlyName
	 * <div class="en">the FriendlyName to be added.</div>
	 * <div class="de">das FriendlyName welches hinzugefügt werden soll.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return
	 * 	<div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	AttributeBuilder friendlyName(String aFriendlyName);

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the name of the Attribute to be build.</div>
	 * <div class="de">Methode um ein name dem Attribute hinzuzufügen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aName
	 * <div class="en">the name to be added.</div>
	 * <div class="de">der Name welcher hinzugefügt werden soll.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return
	 * 	<div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	AttributeBuilder name(String aName);

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the NameFormat of the Attribute to be build.</div>
	 * <div class="de">Methode um ein NameFormat dem Attribute hinzuzufügen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aNameFormat
	 * <div class="en">the NameFormat to be added.</div>
	 * <div class="de">das NameFormat welches hinzugefügt werden soll.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return
	 * 	<div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	AttributeBuilder nameFormat(String aNameFormat);

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the value of the Attribute to be build.</div>
	 * <div class="de">Methode um ein value dem Attribute hinzuzufügen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aValue
	 * <div class="en">the value to be added.</div>
	 * <div class="de">der Wert welcher hinzugefügt werden soll.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return
	 * 	<div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	AttributeBuilder value(String aValue);

}
