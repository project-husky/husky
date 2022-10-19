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

import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.fhir.emed.ch.common.enums.DispenseSupplyType;
import org.projecthusky.fhir.emed.ch.pmp.enums.RegularUnitCodeAmbu;
import org.projecthusky.fhir.emed.ch.pmp.model.common.MedicationDosageInstructions;

import java.util.UUID;

/**
 * A data structure that represents a medication dispense.
 * <p>
 * PADV documents that are aggregated can only change the dosage instructions; other fields are not updatable.
 *
 * @author Quentin Ligier
 */
@Data
@NoArgsConstructor
public class MedicationDispense {

    /**
     * The dispense comment, if any.
     */
    @Nullable
    private String comment;

    /**
     * The dispense type (first fill or refill, complete or partial).
     */
    private DispenseSupplyType dispenseType;

    /**
     * The dosage instructions associated with the dispense, if any.
     */
    @Nullable
    private MedicationDosageInstructions dosageInstructions;

    /**
     * The fulfillment notes, if any.
     */
    @Nullable
    private String fulfillmentNotes;

    /**
     * The DIS item ID.
     */
    private UUID itemId;

    /**
     * The dispensed medication quantity. If the dispensed product has information about the medication package, the
     * quantity is the amount of packages of the medicine without units. Otherwise, it may be either the amount of
     * consumable units of the medication without units or the quantity in non-countable units.
     */
    @Nullable
    private RegularUnitCodeAmbu quantityUnit;

    /**
     * The dispensed medication quantity. If the dispensed product has information about the medication package, the
     * quantity is the amount of packages of the medicine without units. Otherwise, it may be either the amount of
     * consumable units of the medication without units or the quantity in non-countable units.
     */
    private String quantityValue;
}
