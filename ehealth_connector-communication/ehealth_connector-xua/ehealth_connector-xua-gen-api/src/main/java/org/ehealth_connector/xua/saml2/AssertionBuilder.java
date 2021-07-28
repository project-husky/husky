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
package org.ehealth_connector.xua.saml2;

import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.AssertionType;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.ConditionsType;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the methods of the AssertionBuilder. </div>
 * <div class="de">Interface welches die Methoden des AssertionBuilders beschreibt.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface AssertionBuilder extends BaseBuilder<AssertionBuilder> {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to add an Attribute to the assertion to be build.</div>
	 * <div class="de">Methode um ein Attribute dem Assertion hinzuzufügen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aAttribute
	 * <div class="en">the Attribute to be added.</div>
	 * <div class="de">das Attribute welches hinzugefügt werden soll.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return
	 * 	<div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	AssertionBuilder addAttribute(Attribute aAttribute);

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to add a Condition to the assertion to be build.</div>
	 * <div class="de">Methode um eine Condition der Assertion hinzuzufügen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aCondition
	 * <div class="en">the Condition to be added.</div>
	 * <div class="de">die Condition welche hinzugefügt werden soll.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return
	 * 	<div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	AssertionBuilder addCondition(ConditionsType aCondition);

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Creates a concrete instance of Assertion with setted params.</div>
	 * <div class="de">Erstellt die konkrete Instanz des Assertion mit den gesetzten Parametern.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 *  <div class="en">a new Assertion instance with the params set</div>
	 *  <div class="de">eine neue Assertion Instanz mit den gesetzten Parametern</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 *  <!-- @formatter:on -->
	 */
	AssertionType create();

}
