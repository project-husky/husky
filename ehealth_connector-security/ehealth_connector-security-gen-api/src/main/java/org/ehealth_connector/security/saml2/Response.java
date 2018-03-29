/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland. All rights reserved.
 * https://medshare.net Source code, documentation and other resources have been contributed by various people. Project Team:
 * https://sourceforge.net/p/ehealthconnector/wiki/Team/ For exact developer information, please refer to the commit history of the forge.
 * This code is made available under the terms of the Eclipse Public License v1.0. Accompanying materials are made available under the terms
 * of the Creative Commons Attribution-ShareAlike 4.0 License. This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 */
package org.ehealth_connector.security.saml2;

import java.util.List;

/**
 * 
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the methods of Response</div>
 * <div class="de">Interface beschreibt die methoden eines Response</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * 
 * <!-- @formatter:on -->
 */
public interface Response extends Base {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get InResponseTo value.</div>
	 * <div class="de">Methode um den InResponseTo zu erhalten.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @return
	 * <div class="en">the InResponseTo value as {@link java.lang.String}.</div>
	 * <div class="de">der InResponseTo Wert als {@link java.lang.String}.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	String getInResponseTo();

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get Destination value.</div>
	 * <div class="de">Methode um den Destination wert zu erhalten.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @return
	 * <div class="en">the Destination value as {@link java.lang.String}.</div>
	 * <div class="de">der Destination Wert als {@link java.lang.String}.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	String getDestination();

	/**
	 * 
	 * <!-- @formatter:off -->
	 *<div class="en">Method to get Consent value.</div>
	 * <div class="de">Methode um den Consent wert zu erhalten.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @return
	 * <div class="en">the Destination value as {@link java.lang.String}.</div>
	 * <div class="de">der Destination Wert als {@link java.lang.String}.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	String getConsent();

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the Status.</div>
	 * <div class="de">Methode um den Status zu holen.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @return
	 * <div class="en">the Status value as {@link org.ehealth_connector.security.saml2.Status}.</div>
	 * <div class="de">der Status Wert als {@link org.ehealth_connector.security.saml2.Status}.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	Status getStatus();

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the {@link org.ehealth_connector.security.saml2.Assertion}s.</div>
	 * <div class="de">Methode um die Assertions zu erhalten.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @return
	 * <div class="en">a {@link java.util.List} of {@link org.ehealth_connector.security.saml2.Assertion}.</div>
	 * <div class="de">eine {@link java.util.List} von {@link org.ehealth_connector.security.saml2.Assertion}.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	List<Assertion> getAssertions();

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the {@link org.ehealth_connector.security.saml2.EncryptedAssertion}s.</div>
	 * <div class="de">Methode um die EncryptedAssertions zu erhalten.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @return
	 * <div class="en">a {@link java.util.List} of {@link org.ehealth_connector.security.saml2.EncryptedAssertion}.</div>
	 * <div class="de">eine {@link java.util.List} von {@link org.ehealth_connector.security.saml2.EncryptedAssertion}.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	List<EncryptedAssertion> getEncryptedAssertions();

}
