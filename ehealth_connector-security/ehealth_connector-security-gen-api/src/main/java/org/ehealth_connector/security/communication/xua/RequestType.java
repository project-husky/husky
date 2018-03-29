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
 * <div class="en">Enumeration for ws-trust request type.</div>
 * <div class="de">Enummerierung for den WS-Trust Request Typ</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * 
 * <!-- @formatter:on -->
 */
public enum RequestType {

	WST_ISSUE("http://docs.oasis-open.org/ws-sx/ws-trust/200512/Issue"), //
	WST_RENEW("http://docs.oasis-open.org/ws-sx/ws-trust/200512/Renew"), //
	WST_CANCEL("http://docs.oasis-open.org/ws-sx/ws-trust/200512/Cancel"), //
	WST_VALIDATE(" http://docs.oasis-open.org/ws-sx/ws-trust/200512/Validate");

	private String code;

	RequestType(String aCode) {
		this.code = aCode;
	}

	@Override
	public String toString() {
		return code;
	}

	public static RequestType getEnum(String code) {
		for (final RequestType x : values()) {
			if (x.toString().equals(code)) {
				return x;
			}
		}
		return null;
	}

}
