/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
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
package org.ehealth_connector.security.hl7v3.impl;

import org.ehealth_connector.security.hl7v3.OpenSamlInstanceIdentifier;
import org.opensaml.core.xml.AbstractXMLObjectBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class extending the abstract class AbstractXMLObjectBuilder with type OpenSaml InstanceIdentifier.</div>
 * <div class="de">Die Klasse erweitert die abstrakte Klasse AbstractXMLObjectBuilder mit typ OpenSaml InstanceIdentifier.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class InstanceIdentifierBuilder
		extends AbstractXMLObjectBuilder<OpenSamlInstanceIdentifier> {

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">method to create an instance of OpenSamlInstanceIdentifier.</div>
	 * <div class="de">Methode um eine Instanz von OpenSamlInstanceIdentifier zu erstellen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @return
	 * <!-- @formatter:on -->
	 */
	public OpenSamlInstanceIdentifier buildObject() {
		return buildObject(OpenSamlInstanceIdentifier.DEFAULT_NS_URI,
				OpenSamlInstanceIdentifier.DEFAULT_ELEMENT_LOCAL_NAME,
				OpenSamlInstanceIdentifier.DEFAULT_PREFIX);
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.opensaml.core.xml.AbstractXMLObjectBuilder#buildObject(java.lang.String,
	 *      java.lang.String, java.lang.String)
	 */
	@Override
	public OpenSamlInstanceIdentifier buildObject(String namespaceURI, String localName,
			String namespacePrefix) {
		return new InstanceIdentifierImpl(namespaceURI, localName, namespacePrefix);
	}

}
