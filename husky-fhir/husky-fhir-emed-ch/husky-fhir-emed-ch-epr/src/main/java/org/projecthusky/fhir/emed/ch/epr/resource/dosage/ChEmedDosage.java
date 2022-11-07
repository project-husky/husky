package org.projecthusky.fhir.emed.ch.epr.resource.dosage;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.Dosage;
import org.hl7.fhir.r4.model.Period;
import org.hl7.fhir.r4.model.Timing;
import org.projecthusky.common.utils.datatypes.Oids;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.enums.EventTiming;
import org.projecthusky.fhir.emed.ch.common.enums.RouteOfAdministrationEdqm;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;

import java.util.ArrayList;
import java.util.List;

/**
 * The HAPI custom structure for CH-EMED-Dosage.
 *
 * @author Ronaldo Loureiro
 **/
public class ChEmedDosage extends Dosage {

    /**
     * Empty constructor
     */
    public ChEmedDosage() {
        super();
    }

    /**
     * Resolves the list of with event timings.
     *
     * @return the list of with event timings.
     * @throws InvalidEmedContentException if dosage for time period of occurrence is invalid.
     */
    @Nullable
    @ExpectsValidResource
    public List<EventTiming> resolveWhen() throws InvalidEmedContentException {
        final var repeat = this.getTiming().getRepeat();
        if (!repeat.hasWhen()) return null;

        final var eventTimings = new ArrayList<EventTiming>();
        for (final var event : repeat.getWhen()) {
            final var eventTiming = EventTiming.getEnum(event.getCode());
            if (eventTiming == null) {
                throw new InvalidEmedContentException("The event timing is invalid.");
            }
            eventTimings.add(eventTiming);
        }
        return eventTimings;
    }

    /**
     * Resolve the route of administration.
     *
     * @return the route of administration or {@code null}.
     * @throws InvalidEmedContentException if the route of administration is invalid.
     */
    @Nullable
    @ExpectsValidResource
    public RouteOfAdministrationEdqm resolveRouteOfAdministration() throws InvalidEmedContentException {
        if (!this.hasRoute()) return null;

        final var routeOfAdministration = RouteOfAdministrationEdqm.getEnum(this.getRoute()
                .getCodingFirstRep()
                .getCode());

        if (routeOfAdministration == null)
            throw new InvalidEmedContentException("The route of administration is invalid.");

        return routeOfAdministration;
    }

    /**
     * Resolve the dose quantity.
     *
     * @return the dose quantity or {@code null}.
     * @throws InvalidEmedContentException if the dose quantity isn't of the right type.
     */
    @Nullable
    @ExpectsValidResource
    public ChEmedQuantityWithEmedUnits resolveDoseQuantity() throws InvalidEmedContentException {
        if (!this.hasDoseAndRate() || !this.getDoseAndRateFirstRep().hasDoseQuantity()) return null;
        final var doseQuantity = this.getDoseAndRateFirstRep().getDoseQuantity();
        if (doseQuantity instanceof ChEmedQuantityWithEmedUnits chDoseQuantity) {
            return chDoseQuantity;
        }
        throw new InvalidEmedContentException("The dose quantity isn't of the right type.");
    }

    /**
     * Resolve the dose range.
     *
     * @return the dose range or {@code null}.
     * @throws InvalidEmedContentException if the dose range isn't of the right type.
     */
    @Nullable
    @ExpectsValidResource
    public ChEmedRangeWithEmedUnits resolveDoseRange() throws InvalidEmedContentException {
        if (!this.hasDoseAndRate() || !this.getDoseAndRateFirstRep().hasDoseRange()) return null;
        final var doseRange = this.getDoseAndRateFirstRep().getDoseRange();
        if (doseRange instanceof ChEmedRangeWithEmedUnits chDoseRange) {
            return chDoseRange;
        }
        throw new InvalidEmedContentException("The dose range isn't of the right type.");
    }

    /**
     * Gets the start and/or end of treatment. If it doesn't exist, it's created.
     *
     * @return the start and/or end of treatment.
     */
    public Period getBoundsPeriod() {
        return this.getTiming()
                .getRepeat()
                .getBoundsPeriod();
    }

    /**
     * Sets patient medication instructions.
     *
     * @param patientInstruction Instructions in terms that are understood by the patient or consumer.
     * @return this.
     */
    public ChEmedDosage setPatientInstruction(final String patientInstruction) {
        super.setPatientInstruction(patientInstruction);
        return this;
    }

    /**
     * Sets start and/or end of treatment.
     *
     * @param boundsPeriod start and/or end of treatment.
     * @return this.
     */
    public ChEmedDosage setBoundsPeriod(final Period boundsPeriod) {
        this.getTiming()
                .getRepeat()
                .setBounds(boundsPeriod);
        return this;
    }

    /**
     * Sets route of administration.
     *
     * @param routeOfAdministration the route of administration.
     * @return this.
     */
    public ChEmedDosage setRouteOfAdministration(final RouteOfAdministrationEdqm routeOfAdministration) {
        this.getRoute()
                .getCodingFirstRep()
                .setSystem(Oids.PREFIX_OID + routeOfAdministration.getCodeSystemId())
                .setCode(routeOfAdministration.getCodeValue())
                .setDisplay(routeOfAdministration.getDisplayName());

        return this;
    }

    /**
     * Sets the dose quantity.
     *
     * @param doseQuantity the dose quantity.
     * @return this.
     */
    public ChEmedDosage setDoseQuantity(final ChEmedQuantityWithEmedUnits doseQuantity) {
        this.getDoseAndRateFirstRep().setDose(doseQuantity);
        return this;
    }

    /**
     * Sets the dose range.
     *
     * @param doseRange the dose range.
     * @return this.
     */
    public ChEmedDosage setDoseRange(final ChEmedQuantityWithEmedUnits doseRange) {
        this.getDoseAndRateFirstRep().setDose(doseRange);
        return this;
    }

    /**
     * Adds an event timing for time period occurrence.
     *
     * @param timing the event timing.
     * @return this.
     */
    public ChEmedDosage addWhen(final EventTiming timing) {
        this.getTiming()
                .getRepeat()
                .addWhen(Timing.EventTiming.fromCode(timing.getCodeValue()));

        return this;
    }

    /**
     * Return whether a code for time period of occurrence.
     *
     * @return {@code true} if a code for time period of occurrence exists, {@code false} otherwise.
     */
    public boolean hasWhen() {
        return this.getTiming()
                .getRepeat()
                .hasWhen();
    }

    /**
     * Return whether the start and/or end of treatment.
     *
     * @return {@code true} if the start and/or end of treatment exists, {@code false} otherwise.
     */
    public boolean hasBoundsPeriod() {
        return this.getTiming()
                .getRepeat()
                .hasBoundsPeriod();
    }
}
