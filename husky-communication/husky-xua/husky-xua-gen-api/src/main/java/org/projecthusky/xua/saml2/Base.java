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
package org.projecthusky.xua.saml2;

import java.util.Calendar;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the basic methods.</div>
 * <div class="de">Interface welches die Basis Methoden beschreibt.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 *
 */
public interface Base {

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the ID.</div>
	 * <div class="de">Methode die ID zu holen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">the ID value as {@link java.lang.String}.</div>
	 * <div class="de">der ID Wert als {@link java.lang.String}.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	String getId();

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the IssueInstant.</div>
	 * <div class="de">Methode den IssueInstant zu holen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">the IssueInstant value as {@link java.util.Calendar}.</div>
	 * <div class="de">der IssueInstant Wert als {@link java.util.Calendar}.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	Calendar getIssueInstant();

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the Issuer.</div>
	 * <div class="de">Methode um den Issuer zu holen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">the Issuer value as {@link java.lang.String}.</div>
	 * <div class="de">der Issuer Wert als {@link java.lang.String}.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	String getIssuer();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the Version.</div>
	 * <div class="de">Methode um die Version zu holen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">the Version value as {@link java.lang.String}.</div>
	 * <div class="de">die Version als {@link java.lang.String}.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	String getVersion();

}
