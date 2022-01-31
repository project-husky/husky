/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.ch.models.entry;

import lombok.Getter;
import lombok.Setter;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.emed.ch.enums.ActSubstanceAdminSubstitutionCode;
import org.husky.emed.ch.enums.DispenseSupplyType;
import org.husky.emed.ch.enums.EmedEntryType;
import org.husky.emed.ch.models.common.AuthorDigest;
import org.husky.emed.ch.models.common.EmedReference;
import org.husky.emed.ch.models.common.Quantity;
import org.husky.emed.ch.models.treatment.MedicationProduct;

import java.time.Instant;
import java.util.Objects;

/**
 * Represents the digest of an eMed DIS document item entry.
 *
 * @author Quentin Ligier
 */
@Getter
@Setter
public class EmedDisEntryDigest extends EmedEntryDigest {

    /**
     * The dispense type (first fill or refill, complete or partial).
     */
    private DispenseSupplyType dispenseType;

    /**
     * The fulfilment notes or {@code null} if it isn't provided.
     */
    @Nullable
    private String fulfilmentNotes;

    /**
     * The targeted MTP entry reference or {@code null}.
     */
    @Nullable
    private EmedReference mtpEntryRef;

    /**
     * Whether the dispense is an over-the-counter (OTC) dispense (targeting the MTP) or a regular one (targeting a
     * PRE).
     */
    private boolean otc;

    /**
     * The patient medication instructions or {@code null} if it isn't provided.
     */
    @Nullable
    private String patientMedicationInstructions;

    /**
     * The targeted PRE entry reference or {@code null} if it's an over-the-counter dispense.
     */
    @Nullable
    private EmedReference preEntryRef;

    /**
     * The dispensed medication product.
     */
    private MedicationProduct product;

    /**
     * The dispensed medication quantity.
     */
    private Quantity quantity;

    /**
     * The substitution act or {@code null} if it's not given.
     */
    @Nullable
    private ActSubstanceAdminSubstitutionCode substitutionAct;

    /**
     * Constructor.
     *
     * @param creationTime                  The instant at which the item entry was created.
     * @param documentId                    The parent document unique ID.
     * @param documentAuthor                The author of the original parent document or {@code null} if they're not
     *                                      known.
     * @param sectionAuthor                 The author of the original parent section or {@code null} if they're not
     *                                      known.
     * @param entryId                       The item entry ID.
     * @param medicationTreatmentId         The ID of the medication treatment this item entry belongs to.
     * @param sequence                      The sequence of addition.
     * @param annotationComment             The annotation comment or {@code null} if it isn't provided.
     * @param dispenseType                  The dispense type (first fill or refill, complete or partial).
     * @param otc                           Whether the dispense is an over-the-counter (OTC) dispense (targeting the
     *                                      MTP) or a regular one (targeting a PRE).
     * @param mtpEntryRef                   The targeted MTP entry reference or {@code null}.
     * @param preEntryRef                   The targeted PRE entry reference or {@code null} if it's an over-the-counter
     *                                      dispense.
     * @param product                       The dispensed medication product.
     * @param quantity                      The dispensed medication quantity.
     * @param substitutionAct               The substitution act or {@code null} if it's not given.
     * @param patientMedicationInstructions The patient medication instructions or {@code null} if it isn't provided.
     * @param fulfilmentNotes               The fulfilment notes or {@code null} if it isn't provided.
     */
    public EmedDisEntryDigest(final Instant creationTime,
                              final String documentId,
                              @Nullable final AuthorDigest documentAuthor,
                              @Nullable final AuthorDigest sectionAuthor,
                              final String entryId,
                              final String medicationTreatmentId,
                              final int sequence,
                              @Nullable final String annotationComment,
                              final DispenseSupplyType dispenseType,
                              final boolean otc,
                              @Nullable final EmedReference mtpEntryRef,
                              @Nullable final EmedReference preEntryRef,
                              final MedicationProduct product,
                              final Quantity quantity,
                              @Nullable final ActSubstanceAdminSubstitutionCode substitutionAct,
                              @Nullable final String patientMedicationInstructions,
                              @Nullable final String fulfilmentNotes) {
        super(creationTime, documentId, documentAuthor, sectionAuthor, entryId, medicationTreatmentId, sequence,
                annotationComment);
        this.dispenseType = Objects.requireNonNull(dispenseType);
        this.otc = otc;
        this.mtpEntryRef = mtpEntryRef;
        this.preEntryRef = preEntryRef;
        this.product = Objects.requireNonNull(product);
        this.quantity = Objects.requireNonNull(quantity);
        this.substitutionAct = substitutionAct;
        this.patientMedicationInstructions = patientMedicationInstructions;
        this.fulfilmentNotes = fulfilmentNotes;
    }

    /**
     * Returns the non-null type of the item entry digest.
     */
    public EmedEntryType getEmedEntryType() {
        return EmedEntryType.DIS;
    }
}
