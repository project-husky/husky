package org.projecthusky.fhir.emed.ch.epr.model.common;

import org.checkerframework.checker.nullness.qual.Nullable;

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
        @Nullable String route,
        @Nullable Period period,
        @Nullable Duration periodDuration,
        @Nullable AmountPerDuration maxDosePerPeriod,
        @Nullable AmountQuantity maxDosePerAdministration,
        @Nullable AmountQuantity maxDosePerLifetime) {

    public boolean hasPatientInstructions() {
        return this.patientInstructions != null;
    }


    public boolean isRegular() {
        return !this.isAsNeeded();
    }
}
