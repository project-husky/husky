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
import org.husky.xua.saml2.ArtifactResponse;
import org.husky.xua.saml2.impl.ArtifactResponseImpl;
import org.husky.xua.saml2.validation.ArtifactResponseValidator;

/**
 * <!-- @formatter:off -->
 * <div class="en">Implementation class of ArtifactResponseValidator</div>
 * <div class="de">Implementations Klasse von ArtifactResponseValidator</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class ArtifactResponseValidatorImpl extends AbstractValidator
		implements ArtifactResponseValidator {

	@Override
	public void setTrustStore(KeyStore trustStore, String password) {
		setTrustStore(trustStore);
		setPassword(password);
	}

	@Override
	public void validate(ArtifactResponse aType, String aAlias) throws ValidationException {
		final org.opensaml.saml.saml2.core.ArtifactResponse wrappedObject = ((ArtifactResponseImpl) aType)
				.getWrappedObject();
		if (wrappedObject.getSignature() != null) {
			validate(wrappedObject.getSignature(), aAlias);
		}
	}

}
