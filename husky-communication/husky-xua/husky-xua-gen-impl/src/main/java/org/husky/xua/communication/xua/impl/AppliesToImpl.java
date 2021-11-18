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
package org.husky.xua.communication.xua.impl;

import org.husky.xua.communication.xua.AppliesTo;
import org.husky.xua.core.SecurityObject;
import org.husky.xua.helpers.ListXmlObjectHelper;
import org.opensaml.soap.wsaddressing.EndpointReference;
import org.opensaml.soap.wsaddressing.impl.EndpointReferenceImpl;

/**
 * <!-- @formatter:off -->
 * <div class="en">Implementation class of Interface AppliesTo</div>
 * <div class="de">Implementations Klasse von Interface AppliesTo</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class AppliesToImpl
		implements AppliesTo, SecurityObject<org.opensaml.soap.wspolicy.AppliesTo> {

	private org.opensaml.soap.wspolicy.AppliesTo appliesTo;

	protected AppliesToImpl(org.opensaml.soap.wspolicy.AppliesTo aAppliesTo) {
		appliesTo = aAppliesTo;
	}

	@Override
	public String getAddress() {
		final var wsEndpointReference = new ListXmlObjectHelper<EndpointReference>()
				.getComponent(EndpointReferenceImpl.class, appliesTo.getUnknownXMLObjects());
		if ((wsEndpointReference != null) && (wsEndpointReference.getAddress() != null)) {
			return wsEndpointReference.getAddress().getURI();
		}
		return "";
	}

	@Override
	public org.opensaml.soap.wspolicy.AppliesTo getWrappedObject() {
		return appliesTo;
	}

}
