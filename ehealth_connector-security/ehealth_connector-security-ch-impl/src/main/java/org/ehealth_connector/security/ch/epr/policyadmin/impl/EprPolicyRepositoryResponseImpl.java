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
package org.ehealth_connector.security.ch.epr.policyadmin.impl;

import java.util.List;

import org.ehealth_connector.security.ch.epr.policyadmin.OpenSamlEprPolicyRepositoryResponse;
import org.ehealth_connector.security.ch.ppq.impl.PrivacyPolicyFeedResponseImpl;
import org.opensaml.core.xml.XMLObject;

/**
 * <!-- @formatter:off -->
 * <div class="en">Implementing class of OpenSamlEpdPolicyRepositoryResponse interface.</div>
 * <div class="de">Implementierende Klasse des OpenSamlEpdPolicyRepositoryResponse Interfaces.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class EprPolicyRepositoryResponseImpl extends AbstractAssertionBasedRequestImpl
		implements OpenSamlEprPolicyRepositoryResponse {

	private String status;

	protected EprPolicyRepositoryResponseImpl(String namespaceURI, String elementLocalName,
			String namespacePrefix) {
		super(namespaceURI, elementLocalName, namespacePrefix);
	}

	@Override
	public List<XMLObject> getOrderedChildren() {
		return null;
	}

	@Override
	public String getStatus() {
		return status;
	}

	@Override
	public Boolean isStatusSuccess() {
		return PrivacyPolicyFeedResponseImpl.SUCCESS.equals(status);
	}

	@Override
	public void setStatus(String aStatus) {
		status = aStatus;
	}
}
