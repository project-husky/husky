/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.cda.models.common;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * The dosage instructions of a medication.
 *
 * @author Quentin Ligier
 */
public class MedicationDosageInstructions {

    /**
     * The list of dosage instructions intakes. It may be empty.
     */
    private final List<@NonNull MedicationDosageIntake> intakes = new ArrayList<>();

    /**
     * The narrative description of the dosage instructions.
     */
    @Nullable private String narrativeDosageInstructions;

    /**
     * The inclusive treatment start time.
     */
    @Nullable private Instant treatmentStart;

    /**
     * The inclusive treatment stop time.
     */
    @Nullable private Instant treatmentStop;

    /**
     * Constructor.
     *
     * @param narrativeDosageInstructions The narrative description of the dosage instructions.
     */
    public MedicationDosageInstructions(@Nullable final String narrativeDosageInstructions,
                                        @Nullable final Instant treatmentStart,
                                        @Nullable final Instant treatmentStop) {
        this.narrativeDosageInstructions = narrativeDosageInstructions;
        this.treatmentStart = treatmentStart;
        this.treatmentStop = treatmentStop;
    }

    /**
     * Returns the narrative description of the dosage instructions or {@code null} if it isn't provided.
     */
    @Nullable
    public String getNarrativeDosageInstructions() {
        return this.narrativeDosageInstructions;
    }

    /**
     * Sets the narrative description of the dosage instructions.
     *
     * @param narrativeDosageInstructions The narrative description of the dosage instructions.
     */
    public void setNarrativeDosageInstructions(@Nullable final String narrativeDosageInstructions) {
        this.narrativeDosageInstructions = narrativeDosageInstructions;
    }

    /**
     * Returns the list of dosage instructions intakes. It may be empty.
     */
    public List<@NonNull MedicationDosageIntake> getIntakes() {
        return this.intakes;
    }

    /**
     * Returns the inclusive treatment start time.
     */
    @Nullable
    public Instant getTreatmentStart() {
        return treatmentStart;
    }

    /**
     * Sets the treatment start time.
     *
     * @param treatmentStart The inclusive treatment start time.
     */
    public void setTreatmentStart(@Nullable final Instant treatmentStart) {
        this.treatmentStart = treatmentStart;
    }

    /**
     * Returns the inclusive treatment stop time.
     */
    @Nullable
    public Instant getTreatmentStop() {
        return treatmentStop;
    }

    /**
     * Sets the treatment stop time.
     *
     * @param treatmentStop The inclusive treatment stop time.
     */
    public void setTreatmentStop(@Nullable final Instant treatmentStop) {
        this.treatmentStop = treatmentStop;
    }

    @Override
    public String toString() {
        return "MedicationDosageInstructions{" +
                "intakes=" + intakes +
                ", narrativeDosageInstructions='" + narrativeDosageInstructions + '\'' +
                ", treatmentStart=" + treatmentStart +
                ", treatmentStop=" + treatmentStop +
                '}';
    }
}
