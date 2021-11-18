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

import java.util.Calendar;

import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.SubjectConfirmationType;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the methods of the SubjectConfirmation.</div>
 * <div class="de">Interface welches die Methoden des SubjectConfirmation beschreibt.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface SubjectConfirmationBuilder extends SimpleBuilder<SubjectConfirmationType> {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the Address of the SubjectConfirmation to be build.</div>
	 * <div class="de">Methode um ein Address dem SubjectConfirmation hinzuzufügen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aAddress
	 *  <div class="en">the Address to be set</div>
	 * 	<div class="de">die Addresse die gesetzt werden soll</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @return
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	SubjectConfirmationBuilder address(String aAddress);

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the InResponseTo of the SubjectConfirmation to be build.</div>
	 * <div class="de">Methode um ein InResponseTo dem SubjectConfirmation hinzuzufügen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aInResponseTo
	 *  <div class="en">the InResponseTo to be set</div>
	 * 	<div class="de">die InResponseTo die gesetzt werden soll</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @return
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	SubjectConfirmationBuilder inResponseTo(String aInResponseTo);

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the Method of the SubjectConfirmation to be build.</div>
	 * <div class="de">Methode um ein Method dem SubjectConfirmation hinzuzufügen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aMethod
	 *  <div class="en">the Method to be set</div>
	 * 	<div class="de">die Method die gesetzt werden soll</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @return
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	SubjectConfirmationBuilder method(String aMethod);

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the NotBefore of the SubjectConfirmation to be build.</div>
	 * <div class="de">Methode um ein NotBefore dem SubjectConfirmation hinzuzufügen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aNotBefore
	 *  <div class="en">the NotBefore to be set</div>
	 * 	<div class="de">die NotBefore die gesetzt werden soll</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @return
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	SubjectConfirmationBuilder notBefore(Calendar aNotBefore);

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the NotOnOrAfter of the SubjectConfirmation to be build.</div>
	 * <div class="de">Methode um ein NotOnOrAfter dem SubjectConfirmation hinzuzufügen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aNotOnOrAfter
	 *  <div class="en">the NotOnOrAfter to be set</div>
	 * 	<div class="de">die NotOnOrAfter die gesetzt werden soll</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @return
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	SubjectConfirmationBuilder notOnOrAfter(Calendar aNotOnOrAfter);

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the Recipient of the SubjectConfirmation to be build.</div>
	 * <div class="de">Methode um ein Recipient dem SubjectConfirmation hinzuzufügen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aRecipient
	 *  <div class="en">the Recipient to be set</div>
	 * 	<div class="de">die Recipient die gesetzt werden soll</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @return
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	SubjectConfirmationBuilder recipient(String aRecipient);

}
