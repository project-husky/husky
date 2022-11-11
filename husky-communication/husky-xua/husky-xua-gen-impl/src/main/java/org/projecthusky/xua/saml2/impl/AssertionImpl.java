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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.projecthusky.xua.core.SecurityObject;
import org.projecthusky.xua.saml2.Assertion;
import org.projecthusky.xua.saml2.XACMLPolicySetIdReferenceStatement;
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
 * Implementation class of Interface Assertion
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

		addStatements(aAssertion.getStatementOrAuthnStatementOrAuthzDecisionStatement());
		setIssuer(aAssertion.getIssuer());
		setConditions(aAssertion.getConditions());
		setId(aAssertion.getID());
		setIssueInstant(aAssertion.getIssueInstant());
		setSubject(aAssertion.getSubject());
		setVersion(aAssertion.getVersion());
	}

	/**
	 * method to set attributes.
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
	 * Method to add statements.
	 * @param statements the list of statements to be added
	 */
	public void addStatements(List<StatementAbstractType> statements) {
		if (this.assertion == null) {
			this.assertion = new AssertionBuilder().buildObject();
		}

		for (StatementAbstractType statement : statements) {
			if (statement instanceof org.openehealth.ipf.commons.ihe.xacml20.stub.xacml20.saml.assertion.XACMLPolicyStatementType policyStat) {
				this.assertion.getStatements().add(new StatementBuilderImpl().create(policyStat));
			} else if (statement instanceof AttributeStatementType attrStat) {
				var retVal = new AttributeStatementBuilder().buildObject();
				
				for(Object obj: attrStat.getAttributeOrEncryptedAttribute()) {
					if (obj instanceof AttributeType attributeType) {
						retVal.getAttributes().add(new AttributeBuilderImpl().create(attributeType));
					}
				}
				
				this.assertion.getStatements().add(retVal);
			} else if (statement instanceof AuthnStatementType attrStat) {
				this.assertion.getAuthnStatements().add(new AuthnStatementBuilderImpl().create(attrStat));
			} else if (statement instanceof XACMLPolicySetIdReferenceStatementType policyStat) {
				this.assertion.getStatements()
						.add(new XacmlPolicySetIdReferenceStatementBuilderImpl().create(policyStat));
			}
		}
	}

	/**
	 * method to set authnstatements.
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
	 * method to set statements.
	 */
	public void setStatements() {
		if (this.statementOrAuthnStatementOrAuthzDecisionStatement == null) {
			this.statementOrAuthnStatementOrAuthzDecisionStatement = new ArrayList<>();
		}

		final List<org.opensaml.saml.saml2.core.Statement> innerList = assertion.getStatements();
		innerList.forEach(c -> {
			if (c instanceof XACMLPolicyStatementType xacmlPolicyStatementType) {
				this.statementOrAuthnStatementOrAuthzDecisionStatement
						.add(new StatementBuilderImpl().create(xacmlPolicyStatementType));
			} else if (c instanceof XACMLPolicySetIdReferenceStatement xacmlPolicySetIdReferenceStatement) {
				this.statementOrAuthnStatementOrAuthzDecisionStatement
						.add(new XacmlPolicySetIdReferenceStatementBuilderImpl()
								.create(xacmlPolicySetIdReferenceStatement));
			}

		});
	}

	/**
	 * method to set conditions.
	 */
	public void setConditions() {
		if (assertion.getConditions() != null) {
			this.conditions = new ConditionsBuilderImpl().create(assertion.getConditions());
		}
	}

	/**
	 * method to set a conditions.
	 */
	public void setConditions(ConditionsType conditions) {
		if (conditions != null) {
			this.assertion.setConditions(new ConditionsBuilderImpl().create(conditions));
		}
	}

	/**
	 * method to set condition audience restrictions.
	 */
	public void setConditionsAudienceRestrictions() {
		if (assertion.getConditions() != null && assertion.getConditions().getAudienceRestrictions() != null) {
			assertion.getConditions().getAudienceRestrictions()
					.forEach(audres -> getConditions().getConditionOrAudienceRestrictionOrOneTimeUse()
							.add(new AudienceRestrictionBuilderImpl().create(audres)));
		}
	}

	/**
	 * method to set condition not before.
	 */
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

	/**
	 * method to set condition not on or after.
	 */
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
	 * method to setid
	 */
	public void setId() {
		setID(assertion.getID());
	}

	/**
	 * method to an id
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.assertion.setID(id);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.projecthusky.xua.saml2.Assertion#getIssueInstant()
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

	/**
	 * Method to set IssueInstant
	 * @param cal the XMLGregorianCalendar to set
	 */
	public void setIssueInstant(XMLGregorianCalendar cal) {
		if (cal != null) {
			this.assertion.setIssueInstant(cal.toGregorianCalendar().toInstant());
		}
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.projecthusky.xua.saml2.Assertion#getIssuer()
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

	/**
	 * method to setIssuer
	 * @param issuer the issue to be set
	 */
	public void setIssuer(NameIDType issuer) {
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
	 * Method to set subject.
	 */
	public void setSubject() {
		if (assertion.getSubject() != null) {
			var retVal = new SubjectBuilderImpl().create(assertion.getSubject());
			setSubject(retVal);
		}
	}

	/**
	 * Method to set a subject.
	 * @param subject the subject to be set.
	 */
	public void getSubject(SubjectType subject) {
		if (subject != null) {
			this.assertion.setSubject(new SubjectBuilderImpl().create(subject));
		}
	}

	/**
	 * method to set the version
	 */
	public void setVersion() {
		if (assertion.getVersion() != null) {
			var retVal = assertion.getVersion().toString();
			setVersion(retVal);
		}
	}

	/**
	 * Method to set a version.
	 * @param version the version to be set
	 */
	public void setVersion(String version) {
		this.assertion.setVersion(SAMLVersion.valueOf(version));
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.projecthusky.xua.core.SecurityObject#getWrappedObject()
	 */
	@Override
	public org.opensaml.saml.saml2.core.Assertion getWrappedObject() {
		return assertion;
	}

	/**
	 * method to check for signature.
	 * @return true if signature is available else false
	 */
	public boolean hasSignature() {
		return (assertion.getSignature() != null);
	}

}
