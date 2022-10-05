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
package org.projecthusky.xua.crypt;

import java.security.KeyStore;
import java.security.KeyStore.PasswordProtection;
import java.security.KeyStore.PrivateKeyEntry;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableEntryException;
import java.security.cert.X509Certificate;

import org.projecthusky.xua.authentication.AuthnRequest;
import org.projecthusky.xua.authentication.impl.AuthnRequestImpl;
import org.projecthusky.xua.exceptions.SigningException;
import org.projecthusky.xua.saml2.ArtifactResolve;
import org.projecthusky.xua.saml2.impl.ArtifactResolveImpl;
import org.opensaml.core.xml.config.XMLObjectProviderRegistrySupport;
import org.opensaml.core.xml.io.MarshallingException;
import org.opensaml.security.SecurityException;
import org.opensaml.security.x509.BasicX509Credential;
import org.opensaml.xmlsec.keyinfo.impl.X509KeyInfoGeneratorFactory;
import org.opensaml.xmlsec.signature.SignableXMLObject;
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
 * <div class="de">Die Klasse implementiert das entsprechende Interface SignCryptModule.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class SignCryptModuleImpl implements SignCryptModule {

	private static final Logger LOG = LoggerFactory.getLogger(SignCryptModuleImpl.class);

	private KeyStore keyStore;

	private String keyStorePassword;

	@SuppressWarnings("unused")
	private KeyStore trustStore;

	@SuppressWarnings("unused")
	private String trustStorePassword;

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to get the desired BasicX509Credential for signing by alias.</div>
	 * <div class="de">Methode um das gewünschen BasicX509Credential für das 'signing by alias' zu erhalten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aSigningAlias
	 * <div class="en">the alias</div>
	 * <div class="de">Das Alias</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @return
	 * <div class="en">the BasicX509Credential with the corresponding certificate and key</div>
	 * <div class="de">Das BasicX509Credential mit dem entspechenden Zertifikat und Key</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @throws SigningException
	 * <div class="en">will be thrown when an error occures loading the BasicX509Credential from keystore.</div>
	 *  <div class="de">wird geworfen wenn ein Fehler beim Laden des BasicX509Credential aus dem Keystore auftritt</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	private BasicX509Credential getSigningCredential(String aSigningAlias) throws SigningException {
		try {
			final var privateKeyEntry = (PrivateKeyEntry) keyStore.getEntry(
					aSigningAlias, new PasswordProtection(keyStorePassword.toCharArray()));
			final var privateKey = privateKeyEntry.getPrivateKey();
			final X509Certificate certificate = (X509Certificate) privateKeyEntry.getCertificate();

			LOG.debug(certificate.getIssuerX500Principal().getName());
			
			final var credential = new BasicX509Credential(certificate, privateKey);
			credential.setEntityId(aSigningAlias);

			return credential;
		} catch (NoSuchAlgorithmException | UnrecoverableEntryException | KeyStoreException e) {
			throw new SigningException(e);
		}
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.projecthusky.xua.crypt.SignCryptModule#setPki(java.security.KeyStore,
	 *      java.lang.String, java.security.KeyStore, java.lang.String)
	 */
	@Override
	public void setPki(KeyStore aKeyStore, String aKeyStorePassword, KeyStore aTrustStore,
			String aTrustStorePassword) {
		keyStore = aKeyStore;
		keyStorePassword = aKeyStorePassword;
		trustStore = aTrustStore;
		trustStorePassword = aTrustStorePassword;
	}

	private void sign(SignableXMLObject singningobject, String aSigningAlias)
			throws SigningException {
		try {

			final Signature signature = new SignatureBuilder()
					.buildObject(Signature.DEFAULT_ELEMENT_NAME);

			final BasicX509Credential signingCredential = getSigningCredential(aSigningAlias);

			signature.setSigningCredential(signingCredential);
			signature.setSignatureAlgorithm(SignatureConstants.ALGO_ID_SIGNATURE_RSA_SHA512);
			signature.setCanonicalizationAlgorithm(
					SignatureConstants.ALGO_ID_C14N_EXCL_OMIT_COMMENTS);

			final var keyInfoGeneratorFactory = new X509KeyInfoGeneratorFactory();
			keyInfoGeneratorFactory.setEmitEntityCertificate(true);
			keyInfoGeneratorFactory
					.setX509DigestAlgorithmURI(SignatureConstants.ALGO_ID_DIGEST_SHA1);

			if (keyInfoGeneratorFactory.handles(signingCredential)) {
				final var keyInfoGenerator = keyInfoGeneratorFactory.newInstance();
				final var keyInfo = keyInfoGenerator.generate(signingCredential);

				signature.setKeyInfo(keyInfo);

				singningobject.setSignature(signature);

				XMLObjectProviderRegistrySupport.getMarshallerFactory()
						.getMarshaller(singningobject).marshall(singningobject);

				Signer.signObject(signature);

			}
		} catch (SecurityException | MarshallingException | SignatureException e) {
			throw new SigningException(e);
		}
	}

	@Override
	public void signArtifactResolve(ArtifactResolve artifactResolve, String aSigningAlias)
			throws SigningException {
		final ArtifactResolveImpl concrete = (ArtifactResolveImpl) artifactResolve;
		sign(concrete.getWrappedObject(), aSigningAlias);
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.projecthusky.xua.crypt.SignCryptModule#signAuthnRequest(org.projecthusky.xua.authentication.AuthnRequest,
	 *      java.lang.String)
	 */
	@Override
	public void signAuthnRequest(AuthnRequest aAuthnRequest, String aSigningAlias)
			throws SigningException {
		final AuthnRequestImpl concrete = (AuthnRequestImpl) aAuthnRequest;
		sign(concrete.getWrappedObject(), aSigningAlias);
	}

}
