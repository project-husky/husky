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
import org.ehealth_connector.security.saml2.Audience;
import org.ehealth_connector.security.saml2.AudienceBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the corresponding interface for  Audience building.</div>
 * <div class="de">Die Klasse implementiert das entsprechende Interface um  Audience bilden zu können.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class AudienceBuilderImpl implements AudienceBuilder,
		SecurityObjectBuilder<org.opensaml.saml.saml2.core.Audience, Audience> {

	private org.opensaml.saml.saml2.core.Audience audience;

	public AudienceBuilderImpl() {
		audience = new org.opensaml.saml.saml2.core.impl.AudienceBuilder().buildObject();
	}

	@Override
	public Audience create() {
		return new AudienceImpl(audience);
	}

	@Override
	public Audience create(org.opensaml.saml.saml2.core.Audience aInternalObject) {
		return new AudienceImpl(audience);
	}

}
