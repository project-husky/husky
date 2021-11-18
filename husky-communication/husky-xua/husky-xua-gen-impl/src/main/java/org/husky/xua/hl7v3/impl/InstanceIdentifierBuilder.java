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
package org.husky.xua.hl7v3.impl;

import org.husky.xua.hl7v3.InstanceIdentifier;
import org.husky.xua.hl7v3.OpenSamlInstanceIdentifier;
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
		return buildObject(InstanceIdentifier.DEFAULT_NS_URI,
				InstanceIdentifier.DEFAULT_ELEMENT_LOCAL_NAME,
				InstanceIdentifier.DEFAULT_PREFIX);
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
