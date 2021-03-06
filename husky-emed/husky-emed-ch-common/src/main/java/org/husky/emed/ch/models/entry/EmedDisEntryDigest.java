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

import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.emed.ch.enums.DispenseSupplyType;
import org.husky.emed.ch.enums.EmedEntryType;
import org.husky.emed.ch.models.common.AuthorDigest;
import org.husky.emed.ch.models.common.EmedReference;
import org.husky.emed.ch.models.common.MedicationDosageInstructions;
import org.husky.emed.ch.models.common.Quantity;
import org.husky.emed.ch.models.treatment.MedicationProduct;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

/**
 * Represents the digest of an eMed DIS document item entry.
 *
 * @author Quentin Ligier
 */
public class EmedDisEntryDigest extends EmedEntryDigest {

    /**
     * The dispense type (first fill or refill, complete or partial).
     */
    private DispenseSupplyType dispenseType;

    /**
     * The changed dosage instructions or {@code null} if they haven't changed.
     */
    @Nullable
    private MedicationDosageInstructions dosageInstructions;

    /**
     * The fulfilment notes or {@code null} if it isn't provided.
     */
    @Nullable
    private String fulfilmentNotes;

    /**
     * Whether the treatment is to be taken regularly ({@code false}) or only if required ({@code true}).
     */
    private boolean inReserve;

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
     * Constructor.
     *
     * @param dispenseTime                  The dispense time.
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
     * @param patientMedicationInstructions The patient medication instructions or {@code null} if it isn't provided.
     * @param fulfilmentNotes               The fulfilment notes or {@code null} if it isn't provided.
     * @param inReserve                     Whether the treatment is to be taken regularly ({@code false}) or only if
     *                                      required ({@code true}).
     * @param dosageInstructions            The changed dosage instructions or {@code null} if they haven't changed.
     */
    public EmedDisEntryDigest(final Instant dispenseTime,
                              final UUID documentId,
                              @Nullable final AuthorDigest documentAuthor,
                              @Nullable final AuthorDigest sectionAuthor,
                              final UUID entryId,
                              final UUID medicationTreatmentId,
                              final int sequence,
                              @Nullable final String annotationComment,
                              final DispenseSupplyType dispenseType,
                              final boolean otc,
                              @Nullable final EmedReference mtpEntryRef,
                              @Nullable final EmedReference preEntryRef,
                              final MedicationProduct product,
                              final Quantity quantity,
                              @Nullable final String patientMedicationInstructions,
                              @Nullable final String fulfilmentNotes,
                              final boolean inReserve,
                              @Nullable final MedicationDosageInstructions dosageInstructions) {
        super(dispenseTime, documentId, documentAuthor, sectionAuthor, entryId, medicationTreatmentId, sequence,
                annotationComment);
        this.dispenseType = Objects.requireNonNull(dispenseType);
        this.otc = otc;
        this.mtpEntryRef = mtpEntryRef;
        this.preEntryRef = preEntryRef;
        this.product = Objects.requireNonNull(product);
        this.quantity = Objects.requireNonNull(quantity);
        this.patientMedicationInstructions = patientMedicationInstructions;
        this.fulfilmentNotes = fulfilmentNotes;
        this.inReserve = inReserve;
        this.dosageInstructions = dosageInstructions;
    }

    /**
     * Returns the non-null type of the item entry digest.
     */
    public EmedEntryType getEmedEntryType() {
        return EmedEntryType.DIS;
    }

    public Instant getDispenseTime() {
        return this.itemTime;
    }

    public void setDispenseTime(final Instant dispenseTime) {
        this.itemTime = Objects.requireNonNull(dispenseTime);
    }

    public DispenseSupplyType getDispenseType() {
        return this.dispenseType;
    }

    public void setDispenseType(final DispenseSupplyType dispenseType) {
        this.dispenseType = dispenseType;
    }

    @Nullable
    public String getFulfilmentNotes() {
        return this.fulfilmentNotes;
    }

    public void setFulfilmentNotes(@Nullable final String fulfilmentNotes) {
        this.fulfilmentNotes = fulfilmentNotes;
    }

    @Nullable
    public EmedReference getMtpEntryRef() {
        return this.mtpEntryRef;
    }

    public void setMtpEntryRef(@Nullable final EmedReference mtpEntryRef) {
        this.mtpEntryRef = mtpEntryRef;
    }

    public boolean isOtc() {
        return this.otc;
    }

    public void setOtc(final boolean otc) {
        this.otc = otc;
    }

    @Nullable
    public String getPatientMedicationInstructions() {
        return this.patientMedicationInstructions;
    }

    public void setPatientMedicationInstructions(@Nullable final String patientMedicationInstructions) {
        this.patientMedicationInstructions = patientMedicationInstructions;
    }

    @Nullable
    public EmedReference getPreEntryRef() {
        return this.preEntryRef;
    }

    public void setPreEntryRef(@Nullable final EmedReference preEntryRef) {
        this.preEntryRef = preEntryRef;
    }

    public MedicationProduct getProduct() {
        return this.product;
    }

    public void setProduct(final MedicationProduct product) {
        this.product = product;
    }

    public Quantity getQuantity() {
        return this.quantity;
    }

    public void setQuantity(final Quantity quantity) {
        this.quantity = quantity;
    }

    public boolean isInReserve() {
        return this.inReserve;
    }

    public void setInReserve(final boolean inReserve) {
        this.inReserve = inReserve;
    }

    @Nullable
    public MedicationDosageInstructions getDosageInstructions() {
        return this.dosageInstructions;
    }

    public void setDosageInstructions(@Nullable final MedicationDosageInstructions dosageInstructions) {
        this.dosageInstructions = dosageInstructions;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof final EmedDisEntryDigest that)) return false;
        if (!super.equals(o)) return false;
        return inReserve == that.inReserve
                && otc == that.otc
                && dispenseType == that.dispenseType
                && Objects.equals(dosageInstructions, that.dosageInstructions)
                && Objects.equals(fulfilmentNotes, that.fulfilmentNotes)
                && Objects.equals(mtpEntryRef, that.mtpEntryRef)
                && Objects.equals(patientMedicationInstructions, that.patientMedicationInstructions)
                && Objects.equals(preEntryRef, that.preEntryRef)
                && Objects.equals(product, that.product)
                && Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), dispenseType, dosageInstructions, fulfilmentNotes, inReserve, mtpEntryRef, otc, patientMedicationInstructions, preEntryRef, product, quantity);
    }

    @Override
    public String toString() {
        return "EmedDisEntryDigest{" +
                "annotationComment='" + this.annotationComment + '\'' +
                ", itemTime=" + this.itemTime +
                ", documentAuthor=" + this.documentAuthor +
                ", documentId='" + this.documentId + '\'' +
                ", entryId='" + this.entryId + '\'' +
                ", medicationTreatmentId='" + this.medicationTreatmentId + '\'' +
                ", sectionAuthor=" + this.sectionAuthor +
                ", sequence=" + this.sequence +
                ", dispenseType=" + this.dispenseType +
                ", dosageInstructions=" + this.dosageInstructions +
                ", fulfilmentNotes='" + this.fulfilmentNotes + '\'' +
                ", inReserve=" + this.inReserve +
                ", mtpEntryRef=" + this.mtpEntryRef +
                ", otc=" + this.otc +
                ", patientMedicationInstructions='" + this.patientMedicationInstructions + '\'' +
                ", preEntryRef=" + this.preEntryRef +
                ", product=" + this.product +
                ", quantity=" + this.quantity +
                '}';
    }
}
