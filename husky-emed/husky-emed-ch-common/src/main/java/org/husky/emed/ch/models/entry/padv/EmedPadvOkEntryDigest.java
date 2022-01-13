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

/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.ch.models.entry.padv;

import lombok.Getter;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.emed.ch.enums.EmedEntryType;
import org.husky.emed.ch.enums.PharmaceuticalAdviceStatus;
import org.husky.emed.ch.models.common.AuthorDigest;
import org.husky.emed.ch.models.common.EmedReference;
import org.husky.emed.ch.models.entry.EmedPadvEntryDigest;
import org.husky.emed.ch.models.entry.EmedPreEntryDigest;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents the digest of an EMED PADV Ok item entry.
 *
 * @author Quentin Ligier
 */
public class EmedPadvOkEntryDigest extends EmedPadvEntryDigest {

    /**
     * Proposition of an alternative (drug, dosage, form, etc.) to the original Prescription Item. More than one
     * Prescription Items within the organizer indicate that the original Prescription Item can be changed with the
     * combination of Prescription Items as a whole.
     * <p>
     * This is only set when the PADV OK item targets a prescription item entry. In other cases, it's an immutable empty
     * list.
     */
    @Getter
    private final List<@NonNull EmedPreEntryDigest> recommendedPrescriptions;

    /*
     * Recommended PRE entries
     */

    /**
     * Constructor.
     *
     * @param creationTime          The instant at which the item entry was created.
     * @param documentId            The parent document unique ID.
     * @param documentAuthor        The author of the original parent document.
     * @param sectionAuthor         The author of the original parent section.
     * @param entryId               The item entry ID.
     * @param medicationTreatmentId The ID of the medication treatment this item entry belongs to.
     * @param sequence              The sequence of addition.
     * @param annotationComment     The annotation comment or {@code null} if it isn't provided.
     * @param completed             Whether the PADV status is completed or not.
     * @param effectiveTime         The instant at which the advice becomes effective.
     * @param targetedEntryRef      Reference to the targeted item entry.
     * @param targetedEntryType     Document type of the targeted item entry (MTP, PRE or DIS).
     */
    public EmedPadvOkEntryDigest(final Instant creationTime,
                                 final String documentId,
                                 final AuthorDigest documentAuthor,
                                 final AuthorDigest sectionAuthor,
                                 final String entryId,
                                 final String medicationTreatmentId,
                                 final int sequence,
                                 @Nullable final String annotationComment,
                                 final boolean completed,
                                 final Instant effectiveTime,
                                 final EmedReference targetedEntryRef,
                                 final EmedEntryType targetedEntryType) {
        super(creationTime, documentId, documentAuthor, sectionAuthor, entryId, medicationTreatmentId,  sequence,
                annotationComment, completed, effectiveTime, targetedEntryRef, targetedEntryType);
        if (targetedEntryType == EmedEntryType.PRE) {
            this.recommendedPrescriptions = new ArrayList<>();
        } else {
            this.recommendedPrescriptions = Collections.emptyList(); // Immutable
        }
    }

    /**
     * Returns the type of the PADV item entry digest.
     */
    public PharmaceuticalAdviceStatus getPadvEntryType() {
        return PharmaceuticalAdviceStatus.OK;
    }
}
