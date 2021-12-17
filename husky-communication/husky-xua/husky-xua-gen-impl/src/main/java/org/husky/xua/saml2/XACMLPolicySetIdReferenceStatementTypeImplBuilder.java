package org.husky.xua.saml2;

import org.opensaml.saml.common.AbstractSAMLObjectBuilder;
import org.opensaml.saml.saml2.core.Statement;

public class XACMLPolicySetIdReferenceStatementTypeImplBuilder
		extends AbstractSAMLObjectBuilder<XACMLPolicySetIdReferenceStatement> {

	/** Constructor. */
	public XACMLPolicySetIdReferenceStatementTypeImplBuilder() {

    }

	/** {@inheritDoc} */
	public XACMLPolicySetIdReferenceStatement buildObject() {
		return buildObject(Statement.DEFAULT_ELEMENT_NAME, Statement.TYPE_NAME);
	}

	/** {@inheritDoc} */
	public XACMLPolicySetIdReferenceStatement buildObject(final String namespaceURI, final String localName,
			final String namespacePrefix) {
		return new XACMLPolicySetIdReferenceStatementImpl(namespaceURI, localName, namespacePrefix);
	}
}