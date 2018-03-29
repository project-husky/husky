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
 * <div class="en">Interface describing the x-user assertion request builder methods.</div>
 * <div class="de">Interface beschreibende methoden des x user  assertion builders.</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * <!-- @formatter:on -->
 */
public interface XUserAssertionRequestBuilder {

	/**
	 * 	
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the dialect of the claims.</div>
	 * <div class="de">Setzt den Dialekt des Claims.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @param aDialect
	 *  <div class="en">the dialect to be set</div>
	 * 	<div class="de">den Dialekt der gesetzt werden soll</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 * @return 
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle instanz des builders</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 *  <!-- @formatter:on -->
	 */
	XUserAssertionRequestBuilder dialect(String aDialect);

	/**
	 * 	
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the context.</div>
	 * <div class="de">Setzt den Kontext.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @param subjectId
	 *  <div class="en">the context to be set</div>
	 * 	<div class="de">die Kontext der gesetzt werden soll</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 * @return 
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle instanz des builders</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 *  <!-- @formatter:on -->
	 */
	XUserAssertionRequestBuilder context(String aContext);

	/**
	 * 	
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the ID of the accessor (GLN oder EPD-PID).</div>
	 * <div class="de">Setzt die Zugreifer ID (GLN oder EPD-PID).</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @param subjectId
	 *  <div class="en">the id of the accessor to be set</div>
	 * 	<div class="de">die ID der zugreifenden Person die gesetzt werden soll</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 * @return 
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle instanz des builders</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 *  <!-- @formatter:on -->
	 */
	XUserAssertionRequestBuilder subjectId(String subjectId);

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the name of the accessor</div>
	 * <div class="de">Setzt den Namen des Zugreifes (Klartext des Benutzernamens).</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @param subjectName
	 *  <div class="en">the id of the accessor to be set</div>
	 * 	<div class="de">die ID der zugreifenden Person die gesetzt werden soll</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 * @return 
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle instanz des builders</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 *  <!-- @formatter:on -->
	 */
	XUserAssertionRequestBuilder subjectName(String subjectName);

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set roleid of the accessor in the actual application context.</div>
	 * <div class="de">Setzt die Rolle des Zugreifers im aktuellen Applikationskontext
	 * (für das EPD in der Schweiz: Code aus dem schweizerischen Value-Set für die Rolle: Patient(in), Behandelnde(r), Hilfsperson, Stellvertreter(in)).</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @param roleId
	 *  <div class="en">the id of the role to be set</div>
	 * 	<div class="de">die id der rolle der zugreifenden Person die gesetzt werden soll</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 * @return 
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle instanz des builders</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 *  <!-- @formatter:on -->
	 */
	XUserAssertionRequestBuilder subjectRole(String roleId);

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the id of the organisation of the accessing person.</div>
	 * <div class="de">Setzt die Organisations ID des Zugreifers (GLN einer Organisation oder einer Gruppe aus dem HOI).</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @param organizationId
	 *  <div class="en">the organisation id of the accessing person to be set</div>
	 * 	<div class="de">die id der Organisation der zugreifenden Person die gesetzt werden soll</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>der rolle der
	 * @return 
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle instanz des builders</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 *  <!-- @formatter:on -->
	 */
	XUserAssertionRequestBuilder organizationId(String organizationId);

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the name of the organisation of the accessing person.</div>
	 * <div class="de">Setzt den Organisationsnamen des Zugreifers (Klartext des Organisationsnamens).</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @param organizationName
	 *  <div class="en">the organisation name of the accessing person to be set</div>
	 * 	<div class="de">der Name der Organisation der zugreifenden Person die gesetzt werden soll</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>der rolle der
	 * @return 
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle instanz des builders</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 *  <!-- @formatter:on -->
	 */
	XUserAssertionRequestBuilder organizationName(String organizationName);

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the ressource id of the actual application context of the transaction.</div>
	 * <div class="de">Setzt die Ressourcen ID im aktuellen Applikationskontext auf welche sich die Transaktion bezieht.
	 * (für das EPD in der Schweiz: EPD-PID des gewünschten Patienten-Dossiers).</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @param resourceId
	 *  <div class="en">the resource id to be set</div>
	 * 	<div class="de">die Id der Ressource die gesetzt werden soll</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>der rolle der
	 * @return 
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle instanz des builders</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 *  <!-- @formatter:on -->
	 */
	XUserAssertionRequestBuilder resourceId(String resourceId);

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the reason of access in the actual application context.</div>
	 * <div class="de">Setzt die Grund für den Zugriff im aktuellen Applikationskontext
	 * (für das EPD in der Schweiz: Code aus dem schweizerischen Value-Set für die Rolle: Normalzugriff, Notfallzugriff).</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @param purposeOfUse
	 *  <div class="en">the purpose of user to be set</div>
	 * 	<div class="de">der Grund des Zugriffes der gesetzt werden soll</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>der rolle der
	 * @return 
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle instanz des builders</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 *  <!-- @formatter:on -->
	 */
	XUserAssertionRequestBuilder purposeOfUse(String purposeOfUse);

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the request type attribute.</div>
	 * <div class="de">Setzt den Request Types Attribut.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * 
	 * @param requestType
	 *  <div class="en">the request type to be set</div>
	 *  <div class="de">der Request Typ der gesetzt werden soll</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>der rolle der
	 * @return
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle instanz des builders</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	XUserAssertionRequestBuilder requestType(RequestType requestType);

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the toke type attribute.</div>
	 * <div class="de">Setzt den Token Types Attribut.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * 
	 * @param tokenType
	 * <div class="en">the token type to be set</div>
	 * <div class="de">der Token Typ der gesetzt werden soll</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>der rolle der
	 * @return
	 * <div class="en">the actual instance of this builder</div>
	 * <div class="de">die aktuelle instanz des builders</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	XUserAssertionRequestBuilder tokenType(TokenType tokenType);

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the applies to attribute.</div>
	 * <div class="de">Setzt das AppliesTo Attribut.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * 
	 * @param appliesTo
	 * <div class="en">the applies to to be set</div>
	 * <div class="de">der applies to der gesetzt werden soll</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>der rolle der
	 * @return 
	 * <div class="en">the actual instance of this builder</div>
	 * <div class="de">die aktuelle instanz des builders</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	XUserAssertionRequestBuilder appliesTo(AppliesTo appliesTo);

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Creates a concrete instance of XUserAssertionRequest with setted params.</div>
	 * <div class="de">Erstellt die konkrete instanz des XUserAssertionRequest mit den gesetzten parametern.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @return 
	 *  <div class="en">a new XUserAssertionRequest instance with the params set</div>
	 *  <div class="de">eine neue XUserAssertionRequest instanz mit den gesetzten parametern</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 *  <!-- @formatter:on -->
	 */
	XUserAssertionRequest create();

}
