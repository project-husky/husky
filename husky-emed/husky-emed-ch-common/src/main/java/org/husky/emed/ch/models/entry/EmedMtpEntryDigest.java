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
import org.husky.emed.ch.enums.EmedEntryType;
import org.husky.emed.ch.enums.RouteOfAdministrationAmbu;
import org.husky.emed.ch.errors.InvalidEmedContentException;
import org.husky.emed.ch.models.common.AuthorDigest;
import org.husky.emed.ch.models.common.EmedReference;
import org.husky.emed.ch.models.common.MedicationDosageInstructions;
import org.husky.emed.ch.models.common.QuantityWithRegularUnit;
import org.husky.emed.ch.models.treatment.MedicationProduct;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

/**
 * Represents the digest of an eMed MTP document item entry.
 *
 * @author Quentin Ligier
 */
public class EmedMtpEntryDigest extends EmedEntryDigest {

    /**
     * The dosage instructions.
     */
    private MedicationDosageInstructions dosageInstructions;

    /**
     * The fulfilment instructions or {@code null} if it isn't provided.
     */
    @Nullable
    private String fulfilmentInstructions;

    /**
     * Whether the treatment is to be taken regularly ({@code false}) or only if required ({@code true}).
     */
    private boolean inReserve;

    /**
     * The reference to the original MTP entry if this one is consolidated (i.e. part of a PMLC document instead of an
     * MTP one).
     */
    @Nullable
    private EmedReference originalMtpReference;

    /**
     * The patient medication instructions or {@code null} if it isn't provided.
     */
    @Nullable
    private String patientMedicationInstructions;

    /**
     * The medication product.
     */
    private MedicationProduct product;

    /**
     * Number of repeats/refills (excluding the initial dispense). It's a non-zero integer if it's limited, it's zero if
     * no repeat/refill is authorized and {@code null} if unlimited repeats/refills are authorized.
     */
    @Nullable
    private Integer repeatNumber;

    /**
     * The medication route of administration or {@code null} if it's not specified.
     */
    @Nullable
    private RouteOfAdministrationAmbu routeOfAdministration;

    /**
     * The lower bound of the planned item validity period.
     */
    private Instant plannedItemValidityStart;

    /**
     * The higher bound of the planned item validity period or {@code null} if it's not bounded.
     */
    @Nullable
    private Instant plannedItemValidityStop;

    /**
     * The quantity to dispense or {@code null} if it isn't provided.
     */
    @Nullable
    private QuantityWithRegularUnit quantityToDispense;

    /**
     * Whether the substitution is permitted (Equivalent) or not (None).
     */
    private boolean substitutionPermitted;

    /**
     * The treatment reason or {@code null} if it isn't provided.
     */
    @Nullable
    private String treatmentReason;

