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
import lombok.NoArgsConstructor;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.emed.ch.enums.DispenseStatus;
import org.husky.emed.ch.enums.DispenseSupplyType;
import org.husky.emed.ch.models.common.QuantityWithUnit;
import org.husky.emed.ch.models.entry.EmedDisEntryDigest;

/**
 * A data structure that represents a medication dispense. Contrary to a {@link EmedDisEntryDigest},
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

    /*
     * List of aggregated PADV?
     */

}
