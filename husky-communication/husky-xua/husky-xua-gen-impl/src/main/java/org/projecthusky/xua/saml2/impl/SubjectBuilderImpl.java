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

import java.util.List;

import org.projecthusky.xua.core.SecurityObjectBuilder;
import org.projecthusky.xua.saml2.SubjectBuilder;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.SubjectConfirmationType;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.SubjectType;
import org.opensaml.saml.saml2.core.NameID;
import org.opensaml.saml.saml2.core.impl.NameIDBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the corresponding interface for Subject building.</div>
 * <div class="de">Die Klasse implementiert das entsprechende Interface um Subject bilden zu k&ouml;nnen.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 *
 */
public class SubjectBuilderImpl implements SubjectBuilder,
		SecurityObjectBuilder<org.opensaml.saml.saml2.core.Subject, SubjectType> {

	private NameID nameID;
	private org.opensaml.saml.saml2.core.Subject subject;

	/**
	 * Default constructor.
	 */
	public SubjectBuilderImpl() {
		subject = new org.opensaml.saml.saml2.core.impl.SubjectBuilder().buildObject();

		nameID = new NameIDBuilder().buildObject();
		subject.setNameID(nameID);
	}

	@Override
	public SubjectBuilder addSubjectConfirmations(SubjectConfirmationType aSubjectConfirmation) {
		if (aSubjectConfirmation != null) {
			final List<org.opensaml.saml.saml2.core.SubjectConfirmation> subjectConfirms = subject
					.getSubjectConfirmations();
			subjectConfirms
					.add(((SubjectConfirmationImpl) aSubjectConfirmation).getWrappedObject());
		}
		return this;
	}

	@Override
	public SubjectType create() {
		return new SubjectImpl(subject);
	}

	@Override
	public SubjectType create(org.opensaml.saml.saml2.core.Subject aInternalObject) {
		return new SubjectImpl(aInternalObject);
	}

	/**
	 * Method to create SubjectType.
	 * 
	 * @param aInternalObject the SubjectType
	 * @return the opensaml SubjectType
	 */
	public org.opensaml.saml.saml2.core.Subject create(SubjectType aInternalObject) {
		return new SubjectImpl(aInternalObject).getWrappedObject();
	}

	@Override
	public SubjectBuilder nameIDFormat(String aNameIDFormat) {
		if (aNameIDFormat != null) {
			subject.getNameID().setFormat(aNameIDFormat);
		}
		return this;
	}

	@Override
	public SubjectBuilder nameIDNameQualifier(String aNameIDNameQualifier) {
		if (aNameIDNameQualifier != null) {
			subject.getNameID().setNameQualifier(aNameIDNameQualifier);
		}
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.projecthusky.xua.saml2.SubjectBuilder#nameIDValue(java.lang.String)
	 */
	@Override
	public SubjectBuilder nameIDValue(String aNameIDValue) {
		if (aNameIDValue != null) {
			subject.getNameID().setValue(aNameIDValue);
		}
		return this;
	}

	@Override
	public SubjectBuilder subjectConfirmations(List<SubjectConfirmationType> aSubjectConfirmations) {
		if (aSubjectConfirmations != null) {
			final List<org.opensaml.saml.saml2.core.SubjectConfirmation> subjectConfirms = subject
					.getSubjectConfirmations();
			aSubjectConfirmations.forEach(c -> 
				subjectConfirms.add(((SubjectConfirmationImpl) c).getWrappedObject())
			);
		}
		return this;
	}
}
