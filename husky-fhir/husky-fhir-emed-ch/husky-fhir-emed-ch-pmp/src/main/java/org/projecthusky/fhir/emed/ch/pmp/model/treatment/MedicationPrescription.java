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
package org.projecthusky.fhir.emed.ch.pmp.model.treatment;

import org.projecthusky.fhir.emed.ch.pmp.model.entry.EmedPreEntryDigest;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.emed.ch.enums.DispenseSupplyType;
import org.projecthusky.emed.ch.enums.PrescriptionStatus;
import org.projecthusky.fhir.emed.ch.pmp.model.common.EmedReference;
import org.projecthusky.fhir.emed.ch.pmp.model.common.QuantityWithRegularUnit;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * A data structure that represents a medication prescription. Contrary to a {@link
 * EmedPreEntryDigest}, it contains the full state of the prescription (i.e the initial PRE
 * item and all PADV items that have been aggregated).
 *
 * @author Quentin Ligier
 */
@Data
@NoArgsConstructor
public class MedicationPrescription {

    /**
     * The list of 'over-the-counter' dispenses (OTC, without prescription).
     */
    private final List<MedicationDispense> dispenses = new ArrayList<>(0);

    /**
     * Number of dispense repeats/refills (excluding the initial dispense). {@code null} means no limitation.
     */
    @Nullable
    private Integer dispenseRepeatNumber = null;

    /**
     * Reference to the PRE items.
     */
    @Nullable
    private EmedReference preReference;

    /**
     * The status of the prescription.
     */
    private PrescriptionStatus prescriptionStatus;

    /**
     * The quantity to dispense or {@code null} if it isn't provided.
     */
    @Nullable
    private QuantityWithRegularUnit quantityToDispense;

    /**
     * PRE item start time.
     */
    private Instant startTime;

    /**
     * PRE item stop time.
     */
    @Nullable
    private Instant stopTime;

    /**
     * Whether the substitution is permitted (Equivalent) or not (None).
     */
    private boolean substitutionPermitted;

    /**
     * Returns whether the prescription may be dispensed again.
     */
    private boolean isDispenseCompleted() {
        for (final MedicationDispense dispense : this.dispenses) {
            if (dispense.getDispenseType() == DispenseSupplyType.FIRST_FILL_COMPLETE
                    || dispense.getDispenseType() == DispenseSupplyType.REFILL_COMPLETE
            ) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the prescription may be ready for validation now or in the future. It ignores the status and the start
     * date of the treatment (because it's not accessible from here) and the prescription start date (because it could
     * be too soon when saving the medication treatment, but effectively ready for validation when the PHARM-1 query
     * comes). The prescription end date is checked because it may not be ready for validation anymore after that date.
     *
     * @return {@code true} if the prescription may be ready for validation, {@code false} otherwise.
     */
    public boolean mayBeReadyForValidationInTheFuture() {
        return (this.prescriptionStatus == PrescriptionStatus.PROVISIONAL || this.prescriptionStatus == PrescriptionStatus.SUBMITTED)
                && (this.stopTime == null || !Instant.now().isAfter(this.stopTime));
    }

    /**
     * Checks if the prescription may be ready for dispense now or in the future. It ignores the status and the start
     * date of the treatment (because it's not accessible from here) and the prescription start date (because it could
     * be too soon when saving the medication treatment, but effectively ready for dispense when the PHARM-1 query
     * comes). The prescription end date is checked because it may not be ready for dispense anymore after that date.
     *
     * @return {@code true} if the prescription may be ready for dispense, {@code false} otherwise.
     */
    public boolean mayBeReadyForDispenseInTheFuture() {
        return this.prescriptionStatus == PrescriptionStatus.ACTIVE &&
                (this.stopTime == null || !Instant.now().isAfter(this.stopTime));
    }
}
