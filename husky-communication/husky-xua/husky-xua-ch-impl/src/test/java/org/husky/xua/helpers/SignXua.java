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
package org.husky.xua.helpers;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.opensaml.core.config.InitializationService;
import org.opensaml.core.xml.config.XMLObjectProviderRegistrySupport;
import org.opensaml.core.xml.io.Marshaller;
import org.opensaml.core.xml.io.Unmarshaller;
import org.opensaml.core.xml.util.XMLObjectSupport;
import org.opensaml.saml.saml2.core.Assertion;
import org.opensaml.security.credential.Credential;
import org.opensaml.security.credential.CredentialContextSet;
import org.opensaml.security.credential.UsageType;
import org.opensaml.xmlsec.SignatureSigningParameters;
import org.opensaml.xmlsec.signature.Signature;
import org.opensaml.xmlsec.signature.support.SignatureSupport;
import org.opensaml.xmlsec.signature.support.Signer;
import org.w3c.dom.Element;

import javax.crypto.SecretKey;
import javax.xml.crypto.dsig.CanonicalizationMethod;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * husky
 *
 * @author Quentin Ligier
 **/
public class SignXua {

    public static void main(String[] args) throws Exception {
        // The XUA file to sign (it should contain no signature)
        final String xuaFile = "xua/assertion-hcp.xml";

        InitializationService.initialize();
        final Unmarshaller unmarshaller = XMLObjectSupport.getUnmarshaller(Assertion.TYPE_NAME);

        final Element element = Objects.requireNonNull(XMLObjectProviderRegistrySupport.getParserPool(), "Can't get " +
                        "the parser pool")
                .parse(Objects.requireNonNull(SignXua.class.getClassLoader().getResourceAsStream(xuaFile), "Can't " +
                        "find the XUA file to sign"))
                .getDocumentElement();
        final Assertion assertion = (Assertion) unmarshaller.unmarshall(element);

        // Load the keystore
        final KeyStore ks = KeyStore.getInstance("JKS");
        ks.load(SignXua.class.getResourceAsStream("/husky_test_keystore1.jks"), "password".toCharArray());

        final Credential credential = new Credential() {
            @Nullable
            @Override
            public String getEntityId() {
                return null;
            }

            @Nullable
            @Override
            public UsageType getUsageType() {
                return null;
            }

            @NonNull
            @Override
            public Collection<String> getKeyNames() {
                return List.of("testkey");
            }

            @Nullable
            @Override
            public PublicKey getPublicKey() {
                return null;
            }

            @Nullable
            @Override
            public PrivateKey getPrivateKey() {
                try {
                    return ((KeyStore.PrivateKeyEntry) ks.getEntry("testkey",
                            new KeyStore.PasswordProtection("password".toCharArray()))).getPrivateKey();
                } catch (final Exception e) {
                    return null;
                }
            }

            @Nullable
            @Override
            public SecretKey getSecretKey() {
                return null;
            }

            @Nullable
            @Override
            public CredentialContextSet getCredentialContextSet() {
                return null;
            }

            @NonNull
            @Override
            public Class<? extends Credential> getCredentialType() {
                return Credential.class;
            }
        };

        // Prepare the signature
        final Signature signature = (Signature) XMLObjectProviderRegistrySupport.getBuilderFactory().getBuilder(Signature.DEFAULT_ELEMENT_NAME)
                .buildObject(Signature.DEFAULT_ELEMENT_NAME);
        assertion.setSignature(signature);
        signature.setSigningCredential(credential);

        SignatureSigningParameters parameters = new SignatureSigningParameters();
        parameters.setSigningCredential(credential);
        parameters.setSignatureAlgorithm("http://www.w3.org/2001/04/xmldsig-more#rsa-sha256");
        parameters.setSignatureReferenceDigestMethod("http://www.w3.org/2001/04/xmlenc#sha256");
        parameters.setSignatureCanonicalizationAlgorithm(CanonicalizationMethod.EXCLUSIVE);
        SignatureSupport.prepareSignatureParams(signature, parameters);

        Marshaller marshaller = XMLObjectProviderRegistrySupport.getMarshallerFactory().getMarshaller(assertion);
        final Element element1 = marshaller.marshall(assertion);

        // Sign it!
        Signer.signObject(signature);

        // And transform it to XML
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setParameter(OutputKeys.OMIT_XML_DECLARATION, "yes");
        transformer.setParameter(OutputKeys.INDENT, "yes");

        DOMSource source = new DOMSource(element1);
        StreamResult result = new StreamResult(new StringWriter());
        transformer.transform(source, result);
        System.out.println(result.getWriter().toString());
    }
}
