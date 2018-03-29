/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland. All rights reserved.
 * https://medshare.net Source code, documentation and other resources have been contributed by various people. Project
 * Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/ For exact developer information, please refer to the
 * commit history of the forge. This code is made available under the terms of the Eclipse Public License v1.0.
 * Accompanying materials are made available under the terms of the Creative Commons Attribution-ShareAlike 4.0 License.
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 */
package org.ehealth_connector.security.saml2;

import java.util.Date;

/**
 * @since Jan 16, 2018 2:05:32 PM
 *
 */
public interface AttributeQueryBuilder {

	/**
	 * @formatter:off
	 * <div class="en">HEREISENGLISH</div>
	 * <div class="de">Erstellt einen neuen Builder für eine SAML 2 Attribute Query.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @param id
	 * @return
	 */
	AttributeQueryBuilder id(String id);

	/**
	 * @formatter:off
	 * <div class="en">HEREISENGLISH</div>
	 * <div class="de">Setzt das IssueInstant Feld der Query.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 * 
	 * @param issueInstant
	 * @return
	 */
	AttributeQueryBuilder issueInstant(Date issueInstant);

	/**
	 * @formatter:off
	 * <div class="en">HEREISENGLISH</div>
	 * <div class="de">Definiert den Issuer der Query.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 * 
	 * @param issuer
	 * @return
	 */
	AttributeQueryBuilder issuer(String issuer);

	/**
	 * 
	 * @formatter:off
	 * <div class="en">HEREISENGLISH</div>
	 * <div class="de">Definiert das Issuer Fomat.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @param issuerFormat
	 * @return
	 */
	AttributeQueryBuilder issuerFormat(String issuerFormat);

	/**
	 * 
	 * @formatter:off
	 * <div class="en">HEREISENGLISH</div>
	 * <div class="de">Fügt ein Attribute zur Query hinzu.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @return
	 */
	AttributeBuilder addAttribute();

	/**
	 * 
	 * @formatter:off
	 * <div class="en">HEREISENGLISH</div>
	 * <div class="de">Erstellt die SAML Attribute Query.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @formatter:on
	 *
	 * @return
	 */
	AttributeQuery createAttributeQuery();

}
