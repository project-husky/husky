/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.emed.ch.cda.utils.readers;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.common.hl7cdar2.*;
import org.projecthusky.emed.ch.cda.utils.EntryRelationshipUtils;
import org.projecthusky.emed.ch.cda.utils.IvlTsUtils;
import org.projecthusky.emed.ch.cda.utils.TemplateIds;
import org.projecthusky.emed.ch.enums.DosageType;
import org.projecthusky.emed.ch.enums.RouteOfAdministrationAmbu;
import org.projecthusky.emed.ch.enums.TimingEventAmbu;
import org.projecthusky.emed.ch.errors.InvalidEmedContentException;
import org.projecthusky.emed.ch.models.common.MedicationDosageInstructions;
import org.projecthusky.emed.ch.models.common.MedicationDosageIntake;
import org.projecthusky.emed.ch.models.common.QuantityWithRegularUnit;

import java.math.BigInteger;
import java.time.Instant;
import java.util.*;

/**
 * A reader for CDA-CH-EMED Dosage Instructions Content Module (1.3.6.1.4.1.19376.1.9.1.3.6).
 *
 * <p>The following elements part of the Dosage Instructions:
 * <ul>
 * <li> Prescription Item Entry Additional Template ID
 * <li> Effective Time (Duration of Treatment)
 * <li> Medication Frequency
 * <li> Route of Administration
 * <li> Approach Site Code
 * <li> Dose Quantity
 * <li> Rate Quantity
 * <li> Related Components
 * </ul>
 *
 * LATER: Add support for the rateQuantity and approachSiteCode elements.
 *
 * @author Quentin Ligier
 */
public class DosageInstructionsReader {

    /**
     * The substance administration.
     */
    protected final POCDMT000040SubstanceAdministration subAdm;

    /**
     * The dosage type.
     */
    private final DosageType dosageType;

    /**
     * Constructor.
     *
     * @param subAdm The substance administration.
     * @throws InvalidEmedContentException if the substance administration is invalid.
     */
    public DosageInstructionsReader(final POCDMT000040SubstanceAdministration subAdm) throws InvalidEmedContentException {
        Objects.requireNonNull(subAdm);
        if (!TemplateIds.isInList(TemplateIds.DOSAGE_INSTRUCTIONS, subAdm.getTemplateId())) {
            throw new InvalidEmedContentException("The given substance administration is not a dosage " +
                "instructions content module");
        }
        this.subAdm = subAdm;
        this.dosageType = this.getDosageTypeFromTemplateIds();
    }

    /**
     * Returns the inclusive treatment effective start time if it's specified.
     *
     * @return an {@link Optional} that may contain the inclusive start time.
     */
    public Optional<Instant> getEffectiveStartTime() {
        return this.subAdm.getEffectiveTime().stream()
                .filter(IVLTS.class::isInstance)
                .findAny()
                .map(IVLTS.class::cast)
                .map(IvlTsUtils::getInclusiveLowInstant);
    }

    /**
     * Returns the inclusive treatment effective stop time if it's specified.
     *
     * @return an {@link Optional} that may contain the inclusive stop time.
     */
    public Optional<Instant> getEffectiveStopTime() {
        return this.subAdm.getEffectiveTime().stream()
                .filter(IVLTS.class::isInstance)
                .findAny()
                .map(IVLTS.class::cast)
                .map(IvlTsUtils::getInclusiveHighInstant);
    }

    /**
     * Returns the number of repeats/refills. It contains a non-zero integer if it's limited, it's zero if no
     * repeat/refill is authorized and it's empty if unlimited repeats/refills are authorized.
     *
     * @return an {@link Optional} that may contain the limit number of repeats/refills.
     */
    public Optional<Integer> getRepeatNumber() {
        return Optional.ofNullable(this.subAdm.getRepeatNumber())
                .map(INT::getValue)
                .map(BigInteger::intValue);
    }

    /**
     * Returns the dose quantity.
     *
     * @return an {@link Optional} that may contain the dose quantity.
     */
    public Optional<QuantityWithRegularUnit> getDoseQuantity() {
        return this.getDoseQuantity(this.subAdm);
    }

    /**
     * Returns the medication route of administration.
     *
     * @return an {@link Optional} that may contain the route of administration.
     */
    public Optional<RouteOfAdministrationAmbu> getRouteOfAdministration() {
        return Optional.ofNullable(this.subAdm.getRouteCode())
                .map(CD::getCode)
                .filter(RouteOfAdministrationAmbu::isInValueSet)
                .map(RouteOfAdministrationAmbu::getEnum);
    }

