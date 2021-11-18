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
package org.husky.xua.communication.clients;

import java.util.List;

import org.husky.xua.communication.xua.XUserAssertionRequest;
import org.husky.xua.communication.xua.XUserAssertionResponse;
import org.husky.xua.core.SecurityHeaderElement;
import org.husky.xua.exceptions.ClientSendException;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the methods for the X-User Assertion Provider client.</div>
 * <div class="de">Interface welches die Methoden für den X-User Assertion Provider Client beschreibt.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface XuaClient {

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to send an X-User Assertion Request.</div>
	 * <div class="de">Methode um einen X-User Assertion Request zu senden.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aSecurityHeaderElement
	 * <div class="en">the SecurityHeaderElement to be sent.</div>
	 * <div class="de">Das SecurityHeaderElement welches geschickt werden soll.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @param aRequest
	 * <div class="en">the XUserAssertionRequest to be sent.</div>
	 * <div class="de">Der XUserAssertionRequest welcher geschickt werden soll.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return
	 * <div class="en">a list of XUserAssertionResponses</div>
	 * <div class="de">Eine Liste von XUserAssertionResponses.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @throws ClientSendException
	 * <div class="en">will be thrown if an error occoures</div>
	 * <div class="de">wird geworfen wenn ein Fehler auftritt.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	List<XUserAssertionResponse> send(SecurityHeaderElement aSecurityHeaderElement,
			XUserAssertionRequest aRequest) throws ClientSendException;

}
