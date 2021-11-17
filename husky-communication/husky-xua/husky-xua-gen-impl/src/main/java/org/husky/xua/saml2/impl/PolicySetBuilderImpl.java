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
package org.husky.xua.saml2.impl;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.herasaf.xacml.core.combiningAlgorithm.policy.impl.PolicyDenyOverridesAlgorithm;
import org.herasaf.xacml.core.combiningAlgorithm.policy.impl.PolicyFirstApplicableAlgorithm;
import org.herasaf.xacml.core.combiningAlgorithm.policy.impl.PolicyOnlyOneApplicableAlgorithm;
import org.herasaf.xacml.core.combiningAlgorithm.policy.impl.PolicyOrderedDenyOverridesAlgorithm;
import org.herasaf.xacml.core.combiningAlgorithm.policy.impl.PolicyPermitOverridesAlgorithm;
import org.herasaf.xacml.core.policy.impl.DefaultsType;
import org.herasaf.xacml.core.policy.impl.EvaluatableIDImpl;
import org.herasaf.xacml.core.policy.impl.IdReferenceType;
import org.herasaf.xacml.core.policy.impl.ObligationType;
import org.herasaf.xacml.core.policy.impl.ObligationsType;
import org.herasaf.xacml.core.policy.impl.PolicySetType;
import org.husky.xua.core.SecurityObjectBuilder;
import org.husky.xua.saml2.SimpleBuilder;
import org.openehealth.ipf.commons.ihe.xacml20.stub.ehealthswiss.XACMLPolicySetIdReferenceStatementType;
import org.opensaml.core.xml.schema.impl.XSStringBuilder;
import org.opensaml.xacml.policy.impl.DefaultsTypeImplBuilder;
import org.opensaml.xacml.policy.impl.DescriptionTypeImplBuilder;
import org.opensaml.xacml.policy.impl.IdReferenceTypeImplBuilder;
import org.opensaml.xacml.policy.impl.ObligationsTypeImplBuilder;
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

	@Override
	public PolicySetType create(org.opensaml.xacml.policy.PolicySetType aInternalObject) {
		var policySet = new PolicySetType();
		policySet.setVersion(aInternalObject.getVersion());

		if (aInternalObject.getDescription() != null) {
			policySet.setDescription(aInternalObject.getDescription().getValue());
		}

		if ("urn:oasis:names:tc:xacml:1.0:policy-combining-algorithm:deny-overrides"
				.equalsIgnoreCase(aInternalObject.getPolicyCombiningAlgoId())) {
			policySet.setCombiningAlg(new PolicyDenyOverridesAlgorithm());
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
			policySet.setTarget(new TargetBuilderImpl().create(aInternalObject.getTarget()));
		}

		return policySet;
	}

	@Override
	public PolicySetType create() {
		return new PolicySetType();
	}

	public org.opensaml.xacml.policy.PolicySetType create(PolicySetType policySetType) {
		var policySet = new PolicySetTypeImplBuilder().buildObject();
		policySet.setVersion(policySetType.getVersion());

		if (policySetType.getDescription() != null) {
			var description = new DescriptionTypeImplBuilder().buildObject();
			description.setValue(policySetType.getDescription());
			policySet.setDescription(description);
		}

		if (policySetType.getCombiningAlg() != null
				&& policySetType.getCombiningAlg().getCombiningAlgorithmId() != null) {
			policySet.setPolicyCombiningAlgoId(policySetType.getCombiningAlg().getCombiningAlgorithmId());
		}


		if (policySetType.getObligations() != null) {
			var obligationsType = new ObligationsTypeImplBuilder().buildObject();

			for (ObligationType type : policySetType.getObligations().getObligations()) {
				obligationsType.getObligations().add(new ObligationBuilderImpl().create(type));
			}

			policySet.setObligations(obligationsType);
		}

		if (policySetType.getPolicySetDefaults() != null
				&& policySetType.getPolicySetDefaults().getXPathVersion() != null) {
			var defaultType = new DefaultsTypeImplBuilder().buildObject();
			var xPathVersion = new XSStringBuilder().buildObject("urn:oasis:names:tc:xacml:2.0:policy:schema:os",
					"XPathVersion", "xacml");
			xPathVersion.setValue(policySetType.getPolicySetDefaults().getXPathVersion());
			defaultType.setXPathVersion(xPathVersion);
			policySet.setPolicySetDefaults(defaultType);
		}

		if (policySetType.getPolicySetId() != null) {
			var policySetId = (EvaluatableIDImpl) policySetType.getPolicySetId();
			policySet.setPolicySetId(policySetId.toString());
		}

		if (policySetType.getAdditionalInformation() != null) {
			for (JAXBElement<?> element : policySetType.getAdditionalInformation()) {
				if (element != null) {
					if (element.getValue() instanceof XACMLPolicySetIdReferenceStatementType) {
						var idReferenceType = (XACMLPolicySetIdReferenceStatementType) element.getValue();

						if (idReferenceType != null && idReferenceType.getPolicySetIdReference() != null
								&& !idReferenceType.getPolicySetIdReference().isEmpty()
								&& idReferenceType.getPolicySetIdReference().get(0) != null) {
							var idReference = new IdReferenceTypeImplBuilder().buildObject(
									new QName("urn:oasis:names:tc:xacml:2.0:policy:schema:os", "PolicySetIdReference"));
							idReference.setVersion(idReferenceType.getPolicySetIdReference().get(0).getVersion());
							idReference.setValue(idReferenceType.getPolicySetIdReference().get(0).getValue());
							idReference.setEarliestVersion(
									idReferenceType.getPolicySetIdReference().get(0).getEarliestVersion());
							idReference.setLatestVersion(
									idReferenceType.getPolicySetIdReference().get(0).getLatestVersion());
							policySet.getPolicySetIdReferences().add(idReference);
						}
					} else if (element.getValue() instanceof IdReferenceType) {
						var idReferenceType = (IdReferenceType) element.getValue();

						if (idReferenceType != null) {
							var idReference = new IdReferenceTypeImplBuilder().buildObject(
									new QName("urn:oasis:names:tc:xacml:2.0:policy:schema:os", "PolicySetIdReference"));
							idReference.setVersion(idReferenceType.getVersion());
							idReference.setValue(idReferenceType.getValue());
							idReference.setEarliestVersion(idReferenceType.getEarliestVersion());
							idReference.setLatestVersion(idReferenceType.getLatestVersion());
							policySet.getPolicySetIdReferences().add(idReference);
						}
					}
				}

			}
		}

		if (policySetType.getTarget() != null) {
			policySet.setTarget(new TargetBuilderImpl().create(policySetType.getTarget()));
		}

		return policySet;
	}

}
