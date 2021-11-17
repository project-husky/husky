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
package org.husky.xua.saml2.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.husky.xua.core.SecurityObject;
import org.husky.xua.saml2.Assertion;
import org.husky.xua.saml2.XACMLPolicySetIdReferenceStatement;
import org.openehealth.ipf.commons.ihe.xacml20.stub.ehealthswiss.XACMLPolicySetIdReferenceStatementType;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.AssertionType;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.AttributeStatementType;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.AttributeType;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.AuthnStatementType;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.ConditionsType;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.NameIDType;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.StatementAbstractType;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.SubjectType;
import org.opensaml.saml.common.SAMLVersion;
import org.opensaml.saml.saml2.core.Issuer;
import org.opensaml.saml.saml2.core.impl.AssertionBuilder;
import org.opensaml.saml.saml2.core.impl.AttributeStatementBuilder;
import org.opensaml.saml.saml2.core.impl.IssuerBuilder;
import org.opensaml.xacml.profile.saml.XACMLPolicyStatementType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <!-- @formatter:off -->
 * <div class="en">Implementation class of Interface Assertion</div>
 * <div class="de">Implementations Klasse von Interface Assertion</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class AssertionImpl extends Assertion implements SecurityObject<org.opensaml.saml.saml2.core.Assertion> {

	private static final Logger LOGGER = LoggerFactory.getLogger(AssertionImpl.class);

	/** The assertion. */
	private org.opensaml.saml.saml2.core.Assertion assertion;

	/**
	 * Instantiates a new AssertionImpl.
	 *
	 * @param aAssertion the Assertion
	 */
	protected AssertionImpl(org.opensaml.saml.saml2.core.Assertion aAssertion) {
		assertion = aAssertion;

		setAttributes();
		setAuthnStatements();
		setConditions();
		setConditionsAudienceRestrictions();
		setId();
		setConditionsNotBefore();
		setConditionsNotOnOrAfter();
		setIssueInstant();
		setIssuer();
		setSubject();
		setVersion();
		setStatements();

	}

	/**
	 * Instantiates a new AssertionImpl.
	 *
	 * @param aAssertion the Assertion
	 */
	protected AssertionImpl(AssertionType aAssertion) {
		assertion = new AssertionBuilder().buildObject();

		getStatements(aAssertion.getStatementOrAuthnStatementOrAuthzDecisionStatement());
		getIssuer(aAssertion.getIssuer());
		getConditions(aAssertion.getConditions());
		getId(aAssertion.getID());
		getIssueInstant(aAssertion.getIssueInstant());
		getSubject(aAssertion.getSubject());
		getVersion(aAssertion.getVersion());
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.saml2.Assertion#getAttributes()
	 */
	public void setAttributes() {
		if (this.statementOrAuthnStatementOrAuthzDecisionStatement == null) {
			this.statementOrAuthnStatementOrAuthzDecisionStatement = new ArrayList<>();
		}

		final List<org.opensaml.saml.saml2.core.AttributeStatement> internalAttributes = assertion
				.getAttributeStatements();
		internalAttributes.forEach(c -> {
			List<AttributeType> attributes = new LinkedList<>();
			final List<org.opensaml.saml.saml2.core.Attribute> listOfAttributes = c.getAttributes();
			listOfAttributes.forEach(d -> attributes
					.add(new AttributeBuilderImpl().create(d)));

			var statement = new AttributeStatementType();
			statement.getAttributeOrEncryptedAttribute().addAll(attributes);
			this.statementOrAuthnStatementOrAuthzDecisionStatement.add(statement);
		});
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.saml2.Assertion#getAttributes()
	 */
	public void getStatements(List<StatementAbstractType> statements) {
		if (this.assertion == null) {
			this.assertion = new AssertionBuilder().buildObject();
		}

		for (StatementAbstractType statement : statements) {
			if (statement instanceof org.openehealth.ipf.commons.ihe.xacml20.stub.xacml20.saml.assertion.XACMLPolicyStatementType) {
				var policyStat = (org.openehealth.ipf.commons.ihe.xacml20.stub.xacml20.saml.assertion.XACMLPolicyStatementType) statement;
				this.assertion.getStatements().add(new StatementBuilderImpl().create(policyStat));
			} else if(statement instanceof AttributeStatementType) {
				var attrStat = (AttributeStatementType) statement;
				var retVal = new AttributeStatementBuilder().buildObject();
				
				for(Object obj: attrStat.getAttributeOrEncryptedAttribute()) {
					if(obj instanceof AttributeType) {
						retVal.getAttributes().add(new AttributeBuilderImpl().create((AttributeType) obj));
					}
				}
				
				this.assertion.getStatements().add(retVal);
			} else if (statement instanceof AuthnStatementType) {
				var attrStat = (AuthnStatementType) statement;
				this.assertion.getAuthnStatements().add(new AuthnStatementBuilderImpl().create(attrStat));
			} else if (statement instanceof XACMLPolicySetIdReferenceStatementType) {
				var policyStat = (XACMLPolicySetIdReferenceStatementType) statement;
				this.assertion.getStatements()
						.add(new XacmlPolicySetIdReferenceStatementBuilderImpl().create(policyStat));
			}
		}
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.saml2.Assertion#getAuthnStatements()
	 */
	public void setAuthnStatements() {
		if (this.statementOrAuthnStatementOrAuthzDecisionStatement == null) {
			this.statementOrAuthnStatementOrAuthzDecisionStatement = new ArrayList<>();
		}

		final List<org.opensaml.saml.saml2.core.AuthnStatement> innerList = assertion.getAuthnStatements();
		innerList.forEach(c -> this.statementOrAuthnStatementOrAuthzDecisionStatement
				.add(new AuthnStatementBuilderImpl().create(c)));
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.saml2.Assertion#getStatements()
	 */
	public void setStatements() {
		if (this.statementOrAuthnStatementOrAuthzDecisionStatement == null) {
			this.statementOrAuthnStatementOrAuthzDecisionStatement = new ArrayList<>();
		}

		final List<org.opensaml.saml.saml2.core.Statement> innerList = assertion.getStatements();
		innerList.forEach(c -> {
			if (c instanceof XACMLPolicyStatementType) {
				this.statementOrAuthnStatementOrAuthzDecisionStatement
						.add(new StatementBuilderImpl().create((XACMLPolicyStatementType) c));
			} else if (c instanceof XACMLPolicySetIdReferenceStatement) {
				this.statementOrAuthnStatementOrAuthzDecisionStatement
						.add(new XacmlPolicySetIdReferenceStatementBuilderImpl()
								.create((XACMLPolicySetIdReferenceStatement) c));
			}

		});
	}

	public void setConditions() {
		if (assertion.getConditions() != null) {
			this.conditions = new ConditionsBuilderImpl().create(assertion.getConditions());
		}
	}

	public void getConditions(ConditionsType conditions) {
		if (conditions != null) {
			this.assertion.setConditions(new ConditionsBuilderImpl().create(conditions));
		}
	}

	public void setConditionsAudienceRestrictions() {
		if (assertion.getConditions() != null && assertion.getConditions().getAudienceRestrictions() != null) {
			assertion.getConditions().getAudienceRestrictions()
					.forEach(audres -> getConditions().getConditionOrAudienceRestrictionOrOneTimeUse()
							.add(new AudienceRestrictionBuilderImpl().create(audres)));
		}
	}

	public void setConditionsNotBefore() {
		if (assertion.getConditions() != null) {
			final var retVal = new GregorianCalendar();
			retVal.setTimeInMillis(assertion.getConditions().getNotBefore().toEpochMilli());

			XMLGregorianCalendar xmlGregCal = null;
			try {
				xmlGregCal = DatatypeFactory.newInstance().newXMLGregorianCalendar();
				getConditions().setNotBefore(xmlGregCal);
			} catch (DatatypeConfigurationException e) {
				LOGGER.error(e.getMessage(), e);
			}

		}
	}

	public void setConditionsNotOnOrAfter() {
		if (assertion.getConditions() != null) {
			final var retVal = Calendar.getInstance();
			retVal.setTimeInMillis(assertion.getConditions().getNotOnOrAfter().toEpochMilli());

			XMLGregorianCalendar xmlGregCal = null;
			try {
				xmlGregCal = DatatypeFactory.newInstance().newXMLGregorianCalendar();
				getConditions().setNotOnOrAfter(xmlGregCal);
			} catch (DatatypeConfigurationException e) {
				LOGGER.error(e.getMessage(), e);
			}
		}
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.saml2.Assertion#getId()
	 */
	public void setId() {
		setID(assertion.getID());
	}

	public void getId(String id) {
		this.assertion.setID(id);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.saml2.Assertion#getIssueInstant()
	 */
	public void setIssueInstant() {
		if (assertion.getIssueInstant() != null) {
			final var retVal = new GregorianCalendar();
			retVal.setTimeInMillis(assertion.getIssueInstant().toEpochMilli());

			XMLGregorianCalendar xmlGregCal = null;
			try {
				xmlGregCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(retVal);
				setIssueInstant(xmlGregCal);
			} catch (DatatypeConfigurationException e) {
				LOGGER.error(e.getMessage(), e);
			}
		}
	}

	public void getIssueInstant(XMLGregorianCalendar cal) {
		if (cal != null) {
			this.assertion.setIssueInstant(cal.toGregorianCalendar().toInstant());
		}
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.saml2.Assertion#getIssuer()
	 */
	public void setIssuer() {
		if (assertion.getIssuer() != null) {
			var nameIdType = new NameIDType();
			nameIdType.setValue(assertion.getIssuer().getValue());
			nameIdType.setNameQualifier(assertion.getIssuer().getNameQualifier());
			nameIdType.setSPNameQualifier(assertion.getIssuer().getSPNameQualifier());
			nameIdType.setSPProvidedID(assertion.getIssuer().getSPProvidedID());
			setIssuer(nameIdType);
		}
	}

	public void getIssuer(NameIDType issuer) {
		if (issuer != null) {
			Issuer retVal = new IssuerBuilder().buildObject();
			retVal.setValue(issuer.getValue());
			retVal.setNameQualifier(issuer.getNameQualifier());
			retVal.setSPNameQualifier(issuer.getSPNameQualifier());
			retVal.setSPProvidedID(issuer.getSPProvidedID());
			assertion.setIssuer(retVal);
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.saml2.Assertion#getSubject()
	 */
	public void setSubject() {
		if (assertion.getSubject() != null) {
			var retVal = new SubjectBuilderImpl().create(assertion.getSubject());
			setSubject(retVal);
		}
	}

	public void getSubject(SubjectType subject) {
		if (subject != null) {
			this.assertion.setSubject(new SubjectBuilderImpl().create(subject));
		}
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.saml2.Base#getVersion()
	 */
	public void setVersion() {
		if (assertion.getVersion() != null) {
			var retVal = assertion.getVersion().toString();
			setVersion(retVal);
		}
	}

	public void getVersion(String version) {
		this.assertion.setVersion(SAMLVersion.valueOf(version));
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.core.SecurityObject#getWrappedObject()
	 */
	@Override
	public org.opensaml.saml.saml2.core.Assertion getWrappedObject() {
		return assertion;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.saml2.Response#hasSignature()
	 */
	public boolean hasSignature() {
		return (assertion.getSignature() != null);
	}

}
