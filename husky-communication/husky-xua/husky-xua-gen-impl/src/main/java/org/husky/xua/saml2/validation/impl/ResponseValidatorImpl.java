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
package org.husky.xua.saml2.validation.impl;

import java.security.KeyStore;

import org.husky.xua.exceptions.ValidationException;
import org.husky.xua.saml2.Response;
import org.husky.xua.saml2.impl.ResponseImpl;
import org.husky.xua.saml2.validation.ResponseValidator;

/**
 * <!-- @formatter:off -->
 * <div class="en">Implementation class of ResponseValidator</div>
 * <div class="de">Implementations Klasse von ResponseValidator</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class ResponseValidatorImpl extends AbstractValidator implements ResponseValidator {

	@Override
	public void setTrustStore(KeyStore keyStore, String password) {
		setTrustStore(keyStore);
		setPassword(password);
	}

	@Override
	public void validate(Response aType, String aAlias) throws ValidationException {

		final var innerResponse = ((ResponseImpl) aType)
				.getWrappedObject();
		if (innerResponse.getSignature() != null) {
			validate(innerResponse.getSignature(), aAlias);
		}
	}

}
