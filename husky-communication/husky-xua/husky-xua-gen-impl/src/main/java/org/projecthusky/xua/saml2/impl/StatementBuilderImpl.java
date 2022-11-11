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

import org.herasaf.xacml.core.policy.impl.PolicyType;
import org.projecthusky.xua.core.SecurityObjectBuilder;
import org.projecthusky.xua.saml2.SimpleBuilder;
import org.openehealth.ipf.commons.ihe.xacml20.stub.xacml20.saml.assertion.ReferencedPoliciesType;
import org.openehealth.ipf.commons.ihe.xacml20.stub.xacml20.saml.assertion.XACMLPolicyStatementType;
import org.opensaml.xacml.policy.PolicySetType;
import org.opensaml.xacml.profile.saml.impl.ReferencedPoliciesTypeImplBuilder;
import org.opensaml.xacml.profile.saml.impl.XACMLPolicyStatementTypeImplBuilder;

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
	
	/**
	 * Method to create XACMLPolicyStatementType.
	 * 
	 * @param aInternalObject the XACMLPolicyStatementType
	 * @return the opensaml XACMLPolicyStatementType
	 */
	public org.opensaml.xacml.profile.saml.XACMLPolicyStatementType create(
			org.openehealth.ipf.commons.ihe.xacml20.stub.xacml20.saml.assertion.XACMLPolicyStatementType aInternalObject) {
		var retVal = new XACMLPolicyStatementTypeImplBuilder().buildObject();
		
		if(aInternalObject.getPolicyOrPolicySet() != null) {
			for(Object obj : aInternalObject.getPolicyOrPolicySet()) {
				if (obj instanceof PolicyType policy) {
					retVal.getPolicies().add(new PolicyBuilderImpl().create(policy));	
				} else if (obj instanceof org.herasaf.xacml.core.policy.impl.PolicySetType policySet) {
					retVal.getPolicySets().add(new PolicySetBuilderImpl().create(policySet));
				}
			}
		}
		
		if (aInternalObject.getReferencedPolicies() != null) {
			var referencedPoliciesType = new ReferencedPoliciesTypeImplBuilder().buildObject();

			for (Object obj : aInternalObject.getReferencedPolicies().getPolicyOrPolicySet()) {
				if (obj instanceof PolicyType policy) {
					retVal.getReferencedPolicies().getPolicies().add(new PolicyBuilderImpl().create(policy));
				} else if (obj instanceof org.herasaf.xacml.core.policy.impl.PolicySetType policySet) {
					retVal.getReferencedPolicies().getPolicySets().add(new PolicySetBuilderImpl().create(policySet));
				}
			}

			retVal.setReferencedPolicies(referencedPoliciesType);
		}


		return retVal;
	}

}
