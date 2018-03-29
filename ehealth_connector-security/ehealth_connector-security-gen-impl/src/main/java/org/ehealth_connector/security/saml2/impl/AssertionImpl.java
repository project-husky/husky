/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland. All rights reserved.
 * https://medshare.net Source code, documentation and other resources have been contributed by various people. Project Team:
 * https://sourceforge.net/p/ehealthconnector/wiki/Team/ For exact developer information, please refer to the commit history of the forge.
 * This code is made available under the terms of the Eclipse Public License v1.0. Accompanying materials are made available under the terms
 * of the Creative Commons Attribution-ShareAlike 4.0 License. This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 */
package org.ehealth_connector.security.saml2.impl;

import java.util.Calendar;

import org.ehealth_connector.security.saml2.Assertion;
import org.joda.time.DateTime;

/**
 * @since Feb 21, 2018 3:44:19 PM
 *
 */
public class AssertionImpl implements Assertion<org.opensaml.saml2.core.Assertion> {

	private org.opensaml.saml2.core.Assertion assertion;

	protected AssertionImpl(org.opensaml.saml2.core.Assertion aAssertion) {
		assertion = aAssertion;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.core.SecurityObject#getWrappedObject()
	 */
	@Override
	public org.opensaml.saml2.core.Assertion getWrappedObject() {
		return assertion;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.Assertion#getIssueInstant()
	 */
	@Override
	public Calendar getIssueInstant() {
		final DateTime instant = assertion.getIssueInstant();
		final Calendar retVal = Calendar.getInstance();
		retVal.setTimeInMillis(instant.getMillis());
		return retVal;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.Assertion#getID()
	 */
	@Override
	public String getID() {
		return assertion.getID();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.Assertion#getIssuer()
	 */
	@Override
	public String getIssuer() {
		if (assertion.getIssuer() != null) {
			return assertion.getIssuer().getValue();
		}
		return "";
	}

}
