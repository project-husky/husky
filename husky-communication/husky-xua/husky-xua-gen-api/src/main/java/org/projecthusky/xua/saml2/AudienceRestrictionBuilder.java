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
package org.projecthusky.xua.saml2;

import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.AudienceRestrictionType;

/**
 * Interface describing the methods of the AudienceRestrictionBuilder.
 */
public interface AudienceRestrictionBuilder extends SimpleBuilder<AudienceRestrictionType> {

	// There are no special methods defined, but the interface has to be
	// declared for selection reasons.

}
