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

import org.herasaf.xacml.core.policy.impl.IdReferenceType;
import org.projecthusky.xua.core.SecurityObjectBuilder;
import org.projecthusky.xua.saml2.SimpleBuilder;
import org.projecthusky.xua.saml2.XACMLPolicySetIdReferenceStatement;
import org.projecthusky.xua.saml2.XACMLPolicySetIdReferenceStatementTypeImplBuilder;
import org.openehealth.ipf.commons.ihe.xacml20.stub.ehealthswiss.XACMLPolicySetIdReferenceStatementType;
import org.opensaml.xacml.policy.impl.IdReferenceTypeImplBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the corresponding interface for AuthnStatement building.</div>
 * <div class="de">Die Klasse implementiert das entsprechende Interface um AuthnStatements bilden zu können.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class XacmlPolicySetIdReferenceStatementBuilderImpl
		implements SimpleBuilder<XACMLPolicySetIdReferenceStatementType>,
		SecurityObjectBuilder<XACMLPolicySetIdReferenceStatement, XACMLPolicySetIdReferenceStatementType> {

	@Override
	public XACMLPolicySetIdReferenceStatementType create() {
		return new XACMLPolicySetIdReferenceStatementType();
	}

	@Override
	public XACMLPolicySetIdReferenceStatementType create(XACMLPolicySetIdReferenceStatement aInternalObject) {
		var retVal = new XACMLPolicySetIdReferenceStatementType();

		if (aInternalObject != null) {
			for (var policySetIdRef : aInternalObject.getPolicySetIdReference()) {
				if (policySetIdRef != null) {
					var id = new IdReferenceType();
					id.setValue(policySetIdRef.getValue());
					retVal.getPolicySetIdReference().add(id);
				}
			}
		}

		return retVal;
	}

	/**
	 * Method to create XACMLPolicySetIdReferenceStatementType.
	 * 
	 * @param aInternalObject the XACMLPolicySetIdReferenceStatementType
	 * @return the opensaml XACMLPolicySetIdReferenceStatementType
	 */
	public XACMLPolicySetIdReferenceStatement create(XACMLPolicySetIdReferenceStatementType aInternalObject) {
		var retVal = new XACMLPolicySetIdReferenceStatementTypeImplBuilder().buildObject();

		if (aInternalObject != null) {
			for (var policySetIdRef : aInternalObject.getPolicySetIdReference()) {
				if (policySetIdRef != null) {
					var id = new IdReferenceTypeImplBuilder().buildObject();
					id.setValue(policySetIdRef.getValue());
					retVal.getPolicySetIdReference().add(id);
				}
			}
		}

		return retVal;
	}

}
