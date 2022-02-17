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

import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.emed.ch.enums.EmedEntryType;
import org.husky.emed.ch.enums.PharmaceuticalAdviceStatus;
import org.husky.emed.ch.models.common.AuthorDigest;
import org.husky.emed.ch.models.common.EmedReference;
import org.husky.emed.ch.models.common.MedicationDosageInstructions;
import org.husky.emed.ch.models.entry.EmedMtpEntryDigest;
import org.husky.emed.ch.models.entry.EmedPadvEntryDigest;
import org.husky.emed.ch.models.entry.EmedPreEntryDigest;

import java.time.Instant;

/**
 * Represents the digest of an EMED PADV document Change item entry.
 *
 * @author Quentin Ligier
 */
public class EmedPadvChangeEntryDigest extends EmedPadvEntryDigest {

    /**
     * The changed MTP entry, if any. This may only be set when the PADV CHANGE item targets an MTP item entry.
     */
    @Nullable
    private EmedMtpEntryDigest changedMtpEntry;

    /**
     * The changed Prescription Item, if any, which is allowed to be dispensed instead of the original prescribed item.
     */
    @Nullable
    private EmedPreEntryDigest changedPreEntry;

    /**
     * The changed dosage instructions, if any. This may only be set when the PADV CHANGE item targets a dispense item
     * entry.
     */
    @Nullable
    private MedicationDosageInstructions changedDosageInstructions;

    /**
     * Constructor.
     *
     * @param creationTime              The instant at which the item entry was created.
     * @param documentId                The parent document unique ID.
     * @param documentAuthor            The author of the original parent document or {@code null} if they're not
     *                                  known.
     * @param sectionAuthor             The author of the original parent section or {@code null} if they're not known.
     * @param entryId                   The item entry ID.
     * @param medicationTreatmentId     The ID of the medication treatment this item entry belongs to.
     * @param sequence                  The sequence of addition.
     * @param annotationComment         The annotation comment or {@code null} if it isn't provided.
     * @param completed                 Whether the PADV status is completed or not.
     * @param effectiveTime             The instant at which the advice becomes effective.
     * @param targetedEntryRef          Reference to the targeted item entry.
     * @param targetedEntryType         Document type of the targeted item entry (MTP, PRE or DIS).
     * @param changedMtpEntry           The changed MTP entry, if any. This may only be set when the PADV CHANGE item
     *                                  targets an MTP item entry.
     * @param changedPreEntry           The changed Prescription Item, if any, which is allowed to be dispensed instead
     *                                  of the original prescribed item.
     * @param changedDosageInstructions The changed dosage instructions, if any. This may only be set when the PADV
     *                                  CHANGE item targets a dispense * item entry.
     */
    public EmedPadvChangeEntryDigest(final Instant creationTime,
                                     final String documentId,
                                     @Nullable final AuthorDigest documentAuthor,
                                     @Nullable final AuthorDigest sectionAuthor,
                                     final String entryId,
                                     final String medicationTreatmentId,
                                     final int sequence,
                                     @Nullable final String annotationComment,
                                     final boolean completed,
                                     final Instant effectiveTime,
                                     final EmedReference targetedEntryRef,
                                     final EmedEntryType targetedEntryType,
                                     @Nullable final EmedMtpEntryDigest changedMtpEntry,
                                     @Nullable final EmedPreEntryDigest changedPreEntry,
                                     @Nullable final MedicationDosageInstructions changedDosageInstructions) {
        super(creationTime, documentId, documentAuthor, sectionAuthor, entryId, medicationTreatmentId, sequence,
                annotationComment, completed, effectiveTime, targetedEntryRef, targetedEntryType);

        if (changedMtpEntry != null) {
            if (targetedEntryType != EmedEntryType.MTP) {
                throw new IllegalArgumentException("A changed MTP entry can only be added when the PADV CHANGE targets an " +
                        "MTP entry");
            }
            this.changedMtpEntry = changedMtpEntry;
        }

        if (changedPreEntry != null) {
            if (targetedEntryType != EmedEntryType.PRE) {
                throw new IllegalArgumentException("A changed PRE entry can only be added when the PADV CHANGE targets " +
                        "a PRE entry");
            }
            this.changedPreEntry = changedPreEntry;
        }

        if (changedDosageInstructions != null) {
            if (targetedEntryType != EmedEntryType.PRE) {
                throw new IllegalArgumentException("A changed DIS entry can only be added when the PADV CHANGE targets " +
                        "a DIS entry");
            }
            this.changedDosageInstructions = changedDosageInstructions;
        }
    }

    /**
     * Returns the type of the PADV item entry digest.
     */
    public PharmaceuticalAdviceStatus getPadvEntryType() {
        return PharmaceuticalAdviceStatus.CHANGE;
    }

    @Nullable
    public EmedMtpEntryDigest getChangedMtpEntry() {
        return this.changedMtpEntry;
    }

    public void setChangedMtpEntry(final EmedMtpEntryDigest changedMtpEntry) {
        if (this.getTargetedEntryType() != EmedEntryType.MTP) {
            throw new IllegalStateException("A changed MTP entry can only be added when the PADV CHANGE targets an " +
                    "MTP entry");
        }
        this.changedMtpEntry = changedMtpEntry;
    }

    @Nullable
    public EmedPreEntryDigest getChangedPreEntry() {
        return this.changedPreEntry;
    }

    @Nullable
    public MedicationDosageInstructions getChangedDosageInstructions() {
        return this.changedDosageInstructions;
    }

    public void setChangedDosageInstructions(final MedicationDosageInstructions changedDosageInstructions) {
        if (this.getTargetedEntryType() != EmedEntryType.DIS) {
            throw new IllegalStateException("A changed dosage instructions can only be added when the PADV CHANGE " +
                    "targets a DIS entry");
        }
        this.changedDosageInstructions = changedDosageInstructions;
    }
}
