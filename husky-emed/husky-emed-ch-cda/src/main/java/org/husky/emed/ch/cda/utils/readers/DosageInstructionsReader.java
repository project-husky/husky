/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.ch.cda.utils.readers;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.husky.common.hl7cdar2.*;
import org.husky.emed.ch.cda.utils.EntryRelationshipUtils;
import org.husky.emed.ch.cda.utils.IvlTsUtils;
import org.husky.emed.ch.cda.utils.TemplateIds;
import org.husky.emed.ch.enums.DosageType;
import org.husky.emed.ch.enums.RouteOfAdministrationAmbu;
import org.husky.emed.ch.enums.TimingEventAmbu;
import org.husky.emed.ch.errors.InvalidEmedContentException;
import org.husky.emed.ch.models.common.MedicationDosageInstructions;
import org.husky.emed.ch.models.common.MedicationDosageIntake;
import org.husky.emed.ch.models.common.QuantityWithRegularUnit;

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
     * Returns the dosage instructions - frequency: a single or multiple events within a day with the same dosage.
     */
    public List<@NonNull TimingEventAmbu> getEventTimings() {
        return this.getEventTimings(this.subAdm);
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

        if (this.getDosageType() == DosageType.NORMAL) {
            instructions.getIntakes().addAll(this.getIntakes(this.subAdm));
        } else if (this.getDosageType() == DosageType.SPLIT) {
            this.subAdm.getEntryRelationship().stream()
                    .filter(er -> er.getTypeCode() == XActRelationshipEntryRelationship.COMP)
                    .filter(er -> er.getSequenceNumber() != null)
                    .map(POCDMT000040EntryRelationship::getSubstanceAdministration)
                    .filter(Objects::nonNull)
                    .flatMap(relatedSubAdm -> this.getIntakes(relatedSubAdm).stream())
                    .forEach(intakes -> instructions.getIntakes().add(intakes));
        } else {
            throw new InvalidEmedContentException("The dosage type " + this.getDosageType() + " isn't supported yet");
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
     * Returns the list of intakes for a given dosage instructions. It will only work on the main dosage instruction in
     * normal dosage type, or on the related components in split dosage type.
     *
     * @param subAdm The dosage instructions.
     * @return a list of intakes.
     */
    private List<@NonNull MedicationDosageIntake> getIntakes(@NonNull final POCDMT000040SubstanceAdministration subAdm) {
        final List<MedicationDosageIntake> intakes = new ArrayList<>();
        final var eventTimings = this.getEventTimings(subAdm);
        final var doseQuantity = this.getDoseQuantity(subAdm).orElse(null);
        if (!eventTimings.isEmpty() && doseQuantity == null) {
            throw new InvalidEmedContentException("The doseQuantity is missing within normal dosage");
        }
        for (final var eventTiming : eventTimings) {
            intakes.add(new MedicationDosageIntake(eventTiming, doseQuantity));
        }
        return intakes;
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
     * Returns the dosage instructions - frequency: a single or multiple events within a day with the same dosage.
     *
     * @param subAdm The dosage instructions.
     * @return a list of event timings.
     */
    private List<@NonNull TimingEventAmbu> getEventTimings(@NonNull final POCDMT000040SubstanceAdministration subAdm) {
        final List<TimingEventAmbu> eventTimings = new ArrayList<>();

        // <effectiveTime operator='A' xsi:type='EIVL_TS' />
        subAdm.getEffectiveTime().stream()
                .filter(EIVLTS.class::isInstance)
                .findAny()
                .map(effectiveTime -> ((EIVLTS) effectiveTime).getEvent())
                .map(CD::getCode)
                .map(TimingEventAmbu::getEnum)
                .ifPresent(eventTimings::add);

        // <effectiveTime operator='A' xsi:type='SXPR_TS' />
        subAdm.getEffectiveTime().stream()
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
                .forEach(eventTimings::add);
        return eventTimings;
    }
}
