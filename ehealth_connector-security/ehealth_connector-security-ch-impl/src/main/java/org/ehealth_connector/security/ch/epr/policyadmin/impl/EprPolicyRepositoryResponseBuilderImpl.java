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

import org.ehealth_connector.security.ch.epr.policyadmin.EprPolicyRepositoryResponse;
import org.ehealth_connector.security.ch.epr.policyadmin.EprPolicyRepositoryResponseBuilder;
import org.ehealth_connector.security.ch.epr.policyadmin.OpenSamlEprPolicyRepositoryResponse;
import org.opensaml.core.xml.AbstractXMLObjectBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Builder class for OpenSamlEpdPolicyRepositoryResponse.</div>
 * <div class="de">Builder Klasse für OpenSamlEpdPolicyRepositoryResponse.</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * <!-- @formatter:on -->
 */
public class EprPolicyRepositoryResponseBuilderImpl extends
		AbstractXMLObjectBuilder<OpenSamlEprPolicyRepositoryResponse> implements EprPolicyRepositoryResponseBuilder {

	private String status;

	@Override
	public EprPolicyRepositoryResponseBuilderImpl status(String aStatus) {
		status = aStatus;
		return this;
	}

	public OpenSamlEprPolicyRepositoryResponse buildObject() {
		return buildObject(EprPolicyRepositoryResponse.DEFAULT_NS_URI,
				EprPolicyRepositoryResponse.DEFAULT_ELEMENT_LOCAL_NAME, EprPolicyRepositoryResponse.DEFAULT_PREFIX);
	}

	@Override
	public OpenSamlEprPolicyRepositoryResponse buildObject(String namespaceURI, String localName,
			String namespacePrefix) {
		final OpenSamlEprPolicyRepositoryResponse abr = new EprPolicyRepositoryResponseImpl(namespaceURI, localName,
				namespacePrefix);
		abr.setStatus(status);
		return abr;
	}
}
