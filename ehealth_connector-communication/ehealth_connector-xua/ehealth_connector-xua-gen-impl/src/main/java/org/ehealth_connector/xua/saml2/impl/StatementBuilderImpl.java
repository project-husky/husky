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
package org.ehealth_connector.xua.saml2.impl;

import org.ehealth_connector.xua.core.SecurityObjectBuilder;
import org.ehealth_connector.xua.saml2.SimpleBuilder;
import org.openehealth.ipf.commons.ihe.xacml20.stub.xacml20.saml.assertion.ReferencedPoliciesType;
import org.openehealth.ipf.commons.ihe.xacml20.stub.xacml20.saml.assertion.XACMLPolicyStatementType;
import org.opensaml.xacml.policy.PolicySetType;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the corresponding interface for AuthnStatement building.</div>
 * <div class="de">Die Klasse implementiert das entsprechende Interface um AuthnStatements bilden zu können.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class StatementBuilderImpl
		implements SimpleBuilder<XACMLPolicyStatementType>,
		SecurityObjectBuilder<org.opensaml.xacml.profile.saml.XACMLPolicyStatementType, XACMLPolicyStatementType> {

	private org.opensaml.xacml.profile.saml.XACMLPolicyStatementType wrappedObject;

	public StatementBuilderImpl() {
		wrappedObject = new org.opensaml.xacml.profile.saml.impl.XACMLPolicyStatementTypeImplBuilder().buildObject();
	}

	@Override
	public XACMLPolicyStatementType create() {
		return new XACMLPolicyStatementType();
	}

	@Override
	public XACMLPolicyStatementType create(org.opensaml.xacml.profile.saml.XACMLPolicyStatementType aInternalObject) {
		var retVal = new XACMLPolicyStatementType();
		
		if (aInternalObject.getPolicySets() != null) {
			for (PolicySetType policySetType : aInternalObject.getPolicySets()) {
				retVal.getPolicyOrPolicySet().add(new PolicySetBuilderImpl().create(policySetType));
			}
		}

		if (aInternalObject.getPolicies() != null) {
			for (org.opensaml.xacml.policy.PolicyType policyType : aInternalObject.getPolicies()) {
				retVal.getPolicyOrPolicySet().add(new PolicyBuilderImpl().create(policyType));
			}
		}
		
		if (aInternalObject.getReferencedPolicies() != null) {
			var referencedPoliciesType = new ReferencedPoliciesType();

			for (org.opensaml.xacml.policy.PolicySetType policySetType : aInternalObject.getReferencedPolicies()
					.getPolicySets()) {
				referencedPoliciesType.getPolicyOrPolicySet().add(new PolicySetBuilderImpl().create(policySetType));
			}

			for (org.opensaml.xacml.policy.PolicyType policyType : aInternalObject.getReferencedPolicies()
					.getPolicies()) {
				referencedPoliciesType.getPolicyOrPolicySet().add(new PolicyBuilderImpl().create(policyType));
			}

			retVal.setReferencedPolicies(referencedPoliciesType);
		}

		return retVal;
	}

}
