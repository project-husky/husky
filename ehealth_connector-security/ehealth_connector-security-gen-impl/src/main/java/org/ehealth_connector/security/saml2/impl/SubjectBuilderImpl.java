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
package org.ehealth_connector.security.saml2.impl;

import java.util.List;

import org.ehealth_connector.security.core.SecurityObjectBuilder;
import org.ehealth_connector.security.saml2.Subject;
import org.ehealth_connector.security.saml2.SubjectBuilder;
import org.ehealth_connector.security.saml2.SubjectConfirmation;
import org.opensaml.saml.saml2.core.NameID;
import org.opensaml.saml.saml2.core.impl.NameIDBuilder;

/**
 * @since Feb 22, 2018 9:26:34 AM
 *
 */
public class SubjectBuilderImpl implements SubjectBuilder,
		SecurityObjectBuilder<org.opensaml.saml.saml2.core.Subject, Subject> {

	private NameID nameID;
	private org.opensaml.saml.saml2.core.Subject subject;

	public SubjectBuilderImpl() {
		subject = new org.opensaml.saml.saml2.core.impl.SubjectBuilder().buildObject();

		nameID = new NameIDBuilder().buildObject();
		subject.setNameID(nameID);
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.SubjectBuilder#addSubjectConfirmations(org.ehealth_connector.security.saml2.SubjectConfirmation)
	 */
	@Override
	public SubjectBuilder addSubjectConfirmations(SubjectConfirmation aSubjectConfirmation) {
		if (aSubjectConfirmation != null) {
			final List<org.opensaml.saml.saml2.core.SubjectConfirmation> subjectConfirms = subject
					.getSubjectConfirmations();
			subjectConfirms
					.add(((SubjectConfirmationImpl) aSubjectConfirmation).getWrappedObject());
		}
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.SubjectBuilder#create()
	 */
	@Override
	public Subject create() {
		return new SubjectImpl(subject);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.core.SecurityObjectBuilder#create(java.lang.Object)
	 */
	@Override
	public Subject create(org.opensaml.saml.saml2.core.Subject aInternalObject) {
		return new SubjectImpl(aInternalObject);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.SubjectBuilder#nameIDFormat(java.lang.String)
	 */
	@Override
	public SubjectBuilder nameIDFormat(String aNameIDFormat) {
		if (aNameIDFormat != null) {
			subject.getNameID().setFormat(aNameIDFormat);
		}
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.SubjectBuilder#nameIDValue(java.lang.String)
	 */
	@Override
	public SubjectBuilder nameIDValue(String aNameIDValue) {
		if (aNameIDValue != null) {
			subject.getNameID().setValue(aNameIDValue);
		}
		return this;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.SubjectBuilder#subjectConfirmations(java.util.List)
	 */
	@Override
	public SubjectBuilder subjectConfirmations(List<SubjectConfirmation> aSubjectConfirmations) {
		if (aSubjectConfirmations != null) {
			final List<org.opensaml.saml.saml2.core.SubjectConfirmation> subjectConfirms = subject
					.getSubjectConfirmations();
			aSubjectConfirmations.forEach(c -> {
				subjectConfirms.add(((SubjectConfirmationImpl) c).getWrappedObject());
			});
		}
		return this;
	}

}
