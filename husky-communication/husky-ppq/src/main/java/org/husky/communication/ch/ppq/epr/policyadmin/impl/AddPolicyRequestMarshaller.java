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
package org.husky.communication.ch.ppq.epr.policyadmin.impl;

import org.husky.communication.ch.ppq.epr.policyadmin.api.OpenSamlAddPolicyRequest;
import org.husky.xua.saml2.impl.AssertionImpl;
import org.opensaml.core.xml.XMLObject;
import org.opensaml.core.xml.io.AbstractXMLObjectMarshaller;
import org.opensaml.core.xml.io.MarshallingException;
import org.w3c.dom.Element;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the marshaller for OpenSamlAddPolicyRequest.</div>
 * <div class="de">Die Klasse implementiert den Marshaller für OpenSamlAddPolicyRequest.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class AddPolicyRequestMarshaller extends AbstractXMLObjectMarshaller {

	@Override
	protected void marshallChildElements(XMLObject xmlObject, Element domElement)
			throws MarshallingException {
		if (xmlObject instanceof OpenSamlAddPolicyRequest) {
			final OpenSamlAddPolicyRequest request = (OpenSamlAddPolicyRequest) xmlObject;
			if (request.getAssertion() != null) {
				final AssertionImpl assertion = (AssertionImpl) request.getAssertion();
				final var innerAssertion = assertion
						.getWrappedObject();
				final var assertionElement = marshall(innerAssertion);
				final var imported = domElement.getOwnerDocument().importNode(assertionElement,
						true);
				domElement.appendChild(imported);
			}
		}
		super.marshallChildElements(xmlObject, domElement);
	}

}
