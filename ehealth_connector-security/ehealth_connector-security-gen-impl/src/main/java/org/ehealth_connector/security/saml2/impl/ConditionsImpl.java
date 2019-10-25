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

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.security.core.SecurityObject;
import org.ehealth_connector.security.saml2.AudienceRestriction;
import org.ehealth_connector.security.saml2.Conditions;

/**
 *
 */
public class ConditionsImpl
		implements Conditions, SecurityObject<org.opensaml.saml.saml2.core.Conditions> {

	private org.opensaml.saml.saml2.core.Conditions wrappedObject;

	protected ConditionsImpl(org.opensaml.saml.saml2.core.Conditions aInternalObject) {
		wrappedObject = aInternalObject;
	}

	@Override
	public List<AudienceRestriction> getAudienceRestrictions() {
		final List<AudienceRestriction> retVal = new ArrayList<>();
		if (wrappedObject.getAudienceRestrictions() != null) {
			wrappedObject.getAudienceRestrictions().forEach(audienceRestrictions -> {
				retVal.add(new AudienceRestrictionBuilderImpl().create(audienceRestrictions));
			});
		}
		return retVal;
	}

	@Override
	public org.opensaml.saml.saml2.core.Conditions getWrappedObject() {
		return wrappedObject;
	}

}
