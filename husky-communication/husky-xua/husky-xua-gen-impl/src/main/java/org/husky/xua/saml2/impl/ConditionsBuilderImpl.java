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
import org.husky.xua.saml2.ConditionsBuilder;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.ConditionsType;

/**
 * Class implementing the corresponding interface for Condition building.
 */
public class ConditionsBuilderImpl implements ConditionsBuilder,
		SecurityObjectBuilder<org.opensaml.saml.saml2.core.Conditions, ConditionsType> {

	private org.opensaml.saml.saml2.core.Conditions conditions;

	public ConditionsBuilderImpl() {
		conditions = new org.opensaml.saml.saml2.core.impl.ConditionsBuilder().buildObject();
	}

	@Override
	public ConditionsType create() {
		return new ConditionsImpl(conditions);
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.core.SecurityObjectBuilder#create(java.lang.Object)
	 */
	public ConditionsType create(org.opensaml.saml.saml2.core.Conditions aInternalObject) {
		return new ConditionsImpl(aInternalObject);
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.core.SecurityObjectBuilder#create(java.lang.Object)
	 */
	public org.opensaml.saml.saml2.core.Conditions create(ConditionsType aInternalObject) {
		return new ConditionsImpl(aInternalObject).getWrappedObject();
	}

}
