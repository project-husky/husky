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
import org.husky.emed.ch.enums.EmedEntryType;
import org.husky.emed.ch.enums.RouteOfAdministrationAmbu;
import org.husky.emed.ch.errors.InvalidEmedContentException;
import org.husky.emed.ch.models.common.*;
import org.husky.emed.ch.models.treatment.MedicationProduct;

import java.time.Instant;
import java.util.Objects;

/**
 * Represents the digest of an eMed PRE document item entry.
 *
 * @author Quentin Ligier
 */
@Getter
@Setter
public class EmedPreEntryDigest extends EmedEntryDigest {

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
     * The inclusive instant at which the initial treatment shall start.
     */
    private Instant itemValidityStart;

    /**
     * The inclusive instant at which the initial treatment shall stop or {@code null} if it's not bounded.
     */
    @Nullable
    private Instant itemValidityStop;

    /**
     * The reference to the MTP entry, if any.
     */
    @Nullable
    private EmedReference mtpReference;

    /**
     * The patient medication instructions or {@code null} if it isn't provided.
     */
    @Nullable
    private String patientMedicationInstructions;

    /**
     * The inclusive instant at which the prescription shall start.
     */
    private Instant prescriptionDocumentValidityStart;

    /**
     * The inclusive instant at which the prescription shall stop or {@code null} if it's not bounded.
     */
    @Nullable
    private Instant prescriptionDocumentValidityStop;

    /**
     * The prescribed medication product.
     */
    private MedicationProduct product;

    /**
     * Whether this prescription item is provisional or not.
     */
    private boolean provisional;

    /**
     * The quantity to dispense or {@code null} if it isn't provided.
     */
    @Nullable
    private QuantityWithRegularUnit quantityToDispense;

    /**
     * The renewal period or {@code null}. If it's not specified, the renewal period is the prescription validity
     * period. If the lower bound is not specified, the period starts at the first dispense.
     */
    @Nullable
    private RenewalInterval renewalPeriod;

    /**
     * Number of repeats/refills (excluding the initial dispense). It's a non-zero integer if it's limited, it's zero if
     * no repeat/refill is authorized and {@code null} if unlimited repeats/refills are authorized.
     */
    @Nullable
    private Integer repeatNumber;

