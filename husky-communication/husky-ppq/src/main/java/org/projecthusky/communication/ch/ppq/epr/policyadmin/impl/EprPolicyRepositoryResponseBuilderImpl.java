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
package org.projecthusky.communication.ch.ppq.epr.policyadmin.impl;

import org.projecthusky.communication.ch.ppq.epr.policyadmin.api.EprPolicyRepositoryResponse;
import org.projecthusky.communication.ch.ppq.epr.policyadmin.api.EprPolicyRepositoryResponseBuilder;
import org.projecthusky.communication.ch.ppq.epr.policyadmin.api.OpenSamlEprPolicyRepositoryResponse;
import org.projecthusky.communication.ch.ppq.epr.policyadmin.api.PolicyAdministrationConstants;
import org.opensaml.core.xml.AbstractXMLObjectBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Builder class for OpenSamlEpdPolicyRepositoryResponse.</div>
 * <div class="de">Builder Klasse für OpenSamlEpdPolicyRepositoryResponse.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class EprPolicyRepositoryResponseBuilderImpl
		extends AbstractXMLObjectBuilder<OpenSamlEprPolicyRepositoryResponse>
		implements EprPolicyRepositoryResponseBuilder {

	private String status;

	public OpenSamlEprPolicyRepositoryResponse buildObject() {
		return buildObject(PolicyAdministrationConstants.DEFAULT_NS_URI,
				EprPolicyRepositoryResponse.DEFAULT_ELEMENT_LOCAL_NAME,
				PolicyAdministrationConstants.DEFAULT_PREFIX);
	}

	@Override
	public OpenSamlEprPolicyRepositoryResponse buildObject(String namespaceURI, String localName,
			String namespacePrefix) {
		final OpenSamlEprPolicyRepositoryResponse abr = new EprPolicyRepositoryResponseImpl(
				namespaceURI, localName, namespacePrefix);
		abr.setStatus(status);
		return abr;
	}

	@Override
	public EprPolicyRepositoryResponseBuilderImpl status(String aStatus) {
		status = aStatus;
		return this;
	}
}
