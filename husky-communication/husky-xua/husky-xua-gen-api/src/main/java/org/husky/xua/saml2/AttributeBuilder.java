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

import org.husky.xua.hl7v3.CE;
import org.husky.xua.hl7v3.InstanceIdentifier;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.AttributeType;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the methods of the AttributeBuilder. </div>
 * <div class="de">Interface welches die Methoden des AttributeBuilder beschreibt.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface AttributeBuilder extends SimpleBuilder<AttributeType> {

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

	AttributeBuilder value(Object aValue);

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

	InstanceIdentifier getValueAsInstanceIdentifier();

	CE getValueAsPurposeOfUse();

	CE getValueAsRole();

	String getValueAsString();
}
