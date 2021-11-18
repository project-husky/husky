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

import org.husky.xua.hl7v3.OpenSamlPurposeOfUse;

/**
 * <!-- @formatter:off -->
 * <div class="en">Implementation class of Interface OpenSaml PurposeOfUse.</div>
 * <div class="de">Implementations Klasse des Interfaces OpenSaml PurposeOfUse.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class PurposeOfUseImpl extends AbstractImpl implements OpenSamlPurposeOfUse {

	protected PurposeOfUseImpl(String namespaceURI, String elementLocalName,
			String namespacePrefix) {
		super(namespaceURI, elementLocalName, namespacePrefix);
	}
}
