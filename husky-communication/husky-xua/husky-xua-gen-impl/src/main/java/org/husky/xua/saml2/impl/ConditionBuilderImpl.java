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
package org.husky.xua.saml2.impl;

import org.husky.xua.core.SecurityObjectBuilder;
import org.husky.xua.saml2.Condition;
import org.husky.xua.saml2.ConditionBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the corresponding interface for Condition building.</div>
 * <div class="de">Die Klasse implementiert das entsprechende Interface um Conditions bilden zu k&ooml;nnen.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class ConditionBuilderImpl implements ConditionBuilder,
		SecurityObjectBuilder<org.opensaml.saml.saml2.core.Condition, Condition> {

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.core.SecurityObjectBuilder#create(java.lang.Object)
	 */
	@Override
	public Condition create(org.opensaml.saml.saml2.core.Condition aInternalObject) {
		return new ConditionImpl(aInternalObject);
	}

}
