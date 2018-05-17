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
import org.ehealth_connector.security.ch.epr.policyadmin.UnknownPolicySetId;
import org.ehealth_connector.security.ch.epr.policyadmin.UnknownPolicySetIdBuilder;
import org.opensaml.core.xml.AbstractXMLObjectBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Builder class for OpenSamlUnknownPolicySetId.</div>
 * <div class="de">Builder Klasse für OpenSamlUnknownPolicySetId.</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * <!-- @formatter:on -->
 */
public class UnknownPolicySetIdBuilderImpl extends AbstractXMLObjectBuilder<OpenSamlUnknownPolicySetId>
		implements UnknownPolicySetIdBuilder {

	private String message;

	@Override
	public UnknownPolicySetIdBuilderImpl message(String aMessage) {
		message = aMessage;
		return this;
	}

	public OpenSamlUnknownPolicySetId buildObject() {
		return buildObject(UnknownPolicySetId.DEFAULT_NS_URI, UnknownPolicySetId.DEFAULT_ELEMENT_LOCAL_NAME,
				UnknownPolicySetId.DEFAULT_PREFIX);
	}

	@Override
	public OpenSamlUnknownPolicySetId buildObject(String namespaceURI, String localName, String namespacePrefix) {
		final OpenSamlUnknownPolicySetId abr = new UnknownPolicySetIdImpl(namespaceURI, localName, namespacePrefix);
		abr.setMessage(message);
		return abr;
	}

}
