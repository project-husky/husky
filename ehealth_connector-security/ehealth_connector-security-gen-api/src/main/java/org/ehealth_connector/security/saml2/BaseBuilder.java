/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland. All rights reserved.
 * https://medshare.net Source code, documentation and other resources have been contributed by various people. Project Team:
 * https://sourceforge.net/p/ehealthconnector/wiki/Team/ For exact developer information, please refer to the commit history of the forge.
 * This code is made available under the terms of the Eclipse Public License v1.0. Accompanying materials are made available under the terms
 * of the Creative Commons Attribution-ShareAlike 4.0 License. This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 */
package org.ehealth_connector.security.saml2;

import java.util.Calendar;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the methods of the BaseBuilder.</div>
 * <div class="de">Interface beschreibt die Methoden des BaseBuilders.</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * 
 * <!-- @formatter:on -->
 */
public interface BaseBuilder<T> {

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Builds the id on the T.</div>
	 * <div class="de">Bildet die id im T.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 *
	 * @param aId 
	 * 	<div class="en">the id string to be set</div>
	 *  <div class="de">der id string der gesetzt werden soll</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 * @return 
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle instanz des builders</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 *  <!-- @formatter:on -->
	 */
	T id(String aId);

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Builds the issueInstant on the T.</div>
	 * <div class="de">Bildet den issueInstant im T.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @param aIssueInstant
	 * 	<div class="en">the issueInstant to be set</div>
	 * 	<div class="de">der issue instant der gesetzt werden soll</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 * @return 
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle instanz des builders</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 *  <!-- @formatter:on -->
	 */
	T issueInstant(Calendar aIssueInstant);

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Builds the Issuer element on the T.</div>
	 * <div class="de">Buildet das Issuer element im T.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * 
	 * @param aIssuer
	 *  <div class="en">the issuer to be set</div>
	 * 	<div class="de">der issuer der gesetzt werden soll</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 * @return 
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle instanz des builders</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 *  <!-- @formatter:on -->
	 */
	T issuer(String aIssuer);

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Builds the Version on the T.</div>
	 * <div class="de">Buildet das Version im T.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * 
	 * @param aVersion
	 *  <div class="en">the issuer to be set</div>
	 * 	<div class="de">der issuer der gesetzt werden soll</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 * @return 
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle instanz des builders</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 *  <!-- @formatter:on -->
	 */
	T version(String aVersion);

}