    /**
     * Constructor.
     *
     * @param planningTime                  The planning time.
     * @param documentId                    The parent document unique ID.
     * @param documentAuthor                The author of the original parent document or {@code null} if they're not
     *                                      known.
     * @param sectionAuthor                 The author of the original parent section or {@code null} if they're not
     *                                      known.
     * @param entryId                       The item entry ID.
     * @param medicationTreatmentId         The ID of the medication treatment this item entry belongs to.
     * @param sequence                      The sequence of addition.
     * @param annotationComment             The annotation comment or {@code null} if it isn't provided.
     * @param dosageInstructions            The dosage instructions.
     * @param product                       The medication product.
     * @param repeatNumber                  Number of repeats/refills (excluding the initial dispense). It's a non-zero
     *                                      integer if it's limited, it's zero if no repeat/refill is authorized and
     *                                      {@code null} if unlimited repeats/refills are authorized.
     * @param routeOfAdministration         The medication route of administration or {@code null} if it's not
     *                                      specified.
     * @param plannedItemValidityStart      The lower bound of the planned item validity period.
     * @param plannedItemValidityStop       The higher bound of the planned item validity period or {@code null} if it's
     *                                      not bounded.
     * @param substitutionPermitted         Whether the substitution is permitted (Equivalent) or not (None).
     * @param originalMtpReference          The reference to the original MTP entry if this one is consolidated.
     * @param treatmentReason               The treatment reason or {@code null} if it isn't provided.
     * @param patientMedicationInstructions The patient medication instructions or {@code null} if it isn't provided.
     * @param fulfilmentInstructions        The fulfilment instructions or {@code null} if it isn't provided.
     * @param inReserve                     Whether the treatment is to be taken regularly ({@code false}) or only if
     *                                      required ({@code true}).
     * @param quantityToDispense            The quantity to dispense or {@code null} if it isn't provided.
     * @throws InvalidEmedContentException if plannedItemValidityStop is before plannedItemValidityStart.
     */
    public EmedMtpEntryDigest(final Instant planningTime,
                              final UUID documentId,
                              @Nullable final AuthorDigest documentAuthor,
                              @Nullable final AuthorDigest sectionAuthor,
                              final UUID entryId,
                              final UUID medicationTreatmentId,
                              final int sequence,
                              @Nullable final String annotationComment,
                              final MedicationDosageInstructions dosageInstructions,
                              final MedicationProduct product,
                              @Nullable final Integer repeatNumber,
                              @Nullable final RouteOfAdministrationAmbu routeOfAdministration,
                              final Instant plannedItemValidityStart,
                              @Nullable final Instant plannedItemValidityStop,
                              final boolean substitutionPermitted,
                              @Nullable final EmedReference originalMtpReference,
                              @Nullable final String treatmentReason,
                              @Nullable final String patientMedicationInstructions,
                              @Nullable final String fulfilmentInstructions,
                              final boolean inReserve,
                              @Nullable final QuantityWithRegularUnit quantityToDispense) {
        super(planningTime, documentId, documentAuthor, sectionAuthor, entryId, medicationTreatmentId, sequence,
                annotationComment);
        this.dosageInstructions = Objects.requireNonNull(dosageInstructions);
        this.product = Objects.requireNonNull(product);
        this.routeOfAdministration = routeOfAdministration;
        this.repeatNumber = repeatNumber;
        this.plannedItemValidityStart = Objects.requireNonNull(plannedItemValidityStart);
        this.plannedItemValidityStop = plannedItemValidityStop;
        this.substitutionPermitted = substitutionPermitted;
        this.originalMtpReference = originalMtpReference;
        this.treatmentReason = treatmentReason;
        this.patientMedicationInstructions = patientMedicationInstructions;
        this.fulfilmentInstructions = fulfilmentInstructions;
        this.inReserve = inReserve;
        this.quantityToDispense = quantityToDispense;
        if (this.plannedItemValidityStop != null && this.plannedItemValidityStop.isBefore(this.plannedItemValidityStart)) {
            throw new InvalidEmedContentException("The planned item validity shall be a valid interval");
        }
    }

    /**
     * Checks whether the MTP entry is consolidated or not.
     *
     * @return {@code true} if the MTP entry is consolidated.
     */
    public boolean isConsolidatedEntry() {
        return this.originalMtpReference != null;
    }

    /**
     * Returns the non-null type of the item entry digest.
     */
    public EmedEntryType getEmedEntryType() {
        return EmedEntryType.MTP;
    }

    public Instant getPlanningTime() {
        return this.itemTime;
    }

    public void setPlanningTime(final Instant planningTime) {
        this.itemTime = Objects.requireNonNull(planningTime);
    }

    public MedicationDosageInstructions getDosageInstructions() {
        return this.dosageInstructions;
    }

    public void setDosageInstructions(final MedicationDosageInstructions dosageInstructions) {
        this.dosageInstructions = dosageInstructions;
    }

    @Nullable
    public String getFulfilmentInstructions() {
        return this.fulfilmentInstructions;
    }

    public void setFulfilmentInstructions(@Nullable final String fulfilmentInstructions) {
        this.fulfilmentInstructions = fulfilmentInstructions;
    }

    @Nullable
    public EmedReference getOriginalMtpReference() {
        return this.originalMtpReference;
    }

    public void setOriginalMtpReference(@Nullable final EmedReference originalMtpReference) {
        this.originalMtpReference = originalMtpReference;
    }

    @Nullable
    public String getPatientMedicationInstructions() {
        return this.patientMedicationInstructions;
    }

    public void setPatientMedicationInstructions(@Nullable final String patientMedicationInstructions) {
        this.patientMedicationInstructions = patientMedicationInstructions;
    }

    public MedicationProduct getProduct() {
        return this.product;
    }

    public void setProduct(final MedicationProduct product) {
        this.product = product;
    }

    @Nullable
    public Integer getRepeatNumber() {
        return this.repeatNumber;
    }

    public void setRepeatNumber(@Nullable final Integer repeatNumber) {
        this.repeatNumber = repeatNumber;
    }

