package org.projecthusky.xua.saml2;

import java.util.List;

import javax.xml.namespace.QName;

import org.opensaml.saml.saml2.core.Statement;
import org.opensaml.xacml.XACMLObject;
import org.opensaml.xacml.policy.IdReferenceType;
import org.opensaml.xacml.profile.saml.SAMLProfileConstants;

/**
 * Class implementing XACMLPolicySetIdReferenceStatement
 */
public interface XACMLPolicySetIdReferenceStatement extends Statement, XACMLObject {

	/** Element local name. */
	public static final String DEFAULT_ELEMENT_LOCAL_NAME = "XACMLPolicySetIdReferenceStatement";

	/** Default element name for XACML 1.0. */
	public static final QName DEFAULT_ELEMENT_NAME_XACML10 = new QName(SAMLProfileConstants.SAML20XACML10_NS,
			DEFAULT_ELEMENT_LOCAL_NAME, SAMLProfileConstants.SAML20XACMLASSERTION_PREFIX);

	/** Default element name for XACML 1.1. */
	public static final QName DEFAULT_ELEMENT_NAME_XACML11 = new QName(SAMLProfileConstants.SAML20XACML1_1_NS,
			DEFAULT_ELEMENT_LOCAL_NAME, SAMLProfileConstants.SAML20XACMLASSERTION_PREFIX);

	/** Default element name for XACML 2.0. */
	public static final QName DEFAULT_ELEMENT_NAME_XACML20 = new QName(SAMLProfileConstants.SAML20XACML20_NS,
			DEFAULT_ELEMENT_LOCAL_NAME, SAMLProfileConstants.SAML20XACMLASSERTION_PREFIX);

	/** Default element name for XACML 3.0. */
	public static final QName DEFAULT_ELEMENT_NAME_XACML30 = new QName(SAMLProfileConstants.SAML20XACML30_NS,
			DEFAULT_ELEMENT_LOCAL_NAME, SAMLProfileConstants.SAML20XACMLASSERTION_PREFIX);

	/** Local name of the XSI type. */
	public static final String TYPE_LOCAL_NAME = "XACMLPolicySetIdReferenceStatementType";

	/** QName of the XSI type.XACML1.0. */
	public static final QName TYPE_NAME_XACML10 = new QName(SAMLProfileConstants.SAML20XACML10_NS, TYPE_LOCAL_NAME,
			SAMLProfileConstants.SAML20XACMLASSERTION_PREFIX);

	/** QName of the XSI type.XACML1.1. */
	public static final QName TYPE_NAME_XACML11 = new QName(SAMLProfileConstants.SAML20XACML1_1_NS, TYPE_LOCAL_NAME,
			SAMLProfileConstants.SAML20XACMLASSERTION_PREFIX);

	/** QName of the XSI type.XACML2.0. */
	public static final QName TYPE_NAME_XACML20 = new QName(SAMLProfileConstants.SAML20XACML20_NS, TYPE_LOCAL_NAME,
			SAMLProfileConstants.SAML20XACMLASSERTION_PREFIX);

	/** QName of the XSI type.XACML3.0. */
	public static final QName TYPE_NAME_XACML30 = new QName(SAMLProfileConstants.SAML20XACML30_NS, TYPE_LOCAL_NAME,
			SAMLProfileConstants.SAML20XACMLASSERTION_PREFIX);

	/**
	 * Return the XACMLPolicy inside the policy statement.
	 * 
	 * @return the Policy
	 */
	public List<IdReferenceType> getPolicySetIdReference();

}