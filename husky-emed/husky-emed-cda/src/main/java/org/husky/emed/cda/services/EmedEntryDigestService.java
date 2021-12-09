/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.cda.services;

import java.time.Instant;
import java.util.Optional;

import org.husky.emed.models.entry.EmedEntryDigest;

/**
 * The service of the {@link EmedEntryDigest} registry.
 *
 * @author Quentin Ligier
 */
public interface EmedEntryDigestService {

    /**
     * Find an Emed entry digest by its ID.
     *
     * @param entryId The Emed entry ID.
     * @return an {@link Optional} that may contain the found item entry.
     */
    Optional<EmedEntryDigest> getById(final String entryId);

    /**
     * Find a single Emed entry digest by its document ID.
     *
     * @param documentUniqueId The Emed document ID.
     * @return an {@link Optional} that may contain the found item entry.
     */
    Optional<EmedEntryDigest> getByDocument(final String documentUniqueId);

    /**
     * Find the next number in the sequence. The sequence is necessary to order Emed entries belonging to the same
     * medication treatment and having the same creation time (it should be quite rare but is allowed); one is
     * necessarily aggregated before the other, in order of ascending sequence number.
     * <p>
     * The simplest implementation is to return the count of entries in the given medication treatment that have the
     * given creation time; this sequence begins at 0.
     *
     * @param medicationTreatmentId The medication treatment ID.
     * @param creationTime The document creation time.
     * @return The next number in the sequence.
     */
    long getSequence(final String medicationTreatmentId, final Instant creationTime);
}
