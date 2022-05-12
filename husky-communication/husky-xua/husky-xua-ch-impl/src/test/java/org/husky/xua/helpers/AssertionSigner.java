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

import org.opensaml.core.xml.config.XMLObjectProviderRegistrySupport;
import org.opensaml.core.xml.io.Marshaller;
import org.opensaml.saml.saml2.core.Assertion;
import org.opensaml.security.credential.Credential;
import org.opensaml.xmlsec.SignatureSigningParameters;
import org.opensaml.xmlsec.signature.Signature;
import org.opensaml.xmlsec.signature.support.SignatureSupport;
import org.opensaml.xmlsec.signature.support.Signer;
import org.w3c.dom.Element;

import javax.xml.crypto.dsig.CanonicalizationMethod;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

/**
 * Utility to sign an assertion with the given credentials.
 *
 * @author Quentin Ligier
 **/
public class AssertionSigner {

    public static String sign(final Assertion assertion,
                              final Credential credential) throws Exception {
        // Prepare the signature
        final Signature signature = (Signature) XMLObjectProviderRegistrySupport.getBuilderFactory().getBuilder(Signature.DEFAULT_ELEMENT_NAME)
                .buildObject(Signature.DEFAULT_ELEMENT_NAME);
        assertion.setSignature(signature);
        signature.setSigningCredential(credential);

        final var parameters = new SignatureSigningParameters();
        parameters.setSigningCredential(credential);
        parameters.setSignatureAlgorithm("http://www.w3.org/2001/04/xmldsig-more#rsa-sha256");
        parameters.setSignatureReferenceDigestMethod("http://www.w3.org/2001/04/xmlenc#sha256");
        parameters.setSignatureCanonicalizationAlgorithm(CanonicalizationMethod.EXCLUSIVE);
        SignatureSupport.prepareSignatureParams(signature, parameters);

        final Marshaller marshaller = XMLObjectProviderRegistrySupport.getMarshallerFactory().getMarshaller(assertion);
        final Element element1 = marshaller.marshall(assertion);

        // Sign it!
        Signer.signObject(signature);

        // And transform it to XML
        final TransformerFactory transformerFactory = TransformerFactory.newInstance();
        final Transformer transformer = transformerFactory.newTransformer();
        transformer.setParameter(OutputKeys.OMIT_XML_DECLARATION, "yes");
        transformer.setParameter(OutputKeys.INDENT, "yes");

        final var source = new DOMSource(element1);
        final var result = new StreamResult(new StringWriter());
        transformer.transform(source, result);

        return result.getWriter().toString();
    }
}
