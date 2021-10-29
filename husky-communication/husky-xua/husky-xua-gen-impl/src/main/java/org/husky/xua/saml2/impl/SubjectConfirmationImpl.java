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

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.husky.xua.core.SecurityObject;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.SubjectConfirmationDataType;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.SubjectConfirmationType;
import org.opensaml.saml.saml2.core.impl.SubjectConfirmationBuilder;
import org.opensaml.saml.saml2.core.impl.SubjectConfirmationDataBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <!-- @formatter:off -->
 * <div class="en">Implementation class of SubjectConfirmation</div>
 * <div class="de">Implementations Klasse von SubjectConfirmation</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class SubjectConfirmationImpl extends SubjectConfirmationType implements
		SecurityObject<org.opensaml.saml.saml2.core.SubjectConfirmation> {

	private static final Logger LOGGER = LoggerFactory.getLogger(SubjectConfirmationImpl.class);
	
	/** The subject confirmation. */
	private org.opensaml.saml.saml2.core.SubjectConfirmation subjectConfirmation;

	/**
	 * Default constructor to instanciate the object
	 *
	 * @param aInternalObject
	 */
	protected SubjectConfirmationImpl(
			org.opensaml.saml.saml2.core.SubjectConfirmation aInternalObject) {
		subjectConfirmation = aInternalObject;
		setSubjectConfirmationData(new SubjectConfirmationDataType());
		
		getAddress();
		getInResponseTo();
		getMethod();
		getNotBefore();
		getNotOnOrAfter();
		getRecipient();
	}

	/**
	 * Default constructor to instanciate the object
	 *
	 * @param aInternalObject
	 */
	protected SubjectConfirmationImpl(SubjectConfirmationType aInternalObject) {
		subjectConfirmation = new SubjectConfirmationBuilder().buildObject();
		
		if(aInternalObject.getSubjectConfirmationData() != null) {
			var subjectConfirmData = new SubjectConfirmationDataBuilder().buildObject();
			subjectConfirmData.setAddress(aInternalObject.getSubjectConfirmationData().getAddress());
			subjectConfirmData.setInResponseTo(aInternalObject.getSubjectConfirmationData().getInResponseTo());

			if (aInternalObject.getSubjectConfirmationData().getNotBefore() != null) {
				subjectConfirmData.setNotBefore(
						aInternalObject.getSubjectConfirmationData().getNotBefore().toGregorianCalendar().toInstant());
			}

			if (aInternalObject.getSubjectConfirmationData().getNotOnOrAfter() != null) {
				subjectConfirmData.setNotOnOrAfter(aInternalObject.getSubjectConfirmationData().getNotOnOrAfter()
						.toGregorianCalendar().toInstant());
			}
			
			subjectConfirmData.setRecipient(aInternalObject.getSubjectConfirmationData().getRecipient());
			subjectConfirmation.setSubjectConfirmationData(subjectConfirmData);
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final SubjectConfirmationImpl other = (SubjectConfirmationImpl) obj;
		if (subjectConfirmation == null) {
			if (other.subjectConfirmation != null)
				return false;
		} else if (!subjectConfirmation.equals(other.subjectConfirmation))
			return false;
		return true;
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.saml2.SubjectConfirmation#getAddress()
	 */
	public String getAddress() {		
		if (subjectConfirmation.getSubjectConfirmationData() != null) {
			getSubjectConfirmationData().setAddress(subjectConfirmation.getSubjectConfirmationData().getAddress());			
			return getSubjectConfirmationData().getAddress();
		}
		return "";
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.saml2.SubjectConfirmation#getInResponseTo()
	 */
	public String getInResponseTo() {
		if (subjectConfirmation.getSubjectConfirmationData() != null) {
			getSubjectConfirmationData().setInResponseTo(subjectConfirmation.getSubjectConfirmationData().getInResponseTo());	
			return getSubjectConfirmationData().getInResponseTo();
		}
		return "";
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.saml2.SubjectConfirmation#getMethod()
	 */
	@Override
	public String getMethod() {
		setMethod(subjectConfirmation.getMethod());
		return super.getMethod();
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.saml2.SubjectConfirmation#getNotBefore()
	 */
	public Calendar getNotBefore() {
		if (subjectConfirmation.getSubjectConfirmationData() != null && subjectConfirmation.getSubjectConfirmationData().getNotBefore() != null) {
			final var retVal = new GregorianCalendar();
			retVal.setTimeInMillis(subjectConfirmation.getSubjectConfirmationData().getNotBefore().toEpochMilli());
			
			XMLGregorianCalendar xmlGregCal = null;
			try {
				xmlGregCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(retVal);
				getSubjectConfirmationData().setNotBefore(xmlGregCal);
			} catch (DatatypeConfigurationException e) {
				LOGGER.error(e.getMessage(), e);
			}
			
			return retVal;
		}
		return Calendar.getInstance();
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.saml2.SubjectConfirmation#getNotOnOrAfter()
	 */
	public Calendar getNotOnOrAfter() {
		if (subjectConfirmation.getSubjectConfirmationData() != null && subjectConfirmation.getSubjectConfirmationData().getNotOnOrAfter() != null) {
			final var retVal = new GregorianCalendar();
			retVal.setTimeInMillis(subjectConfirmation.getSubjectConfirmationData().getNotOnOrAfter().toEpochMilli());
			
			XMLGregorianCalendar xmlGregCal = null;
			try {
				xmlGregCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(retVal);
				getSubjectConfirmationData().setNotOnOrAfter(xmlGregCal);
			} catch (DatatypeConfigurationException e) {
				LOGGER.error(e.getMessage(), e);
			}

			return retVal;
		}
		return Calendar.getInstance();
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.saml2.SubjectConfirmation#getRecipient()
	 */
	public String getRecipient() {
		if (subjectConfirmation.getSubjectConfirmationData() != null) {
			getSubjectConfirmationData().setRecipient(subjectConfirmation.getSubjectConfirmationData().getRecipient());
			return getSubjectConfirmationData().getRecipient();
		}
		return "";
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.core.SecurityObject#getWrappedObject()
	 */
	@Override
	public org.opensaml.saml.saml2.core.SubjectConfirmation getWrappedObject() {
		return subjectConfirmation;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final var prime = 31;
		var result = 1;
		result = (prime * result)
				+ ((subjectConfirmation == null) ? 0 : subjectConfirmation.hashCode());
		return result;
	}

}
