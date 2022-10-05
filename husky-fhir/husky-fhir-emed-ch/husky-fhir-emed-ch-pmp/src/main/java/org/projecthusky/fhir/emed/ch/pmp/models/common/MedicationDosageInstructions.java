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
package org.projecthusky.fhir.emed.ch.pmp.models.common;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.emed.ch.enums.TimingEventAmbu;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The dosage instructions of a medication.
 *
 * @author Quentin Ligier
 */
public class MedicationDosageInstructions {

    /**
     * The list of dosage instructions intakes. It may be empty.
     */
    private final List<@NonNull MedicationDosageIntake> intakes = new ArrayList<>(0);

    /**
     * The narrative description of the dosage instructions or {@code null} if it's not specified.
     */
    @Nullable
    private String narrativeDosageInstructions;

    /**
     * The inclusive intake period start time or {@code null} if it's not specified.
     */
    @Nullable
    private Instant intakePeriodStartTime;

    /**
     * The inclusive intake period stop time or {@code null} if it's not specified.
     */
    @Nullable
    private Instant intakePeriodStopTime;

    /**
     * Constructor.
     *
     * @param intakes                     The list of dosage instructions intakes or {@code null}.
     * @param narrativeDosageInstructions The narrative description of the dosage instructions or {@code null}.
     * @param intakePeriodStartTime       The inclusive intake period start time or {@code null}.
     * @param intakePeriodStopTime        The inclusive intake period stop time or {@code null}.
     */
    public MedicationDosageInstructions(@Nullable final List<@NonNull MedicationDosageIntake> intakes,
                                        @Nullable final String narrativeDosageInstructions,
                                        @Nullable final Instant intakePeriodStartTime,
                                        @Nullable final Instant intakePeriodStopTime) {
        if (intakes != null) {
            this.intakes.addAll(intakes);
        }
        this.narrativeDosageInstructions = narrativeDosageInstructions;
        this.intakePeriodStartTime = intakePeriodStartTime;
        this.intakePeriodStopTime = intakePeriodStopTime;
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
     * Sets a dosage instruction intake.
     *
     * @param eventTiming  The event timing.
     * @param doseQuantity The dose quantity.
     */
    public void setIntake(final TimingEventAmbu eventTiming,
                          final QuantityWithRegularUnit doseQuantity) {
        this.getIntake(eventTiming).ifPresentOrElse(oldIntake -> this.intakes.set(
                this.intakes.indexOf(oldIntake),
                new MedicationDosageIntake(eventTiming, doseQuantity)
        ), () -> this.intakes.add(new MedicationDosageIntake(eventTiming, doseQuantity)));
    }

    /**
     * Returns a dosage instruction intake by a timing event.
     *
     * @return an {@link Optional} that may contain the dosage instruction intake.
     */
    public Optional<MedicationDosageIntake> getIntake(final TimingEventAmbu eventTiming) {
        return this.intakes.stream()
                .filter(intake -> eventTiming.equals(intake.getEventTiming()))
                .findAny();
    }

    /**
     * Returns the inclusive treatment start time.
     */
    @Nullable
    public Instant getIntakePeriodStartTime() {
        return intakePeriodStartTime;
    }

    /**
     * Sets the treatment start time.
     *
     * @param intakePeriodStartTime The inclusive treatment start time.
     */
    public void setIntakePeriodStartTime(@Nullable final Instant intakePeriodStartTime) {
        this.intakePeriodStartTime = intakePeriodStartTime;
    }

    /**
     * Returns the inclusive treatment stop time.
     */
    @Nullable
    public Instant getIntakePeriodStopTime() {
        return intakePeriodStopTime;
    }

    /**
     * Sets the treatment stop time.
     *
     * @param intakePeriodStopTime The inclusive treatment stop time.
     */
    public void setIntakePeriodStopTime(@Nullable final Instant intakePeriodStopTime) {
        this.intakePeriodStopTime = intakePeriodStopTime;
    }

    /**
     * Returns the type of the dosage instructions.
     */
    public Type getType() {
        if (this.narrativeDosageInstructions != null) {
            return Type.NARRATIVE;
        }
        final long nbDifferentDosis =
                this.intakes.stream().map(MedicationDosageIntake::getDoseQuantity).distinct().count();
        return (nbDifferentDosis < 2) ? Type.NORMAL : Type.SPLIT;
    }

    @Override
    public String toString() {
        return "MedicationDosageInstructions{" +
                "intakes=" + intakes +
                ", narrativeDosageInstructions='" + narrativeDosageInstructions + '\'' +
                ", setIntakePeriodStartTime=" + intakePeriodStartTime +
                ", intakePeriodStopTime=" + intakePeriodStopTime +
                '}';
    }

    /**
     * The types of dosage instructions.
     */
    public enum Type {
        NORMAL, SPLIT, NARRATIVE
    }
}
