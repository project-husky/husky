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
package org.ehealth_connector.security.ch.epr.policyadmin.impl;

import java.util.List;

import org.ehealth_connector.security.ch.epr.policyadmin.OpenSamlUnknownPolicySetId;
import org.opensaml.core.xml.XMLObject;

/**
 * <!-- @formatter:off -->
 * <div class="en">Implementing class of OpenSamlUnknownPolicySetId interface.</div>
 * <div class="de">Implementierende Klasse des OpenSamlUnknownPolicySetId Interfaces.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class UnknownPolicySetIdImpl extends AbstractAssertionBasedRequestImpl
		implements OpenSamlUnknownPolicySetId {

	private String message;

	protected UnknownPolicySetIdImpl(String namespaceURI, String elementLocalName,
			String namespacePrefix) {
		super(namespaceURI, elementLocalName, namespacePrefix);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.ch.epr.policyadmin.UnknownPolicySetId#getMessage()
	 */
	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public List<XMLObject> getOrderedChildren() {
		return null;
	}

	@Override
	public void setMessage(String aMessage) {
		message = aMessage;
	}

}
