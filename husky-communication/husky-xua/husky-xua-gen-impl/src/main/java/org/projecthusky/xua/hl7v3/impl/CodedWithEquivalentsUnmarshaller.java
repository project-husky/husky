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
package org.projecthusky.xua.hl7v3.impl;

import org.projecthusky.xua.hl7v3.OpenSamlCodedWithEquivalent;
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
public class CodedWithEquivalentsUnmarshaller extends AbstractXMLObjectUnmarshaller {

	/**
	 * {@inheritDoc}
	 *
	 * @see org.opensaml.core.xml.io.AbstractXMLObjectUnmarshaller#processAttribute(org.opensaml.core.xml.XMLObject,
	 *      org.w3c.dom.Attr)
	 */
	@Override
	protected void processAttribute(XMLObject xmlObject, Attr attribute)
			throws UnmarshallingException {
		final OpenSamlCodedWithEquivalent purposeOfUse = (OpenSamlCodedWithEquivalent) xmlObject;
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
	public OpenSamlCodedWithEquivalent unmarshall(Element domElement) throws UnmarshallingException {
		return (OpenSamlCodedWithEquivalent) super.unmarshall(domElement);
	}

}
