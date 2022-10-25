/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.xua;

/**
 * XUA specifications in the CH-EPR context.
 *
 * @author Quentin Ligier
 */
public class ChEprXuaSpecifications {

    /**
     * This class is not instantiable.
     */
    private ChEprXuaSpecifications() {}

    /**
     * Audience URN for all communities.
     */
    public static final String AUDIENCE_ALL_COMMUNITIES = "urn:e-health-suisse:token-audience:all-communities";

    /**
     * URN to specify the technical user ID.
     */
    public static final String TECHNICAL_USER_ID = "urn:e-health-suisse:technical-user-id";

    /**
     * URN to specify the policy administrator ID.
     */
    public static final String POLICY_ADMINISTRATOR_ID = "urn:e-health-suisse:policy-administrator-id";

    /**
     * URN to specify the document administrator ID.
     */
    public static final String DOCUMENT_ADMINISTRATOR_ID = "urn:e-health-suisse:document-administrator-id";

    /**
     * URN to specify the representative ID.
     */
    public static final String REPRESENTATIVE_ID = "urn:e-health-suisse:representative-id";

    /**
     * URN to specify the ID of the user.
     */
    public static final String PRINCIPAL_ID = "urn:e-health-suisse:principal-id";

    /**
     * URN to specify the name of the user.
     */
    public static final String PRINCIPAL_NAME = "urn:e-health-suisse:principal-name";

    /**
     * The claims dialect (in Get X-User Assertion requests).
     */
    public static final String CLAIMS_DIALECT = "http://bag.admin.ch/epr/2017/annex/5/addendum/2";
}
