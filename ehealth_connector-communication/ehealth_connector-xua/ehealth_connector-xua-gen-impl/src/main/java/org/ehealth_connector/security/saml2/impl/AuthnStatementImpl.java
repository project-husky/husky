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
package org.ehealth_connector.security.saml2.impl;

import java.util.Calendar;

import org.ehealth_connector.security.core.SecurityObject;
import org.ehealth_connector.security.saml2.AuthnStatement;
import org.joda.time.DateTime;

/**
 * <!-- @formatter:off -->
 * <div class="en">Implementation class of AuthnStatement</div>
 * <div class="de">Implementations Klasse von AuthnStatement</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class AuthnStatementImpl
		implements AuthnStatement, SecurityObject<org.opensaml.saml.saml2.core.AuthnStatement> {

	private org.opensaml.saml.saml2.core.AuthnStatement authnStatement;

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Default constructor to instanciate the object.</div>
	 * <div class="de">Default Konstruktor für die Instanziierung des Objekts.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * <!-- @formatter:on -->
	 *
	 * @param aAuthnStatement the AuthnStatement
	 */
	protected AuthnStatementImpl(org.opensaml.saml.saml2.core.AuthnStatement aAuthnStatement) {
		authnStatement = aAuthnStatement;
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.AuthnStatement#getAuthnContextClassRef()
	 */
	@Override
	public String getAuthnContextClassRef() {
		if ((authnStatement.getAuthnContext() != null)
				&& (authnStatement.getAuthnContext().getAuthnContextClassRef() != null)) {
			return authnStatement.getAuthnContext().getAuthnContextClassRef()
					.getAuthnContextClassRef();
		}
		return "";
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.AuthnStatement#getAuthnInstant()
	 */
	@Override
	public Calendar getAuthnInstant() {
		final DateTime instant = authnStatement.getAuthnInstant();
		final Calendar retVal = Calendar.getInstance();
		retVal.setTimeInMillis(instant.getMillis());
		return retVal;
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.AuthnStatement#getSessionIndex()
	 */
	@Override
	public String getSessionIndex() {
		return authnStatement.getSessionIndex();
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.AuthnStatement#getSessionNotOnOrAfter()
	 */
	@Override
	public Calendar getSessionNotOnOrAfter() {
		final DateTime instant = authnStatement.getSessionNotOnOrAfter();
		final Calendar retVal = Calendar.getInstance();
		retVal.setTimeInMillis(instant.getMillis());
		return retVal;
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.core.SecurityObject#getWrappedObject()
	 */
	@Override
	public org.opensaml.saml.saml2.core.AuthnStatement getWrappedObject() {
		return authnStatement;
	}

}
