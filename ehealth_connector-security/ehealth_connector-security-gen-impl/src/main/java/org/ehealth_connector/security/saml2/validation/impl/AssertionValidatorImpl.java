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
package org.ehealth_connector.security.saml2.validation.impl;

import java.security.KeyStore;

import org.ehealth_connector.security.exceptions.ValidationException;
import org.ehealth_connector.security.saml2.Assertion;
import org.ehealth_connector.security.saml2.impl.AssertionImpl;
import org.ehealth_connector.security.saml2.validation.AssertionValidator;

/**
 * <!-- @formatter:off -->
 * <div class="en">Implementation class of AssertionValidator</div>
 * <div class="de">Implementations Klasse von AssertionValidator</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class AssertionValidatorImpl extends AbstractValidator implements AssertionValidator {

	@Override
	public void setTrustStore(KeyStore keyStore, String password) {
		setTrustStore(keyStore);
		setPassword(password);
	}

	@Override
	public void validate(Assertion aType, String aAlias) throws ValidationException {
		final org.opensaml.saml.saml2.core.Assertion innerAssertion = ((AssertionImpl) aType)
				.getWrappedObject();
		innerAssertion.getDOM().setIdAttribute("ID", true);
		validate(innerAssertion.getSignature(), aAlias);
	}

}
