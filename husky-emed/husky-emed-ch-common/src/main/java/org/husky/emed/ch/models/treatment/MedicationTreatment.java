/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.ch.models.treatment;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.emed.ch.enums.RouteOfAdministrationAmbu;
import org.husky.emed.ch.enums.TreatmentStatus;
import org.husky.emed.ch.models.common.AuthorDigest;
import org.husky.emed.ch.models.common.EmedReference;
import org.husky.emed.ch.models.common.MedicationDosageInstructions;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * An representation of the state of a medication in the treatment plan at a given time.
 * <p>
 * The medication treatment is constructed with item aggregators. It should not be modified elsewhere, as it requires a
 * lot of business logic.
 * <p>
 * TODO: check all dates: inclusives or exclusives? PRE stop time is exclusive in digest...
 *
 * @author Quentin Ligier
 */
@Data
@EqualsAndHashCode
@RequiredArgsConstructor
public class MedicationTreatment {

    /**
     * The list of 'over-the-counter' dispenses (OTC, without prescription).
     */
    protected final List<@NonNull MedicationDispense> otcDispenses = new ArrayList<>(0);

    /**
     * The list of prescriptions.
     */
    protected final List<@NonNull MedicationPrescription> prescriptions = new ArrayList<>(0);

    /**
     * The annotation comment or {@code null} if it isn't provided.
     *
     * TODO: Do not use yet, use case is unclear. May be deleted soon.
     */
    @Nullable
    protected String annotationComment;

    /**
     * All comments that have been made about the treatment.
     */
    protected final List<@NonNull MedicationTreatmentComment> comments = new ArrayList<>(0);

    /**
     * Number of dispense repeats/refills (excluding the initial dispense). {@code null} means no limitation.
     */
    @Nullable
    protected Integer dispenseRepeatNumber = null;

    /**
     * The dosage instructions.
     */
    protected MedicationDosageInstructions dosageInstructions;

    /**
     * The fulfilment instructions or {@code null} if it isn't provided.
     */
    @Nullable
    protected String fulfilmentInstructions;

    /**
     * The medication treatment ID.
     */
    protected UUID id;

    /**
     * Whether the treatment is to be taken regularly ({@code false}) or only if required ({@code true}).
     */
    private boolean inReserve;

    /**
     * The author of the last item entry (of any kind) in this treatment. This is the last intervening.
     */
    @Nullable
    protected AuthorDigest lastInterveningAuthor;

    /**
     * The author of the last item entry (of type MTP, PRE, or any type of PADV except COMMENT that apply to an MTP
     * or PRE) in this treatment. This is the last "medical" participant.
     */
    @Nullable
    protected AuthorDigest lastMedicalAuthor;

    /**
     * Reference to the MTP item.
     */
    @Nullable
    protected EmedReference mtpReference;

    /**
     * The patient medication instructions or {@code null} if it isn't provided.
     */
    @Nullable
    protected String patientMedicationInstructions;

    /**
     * The medication product.
     */
    protected MedicationProduct product;

    /**
     * The quantity to dispense or {@code null} if it isn't provided.
     */
    @Nullable
    private String quantityToDispense;

    /**
     * The medication route of administration or {@code null} if it's not specified.
     */
    @Nullable
    protected RouteOfAdministrationAmbu routeOfAdministration;

    /**
     * Whether the substitution is permitted (Equivalent) or not (None).
     */
    protected boolean substitutionPermitted;

    /**
     * The treatment reason or {@code null} if it isn't provided.
     */
    @Nullable
    protected String treatmentReason;

    /**
     * The treatment start time (inclusive).
     */
    protected Instant treatmentStartTime;

    /**
     * The actual status of the treatment.
     * <p>
     * TODO: Can it change with the date?
     */
    protected TreatmentStatus treatmentStatus;

    /**
     * The treatment stop time (inclusive). It's the maximum time at which the medication treatment can be valid. If
     * {@code null}, the treatment is active forever (or until stopped).
     */
    @Nullable
    protected Instant treatmentStopTime;

