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

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.ehealth_connector.xua.core.SecurityObjectBuilder;
import org.ehealth_connector.xua.saml2.SimpleBuilder;
import org.herasaf.xacml.core.combiningAlgorithm.policy.impl.PolicyFirstApplicableAlgorithm;
import org.herasaf.xacml.core.combiningAlgorithm.policy.impl.PolicyOnlyOneApplicableAlgorithm;
import org.herasaf.xacml.core.combiningAlgorithm.policy.impl.PolicyOrderedDenyOverridesAlgorithm;
import org.herasaf.xacml.core.combiningAlgorithm.policy.impl.PolicyPermitOverridesAlgorithm;
import org.herasaf.xacml.core.policy.impl.ActionType;
import org.herasaf.xacml.core.policy.impl.ActionsType;
import org.herasaf.xacml.core.policy.impl.DefaultsType;
import org.herasaf.xacml.core.policy.impl.EvaluatableIDImpl;
import org.herasaf.xacml.core.policy.impl.IdReferenceType;
import org.herasaf.xacml.core.policy.impl.ObligationsType;
import org.herasaf.xacml.core.policy.impl.PolicySetType;
import org.herasaf.xacml.core.policy.impl.ResourceType;
import org.herasaf.xacml.core.policy.impl.ResourcesType;
import org.herasaf.xacml.core.policy.impl.SubjectsType;
import org.herasaf.xacml.core.policy.impl.TargetType;
import org.opensaml.xacml.policy.impl.PolicySetTypeImplBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the corresponding interface for AuthnStatement building.</div>
 * <div class="de">Die Klasse implementiert das entsprechende Interface um AuthnStatements bilden zu können.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class PolicySetBuilderImpl
		implements SimpleBuilder<PolicySetType>,
		SecurityObjectBuilder<org.opensaml.xacml.policy.PolicySetType, PolicySetType> {

	private org.opensaml.xacml.policy.PolicySetType wrappedObject;

	public PolicySetBuilderImpl() {
		wrappedObject = new PolicySetTypeImplBuilder().buildObject();
	}

	@Override
	public PolicySetType create(org.opensaml.xacml.policy.PolicySetType aInternalObject) {
		this.wrappedObject = aInternalObject;
		var policySet = new PolicySetType();
		policySet.setVersion(aInternalObject.getVersion());

		if (aInternalObject.getDescription() != null) {
			policySet.setDescription(aInternalObject.getDescription().getValue());
		}

		if ("urn:oasis:names:tc:xacml:1.0:policy-combining-algorithm:deny-overrides"
				.equalsIgnoreCase(aInternalObject.getPolicyCombiningAlgoId())) {
			policySet.setCombiningAlg(new PolicyOrderedDenyOverridesAlgorithm());
		} else if ("urn:oasis:names:tc:xacml:1.0:policy-combining-algorithm:only-one-applicable"
				.equalsIgnoreCase(aInternalObject.getPolicyCombiningAlgoId())) {
			policySet.setCombiningAlg(new PolicyOnlyOneApplicableAlgorithm());
		} else if ("urn:oasis:names:tc:xacml:1.0:policy-combining-algorithm:permit-overrides"
				.equalsIgnoreCase(aInternalObject.getPolicyCombiningAlgoId())) {
			policySet.setCombiningAlg(new PolicyPermitOverridesAlgorithm());
		} else if ("urn:oasis:names:tc:xacml:1.1:policy-combining-algorithm:ordered-permit-overrides"
				.equalsIgnoreCase(aInternalObject.getPolicyCombiningAlgoId())) {
			policySet.setCombiningAlg(new PolicyOrderedDenyOverridesAlgorithm());
		} else if ("urn:oasis:names:tc:xacml:1.1:policy-combining-algorithm:ordered-deny-overrides"
				.equalsIgnoreCase(aInternalObject.getPolicyCombiningAlgoId())) {
			policySet.setCombiningAlg(new PolicyOrderedDenyOverridesAlgorithm());
		} else if ("urn:oasis:names:tc:xacml:1.0:policy-combining-algorithm:first-applicable"
				.equalsIgnoreCase(aInternalObject.getPolicyCombiningAlgoId())) {
			policySet.setCombiningAlg(new PolicyFirstApplicableAlgorithm());
		}

		if (aInternalObject.getObligations() != null) {
			policySet.setHasObligations(true);

			var obligationsType = new ObligationsType();

			for (org.opensaml.xacml.policy.ObligationType type : aInternalObject.getObligations().getObligations()) {
				obligationsType.getObligations().add(new ObligationBuilderImpl().create(type));
			}

			policySet.setObligations(obligationsType);
		}

		if (aInternalObject.getPolicySetDefaults() != null
				&& aInternalObject.getPolicySetDefaults().getXPathVersion() != null) {
			var defaultType = new DefaultsType();
			defaultType.setXPathVersion(aInternalObject.getPolicySetDefaults().getXPathVersion().getValue());
			policySet.setPolicySetDefaults(defaultType);
		}

		policySet.setPolicySetId(new EvaluatableIDImpl(aInternalObject.getPolicySetId()));

		if (aInternalObject.getPolicySetIdReferences() != null) {
			var qnameIdReference = new QName("urn:oasis:names:tc:xacml:2.0:policy:schema:os", "PolicySetIdReference");
			for (org.opensaml.xacml.policy.IdReferenceType idReference : aInternalObject.getPolicySetIdReferences()) {
				if (idReference != null) {
					var idReferenceType = new IdReferenceType();
					idReferenceType.setVersion(idReference.getVersion());
					idReferenceType.setValue(idReference.getValue());
					idReferenceType.setEarliestVersion(idReference.getEarliestVersion());
					idReferenceType.setLatestVersion(idReference.getLatestVersion());
					policySet.getAdditionalInformation()
							.add(new JAXBElement<>(qnameIdReference, IdReferenceType.class, idReferenceType));
				}
			}
		}

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


			policySet.setTarget(targetType);
		}

		return policySet;
	}

	@Override
	public PolicySetType create() {
		return new PolicySetType();
	}

}
