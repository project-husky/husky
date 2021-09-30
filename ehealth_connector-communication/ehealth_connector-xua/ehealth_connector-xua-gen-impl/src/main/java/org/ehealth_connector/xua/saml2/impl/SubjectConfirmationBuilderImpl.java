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

import java.util.Calendar;

import org.ehealth_connector.xua.core.SecurityObjectBuilder;
import org.ehealth_connector.xua.saml2.SubjectConfirmationBuilder;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.SubjectConfirmationType;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the corresponding interface for SubjectConfirmation building.</div>
 * <div class="de">Die Klasse implementiert das entsprechende Interface um SubjectConfirmation bilden zu k&ooml;nnen.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 *
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
	 * @see org.ehealth_connector.xua.saml2.SubjectConfirmationBuilder#address(java.lang.String)
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
	 * @see org.ehealth_connector.xua.saml2.SubjectConfirmationBuilder#create()
	 */
	@Override
	public SubjectConfirmationType create() {
		return new SubjectConfirmationImpl(subjectConfirmation);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.core.SecurityObjectBuilder#create(java.lang.Object)
	 */
	@Override
	public SubjectConfirmationType create(
			org.opensaml.saml.saml2.core.SubjectConfirmation aInternalObject) {
		return new SubjectConfirmationImpl(aInternalObject);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.saml2.SubjectConfirmationBuilder#inResponseTo(java.lang.String)
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
	 * @see org.ehealth_connector.xua.saml2.SubjectConfirmationBuilder#method(java.lang.String)
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
	 * @see org.ehealth_connector.xua.saml2.SubjectConfirmationBuilder#notBefore(java.util.Calendar)
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
	 * @see org.ehealth_connector.xua.saml2.SubjectConfirmationBuilder#notOnOrAfter(java.util.Calendar)
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
	 * @see org.ehealth_connector.xua.saml2.SubjectConfirmationBuilder#recipient(java.lang.String)
	 */
	@Override
	public SubjectConfirmationBuilder recipient(String aRecipient) {
		if (aRecipient != null) {
			subjectConfirmationData.setRecipient(aRecipient);
		}
		return this;
	}

}
