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
package org.ehealth_connector.xua.saml2.validation.impl;

import java.security.KeyStore;
import java.util.HashMap;
import java.util.Map;

import org.ehealth_connector.xua.exceptions.ValidationException;
import org.opensaml.core.criterion.EntityIdCriterion;
import org.opensaml.saml.security.impl.SAMLSignatureProfileValidator;
import org.opensaml.security.credential.impl.KeyStoreCredentialResolver;
import org.opensaml.xmlsec.signature.Signature;
import org.opensaml.xmlsec.signature.support.SignatureValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.shibboleth.utilities.java.support.resolver.CriteriaSet;
import net.shibboleth.utilities.java.support.resolver.Criterion;

/**
 * <!-- @formatter:off -->
 * <div class="en">Abstract class implementing the generic functions for all validators.</div>
 * <div class="de">Abstrakte Klasse implementiert alle generischen Funktionen für die Validatoren.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public abstract class AbstractValidator {

	private final Logger log = LoggerFactory.getLogger(getClass());

	private String password;
	private KeyStore trustStore;

	public Logger getLog() {
		return log;
	}

	public String getPassword() {
		return password;
	}

	public KeyStore getTrustStore() {
		return trustStore;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setTrustStore(KeyStore trustStore) {
		this.trustStore = trustStore;
	}

	public void validate(Signature aSignature, String aAlias) throws ValidationException {
		try {
			final var profileValidator = new SAMLSignatureProfileValidator();
			profileValidator.validate(aSignature);
		} catch (final Exception e) {
			log.error("Error", e);
		}
		try {
			final Map<String, String> passwordMap = new HashMap<>();
			final var resolver = new KeyStoreCredentialResolver(trustStore,
					passwordMap);

			final Criterion criterion = new EntityIdCriterion(aAlias);
			final var criteriaSet = new CriteriaSet(criterion);
			final var credential = resolver.resolveSingle(criteriaSet);

			SignatureValidator.validate(aSignature, credential);

		} catch (final Exception e) {
			throw new ValidationException(e);
		}
	}

}
