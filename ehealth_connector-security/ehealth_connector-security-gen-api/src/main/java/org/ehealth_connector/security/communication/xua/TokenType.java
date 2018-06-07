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
 * <div class="en">Enumeration defining the TokenTypes.</div>
 * <div class="de">Enumeration die die TokenTypes definiert.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public enum TokenType {
	OASIS_WSS_SAML_PROFILE_11_SAMLV20(
			"http://docs.oasis-open.org/wss/oasis-wss-saml-token-profile-1.1#SAMLV2.0");

	public static TokenType getEnum(String code) {
		for (final TokenType x : values()) {
			if (x.toString().equals(code)) {
				return x;
			}
		}
		return null;
	}

	private String code;

	TokenType(String aCode) {
		this.code = aCode;
	}

	@Override
	public String toString() {
		return code;
	}
}
