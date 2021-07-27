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

import java.util.Calendar;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the methods of the BaseBuilder.</div>
 * <div class="de">Interface welches die Methoden des BaseBuilders beschreibt.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 *
 * <!-- @formatter:on -->
 */
public interface BaseBuilder<T> {

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Builds the id on the T.</div>
	 * <div class="de">Bildet die ID im T.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 *
	 * @param aId
	 * 	<div class="en">the id string to be set</div>
	 *  <div class="de">die ID die gesetzt werden soll</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @return
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 *  <!-- @formatter:on -->
	 */
	T id(String aId);

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Builds the issueInstant on the T.</div>
	 * <div class="de">Bildet den issueInstant im T.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aIssueInstant
	 * 	<div class="en">the issueInstant to be set</div>
	 * 	<div class="de">der issueInstant der gesetzt werden soll</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @return
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 *  <!-- @formatter:on -->
	 */
	T issueInstant(Calendar aIssueInstant);

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Builds the Issuer element on the T.</div>
	 * <div class="de">Buildet das Issuer element im T.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aIssuer
	 *  <div class="en">the issuer to be set</div>
	 * 	<div class="de">der Issuer der gesetzt werden soll</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @return
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 *  <!-- @formatter:on -->
	 */
	T issuer(String aIssuer);

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Builds the Version on the T.</div>
	 * <div class="de">Buildet die Version im T.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aVersion
	 *  <div class="en">the issuer to be set</div>
	 * 	<div class="de">der Issuer der gesetzt werden soll</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @return
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 *  <!-- @formatter:on -->
	 */
	T version(String aVersion);

}
