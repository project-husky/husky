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
package org.husky.xua.saml2.impl;

import java.util.Calendar;
import java.util.List;

import org.husky.xua.core.SecurityObjectBuilder;
import org.husky.xua.saml2.Assertion;
import org.husky.xua.saml2.AssertionBuilder;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.AssertionType;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.AttributeType;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.ConditionsType;
import org.opensaml.saml.common.SAMLVersion;
import org.opensaml.saml.saml2.core.AttributeStatement;
import org.opensaml.saml.saml2.core.Issuer;
import org.opensaml.saml.saml2.core.impl.AttributeStatementBuilder;
import org.opensaml.saml.saml2.core.impl.IssuerBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the corresponding interface for Assertion building.</div>
 * <div class="de">Die Klasse implementiert das entsprechende Interface um Assertion bilden zu k&ooml;nnen.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class AssertionBuilderImpl implements AssertionBuilder,
		SecurityObjectBuilder<org.opensaml.saml.saml2.core.Assertion, Assertion> {

	private org.opensaml.saml.saml2.core.Issuer issuer;
	private org.opensaml.saml.saml2.core.Assertion wrappedObject;

	public AssertionBuilderImpl() {
		final var builder = new org.opensaml.saml.saml2.core.impl.AssertionBuilder();
		wrappedObject = builder.buildObject();

		final var issueBuilder = new IssuerBuilder();
		issuer = issueBuilder.buildObject(Issuer.DEFAULT_ELEMENT_NAME);
		wrappedObject.setIssuer(issuer);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.saml2.AssertionBuilder#addAttribute(org.husky.xua.saml2.Attribute)
	 */
	@Override
	public AssertionBuilder addAttribute(AttributeType attribute) {
		final List<AttributeStatement> attributeStatements = wrappedObject.getAttributeStatements();
		AttributeStatement statement = null;
		if (attributeStatements.isEmpty()) {
			statement = new AttributeStatementBuilder()
					.buildObject(AttributeStatement.DEFAULT_ELEMENT_NAME);
			attributeStatements.add(statement);
		} else {
			statement = attributeStatements.get(0);
		}
		statement.getAttributes().add(((AttributeImpl) attribute).getWrappedObject());
		return this;
	}

	@Override
	public AssertionBuilder addCondition(ConditionsType condition) {
		if (wrappedObject.getConditions() != null) {
			wrappedObject.setConditions(((ConditionsImpl) condition).getWrappedObject());
		}
		return this;
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.saml2.AssertionBuilder#create()
	 */
	@Override
	public Assertion create() {
		return new AssertionImpl(wrappedObject);
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.saml2.AssertionBuilder#create(AssertionType)
	 */
	@Override
	public Assertion create(AssertionType aInternalObject) {
		return new AssertionImpl(aInternalObject);
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.core.SecurityObjectBuilder#create(java.lang.Object)
	 */
	@Override
	public Assertion create(org.opensaml.saml.saml2.core.Assertion aInternalObject) {
		return new AssertionImpl(aInternalObject);
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.saml2.BaseBuilder#id(java.lang.String)
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
	 * @see org.husky.xua.saml2.BaseBuilder#issueInstant(java.util.Calendar)
	 */
	@Override
	public AssertionBuilder issueInstant(Calendar aIssueInstant) {
		if (aIssueInstant != null) {
			wrappedObject.setIssueInstant(aIssueInstant.toInstant());
		}
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.saml2.AssertionBuilder#issuer(java.lang.String)
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
	 * @see org.husky.xua.saml2.BaseBuilder#version(java.lang.String)
	 */
	@Override
	public AssertionBuilder version(String aVersion) {
		if (aVersion != null) {
			wrappedObject.setVersion(SAMLVersion.valueOf(aVersion));
		}
		return this;
	}

}
