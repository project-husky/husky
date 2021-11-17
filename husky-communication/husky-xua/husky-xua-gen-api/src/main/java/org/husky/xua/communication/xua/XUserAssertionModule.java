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

import java.util.List;

import org.husky.xua.communication.config.XuaClientConfig;
import org.husky.xua.core.SecurityHeaderElement;
import org.husky.xua.exceptions.ClientSendException;

/**
 * <!-- @formatter:off -->
 * <div class="en">Describing the methods of the XUserAssertionModule Interface</div>
 * <div class="de">Beschreibung der Methoden des XUserAssertionModule Interfaces</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface XUserAssertionModule {
	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the xuser assertion from an X-Assertion Provider.</div>
	 * <div class="de">Methode um die Authentifizierungs Assertion eines X-Assertion Providers zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aSecurityHeaderElement
	 * <div class="en">The SecurityHeaderElement to be sent by SOAP header.</div>
	 * <div class="de">Das SecurityHeaderElement welcehs im SOAP header mitgeschickt werden soll.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @param aRequest
	 * <div class="en">The XUserAssertionRequest to be sent.</div>
	 * <div class="de">Der XUserAssertionRequest der geschickt werden soll.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @param clientConfiguration
	 * <div class="en">The client configuartion to be set..</div>
	 * <div class="de">Die Client Konfiguration die gesetzt werden soll.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return
	 * <!-- @formatter:on -->
	 */
	List<XUserAssertionResponse> invokeGetXUserAssertion(
			SecurityHeaderElement aSecurityHeaderElement, XUserAssertionRequest aRequest,
			XuaClientConfig clientConfiguration) throws ClientSendException;

}
