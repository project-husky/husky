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

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.security.core.SecurityObject;
import org.ehealth_connector.security.saml2.Subject;
import org.ehealth_connector.security.saml2.SubjectConfirmation;

/**
 * <!-- @formatter:off -->
 * <div class="en">Implementation class of Subject</div>
 * <div class="de">Implementations Klasse von Subject</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class SubjectImpl implements Subject, SecurityObject<org.opensaml.saml.saml2.core.Subject> {

	private org.opensaml.saml.saml2.core.Subject subject;

	protected SubjectImpl(org.opensaml.saml.saml2.core.Subject aSubject) {
		subject = aSubject;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.Subject#getNameIDFormat()
	 */
	@Override
	public String getNameIDFormat() {
		if (subject.getNameID() != null) {
			return subject.getNameID().getFormat();
		}
		return "";
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.Subject#getNameIDValue()
	 */
	@Override
	public String getNameIDValue() {
		if (subject.getNameID() != null) {
			return subject.getNameID().getValue();
		}
		return "";
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.saml2.Subject#getSubjectConfirmation()
	 */
	@Override
	public List<SubjectConfirmation> getSubjectConfirmations() {
		final List<SubjectConfirmation> retVal = new ArrayList<>();
		final List<org.opensaml.saml.saml2.core.SubjectConfirmation> innerConfirms = subject
				.getSubjectConfirmations();
		innerConfirms.forEach(c -> {
			retVal.add(new SubjectConfirmationBuilderImpl().create(c));
		});
		return retVal;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.core.SecurityObject#getWrappedObject()
	 */
	@Override
	public org.opensaml.saml.saml2.core.Subject getWrappedObject() {
		return subject;
	}

}
