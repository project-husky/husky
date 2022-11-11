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
import java.util.HashMap;
import java.util.Map;

import org.projecthusky.xua.exceptions.ValidationException;
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

	/**
	 * Method to get logger.
	 * @return returns the logger
	 */
	public Logger getLog() {
		return log;
	}

	/**
	 * Method to get password.
	 * @return returns the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Method to get truststore. 
	 * @return returns the truststore
	 */
	public KeyStore getTrustStore() {
		return trustStore;
	}

	/**
	 * Method to set password
	 * @param password the password to be set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Method to set trustStore.
	 * @param trustStore the trustStore to be set
	 */
	public void setTrustStore(KeyStore trustStore) {
		this.trustStore = trustStore;
	}

	/**
	 * Method to validate signatures.
	 * @param aSignature the signature instance
	 * @param aAlias the alias
	 * @throws ValidationException will be thrown on validation errors
	 */
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
