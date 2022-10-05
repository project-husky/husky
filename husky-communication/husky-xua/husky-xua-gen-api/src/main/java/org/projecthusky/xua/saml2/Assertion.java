package org.projecthusky.xua.saml2;

import org.projecthusky.xua.core.SecurityHeaderElement;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.AssertionType;

public abstract class Assertion extends AssertionType implements SecurityHeaderElement {

	// There are no special methods defined, but the interface has to be
	// declared for selection reasons.

}
