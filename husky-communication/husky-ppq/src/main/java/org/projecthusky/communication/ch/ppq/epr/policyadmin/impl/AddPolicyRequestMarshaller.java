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

import org.projecthusky.communication.ch.ppq.epr.policyadmin.api.OpenSamlAddPolicyRequest;
import org.projecthusky.xua.saml2.impl.AssertionImpl;
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
		if (xmlObject instanceof OpenSamlAddPolicyRequest request && request.getAssertion() != null) {
				final AssertionImpl assertion = (AssertionImpl) request.getAssertion();
				final var innerAssertion = assertion
						.getWrappedObject();
				final var assertionElement = marshall(innerAssertion);
				final var imported = domElement.getOwnerDocument().importNode(assertionElement,
						true);
				domElement.appendChild(imported);
		}
		super.marshallChildElements(xmlObject, domElement);
	}

}
