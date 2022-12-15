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
package org.projecthusky.fhir.emed.ch.epr.datatypes;

import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.Dosage;
import org.hl7.fhir.r4.model.Period;
import org.hl7.fhir.r4.model.Timing;
import org.projecthusky.common.utils.datatypes.Oids;
import org.projecthusky.fhir.emed.ch.common.annotation.ExpectsValidResource;
import org.projecthusky.fhir.emed.ch.common.enums.RouteOfAdministrationEdqm;
import org.projecthusky.fhir.emed.ch.common.error.InvalidEmedContentException;
import org.projecthusky.fhir.emed.ch.epr.enums.TimingEventAmbu;
import org.projecthusky.fhir.emed.ch.epr.model.common.AmountPerDuration;
import org.projecthusky.fhir.emed.ch.epr.model.common.AmountQuantity;
import org.projecthusky.fhir.emed.ch.epr.model.common.Duration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The HAPI custom structure for CH-EMED-Dosage.
 *
 * @author Ronaldo Loureiro
 **/
@DatatypeDef(name = "Dosage", isSpecialization = true, profileOf = Dosage.class)
public class ChEmedEprDosage extends Dosage {

    /**
     * Empty constructor
     */
    public ChEmedEprDosage() {
        super();
    }

    /**
     * Resolves the list of with event timings.
     *
     * @return the list of with event timings.
     * @throws InvalidEmedContentException if dosage for time period of occurrence is invalid.
     */
    @ExpectsValidResource
    public List<TimingEventAmbu> resolveWhen() throws InvalidEmedContentException {
        final var repeat = this.getTiming().getRepeat();
        if (!repeat.hasWhen()) return Collections.emptyList();

        final var eventTimings = new ArrayList<TimingEventAmbu>(repeat.getWhen().size());
        for (final var event : repeat.getWhen()) {
            final var eventTiming = TimingEventAmbu.getEnum(event.getCode());
            if (eventTiming == null) {
                throw new InvalidEmedContentException("The event timing '" + event.getCode() + "' is invalid.");
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
        if (!this.hasRoute()) {
            return null;
        }
        for (final var coding : this.getRoute().getCoding()) {
            if (!RouteOfAdministrationEdqm.CODE_SYSTEM_ID.equals(coding.getSystem())) {
                continue;
            }
            final var routeOfAdministration = RouteOfAdministrationEdqm.getEnum(coding.getCode());
            if (routeOfAdministration != null) {
                return routeOfAdministration;
            }
        }
        throw new InvalidEmedContentException("The route of administration is invalid.");
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
     * Returns whether the dosage is 'as needed'.
     */
    public boolean isAsNeeded() {
        if (this.hasAsNeededBooleanType()) {
            return this.getAsNeededBooleanType().booleanValue();
        } else return this.hasAsNeededCodeableConcept();
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
     * Resolves the treatment duration, if specified.
     *
     * @return the treatment duration or {@code null}.
     */
    @ExpectsValidResource
    @Nullable
    public Duration resolveBoundsDuration() {
        if (!this.getTiming().getRepeat().hasBoundsDuration()) {
            return null;
        }
        return Duration.fromQuantity(this.getTiming().getRepeat().getBoundsDuration());
    }

    /**
     * Sets patient medication instructions.
     *
     * @param patientInstruction Instructions in terms that are understood by the patient or consumer.
     * @return this.
     */
    public ChEmedEprDosage setPatientInstruction(final String patientInstruction) {
        super.setPatientInstruction(patientInstruction);
        return this;
    }

    /**
     * Sets start and/or end of treatment.
     *
     * @param boundsPeriod start and/or end of treatment.
     * @return this.
     */
    public ChEmedEprDosage setBoundsPeriod(final Period boundsPeriod) {
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
    public ChEmedEprDosage setRouteOfAdministration(final RouteOfAdministrationEdqm routeOfAdministration) {
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
    public ChEmedEprDosage setDoseQuantity(final ChEmedQuantityWithEmedUnits doseQuantity) {
        this.getDoseAndRateFirstRep().setDose(doseQuantity);
        return this;
    }

    /**
     * Sets the dose range.
     *
     * @param doseRange the dose range.
     * @return this.
     */
    public ChEmedEprDosage setDoseRange(final ChEmedQuantityWithEmedUnits doseRange) {
        this.getDoseAndRateFirstRep().setDose(doseRange);
        return this;
    }

    /**
     * Adds an event timing for time period occurrence.
     *
     * @param timing the event timing.
     * @return this.
     */
    public ChEmedEprDosage addWhen(final TimingEventAmbu timing) {
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

    /**
     * Returns the site text, either the `site.text` element or the first `site.coding.text` that is filled.
     */
    @Nullable
    public String getSiteText() {
        if (!this.hasSite()) {
            return null;
        }
        if (this.getSite().hasText()) {
            return this.getSite().getText();
        }
        for (final var code : this.getSite().getCoding()) {
            if (code.hasDisplay()) {
                return code.getDisplay();
            }
        }
        return null;
    }

    /**
     * Returns the resolved max dose per period, or {@code null} if it's not specified. Throws if it's specified but
     * invalid.
     */
    @ExpectsValidResource
    @Nullable
    public AmountPerDuration resolveMaxDosePerPeriod() {
        if (!this.hasMaxDosePerPeriod()) {
            return null;
        }
        return AmountPerDuration.fromRatio(this.getMaxDosePerPeriod());
    }

    /**
     * Returns the resolved max dose per administration, or {@code null} if it's not specified. Throws if it's specified
     * but invalid.
     */
    @ExpectsValidResource
    @Nullable
    public AmountQuantity resolveMaxDosePerAdministration() {
        if (!this.hasMaxDosePerAdministration()) {
            return null;
        }
        return AmountQuantity.fromQuantity(this.getMaxDosePerAdministration());
    }
}
