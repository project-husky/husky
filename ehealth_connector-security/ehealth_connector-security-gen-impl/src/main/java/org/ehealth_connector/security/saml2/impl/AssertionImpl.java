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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.ehealth_connector.security.core.SecurityObject;
import org.ehealth_connector.security.saml2.Assertion;
import org.ehealth_connector.security.saml2.Attribute;
import org.ehealth_connector.security.saml2.AudienceRestriction;
import org.ehealth_connector.security.saml2.AuthnStatement;
import org.ehealth_connector.security.saml2.Condition;
import org.ehealth_connector.security.saml2.Subject;
import org.joda.time.DateTime;

/**
 * <!-- @formatter:off -->
 * <div class="en">Implementation class of Interface Assertion</div>
 * <div class="de">Implementations Klasse von  Interface Assertion</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * <!-- @formatter:on -->
 */
public class AssertionImpl implements Assertion, SecurityObject<org.opensaml.saml.saml2.core.Assertion> {

	private org.opensaml.saml.saml2.core.Assertion assertion;

	protected AssertionImpl(org.opensaml.saml.saml2.core.Assertion aAssertion) {
		assertion = aAssertion;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.core.SecurityObject#getWrappedObject()
	 */
	@Override
	public org.opensaml.saml.saml2.core.Assertion getWrappedObject() {
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

	@Override
	public Calendar getConditionsNotBefore() {
		if (assertion.getConditions() != null) {
			final DateTime instant = assertion.getConditions().getNotBefore();
			final Calendar retVal = Calendar.getInstance();
			retVal.setTimeInMillis(instant.getMillis());
			return retVal;
		}
		return Calendar.getInstance();
	}

	@Override
	public Calendar getConditionsNotOnOrAfter() {
		if (assertion.getConditions() != null) {
			final DateTime instant = assertion.getConditions().getNotOnOrAfter();
			final Calendar retVal = Calendar.getInstance();
			retVal.setTimeInMillis(instant.getMillis());
			return retVal;
		}
		return Calendar.getInstance();
	}

	/**
	 * 
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.Assertion#getId()
	 */
	@Override
	public String getId() {
		return assertion.getID();
	}

	/**
	 * 
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

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.Assertion#getAttributes()
	 */
	@Override
	public List<Attribute> getAttributes() {
		final List<Attribute> retVal = new ArrayList<>();

		final List<org.opensaml.saml.saml2.core.AttributeStatement> internalAttributes = assertion
				.getAttributeStatements();
		internalAttributes.forEach(c -> {
			final List<org.opensaml.saml.saml2.core.Attribute> listOfAttributes = c.getAttributes();
			listOfAttributes.forEach(d -> {
				retVal.add(new AttributeBuilderImpl().create(d));
			});
		});
		return retVal;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.Assertion#getSubject()
	 */
	@Override
	public Subject getSubject() {
		if (assertion.getSubject() != null) {
			return new SubjectBuilderImpl().create();
		}
		return null;
	}

	/**
	 * 
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.Base#getVersion()
	 */
	@Override
	public String getVersion() {
		if (assertion.getVersion() != null) {
			return assertion.getVersion().toString();
		}
		return "";
	}

	/**
	 * 
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.Assertion#getAuthnStatements()
	 */
	@Override
	public List<AuthnStatement> getAuthnStatements() {
		final List<AuthnStatement> retVal = new ArrayList<>();
		final List<org.opensaml.saml.saml2.core.AuthnStatement> innerList = assertion.getAuthnStatements();
		innerList.forEach(c -> {
			retVal.add(new AuthnStatementBuilderImpl().create(c));
		});
		return retVal;
	}

	@Override
	public List<Condition> getConditionsConditions() {
		final List<Condition> retVal = new ArrayList<>();
		if (assertion.getConditions() != null) {
			final List<org.opensaml.saml.saml2.core.Condition> innerList = assertion.getConditions().getConditions();
			innerList.forEach(c -> {
				retVal.add(new ConditionBuilderImpl().create(c));
			});
		}
		return retVal;
	}

	@Override
	public List<AudienceRestriction> getConditionsAudienceRestrictions() {
		final List<AudienceRestriction> retVal = new ArrayList<>();
		return retVal;
	}

}