    /**
     * The medication route of administration, or {@code null} if it's not specified.
     */
    @Nullable
    private RouteOfAdministrationAmbu routeOfAdministration;

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
     * @param prescriptionTime                  The prescription time.
     * @param documentId                        The parent document unique ID.
     * @param documentAuthor                    The author of the original parent document or {@code null} if they're
     *                                          not known.
     * @param sectionAuthor                     The author of the original parent section or {@code null} if they're not
     *                                          known.
     * @param entryId                           The item entry ID.
     * @param medicationTreatmentId             The ID of the medication treatment this item entry belongs to.
     * @param sequence                          The sequence of addition.
     * @param annotationComment                 The annotation comment or {@code null} if it isn't provided.
     * @param dosageInstructions                The dosage instructions.
     * @param product                           The medication product.
     * @param repeatNumber                      Number of repeats/refills (excluding the initial dispense). It's a
     *                                          non-zero integer if it's limited, it's zero if no repeat/refill is
     *                                          authorized and {@code null} if unlimited repeats/refills are
     *                                          authorized.
     * @param routeOfAdministration             The medication route of administration or {@code null} if it's not
     *                                          specified.
     * @param prescriptionDocumentValidityStart The inclusive instant at which the prescription shall start.
     * @param prescriptionDocumentValidityStop  The inclusive instant at which the prescription shall stop or
     *                                          {@code null} if it's not bounded.
     * @param itemValidityStart                 The inclusive instant at which the initial treatment shall start.
     * @param itemValidityStop                  The inclusive instant at which the initial treatment shall stop or
     *                                          {@code null} if it's not bounded.
     * @param renewalPeriod                     The renewal period or {@code null} if it's not specified.
     * @param mtpReference                      The reference to the MTP entry, if any.
     * @param provisional                       Whether this prescription item is provisional or not.
     * @param substitutionPermitted             Whether the substitution is permitted (Equivalent) or not (None).
     * @param treatmentReason                   The treatment reason or {@code null} if it isn't provided.
     * @param patientMedicationInstructions     The patient medication instructions or {@code null} if it isn't
     *                                          provided.
     * @param fulfilmentInstructions            The fulfilment instructions or {@code null} if it isn't provided.
     * @param inReserve                         Whether the treatment is to be taken regularly ({@code false}) or only
     *                                          if required ({@code true}).
     * @param quantityToDispense                The quantity to dispense or {@code null} if it isn't provided.
     * @throws InvalidEmedContentException if the validity periods are invalid.
     */
    public EmedPreEntryDigest(final Instant prescriptionTime,
                              final String documentId,
                              @Nullable final AuthorDigest documentAuthor,
                              @Nullable final AuthorDigest sectionAuthor,
                              final String entryId,
                              final String medicationTreatmentId,
                              final int sequence,
                              @Nullable final String annotationComment,
                              final MedicationDosageInstructions dosageInstructions,
                              final MedicationProduct product,
                              @Nullable final Integer repeatNumber,
                              @Nullable final RouteOfAdministrationAmbu routeOfAdministration,
                              final Instant prescriptionDocumentValidityStart,
                              @Nullable final Instant prescriptionDocumentValidityStop,
                              final Instant itemValidityStart,
                              @Nullable final Instant itemValidityStop,
                              @Nullable final RenewalInterval renewalPeriod,
                              @Nullable final EmedReference mtpReference,
                              final boolean provisional,
                              final boolean substitutionPermitted,
                              @Nullable final String treatmentReason,
                              @Nullable final String patientMedicationInstructions,
                              @Nullable final String fulfilmentInstructions,
                              final boolean inReserve,
                              @Nullable final QuantityWithRegularUnit quantityToDispense) {
        super(prescriptionTime, documentId, documentAuthor, sectionAuthor, entryId, medicationTreatmentId, sequence,
                annotationComment);
        this.dosageInstructions = Objects.requireNonNull(dosageInstructions);
        this.product = Objects.requireNonNull(product);
        this.routeOfAdministration = routeOfAdministration;
        this.repeatNumber = repeatNumber;
        this.prescriptionDocumentValidityStart = Objects.requireNonNull(prescriptionDocumentValidityStart);
        this.prescriptionDocumentValidityStop = prescriptionDocumentValidityStop;
        this.itemValidityStart = Objects.requireNonNull(itemValidityStart);
        this.itemValidityStop = itemValidityStop;
        this.renewalPeriod = renewalPeriod;
        this.mtpReference = mtpReference;
        this.provisional = provisional;
        this.substitutionPermitted = substitutionPermitted;
        this.treatmentReason = treatmentReason;
        this.patientMedicationInstructions = patientMedicationInstructions;
        this.fulfilmentInstructions = fulfilmentInstructions;
        this.inReserve = inReserve;
        this.quantityToDispense = quantityToDispense;
        if (this.prescriptionDocumentValidityStop != null && this.prescriptionDocumentValidityStop.isBefore(this.prescriptionDocumentValidityStart)) {
            throw new InvalidEmedContentException("The prescription document validity period shall be a valid interval");
        }
        if (this.itemValidityStop != null && this.itemValidityStop.isBefore(this.itemValidityStart)) {
            throw new InvalidEmedContentException("The prescription item validity period shall be a valid interval");
        }
        if (this.itemValidityStart.isBefore(this.prescriptionDocumentValidityStart)) {
            throw new InvalidEmedContentException("The item validity period shall not start before the document validity " +
                    "period");
        }
        if (this.prescriptionDocumentValidityStop != null && (this.itemValidityStop == null || this.itemValidityStop.isBefore(this.prescriptionDocumentValidityStop))) {
            throw new InvalidEmedContentException("The item validity period shall not end after the document validity " +
                    "period");
        }
    }

    /**
     * Returns the non-null type of the item entry digest.
     */
    public EmedEntryType getEmedEntryType() {
        return EmedEntryType.PRE;
    }

    public Instant getPrescriptionTime() {
        return this.itemTime;
    }

    public void setPrescriptionTime(final Instant prescriptionTime) {
        this.itemTime = Objects.requireNonNull(prescriptionTime);
    }

    public MedicationDosageInstructions getDosageInstructions() {
        return this.dosageInstructions;
    }

    public void setDosageInstructions(final MedicationDosageInstructions dosageInstructions) {
        this.dosageInstructions = dosageInstructions;
    }

    public String getFulfilmentInstructions() {
        return this.fulfilmentInstructions;
    }

    public void setFulfilmentInstructions(final String fulfilmentInstructions) {
        this.fulfilmentInstructions = fulfilmentInstructions;
    }

    public boolean isInReserve() {
        return this.inReserve;
    }

    public void setInReserve(final boolean inReserve) {
        this.inReserve = inReserve;
    }

    public Instant getItemValidityStart() {
        return this.itemValidityStart;
    }

    public void setItemValidityStart(final Instant itemValidityStart) {
        this.itemValidityStart = itemValidityStart;
    }

    public Instant getItemValidityStop() {
        return this.itemValidityStop;
    }

    public void setItemValidityStop(final Instant itemValidityStop) {
        this.itemValidityStop = itemValidityStop;
    }

    public EmedReference getMtpReference() {
        return this.mtpReference;
    }

    public void setMtpReference(final EmedReference mtpReference) {
        this.mtpReference = mtpReference;
    }

    public String getPatientMedicationInstructions() {
        return this.patientMedicationInstructions;
    }

    public void setPatientMedicationInstructions(final String patientMedicationInstructions) {
        this.patientMedicationInstructions = patientMedicationInstructions;
    }

