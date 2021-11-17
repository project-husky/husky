/*
 * This code is made available under the terms of the Eclipse Public License v1.0 in the github project https://github.com/project-husky/husky there you also find a list of the contributors and the license information.
This project has been developed further and modified by the joined working group Husky on the basis of the eHealth Connector opensource project from June 28, 2021, whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
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
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.husky.xua.core.SecurityObject;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.NameIDType;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.SubjectConfirmationType;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.SubjectType;
import org.opensaml.saml.saml2.core.impl.NameIDBuilder;
import org.opensaml.saml.saml2.core.impl.SubjectBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Implementation class of Subject</div>
 * <div class="de">Implementations Klasse von Subject</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class SubjectImpl extends SubjectType implements SecurityObject<org.opensaml.saml.saml2.core.Subject> {

	/** The subject. */
	private org.opensaml.saml.saml2.core.Subject subject;

	/**
	 * Instantiates a new SubjectImpl.
	 *
	 * @param aSubject
	 *            the a subject
	 */
	protected SubjectImpl(org.opensaml.saml.saml2.core.Subject aSubject) {
		subject = aSubject;
		
		getNameID();
		getSubjectConfirmations();
	}

	/**
	 * Instantiates a new SubjectImpl.
	 *
	 * @param aSubject the a subject
	 */
	protected SubjectImpl(SubjectType aSubject) {
		subject = new SubjectBuilder().buildObject();

		for (JAXBElement<?> element : aSubject.getContent()) {
			if (element != null) {
				if (element.getValue() instanceof NameIDType) {
					var nameId = (NameIDType) element.getValue();
					var retVal = new NameIDBuilder().buildObject();
					retVal.setFormat(nameId.getFormat());
					retVal.setValue(nameId.getValue());
					retVal.setNameQualifier(nameId.getNameQualifier());
					retVal.setSPNameQualifier(nameId.getSPNameQualifier());
					retVal.setSPProvidedID(nameId.getSPProvidedID());
					subject.setNameID(retVal);
				} else if (element.getValue() instanceof SubjectConfirmationType) {
					var subjectConf = (SubjectConfirmationType) element.getValue();
					subject.getSubjectConfirmations().add(new SubjectConfirmationBuilderImpl().create(subjectConf));
				}
			}
		}

		getNameID();
		getSubjectConfirmations();
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.saml2.Subject#getNameIDFormat()
	 */
	public NameIDType getNameID() {
		if (subject.getNameID() != null) {		
			var nameIdType = new NameIDType();
			nameIdType.setFormat(subject.getNameID().getFormat());
			nameIdType.setValue(subject.getNameID().getValue());
			nameIdType.setNameQualifier(subject.getNameID().getNameQualifier());
			nameIdType.setSPNameQualifier(subject.getNameID().getSPNameQualifier());
			nameIdType.setSPProvidedID(subject.getNameID().getSPProvidedID());			
			getContent().add(new JAXBElement<>(subject.getNameID().getElementQName(), NameIDType.class, nameIdType));
			
			return nameIdType;
		}
		return null;
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.saml2.Subject#getSubjectConfirmations()
	 */
	public List<SubjectConfirmationType> getSubjectConfirmations() {		
		final List<SubjectConfirmationType> retVal = new ArrayList<>();
		
		if(subject.getSubjectConfirmations() != null) {
			final List<org.opensaml.saml.saml2.core.SubjectConfirmation> innerConfirms = subject
					.getSubjectConfirmations();
			innerConfirms.forEach(c -> getContent().add(new JAXBElement<>(c.getElementQName(), SubjectConfirmationType.class, new SubjectConfirmationBuilderImpl().create(c))));
		}
				
		return retVal;
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.husky.xua.core.SecurityObject#getWrappedObject()
	 */
	@Override
	public org.opensaml.saml.saml2.core.Subject getWrappedObject() {
		return subject;
	}

}
