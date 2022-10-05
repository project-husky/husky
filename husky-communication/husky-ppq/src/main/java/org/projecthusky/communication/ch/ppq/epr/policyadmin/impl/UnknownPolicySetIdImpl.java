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
package org.projecthusky.communication.ch.ppq.epr.policyadmin.impl;

import java.util.LinkedList;
import java.util.List;

import org.projecthusky.communication.ch.ppq.epr.policyadmin.api.OpenSamlUnknownPolicySetId;
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
	 * @see org.projecthusky.communication.ch.ppq.epr.policyadmin.api.UnknownPolicySetId#getMessage()
	 */
	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public List<XMLObject> getOrderedChildren() {
		return new LinkedList<>();
	}

	@Override
	public void setMessage(String aMessage) {
		message = aMessage;
	}

}
