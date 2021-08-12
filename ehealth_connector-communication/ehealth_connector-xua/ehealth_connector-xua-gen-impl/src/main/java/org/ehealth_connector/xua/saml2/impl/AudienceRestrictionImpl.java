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

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.xua.core.SecurityObject;
import org.ehealth_connector.xua.saml2.Audience;
import org.ehealth_connector.xua.saml2.AudienceRestriction;

/**
 * <!-- @formatter:off -->
 * <div class="en">Implementation class of AudienceRestriction</div>
 * <div class="de">Implementations Klasse von AudienceRestriction</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 *
 * <!-- @formatter:on -->
 */
public class AudienceRestrictionImpl implements AudienceRestriction,
		SecurityObject<org.opensaml.saml.saml2.core.AudienceRestriction> {

	private org.opensaml.saml.saml2.core.AudienceRestriction wrappedObject;

	protected AudienceRestrictionImpl(
			org.opensaml.saml.saml2.core.AudienceRestriction aInternalObject) {
		wrappedObject = aInternalObject;
	}

	@Override
	public List<Audience> getAudiences() {
		final List<org.opensaml.saml.saml2.core.Audience> internal = wrappedObject.getAudiences();
		final List<Audience> retVal = new ArrayList<>();
		internal.forEach(c -> {
			retVal.add(new AudienceBuilderImpl().create(c));
		});
		return retVal;
	}

	@Override
	public org.opensaml.saml.saml2.core.AudienceRestriction getWrappedObject() {
		return wrappedObject;
	}

}
