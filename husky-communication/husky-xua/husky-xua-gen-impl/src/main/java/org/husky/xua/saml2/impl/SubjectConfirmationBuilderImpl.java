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

import org.husky.xua.core.SecurityObjectBuilder;
import org.husky.xua.saml2.SubjectConfirmationBuilder;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.SubjectConfirmationType;

/**
 * Class implementing the corresponding interface for SubjectConfirmation building.
 */
public class SubjectConfirmationBuilderImpl implements SubjectConfirmationBuilder,
		SecurityObjectBuilder<org.opensaml.saml.saml2.core.SubjectConfirmation, SubjectConfirmationType> {

	/** The subject confirmation. */
	private org.opensaml.saml.saml2.core.SubjectConfirmation subjectConfirmation;

	/** The subject confirmation data. */
	private org.opensaml.saml.saml2.core.SubjectConfirmationData subjectConfirmationData;

	/**
	 * Instantiates a new SubjectConfirmationBuilderImpl.
	 */
	public SubjectConfirmationBuilderImpl() {
		subjectConfirmation = new org.opensaml.saml.saml2.core.impl.SubjectConfirmationBuilder()
				.buildObject();
		subjectConfirmationData = new org.opensaml.saml.saml2.core.impl.SubjectConfirmationDataBuilder()
				.buildObject();
		subjectConfirmation.setSubjectConfirmationData(subjectConfirmationData);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.saml2.SubjectConfirmationBuilder#address(java.lang.String)
	 */
	@Override
	public SubjectConfirmationBuilder address(String aAddress) {
		if (aAddress != null) {
			subjectConfirmationData.setAddress(aAddress);
		}
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.saml2.SubjectConfirmationBuilder#create()
	 */
	@Override
	public SubjectConfirmationType create() {
		return new SubjectConfirmationImpl(subjectConfirmation);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.core.SecurityObjectBuilder#create(java.lang.Object)
	 */
	@Override
	public SubjectConfirmationType create(
			org.opensaml.saml.saml2.core.SubjectConfirmation aInternalObject) {
		return new SubjectConfirmationImpl(aInternalObject);
	}

	public org.opensaml.saml.saml2.core.SubjectConfirmation create(SubjectConfirmationType aInternalObject) {
		return new SubjectConfirmationImpl(aInternalObject).getWrappedObject();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.saml2.SubjectConfirmationBuilder#inResponseTo(java.lang.String)
	 */
	@Override
	public SubjectConfirmationBuilder inResponseTo(String aResponseTo) {
		if (aResponseTo != null) {
			subjectConfirmationData.setInResponseTo(aResponseTo);
		}
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.saml2.SubjectConfirmationBuilder#method(java.lang.String)
	 */
	@Override
	public SubjectConfirmationBuilder method(String aMethod) {
		if (aMethod != null) {
			subjectConfirmation.setMethod(aMethod);
		}
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.saml2.SubjectConfirmationBuilder#notBefore(java.util.Calendar)
	 */
	@Override
	public SubjectConfirmationBuilder notBefore(Calendar aNotBefore) {
		if (aNotBefore != null) {
			subjectConfirmationData.setNotBefore(aNotBefore.toInstant());
		}
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.saml2.SubjectConfirmationBuilder#notOnOrAfter(java.util.Calendar)
	 */
	@Override
	public SubjectConfirmationBuilder notOnOrAfter(Calendar aNotOnOrAfter) {
		if (aNotOnOrAfter != null) {
			subjectConfirmationData.setNotOnOrAfter(aNotOnOrAfter.toInstant());
		}
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.saml2.SubjectConfirmationBuilder#recipient(java.lang.String)
	 */
	@Override
	public SubjectConfirmationBuilder recipient(String aRecipient) {
		if (aRecipient != null) {
			subjectConfirmationData.setRecipient(aRecipient);
		}
		return this;
	}

}