    public Instant getPrescriptionDocumentValidityStart() {
        return this.prescriptionDocumentValidityStart;
    }

    public void setPrescriptionDocumentValidityStart(final Instant prescriptionDocumentValidityStart) {
        this.prescriptionDocumentValidityStart = prescriptionDocumentValidityStart;
    }

    public Instant getPrescriptionDocumentValidityStop() {
        return this.prescriptionDocumentValidityStop;
    }

    public void setPrescriptionDocumentValidityStop(final Instant prescriptionDocumentValidityStop) {
        this.prescriptionDocumentValidityStop = prescriptionDocumentValidityStop;
    }

    public MedicationProduct getProduct() {
        return this.product;
    }

    public void setProduct(final MedicationProduct product) {
        this.product = product;
    }

    public boolean isProvisional() {
        return this.provisional;
    }

    public void setProvisional(final boolean provisional) {
        this.provisional = provisional;
    }

    public RenewalInterval getRenewalPeriod() {
        return this.renewalPeriod;
    }

    public void setRenewalPeriod(final RenewalInterval renewalPeriod) {
        this.renewalPeriod = renewalPeriod;
    }

    public Integer getRepeatNumber() {
        return this.repeatNumber;
    }

    public void setRepeatNumber(final Integer repeatNumber) {
        this.repeatNumber = repeatNumber;
    }

    public RouteOfAdministrationAmbu getRouteOfAdministration() {
        return this.routeOfAdministration;
    }

    public void setRouteOfAdministration(final RouteOfAdministrationAmbu routeOfAdministration) {
        this.routeOfAdministration = routeOfAdministration;
    }

    public boolean isSubstitutionPermitted() {
        return this.substitutionPermitted;
    }

    public void setSubstitutionPermitted(final boolean substitutionPermitted) {
        this.substitutionPermitted = substitutionPermitted;
    }

    public String getTreatmentReason() {
        return this.treatmentReason;
    }

    public void setTreatmentReason(final String treatmentReason) {
        this.treatmentReason = treatmentReason;
    }

    public QuantityWithRegularUnit getQuantityToDispense() {
        return this.quantityToDispense;
    }

    public void setQuantityToDispense(final QuantityWithRegularUnit quantityToDispense) {
        this.quantityToDispense = quantityToDispense;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof final EmedPreEntryDigest that)) return false;
        if (!super.equals(o)) return false;
        return inReserve == that.inReserve
                && provisional == that.provisional
                && substitutionPermitted == that.substitutionPermitted
                && Objects.equals(dosageInstructions, that.dosageInstructions)
                && Objects.equals(fulfilmentInstructions, that.fulfilmentInstructions)
                && Objects.equals(itemValidityStart, that.itemValidityStart)
                && Objects.equals(itemValidityStop, that.itemValidityStop)
                && Objects.equals(mtpReference, that.mtpReference)
                && Objects.equals(patientMedicationInstructions, that.patientMedicationInstructions)
                && Objects.equals(prescriptionDocumentValidityStart, that.prescriptionDocumentValidityStart)
                && Objects.equals(prescriptionDocumentValidityStop, that.prescriptionDocumentValidityStop)
                && Objects.equals(product, that.product)
                && Objects.equals(quantityToDispense, that.quantityToDispense)
                && Objects.equals(renewalPeriod, that.renewalPeriod)
                && Objects.equals(repeatNumber, that.repeatNumber)
                && routeOfAdministration == that.routeOfAdministration
                && Objects.equals(treatmentReason, that.treatmentReason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), dosageInstructions, fulfilmentInstructions, inReserve,
                itemValidityStart, itemValidityStop, mtpReference, patientMedicationInstructions,
                prescriptionDocumentValidityStart, prescriptionDocumentValidityStop, product, provisional,
                quantityToDispense, renewalPeriod, repeatNumber, routeOfAdministration, substitutionPermitted,
                treatmentReason);
    }

    @Override
    public String toString() {
        return "EmedPreEntryDigest{" +
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
                ", itemValidityStart=" + this.itemValidityStart +
                ", itemValidityStop=" + this.itemValidityStop +
                ", mtpReference=" + this.mtpReference +
                ", patientMedicationInstructions='" + this.patientMedicationInstructions + '\'' +
                ", prescriptionDocumentValidityStart=" + this.prescriptionDocumentValidityStart +
                ", prescriptionDocumentValidityStop=" + this.prescriptionDocumentValidityStop +
                ", product=" + this.product +
                ", provisional=" + this.provisional +
                ", quantityToDispense=" + this.quantityToDispense +
                ", renewalPeriod=" + this.renewalPeriod +
                ", repeatNumber=" + this.repeatNumber +
                ", routeOfAdministration=" + this.routeOfAdministration +
                ", substitutionPermitted=" + this.substitutionPermitted +
                ", treatmentReason='" + this.treatmentReason + '\'' +
                '}';
    }
}
