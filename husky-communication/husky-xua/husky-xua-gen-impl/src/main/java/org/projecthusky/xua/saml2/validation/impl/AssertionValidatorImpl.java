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
package org.projecthusky.xua.saml2.validation.impl;

import java.security.KeyStore;

import org.projecthusky.xua.exceptions.ValidationException;
import org.projecthusky.xua.saml2.Assertion;
import org.projecthusky.xua.saml2.impl.AssertionImpl;
import org.projecthusky.xua.saml2.validation.AssertionValidator;

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
		final var innerAssertion = ((AssertionImpl) aType)
				.getWrappedObject();
		innerAssertion.getDOM().setIdAttribute("ID", true);
		validate(innerAssertion.getSignature(), aAlias);
	}

}
