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
package org.ehealth_connector.security.communication.xua.impl;

import org.ehealth_connector.security.communication.xua.AppliesTo;
import org.ehealth_connector.security.core.SecurityObject;
import org.ehealth_connector.security.helpers.ListXmlObjectHelper;
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
		final EndpointReference wsEndpointReference = new ListXmlObjectHelper<EndpointReference>()
				.getComponent(EndpointReferenceImpl.class, appliesTo.getUnknownXMLObjects());
		if ((wsEndpointReference != null) && (wsEndpointReference.getAddress() != null)) {
			return wsEndpointReference.getAddress().getValue();
		}
		return "";
	}

	@Override
	public org.opensaml.soap.wspolicy.AppliesTo getWrappedObject() {
		return appliesTo;
	}

}
