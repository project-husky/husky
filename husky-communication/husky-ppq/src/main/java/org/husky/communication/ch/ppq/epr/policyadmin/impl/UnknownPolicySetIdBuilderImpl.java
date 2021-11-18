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
package org.husky.communication.ch.ppq.epr.policyadmin.impl;

import org.husky.communication.ch.ppq.epr.policyadmin.api.BasePolicyAdministration;
import org.husky.communication.ch.ppq.epr.policyadmin.api.OpenSamlUnknownPolicySetId;
import org.husky.communication.ch.ppq.epr.policyadmin.api.UnknownPolicySetId;
import org.husky.communication.ch.ppq.epr.policyadmin.api.UnknownPolicySetIdBuilder;
import org.opensaml.core.xml.AbstractXMLObjectBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Builder class for OpenSamlUnknownPolicySetId.</div>
 * <div class="de">Builder Klasse für OpenSamlUnknownPolicySetId.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class UnknownPolicySetIdBuilderImpl extends
		AbstractXMLObjectBuilder<OpenSamlUnknownPolicySetId> implements UnknownPolicySetIdBuilder {

	private String message;

	public OpenSamlUnknownPolicySetId buildObject() {
		return buildObject(BasePolicyAdministration.DEFAULT_NS_URI, UnknownPolicySetId.DEFAULT_ELEMENT_LOCAL_NAME,
				BasePolicyAdministration.DEFAULT_PREFIX);
	}

	@Override
	public OpenSamlUnknownPolicySetId buildObject(String namespaceURI, String localName,
			String namespacePrefix) {
		final OpenSamlUnknownPolicySetId abr = new UnknownPolicySetIdImpl(namespaceURI, localName,
				namespacePrefix);
		abr.setMessage(message);
		return abr;
	}

	@Override
	public UnknownPolicySetIdBuilderImpl message(String aMessage) {
		message = aMessage;
		return this;
	}

}
