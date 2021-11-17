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
package org.husky.xua.hl7v3.impl;

import org.husky.xua.hl7v3.OpenSamlRole;
import org.opensaml.core.xml.XMLObject;
import org.opensaml.core.xml.io.AbstractXMLObjectUnmarshaller;
import org.opensaml.core.xml.io.UnmarshallingException;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the unmarshaller for OpenSaml PurposeOfUse.</div>
 * <div class="de">Die Klasse implementiert den Unmarshaller für OpenSaml PurposeOfUse.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class RoleUnmarshaller extends AbstractXMLObjectUnmarshaller {

	/**
	 * {@inheritDoc}
	 *
	 * @see org.opensaml.core.xml.io.AbstractXMLObjectUnmarshaller#processAttribute(org.opensaml.core.xml.XMLObject,
	 *      org.w3c.dom.Attr)
	 */
	@Override
	protected void processAttribute(XMLObject xmlObject, Attr attribute)
			throws UnmarshallingException {
		final OpenSamlRole purposeOfUse = (OpenSamlRole) xmlObject;
		if ("code".equalsIgnoreCase(attribute.getName())) {
			purposeOfUse.setCode(attribute.getValue());
		}
		if ("codesystem".equalsIgnoreCase(attribute.getName())) {
			purposeOfUse.setCodeSystem(attribute.getValue());
		}
		if ("codesystemname".equalsIgnoreCase(attribute.getName())) {
			purposeOfUse.setCodeSystemName(attribute.getValue());
		}
		if ("displayName".equalsIgnoreCase(attribute.getName())) {
			purposeOfUse.setDisplayName(attribute.getValue());
		}

	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.opensaml.core.xml.io.AbstractXMLObjectUnmarshaller#unmarshall(org.w3c.dom.Element)
	 */
	@Override
	public OpenSamlRole unmarshall(Element domElement) throws UnmarshallingException {
		return (OpenSamlRole) super.unmarshall(domElement);
	}

}
