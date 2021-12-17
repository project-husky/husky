package org.husky.emed.cda.models.treatment;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.emed.cda.enums.DispenseStatus;
import org.husky.emed.cda.generated.artdecor.enums.DispenseSupplyType;
import org.husky.emed.cda.models.common.QuantityWithUnit;

/**
 * A data structure that represents a medication dispense. Contrary to a {@link org.husky.emed.cda.models.entry.EmedDisEntryDigest},
 * it contains the full state of the dispense (i.e the initial DIS item and all PADV items that have been aggregated).
 *
 * @author Quentin Ligier
 */
@Data
@NoArgsConstructor
public class MedicationDispense {

    /**
     * The DIS item ID.
     */
    private String itemId;

    /**
     * The dispense type (first fill or refill, complete or partial).
     */
    private DispenseSupplyType dispenseType;

    /**
     * The actual status of the dispense.
     */
    @Nullable
    private DispenseStatus status;

    /**
     * The dispensed medication quantity. If the dispensed product has information about the medication package, the
     * quantity is the amount of packages of the medicine without units. Otherwise, it may be either the amount of
     * consumable units of the medication without units or the quantity in non-countable units.
     */
    @Nullable
    private QuantityWithUnit quantity;

    /**
     * List of aggregated PADV?
     */

}
