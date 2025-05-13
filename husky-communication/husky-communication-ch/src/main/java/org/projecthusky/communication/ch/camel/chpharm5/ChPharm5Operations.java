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
package org.projecthusky.communication.ch.camel.chpharm5;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.openehealth.ipf.commons.ihe.fhir.pharm5.Pharm5Operations;

import java.util.Objects;

/**
 * The different operations of CMPD CH:PHARM-5 transaction.
 *
 * @author Quentin Ligier
 **/
public enum ChPharm5Operations {

    FIND_MEDICATION_TREATMENT_PLANS("$find-medication-treatment-plans"),
    FIND_PRESCRIPTIONS("$find-prescriptions"),
    FIND_DISPENSES("$find-dispenses"),
    FIND_MEDICATION_ADMINISTRATIONS("$find-medication-administrations"),
    FIND_PRESCRIPTIONS_FOR_VALIDATION("$find-prescriptions-for-validation"),
    FIND_PRESCRIPTIONS_FOR_DISPENSE("$find-prescriptions-for-dispense"),
    FIND_MEDICATION_LIST("$find-medication-list"),
    FIND_MEDICATION_CARD("$find-medication-card");

    private final String operation;

    ChPharm5Operations(final String operation) {
        this.operation = Objects.requireNonNull(operation);
    }

    public String getOperation() {
        return this.operation;
    }

    public static ChPharm5Operations fromPharm5Operation(final Pharm5Operations pharm5Operation) {
        return switch(pharm5Operation) {
            case FIND_MEDICATION_TREATMENT_PLANS -> FIND_MEDICATION_TREATMENT_PLANS;
            case FIND_PRESCRIPTIONS -> FIND_PRESCRIPTIONS;
            case FIND_DISPENSES -> FIND_DISPENSES;
            case FIND_MEDICATION_ADMINISTRATIONS -> FIND_MEDICATION_ADMINISTRATIONS;
            case FIND_PRESCRIPTIONS_FOR_VALIDATION -> FIND_PRESCRIPTIONS_FOR_VALIDATION;
            case FIND_PRESCRIPTIONS_FOR_DISPENSE -> FIND_PRESCRIPTIONS_FOR_DISPENSE;
            case FIND_MEDICATION_LIST -> FIND_MEDICATION_LIST;
        };
    }

    public static @Nullable ChPharm5Operations fromOperation(String operation) {
        if (operation == null || operation.isBlank()) return null;
        if (!operation.startsWith("$")) operation = "$" + operation;
        for (final var chPharm5Operation : ChPharm5Operations.values()) {
            if (chPharm5Operation.getOperation().equals(operation)) return chPharm5Operation;
        }
        return null;
    }

    public @Nullable Pharm5Operations toPharm5Operation() {
        return switch (this) {
            case FIND_MEDICATION_TREATMENT_PLANS -> Pharm5Operations.FIND_MEDICATION_TREATMENT_PLANS;
            case FIND_PRESCRIPTIONS -> Pharm5Operations.FIND_PRESCRIPTIONS;
            case FIND_DISPENSES -> Pharm5Operations.FIND_DISPENSES;
            case FIND_MEDICATION_ADMINISTRATIONS -> Pharm5Operations.FIND_MEDICATION_ADMINISTRATIONS;
            case FIND_PRESCRIPTIONS_FOR_VALIDATION -> Pharm5Operations.FIND_PRESCRIPTIONS_FOR_VALIDATION;
            case FIND_PRESCRIPTIONS_FOR_DISPENSE -> Pharm5Operations.FIND_PRESCRIPTIONS_FOR_DISPENSE;
            case FIND_MEDICATION_LIST -> Pharm5Operations.FIND_MEDICATION_LIST;
            case FIND_MEDICATION_CARD -> null;
        };
    }
}
