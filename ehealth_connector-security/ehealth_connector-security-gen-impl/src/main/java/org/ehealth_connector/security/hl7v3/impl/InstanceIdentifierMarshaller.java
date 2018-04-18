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
package org.ehealth_connector.security.hl7v3.impl;

import org.ehealth_connector.security.hl7v3.OpenSamlInstanceIdentifier;
import org.opensaml.core.xml.XMLObject;
import org.opensaml.core.xml.io.AbstractXMLObjectMarshaller;
import org.opensaml.core.xml.io.MarshallingException;
import org.w3c.dom.Element;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the marshaller for OpenSamlInstanceIdentifier.</div>
 * <div class="de">Die Klasse implementiert den Marshaller für OpenSamlInstanceIdentifier.</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * <!-- @formatter:on -->
 */
public class InstanceIdentifierMarshaller extends AbstractXMLObjectMarshaller {

	@Override
	protected void marshallAttributes(XMLObject xmlObject, Element domElement) throws MarshallingException {
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
