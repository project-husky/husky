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
import org.herasaf.xacml.core.combiningAlgorithm.rule.impl.RuleDenyOverridesAlgorithm;
import org.herasaf.xacml.core.combiningAlgorithm.rule.impl.RuleFirstApplicableAlgorithm;
import org.herasaf.xacml.core.combiningAlgorithm.rule.impl.RuleOrderedDenyOverridesAlgorithm;
import org.herasaf.xacml.core.combiningAlgorithm.rule.impl.RuleOrderedPermitOverridesAlgorithm;
import org.herasaf.xacml.core.combiningAlgorithm.rule.impl.RulePermitOverridesAlgorithm;
import org.herasaf.xacml.core.policy.impl.ActionType;
import org.herasaf.xacml.core.policy.impl.ActionsType;
import org.herasaf.xacml.core.policy.impl.DefaultsType;
import org.herasaf.xacml.core.policy.impl.EvaluatableIDImpl;
import org.herasaf.xacml.core.policy.impl.ObligationsType;
import org.herasaf.xacml.core.policy.impl.PolicyType;
import org.herasaf.xacml.core.policy.impl.ResourceType;
import org.herasaf.xacml.core.policy.impl.ResourcesType;
import org.herasaf.xacml.core.policy.impl.SubjectsType;
import org.herasaf.xacml.core.policy.impl.TargetType;
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

	private org.opensaml.xacml.policy.PolicyType wrappedObject;

	public PolicyBuilderImpl() {
		wrappedObject = new PolicyTypeImplBuilder().buildObject();
	}

	@Override
	public PolicyType create(org.opensaml.xacml.policy.PolicyType aInternalObject) {
		var policy = new PolicyType();
		policy.setVersion(aInternalObject.getVersion());

		if (aInternalObject.getDescription() != null) {
			policy.setDescription(aInternalObject.getDescription().getValue());
		}

		if ("urn:oasis:names:tc:xacml:1.0:rule-combining-algorithm:deny-overrides"
				.equalsIgnoreCase(aInternalObject.getRuleCombiningAlgoId())) {
			policy.setCombiningAlg(new RuleDenyOverridesAlgorithm());
		} else if ("urn:oasis:names:tc:xacml:1.0:rule-combining-algorithm:only-one-applicable"
				.equalsIgnoreCase(aInternalObject.getRuleCombiningAlgoId())) {
			policy.setCombiningAlg(new RuleFirstApplicableAlgorithm());
		} else if ("urn:oasis:names:tc:xacml:1.0:rule-combining-algorithm:permit-overrides"
				.equalsIgnoreCase(aInternalObject.getRuleCombiningAlgoId())) {
			policy.setCombiningAlg(new RulePermitOverridesAlgorithm());
		} else if ("urn:oasis:names:tc:xacml:1.1:rule-combining-algorithm:ordered-permit-overrides"
				.equalsIgnoreCase(aInternalObject.getRuleCombiningAlgoId())) {
			policy.setCombiningAlg(new RuleOrderedPermitOverridesAlgorithm());
		} else if ("urn:oasis:names:tc:xacml:1.1:rule-combining-algorithm:ordered-deny-overrides"
				.equalsIgnoreCase(aInternalObject.getRuleCombiningAlgoId())) {
			policy.setCombiningAlg(new RuleOrderedDenyOverridesAlgorithm());
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
			var targetType = new TargetType();

			if (aInternalObject.getTarget().getActions() != null
					&& aInternalObject.getTarget().getActions().getActions() != null) {
				var actionsType = new ActionsType();
				for (var type : aInternalObject.getTarget().getActions().getActions()) {
					var actionType = new ActionType();

					for (var typeMatch : type.getActionMatches()) {
						actionType.getActionMatches().add(new ActionMatchBuilderImpl().create(typeMatch));
					}

					actionsType.getActions().add(actionType);
				}

				targetType.setActions(actionsType);
			}

			if (aInternalObject.getTarget().getSubjects() != null
					&& aInternalObject.getTarget().getSubjects().getSubjects() != null) {
				var subjectsType = new SubjectsType();

				for (var type : aInternalObject.getTarget().getSubjects().getSubjects()) {
					var subjectType = new org.herasaf.xacml.core.policy.impl.SubjectType();

					for (var typeMatch : type.getSubjectMatches()) {
						subjectType.getSubjectMatches().add(new SubjectMatchBuilderImpl().create(typeMatch));
					}

					subjectsType.getSubjects().add(subjectType);
				}
				targetType.setSubjects(subjectsType);
			}

			if (aInternalObject.getTarget().getResources() != null
					&& aInternalObject.getTarget().getResources().getResources() != null) {
				var resourcesType = new ResourcesType();

				for (var type : aInternalObject.getTarget().getResources().getResources()) {
					var resourceType = new ResourceType();

					for (var typeMatch : type.getResourceMatches()) {
						resourceType.getResourceMatches().add(new ResourceMatchBuilderImpl().create(typeMatch));
					}

					resourcesType.getResources().add(resourceType);
				}
				targetType.setResources(resourcesType);
			}

			policy.setTarget(targetType);
		}

		return policy;
	}

	@Override
	public PolicyType create() {
		return new PolicyType();
	}

}
