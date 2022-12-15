package org.projecthusky.fhir.emed.ch.epr.model.common;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.Period;
import org.projecthusky.fhir.emed.ch.common.enums.RouteOfAdministrationEdqm;
import org.projecthusky.fhir.emed.ch.epr.datatypes.ChEmedEprDosage;

import java.util.ArrayList;
import java.util.List;

/**
 * A model of the effective dosage, resolved from a list of FHIR Dosages.
 *
 * @author Quentin Ligier
 */
public record EffectiveDosageInstructions(
        @Nullable String patientInstructions,
        boolean isAsNeeded,
        @Nullable List<DosageIntake> intakes,
        @Nullable String site,
        @Nullable RouteOfAdministrationEdqm route,
        @Nullable Period period,
        @Nullable Duration periodDuration,
        @Nullable AmountPerDuration maxDosePerPeriod,
        @Nullable AmountQuantity maxDosePerAdministration) {

    public boolean hasPatientInstructions() {
        return this.patientInstructions != null;
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
                                                          final List<ChEmedEprDosage> additionalDosage) {
        final var patientInstructions = baseDosage.getPatientInstruction();
        final var isAsNeeded = baseDosage.isAsNeeded();
        final var intakes = new ArrayList<DosageIntake>(0);
        final var site = baseDosage.getSiteText();
        final var route = baseDosage.resolveRouteOfAdministration();
        final var period = baseDosage.getBoundsPeriod();
        final var duration = baseDosage.resolveBoundsDuration();
        final var maxDosePerPeriod = baseDosage.resolveMaxDosePerPeriod();
        final var maxDosePerAdministration = baseDosage.resolveMaxDosePerAdministration();

        // Resolve intakes
        // todo

        return new EffectiveDosageInstructions(patientInstructions,
                                               isAsNeeded,
                                               intakes,
                                               site,
                                               route,
                                               period,
                                               duration,
                                               maxDosePerPeriod,
                                               maxDosePerAdministration);
    }
}
