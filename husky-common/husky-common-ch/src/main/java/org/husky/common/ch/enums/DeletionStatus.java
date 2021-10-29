package org.husky.common.ch.enums;

/**
 * Deletion status of a DocumentEntry, as defined by the National extensions to the IHE Technical Framework, Annex 5,
 * Extension 1.
 *
 * <p>This is not automatically generated from Art-Decor (yet).
 *
 * @author Quentin Ligier
 */
public enum DeletionStatus {

    DELETION_NOT_REQUESTED("Deletion Not Requested", "urn:e-health-suisse:2019:deletionStatus:deletionNotRequested",
            "No action requested. This value can also be sent to undo the other options."),
    DELETION_REQUESTED("Deletion Requested", "urn:e-health-suisse:2019:deletionStatus:deletionRequested", "Document " +
            "shall be deleted."),
    DELETION_PROHIBITED("Deletion Prohibited", "urn:e-health-suisse:2019:deletionStatus:deletionProhibited", "This " +
            "document shall not be deleted after the time period for the deletion of outdated documents as defined in the law.");

    /**
     * Name of the value set.
     */
    public static final String VALUE_SET_NAME = "DocumentEntry.deletionStatus";

    /**
     * The deletion status name.
     */
    private final String name;

    /**
     * The deletion status URN.
     */
    private final String urn;

    /**
     * The deletion status description.
     */
    private final String description;

    /**
     * Constructor.
     *
     * @param name        The deletion status name.
     * @param urn         The deletion status URN.
     * @param description The deletion status description.
     */
    DeletionStatus(final String name,
                   final String urn,
                   final String description) {
        this.name = name;
        this.urn = urn;
        this.description = description;
    }

    /**
     * Checks if a given URN is in this value set.
     *
     * @param urn The URN to search.
     * @return {@code true} if the URN is in the value set, {@code false} otherwise.
     */
    public static boolean isInValueSet(final String urn) {
        return getEnum(urn) != null;
    }

    /**
     * Gets the deletion status that matches the given URN.
     *
     * @param urn The URN to search.
     * @return the found deletion status or {@code null} if it hasn't been found.
     */
    public static DeletionStatus getEnum(final String urn) {
        for (final DeletionStatus status : values()) {
            if (status.getUrn().equals(urn)) {
                return status;
            }
        }
        return null;
    }

    /**
     * Getter for the deletion status name.
     *
     * @return the name as a string.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for the deletion status URN.
     *
     * @return the URN as a string.
     */
    public String getUrn() {
        return this.urn;
    }

    /**
     * Getter for the deletion status description.
     *
     * @return the description as a string.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Gets the value set name.
     *
     * @return the value set name.
     */
    public String getValueSetName() {
        return VALUE_SET_NAME;
    }
}
