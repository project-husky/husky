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

import org.ehealth_connector.xua.core.SecurityObject;
import org.ehealth_connector.xua.saml2.Audience;

/**
 * <!-- @formatter:off -->
 * <div class="en">Implementation class of Audience</div>
 * <div class="de">Implementations Klasse von Audience</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 *
 * <!-- @formatter:on -->
 */
public class AudienceImpl
		implements Audience, SecurityObject<org.opensaml.saml.saml2.core.Audience> {

	private org.opensaml.saml.saml2.core.Audience wrappedObject;

	protected AudienceImpl(org.opensaml.saml.saml2.core.Audience aInternalObject) {
		wrappedObject = aInternalObject;
	}

	@Override
	public String getAudienceURI() {
		return wrappedObject.getAudienceURI();
	}

	@Override
	public org.opensaml.saml.saml2.core.Audience getWrappedObject() {
		return wrappedObject;
	}

}
