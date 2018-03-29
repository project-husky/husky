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
package org.ehealth_connector.security.crypt;

import java.security.KeyStore;
import java.security.KeyStore.PasswordProtection;
import java.security.KeyStore.PrivateKeyEntry;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableEntryException;
import java.security.cert.X509Certificate;

import org.ehealth_connector.security.authentication.AuthnRequest;
import org.ehealth_connector.security.authentication.impl.AuthnRequestImpl;
import org.ehealth_connector.security.exceptions.SigningException;
import org.opensaml.core.xml.config.XMLObjectProviderRegistrySupport;
import org.opensaml.core.xml.io.MarshallingException;
import org.opensaml.security.SecurityException;
import org.opensaml.security.x509.BasicX509Credential;
import org.opensaml.xmlsec.keyinfo.KeyInfoGenerator;
import org.opensaml.xmlsec.keyinfo.impl.X509KeyInfoGeneratorFactory;
import org.opensaml.xmlsec.signature.KeyInfo;
import org.opensaml.xmlsec.signature.Signature;
import org.opensaml.xmlsec.signature.impl.SignatureBuilder;
import org.opensaml.xmlsec.signature.support.SignatureConstants;
import org.opensaml.xmlsec.signature.support.SignatureException;
import org.opensaml.xmlsec.signature.support.Signer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the corresponding interface SignCryptModule.</div>
 * <div class="de">Die Klasse implementiert das entsprechende interface SignCryptModule.</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * <!-- @formatter:on -->
 */
public class SignCryptModuleImpl implements SignCryptModule {

	private static Logger LOG = LoggerFactory.getLogger(SignCryptModuleImpl.class);

	private KeyStore keyStore;

	private String keyStorePassword;

	private KeyStore trustStore;

	private String trustStorePassword;

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.security.crypt.SignCryptModule#setPki(java.security.KeyStore, java.security.KeyStore)
	 */
	@Override
	public void setPki(KeyStore aKeyStore, String aKeyStorePassword, KeyStore aTrustStore, String aTrustStorePassword) {
		keyStore = aKeyStore;
		keyStorePassword = aKeyStorePassword;
		trustStore = aTrustStore;
		trustStorePassword = aTrustStorePassword;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * 
	 *
	 * @see org.ehealth_connector.security.crypt.SignCryptModule#signAuthnRequest(org.ehealth_connector.security.authentication.AuthnRequest)
	 */
	@Override
	public void signAuthnRequest(AuthnRequest aAuthnRequest, String aSigningAlias) throws SigningException {
		try {
			final AuthnRequestImpl concrete = (AuthnRequestImpl) aAuthnRequest;

			final Signature signature = new SignatureBuilder().buildObject(Signature.DEFAULT_ELEMENT_NAME);

			final BasicX509Credential signingCredential = getSigningCredential(aSigningAlias);

			signature.setSigningCredential(signingCredential);
			signature.setSignatureAlgorithm(SignatureConstants.ALGO_ID_SIGNATURE_RSA_SHA512);
			signature.setCanonicalizationAlgorithm(SignatureConstants.ALGO_ID_C14N_EXCL_OMIT_COMMENTS);

			final X509KeyInfoGeneratorFactory keyInfoGeneratorFactory = new X509KeyInfoGeneratorFactory();
			keyInfoGeneratorFactory.setEmitEntityCertificate(true);
			keyInfoGeneratorFactory.setX509DigestAlgorithmURI(SignatureConstants.ALGO_ID_DIGEST_SHA1);

			if (keyInfoGeneratorFactory.handles(signingCredential)) {
				final KeyInfoGenerator keyInfoGenerator = keyInfoGeneratorFactory.newInstance();
				final KeyInfo keyInfo = keyInfoGenerator.generate(signingCredential);

				signature.setKeyInfo(keyInfo);

				concrete.getWrappedObject().setSignature(signature);

				XMLObjectProviderRegistrySupport.getMarshallerFactory().getMarshaller(concrete.getWrappedObject())
						.marshall(concrete.getWrappedObject());

				Signer.signObject(signature);

			}
		} catch (SecurityException | MarshallingException | SignatureException e) {
			throw new SigningException(e);
		}
	}

	/**
	 * 
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the desired BasicX509Credential for signing by alias.</div>
	 * <div class="de">Method um das BasicX509Credential referenziert durch das alias zu bekommen.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @param aSigningAlias
	 * <div class="en">the alias</div>
	 * <div class="de">Das alias</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @return
	 * <div class="en">the BasicX509Credential with the corresponding certificate and key</div>
	 * <div class="de">Das BasicX509Credential mit dem entspechenden Zertifikat und Key</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @throws SigningException
	 * <div class="en">will be thrown when an error occures loading the BasicX509Credential from keystore.</div>
	 *  <div class="de">wird geworfen wenn eine fehler beim laden des BasicX509Credential aus dem keystore auftritt</div>
	 *  <div class="fr">VOICIFRANCAIS</div>
	 *  <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	private BasicX509Credential getSigningCredential(String aSigningAlias) throws SigningException {
		try {
			final PrivateKeyEntry privateKeyEntry = (PrivateKeyEntry) keyStore.getEntry(aSigningAlias,
					new PasswordProtection(keyStorePassword.toCharArray()));
			final PrivateKey privateKey = privateKeyEntry.getPrivateKey();
			final X509Certificate certificate = (X509Certificate) privateKeyEntry.getCertificate();

			LOG.debug(certificate.getIssuerDN().getName());
			LOG.debug(certificate.getSubjectDN().getName());

			final BasicX509Credential credential = new BasicX509Credential(certificate, privateKey);
			credential.setEntityId(aSigningAlias);

			return credential;
		} catch (NoSuchAlgorithmException | UnrecoverableEntryException | KeyStoreException e) {
			throw new SigningException(e);
		}
	}

}
