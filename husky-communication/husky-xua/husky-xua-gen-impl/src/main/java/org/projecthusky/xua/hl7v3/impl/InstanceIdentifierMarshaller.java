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

import org.projecthusky.xua.hl7v3.OpenSamlInstanceIdentifier;
import org.opensaml.core.xml.XMLObject;
import org.opensaml.core.xml.io.AbstractXMLObjectMarshaller;
import org.opensaml.core.xml.io.MarshallingException;
import org.w3c.dom.Element;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the marshaller for OpenSaml InstanceIdentifier.</div>
 * <div class="de">Die Klasse implementiert den Marshaller für OpenSaml InstanceIdentifier.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class InstanceIdentifierMarshaller extends AbstractXMLObjectMarshaller {

	@Override
	protected void marshallAttributes(XMLObject xmlObject, Element domElement)
			throws MarshallingException {
		final OpenSamlInstanceIdentifier purposeOfUse = (OpenSamlInstanceIdentifier) xmlObject;
		if (purposeOfUse.getRoot() != null) {
			domElement.setAttributeNS(null, "root", purposeOfUse.getRoot());
		}
		if (purposeOfUse.getExtension() != null) {
			domElement.setAttributeNS(null, "extension", purposeOfUse.getExtension());
		}

		domElement.setAttribute("xsi:type", "II");
		domElement.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");

	}

}
