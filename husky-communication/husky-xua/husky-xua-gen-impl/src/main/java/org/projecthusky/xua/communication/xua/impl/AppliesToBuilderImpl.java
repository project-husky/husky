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
package org.projecthusky.xua.communication.xua.impl;

import org.projecthusky.xua.communication.xua.AppliesTo;
import org.projecthusky.xua.communication.xua.AppliesToBuilder;
import org.projecthusky.xua.core.SecurityObjectBuilder;
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

	/**
	 * Default constructor.
	 */
	public AppliesToBuilderImpl() {
		appliesTo = new org.opensaml.soap.wspolicy.impl.AppliesToBuilder().buildObject();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.projecthusky.xua.communication.xua.AppliesToBuilder#address(java.lang.String)
	 */
	@Override
	public AppliesToBuilder address(String aAddress) {
		final var wsaAddress = new AddressBuilder().buildObject();
		wsaAddress.setURI(aAddress);

		final EndpointReference enpointRef = new EndpointReferenceBuilder().buildObject();
		enpointRef.setAddress(wsaAddress);

		appliesTo.getUnknownXMLObjects().add(enpointRef);
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.projecthusky.xua.communication.xua.AppliesToBuilder#create()
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
