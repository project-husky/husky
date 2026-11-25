/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.xua.validation;

import org.opensaml.xmlsec.signature.Signature;
import org.opensaml.xmlsec.signature.support.SignatureException;
import org.opensaml.xmlsec.signature.support.SignaturePrevalidator;

import javax.annotation.concurrent.ThreadSafe;

/**
 * A no-operation {@link SignaturePrevalidator}.
 */
@ThreadSafe
public class NoopSAMLSignatureProfileValidator implements SignaturePrevalidator {

    /**
     * Validate the specified signature with SAML specifications
     *
     * @param signature the SAML signature to validate.
     */
    @Override
    public void validate(Signature signature) throws SignatureException {}
}
