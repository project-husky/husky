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
package org.projecthusky.xua.communication.xua;

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
