/*
 *
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
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
package org.ehealth_connector.security.saml2.impl;

import java.util.Calendar;

import org.ehealth_connector.security.core.SecurityObjectBuilder;
import org.ehealth_connector.security.saml2.AuthnStatement;
import org.ehealth_connector.security.saml2.AuthnStatementBuilder;
import org.joda.time.DateTime;
import org.opensaml.saml.saml2.core.AuthnContextClassRef;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the corresponding interface for AuthnStatement building.</div>
 * <div class="de">Die Klasse implementiert das entsprechende interface um AuthnStatement bilden zu k&ooml;nnen.</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * <!-- @formatter:on -->
 */
public class AuthnStatementBuilderImpl implements AuthnStatementBuilder,
		SecurityObjectBuilder<org.opensaml.saml.saml2.core.AuthnStatement, AuthnStatement> {

	private org.opensaml.saml.saml2.core.AuthnStatement wrappedObject;
	private AuthnContextClassRef authnContextClassRef;

	public AuthnStatementBuilderImpl() {
		wrappedObject = new org.opensaml.saml.saml2.core.impl.AuthnStatementBuilder().buildObject();
		final org.opensaml.saml.saml2.core.AuthnContext authnContext = new org.opensaml.saml.saml2.core.impl.AuthnContextBuilder()
				.buildObject();
		wrappedObject.setAuthnContext(authnContext);
		authnContextClassRef = new org.opensaml.saml.saml2.core.impl.AuthnContextClassRefBuilder().buildObject();
		authnContext.setAuthnContextClassRef(authnContextClassRef);
	}

	@Override
	public AuthnStatementBuilder authnInstant(Calendar aAuthnInstant) {
		if (aAuthnInstant != null) {
			final DateTime dateTime = new DateTime(aAuthnInstant.getTimeInMillis());
			wrappedObject.setAuthnInstant(dateTime);
		}
		return this;
	}

	@Override
	public AuthnStatementBuilder sessionNotOnOrAfter(Calendar aSessionNotOnOrAfter) {
		if (aSessionNotOnOrAfter != null) {
			final DateTime dateTime = new DateTime(aSessionNotOnOrAfter.getTimeInMillis());
			wrappedObject.setSessionNotOnOrAfter(dateTime);
		}
		return this;
	}

	@Override
	public AuthnStatementBuilder sessionIndex(String aSessionIndex) {
		if (aSessionIndex != null) {
			wrappedObject.setSessionIndex(aSessionIndex);
		}
		return this;
	}

	@Override
	public AuthnStatementBuilder authnContextClassRef(String aAuthnContextClassRef) {
		if (aAuthnContextClassRef != null) {
			authnContextClassRef.setAuthnContextClassRef(aAuthnContextClassRef);
		}
		return this;
	}

	@Override
	public org.ehealth_connector.security.saml2.AuthnStatement create() {
		return new AuthnStatementImpl(wrappedObject);
	}

	@Override
	public AuthnStatement create(org.opensaml.saml.saml2.core.AuthnStatement aAuthnStatement) {
		return new AuthnStatementImpl(aAuthnStatement);
	}

}
