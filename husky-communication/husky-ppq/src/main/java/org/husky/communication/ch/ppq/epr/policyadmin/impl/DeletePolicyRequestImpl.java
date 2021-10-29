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
package org.husky.communication.ch.ppq.epr.policyadmin.impl;

import java.util.LinkedList;
import java.util.List;

import org.husky.communication.ch.ppq.epr.policyadmin.api.OpenSamlDeletePolicyRequest;
import org.opensaml.core.xml.XMLObject;

/**
 * <!-- @formatter:off -->
 * <div class="en">Implementing class of OpenSamlDeletePolicyRequest interface.</div>
 * <div class="de">Implementierende Klasse des OpenSamlDeletePolicyRequest Interfaces.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class DeletePolicyRequestImpl extends AbstractAssertionBasedRequestImpl
		implements OpenSamlDeletePolicyRequest {

	protected DeletePolicyRequestImpl(String namespaceURI, String elementLocalName,
			String namespacePrefix) {
		super(namespaceURI, elementLocalName, namespacePrefix);
	}

	@Override
	public List<XMLObject> getOrderedChildren() {
		return new LinkedList<>();
	}

}
