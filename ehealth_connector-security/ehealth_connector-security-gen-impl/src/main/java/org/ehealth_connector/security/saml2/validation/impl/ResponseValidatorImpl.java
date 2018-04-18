/*
 *
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
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
import org.ehealth_connector.security.saml2.Response;
import org.ehealth_connector.security.saml2.impl.ResponseImpl;
import org.ehealth_connector.security.saml2.validation.ResponseValidator;

/**
 * <!-- @formatter:off -->
 * <div class="en">Implementation class of ResponseValidator</div>
 * <div class="de">Implementations Klasse von ResponseValidator</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
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

		final org.opensaml.saml.saml2.core.Response innerResponse = ((ResponseImpl) aType).getWrappedObject();
		if (innerResponse.getSignature() != null) {
			validate(innerResponse.getSignature(), aAlias);
		}
	}

}