    @Nullable
    public RouteOfAdministrationAmbu getRouteOfAdministration() {
        return this.routeOfAdministration;
    }

    public void setRouteOfAdministration(@Nullable final RouteOfAdministrationAmbu routeOfAdministration) {
        this.routeOfAdministration = routeOfAdministration;
    }

    public Instant getPlannedItemValidityStart() {
        return this.plannedItemValidityStart;
    }

    public void setPlannedItemValidityStart(final Instant plannedItemValidityStart) {
        this.plannedItemValidityStart = plannedItemValidityStart;
    }

    @Nullable
    public Instant getPlannedItemValidityStop() {
        return this.plannedItemValidityStop;
    }

    public void setPlannedItemValidityStop(@Nullable final Instant plannedItemValidityStop) {
        this.plannedItemValidityStop = plannedItemValidityStop;
    }

    public boolean isSubstitutionPermitted() {
        return this.substitutionPermitted;
    }

    public void setSubstitutionPermitted(final boolean substitutionPermitted) {
        this.substitutionPermitted = substitutionPermitted;
    }

    @Nullable
    public String getTreatmentReason() {
        return this.treatmentReason;
    }

    public void setTreatmentReason(@Nullable final String treatmentReason) {
        this.treatmentReason = treatmentReason;
    }

    public boolean isInReserve() {
        return this.inReserve;
    }

    public void setInReserve(final boolean inReserve) {
        this.inReserve = inReserve;
    }

    @Nullable
    public QuantityWithRegularUnit getQuantityToDispense() {
        return this.quantityToDispense;
    }

    public void setQuantityToDispense(@Nullable final QuantityWithRegularUnit quantityToDispense) {
        this.quantityToDispense = quantityToDispense;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof final EmedMtpEntryDigest that)) return false;
        if (!super.equals(o)) return false;
        return inReserve == that.inReserve
                && substitutionPermitted == that.substitutionPermitted
                && Objects.equals(dosageInstructions, that.dosageInstructions)
                && Objects.equals(fulfilmentInstructions, that.fulfilmentInstructions)
                && Objects.equals(originalMtpReference, that.originalMtpReference)
                && Objects.equals(patientMedicationInstructions, that.patientMedicationInstructions)
                && Objects.equals(product, that.product)
                && Objects.equals(repeatNumber, that.repeatNumber)
                && routeOfAdministration == that.routeOfAdministration
                && Objects.equals(plannedItemValidityStart, that.plannedItemValidityStart)
                && Objects.equals(plannedItemValidityStop, that.plannedItemValidityStop)
                && Objects.equals(quantityToDispense, that.quantityToDispense)
                && Objects.equals(treatmentReason, that.treatmentReason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), dosageInstructions, fulfilmentInstructions, inReserve, originalMtpReference, patientMedicationInstructions, product, repeatNumber, routeOfAdministration, plannedItemValidityStart, plannedItemValidityStop, quantityToDispense, substitutionPermitted, treatmentReason);
    }

    @Override
    public String toString() {
        return "EmedMtpEntryDigest{" +
                "annotationComment='" + this.annotationComment + '\'' +
                ", itemTime=" + this.itemTime +
                ", documentAuthor=" + this.documentAuthor +
                ", documentId='" + this.documentId + '\'' +
                ", entryId='" + this.entryId + '\'' +
                ", medicationTreatmentId='" + this.medicationTreatmentId + '\'' +
                ", sectionAuthor=" + this.sectionAuthor +
                ", sequence=" + this.sequence +
                ", dosageInstructions=" + this.dosageInstructions +
                ", fulfilmentInstructions='" + this.fulfilmentInstructions + '\'' +
                ", inReserve=" + this.inReserve +
                ", originalMtpReference=" + this.originalMtpReference +
                ", patientMedicationInstructions='" + this.patientMedicationInstructions + '\'' +
                ", product=" + this.product +
                ", repeatNumber=" + this.repeatNumber +
                ", routeOfAdministration=" + this.routeOfAdministration +
                ", plannedItemValidityStart=" + this.plannedItemValidityStart +
                ", plannedItemValidityStop=" + this.plannedItemValidityStop +
                ", quantityToDispense=" + this.quantityToDispense +
                ", substitutionPermitted=" + this.substitutionPermitted +
                ", treatmentReason='" + this.treatmentReason + '\'' +
                '}';
    }
}
