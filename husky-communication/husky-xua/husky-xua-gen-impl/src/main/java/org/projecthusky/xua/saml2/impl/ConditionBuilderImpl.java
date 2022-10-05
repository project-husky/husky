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
package org.projecthusky.xua.saml2.impl;

import org.projecthusky.xua.core.SecurityObjectBuilder;
import org.projecthusky.xua.saml2.Condition;
import org.projecthusky.xua.saml2.ConditionBuilder;

/**
 * Class implementing the corresponding interface for Condition building.
 */
public class ConditionBuilderImpl implements ConditionBuilder,
		SecurityObjectBuilder<org.opensaml.saml.saml2.core.Condition, Condition> {

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.projecthusky.xua.core.SecurityObjectBuilder#create(java.lang.Object)
	 */
	@Override
	public Condition create(org.opensaml.saml.saml2.core.Condition aInternalObject) {
		return new ConditionImpl(aInternalObject);
	}

}
