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
package org.ehealth_connector.security.saml2;

import java.util.Calendar;
import java.util.List;

import org.ehealth_connector.security.core.SecurityHeaderElement;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the methods of Assertion. </div>
 * <div class="de">Interface beschreibt die Methoden von Assertion.</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * <!-- @formatter:on -->
 */
public interface Assertion extends Base, SecurityHeaderElement {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the Subject.</div>
	 * <div class="de">Methode um das Subject zu holen.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @return
	 * <div class="en">the instance of {@link org.ehealth_connector.security.saml2.Subject}</div>
	 * <div class="de">die Instanz von {@link org.ehealth_connector.security.saml2.Subject}</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	Subject getSubject();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the NotBefore of Conditions.</div>
	 * <div class="de">Methode um das NotBefore of Condition zu holen.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @return
	 * <div class="en">the NotBefore value as {@link java.util.Calendar}</div>
	 * <div class="de">der NotBefore Wert als {@link java.util.Calendar}</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	Calendar getConditionsNotBefore();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the NotOnOrAfter of Conditions.</div>
	 * <div class="de">Methode um das NotOnOrAfter of Condition zu holen.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @return
	 * <div class="en">the NotOnOrAfter value as {@link java.util.Calendar}</div>
	 * <div class="de">der NotOnOrAfter Wert als {@link java.util.Calendar}</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	Calendar getConditionsNotOnOrAfter();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the Conditions.</div>
	 * <div class="de">Methode um die Conditions zu holen.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @return
	 * <div class="en">a {@link java.util.List} of  {@link org.ehealth_connector.security.saml2.Condition}</div>
	 * <div class="de">eine {@link java.util.List} von {@link org.ehealth_connector.security.saml2.Condition}</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	List<Condition> getConditionsConditions();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the AudienceRestrictions.</div>
	 * <div class="de">Methode um die AudienceRestrictions zu holen.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @return
	 * <div class="en">a {@link java.util.List} of {@link org.ehealth_connector.security.saml2.AudienceRestriction}</div>
	 * <div class="de">eine {@link java.util.List} von {@link org.ehealth_connector.security.saml2.AudienceRestriction}</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	List<AudienceRestriction> getConditionsAudienceRestrictions();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the AuthnContexts.</div>
	 * <div class="de">Methode um die AuthnContexts zu holen.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @return
	 * <div class="en">a {@link java.util.List} of {@link org.ehealth_connector.security.saml2.AuthnStatement}</div>
	 * <div class="de">eine {@link java.util.List} von {@link org.ehealth_connector.security.saml2.AuthnStatement}</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	List<AuthnStatement> getAuthnStatements();

	/**
	 * * <!-- @formatter:off -->
	 * <div class="en">Method to get the Attributes.</div>
	 * <div class="de">Methode um die Attributes zu holen.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @return
	 * <div class="en">a {@link java.util.List} of {@link org.ehealth_connector.security.saml2.Attribute}</div>
	 * <div class="de">eine {@link java.util.List} von {@link org.ehealth_connector.security.saml2.Attribute}</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	List<Attribute> getAttributes();

	//
	// Advice getAdvice();
}
