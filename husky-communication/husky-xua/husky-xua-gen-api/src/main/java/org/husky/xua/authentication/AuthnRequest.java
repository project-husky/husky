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
package org.husky.xua.authentication;

import org.husky.xua.saml2.Base;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.SubjectType;

/**
 * Interface describing the methods of AuthnRequest.
 */
public interface AuthnRequest extends Base {

    /**
     * Method to get the assertion consumer service index.
     *
     * @return the assertion consumer service index as integer
     */
    Integer getAssertionConsumerServiceIndex();

    /**
     * Method to get assertion consumer service url.
     *
     * @return the assertion consumer service url as string
     */
    String getAssertionConsumerServiceUrl();

    /**
     * Method to get attribute consumer service index.
     *
     * @return the attribute consumer service index as integer
     */
    Integer getAttributeConsumingServiceIndex();

    /**
     * Method to get the consent.
     *
     * @return the consent as string
     */
    String getConsent();

    /**
     * Method to get the destination.
     *
     * @return the destination value.
     */
    String getDestination();

    /**
     * Method to get the ForceAuthn value.
     *
     * @return the force authn value
     */
    Boolean getForceAuthn();

    /**
     * Method to get the NameIdPolicy.AllowCreate value.
     *
     * @return the NameIdPolicy.AllowCreate value.
     */
    Boolean getNameIdPolicyAllowCreate();

    /**
     * Method to get the NameIdPolicy.Format value.
     *
     * @return the NameIdPolicy.Format as string
     */
    String getNameIdPolicyFormat();

    /**
     * Method to get the ProtocolBinding value.
     *
     * @return the ProtocolBinding value as string
     */
    String getProtocolBinding();

    /**
     * Method to get the provider name.
     *
     * @return the provider name as string
     */
    String getProviderName();

    /**
     * Method to get the subject value.
     *
     * @return the subject
     */
    SubjectType getSubject();
}
