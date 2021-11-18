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

import org.husky.communication.ch.ppq.epr.policyadmin.api.OpenSamlDeletePolicyRequest;
import org.husky.xua.saml2.impl.AssertionBuilderImpl;
import org.opensaml.core.xml.XMLObject;
import org.opensaml.core.xml.io.AbstractXMLObjectUnmarshaller;
import org.opensaml.core.xml.io.UnmarshallingException;
import org.w3c.dom.Element;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the unmarshaller for OpenSamlDeletePolicyRequest.</div>
 * <div class="de">Die Klasse implementiert den Unmarshaller für OpenSamlDeletePolicyRequest.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class DeletePolicyRequestUnmarshaller extends AbstractXMLObjectUnmarshaller {

	@Override
	protected void processChildElement(XMLObject parentXMLObject, XMLObject childXMLObject)
			throws UnmarshallingException {
		if (childXMLObject instanceof org.opensaml.saml.saml2.core.Assertion) {
			final OpenSamlDeletePolicyRequest request = (OpenSamlDeletePolicyRequest) parentXMLObject;
			request.setAssertion(new AssertionBuilderImpl()
					.create((org.opensaml.saml.saml2.core.Assertion) childXMLObject));
		} else {
			super.processChildElement(parentXMLObject, childXMLObject);
		}
	}

	@Override
	public OpenSamlDeletePolicyRequest unmarshall(Element domElement)
			throws UnmarshallingException {
		return (OpenSamlDeletePolicyRequest) super.unmarshall(domElement);
	}

}
