package org.husky.emed.cda.models.treatment;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.emed.cda.enums.PrescriptionStatus;
import org.husky.emed.cda.generated.artdecor.enums.ActSubstanceAdminSubstitutionCode;
import org.husky.emed.cda.generated.artdecor.enums.DispenseSupplyType;
import org.husky.emed.cda.models.common.EmedReference;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * A data structure that represents a medication prescription. Contrary to a {@link EmedPreEntryDigest}, it contains the
 * full state of the prescription (i.e the initial PRE item and all PADV items that have been aggregated).
 *
 * @author Quentin Ligier
 */
@Data
@NoArgsConstructor
public class MedicationPrescription {

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
     * Number of dispense repeats/refills (excluding the initial dispense). {@code null} means no limitation.
     */
    @Nullable
    private Integer dispenseRepeatNumber = null;

    /**
     * PRE item starting time.
     * <p>
     * TODO: mandatory?
     */
    @Nullable
    private Instant startTime;

    /**
     * PRE item ending time.
     * <p>
     * TODO: mandatory?
     */
    @Nullable
    private Instant endTime;

    /**
     * The list of substance substitution permissions.
     * <p>
     * SPEC: single value? default value?
     */
    private final List<ActSubstanceAdminSubstitutionCode> substitutionPermissions = new ArrayList<>();

    /**
     * The list of 'over-the-counter' dispenses (OTC, without prescription).
     */
    private final List<MedicationDispense> dispenses = new ArrayList<>();

    /**
     * Returns whether the dispense has been completed.
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
        return (this.endTime == null || !Instant.now().isAfter(this.endTime)) // if end time null or in the future
                &&
                (this.prescriptionStatus == PrescriptionStatus.PROVISIONAL ||
                        this.prescriptionStatus == PrescriptionStatus.SUBMITTED);
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
        return (this.endTime == null || !Instant.now().isAfter(this.endTime)) // if end time null or in the future
                && this.prescriptionStatus == PrescriptionStatus.ACTIVE;
    }
}
