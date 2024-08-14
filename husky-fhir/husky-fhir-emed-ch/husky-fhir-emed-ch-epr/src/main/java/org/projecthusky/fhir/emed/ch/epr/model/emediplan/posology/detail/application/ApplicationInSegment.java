package org.projecthusky.fhir.emed.ch.epr.model.emediplan.posology.detail.application;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.projecthusky.fhir.emed.ch.epr.model.emediplan.enums.DaySegment;

/**
 * Specifies a day segment (morning, noon, evening or night) when a medication must be applied.
 */
public class ApplicationInSegment extends Application {
    @JsonProperty("s")
    protected DaySegment segment;
}
