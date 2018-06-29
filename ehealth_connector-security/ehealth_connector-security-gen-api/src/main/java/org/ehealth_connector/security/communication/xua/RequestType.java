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
 * <div class="en">Enumeration for the WS-Trust Request type.</div>
 * <div class="de">Enummerierung für den WS-Trust Request Typ</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 *
 * <!-- @formatter:on -->
 */
public enum RequestType {

	WST_CANCEL("http://docs.oasis-open.org/ws-sx/ws-trust/200512/Cancel"), //
	WST_ISSUE("http://docs.oasis-open.org/ws-sx/ws-trust/200512/Issue"), //
	WST_RENEW("http://docs.oasis-open.org/ws-sx/ws-trust/200512/Renew"), //
	WST_VALIDATE(" http://docs.oasis-open.org/ws-sx/ws-trust/200512/Validate");

	/** the code representing the enum value as string */
	private String code;

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
	public static RequestType getEnum(String aCode) {
		for (final RequestType x : values()) {
			if (x.toString().equals(aCode)) {
				return x;
			}
		}
		return null;
	}

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
	RequestType(String aCode) {
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
