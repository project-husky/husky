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

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.herasaf.xacml.core.combiningAlgorithm.policy.AbstractPolicyCombiningAlgorithm;
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
public class PolicySetBuilderImpl implements SimpleBuilder<PolicySetType>,
		SecurityObjectBuilder<org.opensaml.xacml.policy.PolicySetType, PolicySetType> {

	private static final String XACML_NAMESPACE = "urn:oasis:names:tc:xacml:2.0:policy:schema:os";
	private static final String ELEMENT_NAME_POLICY_SET_ID_REFERENCE = "PolicySetIdReference";

	@Override
	public PolicySetType create(org.opensaml.xacml.policy.PolicySetType aInternalObject) {
		var policySet = new PolicySetType();
		policySet.setVersion(aInternalObject.getVersion());

		if (aInternalObject.getDescription() != null) {
			policySet.setDescription(aInternalObject.getDescription().getValue());
		}

		policySet.setCombiningAlg(getCombiningAlg(aInternalObject.getPolicyCombiningAlgoId()));

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
			var qnameIdReference = new QName(XACML_NAMESPACE, ELEMENT_NAME_POLICY_SET_ID_REFERENCE);
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

	private AbstractPolicyCombiningAlgorithm getCombiningAlg(String policyCombiningAlgoId) {
		if ("urn:oasis:names:tc:xacml:1.0:policy-combining-algorithm:deny-overrides"
				.equalsIgnoreCase(policyCombiningAlgoId)) {
			return new PolicyDenyOverridesAlgorithm();
		} else if ("urn:oasis:names:tc:xacml:1.0:policy-combining-algorithm:only-one-applicable"
				.equalsIgnoreCase(policyCombiningAlgoId)) {
			return new PolicyOnlyOneApplicableAlgorithm();
		} else if ("urn:oasis:names:tc:xacml:1.0:policy-combining-algorithm:permit-overrides"
				.equalsIgnoreCase(policyCombiningAlgoId)) {
			return new PolicyPermitOverridesAlgorithm();
		} else if ("urn:oasis:names:tc:xacml:1.1:policy-combining-algorithm:ordered-permit-overrides"
				.equalsIgnoreCase(policyCombiningAlgoId)) {
			return new PolicyOrderedDenyOverridesAlgorithm();
		} else if ("urn:oasis:names:tc:xacml:1.1:policy-combining-algorithm:ordered-deny-overrides"
				.equalsIgnoreCase(policyCombiningAlgoId)) {
			return new PolicyOrderedDenyOverridesAlgorithm();
		} else if ("urn:oasis:names:tc:xacml:1.0:policy-combining-algorithm:first-applicable"
				.equalsIgnoreCase(policyCombiningAlgoId)) {
			return new PolicyFirstApplicableAlgorithm();
		}

		return null;
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
			var xPathVersion = new XSStringBuilder().buildObject(XACML_NAMESPACE, "XPathVersion", "xacml");
			xPathVersion.setValue(policySetType.getPolicySetDefaults().getXPathVersion());
			defaultType.setXPathVersion(xPathVersion);
			policySet.setPolicySetDefaults(defaultType);
		}

		if (policySetType.getPolicySetId() != null) {
			var policySetId = (EvaluatableIDImpl) policySetType.getPolicySetId();
			policySet.setPolicySetId(policySetId.toString());
		}

		if (policySetType.getAdditionalInformation() != null) {
			policySet.getPolicySetIdReferences()
					.addAll(extractIdsFromAdditionalInformation(policySetType.getAdditionalInformation()));
		}

		if (policySetType.getTarget() != null) {
			policySet.setTarget(new TargetBuilderImpl().create(policySetType.getTarget()));
		}

		return policySet;
	}

	private List<org.opensaml.xacml.policy.IdReferenceType> extractIdsFromAdditionalInformation(
			List<JAXBElement<?>> elements) {
		List<org.opensaml.xacml.policy.IdReferenceType> ids = new LinkedList<>();
		for (JAXBElement<?> element : elements) {
			if (element != null) {
				if (element.getValue()instanceof XACMLPolicySetIdReferenceStatementType idReferenceType) {
					if (idReferenceType.getPolicySetIdReference() != null
							&& !idReferenceType.getPolicySetIdReference().isEmpty()
							&& idReferenceType.getPolicySetIdReference().get(0) != null) {
						var idReference = new IdReferenceTypeImplBuilder()
								.buildObject(new QName(XACML_NAMESPACE, ELEMENT_NAME_POLICY_SET_ID_REFERENCE));
						idReference.setVersion(idReferenceType.getPolicySetIdReference().get(0).getVersion());
						idReference.setValue(idReferenceType.getPolicySetIdReference().get(0).getValue());
						idReference.setEarliestVersion(
								idReferenceType.getPolicySetIdReference().get(0).getEarliestVersion());
						idReference
								.setLatestVersion(idReferenceType.getPolicySetIdReference().get(0).getLatestVersion());
						ids.add(idReference);
					}
				} else if (element.getValue()instanceof IdReferenceType idReferenceType) {
					var idReference = new IdReferenceTypeImplBuilder()
							.buildObject(new QName(XACML_NAMESPACE, ELEMENT_NAME_POLICY_SET_ID_REFERENCE));
					idReference.setVersion(idReferenceType.getVersion());
					idReference.setValue(idReferenceType.getValue());
					idReference.setEarliestVersion(idReferenceType.getEarliestVersion());
					idReference.setLatestVersion(idReferenceType.getLatestVersion());
					ids.add(idReference);
				}
			}
		}

		return ids;
	}

}