    /**
     * Returns the dosage type.
     *
     * @return the dosage type.
     */
    public DosageType getDosageType() {
        return this.dosageType;
    }

    /**
     * Returns the medication dosage instructions.
     */
    public MedicationDosageInstructions getDosageInstructions() {
        final var instructions = new MedicationDosageInstructions(
                null,
                this.getNarrativeDosageInstructions().orElse(null),
                this.getEffectiveStartTime().orElse(null),
                this.getEffectiveStopTime().orElse(null)
        );

        final var timingEvent = this.getSingleTimingEvent(this.subAdm).orElse(null);
        final var timingEvents = this.getMultipleTimingEvents(this.subAdm);
        final var doseQuantity = this.getDoseQuantity(this.subAdm).orElse(null);
        final var relatedComponents = this.getRelatedComponents(this.subAdm);

        if (this.getDosageType() == DosageType.NORMAL) {
            if (!relatedComponents.isEmpty()) {
                throw new InvalidEmedContentException("The related components shall not be present in a normal dose " +
                        "regime");
            }
            if (timingEvent != null && !timingEvents.isEmpty()) {
                throw new InvalidEmedContentException("Either the single or the multiple medication frequency shall " +
                        "be specified in normal dose regime");
            }
            // The case where the normal dose regime contains both structured and narrative info or none is covered by
            // the Schematron
            if (timingEvent != null) {
                instructions.getIntakes().add(new MedicationDosageIntake(timingEvent, doseQuantity));
            }
            timingEvents.forEach(timingEventAmbu -> instructions.getIntakes().add(new MedicationDosageIntake(timingEventAmbu, doseQuantity)));
        } else if (this.getDosageType() == DosageType.SPLIT) {
            if (relatedComponents.isEmpty()) {
                throw new InvalidEmedContentException("The related components shall be present in a split dose regime");
            }
            if (!timingEvents.isEmpty()) {
                throw new InvalidEmedContentException("The multiple medication frequencies shall not be present in a " +
                        "split dose regime");
            }
            relatedComponents.forEach(relatedComponent -> {
                final var newIntake = this.getSubordinateIntake(relatedComponent, timingEvent, doseQuantity);
                instructions.getIntakes().add(newIntake);
            });
        } else {
            throw new InvalidEmedContentException("The dosage type " + this.getDosageType() + " isn't supported yet");
        }

        if (instructions.getIntakes().size() != instructions.getIntakes().stream().map(MedicationDosageIntake::getEventTiming).distinct().count()) {
            throw new InvalidEmedContentException("A timing event was fount multiple times in the dosage instructions");
        }
        return instructions;
    }

    /**
     * Returns the dosage instructions element or {@code null} if it's not specified.
     *
     * @return an {@link Optional} that may contain the dosage instructions.
     */
    public Optional<POCDMT000040SubstanceAdministration> getNarrativeDosageInstructionsElement() {
        final List<POCDMT000040SubstanceAdministration> sas =
                EntryRelationshipUtils.getSubstanceAdministrationsFromEntryRelationshipsByTemplateId(this.subAdm.getEntryRelationship(),
                        TemplateIds.DOSAGE_INSTRUCTIONS_NON_STRUCTURED);
        return Optional.ofNullable(!sas.isEmpty() ? sas.get(0) : null);
    }

    /**
     * Returns the narrative description of the dosage instructions if provided.
     *
     * @return an {@link Optional<String>} that may contain the narrative text.
     */
    public Optional<String> getNarrativeDosageInstructions() {
        return this.getNarrativeDosageInstructionsElement()
                .map(POCDMT000040SubstanceAdministration::getText)
                .map(ED::getTextContent);
    }

    /**
     * Validates and extracts the dosage type from the template IDs.
     *
     * @return the dosage type found.
     */
    private DosageType getDosageTypeFromTemplateIds() throws InvalidEmedContentException {
        final List<String> templateIds = this.subAdm.getTemplateId().stream()
                .map(II::getRoot)
                .filter(id -> TemplateIds.DOSAGE_TYPE_NORMAL.equals(id)
                        || TemplateIds.DOSAGE_TYPE_TAPERED.equals(id)
                        || TemplateIds.DOSAGE_TYPE_SPLIT.equals(id))
                .toList();
        if (templateIds.size() != 1) {
            throw new InvalidEmedContentException("No or multiple dosage type template IDs found");
        }
        if (templateIds.contains(TemplateIds.DOSAGE_TYPE_NORMAL)) {
            return DosageType.NORMAL;
        } else if (templateIds.contains(TemplateIds.DOSAGE_TYPE_SPLIT)) {
            return DosageType.SPLIT;
        } else {
            throw new InvalidEmedContentException("The dosage type isn't supported yet");
        }
    }

