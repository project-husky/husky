/*
 * This code is made available under the terms of the Eclipse Public License v1.0 in the github project https://github.com/project-husky/husky there you also find a list of the contributors and the license information.
This project has been developed further and modified by the joined working group Husky on the basis of the eHealth Connector opensource project from June 28, 2021, whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
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
package org.husky.xua.communication.xua;

/**
 * <!-- @formatter:off -->
 * <div class="en">Enumeration defining the TokenTypes.</div>
 * <div class="de">Enumeration die die TokenTypes definiert.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public enum TokenType {
	OASIS_WSS_SAML_PROFILE_11_SAMLV20(
			"http://docs.oasis-open.org/wss/oasis-wss-saml-token-profile-1.1#SAMLV2.0");

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the correct enum value by string.</div>
	 * <div class="de">Methode um den korrekte enum Wert zum String zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aCode
	 * <div class="en">The enum as string.</div>
	 * <div class="de">Der enum wert als String.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return
	 * <div class="en">The enum value corresponding to the input string else null.</div>
	 * <div class="de">Der enum Wert korrespondierend zum Eingabe String und sonst null.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	public static TokenType getEnum(String aCode) {
		for (final TokenType x : values()) {
			if (x.toString().equals(aCode)) {
				return x;
			}
		}
		return null;
	}

	/** the code representing the enum value as string */
	private String code;

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Default constructor to instanciate the object.</div>
	 * <div class="de">Default Konstruktor für die instanziierung des objects.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aCode
	 * <div class="en">The enum as string.</div>
	 * <div class="de">Der enum wert als String.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	TokenType(String aCode) {
		code = aCode;
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		return code;
	}
}
