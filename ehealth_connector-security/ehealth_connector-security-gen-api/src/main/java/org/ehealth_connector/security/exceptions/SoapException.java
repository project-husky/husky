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
package org.ehealth_connector.security.exceptions;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the SoapException.</div>
 * <div class="de">Klasse implemetiert die SoapException.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class SoapException extends ClientSendException {

	private static final long serialVersionUID = 718920336633885906L;

	/** the soap exception code */
	@SuppressWarnings("unused")
	private String code;
	/** the soap exception message */
	@SuppressWarnings("unused")
	private String message;

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Default constructor to instanciate the object.</div>
	 * <div class="de">Default Konstruktor für die instanziierung des objects.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aCode
	 * <div class="en">The code of the exception.</div>
	 * <div class="de">Der Code des Fehlers.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @param aMessage
	 * <div class="en">The message of the exception.</div>
	 * <div class="de">Die Nachricht des Fehlers.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	public SoapException(String aCode, String aMessage) {
		super("Code: " + aCode + ", Message: " + aMessage);
		code = aCode;
		message = aMessage;
	}
}