    /**
     * Returns the intake derived from a related component (which is a subordinate intake). If the dose or the
     * frequency is not specified, the default value applies.
     *
     * @param subAdm The dosage instructions.
     * @param defaultTimingEvent The default timing event.
     * @param defaultDoseQuantity The default dose quantity.
     * @return an intake.
     * @throws InvalidEmedContentException if the dose or the timing is missing.
     */
    private MedicationDosageIntake getSubordinateIntake(@NonNull final POCDMT000040SubstanceAdministration subAdm,
                                                        @Nullable final TimingEventAmbu defaultTimingEvent,
                                                        @Nullable final QuantityWithRegularUnit defaultDoseQuantity) {
        final var timingEvent = this.getSingleTimingEvent(subAdm).orElse(defaultTimingEvent);
        final var doseQuantity = this.getDoseQuantity(subAdm).orElse(defaultDoseQuantity);
        if (timingEvent == null) {
            throw new InvalidEmedContentException("In a related component, the frequency is missing and no default " +
                    "value is available");
        }
        if (doseQuantity == null) {
            throw new InvalidEmedContentException("In a related component, the doseQuantity is missing and no default" +
                    " value is available");
        }
        return new MedicationDosageIntake(timingEvent, doseQuantity);
    }

    /**
     * Returns the dose quantity.
     *
     * @param subAdm The dosage instructions.
     * @return an {@link Optional} that may contain the dose quantity.
     */
    private Optional<QuantityWithRegularUnit> getDoseQuantity(@NonNull final POCDMT000040SubstanceAdministration subAdm) {
        return Optional.ofNullable(subAdm.getDoseQuantity())
                .map(QuantityWithRegularUnit::fromPq);
    }

    /**
     * Returns the dosage instructions - event: a single event within a day.
     *
     * @param subAdm The dosage instructions.
     * @return a timing event.
     */
    private Optional<TimingEventAmbu> getSingleTimingEvent(@NonNull final POCDMT000040SubstanceAdministration subAdm) {
        // <effectiveTime operator='A' xsi:type='EIVL_TS' />
        return subAdm.getEffectiveTime().stream()
                .filter(EIVLTS.class::isInstance)
                .findAny()
                .map(effectiveTime -> ((EIVLTS) effectiveTime).getEvent())
                .map(CD::getCode)
                .map(TimingEventAmbu::getEnum);
    }

    /**
     * Returns the dosage instructions - frequency: multiple events within a day with the same dosage.
     *
     * @param subAdm The dosage instructions.
     * @return a list of timing events.
     */
    private List<@NonNull TimingEventAmbu> getMultipleTimingEvents(@NonNull final POCDMT000040SubstanceAdministration subAdm) {
        // <effectiveTime operator='A' xsi:type='SXPR_TS' />
        return subAdm.getEffectiveTime().stream()
                .filter(SXPRTS.class::isInstance)
                .findAny()
                .map(effectiveTime -> ((SXPRTS) effectiveTime).getComp())
                .orElse(Collections.emptyList())
                .stream()
                .map(effectiveTime -> ((EIVLTS) effectiveTime).getEvent())
                .filter(Objects::nonNull)
                .map(CD::getCode)
                .map(TimingEventAmbu::getEnum)
                .filter(Objects::nonNull)
                .toList();
    }

    /**
     * Returns the related components and checks the sequence numbers.
     *
     * @param subAdm The dosage instructions.
     * @return a list of related components.
     * @throws InvalidEmedContentException if the sequence number are incorrect.
     */
    private List<@NonNull POCDMT000040SubstanceAdministration> getRelatedComponents(@NonNull final POCDMT000040SubstanceAdministration subAdm) throws InvalidEmedContentException {
        final var entryRelationships = subAdm.getEntryRelationship().stream()
                .filter(er -> er.getTypeCode() == XActRelationshipEntryRelationship.COMP)
                .filter(er -> er.getSequenceNumber() != null)
                .filter(er -> er.getSubstanceAdministration() != null).toList();
        for (int i = 1; i <= entryRelationships.size(); ++i) {
            final var sequenceNumber = entryRelationships.get(i-1).getSequenceNumber();
            if (sequenceNumber == null || sequenceNumber.getValue() == null || sequenceNumber.getValue().intValue() != i) {
                throw new InvalidEmedContentException("The related components don't have an ordered, monotonic " +
                        "sequence starting at 1");
            }
        }
        return entryRelationships.stream()
                .map(POCDMT000040EntryRelationship::getSubstanceAdministration)
                .filter(Objects::nonNull)
                .toList();
    }
}
