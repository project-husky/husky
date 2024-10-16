package org.projecthusky.fhir.emed.ch.epr.model.common;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.Period;
import org.projecthusky.fhir.emed.ch.common.enums.RouteOfAdministrationEdqm;
import org.projecthusky.fhir.emed.ch.epr.datatypes.ChEmedEprDosage;
import org.projecthusky.fhir.emed.ch.epr.enums.RegularUnitCodeAmbu;
import org.projecthusky.fhir.emed.ch.epr.enums.TimingEventAmbu;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * A model of the effective dosage, resolved from a list of FHIR Dosages.
 *
 * @author Quentin Ligier
 */
public record EffectiveDosageInstructions(
        @Nullable String patientInstructions,
        String narrative,
        boolean isAsNeeded,
        List<DosageIntake> intakes,
        @Nullable Dose simpleDose,
        @Nullable List<TimingEventAmbu> simpleEventTimings,
        @Nullable String site,
        @Nullable RouteOfAdministrationEdqm routeOfAdministration,
        @Nullable Period period,
        @Nullable AmountPerDuration maxDosePerPeriod,
        @Nullable AmountQuantity maxDosePerAdministration) {

    public boolean hasPatientInstructions() {
        return this.patientInstructions != null;
    }

    public boolean hasRouteOfAdministration() {
        return this.routeOfAdministration != null;
    }

    public boolean hasIntakes() {
        return !this.intakes.isEmpty();
    }

    public boolean hasMaxDose() {
        return this.maxDosePerPeriod != null || this.maxDosePerAdministration != null;
    }

    public boolean hasSimpleDose() {
        return this.simpleDose != null;
    }

    public boolean hasSimpleEventTimings() {
        return this.simpleEventTimings != null;
    }

    public boolean hasSimpleEventTiming(TimingEventAmbu timing) {
        return hasSimpleEventTimings() && this.simpleEventTimings.contains(timing);
    }

    public boolean hasMorningSimpleEventTiming() {return hasSimpleEventTiming(TimingEventAmbu.MORNING);}
    public boolean hasNoonSimpleEventTiming() {return hasSimpleEventTiming(TimingEventAmbu.NOON);}
    public boolean hasEveningSimpleEventTiming() {return hasSimpleEventTiming(TimingEventAmbu.EVENING);}
    public boolean hasNightSimpleEventTiming() {return hasSimpleEventTiming(TimingEventAmbu.NIGHT);}

    public boolean hasPeriod() {return period != null;}

    @Nullable
    public DosageIntake getMornIntake() {
        return this.getIntake(TimingEventAmbu.MORNING);
    }

    @Nullable
    public DosageIntake getNoonIntake() {
        return this.getIntake(TimingEventAmbu.NOON);
    }

    @Nullable
    public DosageIntake getEveIntake() {
        return this.getIntake(TimingEventAmbu.EVENING);
    }

    @Nullable
    public DosageIntake getNightIntake() {
        return this.getIntake(TimingEventAmbu.NIGHT);
    }

    @Nullable
    public DosageIntake getIntake(final TimingEventAmbu eventTiming) {
        return this.intakes.stream().filter(intake -> intake.eventTiming() == eventTiming).findAny().orElse(null);
    }

    @Nullable
    public RegularUnitCodeAmbu getUnit() {
        Function<Dose, RegularUnitCodeAmbu> extractUnit = (Dose dose) -> {
            if (dose.isQuantity()) return dose.quantity().unit();
            if (dose.low() != null) return dose.low().unit();
            return dose.high().unit();
        };
        if (hasIntakes())
            return intakes.stream().filter(Objects::nonNull).map(DosageIntake::dose).map(extractUnit).findAny().orElse(null);
        if (hasSimpleDose())
            return extractUnit.apply(simpleDose);
        return null;
    }

    /**
     * Whether the treatment is "regular" (i.e. to be taken without condition). If {@code false}, it's as needed.
     */
    public boolean isRegular() {
        return !this.isAsNeeded();
    }

    /**
     * Creates an instance from the base and additional dosages.
     */
    public static EffectiveDosageInstructions fromDosages(final ChEmedEprDosage baseDosage,
                                                          final List<ChEmedEprDosage> additionalDosages) {
        final var patientInstructions = baseDosage.getPatientInstruction();
        final var narrative = baseDosage.getText();
        final var isAsNeeded = baseDosage.isAsNeeded();
        final var site = baseDosage.getSiteText();
        final var routeOfAdministration = baseDosage.resolveRouteOfAdministration();
        final var period = baseDosage.getBoundsPeriod();
        final var maxDosePerPeriod = baseDosage.resolveMaxDosePerPeriod();
        final var maxDosePerAdministration = baseDosage.resolveMaxDosePerAdministration();

        // Resolve intakes
        final List<DosageIntake> intakes = new ArrayList<>(0);
        final Consumer<ChEmedEprDosage> processIntakes = (ChEmedEprDosage dosage) -> {
            final Dose dose = dosage.resolveDose();
            if (dose == null || dose.isQuantity() && "0".equals(dose.quantity().value())) {
                return;
            }
            for (final TimingEventAmbu eventTiming : dosage.resolveWhen()) {
                intakes.add(new DosageIntake(eventTiming, dose));
            }
        };
        processIntakes.accept(baseDosage);
        for (final ChEmedEprDosage additionalDosage : additionalDosages) {
            processIntakes.accept(additionalDosage);
        }

        Dose simpleDose = null;
        List<TimingEventAmbu> simpleEventTimings = null;
        if (intakes.isEmpty()) {
            if (baseDosage.hasDoseAndRate() && baseDosage.getDoseAndRateFirstRep().hasDoseQuantity()) {
                simpleDose = baseDosage.resolveDose();
            }
            if (baseDosage.hasTiming() && baseDosage.getTiming().hasRepeat() && baseDosage.getTiming().getRepeat().hasWhen()) {
                simpleEventTimings = baseDosage.resolveWhen();
            }
        }

        return new EffectiveDosageInstructions(patientInstructions,
                                               narrative,
                                               isAsNeeded,
                                               intakes,
                                               simpleDose,
                                               simpleEventTimings,
                                               site,
                                               routeOfAdministration,
                                               period,
                                               maxDosePerPeriod,
                                               maxDosePerAdministration);
    }
}
