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
package org.projecthusky.xua.saml2;

import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.AssertionType;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.AttributeType;
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
	AssertionBuilder addAttribute(AttributeType aAttribute);

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
	Assertion create();

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to create an instance of type AssertionType.</div>
	 * <div class="de">Methode um eine Instanc des Typs AssertionType zu erstellen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aInternalObject
	 * <div class="en">the internal wrapped object of type AssertionType</div>
	 * <div class="de">das Innere, gewrappte Object vom Typ AssertionType</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return the Object ot the type Assertion
	 * <div class="en">the instance of type Assertion</div>
	 * <div class="de">die erstellte Instanz vom Typ Assertion</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *  <!-- @formatter:on -->
	 */
	Assertion create(AssertionType aInternalObject);

}
