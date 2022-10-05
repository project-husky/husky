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

import org.projecthusky.communication.ch.ppq.epr.policyadmin.api.OpenSamlEprPolicyRepositoryResponse;
import org.opensaml.core.xml.XMLObject;
import org.opensaml.core.xml.io.AbstractXMLObjectUnmarshaller;
import org.opensaml.core.xml.io.UnmarshallingException;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the unmarshaller for OpenSamlEpdPolicyRepositoryResponse.</div>
 * <div class="de">Die Klasse implementiert den Unmarshaller für OpenSamlEpdPolicyRepositoryResponse.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class EprPolicyRepositoryResponseUnmarshaller extends AbstractXMLObjectUnmarshaller {

	@Override
	protected void processAttribute(XMLObject xmlObject, Attr attribute)
			throws UnmarshallingException {
		final OpenSamlEprPolicyRepositoryResponse reponse = (OpenSamlEprPolicyRepositoryResponse) xmlObject;
		if ("status".equalsIgnoreCase(attribute.getName())) {
			reponse.setStatus(attribute.getValue());
		}
	}

	@Override
	public OpenSamlEprPolicyRepositoryResponse unmarshall(Element domElement)
			throws UnmarshallingException {
		return (OpenSamlEprPolicyRepositoryResponse) super.unmarshall(domElement);
	}

}
