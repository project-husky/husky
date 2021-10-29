package org.husky.emed.cda.utils;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.husky.emed.cda.errors.InvalidEmedContentException;
import org.husky.emed.cda.generated.hl7cdar2.POCDMT000040Act;
import org.husky.emed.cda.generated.hl7cdar2.POCDMT000040EntryRelationship;
import org.husky.emed.cda.generated.hl7cdar2.POCDMT000040Observation;
import org.husky.emed.cda.generated.hl7cdar2.POCDMT000040SubstanceAdministration;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Utilities for dealing with CDA-CH-EMED EntryRelationships.
 *
 * @author Quentin Ligier
 */
public class EntryRelationshipUtils {

    /**
     * This class is not instantiable.
     */
    private EntryRelationshipUtils() {}

    /**
     * Returns the patient medication instructions act.
     *
     * @param entryRelationships The list of entry relationships that may contain the patient medication instructions
     *                          act.
     * @return an {@link Optional} that may contain the patient medication instructions act.
     */
    public static Optional<POCDMT000040Act> getPatientMedicationInstructions(final List<POCDMT000040EntryRelationship> entryRelationships) throws InvalidEmedContentException {
        final List<POCDMT000040Act> acts = getActsFromEntryRelationshipsByTemplateId(entryRelationships,
                TemplateIds.PATIENT_MEDICATION_INSTRUCTIONS);
        if (acts.size() > 1) {
            throw new InvalidEmedContentException("There may be only one patient medication instruction");
        }
        return Optional.ofNullable(!acts.isEmpty() ? acts.get(0) : null);
    }

    /**
     * Returns the fulfillment instructions act.
     *
     * @param entryRelationships The list of entry relationships that may contain the fulfillment instructions act.
     * @return an {@link Optional} that may contain the fulfillment instructions act.
     */
    public static Optional<POCDMT000040Act> getFulfillmentInstructions(final List<POCDMT000040EntryRelationship> entryRelationships) throws InvalidEmedContentException {
        final List<POCDMT000040Act> acts = getActsFromEntryRelationshipsByTemplateId(entryRelationships,
                TemplateIds.FULFILLMENT_INSTRUCTIONS);
        if (acts.size() > 1) {
            throw new InvalidEmedContentException("There may be only one fulfillment instruction");
        }
        return Optional.ofNullable(!acts.isEmpty() ? acts.get(0) : null);
    }


    /**
     * Finds a list of Acts in EntryRelationships that contain a specified template ID.
     *
     * @param entryRelationships The list of EntryRelationships.
     * @param templateId         The template ID to search.
     * @return the list of corresponding Acts.
     */
    public static List<POCDMT000040Act> getActsFromEntryRelationshipsByTemplateId(
            @Nullable final List<POCDMT000040EntryRelationship> entryRelationships,
            final String templateId
    ) {
        Objects.requireNonNull(templateId);
        if (entryRelationships == null || entryRelationships.isEmpty()) {
            return Collections.emptyList();
        }
        return entryRelationships.stream()
                .map(POCDMT000040EntryRelationship::getAct)
                .filter(Objects::nonNull)
                .filter(act -> TemplateIds.isInList(templateId, act.getTemplateId()))
                .toList();
    }

    /**
     * Finds a list of Observations in EntryRelationships that contain a specified template ID.
     *
     * @param entryRelationships The list of EntryRelationships.
     * @param templateId         The template ID to search.
     * @return the list of corresponding Observations.
     */
    public static List<POCDMT000040Observation> getObservationsFromEntryRelationshipsByTemplateId(
            @Nullable final List<POCDMT000040EntryRelationship> entryRelationships,
            final String templateId
    ) {
        Objects.requireNonNull(templateId);
        if (entryRelationships == null || entryRelationships.isEmpty()) {
            return Collections.emptyList();
        }
        return entryRelationships.stream()
                .map(POCDMT000040EntryRelationship::getObservation)
                .filter(Objects::nonNull)
                .filter(observation -> TemplateIds.isInList(templateId, observation.getTemplateId()))
                .toList();
    }

    /**
     * Finds a list of SubstanceAdministrations in EntryRelationships that contain a specified template ID.
     *
     * @param entryRelationships The list of EntryRelationships.
     * @param templateId         The template ID to search.
     * @return the list of corresponding SubstanceAdministrations.
     */
    public static List<POCDMT000040SubstanceAdministration> getSubstanceAdministrationsFromEntryRelationshipsByTemplateId(
            @Nullable final List<POCDMT000040EntryRelationship> entryRelationships,
            final String templateId
    ) {
        Objects.requireNonNull(templateId);
        if (entryRelationships == null || entryRelationships.isEmpty()) {
            return Collections.emptyList();
        }
        return entryRelationships.stream()
                .map(POCDMT000040EntryRelationship::getSubstanceAdministration)
                .filter(Objects::nonNull)
                .filter(observation -> TemplateIds.isInList(templateId, observation.getTemplateId()))
                .toList();
    }
}
