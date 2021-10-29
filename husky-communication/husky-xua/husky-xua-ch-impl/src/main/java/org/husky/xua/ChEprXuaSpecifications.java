package org.husky.xua;

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
}
