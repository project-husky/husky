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
package org.ehealth_connector.xua.saml2.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.ehealth_connector.xua.core.SecurityObject;
import org.ehealth_connector.xua.saml2.Attribute;
import org.ehealth_connector.xua.saml2.AuthnStatement;
import org.joda.time.DateTime;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.AssertionType;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.ConditionAbstractType;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.ConditionsType;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.NameIDType;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.SubjectType;

/**
 * <!-- @formatter:off -->
 * <div class="en">Implementation class of Interface Assertion</div>
 * <div class="de">Implementations Klasse von Interface Assertion</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class AssertionImpl
		extends AssertionType implements SecurityObject<org.opensaml.saml.saml2.core.Assertion> {

	/** The assertion. */
	private org.opensaml.saml.saml2.core.Assertion assertion;

	/**
	 * Instantiates a new AssertionImpl.
	 *
	 * @param aAssertion
	 *            the Assertion
	 */
	protected AssertionImpl(org.opensaml.saml.saml2.core.Assertion aAssertion) {
		assertion = aAssertion;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.saml2.Assertion#getAttributes()
	 */
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
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.saml2.Assertion#getAuthnStatements()
	 */
	public List<AuthnStatement> getAuthnStatements() {
		final List<AuthnStatement> retVal = new ArrayList<>();
		final List<org.opensaml.saml.saml2.core.AuthnStatement> innerList = assertion
				.getAuthnStatements();
		innerList.forEach(c -> {
			retVal.add(new AuthnStatementBuilderImpl().create(c));
		});
		return retVal;
	}

	@Override
	public ConditionsType getConditions() {
		if (assertion.getConditions() != null) {
			return new ConditionsBuilderImpl().create(assertion.getConditions());
		}
		return null;
	}

	public List<ConditionAbstractType> getConditionsAudienceRestrictions() {
		if (assertion.getConditions() != null
				&& assertion.getConditions().getAudienceRestrictions() != null) {
			assertion.getConditions().getAudienceRestrictions().forEach(audres -> {
				getConditions().getConditionOrAudienceRestrictionOrOneTimeUse().add(new AudienceRestrictionBuilderImpl().create(audres));
			});
		}
		
		return getConditions().getConditionOrAudienceRestrictionOrOneTimeUse();
	}

	public Calendar getConditionsNotBefore() {
		if (assertion.getConditions() != null) {
			final DateTime instant = assertion.getConditions().getNotBefore();
			final Calendar retVal = Calendar.getInstance();
			retVal.setTimeInMillis(instant.getMillis());
			return retVal;
		}
		return Calendar.getInstance();
	}

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
	 * @see org.ehealth_connector.xua.saml2.Assertion#getId()
	 */
	public String getId() {
		setID(assertion.getID());
		return assertion.getID();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.saml2.Assertion#getIssueInstant()
	 */
	@Override
	public XMLGregorianCalendar getIssueInstant() {
		final DateTime instant = assertion.getIssueInstant();
		final GregorianCalendar retVal = new GregorianCalendar();
		retVal.setTimeInMillis(instant.getMillis());
			
		XMLGregorianCalendar xmlGregCal = null;
		try {
			xmlGregCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(retVal);
			setIssueInstant(xmlGregCal);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		
		return xmlGregCal;
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.saml2.Assertion#getIssuer()
	 */
	@Override
	public NameIDType getIssuer() {		
		if (assertion.getIssuer() != null) {			
			var nameIdType = new NameIDType();
			nameIdType.setValue(assertion.getIssuer().getValue());
			setIssuer(nameIdType);	
			return nameIdType;
		}
		
		return null;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.saml2.Assertion#getSubject()
	 */
	@Override
	public SubjectType getSubject() {
		if (assertion.getSubject() != null) {
			var retVal = new SubjectBuilderImpl().create(assertion.getSubject());
			setSubject(retVal);
			return retVal;
		}
		return null;
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.saml2.Base#getVersion()
	 */
	@Override
	public String getVersion() {
		if (assertion.getVersion() != null) {
			var retVal = assertion.getVersion().toString();		
			setVersion(retVal);
			return retVal;
		}
		return "";
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.core.SecurityObject#getWrappedObject()
	 */
	@Override
	public org.opensaml.saml.saml2.core.Assertion getWrappedObject() {
		return assertion;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.saml2.Response#hasSignature()
	 */
	public boolean hasSignature() {
		return (assertion.getSignature() != null);
	}

}
