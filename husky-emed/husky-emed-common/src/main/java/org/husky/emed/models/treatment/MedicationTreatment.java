/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.models.treatment;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.emed.enums.ActSubstanceAdminSubstitutionCode;
import org.husky.emed.enums.ChEmedTimingEvent;
import org.husky.emed.enums.RouteOfAdministrationEdqm;
import org.husky.emed.enums.TreatmentStatus;
import org.husky.emed.models.common.EmedReference;
import org.husky.emed.models.common.MedicationDosageInstructions;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
     * The substance substitution permissions, or {@code null} if substitution is authorized without condition.
     */
    private final List<ActSubstanceAdminSubstitutionCode> substitutionPermissions = new ArrayList<>();
    /**
     * The list of prescriptions.
     */
    private final List<MedicationPrescription> prescriptions = new ArrayList<>();
    /**
     * The list of 'over-the-counter' dispenses (OTC, without prescription).
     */
    private final List<MedicationDispense> otcDispenses = new ArrayList<>();
    /**
     * Multiple events within a day with the same dosage, or an empty list if it's not specified.
     */
    private final List<ChEmedTimingEvent> timingEvents = new ArrayList<>();
    /**
     * The medication treatment ID.
     */
    private String id;
    /**
     * Reference to the MTP item.
     */
    @Nullable
    private EmedReference mtpReference;
    /**
     * The MTP and treatment starting time.
     */
    private Instant treatmentStartTime;
    /**
     * The MTP planned stop time. It's the maximum time at which the medication treatment can be valid, but it may
     * already be stopped by a PADV CANCEL or REFUSE item.
     *
     * @see #treatmentStopTime
     */
    @Nullable
    private Instant mtpStopTime;
    /**
     * The treatment stop time. By default, it's equal to the {@code mtpStopTime}. It can be then moved sooner if a PADV
     * CANCEL or REFUSE targets the MTP.
     *
     * @see #mtpStopTime
     */
    @Nullable
    private Instant treatmentStopTime;
    /**
     * The actual status of the treatment.
     * <p>
     * TODO: Can it change with the date?
     */
    private TreatmentStatus treatmentStatus;
    /**
     * Number of dispense repeats/refills (excluding the initial dispense). {@code null} means no limitation.
     */
    @Nullable
    private Integer dispenseRepeatNumber = null;
    /**
     * The medication product.
     */
    private MedicationProduct product;
    /**
     * The medication route of administration or {@code null} if it's not specified.
     */
    @Nullable
    private RouteOfAdministrationEdqm routeOfAdministration;
    /**
     * The dosage instructions.
     */
    @NonNull
    private MedicationDosageInstructions dosageInstructions;

    /**
     * Returns whether the treatment is active now.
     * <p>
     * A medication treatment is active at date D if:
     * <li>The MTP Item is active, i.e. it started before or at date D and ended after date D;
     * <li>The MTP Item has not been made inactive by a PADV Item.
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
    public Optional<MedicationPrescription> getPrescriptionById(final String prescriptionId) {
        return this.prescriptions.stream()
                .filter(prescription -> prescriptionId.equals(prescription.getPreReference().getItemId()))
                .findAny();
    }

    /**
     * Finds a {@link MedicationDispense} by its ID.
     *
     * @param dispenseId The ID of the dispense to find.
     * @return the retrieved entity or {@link Optional#empty()} if none found.
     */
    public Optional<MedicationDispense> getDispenseById(final String dispenseId) {
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

    /**
     * Returns the dosage type.
     * TODO: useful?
     *
     public DosageType getDosageType() {
     if (!this.dosageInstructions.isEmpty()) {
     return DosageType.Split;
     } else {
     return DosageType.Normal;
     }
     }*/
}
