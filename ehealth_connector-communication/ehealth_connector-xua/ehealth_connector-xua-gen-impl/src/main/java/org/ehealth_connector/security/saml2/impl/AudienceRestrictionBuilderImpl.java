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

import org.ehealth_connector.security.core.SecurityObjectBuilder;
import org.ehealth_connector.security.saml2.AudienceRestriction;
import org.ehealth_connector.security.saml2.AudienceRestrictionBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the corresponding interface for  AudienceRestrictio building.</div>
 * <div class="de">Die Klasse implementiert das entsprechende Interface um  AudienceRestrictio bilden zu können.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class AudienceRestrictionBuilderImpl implements AudienceRestrictionBuilder,
		SecurityObjectBuilder<org.opensaml.saml.saml2.core.AudienceRestriction, AudienceRestriction> {

	private org.opensaml.saml.saml2.core.AudienceRestriction audienceRestriction;

	public AudienceRestrictionBuilderImpl() {
		audienceRestriction = new org.opensaml.saml.saml2.core.impl.AudienceRestrictionBuilder()
				.buildObject();
	}

	@Override
	public AudienceRestriction create() {
		return new AudienceRestrictionImpl(audienceRestriction);
	}

	@Override
	public AudienceRestriction create(
			org.opensaml.saml.saml2.core.AudienceRestriction aInternalObject) {

		return new AudienceRestrictionImpl(aInternalObject);
	}

}