    /**
     * Returns whether the treatment is active now.
     * <p>
     * A medication treatment is active at date D if:
     * <ul>
     * <li>The MTP Item is active, i.e. it started before or at date D and ended after date D;
     * <li>The MTP Item has not been made inactive by a PADV Item.
     * </ul>
     */
    public boolean isTreatmentActive() {
        return this.treatmentStatus == TreatmentStatus.ACTIVE
                && !Instant.now().isBefore(this.treatmentStartTime)
                && (this.treatmentStopTime == null || !Instant.now().isAfter(this.treatmentStopTime));
    }

    /**
     * Checks if one of the prescriptions contained in the medication treatment may be ready for validation. The start
     * dates of the treatment and the prescription are not checked because it could be not ready for validation when the
     * status is calculated but effectively ready for validation when the PHARM-1 query comes. The end dates are checked
     * because that could not happen.
     * <p>
     * The result is stored in the Mongo collection to facilitate PHARM-1 query search.
     *
     * @return {@code true} if one of the prescriptions is ready for validation, {@code false} otherwise.
     */
    public boolean mayHavePrescriptionReadyForValidationInTheFuture() {
        return (this.treatmentStopTime == null || !Instant.now().isAfter(this.treatmentStopTime))
                && this.prescriptions.stream().anyMatch(MedicationPrescription::mayBeReadyForValidationInTheFuture);
    }

    /**
     * Checks if one of the prescriptions contained in the medication treatment may be ready for dispense. The start
     * dates of the treatment and the prescription are not checked because it could be not ready for dispense when the
     * status is calculated but effectively ready for dispense when the PHARM-1 query comes. The end dates are checked
     * because that could not happen.
     * <p>
     * The result is stored in the Mongo collection to facilitate PHARM-1 query search.
     *
     * @return {@code true} if one of the prescriptions is ready for dispense, {@code false} otherwise.
     */
    public boolean mayHavePrescriptionReadyForDispenseInTheFuture() {
        return (this.treatmentStopTime == null || !Instant.now().isAfter(this.treatmentStopTime))
                && this.treatmentStatus == TreatmentStatus.ACTIVE
                && this.prescriptions.stream().anyMatch(MedicationPrescription::mayBeReadyForDispenseInTheFuture);
    }

    /**
     * Checks if a prescription contained in this medication treatment is ready for validation now.
     *
     * @param prescription The prescription to check.
     * @return {@code true} if the prescription is ready for validation now, {@code false} otherwise.
     */
    public boolean isPrescriptionReadyForValidation(final MedicationPrescription prescription) {
        return this.isTreatmentActive()
                && prescription.mayBeReadyForValidationInTheFuture()
                && !Instant.now().isBefore(prescription.getStartTime());
    }

    /**
     * Checks if a prescription contained in this medication treatment is ready for dispense now.
     *
     * @param prescription The prescription to check.
     * @return {@code true} if the prescription is ready for validation now, {@code false} otherwise.
     */
    public boolean isPrescriptionReadyForDispense(final MedicationPrescription prescription) {
        return this.isTreatmentActive()
                && prescription.mayBeReadyForDispenseInTheFuture()
                && !Instant.now().isBefore(prescription.getStartTime());
    }

    /**
     * Finds a {@link MedicationPrescription} by its ID.
     *
     * @param prescriptionId The ID of the prescription to find.
     * @return the retrieved entity or {@link Optional#empty()} if none found.
     */
    public Optional<MedicationPrescription> getPrescriptionById(final UUID prescriptionId) {
        return this.prescriptions.stream()
                .filter(prescription -> prescriptionId.equals(prescription.getPreReference().getEntryId()))
                .findAny();
    }

    /**
     * Finds a {@link MedicationDispense} by its ID.
     *
     * @param dispenseId The ID of the dispense to find.
     * @return the retrieved entity or {@link Optional#empty()} if none found.
     */
    public Optional<MedicationDispense> getDispenseById(final UUID dispenseId) {
        for (final MedicationDispense dispense : this.otcDispenses) {
            if (dispenseId.equals(dispense.getItemId())) {
                return Optional.of(dispense);
            }
        }
        for (final MedicationPrescription prescription : this.prescriptions) {
            for (final MedicationDispense dispense : prescription.getDispenses()) {
                if (dispenseId.equals(dispense.getItemId())) {
                    return Optional.of(dispense);
                }
            }
        }
        return Optional.empty();
    }
}
