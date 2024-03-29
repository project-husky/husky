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
 * <div class="en">Interface decribing the methods of SubjectConfirmation.</div>
 * <div class="de">Interface welches die Methoden von SubjectConfirmation beschreibt.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface SubjectConfirmation {
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the Address.</div>
	 * <div class="de">Methode um die Addresse zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">the Address as {@link java.lang.String}</div>
	 * <div class="de">die Addresse as {@link java.lang.String}</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	String getAddress();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the InResponseTo.</div>
	 * <div class="de">Methode um den Inhalt von InResponseTo zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">the InResponseTo as {@link java.lang.String}</div>
	 * <div class="de">den Inhalt von InResponseTo als {@link java.lang.String}</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	String getInResponseTo();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the Method.</div>
	 * <div class="de">Methode um die Method zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">the NMethod as {@link java.lang.String}</div>
	 * <div class="de">die Method as {@link java.lang.String}</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	String getMethod();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the NotBefore.</div>
	 * <div class="de">Methode um das NotBefore zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">the NotBefore as {@link java.util.Calendar}</div>
	 * <div class="de">das NotBefore als {@link java.util.Calendar}</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	Calendar getNotBefore();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the NotOnOrAfter.</div>
	 * <div class="de">Methode um das NotOnOrAfter zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">the NotOnOrAfter as {@link java.util.Calendar}</div>
	 * <div class="de">das NotOnOrAfter als {@link java.util.Calendar}</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	Calendar getNotOnOrAfter();

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the Recipient.</div>
	 * <div class="de">Methode um den Recipient zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <div class="en">the Recipient as {@link java.lang.String}</div>
	 * <div class="de">den Recipient as {@link java.lang.String}</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	String getRecipient();
}
