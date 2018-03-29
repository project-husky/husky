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
import java.util.List;

import org.ehealth_connector.security.core.SecurityObjectBuilder;
import org.ehealth_connector.security.saml2.Assertion;
import org.ehealth_connector.security.saml2.AssertionBuilder;
import org.ehealth_connector.security.saml2.Attribute;
import org.ehealth_connector.security.saml2.Condition;
import org.joda.time.DateTime;
import org.opensaml.saml.common.SAMLVersion;
import org.opensaml.saml.saml2.core.AttributeStatement;
import org.opensaml.saml.saml2.core.Issuer;
import org.opensaml.saml.saml2.core.impl.AttributeStatementBuilder;
import org.opensaml.saml.saml2.core.impl.IssuerBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the corresponding interface for Assertion building.</div>
 * <div class="de">Die Klasse implementiert das entsprechende interface um Assertion bilden zu k&ooml;nnen.</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * <!-- @formatter:on -->
 */
public class AssertionBuilderImpl
		implements AssertionBuilder, SecurityObjectBuilder<org.opensaml.saml.saml2.core.Assertion, Assertion> {

	private org.opensaml.saml.saml2.core.Assertion wrappedObject;
	private org.opensaml.saml.saml2.core.Issuer issuer;

	public AssertionBuilderImpl() {
		final org.opensaml.saml.saml2.core.impl.AssertionBuilder builder = new org.opensaml.saml.saml2.core.impl.AssertionBuilder();
		wrappedObject = builder.buildObject();

		final IssuerBuilder issueBuilder = new IssuerBuilder();
		issuer = issueBuilder.buildObject(Issuer.DEFAULT_ELEMENT_NAME);
		wrappedObject.setIssuer(issuer);
	}

	/**
	 * 
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.BaseBuilder#id(java.lang.String)
	 */
	@Override
	public AssertionBuilder id(String aId) {
		if (aId != null) {
			wrappedObject.setID(aId);
		}
		return this;
	}

	/**
	 * 
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.BaseBuilder#issueInstant(java.util.Calendar)
	 */
	@Override
	public AssertionBuilder issueInstant(Calendar aIssueInstant) {
		if (aIssueInstant != null) {
			final DateTime dateTime = new DateTime(aIssueInstant.getTimeInMillis());
			wrappedObject.setIssueInstant(dateTime);
		}
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.AssertionBuilder#issuer(java.lang.String)
	 */
	@Override
	public AssertionBuilder issuer(String aIssuer) {
		if (aIssuer != null) {
			issuer.setValue(aIssuer);
		}
		return this;
	}

	/**
	 * 
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.BaseBuilder#version(java.lang.String)
	 */
	@Override
	public AssertionBuilder version(String aVersion) {
		if (aVersion != null) {
			wrappedObject.setVersion(SAMLVersion.valueOf(aVersion));
		}
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.AssertionBuilder#addAttribute(org.ehealth_connector.security.saml2.Attribute)
	 */
	@Override
	public AssertionBuilder addAttribute(Attribute attribute) {
		final List<AttributeStatement> attributeStatements = wrappedObject.getAttributeStatements();
		AttributeStatement statement = null;
		if (attributeStatements.isEmpty()) {
			statement = new AttributeStatementBuilder().buildObject(AttributeStatement.DEFAULT_ELEMENT_NAME);
			attributeStatements.add(statement);
		} else {
			statement = attributeStatements.get(0);
		}
		statement.getAttributes().add(((AttributeImpl) attribute).getWrappedObject());
		return this;
	}

	@Override
	public AssertionBuilder addCondition(Condition condition) {
		if (wrappedObject.getConditions() != null) {
			final List<org.opensaml.saml.saml2.core.Condition> conditionList = wrappedObject.getConditions()
					.getConditions();
			conditionList.add(((ConditionImpl) condition).getWrappedObject());
		}
		return this;
	}

	/**
	 * 
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.AssertionBuilder#create()
	 */
	@Override
	public Assertion create() {
		return new AssertionImpl(wrappedObject);
	}

	/**
	 * 
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.core.SecurityObjectBuilder#create(java.lang.Object)
	 */
	@Override
	public Assertion create(org.opensaml.saml.saml2.core.Assertion aInternalObject) {
		return new AssertionImpl(aInternalObject);
	}

}
