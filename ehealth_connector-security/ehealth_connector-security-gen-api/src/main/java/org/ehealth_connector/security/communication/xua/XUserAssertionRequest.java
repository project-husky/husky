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
package org.ehealth_connector.security.communication.xua;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the methods of xuserassertionrequest.</div>
 * <div class="de">Interface beschreibt die Methoden für den xuserassertionrequest.</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * <!-- @formatter:on -->
 */
public interface XUserAssertionRequest {

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the id of the accessor.</div>
	 * <div class="de">Method um die Id des Zugreifers zu erhalten.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @return
	 * <div class="en">The accessor id as string</div>
	 * <div class="de">die Id des Zugreifers als String</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	String getSubjectId();

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the name of the accessor.</div>
	 * <div class="de">Method um den Namen des Zugreifers zu erhalten.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @return
	 * <div class="en">The accessor name as string</div>
	 * <div class="de">der Name des Zugreifers als String</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	String getSubjectName();

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the role of the accessor.</div>
	 * <div class="de">Method um die  Rolle des Zugreifers zu erhalten.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @return
	 * <div class="en">The role of the accessor as string</div>
	 * <div class="de">die Rolle des Zugreifers als String</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	String getSubjectRole();

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the organisation id of the accessor.</div>
	 * <div class="de">Method um die Id der Organisation des Zugreifers zu erhalten.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @return
	 * <div class="en">The organisation id as string</div>
	 * <div class="de">die Organisations ID des Zugreifers als String</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	String getOrganizationId();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the organisation name of the accessor.</div>
	 * <div class="de">Method um den namen der Organisation des Zugreifers zu erhalten.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @return
	 * <div class="en">The organisation name as string</div>
	 * <div class="de">die Organisations Name des Zugreifers als String</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	String getOrganizationName();

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the resource id.</div>
	 * <div class="de">Method um die ressourcen Id zu erhalten.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @return
	 * <div class="en">The resource id as string</div>
	 * <div class="de">die ressourcen Id des Zugreifers als string</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	String getResourceId();

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the purpose of use.</div>
	 * <div class="de">Method um den Grund des Zugriffes zu erhalten.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @return
	 * <div class="en">The purpose of use as string</div>
	 * <div class="de">den Grund des Zugriffes als string</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	String getPurposeOfUse();

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the request type.</div>
	 * <div class="de">Method um den Requst Typ zu erhalten.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @return
	 * <div class="en">The request type</div>
	 * <div class="de">der request typ</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	RequestType getRequestType();

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the token type.</div>
	 * <div class="de">Method um den Token Typ zu erhalten.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @return
	 * <div class="en">The token type</div>
	 * <div class="de">der token typ</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	TokenType getTokenType();

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the applies to value.</div>
	 * <div class="de">Method um den Applies To wert zu erhalten.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @return
	 * <div class="en">The applies to as string</div>
	 * <div class="de">den Applies To Wert als string</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	AppliesTo getAppliesTo();

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the dialect value.</div>
	 * <div class="de">Method um den Dialekt Wert zu erhalten.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @return
	 * <div class="en">The dialect as string</div>
	 * <div class="de">den Dialekt wert als String</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	String getDialect();

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the context value.</div>
	 * <div class="de">Method um den Kontext Wert zu erhalten.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @return
	 * <div class="en">The dialect as string</div>
	 * <div class="de">den Dialekt wert als String</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	String getContext();

}
