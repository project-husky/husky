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
package org.husky.xua.exceptions;

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
	private final String code;
	/** the soap exception message */
	@SuppressWarnings("unused")
	private final String message;

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
