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

import org.ehealth_connector.security.core.SecurityObject;
import org.ehealth_connector.security.saml2.SubjectConfirmation;
import org.joda.time.DateTime;

/**
 * <!-- @formatter:off -->
 * <div class="en">Implementation class of SubjectConfirmation</div>
 * <div class="de">Implementations Klasse von SubjectConfirmation</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class SubjectConfirmationImpl implements SubjectConfirmation,
		SecurityObject<org.opensaml.saml.saml2.core.SubjectConfirmation> {

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
	 * @see org.ehealth_connector.security.saml2.SubjectConfirmation#getAddress()
	 */
	@Override
	public String getAddress() {
		if (subjectConfirmation.getSubjectConfirmationData() != null) {
			return subjectConfirmation.getSubjectConfirmationData().getAddress();
		}
		return "";
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.SubjectConfirmation#getInResponseTo()
	 */
	@Override
	public String getInResponseTo() {
		if (subjectConfirmation.getSubjectConfirmationData() != null) {
			return subjectConfirmation.getSubjectConfirmationData().getInResponseTo();
		}
		return "";
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.SubjectConfirmation#getMethod()
	 */
	@Override
	public String getMethod() {
		return subjectConfirmation.getMethod();
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.SubjectConfirmation#getNotBefore()
	 */
	@Override
	public Calendar getNotBefore() {
		if (subjectConfirmation.getSubjectConfirmationData() != null) {
			final DateTime notOnOrAfter = subjectConfirmation.getSubjectConfirmationData()
					.getNotBefore();
			final Calendar retVal = Calendar.getInstance();
			retVal.setTimeInMillis(notOnOrAfter.getMillis());
			return retVal;
		}
		return Calendar.getInstance();
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.SubjectConfirmation#getNotOnOrAfter()
	 */
	@Override
	public Calendar getNotOnOrAfter() {
		if (subjectConfirmation.getSubjectConfirmationData() != null) {
			final DateTime notOnOrAfter = subjectConfirmation.getSubjectConfirmationData()
					.getNotOnOrAfter();
			final Calendar retVal = Calendar.getInstance();
			retVal.setTimeInMillis(notOnOrAfter.getMillis());
			return retVal;
		}
		return Calendar.getInstance();
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.SubjectConfirmation#getRecipient()
	 */
	@Override
	public String getRecipient() {
		if (subjectConfirmation.getSubjectConfirmationData() != null) {
			return subjectConfirmation.getSubjectConfirmationData().getRecipient();
		}
		return "";
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.core.SecurityObject#getWrappedObject()
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
		final int prime = 31;
		int result = 1;
		result = (prime * result)
				+ ((subjectConfirmation == null) ? 0 : subjectConfirmation.hashCode());
		return result;
	}

}
