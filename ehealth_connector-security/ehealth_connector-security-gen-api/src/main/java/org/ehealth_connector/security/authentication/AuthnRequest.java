/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland. All rights reserved.
 * https://medshare.net Source code, documentation and other resources have been contributed by various people. Project Team:
 * https://sourceforge.net/p/ehealthconnector/wiki/Team/ For exact developer information, please refer to the commit history of the forge.
 * This code is made available under the terms of the Eclipse Public License v1.0. Accompanying materials are made available under the terms
 * of the Creative Commons Attribution-ShareAlike 4.0 License. This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 */
package org.ehealth_connector.security.authentication;

import java.util.Calendar;

import org.ehealth_connector.security.core.SecurityObject;

/**
 * @since Jan 17, 2018 3:05:16 PM
 *
 */
public interface AuthnRequest<T> extends SecurityObject<T> {

	/**
	 * 
	 * @formatter:off
	 * <div class="en">get the protocol binding value.</div>
	 * <div class="de">holt den protocol binding wert.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @return the protocol binding value as string
	 */
	String getProtocolBinding();

	/**
	 * 
	 * @formatter:off
	 * <div class="en">get the assertion consumer service index.</div>
	 * <div class="de">holt den  wert.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @return the assertion consumer service index as integer
	 */
	Integer getAssertionConsumerServiceIndex();

	/**
	 * 
	 * @formatter:off
	 * <div class="en">get assertion consumer service url.</div>
	 * <div class="de">holt den  wert.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @return the assertion consumer service url as string
	 */
	String getAssertionConsumerServiceURL();

	/**
	 * 
	 * @formatter:off
	 * <div class="en">get attribute consumer service index.</div>
	 * <div class="de">holt den  wert.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @return the attribute consumer service index as integer
	 */
	Integer getAttributeConsumingServiceIndex();

	/**
	 * 
	 * @formatter:off
	 * <div class="en">get the provider name.</div>
	 * <div class="de">holt den  wert.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @return the provider name as string
	 */
	String getProviderName();

	/**
	 * 
	 * @formatter:off
	 * <div class="en">get the value.</div>
	 * <div class="de">holt den  wert.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @return the force authn value
	 */
	Boolean getForceAuthn();

	/**
	 * 
	 * @formatter:off
	 * <div class="en">get the value.</div>
	 * <div class="de">holt den  wert.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @return the consent as string
	 */
	String getConsent();

	/**
	 * 
	 * @formatter:off
	 * <div class="en">get the value.</div>
	 * <div class="de">holt den  wert.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @return
	 */
	String getDestination();

	/**
	 * 
	 * @formatter:off
	 * <div class="en">get the value.</div>
	 * <div class="de">holt den  wert.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @return he issue instant as calendar
	 */
	Calendar getIssueInstant();

	/**
	 * 
	 * @formatter:off
	 * <div class="en">get the value.</div>
	 * <div class="de">holt den  wert.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @return
	 */
	String getID();

	/**
	 * @formatter:off
	 * <div class="en">get the value.</div>
	 * <div class="de">holt den  wert.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @return the issuer value as string
	 */
	String getIssuer();

	/**
	 * @formatter:off
	 * <div class="en">get the value.</div>
	 * <div class="de">holt den  wert.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @return the NameIdPolicy allow create value
	 */
	Boolean getNameIdPolicyAllowCreate();

	/**
	 * @formatter:off
	 * <div class="en">get the value.</div>
	 * <div class="de">holt den  wert.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @return the NameIdPolicy format as string
	 */
	String getNameIdPolicyFormat();
}
