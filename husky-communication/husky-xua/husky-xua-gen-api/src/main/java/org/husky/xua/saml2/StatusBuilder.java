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
package org.husky.xua.saml2;

import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.protocol.StatusType;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the methods of the StatusBuilder.</div>
 * <div class="de">Interface welches die Methoden des StatusBuilders beschreibt.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface StatusBuilder extends SimpleBuilder<Status> {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the StatusCode of the Status to be build.</div>
	 * <div class="de">Methode um ein StatusCode dem Status hinzuzufügen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aStatusCode
	 *  <div class="en">the StatusCode to be set</div>
	 * 	<div class="de">der StatusCode der gesetzt werden soll</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @return
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	StatusBuilder statusCode(StatusCode aStatusCode);

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the StatusMessage of the Status to be build.</div>
	 * <div class="de">Methode um eine StatusMessage dem Status hinzuzufügen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aStatusMessage
	 *  <div class="en">the StatusMessage to be set</div>
	 * 	<div class="de">die StatusMessage der gesetzt werden soll</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @return
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	StatusBuilder statusMessage(String aStatusMessage);

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to create an instance of type StatusType.</div>
	 * <div class="de">Methode um eine Instanc des Typs StatusType zu erstellen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aInternalObject
	 * <div class="en">the internal wrapped object of type StatusType</div>
	 * <div class="de">das Innere, gewrappte Object vom Typ StatusType</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return the Object ot the type StatusBuilder
	 * <div class="en">the instance of type StatusBuilder</div>
	 * <div class="de">die erstellte Instanz vom Typ StatusBuilder</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *  <!-- @formatter:on -->
	 */
	Status create(StatusType aInternalObject);

}
