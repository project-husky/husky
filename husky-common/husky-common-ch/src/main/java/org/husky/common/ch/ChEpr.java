package org.husky.common.ch;

/**
 * Some constants in use in the CH-EPR environment.
 *
 * @author Quentin Ligier
 */
public class ChEpr {

    /**
     * This class is not instantiable.
     */
    private ChEpr() {}

    /**
     * URN of an EPR-SPID.
     */
    public static final String EPR_SPID_URN = "urn:e-health-suisse:2015:epr-spid";

    /**
     * URN of the DocumentEntry.originalProviderRole attribute.
     */
    public static final String ORIGINAL_PROVIDER_ROLE_URN = "urn:e-health-suisse:2020:originalProviderRole";

    /**
     * URN of the DocumentEntry.deletionStatus attribute.
     */
    public static final String DELETION_STATUS_URN = "urn:e-health-suisse:2019:deletionStatus";
}
