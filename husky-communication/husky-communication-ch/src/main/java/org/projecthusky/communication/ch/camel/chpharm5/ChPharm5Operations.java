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
}
