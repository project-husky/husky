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
package org.husky.xua.communication.xua;

import org.husky.xua.hl7v3.PurposeOfUse;
import org.husky.xua.hl7v3.Role;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the X-User assertion request builder methods.</div>
 * <div class="de">Interface welches die Methoden des X-User assertion builders beschreibt.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface XUserAssertionRequestBuilder {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the AppliesTo attribute.</div>
	 * <div class="de">Setzt das AppliesTo Attribut.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param appliesTo
	 * <div class="en">the value to be set</div>
	 * <div class="de">der Wert der gesetzt werden soll</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>der rolle der
	 * @return
	 * <div class="en">the actual instance of this builder</div>
	 * <div class="de">die aktuelle Instanz des Builders</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	XUserAssertionRequestBuilder appliesTo(AppliesTo appliesTo);

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the context.</div>
	 * <div class="de">Setzt den Kontext.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aContext
	 *  <div class="en">the context to be set</div>
	 * 	<div class="de">der Kontext der gesetzt werden soll</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @return
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 *  <!-- @formatter:on -->
	 */
	XUserAssertionRequestBuilder context(String aContext);

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Creates a concrete instance of XUserAssertionRequest with setted params.</div>
	 * <div class="de">Erstellt die konkrete Instanz des XUserAssertionRequest mit den gesetzten Parametern.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 *  <div class="en">a new XUserAssertionRequest instance with the params set</div>
	 *  <div class="de">eine neue XUserAssertionRequest Instanz mit den gesetzten Parametern</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 *  <!-- @formatter:on -->
	 */
	XUserAssertionRequest create();

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the dialect of the claims.</div>
	 * <div class="de">Setzt den Dialekt des Claims.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aDialect
	 *  <div class="en">the dialect to be set</div>
	 * 	<div class="de">den Dialekt der gesetzt werden soll</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @return
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 *  <!-- @formatter:on -->
	 */
	XUserAssertionRequestBuilder dialect(String aDialect);

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the id of the organisation of the accessing person (GLN of an organisation or a group from the HOI).</div>
	 * <div class="de">Setzt die Organisations-ID des Zugreifers (GLN einer Organisation oder einer Gruppe aus dem HOI).</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param organizationId
	 *  <div class="en">the organisation id of the accessing person to be set</div>
	 * 	<div class="de">die Organisations-ID der zugreifenden Person die gesetzt werden soll</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>der rolle der
	 * @return
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 *  <!-- @formatter:on -->
	 */
	XUserAssertionRequestBuilder organizationId(String organizationId);

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the name of the organisation of the accessing person (plain text of the organisation).</div>
	 * <div class="de">Setzt den Organisationsnamen des Zugreifers (Klartext des Organisationsnamens).</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param organizationName
	 *  <div class="en">the organisation name of the accessing person to be set</div>
	 * 	<div class="de">der Name der Organisation der zugreifenden Person die gesetzt werden soll</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>der rolle der
	 * @return
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 *  <!-- @formatter:on -->
	 */
	XUserAssertionRequestBuilder organizationName(String organizationName);

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the reason of access in the actual application context (for the EPR in Switzerland: Code from the Swiss value set: normal access, emergency access).</div>
	 * <div class="de">Setzt den Grund für den Zugriff im aktuellen Applikationskontext (für das EPD in der Schweiz: Code aus dem schweizerischen Value-Set: Normalzugriff, Notfallzugriff).</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aPurposeOfUse
	 *  <div class="en">the purpose of user to be set</div>
	 * 	<div class="de">der Grund des Zugriffes der gesetzt werden soll</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>der rolle der
	 * @return
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 *  <!-- @formatter:on -->
	 */
	XUserAssertionRequestBuilder purposeOfUse(PurposeOfUse aPurposeOfUse);

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the request type attribute.</div>
	 * <div class="de">Setzt den Request Types Attribut.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param requestType
	 *  <div class="en">the request type to be set</div>
	 *  <div class="de">der Request Typ der gesetzt werden soll</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>der rolle der
	 * @return
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	XUserAssertionRequestBuilder requestType(RequestType requestType);

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the resource id of the actual application context of the transaction (for the EPR in Switzerland: EPR-SPID of the desired patient record).</div>
	 * <div class="de">Setzt die Ressourcen-ID im aktuellen Applikationskontext auf welche sich die Transaktion bezieht (für das EPD in der Schweiz: EPR-SPID des gewünschten Patienten-Dossiers).</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param resourceId
	 *  <div class="en">the resource id to be set</div>
	 * 	<div class="de">die ID der Ressource die gesetzt werden soll</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @return
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 *  <!-- @formatter:on -->
	 */
	XUserAssertionRequestBuilder resourceId(String resourceId);

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the ID of the accessor (GLN or EPR-SPID).</div>
	 * <div class="de">Setzt die Zugreifer ID (GLN oder EPR-SPID).</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param subjectId
	 *  <div class="en">the id of the accessor to be set</div>
	 * 	<div class="de">die ID der zugreifenden Person die gesetzt werden soll</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @return
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 *  <!-- @formatter:on -->
	 */
	XUserAssertionRequestBuilder subjectId(String subjectId);

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the name of the accessor (plain text of the user name)</div>
	 * <div class="de">Setzt den Namen des Zugreifes (Klartext des Benutzernamens).</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param subjectName
	 *  <div class="en">the id of the accessor to be set</div>
	 * 	<div class="de">die ID der zugreifenden Person die gesetzt werden soll</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @return
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 *  <!-- @formatter:on -->
	 */
	XUserAssertionRequestBuilder subjectName(String subjectName);

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set role id of the accessor in the actual application context (for the EPR in Switzerland: Code from the Swiss Value Set for the role: patient, health professional, assistant, deputy).</div>
	 * <div class="de">Setzt die ID der Rolle des Zugreifers im aktuellen Applikationskontext (für das EPD in der Schweiz: Code aus dem schweizerischen Value-Set für die Rolle: Patient(in), Behandelnde(r), Hilfsperson, Stellvertreter(in)).</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param roleId
	 *  <div class="en">the id of the role to be set</div>
	 * 	<div class="de">die ID der rolle der zugreifenden Person die gesetzt werden soll</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @return
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 *  <!-- @formatter:on -->
	 */
	XUserAssertionRequestBuilder subjectRole(Role roleId);

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the toke type attribute.</div>
	 * <div class="de">Setzt den Token Types Attribut.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param tokenType
	 * <div class="en">the token type to be set</div>
	 * <div class="de">der Token Typ der gesetzt werden soll</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>der rolle der
	 * @return
	 * <div class="en">the actual instance of this builder</div>
	 * <div class="de">die aktuelle Instanz des Builders</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	XUserAssertionRequestBuilder tokenType(TokenType tokenType);

}
