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

import org.ehealth_connector.security.ch.epr.policyadmin.OpenSamlUnknownPolicySetId;
import org.opensaml.core.xml.XMLObject;
import org.opensaml.core.xml.io.AbstractXMLObjectUnmarshaller;
import org.opensaml.core.xml.io.UnmarshallingException;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the unmarshaller for OpenSamlUnknownPolicySetId.</div>
 * <div class="de">Die Klasse implementiert den Unmarshaller für OpenSamlUnknownPolicySetId	.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class UnknownPolicySetIdUnmarshaller extends AbstractXMLObjectUnmarshaller {

	@Override
	protected void processAttribute(XMLObject xmlObject, Attr attribute)
			throws UnmarshallingException {
		final OpenSamlUnknownPolicySetId reponse = (OpenSamlUnknownPolicySetId) xmlObject;
		if ("status".equalsIgnoreCase(attribute.getName())) {
			reponse.setMessage(attribute.getValue());
		}
	}

	@Override
	public OpenSamlUnknownPolicySetId unmarshall(Element domElement) throws UnmarshallingException {
		return (OpenSamlUnknownPolicySetId) super.unmarshall(domElement);
	}

}
