package org.ehealth_connector.xua.saml2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.opensaml.core.xml.AbstractXMLObject;
import org.opensaml.core.xml.XMLObject;
import org.opensaml.xacml.policy.IdReferenceType;

public class XACMLPolicySetIdReferenceStatementImpl extends AbstractXMLObject
		implements XACMLPolicySetIdReferenceStatement {


	/** ReferencedPolicie child. */
	private List<IdReferenceType> policySetIdReference;

	/**
     * Constructor.
     * 
     * @param namespaceURI the namespace the element is in
     * @param elementLocalName the local name of the XML element this Object represents
     * @param namespacePrefix the prefix for the given namespace
     */
	protected XACMLPolicySetIdReferenceStatementImpl(final String namespaceURI, final String elementLocalName,
            final String namespacePrefix) {
        super(namespaceURI, elementLocalName, namespacePrefix);
		policySetIdReference = new LinkedList<>();
    }

	/** {@inheritDoc} */
	public List<XMLObject> getOrderedChildren() {
		final ArrayList<XMLObject> children = new ArrayList<>();

		children.addAll(policySetIdReference);

		return Collections.unmodifiableList(children);
	}

	/** {@inheritDoc} */
	public List<IdReferenceType> getPolicySetIdReference() {
		return this.policySetIdReference;

	}


}
