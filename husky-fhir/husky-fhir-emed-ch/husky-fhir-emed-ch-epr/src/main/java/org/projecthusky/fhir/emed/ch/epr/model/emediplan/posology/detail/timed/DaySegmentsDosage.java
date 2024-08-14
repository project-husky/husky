package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.timed;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.application.ApplicationInSegment;

import java.util.List;

/**
 * Specifies the day segment (morning, noon, evening, night) when a medication should be applied. This is called
 * DaySegments by ChMed23A.
 */
public class DaySegmentsDosage extends EmbeddableTimedDosage {
    /**
     * Specifies the dosage to be applied per day segment.
     */
    @JsonProperty("ss")
    protected List<@NonNull ApplicationInSegment> applications;
}
