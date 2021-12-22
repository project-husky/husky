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

import org.herasaf.xacml.core.combiningAlgorithm.rule.impl.RuleDenyOverridesAlgorithm;
import org.herasaf.xacml.core.combiningAlgorithm.rule.impl.RuleFirstApplicableAlgorithm;
import org.herasaf.xacml.core.combiningAlgorithm.rule.impl.RuleOrderedDenyOverridesAlgorithm;
import org.herasaf.xacml.core.combiningAlgorithm.rule.impl.RuleOrderedPermitOverridesAlgorithm;
import org.herasaf.xacml.core.combiningAlgorithm.rule.impl.RulePermitOverridesAlgorithm;
import org.herasaf.xacml.core.policy.impl.DefaultsType;
import org.herasaf.xacml.core.policy.impl.EvaluatableIDImpl;
import org.herasaf.xacml.core.policy.impl.ObligationType;
import org.herasaf.xacml.core.policy.impl.ObligationsType;
import org.herasaf.xacml.core.policy.impl.PolicyType;
import org.herasaf.xacml.core.policy.impl.RuleType;
import org.husky.xua.core.SecurityObjectBuilder;
import org.husky.xua.saml2.SimpleBuilder;
import org.opensaml.core.xml.schema.impl.XSStringBuilder;
import org.opensaml.xacml.policy.impl.DefaultsTypeImplBuilder;
import org.opensaml.xacml.policy.impl.DescriptionTypeImplBuilder;
import org.opensaml.xacml.policy.impl.ObligationsTypeImplBuilder;
import org.opensaml.xacml.policy.impl.PolicyTypeImplBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the corresponding interface for PolicyType building.</div>
 * <div class="de">Die Klasse implementiert das entsprechende Interface um PolicyType bilden zu können.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class PolicyBuilderImpl
		implements SimpleBuilder<PolicyType>, SecurityObjectBuilder<org.opensaml.xacml.policy.PolicyType, PolicyType> {

	@Override
	public PolicyType create(org.opensaml.xacml.policy.PolicyType aInternalObject) {
		var policy = new PolicyType();
		policy.setVersion(aInternalObject.getVersion());

		if (aInternalObject.getDescription() != null) {
			policy.setDescription(aInternalObject.getDescription().getValue());
		}

		if (aInternalObject.getRuleCombiningAlgoId() != null) {
			if (aInternalObject.getRuleCombiningAlgoId().contains("rule-combining-algorithm:deny-overrides")) {
				policy.setCombiningAlg(new RuleDenyOverridesAlgorithm());
			} else if (aInternalObject.getRuleCombiningAlgoId()
					.contains("rule-combining-algorithm:only-one-applicable")) {
				policy.setCombiningAlg(new RuleFirstApplicableAlgorithm());
			} else if (aInternalObject.getRuleCombiningAlgoId().contains("rule-combining-algorithm:permit-overrides")) {
				policy.setCombiningAlg(new RulePermitOverridesAlgorithm());
			} else if (aInternalObject.getRuleCombiningAlgoId()
					.contains("urn:oasis:names:tc:xacml:1.1:rule-combining-algorithm:ordered-permit-overrides")) {
				policy.setCombiningAlg(new RuleOrderedPermitOverridesAlgorithm());
			} else if (aInternalObject.getRuleCombiningAlgoId()
					.contains("urn:oasis:names:tc:xacml:1.1:rule-combining-algorithm:ordered-deny-overrides")) {
				policy.setCombiningAlg(new RuleOrderedDenyOverridesAlgorithm());
			}
		}

		if (aInternalObject.getObligations() != null) {
			var obligationsType = new ObligationsType();

			for (org.opensaml.xacml.policy.ObligationType type : aInternalObject.getObligations().getObligations()) {
				obligationsType.getObligations().add(new ObligationBuilderImpl().create(type));
			}

			policy.setObligations(obligationsType);
		}

		if (aInternalObject.getPolicyDefaults() != null
				&& aInternalObject.getPolicyDefaults().getXPathVersion() != null) {
			var defaultType = new DefaultsType();
			defaultType.setXPathVersion(aInternalObject.getPolicyDefaults().getXPathVersion().getValue());
			policy.setPolicyDefaults(defaultType);
		}

		policy.setPolicyId(new EvaluatableIDImpl(aInternalObject.getPolicyId()));

		if (aInternalObject.getTarget() != null) {
			policy.setTarget(new TargetBuilderImpl().create(aInternalObject.getTarget()));
		}

		if (aInternalObject.getRules() != null) {
			for (org.opensaml.xacml.policy.RuleType rule : aInternalObject.getRules()) {
				policy.getAdditionalInformation().add(new RuleBuilderImpl().create(rule));
			}
		}

		return policy;
	}

	@Override
	public PolicyType create() {
		return new PolicyType();
	}

	public org.opensaml.xacml.policy.PolicyType create(PolicyType aInternalObject) {
		var policy = new PolicyTypeImplBuilder().buildObject();
		policy.setVersion(aInternalObject.getVersion());

		if (aInternalObject.getDescription() != null) {
			var description = new DescriptionTypeImplBuilder().buildObject();
			description.setValue(aInternalObject.getDescription());
			policy.setDescription(description);
		}

		if (aInternalObject.getCombiningAlg() != null) {
			policy.setRuleCombiningAlgoId(aInternalObject.getCombiningAlg().getCombiningAlgorithmId());
		}

		if (aInternalObject.getObligations() != null) {
			var obligationsType = new ObligationsTypeImplBuilder().buildObject();

			for (ObligationType type : aInternalObject.getObligations().getObligations()) {
				obligationsType.getObligations().add(new ObligationBuilderImpl().create(type));
			}

			policy.setObligations(obligationsType);
		}

		if (aInternalObject.getPolicyDefaults() != null
				&& aInternalObject.getPolicyDefaults().getXPathVersion() != null) {
			var defaultType = new DefaultsTypeImplBuilder().buildObject();
			var xsstring = new XSStringBuilder().buildObject("", "", "");
			xsstring.setValue(aInternalObject.getPolicyDefaults().getXPathVersion());
			defaultType.setXPathVersion(xsstring);
			policy.setPolicyDefaults(defaultType);
		}

		policy.setPolicyId(((EvaluatableIDImpl) aInternalObject.getPolicyId()).toString());

		if (aInternalObject.getTarget() != null) {
			policy.setTarget(new TargetBuilderImpl().create(aInternalObject.getTarget()));
		}

		if (aInternalObject.getAdditionalInformation() != null) {
			for (Object obj : aInternalObject.getAdditionalInformation()) {
				if (obj instanceof RuleType rule) {
					policy.getRules().add(new RuleBuilderImpl().create(rule));
				}
			}

		}

		return policy;
	}

}
