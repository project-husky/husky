/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
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
package org.ehealth_connector.security.communication.xua.impl;

import org.ehealth_connector.security.communication.xua.AppliesTo;
import org.ehealth_connector.security.communication.xua.AppliesToBuilder;
import org.ehealth_connector.security.core.SecurityObjectBuilder;
import org.opensaml.soap.wsaddressing.Address;
import org.opensaml.soap.wsaddressing.EndpointReference;
import org.opensaml.soap.wsaddressing.impl.AddressBuilder;
import org.opensaml.soap.wsaddressing.impl.EndpointReferenceBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the corresponding interfaces AppliesToBuilder and SecurityObjectBuilder.</div>
 * <div class="de">Die Klasse implementiert die entsprechenden Interfaces AppliesToBuilder und SecurityObjectBuilder.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class AppliesToBuilderImpl implements AppliesToBuilder,
		SecurityObjectBuilder<org.opensaml.soap.wspolicy.AppliesTo, AppliesTo> {

	private org.opensaml.soap.wspolicy.AppliesTo appliesTo;

	public AppliesToBuilderImpl() {
		appliesTo = new org.opensaml.soap.wspolicy.impl.AppliesToBuilder().buildObject();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.communication.xua.AppliesToBuilder#address(java.lang.String)
	 */
	@Override
	public AppliesToBuilder address(String aAddress) {
		final Address wsaAddress = new AddressBuilder().buildObject();
		wsaAddress.setValue(aAddress);

		final EndpointReference enpointRef = new EndpointReferenceBuilder().buildObject();
		enpointRef.setAddress(wsaAddress);

		appliesTo.getUnknownXMLObjects().add(enpointRef);
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.communication.xua.AppliesToBuilder#create()
	 */
	@Override
	public AppliesTo create() {
		return new AppliesToImpl(appliesTo);
	}

	@Override
	public AppliesTo create(org.opensaml.soap.wspolicy.AppliesTo aInternalObject) {
		return new AppliesToImpl(aInternalObject);
	}

}
