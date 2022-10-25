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

import org.projecthusky.xua.core.SecurityObject;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.AudienceRestrictionType;
import org.opensaml.saml.saml2.core.impl.AudienceBuilder;
import org.opensaml.saml.saml2.core.impl.AudienceRestrictionBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Implementation class of AudienceRestriction</div>
 * <div class="de">Implementations Klasse von AudienceRestriction</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 *
 * <!-- @formatter:on -->
 */
public class AudienceRestrictionImpl extends AudienceRestrictionType implements
		SecurityObject<org.opensaml.saml.saml2.core.AudienceRestriction> {

	private org.opensaml.saml.saml2.core.AudienceRestriction wrappedObject;

	protected AudienceRestrictionImpl(
			org.opensaml.saml.saml2.core.AudienceRestriction aInternalObject) {
		wrappedObject = aInternalObject;
	}

	protected AudienceRestrictionImpl(AudienceRestrictionType aInternalObject) {
		wrappedObject = new AudienceRestrictionBuilder().buildObject();

		for (String audience : aInternalObject.getAudience()) {
			var retVal = new AudienceBuilder().buildObject();
			retVal.setURI(audience);
			wrappedObject.getAudiences().add(retVal);
		}
	}

	public List<String> getAudiences() {		
		final List<org.opensaml.saml.saml2.core.Audience> internal = wrappedObject.getAudiences();		
		internal.forEach(c -> getAudience().add(c.getURI()));
		return getAudience();
	}

	@Override
	public org.opensaml.saml.saml2.core.AudienceRestriction getWrappedObject() {
		return wrappedObject;
	}

}
