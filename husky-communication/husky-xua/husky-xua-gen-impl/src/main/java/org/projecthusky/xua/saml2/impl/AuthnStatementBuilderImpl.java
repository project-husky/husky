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

import java.util.Calendar;

import org.projecthusky.xua.core.SecurityObjectBuilder;
import org.projecthusky.xua.saml2.AuthnStatementBuilder;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.AuthnStatementType;
import org.opensaml.saml.saml2.core.AuthnContextClassRef;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the corresponding interface for AuthnStatement building.</div>
 * <div class="de">Die Klasse implementiert das entsprechende Interface um AuthnStatements bilden zu können.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class AuthnStatementBuilderImpl implements AuthnStatementBuilder,
		SecurityObjectBuilder<org.opensaml.saml.saml2.core.AuthnStatement, AuthnStatementType> {

	private AuthnContextClassRef authnContextClassRef;
	private org.opensaml.saml.saml2.core.AuthnStatement wrappedObject;

	/**
	 * Default constructor
	 */
	public AuthnStatementBuilderImpl() {
		wrappedObject = new org.opensaml.saml.saml2.core.impl.AuthnStatementBuilder().buildObject();
		final var authnContext = new org.opensaml.saml.saml2.core.impl.AuthnContextBuilder()
				.buildObject();
		wrappedObject.setAuthnContext(authnContext);
		authnContextClassRef = new org.opensaml.saml.saml2.core.impl.AuthnContextClassRefBuilder()
				.buildObject();
		authnContext.setAuthnContextClassRef(authnContextClassRef);
	}

	@Override
	public AuthnStatementBuilder authnContextClassRef(String aAuthnContextClassRef) {
		if (aAuthnContextClassRef != null) {
			authnContextClassRef.setURI(aAuthnContextClassRef);
		}
		return this;
	}

	@Override
	public AuthnStatementBuilder authnInstant(Calendar aAuthnInstant) {
		if (aAuthnInstant != null) {
			wrappedObject.setAuthnInstant(aAuthnInstant.toInstant());
		}
		return this;
	}

	@Override
	public AuthnStatementType create() {
		return new AuthnStatementImpl(wrappedObject);
	}

	@Override
	public AuthnStatementType create(org.opensaml.saml.saml2.core.AuthnStatement aAuthnStatement) {
		return new AuthnStatementImpl(aAuthnStatement);
	}

	/**
	 * Method to create opensaml authntatement.
	 * @param aAuthnStatement the authnstatement to be converted
	 * @return the opensaml rfepresentation of authnstatement
	 */
	public org.opensaml.saml.saml2.core.AuthnStatement create(AuthnStatementType aAuthnStatement) {
		return new AuthnStatementImpl(aAuthnStatement).getWrappedObject();
	}

	@Override
	public AuthnStatementBuilder sessionIndex(String aSessionIndex) {
		if (aSessionIndex != null) {
			wrappedObject.setSessionIndex(aSessionIndex);
		}
		return this;
	}

	@Override
	public AuthnStatementBuilder sessionNotOnOrAfter(Calendar aSessionNotOnOrAfter) {
		if (aSessionNotOnOrAfter != null) {
			wrappedObject.setSessionNotOnOrAfter(aSessionNotOnOrAfter.toInstant());
		}
		return this;
	}

}
