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

import org.projecthusky.xua.core.SecurityObjectBuilder;
import org.projecthusky.xua.saml2.AudienceRestrictionBuilder;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.AudienceRestrictionType;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the corresponding interface for  AudienceRestrictio building.</div>
 * <div class="de">Die Klasse implementiert das entsprechende Interface um  AudienceRestrictio bilden zu können.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class AudienceRestrictionBuilderImpl implements AudienceRestrictionBuilder,
		SecurityObjectBuilder<org.opensaml.saml.saml2.core.AudienceRestriction, AudienceRestrictionType> {

	private org.opensaml.saml.saml2.core.AudienceRestriction audienceRestriction;

	public AudienceRestrictionBuilderImpl() {
		audienceRestriction = new org.opensaml.saml.saml2.core.impl.AudienceRestrictionBuilder()
				.buildObject();
	}

	@Override
	public AudienceRestrictionType create() {
		return new AudienceRestrictionImpl(audienceRestriction);
	}

	public AudienceRestrictionType create(
			org.opensaml.saml.saml2.core.AudienceRestriction aInternalObject) {

		return new AudienceRestrictionImpl(aInternalObject);
	}

	public org.opensaml.saml.saml2.core.AudienceRestriction create(AudienceRestrictionType aInternalObject) {
		return new AudienceRestrictionImpl(aInternalObject).getWrappedObject();
	}

}
