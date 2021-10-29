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

import java.util.List;

import org.ehealth_connector.xua.core.SecurityObjectBuilder;
import org.ehealth_connector.xua.saml2.SubjectBuilder;
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
	 * @see org.ehealth_connector.xua.saml2.SubjectBuilder#nameIDValue(java.lang.String)
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
